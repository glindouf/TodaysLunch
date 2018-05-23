package com.example.gustav.todayslunch;

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
import java.util.HashMap;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-30.
 */

public class JsonRestaurantStore implements RestaurantStore{

    private static final String LOG_TAG = JsonRestaurantStore.class.getCanonicalName();
    private String jsonURL = "https://raw.githubusercontent.com/Farrigan/todayslunch-data/master/rest.json";
    private HashMap<String, Restaurant> jRestaurants = new HashMap<String,Restaurant>();
    // HashMap<Integer, String> hmap = new HashMap<Integer, String>();

    private static JsonRestaurantStore jsonStore;
    private Context context;
    private JsonRestaurantStore(Context c){
        Log.d(LOG_TAG, "got context: " + c );
        this.context = c;
        Log.d(LOG_TAG, "got context: " + context );
    };

    private HashMap<String, Restaurant> parseRestaurants(JSONArray restaurants) throws JSONException{ //ändra till hashmap
        HashMap<String, Restaurant> restMap = new HashMap<String,Restaurant>();
        Log.d(LOG_TAG, "Parsing...  rests: " + restaurants.length());
        for(int i = 0; i < restaurants.length();i++){
            Log.d(LOG_TAG, "Från parsening " + i);
            JSONObject restaurant = restaurants.getJSONObject(i);
            JSONArray dishes  = restaurant.getJSONArray("lunchmenu");
            ArrayList<Dish> jDishes =  new ArrayList<Dish>();
            for(int j = 0; j < dishes.length();j++){
                JSONObject dish = dishes.getJSONObject(j);
                Dish jDish = new Dish(dish.getString("name"),dish.getInt("price"),dish.getString("dishtype"));
                jDishes.add(jDish);
            }
            Restaurant jRestaurant = new Restaurant(restaurant.getString("name"),restaurant.getString("address"),restaurant.getString("tel"),
                                                    restaurant.getString("lunchhours"),jDishes);
            Log.d(LOG_TAG, " restaurant: " + jRestaurant);
            jRestaurants.put(jRestaurant.name(),jRestaurant);
            Log.d(LOG_TAG, " restaurants size: " + jRestaurants.size() + "  i: " + i);

        }
        return restMap;
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
    public HashMap<String, Restaurant> getRestaurants() { //ändra till hashmap

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
                            jRestaurants = parseRestaurants(array); //ta bort tvåan
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
