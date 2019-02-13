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

    //Constructor
    public Continent(String name, ArrayList<Region> regions) {
        this.name = name;
        this.regions = regions;
    }

    //Getters
    public String getName() { return name; }
    public ArrayList<Region> getRegions() { return regions; }

    public long getPopulation() {
        long continentPopulation = 0;
        for (Region region : regions) {
            continentPopulation += region.getPopulation();
        }
        return continentPopulation;
    }
}
