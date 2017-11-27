package November21;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO_Sample{
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\РС\\Desktop\\Git.txt");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1000000);
        System.out.println("default ".toUpperCase() + byteBuffer);

        channel.read(byteBuffer);
        System.out.println("read ".toUpperCase() + byteBuffer);

        channel.write(byteBuffer);

        byteBuffer.flip();
        System.out.println("flipped ".toUpperCase() + byteBuffer);

        while(byteBuffer.hasRemaining()){
//            System.out.println((char) byteBuffer.get());
        byteBuffer.get();
        }
        System.out.println("after get ".toUpperCase() +byteBuffer);

        byteBuffer.clear();
        System.out.println("after clear or compact ".toUpperCase() + byteBuffer);


    }
}
