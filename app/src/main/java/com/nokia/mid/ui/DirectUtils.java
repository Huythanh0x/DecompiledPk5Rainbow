/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.nokia.mid.ui.DirectGraphics
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 */
package com.nokia.mid.ui;

import com.nokia.mid.ui.DirectGraphics;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DirectUtils {
    private static DirectGraphics dg;

    public static Image createImage(int n, int n2, int n3) {
        return Image.createImage((int)n, (int)n2, (int)0);
    }

    public static DirectGraphics getDirectGraphics(Graphics graphics) {
        dg = new DirectGraphics();
        DirectUtils.dg.g = graphics;
        return dg;
    }
}
