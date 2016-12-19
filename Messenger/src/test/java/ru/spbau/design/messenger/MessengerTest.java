package ru.spbau.design.messenger;

import org.junit.Test;
import ru.spbau.design.messenger.model.Message;
import ru.spbau.design.messenger.model.interfaces.IMessage;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MessengerTest {
    private final String HOST = "localhost";
    private final String DATA = "TEST";
    private final int PORT_FST = 8841;
    private final int PORT_SND = 8842;

    @Test
    public void handleMessage() throws Exception {
        IMessage message = new Message(HOST, PORT_SND, DATA);
        Messenger messenger = new Messenger(HOST, PORT_FST);

        IMessage spyMessage = spy(message);
        Messenger spyMessenger = spy(messenger);

        spyMessenger.handleMessage(spyMessage);
        verify(spyMessenger, times(1)).handleMessage(spyMessage);
        verify(spyMessage, times(2)).getAddress();
    }

    @Test
    public void sendMessage() throws Exception {
        Messenger messengerFst = new Messenger(HOST, PORT_FST);
        Messenger messengerSnd = new Messenger(HOST, PORT_SND);
        Messenger spyFst = spy(messengerFst);
        Messenger spySnd = spy(messengerSnd);

        spyFst.start();
        spySnd.start();
        verify(spyFst, times(1)).start();
        verify(spySnd, times(1)).start();

        spyFst.sendMessage(DATA, HOST, PORT_SND);
        verify(spyFst, times(1)).sendMessage(DATA, HOST, PORT_SND);

        spyFst.close();
        spySnd.close();
        verify(spyFst, times(1)).close();
        verify(spySnd, times(1)).close();
    }
}