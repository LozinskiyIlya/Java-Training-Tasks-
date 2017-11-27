package November20;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ClientUpdater implements Runnable {
    private Socket clientSocket;
    private ConcurrentLinkedQueue<Message> messagesQueue;
    private List<Client> clients;
    private final ClientCreator creator;
    private IncomingMessageProcessorCreatorV2 processorCreator;

    ClientUpdater(Socket clientSocket, ConcurrentLinkedQueue<Message> messagesQueue,
                  List<Client> clients, ClientCreator creator, IncomingMessageProcessorCreatorV2 processorCreator) {

        this.clientSocket = clientSocket;
        this.messagesQueue = messagesQueue;
        this.clients = clients;
        this.creator = creator;
        this.processorCreator = processorCreator;
    }

    @Override
    public void run() {
        try {
            processClient();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (!clientSocket.isClosed()) {
                    clientSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void processClient() throws IOException {
        Client client = creator.create(clientSocket);
        clients.add(client);
        messagesQueue.add(new Message("Welcome" + clientSocket.getInetAddress() + "!!!", client));
        IncomingMessageProcessor processor = processorCreator.create(client, clients, messagesQueue);
        processor.process();
    }
}

