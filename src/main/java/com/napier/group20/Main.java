package com.napier.group20;

import com.napier.group20.places.City;
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

        ArrayList<City> citiesInWorld = app.citiesInWorld();
        for(City city : citiesInWorld) {
            System.out.println(city.toString());
        }

        ArrayList<City> capitalCitiesInWorld = app.capitalCitiesInWorld();
        for(City city : capitalCitiesInWorld) {
            System.out.println(city.toString());
        }

        long populationOfWorld = app.populationOfWorld();
        System.out.println(populationOfWorld);

        long populationOfCity = app.populationOfCity("Edinburgh");
        System.out.println(populationOfCity);

        long populationOfRegion = app.populationOfRegion("Asia", "Southern and Central Asia");
        System.out.println(populationOfRegion);

        long populationOfDistrict = app.populationOfDistrict("Argentina", "Buenos Aires");
        System.out.println(populationOfDistrict);
    }
}
