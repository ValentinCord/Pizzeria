package be.ac.umons.abstractFactory;

import be.ac.umons.Pizza;

import java.math.BigDecimal;

public class ChoixPizzaNormal extends ChoixPizza {

    public Pizza type(Pizza pizza){
        return pizza;
    }
}
