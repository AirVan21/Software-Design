package ru.spbau.design.messenger.model;


import java.util.*;

public class Storage {
    Map<String, List<IMessage>> userToMessagesMap = new HashMap<>();

    public Optional<List<IMessage>> getMessages(User user) {
        final List<IMessage> result = userToMessagesMap.getOrDefault(user.getName(), new ArrayList<>());
        return result.size() > 0 ? Optional.of(result) : Optional.empty();
    }

    public void addMessage(User user, IMessage message) {
        final List<IMessage> target = userToMessagesMap.get(user.getName());
        if (target == null) {
            List<IMessage> messages = new ArrayList<>();
            messages.add(message);
            userToMessagesMap.put(user.getName(), messages);
        } else {
            target.add(message);
        }
    }
}
