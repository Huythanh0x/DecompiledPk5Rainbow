.class public Lcom/uc/paymentsdk/payment/sms/receiver/SmsReceiver;
.super Landroid/content/BroadcastReceiver;
.source "SmsReceiver.java"

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 10
    invoke-direct { p0 }, Landroid/content/BroadcastReceiver;-><init>()V
    return-void
.end method

.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramIntent" # Landroid/content/Intent;
  .registers 11
  .prologue
  .line 15
    invoke-virtual { p2 }, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;
    move-result-object v2
  .line 16
  .local v2, "localBundle":Landroid/os/Bundle;
    if-nez v2, :L1
  :L0
  .line 26
    return-void
  :L1
  .line 18
    const-string v5, "pdus"
    invoke-virtual { v2, v5 }, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Ljava/lang/Object;
  .line 19
  .local v0, "arrayOfObject":[Ljava/lang/Object;
    const/4 v1, 0
  :L2
  .local v1, "i":I
    array-length v5, v0
    if-ge v1, v5, :L0
  .line 21
    aget-object v5, v0, v1
    check-cast v5, [B
    invoke-static { v5 }, Landroid/telephony/gsm/SmsMessage;->createFromPdu([B)Landroid/telephony/gsm/SmsMessage;
    move-result-object v3
  .line 22
  .local v3, "localSmsMessage":Landroid/telephony/gsm/SmsMessage;
    invoke-virtual { v3 }, Landroid/telephony/gsm/SmsMessage;->getOriginatingAddress()Ljava/lang/String;
    move-result-object v4
  .line 23
  .local v4, "str":Ljava/lang/String;
    const-string v5, "pay"
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "receiver number:"
    invoke-direct { v6, v7 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v6, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual { v6 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static { v5, v6 }, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
  .line 24
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/payment/sms/receiver/SmsReceiver;->abortBroadcast()V
  .line 19
    add-int/lit8 v1, v1, 1
    goto :L2
.end method
