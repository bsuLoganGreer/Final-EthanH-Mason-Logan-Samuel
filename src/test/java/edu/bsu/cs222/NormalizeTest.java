package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class NormalizeTest {

    @Test
    public void checkAverageWhite() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        PixelReader testReader = testImage.getPixelReader();

        Color normal = new Normalize().getAveragePixels(testReader, 0, 0);
        Assertions.assertEquals(normal, Color.WHITE);
    }



    @Test
    public void  checkBlue() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        PixelReader testReader = testImage.getPixelReader();


    }
}


