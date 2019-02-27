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
        regions.add(new Region("Region1", null, 1));
        regions.add(new Region("Region2", null, 2));
        regions.add(new Region("Region3", null, 3));

        Continent continent = new Continent("Continent", regions);

        // Assert
        assertEquals(regions, continent.getRegions());
    }

    @Test
    void getPopulation() {
        // Arrange
        ArrayList<Region> regions = new ArrayList<>();
        regions.add(new Region("Region1", null, 1));
        regions.add(new Region("Region2", null, 2));
        regions.add(new Region("Region3", null, 3));

        Continent continent = new Continent("Continent", regions);

        assertEquals(6, continent.getPopulation());
    }
}