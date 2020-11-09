package be.ac.umons.state;

public class Manque implements State {
    private Boolean manque = false;
    @Override
    public void currentState(Context context) {
        System.out.println("Manque");
        if (manque){
            context.setState(new Attente());
        }
    }
}
