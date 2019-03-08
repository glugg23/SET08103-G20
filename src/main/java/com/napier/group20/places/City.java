package com.napier.group20.places;

import com.napier.group20.utils.Population;

/**
 * City.java
 *
 * Stores information about a city including its name,
 * population and if it is the capital city.
 *
 */

public class City implements Population {

    private String name;
    private int population;
    private boolean isCapital;

    public City(String name, int population, boolean isCapital) {
        this.name = name;
        this.population = population;
        this.isCapital = isCapital;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return (long)population;
    }

    public boolean isCapital() {
        return isCapital;
    }

}
