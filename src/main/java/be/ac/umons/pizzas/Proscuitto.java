package be.ac.umons.pizzas;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.Cheese;
import be.ac.umons.ingredients.Dough;
import be.ac.umons.ingredients.Ham;
import be.ac.umons.ingredients.TomatoSauce;

import java.math.BigDecimal;

public class Proscuitto extends Pizza {

    public Proscuitto() {

        addIngredient(new Dough());
        addIngredient(new TomatoSauce());
        addIngredient(new Cheese());
        addIngredient(new Ham());
    }
}
