package be.ac.umons.pizzas;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.*;

import java.math.BigDecimal;

public class Carbonara extends Pizza {
    Dough dough = new Dough("Dough", BigDecimal.valueOf(3));
    WhiteCream whiteCream = new WhiteCream("WhiteCream", BigDecimal.valueOf(1.5));
    Cheese cheese = new Cheese ("Cheese", BigDecimal.valueOf(2));
    Ham ham = new Ham("Ham", BigDecimal.valueOf(2));

    public Carbonara(String name, BigDecimal price) {
        super(name,price);
        addIngredient(dough);
        addIngredient(whiteCream);
        addIngredient(cheese);
        addIngredient(ham);
    }
}
