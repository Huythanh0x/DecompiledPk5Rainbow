package com.uc.paymentsdk.util;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;

class DialogUtil$9 implements DialogInterface.OnCancelListener {
   private final Context val$context;
   private final int val$id;

   DialogUtil$9(Context var1, int var2) {
      super();
      this.val$context = var1;
      this.val$id = var2;
   }

   public void onCancel(DialogInterface var1) {
      if (this.val$context instanceof Activity) {
         ((Activity)this.val$context).removeDialog(this.val$id);
      }

   }
}
