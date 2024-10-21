package com.uc.paymentsdk.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class DialogUtil {
   public DialogUtil() {
      super();
   }

   public static ProgressDialog createDeterminateProgressDialog(Context var0, int var1, String var2, boolean var3, DialogUtil$ProgressDialogListener var4) {
      ProgressDialog var5 = new ProgressDialog(var0);
      var5.setIcon(17301659);
      var5.setTitle(var2);
      var5.setProgressStyle(1);
      if (var3) {
         var5.setButton(var0.getString(17039360), new DialogUtil$1(var0, var1, var4));
         var5.setOnCancelListener(new DialogUtil$2(var0, var1, var4));
      }

      if (!var3) {
         var5.setOnDismissListener(new DialogUtil$3(var0, var1));
      }

      return var5;
   }

   public static Dialog createIndeterminateProgressDialog(Context var0, int var1, String var2, boolean var3, DialogUtil$ProgressDialogListener var4) {
      ProgressDialog var5 = new ProgressDialog(var0);
      if (var2 == null) {
         throw new RuntimeException("Must provide a hint string for input dialog");
      } else {
         var5.setCancelable(var3);
         var5.setMessage(var2);
         var5.setOnCancelListener(new DialogUtil$6(var0, var1));
         return var5;
      }
   }

   public static Dialog createOKWarningDialog(Context var0, int var1, CharSequence var2, DialogUtil$WarningDialogListener var3) {
      return createOKWarningDialog(var0, var1, (CharSequence)null, var2, var3);
   }

   public static Dialog createOKWarningDialog(Context var0, int var1, CharSequence var2, CharSequence var3, DialogUtil$WarningDialogListener var4) {
      AlertDialog.Builder var5 = (new AlertDialog.Builder(var0)).setCancelable(true);
      if (TextUtils.isEmpty((CharSequence)var2)) {
         var2 = "\u53d1\u751f\u9519\u8bef";
      }

      return var5.setTitle((CharSequence)var2).setMessage(var3).setPositiveButton("\u786e\u5b9a", new DialogUtil$4(var0, var1, var4)).setOnCancelListener(new DialogUtil$5(var0, var1, var4)).create();
   }

   public static Dialog createOKWarningDialogSupportLink(Context var0, int var1, String var2, String var3, DialogUtil$WarningDialogListener var4) {
      TextView var5 = new TextView(var0);
      var5.setPadding(10, 10, 10, 10);
      var5.setTextAppearance(var0, 16973893);
      var5.setBackgroundColor(-1);
      var5.setLinkTextColor(-24576);
      var5.setMovementMethod(LinkMovementMethod.getInstance());
      var5.setText(Html.fromHtml(var3));
      LinearLayout var6 = new LinearLayout(var0);
      var6.setOrientation(1);
      var6.addView(var5);
      ScrollView var7 = new ScrollView(var0);
      var7.setVerticalFadingEdgeEnabled(false);
      var7.addView(var6);
      return (new AlertDialog.Builder(var0)).setTitle(var2).setView(var7).setPositiveButton("\u786e\u5b9a", (DialogInterface.OnClickListener)null).setPositiveButton("\u786e\u5b9a", new DialogUtil$10(var0, var1, var4)).setOnCancelListener(new DialogUtil$11(var0, var1, var4)).create();
   }

   public static Dialog createTwoButtonsDialog(Context var0, int var1, CharSequence var2, CharSequence var3, CharSequence var4, DialogUtil$WarningDialogListener var5) {
      return (new AlertDialog.Builder(var0)).setTitle("\u6ce8\u610f").setMessage(var2).setPositiveButton(var3, new DialogUtil$7(var0, var1, var5)).setNegativeButton(var4, new DialogUtil$8(var0, var1, var5)).setOnCancelListener(new DialogUtil$9(var0, var1)).create();
   }

   public static Dialog createYesNoDialog(Context var0, int var1, CharSequence var2, DialogUtil$WarningDialogListener var3) {
      return createTwoButtonsDialog(var0, var1, var2, "\u786e\u5b9a", "\u53d6\u6d88", var3);
   }
}
