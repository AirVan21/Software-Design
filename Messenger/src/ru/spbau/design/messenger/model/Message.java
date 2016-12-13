package ru.spbau.design.messenger.model;

public class Message implements IMessage {
    private String host;
    private String text;

    public Message(String host, String text) {
        this.host = host;
        this.text = text;
    }

    @Override
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "<" + host + ">: " + text;
    }
}
