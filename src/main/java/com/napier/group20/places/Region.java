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
    private long population;

    //Constructor
    public Region(String name, ArrayList<Country> countries, long population)
    {
        this.name = name;
        this.countries = countries;
        this.population = population;
    }

    //Getters
    public String getName() { return name; }
    public ArrayList<Country> getCountries() { return countries; }
    public long getPopulation() { return population; }
}
