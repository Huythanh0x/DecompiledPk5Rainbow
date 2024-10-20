.class Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;
.super Ljava/lang/Object;
.source "SyncSmsInfoHandler.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->handleRequest()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;


# direct methods
.method constructor <init>(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;)V
    .registers 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;

    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;)Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;
    .registers 2

    .prologue
    .line 39
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;

    return-object v0
.end method


# virtual methods
.method public run()V
    .registers 4

    .prologue
    .line 42
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;

    invoke-static {v1}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->access$0(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;)Ljava/lang/Integer;

    move-result-object v1

    monitor-enter v1

    .line 44
    :try_start_7
    iget-object v2, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;

    invoke-static {v2}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->access$0(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->wait()V
    :try_end_10
    .catch Ljava/lang/InterruptedException; {:try_start_7 .. :try_end_10} :catch_1e
    .catchall {:try_start_7 .. :try_end_10} :catchall_24

    .line 42
    :goto_10
    :try_start_10
    monitor-exit v1
    :try_end_11
    .catchall {:try_start_10 .. :try_end_11} :catchall_24

    .line 49
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;->this$0:Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;

    iget-object v1, v1, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mHandler:Landroid/os/Handler;

    new-instance v2, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1$1;

    invoke-direct {v2, p0}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1$1;-><init>(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 55
    return-void

    .line 45
    :catch_1e
    move-exception v2

    move-object v0, v2

    .line 46
    .local v0, "localInterruptedException":Ljava/lang/InterruptedException;
    :try_start_20
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_10

    .line 42
    .end local v0    # "localInterruptedException":Ljava/lang/InterruptedException;
    :catchall_24
    move-exception v2

    monitor-exit v1
    :try_end_26
    .catchall {:try_start_20 .. :try_end_26} :catchall_24

    throw v2
.end method
