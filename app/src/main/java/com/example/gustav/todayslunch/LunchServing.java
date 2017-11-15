package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by ludvi on 15/11/2017.
 */

public class LunchServing {
    private String day;
    private String lunchHours;
    private ArrayList<Dish> lunchMenu;

    public LunchServing(String day, String lunchHours,ArrayList<Dish> lunchMenu){
        this.day = day;
        this.lunchHours = lunchHours;
        this.lunchMenu = lunchMenu;
    }

    public ArrayList<Dish> lunchMenu(){
        return lunchMenu;
    }


}
