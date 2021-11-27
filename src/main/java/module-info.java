module com.example.f21st200454895comp1011a2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.f21st200454895comp1011a2 to javafx.fxml,com.google.gson;
    exports com.example.f21st200454895comp1011a2;
    exports com.example.f21st200454895comp1011a2.Controllers;
    opens com.example.f21st200454895comp1011a2.Controllers to com.google.gson, javafx.fxml;
    exports com.example.f21st200454895comp1011a2.Models;
    opens com.example.f21st200454895comp1011a2.Models to com.google.gson, javafx.fxml;
    exports com.example.f21st200454895comp1011a2.API;
    opens com.example.f21st200454895comp1011a2.API to com.google.gson, javafx.fxml;
}