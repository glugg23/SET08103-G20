package com.napier.group20.places;

import org.junit.jupiter.api.Test;
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

    }

    @Test
    void getContinent() {

    }

    @Test
    void getRegion() {

    }

    @Test
    void getDistricts() {

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
