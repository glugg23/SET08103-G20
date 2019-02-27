package com.napier.group20.places;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    @Test
    void getContinents() {
        // Arrange
        ArrayList<Continent> continents = new ArrayList<>();
        continents.add(new Continent("Continent1", null));
        continents.add(new Continent("Continent2", null));
        continents.add(new Continent("Continent3", null));

        World world = World.getInstance();
        world.setContinents(continents);

        // Assert
        assertEquals(continents, world.getContinents());
    }

    @Test
    void getPopulation() {
        // Arrange
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("ABC", "Country1", null, null, null,
                12345));
        countries.add(new Country("DEF", "Country2", null, null, null,
                12345));

        ArrayList<Region> regions = new ArrayList<>();
        regions.add(new Region("Region", countries));

        ArrayList<Continent> continents = new ArrayList<>();
        continents.add(new Continent("Continent", regions));

        World world = World.getInstance();
        world.setContinents(continents);

        // Assert
        assertEquals(12345*2, world.getPopulation());
    }
}
