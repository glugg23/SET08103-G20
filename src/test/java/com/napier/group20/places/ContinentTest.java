package com.napier.group20.places;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContinentTest {

    @Test
    void getName() {
        //Arrange
        Continent continent = new Continent("Continent", null);

        //Assert
        assertEquals("Continent", continent.getName());
    }

    @Test
    void getRegions() {
        // Arrange
        ArrayList<Region> regions = new ArrayList<>();
        regions.add(new Region("Region1", null));
        regions.add(new Region("Region2", null));
        regions.add(new Region("Region3", null));

        Continent continent = new Continent("Continent", regions);

        // Assert
        assertEquals(regions, continent.getRegions());
    }

    @Test
    void getPopulation() {
        // Arrange
        ArrayList<Region> regions = new ArrayList<>();

        ArrayList<Country> countries = new ArrayList<>();

        countries.add(new Country(null, null, null, null, null, 1));
        countries.add(new Country(null, null, null, null, null, 2));
        countries.add(new Country(null, null, null, null, null, 3));


        regions.add(new Region("Region1", countries));
        regions.add(new Region("Region2", countries));
        regions.add(new Region("Region3", countries));

        Continent continent = new Continent("Continent", regions);

        assertEquals(18, continent.getPopulation());
    }
}