package ru.spbau.design.messenger.network;


import ru.spbau.design.messenger.Messenger;
import ru.spbau.design.messenger.model.ILogger;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.model.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;

public class Server {
    private final Messenger application;
    private final User user;
    private ServerSocket socket;
    private volatile boolean isStopped;
    private final ILogger logger = new Logger();

    public Server(Messenger application, User user) {
        this.application = application;
        this.user = user;
    }

    /**
     * Starts server
     * @param port - port for server socket
     * @throws IOException
     */
    public synchronized void start(int port) throws IOException {
        if (socket != null) {
            logger.log(Level.WARNING, "Server is already up!");
            return;
        }

        socket = new ServerSocket(port);
        isStopped = false;
        new Thread(this::handle).start();
    }

    /**
     * Listens connections
     */
    private void handle() {
        while (!isStopped) {
            try {
                acceptTask();
            } catch (IOException e) {
                logger.log(Level.WARNING, "Couldn't accept task!");
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
        final Socket connection;
        try {
            connection = socket.accept();
        } catch (IOException e) {
            return;
        }

        final HandleTask task = new HandleTask(connection);
        new Thread(task).start();
    }
}
