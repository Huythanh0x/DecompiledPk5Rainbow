.class Lcom/uc/paymentsdk/util/DialogUtil$2;
.super Ljava/lang/Object;
.implements Landroid/content/DialogInterface$OnCancelListener;
.source "DialogUtil.java"

.annotation system Ldalvik/annotation/EnclosingMethod;
  value = Lcom/uc/paymentsdk/util/DialogUtil;->createDeterminateProgressDialog(Landroid/content/Context;ILjava/lang/String;ZLcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;)Landroid/app/ProgressDialog;
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 0
  name = null
.end annotation

.field private final synthetic val$context:Landroid/content/Context;

.field private final synthetic val$id:I

.field private final synthetic val$listener:Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;

.method constructor <init>(Landroid/content/Context;ILcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;)V
  .registers 4
  .prologue
  .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$context:Landroid/content/Context;
    iput p2, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$id:I
    iput-object p3, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$listener:Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;
  .line 42
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public onCancel(Landroid/content/DialogInterface;)V
  .parameter "paramDialogInterface" # Landroid/content/DialogInterface;
  .registers 4
  .prologue
  .line 46
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$context:Landroid/content/Context;
    instance-of v0, v0, Landroid/app/Activity;
    if-eqz v0, :L0
  .line 47
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$context:Landroid/content/Context;
    check-cast v0, Landroid/app/Activity;
    iget v1, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$id:I
    invoke-virtual { v0, v1 }, Landroid/app/Activity;->removeDialog(I)V
  :L0
  .line 48
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$listener:Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;
    if-eqz v0, :L1
  .line 49
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$listener:Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;
    iget v1, p0, Lcom/uc/paymentsdk/util/DialogUtil$2;->val$id:I
    invoke-interface { v0, v1 }, Lcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;->onProgressDialogCancel(I)V
  :L1
  .line 50
    return-void
.end method
