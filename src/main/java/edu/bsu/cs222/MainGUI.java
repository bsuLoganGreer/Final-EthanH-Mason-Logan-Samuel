package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;

public class MainGUI extends Application {
    public static void main(String[] args){
        launch(args);
    }
    private final Button displayPhotoButton = new Button("Apply!");
    private final Button selectPhotoButton = new Button("Select Photo->");

    private final ComboBox<String> filterSelector = new ComboBox<>();
    //private Photo photoField = new Photo();

    @Override
    public void start(Stage primaryStage) {
        configure(primaryStage);
        configureRevisionsButton();
    }

    private void configure(Stage stage){
        stage.setTitle("Photo filter");
        stage.setScene(new Scene(createRoot()));
        // will soon need to adjust to photo size
        stage.setWidth(500);
        stage.setHeight(650);
        stage.show();
    }

    private Pane createRoot() {
        VBox root = new VBox();
        root.getChildren().addAll( //
                new Label("Photo filter"), //
                selectPhotoButton, //
                new Label("Select a modification:"), //
                filterSelector, //
                displayPhotoButton, //
                new Label("Modified Photo:") //
                //, photoField //
                );
        return root;
    }

    private void configureRevisionsButton() {
        selectPhotoButton.setOnAction(event -> {
            try {
                selectPhoto();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    private void selectPhoto() throws IOException {
        //photoManager.selectPhoto();
    }


    private void displayDisconnectAlert() {
        Alert disconnectAlert = new Alert(Alert.AlertType.ERROR);
        disconnectAlert.setHeaderText("Disconnect Error:");
        disconnectAlert.setContentText("Your device is not connected to the internet!");
        disconnectAlert.show();
    }


    private void displayAnyRedirect(RevisionParser Parser, JSONArray wikiResult) {
        String currentTitle = Parser.checkRedirect(wikiResult);
        if (currentTitle != null) {
            specialField.setText(String.format("The page was redirected to %s.\n", currentTitle));
        }
    }

    private void setToAskForSearch() {
        resetDisplay();
        specialField.setText("Please input a article title.");
    }

    private void setToNoPage() {
        resetDisplay();
        specialField.setText("There is not a page under this name!");
    }

    private void resetDisplay() {
        inputField.setEditable(true);
        specialField.setText("");
        outputField.setText("");
    }
}
