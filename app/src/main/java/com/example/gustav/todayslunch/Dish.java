package com.example.gustav.todayslunch;

/**
 * Created by ludvi on 15/11/2017.
 */

public class Dish {
    private String name;
    private int price;
    private String dishtype;

    public Dish(String name, int price, String dishtype){
        this.name = name;
        this.price = price;
        this.dishtype= dishtype;
    }

    @Override
    public String toString() {

        return name + " " + price + "kr " + dishtype;
    }


}


