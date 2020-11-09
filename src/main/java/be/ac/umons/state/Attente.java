package be.ac.umons.state;

public class Attente implements State {
    Boolean panne = false;
    Boolean manque = false;
    Boolean fabrication = false;
    @Override
    public void currentState(Context context) {
        System.out.println("Panne");
        if (panne){
            context.setState(new Panne());
        }
        if(manque){
            context.setState(new Manque());
        }
        if (fabrication){
            context.setState(new Fabrication());
        }
    }
}
