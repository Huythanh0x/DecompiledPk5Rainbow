.class public Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;
.super Lcom/uc/paymentsdk/network/chain/Handler;
.source "SyncPayChannelHandler.java"

# interfaces
.implements Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;


# static fields
.field private static sStatus:I


# instance fields
.field private final LOCK:Ljava/lang/Integer;

.field private mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V

    .line 18
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->LOCK:Ljava/lang/Integer;

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V
    .locals 1
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paramOnFinishListener"    # Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V

    .line 18
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->LOCK:Ljava/lang/Integer;

    .line 28
    iput-object p2, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    .line 29
    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;)Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->LOCK:Ljava/lang/Integer;

    return-object v0
.end method

.method public static init()V
    .locals 1

    .prologue
    .line 33
    const/4 v0, 0x0

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->sStatus:I

    .line 34
    return-void
.end method


# virtual methods
.method public handleRequest()V
    .locals 2

    .prologue
    .line 39
    sget v0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->sStatus:I

    packed-switch v0, :pswitch_data_0

    .line 85
    :cond_0
    :goto_0
    return-void

    .line 42
    :pswitch_0
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    if-nez v0, :cond_1

    .line 44
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v0, :cond_0

    .line 46
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v0}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    goto :goto_0

    .line 50
    :cond_1
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_0

    .line 54
    :pswitch_1
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;

    invoke-direct {v1, p0}, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;-><init>(Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 79
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 82
    :pswitch_2
    const/4 v0, 0x1

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->sStatus:I

    .line 83
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mContext:Landroid/content/Context;

    invoke-static {v0, p0}, Lcom/uc/paymentsdk/network/Api;->syncPayChannel(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;)V

    goto :goto_0

    .line 39
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onError(II)V
    .locals 2
    .param p1, "paramInt1"    # I
    .param p2, "paramInt2"    # I

    .prologue
    .line 124
    const/4 v0, 0x0

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->sStatus:I

    .line 125
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->LOCK:Ljava/lang/Integer;

    monitor-enter v0

    .line 127
    :try_start_0
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->LOCK:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 125
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 129
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    if-nez v0, :cond_1

    .line 131
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v0, :cond_0

    .line 132
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v0}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    .line 136
    :cond_0
    :goto_0
    return-void

    .line 125
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 135
    :cond_1
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_0
.end method

.method public onPreHandle(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
    .locals 3
    .param p1, "paramInt"    # I
    .param p2, "paramHttpResponse"    # Lorg/apache/http/HttpResponse;

    .prologue
    const/4 v2, 0x0

    .line 108
    invoke-static {p1, p2}, Lcom/uc/paymentsdk/util/Utils;->getBodyString(ILorg/apache/http/HttpResponse;)Ljava/lang/String;

    move-result-object v0

    .line 109
    .local v0, "str":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    move-object v1, v2

    .line 118
    :goto_0
    return-object v1

    .line 113
    :cond_0
    :try_start_0
    invoke-static {v0}, Lcom/uc/paymentsdk/network/XMLParser;->parsePayChannel(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 115
    :catch_0
    move-exception v1

    move-object v1, v2

    .line 118
    goto :goto_0
.end method

.method public onSuccess(ILjava/lang/Object;)V
    .locals 2
    .param p1, "paramInt"    # I
    .param p2, "paramObject"    # Ljava/lang/Object;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mContext:Landroid/content/Context;

    check-cast p2, Ljava/lang/String;

    .end local p2    # "paramObject":Ljava/lang/Object;
    invoke-static {v0, p2}, Lcom/uc/paymentsdk/util/PrefUtil;->syncPayChannels(Landroid/content/Context;Ljava/lang/String;)V

    .line 91
    const/4 v0, 0x2

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->sStatus:I

    .line 92
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->LOCK:Ljava/lang/Integer;

    monitor-enter v0

    .line 94
    :try_start_0
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->LOCK:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 92
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 96
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    if-nez v0, :cond_1

    .line 98
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v0}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    .line 103
    :cond_0
    :goto_0
    return-void

    .line 92
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 102
    :cond_1
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_0
.end method
