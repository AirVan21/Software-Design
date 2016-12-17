package ru.spbau.design.messenger.model;

/**
 * Interface for message
 */
public interface IMessage {
    /**
     * Returns source host  ip
     * @return source host ip
     */
    String getHost();

    /**
     * Returns host port
     * @return host port
     */
    int getPort();

    /**
     * Returns "ip:port" string
     * @return "ip:port" string
     */
    String getAddress();

    /**
     * Returns message text
     * @return text
     */
    String getText();
}
