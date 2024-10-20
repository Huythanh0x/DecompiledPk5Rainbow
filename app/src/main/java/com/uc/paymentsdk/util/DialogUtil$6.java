/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 */
package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

class DialogUtil.6
implements DialogInterface.OnCancelListener {
    private final Context val$context;
    private final int val$id;

    DialogUtil.6(Context context, int n) {
        this.val$context = context;
        this.val$id = n;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.val$context instanceof Activity) {
            ((Activity)this.val$context).removeDialog(this.val$id);
        }
    }
}
