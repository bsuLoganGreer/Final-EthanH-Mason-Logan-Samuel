package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EdgeTest {
    @Test
    public void checkColorDifference() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        PixelReader pixels = testImage.getPixelReader();
        Image edgedImage = new Edge().edge(testImage);
        PixelReader edgedPixels = edgedImage.getPixelReader();

        for (int x = 0; x < testImage.getWidth() - 2; x++) {
            for (int y = 0; y < testImage.getHeight(); y++) {
                if (new Edge().shouldSetBlack(pixels.getColor(x, y), pixels.getColor(x + 1, y), 0.5)){
                    Assertions.assertEquals(Color.BLACK, edgedPixels.getColor(x, y));
                }
                else{
                    Assertions.assertEquals(Color.WHITE, edgedPixels.getColor(x, y));
                }
            }
        }
    }

    @Test
    public void checkSetBlack(){


    }
    @Test
    public void checkSetWhite(){

    }
}