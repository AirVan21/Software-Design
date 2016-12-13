package ru.spbau.design.messenger;


import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.view.IView;

public interface IMessenger {
    void addView(IView view);
    void updateViews(IMessage message);
    void handleMessage(IMessage message);
}
