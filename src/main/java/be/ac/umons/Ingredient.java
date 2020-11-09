package be.ac.umons;

import java.math.BigDecimal;
import java.util.List;
import java.util.Observer;

public class Ingredient implements PizzaComponent {
    private String name;
    private BigDecimal price;
    public List<Observer> observers;

    public Ingredient(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
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
    public void register(Observer obs){
        if (obs == null){
            throw new NullPointerException(("This osb is null"));
        }

        if (!observers.contains(obs)){
            observers.add(obs);
        }
    }
    public void unregister(Observer obs){
        if (obs == null){
            throw new NullPointerException(("This observer is null"));
        }

        if (!observers.contains(obs)){
            observers.remove(obs);
        }
    }

    public void notify(List<Observer> observers){

    }


}
