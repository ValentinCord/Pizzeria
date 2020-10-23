package be.ac.umons;

import java.math.BigDecimal;
import java.util.Observer;

public class Ingredient implements PizzaComponent {
    private String name;
    private BigDecimal price;
    // private ObserverCollection;

    public Ingredient() {
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public BigDecimal getPrice() {
        return price;
    }
    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    public void registerObserver(Observer o){

    }
    public void unregisterObserver(Observer o){

    }
    public void notifyObserver(){

    }


}
