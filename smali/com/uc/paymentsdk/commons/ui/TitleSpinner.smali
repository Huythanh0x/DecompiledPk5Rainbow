.class public Lcom/uc/paymentsdk/commons/ui/TitleSpinner;
.super Landroid/widget/Button;
.source "TitleSpinner.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;
    }
.end annotation


# instance fields
.field private mAdapter:Landroid/widget/SpinnerAdapter;

.field private mNextSelectedPosition:I

.field private mOnClickListener:Landroid/content/DialogInterface$OnClickListener;

.field private mPrompt:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 2
    .param p1, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-direct {p0, p1}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    .line 25
    invoke-direct {p0}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->init()V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 3
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paramAttributeSet"    # Landroid/util/AttributeSet;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    invoke-direct {p0}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->init()V

    .line 32
    return-void
.end method

.method private init()V
    .registers 2

    .prologue
    .line 36
    const/4 v0, -0x1

    iput v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mNextSelectedPosition:I

    .line 37
    const/16 v0, 0x13

    invoke-virtual {p0, v0}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->setGravity(I)V

    .line 38
    const v0, 0x1080006

    invoke-virtual {p0, v0}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->setBackgroundResource(I)V

    .line 39
    return-void
.end method


# virtual methods
.method public getSelectedItemPosition()I
    .registers 2

    .prologue
    .line 43
    iget v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mNextSelectedPosition:I

    return v0
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 4
    .param p1, "paramDialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "paramInt"    # I

    .prologue
    .line 60
    invoke-virtual {p0, p2}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->setSelection(I)V

    .line 61
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 62
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mOnClickListener:Landroid/content/DialogInterface$OnClickListener;

    if-eqz v0, :cond_f

    .line 63
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mOnClickListener:Landroid/content/DialogInterface$OnClickListener;

    invoke-interface {v0, p1, p2}, Landroid/content/DialogInterface$OnClickListener;->onClick(Landroid/content/DialogInterface;I)V

    .line 64
    :cond_f
    return-void
.end method

.method public performClick()Z
    .registers 5

    .prologue
    .line 69
    invoke-super {p0}, Landroid/widget/Button;->performClick()Z

    move-result v0

    .line 70
    .local v0, "bool":Z
    if-nez v0, :cond_2b

    .line 72
    const/4 v0, 0x1

    .line 73
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 74
    .local v1, "localBuilder":Landroid/app/AlertDialog$Builder;
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mPrompt:Ljava/lang/CharSequence;

    if-eqz v2, :cond_19

    .line 75
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mPrompt:Ljava/lang/CharSequence;

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 76
    :cond_19
    new-instance v2, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;

    iget-object v3, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-direct {v2, v3}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;-><init>(Landroid/widget/SpinnerAdapter;)V

    invoke-virtual {p0}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->getSelectedItemPosition()I

    move-result v3

    invoke-virtual {v1, v2, v3, p0}, Landroid/app/AlertDialog$Builder;->setSingleChoiceItems(Landroid/widget/ListAdapter;ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 78
    .end local v1    # "localBuilder":Landroid/app/AlertDialog$Builder;
    :cond_2b
    return v0
.end method

.method public setAdapter(Landroid/widget/SpinnerAdapter;)V
    .registers 2
    .param p1, "paramSpinnerAdapter"    # Landroid/widget/SpinnerAdapter;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mAdapter:Landroid/widget/SpinnerAdapter;

    .line 55
    return-void
.end method

.method public setOnClickListener(Landroid/content/DialogInterface$OnClickListener;)V
    .registers 2
    .param p1, "paramOnClickListener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mOnClickListener:Landroid/content/DialogInterface$OnClickListener;

    .line 84
    return-void
.end method

.method public setPrompt(Ljava/lang/CharSequence;)V
    .registers 2
    .param p1, "paramCharSequence"    # Ljava/lang/CharSequence;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mPrompt:Ljava/lang/CharSequence;

    .line 89
    return-void
.end method

.method public setSelection(I)V
    .registers 3
    .param p1, "paramInt"    # I

    .prologue
    .line 48
    iput p1, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mNextSelectedPosition:I

    .line 49
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v0, p1}, Landroid/widget/SpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner;->setText(Ljava/lang/CharSequence;)V

    .line 50
    return-void
.end method
