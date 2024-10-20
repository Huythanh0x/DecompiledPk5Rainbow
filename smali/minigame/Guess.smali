.class public Lminigame/Guess;
.super Ljava/lang/Object;
.source "Guess.java"

# interfaces
.implements Lminigame/MiniGame_H;


# instance fields
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


# direct methods
.method public constructor <init>(Lmain/GameRun;)V
    .locals 3
    .param p1, "gr_"    # Lmain/GameRun;

    .prologue
    const/16 v2, 0x14

    const/4 v1, 0x0

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-short v2, p0, Lminigame/Guess;->TIME:S

    .line 40
    const/16 v0, 0x28

    iput-short v0, p0, Lminigame/Guess;->TIME2:S

    .line 45
    const/16 v0, 0x96

    iput-short v0, p0, Lminigame/Guess;->BOX_Y1:S

    .line 46
    const/16 v0, 0xa5

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
    .locals 30

    .prologue
    .line 121
    const/16 v26, 0x280

    .local v26, "WIDTH":I
    const/16 v24, 0x168

    .line 122
    .local v24, "HEIGHT":I
    const/16 v7, 0x140

    .local v7, "WIDTH_H":I
    const/16 v25, 0xb4

    .line 123
    .local v25, "HEIGHT_H":I
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->state:B

    move v5, v0

    if-nez v5, :cond_0

    .line 124
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const-string v6, "\u6e38\u620f\u89c4\u5219"

    const/4 v8, 0x4

    const/16 v9, 0x11

    const/4 v10, 0x3

    const/4 v11, 0x1

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 125
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    const/4 v9, 0x7

    const/16 v5, 0x4b

    sub-int v10, v7, v5

    const/16 v11, 0x1b

    const/16 v12, 0x28

    const/4 v13, 0x0

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawUi(IIIII)V

    .line 126
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    const/4 v9, 0x7

    add-int/lit8 v10, v7, 0x4b

    const/16 v11, 0x1b

    const/16 v12, 0x24

    const/4 v13, 0x4

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawUi(IIIII)V

    .line 128
    :cond_0
    const/16 v9, 0xa

    .local v9, "x":I
    const/16 v29, 0x19

    .local v29, "y":I
    const/16 v11, 0xc8

    .local v11, "w":I
    const/16 v27, 0x1d

    .line 129
    .local v27, "fh":I
    mul-int/lit8 v12, v27, 0xa

    .line 130
    .local v12, "h":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    add-int/lit8 v10, v29, 0xa

    const/4 v13, 0x4

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawK(IIIII)V

    .line 131
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v13

    add-int v5, v9, v11

    add-int/lit8 v14, v5, 0xa

    add-int/lit8 v15, v29, 0xa

    const/16 v18, 0x4

    move/from16 v16, v11

    move/from16 v17, v12

    invoke-virtual/range {v13 .. v18}, Ldm/Ui;->drawK(IIIII)V

    .line 132
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v13

    add-int/lit8 v5, v11, 0xa

    mul-int/lit8 v5, v5, 0x2

    add-int/lit16 v14, v9, 0x1a4

    add-int/lit8 v15, v29, 0xa

    const/16 v18, 0x4

    move/from16 v16, v11

    move/from16 v17, v12

    invoke-virtual/range {v13 .. v18}, Ldm/Ui;->drawK(IIIII)V

    .line 134
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v14, v5, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    add-int/lit8 v15, v9, 0x6

    add-int/lit8 v16, v29, 0xa

    const/16 v18, 0x0

    const/16 v19, 0x0

    move/from16 v17, v27

    invoke-virtual/range {v13 .. v19}, Ldm/Ui;->drawStringY([Ljava/lang/StringBuffer;IIIII)V

    .line 135
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->state:B

    move v5, v0

    if-nez v5, :cond_1

    .line 136
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v13, v0

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\u9700\u8981\u7684\u53c2\u52a0\u8d39\uff1a"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget v0, v0, Lminigame/Guess;->sell_money:I

    move v6, v0

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\u91d1"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    move/from16 v0, v29

    add-int/lit16 v0, v0, 0x122

    move v5, v0

    const/16 v6, 0x32

    sub-int v16, v5, v6

    const/16 v17, 0x7

    const/16 v18, 0x0

    move v15, v7

    invoke-virtual/range {v13 .. v18}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 137
    add-int/lit8 v5, v29, 0x4b

    add-int/lit8 v16, v5, 0x5

    .line 138
    .local v16, "ty":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v13

    const/4 v14, 0x2

    add-int v5, v9, v11

    add-int/lit8 v5, v5, 0xc

    add-int/lit8 v15, v5, 0x19

    const/16 v5, 0x32

    sub-int v17, v11, v5

    const/16 v18, 0x3

    const/16 v19, 0x1e

    const/16 v20, 0xa

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->sel:B

    move/from16 v21, v0

    const/16 v22, 0x4

    const/16 v23, 0x2

    invoke-virtual/range {v13 .. v23}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 139
    const/16 v28, 0x0

    .end local v12    # "h":I
    .local v28, "i":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;

    array-length v5, v5

    move/from16 v0, v28

    move v1, v5

    if-lt v0, v1, :cond_3

    .line 148
    .end local v16    # "ty":I
    .end local v28    # "i":I
    :cond_1
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->state:B

    move v5, v0

    if-nez v5, :cond_2

    .line 149
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v8, 0x1

    invoke-virtual {v5, v6, v8}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 150
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, 0x3

    const/4 v8, 0x0

    move-object v0, v5

    move v1, v7

    move/from16 v2, v24

    move v3, v6

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawMoney(IIIZ)V

    .line 151
    return-void

    .line 140
    .restart local v16    # "ty":I
    .restart local v28    # "i":I
    :cond_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;

    aget-object v5, v5, v28

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v18

    add-int v5, v9, v11

    add-int/lit8 v5, v5, 0xf

    add-int/lit8 v5, v5, 0x19

    add-int/lit8 v19, v5, 0x1a

    .line 141
    mul-int/lit8 v5, v28, 0x28

    add-int/lit8 v5, v5, 0x69

    const/4 v6, 0x2

    sub-int v20, v5, v6

    const/16 v21, 0x0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->sel:B

    move v5, v0

    move v0, v5

    move/from16 v1, v28

    if-ne v0, v1, :cond_5

    const/4 v5, 0x0

    move/from16 v22, v5

    :goto_1
    const/16 v23, 0x1

    .line 140
    invoke-virtual/range {v17 .. v23}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 142
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;

    add-int v6, v9, v11

    add-int/lit8 v6, v6, 0xc

    add-int/lit8 v6, v6, 0x19

    mul-int/lit8 v8, v28, 0x28

    add-int/lit8 v8, v8, 0x69

    const/4 v10, 0x2

    sub-int/2addr v8, v10

    const/16 v10, 0x32

    sub-int v10, v11, v10

    const/16 v12, 0x28

    invoke-virtual {v5, v6, v8, v10, v12}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 143
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->sel:B

    move v5, v0

    move v0, v5

    move/from16 v1, v28

    if-ne v0, v1, :cond_6

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v5}, Lmain/PointerKey;->setKey5()V

    .line 139
    :cond_4
    :goto_2
    add-int/lit8 v28, v28, 0x1

    goto/16 :goto_0

    .line 141
    :cond_5
    const/4 v5, 0x3

    move/from16 v22, v5

    goto :goto_1

    .line 144
    :cond_6
    move/from16 v0, v28

    int-to-byte v0, v0

    move v5, v0

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lminigame/Guess;->sel:B

    goto :goto_2
.end method

.method private drawGame()V
    .locals 24

    .prologue
    .line 50
    const/16 v15, 0x280

    .local v15, "WIDTH":I
    const/16 v14, 0x168

    .line 51
    .local v14, "HEIGHT":I
    const/16 v7, 0x140

    .line 53
    .local v7, "WIDTH_H":I
    const/16 v21, 0xf0

    .local v21, "width":I
    const/16 v18, 0x140

    .line 54
    .local v18, "height":I
    const/16 v22, 0xca

    .local v22, "x":I
    const/16 v23, 0x20

    .local v23, "y":I
    const/4 v5, 0x4

    sub-int v20, v21, v5

    .local v20, "w":I
    const/4 v5, 0x4

    sub-int v17, v18, v5

    .local v17, "h":I
    const/16 v16, 0x1d

    .line 55
    .local v16, "fh":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v8, "\u80dc\u5229\u6b21\u6570\uff1a"

    invoke-direct {v6, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->winNum:B

    move v8, v0

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v8, "/"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gameData:[[B

    move-object v8, v0

    const/4 v9, 0x3

    aget-object v8, v8, v9

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->lv:B

    move v9, v0

    aget-byte v8, v8, v9

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v8, 0x4

    const/16 v9, 0x11

    const/4 v10, 0x3

    const/4 v11, 0x1

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 65
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->state:B

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_5

    .line 66
    sget-object v5, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v6, 0x41

    const/16 v7, 0x64

    move-object v0, v5

    move/from16 v1, v22

    move v2, v6

    move/from16 v3, v21

    move v4, v7

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 67
    .end local v7    # "WIDTH_H":I
    const/16 v19, 0x0

    .local v19, "i":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    array-length v5, v5

    move/from16 v0, v19

    move v1, v5

    if-lt v0, v1, :cond_1

    .line 71
    sget-object v5, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7, v15, v14}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 72
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->time:B

    move v5, v0

    const/16 v6, 0x14

    if-lt v5, v6, :cond_0

    .line 73
    const/16 v19, 0x0

    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    array-length v5, v5

    move/from16 v0, v19

    move v1, v5

    if-lt v0, v1, :cond_4

    .line 117
    .end local v19    # "i":I
    :cond_0
    :goto_2
    return-void

    .line 68
    .restart local v19    # "i":I
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    aget-object v5, v5, v19

    const/4 v6, 0x1

    aget v5, v5, v6

    const/4 v6, -0x1

    if-ne v5, v6, :cond_2

    .line 67
    :goto_3
    add-int/lit8 v19, v19, 0x1

    goto :goto_0

    .line 69
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    aget-object v5, v5, v19

    const/4 v6, 0x1

    aget v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v6, v0

    aget-object v6, v6, v19

    const/4 v7, 0x2

    aget v6, v6, v7

    add-int v6, v6, v22

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->time:B

    move v7, v0

    const/16 v8, 0x28

    if-ge v7, v8, :cond_3

    const/4 v7, 0x0

    :goto_4
    add-int/lit16 v7, v7, 0xa5

    move-object/from16 v0, p0

    move/from16 v1, v19

    move v2, v5

    move v3, v6

    move v4, v7

    invoke-direct {v0, v1, v2, v3, v4}, Lminigame/Guess;->drawMon(IIII)V

    goto :goto_3

    :cond_3
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->mon_size_move:B

    move v7, v0

    goto :goto_4

    .line 74
    :cond_4
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;

    move-object v6, v0

    const/4 v7, 0x1

    aget-object v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v7, v0

    aget-object v7, v7, v19

    const/4 v8, 0x2

    aget v7, v7, v8

    add-int v7, v7, v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v8, v0

    aget-object v8, v8, v19

    const/4 v9, 0x3

    aget v8, v8, v9

    const/16 v9, 0x11

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 73
    add-int/lit8 v19, v19, 0x1

    goto :goto_1

    .line 76
    .end local v19    # "i":I
    .restart local v7    # "WIDTH_H":I
    :cond_5
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->state:B

    move v5, v0

    const/4 v6, 0x2

    if-ne v5, v6, :cond_6

    .line 77
    const/16 v19, 0x0

    .end local v7    # "WIDTH_H":I
    .restart local v19    # "i":I
    :goto_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    array-length v5, v5

    move/from16 v0, v19

    move v1, v5

    if-ge v0, v1, :cond_0

    .line 78
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;

    move-object v6, v0

    const/4 v7, 0x1

    aget-object v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v7, v0

    aget-object v7, v7, v19

    const/4 v8, 0x2

    aget v7, v7, v8

    add-int v7, v7, v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v8, v0

    aget-object v8, v8, v19

    const/4 v9, 0x3

    aget v8, v8, v9

    const/16 v9, 0x11

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 77
    add-int/lit8 v19, v19, 0x1

    goto :goto_5

    .line 79
    .end local v19    # "i":I
    .restart local v7    # "WIDTH_H":I
    :cond_6
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->state:B

    move v5, v0

    const/4 v6, 0x3

    if-ne v5, v6, :cond_b

    .line 80
    const/16 v19, 0x0

    .end local v7    # "WIDTH_H":I
    .restart local v19    # "i":I
    :goto_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    array-length v5, v5

    move/from16 v0, v19

    move v1, v5

    if-lt v0, v1, :cond_8

    .line 89
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;

    move-object v6, v0

    const/4 v7, 0x0

    aget-object v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v8, v0

    iget-byte v8, v8, Lmain/GameRun;->selectx:B

    aget-object v7, v7, v8

    const/4 v8, 0x2

    aget v7, v7, v8

    add-int v7, v7, v22

    const/4 v8, 0x1

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

    const/4 v9, 0x3

    aget v8, v8, v9

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->time:B

    move v9, v0

    rem-int/lit8 v9, v9, 0x4

    const/4 v10, 0x2

    if-gt v9, v10, :cond_a

    const/4 v9, 0x5

    :goto_7
    sub-int/2addr v8, v9

    const/16 v9, 0x11

    .line 89
    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 91
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->time:B

    move v5, v0

    add-int/lit8 v5, v5, 0x1

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lminigame/Guess;->time:B

    const/16 v6, 0x14

    if-le v5, v6, :cond_7

    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lminigame/Guess;->time:B

    .line 92
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-byte v6, v6, Lmain/GameRun;->selecty:B

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->selecty:B

    aget-object v6, v6, v7

    const/4 v7, 0x1

    aget v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gameData:[[B

    move-object v7, v0

    const/4 v8, 0x0

    aget-object v7, v7, v8

    const/4 v8, 0x1

    aget-byte v7, v7, v8

    add-int v7, v7, v22

    add-int/lit8 v7, v7, 0x64

    const/16 v8, 0x87

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-direct {v0, v1, v2, v3, v4}, Lminigame/Guess;->drawMon(IIII)V

    .line 94
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v8, v0

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\u8bf7\u6307\u51fa"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

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

    const/4 v9, 0x1

    aget v7, v7, v9

    invoke-virtual {v6, v7}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\u6240\u5728\u7bb1\u5b50"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 95
    add-int v5, v22, v21

    add-int/lit8 v10, v5, 0x5a

    mul-int/lit8 v11, v16, 0x5

    const/4 v12, 0x6

    const/4 v13, 0x0

    .line 94
    invoke-virtual/range {v8 .. v13}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    goto/16 :goto_2

    .line 82
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v6, v0

    aget-object v6, v6, v19

    const/4 v7, 0x2

    aget v6, v6, v7

    add-int v6, v6, v22

    const/16 v7, 0x14

    sub-int/2addr v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v7, v0

    aget-object v7, v7, v19

    const/4 v8, 0x3

    aget v7, v7, v8

    const/16 v8, 0x28

    const/16 v9, 0x28

    invoke-virtual {v5, v6, v7, v8, v9}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_9

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

    invoke-virtual {v5}, Lmain/PointerKey;->setKey5()V

    .line 87
    :cond_9
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;

    move-object v6, v0

    const/4 v7, 0x1

    aget-object v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v7, v0

    aget-object v7, v7, v19

    const/4 v8, 0x2

    aget v7, v7, v8

    add-int v7, v7, v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v8, v0

    aget-object v8, v8, v19

    const/4 v9, 0x3

    aget v8, v8, v9

    const/16 v9, 0x11

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 80
    add-int/lit8 v19, v19, 0x1

    goto/16 :goto_6

    .line 90
    :cond_a
    const/4 v9, 0x0

    goto/16 :goto_7

    .line 101
    .end local v19    # "i":I
    .restart local v7    # "WIDTH_H":I
    :cond_b
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->state:B

    move v5, v0

    const/4 v6, 0x4

    if-ne v5, v6, :cond_0

    .line 102
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-byte v6, v6, Lmain/GameRun;->selecty:B

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v7, v0

    .end local v7    # "WIDTH_H":I
    iget-byte v7, v7, Lmain/GameRun;->selecty:B

    aget-object v6, v6, v7

    const/4 v7, 0x1

    aget v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gameData:[[B

    move-object v7, v0

    const/4 v8, 0x0

    aget-object v7, v7, v8

    const/4 v8, 0x1

    aget-byte v7, v7, v8

    add-int v7, v7, v22

    add-int/lit8 v7, v7, 0x64

    const/16 v8, 0x87

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-direct {v0, v1, v2, v3, v4}, Lminigame/Guess;->drawMon(IIII)V

    .line 103
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;

    move-object v6, v0

    const/4 v7, 0x1

    aget-object v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v8, v0

    iget-byte v8, v8, Lmain/GameRun;->selectx:B

    aget-object v7, v7, v8

    const/4 v8, 0x2

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

    const/4 v9, 0x3

    aget v8, v8, v9

    const/16 v9, 0x11

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 105
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-byte v6, v6, Lmain/GameRun;->selectx:B

    aget-object v5, v5, v6

    const/4 v6, 0x1

    aget v5, v5, v6

    const/4 v6, -0x1

    if-eq v5, v6, :cond_c

    .line 106
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-byte v6, v6, Lmain/GameRun;->selectx:B

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->selectx:B

    aget-object v6, v6, v7

    const/4 v7, 0x1

    aget v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->box:[[I

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v8, v0

    iget-byte v8, v8, Lmain/GameRun;->selectx:B

    aget-object v7, v7, v8

    const/4 v8, 0x2

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

    const/4 v9, 0x3

    aget v8, v8, v9

    add-int/lit8 v8, v8, 0x23

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-direct {v0, v1, v2, v3, v4}, Lminigame/Guess;->drawMon(IIII)V

    .line 108
    :cond_c
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Guess;->b_win:B

    move v5, v0

    if-lez v5, :cond_d

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v8, v0

    const-string v9, "\u60a8\u771f\u5389\u5bb3\uff01"

    add-int v5, v22, v21

    add-int/lit8 v10, v5, 0x5a

    mul-int/lit8 v11, v16, 0x5

    const/4 v12, 0x6

    const/4 v13, 0x0

    invoke-virtual/range {v8 .. v13}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 110
    :goto_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v8, v0

    const-string v9, "\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed"

    add-int v5, v22, v21

    add-int/lit8 v10, v5, 0x5a

    mul-int/lit8 v11, v16, 0x7

    const/4 v12, 0x6

    const/4 v13, 0x0

    invoke-virtual/range {v8 .. v13}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 111
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7, v15, v14}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v5}, Lmain/PointerKey;->setKey5()V

    goto/16 :goto_2

    .line 109
    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Guess;->gr:Lmain/GameRun;

    move-object v8, v0

    const-string v9, "\u8bf4\u4e0d\u5b9a\u4e0b\u6b21\u5c31\u80fd\u884c\u7684\u3002"

    add-int v5, v22, v21

    add-int/lit8 v10, v5, 0x5a

    mul-int/lit8 v11, v16, 0x5

    const/4 v12, 0x6

    const/4 v13, 0x0

    invoke-virtual/range {v8 .. v13}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    goto :goto_8
.end method

.method private drawMon(IIII)V
    .locals 6
    .param p1, "i"    # I
    .param p2, "id"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I

    .prologue
    const/4 v5, 0x0

    .line 175
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;

    aget-object v1, v1, p1

    iget-object v2, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;

    aget-object v2, v2, p1

    iget-object v3, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->mList_id:[[B

    aget-object v3, v3, p2

    const/4 v4, 0x1

    aget-byte v3, v3, v4

    mul-int/lit8 v3, v3, 0x3

    invoke-virtual {v2, v3, v5, v5}, Ldm/Sprite;->action(III)I

    move-result v2

    move v3, p3

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    .line 176
    return-void
.end method

.method private getGameMonList()[B
    .locals 11

    .prologue
    const/4 v10, 0x3

    const/4 v9, 0x2

    const/4 v7, 0x1

    const/4 v8, -0x1

    const/4 v6, 0x4

    .line 437
    new-array v1, v10, [B

    .line 439
    .local v1, "monList":[B
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    array-length v4, v1

    if-lt v0, v4, :cond_0

    .line 441
    const/4 v0, 0x0

    :goto_1
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B

    aget-object v4, v4, v9

    iget-byte v5, p0, Lminigame/Guess;->lv:B

    aget-byte v4, v4, v5

    if-lt v0, v4, :cond_1

    .line 452
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v9}, Ldm/Ms;->getRandom(I)I

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
    const/4 v0, 0x0

    :goto_2
    if-lt v0, v10, :cond_4

    .line 463
    return-object v1

    .line 440
    .end local v2    # "n":B
    :cond_0
    aput-byte v8, v1, v0

    .line 439
    add-int/lit8 v4, v0, 0x1

    int-to-byte v0, v4

    goto :goto_0

    .line 442
    :cond_1
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B

    aget-object v4, v4, v6

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v5, p0, Lminigame/Guess;->gameData:[[B

    aget-object v5, v5, v6

    array-length v5, v5

    invoke-static {v5}, Ldm/Ms;->getRandom(I)I

    move-result v5

    aget-byte v4, v4, v5

    aput-byte v4, v1, v0

    .line 443
    const/4 v2, 0x0

    .line 444
    .restart local v2    # "n":B
    :goto_3
    if-lt v2, v0, :cond_2

    .line 441
    add-int/lit8 v4, v0, 0x1

    int-to-byte v0, v4

    goto :goto_1

    .line 445
    :cond_2
    aget-byte v4, v1, v2

    aget-byte v5, v1, v0

    if-ne v4, v5, :cond_3

    .line 446
    iget-object v4, p0, Lminigame/Guess;->gameData:[[B

    aget-object v4, v4, v6

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v5, p0, Lminigame/Guess;->gameData:[[B

    aget-object v5, v5, v6

    array-length v5, v5

    invoke-static {v5}, Ldm/Ms;->getRandom(I)I

    move-result v5

    aget-byte v4, v4, v5

    aput-byte v4, v1, v0

    .line 447
    const/4 v2, 0x0

    goto :goto_3

    .line 448
    :cond_3
    add-int/lit8 v4, v2, 0x1

    int-to-byte v2, v4

    goto :goto_3

    .line 459
    :cond_4
    aget-byte v4, v1, v0

    if-ne v4, v8, :cond_5

    .line 458
    :goto_4
    add-int/lit8 v4, v0, 0x1

    int-to-byte v0, v4

    goto :goto_2

    .line 460
    :cond_5
    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->mList_id:[[B

    aget-byte v5, v1, v0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v3, v4, v5

    .line 461
    .local v3, "t":B
    iget-object v4, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "data/npc2/"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    invoke-virtual {v7, v3}, Lmain/GameRun;->isNpc2ImageType(I)Z

    move-result v7

    invoke-virtual {v5, v6, v7}, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;

    move-result-object v5

    aput-object v5, v4, v0

    goto :goto_4
.end method

.method private initGame()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x0

    .line 417
    invoke-direct {p0}, Lminigame/Guess;->getGameMonList()[B

    move-result-object v1

    .line 418
    .local v1, "monList":[B
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    if-lt v0, v6, :cond_0

    .line 425
    const/4 v1, 0x0

    check-cast v1, [B

    .line 426
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v2, p0, Lminigame/Guess;->lv:B

    add-int/lit8 v2, v2, 0x2

    invoke-static {v2}, Ldm/Ms;->getRandom(I)I

    move-result v2

    add-int/lit8 v2, v2, 0x2

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

    .line 419
    :cond_0
    iget-object v2, p0, Lminigame/Guess;->box:[[I

    aget-object v2, v2, v0

    aput v0, v2, v5

    .line 420
    iget-object v2, p0, Lminigame/Guess;->box:[[I

    aget-object v2, v2, v0

    const/4 v3, 0x1

    aget-byte v4, v1, v0

    aput v4, v2, v3

    .line 421
    iget-object v2, p0, Lminigame/Guess;->box:[[I

    aget-object v2, v2, v0

    const/4 v3, 0x2

    iget-object v4, p0, Lminigame/Guess;->gameData:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v0

    add-int/lit8 v4, v4, 0x64

    aput v4, v2, v3

    .line 422
    iget-object v2, p0, Lminigame/Guess;->box:[[I

    aget-object v2, v2, v0

    aput v5, v2, v6

    .line 418
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    goto :goto_0
.end method

.method private win()B
    .locals 9

    .prologue
    const/16 v8, 0xb

    const/4 v7, 0x3

    const/4 v6, 0x2

    .line 337
    iget-byte v1, p0, Lminigame/Guess;->winNum:B

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    iput-byte v1, p0, Lminigame/Guess;->winNum:B

    iget-object v2, p0, Lminigame/Guess;->gameData:[[B

    aget-object v2, v2, v7

    iget-byte v3, p0, Lminigame/Guess;->lv:B

    aget-byte v2, v2, v3

    if-lt v1, v2, :cond_1

    .line 338
    iget v1, p0, Lminigame/Guess;->sell_money:I

    iget-byte v2, p0, Lminigame/Guess;->lv:B

    iget-byte v3, p0, Lminigame/Guess;->lv:B

    mul-int/2addr v2, v3

    mul-int/lit16 v2, v2, 0x96

    add-int/2addr v1, v2

    iget-byte v2, p0, Lminigame/Guess;->lv:B

    sub-int v2, v6, v2

    mul-int/lit8 v2, v2, 0x19

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

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 341
    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->rmsOther:[B

    const/16 v2, 0xa

    aget-byte v3, v1, v2

    const/4 v4, 0x1

    iget-byte v5, p0, Lminigame/Guess;->lv:B

    shl-int/2addr v4, v5

    or-int/2addr v3, v4

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 342
    iget-byte v1, p0, Lminigame/Guess;->lv:B

    if-ne v1, v6, :cond_0

    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->rmsOther:[B

    aget-byte v1, v1, v8

    if-ge v1, v7, :cond_0

    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->rmsOther:[B

    aget-byte v2, v1, v8

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    aput-byte v2, v1, v8

    :cond_0
    move v1, v6

    .line 345
    .end local v0    # "tm":I
    :goto_0
    return v1

    :cond_1
    move v1, v7

    goto :goto_0
.end method


# virtual methods
.method public go(I)V
    .locals 2
    .param p1, "mode"    # I

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 400
    if-ge p1, v0, :cond_0

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

    const/16 v1, 0x9

    iput-byte v1, v0, Lmain/GameRun;->line_max:B

    .line 408
    iget-byte v0, p0, Lminigame/Guess;->lv:B

    mul-int/lit16 v0, v0, 0xc8

    add-int/lit16 v0, v0, 0xc8

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

    .line 415
    :goto_0
    return-void

    .line 411
    :cond_0
    iput-byte v1, p0, Lminigame/Guess;->time:B

    .line 412
    iput-byte v0, p0, Lminigame/Guess;->state:B

    .line 413
    invoke-direct {p0}, Lminigame/Guess;->initGame()V

    goto :goto_0
.end method

.method public go(II)V
    .locals 8
    .param p1, "mode"    # I
    .param p2, "lv_"    # I

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x4

    const/4 v3, 0x3

    .line 368
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    const-string v2, "data/gamed.d"

    invoke-virtual {v1, v2}, Lmain/GameRun;->createString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0xb4

    invoke-virtual {v0, v1, v2, v5}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 369
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    const-string v1, "\u5f00\u59cb\u6e38\u620f#n\u79bb\u5f00\u6e38\u620f"

    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {v0, v1, v2, v6}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 374
    int-to-byte v0, p2

    iput-byte v0, p0, Lminigame/Guess;->lv:B

    .line 375
    new-array v0, v7, [Ljavax/microedition/lcdui/Image;

    iput-object v0, p0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;

    .line 376
    iget-object v0, p0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/brow/m2"

    invoke-virtual {v1, v2}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    aput-object v1, v0, v5

    .line 377
    iget-object v0, p0, Lminigame/Guess;->imgBox:[Ljavax/microedition/lcdui/Image;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/brow/m3"

    invoke-virtual {v1, v2}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    aput-object v1, v0, v6

    .line 378
    new-array v0, v7, [B

    iput-object v0, p0, Lminigame/Guess;->boxNum:[B

    .line 379
    const/4 v0, 0x5

    new-array v0, v0, [[B

    .line 383
    new-array v1, v3, [B

    fill-array-data v1, :array_0

    aput-object v1, v0, v5

    .line 385
    new-array v1, v4, [B

    fill-array-data v1, :array_1

    aput-object v1, v0, v6

    .line 386
    new-array v1, v4, [B

    fill-array-data v1, :array_2

    aput-object v1, v0, v7

    .line 387
    new-array v1, v4, [B

    fill-array-data v1, :array_3

    aput-object v1, v0, v3

    .line 388
    new-array v1, v3, [B

    fill-array-data v1, :array_4

    aput-object v1, v0, v4

    .line 379
    iput-object v0, p0, Lminigame/Guess;->gameData:[[B

    .line 394
    filled-new-array {v3, v4}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[I

    iput-object v0, p0, Lminigame/Guess;->box:[[I

    .line 395
    new-array v0, v3, [Ldm/Sprite;

    iput-object v0, p0, Lminigame/Guess;->imgMon:[Ldm/Sprite;

    .line 396
    invoke-virtual {p0, p1}, Lminigame/Guess;->go(I)V

    .line 397
    return-void

    .line 383
    :array_0
    .array-data 1
        -0x3ct
        0x11t
        0x5at
    .end array-data

    .line 385
    :array_1
    .array-data 1
        0x8t
        0xdt
        0x14t
        0x1et
    .end array-data

    .line 386
    :array_2
    .array-data 1
        0x1t
        0x2t
        0x3t
        0x3t
    .end array-data

    .line 387
    :array_3
    .array-data 1
        0x6t
        0x4t
        0x2t
        0x2t
    .end array-data

    .line 388
    :array_4
    .array-data 1
        0x53t
        0x1et
        0x37t
    .end array-data
.end method

.method public key()Z
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v3, -0x1

    const/4 v5, 0x0

    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 267
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v5

    .line 334
    :goto_0
    return v0

    .line 268
    :cond_0
    iget-byte v0, p0, Lminigame/Guess;->state:B

    if-nez v0, :cond_5

    .line 270
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 271
    iget-byte v0, p0, Lminigame/Guess;->sel:B

    xor-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lminigame/Guess;->sel:B

    :cond_1
    :goto_1
    move v0, v5

    .line 334
    goto :goto_0

    .line 272
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 273
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 274
    iget-byte v0, p0, Lminigame/Guess;->sel:B

    if-nez v0, :cond_3

    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget v1, p0, Lminigame/Guess;->sell_money:I

    invoke-virtual {v0, v1, v4}, Lmain/GameRun;->isMoney(IZ)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-byte v0, p0, Lminigame/Guess;->lv:B

    invoke-virtual {p0, v4, v0}, Lminigame/Guess;->go(II)V

    goto :goto_1

    .line 275
    :cond_3
    iget-byte v0, p0, Lminigame/Guess;->sel:B

    if-ne v0, v4, :cond_1

    .line 276
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

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
    goto :goto_0

    .line 296
    :cond_4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 297
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

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
    goto :goto_0

    .line 307
    :cond_5
    iget-byte v0, p0, Lminigame/Guess;->state:B

    if-ne v0, v6, :cond_8

    .line 308
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 309
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->selectx:B

    iget-object v3, p0, Lminigame/Guess;->box:[[I

    array-length v3, v3

    sub-int/2addr v3, v4

    invoke-virtual {v1, v2, v5, v3}, Ldm/Ms;->select(III)B

    move-result v1

    iput-byte v1, v0, Lmain/GameRun;->selectx:B

    goto/16 :goto_1

    .line 310
    :cond_6
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 311
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 312
    const/4 v0, 0x4

    iput-byte v0, p0, Lminigame/Guess;->state:B

    .line 313
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->selectx:B

    iget-object v1, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->selecty:B

    if-ne v0, v1, :cond_7

    move v0, v4

    :goto_2
    int-to-byte v0, v0

    iput-byte v0, p0, Lminigame/Guess;->b_win:B

    goto/16 :goto_1

    :cond_7
    move v0, v3

    goto :goto_2

    .line 316
    :cond_8
    iget-byte v0, p0, Lminigame/Guess;->state:B

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 317
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 318
    iget-byte v0, p0, Lminigame/Guess;->b_win:B

    if-ne v0, v4, :cond_9

    .line 319
    invoke-direct {p0}, Lminigame/Guess;->win()B

    move-result v0

    iput-byte v0, p0, Lminigame/Guess;->b_win:B

    .line 320
    iget-byte v0, p0, Lminigame/Guess;->b_win:B

    if-ne v0, v6, :cond_1

    iget-byte v0, p0, Lminigame/Guess;->lv:B

    invoke-virtual {p0, v4, v0}, Lminigame/Guess;->go(II)V

    goto/16 :goto_1

    .line 322
    :cond_9
    iget-byte v0, p0, Lminigame/Guess;->b_win:B

    if-eq v0, v3, :cond_a

    iget-byte v0, p0, Lminigame/Guess;->b_win:B

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->say_c:B

    if-nez v0, :cond_1

    .line 325
    :cond_a
    iget-byte v0, p0, Lminigame/Guess;->b_win:B

    const/4 v1, 0x2

    if-ne v0, v1, :cond_c

    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    const/16 v1, 0xb

    aget-byte v0, v0, v1

    if-ne v0, v6, :cond_c

    .line 326
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    const/16 v1, 0xb

    const/4 v2, 0x4

    aput-byte v2, v0, v1

    .line 327
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    const/16 v1, 0x53

    const/16 v2, 0x19

    invoke-virtual {v0, v1, v2, v5, v3}, Lmain/GameRun;->getMonster(IIII)B

    .line 331
    :cond_b
    :goto_3
    iget-byte v0, p0, Lminigame/Guess;->lv:B

    invoke-virtual {p0, v5, v0}, Lminigame/Guess;->go(II)V

    goto/16 :goto_1

    .line 328
    :cond_c
    iget-byte v0, p0, Lminigame/Guess;->b_win:B

    if-ne v0, v3, :cond_b

    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    const/16 v1, 0xb

    aget-byte v0, v0, v1

    if-ge v0, v6, :cond_b

    .line 329
    iget-object v0, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    const/16 v1, 0xb

    aput-byte v5, v0, v1

    goto :goto_3
.end method

.method public patin()V
    .locals 5

    .prologue
    .line 26
    const/16 v2, 0x280

    .local v2, "WIDTH":I
    const/16 v0, 0x168

    .line 27
    .local v0, "HEIGHT":I
    const/16 v3, 0x140

    .local v3, "WIDTH_H":I
    const/16 v1, 0xb4

    .line 28
    .local v1, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    invoke-virtual {v4}, Ldm/Ui;->fillRectB()V

    .line 30
    invoke-direct {p0}, Lminigame/Guess;->draw()V

    .line 31
    iget-byte v4, p0, Lminigame/Guess;->state:B

    if-eqz v4, :cond_0

    invoke-direct {p0}, Lminigame/Guess;->drawGame()V

    .line 37
    :cond_0
    return-void
.end method

.method public run()V
    .locals 12

    .prologue
    const/16 v11, 0x96

    const/4 v10, 0x3

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 180
    iget-byte v3, p0, Lminigame/Guess;->state:B

    if-ne v3, v8, :cond_4

    .line 181
    iget-byte v3, p0, Lminigame/Guess;->time:B

    const/16 v4, 0x14

    if-ge v3, v4, :cond_1

    .line 182
    iget-byte v3, p0, Lminigame/Guess;->time:B

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    iput-byte v3, p0, Lminigame/Guess;->time:B

    .line 264
    :cond_0
    :goto_0
    return-void

    .line 185
    :cond_1
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    aget-object v3, v3, v7

    aget v3, v3, v10

    if-ge v3, v11, :cond_2

    .line 186
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_1
    if-ge v0, v10, :cond_0

    .line 187
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    aget-object v3, v3, v0

    aget v4, v3, v10

    add-int/lit8 v4, v4, 0x19

    aput v4, v3, v10

    .line 186
    add-int/lit8 v3, v0, 0x1

    int-to-byte v0, v3

    goto :goto_1

    .line 190
    .end local v0    # "i":B
    :cond_2
    iget-byte v3, p0, Lminigame/Guess;->time:B

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    iput-byte v3, p0, Lminigame/Guess;->time:B

    const/16 v4, 0x28

    if-lt v3, v4, :cond_0

    .line 191
    iget-byte v3, p0, Lminigame/Guess;->mon_size_move:B

    const/16 v4, 0x28

    if-ge v3, v4, :cond_3

    .line 192
    iget-byte v3, p0, Lminigame/Guess;->mon_size_move:B

    add-int/lit8 v3, v3, 0x5

    int-to-byte v3, v3

    iput-byte v3, p0, Lminigame/Guess;->mon_size_move:B

    goto :goto_0

    .line 194
    :cond_3
    iput-byte v9, p0, Lminigame/Guess;->state:B

    .line 196
    iput-byte v7, p0, Lminigame/Guess;->time:B

    goto :goto_0

    .line 202
    :cond_4
    iget-byte v3, p0, Lminigame/Guess;->state:B

    if-ne v3, v9, :cond_e

    .line 203
    iget-byte v3, p0, Lminigame/Guess;->time:B

    if-gtz v3, :cond_9

    .line 204
    iget-byte v3, p0, Lminigame/Guess;->transNum:B

    iget-byte v4, p0, Lminigame/Guess;->maxTransNum:B

    if-ge v3, v4, :cond_7

    .line 205
    iput-byte v8, p0, Lminigame/Guess;->time:B

    .line 206
    iget-byte v3, p0, Lminigame/Guess;->transNum:B

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    iput-byte v3, p0, Lminigame/Guess;->transNum:B

    .line 207
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v10}, Ldm/Ms;->getRandom(I)I

    move-result v4

    int-to-byte v4, v4

    aput-byte v4, v3, v7

    .line 208
    :cond_5
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v10}, Ldm/Ms;->getRandom(I)I

    move-result v4

    int-to-byte v4, v4

    aput-byte v4, v3, v8

    .line 209
    iget-object v3, p0, Lminigame/Guess;->boxNum:[B

    aget-byte v3, v3, v8

    iget-object v4, p0, Lminigame/Guess;->boxNum:[B

    aget-byte v4, v4, v7

    if-eq v3, v4, :cond_5

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

    if-ge v3, v4, :cond_6

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

    .line 216
    :cond_6
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

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

    invoke-static {v3}, Ldm/Ms;->abs(I)I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-byte v3, v3

    iput-byte v3, p0, Lminigame/Guess;->gameR:B

    .line 217
    iget-byte v3, p0, Lminigame/Guess;->gameR:B

    mul-int/lit8 v3, v3, 0x2

    iget-object v4, p0, Lminigame/Guess;->gameData:[[B

    aget-object v4, v4, v8

    iget-byte v5, p0, Lminigame/Guess;->lv:B

    aget-byte v4, v4, v5

    div-int/2addr v3, v4

    int-to-byte v3, v3

    iput-byte v3, p0, Lminigame/Guess;->tempTransNum:B

    goto/16 :goto_0

    .line 220
    :cond_7
    iput-byte v7, p0, Lminigame/Guess;->time:B

    .line 221
    iput-byte v10, p0, Lminigame/Guess;->state:B

    .line 223
    :cond_8
    iget-object v3, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v4, p0, Lminigame/Guess;->box:[[I

    array-length v4, v4

    invoke-static {v4}, Ldm/Ms;->getRandom(I)I

    move-result v4

    int-to-byte v4, v4

    iput-byte v4, v3, Lmain/GameRun;->selecty:B

    .line 224
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v4, v4, Lmain/GameRun;->selecty:B

    aget-object v3, v3, v4

    aget v3, v3, v8

    const/4 v4, -0x1

    if-eq v3, v4, :cond_8

    goto/16 :goto_0

    .line 230
    :cond_9
    iget-byte v3, p0, Lminigame/Guess;->time:B

    iget-byte v4, p0, Lminigame/Guess;->tempTransNum:B

    if-le v3, v4, :cond_d

    .line 231
    iput-byte v7, p0, Lminigame/Guess;->time:B

    .line 232
    const/4 v3, 0x4

    new-array v2, v3, [I

    .line 233
    .local v2, "temp":[I
    const/4 v0, 0x0

    .restart local v0    # "i":B
    :goto_2
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    array-length v3, v3

    if-lt v0, v3, :cond_a

    .line 242
    const/4 v0, 0x0

    :goto_3
    if-ge v0, v10, :cond_0

    .line 243
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    aget-object v3, v3, v0

    iget-object v4, p0, Lminigame/Guess;->gameData:[[B

    aget-object v4, v4, v7

    aget-byte v4, v4, v0

    add-int/lit8 v4, v4, 0x64

    aput v4, v3, v9

    .line 244
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    aget-object v3, v3, v0

    aput v11, v3, v10

    .line 242
    add-int/lit8 v3, v0, 0x1

    int-to-byte v0, v3

    goto :goto_3

    .line 234
    :cond_a
    const/4 v1, 0x0

    .local v1, "j":B
    :goto_4
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    array-length v3, v3

    if-lt v1, v3, :cond_b

    .line 233
    add-int/lit8 v3, v0, 0x1

    int-to-byte v0, v3

    goto :goto_2

    .line 235
    :cond_b
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    aget-object v3, v3, v1

    aget v3, v3, v9

    iget-object v4, p0, Lminigame/Guess;->box:[[I

    aget-object v4, v4, v0

    aget v4, v4, v9

    if-le v3, v4, :cond_c

    .line 236
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    aget-object v3, v3, v0

    array-length v4, v2

    invoke-static {v3, v7, v2, v7, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 237
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    aget-object v3, v3, v1

    iget-object v4, p0, Lminigame/Guess;->box:[[I

    aget-object v4, v4, v0

    iget-object v5, p0, Lminigame/Guess;->box:[[I

    aget-object v5, v5, v1

    array-length v5, v5

    invoke-static {v3, v7, v4, v7, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 238
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    aget-object v3, v3, v1

    array-length v4, v2

    invoke-static {v2, v7, v3, v7, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 234
    :cond_c
    add-int/lit8 v3, v1, 0x1

    int-to-byte v1, v3

    goto :goto_4

    .line 250
    .end local v0    # "i":B
    .end local v1    # "j":B
    .end local v2    # "temp":[I
    :cond_d
    iget-byte v3, p0, Lminigame/Guess;->time:B

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    iput-byte v3, p0, Lminigame/Guess;->time:B

    .line 251
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    iget-object v4, p0, Lminigame/Guess;->boxNum:[B

    aget-byte v4, v4, v7

    aget-object v3, v3, v4

    aget v4, v3, v9

    iget-byte v5, p0, Lminigame/Guess;->gameR:B

    mul-int/lit8 v5, v5, 0x2

    iget-byte v6, p0, Lminigame/Guess;->tempTransNum:B

    div-int/2addr v5, v6

    add-int/2addr v4, v5

    aput v4, v3, v9

    .line 252
    iget-byte v3, p0, Lminigame/Guess;->gameR:B

    mul-int/lit8 v3, v3, 0x2

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

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

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

    invoke-virtual {v4, v5}, Ldm/Ms;->sqrt(I)I

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

    mul-int/lit8 v5, v5, 0x2

    iget-byte v6, p0, Lminigame/Guess;->tempTransNum:B

    div-int/2addr v5, v6

    sub-int/2addr v4, v5

    aput v4, v3, v9

    .line 255
    iget-object v3, p0, Lminigame/Guess;->box:[[I

    iget-object v4, p0, Lminigame/Guess;->boxNum:[B

    aget-byte v4, v4, v8

    aget-object v3, v3, v4

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

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

    invoke-virtual {v4, v5}, Ldm/Ms;->sqrt(I)I

    move-result v4

    add-int/lit16 v4, v4, 0x96

    aput v4, v3, v10

    goto/16 :goto_0

    .line 258
    .end local v2    # "temp":I
    :cond_e
    iget-byte v3, p0, Lminigame/Guess;->state:B

    const/4 v4, 0x4

    if-ne v3, v4, :cond_0

    .line 259
    iget-object v3, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->selectx:B

    if-ne v3, v9, :cond_f

    iget-object v3, p0, Lminigame/Guess;->box:[[I

    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v4, v4, Lmain/GameRun;->selectx:B

    aget-object v3, v3, v4

    aget v3, v3, v9

    iget-object v4, p0, Lminigame/Guess;->gameData:[[B

    aget-object v4, v4, v7

    aget-byte v4, v4, v8

    add-int/lit8 v4, v4, 0x64

    if-gt v3, v4, :cond_10

    .line 260
    :cond_f
    iget-object v3, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->selectx:B

    if-nez v3, :cond_0

    iget-object v3, p0, Lminigame/Guess;->box:[[I

    iget-object v4, p0, Lminigame/Guess;->gr:Lmain/GameRun;

    iget-byte v4, v4, Lmain/GameRun;->selectx:B

    aget-object v3, v3, v4

    aget v3, v3, v9

    iget-object v4, p0, Lminigame/Guess;->gameData:[[B

    aget-object v4, v4, v7

    aget-byte v4, v4, v8

    add-int/lit8 v4, v4, 0x64

    if-ge v3, v4, :cond_0

    .line 261
    :cond_10
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

    div-int/lit8 v5, v5, 0x7

    add-int/2addr v4, v5

    aput v4, v3, v9

    goto/16 :goto_0
.end method
