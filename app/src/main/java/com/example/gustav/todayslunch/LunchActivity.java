package com.example.gustav.todayslunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class LunchActivity extends AppCompatActivity {
    ListView menu;

    private static Restaurant restaurant = null;
    private static FakeRestaurantStore fake;

    static{
        fake = FakeRestaurantStore.getInstance();
    }

    public static void setRestaurant(String name){
        restaurant = fake.getRestaurantInfo(name);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        TextView title=(TextView)findViewById(R.id.title);
        title.setText(restaurant.name());
        TextView info =(TextView)findViewById(R.id.info);
        info.setText(restaurant.address() + " " + restaurant.getTel());
        menu = (ListView) findViewById(R.id.menu);
        ArrayList<String> menuItems = convertRestaurantInfo();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,menuItems);
        menu.setAdapter(arrayAdapter);

    }

    private ArrayList<String> convertRestaurantInfo(){
        ArrayList<String> menuItems = new ArrayList<String>();
        ArrayList<LunchServing> weekMenu = restaurant.weekMenu();
        for(LunchServing l : weekMenu){
            String title = l.day() + " " + l.lunchHours();
            menuItems.add(title);
            ArrayList<Dish> lunchMenu = l.lunchMenu();
            for(Dish d : lunchMenu) {
                menuItems.add(d.toString());
            }
        }
        return menuItems;
    }
}
