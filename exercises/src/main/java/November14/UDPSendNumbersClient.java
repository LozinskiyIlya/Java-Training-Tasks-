package November14;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPSendNumbersClient {
    private static final int PORT = 8189;
    private static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        final InetAddress address = InetAddress.getByName(HOST);

        try (DatagramSocket client = new DatagramSocket()) {
            for (int i = 0; i < 1000000; i++) {
                sendString(String.valueOf(i),address,client);
            }

        }
    }

    private static void sendString(String string, InetAddress address, DatagramSocket client) throws IOException {
        byte[] buffer = string.getBytes();
        byte[] sizeBytes = intToByteArray(buffer.length);
        sendDataSize(address, client, sizeBytes);
        sendData(address, client, buffer);
    }

    private static void sendData(InetAddress address, DatagramSocket client, byte[] buffer) throws IOException {
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, PORT);
        client.send(packet);
    }

    private static void sendDataSize(InetAddress address, DatagramSocket client, byte[] sizeBytes) throws IOException {
        sendData(address, client, sizeBytes);
    }

    private static byte[] intToByteArray(int size) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DataOutputStream dataOut = new DataOutputStream(out);

        dataOut.writeInt(size);
        dataOut.flush();

        byte[] result = out.toByteArray();
        dataOut.close();
        out.close();

        return result;
    }
}
