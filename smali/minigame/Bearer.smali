.class public Lminigame/Bearer;
.super Ljava/lang/Object;
.implements Lminigame/MiniGame_H;
.source "Bearer.java"

.field private final SPEED:B

.field private ballC0:S

.field private ballC1:S

.field private ballDate:[[S

.field private ball_time:[B

.field private bsp:Ldm/Sprite;

.field private count:S

.field private cur:B

.field private gDate:[[S

.field gr:Lmain/GameRun;

.field private img:Ljavax/microedition/lcdui/Image;

.field private length:B

.field private lv:B

.field private money:[S

.field private myxy:[S

.field sel:B

.field private sp:[Ldm/Sprite;

.field private state:B

.field private time0:S

.field private time1:S

.field private xy:[[S

.method public constructor <init>(Lmain/GameRun;)V
  .parameter "gr_" # Lmain/GameRun;
  .registers 10
  .prologue
    const/4 v7, 3
    const/4 v6, 2
    const/4 v5, 1
    const/4 v4, 5
    const/4 v3, 4
  .line 62
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 28
    new-array v0, v3, [[S
    const/4 v1, 0
  .line 29
    const/16 v2, 10
    new-array v2, v2, [S
    fill-array-data v2, :L0
    aput-object v2, v0, v1
  .line 30
    new-array v1, v3, [S
    fill-array-data v1, :L1
    aput-object v1, v0, v5
  .line 31
    new-array v1, v3, [S
    fill-array-data v1, :L2
    aput-object v1, v0, v6
  .line 32
    const/16 v1, 8
    new-array v1, v1, [S
    fill-array-data v1, :L3
    aput-object v1, v0, v7
    iput-object v0, p0, Lminigame/Bearer;->gDate:[[S
  .line 34
    new-array v0, v7, [[S
    const/4 v1, 0
  .line 40
    new-array v2, v4, [S
    fill-array-data v2, :L4
    aput-object v2, v0, v1
  .line 41
    new-array v1, v4, [S
    fill-array-data v1, :L5
    aput-object v1, v0, v5
  .line 42
    new-array v1, v4, [S
    fill-array-data v1, :L6
    aput-object v1, v0, v6
    iput-object v0, p0, Lminigame/Bearer;->ballDate:[[S
  .line 49
    new-array v0, v3, [S
    fill-array-data v0, :L7
    iput-object v0, p0, Lminigame/Bearer;->money:[S
  .line 50
    const/16 v0, 40
    const/4 v1, 7
    filled-new-array { v0, v1 }, [I
    move-result-object v0
    sget-object v1, Ljava/lang/Short;->TYPE:Ljava/lang/Class;
    invoke-static { v1, v0 }, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [[S
    iput-object v0, p0, Lminigame/Bearer;->xy:[[S
  .line 52
    new-array v0, v4, [S
    const/16 v1, 275
    aput-short v1, v0, v5
    const/16 v1, 67
    aput-short v1, v0, v6
    const/16 v1, 10
    aput-short v1, v0, v7
    iput-object v0, p0, Lminigame/Bearer;->myxy:[S
  .line 61
    new-array v0, v3, [B
    fill-array-data v0, :L8
    iput-object v0, p0, Lminigame/Bearer;->ball_time:[B
  .line 107
    const/16 v0, 10
    iput-byte v0, p0, Lminigame/Bearer;->SPEED:B
  .line 62
    iput-object p1, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    return-void
  .line 29
  .line 30
  .line 31
  .line 32
  .line 40
  .line 41
  .line 42
  .line 49
  .line 61
  :L0
  .array-data 2
    9t 0t
    1t 0t
    10t 0t
    2t 0t
    11t 0t
    4t 0t
    27t 0t
    8t 0t
    2t 0t
    -10t -1t
  .end array-data
  :L1
  .array-data 2
    50t 0t
    100t 0t
    -106t 0t
    -56t 0t
  .end array-data
  :L2
  .array-data 2
    60t 0t
    40t 0t
    30t 0t
    10t 0t
  .end array-data
  :L3
  .array-data 2
    8t 0t
    6t 0t
    13t 0t
    3t 0t
    20t 0t
    5t 0t
    30t 0t
    10t 0t
  .end array-data
  :L4
  .array-data 2
    10t 0t
    20t 0t
    60t 0t
    10t 0t
    -36t 0t
  .end array-data
  :L5
  .array-data 2
    13t 0t
    40t 0t
    60t 0t
    12t 0t
    -86t 0t
  .end array-data
  :L6
  .array-data 2
    10t 0t
    40t 0t
    60t 0t
    10t 0t
    120t 0t
  .end array-data
  :L7
  .array-data 2
    -106t 0t
    -56t 0t
    44t 1t
    -62t 1t
  .end array-data
  :L8
  .array-data 1
    20t
    15t
    10t
    5t
  .end array-data
.end method

.method private addBall(I)V
  .parameter "id" # I
  .registers 9
  .prologue
    const/4 v6, 4
    const/4 v5, 3
    const/4 v3, 1
    const/4 v4, 0
  .line 244
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    iget-byte v1, p0, Lminigame/Bearer;->cur:B
    aget-object v0, v0, v1
    const/16 v1, -20
    aput-short v1, v0, v4
  .line 245
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    iget-byte v1, p0, Lminigame/Bearer;->cur:B
    aget-object v0, v0, v1
    iget-object v1, p0, Lminigame/Bearer;->ballDate:[[S
    aget-object v1, v1, p1
    aget-short v1, v1, v6
    aput-short v1, v0, v3
  .line 246
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    iget-byte v1, p0, Lminigame/Bearer;->cur:B
    aget-object v0, v0, v1
    const/4 v1, 2
    iget-object v2, p0, Lminigame/Bearer;->ballDate:[[S
    aget-object v2, v2, p1
    aget-short v2, v2, v3
    iget-object v3, p0, Lminigame/Bearer;->ballDate:[[S
    aget-object v3, v3, p1
    aget-short v3, v3, v4
    div-int/2addr v2, v3
    int-to-short v2, v2
    aput-short v2, v0, v1
  .line 247
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    iget-byte v1, p0, Lminigame/Bearer;->cur:B
    aget-object v0, v0, v1
    iget-object v1, p0, Lminigame/Bearer;->ballDate:[[S
    aget-object v1, v1, p1
    aget-short v1, v1, v4
    aput-short v1, v0, v6
  .line 248
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    iget-byte v1, p0, Lminigame/Bearer;->cur:B
    aget-object v0, v0, v1
    const/4 v1, 5
    int-to-short v2, p1
    aput-short v2, v0, v1
  .line 249
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    iget-byte v1, p0, Lminigame/Bearer;->cur:B
    aget-object v0, v0, v1
    iget-object v1, p0, Lminigame/Bearer;->ballDate:[[S
    aget-object v1, v1, p1
    aget-short v1, v1, v5
    aput-short v1, v0, v5
  .line 250
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    iget-byte v1, p0, Lminigame/Bearer;->cur:B
    aget-object v0, v0, v1
    const/4 v1, 6
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-object v2, p0, Lminigame/Bearer;->gDate:[[S
    aget-object v2, v2, v4
    array-length v2, v2
    shr-int/lit8 v2, v2, 1
    invoke-static { v2 }, Ldm/Ms;->getRandom(I)I
    move-result v2
    int-to-short v2, v2
    aput-short v2, v0, v1
  .line 251
    iget-byte v0, p0, Lminigame/Bearer;->cur:B
    add-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    iput-byte v0, p0, Lminigame/Bearer;->cur:B
    iget-object v1, p0, Lminigame/Bearer;->xy:[[S
    array-length v1, v1
    if-lt v0, v1, :L0
    iput-byte v4, p0, Lminigame/Bearer;->cur:B
  :L0
  .line 252
    return-void
.end method

.method private draw0(III)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "h" # I
  .registers 21
  .prologue
  .line 158
    const/16 v13, 360
  .line 159
  .local v13, "HEIGHT":I
    const/16 v14, 320
  .line 160
  .local v14, "WIDTH_H":I
    add-int/lit8 p3, p3, 45
  .line 161
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    invoke-virtual { v2 }, Ldm/Ui;->fillRectB()V
  .line 162
    const/16 v16, 200
  .line 163
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
  .line 164
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    add-int v3, p1, v16
    add-int/lit8 v3, v3, 10
    add-int/lit8 v4, p2, 25
    add-int/lit8 v4, v4, 5
    const/4 v7, 4
    move/from16 v5, v16
    move/from16 v6, p3
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawK(IIIII)V
  .line 165
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
  .line 167
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
  .line 168
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const/4 v3, 7
    const/16 v4, 50
    sub-int v4, v14, v4
    const/4 v5, 5
    sub-int/2addr v4, v5
    add-int/lit8 v5, p2, 25
    const/4 v6, 4
    sub-int/2addr v5, v6
    const/16 v6, 40
    const/4 v7, 0
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawUi(IIIII)V
  .line 169
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const/4 v3, 7
    add-int/lit8 v4, v14, 50
    add-int/lit8 v4, v4, 5
    add-int/lit8 v5, p2, 25
    const/4 v6, 4
    sub-int/2addr v5, v6
    const/16 v6, 36
    const/4 v7, 4
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawUi(IIIII)V
  .line 170
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gr:Lmain/GameRun;
    move-object v3, v0
    iget-object v3, v3, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;
    const/16 v4, 25
    add-int/lit8 v5, p2, 75
    add-int/lit8 v5, v5, 10
    const/16 v6, 25
    const/4 v7, 0
    const/4 v8, 0
    invoke-virtual/range { v2 .. v8 }, Ldm/Ui;->drawStringY([Ljava/lang/StringBuffer;IIIII)V
  .line 171
    add-int/lit8 v5, p2, 100
  .line 172
  .local v5, "ty":I
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const-string v3, "\u7403\u7684\u5206\u6570\uff1a"
    add-int/lit8 v4, v16, 10
    mul-int/lit8 v4, v4, 2
    move/from16 v0, p1
    add-int/lit16 v0, v0, 420
    move v4, v0
    add-int/lit8 v4, v4, 20
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    invoke-virtual/range { v2 .. v8 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 173
    add-int/lit8 v5, v5, 50
  .line 174
    const/4 v15, 0
  :L0
  .local v15, "i":I
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gDate:[[S
    move-object v2, v0
    const/4 v3, 0
    aget-object v2, v2, v3
    array-length v2, v2
    if-lt v15, v2, :L3
  .line 180
    add-int/lit8 v5, v5, -50
  .line 181
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
    iget-byte v0, v0, Lminigame/Bearer;->sel:B
    move v10, v0
    const/4 v11, 4
    const/4 v12, 2
    invoke-virtual/range { v2 .. v12 }, Ldm/Ui;->drawListKY(IIIIIIIIII)V
  .line 182
    const/4 v15, 0
  :L1
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gr:Lmain/GameRun;
    move-object v2, v0
    iget-object v2, v2, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;
    array-length v2, v2
    if-lt v15, v2, :L10
  .line 193
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gr:Lmain/GameRun;
    move-object v6, v0
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a"
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->money:[S
    move-object v3, v0
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Bearer;->lv:B
    move v4, v0
    aget-short v3, v3, v4
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, "\u91d1"
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    add-int v2, p2, p3
    const/16 v3, 50
    sub-int v9, v2, v3
    const/4 v10, 7
    const/4 v11, 0
    move v8, v14
    invoke-virtual/range { v6 .. v11 }, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V
  .line 194
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gr:Lmain/GameRun;
    move-object v2, v0
    const/4 v3, 3
    const/4 v4, 0
    invoke-virtual { v2, v14, v13, v3, v4 }, Lmain/GameRun;->drawMoney(IIIZ)V
  .line 195
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Bearer;->state:B
    move v2, v0
    if-nez v2, :L2
  .line 196
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    const/4 v3, 1
    const/4 v4, 1
    invoke-virtual { v2, v3, v4 }, Ldm/Ui;->drawYesNo(ZZ)V
  :L2
  .line 197
    return-void
  :L3
  .line 175
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gr:Lmain/GameRun;
    move-object v2, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gDate:[[S
    move-object v3, v0
    const/4 v4, 0
    aget-object v3, v3, v4
    aget-short v3, v3, v15
    add-int/lit8 v4, v16, 10
    mul-int/lit8 v4, v4, 2
    move/from16 v0, p1
    add-int/lit16 v0, v0, 420
    move v4, v0
    add-int/lit8 v4, v4, 25
    rem-int/lit8 v6, v15, 4
    const/4 v7, 2
    if-ne v6, v7, :L7
    const/16 v6, 100
  :L4
    add-int/2addr v4, v6
  .line 176
    shr-int/lit8 v6, v15, 2
    mul-int/lit8 v6, v6, 30
    add-int/2addr v6, v5
    const/4 v7, 0
  .line 175
    invoke-virtual { v2, v3, v4, v6, v7 }, Lmain/GameRun;->drawItem(IIII)V
  .line 177
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v6
    new-instance v2, Ljava/lang/StringBuilder;
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gDate:[[S
    move-object v3, v0
    const/4 v4, 0
    aget-object v3, v3, v4
    add-int/lit8 v4, v15, 1
    aget-short v3, v3, v4
    if-gez v3, :L8
    const-string v3, ""
  :L5
    invoke-static { v3 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gDate:[[S
    move-object v3, v0
    const/4 v4, 0
    aget-object v3, v3, v4
    add-int/lit8 v4, v15, 1
    aget-short v3, v3, v4
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    add-int/lit8 v2, v16, 10
    mul-int/lit8 v2, v2, 2
    move/from16 v0, p1
    add-int/lit16 v0, v0, 420
    move v2, v0
    add-int/lit8 v2, v2, 25
    rem-int/lit8 v3, v15, 4
    const/4 v4, 2
    if-ne v3, v4, :L9
    const/16 v3, 100
  :L6
    add-int/2addr v2, v3
    add-int/lit8 v8, v2, 16
  .line 178
    shr-int/lit8 v2, v15, 2
    mul-int/lit8 v2, v2, 30
    add-int/2addr v2, v5
    const/4 v3, 4
    sub-int v9, v2, v3
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 1
  .line 177
    invoke-virtual/range { v6 .. v12 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 174
    add-int/lit8 v15, v15, 2
    goto/16 :L0
  :L7
  .line 175
    const/4 v6, 0
    goto :L4
  :L8
  .line 177
    const-string v3, "+"
    goto :L5
  :L9
    const/4 v3, 0
    goto :L6
  :L10
  .line 183
    sget-object v2, Ljava/lang/System;->out:Ljava/io/PrintStream;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "i   "
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v3, v15 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v2, v3 }, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
  .line 184
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gr:Lmain/GameRun;
    move-object v2, v0
    iget-object v2, v2, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;
    aget-object v2, v2, v15
    invoke-virtual { v2 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v7
    add-int v2, p1, v16
    add-int/lit8 v2, v2, 15
    add-int/lit8 v2, v2, 25
    add-int/lit8 v8, v2, 26
  .line 185
    mul-int/lit8 v2, v15, 40
    add-int/2addr v2, v5
    const/4 v3, 2
    sub-int v9, v2, v3
    const/4 v10, 0
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Bearer;->sel:B
    move v2, v0
    if-ne v2, v15, :L13
    const/4 v2, 0
    move v11, v2
  :L11
    const/4 v12, 1
  .line 184
    invoke-virtual/range { v6 .. v12 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 186
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gr:Lmain/GameRun;
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
    if-eqz v2, :L12
  .line 187
    sget-object v2, Ljava/lang/System;->out:Ljava/io/PrintStream;
    const-string v3, "asdfasfaf"
    invoke-virtual { v2, v3 }, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
  .line 188
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Bearer;->sel:B
    move v2, v0
    if-ne v2, v15, :L14
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Bearer;->gr:Lmain/GameRun;
    move-object v2, v0
    iget-object v2, v2, Lmain/GameRun;->pkey:Lmain/PointerKey;
    invoke-virtual { v2 }, Lmain/PointerKey;->setKey5()V
  :L12
  .line 182
    add-int/lit8 v15, v15, 1
    goto/16 :L1
  :L13
  .line 185
    const/4 v2, 3
    move v11, v2
    goto :L11
  :L14
  .line 189
    int-to-byte v2, v15
    move v0, v2
    move-object/from16 v1, p0
    iput-byte v0, v1, Lminigame/Bearer;->sel:B
    goto :L12
.end method

.method private drawGame(IIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 16
  .prologue
    const/4 v10, 4
    const/4 v9, 3
    const/4 v6, 1
    const/4 v8, 0
  .line 223
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const v1, 5423359
    move v2, p1
    move v3, p2
    move v4, p3
    move v5, p4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 224
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-object v1, p0, Lminigame/Bearer;->bsp:Ldm/Sprite;
    shr-int/lit8 v2, p3, 1
    add-int v3, p1, v2
    shr-int/lit8 v2, p4, 1
    add-int v4, p2, v2
    move v2, v8
    move v5, v8
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V
  .line 226
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "\u5206\u6570\uff1a"
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-short v2, p0, Lminigame/Bearer;->count:S
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    shr-int/lit8 v2, p3, 1
    add-int/2addr v2, p1
    const/16 v3, 25
    sub-int/2addr v2, v3
    const/16 v4, 24
    move v3, p2
    move v5, v9
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 227
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "\u7403\u603b\u6570\uff1a"
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-short v2, p0, Lminigame/Bearer;->ballC0:S
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    shr-int/lit8 v2, p3, 1
    add-int/2addr v2, p1
    add-int/lit8 v2, v2, 25
    const/16 v4, 20
    move v3, p2
    move v5, v9
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 228
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-object v1, p0, Lminigame/Bearer;->img:Ljavax/microedition/lcdui/Image;
    add-int v2, p1, p3
    const/16 v3, 15
    sub-int v3, p4, v3
    const/16 v4, 40
    invoke-virtual { v0, v1, v2, v3, v4 }, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V
  .line 230
    const/4 v7, 0
  :L0
  .local v7, "i":B
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    array-length v0, v0
    if-lt v7, v0, :L2
  .line 235
    const/4 v7, 0
  :L1
    const/4 v0, 2
    if-lt v7, v0, :L5
  .line 238
    iget-object v0, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    const/16 v1, 320
    const/16 v2, 360
    invoke-virtual { v0, v1, v2, v9, v8 }, Lmain/GameRun;->drawMoney(IIIZ)V
  .line 241
    return-void
  :L2
  .line 231
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, v7
    const/4 v1, 5
    aget-short v0, v0, v1
    const/4 v1, -1
    if-ne v0, v1, :L4
  :L3
  .line 230
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L0
  :L4
  .line 232
    iget-object v0, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    iget-object v1, p0, Lminigame/Bearer;->gDate:[[S
    aget-object v1, v1, v8
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v7
    const/4 v3, 6
    aget-short v2, v2, v3
    shl-int/lit8 v2, v2, 1
    aget-short v1, v1, v2
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v7
    aget-short v2, v2, v8
    add-int/2addr v2, p1
    iget-object v3, p0, Lminigame/Bearer;->xy:[[S
    aget-object v3, v3, v7
    aget-short v3, v3, v6
    add-int/2addr v3, p2
    invoke-virtual { v0, v1, v2, v3, v8 }, Lmain/GameRun;->drawItem(IIII)V
    goto :L3
  :L5
  .line 236
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-object v1, p0, Lminigame/Bearer;->sp:[Ldm/Sprite;
    aget-object v1, v1, v8
    iget-object v2, p0, Lminigame/Bearer;->myxy:[S
    aget-short v2, v2, v10
    if-nez v2, :L7
    move v2, v9
  :L6
    iget-object v3, p0, Lminigame/Bearer;->myxy:[S
    aget-short v3, v3, v8
    add-int/2addr v3, p1
    mul-int/lit8 v4, v7, 30
    add-int/2addr v3, v4
    add-int/lit8 v3, v3, 20
    iget-object v4, p0, Lminigame/Bearer;->myxy:[S
    aget-short v4, v4, v6
    add-int/2addr v4, p2
    add-int/lit8 v4, v4, 25
    move v5, v8
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V
  .line 235
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L1
  :L7
    move v2, v10
  .line 236
    goto :L6
.end method

.method private getAY(I)V
  .parameter "i" # I
  .registers 8
  .prologue
    const/4 v1, 4
    const/4 v5, 1
    const/4 v4, 3
  .line 259
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v0, v0, v1
    if-lez v0, :L1
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v0, v0, v4
    if-le v0, v5, :L1
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v1, v0, v4
    sub-int/2addr v1, v5
    int-to-short v1, v1
    aput-short v1, v0, v4
  :L0
  .line 262
    return-void
  :L1
  .line 260
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v0, v0, v1
    if-nez v0, :L2
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    const/4 v1, 0
    aput-short v1, v0, v4
    goto :L0
  :L2
  .line 261
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v0, v0, v1
    if-gez v0, :L0
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v0, v0, v4
    iget-object v1, p0, Lminigame/Bearer;->ballDate:[[S
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, p1
    const/4 v3, 5
    aget-short v2, v2, v3
    aget-object v1, v1, v2
    aget-short v1, v1, v4
    neg-int v1, v1
    if-le v0, v1, :L0
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v1, v0, v4
    sub-int/2addr v1, v5
    int-to-short v1, v1
    aput-short v1, v0, v4
    goto :L0
.end method

.method private initABall(Z)V
  .parameter "mode" # Z
  .registers 5
  .prologue
    const/4 v2, 3
  .line 254
    if-eqz p1, :L1
    const/16 v0, 10
  :L0
    iput-short v0, p0, Lminigame/Bearer;->time0:S
  .line 255
    iget-object v0, p0, Lminigame/Bearer;->ball_time:[B
    iget-byte v1, p0, Lminigame/Bearer;->lv:B
    aget-byte v0, v0, v1
    iput-short v0, p0, Lminigame/Bearer;->time1:S
  .line 256
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-object v0, p0, Lminigame/Bearer;->gDate:[[S
    aget-object v0, v0, v2
    iget-byte v1, p0, Lminigame/Bearer;->lv:B
    shl-int/lit8 v1, v1, 1
    aget-short v0, v0, v1
    invoke-static { v0 }, Ldm/Ms;->getRandom(I)I
    move-result v0
    iget-object v1, p0, Lminigame/Bearer;->gDate:[[S
    aget-object v1, v1, v2
    iget-byte v2, p0, Lminigame/Bearer;->lv:B
    shl-int/lit8 v2, v2, 1
    add-int/lit8 v2, v2, 1
    aget-short v1, v1, v2
    add-int/2addr v0, v1
    int-to-short v0, v0
    iput-short v0, p0, Lminigame/Bearer;->ballC1:S
  .line 257
    return-void
  :L1
  .line 254
    iget-object v0, p0, Lminigame/Bearer;->gDate:[[S
    const/4 v1, 2
    aget-object v0, v0, v1
    iget-byte v1, p0, Lminigame/Bearer;->lv:B
    aget-short v0, v0, v1
    goto :L0
.end method

.method private isCollision(I)Z
  .parameter "i" # I
  .registers 12
  .prologue
    const/16 v7, 16
    const/4 v8, 1
    const/4 v6, 0
  .line 290
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    iget-object v1, p0, Lminigame/Bearer;->myxy:[S
    aget-short v1, v1, v6
    iget-object v2, p0, Lminigame/Bearer;->myxy:[S
    aget-short v2, v2, v8
    iget-object v3, p0, Lminigame/Bearer;->myxy:[S
    const/4 v4, 2
    aget-short v3, v3, v4
    iget-object v4, p0, Lminigame/Bearer;->myxy:[S
    const/4 v5, 3
    aget-short v4, v4, v5
  .line 291
    iget-object v5, p0, Lminigame/Bearer;->xy:[[S
    aget-object v5, v5, p1
    aget-short v5, v5, v6
    iget-object v6, p0, Lminigame/Bearer;->xy:[[S
    aget-object v6, v6, p1
    aget-short v6, v6, v8
    move v8, v7
  .line 290
    invoke-virtual/range { v0 .. v8 }, Ldm/Ms;->isRect(IIIIIIII)Z
    move-result v9
  .line 292
  .local v9, "bb":Z
    return v9
.end method

.method private isSrc(I)Z
  .parameter "i" # I
  .registers 16
  .prologue
    const/16 v7, 16
    const/16 v4, 10
    const/4 v13, 0
    const/4 v12, 1
  .line 265
    const/16 v11, 240
  .local v11, "w":I
    const/16 v10, 320
  .line 266
  .local v10, "h":I
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v0, v0, v12
    add-int/lit8 v1, v10, 10
    if-le v0, v1, :L3
    move v9, v12
  :L0
  .line 267
  .local v9, "bb":Z
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    sub-int v1, v11, v4
    const/16 v2, 40
    sub-int v2, v10, v2
    const/16 v3, 20
  .line 268
    iget-object v5, p0, Lminigame/Bearer;->xy:[[S
    aget-object v5, v5, p1
    aget-short v5, v5, v13
    iget-object v6, p0, Lminigame/Bearer;->xy:[[S
    aget-object v6, v6, p1
    aget-short v6, v6, v12
    move v8, v7
  .line 267
    invoke-virtual/range { v0 .. v8 }, Ldm/Ms;->isRect(IIIIIIII)Z
    move-result v0
    if-nez v0, :L1
  .line 269
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v0, v0, v13
    if-le v0, v11, :L2
    iget-object v0, p0, Lminigame/Bearer;->xy:[[S
    aget-object v0, v0, p1
    aget-short v0, v0, v12
    iget-object v1, p0, Lminigame/Bearer;->myxy:[S
    aget-short v1, v1, v12
    if-ge v0, v1, :L2
  :L1
  .line 270
    const/4 v9, 1
  .line 271
    iget-short v0, p0, Lminigame/Bearer;->count:S
    iget-object v1, p0, Lminigame/Bearer;->gDate:[[S
    aget-object v1, v1, v13
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, p1
    const/4 v3, 6
    aget-short v2, v2, v3
    mul-int/lit8 v2, v2, 2
    add-int/lit8 v2, v2, 1
    aget-short v1, v1, v2
    add-int/2addr v0, v1
    int-to-short v0, v0
    iput-short v0, p0, Lminigame/Bearer;->count:S
  :L2
  .line 273
    return v9
  :L3
  .end local v9
    move v9, v13
  .line 266
    goto :L0
.end method

.method private nullGame()V
  .registers 2
  .prologue
    const/4 v0, 0
  .line 64
    iput-object v0, p0, Lminigame/Bearer;->gDate:[[S
  .line 65
    iput-object v0, p0, Lminigame/Bearer;->money:[S
  .line 66
    iput-object v0, p0, Lminigame/Bearer;->sp:[Ldm/Sprite;
  .line 67
    iput-object v0, p0, Lminigame/Bearer;->img:Ljavax/microedition/lcdui/Image;
  .line 68
    iput-object v0, p0, Lminigame/Bearer;->ballDate:[[S
  .line 69
    return-void
.end method

.method public go(I)V
  .parameter "mode" # I
  .registers 8
  .prologue
    const/4 v5, 0
    const/4 v4, 1
  .line 89
    if-ge p1, v4, :L1
  .line 90
    iput-byte v5, p0, Lminigame/Bearer;->state:B
  .line 91
    const/16 v1, 10
    iput-byte v1, p0, Lminigame/Bearer;->length:B
  .line 93
    iget-object v1, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    const-string v2, "\u5728\u9650\u5b9a\u65f6\u95f4\u91cc\u63a5\u5c3d\u91cf\u591a\u7684\u7403\u5230\u6846\u91cc\uff0c\u6700\u540e\u6839\u636e\u6846\u91cc\u7403\u7684\u5206\u6570\u6765\u6362\u53d6\u91d1\u94b1\u3002"
    const/16 v3, 160
    invoke-virtual { v1, v2, v3, v5 }, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V
  .line 94
    iget-object v1, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    const-string v2, "\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f"
    sget v3, Lmain/Constants_H;->WIDTH:I
    invoke-virtual { v1, v2, v3, v4 }, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V
  :L0
  .line 106
    return-void
  :L1
  .line 98
    if-ne p1, v4, :L0
  .line 99
    iput-byte v4, p0, Lminigame/Bearer;->state:B
  .line 100
    iput-short v5, p0, Lminigame/Bearer;->count:S
  .line 101
    iput-byte v5, p0, Lminigame/Bearer;->cur:B
  .line 102
    iget-object v1, p0, Lminigame/Bearer;->gDate:[[S
    aget-object v1, v1, v4
    iget-byte v2, p0, Lminigame/Bearer;->lv:B
    aget-short v1, v1, v2
    iput-short v1, p0, Lminigame/Bearer;->ballC0:S
  .line 103
    invoke-direct { p0, v4 }, Lminigame/Bearer;->initABall(Z)V
  .line 104
    const/4 v0, 0
  :L2
  .local v0, "i":B
    iget-object v1, p0, Lminigame/Bearer;->xy:[[S
    array-length v1, v1
    if-ge v0, v1, :L0
    iget-object v1, p0, Lminigame/Bearer;->xy:[[S
    aget-object v1, v1, v0
    const/4 v2, 5
    const/4 v3, -1
    aput-short v3, v1, v2
    add-int/lit8 v1, v0, 1
    int-to-byte v0, v1
    goto :L2
.end method

.method public go(II)V
  .parameter "mode" # I
  .parameter "lv_" # I
  .registers 10
  .prologue
    const/4 v6, 0
    const/4 v5, 2
  .line 73
    int-to-byte v1, p2
    iput-byte v1, p0, Lminigame/Bearer;->lv:B
  .line 74
    new-array v1, v5, [Ldm/Sprite;
    iput-object v1, p0, Lminigame/Bearer;->sp:[Ldm/Sprite;
  .line 75
    iget-object v1, p0, Lminigame/Bearer;->sp:[Ldm/Sprite;
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v2
    const-string v3, "data/npc2/38"
    const/4 v4, 1
    invoke-virtual { v2, v3, v4 }, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;
    move-result-object v2
    aput-object v2, v1, v6
  .line 76
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const-string v2, "data/brow/m0"
    invoke-virtual { v1, v2 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v1
    iput-object v1, p0, Lminigame/Bearer;->img:Ljavax/microedition/lcdui/Image;
  .line 78
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const-string v2, "data/gamee.data"
    const/4 v3, -1
    invoke-virtual { v1, v2, v3 }, Ldm/Ms;->getStream(Ljava/lang/String;I)[B
    move-result-object v0
  .line 79
  .local v0, "date":[B
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    sput v6, Ldm/Ms;->skip:I
  .line 81
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const-string v2, "data/map/5"
    invoke-virtual { v1, v2 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v1
  .line 82
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v2
    invoke-virtual { v2, v0, v5 }, Ldm/Ms;->createShort2Array([BI)[[S
    move-result-object v2
  .line 83
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v3
    invoke-virtual { v3, v0, v5 }, Ldm/Ms;->createShort3Array([BI)[[[S
    move-result-object v3
  .line 84
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v4
    invoke-virtual { v4, v0, v5 }, Ldm/Ms;->createShort3Array([BI)[[[S
    move-result-object v4
  .line 80
    invoke-static { v1, v2, v3, v4 }, Ldm/Sprite;->Create(Ljavax/microedition/lcdui/Image;[[S[[[S[[[S)Ldm/Sprite;
    move-result-object v1
    iput-object v1, p0, Lminigame/Bearer;->bsp:Ldm/Sprite;
  .line 85
    invoke-virtual { p0, p1 }, Lminigame/Bearer;->go(I)V
  .line 86
    return-void
.end method

.method public key()Z
  .registers 7
  .prologue
    const/4 v5, 2
    const/4 v4, 1
    const/4 v3, 0
  .line 109
    iget-byte v0, p0, Lminigame/Bearer;->state:B
    if-nez v0, :L5
  .line 111
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Up_Down()Z
    move-result v0
    if-eqz v0, :L2
  .line 112
    iget-byte v0, p0, Lminigame/Bearer;->sel:B
    xor-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    iput-byte v0, p0, Lminigame/Bearer;->sel:B
  :L0
    move v0, v3
  :L1
  .line 143
    return v0
  :L2
  .line 113
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S1_Num5()Z
    move-result v0
    if-eqz v0, :L4
  .line 114
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 115
    iget-byte v0, p0, Lminigame/Bearer;->sel:B
    if-nez v0, :L3
    iget-object v0, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    iget-object v1, p0, Lminigame/Bearer;->money:[S
    iget-byte v2, p0, Lminigame/Bearer;->lv:B
    aget-short v1, v1, v2
    invoke-virtual { v0, v1, v4 }, Lmain/GameRun;->isMoney(IZ)Z
    move-result v0
    if-eqz v0, :L3
    invoke-virtual { p0, v4 }, Lminigame/Bearer;->go(I)V
    goto :L0
  :L3
  .line 116
    iget-byte v0, p0, Lminigame/Bearer;->sel:B
    if-ne v0, v4, :L0
  .line 117
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 118
    invoke-direct { p0 }, Lminigame/Bearer;->nullGame()V
    move v0, v4
  .line 119
    goto :L1
  :L4
  .line 125
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S2()Z
    move-result v0
    if-eqz v0, :L0
  .line 126
    invoke-direct { p0 }, Lminigame/Bearer;->nullGame()V
    move v0, v4
  .line 127
    goto :L1
  :L5
  .line 129
    iget-byte v0, p0, Lminigame/Bearer;->state:B
    if-ne v0, v4, :L0
  .line 130
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Left()Z
    move-result v0
    if-eqz v0, :L6
  .line 131
    iget-object v0, p0, Lminigame/Bearer;->myxy:[S
    aget-short v1, v0, v3
    const/16 v2, 10
    sub-int/2addr v1, v2
    int-to-short v1, v1
    aput-short v1, v0, v3
  .line 132
    iget-object v0, p0, Lminigame/Bearer;->myxy:[S
    aget-short v0, v0, v3
    if-gez v0, :L0
    iget-object v0, p0, Lminigame/Bearer;->myxy:[S
    aput-short v3, v0, v3
    goto :L0
  :L6
  .line 133
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Right()Z
    move-result v0
    if-eqz v0, :L0
  .line 134
    iget-object v0, p0, Lminigame/Bearer;->myxy:[S
    aget-short v1, v0, v3
    add-int/lit8 v1, v1, 10
    int-to-short v1, v1
    aput-short v1, v0, v3
  .line 136
    iget-object v0, p0, Lminigame/Bearer;->myxy:[S
    aget-short v0, v0, v3
    iget-object v1, p0, Lminigame/Bearer;->myxy:[S
    aget-short v1, v1, v5
    add-int/2addr v0, v1
    const/16 v1, 220
    if-le v0, v1, :L0
    iget-object v0, p0, Lminigame/Bearer;->myxy:[S
    const/16 v1, 240
    iget-object v2, p0, Lminigame/Bearer;->myxy:[S
    aget-short v2, v2, v5
    sub-int/2addr v1, v2
    const/16 v2, 20
    sub-int/2addr v1, v2
    int-to-short v1, v1
    aput-short v1, v0, v3
    goto/16 :L0
.end method

.method public patin()V
  .registers 5
  .prologue
  .line 148
    const/16 v0, 10
    const/4 v1, 2
    iget-byte v2, p0, Lminigame/Bearer;->length:B
    mul-int/lit8 v2, v2, 25
    invoke-direct { p0, v0, v1, v2 }, Lminigame/Bearer;->draw0(III)V
  .line 149
    iget-byte v0, p0, Lminigame/Bearer;->state:B
    if-eqz v0, :L0
    const/16 v0, 200
    const/4 v1, 0
    const/16 v2, 240
    const/16 v3, 320
    invoke-direct { p0, v0, v1, v2, v3 }, Lminigame/Bearer;->drawGame(IIII)V
  :L0
  .line 154
    return-void
.end method

.method public run()V
  .registers 12
  .prologue
    const/4 v10, 2
    const/4 v9, 5
    const/4 v8, 0
    const/4 v7, 4
    const/4 v6, 1
  .line 295
    iget-byte v2, p0, Lminigame/Bearer;->state:B
    if-ne v2, v6, :L13
  .line 296
    iget-short v2, p0, Lminigame/Bearer;->ballC0:S
    if-lez v2, :L0
  .line 297
    iget-short v2, p0, Lminigame/Bearer;->time0:S
    if-lez v2, :L6
    iget-short v2, p0, Lminigame/Bearer;->time0:S
    sub-int/2addr v2, v6
    int-to-short v2, v2
    iput-short v2, p0, Lminigame/Bearer;->time0:S
  :L0
  .line 306
    iget-object v2, p0, Lminigame/Bearer;->myxy:[S
    aget-short v2, v2, v7
    if-lez v2, :L1
    iget-object v2, p0, Lminigame/Bearer;->myxy:[S
    aget-short v3, v2, v7
    sub-int/2addr v3, v6
    int-to-short v3, v3
    aput-short v3, v2, v7
  :L1
  .line 308
    const/4 v0, 1
  .line 309
  .local v0, "bb":Z
    const/4 v1, 0
  :L2
  .local v1, "i":B
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    array-length v2, v2
    if-lt v1, v2, :L9
  .line 324
    iget-short v2, p0, Lminigame/Bearer;->ballC0:S
    if-ge v2, v6, :L4
    if-eqz v0, :L4
  .line 325
    iget-short v2, p0, Lminigame/Bearer;->count:S
    mul-int/lit8 v2, v2, 15
    div-int/lit8 v2, v2, 10
    int-to-short v2, v2
    iput-short v2, p0, Lminigame/Bearer;->count:S
  .line 326
    iget-object v2, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    iget v3, v2, Lmain/GameRun;->money:I
    iget-short v4, p0, Lminigame/Bearer;->count:S
    add-int/2addr v3, v4
    iput v3, v2, Lmain/GameRun;->money:I
  .line 327
    iget-object v2, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "\u83b7\u5f97\uff1a"
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-short v4, p0, Lminigame/Bearer;->count:S
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "\u91d1"
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v2, v3, v8 }, Lmain/GameRun;->say(Ljava/lang/String;I)V
  .line 328
    iget-short v2, p0, Lminigame/Bearer;->count:S
    if-lez v2, :L3
    iget-object v2, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    iget-object v2, v2, Lmain/GameRun;->rmsOther:[B
    const/4 v3, 6
    aget-byte v4, v2, v3
    iget-byte v5, p0, Lminigame/Bearer;->lv:B
    shl-int v5, v6, v5
    or-int/2addr v4, v5
    int-to-byte v4, v4
    aput-byte v4, v2, v3
  :L3
  .line 329
    iput-byte v10, p0, Lminigame/Bearer;->state:B
  :L4
  .line 333
    iget-object v2, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    iget-object v2, v2, Lmain/GameRun;->pkey:Lmain/PointerKey;
    invoke-virtual { v2, v7 }, Lmain/PointerKey;->checkButton(I)I
  :L5
  .line 336
  .end local v0
  .end local v1
    return-void
  :L6
  .line 298
    iget-short v2, p0, Lminigame/Bearer;->time1:S
    if-lez v2, :L7
    iget-short v2, p0, Lminigame/Bearer;->time1:S
    sub-int/2addr v2, v6
    int-to-short v2, v2
    iput-short v2, p0, Lminigame/Bearer;->time1:S
    goto :L0
  :L7
  .line 299
    iget-short v2, p0, Lminigame/Bearer;->ballC1:S
    if-lez v2, :L8
  .line 300
    iget-object v2, p0, Lminigame/Bearer;->ball_time:[B
    iget-byte v3, p0, Lminigame/Bearer;->lv:B
    aget-byte v2, v2, v3
    iput-short v2, p0, Lminigame/Bearer;->time1:S
  .line 301
    iget-object v2, p0, Lminigame/Bearer;->ballDate:[[S
    array-length v2, v2
    invoke-static { v2 }, Ldm/Ms;->getRandom(I)I
    move-result v2
    invoke-direct { p0, v2 }, Lminigame/Bearer;->addBall(I)V
  .line 302
    iget-short v2, p0, Lminigame/Bearer;->ballC1:S
    sub-int/2addr v2, v6
    int-to-short v2, v2
    iput-short v2, p0, Lminigame/Bearer;->ballC1:S
  .line 303
    iget-short v2, p0, Lminigame/Bearer;->ballC0:S
    sub-int/2addr v2, v6
    int-to-short v2, v2
    iput-short v2, p0, Lminigame/Bearer;->ballC0:S
    goto/16 :L0
  :L8
  .line 304
    iget-short v2, p0, Lminigame/Bearer;->ballC1:S
    if-nez v2, :L0
    invoke-direct { p0, v8 }, Lminigame/Bearer;->initABall(Z)V
    goto/16 :L0
  :L9
  .line 310
  .restart local v0
  .restart local v1
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v1
    aget-short v2, v2, v9
    const/4 v3, -1
    if-ne v2, v3, :L11
  :L10
  .line 309
    add-int/lit8 v2, v1, 1
    int-to-byte v1, v2
    goto/16 :L2
  :L11
  .line 311
    const/4 v0, 0
  .line 312
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v1
    aget-short v3, v2, v8
    iget-object v4, p0, Lminigame/Bearer;->xy:[[S
    aget-object v4, v4, v1
    aget-short v4, v4, v10
    add-int/2addr v3, v4
    int-to-short v3, v3
    aput-short v3, v2, v8
  .line 313
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v1
    aget-short v3, v2, v6
    iget-object v4, p0, Lminigame/Bearer;->xy:[[S
    aget-object v4, v4, v1
    const/4 v5, 3
    aget-short v4, v4, v5
    sub-int/2addr v3, v4
    int-to-short v3, v3
    aput-short v3, v2, v6
  .line 314
    invoke-direct { p0, v1 }, Lminigame/Bearer;->getAY(I)V
  .line 315
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v1
    aget-short v3, v2, v7
    sub-int/2addr v3, v6
    int-to-short v3, v3
    aput-short v3, v2, v7
  .line 316
    invoke-direct { p0, v1 }, Lminigame/Bearer;->isSrc(I)Z
    move-result v2
    if-eqz v2, :L12
  .line 317
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v1
    const/4 v3, -1
    aput-short v3, v2, v9
    goto :L10
  :L12
  .line 318
    invoke-direct { p0, v1 }, Lminigame/Bearer;->isCollision(I)Z
    move-result v2
    if-eqz v2, :L10
  .line 319
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v1
    iget-object v3, p0, Lminigame/Bearer;->ballDate:[[S
    iget-object v4, p0, Lminigame/Bearer;->xy:[[S
    aget-object v4, v4, v1
    aget-short v4, v4, v9
    aget-object v3, v3, v4
    aget-short v3, v3, v8
    aput-short v3, v2, v7
  .line 320
    iget-object v2, p0, Lminigame/Bearer;->myxy:[S
    aput-short v6, v2, v7
  .line 321
    iget-object v2, p0, Lminigame/Bearer;->xy:[[S
    aget-object v2, v2, v1
    const/4 v3, 3
    iget-object v4, p0, Lminigame/Bearer;->ballDate:[[S
    iget-object v5, p0, Lminigame/Bearer;->xy:[[S
    aget-object v5, v5, v1
    aget-short v5, v5, v9
    aget-object v4, v4, v5
    const/4 v5, 3
    aget-short v4, v4, v5
    aput-short v4, v2, v3
    goto :L10
  :L13
  .line 335
  .end local v0
  .end local v1
    iget-byte v2, p0, Lminigame/Bearer;->state:B
    if-ne v2, v10, :L5
    iget-object v2, p0, Lminigame/Bearer;->gr:Lmain/GameRun;
    iget-byte v2, v2, Lmain/GameRun;->say_c:B
    if-nez v2, :L5
    invoke-virtual { p0, v8 }, Lminigame/Bearer;->go(I)V
    goto/16 :L5
.end method

.method public setLv(I)V
  .parameter "lv_" # I
  .registers 3
  .prologue
  .line 70
    int-to-byte v0, p1
    iput-byte v0, p0, Lminigame/Bearer;->lv:B
    return-void
.end method
