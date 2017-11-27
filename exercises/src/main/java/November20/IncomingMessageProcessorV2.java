package November20;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

public class IncomingMessageProcessorV2 extends IncomingMessageProcessor {
    private Client client;
    private List<Client> clients;
    private Queue<Message> messagesQueue;
    IncomingMessageProcessorV2(Client client, List<Client> clients, Queue<Message> messageQueue) {
        super(client, clients, messageQueue);
        this.client = client;
        this.clients = clients;
        this.messagesQueue = messageQueue;

    }

    void process() throws IOException {
        while (true) {
            String clientMessage = client.reader.readLine();
            if (clientMessage == null || clientMessage.toUpperCase().equals("!EXIT")) {
                clients.remove(client);
                messagesQueue.add(new Message(client.socket.getInetAddress() + " ! Disconnected"));
                System.out.println(client.socket.getInetAddress() + " : " + "Client disconnected");
                return;
            }
            messagesQueue.add(new Message(client.socket.getInetAddress() + " > " + clientMessage));
        }
    }
}
