.class Lcom/uc/paymentsdk/payment/PaymentsActivity$3;
.super Ljava/lang/Object;
.source "PaymentsActivity.java"

# interfaces
.implements Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/uc/paymentsdk/payment/PaymentsActivity;->buildSmsPaymentView()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field cancelBtn:Landroid/widget/Button;

.field contentPanel:Landroid/widget/RelativeLayout;

.field okBtn:Landroid/widget/Button;

.field smsPayment:I

.field final synthetic this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

.field tvInfo2:Landroid/widget/TextView;

.field waitTV:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/uc/paymentsdk/payment/PaymentsActivity;Landroid/widget/TextView;Landroid/widget/TextView;ILandroid/widget/Button;Landroid/widget/Button;Landroid/widget/RelativeLayout;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 986
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 987
    iput-object p2, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->waitTV:Landroid/widget/TextView;

    .line 988
    iput-object p3, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->tvInfo2:Landroid/widget/TextView;

    .line 989
    iput p4, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->smsPayment:I

    .line 990
    iput-object p5, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->cancelBtn:Landroid/widget/Button;

    .line 991
    iput-object p6, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->okBtn:Landroid/widget/Button;

    .line 992
    iput-object p7, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->contentPanel:Landroid/widget/RelativeLayout;

    return-void
.end method


# virtual methods
.method public onFinish()V
    .locals 7

    .prologue
    const/16 v2, 0x13

    .line 995
    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getSmsInfos()Lcom/uc/paymentsdk/payment/sms/SmsInfos;

    move-result-object v0

    if-nez v0, :cond_0

    .line 996
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 997
    invoke-virtual {v0, v2}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 998
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 999
    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    .line 1009
    :goto_0
    return-void

    .line 1002
    :cond_0
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$17(Lcom/uc/paymentsdk/payment/PaymentsActivity;Z)V

    .line 1003
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 1004
    invoke-virtual {v0, v2}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 1005
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->waitTV:Landroid/widget/TextView;

    .line 1006
    iget-object v2, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->tvInfo2:Landroid/widget/TextView;

    iget v3, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->smsPayment:I

    .line 1007
    iget-object v4, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->cancelBtn:Landroid/widget/Button;

    iget-object v5, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->okBtn:Landroid/widget/Button;

    .line 1008
    iget-object v6, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$3;->contentPanel:Landroid/widget/RelativeLayout;

    .line 1005
    invoke-static/range {v0 .. v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$18(Lcom/uc/paymentsdk/payment/PaymentsActivity;Landroid/widget/TextView;Landroid/widget/TextView;ILandroid/widget/Button;Landroid/widget/Button;Landroid/widget/RelativeLayout;)V

    goto :goto_0
.end method
