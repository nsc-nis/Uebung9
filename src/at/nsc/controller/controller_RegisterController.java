package at.nsc.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Übung 9 - Controller
 * @author Niklas Schachl
 * @version 1.0, 26.11.2020
 */
public class controller_RegisterController implements Initializable
{
    @FXML
    private TextField textField_UserField;

    @FXML
    private PasswordField passwordField_PasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public static void show(Stage stage)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(controller_WelcomeController.class.getResource("/at/nsc/view/view_RegisterView.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            controller_WelcomeController ctrl = fxmlLoader.getController();
            stage = stage;

            stage.setTitle("Register to Magic 8 Ball");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        }
        catch (Exception exception)
        {
            System.err.println("Something wrong with view_RegisterView.fxml: " + exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    @FXML
    private void action_createAccount()
    {

    }
}
