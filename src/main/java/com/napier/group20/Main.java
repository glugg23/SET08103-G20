package com.napier.group20;

import com.napier.group20.places.Country;
import com.napier.group20.utils.App;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.connect("db:3306", 10);

        app.loadDatabase();

        app.disconnect();

        ArrayList<Country> countriesInWorld = app.countriesInWorld();
        for(Country country : countriesInWorld) {
            System.out.println(country.toString());
        }
    }
}
