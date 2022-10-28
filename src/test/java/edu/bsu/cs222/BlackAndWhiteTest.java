package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BlackAndWhiteTest {

    @Test
    public void checkBlackAndWhite() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image blackAndWhite = new BlackAndWhite().blackAndWhite(testImage);
        PixelReader pixels = blackAndWhite.getPixelReader();

        boolean containsColor = false;
        for (int x = 0; x < testImage.getWidth(); x++) {
            for (int y = 0; y < testImage.getHeight(); y++) {
                Color sample1 = pixels.getColor(x, y);
                if (!sample1.equals(Color.BLACK) && !sample1.equals(Color.WHITE))
                    containsColor = true;
            }
        }
        Assertions.assertFalse(containsColor);
    }
}