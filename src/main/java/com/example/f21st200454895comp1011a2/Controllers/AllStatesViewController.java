package com.example.f21st200454895comp1011a2.Controllers;

import com.example.f21st200454895comp1011a2.API.ApiResponseCountry;
import com.example.f21st200454895comp1011a2.API.ApiResponseAllStates;
import com.example.f21st200454895comp1011a2.API.ApiUtility;
import com.example.f21st200454895comp1011a2.SceneChanger;
import com.example.f21st200454895comp1011a2.Models.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllStatesViewController implements Initializable {

@FXML
private Label totalPopLabel;

@FXML
private ListView<State> statesListView;

@FXML
private Button stateDetailsButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        stateDetailsButton.setVisible(false);

        try {
            loadStatesData();
            loadCountryData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Check if there is a state selected, if yes then display the button for state details
        statesListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldState, stateSelected) -> {
                    stateDetailsButton.setVisible(true);
                });
    }

    /**
     * Will Retrieve data from API and display all states and their population on a listView
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    public void loadStatesData() throws IOException, InterruptedException {
        ApiResponseAllStates apiResponseAllStates = ApiUtility.getStatesFromDataUsa();
        statesListView.getItems().addAll(apiResponseAllStates.getData());
    }

    /**
     * Will Retrieve data from API and display USA's total population on a label
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    public void loadCountryData() throws IOException, InterruptedException {
        ApiResponseCountry apiResponseCountry=ApiUtility.getCountryFromDataUsa();
        totalPopLabel.setText("USA Total Population: "+apiResponseCountry.getData()[0].toString());
    }

    @FXML
    public void viewStateDetails(ActionEvent event) throws IOException {
        String stateID=statesListView.getSelectionModel().getSelectedItem().getStateID();
        SceneChanger.changeScenes(event,"state_details_view.fxml", stateID);
    }
}