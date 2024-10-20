.class public Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;
.super Lcom/uc/paymentsdk/network/chain/Handler;
.implements Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
.source "SyncChargeChannelHandler.java"

.field private static sStatus:I

.field private final LOCK:Ljava/lang/Integer;

.field private mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

.method public constructor <init>(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 23
    invoke-direct { p0, p1 }, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V
  .line 19
    const/4 v0, 0
    invoke-static { v0 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;
  .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramOnFinishListener" # Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
  .registers 4
  .prologue
  .line 28
    invoke-direct { p0, p1 }, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V
  .line 19
    const/4 v0, 0
    invoke-static { v0 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;
  .line 29
    iput-object p2, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
  .line 30
    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;)Ljava/lang/Integer;
  .registers 2
  .prologue
  .line 19
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;
    return-object v0
.end method

.method public static init()V
  .registers 1
  .prologue
  .line 34
    const/4 v0, 0
    sput v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I
  .line 35
    return-void
.end method

.method public handleRequest()V
  .registers 3
  .prologue
  .line 40
    sget v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I
    packed-switch v0, :L5
  :L0
  .line 86
    return-void
  :L1
  .line 43
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    if-nez v0, :L2
  .line 45
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    if-eqz v0, :L0
  .line 47
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    invoke-interface { v0 }, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V
    goto :L0
  :L2
  .line 51
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V
    goto :L0
  :L3
  .line 55
    new-instance v0, Ljava/lang/Thread;
    new-instance v1, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;
    invoke-direct { v1, p0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;-><init>(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;)V
    invoke-direct { v0, v1 }, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V
  .line 80
    invoke-virtual { v0 }, Ljava/lang/Thread;->start()V
    goto :L0
  :L4
  .line 83
    const/4 v0, 1
    sput v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I
  .line 84
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mContext:Landroid/content/Context;
    invoke-static { v0, p0 }, Lcom/uc/paymentsdk/network/Api;->syncChargeChannel(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;)V
    goto :L0
  .line 40
  :L5
  .packed-switch 0
    :L4
    :L3
    :L1
  .end packed-switch
.end method

.method public onError(II)V
  .parameter "paramInt1" # I
  .parameter "paramInt2" # I
  .catchall { :L0 .. :L1 } :L3
  .catchall { :L4 .. :L5 } :L3
  .registers 5
  .prologue
  .line 125
    const/4 v0, 0
    sput v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I
  .line 126
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;
    monitor-enter v0
  :L0
  .line 128
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;
    invoke-virtual { v1 }, Ljava/lang/Object;->notifyAll()V
  .line 126
    monitor-exit v0
  :L1
  .line 130
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    if-nez v0, :L6
  .line 132
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    if-eqz v0, :L2
  .line 133
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    invoke-interface { v0 }, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V
  :L2
  .line 137
    return-void
  :L3
  .line 126
    move-exception v1
  :L4
    monitor-exit v0
  :L5
    throw v1
  :L6
  .line 136
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V
    goto :L2
.end method

.method public onPreHandle(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
  .parameter "paramInt" # I
  .parameter "paramHttpResponse" # Lorg/apache/http/HttpResponse;
  .catch Lorg/json/JSONException; { :L1 .. :L2 } :L3
  .registers 6
  .prologue
    const/4 v2, 0
  .line 109
    invoke-static { p1, p2 }, Lcom/uc/paymentsdk/util/Utils;->getBodyString(ILorg/apache/http/HttpResponse;)Ljava/lang/String;
    move-result-object v0
  .line 110
  .local v0, "str":Ljava/lang/String;
    invoke-static { v0 }, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, :L1
    move-object v1, v2
  :L0
  .line 119
    return-object v1
  :L1
  .line 114
    invoke-static { v0 }, Lcom/uc/paymentsdk/network/JSONParser;->parseChargeChannel(Ljava/lang/String;)[Ljava/lang/String;
  :L2
    move-result-object v1
    goto :L0
  :L3
  .line 116
    move-exception v1
    move-object v1, v2
  .line 119
    goto :L0
.end method

.method public onSuccess(ILjava/lang/Object;)V
  .parameter "paramInt" # I
  .parameter "paramObject" # Ljava/lang/Object;
  .catchall { :L0 .. :L1 } :L3
  .catchall { :L4 .. :L5 } :L3
  .registers 5
  .prologue
  .line 91
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mContext:Landroid/content/Context;
    check-cast p2, [Ljava/lang/String;
  .end local p2
    invoke-static { v0, p2 }, Lcom/uc/paymentsdk/util/PrefUtil;->syncChargeChannels(Landroid/content/Context;[Ljava/lang/String;)V
  .line 92
    const/4 v0, 2
    sput v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I
  .line 93
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;
    monitor-enter v0
  :L0
  .line 95
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;
    invoke-virtual { v1 }, Ljava/lang/Object;->notifyAll()V
  .line 93
    monitor-exit v0
  :L1
  .line 97
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    if-nez v0, :L6
  .line 99
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    if-eqz v0, :L2
  .line 100
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    invoke-interface { v0 }, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V
  :L2
  .line 104
    return-void
  :L3
  .line 93
    move-exception v1
  :L4
    monitor-exit v0
  :L5
    throw v1
  :L6
  .line 103
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    move-result-object v0
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V
    goto :L2
.end method
