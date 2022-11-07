package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

public class ColorWheelTest {

    @Test
    public void checkFirstSplitComplementaryColor() {
        Color testColor = Color.hsb(0.0, .8, .8);
        System.out.print("Red: " + testColor.getRed() + ", Green: " + testColor.getGreen() + ", Blue: " + testColor.getBlue());
        Color test2Color = Color.hsb(150,.14,.88);
        System.out.print("Red: " + test2Color.getRed() + ", Green: " + test2Color.getGreen() + ", Blue: " + test2Color.getBlue());
        Color test3Color = Color.hsb(210,.94,.72);

    }

    @Test
    public void checkSecondSplitComplementaryColor() {
        Color testColor = Color.hsb(0.0, 1.0, 1.0);
        System.out.print("Red: " + testColor.getRed() + ", Green: " + testColor.getGreen() + ", Blue: " + testColor.getBlue());
        Color test2Color = Color.hsb(120,1.0,1.0);
        System.out.print("Red: " + test2Color.getRed() + ", Green: " + test2Color.getGreen() + ", Blue: " + test2Color.getBlue());
        Color test3Color = Color.hsb(240,1.0,1.0);

    }
}
