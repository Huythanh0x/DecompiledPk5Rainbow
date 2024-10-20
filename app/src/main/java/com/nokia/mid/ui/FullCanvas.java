/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  javax.microedition.lcdui.Canvas
 *  javax.microedition.lcdui.CwaActivity
 */
package com.nokia.mid.ui;

import android.content.Context;
import android.util.AttributeSet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.CwaActivity;

public abstract class FullCanvas
extends Canvas {
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
        KEY_UP_ARROW = 19;
        KEY_DOWN_ARROW = 20;
        KEY_LEFT_ARROW = 21;
        KEY_RIGHT_ARROW = 22;
        KEY_END = 6;
        KEY_SEND = 5;
        KEY_SOFTKEY1 = 1;
        KEY_SOFTKEY2 = 2;
        KEY_SOFTKEY3 = 23;
    }

    protected FullCanvas() {
        CwaActivity.getInstance().setFullWindow(true);
    }

    protected FullCanvas(Context context, AttributeSet attributeSet) {
    }
}
