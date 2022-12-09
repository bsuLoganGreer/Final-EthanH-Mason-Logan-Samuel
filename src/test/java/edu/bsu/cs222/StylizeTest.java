package edu.bsu.cs222;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StylizeTest {



    @Test
    public void checkSetPrimaryTrue() {
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertTrue(new Stylize().SetPrimary( test1));
    }

    @Test
    public void checkSetPrimaryFalse(){
        Color test1 = Color.rgb(0,0,0);
        Assertions.assertFalse(new Stylize().SetPrimary( test1));
    }

    @Test
    public void checkSetSecondaryTrue() {
        Color test1 = Color.rgb(0,0,0);
        Assertions.assertTrue(new Stylize().SetSecondary(test1));
    }

    @Test
    public void checkSetSecondaryFalse(){
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertFalse(new Stylize().SetSecondary(test1));

    }

    @Test
    public void checkSetTertiaryTrue(){
        Color test1 = Color.rgb(255,255,255);
        Assertions.assertTrue(new Stylize().SetTertiary(test1));
    }

    @Test
    public void checkSetTertiaryFalse(){
        Color test1 = Color.rgb(117,117,117);
        Assertions.assertFalse(new Stylize().SetTertiary(test1));
    }
}
