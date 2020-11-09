package be.ac.umons.state;

public class Fabrication implements State{
    private Boolean etatFabrication = false;
    @Override
    public void currentState(Context context) {
        System.out.println("Panne");
        if (etatFabrication){
            context.setState(new Attente());
        }
    }
}
