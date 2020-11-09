package be.ac.umons.pizzas;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.*;

import java.math.BigDecimal;

public class Carbonara extends Pizza {

    public Carbonara() {
        addIngredient(new Dough());
        addIngredient(new WhiteCream());
        addIngredient(new Cheese());
        addIngredient(new Ham());
    }
}
