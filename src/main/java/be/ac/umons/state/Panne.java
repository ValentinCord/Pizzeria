package be.ac.umons.state;

public class Panne implements State {
    Boolean panne = true;
    @Override
    public void currentState(Context context) {
        System.out.println("Panne");
        if (!panne) {
            context.setState(new Attente());
        }
    }

}
