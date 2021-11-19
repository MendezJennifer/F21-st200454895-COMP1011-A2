package com.example.f21st200454895comp1011a2;

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

//        ApiResponse apiResponse=ApiUtility.getStatesFromDataUsa();
//        if(apiResponse!=null)
//        {
//            statesListView.getItems().addAll(apiResponse.getData());
//        }

    }

    @FXML void viewStateDetails(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"state_details_view.fxml", "State Details");
    }
}