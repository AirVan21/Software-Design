package ru.spbau.design.messenger.network;


import ru.spbau.design.messenger.Messenger;
import ru.spbau.design.messenger.model.ILogger;
import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.model.Message;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

/**
 * HandleTask is a class which handles Client request (and executes it)
 */
public class HandleTask implements Runnable {
    private final Messenger application;
    private final Socket taskSocket;
    private DataInputStream input;
    private final ILogger logger = new Logger();

    public HandleTask(Messenger application, Socket connection) throws IOException {
        this.application = application;
        taskSocket = connection;
        input = new DataInputStream(taskSocket.getInputStream());
    }

    /**
     * Parses and executes client request
     */
    @Override
    public void run() {
        try {
            while (!taskSocket.isClosed()) {
                String address = input.readUTF();
                String text = input.readUTF();
                logger.log(Level.INFO, "handled: " + address);
                IMessage message = new Message(address, text);
                application.handleMessage(message);
            }
        } catch (IOException e) {
            // skip
        } finally {
            try {
                taskSocket.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, e.getMessage());
            }
        }
    }
}