package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

class DialogUtil$4 implements DialogInterface.OnClickListener {
   private final Context val$context;
   private final int val$id;
   private final DialogUtil$WarningDialogListener val$listener;

   DialogUtil$4(Context var1, int var2, DialogUtil$WarningDialogListener var3) {
      super();
      this.val$context = var1;
      this.val$id = var2;
      this.val$listener = var3;
   }

   public void onClick(DialogInterface var1, int var2) {
      if (this.val$context instanceof Activity) {
         ((Activity)this.val$context).removeDialog(this.val$id);
      }

      if (this.val$listener != null) {
         this.val$listener.onWarningDialogOK(this.val$id);
      }

   }
}
