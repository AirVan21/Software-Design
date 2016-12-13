package ru.spbau.design.messenger;

import ru.spbau.design.messenger.model.IMessage;
import ru.spbau.design.messenger.model.Logger;
import ru.spbau.design.messenger.network.Client;
import ru.spbau.design.messenger.network.Server;
import ru.spbau.design.messenger.view.IView;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Messenger implements IMessenger {
    private final static int PORT = 8841;
    private final List<IView> views = new ArrayList<>();
    private String host;
    private Client client;
    private Server server;
    private Logger logger = new Logger(getClass().getName());

    public Messenger(String host) {
        this.host = host;
    }

    @Override
    public void updateViews(IMessage message) {
        views.forEach(view -> view.handleMessage(message));
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

    }

    @Override
    public void sendMessage(IMessage message)  {
        logger.log(Level.INFO, "sendMessage = " + message.toString());
        client = new Client(this, message.getHost(), PORT);
        try {
            client.connet();
            client.sendMessage(message);
            client.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
