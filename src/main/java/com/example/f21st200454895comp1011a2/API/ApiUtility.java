package com.example.f21st200454895comp1011a2.API;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiUtility {

    /**
     * Method that reads the "jsonData.json" file (in the root directory) and creates an ApiResponse object
     */
    public static ApiResponseAllStates getStatesJsonFile()
    {
        Gson gson = new Gson();
        ApiResponseAllStates response = null;

        try(
                FileReader fileReader = new FileReader("jsonDataResponse.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            response = gson.fromJson(jsonReader, ApiResponseAllStates.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * Method that calls the US Data API, will display State name and population
     * Will store the API Response to a String and then create objects
     */
    public static ApiResponseAllStates getStatesFromDataUsa() throws IOException, InterruptedException {

        String uri="https://datausa.io/api/data?drilldowns=State&measures=Foreign-Born%20Citizens,Population,Household%20Income%20by%20Race,Average%20Commute%20Time,Citizenship%20Status";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

/*
        //Send the API results to a file (jsonDataResponse.json)
        HttpResponse<Path> response = client.send(httpRequest, HttpResponse.BodyHandlers
                                                    .ofFile(Paths.get("jsonDataResponse.json")));


        return getStatesJsonFile();
*/


        //Store the API response to a String and then use it to create objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString =response.body();

        Gson gson = new Gson();
        ApiResponseAllStates apiResponseAllStates = null;

        try{
            apiResponseAllStates = gson.fromJson(jsonString, ApiResponseAllStates.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponseAllStates;
   }

    /**
     * Method that calls the US Data Api, will display details for the selected state
     * Will store the API Response to a String and then create objects
     */
    public static ApiResponseStateDetails getStateDetails(String idGeography) throws IOException, InterruptedException {

        String uri="https://datausa.io/api/data?&measures=Foreign-Born%20Citizens,Population,Household%20Income%20by%20Race,Average%20Commute%20Time,Citizenship%20Status&year=latest&Geography="+idGeography;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
/*
        //Send the API results to a file (jsonDataResponse.json)
        HttpResponse<Path> response = client.send(httpRequest, HttpResponse.BodyHandlers
                                                    .ofFile(Paths.get("jsonDataResponse.json")));


        return getStatesJsonFile();
*/
        //Store the API response to a String and then use it to create objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString =response.body();

        Gson gson = new Gson();
        ApiResponseStateDetails apiResponse = null;

        try{
            apiResponse  = gson.fromJson(jsonString, ApiResponseStateDetails.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;

    }

    /**
     * Method that calls the US Data Api, will display the total population of the country
     * Will store the API Response to a String and then create objects
     */
    public static ApiResponseCountry getCountryFromDataUsa() throws IOException, InterruptedException {

        String uri="https://datausa.io/api/data?&measures=Population&year=latest";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();
/*
        //Send the API results to a file (jsonDataResponse.json)
        HttpResponse<Path> response = client.send(httpRequest, HttpResponse.BodyHandlers
                                                    .ofFile(Paths.get("jsonDataResponse.json")));


        return getStatesJsonFile();
*/
        //Store the API response to a String and then use it to create objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString =response.body();

        Gson gson = new Gson();
        ApiResponseCountry apiResponse = null;

        try{
            apiResponse  = gson.fromJson(jsonString, ApiResponseCountry.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;

    }

}
