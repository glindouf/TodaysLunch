package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-15.
 */

public class FakeRestaurantStore implements RestaurantStore {
    private static FakeRestaurantStore fake;
    private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

    static {
        fake = new FakeRestaurantStore();

        ArrayList<Dish> mimolettDishes = new ArrayList<Dish>();
        mimolettDishes.add(new Dish("Diavola",99,false));
        mimolettDishes.add(new Dish("Carbonara",99,false));
        ArrayList<LunchServing> mimolettServings = new ArrayList<LunchServing>();
        mimolettServings.add(new LunchServing("Monday","11:00-14:00",mimolettDishes));
        mimolettServings.add(new LunchServing("Tuesday","11:00-14:00",mimolettDishes));
        fake.restaurants.add(new Restaurant("Mimolett","Lindholmenvägen 46", "031224466",mimolettServings));

        ArrayList<Dish> bistroDishes = new ArrayList<Dish>();
        bistroDishes.add(new Dish("Högrevsgryta a la Fredrik",90,false));
        bistroDishes.add(new Dish("Permesanpanerad kålrot",90,true));
        ArrayList<LunchServing> bistroServings= new ArrayList<LunchServing>();
        bistroServings.add(new LunchServing("Monday","11:00-14:00",bistroDishes));
        bistroServings.add(new LunchServing("Tuesday","11:00-14:00",bistroDishes));
        fake.restaurants.add(new Restaurant("Bistrot","Diagonalen 8", "031223323",bistroServings ));

        ArrayList<Dish> lsDishes = new ArrayList<Dish>();
        lsDishes.add(new Dish("Ceasar Sallad",80,false));
        lsDishes.add(new Dish("Pasta Gratäng",80,true));
        ArrayList<LunchServing> lsServings= new ArrayList<LunchServing>();
        lsServings.add(new LunchServing("Monday","11:00-14:00",lsDishes));
        lsServings.add(new LunchServing("Tuesday","11:00-14:00",lsDishes));
        fake.restaurants.add(new Restaurant("L's Express","Lindholmspiren 5", "0317723950",lsServings ));

        ArrayList<Dish> matminnenDishes = new ArrayList<Dish>();
        matminnenDishes.add(new Dish("Långbakad fläskkarré",83,false));
        matminnenDishes.add(new Dish("Blomkålssoppa",83,true));
        ArrayList<LunchServing> matminnenServings= new ArrayList<LunchServing>();
        matminnenServings.add(new LunchServing("Monday","11:00-13:30",matminnenDishes));
        matminnenServings.add(new LunchServing("Tuesday","11:00-13:30",matminnenDishes));
        fake.restaurants.add(new Restaurant("Matminnen","Lindholmsallén 2", "07256357533",matminnenServings ));

    }

    public static FakeRestaurantStore  getInstance(){
        return fake;
    }

    public ArrayList<Restaurant> getRestaurants(){
        return restaurants;
    }


}
