package be.ac.umons.decorationPizza;

import be.ac.umons.Pizza;
import be.ac.umons.PizzaComponent;

import java.math.BigDecimal;

public abstract class Decoration implements PizzaComponent {
    protected Pizza pizza;

    public abstract Pizza Dedoration(Pizza pizza);
}
