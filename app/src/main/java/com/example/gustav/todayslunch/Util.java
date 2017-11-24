package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by ludvi on 24/11/2017.
 */

public class Util {

    public static ArrayList<String> convertRestaurantInfo(Restaurant restaurant){
        ArrayList<String> menuItems = new ArrayList<String>();
        ArrayList<LunchServing> weekMenu = restaurant.weekMenu();
        for(LunchServing l : weekMenu){
            String title = l.day() + " " + l.lunchHours();
            menuItems.add(title);
            ArrayList<Dish> lunchMenu = l.lunchMenu();
            for(Dish d : lunchMenu) {
                menuItems.add(d.toString());
            }
        }
        return menuItems;
    }

    public static Restaurant getRestaurantInfo(String restaurant, ArrayList<Restaurant> restaurants) {
        Restaurant rest = new Restaurant("Error couldnt find the restaurant",
                "Error", "Error",new ArrayList<LunchServing>() );
        for(Restaurant r :restaurants ){
            if(r.name().equals(restaurant)){
                rest = r;
            }
        }
        return rest;
    }


}
