package edu.bsu.cs222;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ColorWheel {

    public Color getPrimaryColor(Color color){
        int hue = 1;
        double saturation = 1.0;
        double brightness = 1.0;

        Color mainColor = Color.hsb(hue, saturation, brightness);
        return color;
    }

    public Color getFirstComplementaryColor(Color color){
        return color;
    }

    public Color getSecondComplementaryColor(Color color) {
        return color;
    }

}
