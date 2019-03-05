package com.napier.group20.places;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageTest {

    @Test
    void getLanguageName() {
        //Arrange
        Language language = new Language("Language", "ABC", 99.9, true);

        //Assert
        assertEquals("Language", language.getLanguageName());
    }

    @Test
    void getCountryCode() {
        //Arrange
        Language language = new Language("Language", "ABC", 99.9, true);

        //Assert
        assertEquals("ABC", language.getCountryCode());
    }

    @Test
    void getPercentage() {
        //Arrange
        Language language = new Language("Language", "ABC", 99.9, true);

        //Assert
        assertEquals(99.9, language.getPercentage());
    }

    @Test
    void isOfficial() {
        //Arrange
        Language language = new Language("Language", "ABC", 99.9, true);

        //Assert
        assertTrue(language.isOfficial());
    }

    @Test
    void equals() {
        //Arrange
        Language language1 = new Language("Language", "ABC", 99.9, true);
        Language language2 = new Language("Language", "ABC", 99.9, true);

        //Assert
        assertEquals(language1, language2);
    }
}
