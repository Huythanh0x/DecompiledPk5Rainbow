.class Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1$1;
.super Ljava/lang/Object;
.implements Ljava/lang/Runnable;
.source "SyncChargeChannelHandler.java"

.annotation system Ldalvik/annotation/EnclosingMethod;
  value = Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;->run()V
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 0
  name = null
.end annotation

.field final synthetic this$1:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;

.method constructor <init>(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;)V
  .registers 2
  .prologue
  .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1$1;->this$1:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;
  .line 71
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public run()V
  .registers 2
  .prologue
  .line 76
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1$1;->this$1:Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;
    invoke-static { v0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;->access$0(Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler$1;)Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;
    move-result-object v0
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/chain/SyncChargeChannelHandler;->handleRequest()V
  .line 77
    return-void
.end method
