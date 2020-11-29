package at.nsc.controller;

import at.nsc.model.model_8ballData;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 *  Übung 9 - Controller
 * @author Niklas Schachl
 * @version 1.0, 26.11.2020
 */
public class controller_MainController implements Initializable {

    private static Stage stage = new Stage();

    @FXML
    private Label label_answer;

    @FXML
    private TextField textField_question;

    public static void show()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(controller_MainController.class.getResource("/at/nsc/view/view_mainView.fxml"));
            Parent root = fxmlLoader.load();

            stage.getIcons().add(new Image("/at/nsc/logo.png"));
            stage.setTitle("Magic 8 Ball");
            stage.setScene(new Scene(root));
            stage.show();

        }
        catch(Exception exception)
        {
            controller_ErrorController.show("Internal error");
            System.err.println("Something wrong with view_mainView.fxml: " + exception.getMessage());
            exception.printStackTrace(System.err);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    @FXML
    private void action_submit()
    {
        at.nsc.model.model_8ballData answer = new model_8ballData();
        textField_question.clear();
        label_answer.setText(answer.getAnswer());
    }

    @FXML
    private void action_exit()
    {
        stage.close();
    }
}
