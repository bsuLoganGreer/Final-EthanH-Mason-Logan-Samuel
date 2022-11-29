package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColorWheelTest {

    //For testing purposes we will use this split complementary pair
    //main: #ff782f, or (255, 120, 47)
    //secondary: #2f4eff or (47, 78, 255)
    //tertiary: #2fffe0 or (47, 255, 224)
    @Test
    public void CheckFirstComplementaryColor(){
        Color TestColor = Color.hsb(150, 1.0, 1.0);
        Color SecondaryColor = new ColorWheel().getFirstComplementaryColor(TestColor);

        Assertions.assertEquals(150, SecondaryColor.getHue());



    }

    @Test
    public void CheckSecondaryComplementaryColor(){
        Color TestColor = Color.hsb(210, 1.0, 1.0);
        Color TertiaryColor = new ColorWheel().getSecondComplementaryColor(TestColor);

        Assertions.assertEquals(210, TertiaryColor.getHue());

    }
}
