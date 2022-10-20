package edu.bsu.cs222;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class blur {

public BufferedImage getPic() throws IOException {

    File fin = new File("C:\\Users\\Leffe\\Documents\\freshmen year\\cs 120\\MasonLeffel_project_3");

    BufferedImage input = ImageIO.read(fin);
    return input;
}
private BufferedImage copyPic() throws IOException{

    BufferedImage output = new BufferedImage(
            getPic().getWidth(), getPic().getHeight(),
            BufferedImage.TYPE_INT_RGB);
    return output;
}

public void blurPic() throws IOException{
            Color color[];
            int i = 0;
            int max = 400, rad = 10;
            int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
            color = new Color[max];

            // blurring of an image

            int x = 1, y = 1, x1, y1, ex = 5, d = 0;

            // Running nested for loops for each pixel
            // and blurring it
            for (x = rad; x < getPic().getHeight() - rad; x++) {
                for (y = rad; y < getPic().getWidth() - rad; y++) {
                    for (x1 = x - rad; x1 < x + rad; x1++) {
                        for (y1 = y - rad; y1 < y + rad; y1++) {
                            color[i++] = new Color(
                                    getPic().getRGB(y1, x1));
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
                    copyPic().setRGB(y, x, (int)(sum1));
                }
            }

            // Writing the blurred image on the disc where
            // directory is passed as an argument
            ImageIO.write(
                    copyPic(), "jpeg",
                    new File("C:/Downloads/BlurredImage.jpeg"));



            // Message to be displayed in the console when
            // program is successfully executed
            System.out.println("Image blurred successfully !");
        }
    }


