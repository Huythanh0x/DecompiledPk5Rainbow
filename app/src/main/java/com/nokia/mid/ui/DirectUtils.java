package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DirectUtils
{
    private static DirectGraphics dg;
    
    public DirectUtils() {
        super();
    }
    
    public static Image createImage(final int n, final int n2, final int n3) {
        return Image.createImage(n, n2, 0);
    }
    
    public static DirectGraphics getDirectGraphics(final Graphics g) {
        DirectUtils.dg = new DirectGraphics();
        DirectUtils.dg.g = g;
        return DirectUtils.dg;
    }
}
