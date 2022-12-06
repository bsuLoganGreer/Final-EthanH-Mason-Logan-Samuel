package edu.bsu.cs222;

import javafx.scene.image.Image;

public class PixelProcessor {
    Boolean[][] processedList;
    public PixelProcessor(Image img) {
        processedList = new Boolean [(int)img.getWidth()] [(int)img.getHeight()];
        for (int x = 0; x<(int)img.getWidth(); x++){
            for (int y = 0; y<(int)img.getHeight(); y++){
                processedList[x][y] = true;
            }
        }
    }

    public boolean shouldProcess(int x, int y) {
        if (x >= processedList.length || x < 0 || y>= processedList[1].length || y < 0)
            return false;
        return processedList[x][y];
    }

    public void setProcessed(int x, int y) {
        processedList[x][y] = false;
    }


}
