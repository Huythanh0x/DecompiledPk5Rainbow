package com.nokia.mid.ui.DirectUtils;
import java.lang.Object;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import com.nokia.mid.ui.DirectGraphics;

public class DirectUtils	// class@000083 from classes.dex
{
    private static DirectGraphics dg;

    public void DirectUtils(){
       super();
    }
    public static Image createImage(int width,int height,int ARGBcolor){
       return Image.createImage(width, height, 0);
    }
    public static DirectGraphics getDirectGraphics(Graphics g){
       DirectUtils.dg = new DirectGraphics();
       DirectUtils.dg.g = g;
       return DirectUtils.dg;
    }
}
