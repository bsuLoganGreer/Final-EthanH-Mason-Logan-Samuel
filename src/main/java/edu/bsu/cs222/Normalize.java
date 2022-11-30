package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Normalize {

    public Image normalize(Image img){
        PixelReader reader = img.getPixelReader();
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelWriter writer = tmp.getPixelWriter();
        for (int w=0; w < img.getWidth(); w++) {
            for (int h = 0; h < img.getHeight(); h++) {
                writer.setColor(w,h,getRoundedColor(reader.getColor(w,h)));
            }
        }
        return tmp;
    }


    public int getRoundedValue(int x) {
       int y =x/ 50;
       return y*50;
    }

    public Color getRoundedColor(Color color) {
        return Color.rgb(getRoundedValue((int) (color.getRed()*255)), getRoundedValue((int) (color.getGreen()*255)),
                getRoundedValue((int) (color.getBlue()*255)));
    }
}
