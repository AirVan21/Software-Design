package ru.spbau.design.messenger.model;

import ru.spbau.design.messenger.model.interfaces.IMessage;

import java.util.*;
import java.util.logging.Level;

/**
 * Storage is a simple Database stub
 */
public class Storage {
    private final Map<String, List<IMessage>> userToMessagesMap = new HashMap<>();
    private final Logger LOGGER = new Logger(getClass().getName());

    /**
     * Get messages for dialog with selected user
     * @param address - "ip:port" key
     * @return all messages from this dialog
     */
    public Optional<List<IMessage>> getMessages(String address) {
        LOGGER.log(Level.INFO, "get message for " + address);

        final List<IMessage> result = userToMessagesMap.get(address);
        return result != null ? Optional.of(result) : Optional.empty();
    }

    /**
     * Storage message to dialog with current user
     * @param address "ip:port" key
     * @param message message to store
     */
    public void addMessage(String address, IMessage message) {
        LOGGER.log(Level.INFO, "add message = " + message.getText());
        LOGGER.log(Level.INFO, "address = " + address);

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
