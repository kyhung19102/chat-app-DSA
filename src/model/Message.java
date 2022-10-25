package model;

public class Message {
    private String from;
    private String to;
    private String data;

    public Message(String from, String to) {
        this.from = from;
        this.to = to;
        this.data = null;
    }

    public Message(String from, String data, String to) {
        this.from = from;
        this.to = to;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Message [from=" + from + ", to=" + to + ", data=" + data + "]";
    }
}
