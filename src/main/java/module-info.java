module com.example.boxanddotses {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.boxanddotses to javafx.fxml;
    exports com.example.boxanddotses;
}