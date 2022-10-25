package controller;

import java.util.Set;

import model.Message;
import repository.MessageRepository;
import service.AccountService;

public class Account {
    private String name;
    // private final MessageRepository msgRepo;
    private AccountService accountSV;
    // public Account(MessageRepository msgRepo) {
    //     this.msgRepo = msgRepo;
    // }
    
    public Account(AccountService accountSV) {
        this.accountSV = accountSV;
    }
    
    // public Account(MessageRepository msgRepo, String name) {
    //     this(msgRepo);
    //     this.name = name;
    // }

    public void send(Message msg) {
        accountSV.save(msg);
        System.out.printf("From: %s send message successfully!\n", this.name);
    }

    public void showAllMessages() {
        Set<Message> setMsg = accountSV.getAllMessages();
        if (setMsg.isEmpty()) {
            System.out.println("*********************************");
            System.out.println("****Please send more message!****");
            System.out.println("*********************************");
        } else {
            for (Message msg : setMsg) {
                System.out.println(String.format("From: %s -> To: %s", msg.getFrom(), msg.getTo()));
                System.out.println(msg.getData());
            }
        }
    }

    public void showLatestMessage() {
        Message msgLatest = accountSV.getLatestMessage();
        if (msgLatest != null) {
            System.out.println(String.format("From: %s -> To: %s", msgLatest.getFrom(), msgLatest.getTo()));
            System.out.println(msgLatest.getData());
        } else {
            System.out.println("*********************************");
            System.out.println("****Please send more message!****");
            System.out.println("*********************************");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}