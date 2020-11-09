package be.ac.umons.pizzas;

import be.ac.umons.Pizza;
import be.ac.umons.ingredients.*;

import java.math.BigDecimal;

public class FruttiDiMare extends Pizza {

    public FruttiDiMare() {

        addIngredient(new Dough());
        addIngredient(new TomatoSauce());
        addIngredient(new Cheese());
        addIngredient(new Seafood());
    }
}
