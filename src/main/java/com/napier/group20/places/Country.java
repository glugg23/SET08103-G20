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
    private ArrayList<Language> languages;
    private long population;

    public Country(String countryCode, String name, Continent continent, Region region, ArrayList<District> districts,
                   City capital, ArrayList<Language> languages, long population) {
        this.countryCode = countryCode;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.districts = districts;
        this.capital = capital;
        this.languages = languages;
        this.population = population;
    }

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

    public ArrayList<Language> getLanguages() {
        return languages;
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
