package November12;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;

public class HelloClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8189);
        OutputStream out = client.getOutputStream();// выходной поток от клиента к серверу;
        out.write("Hello!\n".getBytes( Charset.forName("UTF8")));
        out.flush();

        InputStream in = client.getInputStream();//входной поток от сервера к клиенту;
        InputStreamReader reader = new InputStreamReader(in, Charset.forName("UTF-8"));
        BufferedReader buffer = new BufferedReader(reader);

        System.out.println(buffer.readLine());

        client.close();
    }
}
