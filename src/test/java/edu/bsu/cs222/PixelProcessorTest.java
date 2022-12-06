package edu.bsu.cs222;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PixelProcessorTest {
    @Test
    public void testMiddlePixel() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/10by10_White.png"));
        PixelProcessor pixels = new PixelProcessor(testImage);
        Assertions.assertTrue(pixels.shouldProcess(1,1));
    }
    @Test
    public void testDefaultHeight() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/10by10_White.png"));
        PixelProcessor pixels = new PixelProcessor(testImage);
        Assertions.assertTrue(pixels.shouldProcess(9,9));

    }
    @Test
    public void testSetProcessed() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/10by10_White.png"));
        PixelProcessor pixels = new PixelProcessor(testImage);
        pixels.setProcessed(5,5);
        Assertions.assertFalse(pixels.shouldProcess(5,5));

    }

    @Test
    public void testSetBlackPixelsProcessedTrue() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        PixelProcessor pixels = new PixelProcessor(testImage);
        pixels.processBlackPixels();
        Assertions.assertTrue(pixels.shouldProcess(2,2));

    }

    @Test
    public void testSetBlackPixelsProcessedFalse() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        PixelProcessor pixels = new PixelProcessor(testImage);
        pixels.processBlackPixels();
        Assertions.assertTrue(pixels.shouldProcess(0,0));

    }

}
