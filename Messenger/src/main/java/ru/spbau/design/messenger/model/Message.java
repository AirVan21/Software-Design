package ru.spbau.design.messenger.model;

import ru.spbau.design.messenger.model.interfaces.IMessage;

public class Message implements IMessage {
    private String host;
    private int port;
    private String text;

    public Message(String host, int port, String text) {
        this.host = host;
        this.port = port;
        this.text = text;
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "<" + host + ":" + Integer.toString(port) + ">: " + text;
    }

    public int getPort() {
        return port;
    }

    @Override
    public String getAddress() {
        return host + ":" + Integer.toString(port);
    }
}