.class public abstract Lcom/uc/paymentsdk/network/chain/Handler;
.super Ljava/lang/Object;
.source "Handler.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    }
.end annotation


# static fields
.field protected static final STATUS_SYNCED:I = 0x2

.field protected static final STATUS_SYNCING:I = 0x1

.field protected static final STATUS_UNSYNC:I


# instance fields
.field protected mContext:Landroid/content/Context;

.field protected mHandler:Landroid/os/Handler;

.field private mSuccessor:Lcom/uc/paymentsdk/network/chain/Handler;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .registers 3
    .param p1, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/uc/paymentsdk/network/chain/Handler;->mContext:Landroid/content/Context;

    .line 17
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/Handler;->mHandler:Landroid/os/Handler;

    .line 18
    return-void
.end method


# virtual methods
.method public getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;
    .registers 2

    .prologue
    .line 30
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/Handler;->mSuccessor:Lcom/uc/paymentsdk/network/chain/Handler;

    return-object v0
.end method

.method public abstract handleRequest()V
.end method

.method public setSuccessor(Lcom/uc/paymentsdk/network/chain/Handler;)Lcom/uc/paymentsdk/network/chain/Handler;
    .registers 2
    .param p1, "paramHandler"    # Lcom/uc/paymentsdk/network/chain/Handler;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/uc/paymentsdk/network/chain/Handler;->mSuccessor:Lcom/uc/paymentsdk/network/chain/Handler;

    .line 25
    return-object p0
.end method
