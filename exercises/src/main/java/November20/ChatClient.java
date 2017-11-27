package November20;

import java.io.*;
import java.net.Socket;


class ChatClient {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите адрес сервера");
        String serverAddress = consoleInput.readLine();
        System.out.println("Введите порт сервера");
        int port = Integer.parseInt(consoleInput.readLine());

        try (Socket socket = new Socket(serverAddress, port)) {
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter serverWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8")), true);

//            String greeting = serverReader.readLine();
//            System.out.println(greeting);

            Thread senderThread = new Thread(() -> {
                try {
                    while (true) {
                        String msg = consoleInput.readLine();
                        serverWriter.println(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            senderThread.start();

            while (true) {
                String msgFromServer = serverReader.readLine();
                if (msgFromServer == null) {
                    System.exit(1);
                }
                System.out.println(msgFromServer);
            }
        }
    }
}
