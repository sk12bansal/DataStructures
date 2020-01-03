package DesignPatterns.ObserverPattern;

public interface Subject {
    void subscribe(Observer s);

    void unSubscribe(Observer s);

    void notifySubscriber();

    void upload(String title);
}
