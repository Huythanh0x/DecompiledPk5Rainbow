package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;

class DialogUtil$6 implements DialogInterface$OnCancelListener {
    private final Context val$context;
    private final int val$id;
    
    DialogUtil$6(final Context val$context, final int val$id) {
        this.val$context = val$context;
        this.val$id = val$id;
        super();
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
        if (this.val$context instanceof Activity) {
            ((Activity)this.val$context).removeDialog(this.val$id);
        }
    }
}