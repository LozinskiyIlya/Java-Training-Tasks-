package November12.FileTransaction;

import java.io.*;
import java.net.Socket;

class Client {
    private static final String WAY = "C:\\Users\\РС\\Desktop\\Без названия.jpg";

    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 8189);

        try (OutputStream clientOut = client.getOutputStream()) {
            File file = new File(WAY);
            long size = file.length();
            writeFileSize(clientOut, size);
            writeFile(clientOut, file, size);
            clientOut.flush();
        }

  /*      int indexOfPoint = WAY.lastIndexOf(".");
        String extension = WAY.substring(indexOfPoint, WAY.length());
        System.out.println(extension);
        byte[] arr = extension.getBytes();
        System.out.println(arr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
*/

    }

    private static void writeFile(OutputStream clientOut, File file, long size) throws IOException {
        try (BufferedInputStream clientIn = new BufferedInputStream(new FileInputStream(file))) {
            for (long i = 0; i < size; i++) {
                clientOut.write(clientIn.read());
            }
        }
    }

    private static void writeFileSize(OutputStream clientOut, long size) throws IOException {
        byte f = (byte) size;
        byte s = (byte) (size >>> 8);
        byte t = (byte) (size >>> 16);
        byte four = (byte) (size >>> 24);

        byte[] fourByte = {four, t, s, f};
        clientOut.write(fourByte);
    }
}
