package com.uc.paymentsdk.util;

import android.widget.ScrollView;
import android.view.View;
import android.widget.LinearLayout;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import android.text.TextUtils;
import android.app.AlertDialog$Builder;
import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnCancelListener;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.ProgressDialog;
import android.content.Context;

public class DialogUtil
{
    public DialogUtil() {
        super();
    }
    
    public static ProgressDialog createDeterminateProgressDialog(final Context context, final int n, final String title, final boolean b, final ProgressDialogListener progressDialogListener) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setIcon(17301659);
        progressDialog.setTitle((CharSequence)title);
        progressDialog.setProgressStyle(1);
        if (b) {
            progressDialog.setButton((CharSequence)context.getString(17039360), (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(context, n, progressDialogListener) {
                private final Context val$context;
                private final int val$id;
                private final ProgressDialogListener val$listener;
                
                DialogUtil$1(final Context val$context, final int val$id, final ProgressDialogListener val$listener) {
                    this.val$context = val$context;
                    this.val$id = val$id;
                    this.val$listener = val$listener;
                    super();
                }
                
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    if (this.val$context instanceof Activity) {
                        ((Activity)this.val$context).removeDialog(this.val$id);
                    }
                    if (this.val$listener != null) {
                        this.val$listener.onProgressDialogCancel(this.val$id);
                    }
                }
            });
            progressDialog.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener(context, n, progressDialogListener) {
                private final Context val$context;
                private final int val$id;
                private final ProgressDialogListener val$listener;
                
                DialogUtil$2(final Context val$context, final int val$id, final ProgressDialogListener val$listener) {
                    this.val$context = val$context;
                    this.val$id = val$id;
                    this.val$listener = val$listener;
                    super();
                }
                
                public void onCancel(final DialogInterface dialogInterface) {
                    if (this.val$context instanceof Activity) {
                        ((Activity)this.val$context).removeDialog(this.val$id);
                    }
                    if (this.val$listener != null) {
                        this.val$listener.onProgressDialogCancel(this.val$id);
                    }
                }
            });
        }
        if (!b) {
            progressDialog.setOnDismissListener((DialogInterface$OnDismissListener)new DialogInterface$OnDismissListener(context, n) {
                private final Context val$context;
                private final int val$id;
                
                DialogUtil$3(final Context val$context, final int val$id) {
                    this.val$context = val$context;
                    this.val$id = val$id;
                    super();
                }
                
                public void onDismiss(final DialogInterface dialogInterface) {
                    if (this.val$context instanceof Activity) {
                        ((Activity)this.val$context).removeDialog(this.val$id);
                    }
                }
            });
        }
        return progressDialog;
    }
    
    public static Dialog createIndeterminateProgressDialog(final Context context, final int n, final String message, final boolean cancelable, final ProgressDialogListener progressDialogListener) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        if (message == null) {
            throw new RuntimeException("Must provide a hint string for input dialog");
        }
        progressDialog.setCancelable(cancelable);
        progressDialog.setMessage((CharSequence)message);
        progressDialog.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener(context, n) {
            private final Context val$context;
            private final int val$id;
            
            DialogUtil$6(final Context val$context, final int val$id) {
                this.val$context = val$context;
                this.val$id = val$id;
                super();
            }
            
            public void onCancel(final DialogInterface dialogInterface) {
                if (this.val$context instanceof Activity) {
                    ((Activity)this.val$context).removeDialog(this.val$id);
                }
            }
        });
        return (Dialog)progressDialog;
    }
    
    public static Dialog createOKWarningDialog(final Context context, final int n, final CharSequence charSequence, final WarningDialogListener warningDialogListener) {
        return createOKWarningDialog(context, n, null, charSequence, warningDialogListener);
    }
    
    public static Dialog createOKWarningDialog(final Context context, final int n, CharSequence title, final CharSequence message, final WarningDialogListener warningDialogListener) {
        final AlertDialog$Builder setCancelable = new AlertDialog$Builder(context).setCancelable(true);
        if (TextUtils.isEmpty(title)) {
            title = "\u53d1\u751f\u9519\u8bef";
        }
        return (Dialog)setCancelable.setTitle(title).setMessage(message).setPositiveButton((CharSequence)"\u786e\u5b9a", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(context, n, warningDialogListener) {
            private final Context val$context;
            private final int val$id;
            private final WarningDialogListener val$listener;
            
            DialogUtil$4(final Context val$context, final int val$id, final WarningDialogListener val$listener) {
                this.val$context = val$context;
                this.val$id = val$id;
                this.val$listener = val$listener;
                super();
            }
            
            public void onClick(final DialogInterface dialogInterface, final int n) {
                if (this.val$context instanceof Activity) {
                    ((Activity)this.val$context).removeDialog(this.val$id);
                }
                if (this.val$listener != null) {
                    this.val$listener.onWarningDialogOK(this.val$id);
                }
            }
        }).setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener(context, n, warningDialogListener) {
            private final Context val$context;
            private final int val$id;
            private final WarningDialogListener val$listener;
            
            DialogUtil$5(final Context val$context, final int val$id, final WarningDialogListener val$listener) {
                this.val$context = val$context;
                this.val$id = val$id;
                this.val$listener = val$listener;
                super();
            }
            
            public void onCancel(final DialogInterface dialogInterface) {
                if (this.val$context instanceof Activity) {
                    ((Activity)this.val$context).removeDialog(this.val$id);
                }
                if (this.val$listener != null) {
                    this.val$listener.onWarningDialogOK(this.val$id);
                }
            }
        }).create();
    }
    
    public static Dialog createOKWarningDialogSupportLink(final Context context, final int n, final String title, final String s, final WarningDialogListener warningDialogListener) {
        final TextView textView = new TextView(context);
        textView.setPadding(10, 10, 10, 10);
        textView.setTextAppearance(context, 16973893);
        textView.setBackgroundColor(-1);
        textView.setLinkTextColor(-24576);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText((CharSequence)Html.fromHtml(s));
        final LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.addView((View)textView);
        final ScrollView view = new ScrollView(context);
        view.setVerticalFadingEdgeEnabled(false);
        view.addView((View)linearLayout);
        return (Dialog)new AlertDialog$Builder(context).setTitle((CharSequence)title).setView((View)view).setPositiveButton((CharSequence)"\u786e\u5b9a", (DialogInterface$OnClickListener)null).setPositiveButton((CharSequence)"\u786e\u5b9a", (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(context, n, warningDialogListener) {
            private final Context val$context;
            private final int val$id;
            private final WarningDialogListener val$listener;
            
            DialogUtil$10(final Context val$context, final int val$id, final WarningDialogListener val$listener) {
                this.val$context = val$context;
                this.val$id = val$id;
                this.val$listener = val$listener;
                super();
            }
            
            public void onClick(final DialogInterface dialogInterface, final int n) {
                if (this.val$context instanceof Activity) {
                    ((Activity)this.val$context).removeDialog(this.val$id);
                }
                if (this.val$listener != null) {
                    this.val$listener.onWarningDialogOK(this.val$id);
                }
            }
        }).setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener(context, n, warningDialogListener) {
            private final Context val$context;
            private final int val$id;
            private final WarningDialogListener val$listener;
            
            DialogUtil$11(final Context val$context, final int val$id, final WarningDialogListener val$listener) {
                this.val$context = val$context;
                this.val$id = val$id;
                this.val$listener = val$listener;
                super();
            }
            
            public void onCancel(final DialogInterface dialogInterface) {
                if (this.val$context instanceof Activity) {
                    ((Activity)this.val$context).removeDialog(this.val$id);
                }
                if (this.val$listener != null) {
                    this.val$listener.onWarningDialogOK(this.val$id);
                }
            }
        }).create();
    }
    
    public static Dialog createTwoButtonsDialog(final Context context, final int n, final CharSequence message, final CharSequence charSequence, final CharSequence charSequence2, final WarningDialogListener warningDialogListener) {
        return (Dialog)new AlertDialog$Builder(context).setTitle((CharSequence)"\u6ce8\u610f").setMessage(message).setPositiveButton(charSequence, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(context, n, warningDialogListener) {
            private final Context val$context;
            private final int val$id;
            private final WarningDialogListener val$listener;
            
            DialogUtil$7(final Context val$context, final int val$id, final WarningDialogListener val$listener) {
                this.val$context = val$context;
                this.val$id = val$id;
                this.val$listener = val$listener;
                super();
            }
            
            public void onClick(final DialogInterface dialogInterface, final int n) {
                if (this.val$context instanceof Activity) {
                    ((Activity)this.val$context).removeDialog(this.val$id);
                }
                if (this.val$listener != null) {
                    this.val$listener.onWarningDialogOK(this.val$id);
                }
            }
        }).setNegativeButton(charSequence2, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener(context, n, warningDialogListener) {
            private final Context val$context;
            private final int val$id;
            private final WarningDialogListener val$listener;
            
            DialogUtil$8(final Context val$context, final int val$id, final WarningDialogListener val$listener) {
                this.val$context = val$context;
                this.val$id = val$id;
                this.val$listener = val$listener;
                super();
            }
            
            public void onClick(final DialogInterface dialogInterface, final int n) {
                if (this.val$context instanceof Activity) {
                    ((Activity)this.val$context).removeDialog(this.val$id);
                    if (this.val$listener != null) {
                        this.val$listener.onWarningDialogCancel(this.val$id);
                    }
                }
            }
        }).setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener(context, n) {
            private final Context val$context;
            private final int val$id;
            
            DialogUtil$9(final Context val$context, final int val$id) {
                this.val$context = val$context;
                this.val$id = val$id;
                super();
            }
            
            public void onCancel(final DialogInterface dialogInterface) {
                if (this.val$context instanceof Activity) {
                    ((Activity)this.val$context).removeDialog(this.val$id);
                }
            }
        }).create();
    }
    
    public static Dialog createYesNoDialog(final Context context, final int n, final CharSequence charSequence, final WarningDialogListener warningDialogListener) {
        return createTwoButtonsDialog(context, n, charSequence, "\u786e\u5b9a", "\u53d6\u6d88", warningDialogListener);
    }
    
    public interface CheckBoxWarningDialogListener
    {
        void onWarningDialogCancel(final int p0);
        
        void onWarningDialogOK(final int p0, final boolean p1);
    }
    
    public interface EditTextDialogListener
    {
        void onEditTextDialogCancel(final int p0);
        
        void onEditTextDialogOK(final int p0, final String p1);
    }
    
    public interface InfoDialogListener
    {
        void onInfoDialogOK(final int p0);
    }
    
    public interface InputDialogListener
    {
        void onInputDialogCancel(final int p0);
        
        void onInputDialogOK(final int p0, final String p1);
    }
    
    public interface ListCheckboxDialogListener
    {
        void onListDialogCancel(final int p0, final CharSequence[] p1);
        
        void onListDialogOK(final int p0, final CharSequence[] p1, final int p2, final int p3);
    }
    
    public interface ListDIalogListener
    {
        void onListDialogOK(final int p0, final int p1);
    }
    
    public interface ListDialogListener2
    {
        void onListDialogCancel2(final int p0, final Object[] p1);
        
        void onListDialogOK2(final int p0, final Object[] p1, final int p2);
    }
    
    public interface ProgressDialogListener
    {
        void onProgressDialogCancel(final int p0);
    }
    
    public interface RatingDialogListener
    {
        void onRatingDialogCancel();
        
        void onRatingDialogOK(final int p0, final float p1);
    }
    
    public interface RegisterDialogListener
    {
        void onRegisterDialogCancel(final int p0);
        
        void onRegisterDialogOK(final int p0, final String p1, final String p2, final String p3);
    }
    
    public interface UserPwdDialogListener
    {
        void onUserPwdDialogCancel(final int p0);
        
        void onUserPwdDialogOK(final int p0, final String p1, final String p2, final boolean p3);
        
        void onUserPwdDialogRegister(final int p0);
    }
    
    public interface WarningDialogListener
    {
        void onWarningDialogCancel(final int p0);
        
        void onWarningDialogOK(final int p0);
    }
}
