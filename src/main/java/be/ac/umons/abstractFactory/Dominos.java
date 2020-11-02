package be.ac.umons.abstractFactory;

public class Dominos extends FabriqueAbstraite {
    @Override
    public ChoixPizza createPizza() {
        return new ChoixPizzaNormal();
    }
}
