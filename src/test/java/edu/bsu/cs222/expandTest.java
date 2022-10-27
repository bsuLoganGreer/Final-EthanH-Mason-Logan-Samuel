package edu.bsu.cs222;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class expandTest {

    @Test
    public void testSizeChange() throws FileNotFoundException {
        Expand expand = new Expand();
        PhotoManager manager = new PhotoManager();
        String source = "/src/resources/test.png";
        Image test2;
        test2 = manager.getImage(source);
        Image test = expand.resizeImage(test2, 2);
        Assertions.assertNotEquals(test,test2);
    }
}

