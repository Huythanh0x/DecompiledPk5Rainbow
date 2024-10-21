package com.nokia.mid.ui;

import android.content.Context;
import android.util.AttributeSet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.CwaActivity;

public abstract class FullCanvas extends Canvas {
   public static int KEY_DOWN_ARROW = 20;
   public static int KEY_END = 6;
   public static int KEY_LEFT_ARROW = 21;
   public static int KEY_RIGHT_ARROW = 22;
   public static int KEY_SEND = 5;
   public static int KEY_SOFTKEY1 = 1;
   public static int KEY_SOFTKEY2 = 2;
   public static int KEY_SOFTKEY3 = 23;
   public static int KEY_UP_ARROW = 19;

   protected FullCanvas() {
      super();
      CwaActivity.getInstance().setFullWindow(true);
   }

   protected FullCanvas(Context var1, AttributeSet var2) {
      super();
   }
}
