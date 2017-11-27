package November20;

import java.util.List;
import java.util.Queue;

public class IncomingMessageProcessorCreator {
    public IncomingMessageProcessor create(Client client, List<Client> clients, Queue<Message> messagesQueue) {
        return new IncomingMessageProcessorV2(client, clients, messagesQueue);
    }
}
