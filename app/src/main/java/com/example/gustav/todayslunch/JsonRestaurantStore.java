package com.example.gustav.todayslunch;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-30.
 */

public class JsonRestaurantStore implements RestaurantStore{

    private static final String LOG_TAG = JsonRestaurantStore.class.getCanonicalName();
    private String jsonURL = "https://raw.githubusercontent.com/glindouf/todayslunch-data/master/lunch.json";
    private ArrayList<Restaurant> jRestaurants = new ArrayList<>();

    private static String jsonString = "[ { \"name\":\"Mimolett\", \"address\":\"Lindholmsallen 61\", \"tel\":\"031-224466\", "+
    " \"lunchserving\" :[  { \"day\": \"onsdag\", \"lunchhours\": \"11.00-14.00\", " +
    " \"lunchmenu\": [ { \"name\": \"Carbonara\", \"price\": 99,  \"dishtype\": \"pasta\"  }, " +
            "             { \"name\": \"Diavola\", \"price\": 99, \"dishtype\": \"pasta\" } ] } ] }]    ";
    //, \n        { \n            \"name\": \"Bistrot\", \n                \"address\": \"\", \n                \"tel\": \"\", \n                \"lunchserving\": [ \n            { \n                \"day\": \"onsdag\", \n                    \"lunchhours\": \"11.00-13.30\", \"lunchmenu\": [  { \"name\": \"Högrevsgryta\",  \"price\": 90,   \"veg\": \"no\"   }, {    \"name\": \"Parmesanpanerad kålrot\",  \"price\": 90,   \"veg\": \"yes\"  } ]} ]  } ]}";
    private static JsonRestaurantStore jsonStore;
    private Context context;
    private JsonRestaurantStore(Context c){
        Log.d(LOG_TAG, "got context: " + c );
        this.context = c;
        Log.d(LOG_TAG, "got context: " + context );
    };
    public String getRestaurantJSON() {

        return jsonString;
    }

    private ArrayList<Restaurant> parseRestaurants2(JSONArray restaurants) throws JSONException{
        Log.d(LOG_TAG, "Parsing...  rests: " + restaurants.length());
        for(int i = 0; i < restaurants.length();i++){
            Log.d(LOG_TAG, "Från parsening " + i);
            JSONObject restaurant = restaurants.getJSONObject(i);
            JSONArray dishes  = restaurant.getJSONArray("lunchmenu");
            ArrayList<Dish> jDishes =  new ArrayList<Dish>();
            for(int j = 0; j < dishes.length();j++){
                JSONObject dish = dishes.getJSONObject(j);
                Dish jDish = new Dish(dish.getString("name"),dish.getInt("price"),dish.getBoolean("veg"));
                jDishes.add(jDish);
            }
            Restaurant jRestaurant = new Restaurant(restaurant.getString("name"),restaurant.getString("address"),restaurant.getString("tel"),
                                                    restaurant.getString("day"),restaurant.getString("lunchhours"),jDishes);
            Log.d(LOG_TAG, " restaurant: " + jRestaurant);
            jRestaurants.add(jRestaurant);
            Log.d(LOG_TAG, " restaurants size: " + jRestaurants.size() + "  i: " + i);

        }
        return jRestaurants;
    }

   /* public ArrayList<Restaurant> getRestaurants(){
        System.out.println("Getting restaurants....");
        setJson();  // fetches JSON from github
        try {
            setJson();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Error!!!!!!!!!!!");
        }
        return jRestaurants;
    }*/

    // The code below is "slightly" (nudge nudge) based on:
    //   https://developer.android.com/training/volley/request.html
    public ArrayList<Restaurant> getRestaurants() {

        Log.d(LOG_TAG, "got context????: " + context );
        Log.d(LOG_TAG, "got context????: " + context.getCacheDir() );
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                jsonURL,
                null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray array) {
                        Log.d(LOG_TAG, "hurra, .... " + array );
                        try {
                            jRestaurants = parseRestaurants2(array);
                        }catch (JSONException e){
                            System.out.println(e);
                        }
                        /*
                        members = jsonToMembers(array);
                        resetListView();
                        ActivitySwitcher.showToast(me, "Members updated");
                        */
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(LOG_TAG, " cause: " + error.getCause().getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
        return jRestaurants;
    }

    public static JsonRestaurantStore getInstance(Context c){
        Log.d(LOG_TAG, "got context: " + c );
        jsonStore = new JsonRestaurantStore(c);
        return jsonStore;
    }
}
