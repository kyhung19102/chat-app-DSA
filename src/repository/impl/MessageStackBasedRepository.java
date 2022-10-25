package repository.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import repository.MessageRepository;
import helper.Stack;
import helper.impl.StackLinkedListImpl;
import model.Message;

public class MessageStackBasedRepository implements MessageRepository {
    private Stack<Message> stack;

    public MessageStackBasedRepository() {
        this.stack = new StackLinkedListImpl<>();
    }

    @Override
    public void save(Message msg) {
        stack.push(msg);
    }

    @Override
    public Set<Message> getAllMessages() {
        Set<Message> set = new LinkedHashSet<>();
        Message[] tempMessages = new Message[stack.size()];

        // Get all messgaes from the message stack storage
        int index = 0;
        while (!stack.isEmpty()) {
            Message message = stack.pop();
            tempMessages[index++] = message;
        }

        // Reverse the message for ordering message
        for (int i = index - 1; i >= 0; --i)
            set.add(tempMessages[i]);

        return set;
    }

    @Override
    public Message getLatestMessage() {
        return stack.isEmpty() ? null : stack.pop();
    }
}
