package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Edge {

    public Image edge(Image image) throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        PixelReader pixels = testImage.getPixelReader();
        WritableImage tmp = new WritableImage(image.getPixelReader(), (int) image.getWidth(), (int)image.getHeight());
        PixelWriter writer = tmp.getPixelWriter();


        for (int x = 0; x < testImage.getWidth() - 2; x++) {
            for (int y = 0; y < testImage.getHeight(); y++) {
                if (shouldSetBlack(pixels.getColor(x, y), pixels.getColor(x + 1, y), 0.5)){
                    writer.setColor(x,y,Color.BLACK);
                }
                else{
                    writer.setColor(x,y,Color.WHITE);
                }
            }
        }
        return tmp;
    }

    public boolean shouldSetBlack(Color color, Color color1, double v) {
        double sumColor1 = color.getRed();
        sumColor1 += color.getGreen();
        sumColor1 += color.getBlue();

        double sumColor2 = color1.getRed();
        sumColor2 += color1.getBlue();
        sumColor2 += color1.getGreen();
        double difference = Math.abs(sumColor1 - sumColor2);
        return difference > v;
    }
}
