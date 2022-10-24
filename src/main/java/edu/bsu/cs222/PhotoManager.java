package edu.bsu.cs222;

import java.io.FileInputStream;
import java.awt.image.BufferedImage;
import javafx.scene.image.Image;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PhotoManager {
    private BufferedImage originalImage;
    private BufferedImage displayImage;
    //remove comments once classes are created
    //private blur = new Blur();
    //private expandImage = new expandImage();
    //private imageSelector = new ImageSelector();

    public PhotoManager(){
        selectPhoto("");
    }

    public PhotoManager(BufferedImage source){
        originalImage = source;
        resetImage();
    }

    public void selectPhoto(String dir){
        //originalImage = imageSelector.getImage(dir);
        resetImage();

    }

    public void resetImage(){
        //make sure there is a copy made here
        displayImage = originalImage;
    }

    public Image getDisplayImage() throws FileNotFoundException {
        return new javafx.scene.image.Image(new FileInputStream("/Users/samuelgross/IdeaProjects/Final-Ethan-Mason-Logan-Samuel/src/resources/black_image.png"));
    }
    public void blurImage() throws IOException {
        //blur.blurImage(displayImage);
    }

    public void expandImage(){
        //expandImage.expand(displayImage);
    }
}
