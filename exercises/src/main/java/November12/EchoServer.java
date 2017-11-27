package November12;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.nio.charset.Charset;

public class EchoServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket server = new ServerSocket(8189,1);
        System.out.println("Server is running....");
        while (true) {
            Socket client = server.accept();//болкируется программа для ожидания подключения клиентов, когда клиент придет отсюда вернёться Socket;
            System.out.println("Client accepted....");
            InputStream in = client.getInputStream();//входной поток от клиента;
            InputStreamReader reader = new InputStreamReader(in, Charset.forName("UTF-8"));
            BufferedReader buffer = new BufferedReader(reader);
            OutputStream out = client.getOutputStream();
            String data = buffer.readLine()+" от сервера";
            System.out.println(client+": " +data);
            if (data.equals("~")) {
                break;
            }
            out.write(data.getBytes(Charset.defaultCharset()));
            out.flush();
            client.close();
            System.out.println("Client disconnected");
        }


//      while(buffer.read()!=-1){
//            out.write(buffer.readLine().getBytes());
//        }

    }
}
