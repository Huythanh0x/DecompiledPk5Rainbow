.class public Lmain/CreateThread;
.super Ljava/lang/Thread;
.source "CreateThread.java"


# instance fields
.field gr:Lmain/GameRun;


# direct methods
.method public constructor <init>(Lmain/GameRun;I)V
    .locals 2
    .param p1, "gr_"    # Lmain/GameRun;
    .param p2, "type"    # I

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 16
    iput-object p1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    .line 17
    iget-object v0, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    int-to-byte v1, p2

    iput-byte v1, v0, Lmain/GameRun;->threadType:B

    .line 19
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 21
    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 24
    :try_start_0
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    const/4 v2, 0x0

    iput-byte v2, v1, Lmain/GameRun;->createOver:B

    .line 25
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->threadType:B

    if-nez v1, :cond_1

    .line 26
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v1}, Lmain/Map;->initMap()V

    .line 27
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    invoke-virtual {v1}, Lmain/GameRun;->loadItem()V

    .line 30
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    const/4 v2, 0x0

    iget-object v3, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->monster_pro:[[B

    invoke-virtual {v1, v2, v3}, Lmain/GameRun;->loadMon(I[[B)V

    .line 31
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    const/4 v2, 0x1

    iget-object v3, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->monster_pro:[[B

    invoke-virtual {v1, v2, v3}, Lmain/GameRun;->loadMon(I[[B)V

    .line 34
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    invoke-virtual {v1}, Lmain/GameRun;->loadInfoList()V

    .line 53
    :cond_0
    :goto_0
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    const/4 v2, -0x1

    iput-byte v2, v1, Lmain/GameRun;->createOver:B

    .line 58
    :goto_1
    return-void

    .line 38
    :cond_1
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->threadType:B

    if-ne v1, v3, :cond_2

    .line 39
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    invoke-virtual {v1}, Lmain/GameRun;->initBattle()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 55
    :catch_0
    move-exception v1

    move-object v0, v1

    .line 56
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 41
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_2
    :try_start_1
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->threadType:B

    const/4 v2, 0x2

    if-eq v1, v2, :cond_0

    .line 44
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->threadType:B

    const/4 v2, 0x3

    if-eq v1, v2, :cond_0

    .line 47
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->threadType:B

    const/4 v2, 0x4

    if-eq v1, v2, :cond_0

    .line 50
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->threadType:B
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
