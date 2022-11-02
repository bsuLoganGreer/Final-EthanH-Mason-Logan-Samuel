package edu.bsu.cs222;

import java.io.FileInputStream;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PhotoManager {
    private Image displayImage;
    private String sourceDir;

    public PhotoManager() throws FileNotFoundException {
        sourceDir = System.getProperty("user.dir") + "/src/resources/black_image.png";
        displayImage = getImage(sourceDir);
    }
    public PhotoManager(String fileLocation) throws FileNotFoundException {
        selectPhoto(fileLocation);
    }
    public PhotoManager(Image source){
        displayImage = source;
    }


    public Image getDisplayImage(){
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
        displayImage = new Blur().blur(displayImage, 3);
    }
    public void expandImage(){
        displayImage = new ResizeImage().expand(displayImage, 2);
    }
    public void shrinkImage(){
        displayImage = new ResizeImage().shrink(displayImage, 2);
    }
    public void blackAndWhiteImage(){
        displayImage = new BlackAndWhite().blackAndWhite(displayImage);
    }
    public void stylizeImage(){
        displayImage = new Stylize().stylize(displayImage);
    }


    public Image getImage(String dir) throws FileNotFoundException {
        return new javafx.scene.image.Image(new FileInputStream(dir));
    }
}
