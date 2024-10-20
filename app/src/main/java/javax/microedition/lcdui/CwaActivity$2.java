package javax.microedition.lcdui;

import android.content.DialogInterface;

class CwaActivity$2 implements DialogInterface.OnClickListener {
   final CwaActivity this$0;

   CwaActivity$2(CwaActivity var1) {
      super();
      this.this$0 = var1;
   }

   public void onClick(DialogInterface var1, int var2) {
      var1.dismiss();
      CwaActivity.access$0(this.this$0).notifyResumed();
   }
}
