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

        for (int x = 2; x < ((int) img.getWidth() - 2); x++) {
            for (int y = 2; y < ((int) img.getHeight() - 2); y++) {
                writer.setColor(x, y, getBlurredColor(reader, x, y));
            }
        }
        return tmp;
    }

    public Color getBlurredColor(PixelReader reader, int x,  int y){
        double averageRed = 0.0;
        double averageGreen = 0.0;
        double averageBlue = 0.0;
        for (int w = -2; w <= 2; w++) {
            for (int h = -2; h <= 2; h++) {
                averageRed += reader.getColor(x + w, y + h).getRed();
                averageGreen += reader.getColor(x + w, y + h).getGreen();
                averageBlue += reader.getColor(x + w, y + h).getBlue();
            }
        }
        averageRed = averageRed/25.0;
        averageGreen =averageGreen/25.0;
        averageBlue = averageBlue/25.0;
        return new Color(averageRed, averageGreen, averageBlue, 1.0);

    }
}


