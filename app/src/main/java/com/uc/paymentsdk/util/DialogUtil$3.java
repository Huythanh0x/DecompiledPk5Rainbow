package com.uc.paymentsdk.util.DialogUtil$3;
import android.content.DialogInterface$OnDismissListener;
import android.content.Context;
import java.lang.Object;
import android.content.DialogInterface;
import android.app.Activity;

class DialogUtil$3 implements DialogInterface$OnDismissListener	// class@0000c1 from classes.dex
{
    private final Context val$context;
    private final int val$id;

    void DialogUtil$3(Context p0,int p1){
       this.val$context = p0;
       this.val$id = p1;
       super();
    }
    public void onDismiss(DialogInterface paramDialogInterface){
       if (this.val$context instanceof Activity) {
          this.val$context.removeDialog(this.val$id);
       }
       return;
    }
}
