package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Stylize {

    //For testing purposes we will use this split complementary pair
    //main: #ff782f, or (255, 120, 47)
    //secondary: #2f4eff or (47, 78, 255)
    //tertiary: #2fff0 or (47, 255, 224)
    private Color primary;
    private Color secondary;
    private Color tertiary;

    public Image stylize(Image img){
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        for (int x = 0; x < ((int) img.getWidth()); x++) {
            for (int y = 0; y < ((int) img.getHeight()); y++) {
                Color sourceColor = reader.getColor(x, y);
                writer.setColor(x,y, getCorrectColor(sourceColor));
            }
        }
        return tmp;
    }

    public Color getCorrectColor(Color sourceColor){
        if (shouldSetPrimary(sourceColor))
            return primary;
        else if (shouldSetSecondary(sourceColor))
            return secondary;
        else if (shouldSetTertiary(sourceColor))
            return tertiary;

        return Color.WHITE;
    }

    public void setColors(Color color){
        primary = color;
        secondary = new ColorWheel().getFirstComplementaryColor(color);
        tertiary = new ColorWheel().getSecondComplementaryColor(color);
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
