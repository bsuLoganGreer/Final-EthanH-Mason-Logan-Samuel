package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StylizeTest {



    @Test
    public void checkSetPrimary() {
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertTrue(new Stylize().shouldSetPrimary( test1));
    }

    @Test
    public void checkDontSetPrimary(){
        Color test1 = Color.rgb(0,0,0);
        Assertions.assertFalse(new Stylize().shouldSetPrimary( test1));
    }

    @Test
    public void checkSetSecondary() {
        Color test1 = Color.rgb(0,0,0);
        Assertions.assertTrue(new Stylize().shouldSetSecondary(test1));
    }

    @Test
    public void checkDontSetSecondary(){
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertFalse(new Stylize().shouldSetSecondary(test1));

    }

    @Test
    public void checkSetTertiary(){
        Color test1 = Color.rgb(255,255,255);
        Assertions.assertTrue(new Stylize().shouldSetTertiary(test1));
    }

    @Test
    public void checkDontSetTertiary(){
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertFalse(new Stylize().shouldSetTertiary(test1));
    }
}
