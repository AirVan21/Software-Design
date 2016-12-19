package ru.spbau.design.messenger.network;


import ru.spbau.design.messenger.Messenger;
import ru.spbau.design.messenger.model.interfaces.ILogger;
import ru.spbau.design.messenger.model.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

/**
 * Server is a class for handling messages
 */
public class Server {
    private final Messenger application;
    private ServerSocket socket;
    private volatile boolean isStopped;
    private final ILogger LOGGER = new Logger(getClass().getName());

    public Server(Messenger application) {
        this.application = application;
    }

    /**
     * Starts server
     * @param port - port for server socket
     * @throws IOException
     */
    public synchronized void start(int port) throws IOException {
        LOGGER.log(Level.INFO, ": staring server on port = " + Integer.toString(port));

        if (socket != null) {
            LOGGER.log(Level.WARNING, "Server is already up!");
            return;
        }

        socket = new ServerSocket(port);
        isStopped = false;
        new Thread(this::handle).start();
    }

    /**
     * Stops server
     * @throws IOException
     */
    public synchronized void close() throws IOException, InterruptedException {
        LOGGER.log(Level.INFO, ": closing server");

        if (socket == null) {
            LOGGER.log(Level.WARNING, "Couldn't close empty socket!");
            return;
        }

        isStopped = true;
        socket.close();
        wait();
    }

    /**
     * Listens connections
     */
    private void handle() {
        while (!isStopped) {
            try {
                acceptTask();
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Couldn't accept task!");
            }

            synchronized (this) {
                notify();
            }
        }
    }

    /**
     * Accepts connection to server socket
     * @throws IOException
     */
    private void acceptTask() throws IOException {
        LOGGER.log(Level.INFO, ": accepts task");

        final Socket connection;
        try {
            connection = socket.accept();
        } catch (IOException e) {
            return;
        }

        final HandleTask task = new HandleTask(application, connection);
        new Thread(task).start();
    }
}
