package ru.spbau.design.messenger.network;

import ru.spbau.design.messenger.Messenger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private final Messenger application;
    private final String host;
    private final int port;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;

    public Client(Messenger messenger, String clinetHost, int clinetPort) {
        application = messenger;
        host = clinetHost;
        port = clinetPort;

    }

    public synchronized void connet() throws IOException {
        if (socket != null) {
            return;
        }
    }
}
