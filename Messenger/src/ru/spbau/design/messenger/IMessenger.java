package ru.spbau.design.messenger;


import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.view.IView;


public interface IMessenger {
    void start();
    void addView(IView view);
    void handleMessage(IMessage message);
    void sendMessage(String data, String address, int port);
    String getHost();
    int getPort();
}
