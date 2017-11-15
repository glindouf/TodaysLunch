package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-15.
 */

public class FakeRestaurantStore {
    private FakeRestaurantStore fake;
    private ArrayList<Restaurant> restuarants = new ArrayList<Restaurant>();

    {
        fake = new FakeRestaurantStore();
        restuarants.add(new Restaurant("Mimolett","Lindholmenvägen 46", "03124224466", ));
    }

    private FakeRestaurantStore(){
    }

}
