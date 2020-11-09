package be.ac.umons.observer;

public interface Observer {

    /**
     * Update the observer, used by subject
     */
    //public void update();

    /**
     * Attach with the subject to observe
     * @param subject
     */
    public void setSubject(Subject subject);
}
