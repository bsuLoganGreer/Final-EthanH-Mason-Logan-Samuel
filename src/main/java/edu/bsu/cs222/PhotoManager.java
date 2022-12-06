package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

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
    public void pixelateImage(){
        displayImage = new Pixelate().pixelate(displayImage);
    }
    public void blackAndWhiteImage(){
        displayImage = new BlackAndWhite().blackAndWhite(displayImage);
    }
    public void outlineImage(){
        displayImage = new Edge().createOutline(displayImage);
    }
    public void defineEdges(){
        displayImage = new Edge().defineEdge(displayImage);
    }
    public void stylizeImage(Color color){
        Stylize stylizeEngine = new Stylize();
        stylizeEngine.setColors(color);
        displayImage = stylizeEngine.stylize(displayImage);
    }

    public void normalizeImage(){
        displayImage = new Normalize().normalize(displayImage);
    }
    public void animeImage(){
        displayImage = new Anime(displayImage).getAnimeImage();
    }
    public void downloadImage() throws IOException {
        new Download().download(displayImage, sourceDir);
    }


}
