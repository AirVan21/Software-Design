package ru.spbau.design.messenger.model;

public interface IMessage {
    String getHost();
    int getPort();
    String getAddress();
    String getText();
}
