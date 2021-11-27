package com.example.f21st200454895comp1011a2.Controllers;

import com.example.f21st200454895comp1011a2.API.ApiResponse;
import com.example.f21st200454895comp1011a2.API.ApiUtility;
import com.example.f21st200454895comp1011a2.SceneChanger;
import com.example.f21st200454895comp1011a2.Models.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllStatesViewController implements Initializable {

@FXML
private Label errMsgLabel;

@FXML
private ListView<State> statesListView;

@FXML
private ComboBox<State> stateComboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errMsgLabel.setText("");
        try {
            loadStatesData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        stateComboBox.getItems().addAll(apiResponse.getData());
    }
    @FXML
    public void viewStateDetails(ActionEvent event) throws IOException, InterruptedException {
        SceneChanger.changeScenes(event,"state-details-view.fxml", "State Details");
    }
}