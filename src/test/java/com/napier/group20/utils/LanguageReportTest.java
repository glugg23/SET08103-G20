package com.napier.group20.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageReportTest {

    @Test
    void getLanguageName() {
        //Arrange
        LanguageReport report = new LanguageReport("Language");

        //Assert
        assertEquals("Language", report.getLanguageName());
    }

    @Test
    void addSpeakerPopulation() {
        //Arrange
        LanguageReport report = new LanguageReport("Language");

        //Act
        report.addSpeakerPopulation(100);

        //Assert
        assertEquals(100, report.getSpeakerPopulation());
    }

    @Test
    void calculateWorldPercentage() {
        //Arrange
        LanguageReport report = new LanguageReport("Language");
        report.addSpeakerPopulation(100);

        //Act
        report.calculateWorldPercentage(200);

        //Assert
        assertEquals(50.0, report.getWorldPercentage());
    }

    @Test
    void toStringTest() {
        //Arrange
        String expected = "LanguageReport{languageName='Language', speakerPopulation=100, worldPercentage=50.00%}";
        LanguageReport report = new LanguageReport("Language");
        report.addSpeakerPopulation(100);
        report.calculateWorldPercentage(200);

        //Assert
        assertEquals(expected, report.toString());
    }
}