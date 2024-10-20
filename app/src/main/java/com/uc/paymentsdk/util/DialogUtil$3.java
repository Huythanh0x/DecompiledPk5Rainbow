/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

class DialogUtil.3
implements DialogInterface.OnDismissListener {
    private final Context val$context;
    private final int val$id;

    DialogUtil.3(Context context, int n) {
        this.val$context = context;
        this.val$id = n;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.val$context instanceof Activity) {
            ((Activity)this.val$context).removeDialog(this.val$id);
        }
    }
}
