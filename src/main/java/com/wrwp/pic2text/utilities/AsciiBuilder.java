package com.wrwp.pic2text.utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class AsciiBuilder {
    private final int width;
    private final int height;
    private final String palette;
    private final boolean reverse;
    private BufferedImage image;
    private final File file;

    private float colorMax = 65535.0f;

    private String outputText;

    public AsciiBuilder(int width, int height, String palette, boolean reverse, File file) {
        this.width = width;
        this.height = height;
        this.palette = palette;
        this.file = file;
        this.reverse = reverse;

        try {
            this.image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String process(BufferedImage image, int height, int width, String palette, boolean reverse) {
        byte[] result = new byte[height + height * width];
        if(reverse) {
            palette = reversePalette();
        }
        HashMap<String, Integer> chunkSizes = chunkSizes(image, height, width);
        int chunkWidth = chunkSizes.get("chunkSizeX");
        int chunkHeight = chunkSizes.get("chunkSizeY");

        Raster imagePixels = image.getData();

        int resIdx = 0;
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println(imagePixels.getSample(x, y, 0));
            }
        }
        return Arrays.toString(result);
    }

    public String reversePalette() {
        String str = palette;
        StringBuilder nstr= new StringBuilder();
        char ch;
        for (int i=0; i < str.length(); i++){
            ch = str.charAt(i);
            nstr.insert(0, ch);
        }
        return nstr.toString();
    }


    private HashMap<String, Integer> chunkSizes(BufferedImage image, int height, int width) {
        HashMap<String, Integer> chunkHashMap = new HashMap<>();
        int imgWidth = image.getWidth();
        int imgHeight = image.getHeight();
        int newImgWidth = imgWidth - (imgWidth % width);
        int newImgHeight = imgHeight - (imgHeight % height);
        Integer chunkSizeX = newImgWidth / width;
        Integer chunkSizeY = newImgHeight / height;

        chunkHashMap.put("chunkSizeX", chunkSizeX);
        chunkHashMap.put("chunkSizeY", chunkSizeY);
        return chunkHashMap;
    }

    @Override
    public String toString() {
        return "AsciiBuilder{" +
                "width=" + width +
                ", height=" + height +
                ", palette='" + palette + '\'' +
                ", image=" + image +
                ", file=" + file +
                ", outputText='" + outputText + '\'' +
                '}';
    }
}
