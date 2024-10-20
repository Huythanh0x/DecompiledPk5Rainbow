.class Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;
.super Ljava/lang/Object;
.source "SyncChargeChannelHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->handleRequest()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;


# direct methods
.method constructor <init>(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;

    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;)Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 60
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;

    invoke-static {v1}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->access$0(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;)Ljava/lang/Integer;

    move-result-object v1

    monitor-enter v1

    .line 64
    :try_start_0
    iget-object v2, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;

    invoke-static {v2}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->access$0(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->wait()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 60
    :goto_0
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 71
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;

    iget-object v1, v1, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->mHandler:Landroid/os/Handler;

    new-instance v2, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1$1;

    invoke-direct {v2, p0}, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1$1;-><init>(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 79
    return-void

    .line 66
    :catch_0
    move-exception v2

    move-object v0, v2

    .line 68
    .local v0, "localInterruptedException":Ljava/lang/InterruptedException;
    :try_start_2
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0

    .line 60
    .end local v0    # "localInterruptedException":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v2

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v2
.end method
