package November12.NumbersTransaction;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTcp {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("185.32.176.36", 10000);
        OutputStream out = client.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
        for (int i = 0; i < 1000; i++) {
            writer.write((String.valueOf(i)));
            writer.newLine();
        }
        writer.flush();
        client.close();
    }
}
