package November12.NumbersTransaction;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

 class ClientUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket client = new DatagramSocket();
        String numbers = "";
        for (int i = 0; i <1000 ; i++) {
            numbers+=i+"/";
        }
        byte[] sendData = numbers.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket toSend =  new DatagramPacket(sendData,sendData.length,ip,8189);
        client.send(toSend);
        client.close();
    }
}
