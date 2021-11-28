package com.example.f21st200454895comp1011a2.Models;

import com.google.gson.annotations.SerializedName;

public class StateDetails {

    @SerializedName("Year")
    private String year;

    @SerializedName("Foreign-Born Citizens")
    private int foreignBornCitizens;

    @SerializedName("Geography")
    private String geography;

    @SerializedName("ID Geography")
    private String idGeography;

    @SerializedName("Population")
    private int population;

    @SerializedName("Household Income by Race")
    private int householdIncomeByRace;

    @SerializedName("Average Commute Time")
    private double averageCommuteTime;

    @SerializedName("Citizenship Status")
    private int citizenshipStatus;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getForeignBornCitizens() {
        return foreignBornCitizens;
    }

    public void setForeignBornCitizens(int foreignBornCitizens) {
        this.foreignBornCitizens = foreignBornCitizens;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    public String getIdGeography() {
        return idGeography;
    }

    public void setIdGeography(String idGeography) {
        this.idGeography = idGeography;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getHouseholdIncomeByRace() {
        return householdIncomeByRace;
    }

    public void setHouseholdIncomeByRace(int householdIncomeByRace) {
        this.householdIncomeByRace = householdIncomeByRace;
    }

    public double getAverageCommuteTime() {
        return averageCommuteTime;
    }

    public void setAverageCommuteTime(double averageCommuteTime) {
        this.averageCommuteTime = averageCommuteTime;
    }

    public int getCitizenshipStatus() {
        return citizenshipStatus;
    }

    public void setCitizenshipStatus(int citizenshipStatus) {
        this.citizenshipStatus = citizenshipStatus;
    }

}
