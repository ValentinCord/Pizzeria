package be.ac.umons.observer;

public class Viewers implements Observer{
    private String viewerName;
    private Subject newsChannelObj;

    public Viewers(String viewerName) {
        this.viewerName = viewerName;
    }

    /*@Override
    public void update() {
        String msg = (String) newsChannelObj.getUpdate((java.util.Observer) this);

        if (msg == null)
            System.out.println("No notifications for " + viewerName);
        else
            System.out.println("Notify " + viewerName + " of a new  headline -> " + msg);
    }*/

    @Override
    public void setSubject(Subject subject) {
        if (subject == null)
            throw new NullPointerException("The subject object is null");
        this.newsChannelObj = subject;
    }
}
