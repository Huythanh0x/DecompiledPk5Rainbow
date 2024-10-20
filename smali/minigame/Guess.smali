.class public Lminigame/Guess;
.super Ljava/lang/Object;
.implements Lminigame/MiniGame_H;
.source "Guess.java"

.field final BOX_Y1:S

.field final MON_Y:S

.field final TIME:S

.field final TIME2:S

.field private b_win:B

.field private box:[[I

.field private boxNum:[B

.field private gameData:[[B

.field private gameR:B

.field gr:Lmain/GameRun;

.field private imgBox:[Ljavax/microedition/lcdui/Image;

.field private imgMon:[Ldm/Sprite;

.field private length:B

.field private lv:B

.field private maxTransNum:B

.field private mon_size_move:B

.field sel:B

.field private sell_money:I

.field private state:B

.field private tempTransNum:B

.field private time:B

.field private transNum:B

.field private winNum:B

.method public constructor <init>(Lmain/GameRun;)V
  .parameter "gr_" # Lmain/GameRun;
  .registers 5
  .prologue
    const/16 v2, 20
    const/4 v1, 0
  .line 23
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 39
    iput-short v2, p0, Lminigame/Guess;->TIME:S
  .line 40
    const/16 v0, 40
    iput-short v0, p0, Lminigame/Guess;->TIME2:S
  .line 45
    const/16 v0, 150
    iput-short v0, p0, Lminigame/Guess;->BOX_Y1:S
  .line 46
    const/16 v0, 165
    iput-short v0, p0, Lminigame/Guess;->MON_Y:S
  .line 353
    iput-byte v1, p0, Lminigame/Guess;->mon_size_move:B
  .line 355
    iput-byte v1, p0, Lminigame/Guess;->state:B
  .line 356
    iput-byte v1, p0, Lminigame/Guess;->gameR:B
  .line 357
    iput-byte v1, p0, Lminigame/Guess;->winNum:B
  .line 358
    iput-byte v1, p0, Lminigame/Guess;->transNum:B
  .line 359
    iput-byte v2, p0, Lminigame/Guess;->maxTransNum:B
  .line 360
    iput-byte v1, p0, Lminigame/Guess;->tempTransNum:B
  .line 23
    iput-object p1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    return-void
.end method

.method private draw()V
  .registers 31
  .prologue
  .line 121
    const/16 v26, 640
  .local v26, "WIDTH":I
    const/16 v24, 360
  .line 122
  .local v24, "HEIGHT":I
    const/16 v7, 320
  .local v7, "WIDTH_H":I
    const/16 v25, 180
  .line 123
  .local v25, "HEIGHT_H":I
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->state:B
    move v5, v0
    if-nez v5, :L0
  .line 124
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    const-string v6, "\u6e38\u620f\u89c4\u5219"
    const/4 v8, 4
    const/16 v9, 17
    const/4 v10, 3
    const/4 v11, 1
    invoke-virtual/range { v5 .. v11 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 125
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v8
    const/4 v9, 7
    const/16 v5, 75
    sub-int v10, v7, v5
    const/16 v11, 27
    const/16 v12, 40
    const/4 v13, 0
    invoke-virtual/range { v8 .. v13 }, Ldm/Ui;->drawUi(IIIII)V
  .line 126
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v8
    const/4 v9, 7
    add-int/lit8 v10, v7, 75
    const/16 v11, 27
    const/16 v12, 36
    const/4 v13, 4
    invoke-virtual/range { v8 .. v13 }, Ldm/Ui;->drawUi(IIIII)V
  :L0
  .line 128
    const/16 v9, 10
  .local v9, "x":I
    const/16 v29, 25
  .local v29, "y":I
    const/16 v11, 200
  .local v11, "w":I
    const/16 v27, 29
  .line 129
  .local v27, "fh":I
    mul-int/lit8 v12, v27, 10
  .line 130
  .local v12, "h":I
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v8
    add-int/lit8 v10, v29, 10
    const/4 v13, 4
    invoke-virtual/range { v8 .. v13 }, Ldm/Ui;->drawK(IIIII)V
  .line 131
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v13
    add-int v5, v9, v11
    add-int/lit8 v14, v5, 10
    add-int/lit8 v15, v29, 10
    const/16 v18, 4
    move/from16 v16, v11
    move/from16 v17, v12
    invoke-virtual/range { v13 .. v18 }, Ldm/Ui;->drawK(IIIII)V
  .line 132
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v13
    add-int/lit8 v5, v11, 10
    mul-int/lit8 v5, v5, 2
    add-int/lit16 v14, v9, 420
    add-int/lit8 v15, v29, 10
    const/16 v18, 4
    move/from16 v16, v11
    move/from16 v17, v12
    invoke-virtual/range { v13 .. v18 }, Ldm/Ui;->drawK(IIIII)V
  .line 134
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v13
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v14, v5, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;
    add-int/lit8 v15, v9, 6
    add-int/lit8 v16, v29, 10
    const/16 v18, 0
    const/16 v19, 0
    move/from16 v17, v27
    invoke-virtual/range { v13 .. v19 }, Ldm/Ui;->drawStringY([Ljava/lang/StringBuffer;IIIII)V
  .line 135
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->state:B
    move v5, v0
    if-nez v5, :L2
  .line 136
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v13, v0
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a"
    invoke-direct { v5, v6 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v0, p0
    iget v0, v0, Lminigame/Guess;->sell_money:I
    move v6, v0
    invoke-virtual { v5, v6 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "\u91d1"
    invoke-virtual { v5, v6 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual { v5 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    move/from16 v0, v29
    add-int/lit16 v0, v0, 290
    move v5, v0
    const/16 v6, 50
    sub-int v16, v5, v6
    const/16 v17, 7
    const/16 v18, 0
    move v15, v7
    invoke-virtual/range { v13 .. v18 }, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V
  .line 137
    add-int/lit8 v5, v29, 75
    add-int/lit8 v16, v5, 5
  .line 138
  .local v16, "ty":I
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v13
    const/4 v14, 2
    add-int v5, v9, v11
    add-int/lit8 v5, v5, 12
    add-int/lit8 v15, v5, 25
    const/16 v5, 50
    sub-int v17, v11, v5
    const/16 v18, 3
    const/16 v19, 30
    const/16 v20, 10
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->sel:B
    move/from16 v21, v0
    const/16 v22, 4
    const/16 v23, 2
    invoke-virtual/range { v13 .. v23 }, Ldm/Ui;->drawListKY(IIIIIIIIII)V
  .line 139
    const/16 v28, 0
  :L1
  .end local v12
  .local v28, "i":I
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v5, v5, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;
    array-length v5, v5
    move/from16 v0, v28
    move v1, v5
    if-lt v0, v1, :L4
  :L2
  .line 148
  .end local v16
  .end local v28
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->state:B
    move v5, v0
    if-nez v5, :L3
  .line 149
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    const/4 v6, 1
    const/4 v8, 1
    invoke-virtual { v5, v6, v8 }, Ldm/Ui;->drawYesNo(ZZ)V
  :L3
  .line 150
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    const/4 v6, 3
    const/4 v8, 0
    move-object v0, v5
    move v1, v7
    move/from16 v2, v24
    move v3, v6
    move v4, v8
    invoke-virtual { v0, v1, v2, v3, v4 }, Lmain/GameRun;->drawMoney(IIIZ)V
  .line 151
    return-void
  :L4
  .line 140
  .restart local v16
  .restart local v28
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v17
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v5, v5, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;
    aget-object v5, v5, v28
    invoke-virtual { v5 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v18
    add-int v5, v9, v11
    add-int/lit8 v5, v5, 15
    add-int/lit8 v5, v5, 25
    add-int/lit8 v19, v5, 26
  .line 141
    mul-int/lit8 v5, v28, 40
    add-int/lit8 v5, v5, 105
    const/4 v6, 2
    sub-int v20, v5, v6
    const/16 v21, 0
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->sel:B
    move v5, v0
    move v0, v5
    move/from16 v1, v28
    if-ne v0, v1, :L7
    const/4 v5, 0
    move/from16 v22, v5
  :L5
    const/16 v23, 1
  .line 140
    invoke-virtual/range { v17 .. v23 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 142
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;
    add-int v6, v9, v11
    add-int/lit8 v6, v6, 12
    add-int/lit8 v6, v6, 25
    mul-int/lit8 v8, v28, 40
    add-int/lit8 v8, v8, 105
    const/4 v10, 2
    sub-int/2addr v8, v10
    const/16 v10, 50
    sub-int v10, v11, v10
    const/16 v12, 40
    invoke-virtual { v5, v6, v8, v10, v12 }, Lmain/PointerKey;->isSelect(IIII)Z
    move-result v5
    if-eqz v5, :L6
  .line 143
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->sel:B
    move v5, v0
    move v0, v5
    move/from16 v1, v28
    if-ne v0, v1, :L8
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;
    invoke-virtual { v5 }, Lmain/PointerKey;->setKey5()V
  :L6
  .line 139
    add-int/lit8 v28, v28, 1
    goto/16 :L1
  :L7
  .line 141
    const/4 v5, 3
    move/from16 v22, v5
    goto :L5
  :L8
  .line 144
    move/from16 v0, v28
    int-to-byte v0, v0
    move v5, v0
    move v0, v5
    move-object/from16 v1, p0
    iput-byte v0, v1, Lminigame/Guess;->sel:B
    goto :L6
.end method

.method private drawGame()V
  .registers 25
  .prologue
  .line 50
    const/16 v15, 640
  .local v15, "WIDTH":I
    const/16 v14, 360
  .line 51
  .local v14, "HEIGHT":I
    const/16 v7, 320
  .line 53
  .local v7, "WIDTH_H":I
    const/16 v21, 240
  .local v21, "width":I
    const/16 v18, 320
  .line 54
  .local v18, "height":I
    const/16 v22, 202
  .local v22, "x":I
    const/16 v23, 32
  .local v23, "y":I
    const/4 v5, 4
    sub-int v20, v21, v5
  .local v20, "w":I
    const/4 v5, 4
    sub-int v17, v18, v5
  .local v17, "h":I
    const/16 v16, 29
  .line 55
  .local v16, "fh":I
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v8, "\u80dc\u5229\u6b21\u6570\uff1a"
    invoke-direct { v6, v8 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->winNum:B
    move v8, v0
    invoke-virtual { v6, v8 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v8, "/"
    invoke-virtual { v6, v8 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gameData:[[B
    move-object v8, v0
    const/4 v9, 3
    aget-object v8, v8, v9
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->lv:B
    move v9, v0
    aget-byte v8, v8, v9
    invoke-virtual { v6, v8 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual { v6 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const/4 v8, 4
    const/16 v9, 17
    const/4 v10, 3
    const/4 v11, 1
    invoke-virtual/range { v5 .. v11 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 65
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->state:B
    move v5, v0
    const/4 v6, 1
    if-ne v5, v6, :L9
  .line 66
    sget-object v5, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const/16 v6, 65
    const/16 v7, 100
    move-object v0, v5
    move/from16 v1, v22
    move v2, v6
    move/from16 v3, v21
    move v4, v7
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V
  .line 67
  .end local v7
    const/16 v19, 0
  :L0
  .local v19, "i":I
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    array-length v5, v5
    move/from16 v0, v19
    move v1, v5
    if-lt v0, v1, :L3
  .line 71
    sget-object v5, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual { v5, v6, v7, v15, v14 }, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V
  .line 72
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->time:B
    move v5, v0
    const/16 v6, 20
    if-lt v5, v6, :L2
  .line 73
    const/16 v19, 0
  :L1
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    array-length v5, v5
    move/from16 v0, v19
    move v1, v5
    if-lt v0, v1, :L8
  :L2
  .line 117
  .end local v19
    return-void
  :L3
  .line 68
  .restart local v19
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    aget-object v5, v5, v19
    const/4 v6, 1
    aget v5, v5, v6
    const/4 v6, -1
    if-ne v5, v6, :L5
  :L4
  .line 67
    add-int/lit8 v19, v19, 1
    goto :L0
  :L5
  .line 69
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    aget-object v5, v5, v19
    const/4 v6, 1
    aget v5, v5, v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v6, v0
    aget-object v6, v6, v19
    const/4 v7, 2
    aget v6, v6, v7
    add-int v6, v6, v22
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->time:B
    move v7, v0
    const/16 v8, 40
    if-ge v7, v8, :L7
    const/4 v7, 0
  :L6
    add-int/lit16 v7, v7, 165
    move-object/from16 v0, p0
    move/from16 v1, v19
    move v2, v5
    move v3, v6
    move v4, v7
    invoke-direct { v0, v1, v2, v3, v4 }, Lminigame/Guess;->drawMon(IIII)V
    goto :L4
  :L7
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->mon_size_move:B
    move v7, v0
    goto :L6
  :L8
  .line 74
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
    move-object v6, v0
    const/4 v7, 1
    aget-object v6, v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v7, v0
    aget-object v7, v7, v19
    const/4 v8, 2
    aget v7, v7, v8
    add-int v7, v7, v22
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v8, v0
    aget-object v8, v8, v19
    const/4 v9, 3
    aget v8, v8, v9
    const/16 v9, 17
    invoke-virtual { v5, v6, v7, v8, v9 }, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V
  .line 73
    add-int/lit8 v19, v19, 1
    goto :L1
  :L9
  .line 76
  .end local v19
  .restart local v7
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->state:B
    move v5, v0
    const/4 v6, 2
    if-ne v5, v6, :L11
  .line 77
    const/16 v19, 0
  :L10
  .end local v7
  .restart local v19
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    array-length v5, v5
    move/from16 v0, v19
    move v1, v5
    if-ge v0, v1, :L2
  .line 78
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
    move-object v6, v0
    const/4 v7, 1
    aget-object v6, v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v7, v0
    aget-object v7, v7, v19
    const/4 v8, 2
    aget v7, v7, v8
    add-int v7, v7, v22
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v8, v0
    aget-object v8, v8, v19
    const/4 v9, 3
    aget v8, v8, v9
    const/16 v9, 17
    invoke-virtual { v5, v6, v7, v8, v9 }, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V
  .line 77
    add-int/lit8 v19, v19, 1
    goto :L10
  :L11
  .line 79
  .end local v19
  .restart local v7
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->state:B
    move v5, v0
    const/4 v6, 3
    if-ne v5, v6, :L18
  .line 80
    const/16 v19, 0
  :L12
  .end local v7
  .restart local v19
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    array-length v5, v5
    move/from16 v0, v19
    move v1, v5
    if-lt v0, v1, :L15
  .line 89
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
    move-object v6, v0
    const/4 v7, 0
    aget-object v6, v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v7, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v8, v0
    iget-byte v8, v8, Lmain/GameRun;->selectx:B
    aget-object v7, v7, v8
    const/4 v8, 2
    aget v7, v7, v8
    add-int v7, v7, v22
    const/4 v8, 1
    sub-int/2addr v7, v8
  .line 90
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v8, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v9, v0
    iget-byte v9, v9, Lmain/GameRun;->selectx:B
    aget-object v8, v8, v9
    const/4 v9, 3
    aget v8, v8, v9
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->time:B
    move v9, v0
    rem-int/lit8 v9, v9, 4
    const/4 v10, 2
    if-gt v9, v10, :L17
    const/4 v9, 5
  :L13
    sub-int/2addr v8, v9
    const/16 v9, 17
  .line 89
    invoke-virtual { v5, v6, v7, v8, v9 }, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V
  .line 91
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->time:B
    move v5, v0
    add-int/lit8 v5, v5, 1
    int-to-byte v5, v5
    move v0, v5
    move-object/from16 v1, p0
    iput-byte v0, v1, Lminigame/Guess;->time:B
    const/16 v6, 20
    if-le v5, v6, :L14
    const/4 v5, 0
    move v0, v5
    move-object/from16 v1, p0
    iput-byte v0, v1, Lminigame/Guess;->time:B
  :L14
  .line 92
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v6, v0
    iget-byte v6, v6, Lmain/GameRun;->selecty:B
    aget-object v5, v5, v6
    const/4 v6, 0
    aget v5, v5, v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v6, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v7, v0
    iget-byte v7, v7, Lmain/GameRun;->selecty:B
    aget-object v6, v6, v7
    const/4 v7, 1
    aget v6, v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gameData:[[B
    move-object v7, v0
    const/4 v8, 0
    aget-object v7, v7, v8
    const/4 v8, 1
    aget-byte v7, v7, v8
    add-int v7, v7, v22
    add-int/lit8 v7, v7, 100
    const/16 v8, 135
    move-object/from16 v0, p0
    move v1, v5
    move v2, v6
    move v3, v7
    move v4, v8
    invoke-direct { v0, v1, v2, v3, v4 }, Lminigame/Guess;->drawMon(IIII)V
  .line 94
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v8, v0
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "\u8bf7\u6307\u51fa"
    invoke-direct { v5, v6 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v6, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v7, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v9, v0
    iget-byte v9, v9, Lmain/GameRun;->selecty:B
    aget-object v7, v7, v9
    const/4 v9, 1
    aget v7, v7, v9
    invoke-virtual { v6, v7 }, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;
    move-result-object v6
    invoke-virtual { v5, v6 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, "\u6240\u5728\u7bb1\u5b50"
    invoke-virtual { v5, v6 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual { v5 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
  .line 95
    add-int v5, v22, v21
    add-int/lit8 v10, v5, 90
    mul-int/lit8 v11, v16, 5
    const/4 v12, 6
    const/4 v13, 0
  .line 94
    invoke-virtual/range { v8 .. v13 }, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V
    goto/16 :L2
  :L15
  .line 82
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v6, v0
    aget-object v6, v6, v19
    const/4 v7, 2
    aget v6, v6, v7
    add-int v6, v6, v22
    const/16 v7, 20
    sub-int/2addr v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v7, v0
    aget-object v7, v7, v19
    const/4 v8, 3
    aget v7, v7, v8
    const/16 v8, 40
    const/16 v9, 40
    invoke-virtual { v5, v6, v7, v8, v9 }, Lmain/PointerKey;->isSelect(IIII)Z
    move-result v5
    if-eqz v5, :L16
  .line 83
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    move/from16 v0, v19
    int-to-byte v0, v0
    move v6, v0
    iput-byte v6, v5, Lmain/GameRun;->selectx:B
  .line 84
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;
    invoke-virtual { v5 }, Lmain/PointerKey;->setKey5()V
  :L16
  .line 87
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
    move-object v6, v0
    const/4 v7, 1
    aget-object v6, v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v7, v0
    aget-object v7, v7, v19
    const/4 v8, 2
    aget v7, v7, v8
    add-int v7, v7, v22
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v8, v0
    aget-object v8, v8, v19
    const/4 v9, 3
    aget v8, v8, v9
    const/16 v9, 17
    invoke-virtual { v5, v6, v7, v8, v9 }, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V
  .line 80
    add-int/lit8 v19, v19, 1
    goto/16 :L12
  :L17
  .line 90
    const/4 v9, 0
    goto/16 :L13
  :L18
  .line 101
  .end local v19
  .restart local v7
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->state:B
    move v5, v0
    const/4 v6, 4
    if-ne v5, v6, :L2
  .line 102
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v6, v0
    iget-byte v6, v6, Lmain/GameRun;->selecty:B
    aget-object v5, v5, v6
    const/4 v6, 0
    aget v5, v5, v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v6, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v7, v0
  .end local v7
    iget-byte v7, v7, Lmain/GameRun;->selecty:B
    aget-object v6, v6, v7
    const/4 v7, 1
    aget v6, v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gameData:[[B
    move-object v7, v0
    const/4 v8, 0
    aget-object v7, v7, v8
    const/4 v8, 1
    aget-byte v7, v7, v8
    add-int v7, v7, v22
    add-int/lit8 v7, v7, 100
    const/16 v8, 135
    move-object/from16 v0, p0
    move v1, v5
    move v2, v6
    move v3, v7
    move v4, v8
    invoke-direct { v0, v1, v2, v3, v4 }, Lminigame/Guess;->drawMon(IIII)V
  .line 103
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
    move-object v6, v0
    const/4 v7, 1
    aget-object v6, v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v7, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v8, v0
    iget-byte v8, v8, Lmain/GameRun;->selectx:B
    aget-object v7, v7, v8
    const/4 v8, 2
    aget v7, v7, v8
    add-int v7, v7, v22
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v8, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v9, v0
    iget-byte v9, v9, Lmain/GameRun;->selectx:B
    aget-object v8, v8, v9
    const/4 v9, 3
    aget v8, v8, v9
    const/16 v9, 17
    invoke-virtual { v5, v6, v7, v8, v9 }, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V
  .line 105
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v6, v0
    iget-byte v6, v6, Lmain/GameRun;->selectx:B
    aget-object v5, v5, v6
    const/4 v6, 1
    aget v5, v5, v6
    const/4 v6, -1
    if-eq v5, v6, :L19
  .line 106
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v5, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v6, v0
    iget-byte v6, v6, Lmain/GameRun;->selectx:B
    aget-object v5, v5, v6
    const/4 v6, 0
    aget v5, v5, v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v6, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v7, v0
    iget-byte v7, v7, Lmain/GameRun;->selectx:B
    aget-object v6, v6, v7
    const/4 v7, 1
    aget v6, v6, v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v7, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v8, v0
    iget-byte v8, v8, Lmain/GameRun;->selectx:B
    aget-object v7, v7, v8
    const/4 v8, 2
    aget v7, v7, v8
    add-int v7, v7, v22
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->box:[[I
    move-object v8, v0
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v9, v0
    iget-byte v9, v9, Lmain/GameRun;->selectx:B
    aget-object v8, v8, v9
    const/4 v9, 3
    aget v8, v8, v9
    add-int/lit8 v8, v8, 35
    move-object/from16 v0, p0
    move v1, v5
    move v2, v6
    move v3, v7
    move v4, v8
    invoke-direct { v0, v1, v2, v3, v4 }, Lminigame/Guess;->drawMon(IIII)V
  :L19
  .line 108
    move-object/from16 v0, p0
    iget-byte v0, v0, Lminigame/Guess;->b_win:B
    move v5, v0
    if-lez v5, :L21
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v8, v0
    const-string v9, "\u60a8\u771f\u5389\u5bb3\uff01"
    add-int v5, v22, v21
    add-int/lit8 v10, v5, 90
    mul-int/lit8 v11, v16, 5
    const/4 v12, 6
    const/4 v13, 0
    invoke-virtual/range { v8 .. v13 }, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V
  :L20
  .line 110
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v8, v0
    const-string v9, "\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed"
    add-int v5, v22, v21
    add-int/lit8 v10, v5, 90
    mul-int/lit8 v11, v16, 7
    const/4 v12, 6
    const/4 v13, 0
    invoke-virtual/range { v8 .. v13 }, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V
  .line 111
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual { v5, v6, v7, v15, v14 }, Lmain/PointerKey;->isSelect(IIII)Z
    move-result v5
    if-eqz v5, :L2
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v5, v0
    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;
    invoke-virtual { v5 }, Lmain/PointerKey;->setKey5()V
    goto/16 :L2
  :L21
  .line 109
    move-object/from16 v0, p0
    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;
    move-object v8, v0
    const-string v9, "\u8bf4\u4e0d\u5b9a\u4e0b\u6b21\u5c31\u80fd\u884c\u7684\u3002"
    add-int v5, v22, v21
    add-int/lit8 v10, v5, 90
    mul-int/lit8 v11, v16, 5
    const/4 v12, 6
    const/4 v13, 0
    invoke-virtual/range { v8 .. v13 }, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V
    goto :L20
.end method

.method private drawMon(IIII)V
  .parameter "i" # I
  .parameter "id" # I
  .parameter "x" # I
  .parameter "y" # I
  .registers 11
  .prologue
    const/4 v5, 0
  .line 175
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-object v1, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;
    aget-object v1, v1, p1
    iget-object v2, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;
    aget-object v2, v2, p1
    iget-object v3, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v3, v3, Lmain/GameRun;->mList_id:[[B
    aget-object v3, v3, p2
    const/4 v4, 1
    aget-byte v3, v3, v4
    mul-int/lit8 v3, v3, 3
    invoke-virtual { v2, v3, v5, v5 }, Ldm/Sprite;->action(III)I
    move-result v2
    move v3, p3
    move v4, p4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V
  .line 176
    return-void
.end method

.method private getGameMonList()[B
  .registers 12
  .prologue
    const/4 v10, 3
    const/4 v9, 2
    const/4 v7, 1
    const/4 v8, -1
    const/4 v6, 4
  .line 437
    new-array v1, v10, [B
  .line 439
  .local v1, "monList":[B
    const/4 v0, 0
  :L0
  .local v0, "i":B
    array-length v4, v1
    if-lt v0, v4, :L3
  .line 441
    const/4 v0, 0
  :L1
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B
    aget-object v4, v4, v9
    iget-byte v5, p0, Lminigame/Guess;->lv:B
    aget-byte v4, v4, v5
    if-lt v0, v4, :L4
  .line 452
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    invoke-static { v9 }, Ldm/Ms;->getRandom(I)I
    move-result v4
    int-to-byte v0, v4
  .line 453
    array-length v4, v1
    sub-int/2addr v4, v7
    aget-byte v2, v1, v4
  .line 454
  .local v2, "n":B
    array-length v4, v1
    sub-int/2addr v4, v7
    aget-byte v5, v1, v0
    aput-byte v5, v1, v4
  .line 455
    aput-byte v2, v1, v0
  .line 458
    const/4 v0, 0
  :L2
    if-lt v0, v10, :L8
  .line 463
    return-object v1
  :L3
  .line 440
  .end local v2
    aput-byte v8, v1, v0
  .line 439
    add-int/lit8 v4, v0, 1
    int-to-byte v0, v4
    goto :L0
  :L4
  .line 442
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B
    aget-object v4, v4, v6
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-object v5, p0, Lminigame/Guess;->gameData:[[B
    aget-object v5, v5, v6
    array-length v5, v5
    invoke-static { v5 }, Ldm/Ms;->getRandom(I)I
    move-result v5
    aget-byte v4, v4, v5
    aput-byte v4, v1, v0
  .line 443
    const/4 v2, 0
  :L5
  .line 444
  .restart local v2
    if-lt v2, v0, :L6
  .line 441
    add-int/lit8 v4, v0, 1
    int-to-byte v0, v4
    goto :L1
  :L6
  .line 445
    aget-byte v4, v1, v2
    aget-byte v5, v1, v0
    if-ne v4, v5, :L7
  .line 446
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B
    aget-object v4, v4, v6
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-object v5, p0, Lminigame/Guess;->gameData:[[B
    aget-object v5, v5, v6
    array-length v5, v5
    invoke-static { v5 }, Ldm/Ms;->getRandom(I)I
    move-result v5
    aget-byte v4, v4, v5
    aput-byte v4, v1, v0
  .line 447
    const/4 v2, 0
    goto :L5
  :L7
  .line 448
    add-int/lit8 v4, v2, 1
    int-to-byte v2, v4
    goto :L5
  :L8
  .line 459
    aget-byte v4, v1, v0
    if-ne v4, v8, :L10
  :L9
  .line 458
    add-int/lit8 v4, v0, 1
    int-to-byte v0, v4
    goto :L2
  :L10
  .line 460
    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v4, v4, Lmain/GameRun;->mList_id:[[B
    aget-byte v5, v1, v0
    aget-object v4, v4, v5
    const/4 v5, 0
    aget-byte v3, v4, v5
  .line 461
  .local v3, "t":B
    iget-object v4, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v5
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "data/npc2/"
    invoke-direct { v6, v7 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v6, v3 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual { v6 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    iget-object v7, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    invoke-virtual { v7, v3 }, Lmain/GameRun;->isNpc2ImageType(I)Z
    move-result v7
    invoke-virtual { v5, v6, v7 }, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;
    move-result-object v5
    aput-object v5, v4, v0
    goto :L9
.end method

.method private initGame()V
  .registers 8
  .prologue
    const/4 v6, 3
    const/4 v5, 0
  .line 417
    invoke-direct { p0 }, Lminigame/Guess;->getGameMonList()[B
    move-result-object v1
  .line 418
  .local v1, "monList":[B
    const/4 v0, 0
  :L0
  .local v0, "i":B
    if-lt v0, v6, :L1
  .line 425
    const/4 v1, 0
    check-cast v1, [B
  .line 426
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-byte v2, p0, Lminigame/Guess;->lv:B
    add-int/lit8 v2, v2, 2
    invoke-static { v2 }, Ldm/Ms;->getRandom(I)I
    move-result v2
    add-int/lit8 v2, v2, 2
    iget-byte v3, p0, Lminigame/Guess;->lv:B
    add-int/2addr v2, v3
    int-to-byte v2, v2
    iput-byte v2, p0, Lminigame/Guess;->maxTransNum:B
  .line 427
    iput-byte v5, p0, Lminigame/Guess;->transNum:B
  .line 428
    iput-byte v5, p0, Lminigame/Guess;->mon_size_move:B
  .line 434
    return-void
  :L1
  .line 419
    iget-object v2, p0, Lminigame/Guess;->box:[[I
    aget-object v2, v2, v0
    aput v0, v2, v5
  .line 420
    iget-object v2, p0, Lminigame/Guess;->box:[[I
    aget-object v2, v2, v0
    const/4 v3, 1
    aget-byte v4, v1, v0
    aput v4, v2, v3
  .line 421
    iget-object v2, p0, Lminigame/Guess;->box:[[I
    aget-object v2, v2, v0
    const/4 v3, 2
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B
    aget-object v4, v4, v5
    aget-byte v4, v4, v0
    add-int/lit8 v4, v4, 100
    aput v4, v2, v3
  .line 422
    iget-object v2, p0, Lminigame/Guess;->box:[[I
    aget-object v2, v2, v0
    aput v5, v2, v6
  .line 418
    add-int/lit8 v2, v0, 1
    int-to-byte v0, v2
    goto :L0
.end method

.method private win()B
  .registers 10
  .prologue
    const/16 v8, 11
    const/4 v7, 3
    const/4 v6, 2
  .line 337
    iget-byte v1, p0, Lminigame/Guess;->winNum:B
    add-int/lit8 v1, v1, 1
    int-to-byte v1, v1
    iput-byte v1, p0, Lminigame/Guess;->winNum:B
    iget-object v2, p0, Lminigame/Guess;->gameData:[[B
    aget-object v2, v2, v7
    iget-byte v3, p0, Lminigame/Guess;->lv:B
    aget-byte v2, v2, v3
    if-lt v1, v2, :L2
  .line 338
    iget v1, p0, Lminigame/Guess;->sell_money:I
    iget-byte v2, p0, Lminigame/Guess;->lv:B
    iget-byte v3, p0, Lminigame/Guess;->lv:B
    mul-int/2addr v2, v3
    mul-int/lit16 v2, v2, 150
    add-int/2addr v1, v2
    iget-byte v2, p0, Lminigame/Guess;->lv:B
    sub-int v2, v6, v2
    mul-int/lit8 v2, v2, 25
    add-int v0, v1, v2
  .line 339
  .local v0, "tm":I
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget v2, v1, Lmain/GameRun;->money:I
    add-int/2addr v2, v0
    iput v2, v1, Lmain/GameRun;->money:I
  .line 340
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "\u83b7\u5f97\u91d1\u94b1\uff1a"
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v2, v0 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    invoke-virtual { v1, v2, v3 }, Lmain/GameRun;->say(Ljava/lang/String;I)V
  .line 341
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v1, v1, Lmain/GameRun;->rmsOther:[B
    const/16 v2, 10
    aget-byte v3, v1, v2
    const/4 v4, 1
    iget-byte v5, p0, Lminigame/Guess;->lv:B
    shl-int/2addr v4, v5
    or-int/2addr v3, v4
    int-to-byte v3, v3
    aput-byte v3, v1, v2
  .line 342
    iget-byte v1, p0, Lminigame/Guess;->lv:B
    if-ne v1, v6, :L0
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v1, v1, Lmain/GameRun;->rmsOther:[B
    aget-byte v1, v1, v8
    if-ge v1, v7, :L0
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v1, v1, Lmain/GameRun;->rmsOther:[B
    aget-byte v2, v1, v8
    add-int/lit8 v2, v2, 1
    int-to-byte v2, v2
    aput-byte v2, v1, v8
  :L0
    move v1, v6
  :L1
  .line 345
  .end local v0
    return v1
  :L2
    move v1, v7
    goto :L1
.end method

.method public go(I)V
  .parameter "mode" # I
  .registers 4
  .prologue
    const/4 v0, 1
    const/4 v1, 0
  .line 400
    if-ge p1, v0, :L1
  .line 401
    iput-byte v1, p0, Lminigame/Guess;->b_win:B
  .line 402
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iput-byte v1, v0, Lmain/GameRun;->selecty:B
  .line 403
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iput-byte v1, v0, Lmain/GameRun;->selectx:B
  .line 404
    iput-byte v1, p0, Lminigame/Guess;->winNum:B
  .line 405
    iput-byte v1, p0, Lminigame/Guess;->state:B
  .line 406
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iput-byte v1, v0, Lmain/GameRun;->buyOk:B
  .line 407
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    const/16 v1, 9
    iput-byte v1, v0, Lmain/GameRun;->line_max:B
  .line 408
    iget-byte v0, p0, Lminigame/Guess;->lv:B
    mul-int/lit16 v0, v0, 200
    add-int/lit16 v0, v0, 200
    iput v0, p0, Lminigame/Guess;->sell_money:I
  .line 409
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v0, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;
    array-length v0, v0
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v1, v1, Lmain/GameRun;->line_max:B
    sub-int/2addr v0, v1
    int-to-byte v0, v0
    iput-byte v0, p0, Lminigame/Guess;->length:B
  :L0
  .line 415
    return-void
  :L1
  .line 411
    iput-byte v1, p0, Lminigame/Guess;->time:B
  .line 412
    iput-byte v0, p0, Lminigame/Guess;->state:B
  .line 413
    invoke-direct { p0 }, Lminigame/Guess;->initGame()V
    goto :L0
.end method

.method public go(II)V
  .parameter "mode" # I
  .parameter "lv_" # I
  .registers 11
  .prologue
    const/4 v7, 2
    const/4 v6, 1
    const/4 v5, 0
    const/4 v4, 4
    const/4 v3, 3
  .line 368
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    const-string v2, "data/gamed.d"
    invoke-virtual { v1, v2 }, Lmain/GameRun;->createString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const/16 v2, 180
    invoke-virtual { v0, v1, v2, v5 }, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V
  .line 369
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    const-string v1, "\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f"
    sget v2, Lmain/Constants_H;->WIDTH:I
    invoke-virtual { v0, v1, v2, v6 }, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V
  .line 374
    int-to-byte v0, p2
    iput-byte v0, p0, Lminigame/Guess;->lv:B
  .line 375
    new-array v0, v7, [Ljavax/microedition/lcdui/Image;
    iput-object v0, p0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
  .line 376
    iget-object v0, p0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const-string v2, "data/brow/m2"
    invoke-virtual { v1, v2 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v1
    aput-object v1, v0, v5
  .line 377
    iget-object v0, p0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const-string v2, "data/brow/m3"
    invoke-virtual { v1, v2 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v1
    aput-object v1, v0, v6
  .line 378
    new-array v0, v7, [B
    iput-object v0, p0, Lminigame/Guess;->boxNum:[B
  .line 379
    const/4 v0, 5
    new-array v0, v0, [[B
  .line 383
    new-array v1, v3, [B
    fill-array-data v1, :L0
    aput-object v1, v0, v5
  .line 385
    new-array v1, v4, [B
    fill-array-data v1, :L1
    aput-object v1, v0, v6
  .line 386
    new-array v1, v4, [B
    fill-array-data v1, :L2
    aput-object v1, v0, v7
  .line 387
    new-array v1, v4, [B
    fill-array-data v1, :L3
    aput-object v1, v0, v3
  .line 388
    new-array v1, v3, [B
    fill-array-data v1, :L4
    aput-object v1, v0, v4
  .line 379
    iput-object v0, p0, Lminigame/Guess;->gameData:[[B
  .line 394
    filled-new-array { v3, v4 }, [I
    move-result-object v0
    sget-object v1, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;
    invoke-static { v1, v0 }, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [[I
    iput-object v0, p0, Lminigame/Guess;->box:[[I
  .line 395
    new-array v0, v3, [Ldm/Sprite;
    iput-object v0, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;
  .line 396
    invoke-virtual { p0, p1 }, Lminigame/Guess;->go(I)V
  .line 397
    return-void
  .line 383
  .line 385
  .line 386
  .line 387
  .line 388
  :L0
  .array-data 1
    -60t
    17t
    90t
  .end array-data
  :L1
  .array-data 1
    8t
    13t
    20t
    30t
  .end array-data
  :L2
  .array-data 1
    1t
    2t
    3t
    3t
  .end array-data
  :L3
  .array-data 1
    6t
    4t
    2t
    2t
  .end array-data
  :L4
  .array-data 1
    83t
    30t
    55t
  .end array-data
.end method

.method public key()Z
  .registers 8
  .prologue
    const/4 v6, 3
    const/4 v3, -1
    const/4 v5, 0
    const/4 v4, 1
    const/4 v2, 0
  .line 267
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_delay()Z
    move-result v0
    if-eqz v0, :L1
    move v0, v5
  :L0
  .line 334
    return v0
  :L1
  .line 268
    iget-byte v0, p0, Lminigame/Guess;->state:B
    if-nez v0, :L6
  .line 270
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Up_Down()Z
    move-result v0
    if-eqz v0, :L3
  .line 271
    iget-byte v0, p0, Lminigame/Guess;->sel:B
    xor-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    iput-byte v0, p0, Lminigame/Guess;->sel:B
  :L2
    move v0, v5
  .line 334
    goto :L0
  :L3
  .line 272
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S1_Num5()Z
    move-result v0
    if-eqz v0, :L5
  .line 273
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 274
    iget-byte v0, p0, Lminigame/Guess;->sel:B
    if-nez v0, :L4
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget v1, p0, Lminigame/Guess;->sell_money:I
    invoke-virtual { v0, v1, v4 }, Lmain/GameRun;->isMoney(IZ)Z
    move-result v0
    if-eqz v0, :L4
    iget-byte v0, p0, Lminigame/Guess;->lv:B
    invoke-virtual { p0, v4, v0 }, Lminigame/Guess;->go(II)V
    goto :L2
  :L4
  .line 275
    iget-byte v0, p0, Lminigame/Guess;->sel:B
    if-ne v0, v4, :L2
  .line 276
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 277
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iput-object v2, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;
  .line 278
    iput-object v2, p0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
  .line 279
    iput-object v2, p0, Lminigame/Guess;->boxNum:[B
  .line 280
    iput-object v2, p0, Lminigame/Guess;->gameData:[[B
  .line 281
    iput-object v2, p0, Lminigame/Guess;->box:[[I
  .line 282
    iput-object v2, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;
    move v0, v4
  .line 283
    goto :L0
  :L5
  .line 296
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S2()Z
    move-result v0
    if-eqz v0, :L2
  .line 297
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 298
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iput-object v2, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;
  .line 299
    iput-object v2, p0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;
  .line 300
    iput-object v2, p0, Lminigame/Guess;->boxNum:[B
  .line 301
    iput-object v2, p0, Lminigame/Guess;->gameData:[[B
  .line 302
    iput-object v2, p0, Lminigame/Guess;->box:[[I
  .line 303
    iput-object v2, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;
    move v0, v4
  .line 304
    goto :L0
  :L6
  .line 307
    iget-byte v0, p0, Lminigame/Guess;->state:B
    if-ne v0, v6, :L10
  .line 308
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Left_Right()Z
    move-result v0
    if-eqz v0, :L7
  .line 309
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    iget-object v2, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v2, v2, Lmain/GameRun;->selectx:B
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    array-length v3, v3
    sub-int/2addr v3, v4
    invoke-virtual { v1, v2, v5, v3 }, Ldm/Ms;->select(III)B
    move-result v1
    iput-byte v1, v0, Lmain/GameRun;->selectx:B
    goto/16 :L2
  :L7
  .line 310
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S1_Num5()Z
    move-result v0
    if-eqz v0, :L2
  .line 311
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 312
    const/4 v0, 4
    iput-byte v0, p0, Lminigame/Guess;->state:B
  .line 313
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v0, v0, Lmain/GameRun;->selectx:B
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v1, v1, Lmain/GameRun;->selecty:B
    if-ne v0, v1, :L9
    move v0, v4
  :L8
    int-to-byte v0, v0
    iput-byte v0, p0, Lminigame/Guess;->b_win:B
    goto/16 :L2
  :L9
    move v0, v3
    goto :L8
  :L10
  .line 316
    iget-byte v0, p0, Lminigame/Guess;->state:B
    const/4 v1, 4
    if-ne v0, v1, :L2
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_S1_Num5()Z
    move-result v0
    if-eqz v0, :L2
  .line 317
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 318
    iget-byte v0, p0, Lminigame/Guess;->b_win:B
    if-ne v0, v4, :L11
  .line 319
    invoke-direct { p0 }, Lminigame/Guess;->win()B
    move-result v0
    iput-byte v0, p0, Lminigame/Guess;->b_win:B
  .line 320
    iget-byte v0, p0, Lminigame/Guess;->b_win:B
    if-ne v0, v6, :L2
    iget-byte v0, p0, Lminigame/Guess;->lv:B
    invoke-virtual { p0, v4, v0 }, Lminigame/Guess;->go(II)V
    goto/16 :L2
  :L11
  .line 322
    iget-byte v0, p0, Lminigame/Guess;->b_win:B
    if-eq v0, v3, :L12
    iget-byte v0, p0, Lminigame/Guess;->b_win:B
    const/4 v1, 2
    if-ne v0, v1, :L2
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v0, v0, Lmain/GameRun;->say_c:B
    if-nez v0, :L2
  :L12
  .line 325
    iget-byte v0, p0, Lminigame/Guess;->b_win:B
    const/4 v1, 2
    if-ne v0, v1, :L14
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B
    const/16 v1, 11
    aget-byte v0, v0, v1
    if-ne v0, v6, :L14
  .line 326
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B
    const/16 v1, 11
    const/4 v2, 4
    aput-byte v2, v0, v1
  .line 327
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    const/16 v1, 83
    const/16 v2, 25
    invoke-virtual { v0, v1, v2, v5, v3 }, Lmain/GameRun;->getMonster(IIII)B
  :L13
  .line 331
    iget-byte v0, p0, Lminigame/Guess;->lv:B
    invoke-virtual { p0, v5, v0 }, Lminigame/Guess;->go(II)V
    goto/16 :L2
  :L14
  .line 328
    iget-byte v0, p0, Lminigame/Guess;->b_win:B
    if-ne v0, v3, :L13
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B
    const/16 v1, 11
    aget-byte v0, v0, v1
    if-ge v0, v6, :L13
  .line 329
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B
    const/16 v1, 11
    aput-byte v5, v0, v1
    goto :L13
.end method

.method public patin()V
  .registers 6
  .prologue
  .line 26
    const/16 v2, 640
  .local v2, "WIDTH":I
    const/16 v0, 360
  .line 27
  .local v0, "HEIGHT":I
    const/16 v3, 320
  .local v3, "WIDTH_H":I
    const/16 v1, 180
  .line 28
  .local v1, "HEIGHT_H":I
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v4
    invoke-virtual { v4 }, Ldm/Ui;->fillRectB()V
  .line 30
    invoke-direct { p0 }, Lminigame/Guess;->draw()V
  .line 31
    iget-byte v4, p0, Lminigame/Guess;->state:B
    if-eqz v4, :L0
    invoke-direct { p0 }, Lminigame/Guess;->drawGame()V
  :L0
  .line 37
    return-void
.end method

.method public run()V
  .registers 13
  .prologue
    const/16 v11, 150
    const/4 v10, 3
    const/4 v9, 2
    const/4 v8, 1
    const/4 v7, 0
  .line 180
    iget-byte v3, p0, Lminigame/Guess;->state:B
    if-ne v3, v8, :L5
  .line 181
    iget-byte v3, p0, Lminigame/Guess;->time:B
    const/16 v4, 20
    if-ge v3, v4, :L1
  .line 182
    iget-byte v3, p0, Lminigame/Guess;->time:B
    add-int/lit8 v3, v3, 1
    int-to-byte v3, v3
    iput-byte v3, p0, Lminigame/Guess;->time:B
  :L0
  .line 264
    return-void
  :L1
  .line 185
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    aget-object v3, v3, v7
    aget v3, v3, v10
    if-ge v3, v11, :L3
  .line 186
    const/4 v0, 0
  :L2
  .local v0, "i":B
    if-ge v0, v10, :L0
  .line 187
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    aget-object v3, v3, v0
    aget v4, v3, v10
    add-int/lit8 v4, v4, 25
    aput v4, v3, v10
  .line 186
    add-int/lit8 v3, v0, 1
    int-to-byte v0, v3
    goto :L2
  :L3
  .line 190
  .end local v0
    iget-byte v3, p0, Lminigame/Guess;->time:B
    add-int/lit8 v3, v3, 1
    int-to-byte v3, v3
    iput-byte v3, p0, Lminigame/Guess;->time:B
    const/16 v4, 40
    if-lt v3, v4, :L0
  .line 191
    iget-byte v3, p0, Lminigame/Guess;->mon_size_move:B
    const/16 v4, 40
    if-ge v3, v4, :L4
  .line 192
    iget-byte v3, p0, Lminigame/Guess;->mon_size_move:B
    add-int/lit8 v3, v3, 5
    int-to-byte v3, v3
    iput-byte v3, p0, Lminigame/Guess;->mon_size_move:B
    goto :L0
  :L4
  .line 194
    iput-byte v9, p0, Lminigame/Guess;->state:B
  .line 196
    iput-byte v7, p0, Lminigame/Guess;->time:B
    goto :L0
  :L5
  .line 202
    iget-byte v3, p0, Lminigame/Guess;->state:B
    if-ne v3, v9, :L18
  .line 203
    iget-byte v3, p0, Lminigame/Guess;->time:B
    if-gtz v3, :L10
  .line 204
    iget-byte v3, p0, Lminigame/Guess;->transNum:B
    iget-byte v4, p0, Lminigame/Guess;->maxTransNum:B
    if-ge v3, v4, :L8
  .line 205
    iput-byte v8, p0, Lminigame/Guess;->time:B
  .line 206
    iget-byte v3, p0, Lminigame/Guess;->transNum:B
    add-int/lit8 v3, v3, 1
    int-to-byte v3, v3
    iput-byte v3, p0, Lminigame/Guess;->transNum:B
  .line 207
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    invoke-static { v10 }, Ldm/Ms;->getRandom(I)I
    move-result v4
    int-to-byte v4, v4
    aput-byte v4, v3, v7
  :L6
  .line 208
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    invoke-static { v10 }, Ldm/Ms;->getRandom(I)I
    move-result v4
    int-to-byte v4, v4
    aput-byte v4, v3, v8
  .line 209
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v3, v3, v8
    iget-object v4, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v4, v4, v7
    if-eq v3, v4, :L6
  .line 211
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v4, v4, v8
    aget-object v3, v3, v4
    aget v3, v3, v9
    iget-object v4, p0, Lminigame/Guess;->box:[[I
    iget-object v5, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v5, v5, v7
    aget-object v4, v4, v5
    aget v4, v4, v9
    if-ge v3, v4, :L7
  .line 212
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v3, v3, v8
    iput-byte v3, p0, Lminigame/Guess;->gameR:B
  .line 213
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B
    iget-object v4, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v4, v4, v7
    aput-byte v4, v3, v8
  .line 214
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B
    iget-byte v4, p0, Lminigame/Guess;->gameR:B
    aput-byte v4, v3, v7
  :L7
  .line 216
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v4, v4, v8
    aget-object v3, v3, v4
    aget v3, v3, v9
    iget-object v4, p0, Lminigame/Guess;->box:[[I
    iget-object v5, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v5, v5, v7
    aget-object v4, v4, v5
    aget v4, v4, v9
    sub-int/2addr v3, v4
    invoke-static { v3 }, Ldm/Ms;->abs(I)I
    move-result v3
    div-int/lit8 v3, v3, 2
    int-to-byte v3, v3
    iput-byte v3, p0, Lminigame/Guess;->gameR:B
  .line 217
    iget-byte v3, p0, Lminigame/Guess;->gameR:B
    mul-int/lit8 v3, v3, 2
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B
    aget-object v4, v4, v8
    iget-byte v5, p0, Lminigame/Guess;->lv:B
    aget-byte v4, v4, v5
    div-int/2addr v3, v4
    int-to-byte v3, v3
    iput-byte v3, p0, Lminigame/Guess;->tempTransNum:B
    goto/16 :L0
  :L8
  .line 220
    iput-byte v7, p0, Lminigame/Guess;->time:B
  .line 221
    iput-byte v10, p0, Lminigame/Guess;->state:B
  :L9
  .line 223
    iget-object v3, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-object v4, p0, Lminigame/Guess;->box:[[I
    array-length v4, v4
    invoke-static { v4 }, Ldm/Ms;->getRandom(I)I
    move-result v4
    int-to-byte v4, v4
    iput-byte v4, v3, Lmain/GameRun;->selecty:B
  .line 224
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v4, v4, Lmain/GameRun;->selecty:B
    aget-object v3, v3, v4
    aget v3, v3, v8
    const/4 v4, -1
    if-eq v3, v4, :L9
    goto/16 :L0
  :L10
  .line 230
    iget-byte v3, p0, Lminigame/Guess;->time:B
    iget-byte v4, p0, Lminigame/Guess;->tempTransNum:B
    if-le v3, v4, :L17
  .line 231
    iput-byte v7, p0, Lminigame/Guess;->time:B
  .line 232
    const/4 v3, 4
    new-array v2, v3, [I
  .line 233
  .local v2, "temp":[I
    const/4 v0, 0
  :L11
  .restart local v0
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    array-length v3, v3
    if-lt v0, v3, :L13
  .line 242
    const/4 v0, 0
  :L12
    if-ge v0, v10, :L0
  .line 243
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    aget-object v3, v3, v0
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B
    aget-object v4, v4, v7
    aget-byte v4, v4, v0
    add-int/lit8 v4, v4, 100
    aput v4, v3, v9
  .line 244
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    aget-object v3, v3, v0
    aput v11, v3, v10
  .line 242
    add-int/lit8 v3, v0, 1
    int-to-byte v0, v3
    goto :L12
  :L13
  .line 234
    const/4 v1, 0
  :L14
  .local v1, "j":B
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    array-length v3, v3
    if-lt v1, v3, :L15
  .line 233
    add-int/lit8 v3, v0, 1
    int-to-byte v0, v3
    goto :L11
  :L15
  .line 235
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    aget-object v3, v3, v1
    aget v3, v3, v9
    iget-object v4, p0, Lminigame/Guess;->box:[[I
    aget-object v4, v4, v0
    aget v4, v4, v9
    if-le v3, v4, :L16
  .line 236
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    aget-object v3, v3, v0
    array-length v4, v2
    invoke-static { v3, v7, v2, v7, v4 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  .line 237
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    aget-object v3, v3, v1
    iget-object v4, p0, Lminigame/Guess;->box:[[I
    aget-object v4, v4, v0
    iget-object v5, p0, Lminigame/Guess;->box:[[I
    aget-object v5, v5, v1
    array-length v5, v5
    invoke-static { v3, v7, v4, v7, v5 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  .line 238
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    aget-object v3, v3, v1
    array-length v4, v2
    invoke-static { v2, v7, v3, v7, v4 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  :L16
  .line 234
    add-int/lit8 v3, v1, 1
    int-to-byte v1, v3
    goto :L14
  :L17
  .line 250
  .end local v0
  .end local v1
  .end local v2
    iget-byte v3, p0, Lminigame/Guess;->time:B
    add-int/lit8 v3, v3, 1
    int-to-byte v3, v3
    iput-byte v3, p0, Lminigame/Guess;->time:B
  .line 251
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v4, v4, v7
    aget-object v3, v3, v4
    aget v4, v3, v9
    iget-byte v5, p0, Lminigame/Guess;->gameR:B
    mul-int/lit8 v5, v5, 2
    iget-byte v6, p0, Lminigame/Guess;->tempTransNum:B
    div-int/2addr v5, v6
    add-int/2addr v4, v5
    aput v4, v3, v9
  .line 252
    iget-byte v3, p0, Lminigame/Guess;->gameR:B
    mul-int/lit8 v3, v3, 2
    iget-byte v4, p0, Lminigame/Guess;->tempTransNum:B
    div-int/2addr v3, v4
    iget-byte v4, p0, Lminigame/Guess;->time:B
    mul-int v2, v3, v4
  .line 253
  .local v2, "temp":I
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v4, v4, v7
    aget-object v3, v3, v4
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v4
    iget-byte v5, p0, Lminigame/Guess;->gameR:B
    iget-byte v6, p0, Lminigame/Guess;->gameR:B
    mul-int/2addr v5, v6
    iget-byte v6, p0, Lminigame/Guess;->gameR:B
    sub-int v6, v2, v6
    iget-byte v7, p0, Lminigame/Guess;->gameR:B
    sub-int v7, v2, v7
    mul-int/2addr v6, v7
    sub-int/2addr v5, v6
    invoke-virtual { v4, v5 }, Ldm/Ms;->sqrt(I)I
    move-result v4
    sub-int v4, v11, v4
    aput v4, v3, v10
  .line 254
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v4, v4, v8
    aget-object v3, v3, v4
    aget v4, v3, v9
    iget-byte v5, p0, Lminigame/Guess;->gameR:B
    mul-int/lit8 v5, v5, 2
    iget-byte v6, p0, Lminigame/Guess;->tempTransNum:B
    div-int/2addr v5, v6
    sub-int/2addr v4, v5
    aput v4, v3, v9
  .line 255
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->boxNum:[B
    aget-byte v4, v4, v8
    aget-object v3, v3, v4
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v4
    iget-byte v5, p0, Lminigame/Guess;->gameR:B
    iget-byte v6, p0, Lminigame/Guess;->gameR:B
    mul-int/2addr v5, v6
    iget-byte v6, p0, Lminigame/Guess;->gameR:B
    sub-int v6, v2, v6
    iget-byte v7, p0, Lminigame/Guess;->gameR:B
    sub-int v7, v2, v7
    mul-int/2addr v6, v7
    sub-int/2addr v5, v6
    invoke-virtual { v4, v5 }, Ldm/Ms;->sqrt(I)I
    move-result v4
    add-int/lit16 v4, v4, 150
    aput v4, v3, v10
    goto/16 :L0
  :L18
  .line 258
  .end local v2
    iget-byte v3, p0, Lminigame/Guess;->state:B
    const/4 v4, 4
    if-ne v3, v4, :L0
  .line 259
    iget-object v3, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v3, v3, Lmain/GameRun;->selectx:B
    if-ne v3, v9, :L19
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v4, v4, Lmain/GameRun;->selectx:B
    aget-object v3, v3, v4
    aget v3, v3, v9
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B
    aget-object v4, v4, v7
    aget-byte v4, v4, v8
    add-int/lit8 v4, v4, 100
    if-gt v3, v4, :L20
  :L19
  .line 260
    iget-object v3, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v3, v3, Lmain/GameRun;->selectx:B
    if-nez v3, :L0
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v4, v4, Lmain/GameRun;->selectx:B
    aget-object v3, v3, v4
    aget v3, v3, v9
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B
    aget-object v4, v4, v7
    aget-byte v4, v4, v8
    add-int/lit8 v4, v4, 100
    if-ge v3, v4, :L0
  :L20
  .line 261
    iget-object v3, p0, Lminigame/Guess;->box:[[I
    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v4, v4, Lmain/GameRun;->selectx:B
    aget-object v3, v3, v4
    aget v4, v3, v9
    iget-object v5, p0, Lminigame/Guess;->gameData:[[B
    aget-object v5, v5, v7
    aget-byte v5, v5, v8
    iget-object v6, p0, Lminigame/Guess;->gameData:[[B
    aget-object v6, v6, v7
    iget-object v7, p0, Lminigame/Guess;->gr:Lmain/GameRun;
    iget-byte v7, v7, Lmain/GameRun;->selectx:B
    aget-byte v6, v6, v7
    sub-int/2addr v5, v6
    div-int/lit8 v5, v5, 7
    add-int/2addr v4, v5
    aput v4, v3, v9
    goto/16 :L0
.end method
