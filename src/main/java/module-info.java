module com.example.gui10v3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gui10v3 to javafx.fxml;
    exports com.example.gui10v3;
}