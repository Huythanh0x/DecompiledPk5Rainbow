package com.uc.paymentsdk.util.DialogUtil$9;
import android.content.DialogInterface$OnCancelListener;
import android.content.Context;
import java.lang.Object;
import android.content.DialogInterface;
import android.app.Activity;

class DialogUtil$9 implements DialogInterface$OnCancelListener	// class@0000c7 from classes.dex
{
    private final Context val$context;
    private final int val$id;

    void DialogUtil$9(Context p0,int p1){
       this.val$context = p0;
       this.val$id = p1;
       super();
    }
    public void onCancel(DialogInterface paramDialogInterface){
       if (this.val$context instanceof Activity) {
          this.val$context.removeDialog(this.val$id);
       }
       return;
    }
}
