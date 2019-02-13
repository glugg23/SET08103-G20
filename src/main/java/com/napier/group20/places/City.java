package com.napier.group20.places;

import com.napier.group20.utils.Population;

/**
 * City.java
 *
 * Stores information about a city including its name, country,
 * district, population and if it is the capital city.
 *
 */

public class City implements Population {

    private String name;
    private Country country;
    private District district;
    private int population;
    private boolean isCapital;

    public City(String name, Country country, District district, int population, boolean isCapital) {
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public District getDistrict() {
        return district;
    }

    public long getPopulation() {
        return (long)population;
    }

    public boolean isCapital() {
        return isCapital;
    }

}
