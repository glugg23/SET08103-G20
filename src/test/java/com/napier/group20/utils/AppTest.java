package com.napier.group20.utils;

import com.napier.group20.places.City;
import com.napier.group20.places.Country;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:3306", 1); //This needs to be localhost and not db for some reason
        app.loadDatabase();
        app.disconnect();
    }

    @Test
    void countriesInWorld() {
        //Arrange
        String first = "Country{countryCode='CHN', name='China', continent='Asia', region='Eastern Asia', population=1277558000, capital=City{name='Peking', population=7472000, country='China', district='Peking'}}";
        String last = "Country{countryCode='SGS', name='South Georgia and the South Sandwich Islands', continent='Antarctica', region='Antarctica', population=0, capital=null}";

        //Act
        ArrayList<Country> actual = app.countriesInWorld();

        //Assert
        assertEquals(239, actual.size());
        assertEquals(first, actual.get(0).toString());
        assertEquals(last, actual.get(238).toString());
    }

    @Test
    void citiesInWorld() {
        //Arrange
        String first = "City{name='Mumbai (Bombay)', population=10500000, country='India', district='Maharashtra'}";
        String last = "City{name='Adamstown', population=42, country='Pitcairn', district='None'}";

        //Act
        ArrayList<City> actual = app.citiesInWorld();

        //Assert
        assertEquals(4079, actual.size());
        assertEquals(first, actual.get(0).toString());
        assertEquals(last, actual.get(4078).toString());
    }
}
