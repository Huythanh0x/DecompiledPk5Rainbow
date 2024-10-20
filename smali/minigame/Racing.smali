.class public Lminigame/Racing;
.super Ljava/lang/Object;
.source "Racing.java"

# interfaces
.implements Lminigame/MiniGame_H;


# instance fields
.field private final MAP_HEIGHT:S

.field private final NUM:B

.field private final WIN_HEIGHT:S

.field private cloud:[[S

.field private gDate:[[S

.field gr:Lmain/GameRun;

.field private imgCloud:Ljavax/microedition/lcdui/Image;

.field private length:B

.field private lv:B

.field private monY:[S

.field private money:[S

.field private myDate:[B

.field private now_a:[[B

.field private sel:B

.field private sp:[Ldm/Sprite;

.field private speedLv:B

.field private srcY:S

.field private state:B

.field private time:B


# direct methods
.method public constructor <init>(Lmain/GameRun;)V
    .locals 4
    .param p1, "gr_"    # Lmain/GameRun;

    .prologue
    const/4 v2, 0x4

    const/4 v3, 0x3

    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-byte v2, p0, Lminigame/Racing;->NUM:B

    .line 16
    const/16 v0, 0x1c2

    iput-short v0, p0, Lminigame/Racing;->MAP_HEIGHT:S

    const/16 v0, 0x46

    iput-short v0, p0, Lminigame/Racing;->WIN_HEIGHT:S

    .line 20
    filled-new-array {v2, v3}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[B

    iput-object v0, p0, Lminigame/Racing;->now_a:[[B

    .line 21
    new-array v0, v2, [B

    const/4 v1, -0x1

    aput-byte v1, v0, v3

    iput-object v0, p0, Lminigame/Racing;->myDate:[B

    .line 30
    const/16 v0, 0xa

    filled-new-array {v0, v3}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[S

    iput-object v0, p0, Lminigame/Racing;->cloud:[[S

    .line 31
    new-array v0, v2, [S

    iput-object v0, p0, Lminigame/Racing;->monY:[S

    .line 32
    const/4 v0, 0x6

    new-array v0, v0, [S

    fill-array-data v0, :array_0

    iput-object v0, p0, Lminigame/Racing;->money:[S

    .line 33
    new-array v0, v2, [[S

    const/4 v1, 0x0

    new-array v2, v3, [S

    fill-array-data v2, :array_1

    aput-object v2, v0, v1

    const/4 v1, 0x1

    new-array v2, v3, [S

    fill-array-data v2, :array_2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    new-array v2, v3, [S

    fill-array-data v2, :array_3

    aput-object v2, v0, v1

    new-array v1, v3, [S

    fill-array-data v1, :array_4

    aput-object v1, v0, v3

    iput-object v0, p0, Lminigame/Racing;->gDate:[[S

    .line 18
    iput-object p1, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    return-void

    .line 32
    :array_0
    .array-data 2
        0x64s
        0x78s
        0x12cs
        0x15es
        0x3e8s
        0x4b0s
    .end array-data

    .line 33
    :array_1
    .array-data 2
        0x1c2s
        0x3s
        0x8s
    .end array-data

    nop

    :array_2
    .array-data 2
        0x186s
        0x4s
        0x9s
    .end array-data

    nop

    :array_3
    .array-data 2
        0x10es
        0x7s
        0x6s
    .end array-data

    nop

    :array_4
    .array-data 2
        0xd2s
        0x6s
        0xas
    .end array-data
.end method

.method private addCloud(I)V
    .locals 4
    .param p1, "i"    # I

    .prologue
    .line 379
    iget-object v0, p0, Lminigame/Racing;->cloud:[[S

    aget-object v0, v0, p1

    const/4 v1, 0x0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v2, Lmain/Constants_H;->WIDTH_H:I

    invoke-static {v2}, Ldm/Ms;->getRandom(I)I

    move-result v2

    add-int/lit16 v2, v2, 0x280

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 380
    iget-object v0, p0, Lminigame/Racing;->cloud:[[S

    aget-object v0, v0, p1

    const/4 v1, 0x1

    iget-short v2, p0, Lminigame/Racing;->srcY:S

    const/16 v3, 0x50

    sub-int/2addr v2, v3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v3, 0x19

    invoke-static {v3}, Ldm/Ms;->getRandom(I)I

    move-result v3

    add-int/lit8 v3, v3, 0x37

    mul-int/2addr v3, p1

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 381
    iget-object v0, p0, Lminigame/Racing;->cloud:[[S

    aget-object v0, v0, p1

    const/4 v1, 0x2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v2, 0x5

    invoke-static {v2}, Ldm/Ms;->getRandom(I)I

    move-result v2

    add-int/lit8 v2, v2, 0x2

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 382
    return-void
.end method

.method private draw0(IIII)V
    .locals 21
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "h"    # I
    .param p4, "fh"    # I

    .prologue
    .line 46
    const/16 v19, 0x168

    .line 47
    .local v19, "HEIGHT":I
    const/16 v7, 0x140

    .line 48
    .local v7, "WIDTH_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ui;->fillRectB()V

    .line 49
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const-string v6, "\u6e38\u620f\u89c4\u5219"

    add-int v8, p2, p4

    add-int/lit8 v8, v8, 0x3

    const/16 v9, 0x21

    const/4 v10, 0x3

    const/4 v11, 0x1

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 50
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    const/4 v9, 0x7

    const/16 v5, 0x32

    sub-int v10, v7, v5

    add-int v5, p2, p4

    const/16 v6, 0xd

    sub-int v11, v5, v6

    const/16 v12, 0x28

    const/4 v13, 0x0

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawUi(IIIII)V

    .line 51
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    const/4 v9, 0x7

    add-int/lit8 v10, v7, 0x32

    add-int v5, p2, p4

    const/16 v6, 0xd

    sub-int v11, v5, v6

    const/16 v12, 0x24

    const/4 v13, 0x4

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawUi(IIIII)V

    .line 52
    const/16 v11, 0xc8

    .line 53
    .local v11, "w":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    add-int v5, p2, p4

    add-int/lit8 v10, v5, 0x3

    const/4 v13, 0x4

    move/from16 v9, p1

    move/from16 v12, p3

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawK(IIIII)V

    .line 54
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    add-int v5, p1, v11

    add-int/lit8 v9, v5, 0xa

    add-int v5, p2, p4

    add-int/lit8 v10, v5, 0x3

    const/4 v13, 0x4

    move/from16 v12, p3

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawK(IIIII)V

    .line 55
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->gr:Lmain/GameRun;

    move-object v12, v0

    const-string v13, "\u9009\u62e9\u4f60\u8ba4\u4e3a\u4f1a\u5f97\u7b2c\u4e00\u7684\u4e00\u53ea\u5ba0\u7269\u548c\u62bc\u6ce8\u7684\u5927\u5c0f\uff0c\u6ce8\u6570\u8d8a\u5927\u83b7\u80dc\u540e\u7684\u5956\u52b1\u8d8a\u4e30\u539a\uff01"

    shr-int/lit8 v5, v11, 0x1

    add-int/lit8 v14, p1, 0x64

    add-int v5, p2, p4

    add-int/lit8 v15, v5, 0xf

    const/16 v16, 0x7

    const/16 v17, 0x0

    invoke-virtual/range {v12 .. v17}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 57
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    add-int/lit8 v5, v11, 0xa

    mul-int/lit8 v5, v5, 0x2

    move/from16 v0, p1

    add-int/lit16 v0, v0, 0x1a4

    move v9, v0

    add-int v5, p2, p4

    add-int/lit8 v10, v5, 0x3

    const/4 v13, 0x4

    move/from16 v12, p3

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawK(IIIII)V

    .line 58
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v13, v5, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    add-int/lit8 v5, v11, 0xa

    mul-int/lit8 v5, v5, 0x2

    move/from16 v0, p1

    add-int/lit16 v0, v0, 0x1a4

    move v5, v0

    add-int/lit8 v14, v5, 0x19

    add-int v5, p2, p4

    add-int/lit8 v15, v5, 0xf

    const/16 v17, 0x0

    const/16 v18, 0x0

    move/from16 v16, p4

    invoke-virtual/range {v12 .. v18}, Ldm/Ui;->drawStringY([Ljava/lang/StringBuffer;IIIII)V

    .line 60
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Racing;->state:B

    move v5, v0

    if-nez v5, :cond_0

    .line 61
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v12

    const-string v13, "\u8bf7\u9009\u62e9\u62bc\u6ce8\u5927\u5c0f\uff1a"

    add-int v5, p1, v11

    add-int/lit8 v14, v5, 0xa

    add-int v5, p2, p4

    add-int/lit8 v15, v5, 0xf

    const/16 v16, 0x0

    const/16 v17, 0x0

    const/16 v18, 0x0

    invoke-virtual/range {v12 .. v18}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 62
    const/16 v20, 0x0

    .local v20, "i":I
    :goto_0
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Racing;->length:B

    move v5, v0

    move/from16 v0, v20

    move v1, v5

    if-lt v0, v1, :cond_1

    .line 71
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    add-int v6, p1, v11

    add-int/lit8 v6, v6, 0xa

    add-int/lit8 v6, v6, 0x19

    add-int/lit8 v6, v6, 0xe

    add-int v8, p2, p4

    add-int/lit8 v8, v8, 0x32

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Racing;->sel:B

    move v9, v0

    add-int/lit8 v10, p4, 0x10

    mul-int/2addr v9, v10

    add-int/2addr v8, v9

    const/16 v9, 0x96

    add-int/lit8 v10, p4, 0x4

    invoke-virtual {v5, v6, v8, v9, v10}, Ldm/Ui;->drawK4(IIII)V

    .line 73
    .end local v20    # "i":I
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, 0x3

    const/4 v8, 0x0

    move-object v0, v5

    move v1, v7

    move/from16 v2, v19

    move v3, v6

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawMoney(IIIZ)V

    .line 74
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 75
    .end local v7    # "WIDTH_H":I
    return-void

    .line 63
    .restart local v7    # "WIDTH_H":I
    .restart local v20    # "i":I
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v12

    add-int v5, p1, v11

    add-int/lit8 v5, v5, 0xa

    add-int/lit8 v5, v5, 0x19

    add-int/lit8 v13, v5, 0xe

    add-int v5, p2, p4

    add-int/lit8 v5, v5, 0x32

    add-int/lit8 v6, p4, 0x10

    mul-int v6, v6, v20

    add-int v14, v5, v6

    const/16 v15, 0x96

    add-int/lit8 v16, p4, 0x4

    const/16 v17, 0x1

    invoke-virtual/range {v12 .. v17}, Ldm/Ui;->drawK(IIIII)V

    .line 64
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;

    aget-object v5, v5, v20

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v13

    .line 65
    add-int v5, p1, v11

    add-int/lit8 v5, v5, 0xa

    add-int/lit8 v5, v5, 0x19

    add-int/lit8 v14, v5, 0xe

    add-int v5, p2, p4

    add-int/lit8 v5, v5, 0x32

    add-int/lit8 v6, p4, 0x10

    mul-int v6, v6, v20

    add-int v15, v5, v6

    const/16 v16, 0x0

    const/16 v17, 0x3

    const/16 v18, 0x0

    .line 64
    invoke-virtual/range {v12 .. v18}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 66
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;

    add-int v6, p1, v11

    add-int/lit8 v6, v6, 0xa

    add-int/lit8 v6, v6, 0x19

    add-int/lit8 v6, v6, 0xe

    add-int v8, p2, p4

    add-int/lit8 v8, v8, 0x32

    add-int/lit8 v9, p4, 0x10

    mul-int v9, v9, v20

    add-int/2addr v8, v9

    const/16 v9, 0x96

    add-int/lit8 v10, p4, 0x4

    invoke-virtual {v5, v6, v8, v9, v10}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 67
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Racing;->sel:B

    move v5, v0

    move v0, v5

    move/from16 v1, v20

    if-ne v0, v1, :cond_3

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v5}, Lmain/PointerKey;->setKey5()V

    .line 62
    :cond_2
    :goto_1
    add-int/lit8 v20, v20, 0x1

    goto/16 :goto_0

    .line 68
    :cond_3
    move/from16 v0, v20

    int-to-byte v0, v0

    move v5, v0

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lminigame/Racing;->sel:B

    goto :goto_1
.end method

.method private draw1(III)V
    .locals 13
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "h"    # I

    .prologue
    .line 119
    const/16 v9, 0x280

    .local v9, "WIDTH":I
    const/16 v8, 0x168

    .line 120
    .local v8, "HEIGHT":I
    const/16 v10, 0x140

    .line 122
    .local v10, "WIDTH_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0xd7

    const/16 v2, 0x21

    const/16 v3, 0xd2

    const/16 v4, 0x145

    const/4 v5, 0x4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 124
    const/4 v11, 0x0

    .end local v8    # "HEIGHT":I
    .local v11, "i":B
    :goto_0
    iget-byte v0, p0, Lminigame/Racing;->length:B

    if-lt v11, v0, :cond_2

    .line 130
    iget-byte v0, p0, Lminigame/Racing;->state:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 131
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p1, 0x19

    iget-byte v2, p0, Lminigame/Racing;->sel:B

    mul-int/lit8 v2, v2, 0x34

    add-int/2addr v1, v2

    add-int/lit8 v2, p2, 0x19

    add-int/lit8 v2, v2, 0xa

    const/16 v3, 0x2c

    const/16 v4, 0x4c

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawK4(IIII)V

    .line 132
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p2, 0x19

    add-int/lit8 v2, v1, 0x31

    const/16 v3, 0x74

    const/4 v4, 0x1

    const/4 v5, 0x1

    move v1, v10

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 133
    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    const/4 v1, 0x4

    const/16 v2, 0x74

    sub-int v2, v10, v2

    add-int/lit8 v3, p2, 0x19

    add-int/lit8 v3, v3, 0xa

    const/16 v4, 0x34

    move/from16 v5, p3

    invoke-virtual/range {v0 .. v5}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v12

    .line 134
    .local v12, "t":B
    const/4 v0, -0x1

    if-eq v12, v0, :cond_0

    .line 135
    iget-byte v0, p0, Lminigame/Racing;->sel:B

    if-ne v0, v12, :cond_5

    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v0}, Lmain/PointerKey;->setKey5()V

    .line 140
    .end local v12    # "t":B
    :cond_0
    :goto_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const-string v1, "\u5174\u594b\u5ea6\uff1a"

    add-int/lit8 v2, p1, 0x19

    add-int/lit8 v3, p2, 0x19

    add-int/lit8 v3, v3, 0xd

    add-int v3, v3, p3

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 141
    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    const/4 v1, 0x6

    const/4 v2, 0x2

    add-int/lit8 v3, p1, 0x7d

    add-int/lit8 v4, p2, 0x19

    add-int/lit8 v4, v4, 0x13

    add-int v4, v4, p3

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawFealty(IIII)V

    .line 142
    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    const-string v1, "\u6bcf\u5582\u4e00\u4e2a\u5174\u594b\u83c7\u82b1\u8d3910\u91d1\uff0c\u53ef\u589e\u52a0\u4e00\u683c\u5174\u594b\u5ea6\u3002"

    add-int/lit8 v2, p2, 0x32

    add-int/lit8 v2, v2, 0x13

    add-int v3, v2, p3

    const/16 v4, 0x8

    const/4 v5, 0x0

    move v2, v10

    invoke-virtual/range {v0 .. v5}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 143
    add-int/lit8 v0, p3, 0x45

    add-int/lit8 v0, v0, 0x19

    add-int/lit8 p3, v0, 0x4b

    .line 144
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const-string v1, "\u8bf7\u9009\u62e9\u9053\u5177\uff1a"

    add-int/lit8 v2, p1, 0x19

    add-int v3, p2, p3

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 145
    add-int/lit8 v0, p3, 0x19

    add-int/lit8 p3, v0, 0x3

    .line 146
    const/4 v11, 0x0

    :goto_2
    iget-byte v0, p0, Lminigame/Racing;->length:B

    if-lt v11, v0, :cond_6

    .line 151
    iget-byte v0, p0, Lminigame/Racing;->state:B

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 152
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p1, 0x19

    iget-byte v2, p0, Lminigame/Racing;->sel:B

    mul-int/lit8 v2, v2, 0x34

    add-int/2addr v1, v2

    add-int v2, p2, p3

    const/16 v3, 0x2c

    const/16 v4, 0x22

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawK4(IIII)V

    .line 153
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int v1, p2, p3

    add-int/lit8 v2, v1, 0xe

    const/16 v3, 0x74

    const/4 v4, 0x1

    const/4 v5, 0x1

    move v1, v10

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 154
    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    const/4 v1, 0x4

    const/16 v2, 0x74

    sub-int v2, v10, v2

    add-int v3, p2, p3

    add-int/lit8 v3, v3, 0x8

    const/16 v4, 0x34

    const/16 v5, 0x22

    invoke-virtual/range {v0 .. v5}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v12

    .line 155
    .restart local v12    # "t":B
    const/4 v0, -0x1

    if-eq v12, v0, :cond_1

    .line 156
    iget-byte v0, p0, Lminigame/Racing;->sel:B

    if-ne v0, v12, :cond_7

    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v0}, Lmain/PointerKey;->setKey5()V

    .line 160
    .end local v12    # "t":B
    :cond_1
    :goto_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x1

    iget-byte v2, p0, Lminigame/Racing;->state:B

    const/4 v3, 0x1

    if-eq v2, v3, :cond_8

    const/4 v2, 0x1

    :goto_4
    invoke-virtual {v0, v1, v2}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 161
    return-void

    .line 125
    :cond_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p1, 0x19

    mul-int/lit8 v2, v11, 0x34

    add-int/2addr v1, v2

    add-int/lit8 v2, p2, 0x19

    add-int/lit8 v2, v2, 0xa

    const/16 v3, 0x2c

    const/4 v5, 0x1

    move/from16 v4, p3

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 126
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lminigame/Racing;->sp:[Ldm/Sprite;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    const/4 v2, 0x0

    add-int/lit8 v3, p1, 0x19

    mul-int/lit8 v4, v11, 0x34

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0x16

    .line 127
    add-int/lit8 v4, p2, 0x19

    add-int/lit8 v4, v4, 0x8

    add-int v4, v4, p3

    iget-object v5, p0, Lminigame/Racing;->now_a:[[B

    aget-object v5, v5, v11

    const/4 v6, 0x0

    iget-byte v7, p0, Lminigame/Racing;->state:B

    const/4 v8, 0x1

    if-ne v7, v8, :cond_4

    iget-byte v7, p0, Lminigame/Racing;->sel:B

    if-ne v7, v11, :cond_3

    const/4 v7, 0x1

    .line 126
    :goto_5
    invoke-virtual/range {v0 .. v7}, Ldm/Ui;->drawActionOne(Ldm/Sprite;III[BIZ)Z

    .line 128
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v2, v11, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    add-int/lit8 v2, p1, 0x19

    mul-int/lit8 v3, v11, 0x34

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x1b

    add-int/lit8 v3, p2, 0x32

    add-int/lit8 v3, v3, 0xc

    const/16 v4, 0x14

    const/4 v5, 0x2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 124
    add-int/lit8 v0, v11, 0x1

    int-to-byte v11, v0

    goto/16 :goto_0

    .line 127
    :cond_3
    const/4 v7, 0x0

    goto :goto_5

    :cond_4
    const/4 v7, 0x0

    goto :goto_5

    .line 136
    .restart local v12    # "t":B
    :cond_5
    iput-byte v12, p0, Lminigame/Racing;->sel:B

    goto/16 :goto_1

    .line 147
    .end local v12    # "t":B
    :cond_6
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p1, 0x19

    mul-int/lit8 v2, v11, 0x34

    add-int/2addr v1, v2

    add-int v2, p2, p3

    const/16 v3, 0x2c

    const/16 v4, 0x22

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 148
    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    const/16 v1, 0xc

    add-int/lit8 v2, p1, 0x19

    mul-int/lit8 v3, v11, 0x34

    add-int/2addr v2, v3

    add-int v3, p2, p3

    add-int/lit8 v3, v3, 0xa

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawItem(IIII)V

    .line 149
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "x"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    add-int/lit8 v2, p1, 0x19

    mul-int/lit8 v3, v11, 0x34

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x10

    add-int v3, p2, p3

    add-int/lit8 v3, v3, 0x8

    const/4 v4, 0x0

    const/4 v5, 0x3

    const/4 v6, 0x1

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 146
    add-int/lit8 v0, v11, 0x1

    int-to-byte v11, v0

    goto/16 :goto_2

    .line 157
    .restart local v12    # "t":B
    :cond_7
    iput-byte v12, p0, Lminigame/Racing;->sel:B

    goto/16 :goto_3

    .line 160
    .end local v12    # "t":B
    :cond_8
    const/4 v2, 0x0

    goto/16 :goto_4
.end method

.method private drawCloud()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 385
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-object v1, p0, Lminigame/Racing;->cloud:[[S

    array-length v1, v1

    if-lt v0, v1, :cond_0

    .line 387
    const/4 v0, 0x0

    :goto_1
    iget-object v1, p0, Lminigame/Racing;->cloud:[[S

    array-length v1, v1

    if-lt v0, v1, :cond_1

    .line 391
    return-void

    .line 386
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v1

    iget-object v2, p0, Lminigame/Racing;->imgCloud:Ljavax/microedition/lcdui/Image;

    iget-object v3, p0, Lminigame/Racing;->cloud:[[S

    aget-object v3, v3, v0

    aget-short v3, v3, v6

    iget-object v4, p0, Lminigame/Racing;->cloud:[[S

    aget-object v4, v4, v0

    aget-short v4, v4, v7

    iget-short v5, p0, Lminigame/Racing;->srcY:S

    sub-int/2addr v4, v5

    invoke-virtual {v1, v2, v3, v4, v6}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 385
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0

    .line 388
    :cond_1
    iget-object v1, p0, Lminigame/Racing;->cloud:[[S

    aget-object v1, v1, v0

    aget-short v1, v1, v6

    iget-object v2, p0, Lminigame/Racing;->cloud:[[S

    aget-object v2, v2, v0

    aget-short v2, v2, v7

    invoke-direct {p0, v1, v2}, Lminigame/Racing;->isNpcSrc(II)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-direct {p0, v0}, Lminigame/Racing;->addCloud(I)V

    .line 387
    :goto_2
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_1

    .line 389
    :cond_2
    iget-object v1, p0, Lminigame/Racing;->cloud:[[S

    aget-object v1, v1, v0

    aget-short v2, v1, v6

    iget-object v3, p0, Lminigame/Racing;->cloud:[[S

    aget-object v3, v3, v0

    const/4 v4, 0x2

    aget-short v3, v3, v4

    sub-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v1, v6

    goto :goto_2
.end method

.method private drawEnd()V
    .locals 15

    .prologue
    const/16 v14, 0x28

    const/4 v13, 0x1

    const/4 v2, 0x0

    .line 397
    const/16 v10, 0x280

    .line 398
    .local v10, "WIDTH":I
    const/16 v0, 0x46

    sub-int v0, v10, v0

    div-int/lit8 v0, v0, 0x23

    add-int/lit8 v12, v0, 0x1

    .line 399
    .local v12, "n":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lminigame/Racing;->sp:[Ldm/Sprite;

    aget-object v1, v1, v13

    iget-short v3, p0, Lminigame/Racing;->srcY:S

    sub-int v4, v14, v3

    move v3, v2

    move v5, v2

    move v6, v2

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawModuleOne(Ldm/Sprite;IIIII)V

    .line 400
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    if-lt v11, v12, :cond_0

    .line 402
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lminigame/Racing;->sp:[Ldm/Sprite;

    aget-object v1, v1, v13

    iget-short v3, p0, Lminigame/Racing;->srcY:S

    sub-int v4, v14, v3

    move v3, v10

    move v5, v13

    move v6, v2

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawModuleOne(Ldm/Sprite;IIIII)V

    .line 403
    return-void

    .line 401
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    iget-object v0, p0, Lminigame/Racing;->sp:[Ldm/Sprite;

    aget-object v4, v0, v13

    mul-int/lit8 v0, v11, 0x23

    add-int/lit8 v6, v0, 0x23

    const/16 v0, 0x2c

    iget-short v1, p0, Lminigame/Racing;->srcY:S

    sub-int v7, v0, v1

    move v5, v13

    move v8, v2

    move v9, v2

    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawModuleOne(Ldm/Sprite;IIIII)V

    .line 400
    add-int/lit8 v11, v11, 0x1

    goto :goto_0
.end method

.method private drawGame()V
    .locals 19

    .prologue
    .line 224
    const/16 v6, 0x280

    .local v6, "WIDTH":I
    const/16 v7, 0x168

    .line 225
    .local v7, "HEIGHT":I
    const/16 v17, 0x140

    .local v17, "WIDTH_H":I
    const/16 v16, 0xb4

    .line 226
    .local v16, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const v3, 0x52c0ff

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->fillRect(IIIII)V

    .line 227
    invoke-direct/range {p0 .. p0}, Lminigame/Racing;->drawCloud()V

    .line 228
    invoke-direct/range {p0 .. p0}, Lminigame/Racing;->drawEnd()V

    .line 230
    const/16 v18, 0x0

    .local v18, "i":B
    :goto_0
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Racing;->length:B

    move v2, v0

    move/from16 v0, v18

    move v1, v2

    if-lt v0, v1, :cond_1

    .line 246
    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Racing;->state:B

    move v2, v0

    const/4 v3, 0x3

    if-ne v2, v3, :cond_0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Racing;->time:B

    move v2, v0

    if-eqz v2, :cond_0

    .line 247
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-byte v0, v0, Lminigame/Racing;->time:B

    move v3, v0

    div-int/lit8 v3, v3, 0x14

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v2, 0x5

    sub-int v10, v17, v2

    const/4 v12, 0x0

    const/4 v13, 0x2

    move/from16 v11, v16

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 248
    :cond_0
    return-void

    .line 237
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v3, v18, 0x1

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    mul-int/lit8 v2, v18, 0x64

    add-int/lit8 v2, v2, 0x7d

    add-int/lit8 v10, v2, 0x16

    const/16 v2, 0x14

    move-object/from16 v0, p0

    iget-short v0, v0, Lminigame/Racing;->srcY:S

    move v3, v0

    sub-int v11, v2, v3

    const/4 v12, 0x1

    const/4 v13, 0x2

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 238
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->sp:[Ldm/Sprite;

    move-object v2, v0

    const/4 v3, 0x0

    aget-object v9, v2, v3

    const/4 v10, 0x1

    mul-int/lit8 v2, v18, 0x64

    add-int/lit8 v2, v2, 0x7d

    add-int/lit8 v11, v2, 0x16

    .line 239
    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->monY:[S

    move-object v2, v0

    aget-short v2, v2, v18

    move-object/from16 v0, p0

    iget-short v0, v0, Lminigame/Racing;->srcY:S

    move v3, v0

    sub-int v12, v2, v3

    move-object/from16 v0, p0

    iget-object v0, v0, Lminigame/Racing;->now_a:[[B

    move-object v2, v0

    aget-object v13, v2, v18

    const/4 v14, 0x0

    const/4 v15, 0x1

    .line 238
    invoke-virtual/range {v8 .. v15}, Ldm/Ui;->drawActionOne(Ldm/Sprite;III[BIZ)Z

    .line 230
    add-int/lit8 v2, v18, 0x1

    move v0, v2

    int-to-byte v0, v0

    move/from16 v18, v0

    goto/16 :goto_0
.end method

.method private isNpcSrc(II)Z
    .locals 2
    .param p1, "ax"    # I
    .param p2, "ay"    # I

    .prologue
    .line 393
    const/16 v0, -0x28

    if-lt p1, v0, :cond_0

    .line 394
    iget-short v0, p0, Lminigame/Racing;->srcY:S

    sub-int v0, p2, v0

    sget v1, Lmain/Constants_H;->HEIGHT:I

    add-int/lit8 v1, v1, 0x14

    if-gt v0, v1, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    .line 393
    goto :goto_0
.end method

.method private nullGame()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 35
    iput-object v0, p0, Lminigame/Racing;->sp:[Ldm/Sprite;

    .line 36
    iput-object v0, p0, Lminigame/Racing;->myDate:[B

    .line 37
    iput-object v0, p0, Lminigame/Racing;->money:[S

    .line 38
    iput-object v0, p0, Lminigame/Racing;->now_a:[[B

    .line 39
    iput-object v0, p0, Lminigame/Racing;->monY:[S

    .line 40
    iput-object v0, p0, Lminigame/Racing;->imgCloud:Ljavax/microedition/lcdui/Image;

    .line 41
    iput-object v0, p0, Lminigame/Racing;->cloud:[[S

    .line 42
    iput-object v0, p0, Lminigame/Racing;->gDate:[[S

    .line 43
    return-void
.end method

.method private setSpeed()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x4

    .line 251
    iget-byte v1, p0, Lminigame/Racing;->speedLv:B

    iget-object v2, p0, Lminigame/Racing;->gDate:[[S

    array-length v2, v2

    if-lt v1, v2, :cond_1

    .line 258
    :cond_0
    :goto_0
    return-void

    .line 253
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_1
    if-lt v0, v6, :cond_3

    .line 254
    :cond_2
    if-ge v0, v6, :cond_0

    .line 255
    const/4 v0, 0x0

    :goto_2
    if-lt v0, v6, :cond_4

    .line 257
    iget-byte v1, p0, Lminigame/Racing;->speedLv:B

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    iput-byte v1, p0, Lminigame/Racing;->speedLv:B

    goto :goto_0

    .line 253
    :cond_3
    iget-object v1, p0, Lminigame/Racing;->monY:[S

    aget-short v1, v1, v0

    iget-object v2, p0, Lminigame/Racing;->gDate:[[S

    iget-byte v3, p0, Lminigame/Racing;->speedLv:B

    aget-object v2, v2, v3

    const/4 v3, 0x0

    aget-short v2, v2, v3

    if-le v1, v2, :cond_2

    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_1

    .line 256
    :cond_4
    iget-object v1, p0, Lminigame/Racing;->now_a:[[B

    aget-object v1, v1, v0

    const/4 v2, 0x2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v3, p0, Lminigame/Racing;->gDate:[[S

    iget-byte v4, p0, Lminigame/Racing;->speedLv:B

    aget-object v3, v3, v4

    aget-short v3, v3, v7

    invoke-static {v3}, Ldm/Ms;->getRandom(I)I

    move-result v3

    iget-object v4, p0, Lminigame/Racing;->gDate:[[S

    iget-byte v5, p0, Lminigame/Racing;->speedLv:B

    aget-object v4, v4, v5

    aget-short v4, v4, v7

    add-int/2addr v3, v4

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 255
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_2
.end method


# virtual methods
.method public go(I)V
    .locals 8
    .param p1, "mode"    # I

    .prologue
    const/16 v7, 0x32

    const/4 v6, 0x2

    const/4 v3, 0x3

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 268
    if-ge p1, v5, :cond_1

    .line 269
    iput-byte v4, p0, Lminigame/Racing;->sel:B

    .line 270
    iput-byte v4, p0, Lminigame/Racing;->state:B

    .line 271
    iput-byte v3, p0, Lminigame/Racing;->length:B

    .line 272
    iget-object v1, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    const-string v2, "\u4e00\u6ce8\uff1a#n\u6295\u5165100\u91d1\uff0c#n\u83b7\u80dc\u5f97120\u91d1\u3002#n\u4e8c\u6ce8\uff1a#n\u6295\u5165300\u91d1\uff0c#n\u83b7\u80dc\u5f97350\u91d1\u3002#n\u4e09\u6ce8\uff1a#n\u6295\u51651000\u91d1\uff0c#n\u83b7\u80dc\u5f971200\u91d1\u3002"

    sget v3, Lmain/Constants_H;->WIDTH:I

    sub-int/2addr v3, v7

    invoke-virtual {v1, v2, v3, v4}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 273
    iget-object v1, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    const-string v2, "\u4e00\u6ce8100\u91d1#n\u4e8c\u6ce8300\u91d1#n\u4e09\u6ce81000\u91d1"

    sget v3, Lmain/Constants_H;->WIDTH:I

    sub-int/2addr v3, v7

    invoke-virtual {v1, v2, v3, v5}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 300
    :cond_0
    :goto_0
    return-void

    .line 274
    :cond_1
    if-ne p1, v5, :cond_2

    .line 275
    iget-object v1, p0, Lminigame/Racing;->myDate:[B

    iget-byte v2, p0, Lminigame/Racing;->sel:B

    aput-byte v2, v1, v4

    .line 276
    iput-byte v4, p0, Lminigame/Racing;->sel:B

    .line 277
    iput-byte v5, p0, Lminigame/Racing;->state:B

    .line 278
    const/4 v1, 0x4

    iput-byte v1, p0, Lminigame/Racing;->length:B

    goto :goto_0

    .line 284
    :cond_2
    if-ne p1, v6, :cond_3

    .line 285
    iget-object v1, p0, Lminigame/Racing;->myDate:[B

    iget-byte v2, p0, Lminigame/Racing;->sel:B

    aput-byte v2, v1, v5

    .line 286
    iput-byte v4, p0, Lminigame/Racing;->sel:B

    .line 287
    iput-byte v6, p0, Lminigame/Racing;->state:B

    goto :goto_0

    .line 288
    :cond_3
    if-ne p1, v3, :cond_0

    .line 289
    iget-object v1, p0, Lminigame/Racing;->myDate:[B

    iget-byte v2, p0, Lminigame/Racing;->sel:B

    aput-byte v2, v1, v6

    .line 290
    iput-byte v4, p0, Lminigame/Racing;->sel:B

    .line 291
    iput-byte v3, p0, Lminigame/Racing;->state:B

    .line 292
    const/16 v1, 0x5a

    iput-short v1, p0, Lminigame/Racing;->srcY:S

    .line 293
    iput-byte v4, p0, Lminigame/Racing;->speedLv:B

    .line 294
    iget-object v1, p0, Lminigame/Racing;->myDate:[B

    const/4 v2, -0x1

    aput-byte v2, v1, v3

    .line 295
    const/16 v1, 0x46

    iput-byte v1, p0, Lminigame/Racing;->time:B

    .line 297
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_1
    iget-byte v1, p0, Lminigame/Racing;->length:B

    if-lt v0, v1, :cond_4

    .line 298
    const/4 v0, 0x0

    :goto_2
    iget-object v1, p0, Lminigame/Racing;->cloud:[[S

    array-length v1, v1

    if-ge v0, v1, :cond_0

    invoke-direct {p0, v0}, Lminigame/Racing;->addCloud(I)V

    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_2

    .line 297
    :cond_4
    iget-object v1, p0, Lminigame/Racing;->monY:[S

    const/16 v2, 0x1c2

    aput-short v2, v1, v0

    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_1
.end method

.method public go(II)V
    .locals 5
    .param p1, "mode"    # I
    .param p2, "lv_"    # I

    .prologue
    const/4 v4, 0x1

    .line 260
    int-to-byte v0, p2

    iput-byte v0, p0, Lminigame/Racing;->lv:B

    .line 261
    const/4 v0, 0x3

    new-array v0, v0, [Ldm/Sprite;

    iput-object v0, p0, Lminigame/Racing;->sp:[Ldm/Sprite;

    .line 262
    iget-object v0, p0, Lminigame/Racing;->sp:[Ldm/Sprite;

    const/4 v1, 0x0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    const-string v3, "data/npc0/67"

    invoke-virtual {v2, v3, v4}, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;

    move-result-object v2

    aput-object v2, v0, v1

    .line 263
    iget-object v0, p0, Lminigame/Racing;->sp:[Ldm/Sprite;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/brow/m1"

    invoke-virtual {v1, v2, v4}, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;

    move-result-object v1

    aput-object v1, v0, v4

    .line 264
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "data/cloud"

    invoke-virtual {v0, v1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Lminigame/Racing;->imgCloud:Ljavax/microedition/lcdui/Image;

    .line 265
    invoke-virtual {p0, p1}, Lminigame/Racing;->go(I)V

    .line 266
    return-void
.end method

.method public key()Z
    .locals 5

    .prologue
    const/4 v1, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 302
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v4

    .line 326
    :goto_0
    return v0

    .line 303
    :cond_0
    iget-byte v0, p0, Lminigame/Racing;->state:B

    if-nez v0, :cond_4

    .line 305
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lminigame/Racing;->sel:B

    iget-byte v2, p0, Lminigame/Racing;->length:B

    sub-int/2addr v2, v3

    invoke-virtual {v0, v1, v4, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lminigame/Racing;->sel:B

    :cond_1
    :goto_1
    move v0, v4

    .line 326
    goto :goto_0

    .line 309
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget-object v1, p0, Lminigame/Racing;->money:[S

    iget-byte v2, p0, Lminigame/Racing;->sel:B

    shl-int/lit8 v2, v2, 0x1

    aget-short v1, v1, v2

    invoke-virtual {v0, v1, v3}, Lmain/GameRun;->isMoney(IZ)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-virtual {p0, v3}, Lminigame/Racing;->go(I)V

    goto :goto_1

    .line 310
    :cond_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 311
    invoke-direct {p0}, Lminigame/Racing;->nullGame()V

    move v0, v3

    .line 312
    goto :goto_0

    .line 314
    :cond_4
    iget-byte v0, p0, Lminigame/Racing;->state:B

    if-ne v0, v3, :cond_6

    .line 315
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lminigame/Racing;->sel:B

    iget-byte v2, p0, Lminigame/Racing;->length:B

    sub-int/2addr v2, v3

    invoke-virtual {v0, v1, v4, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lminigame/Racing;->sel:B

    goto :goto_1

    .line 316
    :cond_5
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0, v1}, Lminigame/Racing;->go(I)V

    goto :goto_1

    .line 317
    :cond_6
    iget-byte v0, p0, Lminigame/Racing;->state:B

    if-ne v0, v1, :cond_1

    .line 318
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lminigame/Racing;->sel:B

    iget-byte v2, p0, Lminigame/Racing;->length:B

    sub-int/2addr v2, v3

    invoke-virtual {v0, v1, v4, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lminigame/Racing;->sel:B

    goto :goto_1

    .line 319
    :cond_7
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_8

    iget-object v0, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget-byte v1, p0, Lminigame/Racing;->sel:B

    mul-int/lit8 v1, v1, 0xa

    invoke-virtual {v0, v1, v3}, Lmain/GameRun;->isMoney(IZ)Z

    move-result v0

    if-eqz v0, :cond_8

    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lminigame/Racing;->go(I)V

    goto/16 :goto_1

    .line 320
    :cond_8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 321
    iget-object v0, p0, Lminigame/Racing;->myDate:[B

    aget-byte v0, v0, v3

    iput-byte v0, p0, Lminigame/Racing;->sel:B

    .line 322
    iput-byte v3, p0, Lminigame/Racing;->state:B

    goto/16 :goto_1
.end method

.method public patin()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    .line 333
    iget-byte v0, p0, Lminigame/Racing;->state:B

    if-eqz v0, :cond_0

    iget-byte v0, p0, Lminigame/Racing;->state:B

    if-eq v0, v4, :cond_0

    iget-byte v0, p0, Lminigame/Racing;->state:B

    if-ne v0, v5, :cond_3

    .line 334
    :cond_0
    const/16 v0, 0xa

    const/4 v1, 0x5

    const/16 v2, 0x145

    const/16 v3, 0x19

    invoke-direct {p0, v0, v1, v2, v3}, Lminigame/Racing;->draw0(IIII)V

    .line 335
    iget-byte v0, p0, Lminigame/Racing;->state:B

    if-eq v0, v4, :cond_1

    iget-byte v0, p0, Lminigame/Racing;->state:B

    if-ne v0, v5, :cond_2

    :cond_1
    const/16 v0, 0xc6

    const/16 v1, 0xf

    const/16 v2, 0x4c

    invoke-direct {p0, v0, v1, v2}, Lminigame/Racing;->draw1(III)V

    .line 343
    :cond_2
    :goto_0
    return-void

    .line 342
    :cond_3
    invoke-direct {p0}, Lminigame/Racing;->drawGame()V

    goto :goto_0
.end method

.method public run()V
    .locals 11

    .prologue
    const/4 v10, -0x1

    const/4 v9, 0x4

    const/4 v8, 0x1

    const/4 v7, 0x3

    const/4 v6, 0x0

    .line 345
    iget-byte v2, p0, Lminigame/Racing;->state:B

    if-ne v2, v7, :cond_7

    .line 346
    iget-byte v2, p0, Lminigame/Racing;->time:B

    if-nez v2, :cond_6

    .line 347
    invoke-direct {p0}, Lminigame/Racing;->setSpeed()V

    .line 348
    iget-object v2, p0, Lminigame/Racing;->myDate:[B

    aget-byte v2, v2, v7

    if-eq v2, v10, :cond_1

    .line 349
    const/4 v2, 0x5

    iput-byte v2, p0, Lminigame/Racing;->time:B

    .line 350
    iput-byte v9, p0, Lminigame/Racing;->state:B

    .line 375
    :cond_0
    :goto_0
    return-void

    .line 353
    :cond_1
    const/4 v1, -0x1

    .line 354
    .local v1, "j":B
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_1
    if-lt v0, v9, :cond_3

    .line 359
    if-eq v1, v10, :cond_2

    iget-short v2, p0, Lminigame/Racing;->srcY:S

    iget-object v3, p0, Lminigame/Racing;->now_a:[[B

    aget-object v3, v3, v1

    const/4 v4, 0x2

    aget-byte v3, v3, v4

    sub-int/2addr v2, v3

    int-to-short v2, v2

    iput-short v2, p0, Lminigame/Racing;->srcY:S

    .line 360
    :cond_2
    iget-short v2, p0, Lminigame/Racing;->srcY:S

    if-gez v2, :cond_0

    iput-short v6, p0, Lminigame/Racing;->srcY:S

    goto :goto_0

    .line 355
    :cond_3
    iget-object v2, p0, Lminigame/Racing;->monY:[S

    aget-short v3, v2, v0

    iget-object v4, p0, Lminigame/Racing;->now_a:[[B

    aget-object v4, v4, v0

    const/4 v5, 0x2

    aget-byte v4, v4, v5

    sub-int/2addr v3, v4

    int-to-short v3, v3

    aput-short v3, v2, v0

    .line 356
    iget-object v2, p0, Lminigame/Racing;->monY:[S

    aget-short v2, v2, v0

    iget-short v3, p0, Lminigame/Racing;->srcY:S

    sub-int/2addr v2, v3

    sget v3, Lmain/Constants_H;->HEIGHT_H:I

    if-ge v2, v3, :cond_4

    move v1, v0

    .line 357
    :cond_4
    iget-object v2, p0, Lminigame/Racing;->monY:[S

    aget-short v2, v2, v0

    const/16 v3, 0x46

    if-ge v2, v3, :cond_5

    iget-object v2, p0, Lminigame/Racing;->myDate:[B

    aget-byte v2, v2, v7

    if-ne v2, v10, :cond_5

    iget-object v2, p0, Lminigame/Racing;->myDate:[B

    aput-byte v0, v2, v7

    .line 354
    :cond_5
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    goto :goto_1

    .line 361
    .end local v0    # "i":B
    .end local v1    # "j":B
    :cond_6
    iget-byte v2, p0, Lminigame/Racing;->time:B

    sub-int/2addr v2, v8

    int-to-byte v2, v2

    iput-byte v2, p0, Lminigame/Racing;->time:B

    goto :goto_0

    .line 362
    :cond_7
    iget-byte v2, p0, Lminigame/Racing;->state:B

    if-ne v2, v9, :cond_0

    .line 363
    iget-byte v2, p0, Lminigame/Racing;->time:B

    if-ne v2, v7, :cond_8

    .line 364
    iget-object v2, p0, Lminigame/Racing;->myDate:[B

    aget-byte v2, v2, v7

    iget-object v3, p0, Lminigame/Racing;->myDate:[B

    aget-byte v3, v3, v8

    if-ne v2, v3, :cond_9

    .line 365
    iget-object v2, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget v3, v2, Lmain/GameRun;->money:I

    iget-object v4, p0, Lminigame/Racing;->money:[S

    iget-object v5, p0, Lminigame/Racing;->myDate:[B

    aget-byte v5, v5, v6

    mul-int/lit8 v5, v5, 0x2

    add-int/lit8 v5, v5, 0x1

    aget-short v4, v4, v5

    add-int/2addr v3, v4

    iput v3, v2, Lmain/GameRun;->money:I

    .line 366
    iget-object v2, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\u83b7\u5f97\uff1a"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lminigame/Racing;->money:[S

    iget-object v5, p0, Lminigame/Racing;->myDate:[B

    aget-byte v5, v5, v6

    mul-int/lit8 v5, v5, 0x2

    add-int/lit8 v5, v5, 0x1

    aget-short v4, v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\u91d1"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 367
    iget-object v2, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->rmsOther:[B

    aget-byte v3, v2, v9

    iget-byte v4, p0, Lminigame/Racing;->lv:B

    shl-int v4, v8, v4

    or-int/2addr v3, v4

    int-to-byte v3, v3

    aput-byte v3, v2, v9

    .line 370
    :cond_8
    :goto_2
    iget-byte v2, p0, Lminigame/Racing;->time:B

    if-lez v2, :cond_a

    iget-byte v2, p0, Lminigame/Racing;->time:B

    sub-int/2addr v2, v8

    int-to-byte v2, v2

    iput-byte v2, p0, Lminigame/Racing;->time:B

    goto/16 :goto_0

    .line 368
    :cond_9
    iget-object v2, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    const-string v3, "\u4e0d\u597d\u610f\u601d\uff0c\u6ca1\u6709\u731c\u5bf9\u3002"

    invoke-virtual {v2, v3, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_2

    .line 371
    :cond_a
    iget-byte v2, p0, Lminigame/Racing;->time:B

    if-nez v2, :cond_0

    iget-object v2, p0, Lminigame/Racing;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->say_c:B

    if-nez v2, :cond_0

    .line 372
    invoke-virtual {p0, v6}, Lminigame/Racing;->go(I)V

    goto/16 :goto_0
.end method
