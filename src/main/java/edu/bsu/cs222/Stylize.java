package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Stylize {

    //For testing purposes we will use this split complementary pair
    //main: #ff782f, or (255, 120, 47)
    //secondary: #592fff or (89, 47, 255)
    //tertiary: #2fff82 or (47, 255, 130)
    private Color primary = Color.rgb(255, 120, 47);
    private Color secondary = Color.rgb(89, 47, 255);
    private Color tertiary = Color.rgb(47, 255, 130);

    public Image stylize(Image img){
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        return tmp;
    }
    public Image stylize(Image image, Color primaryColor, Color secondaryColor, Color tertiaryColor){
        primary = primaryColor;
        secondary = secondaryColor;
        tertiary = tertiaryColor;
        return stylize(image);
    }

    public boolean shouldSetPrimary(Color color) {
        return color.getBrightness() <= 0.75 && color.getBrightness() >= 0.25;
    }

    public boolean shouldSetTertiary(Color color) {
        return color.getBrightness() > 0.75;
    }

    public boolean shouldSetSecondary(Color color) {
        return color.getBrightness() < .25;
    }
}
