package November21;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;

public class ClientV1 {
    SocketChannel channel;
    ByteBuffer buffer;
    //    ArrayList<Byte> tempStorage;
    ArrayList<Byte> partialMessage;

  public   ClientV1(SocketChannel channel, ByteBuffer buffer) {
        this.channel = channel;
        this.buffer = buffer;
//        this.tempStorage = new ArrayList<>();
        this.partialMessage = new ArrayList<>();
    }
}
