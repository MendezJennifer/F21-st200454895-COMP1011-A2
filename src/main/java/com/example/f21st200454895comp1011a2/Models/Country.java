package com.example.f21st200454895comp1011a2.Models;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("Year")
    private String year;

    @SerializedName("Population")
    private String population;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String toString()
    {
        return String.format("%,d",Integer.valueOf(population));
    }
}
