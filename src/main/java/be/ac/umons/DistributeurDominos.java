package be.ac.umons;

import java.util.ArrayList;

public class DistributeurDominos extends Thread{
    ArrayList<Pizza> commandes = new ArrayList<>();

    public void run(){
        try {
            sleep(60000);
            //System.out.println("commande finie");
            //commandes.del(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
