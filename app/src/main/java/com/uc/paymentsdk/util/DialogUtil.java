/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.app.Dialog
 *  android.app.ProgressDialog
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.text.Html
 *  android.text.TextUtils
 *  android.text.method.LinkMovementMethod
 *  android.view.View
 *  android.widget.LinearLayout
 *  android.widget.ScrollView
 *  android.widget.TextView
 *  com.uc.paymentsdk.util.DialogUtil$ProgressDialogListener
 *  com.uc.paymentsdk.util.DialogUtil$WarningDialogListener
 */
package com.uc.paymentsdk.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.uc.paymentsdk.util.DialogUtil;

public class DialogUtil {
    public static ProgressDialog createDeterminateProgressDialog(Context context, int n, String string, boolean bl, ProgressDialogListener progressDialogListener) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIcon(17301659);
        progressDialog.setTitle((CharSequence)string);
        progressDialog.setProgressStyle(1);
        if (bl) {
            progressDialog.setButton((CharSequence)context.getString(0x1040000), (DialogInterface.OnClickListener)new /* Unavailable Anonymous Inner Class!! */);
            progressDialog.setOnCancelListener((DialogInterface.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        if (!bl) {
            progressDialog.setOnDismissListener((DialogInterface.OnDismissListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        return progressDialog;
    }

    public static Dialog createIndeterminateProgressDialog(Context context, int n, String string, boolean bl, ProgressDialogListener progressDialogListener) {
        progressDialogListener = new ProgressDialog(context);
        if (string == null) {
            throw new RuntimeException("Must provide a hint string for input dialog");
        }
        progressDialogListener.setCancelable(bl);
        progressDialogListener.setMessage((CharSequence)string);
        progressDialogListener.setOnCancelListener((DialogInterface.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
        return progressDialogListener;
    }

    public static Dialog createOKWarningDialog(Context context, int n, CharSequence charSequence, WarningDialogListener warningDialogListener) {
        return DialogUtil.createOKWarningDialog(context, n, null, charSequence, warningDialogListener);
    }

    public static Dialog createOKWarningDialog(Context context, int n, CharSequence charSequence, CharSequence charSequence2, WarningDialogListener warningDialogListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setCancelable(true);
        if (TextUtils.isEmpty((CharSequence)charSequence)) {
            charSequence = "\u53d1\u751f\u9519\u8bef";
        }
        return builder.setTitle(charSequence).setMessage(charSequence2).setPositiveButton((CharSequence)"\u786e\u5b9a", (DialogInterface.OnClickListener)new /* Unavailable Anonymous Inner Class!! */).setOnCancelListener((DialogInterface.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */).create();
    }

    public static Dialog createOKWarningDialogSupportLink(Context context, int n, String string, String string2, WarningDialogListener warningDialogListener) {
        TextView textView = new TextView(context);
        textView.setPadding(10, 10, 10, 10);
        textView.setTextAppearance(context, 16973893);
        textView.setBackgroundColor(-1);
        textView.setLinkTextColor(-24576);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText((CharSequence)Html.fromHtml((String)string2));
        string2 = new LinearLayout(context);
        string2.setOrientation(1);
        string2.addView((View)textView);
        textView = new ScrollView(context);
        textView.setVerticalFadingEdgeEnabled(false);
        textView.addView((View)string2);
        return new AlertDialog.Builder(context).setTitle((CharSequence)string).setView((View)textView).setPositiveButton((CharSequence)"\u786e\u5b9a", null).setPositiveButton((CharSequence)"\u786e\u5b9a", (DialogInterface.OnClickListener)new /* Unavailable Anonymous Inner Class!! */).setOnCancelListener((DialogInterface.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */).create();
    }

    public static Dialog createTwoButtonsDialog(Context context, int n, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, WarningDialogListener warningDialogListener) {
        return new AlertDialog.Builder(context).setTitle((CharSequence)"\u6ce8\u610f").setMessage(charSequence).setPositiveButton(charSequence2, (DialogInterface.OnClickListener)new /* Unavailable Anonymous Inner Class!! */).setNegativeButton(charSequence3, (DialogInterface.OnClickListener)new /* Unavailable Anonymous Inner Class!! */).setOnCancelListener((DialogInterface.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */).create();
    }

    public static Dialog createYesNoDialog(Context context, int n, CharSequence charSequence, WarningDialogListener warningDialogListener) {
        return DialogUtil.createTwoButtonsDialog(context, n, charSequence, "\u786e\u5b9a", "\u53d6\u6d88", warningDialogListener);
    }
}
