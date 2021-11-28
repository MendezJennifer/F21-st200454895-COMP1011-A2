package com.example.f21st200454895comp1011a2.Controllers;

import com.example.f21st200454895comp1011a2.API.ApiResponseStateDetails;
import com.example.f21st200454895comp1011a2.API.ApiUtility;
import com.example.f21st200454895comp1011a2.InitializeState;
import com.example.f21st200454895comp1011a2.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;

public class StateDetailsViewController implements InitializeState {
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

    @FXML
    private ComboBox statesComboBox;


    /**
     * This method takes the geographyID, calls the API/JSON,
     * and creates a StateDetails object to populate the GUI
     */
    public void loadStateDetails(String stateID) {
        ApiResponseStateDetails apiResponseStateDetails= null;
        try {
            apiResponseStateDetails = ApiUtility.getStateDetails(stateID);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        stateNameLabel.setText(apiResponseStateDetails.getData()[0].getGeography());

        populationLabel.setText(String.format("%,d",apiResponseStateDetails.getData()[0].getPopulation()));
        numForeignCitLabel.setText(String.format("%,d",apiResponseStateDetails.getData()[0].getForeignBornCitizens()));

        householdIncomeLabel.setText(String.format("%,d",apiResponseStateDetails.getData()[0].getHouseholdIncomeByRace()));

        commuteTimeLabel.setText(Double.toString(apiResponseStateDetails.getData()[0].getAverageCommuteTime()).substring(0,Double.toString(apiResponseStateDetails.getData()[0].getAverageCommuteTime()).indexOf(".")+5));

        totalCitizensLabel.setText(String.format("%,d",apiResponseStateDetails.getData()[0].getCitizenshipStatus()));

        yearDataLabel.setText(apiResponseStateDetails.getData()[0].getYear());

    }

    @FXML
    public void allStatesView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"all_states_view.fxml");
    }

}
