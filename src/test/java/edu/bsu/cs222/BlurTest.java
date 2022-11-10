package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static java.lang.Math.abs;

public class BlurTest {

    @Test
    public void checkSameSize() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image blurredImage = new Blur().blur(testImage);

        Assertions.assertEquals(testImage.getWidth(), blurredImage.getWidth());
        Assertions.assertEquals(testImage.getHeight(), blurredImage.getHeight());
    }

    @Test
    public void averageRedColorDifferenceDecreases() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        PixelReader pixels = testImage.getPixelReader();
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();

        int differenceSumTest = 0;
        int differenceSumBlur = 0;
        for (int x = 0; x < testImage.getWidth() - 2; x++) {
            for (int y = 0; y < testImage.getHeight(); y++) {
                Color sample1 = pixels.getColor(x, y);
                Color sample2 = pixels.getColor(x + 1, y);
                differenceSumTest += abs((int)(sample1.getRed() * 10.0) - (int)(sample2.getRed() * 10.0));
                Color sample1Blur = blurredPixels.getColor(x, y);
                Color sample2Blur = blurredPixels.getColor(x + 1, y);
                differenceSumBlur += abs((int)(sample1Blur.getRed() * 10.0) - (int)(sample2Blur.getRed() * 10.0));

            }
        }

        Assertions.assertTrue(differenceSumTest > differenceSumBlur);
    }

    @Test
    public void checkGrey() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/blurTest.png"));
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();

        Color Pixel = blurredPixels.getColor(1, 1);

        Assertions.assertEquals(Pixel, Color.rgb(113, 113, 113));
    }


}
