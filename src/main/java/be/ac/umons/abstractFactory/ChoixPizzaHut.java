package be.ac.umons.abstractFactory;

import be.ac.umons.Ingredient;
import be.ac.umons.Pizza;
import be.ac.umons.ingredients.Olive;

import java.math.BigDecimal;
import java.util.Map;

public class ChoixPizzaHut extends ChoixPizza { ;

    public Pizza type(Pizza pizza, Map<String, Ingredient> c){

        pizza.addIngredient(c.get("Olive"));
        return pizza;
    }
}
