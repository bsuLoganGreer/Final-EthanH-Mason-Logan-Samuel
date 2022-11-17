package edu.bsu.cs222;

import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ColorWheel {

    Color primaryColor;

    public void ColorWheel(Color color){

        primaryColor = color;


    }

    public Color getFirstComplementaryColor(Color color){
        return color;
    }

    public Color getSecondComplementaryColor(Color color) {
        return color;
    }

}
