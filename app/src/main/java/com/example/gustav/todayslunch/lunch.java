package com.example.gustav.todayslunch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;

public class lunch extends AppCompatActivity {
    ListView menu;
    String[] menuItems = {"Monday","Crabonara","Pannbiff","Diavola", "Butterfingers",
            "Tuesday", "Grillad fläskkarré","Husetsfiskgratäng", "Stektlax"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        TextView title=(TextView)findViewById(R.id.title);
        title.setText("Mimolett");
        TextView info =(TextView)findViewById(R.id.info);
        info.setText("Lindholmsallén 61         031-224466");



        menu = (ListView) findViewById(R.id.menu);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,menuItems);
        menu.setAdapter(arrayAdapter);

    }
}
