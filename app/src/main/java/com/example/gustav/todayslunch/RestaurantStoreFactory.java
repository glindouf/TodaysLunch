package com.example.gustav.todayslunch;

import android.content.Context;

/**
 * Created by ludvi on 24/11/2017.
 */

public class RestaurantStoreFactory {
    public static RestaurantStore getRestaurantStore(Context c){
        return JsonRestaurantStore.getInstance(c);
    }
}
