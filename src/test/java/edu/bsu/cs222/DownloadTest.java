package edu.bsu.cs222;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class DownloadTest {
    @Test
    public void testDownload() throws IOException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/test.png"));
        new Download().download(testImage, "testImage.png");
        Image downloadedImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/modified_testImage.png"));

        Assertions.assertEquals(testImage, downloadedImage);
    }
}
