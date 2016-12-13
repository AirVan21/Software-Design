package ru.spbau.design.messenger.network;

import ru.spbau.design.messenger.Messenger;
import ru.spbau.design.messenger.model.ILogger;
import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.model.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

public class Client {
    private final Messenger application;
    private final User user;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private final ILogger logger = new Logger();

    public Client(Messenger messenger, User user) {
        application = messenger;
        this.user = user;

    }

    public synchronized void connet() throws IOException {
        if (socket != null) {
            logger.log(Level.WARNING, "Connection is already opened!");
            return;
        }

        socket = new Socket(user.getHost(), user.getPort());
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    /**
     * Sending message to server
     * @param message payload
     */
    public synchronized void sendMessage(IMessage message) {
        try {
            output.writeUTF(message.getHost());
            output.writeUTF(message.getText());
            output.flush();
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
            try {
                disconnect();
            } catch (IOException closeException) {
                logger.log(Level.WARNING, "Exception on close!");
            }
        }
    }

    /**
     * Closes connection
     * @throws IOException
     */
    public synchronized void disconnect() throws IOException {
        if (socket == null) {
            logger.log(Level.WARNING, "Connection is not found!");
            return;
        }
        // closes input/output streams
        socket.close();
    }
}
