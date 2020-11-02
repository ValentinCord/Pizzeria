package be.ac.umons.abstractFactory;

import be.ac.umons.Pizza;

public class ChoixPizzaNormal extends Pizza {
    @Override
    public Pizza type(Pizza pizza){
        return pizza;
    }
}
