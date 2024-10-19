package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/* loaded from: classes.dex */
public class DirectUtils {
    private static DirectGraphics dg;

    public static Image createImage(int width, int height, int ARGBcolor) {
        return Image.createImage(width, height, 0);
    }

    public static DirectGraphics getDirectGraphics(Graphics g) {
        dg = new DirectGraphics();
        dg.g = g;
        return dg;
    }
}
