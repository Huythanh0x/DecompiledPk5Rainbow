.class public Lminigame/Mg;
.super Ljava/lang/Object;
.source "Mg.java"


# static fields
.field private static mgListener:Lminigame/Mg;


# instance fields
.field private mg:Lminigame/MiniGame_H;

.field public type:B


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sput-object p0, Lminigame/Mg;->mgListener:Lminigame/Mg;

    return-void
.end method

.method public static i()Lminigame/Mg;
    .registers 1

    .prologue
    .line 10
    sget-object v0, Lminigame/Mg;->mgListener:Lminigame/Mg;

    if-nez v0, :cond_b

    new-instance v0, Lminigame/Mg;

    invoke-direct {v0}, Lminigame/Mg;-><init>()V

    sput-object v0, Lminigame/Mg;->mgListener:Lminigame/Mg;

    .line 11
    :cond_b
    sget-object v0, Lminigame/Mg;->mgListener:Lminigame/Mg;

    return-object v0
.end method

.method private setGame(Lmain/GameRun;I)V
    .registers 4
    .param p1, "gr"    # Lmain/GameRun;
    .param p2, "i"    # I

    .prologue
    .line 16
    const/4 v0, 0x0

    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    .line 17
    int-to-byte v0, p2

    iput-byte v0, p0, Lminigame/Mg;->type:B

    .line 18
    packed-switch p2, :pswitch_data_2a

    .line 24
    :goto_9
    return-void

    .line 19
    :pswitch_a
    new-instance v0, Lminigame/Racing;

    invoke-direct {v0, p1}, Lminigame/Racing;-><init>(Lmain/GameRun;)V

    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    goto :goto_9

    .line 20
    :pswitch_12
    new-instance v0, Lminigame/Bearer;

    invoke-direct {v0, p1}, Lminigame/Bearer;-><init>(Lmain/GameRun;)V

    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    goto :goto_9

    .line 21
    :pswitch_1a
    new-instance v0, Lminigame/Cards;

    invoke-direct {v0, p1}, Lminigame/Cards;-><init>(Lmain/GameRun;)V

    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    goto :goto_9

    .line 22
    :pswitch_22
    new-instance v0, Lminigame/Guess;

    invoke-direct {v0, p1}, Lminigame/Guess;-><init>(Lmain/GameRun;)V

    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    goto :goto_9

    .line 18
    :pswitch_data_2a
    .packed-switch 0x0
        :pswitch_a
        :pswitch_12
        :pswitch_1a
        :pswitch_22
    .end packed-switch
.end method


# virtual methods
.method public go(Lmain/GameRun;III)V
    .registers 6
    .param p1, "gr"    # Lmain/GameRun;
    .param p2, "i"    # I
    .param p3, "mode"    # I
    .param p4, "lv"    # I

    .prologue
    .line 26
    const/16 v0, 0x45

    sput v0, Lmain/GameRun;->run_state:I

    .line 27
    invoke-direct {p0, p1, p2}, Lminigame/Mg;->setGame(Lmain/GameRun;I)V

    .line 28
    iget-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    invoke-interface {v0, p3, p4}, Lminigame/MiniGame_H;->go(II)V

    .line 29
    return-void
.end method

.method public key(Lmain/GameRun;)V
    .registers 3
    .param p1, "gr"    # Lmain/GameRun;

    .prologue
    .line 34
    iget-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    invoke-interface {v0}, Lminigame/MiniGame_H;->key()Z

    move-result v0

    if-eqz v0, :cond_f

    .line 35
    const/16 v0, -0xa

    sput v0, Lmain/GameRun;->run_state:I

    .line 36
    const/4 v0, 0x0

    iput-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    .line 38
    :cond_f
    return-void
.end method

.method public paint()V
    .registers 2

    .prologue
    .line 31
    iget-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    invoke-interface {v0}, Lminigame/MiniGame_H;->patin()V

    return-void
.end method

.method public run()V
    .registers 2

    .prologue
    .line 32
    iget-object v0, p0, Lminigame/Mg;->mg:Lminigame/MiniGame_H;

    invoke-interface {v0}, Lminigame/MiniGame_H;->run()V

    return-void
.end method
