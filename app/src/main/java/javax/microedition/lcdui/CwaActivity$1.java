package javax.microedition.lcdui;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

class CwaActivity$1 implements DialogInterface$OnClickListener {
    final CwaActivity this$0;
    
    CwaActivity$1(final CwaActivity this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        if (n == -1) {
            CwaActivity.access$0(this.this$0).notifyDestroyed();
            CwaActivity.access$0(this.this$0).notifyExit();
        }
    }
}