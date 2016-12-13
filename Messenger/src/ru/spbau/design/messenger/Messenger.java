package ru.spbau.design.messenger;

import ru.spbau.design.messenger.network.Client;
import ru.spbau.design.messenger.network.Server;
import ru.spbau.design.messenger.view.IView;

import java.util.List;

public class Messenger implements IMessenger {
    private List<IView> views;
    private Client client;
    private Server server;

    @Override
    public void updateViews() {

    }

    @Override
    public void addView(IView view) {
        views.add(view);
    }
}
