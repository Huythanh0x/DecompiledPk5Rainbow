.class public Lminigame/Cards;
.super Ljava/lang/Object;
.implements Lminigame/MiniGame_H;
.source "Cards.java"

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

.method public constructor <init>(Lmain/GameRun;)V
  .parameter "gr_" # Lmain/GameRun;
  .registers 7
  .prologue
    const/4 v1, 4
    const/4 v4, 3
    const/4 v3, 2
  .line 19
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 24
    const/16 v0, 30
    iput-short v0, p0, Lminigame/Cards;->gw:S
    const/16 v0, 40
    iput-short v0, p0, Lminigame/Cards;->gh:S
    iput-short v1, p0, Lminigame/Cards;->gspace:S
  .line 26
    const/16 v0, 320
    iput-short v0, p0, Lminigame/Cards;->wh:S
    const/16 v0, 160
    iput-short v0, p0, Lminigame/Cards;->hh:S
  .line 30
    iput-byte v4, p0, Lminigame/Cards;->time:B
  .line 31
    iput-byte v4, p0, Lminigame/Cards;->find_count:B
  .line 37
    new-array v0, v1, [[B
    const/4 v1, 0
  .line 38
    new-array v2, v3, [B
    fill-array-data v2, :L0
    aput-object v2, v0, v1
    const/4 v1, 1
  .line 39
    new-array v2, v3, [B
    fill-array-data v2, :L1
    aput-object v2, v0, v1
  .line 40
    new-array v1, v3, [B
    fill-array-data v1, :L2
    aput-object v1, v0, v3
  .line 41
    new-array v1, v3, [B
    fill-array-data v1, :L3
    aput-object v1, v0, v4
    iput-object v0, p0, Lminigame/Cards;->num:[[B
  .line 19
    iput-object p1, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    return-void
  .line 38
  .line 39
  .line 40
  .line 41
  :L0
  .array-data 1
    3t
    4t
  .end array-data
  :L1
  .array-data 1
    3t
    6t
  .end array-data
  :L2
  .array-data 1
    4t
    6t
  .end array-data
  :L3
  .array-data 1
    5t
    6t
  .end array-data
.end method

.method private drawCard(IIIII)V
  .parameter "i" # I
  .parameter "j" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "mode" # I
  .registers 12
  .prologue
  .line 304
    if-nez p5, :L1
  .line 305
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-short v3, p0, Lminigame/Cards;->gw:S
    iget-short v4, p0, Lminigame/Cards;->gh:S
    const/4 v5, 1
    move v1, p3
    move v2, p4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  .line 306
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const/16 v1, 25
    iget-short v2, p0, Lminigame/Cards;->gw:S
    shr-int/lit8 v2, v2, 1
    add-int/2addr v2, p3
    iget-short v3, p0, Lminigame/Cards;->gh:S
    shr-int/lit8 v3, v3, 1
    add-int/2addr v3, p4
    const/4 v4, 3
    const/4 v5, 0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  :L0
  .line 316
    return-void
  :L1
  .line 307
    const/4 v0, 1
    if-ne p5, v0, :L3
  .line 308
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-short v1, p0, Lminigame/Cards;->gw:S
    shr-int/lit8 v1, v1, 1
    add-int/2addr v1, p3
    const/4 v2, 2
    sub-int/2addr v1, v2
    const/4 v2, 3
    sub-int v2, p4, v2
    const/4 v3, 5
    iget-short v4, p0, Lminigame/Cards;->gh:S
    add-int/lit8 v4, v4, 6
    const/4 v5, 1
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  .line 309
    iget-object v0, p0, Lminigame/Cards;->findC:[[B
    aget-object v0, v0, p1
    aget-byte v1, v0, p2
    add-int/lit8 v1, v1, 1
    int-to-byte v1, v1
    aput-byte v1, v0, p2
    const/4 v0, 3
    if-le v1, v0, :L2
    iget-object v0, p0, Lminigame/Cards;->findC:[[B
    aget-object v0, v0, p1
    const/4 v1, 0
    aput-byte v1, v0, p2
  :L2
  .line 310
    const/4 p5, 2
    goto :L0
  :L3
  .line 312
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-short v3, p0, Lminigame/Cards;->gw:S
    iget-short v4, p0, Lminigame/Cards;->gh:S
    const/4 v5, 5
    move v1, p3
    move v2, p4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  .line 313
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    iget-object v1, p0, Lminigame/Cards;->findN:[[B
    aget-object v1, v1, p1
    aget-byte v1, v1, p2
    iget-short v2, p0, Lminigame/Cards;->gw:S
    shr-int/lit8 v2, v2, 1
    add-int/2addr v2, p3
    iget-short v3, p0, Lminigame/Cards;->gh:S
    shr-int/lit8 v3, v3, 1
    add-int/2addr v3, p4
    const/4 v4, 3
    invoke-virtual { v0, v1, v2, v3, v4 }, Lmain/GameRun;->drawItem(IIII)V
  .line 314
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct { v1 }, Ljava/lang/StringBuilder;-><init>()V
    iget-object v2, p0, Lminigame/Cards;->findN:[[B
    aget-object v2, v2, p1
    aget-byte v2, v2, p2
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    iget-short v2, p0, Lminigame/Cards;->gw:S
    add-int/2addr v2, p3
    iget-short v3, p0, Lminigame/Cards;->gh:S
    add-int/2addr v3, p4
    const/16 v4, 40
    const/4 v5, 0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V
    goto :L0
.end method

.method private drawGame(III)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "h" # I
  .registers 16
  .prologue
  .line 265
    const/16 v11, 320
  .local v11, "WIDTH_H":I
    const/16 v10, 180
  .line 276
  .local v10, "HEIGHT_H":I
    const/4 v1, 0
  :L0
  .local v1, "i":I
    iget-object v0, p0, Lminigame/Cards;->findN:[[B
    array-length v0, v0
    if-lt v1, v0, :L2
  .line 288
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v3
    const v4, 15400191
    iget-short v0, p0, Lminigame/Cards;->wh:S
    iget-short v1, p0, Lminigame/Cards;->gx:S
  .end local v1
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
    const/4 v9, 3
    invoke-virtual/range { v3 .. v9 }, Ldm/Ui;->drawRectZ(IIIIII)V
  .line 290
    iget-short v0, p0, Lminigame/Cards;->count:S
    if-lez v0, :L8
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v3
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct { v0 }, Ljava/lang/StringBuilder;-><init>()V
    iget-short v1, p0, Lminigame/Cards;->count:S
    div-int/lit8 v1, v1, 10
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual { v0 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    add-int/lit8 v5, v11, 10
    const/16 v6, 29
    const/16 v7, 36
    const/4 v8, 2
    invoke-virtual/range { v3 .. v8 }, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V
  :L1
  .line 302
    return-void
  :L2
  .line 277
  .restart local v1
    const/4 v2, 0
  :L3
  .local v2, "j":I
    iget-object v0, p0, Lminigame/Cards;->findN:[[B
    aget-object v0, v0, v1
    array-length v0, v0
    if-lt v2, v0, :L4
  .line 276
    add-int/lit8 v1, v1, 1
    goto :L0
  :L4
  .line 279
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
    const/4 v5, 3
    if-ne v0, v5, :L7
    const/4 v0, 1
    move v5, v0
  :L5
    move-object v0, p0
    invoke-direct/range { v0 .. v5 }, Lminigame/Cards;->drawCard(IIIII)V
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
    invoke-virtual { v0, v3, v4, v5, v6 }, Lmain/PointerKey;->isSelect(IIII)Z
    move-result v0
    if-eqz v0, :L6
    iget-byte v0, p0, Lminigame/Cards;->state:B
    const/4 v3, 3
    if-ge v0, v3, :L6
  .line 282
    int-to-byte v0, v2
    iput-byte v0, p0, Lminigame/Cards;->tx:B
  .line 283
    int-to-byte v0, v1
    iput-byte v0, p0, Lminigame/Cards;->ty:B
  .line 284
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;
    invoke-virtual { v0 }, Lmain/PointerKey;->setKey5()V
  :L6
  .line 277
    add-int/lit8 v2, v2, 1
    goto :L3
  :L7
  .line 279
    iget-object v0, p0, Lminigame/Cards;->findC:[[B
    aget-object v0, v0, v1
    aget-byte v0, v0, v2
    move v5, v0
    goto :L5
  :L8
  .line 292
  .end local v1
  .end local v2
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v3
    const-string v4, "\u6e38\u620f\u5f00\u59cb"
    const/4 v6, 4
    const/16 v7, 17
    const/4 v8, 3
    const/4 v9, 0
    move v5, v11
    invoke-virtual/range { v3 .. v9 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 293
    iget-object v3, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "\u53ef\u9519\u6b21\u6570\uff1a"
    invoke-direct { v0, v1 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-byte v1, p0, Lminigame/Cards;->time:B
    if-gez v1, :L10
    const/4 v1, 0
  :L9
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "\u6b21"
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual { v0 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    add-int/lit16 v5, v11, 200
    const/16 v0, 75
    sub-int v6, v10, v0
    const/4 v7, 5
    const/4 v8, 0
    invoke-virtual/range { v3 .. v8 }, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V
    goto/16 :L1
  :L10
    iget-byte v1, p0, Lminigame/Cards;->time:B
    const/4 v2, 1
    sub-int/2addr v1, v2
    goto :L9
.end method

.method private nullGame()V
  .registers 2
  .prologue
    const/4 v0, 0
  .line 102
    iput-object v0, p0, Lminigame/Cards;->findN:[[B
  .line 103
    iput-object v0, p0, Lminigame/Cards;->findC:[[B
  .line 104
    iput-object v0, p0, Lminigame/Cards;->num:[[B
  .line 105
    return-void
.end method

.method public draw0(III)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "h" # I
  .registers 21
  .prologue
  .line 215
    const/16 v13, 360
  .line 216
  .local v13, "HEIGHT":I
    const/16 v14, 320
  .line 217
  .local v14, "WIDTH_H":I
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    invoke-virtual { v2 }, Ldm/Ui;->fillRectB()V
  .line 218
    const/16 v16, 200
  .line 219
  .local v16, "w":I
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    add-int/lit8 v3, p2, 25
    add-int/lit8 v4, v3, 5
    const/16 v3, 10
    sub-int v5, v16, v3
    const/4 v7, 4
    move/from16 v3, p1
    move/from16 v6, p3
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawK(IIIII)V
  .line 220
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    add-int v3, p1, v16
    add-int/lit8 v4, p2, 25
    add-int/lit8 v4, v4, 5
    add-int/lit8 v5, v16, 20
    const/4 v7, 4
    move/from16 v6, p3
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawK(IIIII)V
  .line 221
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    add-int/lit8 v3, v16, 10
    mul-int/lit8 v3, v3, 2
    move/from16 v0, p1
    add-int/lit16 v0, v0, 420
    move v3, v0
    add-int/lit8 v3, v3, 10
    add-int/lit8 v4, p2, 25
    add-int/lit8 v4, v4, 5
    const/16 v5, 10
    sub-int v5, v16, v5
    const/4 v7, 4
    move/from16 v6, p3
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawK(IIIII)V
  .line 223
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Cards;->state:B
    move v2, v0
    if-nez v2, :L0
  .line 224
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const-string v3, "\u6e38\u620f\u89c4\u5219"
    add-int/lit8 v4, p2, 25
    add-int/lit8 v5, v4, 5
    const/16 v6, 33
    const/4 v7, 3
    const/4 v8, 1
    move v4, v14
    invoke-virtual/range { v2 .. v8 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 225
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const/4 v3, 7
    const/16 v4, 50
    sub-int v4, v14, v4
    add-int/lit8 v4, v4, 7
    add-int/lit8 v5, p2, 25
    const/16 v6, 40
    const/4 v7, 0
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawUi(IIIII)V
  .line 226
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const/4 v3, 7
    add-int/lit8 v4, v14, 50
    add-int/lit8 v4, v4, 7
    add-int/lit8 v5, p2, 25
    const/16 v6, 36
    const/4 v7, 4
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawUi(IIIII)V
  :L0
  .line 229
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;
    move-object v3, v0
    iget-object v3, v3, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;
    const/16 v4, 25
    add-int/lit8 v5, p2, 25
    add-int/lit8 v5, v5, 10
    const/16 v6, 25
    const/4 v7, 0
    const/4 v8, 0
    invoke-virtual/range { v2 .. v8 }, Ldm/Ui;->drawStringY([Ljava/lang/StringBuffer;IIIII)V
  .line 231
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Cards;->state:B
    move v2, v0
    if-nez v2, :L2
  .line 232
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;
    move-object v2, v0
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a"
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v0, p0
    iget v0, v0, Lminigame/Cards;->sell_money:I
    move v4, v0
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "\u91d1"
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    add-int v4, p2, p3
    const/16 v5, 50
    sub-int v5, v4, v5
    const/4 v6, 7
    const/4 v7, 0
    move v4, v14
    invoke-virtual/range { v2 .. v7 }, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V
  .line 233
    add-int/lit8 v2, p2, 75
    add-int/lit8 v5, v2, 5
  .line 234
  .local v5, "ty":I
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const/4 v3, 2
    add-int v4, p1, v16
    add-int/lit8 v4, v4, 12
    add-int/lit8 v4, v4, 25
    const/16 v6, 50
    sub-int v6, v16, v6
    const/4 v7, 3
    const/16 v8, 30
    const/16 v9, 10
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Cards;->sel:B
    move v10, v0
    const/4 v11, 4
    const/4 v12, 2
    invoke-virtual/range { v2 .. v12 }, Ldm/Ui;->drawListKY(IIIIIIIIII)V
  .line 235
    const/4 v15, 0
  :L1
  .local v15, "i":I
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;
    move-object v2, v0
    iget-object v2, v2, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;
    array-length v2, v2
    if-lt v15, v2, :L4
  :L2
  .line 244
  .end local v5
  .end local v15
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;
    move-object v2, v0
    const/4 v3, 3
    const/4 v4, 0
    invoke-virtual { v2, v14, v13, v3, v4 }, Lmain/GameRun;->drawMoney(IIIZ)V
  .line 245
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Cards;->state:B
    move v2, v0
    if-nez v2, :L3
  .line 246
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const/4 v3, 1
    const/4 v4, 1
    invoke-virtual { v2, v3, v4 }, Ldm/Ui;->drawYesNo(ZZ)V
  :L3
  .line 247
    return-void
  :L4
  .line 236
  .restart local v5
  .restart local v15
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;
    move-object v2, v0
    iget-object v2, v2, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;
    aget-object v2, v2, v15
    invoke-virtual { v2 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v7
    add-int v2, p1, v16
    add-int/lit8 v2, v2, 15
    add-int/lit8 v2, v2, 25
    add-int/lit8 v8, v2, 26
  .line 237
    mul-int/lit8 v2, v15, 40
    add-int/2addr v2, v5
    const/4 v3, 2
    sub-int v9, v2, v3
    const/4 v10, 0
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Cards;->sel:B
    move v2, v0
    if-ne v2, v15, :L7
    const/4 v2, 0
    move v11, v2
  :L5
    const/4 v12, 1
  .line 236
    invoke-virtual/range { v6 .. v12 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 238
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;
    move-object v2, v0
    iget-object v2, v2, Lmain/GameRun;->pkey:Lmain/PointerKey;
    add-int v3, p1, v16
    add-int/lit8 v3, v3, 12
    add-int/lit8 v3, v3, 25
    mul-int/lit8 v4, v15, 40
    add-int/2addr v4, v5
    const/4 v6, 2
    sub-int/2addr v4, v6
    const/16 v6, 50
    sub-int v6, v16, v6
    const/16 v7, 40
    invoke-virtual { v2, v3, v4, v6, v7 }, Lmain/PointerKey;->isSelect(IIII)Z
    move-result v2
    if-eqz v2, :L6
  .line 239
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Cards;->sel:B
    move v2, v0
    if-ne v2, v15, :L8
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Cards;->gr:Lmain/GameRun;
    move-object v2, v0
    iget-object v2, v2, Lmain/GameRun;->pkey:Lmain/PointerKey;
    invoke-virtual { v2 }, Lmain/PointerKey;->setKey5()V
  :L6
  .line 235
    add-int/lit8 v15, v15, 1
    goto/16 :L1
  :L7
  .line 237
    const/4 v2, 3
    move v11, v2
    goto :L5
  :L8
  .line 240
    int-to-byte v2, v15
    move v0, v2
    move-object/from16 v1, p0
    iput-byte v0, v1, Lminigame/Cards;->sel:B
    goto :L6
.end method

.method public go(I)V
  .parameter "mode" # I
  .registers 14
  .prologue
    const/4 v11, 2
    const/4 v10, -1
    const/4 v9, 0
    const/4 v8, 1
  .line 60
    iget-object v5, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    const/16 v6, 9
    iput-byte v6, v5, Lmain/GameRun;->line_max:B
  .line 61
    const/16 v5, 100
    iput-short v5, p0, Lminigame/Cards;->count:S
  .line 62
    iget-byte v5, p0, Lminigame/Cards;->lv:B
    mul-int/lit8 v5, v5, 2
    add-int/lit8 v5, v5, 4
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
    div-int/lit8 v5, v5, 2
    int-to-byte v5, v5
    iput-byte v5, p0, Lminigame/Cards;->find_count:B
  .line 64
    if-ge p1, v8, :L1
  .line 65
    iput-byte v9, p0, Lminigame/Cards;->ty:B
  .line 66
    iput-byte v9, p0, Lminigame/Cards;->state:B
  .line 67
    iget-byte v5, p0, Lminigame/Cards;->lv:B
    mul-int/lit16 v5, v5, 200
    add-int/lit16 v5, v5, 200
    iput v5, p0, Lminigame/Cards;->sell_money:I
  :L0
  .line 100
  .end local p0
    return-void
  :L1
  .line 69
  .restart local p0
    iget-short v5, p0, Lminigame/Cards;->gw:S
    iget-short v6, p0, Lminigame/Cards;->gspace:S
    add-int/2addr v5, v6
    iget-object v6, p0, Lminigame/Cards;->num:[[B
    iget-byte v7, p0, Lminigame/Cards;->lv:B
    aget-object v6, v6, v7
    aget-byte v6, v6, v8
    mul-int/2addr v5, v6
    neg-int v5, v5
    shr-int/lit8 v5, v5, 1
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
    shr-int/lit8 v5, v5, 1
    int-to-short v5, v5
    iput-short v5, p0, Lminigame/Cards;->gy:S
  .line 71
    iput-byte v9, p0, Lminigame/Cards;->ty:B
    iput-byte v9, p0, Lminigame/Cards;->tx:B
  .line 72
    iput-byte v8, p0, Lminigame/Cards;->state:B
  .line 73
    const/4 v0, 0
  .local v0, "i":B
    iget-byte v5, p0, Lminigame/Cards;->find_count:B
    new-array v3, v5, [B
  :L2
  .line 74
  .local v3, "randN":[B
    iget-object v5, p0, Lminigame/Cards;->findC:[[B
    array-length v5, v5
    if-lt v0, v5, :L5
  .line 80
    const/4 v0, 0
  :L3
  .line 81
    array-length v5, v3
    if-lt v0, v5, :L8
  .line 90
    const/4 v0, 0
  :L4
    array-length v5, v3
    if-lt v0, v5, :L12
  .line 98
    const/4 p0, 0
    check-cast p0, [B
  .end local p0
    goto :L0
  :L5
  .line 75
  .restart local p0
    const/4 v1, 0
  :L6
  .local v1, "j":B
    iget-object v5, p0, Lminigame/Cards;->findC:[[B
    aget-object v5, v5, v0
    array-length v5, v5
    if-lt v1, v5, :L7
  .line 74
    add-int/lit8 v5, v0, 1
    int-to-byte v0, v5
    goto :L2
  :L7
  .line 76
    iget-object v5, p0, Lminigame/Cards;->findC:[[B
    aget-object v5, v5, v0
    aput-byte v11, v5, v1
  .line 77
    iget-object v5, p0, Lminigame/Cards;->findN:[[B
    aget-object v5, v5, v0
    aput-byte v9, v5, v1
  .line 75
    add-int/lit8 v5, v1, 1
    int-to-byte v1, v5
    goto :L6
  :L8
  .line 82
  .end local v1
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    const/16 v5, 35
    invoke-static { v5 }, Ldm/Ms;->getRandom(I)I
    move-result v5
    add-int/lit8 v5, v5, 1
    int-to-byte v4, v5
  .line 83
  .local v4, "rd":B
    array-length v5, v3
    sub-int/2addr v5, v8
    int-to-byte v1, v5
  :L9
  .restart local v1
    if-gt v1, v10, :L11
  :L10
  .line 85
    if-ne v1, v10, :L3
  .line 86
    aput-byte v4, v3, v0
  .line 87
    add-int/lit8 v5, v0, 1
    int-to-byte v0, v5
    goto :L3
  :L11
  .line 84
    aget-byte v5, v3, v1
    if-eq v5, v4, :L10
  .line 83
    sub-int v5, v1, v8
    int-to-byte v1, v5
    goto :L9
  :L12
  .line 91
  .end local v1
  .end local v4
    const/4 v1, 0
  :L13
  .restart local v1
    if-lt v1, v11, :L14
  .line 90
    add-int/lit8 v5, v0, 1
    int-to-byte v0, v5
    goto :L4
  :L14
  .line 93
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-object v5, p0, Lminigame/Cards;->num:[[B
    iget-byte v6, p0, Lminigame/Cards;->lv:B
    aget-object v5, v5, v6
    aget-byte v5, v5, v9
    iget-object v6, p0, Lminigame/Cards;->num:[[B
    iget-byte v7, p0, Lminigame/Cards;->lv:B
    aget-object v6, v6, v7
    aget-byte v6, v6, v8
    mul-int/2addr v5, v6
    invoke-static { v5 }, Ldm/Ms;->getRandom(I)I
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
    if-nez v5, :L14
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
    add-int/lit8 v5, v1, 1
    int-to-byte v1, v5
    goto :L13
.end method

.method public go(II)V
  .parameter "mode" # I
  .parameter "lv_" # I
  .registers 9
  .prologue
    const/4 v5, 0
    const/4 v4, 1
    const/4 v3, 0
  .line 45
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    iget-object v1, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    const-string v2, "data/gamec.d"
    invoke-virtual { v1, v2 }, Lmain/GameRun;->createString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const/16 v2, 160
    invoke-virtual { v0, v1, v2, v3 }, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V
  .line 46
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    const-string v1, "\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f"
    sget v2, Lmain/Constants_H;->WIDTH:I
    invoke-virtual { v0, v1, v2, v4 }, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V
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
    filled-new-array { v0, v1 }, [I
    move-result-object v0
    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;
    invoke-static { v1, v0 }, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;
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
    filled-new-array { v0, v1 }, [I
    move-result-object v0
    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;
    invoke-static { v1, v0 }, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [[B
    iput-object v0, p0, Lminigame/Cards;->findC:[[B
  .line 55
    const/16 v0, 9
    iput-byte v0, p0, Lminigame/Cards;->length:B
  .line 56
    invoke-virtual { p0, p1 }, Lminigame/Cards;->go(I)V
  .line 57
    return-void
.end method

.method public key()Z
  .registers 7
  .prologue
    const/4 v5, 0
    const/4 v4, 1
  .line 107
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_delay()Z
    move-result v0
    if-eqz v0, :L1
    move v0, v5
  :L0
  .line 154
    return v0
  :L1
  .line 108
    iget-byte v0, p0, Lminigame/Cards;->state:B
    if-nez v0, :L6
  .line 110
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Up_Down()Z
    move-result v0
    if-eqz v0, :L3
  .line 111
    iget-byte v0, p0, Lminigame/Cards;->sel:B
    xor-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    iput-byte v0, p0, Lminigame/Cards;->sel:B
  :L2
    move v0, v5
  .line 154
    goto :L0
  :L3
  .line 112
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S1_Num5()Z
    move-result v0
    if-eqz v0, :L5
  .line 113
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 114
    iget-byte v0, p0, Lminigame/Cards;->sel:B
    if-nez v0, :L4
    iget-object v0, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    iget v1, p0, Lminigame/Cards;->sell_money:I
    invoke-virtual { v0, v1, v4 }, Lmain/GameRun;->isMoney(IZ)Z
    move-result v0
    if-eqz v0, :L4
    iget-byte v0, p0, Lminigame/Cards;->lv:B
    invoke-virtual { p0, v4, v0 }, Lminigame/Cards;->go(II)V
    goto :L2
  :L4
  .line 115
    iget-byte v0, p0, Lminigame/Cards;->sel:B
    if-ne v0, v4, :L2
  .line 116
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 117
    invoke-direct { p0 }, Lminigame/Cards;->nullGame()V
    move v0, v4
  .line 118
    goto :L0
  :L5
  .line 131
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S2()Z
    move-result v0
    if-eqz v0, :L2
  .line 132
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 133
    invoke-direct { p0 }, Lminigame/Cards;->nullGame()V
    move v0, v4
  .line 134
    goto :L0
  :L6
  .line 136
    iget-byte v0, p0, Lminigame/Cards;->state:B
    const/4 v1, 3
    if-ge v0, v1, :L2
  .line 137
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Up_Down()Z
    move-result v0
    if-eqz v0, :L7
  .line 138
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    iget-byte v1, p0, Lminigame/Cards;->ty:B
    iget-object v2, p0, Lminigame/Cards;->findN:[[B
    array-length v2, v2
    sub-int/2addr v2, v4
    invoke-virtual { v0, v1, v5, v2 }, Ldm/Ms;->select(III)B
    move-result v0
    iput-byte v0, p0, Lminigame/Cards;->ty:B
    goto :L2
  :L7
  .line 139
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Left_Right()Z
    move-result v0
    if-eqz v0, :L8
  .line 140
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    iget-byte v1, p0, Lminigame/Cards;->tx:B
    iget-object v2, p0, Lminigame/Cards;->findN:[[B
    iget-byte v3, p0, Lminigame/Cards;->ty:B
    aget-object v2, v2, v3
    array-length v2, v2
    sub-int/2addr v2, v4
    invoke-virtual { v0, v1, v5, v2 }, Ldm/Ms;->select(III)B
    move-result v0
    iput-byte v0, p0, Lminigame/Cards;->tx:B
    goto/16 :L2
  :L8
  .line 141
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S1_Num5()Z
    move-result v0
    if-eqz v0, :L2
  .line 142
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 143
    iget-byte v0, p0, Lminigame/Cards;->state:B
    if-nez v0, :L9
  .line 144
    iget-byte v0, p0, Lminigame/Cards;->lv:B
    invoke-virtual { p0, v5, v0 }, Lminigame/Cards;->go(II)V
    goto/16 :L2
  :L9
  .line 145
    iget-object v0, p0, Lminigame/Cards;->findC:[[B
    iget-byte v1, p0, Lminigame/Cards;->ty:B
    aget-object v0, v0, v1
    iget-byte v1, p0, Lminigame/Cards;->tx:B
    aget-byte v0, v0, v1
    if-nez v0, :L2
  .line 146
    iget-object v0, p0, Lminigame/Cards;->findC:[[B
    iget-byte v1, p0, Lminigame/Cards;->ty:B
    aget-object v0, v0, v1
    iget-byte v1, p0, Lminigame/Cards;->tx:B
    aget-byte v2, v0, v1
    add-int/lit8 v2, v2, 1
    int-to-byte v2, v2
    aput-byte v2, v0, v1
  .line 147
    iget-byte v0, p0, Lminigame/Cards;->state:B
    add-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    iput-byte v0, p0, Lminigame/Cards;->state:B
    const/4 v1, 2
    if-ne v0, v1, :L2
  .line 148
    iget-byte v0, p0, Lminigame/Cards;->tx:B
    iput-byte v0, p0, Lminigame/Cards;->selx:B
  .line 149
    iget-byte v0, p0, Lminigame/Cards;->ty:B
    iput-byte v0, p0, Lminigame/Cards;->sely:B
    goto/16 :L2
.end method

.method public patin()V
  .registers 4
  .prologue
    const/16 v2, 10
    const/4 v1, 2
  .line 159
    const/16 v0, 280
    invoke-virtual { p0, v2, v1, v0 }, Lminigame/Cards;->draw0(III)V
  .line 160
    iget-byte v0, p0, Lminigame/Cards;->state:B
    if-eqz v0, :L0
    iget-byte v0, p0, Lminigame/Cards;->length:B
    add-int/lit8 v0, v0, 3
    mul-int/lit8 v0, v0, 25
    invoke-direct { p0, v2, v1, v0 }, Lminigame/Cards;->drawGame(III)V
  :L0
  .line 165
    return-void
.end method

.method public run()V
  .registers 9
  .prologue
    const/16 v4, 10
    const/4 v3, 0
    const/4 v7, 3
    const/4 v5, -1
    const/4 v6, 1
  .line 168
    iget-byte v2, p0, Lminigame/Cards;->time:B
    if-ge v2, v6, :L2
  .line 169
    iget-byte v2, p0, Lminigame/Cards;->time:B
    if-nez v2, :L1
  .line 170
    iput-byte v5, p0, Lminigame/Cards;->time:B
  .line 171
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    const-string v3, "\u6e38\u620f\u5931\u8d25\uff01\uff01\uff01"
    invoke-virtual { v2, v3, v5 }, Lmain/GameRun;->say(Ljava/lang/String;I)V
  :L0
  .line 210
    return-void
  :L1
  .line 172
    iget-byte v2, p0, Lminigame/Cards;->time:B
    if-ne v2, v5, :L0
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    iget-byte v2, v2, Lmain/GameRun;->say_c:B
    if-nez v2, :L0
  .line 173
    iget-byte v2, p0, Lminigame/Cards;->lv:B
    invoke-virtual { p0, v3, v2 }, Lminigame/Cards;->go(II)V
    goto :L0
  :L2
  .line 175
    iget-byte v2, p0, Lminigame/Cards;->find_count:B
    if-ge v2, v6, :L4
  .line 176
    iget-byte v2, p0, Lminigame/Cards;->find_count:B
    if-nez v2, :L3
  .line 177
    iput-byte v5, p0, Lminigame/Cards;->find_count:B
  .line 178
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    iget v3, v2, Lmain/GameRun;->money:I
    iget-byte v4, p0, Lminigame/Cards;->time:B
    mul-int/lit8 v4, v4, 125
    add-int/lit8 v4, v4, 100
    add-int/2addr v3, v4
    iput v3, v2, Lmain/GameRun;->money:I
  .line 179
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "\u83b7\u5f97\u91d1\u94b1\uff1a"
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-byte v4, p0, Lminigame/Cards;->time:B
    mul-int/lit8 v4, v4, 125
    add-int/lit8 v4, v4, 100
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v2, v3, v5 }, Lmain/GameRun;->say(Ljava/lang/String;I)V
  .line 180
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    iget-object v2, v2, Lmain/GameRun;->rmsOther:[B
    const/16 v3, 8
    aget-byte v4, v2, v3
    iget-byte v5, p0, Lminigame/Cards;->lv:B
    shl-int v5, v6, v5
    or-int/2addr v4, v5
    int-to-byte v4, v4
    aput-byte v4, v2, v3
    goto :L0
  :L3
  .line 182
    iget-byte v2, p0, Lminigame/Cards;->find_count:B
    if-ne v2, v5, :L0
    iget-object v2, p0, Lminigame/Cards;->gr:Lmain/GameRun;
    iget-byte v2, v2, Lmain/GameRun;->say_c:B
    if-nez v2, :L0
  .line 189
    iget-byte v2, p0, Lminigame/Cards;->lv:B
    invoke-virtual { p0, v3, v2 }, Lminigame/Cards;->go(II)V
    goto :L0
  :L4
  .line 191
    iget-byte v2, p0, Lminigame/Cards;->state:B
    if-lt v2, v7, :L7
  .line 192
    iget-byte v2, p0, Lminigame/Cards;->state:B
    add-int/lit8 v2, v2, 1
    int-to-byte v2, v2
    iput-byte v2, p0, Lminigame/Cards;->state:B
    if-le v2, v4, :L5
    iput-byte v6, p0, Lminigame/Cards;->state:B
    goto :L0
  :L5
  .line 193
    iget-byte v2, p0, Lminigame/Cards;->state:B
    if-ne v2, v4, :L0
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
    if-eq v2, v3, :L6
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
    goto/16 :L0
  :L6
  .line 198
    iget-byte v2, p0, Lminigame/Cards;->find_count:B
    sub-int/2addr v2, v6
    int-to-byte v2, v2
    iput-byte v2, p0, Lminigame/Cards;->find_count:B
    goto/16 :L0
  :L7
  .line 200
    iget-short v2, p0, Lminigame/Cards;->count:S
    if-lez v2, :L0
  .line 201
    iget-short v2, p0, Lminigame/Cards;->count:S
    sub-int/2addr v2, v6
    int-to-short v2, v2
    iput-short v2, p0, Lminigame/Cards;->count:S
    if-nez v2, :L0
  .line 202
    const/4 v0, 0
  :L8
  .line 203
  .local v0, "i":B
    iget-object v2, p0, Lminigame/Cards;->findC:[[B
    array-length v2, v2
    if-ge v0, v2, :L0
  .line 204
    const/4 v1, 0
  :L9
  .local v1, "j":B
    iget-object v2, p0, Lminigame/Cards;->findC:[[B
    aget-object v2, v2, v0
    array-length v2, v2
    if-lt v1, v2, :L10
  .line 203
    add-int/lit8 v2, v0, 1
    int-to-byte v0, v2
    goto :L8
  :L10
  .line 205
    iget-object v2, p0, Lminigame/Cards;->findC:[[B
    aget-object v2, v2, v0
    aput-byte v7, v2, v1
  .line 204
    add-int/lit8 v2, v1, 1
    int-to-byte v1, v2
    goto :L9
.end method
