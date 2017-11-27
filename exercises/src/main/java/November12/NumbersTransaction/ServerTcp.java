package November12.NumbersTransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerTcp {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        Socket client = server.accept();
        InputStream clientIn = client.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(clientIn));
        int counter = 0;
        while (counter < 1000) {
            String data = reader.readLine();
            if (Integer.parseInt(data) != counter) {
                throw new Exception("Some error: " + data + "!=" + counter);
            }
            System.out.println(data);
            counter += 1;

        }
    }
}
