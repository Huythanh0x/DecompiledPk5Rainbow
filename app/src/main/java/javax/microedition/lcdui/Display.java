package javax.microedition.lcdui;

import javax.microedition.midlet.MIDlet;

public class Display {
  private static Canvas canvas;
  
  public static Canvas getCanvas() {
    return canvas;
  }
  
  public static Display getDisplay(MIDlet paramMIDlet) {
    return new Display();
  }
  
  public void setCurrent(Canvas paramCanvas) {
    CwaActivity.getInstance().setCanvas(paramCanvas);
    canvas = paramCanvas;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/lcdui/Display.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */