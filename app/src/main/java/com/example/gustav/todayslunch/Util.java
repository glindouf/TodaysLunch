package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by ludvi on 24/11/2017.
 */

public class Util {
//
    public static ArrayList<String> convertRestaurantInfo(Restaurant restaurant){
        ArrayList<String> menuItems = new ArrayList<String>();
        String title = restaurant.name() + " " + restaurant.lunchHours();
        menuItems.add(title);
        ArrayList<Dish> lunchMenu = restaurant.lunchMenu();
        for(Dish d : lunchMenu) {
            menuItems.add(d.toString());
        }
        return menuItems;
    }

    public static Restaurant getRestaurantInfo(String restaurant, ArrayList<Restaurant> restaurants) {
        Restaurant rest = null;
        for(Restaurant r :restaurants ){
            if(r.name().equals(restaurant)){
                rest = r;
            }
        }
        return rest;
    }


}
