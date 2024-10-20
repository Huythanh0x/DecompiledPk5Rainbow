.class public Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;
.super Lcom/uc/paymentsdk/network/chain/Handler;
.implements Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
.source "SyncSmsInfoHandler.java"

.field private static sStatus:I

.field private final LOCK:Ljava/lang/Integer;

.field private mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

.method public constructor <init>(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 22
    invoke-direct { p0, p1 }, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V
  .line 19
    const/4 v0, 0
    invoke-static { v0 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;
  .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramOnFinishListener" # Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
  .registers 4
  .prologue
  .line 27
    invoke-direct { p0, p1 }, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V
  .line 19
    const/4 v0, 0
    invoke-static { v0 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;
  .line 28
    iput-object p2, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
  .line 29
    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;)Ljava/lang/Integer;
  .registers 2
  .prologue
  .line 19
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;
    return-object v0
.end method

.method public static init()V
  .registers 1
  .prologue
  .line 32
    const/4 v0, 0
    sput v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I
  .line 33
    return-void
.end method

.method public handleRequest()V
  .registers 4
  .prologue
  .line 37
    sget v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I
    packed-switch v0, :L5
  :L0
  .line 72
    return-void
  :L1
  .line 39
    new-instance v0, Ljava/lang/Thread;
    new-instance v1, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;
    invoke-direct { v1, p0 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;-><init>(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;)V
    invoke-direct { v0, v1 }, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V
  .line 56
    invoke-virtual { v0 }, Ljava/lang/Thread;->start()V
    goto :L0
  :L2
  .line 59
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    if-nez v0, :L3
  .line 60
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    if-eqz v0, :L0
  .line 62
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    invoke-interface { v0 }, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V
    goto :L0
  :L3
  .line 64
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V
    goto :L0
  :L4
  .line 68
    const/4 v0, 1
    sput v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I
  .line 69
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mContext:Landroid/content/Context;
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;
    move-result-object v1
  .line 70
    invoke-virtual { v1 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getCpID()Ljava/lang/String;
    move-result-object v1
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;
    move-result-object v2
    invoke-virtual { v2 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmGameID()Ljava/lang/String;
    move-result-object v2
  .line 69
    invoke-static { v0, p0, v1, v2 }, Lcom/uc/paymentsdk/network/Api;->syncSmsInfo(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;)V
    goto :L0
  .line 37
  :L5
  .packed-switch 0
    :L4
    :L1
    :L2
  .end packed-switch
.end method

.method public onError(II)V
  .parameter "paramInt1" # I
  .parameter "paramInt2" # I
  .catch Ljava/io/IOException; { :L0 .. :L1 } :L7
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L10
  .catchall { :L2 .. :L3 } :L13
  .catch Ljava/io/IOException; { :L5 .. :L6 } :L7
  .catch Ljava/lang/Exception; { :L5 .. :L6 } :L10
  .catch Ljava/io/IOException; { :L8 .. :L9 } :L7
  .catch Ljava/lang/Exception; { :L8 .. :L9 } :L10
  .catch Ljava/io/IOException; { :L11 .. :L12 } :L7
  .catch Ljava/lang/Exception; { :L11 .. :L12 } :L10
  .catchall { :L14 .. :L15 } :L13
  .registers 11
  .prologue
    const/4 v7, 0
  .line 106
    const/4 v4, 2
    sput v4, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I
  .line 107
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getSmsInfos()Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    move-result-object v4
    if-nez v4, :L1
  :L0
  .line 109
    iget-object v4, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mContext:Landroid/content/Context;
    invoke-static { v4 }, Lcom/uc/paymentsdk/util/PrefUtil;->getSmsInfo(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v3
  .line 110
  .local v3, "str":Ljava/lang/String;
    if-nez v3, :L5
  .line 111
    const/4 v4, 0
    invoke-static { v4 }, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
  :L1
  .line 136
  .end local v3
    iget-object v4, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;
    monitor-enter v4
  :L2
  .line 137
    iget-object v5, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;
    invoke-virtual { v5 }, Ljava/lang/Object;->notifyAll()V
  .line 136
    monitor-exit v4
  :L3
  .line 139
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v4
    if-nez v4, :L16
  .line 140
    iget-object v4, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    if-eqz v4, :L4
  .line 141
    iget-object v4, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    invoke-interface { v4 }, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V
  :L4
  .line 144
    return-void
  :L5
  .line 114
  .restart local v3
    invoke-static { v3 }, Lcom/uc/paymentsdk/network/XMLParser;->parseSmsInfo(Ljava/lang/String;)Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    move-result-object v2
  .line 115
  .local v2, "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    if-nez v2, :L8
  .line 116
    const/4 v4, 0
    invoke-static { v4 }, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
  :L6
    goto :L1
  :L7
  .line 128
  .end local v2
  .end local v3
    move-exception v4
    move-object v1, v4
  .line 129
  .local v1, "localIOException":Ljava/io/IOException;
    sput v7, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I
  .line 130
    invoke-virtual { v1 }, Ljava/io/IOException;->printStackTrace()V
    goto :L1
  :L8
  .line 120
  .end local v1
  .restart local v2
  .restart local v3
    iget-object v4, v2, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;
    const/4 v5, 0
    invoke-virtual { v4, v5 }, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/uc/paymentsdk/payment/sms/SmsInfo;
    invoke-virtual { v4 }, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsendtime()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 1
    invoke-static { v5 }, Lcom/uc/paymentsdk/util/Utils;->getCurrentTime(Z)Ljava/lang/String;
    move-result-object v5
    const-string v6, "yyyy-MM-dd"
    invoke-static { v4, v5, v6 }, Lcom/uc/paymentsdk/util/Utils;->dateDiffByDay(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    move-result v4
    if-ltz v4, :L11
  .line 121
    const/4 v4, 0
    invoke-static { v4 }, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
  :L9
    goto :L1
  :L10
  .line 131
  .end local v2
  .end local v3
    move-exception v4
    move-object v0, v4
  .line 132
  .local v0, "localException":Ljava/lang/Exception;
    sput v7, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I
  .line 133
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L1
  :L11
  .line 124
  .end local v0
  .restart local v2
  .restart local v3
    invoke-static { v2 }, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
  :L12
    goto :L1
  :L13
  .line 136
  .end local v2
  .end local v3
    move-exception v5
  :L14
    monitor-exit v4
  :L15
    throw v5
  :L16
  .line 143
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v4
    invoke-virtual { v4 }, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V
    goto :L4
.end method

.method public onPreHandle(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
  .parameter "paramInt" # I
  .parameter "paramHttpResponse" # Lorg/apache/http/HttpResponse;
  .catch Ljava/lang/Exception; { :L1 .. :L2 } :L3
  .registers 8
  .prologue
    const/4 v4, 0
  .line 90
    invoke-static { p1, p2 }, Lcom/uc/paymentsdk/util/Utils;->getBodyString(ILorg/apache/http/HttpResponse;)Ljava/lang/String;
    move-result-object v2
  .line 91
  .local v2, "str":Ljava/lang/String;
    invoke-static { v2 }, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, :L1
    move-object v3, v4
  :L0
  .line 101
    return-object v3
  :L1
  .line 95
    invoke-static { v2 }, Lcom/uc/paymentsdk/network/XMLParser;->parseSmsInfo(Ljava/lang/String;)Lcom/uc/paymentsdk/payment/sms/SmsInfos;
  :L2
    move-result-object v1
  .line 100
  .local v1, "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    iget-object v3, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mContext:Landroid/content/Context;
    invoke-static { v3, v2 }, Lcom/uc/paymentsdk/util/PrefUtil;->setSmsInfo(Landroid/content/Context;Ljava/lang/String;)V
    move-object v3, v1
  .line 101
    goto :L0
  :L3
  .line 96
  .end local v1
    move-exception v0
  .line 97
  .local v0, "e":Ljava/lang/Exception;
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
    move-object v3, v4
  .line 98
    goto :L0
.end method

.method public onSuccess(ILjava/lang/Object;)V
  .parameter "paramInt" # I
  .parameter "paramObject" # Ljava/lang/Object;
  .catchall { :L0 .. :L1 } :L3
  .catchall { :L4 .. :L5 } :L3
  .registers 5
  .prologue
  .line 76
    const/4 v0, 2
    sput v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I
  .line 77
    check-cast p2, Lcom/uc/paymentsdk/payment/sms/SmsInfos;
  .end local p2
    invoke-static { p2 }, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
  .line 78
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;
    monitor-enter v0
  :L0
  .line 79
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;
    invoke-virtual { v1 }, Ljava/lang/Object;->notifyAll()V
  .line 78
    monitor-exit v0
  :L1
  .line 81
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    if-nez v0, :L6
  .line 82
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    if-eqz v0, :L2
  .line 83
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    invoke-interface { v0 }, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V
  :L2
  .line 86
    return-void
  :L3
  .line 78
    move-exception v1
  :L4
    monitor-exit v0
  :L5
    throw v1
  :L6
  .line 85
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V
    goto :L2
.end method
