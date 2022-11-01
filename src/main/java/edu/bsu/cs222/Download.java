package edu.bsu.cs222;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class Download {
    public Download(Image displayImage) throws IOException {
        ImageIO.write((RenderedImage) displayImage, "jpeg", new File("D:/test/BlurredImage.jpeg"));
    }
}
