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

    private ArrayList<Continent> continents;

    public ArrayList<Continent> getContinents() {
        return continents;
    }

    public long getPopulation() {
        return 0;
    }

}
