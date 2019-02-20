package com.napier.group20.places;

import com.napier.group20.utils.Population;

import java.util.ArrayList;

/**
 * District.java
 *
 * Stores the attributes of , including the
 * language name, the country code, what percentage of people speak it
 * and if it is the official language
 *
 */

public class District implements Population {

    private String name;
    private ArrayList<City> cities;

    public District(String name, ArrayList<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public long getPopulation() {
        long districtPopulation = 0;
        for (City city : cities) {
            districtPopulation += city.getPopulation();
        }
        return districtPopulation;
    }
}
