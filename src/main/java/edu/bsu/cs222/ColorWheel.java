package edu.bsu.cs222;

import javafx.scene.paint.Color;

public class ColorWheel {

    public Color getFirstComplementaryColor(Color color){
        Double hue = color.getHue() + 150.0;
        if (hue > 360){hue -= 360;}

        Color returnColor = Color.hsb(hue, color.getSaturation(), color.getBrightness());

        return returnColor;
    }

    public Color getSecondComplementaryColor(Color color) {
        Double hue = color.getHue() + 210.0;
        if (hue > 360){hue -= 360;}

        Color returnColor = Color.hsb(hue, color.getSaturation(), color.getBrightness());

        return returnColor;
    }

}
