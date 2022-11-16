package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PixelateTest {
    @Test
    public void checkAverageWhite() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/10X10White.png"));
        PixelReader testReader = testImage.getPixelReader();

        Color Pixel = new Pixelate().getAveragePixels(testReader, 0, 0);
        Assertions.assertEquals(Pixel, Color.WHITE);
    }
}
