package javax.microedition.lcdui.Display;
import java.lang.Object;
import javax.microedition.lcdui.Canvas;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.CwaActivity;

public class Display	// class@000140 from classes.dex
{
    private static Canvas canvas;

    private void Display(){
       super();
    }
    public static Canvas getCanvas(){
       return Display.canvas;
    }
    public static Display getDisplay(MIDlet midlet){
       return new Display();
    }
    public void setCurrent(Canvas gCanvas){
       CwaActivity.getInstance().setCanvas(gCanvas);
       Display.canvas = gCanvas;
    }
}
