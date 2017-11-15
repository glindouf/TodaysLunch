package com.example.gustav.todayslunch;

import java.util.ArrayList;

/**
 * Created by Gustav on 2017-11-15.
 */

public class Restaurant {
    private String name;
    private String address;
    private String tel;
    private ArrayList<LunchServing> weekMenu;

    public Restaurant(String name, String adress, String tel, ArrayList<LunchServing> weekMenu){
        this.name = name;
        this.address = adress;
        this.tel = tel;
        this.weekMenu = weekMenu;
    }
    public String name() {
        return name;
    }

    public String address() {
        return address;
    }
    public String getTel(){
        return tel;
    }

    public ArrayList<LunchServing> weekMenu(){
        return weekMenu;
    }

}
