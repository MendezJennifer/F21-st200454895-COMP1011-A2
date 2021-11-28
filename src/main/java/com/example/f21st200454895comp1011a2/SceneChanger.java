package com.example.f21st200454895comp1011a2;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class SceneChanger {

    /**
     * This method will an even, file name, and stateId and use it to launch a new scene with the state details for the selected stateID
     * @param event
     * @param fxmlFile
     * @param stateID
     * @throws IOException
     */
    public static void changeScenes(ActionEvent event, String fxmlFile, String stateID) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        InitializeState controller=fxmlLoader.getController();
        controller.loadStateDetails(stateID);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    /**
     * This method takes an event and file name and uses them to launch a new scene
     * @param event
     * @param fxmlFile
     * @throws IOException
     */
    public static void changeScenes(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(SceneChanger.class.getResource(fxmlFile));
        Scene scene=new Scene(root);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.show();
    }

}
