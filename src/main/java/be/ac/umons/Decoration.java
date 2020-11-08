package be.ac.umons;

import java.math.BigDecimal;

public class Decoration extends Pizza {
    private String name;
    private BigDecimal price = BigDecimal.valueOf(0);

    public Decoration(String name, BigDecimal price, String type) {
        super(name, price);
        if (type.equals("Cheesy")){
            this.name = "Cheese " + name;
            this.price = price.add(BigDecimal.valueOf(2));
        }
        else if(type.equals("Pan")){
            this.name = "Pan " + name;
            this.price = price.add(BigDecimal.valueOf(1.5));
        }
    }



}
