.class public Lcom/uc/paymentsdk/util/DialogUtil;
.super Ljava/lang/Object;
.source "DialogUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/uc/paymentsdk/util/DialogUtil$CheckBoxWarningDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$EditTextDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$InfoDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$InputDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$ListCheckboxDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$ListDIalogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$ListDialogListener2;,
        Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$RatingDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$RegisterDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$UserPwdDialogListener;,
        Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createDeterminateProgressDialog(Landroid/content/Context;ILjava/lang/String;ZLcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;)Landroid/app/ProgressDialog;
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I
    .param p2, "paramString"    # Ljava/lang/String;
    .param p3, "paramBoolean"    # Z
    .param p4, "paramProgressDialogListener"    # Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;

    .prologue
    .line 21
    new-instance v3, Landroid/app/ProgressDialog;

    invoke-direct {v3, p0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    .line 22
    .local v3, "localProgressDialog":Landroid/app/ProgressDialog;
    const v4, 0x108009b

    invoke-virtual {v3, v4}, Landroid/app/ProgressDialog;->setIcon(I)V

    .line 23
    invoke-virtual {v3, p2}, Landroid/app/ProgressDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 24
    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 25
    move-object v0, p0

    .line 26
    .local v0, "context":Landroid/content/Context;
    move v1, p1

    .line 27
    .local v1, "id":I
    move-object v2, p4

    .line 28
    .local v2, "listener":Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;
    if-eqz p3, :cond_0

    .line 29
    const/high16 v4, 0x1040000

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 30
    new-instance v5, Lcom/uc/paymentsdk/util/DialogUtil$1;

    invoke-direct {v5, v0, v1, v2}, Lcom/uc/paymentsdk/util/DialogUtil$1;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;)V

    .line 29
    invoke-virtual {v3, v4, v5}, Landroid/app/ProgressDialog;->setButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 42
    new-instance v4, Lcom/uc/paymentsdk/util/DialogUtil$2;

    invoke-direct {v4, v0, v1, v2}, Lcom/uc/paymentsdk/util/DialogUtil$2;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;)V

    invoke-virtual {v3, v4}, Landroid/app/ProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 53
    :cond_0
    if-nez p3, :cond_1

    .line 55
    new-instance v4, Lcom/uc/paymentsdk/util/DialogUtil$3;

    invoke-direct {v4, v0, v1}, Lcom/uc/paymentsdk/util/DialogUtil$3;-><init>(Landroid/content/Context;I)V

    invoke-virtual {v3, v4}, Landroid/app/ProgressDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 63
    :cond_1
    return-object v3
.end method

.method public static createIndeterminateProgressDialog(Landroid/content/Context;ILjava/lang/String;ZLcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;)Landroid/app/Dialog;
    .locals 5
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I
    .param p2, "paramString"    # Ljava/lang/String;
    .param p3, "paramBoolean"    # Z
    .param p4, "paramProgressDialogListener"    # Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;

    .prologue
    .line 115
    move-object v0, p0

    .line 116
    .local v0, "context":Landroid/content/Context;
    move v1, p1

    .line 117
    .local v1, "id":I
    new-instance v2, Landroid/app/ProgressDialog;

    invoke-direct {v2, p0}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;)V

    .line 118
    .local v2, "localProgressDialog":Landroid/app/ProgressDialog;
    if-nez p2, :cond_0

    .line 119
    new-instance v3, Ljava/lang/RuntimeException;

    .line 120
    const-string v4, "Must provide a hint string for input dialog"

    .line 119
    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 121
    :cond_0
    invoke-virtual {v2, p3}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 122
    invoke-virtual {v2, p2}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 124
    new-instance v3, Lcom/uc/paymentsdk/util/DialogUtil$6;

    invoke-direct {v3, v0, v1}, Lcom/uc/paymentsdk/util/DialogUtil$6;-><init>(Landroid/content/Context;I)V

    invoke-virtual {v2, v3}, Landroid/app/ProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 133
    return-object v2
.end method

.method public static createOKWarningDialog(Landroid/content/Context;ILjava/lang/CharSequence;Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)Landroid/app/Dialog;
    .locals 1
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I
    .param p2, "paramCharSequence"    # Ljava/lang/CharSequence;
    .param p3, "paramWarningDialogListener"    # Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;

    .prologue
    .line 69
    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2, p3}, Lcom/uc/paymentsdk/util/DialogUtil;->createOKWarningDialog(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)Landroid/app/Dialog;

    move-result-object v0

    return-object v0
.end method

.method public static createOKWarningDialog(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)Landroid/app/Dialog;
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I
    .param p2, "paramCharSequence1"    # Ljava/lang/CharSequence;
    .param p3, "paramCharSequence2"    # Ljava/lang/CharSequence;
    .param p4, "paramWarningDialogListener"    # Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;

    .prologue
    .line 77
    move-object v0, p0

    .line 78
    .local v0, "context":Landroid/content/Context;
    move v1, p1

    .line 79
    .local v1, "id":I
    move-object v2, p4

    .line 80
    .local v2, "listener":Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;
    new-instance v3, Landroid/app/AlertDialog$Builder;

    invoke-direct {v3, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 81
    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 83
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    const-string v4, "\u53d1\u751f\u9519\u8bef"

    .line 82
    :goto_0
    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 85
    invoke-virtual {v3, p3}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 86
    const-string v4, "\u786e\u5b9a"

    new-instance v5, Lcom/uc/paymentsdk/util/DialogUtil$4;

    invoke-direct {v5, v0, v1, v2}, Lcom/uc/paymentsdk/util/DialogUtil$4;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)V

    invoke-virtual {v3, v4, v5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 97
    new-instance v4, Lcom/uc/paymentsdk/util/DialogUtil$5;

    invoke-direct {v4, v0, v1, v2}, Lcom/uc/paymentsdk/util/DialogUtil$5;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)V

    .line 96
    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 108
    invoke-virtual {v3}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v3

    .line 80
    return-object v3

    :cond_0
    move-object v4, p2

    .line 84
    goto :goto_0
.end method

.method public static createOKWarningDialogSupportLink(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)Landroid/app/Dialog;
    .locals 9
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I
    .param p2, "paramString1"    # Ljava/lang/String;
    .param p3, "paramString2"    # Ljava/lang/String;
    .param p4, "paramWarningDialogListener"    # Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;

    .prologue
    const/16 v6, 0xa

    .line 199
    new-instance v5, Landroid/widget/TextView;

    invoke-direct {v5, p0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 200
    .local v5, "localTextView":Landroid/widget/TextView;
    invoke-virtual {v5, v6, v6, v6, v6}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 201
    const v6, 0x1030045

    invoke-virtual {v5, p0, v6}, Landroid/widget/TextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 202
    const/4 v6, -0x1

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 203
    const/16 v6, -0x6000

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setLinkTextColor(I)V

    .line 204
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 205
    invoke-static {p3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 206
    new-instance v3, Landroid/widget/LinearLayout;

    invoke-direct {v3, p0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 207
    .local v3, "localLinearLayout":Landroid/widget/LinearLayout;
    const/4 v6, 0x1

    invoke-virtual {v3, v6}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 208
    invoke-virtual {v3, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 209
    new-instance v4, Landroid/widget/ScrollView;

    invoke-direct {v4, p0}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 210
    .local v4, "localScrollView":Landroid/widget/ScrollView;
    const/4 v6, 0x0

    invoke-virtual {v4, v6}, Landroid/widget/ScrollView;->setVerticalFadingEdgeEnabled(Z)V

    .line 211
    invoke-virtual {v4, v3}, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V

    .line 212
    move-object v0, p0

    .line 213
    .local v0, "context":Landroid/content/Context;
    move v1, p1

    .line 214
    .local v1, "id":I
    move-object v2, p4

    .line 215
    .local v2, "listener":Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;
    new-instance v6, Landroid/app/AlertDialog$Builder;

    invoke-direct {v6, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 216
    invoke-virtual {v6, p2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 217
    invoke-virtual {v6, v4}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 218
    const-string v7, "\u786e\u5b9a"

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 220
    const-string v7, "\u786e\u5b9a"

    .line 221
    new-instance v8, Lcom/uc/paymentsdk/util/DialogUtil$10;

    invoke-direct {v8, v0, v1, v2}, Lcom/uc/paymentsdk/util/DialogUtil$10;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)V

    .line 219
    invoke-virtual {v6, v7, v8}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 235
    new-instance v7, Lcom/uc/paymentsdk/util/DialogUtil$11;

    invoke-direct {v7, v0, v1, v2}, Lcom/uc/paymentsdk/util/DialogUtil$11;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)V

    .line 234
    invoke-virtual {v6, v7}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v6

    .line 246
    invoke-virtual {v6}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v6

    .line 215
    return-object v6
.end method

.method public static createTwoButtonsDialog(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)Landroid/app/Dialog;
    .locals 5
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I
    .param p2, "paramCharSequence1"    # Ljava/lang/CharSequence;
    .param p3, "paramCharSequence2"    # Ljava/lang/CharSequence;
    .param p4, "paramCharSequence3"    # Ljava/lang/CharSequence;
    .param p5, "paramWarningDialogListener"    # Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;

    .prologue
    .line 140
    move-object v0, p0

    .line 141
    .local v0, "context":Landroid/content/Context;
    move v1, p1

    .line 142
    .local v1, "id":I
    move-object v2, p5

    .line 143
    .local v2, "listener":Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;
    new-instance v3, Landroid/app/AlertDialog$Builder;

    invoke-direct {v3, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 144
    const-string v4, "\u6ce8\u610f"

    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 145
    invoke-virtual {v3, p2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 148
    new-instance v4, Lcom/uc/paymentsdk/util/DialogUtil$7;

    invoke-direct {v4, v0, v1, v2}, Lcom/uc/paymentsdk/util/DialogUtil$7;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)V

    .line 146
    invoke-virtual {v3, p3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 163
    new-instance v4, Lcom/uc/paymentsdk/util/DialogUtil$8;

    invoke-direct {v4, v0, v1, v2}, Lcom/uc/paymentsdk/util/DialogUtil$8;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)V

    .line 161
    invoke-virtual {v3, p4, v4}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 178
    new-instance v4, Lcom/uc/paymentsdk/util/DialogUtil$9;

    invoke-direct {v4, v0, v1}, Lcom/uc/paymentsdk/util/DialogUtil$9;-><init>(Landroid/content/Context;I)V

    .line 177
    invoke-virtual {v3, v4}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v3

    .line 186
    invoke-virtual {v3}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v3

    .line 143
    return-object v3
.end method

.method public static createYesNoDialog(Landroid/content/Context;ILjava/lang/CharSequence;Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)Landroid/app/Dialog;
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I
    .param p2, "paramCharSequence"    # Ljava/lang/CharSequence;
    .param p3, "paramWarningDialogListener"    # Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;

    .prologue
    .line 192
    .line 193
    const-string v3, "\u786e\u5b9a"

    const-string v4, "\u53d6\u6d88"

    move-object v0, p0

    move v1, p1

    move-object v2, p2

    move-object v5, p3

    .line 192
    invoke-static/range {v0 .. v5}, Lcom/uc/paymentsdk/util/DialogUtil;->createTwoButtonsDialog(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)Landroid/app/Dialog;

    move-result-object v0

    return-object v0
.end method
