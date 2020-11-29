package at.nsc.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    private ArrayList<model_LoginData> list_Logins = new ArrayList<model_LoginData>();

    public void setList_Logins(model_LoginData loginData)
    {
        list_Logins.add(loginData);
    }

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

            stage.setTitle("Welcome");
            stage.setScene(new Scene(root, 400, 400));
            stage.show();
        }
        catch (Exception exception)
        {
            //controller_ErrorController.show("Internal error", 0);
            controller_ErrorController.show("Internal error");
            System.err.println("Something wrong with view_welcomeView.fxml: " + exception.getMessage());
            exception.printStackTrace(System.err);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        list_Logins.add(new model_LoginData("admin", "admin"));
    }

    @FXML
    private void next()
    {
        //navigate from welcome screen to main screen
        System.out.println("Navigation started ...");

        controller_MainController.show(new Stage(), "Hello from Welcome Controller!");
        stage.close();
    }

    @FXML
    private void login()
    {
        boolean loginSuccessful = false;
        String user = textField_UserField.getText();
        String password = passwordField_PasswordField.getText();

        for (int i = 0; i < list_Logins.size(); i++)
        {
            String loginData_user = list_Logins.get(i).getUsername();
            String loginData_password = list_Logins.get(i).getPassword();

            if (loginData_user.equals(user) && loginData_password.equals(password))
            {
                controller_MainController.show(new Stage(), "Login successful");
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
    private void register()
    {
        
    }
}
