package be.ac.umons.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class NewChannel implements Subject {
    private List<Observer> observers;
    private String newsHeadLineMessage;

    public NewChannel() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer obj) {
        if (obj == null) {
            throw new NullPointerException("The observer passed is null");
        }
        if (!observers.contains(obj))
            observers.add(obj);
    }

    @Override
    public void unregister(Observer obj) {
        if (obj == null) {
            throw new NullPointerException("The observer passed is null");
        }
        if (observers.contains(obj))
            observers.remove(obj);
    }

    @Override
    public void notifyObservers() {

    }

    /*@Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }*/

    @Override
    public Object getUpdate(Observer obj) {
        return this.newsHeadLineMessage;
    }

    public void postNewsHeadLine(String newsHeadLine) {
        System.out.println("\nNew head-line available : " + newsHeadLine + "\n");
        this.newsHeadLineMessage = newsHeadLine;
        notifyObservers();
    }
}

