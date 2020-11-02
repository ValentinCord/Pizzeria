package be.ac.umons.pizzas;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.*;

import java.math.BigDecimal;

public class FruttiDiMare extends Pizza {
    Dough dough = new Dough("Dough", BigDecimal.valueOf(3));
    TomatoSauce tomatoSauce = new TomatoSauce("TomatoSauce", BigDecimal.valueOf(1.5));
    Cheese cheese = new Cheese ("Cheese", BigDecimal.valueOf(2));
    Seafood seafood = new Seafood("Seafood", BigDecimal.valueOf(2));

    public FruttiDiMare(String name) {
        super(name);
        addIngredient(dough);
        addIngredient(tomatoSauce);
        addIngredient(cheese);
        addIngredient(seafood);
    }
}
