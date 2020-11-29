package at.nsc.controller;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Übung 9 - Controller
 * @author Niklas Schachl
 * @version 1.0, 26.11.2020
 */
public class controller_MainController implements Initializable {

    private String myData = "";

    public static void show(Stage stage, String greeting)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(controller_MainController.class.getResource("/at/nsc/view/view_mainView.fxml"));
            Parent root = fxmlLoader.load();

            //send data to MainController
            controller_MainController ctrl = fxmlLoader.getController();
            ctrl.setMyData(greeting);

            stage.setTitle("Main");
            stage.setScene(new Scene(root, 500, 500));
            stage.show();

        }
        catch(Exception exception)
        {
            System.err.println("Something wrong with view_mainView.fxml: " + exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    public void setMyData(String myData) {
        this.myData = myData;
        System.out.println("(MainController) Data received: " + this.myData);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
