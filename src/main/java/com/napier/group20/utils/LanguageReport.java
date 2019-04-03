package com.napier.group20.utils;

public class LanguageReport {
    private String countryCode;
    private long countryPopulation;
    private String languageName;
    private double languagePercentage;

    public LanguageReport(String countryCode, long countryPopulation, String languageName, double languagePercentage) {
        this.countryCode = countryCode;
        this.countryPopulation = countryPopulation;
        this.languageName = languageName;
        this.languagePercentage = languagePercentage;
    }

    private long convertPercentage(long population, double percentage) {
        return (long) (population / percentage);
    }
}
