package edu.bsu.cs222;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class blur {
    public static void main(String[] args) throws IOException {
        getPic();
    }


public static BufferedImage getPic() throws IOException {
    Image input = null;
    try {

        Image fin = new Image() {
            @Override
            public int getWidth(ImageObserver observer) {
                return 0;
            }

            @Override
            public int getHeight(ImageObserver observer) {
                return 0;
            }

            @Override
            public ImageProducer getSource() {
                return null;
            }

            @Override
            public Graphics getGraphics() {
                return null;
            }

            @Override
            public Object getProperty(String name, ImageObserver observer) {
                return null;
            }
        };

        input = read((ImageInputStream) fin);

    } catch (IOException e) {
        e.printStackTrace();
    }
    return (BufferedImage) input;
}
private static BufferedImage copyPic() throws IOException{

    Image output = new BufferedImage(
            getPic().getWidth((ImageObserver) getPic()), getPic().getHeight((ImageObserver) getPic()),
            BufferedImage.TYPE_INT_RGB);
    return (BufferedImage) output;
}


public static BufferedImage blurBuffImage() throws IOException {
    Color color[];
    int i = 0;
    int max = 400, rad = 10;
    int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
    color = new Color[max];

    // blurring of an image

            int x=0, y=0, x1, y1, ex = 5, d;

            // Running nested for loops for each pixel
            // and blurring it
            for (x = rad; x < getPic().getHeight((ImageObserver) getPic()) - rad; x++) {
                for (y = rad; y < getPic().getWidth((ImageObserver) getPic()) - rad; y++) {
                    for (x1 = x - rad; x1 < x + rad; x1++) {
                        for (y1 = y - rad; y1 < y + rad; y1++) {
                            color[i++] = new Color(
                                    getPic().getRGB(x1, y1));
                        }
                    }

                    // Smoothing colors of image
                    i = 0;
                    for (d = 0; d < max; d++) {
                        a1 = a1 + color[d].getAlpha();
                    }

                    a1 = a1 / (max);
                    for (d = 0; d < max; d++) {
                        r1 = r1 + color[d].getRed();
                    }

                    r1 = r1 / (max);
                    for (d = 0; d < max; d++) {
                        g1 = g1 + color[d].getGreen();
                    }

                    g1 = g1 / (max);
                    for (d = 0; d < max; d++) {
                        b1 = b1 + color[d].getBlue();
                    }

                    b1 = b1 / (max);
                    int sum1 = (a1 << 24) + (r1 << 16)
                            + (g1 << 8) + b1;
                   copyPic().setRGB(y, x, sum1);

                }
            }

            // Writing the blurred image on the disc where
            // directory is passed as an argument
             ImageIO.write((RenderedImage) copyPic(), "jpeg",new File("C:/Downloads/BlurredImage.jpeg"));


            // Message to be displayed in the console when
            // program is successfully executed
            System.out.println("Image blurred successfully !");


            return (BufferedImage) copyPic();
    }
    private static Object blr() throws IOException {
        WritableImage wr = null;
        blurBuffImage();
        wr = new WritableImage(blurBuffImage().getWidth(), blurBuffImage().getHeight());
        PixelWriter pw = wr.getPixelWriter();
        for (int x = 0; x < blurBuffImage().getWidth(); x++) {
            for (int y = 0; y < blurBuffImage().getHeight(); y++) {
                pw.setArgb(x, y, blurBuffImage().getRGB(x, y));
            }
        }

        return new ImageView(wr).getImage();
    }


    public javafx.scene.image.Image blur(javafx.scene.image.Image img, int blurFactor) {
        WritableImage tmp = new WritableImage(img.getPixelReader(), (int) img.getWidth(), (int)img.getHeight());
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        for (int x = blurFactor; x < ((int) img.getWidth() - blurFactor); x++) {
            for (int y = blurFactor; y < ((int) img.getHeight() - blurFactor); y++) {
                javafx.scene.paint.Color sourceColor = reader.getColor(x, y);
                double Red = sourceColor.getRed();
                double Green = sourceColor.getGreen();
                double Blue = sourceColor.getBlue();
                double averageRed = 0.0;
                double averageGreen = 0.0;
                double averageBlue = 0.0;
                for (int w = -blurFactor; w <= blurFactor; w++) {
                    for (int h = -blurFactor; h <= blurFactor; h++) {
                        averageRed += reader.getColor(x + w, y + h).getRed();
                        averageGreen += reader.getColor(x + w, y + h).getGreen();
                        averageBlue += reader.getColor(x + w, y + h).getBlue();
                    }
                }
                double divideFactor = (double)(blurFactor*2 + 1) * (double)(blurFactor*2 + 1) * 2;
                averageRed = averageRed/divideFactor;
                averageGreen =averageGreen/divideFactor;
                averageBlue = averageBlue/divideFactor;
                averageRed += Red *0.5;
                averageGreen += Green *0.5;
                averageBlue += Blue *0.5;
                writer.setColor(x, y, new javafx.scene.paint.Color(averageRed, averageGreen, averageBlue, 1.0));
            }
        }
        return tmp;
    }
}


