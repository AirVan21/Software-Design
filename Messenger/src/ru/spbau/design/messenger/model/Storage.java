package ru.spbau.design.messenger.model;


import java.util.*;

public class Storage {
    private final Map<String, List<IMessage>> userToMessagesMap = new HashMap<>();
    private final Logger logger = new Logger(getClass().getName());

    public Optional<List<IMessage>> getMessages(String userAddress) {
        final List<IMessage> result = userToMessagesMap.getOrDefault(userAddress, new ArrayList<>());
        return result.size() > 0 ? Optional.of(result) : Optional.empty();
    }

    public void addMessage(String userAddress, IMessage message) {
        final List<IMessage> target = userToMessagesMap.get(userAddress);
        if (target == null) {
            List<IMessage> messages = new ArrayList<>();
            messages.add(message);
            userToMessagesMap.put(userAddress, messages);
        } else {
            target.add(message);
        }
    }
}
