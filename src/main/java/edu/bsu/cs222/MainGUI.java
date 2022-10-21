package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class MainGUI extends Application {
    public static void main(String[] args){
        launch(args);
    }
    private final TextField inputField = new TextField();
    private final Button displayPhotoButton = new Button("Apply!");
    private final Button selectPhotoButton = new Button("Select Photo->");
    private final PhotoManager photoManager = new PhotoManager();

    private final ComboBox<String> filterSelector = new ComboBox<>();
    //private Photo photoField = new Photo();

    @Override
    public void start(Stage primaryStage) {
        configure(primaryStage);
        configureSelectPhotoButton();
        configureComboBox();
        configureDisplayPhotoButton();
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
                inputField,//
                selectPhotoButton, //
                new Label("Select a modification:"), //
                filterSelector, //
                displayPhotoButton, //
                new Label("Modified Photo:") //
                //, photoField //
                );
        return root;
    }
    private void configureComboBox(){filterSelector.getItems().addAll("Blur", "Enlarge");}

    private void configureSelectPhotoButton() {
        selectPhotoButton.setOnAction(event -> {
            try {
                selectPhoto();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
    private void configureDisplayPhotoButton() {
        displayPhotoButton.setOnAction(event -> {
            try {
                if (filterSelector.getValue().equals("Blur"))
                    blur();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


    private void selectPhoto() throws IOException {
        photoManager.selectPhoto(inputField.getText());
    }
    private void blur() throws IOException{
        photoManager.blurImage();
    }



}
