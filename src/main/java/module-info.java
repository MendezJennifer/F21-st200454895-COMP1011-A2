module com.example.f21st200454895comp1011a2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires java.net.http;

    opens com.example.f21st200454895comp1011a2 to javafx.fxml,com.google.gson;
    exports com.example.f21st200454895comp1011a2;
}