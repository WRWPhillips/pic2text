package com.wrwp.pic2text.utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class AsciiBuilder {
    private final int width;
    private final int height;
    private String palette;
    private final boolean reverse;
    private BufferedImage image;

    public AsciiBuilder(int width, int height, String palette, boolean reverse, File file) {
        this.width = width;
        this.height = height;
        this.palette = palette;
        this.reverse = reverse;

        try {
            this.image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String process() {
        char[] result = new char[height + height * width];
        if(reverse) {
            this.palette = reversePalette();
        }
        HashMap<String, Integer> chunkSizes = chunkSizes(image, height, width);
        int chunkWidth = chunkSizes.get("chunkSizeX");
        int chunkHeight = chunkSizes.get("chunkSizeY");

        char[] paletteArray = palette.toCharArray();

        int resIdx = 0;
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                float intensity = chunkIntensity(x * chunkWidth, y * chunkHeight, chunkWidth, chunkHeight);
                float charIdx = intensity / 255.0f * Integer.valueOf(palette.length()).floatValue();
                result[resIdx] = paletteArray[Math.round(charIdx) - 1];
                resIdx++;
            }
            result[resIdx] = '\n';
            resIdx++;
        }
        return String.valueOf(result);
    }

    private float chunkIntensity(int x, int y, int chunkWidth, int chunkHeight) {
        float total = 0.0f;
        for(int yOffset = 0; yOffset < chunkHeight; yOffset++) {
            for(int xOffset = 0; xOffset < chunkWidth; xOffset++) {
                int pixel = image.getRGB(x + xOffset,y + yOffset);
                Color color = new Color(pixel, true);
                total += (color.getRed() + color.getGreen() + color.getBlue());
            }
        }
        return total / 3 / (chunkWidth * chunkHeight);
    }

    private String reversePalette() {
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
        return process();
    }
}
