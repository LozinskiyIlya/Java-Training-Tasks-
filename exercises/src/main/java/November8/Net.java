package November8;


import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Net {
    public static void main(String[] args) throws IOException {
//        Socket client = new Socket("localhost:3306", 1234);
        ServerSocket server = new ServerSocket(1234);
       Socket client=server.accept();
        Scanner sc = new Scanner(System.in);
        OutputStream out = client.getOutputStream();
        out.write(sc.nextLine().getBytes());
        out.flush();
        System.out.println("request sent");
    }
}
