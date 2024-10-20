package javax.microedition.lcdui;

import android.content.DialogInterface;

class CwaActivity$1 implements DialogInterface.OnClickListener {
   final CwaActivity this$0;

   CwaActivity$1(CwaActivity var1) {
      super();
      this.this$0 = var1;
   }

   public void onClick(DialogInterface var1, int var2) {
      if (var2 == -1) {
         CwaActivity.access$0(this.this$0).notifyDestroyed();
         CwaActivity.access$0(this.this$0).notifyExit();
      }

   }
}
