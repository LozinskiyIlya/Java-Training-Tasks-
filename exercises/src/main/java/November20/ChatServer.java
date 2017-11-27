package November20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;


class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8189);
        ConcurrentLinkedQueue<Message> messagesQueue = new ConcurrentLinkedQueue<>();
        List<Client> clients = Collections.synchronizedList(new ArrayList<>());

        Thread senderThread = new Thread(new MessageSender(messagesQueue, clients));
        senderThread.start();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress() + " : " + "Client connected");

            Thread clientThread = new Thread(new ClientUpdater(clientSocket, messagesQueue, clients,
                    new ClientCreator(), new IncomingMessageProcessorCreatorV2()));
            clientThread.start();
        }
    }
}


