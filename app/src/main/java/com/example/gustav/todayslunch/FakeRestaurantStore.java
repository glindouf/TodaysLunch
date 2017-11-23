package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-15.
 */

public class FakeRestaurantStore {
    private static FakeRestaurantStore fake;
    private ArrayList<Restaurant> restuarants = new ArrayList<Restaurant>();
    private ArrayList<LunchServing> lunchServings = new ArrayList<LunchServing>();
    private ArrayList<LunchServing> lunchs = new ArrayList<LunchServing>();


    private ArrayList<Dish> dishes = new ArrayList<Dish>();
    static {
        Dish d = new Dish("Carbonara",99,false);
        fake = new FakeRestaurantStore();
        fake.dishes.add(new Dish("Diavola",99,false));
        fake.dishes.add(d);
        fake.lunchServings.add(new LunchServing("Monday","11:00-14:00",fake.dishes));
        fake.lunchServings.add(new LunchServing("Tuesday","11:00-14:00",fake.dishes));
        fake.restuarants.add(new Restaurant("Mimolett","Lindholmenvägen 46", "03124224466",fake.lunchServings ));

        fake.dishes.add(new Dish("Högrevsgryta a la Fredrik",90,false));
        fake.dishes.add(new Dish("Permesanpanerad kålrot",90,true));
        fake.lunchs.add(new LunchServing("Monday","11:00-14:00",fake.dishes));
        fake.lunchs.add(new LunchServing("Tuesday","11:00-14:00",fake.dishes));
        fake.restuarants.add(new Restaurant("Bistrot","Diagonalen 8", "031223323",fake.lunchs ));
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
