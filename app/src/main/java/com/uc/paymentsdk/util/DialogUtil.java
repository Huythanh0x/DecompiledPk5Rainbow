package com.uc.paymentsdk.util.DialogUtil;
import java.lang.Object;
import android.content.Context;
import java.lang.String;
import com.uc.paymentsdk.util.DialogUtil$ProgressDialogListener;
import android.app.ProgressDialog;
import java.lang.CharSequence;
import com.uc.paymentsdk.util.DialogUtil$1;
import android.content.DialogInterface$OnClickListener;
import com.uc.paymentsdk.util.DialogUtil$2;
import android.content.DialogInterface$OnCancelListener;
import com.uc.paymentsdk.util.DialogUtil$3;
import android.content.DialogInterface$OnDismissListener;
import android.app.Dialog;
import java.lang.RuntimeException;
import com.uc.paymentsdk.util.DialogUtil$6;
import com.uc.paymentsdk.util.DialogUtil$WarningDialogListener;
import android.app.AlertDialog$Builder;
import android.text.TextUtils;
import com.uc.paymentsdk.util.DialogUtil$4;
import com.uc.paymentsdk.util.DialogUtil$5;
import android.app.AlertDialog;
import android.widget.TextView;
import android.text.method.MovementMethod;
import android.text.method.LinkMovementMethod;
import android.text.Spanned;
import android.text.Html;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.ScrollView;
import com.uc.paymentsdk.util.DialogUtil$10;
import com.uc.paymentsdk.util.DialogUtil$11;
import com.uc.paymentsdk.util.DialogUtil$7;
import com.uc.paymentsdk.util.DialogUtil$8;
import com.uc.paymentsdk.util.DialogUtil$9;

public class DialogUtil	// class@0000d4 from classes.dex
{

    public void DialogUtil(){
       super();
    }
    public static ProgressDialog createDeterminateProgressDialog(Context paramContext,int paramInt,String paramString,boolean paramBoolean,DialogUtil$ProgressDialogListener paramProgressDialogListener){
       ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
       localProgressDialog.setIcon(0x108009b);
       localProgressDialog.setTitle(paramString);
       localProgressDialog.setProgressStyle(1);
       Context context = paramContext;
       int id = paramInt;
       DialogUtil$ProgressDialogListener listener = paramProgressDialogListener;
       if (paramBoolean) {
          localProgressDialog.setButton(paramContext.getString(0x1040000), new DialogUtil$1(context, id, listener));
          localProgressDialog.setOnCancelListener(new DialogUtil$2(context, id, listener));
       }
       if (!paramBoolean) {
          localProgressDialog.setOnDismissListener(new DialogUtil$3(context, id));
       }
       return localProgressDialog;
    }
    public static Dialog createIndeterminateProgressDialog(Context paramContext,int paramInt,String paramString,boolean paramBoolean,DialogUtil$ProgressDialogListener paramProgressDialogListener){
       Context context = paramContext;
       int id = paramInt;
       ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
       if (paramString == null) {
          throw new RuntimeException("Must provide a hint string for input dialog");
       }
       localProgressDialog.setCancelable(paramBoolean);
       localProgressDialog.setMessage(paramString);
       localProgressDialog.setOnCancelListener(new DialogUtil$6(context, id));
       return localProgressDialog;
    }
    public static Dialog createOKWarningDialog(Context paramContext,int paramInt,CharSequence paramCharSequence,DialogUtil$WarningDialogListener paramWarningDialogListener){
       return DialogUtil.createOKWarningDialog(paramContext, paramInt, null, paramCharSequence, paramWarningDialogListener);
    }
    public static Dialog createOKWarningDialog(Context paramContext,int paramInt,CharSequence paramCharSequence1,CharSequence paramCharSequence2,DialogUtil$WarningDialogListener paramWarningDialogListener){
       Context context = paramContext;
       int id = paramInt;
       DialogUtil$WarningDialogListener listener = paramWarningDialogListener;
       AlertDialog$Builder uBuilder = new AlertDialog$Builder(paramContext).setCancelable(true);
       String str = (TextUtils.isEmpty(paramCharSequence1))? "\x53\x02\x75\x02\x95\x02\x8b\x02": paramCharSequence1;
       return uBuilder.setTitle(str).setMessage(paramCharSequence2).setPositiveButton("\x78\x02\x5b\x02", new DialogUtil$4(context, id, listener)).setOnCancelListener(new DialogUtil$5(context, id, listener)).create();
    }
    public static Dialog createOKWarningDialogSupportLink(Context paramContext,int paramInt,String paramString1,String paramString2,DialogUtil$WarningDialogListener paramWarningDialogListener){
       TextView localTextView = new TextView(paramContext);
       localTextView.setPadding(10, 10, 10, 10);
       localTextView.setTextAppearance(paramContext, 0x1030045);
       localTextView.setBackgroundColor(-1);
       localTextView.setLinkTextColor(-24576);
       localTextView.setMovementMethod(LinkMovementMethod.getInstance());
       localTextView.setText(Html.fromHtml(paramString2));
       LinearLayout localLinearLayout = new LinearLayout(paramContext);
       localLinearLayout.setOrientation(1);
       localLinearLayout.addView(localTextView);
       ScrollView localScrollView = new ScrollView(paramContext);
       localScrollView.setVerticalFadingEdgeEnabled(false);
       localScrollView.addView(localLinearLayout);
       Context context = paramContext;
       int id = paramInt;
       DialogUtil$WarningDialogListener listener = paramWarningDialogListener;
       return new AlertDialog$Builder(paramContext).setTitle(paramString1).setView(localScrollView).setPositiveButton("\x78\x02\x5b\x02", null).setPositiveButton("\x78\x02\x5b\x02", new DialogUtil$10(context, id, listener)).setOnCancelListener(new DialogUtil$11(context, id, listener)).create();
    }
    public static Dialog createTwoButtonsDialog(Context paramContext,int paramInt,CharSequence paramCharSequence1,CharSequence paramCharSequence2,CharSequence paramCharSequence3,DialogUtil$WarningDialogListener paramWarningDialogListener){
       Context context = paramContext;
       int id = paramInt;
       DialogUtil$WarningDialogListener listener = paramWarningDialogListener;
       return new AlertDialog$Builder(paramContext).setTitle("\x6c\x02\x61\x02").setMessage(paramCharSequence1).setPositiveButton(paramCharSequence2, new DialogUtil$7(context, id, listener)).setNegativeButton(paramCharSequence3, new DialogUtil$8(context, id, listener)).setOnCancelListener(new DialogUtil$9(context, id)).create();
    }
    public static Dialog createYesNoDialog(Context paramContext,int paramInt,CharSequence paramCharSequence,DialogUtil$WarningDialogListener paramWarningDialogListener){
       return DialogUtil.createTwoButtonsDialog(paramContext, paramInt, paramCharSequence, "\x78\x02\x5b\x02", "\x53\x02\x6d\x02", paramWarningDialogListener);
    }
}
