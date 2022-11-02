package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DownloadTest {
    @Test
    public void testDownload() throws IOException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        PixelReader pixels = testImage.getPixelReader();
        new Download().download(testImage, "test.png");
        Image downloadedImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/modified_test.png"));
        PixelReader copypixels = downloadedImage.getPixelReader();

        for (int x = 0; x < testImage.getWidth(); x++) {
            for (int y = 0; y < testImage.getHeight(); y++) {
                Assertions.assertEquals(pixels.getColor(x,y), copypixels.getColor(x, y));
            }
        }

    }
}
