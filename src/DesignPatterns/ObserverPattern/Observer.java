package DesignPatterns.ObserverPattern;

public interface Observer {
    void update();

    void subscribeChannel(Channel ch);
}
