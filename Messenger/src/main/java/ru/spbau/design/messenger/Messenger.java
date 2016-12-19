package ru.spbau.design.messenger;

import ru.spbau.design.messenger.model.interfaces.IMessage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.model.Message;
import ru.spbau.design.messenger.model.Storage;
import ru.spbau.design.messenger.network.Client;
import ru.spbau.design.messenger.network.Server;
import ru.spbau.design.messenger.view.IView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

public class Messenger implements IMessenger {
    private final String host;
    private final int port;
    private final List<IView> views = new ArrayList<>();
    private final Server server = new Server(this);
    private final Storage storage = new Storage();
    private final Logger logger = new Logger(getClass().getName());

    public Messenger(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void start() throws IOException {
        server.start(port);
        views.forEach(IView::show);
    }

    @Override
    public void close() throws IOException, InterruptedException {
        server.close();
        views.forEach(IView::close);
    }

    @Override
    public void addView(IView view) {
        views.add(view);
    }

    @Override
    public void handleMessage(IMessage message) {
        logger.log(Level.INFO, "handled message = " + message.toString());
        storage.addMessage(message.getAddress(), message);
        updateViews(message.getAddress());
    }

    @Override
    public void sendMessage(String data, String host, int port)  {
        // Save message
        IMessage messageToSave = new Message(host, port, data);
        // Send message
        IMessage messageToSend = new Message(this.host, this.port, data);
        sendMessage(messageToSend, host, port);
        saveMessage(messageToSave.getAddress(), messageToSend);
        updateViews(messageToSave.getAddress());
    }

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public int getPort() {
        return port;
    }

    /**
     * Asks all views to update
     * @param address - ip:port of updated dialog
     */
    private void updateViews(String address) {
        final Optional<List<IMessage>> messages = storage.getMessages(address);
        views.forEach(view -> view.handleUpdate(address, messages));
    }

    /**
     * Saves message in local DB
     * @param address ip:port
     * @param message message to save
     */
    private void saveMessage(String address, IMessage message) {
        logger.log(Level.INFO, "save message = " + message.toString());
        storage.addMessage(address, message);
    }

    /**
     * Sends message
     * @param message message to send
     * @param address receiver's host ip
     * @param port receiver's port
     */
    private void sendMessage(IMessage message, String address, int port) {
        logger.log(Level.INFO, "send message = " + message.toString());
        Client client = new Client(address, port);
        try {
            client.conneсt();
            client.sendMessage(message);
            client.disconnect();
        } catch (IOException e) {
            logger.log(Level.WARNING, e.getMessage());
        } finally {
            try {
                client.disconnect();
            } catch (IOException e) {
                logger.log(Level.WARNING, e.getMessage());
            }
        }
    }
}
