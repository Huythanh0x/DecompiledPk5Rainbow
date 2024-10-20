.class public Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;
.super Lcom/uc/paymentsdk/network/chain/Handler;
.source "SyncChargeChannelHandler.java"

# interfaces
.implements Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;


# static fields
.field private static sStatus:I


# instance fields
.field private final LOCK:Ljava/lang/Integer;

.field private mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .param p1, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V

    .line 19
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V
    .registers 4
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paramOnFinishListener"    # Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V

    .line 19
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

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
    const/4 v0, 0x0

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I

    .line 35
    return-void
.end method


# virtual methods
.method public handleRequest()V
    .registers 3

    .prologue
    .line 40
    sget v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I

    packed-switch v0, :pswitch_data_36

    .line 86
    :cond_5
    :goto_5
    return-void

    .line 43
    :pswitch_6
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    if-nez v0, :cond_16

    .line 45
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v0, :cond_5

    .line 47
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v0}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    goto :goto_5

    .line 51
    :cond_16
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_5

    .line 55
    :pswitch_1e
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;

    invoke-direct {v1, p0}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;-><init>(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 80
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_5

    .line 83
    :pswitch_2c
    const/4 v0, 0x1

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I

    .line 84
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mContext:Landroid/content/Context;

    invoke-static {v0, p0}, Lcom/uc/paymentsdk/network/Api;->syncChargeChannel(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;)V

    goto :goto_5

    .line 40
    nop

    :pswitch_data_36
    .packed-switch 0x0
        :pswitch_2c
        :pswitch_1e
        :pswitch_6
    .end packed-switch
.end method

.method public onError(II)V
    .registers 5
    .param p1, "paramInt1"    # I
    .param p2, "paramInt2"    # I

    .prologue
    .line 125
    const/4 v0, 0x0

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I

    .line 126
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;

    monitor-enter v0

    .line 128
    :try_start_6
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 126
    monitor-exit v0
    :try_end_c
    .catchall {:try_start_6 .. :try_end_c} :catchall_1c

    .line 130
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    if-nez v0, :cond_1f

    .line 132
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v0, :cond_1b

    .line 133
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v0}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    .line 137
    :cond_1b
    :goto_1b
    return-void

    .line 126
    :catchall_1c
    move-exception v1

    :try_start_1d
    monitor-exit v0
    :try_end_1e
    .catchall {:try_start_1d .. :try_end_1e} :catchall_1c

    throw v1

    .line 136
    :cond_1f
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_1b
.end method

.method public onPreHandle(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
    .registers 6
    .param p1, "paramInt"    # I
    .param p2, "paramHttpResponse"    # Lorg/apache/http/HttpResponse;

    .prologue
    const/4 v2, 0x0

    .line 109
    invoke-static {p1, p2}, Lcom/uc/paymentsdk/util/Utils;->getBodyString(ILorg/apache/http/HttpResponse;)Ljava/lang/String;

    move-result-object v0

    .line 110
    .local v0, "str":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_d

    move-object v1, v2

    .line 119
    :goto_c
    return-object v1

    .line 114
    :cond_d
    :try_start_d
    invoke-static {v0}, Lcom/uc/paymentsdk/network/JSONParser;->parseChargeChannel(Ljava/lang/String;)[Ljava/lang/String;
    :try_end_10
    .catch Lorg/json/JSONException; {:try_start_d .. :try_end_10} :catch_12

    move-result-object v1

    goto :goto_c

    .line 116
    :catch_12
    move-exception v1

    move-object v1, v2

    .line 119
    goto :goto_c
.end method

.method public onSuccess(ILjava/lang/Object;)V
    .registers 5
    .param p1, "paramInt"    # I
    .param p2, "paramObject"    # Ljava/lang/Object;

    .prologue
    .line 91
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mContext:Landroid/content/Context;

    check-cast p2, [Ljava/lang/String;

    .end local p2    # "paramObject":Ljava/lang/Object;
    invoke-static {v0, p2}, Lcom/uc/paymentsdk/util/PrefUtil;->syncChargeChannels(Landroid/content/Context;[Ljava/lang/String;)V

    .line 92
    const/4 v0, 0x2

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->sStatus:I

    .line 93
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;

    monitor-enter v0

    .line 95
    :try_start_d
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->LOCK:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 93
    monitor-exit v0
    :try_end_13
    .catchall {:try_start_d .. :try_end_13} :catchall_23

    .line 97
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    if-nez v0, :cond_26

    .line 99
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v0, :cond_22

    .line 100
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v0}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    .line 104
    :cond_22
    :goto_22
    return-void

    .line 93
    :catchall_23
    move-exception v1

    :try_start_24
    monitor-exit v0
    :try_end_25
    .catchall {:try_start_24 .. :try_end_25} :catchall_23

    throw v1

    .line 103
    :cond_26
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_22
.end method
