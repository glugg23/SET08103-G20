package com.napier.group20.places;

/**
 * City.java
 *
 * Stores information about a city including its name, country,
 * district, population and if it is the capital city.
 *
 */

public class City {

    private String name;
    private Country country;
    private District district;
    private int population;
    private boolean isCapital;

    public City() {

    }

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

    public int getPopulation() {
        return population;
    }

    public boolean isCapital() {
        return isCapital;
    }

}
