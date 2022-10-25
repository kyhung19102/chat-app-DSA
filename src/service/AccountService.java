package service;

import java.util.Set;

import helper.Queue;
import model.Message;
import repository.MessageRepository;
import repository.impl.MessageQueueBasedRepository;
import repository.impl.MessageStackBasedRepository;

public class AccountService {
    MessageRepository msgQueueRepo = new MessageQueueBasedRepository();
	MessageRepository msgStackRepo = new MessageStackBasedRepository();
    
    public Set<Message> getAllMessages() {
		for(Message msg : msgStackRepo.getAllMessages()) // storage to transfer
           msgQueueRepo.save(msg); // transfer to stack
		return msgQueueRepo.getAllMessages();
	}

    public void save(Message msg) {
        msgStackRepo.save(msg);
    }

    public Message getLatestMessage() {
        msgQueueRepo.save(msgStackRepo.getLatestMessage());
        return msgQueueRepo.getLatestMessage();
    }
}
