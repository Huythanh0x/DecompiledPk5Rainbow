package javax.microedition.lcdui;

import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

class CwaActivity$2 implements DialogInterface$OnClickListener {
    final CwaActivity this$0;
    
    CwaActivity$2(final CwaActivity this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        dialogInterface.dismiss();
        CwaActivity.access$0(this.this$0).notifyResumed();
    }
}