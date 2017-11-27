package November20;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MessageSender implements Runnable {

    private Queue<Message> clientMessages;
    final private List<Client> clients;


    MessageSender(ConcurrentLinkedQueue<Message> messagesQueue, List<Client> client) {

        this.clientMessages = messagesQueue;
        this.clients = client;

    }

    @Override
    public void run() {
        while (true) {
            Message message = clientMessages.poll();
            if (message == null) continue;
            sendMessage(message);
        }
    }

    private void sendMessage(Message message) {
        if (message.to == null) {
            sendToAll(message);
        } else {
            sendToOne(message, message.to);
        }
    }

    private void sendToOne(Message message, Client client) {
        synchronized (clients) {
            if (clients.contains(client)) {
                client.writer.println(message.text);
            }
        }
    }

    private void sendToAll(Message message) {
        synchronized (clients) {
            for (Client client : clients) {
                client.writer.println(message);
            }
        }
    }
}
