package com.uc.paymentsdk.util.DialogUtil$11;
import android.content.DialogInterface$OnCancelListener;
import android.content.Context;
import com.uc.paymentsdk.util.DialogUtil$WarningDialogListener;
import java.lang.Object;
import android.content.DialogInterface;
import android.app.Activity;

class DialogUtil$11 implements DialogInterface$OnCancelListener	// class@0000be from classes.dex
{
    private final Context val$context;
    private final int val$id;
    private final DialogUtil$WarningDialogListener val$listener;

    void DialogUtil$11(Context p0,int p1,DialogUtil$WarningDialogListener p2){
       this.val$context = p0;
       this.val$id = p1;
       this.val$listener = p2;
       super();
    }
    public void onCancel(DialogInterface paramDialogInterface){
       if (this.val$context instanceof Activity) {
          this.val$context.removeDialog(this.val$id);
       }
       if (this.val$listener != null) {
          this.val$listener.onWarningDialogOK(this.val$id);
       }
       return;
    }
}
