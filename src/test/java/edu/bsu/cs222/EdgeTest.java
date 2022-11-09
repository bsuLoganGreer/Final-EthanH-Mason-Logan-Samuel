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
            for (int y = 0; y < testImage.getHeight() - 1; y++) {
                if (new Edge().shouldSetBlack(pixels.getColor(x, y), pixels.getColor(x + 1, y), 0.15) ||
                        new Edge().shouldSetBlack(pixels.getColor(x, y), pixels.getColor(x, y+1), 0.15)){
                    Assertions.assertEquals(Color.BLACK, edgedPixels.getColor(x, y));
                }
                else{
                    Assertions.assertEquals(Color.WHITE, edgedPixels.getColor(x, y));
                }
            }
        }
    }

    @Test
    public void checkSetBlack() {
        Color test1 = Color.rgb(0,0,0);
        Color test2 = Color.rgb(255,255,255);
        Assertions.assertTrue(new Edge().shouldSetBlack( test1, test2, 0.5));
    }


    @Test
    public void checkSetWhite(){
        Color test1 = Color.rgb(0,0,0);
        Color test2 = Color.rgb(0,0,0);
        Assertions.assertFalse(new Edge().shouldSetBlack( test1, test2, 0.5));
    }

    @Test
    public void checkSimilarColor(){
        Color test1 = new Color(.5,.5,.5, 1.0);
        Color test2 = new Color(.5,.5,1.0,1.0);
        Assertions.assertFalse(new Edge().shouldSetBlack(test1, test2, 0.5));
    }

    @Test
    public void checkDistantColor(){
        Color test1 = new Color(.5,.5,.5, 1.0);
        Color test2 = new Color(.55,.75,.75,1.0);
        Assertions.assertTrue(new Edge().shouldSetBlack(test1, test2, 0.5));
    }
}