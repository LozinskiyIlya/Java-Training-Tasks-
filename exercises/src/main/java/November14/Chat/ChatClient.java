package November14.Chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите адрес сервера");
        String address = consoleInput.readLine();
        System.out.println("Введите порт сервера");
        int port = Integer.valueOf(consoleInput.readLine());

        try (Socket client = new Socket(address, port)) {
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
            PrintWriter clientOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8")), true);

            while (true) {
                String loginReq = serverInput.readLine();
                System.out.println(loginReq);
                clientOut.println(consoleInput.readLine());
                String loginAnswer = serverInput.readLine();
                if (loginAnswer.equals("Y")) {
                    break;
                }
                System.out.println(loginAnswer);
            }
            while (true) {
                String passReq = serverInput.readLine();
                System.out.println(passReq);
                clientOut.println(consoleInput.readLine());
                String passAnswer = serverInput.readLine();
                if (passAnswer.equals("Y")) {
                    break;
                }
                System.out.println(passAnswer);
            }

            while (true) {
                String messageToServer = consoleInput.readLine();
                clientOut.println(messageToServer);
                String messageFormServer = serverInput.readLine();
                System.out.println(messageFormServer);

            }
        }
    }
}
