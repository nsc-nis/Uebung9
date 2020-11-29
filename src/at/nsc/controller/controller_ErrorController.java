package at.nsc.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *  Übung 9 - Controller
 * @author Niklas Schachl
 * @version 1.0, 29.11.2020
 */
public class controller_ErrorController
{
    private static Stage stage = new Stage();

    public static void show(String errorTitle)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(controller_WelcomeController.class.getResource("/at/nsc/view/view_ErrorView.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle(errorTitle);
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception exception)
        {
            System.err.println("Something wrong with view_errorView.fxml: " + exception.getMessage());
            exception.printStackTrace(System.err);
        }

    }

    @FXML
    public void action_close()
    {
        stage.close();
    }
}
