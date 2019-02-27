package com.napier.group20.places;

import com.napier.group20.utils.Population;

import java.util.ArrayList;

/**
 * World.java
 *
 * Stores the attributes of the world
 *
 */

public class World implements Population {

    private World() {}

    private static World instance = null;

    public static World getInstance() {
        if (instance  == null) {
            instance = new World();
        }
        return instance;
    }

    private ArrayList<Continent> continents;

    public ArrayList<Continent> getContinents() {
        return continents;
    }

    public long getPopulation() {
        long worldPopulation = 0;
        for (Continent continent : continents) {
            worldPopulation += continent.getPopulation();
        }
        return worldPopulation;
    }

}
