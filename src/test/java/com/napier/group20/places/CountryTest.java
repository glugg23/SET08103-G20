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
        assertEquals(districts, country.getDistricts());
    }

    @Test
    void getPopulation() {
        // Arrange
        Country country = new Country("ABC", "Country", null, null, null,
                null, null, 12345);

        assertEquals(12345, country.getPopulation());
    }

    @Test
    void getCitiesPopulation() {
        // Arrange
        ArrayList<City> cities1 = new ArrayList<>();
        cities1.add(new City("City1", null, null, 100,true));
        cities1.add(new City("City2", null, null, 50,false));

        ArrayList<City> cities2 = new ArrayList<>();
        cities2.add(new City("City3", null, null, 100,false));
        cities2.add(new City("City4", null, null, 50,false));

        ArrayList<District> districts = new ArrayList<>();
        districts.add(new District("District1", cities1));
        districts.add(new District("District2", cities2));

        Country country = new Country("ABC", "Country", null, null, districts,
                null, null, 12345);

        assertEquals(300, country.getCitiesPopulation());
    }

    @Test
    void getCapital() {
        // Arrange
        City capital = new City("City1", null, null, 100,true);

        Country country = new Country("ABC", "Country", null, null, null,
                capital, null, 12345);

        // Assert
        assertEquals(capital, country.getCapital());
    }

    @Test
    void getLanguages() {
        // Arrange
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(new Language("Language1", "ABC", 20.5, true));
        languages.add(new Language("Language2", "ABC", 39.5, true));
        languages.add(new Language("Language3", "ABC", 40, false));


        Country country = new Country("ABC", "Country", null, null, null,
                null, languages, 12345);

        // Assert
        assertEquals(languages, country.getLanguages());
    }

    @Test
    void getOfficialLanguages() {
        // Arrange
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(new Language("Language1", "ABC", 20.5, true));
        languages.add(new Language("Language2", "ABC", 39.5, true));
        languages.add(new Language("Language3", "ABC", 40, false));

        ArrayList<Language> expected = new ArrayList<>();
        expected.add(new Language("Language1", "ABC", 20.5, true));
        expected.add(new Language("Language2", "ABC", 39.5, true));

        Country country = new Country("ABC", "Country", null, null, null,
                null, languages, 12345);

        // Assert
        assertEquals(expected, country.getOfficialLanguages());
    }

    @Test
    void getEmptyOfficialLanguages() {
        // Arrange
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(new Language("Language1", "ABC", 20.5, false));
        languages.add(new Language("Language2", "ABC", 39.5, false));
        languages.add(new Language("Language3", "ABC", 40, false));

        Country country = new Country("ABC", "Country", null, null, null,
                null, languages, 12345);

        // Assert
        assertNull(country.getOfficialLanguages());
    }
}
