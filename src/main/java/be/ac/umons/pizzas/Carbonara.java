package be.ac.umons.pizzas;

import be.ac.umons.Ingredient;
import be.ac.umons.Pizza;
import be.ac.umons.ingredients.*;

import java.math.BigDecimal;
import java.util.Map;

public class Carbonara extends Pizza {

    public Carbonara(Map<String, Ingredient> c) {

        addIngredient(c.get("Dough"));
        addIngredient(c.get("White Cream"));
        addIngredient(c.get("Cheese"));
        addIngredient(c.get("Ham"));
/*
        addIngredient(new Dough());
        addIngredient(new WhiteCream());
        addIngredient(new Cheese());
        addIngredient(new Ham());

 */
    }
}
