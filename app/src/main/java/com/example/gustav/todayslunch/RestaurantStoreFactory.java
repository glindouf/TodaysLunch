package com.example.gustav.todayslunch;

/**
 * Created by ludvi on 24/11/2017.
 */

public class RestaurantStoreFactory {
    public static RestaurantStore getRestaurantStore(){
        return JsonRestaurantStore.getInstance();
    }
}
