package com.napier.group20.places;

import com.napier.group20.utils.Population;
import java.util.ArrayList;

/**
 * Region.java
 *
 * Stores information on Regions including name,
 * list of countries and population.
 *
 */

public class Region implements Population{
    //Instance variables
    private String name;
    private ArrayList<Country> countries;

    //Constructor
    public Region(String name, ArrayList<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    //Getters
    public String getName() { return name; }
    public ArrayList<Country> getCountries() { return countries; }

    public long getPopulation() {
        long regionPopulation = 0;
        for (Country country : countries) {
            regionPopulation += country.getPopulation();
        }
        return regionPopulation;
    }
}
