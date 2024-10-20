.class public Lminigame/Mg;
.super Ljava/lang/Object;
.source "Mg.java"

.field private static mgListener:Lminigame/Mg;

.field private mg:Lminigame/MiniGame_H;

.field public type:B

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 8
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    sput-object p0, Lminigame/Mg;->mgListener:Lminigame/Mg;
    return-void
.end method

.method public static i()Lminigame/Mg;
  .registers 1
  .prologue
  .line 10
    sget-object v0, Lminigame/Mg;->mgListener:Lminigame/Mg;
    if-nez v0, :L0
    new-instance v0, Lminigame/Mg;
    invoke-direct { v0 }, Lminigame/Mg;-><init>()V
    sput-object v0, Lminigame/Mg;->mgListener:Lminigame/Mg;
  :L0
  .line 11
    sget-object v0, Lminigame/Mg;->mgListener:Lminigame/Mg;
    return-object v0
.end method

.method private setGame(Lmain/GameRun;I)V
  .parameter "gr" # Lmain/GameRun;
  .parameter "i" # I
  .registers 4
  .prologue
  .line 16
    const/4 v0, 0
    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
  .line 17
    int-to-byte v0, p2
    iput-byte v0, p0, Lminigame/Mg;->type:B
  .line 18
    packed-switch p2, :L5
  :L0
  .line 24
    return-void
  :L1
  .line 19
    new-instance v0, Lminigame/Racing;
    invoke-direct { v0, p1 }, Lminigame/Racing;-><init>(Lmain/GameRun;)V
    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
    goto :L0
  :L2
  .line 20
    new-instance v0, Lminigame/Bearer;
    invoke-direct { v0, p1 }, Lminigame/Bearer;-><init>(Lmain/GameRun;)V
    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
    goto :L0
  :L3
  .line 21
    new-instance v0, Lminigame/Cards;
    invoke-direct { v0, p1 }, Lminigame/Cards;-><init>(Lmain/GameRun;)V
    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
    goto :L0
  :L4
  .line 22
    new-instance v0, Lminigame/Guess;
    invoke-direct { v0, p1 }, Lminigame/Guess;-><init>(Lmain/GameRun;)V
    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
    goto :L0
  .line 18
  :L5
  .packed-switch 0
    :L1
    :L2
    :L3
    :L4
  .end packed-switch
.end method

.method public go(Lmain/GameRun;III)V
  .parameter "gr" # Lmain/GameRun;
  .parameter "i" # I
  .parameter "mode" # I
  .parameter "lv" # I
  .registers 6
  .prologue
  .line 26
    const/16 v0, 69
    sput v0, Lmain/GameRun;->run_state:I
  .line 27
    invoke-direct { p0, p1, p2 }, Lminigame/Mg;->setGame(Lmain/GameRun;I)V
  .line 28
    iget-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
    invoke-interface { v0, p3, p4 }, Lminigame/MiniGame_H;->go(II)V
  .line 29
    return-void
.end method

.method public key(Lmain/GameRun;)V
  .parameter "gr" # Lmain/GameRun;
  .registers 3
  .prologue
  .line 34
    iget-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
    invoke-interface { v0 }, Lminigame/MiniGame_H;->key()Z
    move-result v0
    if-eqz v0, :L0
  .line 35
    const/16 v0, -10
    sput v0, Lmain/GameRun;->run_state:I
  .line 36
    const/4 v0, 0
    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
  :L0
  .line 38
    return-void
.end method

.method public paint()V
  .registers 2
  .prologue
  .line 31
    iget-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
    invoke-interface { v0 }, Lminigame/MiniGame_H;->patin()V
    return-void
.end method

.method public run()V
  .registers 2
  .prologue
  .line 32
    iget-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;
    invoke-interface { v0 }, Lminigame/MiniGame_H;->run()V
    return-void
.end method
