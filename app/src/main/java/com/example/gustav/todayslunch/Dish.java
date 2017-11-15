package com.example.gustav.todayslunch;

/**
 * Created by ludvi on 15/11/2017.
 */

public class Dish {
    private String name;
    private int price;
    private Boolean veg;

    public Dish(String name, int price, Boolean veg){
        this.name = name;
        this.price = price;
        this.veg = veg;
    }

    @Override
    public String toString() {
        String veg = "no";
        if (this.veg) {
            veg = "yes";
        }
        return name + " " + price + "kr vegetarian: " + veg;
    }


}


