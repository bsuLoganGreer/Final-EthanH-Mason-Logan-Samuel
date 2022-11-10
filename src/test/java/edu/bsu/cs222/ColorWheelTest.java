package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColorWheelTest {

    @Test
    public void checkFirstSplitComplementaryColor() {
        Color testColor = Color.hsb(0.0, 1.0, 1.0);
        Assertions.assertEquals(Color.hsb(150,.8,.8), new ColorWheel().getFirstComplementaryColor(testColor));

    }

    @Test
    public void checkSecondSplitComplementaryColor() {
        Color testColor = Color.hsb(0.0, 1.0, 1.0);
        Assertions.assertEquals(Color.hsb(210,.8,.8), new ColorWheel().getSecondComplementaryColor(testColor));

    }
}
