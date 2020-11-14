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
        c.get("Dough").setStock(c.get("Dough").getStock()-1);
        addIngredient(c.get("Tomato Sauce"));
        c.get("Tomato Sauce").setStock(c.get("Tomato Sauce").getStock()-1);
        addIngredient(c.get("Cheese"));
        c.get("Cheese").setStock(c.get("Cheese").getStock()-1);

        /*
        addIngredient(new Dough());
        addIngredient(new TomatoSauce());
        addIngredient(new Cheese());
         */
    }
}
