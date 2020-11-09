package be.ac.umons.abstractFactory;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.Olive;

import java.math.BigDecimal;

public class ChoixPizzaHut extends ChoixPizza {

    Olive olive = new Olive();

    public Pizza type(Pizza pizza){
        pizza.addIngredient(olive);
        return pizza;
    }
}
