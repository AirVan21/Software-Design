package ru.spbau.design.messenger.view;


import ru.spbau.design.messenger.model.IMessage;

public interface IView {
    void handleMessage(IMessage message);
}
