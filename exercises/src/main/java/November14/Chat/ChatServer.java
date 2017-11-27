package November14.Chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class ChatServer {
    public static void main(String[] args) throws IOException {

        HashMap<String, String> logsAndPass = new HashMap<>();
        logsAndPass.put("Ilia", "qwerty");
        logsAndPass.put("Vlad", "asdfg");
        logsAndPass.put("Ira", "zxcvb");

        ServerSocket server = new ServerSocket(8189);
        Socket client = server.accept();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        PrintWriter clientWriter = new PrintWriter(writer, true);

        BufferedReader clientReader = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
        byte[] log;
        while (true) {
            clientWriter.println("Введите имя пользователя");
            String login = clientReader.readLine();
            if (logsAndPass.containsKey(login)) {
                clientWriter.println("Y");
                log = login.getBytes();
                break;
            }
            clientWriter.println("Неверное имя пользователя");
        }
        String login = new String(log);
        while (true) {
            clientWriter.println("Введите пароль");
            String pass = clientReader.readLine();
            if (logsAndPass.get(login).equals(pass)) {
                clientWriter.println("Y");
                break;
            }
            clientWriter.println("Неверный пароль");
        }

        clientWriter.println("Welcome " + login + " !!!");
        while (true) {
            String clientMsg = clientReader.readLine();
            clientWriter.println(login + ": " + clientMsg);
            System.out.println(clientMsg);
        }
    }
}

