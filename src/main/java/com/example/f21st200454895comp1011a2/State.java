package com.example.f21st200454895comp1011a2;
import com.google.gson.annotations.SerializedName;
public class State {
    @SerializedName("State")
    private String state;

    @SerializedName("Foreign-Born Citizens")
    private int foreignBornCitizens;

    @SerializedName("Population")
    private int population;

    @SerializedName("Household Income by Race")
    private int householdIncomeByRace;

    @SerializedName("Average Commute Time")
    private double averageCommuteTime;

    @SerializedName("Citizenship Status")
    private int citizenshipStatus;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getForeignBornCitizens() {
        return foreignBornCitizens;
    }

    public void setForeignBornCitizens(int foreignBornCitizens) {
        this.foreignBornCitizens = foreignBornCitizens;
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

    public String toString()
    {
        return String.format("%s - Population: %d",state,population);
    }
}
