package November21;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class NioSockets {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(10000));
        serverSocketChannel.configureBlocking(false);
        List<ClientV1> clientV1List = new ArrayList<>();
        while (true) {
            trySetNewClients(serverSocketChannel, clientV1List);
            processClients(clientV1List);
        }
    }

    private static void processClients(List<ClientV1> clientV1List) throws IOException {
        List<ClientV1> toRemove = new ArrayList<>();
        for (ClientV1 cl : clientV1List) {
            cl.buffer.clear();
            if (cl.channel.read(cl.buffer) == 0) {
                continue;
            }
            if (cl.channel.read(cl.buffer) == -1) {
                toRemove.add(cl);
                continue;
            }
            cl.buffer.flip();
            int count = cl.buffer.remaining();
            byte[] read = new byte[count];
            cl.buffer.get(read);
            for (byte aRead : read) {
                char currentChar = (char) (byte) aRead;
                if (currentChar != '\n') {
                    cl.partialMessage.add(aRead);
                } else {
                    String message = getString(cl.partialMessage);
                    System.out.println(message);
                }
            }
        }
        clientV1List.removeAll(toRemove);

    }

    private static String getString(ArrayList<Byte> list) throws UnsupportedEncodingException {
        byte[] arr = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return new String(arr, "UTF-8");
    }

    private static void trySetNewClients(ServerSocketChannel serverSocketChannel,
                                         List<ClientV1> clientV1List) throws IOException {
        SocketChannel clientChannel = serverSocketChannel.accept();

        if (clientChannel != null) {
            clientChannel.configureBlocking(false);
            ClientV1 clientV1 = new ClientV1(clientChannel, ByteBuffer.allocate(100));
            clientV1List.add(clientV1);
        }
    }
}

