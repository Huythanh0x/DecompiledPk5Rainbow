.class public Lmain/CreateThread;
.super Ljava/lang/Thread;
.source "CreateThread.java"

.field gr:Lmain/GameRun;

.method public constructor <init>(Lmain/GameRun;I)V
  .parameter "gr_" # Lmain/GameRun;
  .parameter "type" # I
  .registers 5
  .prologue
  .line 15
    invoke-direct { p0 }, Ljava/lang/Thread;-><init>()V
  .line 16
    iput-object p1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
  .line 17
    iget-object v0, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    int-to-byte v1, p2
    iput-byte v1, v0, Lmain/GameRun;->threadType:B
  .line 19
    new-instance v0, Ljava/lang/Thread;
    invoke-direct { v0, p0 }, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V
    invoke-virtual { v0 }, Ljava/lang/Thread;->start()V
  .line 21
    return-void
.end method

.method public run()V
  .catch Ljava/lang/Exception; { :L0 .. :L4 } :L5
  .catch Ljava/lang/Exception; { :L6 .. :L7 } :L5
  .registers 5
  .prologue
    const/4 v3, 1
  :L0
  .line 24
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    const/4 v2, 0
    iput-byte v2, v1, Lmain/GameRun;->createOver:B
  .line 25
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-byte v1, v1, Lmain/GameRun;->threadType:B
    if-nez v1, :L3
  .line 26
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-object v1, v1, Lmain/GameRun;->map:Lmain/Map;
    invoke-virtual { v1 }, Lmain/Map;->initMap()V
  .line 27
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    invoke-virtual { v1 }, Lmain/GameRun;->loadItem()V
  .line 30
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    const/4 v2, 0
    iget-object v3, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-object v3, v3, Lmain/GameRun;->monster_pro:[[B
    invoke-virtual { v1, v2, v3 }, Lmain/GameRun;->loadMon(I[[B)V
  .line 31
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    const/4 v2, 1
    iget-object v3, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-object v3, v3, Lmain/GameRun;->monster_pro:[[B
    invoke-virtual { v1, v2, v3 }, Lmain/GameRun;->loadMon(I[[B)V
  .line 34
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    invoke-virtual { v1 }, Lmain/GameRun;->loadInfoList()V
  :L1
  .line 53
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    const/4 v2, -1
    iput-byte v2, v1, Lmain/GameRun;->createOver:B
  :L2
  .line 58
    return-void
  :L3
  .line 38
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-byte v1, v1, Lmain/GameRun;->threadType:B
    if-ne v1, v3, :L6
  .line 39
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    invoke-virtual { v1 }, Lmain/GameRun;->initBattle()V
  :L4
    goto :L1
  :L5
  .line 55
    move-exception v1
    move-object v0, v1
  .line 56
  .local v0, "e":Ljava/lang/Exception;
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L2
  :L6
  .line 41
  .end local v0
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-byte v1, v1, Lmain/GameRun;->threadType:B
    const/4 v2, 2
    if-eq v1, v2, :L1
  .line 44
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-byte v1, v1, Lmain/GameRun;->threadType:B
    const/4 v2, 3
    if-eq v1, v2, :L1
  .line 47
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-byte v1, v1, Lmain/GameRun;->threadType:B
    const/4 v2, 4
    if-eq v1, v2, :L1
  .line 50
    iget-object v1, p0, Lmain/CreateThread;->gr:Lmain/GameRun;
    iget-byte v1, v1, Lmain/GameRun;->threadType:B
  :L7
    goto :L1
.end method
