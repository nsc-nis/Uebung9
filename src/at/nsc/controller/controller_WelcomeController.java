package at.nsc.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import at.nsc.model.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *  Übung 9 - Controller
 * @author Niklas Schachl
 * @version 1.0, 29.11.2020
 */
public class controller_WelcomeController implements Initializable {

    private Stage stage;

    @FXML
    private TextField textField_UserField;

    @FXML
    private PasswordField passwordField_PasswordField;

    public static void show(Stage stage)
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(controller_WelcomeController.class.getResource("/at/nsc/view/view_welcomeView.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            controller_WelcomeController ctrl = fxmlLoader.getController();
            ctrl.stage = stage;

            stage.getIcons().add(new Image("/at/nsc/icon_user.png"));
            stage.setTitle("Welcome");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception exception)
        {
            controller_ErrorController.show("Internal error");
            System.err.println("Something wrong with view_welcomeView.fxml: " + exception.getMessage());
            exception.printStackTrace(System.err);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        //list_Logins.add(new model_LoginData("admin", "admin"));
        model_loginDataList.setList_Logins(new model_LoginData("admin", "admin"));
    }

    @FXML
    private void action_login()
    {
        boolean loginSuccessful = false;
        String user = textField_UserField.getText();
        String password = passwordField_PasswordField.getText();

        for (int i = 0; i < model_loginDataList.getLength(); i++)
        {
            String loginData_user = model_loginDataList.getList_Logins(i).getUsername();
            String loginData_password = model_loginDataList.getList_Logins(i).getPassword();

            if (loginData_user.equals(user) && loginData_password.equals(password))
            {
                controller_MainController.show();
                loginSuccessful = true;
                stage.close();
                break;
            }
        }
        if (!loginSuccessful)
        {
            controller_ErrorController.show("Wrong username/password");
        }
    }

    @FXML
    private void action_register()
    {
        controller_RegisterController.show();
    }
}
