package be.ac.umons.abstractFactory;

import be.ac.umons.Pizza;

public class Dominos extends FabriqueAbstraite {
    @Override
    Pizza createPizza() {
        return new ChoixPizzaNormal();
    }
}
