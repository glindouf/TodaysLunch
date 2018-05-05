package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-15.
 */

public class Restaurant {
    private String name;
    private String address;
    private String tel;
    private String lunchHours;
    private ArrayList<Dish> lunchMenu;

    public Restaurant(String name, String adress,
                      String tel, String lunchHours, ArrayList<Dish> lunchMenu){
        this.name = name;
        this.address = adress;
        this.tel = tel;
        this.lunchHours = lunchHours;
        this.lunchMenu = lunchMenu;
    }
    public String name() {
        return name;
    }

    public String address() {
        return address;
    }
    public String getTel(){
        return tel;
    }

    public ArrayList<Dish> lunchMenu(){
        return lunchMenu;
    }

    public String lunchHours(){
        return lunchHours;
    }

}
