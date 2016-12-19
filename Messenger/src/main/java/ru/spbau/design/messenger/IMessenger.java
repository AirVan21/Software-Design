package ru.spbau.design.messenger;

import ru.spbau.design.messenger.model.interfaces.IMessage;
import ru.spbau.design.messenger.view.IView;

import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * Interface for messenger apps
 */
public interface IMessenger {
    /**
     * Runs applications' views and server
     */
    void start() throws IOException;

    void close() throws IOException, InterruptedException;

    /**
     * Adds one more application view
     * @param view - Messengers view
     */
    void addView(IView view);

    /**
     * Handles message
     * @param message message
     */
    void handleMessage(IMessage message);

    /**
     * Sends date to server with (address:port)
     * @param data message data
     * @param host ip address of server-receiver
     * @param port port of server-receiver
     */
    void sendMessage(String data, String host, int port);

    /**
     * Gets own server ip address
     * @return
     */
    String getHost();

    /**
     * Gets own server port address
     * @return
     */
    int getPort();
}
