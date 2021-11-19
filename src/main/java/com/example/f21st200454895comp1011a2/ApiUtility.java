package com.example.f21st200454895comp1011a2;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

public class ApiUtility {

    /**
     * Method that reads the "jsonData.json" file (in the root directory) and creates an ApiResponse object
     */
    public static ApiResponse getStatesJsonFile()
    {
        //create a GSON object
        Gson gson = new Gson();
        ApiResponse response = null;

        try(
                FileReader fileReader = new FileReader("jsonData.json");
                JsonReader jsonReader = new JsonReader(fileReader);
        )
        {
            response = gson.fromJson(jsonReader, ApiResponse.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return response;
    }
    /**
     * Method that calls the US Data Api
     * Will store the API Response to a String and then create objects
     */
    public static ApiResponse getStatesFromDataUsa() throws IOException, InterruptedException {
        //searchTerm = searchTerm.trim().replace(" ", "%20");
        //searchTerm = searchTerm.toLowerCase();

        String uri="https://datausa.io/api/data?drilldowns=State&measures=Foreign-Born%20Citizens,Population,Household%20Income%20by%20Race,Average%20Commute%20Time,Citizenship%20Status";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();

//        //Send the API results to a file (jsonDataResponse.json)
//        HttpResponse<Path> response = client.send(httpRequest, HttpResponse.BodyHandlers
//                                                    .ofFile(Paths.get("jsonDataResponse.json")));


//        return getStatesJsonFile();


        //Store the API response to a String and then use it to create objects
        HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String jsonString =response.body();

        Gson gson = new Gson();
        ApiResponse apiResponse = null;

        try{
            apiResponse  = gson.fromJson(jsonString, ApiResponse.class);
        }catch(Exception e)
        {
            e.printStackTrace();
        }

        return apiResponse;
   }

}
