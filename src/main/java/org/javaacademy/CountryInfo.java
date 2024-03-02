package org.javaacademy;

public class CountryInfo {
    private final String countryName;
    private final String currencyName;

    public CountryInfo(String countryName, String currencyName) {
        this.countryName = countryName;
        this.currencyName = currencyName;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getCurrencyName() {
        return currencyName;
    }
}