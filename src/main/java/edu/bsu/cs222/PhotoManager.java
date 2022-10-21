package edu.bsu.cs222;

import java.awt.*;
import java.awt.image.BufferedImage;
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

    public Image getDisplayImage() {
        return displayImage;
    }
    public void blurImage() throws IOException {
        //blur.blurImage(displayImage);
    }

    public void expandImage(){
        //expandImage.expand(displayImage);
    }
}
