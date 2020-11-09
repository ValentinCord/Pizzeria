package be.ac.umons.decorationPizza;

import be.ac.umons.Pizza;

import java.math.BigDecimal;

public class Cheesy extends Decoration {
    private String name;
    private BigDecimal price = BigDecimal.valueOf(0);

    @Override
    public String getName() {
        return "Cheesy" + name;
    }

    @Override
    public BigDecimal getPrice() {
        return price.add(BigDecimal.valueOf(2));
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Pizza Dedoration(Pizza pizza) {
        return null;
    }
}
