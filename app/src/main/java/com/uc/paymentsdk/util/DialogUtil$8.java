package com.uc.paymentsdk.util.DialogUtil$8;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import com.uc.paymentsdk.util.DialogUtil$WarningDialogListener;
import java.lang.Object;
import android.content.DialogInterface;
import android.app.Activity;

class DialogUtil$8 implements DialogInterface$OnClickListener	// class@0000c6 from classes.dex
{
    private final Context val$context;
    private final int val$id;
    private final DialogUtil$WarningDialogListener val$listener;

    void DialogUtil$8(Context p0,int p1,DialogUtil$WarningDialogListener p2){
       this.val$context = p0;
       this.val$id = p1;
       this.val$listener = p2;
       super();
    }
    public void onClick(DialogInterface paramDialogInterface,int paramInt){
       if (this.val$context instanceof Activity) {
          this.val$context.removeDialog(this.val$id);
          if (this.val$listener != null) {
             this.val$listener.onWarningDialogCancel(this.val$id);
          }
       }
       return;
    }
}
