package ru.spbau.design.messenger.view;


import ru.spbau.design.messenger.model.IMessage;

import java.util.List;
import java.util.Optional;

public interface IView {
    void show();
    void handleUpdate(Optional<List<IMessage>> messages);
    void sendData(String data, String targetHost, int port);
}
