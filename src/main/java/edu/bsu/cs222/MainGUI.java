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
    private final Button undoButton = new Button("Undo");
    private final Button downloadButton = new Button("Download");
    private final ColorPicker colorPicker = new ColorPicker();
    private final PhotoManager photoManager = new PhotoManager();
    private final ComboBox<String> filterSelector = new ComboBox<>();
    private ImageView imageView;
    Text errorMessage = new Text("");
    VBox root;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        inputField.setText(new FilePicker().selectFile(primaryStage));
        configure(primaryStage);
        configureSelectPhotoButton();
        configureComboBox();
        configureDisplayPhotoButton();
        configureUndoButton();
        configureDownloadButton();
    }

    private void configure(Stage stage) throws FileNotFoundException {
        stage.setTitle("Photo filter");
        stage.setScene(new Scene(createRoot()));
        // will soon need to adjust to photo size
        stage.setWidth(1000);
        stage.setHeight(500);
        stage.show();
    }

    private Pane createRoot() throws FileNotFoundException {
        root = new VBox();
        updateImageView();
        setRoot();
        return root;
    }
    private void configureComboBox(){filterSelector.getItems().addAll("Blur", "Enlarge", "Shrink", "Outline", "Draw Edges", "Create B&W Image","Pixelate", "Stylize","Anime", "Reset", "Paint");}

    private void configureSelectPhotoButton() {
        selectPhotoButton.setOnAction(event -> {
            try {
                photoManager.selectPhoto(inputField.getText());
                updateImageView();
                setRoot();
            } catch (Exception e) {
                errorMessage.setText("Enter a valid file name. Make sure the image file is stored in resources folder.");
            }
        });
    }
    private void configureUndoButton() {
        undoButton.setOnAction(event -> {
            try {
                photoManager.revertDisplayImage();
                updateImageView();
                setRoot();
                System.out.println("Hi");
            } catch (Exception e) {
                errorMessage.setText("Make sure there is somewhere to revert to!");
            }
        });
    }
    private void configureDownloadButton() {
        downloadButton.setOnAction(event -> {
            try {
                photoManager.downloadImage();
                updateImageView();
                setRoot();
            } catch (Exception e) {
                errorMessage.setText("Could not download.");
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
                    photoManager.selectPhoto(inputField.getText());
                }
                else if (filterSelector.getValue().equals("Create B&W Image")){
                    photoManager.blackAndWhiteImage();
                }
                else if (filterSelector.getValue().equals("Shrink")) {
                    photoManager.shrinkImage();
                }
                else if (filterSelector.getValue().equals("Pixelate")){
                    photoManager.pixelateImage();
                }
                else if (filterSelector.getValue().equals("Outline")){
                        photoManager.outlineImage();
                }
                else if (filterSelector.getValue().equals("Draw Edges")){
                    photoManager.defineEdges();
                }
                else if (filterSelector.getValue().equals("Stylize")){
                    photoManager.stylizeImage(colorPicker.getValue());
                }
                else if (filterSelector.getValue().equals("Paint")){
                    photoManager.paintImage();
                }
                else if (filterSelector.getValue().equals("Anime")){
                    photoManager.animeImage();
                }

                updateImageView();
                setRoot();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
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
                new Label("Enter a file name:"),
                inputField,//
                selectPhotoButton, //
                colorPicker,
                errorMessage, //
                new Label("Select a modification:"), //
                filterSelector, //
                displayPhotoButton, //
                undoButton,
                downloadButton,
                new Label("Modified Photo:") //
                , imageView
        );
    }



}
