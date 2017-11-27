package November20;

import java.io.IOException;
import java.util.List;
import java.util.Queue;

public class IncomingMessageProcessor {
    private Client client;
    private List<Client> clients;
    private Queue<Message> messagesQueue;

    IncomingMessageProcessor(Client client, List<Client> clients, Queue<Message> messageQueue) {
        this.client = client;
        this.clients = clients;
        this.messagesQueue = messageQueue;
    }

    void process() throws IOException {
        while (true) {
            String clientMessage = client.reader.readLine();
            messagesQueue.add(new Message(client.socket.getInetAddress() + " > " + clientMessage));
        }
    }
}
