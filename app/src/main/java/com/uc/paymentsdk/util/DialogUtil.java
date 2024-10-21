package com.uc.paymentsdk.util;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class DialogUtil {
    public interface CheckBoxWarningDialogListener {
        void onWarningDialogCancel(int arg1);

        void onWarningDialogOK(int arg1, boolean arg2);
    }

    public interface EditTextDialogListener {
        void onEditTextDialogCancel(int arg1);

        void onEditTextDialogOK(int arg1, String arg2);
    }

    public interface InfoDialogListener {
        void onInfoDialogOK(int arg1);
    }

    public interface InputDialogListener {
        void onInputDialogCancel(int arg1);

        void onInputDialogOK(int arg1, String arg2);
    }

    public interface ListCheckboxDialogListener {
        void onListDialogCancel(int arg1, CharSequence[] arg2);

        void onListDialogOK(int arg1, CharSequence[] arg2, int arg3, int arg4);
    }

    public interface ListDIalogListener {
        void onListDialogOK(int arg1, int arg2);
    }

    public interface ListDialogListener2 {
        void onListDialogCancel2(int arg1, Object[] arg2);

        void onListDialogOK2(int arg1, Object[] arg2, int arg3);
    }

    public interface ProgressDialogListener {
        void onProgressDialogCancel(int arg1);
    }

    public interface RatingDialogListener {
        void onRatingDialogCancel();

        void onRatingDialogOK(int arg1, float arg2);
    }

    public interface RegisterDialogListener {
        void onRegisterDialogCancel(int arg1);

        void onRegisterDialogOK(int arg1, String arg2, String arg3, String arg4);
    }

    public interface UserPwdDialogListener {
        void onUserPwdDialogCancel(int arg1);

        void onUserPwdDialogOK(int arg1, String arg2, String arg3, boolean arg4);

        void onUserPwdDialogRegister(int arg1);
    }

    public interface WarningDialogListener {
        void onWarningDialogCancel(int arg1);

        void onWarningDialogOK(int arg1);
    }

    public static ProgressDialog createDeterminateProgressDialog(Context paramContext, int paramInt, String paramString, boolean paramBoolean, ProgressDialogListener paramProgressDialogListener) {
        ProgressDialog localProgressDialog = new ProgressDialog(paramContext);
        localProgressDialog.setIcon(0x108009B);
        localProgressDialog.setTitle(paramString);
        localProgressDialog.setProgressStyle(1);
        if(paramBoolean) {
            localProgressDialog.setButton(paramContext.getString(0x1040000), new DialogInterface.OnClickListener() {
                @Override  // android.content.DialogInterface$OnClickListener
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    if((paramContext instanceof Activity)) {
                        ((Activity)paramContext).removeDialog(paramInt);
                    }
                    if(paramProgressDialogListener != null) {
                        paramProgressDialogListener.onProgressDialogCancel(paramInt);
                    }
                }
            });
            localProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override  // android.content.DialogInterface$OnCancelListener
                public void onCancel(DialogInterface paramDialogInterface) {
                    if((paramContext instanceof Activity)) {
                        ((Activity)paramContext).removeDialog(paramInt);
                    }
                    if(paramProgressDialogListener != null) {
                        paramProgressDialogListener.onProgressDialogCancel(paramInt);
                    }
                }
            });
        }
        if(!paramBoolean) {
            localProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override  // android.content.DialogInterface$OnDismissListener
                public void onDismiss(DialogInterface paramDialogInterface) {
                    if((paramContext instanceof Activity)) {
                        ((Activity)paramContext).removeDialog(paramInt);
                    }
                }
            });
        }
        return localProgressDialog;
    }

    public static Dialog createIndeterminateProgressDialog(Context paramContext, int paramInt, String paramString, boolean paramBoolean, ProgressDialogListener paramProgressDialogListener) {
        Dialog localProgressDialog = new ProgressDialog(paramContext);
        if(paramString == null) {
            throw new RuntimeException("Must provide a hint string for input dialog");
        }
        ((ProgressDialog)localProgressDialog).setCancelable(paramBoolean);
        ((ProgressDialog)localProgressDialog).setMessage(paramString);
        ((ProgressDialog)localProgressDialog).setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override  // android.content.DialogInterface$OnCancelListener
            public void onCancel(DialogInterface paramDialogInterface) {
                if((paramContext instanceof Activity)) {
                    ((Activity)paramContext).removeDialog(paramInt);
                }
            }
        });
        return localProgressDialog;
    }

    public static Dialog createOKWarningDialog(Context paramContext, int paramInt, CharSequence paramCharSequence, WarningDialogListener paramWarningDialogListener) {
        return DialogUtil.createOKWarningDialog(paramContext, paramInt, null, paramCharSequence, paramWarningDialogListener);
    }

    public static Dialog createOKWarningDialog(Context paramContext, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, WarningDialogListener paramWarningDialogListener) {
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(paramContext).setCancelable(true);
        return TextUtils.isEmpty(paramCharSequence1) ? alertDialog$Builder0.setTitle("发生错误").setMessage(paramCharSequence2).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                if((paramContext instanceof Activity)) {
                    ((Activity)paramContext).removeDialog(paramInt);
                }
                if(paramWarningDialogListener != null) {
                    paramWarningDialogListener.onWarningDialogOK(paramInt);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override  // android.content.DialogInterface$OnCancelListener
            public void onCancel(DialogInterface paramDialogInterface) {
                if((paramContext instanceof Activity)) {
                    ((Activity)paramContext).removeDialog(paramInt);
                }
                if(paramWarningDialogListener != null) {
                    paramWarningDialogListener.onWarningDialogOK(paramInt);
                }
            }
        }).create() : alertDialog$Builder0.setTitle(paramCharSequence1).setMessage(paramCharSequence2).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                if((paramContext instanceof Activity)) {
                    ((Activity)paramContext).removeDialog(paramInt);
                }
                if(paramWarningDialogListener != null) {
                    paramWarningDialogListener.onWarningDialogOK(paramInt);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override  // android.content.DialogInterface$OnCancelListener
            public void onCancel(DialogInterface paramDialogInterface) {
                if((paramContext instanceof Activity)) {
                    ((Activity)paramContext).removeDialog(paramInt);
                }
                if(paramWarningDialogListener != null) {
                    paramWarningDialogListener.onWarningDialogOK(paramInt);
                }
            }
        }).create();
    }

    public static Dialog createOKWarningDialogSupportLink(Context paramContext, int paramInt, String paramString1, String paramString2, WarningDialogListener paramWarningDialogListener) {
        TextView localTextView = new TextView(paramContext);
        localTextView.setPadding(10, 10, 10, 10);
        localTextView.setTextAppearance(paramContext, 0x1030045);
        localTextView.setBackgroundColor(-1);
        localTextView.setLinkTextColor(0xFFFFA000);
        localTextView.setMovementMethod(LinkMovementMethod.getInstance());
        localTextView.setText(Html.fromHtml(paramString2));
        LinearLayout localLinearLayout = new LinearLayout(paramContext);
        localLinearLayout.setOrientation(1);
        localLinearLayout.addView(localTextView);
        ScrollView localScrollView = new ScrollView(paramContext);
        localScrollView.setVerticalFadingEdgeEnabled(false);
        localScrollView.addView(localLinearLayout);
        return new AlertDialog.Builder(paramContext).setTitle(paramString1).setView(localScrollView).setPositiveButton("确定", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                if((paramContext instanceof Activity)) {
                    ((Activity)paramContext).removeDialog(paramInt);
                }
                if(paramWarningDialogListener != null) {
                    paramWarningDialogListener.onWarningDialogOK(paramInt);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override  // android.content.DialogInterface$OnCancelListener
            public void onCancel(DialogInterface paramDialogInterface) {
                if((paramContext instanceof Activity)) {
                    ((Activity)paramContext).removeDialog(paramInt);
                }
                if(paramWarningDialogListener != null) {
                    paramWarningDialogListener.onWarningDialogOK(paramInt);
                }
            }
        }).create();
    }

    public static Dialog createTwoButtonsDialog(Context paramContext, int paramInt, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, WarningDialogListener paramWarningDialogListener) [...] // Inlined contents

    // Deobfuscation rating: LOW(20)
    public static Dialog createYesNoDialog(Context paramContext, int paramInt, CharSequence paramCharSequence, WarningDialogListener paramWarningDialogListener) {
        return new AlertDialog.Builder(paramContext).setTitle("注意").setMessage(paramCharSequence).setPositiveButton("确定", new com.uc.paymentsdk.util.DialogUtil.7(paramContext, paramInt, paramWarningDialogListener)).setNegativeButton("取消", new com.uc.paymentsdk.util.DialogUtil.8(paramContext, paramInt, paramWarningDialogListener)).setOnCancelListener(new com.uc.paymentsdk.util.DialogUtil.9(paramContext, paramInt)).create();
    }
}

