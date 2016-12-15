package ru.spbau.design.messenger.network;


import ru.spbau.design.messenger.Messenger;
import ru.spbau.design.messenger.model.ILogger;
import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.model.Message;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

/**
 * HandleTask is a class which handles Client request (and executes it)
 */
public class HandleTask implements Runnable {
    private final static int APPROVE_CODE = 42;
    private final Messenger application;
    private final Socket taskSocket;
    private DataInputStream input;
    private DataOutputStream output;
    private final ILogger logger = new Logger(getClass().getName());

    public HandleTask(Messenger application, Socket connection) throws IOException {
        this.application = application;
        taskSocket = connection;
        input = new DataInputStream(taskSocket.getInputStream());
        output = new DataOutputStream(taskSocket.getOutputStream());
    }

    /**
     * Parses and approves client message
     */
    @Override
    public void run() {
        try {
            while (!taskSocket.isClosed()) {
                String address = input.readUTF();
                int port = input.readInt();
                String text = input.readUTF();
                logger.log(Level.INFO, "handled: " + address);
                IMessage message = new Message(address, port, text);
                output.writeInt(APPROVE_CODE);
                application.handleMessage(message);
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        } finally {
            try {
                taskSocket.close();
            } catch (IOException e) {
                logger.log(Level.WARNING, e.getMessage());
            }
        }
    }
}