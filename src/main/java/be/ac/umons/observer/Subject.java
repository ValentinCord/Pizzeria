package be.ac.umons.observer;

import java.util.Observer;

public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);

    /**
     * Notify observers of changes
     */
    public void notifyObservers();

    /**
     * Get updates from subject
     * @param obj the subject
     * @return
     */
    public Object getUpdate(Observer obj);
}

