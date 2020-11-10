package be.ac.umons.pizzas;

import be.ac.umons.Ingredient;
import be.ac.umons.Pizza;
import be.ac.umons.ingredients.Cheese;
import be.ac.umons.ingredients.Dough;
import be.ac.umons.ingredients.TomatoSauce;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Margherita extends Pizza {



    public Margherita(Map<String, Ingredient> c) {

        addIngredient(c.get("Dough"));
        addIngredient(c.get("Tomato Sauce"));
        addIngredient(c.get("Cheese"));

        /*
        addIngredient(new Dough());
        addIngredient(new TomatoSauce());
        addIngredient(new Cheese());
         */
    }
}
