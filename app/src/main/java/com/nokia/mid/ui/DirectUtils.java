package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DirectUtils {
    private static DirectGraphics dg;

    public static Image createImage(int width, int height, int ARGBcolor) {
        return Image.createImage(width, height, 0);
    }

    public static DirectGraphics getDirectGraphics(Graphics g) {
        DirectUtils.dg = new DirectGraphics();
        DirectUtils.dg.g = g;
        return DirectUtils.dg;
    }
}

