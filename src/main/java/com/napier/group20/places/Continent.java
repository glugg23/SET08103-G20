package com.napier.group20.places;

import com.napier.group20.utils.Population;
import java.util.ArrayList;

/**
 * Continent.java
 *
 * Stores information on continents including name,
 * list of regions and the population
 *
 */

public class Continent implements Population{
    //Instance variables
    private String name;
    private ArrayList<Region> regions;
    private long population;

    //Constructor
    public Continent(String name, ArrayList<Region> regions, long population) {
        this.name = name;
        this.regions = regions;
        this.population = population;
    }

    //Getters
    public String getName() { return name; }
    public ArrayList<Region> getRegions() { return regions; }
    public long getPopulation() { return population; }
}
