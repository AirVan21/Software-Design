package ru.spbau.design.messenger.model;

import java.util.*;
import java.util.logging.Level;

public class Storage {
    private final Map<String, List<IMessage>> userToMessagesMap = new HashMap<>();
    private final Logger logger = new Logger(getClass().getName());

    public Optional<List<IMessage>> getMessages(String address) {
        logger.log(Level.INFO, "get message for " + address);
        final List<IMessage> result = userToMessagesMap.get(address);
        return result != null ? Optional.of(result) : Optional.empty();
    }

    public void addMessage(String address, IMessage message) {
        logger.log(Level.INFO, "add message = " + message.getText());
        logger.log(Level.INFO, "address = " + address);
        final List<IMessage> target = userToMessagesMap.get(address);
        if (target == null) {
            List<IMessage> messages = new ArrayList<>();
            messages.add(message);
            userToMessagesMap.put(address, messages);
        } else {
            target.add(message);
        }
    }
}
