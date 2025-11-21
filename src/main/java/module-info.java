module uniquindio.edu.co.specialdates {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens uniquindio.edu.co.specialdates to javafx.fxml;
    exports uniquindio.edu.co.specialdates;
    exports uniquindio.edu.co.specialdates.controllers;
    opens uniquindio.edu.co.specialdates.controllers to javafx.fxml;
}