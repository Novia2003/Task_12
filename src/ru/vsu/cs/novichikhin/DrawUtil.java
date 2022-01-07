package ru.vsu.cs.novichikhin;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawUtil {
    public static void printImageToFile(BufferedImage image, String fileName) throws IOException {
        File file = new File(fileName);
        ImageIO.write(image, "jpg", file);
    }
}
