/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  com.uc.paymentsdk.util.DialogUtil$ProgressDialogListener
 */
package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.uc.paymentsdk.util.DialogUtil;

class DialogUtil.2
implements DialogInterface.OnCancelListener {
    private final Context val$context;
    private final int val$id;
    private final DialogUtil.ProgressDialogListener val$listener;

    DialogUtil.2(Context context, int n, DialogUtil.ProgressDialogListener progressDialogListener) {
        this.val$context = context;
        this.val$id = n;
        this.val$listener = progressDialogListener;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.val$context instanceof Activity) {
            ((Activity)this.val$context).removeDialog(this.val$id);
        }
        if (this.val$listener != null) {
            this.val$listener.onProgressDialogCancel(this.val$id);
        }
    }
}
