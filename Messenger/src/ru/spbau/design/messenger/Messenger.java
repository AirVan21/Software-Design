package ru.spbau.design.messenger;

import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.model.Message;
import ru.spbau.design.messenger.model.Storage;
import ru.spbau.design.messenger.network.Client;
import ru.spbau.design.messenger.network.Server;
import ru.spbau.design.messenger.view.IView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Messenger implements IMessenger {
    private final String host;
    private final int port;
    private final List<IView> views = new ArrayList<>();
    private final Server server = new Server(this);
    private final Storage storage = new Storage();
    private Logger logger = new Logger(getClass().getName());

    public Messenger(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
        server.start(port);
    }

    @Override
    public void start() {
        views.forEach(IView::show);
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

    private void updateViews(String address) {
        views.forEach(view -> view.handleUpdate(storage.getMessages(address)));
    }

    private void saveMessage(String address, IMessage message) {
        logger.log(Level.INFO, "save message = " + message.toString());
        storage.addMessage(address, message);
    }

    private void sendMessage(IMessage message, String address, int port) {
        logger.log(Level.INFO, "send message = " + message.toString());
        Client client = new Client(this, address, port);
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
