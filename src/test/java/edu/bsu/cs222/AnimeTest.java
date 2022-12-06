package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AnimeTest {
    @Test
    public void testAverageWhite(){
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(Color.WHITE);
        colorList.add(Color.WHITE);
        Assertions.assertEquals(Color.WHITE,new Anime().getAverage(colorList));
    }
    @Test
    public void testAverageGray(){
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(Color.WHITE);
        colorList.add(Color.BLACK);
        Assertions.assertEquals(new Color(.5,.5,.5,1.0),new Anime().getAverage(colorList));
    }
    @Test
    public void testAverageThree(){
        ArrayList<Color> colorList = new ArrayList<>();
        colorList.add(Color.WHITE);
        colorList.add(Color.BLACK);
        colorList.add(new Color(.5,.5,.5,1.0));
        Assertions.assertEquals(new Color(.5,.5,.5,1.0),new Anime().getAverage(colorList));
    }

    @Test
    public void testSetBlackPixelsProcessedTrue() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);

        animeTest.processBlackPixels();
        Assertions.assertTrue(animeTest.pixelProcessor.shouldProcess(2,2));

    }

    @Test
    public void testSetBlackPixelsProcessedFalse() throws FileNotFoundException {
        Image testImage = new Image(new FileInputStream(System.getProperty("user.dir") + "/src/resources/5X5Blur.png"));
        Anime animeTest = new Anime(testImage);
        animeTest.processBlackPixels();
        Assertions.assertFalse(animeTest.pixelProcessor.shouldProcess(0,0));

    }
}
