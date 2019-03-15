package com.napier.group20.places;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegionTest {

    @Test
    void getName() {
        //Arrange
        Region region = new Region("Region", null);

        //Assert
        assertEquals("Region", region.getName());
    }

    @Test
    void getCountries() { // Arrange
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("ABC", "Country1", null, null, null, 1, null, null));
        countries.add(new Country("DEF", "Country2", null, null, null, 2, null, null));
        countries.add(new Country("GHI", "Country3", null, null, null, 3, null, null));

        Region region = new Region("Region", countries);

        // Assert
        assertEquals(countries, region.getCountries());
    }

    @Test
    void getPopulation() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("ABC", "Country1", null, null, null, 1, null, null));
        countries.add(new Country("DEF", "Country2", null, null, null, 2, null, null));
        countries.add(new Country("GHI", "Country3", null, null, null, 3, null, null));

        Region region = new Region("Region", countries);

        // Assert
        assertEquals(6, region.getPopulation());
    }
}