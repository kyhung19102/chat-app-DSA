package repository;

import java.util.Set;

import model.Message;

public interface MessageRepository {
    void save(Message msg);

    Set<Message> getAllMessages();

    // at front or last top
    Message getLatestMessage();
}
