package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

class DialogUtil$2 implements DialogInterface.OnCancelListener {
   private final Context val$context;
   private final int val$id;
   private final DialogUtil$ProgressDialogListener val$listener;

   DialogUtil$2(Context var1, int var2, DialogUtil$ProgressDialogListener var3) {
      super();
      this.val$context = var1;
      this.val$id = var2;
      this.val$listener = var3;
   }

   public void onCancel(DialogInterface var1) {
      if (this.val$context instanceof Activity) {
         ((Activity)this.val$context).removeDialog(this.val$id);
      }

      if (this.val$listener != null) {
         this.val$listener.onProgressDialogCancel(this.val$id);
      }

   }
}
