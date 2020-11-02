package be.ac.umons.pizzas;

import be.ac.umons.Cheese;
import be.ac.umons.Ingredient;
import be.ac.umons.Pizza;

public class FruttiDiMare extends Pizza {
    Ingredient cheese = new Cheese();

    public FruttiDiMare() {
        super("FruttiDiMare");
        addIngredient(cheese);
    }

}
