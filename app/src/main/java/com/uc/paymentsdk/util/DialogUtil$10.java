package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Context;
import android.content.DialogInterface$OnClickListener;

class DialogUtil$10 implements DialogInterface$OnClickListener {
    private final Context val$context;
    private final int val$id;
    private final WarningDialogListener val$listener;
    
    DialogUtil$10(final Context val$context, final int val$id, final WarningDialogListener val$listener) {
        this.val$context = val$context;
        this.val$id = val$id;
        this.val$listener = val$listener;
        super();
    }
    
    public void onClick(final DialogInterface dialogInterface, final int n) {
        if (this.val$context instanceof Activity) {
            ((Activity)this.val$context).removeDialog(this.val$id);
        }
        if (this.val$listener != null) {
            this.val$listener.onWarningDialogOK(this.val$id);
        }
    }
}