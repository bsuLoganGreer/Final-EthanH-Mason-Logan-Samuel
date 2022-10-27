package edu.bsu.cs222;

import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BlurTest {
    String envRootDir = System.getProperty("user.dir");
    Image testImage = new Image(new FileInputStream("/src/resources/test.png"));

    public BlurTest() throws FileNotFoundException {
    }

    @Test
    public void sameSize(){

    }
}
