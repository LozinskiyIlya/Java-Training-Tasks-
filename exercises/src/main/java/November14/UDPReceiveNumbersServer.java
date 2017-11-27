package November14;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.Charset;

public class UDPReceiveNumbersServer {
    private static final int PORT = 8189;
    private static final Charset CODING = Charset.forName("UTF-8");

    public static void main(String[] args) throws Exception {
        try (DatagramSocket server = new DatagramSocket(PORT)) {
            System.out.println("Server running...");
            int count = 0;
            while (count < 1000000) {
                String number = getString(server);
                if (!Integer.valueOf(number).equals(count)) {
                    throw new Exception("!!!!Bad number " + number);
                }
                count += 1;
            }
            System.out.println("Everything was fine");
        }
    }


    private static String getString(DatagramSocket server) throws IOException {
        int BUFFER_SIZE = getSize(server);

        byte[] buffer = new byte[BUFFER_SIZE];

        DatagramPacket packet = new DatagramPacket(buffer, BUFFER_SIZE);

        return getData(server, packet);
    }

    private static String getData(DatagramSocket server, DatagramPacket packet) throws IOException {
        server.receive(packet);

        return new String(packet.getData(), CODING);
    }

    private static int getSize(DatagramSocket server) throws IOException {
        byte[] sizeBuffer = new byte[4];

        DatagramPacket sizePacket = new DatagramPacket(sizeBuffer, sizeBuffer.length);
        server.receive(sizePacket);

        return byteArrayToInt(sizeBuffer);
    }

    private static int byteArrayToInt(byte[] sizeBuffer) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(sizeBuffer);
        DataInputStream intIn = new DataInputStream(in);
        int result = intIn.readInt();
        in.close();
        intIn.close();
        return result;
    }
}
