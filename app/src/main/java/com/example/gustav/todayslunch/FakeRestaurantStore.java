package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-15.
 */

public class FakeRestaurantStore {
    private static FakeRestaurantStore fake;
    private ArrayList<Restaurant> restuarants = new ArrayList<Restaurant>();
    private ArrayList<LunchServing> lunchServings = new ArrayList<LunchServing>();
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    static {
        Dish d = new Dish("Carbonara",99,false);
        fake = new FakeRestaurantStore();
        fake.dishes.add(new Dish("Diavola",99,false));
        fake.dishes.add(d);
        fake.lunchServings.add(new LunchServing("Monday","11:00-14:00",fake.dishes));
        fake.lunchServings.add(new LunchServing("Tuesday","11:00-14:00",fake.dishes));
        fake.restuarants.add(new Restaurant("Mimolett","Lindholmenvägen 46", "03124224466",fake.lunchServings ));
    }

    public static FakeRestaurantStore getInstance() {
        return fake;
    }
    private FakeRestaurantStore(){
    }

    public  ArrayList<Restaurant>getRestaurantInfo(){

        return restuarants;
    }

}
