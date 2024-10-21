package com.nokia.mid.ui;

import android.util.AttributeSet;
import android.content.Context;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.lcdui.Canvas;

public abstract class FullCanvas extends Canvas
{
    public static int KEY_DOWN_ARROW;
    public static int KEY_END;
    public static int KEY_LEFT_ARROW;
    public static int KEY_RIGHT_ARROW;
    public static int KEY_SEND;
    public static int KEY_SOFTKEY1;
    public static int KEY_SOFTKEY2;
    public static int KEY_SOFTKEY3;
    public static int KEY_UP_ARROW;
    
    static {
        FullCanvas.KEY_UP_ARROW = 19;
        FullCanvas.KEY_DOWN_ARROW = 20;
        FullCanvas.KEY_LEFT_ARROW = 21;
        FullCanvas.KEY_RIGHT_ARROW = 22;
        FullCanvas.KEY_END = 6;
        FullCanvas.KEY_SEND = 5;
        FullCanvas.KEY_SOFTKEY1 = 1;
        FullCanvas.KEY_SOFTKEY2 = 2;
        FullCanvas.KEY_SOFTKEY3 = 23;
    }
    
    protected FullCanvas() {
        super();
        CwaActivity.getInstance().setFullWindow(true);
    }
    
    protected FullCanvas(final Context context, final AttributeSet set) {
        super();
    }
}
