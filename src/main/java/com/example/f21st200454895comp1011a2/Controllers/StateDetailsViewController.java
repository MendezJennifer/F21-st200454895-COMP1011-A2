package com.example.f21st200454895comp1011a2.Controllers;

import com.example.f21st200454895comp1011a2.API.ApiResponse;
import com.example.f21st200454895comp1011a2.API.ApiResponseStateDetails;
import com.example.f21st200454895comp1011a2.API.ApiUtility;
import com.example.f21st200454895comp1011a2.Models.StateDetails;
import com.example.f21st200454895comp1011a2.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StateDetailsViewController implements Initializable {
    @FXML
    private Label stateNameLabel;

    @FXML
    private Label populationLabel;

    @FXML
    private Label numForeignCitLabel;

    @FXML
    private Label householdIncomeLabel;

    @FXML
    private Label commuteTimeLabel;

    @FXML
    private Label totalCitizensLabel;

    @FXML
    private Label yearDataLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadStateDetails("04000US28");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //stateNameLabel.setText("HEY");
    }

    /**
     * This method takes the geographyID, calls the API/JSON,
     * and creates a StateDetails object to populate the GUI
     */
    private void loadStateDetails(String geographyID) throws IOException, InterruptedException {
        ApiResponseStateDetails apiResponseStateDetails=ApiUtility.getStateDetails(geographyID);
        System.out.println(apiResponseStateDetails.getData()[0].getGeography());

        stateNameLabel.setText(apiResponseStateDetails.getData()[0].getGeography());
         populationLabel.setText(String.valueOf(apiResponseStateDetails.getData()[0].getPopulation()));

        numForeignCitLabel.setText(Integer.toString(apiResponseStateDetails.getData()[0].getForeignBornCitizens()));

        householdIncomeLabel.setText(Integer.toString(apiResponseStateDetails.getData()[0].getHouseholdIncomeByRace()));

        commuteTimeLabel.setText(Double.toString(apiResponseStateDetails.getData()[0].getAverageCommuteTime()));

        totalCitizensLabel.setText(Integer.toString(apiResponseStateDetails.getData()[0].getCitizenshipStatus()));

        yearDataLabel.setText(apiResponseStateDetails.getData()[0].getYear());

    }

    @FXML
    public void allStatesView(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event,"all-states-view.fxml", "State Details");
    }

}
