package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/* loaded from: classes.dex */
/**
 * The DirectUtils class provides utility methods for creating images and obtaining
 * DirectGraphics objects.
 */
public class DirectUtils {
    private static DirectGraphics dg;

    /**
     * Creates an image with the specified width, height, and ARGB color.
     *
     * @param width the width of the image
     * @param height the height of the image
     * @param ARGBcolor the ARGB color of the image
     * @return the created Image object
     */
    public static Image createImage(int width, int height, int ARGBcolor) {
        return Image.createImage(width, height, 0);
    }

    /**
     * Returns a DirectGraphics object associated with the specified Graphics object.
     *
     * @param g the Graphics object to associate with the DirectGraphics object
     * @return the DirectGraphics object
     */
    public static DirectGraphics getDirectGraphics(Graphics g) {
        dg = new DirectGraphics();
        dg.g = g;
        return dg;
    }
}
