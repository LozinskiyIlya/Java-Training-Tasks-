package November12.FileTransaction;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8189);
        Socket client = server.accept();
        InputStream clientIn = client.getInputStream();
        long fileSize = getFileSize(clientIn);
        getFile(clientIn, fileSize,"C:\\Users\\РС\\Desktop\\Received.jpg");
    }

    private static void getFile(InputStream clientIn, long fileSize, String way) throws IOException {
        try(BufferedOutputStream serverOut = new BufferedOutputStream(new FileOutputStream(way))) {
            for (long i = 0; i < fileSize; i++) {
                serverOut.write(clientIn.read());
            }
            serverOut.flush();
        }
    }

    private static long getFileSize(InputStream clientIn) throws IOException {
        long fileSize = 0;
        fileSize = fileSize | (clientIn.read() & 0b1111_1111);
        fileSize = (fileSize << 8) | (clientIn.read() & 0b1111_1111);
        fileSize = (fileSize << 8) | (clientIn.read() & 0b1111_1111);
        fileSize = (fileSize << 8) | (clientIn.read() & 0b1111_1111);
        return fileSize;
    }
}
