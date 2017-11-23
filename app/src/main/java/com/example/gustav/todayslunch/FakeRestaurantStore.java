package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-15.
 */

public class FakeRestaurantStore {
    private static FakeRestaurantStore fake;
    private ArrayList<Restaurant> restuarants = new ArrayList<Restaurant>();

    static {
        ArrayList<Dish> mimolettDishes = new ArrayList<Dish>();
        ArrayList<Dish> bistroDishes = new ArrayList<Dish>();
        fake = new FakeRestaurantStore();
        mimolettDishes.add(new Dish("Diavola",99,false));
        mimolettDishes.add(new Dish("Carbonara",99,false));
        ArrayList<LunchServing> mimolettServings = new ArrayList<LunchServing>();
        mimolettServings.add(new LunchServing("Monday","11:00-14:00",mimolettDishes));
        mimolettServings.add(new LunchServing("Tuesday","11:00-14:00",mimolettDishes));
        fake.restuarants.add(new Restaurant("Mimolett","Lindholmenvägen 46", "03124224466",mimolettServings));

        bistroDishes.add(new Dish("Högrevsgryta a la Fredrik",90,false));
        bistroDishes.add(new Dish("Permesanpanerad kålrot",90,true));
        ArrayList<LunchServing> bistroServings= new ArrayList<LunchServing>();
        bistroServings.add(new LunchServing("Monday","11:00-14:00",bistroDishes));
        bistroServings.add(new LunchServing("Tuesday","11:00-14:00",bistroDishes));
        fake.restuarants.add(new Restaurant("Bistrot","Diagonalen 8", "031223323",bistroServings ));
    }

    public static FakeRestaurantStore getInstance() {
        return fake;
    }
    private FakeRestaurantStore(){
    }

    public Restaurant getRestaurantInfo(String restaurant) {
        Restaurant rest = null;
        for(Restaurant r : fake.restuarants){
            if(r.name().equals(restaurant)){
                rest = r;
            }
        }
        return rest;
    }
}
