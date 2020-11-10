package be.ac.umons.pizzas;

import be.ac.umons.Ingredient;
import be.ac.umons.Pizza;
import be.ac.umons.ingredients.*;

import java.math.BigDecimal;
import java.util.Map;

public class FruttiDiMare extends Pizza {

    public FruttiDiMare(Map<String, Ingredient> c) {

        addIngredient(c.get("Dough"));
        addIngredient(c.get("Tomato Sauce"));
        addIngredient(c.get("Cheese"));
        addIngredient(c.get("Sea food"));

/*
        addIngredient(new Dough());
        addIngredient(new TomatoSauce());
        addIngredient(new Cheese());
        addIngredient(new Seafood());

 */
    }
}
