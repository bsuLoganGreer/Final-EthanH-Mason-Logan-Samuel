package edu.bsu.cs222;

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
        height = sc.nextInt();
        width = sc.nextInt();
        File input = new File("C:\\Users\\jayfe\\cs224_labs\\Test.jpg");
        BufferedImage image = ImageIO.read(input);
        BufferedImage resized = resizeImage(image, width,height);

        File output = new File("C:\\Users\\jayfe\\cs224_labs\\Test5.png");
        ImageIO.write(resized, "png", output);
        System.out.println("Resize Successful");
    }

    public static BufferedImage resizeImage(BufferedImage img, int width, int height) {

        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;

    }
}

