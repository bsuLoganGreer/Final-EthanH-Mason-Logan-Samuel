package edu.bsu.cs222;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Download {
    public void download(Image displayImage, String fileName) throws IOException {

        ImageIO.write(SwingFXUtils.fromFXImage(displayImage, null), "png", new File(System.getProperty("user.dir") +
                "/src/resources/" + "modified_" + fileName));
    }
}
