/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  javax.microedition.lcdui.CwaActivity
 */
package javax.microedition.lcdui;

import android.content.DialogInterface;
import javax.microedition.lcdui.CwaActivity;

class CwaActivity.2
implements DialogInterface.OnClickListener {
    final CwaActivity this$0;

    CwaActivity.2(CwaActivity cwaActivity) {
        this.this$0 = cwaActivity;
    }

    public void onClick(DialogInterface dialogInterface, int n) {
        dialogInterface.dismiss();
        CwaActivity.access$0((CwaActivity)this.this$0).notifyResumed();
    }
}
