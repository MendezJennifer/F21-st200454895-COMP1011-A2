package com.example.f21st200454895comp1011a2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("all_states_view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("USA State Data");
        stage.setScene(scene);
        stage.show();

        //Add Window Icon
        Image image= new Image(getClass().getResource("/img/icon.png").toExternalForm());
        stage.getIcons().add(image);
    }

    public static void main(String[] args) {
        launch();
    }
}