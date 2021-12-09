module com.example.imageplayer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.imageplayer to javafx.fxml;
    exports com.example.imageplayer;
}