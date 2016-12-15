package ru.spbau.design.messenger.view;


import ru.spbau.design.messenger.model.IMessage;

public interface IView {
    void show();
    void handleMessage(IMessage message);
    void sendData(String data, String targetHost, int port);
}
