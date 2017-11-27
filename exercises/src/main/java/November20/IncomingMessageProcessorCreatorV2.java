package November20;

import java.util.List;
import java.util.Queue;

public class IncomingMessageProcessorCreatorV2 extends IncomingMessageProcessorCreator {
    @Override
    public IncomingMessageProcessor create(Client client, List<Client> clients, Queue<Message> messagesQueue) {
        return new IncomingMessageProcessorV2(client, clients, messagesQueue);
    }
}
