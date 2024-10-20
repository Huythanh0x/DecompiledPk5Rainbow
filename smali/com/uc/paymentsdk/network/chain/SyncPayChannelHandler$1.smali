.class Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;
.super Ljava/lang/Object;
.implements Ljava/lang/Runnable;
.source "SyncPayChannelHandler.java"

.annotation system Ldalvik/annotation/EnclosingMethod;
  value = Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->handleRequest()V
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 0
  name = null
.end annotation

.field final synthetic this$0:Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;

.method constructor <init>(Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;)V
  .registers 2
  .prologue
  .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;
  .line 54
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;)Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;
  .registers 2
  .prologue
  .line 54
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;
    return-object v0
.end method

.method public run()V
  .catch Ljava/lang/InterruptedException; { :L0 .. :L1 } :L3
  .catchall { :L0 .. :L1 } :L5
  .catchall { :L1 .. :L2 } :L5
  .catchall { :L4 .. :L6 } :L5
  .registers 4
  .prologue
  .line 59
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;
    invoke-static { v1 }, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->access$0(Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;)Ljava/lang/Integer;
    move-result-object v1
    monitor-enter v1
  :L0
  .line 63
    iget-object v2, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;
    invoke-static { v2 }, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->access$0(Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/Object;->wait()V
  :L1
  .line 59
    monitor-exit v1
  :L2
  .line 70
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;
    iget-object v1, v1, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler;->mHandler:Landroid/os/Handler;
    new-instance v2, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1$1;
    invoke-direct { v2, p0 }, Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1$1;-><init>(Lcom/uc/paymentsdk/network/chain/SyncPayChannelHandler$1;)V
    invoke-virtual { v1, v2 }, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
  .line 78
    return-void
  :L3
  .line 65
    move-exception v2
    move-object v0, v2
  :L4
  .line 67
  .local v0, "localInterruptedException":Ljava/lang/InterruptedException;
    invoke-virtual { v0 }, Ljava/lang/InterruptedException;->printStackTrace()V
    goto :L1
  :L5
  .line 59
  .end local v0
    move-exception v2
    monitor-exit v1
  :L6
    throw v2
.end method
