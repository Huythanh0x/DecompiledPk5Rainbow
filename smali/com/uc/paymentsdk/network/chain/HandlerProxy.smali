.class public Lcom/uc/paymentsdk/network/chain/HandlerProxy;
.super Lcom/uc/paymentsdk/network/chain/Handler;
.source "HandlerProxy.java"

.field private handler:Lcom/uc/paymentsdk/network/chain/Handler;

.method public constructor <init>(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 17
    invoke-direct { p0, p1 }, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V
  .line 18
    new-instance v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;
    invoke-direct { v0, p1 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;-><init>(Landroid/content/Context;)V
    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/HandlerProxy;->handler:Lcom/uc/paymentsdk/network/chain/Handler;
  .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramOnFinishListener" # Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
  .registers 4
  .prologue
  .line 11
    invoke-direct { p0, p1 }, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V
  .line 12
    new-instance v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;
    invoke-direct { v0, p1, p2 }, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;-><init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V
    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/HandlerProxy;->handler:Lcom/uc/paymentsdk/network/chain/Handler;
  .line 13
    return-void
.end method

.method public handleRequest()V
  .registers 2
  .prologue
  .line 24
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/HandlerProxy;->handler:Lcom/uc/paymentsdk/network/chain/Handler;
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V
  .line 25
    return-void
.end method
