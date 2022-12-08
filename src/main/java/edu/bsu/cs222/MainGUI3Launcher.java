package edu.bsu.cs222;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainGUI3Launcher extends Application {

    @Override
    public void start(Stage primaryStage) {
        new edu.bsu.cs222.MainGUI3(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

