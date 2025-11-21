package uniquindio.edu.co.specialdates;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import uniquindio.edu.co.specialdates.controllers.MainController;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("MainView.fxml"));

        MainController mainController = new MainController();
        fxmlLoader.setController(mainController);

        Scene scene = new Scene(fxmlLoader.load(), 886, 683);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}