.class Lcom/uc/paymentsdk/util/DialogUtil$7;
.super Ljava/lang/Object;
.source "DialogUtil.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/uc/paymentsdk/util/DialogUtil;->createTwoButtonsDialog(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$context:Landroid/content/Context;

.field private final synthetic val$id:I

.field private final synthetic val$listener:Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;


# direct methods
.method constructor <init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$context:Landroid/content/Context;

    iput p2, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$id:I

    iput-object p3, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$listener:Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;

    .line 148
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "paramDialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "paramInt"    # I

    .prologue
    .line 153
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$context:Landroid/content/Context;

    instance-of v0, v0, Landroid/app/Activity;

    if-eqz v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$context:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    .line 155
    iget v1, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$id:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->removeDialog(I)V

    .line 156
    :cond_0
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$listener:Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;

    if-eqz v0, :cond_1

    .line 157
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$listener:Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;

    .line 158
    iget v1, p0, Lcom/uc/paymentsdk/util/DialogUtil$7;->val$id:I

    invoke-interface {v0, v1}, Lcom/uc/paymentsdk/util/DialogUtil$WarningDialogListener;->onWarningDialogOK(I)V

    .line 159
    :cond_1
    return-void
.end method
