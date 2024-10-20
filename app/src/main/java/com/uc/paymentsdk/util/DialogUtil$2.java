package com.uc.paymentsdk.util.DialogUtil$2;
import android.content.DialogInterface$OnCancelListener;
import android.content.Context;
import com.uc.paymentsdk.util.DialogUtil$ProgressDialogListener;
import java.lang.Object;
import android.content.DialogInterface;
import android.app.Activity;

class DialogUtil$2 implements DialogInterface$OnCancelListener	// class@0000c0 from classes.dex
{
    private final Context val$context;
    private final int val$id;
    private final DialogUtil$ProgressDialogListener val$listener;

    void DialogUtil$2(Context p0,int p1,DialogUtil$ProgressDialogListener p2){
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
          this.val$listener.onProgressDialogCancel(this.val$id);
       }
       return;
    }
}
