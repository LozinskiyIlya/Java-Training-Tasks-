package November22;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10000);
        Socket client = server.accept();
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"));
        String initialLine = reader.readLine();
        String headers = "";
        String header = reader.readLine();
        while (header !=null && !header.equals("")) {
            headers += header + "\n";
            header = reader.readLine();
        }

        System.out.println(initialLine);
        System.out.println("********");
        System.out.println(headers);

        if (initialLine.contains("/hello")) {
            writer.write("HTTP/1.0 200 OK");
            writer.newLine();
            writer.newLine();
            writer.write("Hello!");
            writer.flush();
        }
    }
}
