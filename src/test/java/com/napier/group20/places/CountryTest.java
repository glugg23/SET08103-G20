package com.napier.group20.places;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    @Test
    void getCountryCode() {
        // Arrange
        Country country = new Country("ABC", "Country", null, null, null,
                null, null, 12345);

        // Assert
        assertEquals("ABC", country.getCountryCode());
    }

    @Test
    void getName() {
        // Arrange
        Country country = new Country("ABC", "Country", null, null, null,
                null, null, 12345);

        // Assert
        assertEquals("Country", country.getName());
    }

    @Test
    void getContinent() {
        // Arrange
        Continent continent = new Continent("Continent", null);

        Country country = new Country("ABC", "Country", continent, null, null,
                null, null, 12345);

        // Assert
        assertEquals(continent, country.getContinent());
    }

    @Test
    void getRegion() {
        // Arrange
        Region region = new Region("Region", null, 12345);
        Country country = new Country("ABC", "Country", null, region, null,
                null, null, 12345);

        // Assert
        assertEquals(region, country.getRegion());
    }

    @Test
    void getDistricts() {
        // Arrange
        ArrayList<District> districts = new ArrayList<>();
        districts.add(new District("District1", null));
        districts.add(new District("District2", null));
        districts.add(new District("District3", null));

        Country country = new Country("ABC", "Country", null, null, districts,
                null, null, 12345);

        // Assert
        assertNotNull(country.getDistricts(), "Districts retrieved successfully");
    }

    @Test
    void getPopulation() {

    }

    @Test
    void getCapital() {

    }

    @Test
    void getOfficialLanguage() {

    }
}
