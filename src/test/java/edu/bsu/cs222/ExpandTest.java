package edu.bsu.cs222;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExpandTest {

    @Test
    public void checkChangeSize() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Image expandedImage = new Expand().resizeImage(testImage, 2);

        Assertions.assertEquals(testImage.getWidth() * 2, expandedImage.getWidth());
        Assertions.assertEquals(testImage.getHeight() * 2, expandedImage.getHeight());
    }

    @Test
    public void checkPixelPreserved() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        Color sample1 = testImage.getPixelReader().getColor((int)testImage.getWidth() / 2, (int)testImage.getHeight() / 2);
        Image expandedImage = new Expand().resizeImage(testImage, 2);
        Color sample2 = expandedImage.getPixelReader().getColor((int)expandedImage.getWidth() / 2, (int)expandedImage.getHeight() / 2);

        Assertions.assertEquals(sample1,sample2);
    }
}

