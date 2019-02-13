package com.napier.group20.places;

import com.napier.group20.utils.Population;

import java.util.ArrayList;

/**
 * Country.java
 *
 * Stores the country's attributes
 *
 */

public class Country implements Population {

    private String countryCode;
    private String name;
    private Continent continent;
    private Region region;
    private ArrayList<District> districts;
    private City capital;
    private ArrayList<Language> language;
    private long population;

    public String getCountryCode() {
        return countryCode;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    public Region getRegion() {
        return region;
    }

    public ArrayList<District> getDistricts() {
        return districts;
    }

    public City getCapital() {
        return capital;
    }

    public ArrayList<Language> getLanguage() {
        return language;
    }

    public long getPopulation() {
        return population;
    }

    public long getCitiesPopulation() {
        long countryPopulation = 0;
        for (District district : districts) {
            countryPopulation += district.getPopulation();
        }
        return countryPopulation;
    }


}
