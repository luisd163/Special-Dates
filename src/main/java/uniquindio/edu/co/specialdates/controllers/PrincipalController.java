package uniquindio.edu.co.specialdates.controllers;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import uniquindio.edu.co.specialdates.model.Main;

@Getter @Setter
public class PrincipalController {

    public static PrincipalController instancia;
    private final Main main = new Main();

    private PrincipalController(){}

    public static PrincipalController getInstance() {
        if(instancia == null) {
            instancia = new PrincipalController();
        }
        return instancia;
    }

    public void closeWindow(Node node){
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    public void createAlert(String message, Alert.AlertType type){
        Alert alert = new Alert(type);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
