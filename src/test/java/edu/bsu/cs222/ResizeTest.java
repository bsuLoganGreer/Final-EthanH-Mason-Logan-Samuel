package edu.bsu.cs222;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ResizeTest {

    @Test
    public void checkExpandSize() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image expandedImage = new ResizeImage().expand(testImage, 2);

        Assertions.assertEquals(testImage.getWidth() * 2, expandedImage.getWidth());
        Assertions.assertEquals(testImage.getHeight() * 2, expandedImage.getHeight());
    }

    @Test
    public void checkPixelPreservedExpand() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Color sample1 = testImage.getPixelReader().getColor((int) testImage.getWidth() / 2, (int) testImage.getHeight() / 2);
        Image expandedImage = new ResizeImage().expand(testImage, 2);
        Color sample2 = expandedImage.getPixelReader().getColor((int) expandedImage.getWidth() / 2, (int) expandedImage.getHeight() / 2);

        Assertions.assertEquals(sample1, sample2);
    }


    @Test
    public void checkShrinkSize() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image expandedImage = new ResizeImage().shrink(testImage, 2);

        Assertions.assertEquals(testImage.getWidth() / 2, expandedImage.getWidth());
        Assertions.assertEquals(testImage.getHeight() / 2, expandedImage.getHeight());
    }

    @Test
    public void checkPixelPreservedShrink() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Color sample1 = testImage.getPixelReader().getColor((int) testImage.getWidth() / 2, (int) testImage.getHeight() / 2);
        Image shrunkImage = new ResizeImage().shrink(testImage, 2);
        Color sample2 = shrunkImage.getPixelReader().getColor((int) shrunkImage.getWidth() / 2, (int) shrunkImage.getHeight() / 2);

        Assertions.assertEquals(sample1, sample2);
    }
}

