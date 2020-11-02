package be.ac.umons.abstractFactory;

import be.ac.umons.Pizza;

public class PizzaHut extends FabriqueAbstraite {
    @Override
    Pizza createPizza() {
        return new ChoixPizzaHut();
    }
}
