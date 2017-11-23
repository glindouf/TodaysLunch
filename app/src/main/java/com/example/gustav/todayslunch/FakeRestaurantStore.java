package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-15.
 */

public class FakeRestaurantStore {
    //public static FakeRestaurantStore fake;
    private ArrayList<Restaurant> restuarants = new ArrayList<Restaurant>();
    private ArrayList<LunchServing> lunchServings = new ArrayList<LunchServing>();
    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    private Dish d = new Dish("Carbonara",99,false);
    /*{
        fake = new FakeRestaurantStore();
        dishes.add(new Dish("Diavola",99,false));
        dishes.add(d);
        lunchServings.add(new LunchServing("Monday","11:00-14:00",dishes));
        lunchServings.add(new LunchServing("Tuesday","11:00-14:00",dishes));
        restuarants.add(new Restaurant("Mimolett","Lindholmenvägen 46", "03124224466",lunchServings ));
    }*/

    public FakeRestaurantStore(){
    }

    public  ArrayList<Restaurant>getRestaurantInfo(){
        dishes.add(new Dish("Diavola",99,false));
        dishes.add(d);
        lunchServings.add(new LunchServing("Monday","11:00-14:00",dishes));
        lunchServings.add(new LunchServing("Tuesday","11:00-14:00",dishes));
        restuarants.add(new Restaurant("Mimolett","Lindholmenvägen 46", "03124224466",lunchServings ));
        return restuarants;
    }

}
