package com.uc.paymentsdk.util;

import android.app.Activity;
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

public class DialogUtil {
  public static ProgressDialog createDeterminateProgressDialog(final Context context, final int id, String paramString, boolean paramBoolean, final ProgressDialogListener listener) {
    ProgressDialog progressDialog = new ProgressDialog(context);
    progressDialog.setIcon(17301659);
    progressDialog.setTitle(paramString);
    progressDialog.setProgressStyle(1);
    if (paramBoolean) {
      progressDialog.setButton(context.getString(17039360), new DialogInterface.OnClickListener() {
            private final Context val$context;
            
            private final int val$id;
            
            private final DialogUtil.ProgressDialogListener val$listener;
            
            public void onClick(DialogInterface param1DialogInterface, int param1Int) {
              if (context instanceof Activity)
                ((Activity)context).removeDialog(id); 
              if (listener != null)
                listener.onProgressDialogCancel(id); 
            }
          });
      progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            private final Context val$context;
            
            private final int val$id;
            
            private final DialogUtil.ProgressDialogListener val$listener;
            
            public void onCancel(DialogInterface param1DialogInterface) {
              if (context instanceof Activity)
                ((Activity)context).removeDialog(id); 
              if (listener != null)
                listener.onProgressDialogCancel(id); 
            }
          });
    } 
    if (!paramBoolean)
      progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            private final Context val$context;
            
            private final int val$id;
            
            public void onDismiss(DialogInterface param1DialogInterface) {
              if (context instanceof Activity)
                ((Activity)context).removeDialog(id); 
            }
          }); 
    return progressDialog;
  }
  
  public static Dialog createIndeterminateProgressDialog(final Context context, final int id, String paramString, boolean paramBoolean, ProgressDialogListener paramProgressDialogListener) {
    ProgressDialog progressDialog = new ProgressDialog(context);
    if (paramString == null)
      throw new RuntimeException("Must provide a hint string for input dialog"); 
    progressDialog.setCancelable(paramBoolean);
    progressDialog.setMessage(paramString);
    progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
          private final Context val$context;
          
          private final int val$id;
          
          public void onCancel(DialogInterface param1DialogInterface) {
            if (context instanceof Activity)
              ((Activity)context).removeDialog(id); 
          }
        });
    return (Dialog)progressDialog;
  }
  
  public static Dialog createOKWarningDialog(Context paramContext, int paramInt, CharSequence paramCharSequence, WarningDialogListener paramWarningDialogListener) {
    return createOKWarningDialog(paramContext, paramInt, null, paramCharSequence, paramWarningDialogListener);
  }
  
  public static Dialog createOKWarningDialog(final Context context, final int id, CharSequence paramCharSequence1, CharSequence paramCharSequence2, final WarningDialogListener listener) {
    AlertDialog.Builder builder = (new AlertDialog.Builder(context)).setCancelable(true);
    if (TextUtils.isEmpty(paramCharSequence1))
      paramCharSequence1 = "发生错误"; 
    return (Dialog)builder.setTitle(paramCharSequence1).setMessage(paramCharSequence2).setPositiveButton("确定", new DialogInterface.OnClickListener() {
          private final Context val$context;
          
          private final int val$id;
          
          private final DialogUtil.WarningDialogListener val$listener;
          
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (context instanceof Activity)
              ((Activity)context).removeDialog(id); 
            if (listener != null)
              listener.onWarningDialogOK(id); 
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
          private final Context val$context;
          
          private final int val$id;
          
          private final DialogUtil.WarningDialogListener val$listener;
          
          public void onCancel(DialogInterface param1DialogInterface) {
            if (context instanceof Activity)
              ((Activity)context).removeDialog(id); 
            if (listener != null)
              listener.onWarningDialogOK(id); 
          }
        }).create();
  }
  
  public static Dialog createOKWarningDialogSupportLink(final Context context, final int id, String paramString1, String paramString2, final WarningDialogListener listener) {
    TextView textView = new TextView(context);
    textView.setPadding(10, 10, 10, 10);
    textView.setTextAppearance(context, 16973893);
    textView.setBackgroundColor(-1);
    textView.setLinkTextColor(-24576);
    textView.setMovementMethod(LinkMovementMethod.getInstance());
    textView.setText((CharSequence)Html.fromHtml(paramString2));
    LinearLayout linearLayout = new LinearLayout(context);
    linearLayout.setOrientation(1);
    linearLayout.addView((View)textView);
    ScrollView scrollView = new ScrollView(context);
    scrollView.setVerticalFadingEdgeEnabled(false);
    scrollView.addView((View)linearLayout);
    return (Dialog)(new AlertDialog.Builder(context)).setTitle(paramString1).setView((View)scrollView).setPositiveButton("确定", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
          private final Context val$context;
          
          private final int val$id;
          
          private final DialogUtil.WarningDialogListener val$listener;
          
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (context instanceof Activity)
              ((Activity)context).removeDialog(id); 
            if (listener != null)
              listener.onWarningDialogOK(id); 
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
          private final Context val$context;
          
          private final int val$id;
          
          private final DialogUtil.WarningDialogListener val$listener;
          
          public void onCancel(DialogInterface param1DialogInterface) {
            if (context instanceof Activity)
              ((Activity)context).removeDialog(id); 
            if (listener != null)
              listener.onWarningDialogOK(id); 
          }
        }).create();
  }
  
  public static Dialog createTwoButtonsDialog(final Context context, final int id, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, final WarningDialogListener listener) {
    return (Dialog)(new AlertDialog.Builder(context)).setTitle("注意").setMessage(paramCharSequence1).setPositiveButton(paramCharSequence2, new DialogInterface.OnClickListener() {
          private final Context val$context;
          
          private final int val$id;
          
          private final DialogUtil.WarningDialogListener val$listener;
          
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (context instanceof Activity)
              ((Activity)context).removeDialog(id); 
            if (listener != null)
              listener.onWarningDialogOK(id); 
          }
        }).setNegativeButton(paramCharSequence3, new DialogInterface.OnClickListener() {
          private final Context val$context;
          
          private final int val$id;
          
          private final DialogUtil.WarningDialogListener val$listener;
          
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (context instanceof Activity) {
              ((Activity)context).removeDialog(id);
              if (listener != null)
                listener.onWarningDialogCancel(id); 
            } 
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
          private final Context val$context;
          
          private final int val$id;
          
          public void onCancel(DialogInterface param1DialogInterface) {
            if (context instanceof Activity)
              ((Activity)context).removeDialog(id); 
          }
        }).create();
  }
  
  public static Dialog createYesNoDialog(Context paramContext, int paramInt, CharSequence paramCharSequence, WarningDialogListener paramWarningDialogListener) {
    return createTwoButtonsDialog(paramContext, paramInt, paramCharSequence, "确定", "取消", paramWarningDialogListener);
  }
  
  public static interface CheckBoxWarningDialogListener {
    void onWarningDialogCancel(int param1Int);
    
    void onWarningDialogOK(int param1Int, boolean param1Boolean);
  }
  
  public static interface EditTextDialogListener {
    void onEditTextDialogCancel(int param1Int);
    
    void onEditTextDialogOK(int param1Int, String param1String);
  }
  
  public static interface InfoDialogListener {
    void onInfoDialogOK(int param1Int);
  }
  
  public static interface InputDialogListener {
    void onInputDialogCancel(int param1Int);
    
    void onInputDialogOK(int param1Int, String param1String);
  }
  
  public static interface ListCheckboxDialogListener {
    void onListDialogCancel(int param1Int, CharSequence[] param1ArrayOfCharSequence);
    
    void onListDialogOK(int param1Int1, CharSequence[] param1ArrayOfCharSequence, int param1Int2, int param1Int3);
  }
  
  public static interface ListDIalogListener {
    void onListDialogOK(int param1Int1, int param1Int2);
  }
  
  public static interface ListDialogListener2 {
    void onListDialogCancel2(int param1Int, Object[] param1ArrayOfObject);
    
    void onListDialogOK2(int param1Int1, Object[] param1ArrayOfObject, int param1Int2);
  }
  
  public static interface ProgressDialogListener {
    void onProgressDialogCancel(int param1Int);
  }
  
  public static interface RatingDialogListener {
    void onRatingDialogCancel();
    
    void onRatingDialogOK(int param1Int, float param1Float);
  }
  
  public static interface RegisterDialogListener {
    void onRegisterDialogCancel(int param1Int);
    
    void onRegisterDialogOK(int param1Int, String param1String1, String param1String2, String param1String3);
  }
  
  public static interface UserPwdDialogListener {
    void onUserPwdDialogCancel(int param1Int);
    
    void onUserPwdDialogOK(int param1Int, String param1String1, String param1String2, boolean param1Boolean);
    
    void onUserPwdDialogRegister(int param1Int);
  }
  
  public static interface WarningDialogListener {
    void onWarningDialogCancel(int param1Int);
    
    void onWarningDialogOK(int param1Int);
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/util/DialogUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */