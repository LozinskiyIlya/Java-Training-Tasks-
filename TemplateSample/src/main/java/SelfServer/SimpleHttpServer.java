package SelfServer;

import SelfServer.Request;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mikle on 11/13/17.
 */
public class SimpleHttpServer {
    public static void main(String[] args) throws IOException, TemplateException {
        ServerSocket serverSocket = new ServerSocket(10000);
        Configuration cfg = getTemplateConfiguration();

        while (true) {
            processRequest(serverSocket, cfg);
        }
    }

    private static Request getRequest(BufferedReader reader) throws IOException {
        String initialLine = getInitialString(reader);
        Map<String, String> headers = getHeaders(reader, initialLine);
        String bodyString = getBodyString(reader, headers);

        return new Request(initialLine, headers, bodyString);
    }

    private static String getInitialString(BufferedReader reader) throws IOException {
        String request = reader.readLine();
        return request;
    }

    private static Map<String, String> getHeaders(BufferedReader reader, String initialLine) throws IOException {
        String request;
        Map<String, String> headers = new HashMap<>();

        System.out.println(initialLine);
        request = reader.readLine();
        while (request != null && !request.isEmpty()) {
            System.out.println(request);
            int splitterPosition = request.indexOf(": ");
            String headerName = request.substring(0, splitterPosition);
            String headerValue = request.substring(splitterPosition + 2, request.length());
            headers.put(headerName, headerValue);
            request = reader.readLine();
        }
        return headers;
    }

    private static String getBodyString(BufferedReader reader, Map<String, String> headers) throws IOException {
        String bodyString = null;
        if (headers.containsKey("Content-Length")) {
            int bodySize = Integer.valueOf(headers.get("Content-Length"));
            byte[] body = new byte[bodySize];
            for (int i = 0; i < bodySize; i++) {
                body[i] = (byte) reader.read();
            }
            bodyString = new String(body);
            System.out.println(bodyString);
        }
        return bodyString;
    }

    private static void processRequest(ServerSocket serverSocket, Configuration cfg) throws IOException, TemplateException {
        Socket clientSocket = serverSocket.accept();

        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        Request request = getRequest(reader);
        String content = getContent(cfg, request);
        writeResponse(clientSocket, content);
    }

    private static void writeResponse(Socket clientSocket, String content) throws IOException {
        OutputStream outputStream = clientSocket.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("HTTP/1.0 200 OK");
        writer.newLine();
        writer.write("Content-Length: " + content.getBytes().length);
        writer.newLine();
        writer.write("Content-Type: text/html; charset=utf-8");
        writer.newLine();
        writer.newLine();
        writer.write(content);
        writer.flush();
        writer.close();
    }

    private static String getContent(Configuration cfg, Request request) throws IOException, TemplateException {
        String content;
        if (request.initialLine.contains("form")) {
            content = getFormView(cfg);
        } else {
            content = getGreetingView(request.initialLine, cfg);
        }
        return content;
    }

    private static Configuration getTemplateConfiguration() throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
        cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\РС\\Desktop"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        return cfg;
    }

    private static String getGreetingView(String initialLine, Configuration cfg) throws IOException, TemplateException {
        int startIndex = initialLine.indexOf('=') + 1;
        String name = initialLine.substring(startIndex, initialLine.indexOf(' ', startIndex));
        Map root = new HashMap();
        root.put("name", name);
        Template temp = cfg.getTemplate("GreetingForm.txt");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter output = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
        temp.process(root, output);
        byte[] resultBytes = byteArrayOutputStream.toByteArray();
        return new String(resultBytes, "UTF-8");
    }
    private static String getFormView(Configuration cfg) throws IOException, TemplateException {
        Map root = new HashMap();
        Template temp = cfg.getTemplate("StartForm.txt");
        StringWriter writer = new StringWriter();
        temp.process(root,writer);
        String content = writer.toString();
        return content;
    }
}
