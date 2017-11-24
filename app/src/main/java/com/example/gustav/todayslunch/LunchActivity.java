package com.example.gustav.todayslunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class LunchActivity extends AppCompatActivity {
    ListView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Restaurant restaurant = Session.getInstance().currentRestaurant;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        TextView title=(TextView)findViewById(R.id.title);
        title.setText(restaurant.name());
        TextView info =(TextView)findViewById(R.id.info);
        info.setText(restaurant.address() + " " + restaurant.getTel());
        menu = (ListView) findViewById(R.id.menu);
        ArrayList<String> menuItems = Util.convertRestaurantInfo(restaurant);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,menuItems);
        menu.setAdapter(arrayAdapter);

    }


}
