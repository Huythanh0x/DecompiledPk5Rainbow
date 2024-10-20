.class public Lcom/uc/paymentsdk/network/chain/HandlerProxy;
.super Lcom/uc/paymentsdk/network/chain/Handler;
.source "HandlerProxy.java"


# instance fields
.field private handler:Lcom/uc/paymentsdk/network/chain/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .param p1, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V

    .line 18
    new-instance v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;

    invoke-direct {v0, p1}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/HandlerProxy;->handler:Lcom/uc/paymentsdk/network/chain/Handler;

    .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V
    .registers 4
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paramOnFinishListener"    # Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    .prologue
    .line 11
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V

    .line 12
    new-instance v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;

    invoke-direct {v0, p1, p2}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;-><init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V

    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/HandlerProxy;->handler:Lcom/uc/paymentsdk/network/chain/Handler;

    .line 13
    return-void
.end method


# virtual methods
.method public handleRequest()V
    .registers 2

    .prologue
    .line 24
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/HandlerProxy;->handler:Lcom/uc/paymentsdk/network/chain/Handler;

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    .line 25
    return-void
.end method
