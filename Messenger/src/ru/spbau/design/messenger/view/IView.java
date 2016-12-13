package ru.spbau.design.messenger.view;


import ru.spbau.design.messenger.model.IMessage;

public interface IView {
    void show();
    void handleMessage(IMessage message);
    void sendMessage(IMessage message);
}
