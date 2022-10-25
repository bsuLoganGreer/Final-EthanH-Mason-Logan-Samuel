package edu.bsu.cs222;

import java.io.FileInputStream;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PhotoManager {
    private Image displayImage;
    private String sourceDir;

    public PhotoManager() throws FileNotFoundException {
        sourceDir = "/src/resources/black_image.png";
        displayImage = getImage(sourceDir);
    }
    public PhotoManager(String fileLocation) throws FileNotFoundException {
        selectPhoto(fileLocation);
    }
    public PhotoManager(Image source){
        displayImage = source;
    }


    public Image getDisplayImage() throws FileNotFoundException {
        return displayImage;
    }
    public void selectPhoto(String fileLocation) throws FileNotFoundException {
        sourceDir = fileLocation;
        reset();
    }
    public void reset() throws FileNotFoundException {
        displayImage = getImage(sourceDir);
    }
    public void blurImage() throws IOException {
        blur.blurImage(displayImage);
    }
    public void expandImage(){
        Expand.resizeImage(displayImage);
    }


    private Image getImage(String dir) throws FileNotFoundException{
        String envRootDir = System.getProperty("user.dir");
        return new javafx.scene.image.Image(new FileInputStream(envRootDir + dir));
    }
}
