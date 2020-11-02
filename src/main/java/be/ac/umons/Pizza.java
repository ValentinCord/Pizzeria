package be.ac.umons;

import java.math.BigDecimal;
import java.util.ArrayList;

public abstract class Pizza extends Ingredient implements PizzaComponent {
    private String name;
    private BigDecimal price = BigDecimal.valueOf(0);
    public ArrayList<Ingredient> listIngredients = new ArrayList<Ingredient>();

    public Pizza(String name){
        super();
        this.name = name;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public BigDecimal getPrice(){
        return price;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    public ArrayList<Ingredient> getListIngredient(){
        return listIngredients;
    }
    public void addIngredient(Ingredient i){
        listIngredients.add(i);
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", listIngredients=" + listIngredients +
                '}';
    }

    public abstract Pizza type(Pizza pizza);
}
