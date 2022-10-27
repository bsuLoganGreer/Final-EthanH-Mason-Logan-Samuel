package edu.bsu.cs222;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

public class Blur {
    public javafx.scene.image.Image blur(javafx.scene.image.Image img, int blurFactor) {
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();

        for (int x = blurFactor; x < ((int) img.getWidth() - blurFactor); x++) {
            for (int y = blurFactor; y < ((int) img.getHeight() - blurFactor); y++) {
                javafx.scene.paint.Color sourceColor = reader.getColor(x, y);
                double Red = sourceColor.getRed();
                double Green = sourceColor.getGreen();
                double Blue = sourceColor.getBlue();
                double averageRed = 0.0;
                double averageGreen = 0.0;
                double averageBlue = 0.0;
                for (int w = -blurFactor; w <= blurFactor; w++) {
                    for (int h = -blurFactor; h <= blurFactor; h++) {
                        averageRed += reader.getColor(x + w, y + h).getRed();
                        averageGreen += reader.getColor(x + w, y + h).getGreen();
                        averageBlue += reader.getColor(x + w, y + h).getBlue();
                    }
                }
                double divideFactor = (double)(blurFactor*2 + 1) * (double)(blurFactor*2 + 1) * 2;
                averageRed = averageRed/divideFactor;
                averageGreen =averageGreen/divideFactor;
                averageBlue = averageBlue/divideFactor;
                averageRed += Red *0.5;
                averageGreen += Green *0.5;
                averageBlue += Blue *0.5;
                writer.setColor(x, y, new javafx.scene.paint.Color(averageRed, averageGreen, averageBlue, 1.0));
            }
        }
        return tmp;
    }
}


