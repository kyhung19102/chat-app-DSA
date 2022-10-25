package repository.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import repository.MessageRepository;
import helper.Queue;
import helper.impl.QueueLinkedListImpl;
import model.Message;

public class MessageQueueBasedRepository implements MessageRepository {
    private Queue<Message> queue;

    public MessageQueueBasedRepository() {
        this.queue = new QueueLinkedListImpl<>();
    }

    @Override
    public void save(Message msg) {
        queue.enqueue(msg);
    }

    @Override
    public Set<Message> getAllMessages() {
        // LinkedHashSet for ordered message
        Set<Message> set = new LinkedHashSet<>();
        while (!queue.isEmpty()) {
            Message message = queue.dequeue();
            set.add(message);
        }
        return set;
    }

    @Override
    public Message getLatestMessage() {
        return queue.isEmpty() ? null : queue.dequeue();

    }
}
