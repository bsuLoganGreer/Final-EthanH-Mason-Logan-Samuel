package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.Math.abs;

public class Edge {

    public javafx.scene.image.Image edge(javafx.scene.image.Image image) throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        PixelReader reader = testImage.getPixelReader();
        WritableImage tmp = new WritableImage(image.getPixelReader(), (int) image.getWidth(), (int)image.getHeight());
        PixelWriter writer = tmp.getPixelWriter();


        int original = 0;
        for (int x = 0; x < testImage.getWidth() - 2; x++) {
            for (int y = 0; y < testImage.getHeight(); y++) {
                Color sample1 = reader.getColor(x, y);
                Color sample2 = reader.getColor(x + 1, y);
                original+= abs((int)(sample1.getRed() * 10.0)- (int)(sample2.getRed() * 10.0));
                writer.setArgb(x,y,original);

            }
        }
        return tmp;
    }

    public boolean shouldSetBlack(Color color, Color color1, double v) {
        return true;
    }
}
