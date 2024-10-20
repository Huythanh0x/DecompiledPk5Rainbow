.class Lcom/uc/paymentsdk/payment/PaymentsActivity$2;
.super Ljava/lang/Object;
.implements Ljava/lang/Runnable;
.source "PaymentsActivity.java"

.annotation system Ldalvik/annotation/EnclosingClass;
  value = Lcom/uc/paymentsdk/payment/PaymentsActivity;
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 0
  name = null
.end annotation

.field final synthetic this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

.method constructor <init>(Lcom/uc/paymentsdk/payment/PaymentsActivity;)V
  .registers 2
  .prologue
  .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
  .line 282
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public run()V
  .catch Ljava/lang/IllegalArgumentException; { :L1 .. :L2 } :L5
  .registers 4
  .prologue
    const/16 v2, 21
  .line 285
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-static { v0 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$10(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;
    move-result-object v0
    if-eqz v0, :L0
  .line 286
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v0
  .line 288
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-static { v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$10(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;
    move-result-object v1
  .line 287
    invoke-virtual { v0, v1 }, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V
  :L0
  .line 289
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    const/16 v1, 17
    invoke-virtual { v0, v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V
  .line 290
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-static { v0 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
    move-result-object v0
    iget-boolean v0, v0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->needconfirm:Z
    if-eqz v0, :L3
  .line 291
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    const-string v1, "\u5bf9\u4e0d\u8d77\uff0c\u63a5\u6536\u786e\u8ba4\u77ed\u4fe1\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u5c1d\u8bd5\u652f\u4ed8\uff01"
    invoke-static { v0, v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V
  .line 292
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-virtual { v0, v2 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V
  :L1
  .line 304
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
  .line 305
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-static { v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$7(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/content/BroadcastReceiver;
    move-result-object v1
    invoke-virtual { v0, v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
  :L2
  .line 308
    return-void
  :L3
  .line 293
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-static { v0 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$3(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
    move-result v0
    if-lez v0, :L4
  .line 294
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    const-string v1, "\u5bf9\u4e0d\u8d77\uff0c\u77ed\u4fe1\u652f\u4ed8\u5df2\u7ecf\u8d85\u65f6\uff0c\u8bf7\u91cd\u65b0\u652f\u4ed8\uff01"
    invoke-static { v0, v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V
  .line 295
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-virtual { v0, v2 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V
    goto :L1
  :L4
  .line 298
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;
    move-result-object v0
  .line 299
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    invoke-static { v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$5(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I
    move-result v1
  .line 297
    invoke-static { v0, v1 }, Lcom/uc/paymentsdk/util/PrefUtil;->setPayedAmount(Landroid/content/Context;I)V
  .line 300
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    const-string v1, "\u611f\u8c22\u60a8\u7684\u4f7f\u7528\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\uff01"
    invoke-static { v0, v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V
  .line 301
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$2;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;
    const/16 v1, 20
    invoke-virtual { v0, v1 }, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V
    goto :L1
  :L5
  .line 306
    move-exception v0
    goto :L2
.end method
