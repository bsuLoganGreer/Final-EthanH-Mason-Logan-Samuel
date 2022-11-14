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
    public void checkMiddle() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5Blur.png"));
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();


        Color Pixel = blurredPixels.getColor(2, 2);

        Assertions.assertEquals(Pixel, Color.rgb(51, 51, 51));
    }

    @Test
    public void checkAverageCorner() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5Blur.png"));
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();

        Color Pixel =blurredPixels.getColor(0, 0);
        Assertions.assertEquals(Pixel, Color.rgb(0, 0, 0));
    }

    @Test
    public void checkAverageSide() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5Blur.png"));
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();

        Color Pixel =blurredPixels.getColor(2, 0);
        Assertions.assertEquals(Pixel, Color.rgb(0, 0, 0));
    }
    @Test
    public void checkMiddleReverse() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5BlurReverse.png"));
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();

        Color Pixel = blurredPixels.getColor(2, 2);

        Assertions.assertEquals(Pixel, Color.rgb(204, 204, 204));
    }

    @Test
    public void checkAverageCornerReverse() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5BlurReverse.png"));
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();

        Color Pixel =blurredPixels.getColor(0, 0);
        Assertions.assertEquals(Pixel, Color.rgb(255, 255, 255));
    }

    @Test
    public void checkAverageSideReverse() throws IOException{
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5x5BlurReverse.png"));
        Image blurredImage = new Blur().blur(testImage);
        PixelReader blurredPixels = blurredImage.getPixelReader();

        Color Pixel =blurredPixels.getColor(2, 0);
        Assertions.assertEquals(Pixel, Color.rgb(255, 255, 255));
    }


}
