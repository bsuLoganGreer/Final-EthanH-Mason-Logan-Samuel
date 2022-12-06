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
    Image outlinedImage;

    public Anime(){

    }
    public Anime(Image img){
        pixelProcessor = new PixelProcessor(img);
        outlinedImage = new Edge().createOutline(img);

    }

    public Image getAnimeImage(){
        WritableImage tmp = new WritableImage(outlinedImage.getPixelReader(), (int) outlinedImage.getWidth(), (int)outlinedImage.getHeight());
        PixelWriter writer = tmp.getPixelWriter();
        for (int x=0; x < outlinedImage.getWidth(); x ++) {
            for (int y = 0; y < outlinedImage.getHeight(); y ++) {
                if (pixelProcessor.shouldProcess(x, y)){
                    ArrayList<Color> colorList = new ArrayList<>();
                    ArrayList<Point> pointList = new ArrayList<>();
                    createColorGroup(x, y, pointList, colorList, outlinedImage.getPixelReader());
                    Color groupAverageColor = getAverage(colorList);
                    for (Point point : pointList) {
                        writer.setColor((int) point.getX(), (int) point.getY(), groupAverageColor);
                    }
                }
            }
        }

        return tmp;
    }

    public void createColorGroup(int x, int y, ArrayList<Point> pointList, ArrayList<Color> colorList, PixelReader reader){
        if (x == outlinedImage.getWidth() || x < 0 || y == outlinedImage.getHeight() || y<0)
            return;
        pixelProcessor.setProcessed(x,y);
        pointList.add(new Point(x, y));


        if (reader.getColor(x, y) == Color.BLACK)
            return;

        if (pixelProcessor.shouldProcess(x + 1,y) ){
            createColorGroup(x + 1, y, pointList, colorList, reader);
        }
        if (pixelProcessor.shouldProcess(x - 1,y) ){
            createColorGroup(x + 1, y, pointList, colorList, reader);
        }
        if (pixelProcessor.shouldProcess(x,y + 1) ){
            createColorGroup(x + 1, y, pointList, colorList, reader);
        }
        if (pixelProcessor.shouldProcess(x,y + 1) ){
            createColorGroup(x + 1, y, pointList, colorList, reader);
        }
        colorList.add(reader.getColor(x,y));


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
}
