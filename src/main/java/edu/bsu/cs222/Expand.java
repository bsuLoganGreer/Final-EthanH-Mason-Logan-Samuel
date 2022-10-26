package edu.bsu.cs222;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Expand {
    public static void main(String args[]) throws IOException{

        Scanner sc = new Scanner (System.in);
        int width ,height;
        System.out.println("Enter Height and width of image");
        File input = new File("C:\\Users\\jayfe\\cs224_labs\\Test.jpg");
        BufferedImage image = ImageIO.read(input);

        height = image.getHeight() * 2;
        width = image.getWidth() * 2;
        BufferedImage resized = resizeImage(image, width,height);

        File output = new File("C:\\Users\\jayfe\\cs224_labs\\Test5.png");
        ImageIO.write(resized, "png", output);
        System.out.println("Resize Successful");
        System.out.println("Image size" + height);
    }

    public static BufferedImage resizeImage(BufferedImage img, int width, int height) {

        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;

    }
    public javafx.scene.image.Image resizeImage(javafx.scene.image.Image img, int resizeFactor){
        WritableImage tmp = new WritableImage((int)img.getWidth()*resizeFactor, (int)img.getWidth()*resizeFactor);
        WritableImage source = (WritableImage) img;
        PixelReader reader = img.getPixelReader();
        PixelWriter writer = tmp.getPixelWriter();
        for (int x = 0;x<(int)img.getWidth(); x++){
            for (int y = 0;y<(int)img.getHeight(); y++){
                Color sourceColor = reader.getColor(x,y);
                for (int w = 0;w<resizeFactor; w++) {
                    for (int h = 0; h < resizeFactor; h++) {
                        writer.setColor(x * 2 + w, y * 2 + h, sourceColor);
                    }
                }
            }
        }
        return tmp;
    }
}

