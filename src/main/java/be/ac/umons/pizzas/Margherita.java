package be.ac.umons.pizzas;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.Cheese;
import be.ac.umons.ingredients.Dough;
import be.ac.umons.ingredients.TomatoSauce;

import java.math.BigDecimal;

public class Margherita extends Pizza {

    public Margherita() {
        addIngredient(new Dough());
        addIngredient(new TomatoSauce());
        addIngredient(new Cheese());
    }
}
