package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DirectUtils {
  private static DirectGraphics dg;
  
  public static Image createImage(int paramInt1, int paramInt2, int paramInt3) {
    return Image.createImage(paramInt1, paramInt2, 0);
  }
  
  public static DirectGraphics getDirectGraphics(Graphics paramGraphics) {
    dg = new DirectGraphics();
    dg.g = paramGraphics;
    return dg;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/nokia/mid/ui/DirectUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */