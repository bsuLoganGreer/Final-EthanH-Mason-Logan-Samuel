package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StylizeTest {



    @Test
    public void checkSetPrimary() {
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertTrue(new Stylize().SetPrimary( test1));
    }

    @Test
    public void checkDontSetPrimary(){
        Color test1 = Color.rgb(0,0,0);
        Assertions.assertFalse(new Stylize().SetPrimary( test1));
    }

    @Test
    public void checkSetSecondary() {
        Color test1 = Color.rgb(0,0,0);
        Assertions.assertTrue(new Stylize().SetSecondary(test1));
    }

    @Test
    public void checkDontSetSecondary(){
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertFalse(new Stylize().SetSecondary(test1));

    }

    @Test
    public void checkSetTertiary(){
        Color test1 = Color.rgb(255,255,255);
        Assertions.assertTrue(new Stylize().SetTertiary(test1));
    }

    @Test
    public void checkDontSetTertiary(){
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertFalse(new Stylize().SetTertiary(test1));
    }
}
