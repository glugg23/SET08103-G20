package com.napier.group20.places;

/**
 * Language.java
 *
 * Stores the language information of a country, including the
 * language name, the country code, what percentage of people speak it
 * and if it is the official language
 *
 */

public class Language {

    private String languageName;
    private String countryCode;
    private double percentage;
    private boolean isOfficial;

    public Language(String languageName, String countryCode, double percentage, boolean isOfficial) {
        this.languageName = languageName;
        this.countryCode = countryCode;
        this.percentage = percentage;
        this.isOfficial = isOfficial;
    }

    public String getLanguageName() {
        return languageName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public double getPercentage() {
        return percentage;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Double.compare(language.getPercentage(), getPercentage()) == 0 &&
                isOfficial() == language.isOfficial() &&
                getLanguageName().equals(language.getLanguageName()) &&
                getCountryCode().equals(language.getCountryCode());
    }
}
