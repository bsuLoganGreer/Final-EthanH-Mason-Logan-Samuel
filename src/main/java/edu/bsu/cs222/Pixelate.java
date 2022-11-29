package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Pixelate {

    public Image pixelate(Image img){
        PixelReader reader = img.getPixelReader();
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelWriter writer = tmp.getPixelWriter();
        for (int w=0; w < img.getWidth(); w++) {
            for (int h = 0; h < img.getHeight(); h++) {
                setAverage(writer, w, h, getAveragePixels(reader, w, h));
            }
        }
        return tmp;
    }
    public Color getAveragePixels(PixelReader reader, int x, int y) {
        double averageRed = 0.0;
        double averageGreen = 0.0;
        double averageBlue = 0.0;
        int numPixels = 0;
        for (int w=0; w <= 10; w++) {
            for (int h = 0; h <= 10; h++) {
                try {
                    averageRed += reader.getColor(x + w, y + h).getRed();
                    averageGreen += reader.getColor(x + w, y + h).getGreen();
                    averageBlue += reader.getColor(x + w, y + h).getBlue();
                    numPixels++;
                }
                catch (IndexOutOfBoundsException ignored){

                }
            }
        }
        averageRed = averageRed/numPixels;
        averageGreen =averageGreen/numPixels;
        averageBlue = averageBlue/numPixels;
        return new Color(averageRed, averageGreen, averageBlue, 1.0);
    }

    public void setAverage(PixelWriter testWriter, int x, int y, Color color) {
        for (int w=0; w <= 10; w++) {
            for (int h = 0; h <= 10; h++) {
                try {
                    testWriter.setColor(x+w, y+h, color);
                }
                catch (IndexOutOfBoundsException ignored){

                }
            }
        }
    }
}
