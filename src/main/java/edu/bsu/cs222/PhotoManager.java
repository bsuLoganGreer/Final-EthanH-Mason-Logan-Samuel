package edu.bsu.cs222;

import java.awt.*;

public class PhotoManager {
    private Image originalImage;
    private Image displayImage;
    //remove comments once classes are created
    //private blurFilter = new BlurFilter();
    //private expandImage = new expandImage();
    //private imageSelector = new ImageSelector();

    public PhotoManager(){
        selectPhoto();
    }

    public PhotoManager(Image source){
        originalImage = source;
        resetImage();
    }

    public void selectPhoto(){
        //originalImage = imageSelector.getImage();
        resetImage();

    }

    public void resetImage(){
        //make sure there is a copy made here
        displayImage = originalImage;
    }

    public Image getDisplayImage() {
        return displayImage;
    }
    public void blurImage(){
        //blurFilter.blur(displayImage);
    }

    public void expandImage(){
        //expandImage.expand(displayImage);
    }
}
