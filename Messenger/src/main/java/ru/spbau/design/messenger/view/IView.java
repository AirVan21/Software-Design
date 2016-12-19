package ru.spbau.design.messenger.view;

import ru.spbau.design.messenger.model.interfaces.IMessage;

import java.util.List;
import java.util.Optional;

/**
 * Interface for Messenger views
 */
public interface IView {
    /**
     * Shows view to user
     */
    void show();

    /**
     * Closes view
     */
    void close();

    /**
     * Handles updated dialog messages
     * @param address - ip:port string of dialog participant
     * @param messages - messages which are connected with this dialog
     */
    void handleUpdate(String address, Optional<List<IMessage>> messages);

    /**
     * Provides data for new message
     * @param data message text
     * @param targetHost ip of target host
     * @param port port of target host
     */
    void sendData(String data, String targetHost, int port);
}
