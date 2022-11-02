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
        String testDirectory = System.getProperty("user.dir") + "/src/resources/test.png";
        Image testImage = new Image(new FileInputStream(testDirectory));
        PixelReader pixels = testImage.getPixelReader();
        new Download().download(testImage, testDirectory);
        Image downloadedImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test_modified.png"));
        PixelReader copypixels = downloadedImage.getPixelReader();

        for (int x = 0; x < testImage.getWidth(); x++) {
            for (int y = 0; y < testImage.getHeight(); y++) {
                Assertions.assertEquals(pixels.getColor(x,y), copypixels.getColor(x, y));
            }
        }

    }

    @Test
    public void testGetModifiedFileDirectory(){
        String testDirectory = System.getProperty("user.dir") + "/src/resources/test.png";
        String returnedDirectory = new Download().getModifiedFileDirectory(testDirectory);

        Assertions.assertEquals(System.getProperty("user.dir") + "/src/resources/test_modified.png", returnedDirectory);
    }
}
