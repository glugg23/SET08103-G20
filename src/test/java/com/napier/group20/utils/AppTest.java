package com.napier.group20.utils;

import com.napier.group20.places.City;
import com.napier.group20.places.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    private static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:3306", 1); //This needs to be localhost and not db for some reason
        app.loadDatabase();
        app.disconnect();
    }

    @Test
    void countriesInWorld() {
        //Act
        ArrayList<Country> actual = app.countriesInWorld();

        //Assert
        StringBuilder hashBuffer = new StringBuilder();
        for(Country country : actual) {
            hashBuffer.append(country.toString());
        }

        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.update(hashBuffer.toString().getBytes(StandardCharsets.UTF_8));
            sha1 = Base64.getEncoder().encodeToString(crypt.digest());
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        assertEquals(239, actual.size());
        assertEquals("8/o7+3uFB368QRAhQIW5SAtTv3c=", sha1);
    }

    @Test
    void citiesInWorld() {
        //Act
        ArrayList<City> actual = app.citiesInWorld();

        //Assert
        StringBuilder hashBuffer = new StringBuilder();
        for(City city : actual) {
            hashBuffer.append(city.toString());
        }

        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.update(hashBuffer.toString().getBytes(StandardCharsets.UTF_8));
            sha1 = Base64.getEncoder().encodeToString(crypt.digest());
        } catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        assertEquals(4079, actual.size());
        assertEquals("UU7JcDurNp+9OTIUDyWE8WBGKY0=", sha1);
    }

    @Test
    void populationOfCity() {
        //Arrange
        long expected = 450180;

        //Act
        long actual = app.populationOfCity("Edinburgh");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfCityNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = app.populationOfCity("Does not exist");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfRegion() {
        //Arrange
        long expected = 1490776000;

        //Act
        long actual = app.populationOfRegion("Asia", "Southern and Central Asia");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfRegionNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = app.populationOfRegion("Does not exist", "Does not exist");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfDistrict() {
        //Arrange
        long expected = 10530136;

        //Act
        long actual = app.populationOfDistrict("Argentina", "Buenos Aires");

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void populationOfDistrictNotFound() {
        //Arrange
        long expected = -1;

        //Act
        long actual = app.populationOfDistrict("Does not exist", "Does not exist");

        //Assert
        assertEquals(expected, actual);
    }
}
