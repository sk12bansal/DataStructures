package DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {
    List<Observer> sub = new ArrayList<>();
    String title;

    @Override
    public void subscribe(Observer s) {
        sub.add(s);
    }

    @Override
    public void unSubscribe(Observer s) {
        sub.remove(s);
    }

    @Override
    public void notifySubscriber() {
        for (Observer s : sub) {
            s.update();
        }
    }

    @Override
    public void upload(String title) {
        this.title = title;
        notifySubscriber();
    }
}
