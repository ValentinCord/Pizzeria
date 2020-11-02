package be.ac.umons.abstractFactory;

public class PizzaHut extends FabriqueAbstraite {
    @Override
    public ChoixPizza createPizza() {
        return new ChoixPizzaHut();
    }
}
