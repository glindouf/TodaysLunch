package com.example.gustav.todayslunch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //private TextView mTextMessage;
    private ArrayList<Restaurant> restaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restaurants = RestaurantStoreFactory.getRestaurantStore(getApplicationContext()).getRestaurants();

        //mTextMessage = (TextView) findViewById(R.id.message);
        ImageButton mimolett = (ImageButton) findViewById(R.id.mimolett);
        mimolett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session.getInstance().currentRestaurant = Util.getRestaurantInfo("Mimolett",restaurants);
                System.out.println("Mimolett");
                System.out.println(Session.getInstance().currentRestaurant.name());
                Intent myIntent = new Intent(MainActivity.this, LunchActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

       /* ImageButton bistrot = (ImageButton) findViewById(R.id.bistrot);
        bistrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session.getInstance().currentRestaurant = Util.getRestaurantInfo("Bistrot",restaurants);
                /Intent myIntent = new Intent(MainActivity.this, LunchActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        ImageButton lsExpress = (ImageButton) findViewById(R.id.lsExpress);
        lsExpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session.getInstance().currentRestaurant = Util.getRestaurantInfo("L's Express",restaurants);
                Intent myIntent = new Intent(MainActivity.this, LunchActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        ImageButton matminnen = (ImageButton) findViewById(R.id.matminnen);
        matminnen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session.getInstance().currentRestaurant = Util.getRestaurantInfo("Matminnen",restaurants);;
                Intent myIntent = new Intent(MainActivity.this, LunchActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        }); */
    }

}
