package be.ac.umons.pizzas;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.Cheese;
import be.ac.umons.ingredients.Dough;
import be.ac.umons.ingredients.Ham;
import be.ac.umons.ingredients.TomatoSauce;

import java.math.BigDecimal;

public class Proscuitto extends Pizza {
    Dough dough = new Dough("Dough", BigDecimal.valueOf(3));
    TomatoSauce tomatoSauce = new TomatoSauce("TomatoSauce", BigDecimal.valueOf(1.5));
    Cheese cheese = new Cheese ("Cheese", BigDecimal.valueOf(2));
    Ham ham = new Ham("Ham", BigDecimal.valueOf(2));

    public Proscuitto(String name, BigDecimal price) {
        super(name,price);
        addIngredient(dough);
        addIngredient(tomatoSauce);
        addIngredient(cheese);
        addIngredient(ham);
    }
}
