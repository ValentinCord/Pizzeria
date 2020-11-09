package be.ac.umons;

import java.util.Observable;
import java.util.Observer;

public class Technicien implements Observer {
    private Ingredient ingredient;

    public Technicien (){
        System.out.println("j'existe");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Notification");
    }

    public void setSubject(Ingredient ingredient){
        if (ingredient == null){
            throw new NullPointerException("This ingredient is null");
        }
        this.ingredient = ingredient;
    }
}
