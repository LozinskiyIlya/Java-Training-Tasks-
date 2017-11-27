package November12.NumbersTransaction;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

class ServerUDP {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(8189);
        byte[] receivedData = new byte[3890];
        DatagramPacket receiveData = new DatagramPacket(receivedData, receivedData.length);
        server.receive(receiveData);
        String buff = "";
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < receivedData.length; i++) {
            if (receivedData[i] == 47) {
                numbers.add(Integer.parseInt(buff));
                buff = "";
                continue;
            }
            char ch = (char) receivedData[i];
            buff += ch;
        }
        for (int i = 0; i <numbers.size()-1; i++) {
            if(numbers.get(i)>=numbers.get(i+1)){
                throw new RuntimeException("UPD....!");
            }
        }
        System.out.println(numbers);
        server.close();
    }
}
