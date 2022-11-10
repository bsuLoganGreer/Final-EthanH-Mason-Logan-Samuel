package edu.bsu.cs222;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import java.io.File;

public class FilePicker {


    // Opens up File Explorer and allows the user to select the photo they want to edit.
    public String selectFile(Stage stage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource file");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));

        File selectedFile = fileChooser.showOpenDialog(stage);
        String dir = selectedFile.getAbsolutePath();

        return dir;
    }
}
