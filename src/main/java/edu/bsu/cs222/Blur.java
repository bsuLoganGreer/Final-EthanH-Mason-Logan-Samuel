package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Blur {
    public Image blur(Image img) {
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();

        for (int x = 0; x < ((int) img.getWidth()); x++) {
            for (int y = 0; y < ((int) img.getHeight()); y++) {
                writer.setColor(x, y, getBlurredColor(reader, x, y));
            }
        }
        return tmp;
    }

    public Color getBlurredColor(PixelReader reader, int x,  int y){
        double averageRed = 0.0;
        double averageGreen = 0.0;
        double averageBlue = 0.0;
        int numPixels = 0;
        for (int w = -2; w <= 2; w++) {
            for (int h = -2; h <= 2; h++) {
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
}


