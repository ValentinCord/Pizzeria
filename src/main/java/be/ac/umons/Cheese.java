package be.ac.umons;

import java.math.BigDecimal;

public class Cheese extends Ingredient {
    public Cheese() {
        super();
        setName("Cheese");
        setPrice(BigDecimal.valueOf(3));
    }
}
