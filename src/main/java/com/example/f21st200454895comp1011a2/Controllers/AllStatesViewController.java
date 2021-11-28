package com.example.f21st200454895comp1011a2.Controllers;

import com.example.f21st200454895comp1011a2.API.ApiResponse;
import com.example.f21st200454895comp1011a2.API.ApiUtility;
import com.example.f21st200454895comp1011a2.SceneChanger;
import com.example.f21st200454895comp1011a2.Models.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        statesListView.getSelectionModel().selectedItemProperty().addListener(
                (obs, oldState, stateSelected) -> {
                    stateDetailsButton.setVisible(true);
                });
    }

    /**
     * Will Retrieve data from API and display all states and their population on a listView
     * Will also populate a combobox with state names
     * @throws IOException
     * @throws InterruptedException
     */
    @FXML
    public void loadStatesData() throws IOException, InterruptedException {
        ApiResponse apiResponse= ApiUtility.getStatesFromDataUsa();
        statesListView.getItems().addAll(apiResponse.getData());
    }

    @FXML
    public void viewStateDetails(ActionEvent event) throws IOException {
        String stateID=statesListView.getSelectionModel().getSelectedItem().getStateID();
        SceneChanger.changeScenes(event,"state-details-view.fxml", stateID);
    }
}