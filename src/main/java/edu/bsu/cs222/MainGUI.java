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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.io.IOException;

public class MainGUI extends Application {
    public MainGUI() throws FileNotFoundException {
    }

    public static void main(String[] args){
        launch(args);
    }
    private final TextField inputField = new TextField();
    private final Button displayPhotoButton = new Button("Apply!");
    private final Button selectPhotoButton = new Button("Select Photo->");
    private final PhotoManager photoManager = new PhotoManager();
    private final ComboBox<String> filterSelector = new ComboBox<>();
    private ImageView imageView;
    Text errorMessage = new Text("");
    VBox root;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        configure(primaryStage);
        configureSelectPhotoButton();
        configureComboBox();
        configureDisplayPhotoButton();
    }

    private void configure(Stage stage) throws FileNotFoundException {
        stage.setTitle("Photo filter");
        stage.setScene(new Scene(createRoot()));
        // will soon need to adjust to photo size
        stage.setWidth(1000);
        stage.setHeight(1300);
        stage.show();
    }

    private Pane createRoot() throws FileNotFoundException {
        root = new VBox();
        updateImageView();
        setRoot();
        return root;
    }
    private void configureComboBox(){filterSelector.getItems().addAll("Blur", "Enlarge", "Reset");}

    private void configureSelectPhotoButton() {
        selectPhotoButton.setOnAction(event -> {
            try {
                selectPhoto();
                setRoot();
            } catch (Exception e) {
                errorMessage.setText("Enter a valid file name. Make sure the image file is stored in resources folder.");
            }
        });
    }
    private void configureDisplayPhotoButton() {
        displayPhotoButton.setOnAction(event -> {
            try {
                if (filterSelector.getValue().equals("Blur")) {
                    photoManager.blurImage();
                }
                else if (filterSelector.getValue().equals("Enlarge")){
                    photoManager.expandImage();
                }
                else if (filterSelector.getValue().equals("Reset")){
                    photoManager.reset();
                }
                updateImageView();
                setRoot();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void selectPhoto() throws IOException {
        photoManager.selectPhoto(inputField.getText());
        updateImageView();
    }

    private void updateImageView() throws FileNotFoundException {
        imageView = new ImageView(photoManager.getDisplayImage());
        imageView.setX(50);
        imageView.setY(25);
        imageView.setPreserveRatio(true);
    }

    private void setRoot(){
        errorMessage.setText("");
        root.getChildren().setAll( //
                inputField,//
                selectPhotoButton, //
                errorMessage, //
                new Label("Select a modification:"), //
                filterSelector, //
                displayPhotoButton, //
                new Label("Modified Photo:") //
                , imageView
        );
    }



}
