package edu.bsu.cs222;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ResizeImage {

    public javafx.scene.image.Image expand(javafx.scene.image.Image img, int resizeFactor){
        WritableImage tmp = new WritableImage((int)img.getWidth()*resizeFactor, (int)img.getHeight()*resizeFactor);
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        for (int x = 0;x<(int)img.getWidth(); x++){
            for (int y = 0;y<(int)img.getHeight(); y++){
                Color sourceColor = reader.getColor(x,y);
                for (int width = 0;width<resizeFactor; width++) {
                    for (int hight = 0; hight < resizeFactor; hight++) {
                        writer.setColor(x * 2 + width, y * 2 + hight, sourceColor);
                    }
                }
            }
        }

        return tmp;
    }

    public Image shrink(Image img, int resizeFactor) {

        WritableImage tmp = new WritableImage((int)img.getWidth()/resizeFactor, (int)img.getHeight()/resizeFactor);
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        for (int x = 0;x<(int)tmp.getWidth(); x++){
            for (int y = 0;y<(int)tmp.getHeight(); y++){
                Color sourceColor = reader.getColor(x*resizeFactor,y*resizeFactor);
                writer.setColor(x, y, sourceColor);

            }
        }

        return tmp;
    }
}

