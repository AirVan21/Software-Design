package ru.spbau.design.messenger;

import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.model.Message;
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
        updateViews(message);
    }

    @Override
    public void sendMessage(String data, String address, int port)  {
        IMessage message = new Message(host, this.port, data);
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

    @Override
    public String getHost() {
        return host;
    }

    @Override
    public int getPort() {
        return port;
    }

    private void updateViews(IMessage message) {
        views.forEach(view -> view.handleMessage(message));
    }
}
