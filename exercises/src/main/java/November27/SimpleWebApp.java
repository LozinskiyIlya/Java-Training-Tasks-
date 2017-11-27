package November27;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;


public class SimpleWebApp {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String request = reader.readLine();
            String initialLine = request;

            // reading headers;
            Map<String, String> headers = new HashMap<>();
            request = reader.readLine();
            while (request != null && !request.isEmpty()) {
                System.out.println(request);
                int index = request.indexOf(": ");
                String headerName = request.substring(0, index);
                String headerValue = request.substring(request.indexOf(": ") + 2, request.length());
                headers.put(headerName, headerValue);
                request = reader.readLine();
            }

            //reading body
            String bodyString = "";
            if (headers.containsKey("Content-Length")) {
                int bodySize = Integer.parseInt(headers.get("Content-Length"));
                byte[] bodyBytes = new byte[bodySize];
                for (int i = 0; i < bodySize; i++) {
                    bodyBytes[i] = (byte) reader.read();
                }
                bodyString = new String(bodyBytes);
                System.out.println(bodyString);
            }

            String content = getContentForParameter(initialLine, bodyString);
            sendContent(clientSocket, content);
        }
    }

    private static String getContentForParameter(String initialLine, String bodyString) {
        String content;
        if (initialLine.contains("/form")) {
            content = "<form  method=\"POST\" action=\"/greeting\"><input type=\"text\" name=\"username\" title=\"Type your name\" ><br/></input>" +
                    "<input type=\"submit\"  value='Send'></input>" +
                    "</form>";
        } else {
            int startIndex = bodyString.indexOf("=");
            String name = bodyString.substring(startIndex + 1, bodyString.length());
            Map<String, String> values = new HashMap<>();
            values.put("name", name);
            String template = "Hello, @name!";
            content = "<h1>" + template.replaceAll("@name", values.get("name")) + "</h1>" + "<br/>" +
                    "<button onclick=\"window.history.go(-1)\">Back</button>";

        }
        return content;
    }

    private static void sendContent(Socket clientSocket, String content) throws IOException {
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
}

