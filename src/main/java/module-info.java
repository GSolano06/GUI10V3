module com.example.gui10v3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.gui10v3 to javafx.fxml;
    exports com.example.gui10v3;
}