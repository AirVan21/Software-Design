package ru.spbau.design.messenger.network;

import ru.spbau.design.messenger.model.interfaces.ILogger;
import ru.spbau.design.messenger.model.interfaces.IMessage;
import ru.spbau.design.messenger.model.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

/**
 * Client is a class for sending messages
 */
public class Client {
    private final String host;
    private final int port;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private final ILogger LOGGER = new Logger(getClass().getName());

    public Client(String host, int port) {
        this.host = host;
        this.port = port;

    }

    /**
     * Connects to server
     * @throws IOException
     */
    public synchronized void conneсt() throws IOException {
        if (socket != null) {
            LOGGER.log(Level.WARNING, "Connection is already opened!");
            return;
        }

        socket = new Socket(host, port);
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
    }

    /**
     * Sending message to server
     * @param message payload
     */
    public synchronized void sendMessage(IMessage message) {
        try {
            output.writeUTF(message.getHost());
            output.writeInt(message.getPort());
            output.writeUTF(message.getText());
            output.flush();
            // Reads approve message
            input.readInt();
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            try {
                disconnect();
            } catch (IOException closeException) {
                LOGGER.log(Level.WARNING, "Exception on close!");
            }
        }
    }

    /**
     * Closes connection
     * @throws IOException
     */
    public synchronized void disconnect() throws IOException {
        if (socket == null) {
            LOGGER.log(Level.WARNING, "Connection is not found!");
            return;
        }
        // closes input/output streams
        socket.close();
    }
}
