package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.ArrayList;

public class Anime {

    PixelProcessor pixelProcessor;
    Image original;
    Image outlinedImage;
    PixelReader reader;

    public Anime(){

    }
    public Anime(Image img){
        pixelProcessor = new PixelProcessor(img);
        outlinedImage = new Blur().blur(img);
        outlinedImage = new Normalize().normalize(outlinedImage);
        outlinedImage = new Edge().defineEdge(outlinedImage);
        reader = outlinedImage.getPixelReader();
        processBlackPixels();
        original = img;
        reader = img.getPixelReader();

    }

    public Image getAnimeImage(){
        WritableImage tmp = new WritableImage(new Normalize().normalize(original).getPixelReader(), (int) outlinedImage.getWidth(), (int)outlinedImage.getHeight());
        PixelWriter writer = tmp.getPixelWriter();

        for (int x=0; x < outlinedImage.getWidth(); x ++) {
            for (int y = 0; y < outlinedImage.getHeight(); y ++) {
                if (pixelProcessor.shouldProcess(x, y)){
                    ArrayList<Color> colorList = new ArrayList<>();
                    ArrayList<Point> pointList = new ArrayList<>();
                    createColorGroup(x, y, pointList, colorList);
                    Color groupAverageColor = getAverage(colorList);
                    for (Point point : pointList) {
                        writer.setColor((int) point.getX(), (int) point.getY(), groupAverageColor);
                    }
                }
            }
        }

        return tmp;
    }

    public void createColorGroup(int x, int y, ArrayList<Point> pointList, ArrayList<Color> colorList){

        pixelProcessor.setProcessed(x,y);
        pointList.add(new Point(x, y));
        colorList.add(reader.getColor(x,y));

        if (pixelProcessor.shouldProcess(x + 1,y)){
            createColorGroup(x + 1, y, pointList, colorList);
        }
        if (pixelProcessor.shouldProcess(x,y + 1) ){
            createColorGroup(x, y + 1, pointList, colorList);
        }
    }


    public Color getAverage(ArrayList<Color> colorList) {
        double averageRed = 0.0;
        double averageGreen = 0.0;
        double averageBlue = 0.0;
        for (Color color : colorList) {
            averageRed += color.getRed();
            averageGreen += color.getGreen();
            averageBlue += color.getBlue();
        }
        averageRed = averageRed/colorList.size();
        averageGreen =averageGreen/colorList.size();
        averageBlue = averageBlue/colorList.size();
        return new Color(averageRed, averageGreen, averageBlue, 1.0);
    }

    public void processBlackPixels() {
        for (int x = 0; x< outlinedImage.getWidth(); x++){
            for (int y = 0; y< outlinedImage.getHeight(); y++){
                if (reader.getColor(x, y).getBrightness() < .05){
                    pixelProcessor.setProcessed(x, y);
                }
            }
        }
    }
}
