package com.example.gustav.todayslunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class lunch extends AppCompatActivity {
    ListView menu;
    String[] menuItems = {"Crabonara","Pannbiff","Diavola"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        TextView t=(TextView)findViewById(R.id.title);
        t.setText("Mimolett");
        menu = (ListView) findViewById(R.id.menu);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,menuItems);
        menu.setAdapter(arrayAdapter);

    }
}
