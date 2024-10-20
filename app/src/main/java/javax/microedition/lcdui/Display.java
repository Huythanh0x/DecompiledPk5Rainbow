package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

public class Display {
   private static Canvas canvas;

   private Display() {
      super();
   }

   public static Canvas getCanvas() {
      return canvas;
   }

   public static Display getDisplay(MIDlet var0) {
      return new Display();
   }

   public void setCurrent(Canvas var1) {
      CwaActivity.getInstance().setCanvas(var1);
      canvas = var1;
   }
}
