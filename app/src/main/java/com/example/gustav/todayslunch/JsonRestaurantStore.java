package com.example.gustav.todayslunch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-30.
 */

public class JsonRestaurantStore implements RestaurantStore{

    private static String jsonString = "[ { \"name\":\"Mimolett\", \"address\":\"Lindholmsallen 61\", \"tel\":\"031-224466\", "+
    " \"lunchserving\" :[  { \"day\": \"onsdag\", \"lunchhours\": \"11.00-14.00\", " +
    " \"lunchmenu\": [ { \"name\": \"Carbonara\", \"price\": 99,  \"veg\": \"false\"  }, " +
            "             { \"name\": \"Diavola\", \"price\": 99, \"veg\": \"false\" } ] } ] }]    ";
    //, \n        { \n            \"name\": \"Bistrot\", \n                \"address\": \"\", \n                \"tel\": \"\", \n                \"lunchserving\": [ \n            { \n                \"day\": \"onsdag\", \n                    \"lunchhours\": \"11.00-13.30\", \"lunchmenu\": [  { \"name\": \"Högrevsgryta\",  \"price\": 90,   \"veg\": \"no\"   }, {    \"name\": \"Parmesanpanerad kålrot\",  \"price\": 90,   \"veg\": \"yes\"  } ]} ]  } ]}";
    private static JsonRestaurantStore jsonStore;
    static {
        jsonStore = new JsonRestaurantStore();
    }
    private JsonRestaurantStore(){};
    public String getRestaurantJSON() {

        return jsonString;
    }
    private ArrayList<Restaurant> parseRestaurants() throws JSONException{
        System.out.println("Parsing...");
//        final JSONObject obj = new JSONObject (jsonString);
//        final JSONArray restaurants = new JSONArray (jsonString);
//        final JSONArray restaurants = obj.getJSONArray("restaurants");
        final JSONArray restaurants = new JSONArray(jsonString); //obj.getJSONArray();
        final JSONObject mimolett = restaurants.getJSONObject(0);
        System.out.println("1: " + mimolett);
//        final JSONObject bistrot = restaurants.getJSONObject(1);
        final JSONArray lunchservingM = mimolett.getJSONArray("lunchserving");
//        final JSONArray lunchServingB = bistrot.getJSONArray("lunchServing");
        final JSONObject servingMimo = lunchservingM.getJSONObject(0);
        System.out.println("ServingMimo: " + servingMimo);
//        final JSONObject servingBistrot = lunchServingB.getJSONObject(1);
        final JSONArray dishesMimo = servingMimo.getJSONArray("lunchmenu");
        System.out.println("2");
///        final JSONArray dishesBistrot = servingBistrot.getJSONArray("lunchmenu");
        final JSONObject carbonara = dishesMimo.getJSONObject(0);
        final JSONObject diavola = dishesMimo.getJSONObject(1);
        System.out.println("3");

//        final JSONObject hogrevsgryta = dishesBistrot.getJSONObject(0);
  //      final JSONObject parmesanbaseradKalrot = dishesBistrot.getJSONObject(1);

        Dish carbonaraJava = new Dish(carbonara.getString("name"),carbonara.getInt("price"),carbonara.getBoolean("veg"));
        System.out.println(carbonara.get("name"));
        Dish diavolaJava = new Dish(diavola.getString("name"),diavola.getInt("price"),diavola.getBoolean("veg"));
//        Dish hogrevsgrytaJava = new Dish(hogrevsgryta.getString("name"),hogrevsgryta.getInt("price"),hogrevsgryta.getBoolean("veg"));
//        Dish parmesanbaseradKalrotJava = new Dish(parmesanbaseradKalrot.getString("name"),parmesanbaseradKalrot.getInt("price"),parmesanbaseradKalrot.getBoolean("veg"));
        ArrayList<Dish> mimoDishes =  new ArrayList<Dish>();
//        ArrayList<Dish> bistrotDishes =  new ArrayList<Dish>();
        mimoDishes.add(carbonaraJava);
        mimoDishes.add(diavolaJava);

//        bistrotDishes.add(hogrevsgrytaJava);

        LunchServing mimoServing = new LunchServing(servingMimo.getString("day"),servingMimo.getString("lunchhours"),mimoDishes);
//        LunchServing bistrotServing = new LunchServing(servingBistrot.getString("day"),servingBistrot.getString("lunchhours"),bistrotDishes);
        ArrayList<LunchServing> weekMenuMimo = new ArrayList<LunchServing>();
        ArrayList<LunchServing> weekMenuBistrot = new ArrayList<LunchServing>();
        weekMenuMimo.add(mimoServing);

        Restaurant mimolettJava = new Restaurant(mimolett.getString("name"),mimolett.getString("address"),mimolett.getString("tel"),weekMenuMimo);
//        Restaurant bistrotJava = new Restaurant(bistrot.getString("name"),bistrot.getString("address"),bistrot.getString("tel"),weekMenuBistrot);
        ArrayList<Restaurant> restaurantsJava = new ArrayList<>();
        restaurantsJava.add(mimolettJava);
//        restaurantsJava.add(bistrotJava);

        return restaurantsJava;

//        return null;
    }

    private ArrayList<Restaurant> parseRestaurants2() throws JSONException{
        System.out.println("Parsing...");
        ArrayList<Restaurant> jRestaurants = new ArrayList<>();
        final JSONArray restaurants = new JSONArray(jsonString); //obj.getJSONArray();
        for(int i = 0; i < restaurants.length();i++){
            JSONObject restaurant = restaurants.getJSONObject(i);
            JSONArray lunchservings = restaurant.getJSONArray("lunchserving");
            ArrayList<LunchServing> jLunchServings = new ArrayList<LunchServing>();
            for(int j = 0; i < lunchservings.length();i++){
                JSONObject lunchserving = lunchservings.getJSONObject(j);
                JSONArray dishes  = lunchserving.getJSONArray("lunchmenu");
                ArrayList<Dish> jDishes =  new ArrayList<Dish>();
                LunchServing jLunchServing = new LunchServing(lunchserving.getString("day"),lunchserving.getString("lunchhours"),jDishes);
                jLunchServings.add(jLunchServing);
                for(int k = 0; k < dishes.length();k++){
                    JSONObject dish = dishes.getJSONObject(k);
                    Dish jDish = new Dish(dish.getString("name"),dish.getInt("price"),dish.getBoolean("veg"));
                    jDishes.add(jDish);
                }

            }
            Restaurant jRestaurant = new Restaurant(restaurant.getString("name"),restaurant.getString("address"),restaurant.getString("tel"),jLunchServings);
            jRestaurants.add(jRestaurant);
        }
        return jRestaurants;
    }

    public ArrayList<Restaurant> getRestaurants(){
        System.out.println("Getting restaurants....");
        ArrayList<Restaurant> restaurants = null;
        try {
            restaurants = parseRestaurants2();
        } catch(JSONException e){
            e.printStackTrace();
            System.out.println(e);
            System.out.println("Error!!!!!!!!!!!");
        }
        return restaurants;
    }

    public static JsonRestaurantStore getInstance(){
        return jsonStore;
    }
}


