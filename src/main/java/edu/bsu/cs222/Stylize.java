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
    //tertiary: #2fffe0 or (47, 255, 224)
    private Color primary = Color.rgb(255, 120, 47);
    private Color secondary = Color.rgb(47, 78, 255);
    private Color tertiary = Color.rgb(47, 255, 224);

    public Image stylize(Image img){
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        for (int x = 0; x < ((int) img.getWidth()); x++) {
            for (int y = 0; y < ((int) img.getHeight()); y++) {
                Color sourceColor = reader.getColor(x, y);
                if (SetPrimary(sourceColor))
                    writer.setColor(x, y, primary);
                if (SetSecondary(sourceColor))
                    writer.setColor(x, y, secondary);
                if (SetTertiary(sourceColor))
                    writer.setColor(x, y, tertiary);
            }
        }
        return tmp;
    }
    public Image stylize(Image image, Color primaryColor, Color secondaryColor, Color tertiaryColor){
        primary = primaryColor;
        secondary = secondaryColor;
        tertiary = tertiaryColor;
        return stylize(image);
    }

    public boolean SetPrimary(Color color) {
        return color.getBrightness() <= 0.75 && color.getBrightness() >= 0.25;
    }

    public boolean SetTertiary(Color color) {
        return color.getBrightness() > 0.75;
    }

    public boolean SetSecondary(Color color) {
        return color.getBrightness() < .25;
    }
}
