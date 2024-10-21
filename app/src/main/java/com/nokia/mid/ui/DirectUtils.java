package com.nokia.mid.ui;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class DirectUtils {
   private static DirectGraphics dg;

   public DirectUtils() {
      super();
   }

   public static Image createImage(int var0, int var1, int var2) {
      return Image.createImage(var0, var1, 0);
   }

   public static DirectGraphics getDirectGraphics(Graphics var0) {
      dg = new DirectGraphics();
      dg.g = var0;
      return dg;
   }
}
