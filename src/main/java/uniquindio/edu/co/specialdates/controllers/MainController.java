package uniquindio.edu.co.specialdates.controllers;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import uniquindio.edu.co.specialdates.model.Date;
import uniquindio.edu.co.specialdates.model.Main;
import uniquindio.edu.co.specialdates.services.DatesServices;

public class MainController {

    private ObservableList<Date> dates;
    private final Main main = PrincipalController.getInstance().getMain();
    private final DatesServices datesServices = new DatesServices();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="TableDates"
    private TableView<Date> TableDates; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_columnDate"
    private TableColumn<Date, String> tbl_columnDate; // Value injected by FXMLLoader

    @FXML // fx:id="tbl_columnDescription"
    private TableColumn<Date, String> tbl_columnDescription; // Value injected by FXMLLoader

    @FXML // fx:id="txtaDescription"
    private TextArea txtaDescription; // Value injected by FXMLLoader

    @FXML // fx:id="txtfDate"
    private TextField txtfDate; // Value injected by FXMLLoader

    @FXML
    void onCreate(ActionEvent event) {
        String date = txtfDate.getText();
        String description = txtaDescription.getText();

        try {
            datesServices.createDate(description, date);
            showAlertSucces("Date Created", "Date created succesfully");
        } catch (Exception e) {
            showAlertError("Error", e.getMessage());
        }

        refreshDates();
    }

    @FXML
    void onDelete(ActionEvent event) {
        Date date = TableDates.getSelectionModel().getSelectedItem();
        try {
            datesServices.removeDate(date);
            showAlertSucces("Date deleted", "Date deleted succesfully");
        } catch (Exception e) {
            showAlertError("Error", e.getMessage());
        }

        refreshDates();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        tbl_columnDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDate()));
        tbl_columnDescription.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDescription()));

        dates = FXCollections.observableArrayList();
        loadDates();
    }

    public void loadDates() {
        List<Date> listDates = main.getDates();

        if(listDates == null) {
            listDates = List.of();
        }
        dates.setAll(listDates);
        TableDates.setItems(dates);
    }

    public void refreshDates() {
        dates.setAll(main.getDates());
    }

    private void showAlertError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showAlertSucces(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

