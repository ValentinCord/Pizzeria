package be.ac.umons.pizzas;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.*;

import java.math.BigDecimal;

public class Carbonara extends Pizza {

    public Carbonara(String name, BigDecimal price) {
        super(name,price);
        addIngredient(new Dough("Dough", BigDecimal.valueOf(3)));
        addIngredient(new WhiteCream("WhiteCream", BigDecimal.valueOf(1.5)));
        addIngredient(new Cheese("Cheese", BigDecimal.valueOf(2)));
        addIngredient(new Ham("Ham", BigDecimal.valueOf(2)));
    }
}
