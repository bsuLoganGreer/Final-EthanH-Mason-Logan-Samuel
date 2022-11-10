package edu.bsu.cs222;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PhotoManager {
    private Image displayImage;
    private String sourceDir;

    public PhotoManager() throws FileNotFoundException {
        sourceDir = System.getProperty("user.dir") + "/src/resources/black_image.png";
        selectPhoto(sourceDir);
    }

    public Image getDisplayImage(){
        return displayImage;
    }
    public void selectPhoto(String fileLocation) throws FileNotFoundException {
        sourceDir = fileLocation;
        displayImage = new Image(new FileInputStream(fileLocation));
    }

    public void blurImage() throws IOException {
        displayImage = new Blur().blur(displayImage);
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
    public void edgeImage(){
        displayImage = new Edge().edge(displayImage);
    }
    public void stylizeImage(){
        displayImage = new Stylize().stylize(displayImage);
    }
    public void downloadImage() throws IOException {
        new Download().download(displayImage, sourceDir);
    }

    public void downLoad() throws IOException {
        new Download().download(displayImage, sourceDir);
    }
}
