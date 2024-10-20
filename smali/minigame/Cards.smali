.class public Lminigame/Cards;
.super Ljava/lang/Object;
.source "Cards.java"

# interfaces
.implements Lminigame/MiniGame_H;


# instance fields
.field private count:S

.field private findC:[[B

.field private findN:[[B

.field private find_count:B

.field private gh:S

.field gr:Lmain/GameRun;

.field private gspace:S

.field private gw:S

.field private gx:S

.field private gy:S

.field private hh:S

.field private length:B

.field private lv:B

.field private num:[[B

.field sel:B

.field private sell_money:I

.field private selx:B

.field private sely:B

.field private state:B

.field private time:B

.field private tx:B

.field private ty:B

.field private wh:S


# direct methods
.method public constructor <init>(Lmain/GameRun;)V
    .registers 7
    .param p1, "gr_"    # Lmain/GameRun;

    .prologue
    const/4 v1, 0x4

    const/4 v4, 0x3

    const/4 v3, 0x2

    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const/16 v0, 0x1e

    iput-short v0, p0, Lminigame/Cards;->gw:S

    const/16 v0, 0x28

    iput-short v0, p0, Lminigame/Cards;->gh:S

    iput-short v1, p0, Lminigame/Cards;->gspace:S

    .line 26
    const/16 v0, 0x140

    iput-short v0, p0, Lminigame/Cards;->wh:S

    const/16 v0, 0xa0

    iput-short v0, p0, Lminigame/Cards;->hh:S

    .line 30
    iput-byte v4, p0, Lminigame/Cards;->time:B

    .line 31
    iput-byte v4, p0, Lminigame/Cards;->find_count:B

    .line 37
    new-array v0, v1, [[B

    const/4 v1, 0x0

    .line 38
    new-array v2, v3, [B

    fill-array-data v2, :array_42

    aput-object v2, v0, v1

    const/4 v1, 0x1

    .line 39
    new-array v2, v3, [B

    fill-array-data v2, :array_48

    aput-object v2, v0, v1

    .line 40
    new-array v1, v3, [B

    fill-array-data v1, :array_4e

    aput-object v1, v0, v3

    .line 41
    new-array v1, v3, [B

    fill-array-data v1, :array_54

    aput-object v1, v0, v4

    iput-object v0, p0, Lminigame/Cards;->num:[[B

    .line 19
    iput-object p1, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    return-void

    .line 38
    nop

    :array_42
    .array-data 1
        0x3t
        0x4t
    .end array-data

    .line 39
    nop

    :array_48
    .array-data 1
        0x3t
        0x6t
    .end array-data

    .line 40
    nop

    :array_4e
    .array-data 1
        0x4t
        0x6t
    .end array-data

    .line 41
    nop

    :array_54
    .array-data 1
        0x5t
        0x6t
    .end array-data
.end method

.method private drawCard(IIIII)V
    .registers 12
    .param p1, "i"    # I
    .param p2, "j"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "mode"    # I

    .prologue
    .line 304
    if-nez p5, :cond_26

    .line 305
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-short v3, p0, Lminigame/Cards;->gw:S

    iget-short v4, p0, Lminigame/Cards;->gh:S

    const/4 v5, 0x1

    move v1, p3

    move v2, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 306
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0x19

    iget-short v2, p0, Lminigame/Cards;->gw:S

    shr-int/lit8 v2, v2, 0x1

    add-int/2addr v2, p3

    iget-short v3, p0, Lminigame/Cards;->gh:S

    shr-int/lit8 v3, v3, 0x1

    add-int/2addr v3, p4

    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 316
    :goto_25
    return-void

    .line 307
    :cond_26
    const/4 v0, 0x1

    if-ne p5, v0, :cond_57

    .line 308
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-short v1, p0, Lminigame/Cards;->gw:S

    shr-int/lit8 v1, v1, 0x1

    add-int/2addr v1, p3

    const/4 v2, 0x2

    sub-int/2addr v1, v2

    const/4 v2, 0x3

    sub-int v2, p4, v2

    const/4 v3, 0x5

    iget-short v4, p0, Lminigame/Cards;->gh:S

    add-int/lit8 v4, v4, 0x6

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 309
    iget-object v0, p0, Lminigame/Cards;->findC:[[B

    aget-object v0, v0, p1

    aget-byte v1, v0, p2

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    aput-byte v1, v0, p2

    const/4 v0, 0x3

    if-le v1, v0, :cond_55

    iget-object v0, p0, Lminigame/Cards;->findC:[[B

    aget-object v0, v0, p1

    const/4 v1, 0x0

    aput-byte v1, v0, p2

    .line 310
    :cond_55
    const/4 p5, 0x2

    goto :goto_25

    .line 312
    :cond_57
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-short v3, p0, Lminigame/Cards;->gw:S

    iget-short v4, p0, Lminigame/Cards;->gh:S

    const/4 v5, 0x5

    move v1, p3

    move v2, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 313
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget-object v1, p0, Lminigame/Cards;->findN:[[B

    aget-object v1, v1, p1

    aget-byte v1, v1, p2

    iget-short v2, p0, Lminigame/Cards;->gw:S

    shr-int/lit8 v2, v2, 0x1

    add-int/2addr v2, p3

    iget-short v3, p0, Lminigame/Cards;->gh:S

    shr-int/lit8 v3, v3, 0x1

    add-int/2addr v3, p4

    const/4 v4, 0x3

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawItem(IIII)V

    .line 314
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lminigame/Cards;->findN:[[B

    aget-object v2, v2, p1

    aget-byte v2, v2, p2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-short v2, p0, Lminigame/Cards;->gw:S

    add-int/2addr v2, p3

    iget-short v3, p0, Lminigame/Cards;->gh:S

    add-int/2addr v3, p4

    const/16 v4, 0x28

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    goto :goto_25
.end method

.method private drawGame(III)V
    .registers 16
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "h"    # I

    .prologue
    .line 265
    const/16 v11, 0x140

    .local v11, "WIDTH_H":I
    const/16 v10, 0xb4

    .line 276
    .local v10, "HEIGHT_H":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_5
    iget-object v0, p0, Lminigame/Cards;->findN:[[B

    array-length v0, v0

    if-lt v1, v0, :cond_5b

    .line 288
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const v4, 0xeafcff

    iget-short v0, p0, Lminigame/Cards;->wh:S

    iget-short v1, p0, Lminigame/Cards;->gx:S

    .end local v1    # "i":I
    add-int/2addr v0, v1

    iget-byte v1, p0, Lminigame/Cards;->tx:B

    iget-short v2, p0, Lminigame/Cards;->gw:S

    iget-short v5, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v2, v5

    mul-int/2addr v1, v2

    add-int v5, v0, v1

    iget-short v0, p0, Lminigame/Cards;->hh:S

    iget-short v1, p0, Lminigame/Cards;->gy:S

    add-int/2addr v0, v1

    iget-byte v1, p0, Lminigame/Cards;->ty:B

    iget-short v2, p0, Lminigame/Cards;->gh:S

    iget-short v6, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v2, v6

    mul-int/2addr v1, v2

    add-int v6, v0, v1

    iget-short v7, p0, Lminigame/Cards;->gw:S

    iget-short v8, p0, Lminigame/Cards;->gh:S

    const/4 v9, 0x3

    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawRectZ(IIIIII)V

    .line 290
    iget-short v0, p0, Lminigame/Cards;->count:S

    if-lez v0, :cond_d6

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-short v1, p0, Lminigame/Cards;->count:S

    div-int/lit8 v1, v1, 0xa

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    add-int/lit8 v5, v11, 0xa

    const/16 v6, 0x1d

    const/16 v7, 0x24

    const/4 v8, 0x2

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 302
    :goto_5a
    return-void

    .line 277
    .restart local v1    # "i":I
    :cond_5b
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_5c
    iget-object v0, p0, Lminigame/Cards;->findN:[[B

    aget-object v0, v0, v1

    array-length v0, v0

    if-lt v2, v0, :cond_66

    .line 276
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 279
    :cond_66
    iget-short v0, p0, Lminigame/Cards;->wh:S

    iget-short v3, p0, Lminigame/Cards;->gx:S

    add-int/2addr v0, v3

    iget-short v3, p0, Lminigame/Cards;->gw:S

    iget-short v4, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v3, v4

    mul-int/2addr v3, v2

    add-int/2addr v3, v0

    iget-short v0, p0, Lminigame/Cards;->hh:S

    iget-short v4, p0, Lminigame/Cards;->gy:S

    add-int/2addr v0, v4

    iget-short v4, p0, Lminigame/Cards;->gh:S

    iget-short v5, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v4, v5

    mul-int/2addr v4, v1

    add-int/2addr v4, v0

    iget-object v0, p0, Lminigame/Cards;->findC:[[B

    aget-object v0, v0, v1

    aget-byte v0, v0, v2

    const/4 v5, 0x3

    if-ne v0, v5, :cond_ce

    const/4 v0, 0x1

    move v5, v0

    :goto_89
    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lminigame/Cards;->drawCard(IIIII)V

    .line 281
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-short v3, p0, Lminigame/Cards;->wh:S

    iget-short v4, p0, Lminigame/Cards;->gx:S

    add-int/2addr v3, v4

    iget-short v4, p0, Lminigame/Cards;->gw:S

    iget-short v5, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v4, v5

    mul-int/2addr v4, v2

    add-int/2addr v3, v4

    iget-short v4, p0, Lminigame/Cards;->hh:S

    iget-short v5, p0, Lminigame/Cards;->gy:S

    add-int/2addr v4, v5

    iget-short v5, p0, Lminigame/Cards;->gh:S

    iget-short v6, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v5, v6

    mul-int/2addr v5, v1

    add-int/2addr v4, v5

    iget-short v5, p0, Lminigame/Cards;->gw:S

    iget-short v6, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v5, v6

    iget-short v6, p0, Lminigame/Cards;->gh:S

    iget-short v7, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v6, v7

    invoke-virtual {v0, v3, v4, v5, v6}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v0

    if-eqz v0, :cond_cb

    iget-byte v0, p0, Lminigame/Cards;->state:B

    const/4 v3, 0x3

    if-ge v0, v3, :cond_cb

    .line 282
    int-to-byte v0, v2

    iput-byte v0, p0, Lminigame/Cards;->tx:B

    .line 283
    int-to-byte v0, v1

    iput-byte v0, p0, Lminigame/Cards;->ty:B

    .line 284
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v0}, Lmain/PointerKey;->setKey5()V

    .line 277
    :cond_cb
    add-int/lit8 v2, v2, 0x1

    goto :goto_5c

    .line 279
    :cond_ce
    iget-object v0, p0, Lminigame/Cards;->findC:[[B

    aget-object v0, v0, v1

    aget-byte v0, v0, v2

    move v5, v0

    goto :goto_89

    .line 292
    .end local v1    # "i":I
    .end local v2    # "j":I
    :cond_d6
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const-string v4, "\u6e38\u620f\u5f00\u59cb"

    const/4 v6, 0x4

    const/16 v7, 0x11

    const/4 v8, 0x3

    const/4 v9, 0x0

    move v5, v11

    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 293
    iget-object v3, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\u53ef\u9519\u6b21\u6570\uff1a"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v1, p0, Lminigame/Cards;->time:B

    if-gez v1, :cond_10e

    const/4 v1, 0x0

    :goto_f3
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\u6b21"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    add-int/lit16 v5, v11, 0xc8

    const/16 v0, 0x4b

    sub-int v6, v10, v0

    const/4 v7, 0x5

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    goto/16 :goto_5a

    :cond_10e
    iget-byte v1, p0, Lminigame/Cards;->time:B

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    goto :goto_f3
.end method

.method private nullGame()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    .line 102
    iput-object v0, p0, Lminigame/Cards;->findN:[[B

    .line 103
    iput-object v0, p0, Lminigame/Cards;->findC:[[B

    .line 104
    iput-object v0, p0, Lminigame/Cards;->num:[[B

    .line 105
    return-void
.end method


# virtual methods
.method public draw0(III)V
    .registers 21
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "h"    # I

    .prologue
    .line 215
    const/16 v13, 0x168

    .line 216
    .local v13, "HEIGHT":I
    const/16 v14, 0x140

    .line 217
    .local v14, "WIDTH_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ui;->fillRectB()V

    .line 218
    const/16 v16, 0xc8

    .line 219
    .local v16, "w":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    add-int/lit8 v3, p2, 0x19

    add-int/lit8 v4, v3, 0x5

    const/16 v3, 0xa

    sub-int v5, v16, v3

    const/4 v7, 0x4

    move/from16 v3, p1

    move/from16 v6, p3

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawK(IIIII)V

    .line 220
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    add-int v3, p1, v16

    add-int/lit8 v4, p2, 0x19

    add-int/lit8 v4, v4, 0x5

    add-int/lit8 v5, v16, 0x14

    const/4 v7, 0x4

    move/from16 v6, p3

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawK(IIIII)V

    .line 221
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    add-int/lit8 v3, v16, 0xa

    mul-int/lit8 v3, v3, 0x2

    move/from16 v0, p1

    add-int/lit16 v0, v0, 0x1a4

    move v3, v0

    add-int/lit8 v3, v3, 0xa

    add-int/lit8 v4, p2, 0x19

    add-int/lit8 v4, v4, 0x5

    const/16 v5, 0xa

    sub-int v5, v16, v5

    const/4 v7, 0x4

    move/from16 v6, p3

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawK(IIIII)V

    .line 223
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Cards;->state:B

    move v2, v0

    if-nez v2, :cond_8d

    .line 224
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const-string v3, "\u6e38\u620f\u89c4\u5219"

    add-int/lit8 v4, p2, 0x19

    add-int/lit8 v5, v4, 0x5

    const/16 v6, 0x21

    const/4 v7, 0x3

    const/4 v8, 0x1

    move v4, v14

    invoke-virtual/range {v2 .. v8}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 225
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x7

    const/16 v4, 0x32

    sub-int v4, v14, v4

    add-int/lit8 v4, v4, 0x7

    add-int/lit8 v5, p2, 0x19

    const/16 v6, 0x28

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawUi(IIIII)V

    .line 226
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x7

    add-int/lit8 v4, v14, 0x32

    add-int/lit8 v4, v4, 0x7

    add-int/lit8 v5, p2, 0x19

    const/16 v6, 0x24

    const/4 v7, 0x4

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawUi(IIIII)V

    .line 229
    :cond_8d
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-object v3, v3, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    const/16 v4, 0x19

    add-int/lit8 v5, p2, 0x19

    add-int/lit8 v5, v5, 0xa

    const/16 v6, 0x19

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v2 .. v8}, Ldm/Ui;->drawStringY([Ljava/lang/StringBuffer;IIIII)V

    .line 231
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Cards;->state:B

    move v2, v0

    if-nez v2, :cond_104

    .line 232
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;

    move-object v2, v0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget v0, v0, Lminigame/Cards;->sell_money:I

    move v4, v0

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\u91d1"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    add-int v4, p2, p3

    const/16 v5, 0x32

    sub-int v5, v4, v5

    const/4 v6, 0x7

    const/4 v7, 0x0

    move v4, v14

    invoke-virtual/range {v2 .. v7}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 233
    add-int/lit8 v2, p2, 0x4b

    add-int/lit8 v5, v2, 0x5

    .line 234
    .local v5, "ty":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x2

    add-int v4, p1, v16

    add-int/lit8 v4, v4, 0xc

    add-int/lit8 v4, v4, 0x19

    const/16 v6, 0x32

    sub-int v6, v16, v6

    const/4 v7, 0x3

    const/16 v8, 0x1e

    const/16 v9, 0xa

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Cards;->sel:B

    move v10, v0

    const/4 v11, 0x4

    const/4 v12, 0x2

    invoke-virtual/range {v2 .. v12}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 235
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_fa
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;

    move-object v2, v0

    iget-object v2, v2, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;

    array-length v2, v2

    if-lt v15, v2, :cond_11f

    .line 244
    .end local v5    # "ty":I
    .end local v15    # "i":I
    :cond_104
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;

    move-object v2, v0

    const/4 v3, 0x3

    const/4 v4, 0x0

    invoke-virtual {v2, v14, v13, v3, v4}, Lmain/GameRun;->drawMoney(IIIZ)V

    .line 245
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Cards;->state:B

    move v2, v0

    if-nez v2, :cond_11e

    .line 246
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x1

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 247
    :cond_11e
    return-void

    .line 236
    .restart local v5    # "ty":I
    .restart local v15    # "i":I
    :cond_11f
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;

    move-object v2, v0

    iget-object v2, v2, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;

    aget-object v2, v2, v15

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    add-int v2, p1, v16

    add-int/lit8 v2, v2, 0xf

    add-int/lit8 v2, v2, 0x19

    add-int/lit8 v8, v2, 0x1a

    .line 237
    mul-int/lit8 v2, v15, 0x28

    add-int/2addr v2, v5

    const/4 v3, 0x2

    sub-int v9, v2, v3

    const/4 v10, 0x0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Cards;->sel:B

    move v2, v0

    if-ne v2, v15, :cond_17f

    const/4 v2, 0x0

    move v11, v2

    :goto_148
    const/4 v12, 0x1

    .line 236
    invoke-virtual/range {v6 .. v12}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 238
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;

    move-object v2, v0

    iget-object v2, v2, Lmain/GameRun;->pkey:Lmain/PointerKey;

    add-int v3, p1, v16

    add-int/lit8 v3, v3, 0xc

    add-int/lit8 v3, v3, 0x19

    mul-int/lit8 v4, v15, 0x28

    add-int/2addr v4, v5

    const/4 v6, 0x2

    sub-int/2addr v4, v6

    const/16 v6, 0x32

    sub-int v6, v16, v6

    const/16 v7, 0x28

    invoke-virtual {v2, v3, v4, v6, v7}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v2

    if-eqz v2, :cond_17b

    .line 239
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Cards;->sel:B

    move v2, v0

    if-ne v2, v15, :cond_182

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;

    move-object v2, v0

    iget-object v2, v2, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v2}, Lmain/PointerKey;->setKey5()V

    .line 235
    :cond_17b
    :goto_17b
    add-int/lit8 v15, v15, 0x1

    goto/16 :goto_fa

    .line 237
    :cond_17f
    const/4 v2, 0x3

    move v11, v2

    goto :goto_148

    .line 240
    :cond_182
    int-to-byte v2, v15

    move v0, v2

    move-object/from16 v1, p0

    iput-byte v0, v1, Lminigame/Cards;->sel:B

    goto :goto_17b
.end method

.method public go(I)V
    .registers 14
    .param p1, "mode"    # I

    .prologue
    const/4 v11, 0x2

    const/4 v10, -0x1

    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 60
    iget-object v5, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    const/16 v6, 0x9

    iput-byte v6, v5, Lmain/GameRun;->line_max:B

    .line 61
    const/16 v5, 0x64

    iput-short v5, p0, Lminigame/Cards;->count:S

    .line 62
    iget-byte v5, p0, Lminigame/Cards;->lv:B

    mul-int/lit8 v5, v5, 0x2

    add-int/lit8 v5, v5, 0x4

    int-to-byte v5, v5

    iput-byte v5, p0, Lminigame/Cards;->time:B

    .line 63
    iget-object v5, p0, Lminigame/Cards;->num:[[B

    iget-byte v6, p0, Lminigame/Cards;->lv:B

    aget-object v5, v5, v6

    aget-byte v5, v5, v9

    iget-object v6, p0, Lminigame/Cards;->num:[[B

    iget-byte v7, p0, Lminigame/Cards;->lv:B

    aget-object v6, v6, v7

    aget-byte v6, v6, v8

    mul-int/2addr v5, v6

    div-int/lit8 v5, v5, 0x2

    int-to-byte v5, v5

    iput-byte v5, p0, Lminigame/Cards;->find_count:B

    .line 64
    if-ge p1, v8, :cond_3c

    .line 65
    iput-byte v9, p0, Lminigame/Cards;->ty:B

    .line 66
    iput-byte v9, p0, Lminigame/Cards;->state:B

    .line 67
    iget-byte v5, p0, Lminigame/Cards;->lv:B

    mul-int/lit16 v5, v5, 0xc8

    add-int/lit16 v5, v5, 0xc8

    iput v5, p0, Lminigame/Cards;->sell_money:I

    .line 100
    .end local p0    # "this":Lminigame/Cards;
    :goto_3b
    return-void

    .line 69
    .restart local p0    # "this":Lminigame/Cards;
    :cond_3c
    iget-short v5, p0, Lminigame/Cards;->gw:S

    iget-short v6, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v5, v6

    iget-object v6, p0, Lminigame/Cards;->num:[[B

    iget-byte v7, p0, Lminigame/Cards;->lv:B

    aget-object v6, v6, v7

    aget-byte v6, v6, v8

    mul-int/2addr v5, v6

    neg-int v5, v5

    shr-int/lit8 v5, v5, 0x1

    int-to-short v5, v5

    iput-short v5, p0, Lminigame/Cards;->gx:S

    .line 70
    iget-short v5, p0, Lminigame/Cards;->gh:S

    iget-short v6, p0, Lminigame/Cards;->gspace:S

    add-int/2addr v5, v6

    iget-object v6, p0, Lminigame/Cards;->num:[[B

    iget-byte v7, p0, Lminigame/Cards;->lv:B

    aget-object v6, v6, v7

    aget-byte v6, v6, v9

    mul-int/2addr v5, v6

    neg-int v5, v5

    shr-int/lit8 v5, v5, 0x1

    int-to-short v5, v5

    iput-short v5, p0, Lminigame/Cards;->gy:S

    .line 71
    iput-byte v9, p0, Lminigame/Cards;->ty:B

    iput-byte v9, p0, Lminigame/Cards;->tx:B

    .line 72
    iput-byte v8, p0, Lminigame/Cards;->state:B

    .line 73
    const/4 v0, 0x0

    .local v0, "i":B
    iget-byte v5, p0, Lminigame/Cards;->find_count:B

    new-array v3, v5, [B

    .line 74
    .local v3, "randN":[B
    :goto_6f
    iget-object v5, p0, Lminigame/Cards;->findC:[[B

    array-length v5, v5

    if-lt v0, v5, :cond_80

    .line 80
    const/4 v0, 0x0

    .line 81
    :cond_75
    :goto_75
    array-length v5, v3

    if-lt v0, v5, :cond_9c

    .line 90
    const/4 v0, 0x0

    :goto_79
    array-length v5, v3

    if-lt v0, v5, :cond_bd

    .line 98
    const/4 p0, 0x0

    check-cast p0, [B

    .end local p0    # "this":Lminigame/Cards;
    goto :goto_3b

    .line 75
    .restart local p0    # "this":Lminigame/Cards;
    :cond_80
    const/4 v1, 0x0

    .local v1, "j":B
    :goto_81
    iget-object v5, p0, Lminigame/Cards;->findC:[[B

    aget-object v5, v5, v0

    array-length v5, v5

    if-lt v1, v5, :cond_8c

    .line 74
    add-int/lit8 v5, v0, 0x1

    int-to-byte v0, v5

    goto :goto_6f

    .line 76
    :cond_8c
    iget-object v5, p0, Lminigame/Cards;->findC:[[B

    aget-object v5, v5, v0

    aput-byte v11, v5, v1

    .line 77
    iget-object v5, p0, Lminigame/Cards;->findN:[[B

    aget-object v5, v5, v0

    aput-byte v9, v5, v1

    .line 75
    add-int/lit8 v5, v1, 0x1

    int-to-byte v1, v5

    goto :goto_81

    .line 82
    .end local v1    # "j":B
    :cond_9c
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v5, 0x23

    invoke-static {v5}, Ldm/Ms;->getRandom(I)I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    int-to-byte v4, v5

    .line 83
    .local v4, "rd":B
    array-length v5, v3

    sub-int/2addr v5, v8

    int-to-byte v1, v5

    .restart local v1    # "j":B
    :goto_ab
    if-gt v1, v10, :cond_b5

    .line 85
    :cond_ad
    if-ne v1, v10, :cond_75

    .line 86
    aput-byte v4, v3, v0

    .line 87
    add-int/lit8 v5, v0, 0x1

    int-to-byte v0, v5

    goto :goto_75

    .line 84
    :cond_b5
    aget-byte v5, v3, v1

    if-eq v5, v4, :cond_ad

    .line 83
    sub-int v5, v1, v8

    int-to-byte v1, v5

    goto :goto_ab

    .line 91
    .end local v1    # "j":B
    .end local v4    # "rd":B
    :cond_bd
    const/4 v1, 0x0

    .restart local v1    # "j":B
    :goto_be
    if-lt v1, v11, :cond_c4

    .line 90
    add-int/lit8 v5, v0, 0x1

    int-to-byte v0, v5

    goto :goto_79

    .line 93
    :cond_c4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v5, p0, Lminigame/Cards;->num:[[B

    iget-byte v6, p0, Lminigame/Cards;->lv:B

    aget-object v5, v5, v6

    aget-byte v5, v5, v9

    iget-object v6, p0, Lminigame/Cards;->num:[[B

    iget-byte v7, p0, Lminigame/Cards;->lv:B

    aget-object v6, v6, v7

    aget-byte v6, v6, v8

    mul-int/2addr v5, v6

    invoke-static {v5}, Ldm/Ms;->getRandom(I)I

    move-result v5

    int-to-byte v2, v5

    .line 94
    .local v2, "k":B
    iget-object v5, p0, Lminigame/Cards;->findN:[[B

    iget-object v6, p0, Lminigame/Cards;->num:[[B

    iget-byte v7, p0, Lminigame/Cards;->lv:B

    aget-object v6, v6, v7

    aget-byte v6, v6, v8

    div-int v6, v2, v6

    aget-object v5, v5, v6

    iget-object v6, p0, Lminigame/Cards;->num:[[B

    iget-byte v7, p0, Lminigame/Cards;->lv:B

    aget-object v6, v6, v7

    aget-byte v6, v6, v8

    rem-int v6, v2, v6

    aget-byte v5, v5, v6

    if-nez v5, :cond_c4

    .line 95
    iget-object v5, p0, Lminigame/Cards;->findN:[[B

    iget-object v6, p0, Lminigame/Cards;->num:[[B

    iget-byte v7, p0, Lminigame/Cards;->lv:B

    aget-object v6, v6, v7

    aget-byte v6, v6, v8

    div-int v6, v2, v6

    aget-object v5, v5, v6

    iget-object v6, p0, Lminigame/Cards;->num:[[B

    iget-byte v7, p0, Lminigame/Cards;->lv:B

    aget-object v6, v6, v7

    aget-byte v6, v6, v8

    rem-int v6, v2, v6

    aget-byte v7, v3, v0

    aput-byte v7, v5, v6

    .line 91
    add-int/lit8 v5, v1, 0x1

    int-to-byte v1, v5

    goto :goto_be
.end method

.method public go(II)V
    .registers 9
    .param p1, "mode"    # I
    .param p2, "lv_"    # I

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 45
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget-object v1, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    const-string v2, "data/gamec.d"

    invoke-virtual {v1, v2}, Lmain/GameRun;->createString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0xa0

    invoke-virtual {v0, v1, v2, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 46
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    const-string v1, "\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f"

    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {v0, v1, v2, v4}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 50
    int-to-byte v0, p2

    iput-byte v0, p0, Lminigame/Cards;->lv:B

    .line 51
    iput-object v5, p0, Lminigame/Cards;->findN:[[B

    .line 52
    iget-object v0, p0, Lminigame/Cards;->num:[[B

    iget-byte v1, p0, Lminigame/Cards;->lv:B

    aget-object v0, v0, v1

    aget-byte v0, v0, v3

    iget-object v1, p0, Lminigame/Cards;->num:[[B

    iget-byte v2, p0, Lminigame/Cards;->lv:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v4

    filled-new-array {v0, v1}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[B

    iput-object v0, p0, Lminigame/Cards;->findN:[[B

    .line 53
    iput-object v5, p0, Lminigame/Cards;->findC:[[B

    .line 54
    iget-object v0, p0, Lminigame/Cards;->num:[[B

    iget-byte v1, p0, Lminigame/Cards;->lv:B

    aget-object v0, v0, v1

    aget-byte v0, v0, v3

    iget-object v1, p0, Lminigame/Cards;->num:[[B

    iget-byte v2, p0, Lminigame/Cards;->lv:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v4

    filled-new-array {v0, v1}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[B

    iput-object v0, p0, Lminigame/Cards;->findC:[[B

    .line 55
    const/16 v0, 0x9

    iput-byte v0, p0, Lminigame/Cards;->length:B

    .line 56
    invoke-virtual {p0, p1}, Lminigame/Cards;->go(I)V

    .line 57
    return-void
.end method

.method public key()Z
    .registers 7

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 107
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_e

    move v0, v5

    .line 154
    :goto_d
    return v0

    .line 108
    :cond_e
    iget-byte v0, p0, Lminigame/Cards;->state:B

    if-nez v0, :cond_70

    .line 110
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_25

    .line 111
    iget-byte v0, p0, Lminigame/Cards;->sel:B

    xor-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lminigame/Cards;->sel:B

    :cond_23
    :goto_23
    move v0, v5

    .line 154
    goto :goto_d

    .line 112
    :cond_25
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_5a

    .line 113
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 114
    iget-byte v0, p0, Lminigame/Cards;->sel:B

    if-nez v0, :cond_4a

    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget v1, p0, Lminigame/Cards;->sell_money:I

    invoke-virtual {v0, v1, v4}, Lmain/GameRun;->isMoney(IZ)Z

    move-result v0

    if-eqz v0, :cond_4a

    iget-byte v0, p0, Lminigame/Cards;->lv:B

    invoke-virtual {p0, v4, v0}, Lminigame/Cards;->go(II)V

    goto :goto_23

    .line 115
    :cond_4a
    iget-byte v0, p0, Lminigame/Cards;->sel:B

    if-ne v0, v4, :cond_23

    .line 116
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 117
    invoke-direct {p0}, Lminigame/Cards;->nullGame()V

    move v0, v4

    .line 118
    goto :goto_d

    .line 131
    :cond_5a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_23

    .line 132
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 133
    invoke-direct {p0}, Lminigame/Cards;->nullGame()V

    move v0, v4

    .line 134
    goto :goto_d

    .line 136
    :cond_70
    iget-byte v0, p0, Lminigame/Cards;->state:B

    const/4 v1, 0x3

    if-ge v0, v1, :cond_23

    .line 137
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_90

    .line 138
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lminigame/Cards;->ty:B

    iget-object v2, p0, Lminigame/Cards;->findN:[[B

    array-length v2, v2

    sub-int/2addr v2, v4

    invoke-virtual {v0, v1, v5, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lminigame/Cards;->ty:B

    goto :goto_23

    .line 139
    :cond_90
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_b0

    .line 140
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lminigame/Cards;->tx:B

    iget-object v2, p0, Lminigame/Cards;->findN:[[B

    iget-byte v3, p0, Lminigame/Cards;->ty:B

    aget-object v2, v2, v3

    array-length v2, v2

    sub-int/2addr v2, v4

    invoke-virtual {v0, v1, v5, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lminigame/Cards;->tx:B

    goto/16 :goto_23

    .line 141
    :cond_b0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_23

    .line 142
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 143
    iget-byte v0, p0, Lminigame/Cards;->state:B

    if-nez v0, :cond_cc

    .line 144
    iget-byte v0, p0, Lminigame/Cards;->lv:B

    invoke-virtual {p0, v5, v0}, Lminigame/Cards;->go(II)V

    goto/16 :goto_23

    .line 145
    :cond_cc
    iget-object v0, p0, Lminigame/Cards;->findC:[[B

    iget-byte v1, p0, Lminigame/Cards;->ty:B

    aget-object v0, v0, v1

    iget-byte v1, p0, Lminigame/Cards;->tx:B

    aget-byte v0, v0, v1

    if-nez v0, :cond_23

    .line 146
    iget-object v0, p0, Lminigame/Cards;->findC:[[B

    iget-byte v1, p0, Lminigame/Cards;->ty:B

    aget-object v0, v0, v1

    iget-byte v1, p0, Lminigame/Cards;->tx:B

    aget-byte v2, v0, v1

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 147
    iget-byte v0, p0, Lminigame/Cards;->state:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lminigame/Cards;->state:B

    const/4 v1, 0x2

    if-ne v0, v1, :cond_23

    .line 148
    iget-byte v0, p0, Lminigame/Cards;->tx:B

    iput-byte v0, p0, Lminigame/Cards;->selx:B

    .line 149
    iget-byte v0, p0, Lminigame/Cards;->ty:B

    iput-byte v0, p0, Lminigame/Cards;->sely:B

    goto/16 :goto_23
.end method

.method public patin()V
    .registers 4

    .prologue
    const/16 v2, 0xa

    const/4 v1, 0x2

    .line 159
    const/16 v0, 0x118

    invoke-virtual {p0, v2, v1, v0}, Lminigame/Cards;->draw0(III)V

    .line 160
    iget-byte v0, p0, Lminigame/Cards;->state:B

    if-eqz v0, :cond_15

    iget-byte v0, p0, Lminigame/Cards;->length:B

    add-int/lit8 v0, v0, 0x3

    mul-int/lit8 v0, v0, 0x19

    invoke-direct {p0, v2, v1, v0}, Lminigame/Cards;->drawGame(III)V

    .line 165
    :cond_15
    return-void
.end method

.method public run()V
    .registers 9

    .prologue
    const/16 v4, 0xa

    const/4 v3, 0x0

    const/4 v7, 0x3

    const/4 v5, -0x1

    const/4 v6, 0x1

    .line 168
    iget-byte v2, p0, Lminigame/Cards;->time:B

    if-ge v2, v6, :cond_28

    .line 169
    iget-byte v2, p0, Lminigame/Cards;->time:B

    if-nez v2, :cond_18

    .line 170
    iput-byte v5, p0, Lminigame/Cards;->time:B

    .line 171
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    const-string v3, "\u6e38\u620f\u5931\u8d25\uff01\uff01\uff01"

    invoke-virtual {v2, v3, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 210
    :cond_17
    :goto_17
    return-void

    .line 172
    :cond_18
    iget-byte v2, p0, Lminigame/Cards;->time:B

    if-ne v2, v5, :cond_17

    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->say_c:B

    if-nez v2, :cond_17

    .line 173
    iget-byte v2, p0, Lminigame/Cards;->lv:B

    invoke-virtual {p0, v3, v2}, Lminigame/Cards;->go(II)V

    goto :goto_17

    .line 175
    :cond_28
    iget-byte v2, p0, Lminigame/Cards;->find_count:B

    if-ge v2, v6, :cond_7a

    .line 176
    iget-byte v2, p0, Lminigame/Cards;->find_count:B

    if-nez v2, :cond_6a

    .line 177
    iput-byte v5, p0, Lminigame/Cards;->find_count:B

    .line 178
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget v3, v2, Lmain/GameRun;->money:I

    iget-byte v4, p0, Lminigame/Cards;->time:B

    mul-int/lit8 v4, v4, 0x7d

    add-int/lit8 v4, v4, 0x64

    add-int/2addr v3, v4

    iput v3, v2, Lmain/GameRun;->money:I

    .line 179
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\u83b7\u5f97\u91d1\u94b1\uff1a"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v4, p0, Lminigame/Cards;->time:B

    mul-int/lit8 v4, v4, 0x7d

    add-int/lit8 v4, v4, 0x64

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 180
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->rmsOther:[B

    const/16 v3, 0x8

    aget-byte v4, v2, v3

    iget-byte v5, p0, Lminigame/Cards;->lv:B

    shl-int v5, v6, v5

    or-int/2addr v4, v5

    int-to-byte v4, v4

    aput-byte v4, v2, v3

    goto :goto_17

    .line 182
    :cond_6a
    iget-byte v2, p0, Lminigame/Cards;->find_count:B

    if-ne v2, v5, :cond_17

    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->say_c:B

    if-nez v2, :cond_17

    .line 189
    iget-byte v2, p0, Lminigame/Cards;->lv:B

    invoke-virtual {p0, v3, v2}, Lminigame/Cards;->go(II)V

    goto :goto_17

    .line 191
    :cond_7a
    iget-byte v2, p0, Lminigame/Cards;->state:B

    if-lt v2, v7, :cond_c8

    .line 192
    iget-byte v2, p0, Lminigame/Cards;->state:B

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    iput-byte v2, p0, Lminigame/Cards;->state:B

    if-le v2, v4, :cond_8a

    iput-byte v6, p0, Lminigame/Cards;->state:B

    goto :goto_17

    .line 193
    :cond_8a
    iget-byte v2, p0, Lminigame/Cards;->state:B

    if-ne v2, v4, :cond_17

    .line 194
    iget-object v2, p0, Lminigame/Cards;->findN:[[B

    iget-byte v3, p0, Lminigame/Cards;->ty:B

    aget-object v2, v2, v3

    iget-byte v3, p0, Lminigame/Cards;->tx:B

    aget-byte v2, v2, v3

    iget-object v3, p0, Lminigame/Cards;->findN:[[B

    iget-byte v4, p0, Lminigame/Cards;->sely:B

    aget-object v3, v3, v4

    iget-byte v4, p0, Lminigame/Cards;->selx:B

    aget-byte v3, v3, v4

    if-eq v2, v3, :cond_c0

    .line 195
    iget-object v2, p0, Lminigame/Cards;->findC:[[B

    iget-byte v3, p0, Lminigame/Cards;->ty:B

    aget-object v2, v2, v3

    iget-byte v3, p0, Lminigame/Cards;->tx:B

    aput-byte v7, v2, v3

    .line 196
    iget-object v2, p0, Lminigame/Cards;->findC:[[B

    iget-byte v3, p0, Lminigame/Cards;->sely:B

    aget-object v2, v2, v3

    iget-byte v3, p0, Lminigame/Cards;->selx:B

    aput-byte v7, v2, v3

    .line 197
    iget-byte v2, p0, Lminigame/Cards;->time:B

    sub-int/2addr v2, v6

    int-to-byte v2, v2

    iput-byte v2, p0, Lminigame/Cards;->time:B

    goto/16 :goto_17

    .line 198
    :cond_c0
    iget-byte v2, p0, Lminigame/Cards;->find_count:B

    sub-int/2addr v2, v6

    int-to-byte v2, v2

    iput-byte v2, p0, Lminigame/Cards;->find_count:B

    goto/16 :goto_17

    .line 200
    :cond_c8
    iget-short v2, p0, Lminigame/Cards;->count:S

    if-lez v2, :cond_17

    .line 201
    iget-short v2, p0, Lminigame/Cards;->count:S

    sub-int/2addr v2, v6

    int-to-short v2, v2

    iput-short v2, p0, Lminigame/Cards;->count:S

    if-nez v2, :cond_17

    .line 202
    const/4 v0, 0x0

    .line 203
    .local v0, "i":B
    :goto_d5
    iget-object v2, p0, Lminigame/Cards;->findC:[[B

    array-length v2, v2

    if-ge v0, v2, :cond_17

    .line 204
    const/4 v1, 0x0

    .local v1, "j":B
    :goto_db
    iget-object v2, p0, Lminigame/Cards;->findC:[[B

    aget-object v2, v2, v0

    array-length v2, v2

    if-lt v1, v2, :cond_e6

    .line 203
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    goto :goto_d5

    .line 205
    :cond_e6
    iget-object v2, p0, Lminigame/Cards;->findC:[[B

    aget-object v2, v2, v0

    aput-byte v7, v2, v1

    .line 204
    add-int/lit8 v2, v1, 0x1

    int-to-byte v1, v2

    goto :goto_db
.end method
