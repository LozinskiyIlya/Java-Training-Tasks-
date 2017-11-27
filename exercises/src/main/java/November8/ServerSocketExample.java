package November8;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("created server");

        Socket clientSocket = serverSocket.accept();
        System.out.println("accepted");
        OutputStream clientOutput =  clientSocket.getOutputStream();
        InputStream clientInput =  clientSocket.getInputStream();
        clientOutput.write("hello world!".getBytes());
        clientOutput.flush();
       Thread.sleep(2000);

    }
}
