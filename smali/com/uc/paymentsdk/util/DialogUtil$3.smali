.class Lcom/uc/paymentsdk/util/DialogUtil$3;
.super Ljava/lang/Object;
.source "DialogUtil.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/uc/paymentsdk/util/DialogUtil;->createDeterminateProgressDialog(Landroid/content/Context;ILjava/lang/String;ZLcom/uc/paymentsdk/util/DialogUtil$ProgressDialogListener;)Landroid/app/ProgressDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private final synthetic val$context:Landroid/content/Context;

.field private final synthetic val$id:I


# direct methods
.method constructor <init>(Landroid/content/Context;I)V
    .registers 3

    .prologue
    .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/util/DialogUtil$3;->val$context:Landroid/content/Context;

    iput p2, p0, Lcom/uc/paymentsdk/util/DialogUtil$3;->val$id:I

    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .registers 4
    .param p1, "paramDialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$3;->val$context:Landroid/content/Context;

    instance-of v0, v0, Landroid/app/Activity;

    if-eqz v0, :cond_f

    .line 60
    iget-object v0, p0, Lcom/uc/paymentsdk/util/DialogUtil$3;->val$context:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    iget v1, p0, Lcom/uc/paymentsdk/util/DialogUtil$3;->val$id:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->removeDialog(I)V

    .line 61
    :cond_f
    return-void
.end method
