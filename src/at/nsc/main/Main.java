package at.nsc.main;

import javafx.application.Application;
import javafx.stage.Stage;
import at.nsc.controller.*;

/**
 *  Übung 9 - Main
 * @author Niklas Schachl
 * @version 1.0, 26.11.2020
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage)
    {
        controller_WelcomeController.show(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
