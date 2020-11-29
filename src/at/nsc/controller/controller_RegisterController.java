package at.nsc.controller;

import at.nsc.model.model_LoginData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

    @FXML
    private PasswordField passwordField_PasswordFieldR;

    private static Stage stage = new Stage();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    public static void show()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(controller_WelcomeController.class.getResource("/at/nsc/view/view_RegisterView.fxml"));
            Parent root = fxmlLoader.load();

            stage.setTitle("Register to Magic 8 Ball");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        }
        catch (Exception exception)
        {
            controller_ErrorController.show("Internal error");
            exception.printStackTrace(System.err);
        }
    }

    @FXML
    private void action_createAccount()
    {
        try
        {
            String user = textField_UserField.getText();
            String password1 = passwordField_PasswordField.getText();
            String password2 = passwordField_PasswordFieldR.getText();

            if (password1.equals(password2))
            {
                controller_WelcomeController controller_welcomeController = new controller_WelcomeController();

                controller_welcomeController.setList_Logins(new model_LoginData(user, password1));

                stage.close();
            }
            else
            {
                controller_ErrorController.show("Passwords don't match");
            }
        }
        catch (Exception exception)
        {
            controller_ErrorController.show("Internal error");
        }
    }

    @FXML
    private void action_cancel()
    {
        stage.close();
    }
}
