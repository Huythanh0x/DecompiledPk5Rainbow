/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  com.uc.paymentsdk.util.DialogUtil$WarningDialogListener
 */
package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.uc.paymentsdk.util.DialogUtil;

class DialogUtil.11
implements DialogInterface.OnCancelListener {
    private final Context val$context;
    private final int val$id;
    private final DialogUtil.WarningDialogListener val$listener;

    DialogUtil.11(Context context, int n, DialogUtil.WarningDialogListener warningDialogListener) {
        this.val$context = context;
        this.val$id = n;
        this.val$listener = warningDialogListener;
    }

    public void onCancel(DialogInterface dialogInterface) {
        if (this.val$context instanceof Activity) {
            ((Activity)this.val$context).removeDialog(this.val$id);
        }
        if (this.val$listener != null) {
            this.val$listener.onWarningDialogOK(this.val$id);
        }
    }
}
