.class public Lmain/PointerKey;
.super Ljava/lang/Object;
.source "PointerKey.java"

# interfaces
.implements Lmain/Key_H;


# instance fields
.field public button_pos:[[[I

.field dir:Z

.field gox:I

.field goy:I

.field gr:Lmain/GameRun;

.field i0:I

.field i1:I

.field isGo:Z

.field m0:I

.field m1:I

.field map:Lmain/Map;

.field mc:Lmain/MainCanvas;

.field tempx:I

.field tempy:I


# direct methods
.method public constructor <init>(Lmain/MainCanvas;)V
    .locals 13
    .param p1, "mc_"    # Lmain/MainCanvas;

    .prologue
    const/4 v12, 0x3

    const/16 v11, 0x3c

    const/4 v10, 0x1

    const/4 v9, 0x2

    const/4 v8, 0x5

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    const/16 v0, 0xb

    new-array v0, v0, [[[I

    const/4 v1, 0x0

    .line 55
    new-array v2, v9, [[I

    const/4 v3, 0x0

    new-array v4, v8, [I

    sget v5, Lmain/Constants_H;->HEIGHT:I

    const/16 v6, 0x32

    sub-int/2addr v5, v6

    aput v5, v4, v10

    const/16 v5, 0x32

    aput v5, v4, v9

    const/16 v5, 0x32

    aput v5, v4, v12

    const/4 v5, 0x4

    const/4 v6, -0x6

    aput v6, v4, v5

    aput-object v4, v2, v3

    .line 56
    new-array v3, v8, [I

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH:I

    const/16 v6, 0x32

    sub-int/2addr v5, v6

    aput v5, v3, v4

    sget v4, Lmain/Constants_H;->HEIGHT:I

    const/16 v5, 0x32

    sub-int/2addr v4, v5

    aput v4, v3, v10

    const/16 v4, 0x32

    aput v4, v3, v9

    const/16 v4, 0x32

    aput v4, v3, v12

    const/4 v4, 0x4

    const/4 v5, -0x7

    aput v5, v3, v4

    aput-object v3, v2, v10

    aput-object v2, v0, v1

    .line 58
    new-array v1, v10, [[I

    const/4 v2, 0x0

    new-array v3, v8, [I

    sget v4, Lmain/Constants_H;->WIDTH:I

    aput v4, v3, v9

    sget v4, Lmain/Constants_H;->HEIGHT:I

    aput v4, v3, v12

    const/4 v4, 0x4

    const/16 v5, 0x30

    aput v5, v3, v4

    aput-object v3, v1, v2

    aput-object v1, v0, v10

    .line 60
    new-array v1, v10, [[I

    const/4 v2, 0x0

    new-array v3, v8, [I

    sget v4, Lmain/Constants_H;->WIDTH:I

    aput v4, v3, v9

    sget v4, Lmain/Constants_H;->HEIGHT:I

    aput v4, v3, v12

    const/4 v4, 0x4

    const/16 v5, 0x35

    aput v5, v3, v4

    aput-object v3, v1, v2

    aput-object v1, v0, v9

    .line 62
    new-array v1, v12, [[I

    const/4 v2, 0x0

    new-array v3, v8, [I

    fill-array-data v3, :array_0

    aput-object v3, v1, v2

    .line 63
    new-array v2, v8, [I

    fill-array-data v2, :array_1

    aput-object v2, v1, v10

    .line 64
    new-array v2, v8, [I

    fill-array-data v2, :array_2

    aput-object v2, v1, v9

    aput-object v1, v0, v12

    const/4 v1, 0x4

    .line 66
    new-array v2, v9, [[I

    const/4 v3, 0x0

    new-array v4, v8, [I

    const/16 v5, 0x140

    aput v5, v4, v9

    const/16 v5, 0x168

    aput v5, v4, v12

    const/4 v5, 0x4

    const/4 v6, -0x3

    aput v6, v4, v5

    aput-object v4, v2, v3

    .line 67
    new-array v3, v8, [I

    const/4 v4, 0x0

    const/16 v5, 0x140

    aput v5, v3, v4

    const/16 v4, 0x140

    aput v4, v3, v9

    const/16 v4, 0x168

    aput v4, v3, v12

    const/4 v4, 0x4

    const/4 v5, -0x4

    aput v5, v3, v4

    aput-object v3, v2, v10

    aput-object v2, v0, v1

    .line 69
    new-array v1, v8, [[I

    const/4 v2, 0x0

    new-array v3, v8, [I

    fill-array-data v3, :array_3

    aput-object v3, v1, v2

    new-array v2, v8, [I

    fill-array-data v2, :array_4

    aput-object v2, v1, v10

    .line 70
    new-array v2, v8, [I

    fill-array-data v2, :array_5

    aput-object v2, v1, v9

    new-array v2, v8, [I

    fill-array-data v2, :array_6

    aput-object v2, v1, v12

    const/4 v2, 0x4

    .line 71
    new-array v3, v8, [I

    fill-array-data v3, :array_7

    aput-object v3, v1, v2

    aput-object v1, v0, v8

    const/4 v1, 0x6

    .line 105
    const/4 v2, 0x7

    new-array v2, v2, [[I

    const/4 v3, 0x0

    new-array v4, v8, [I

    const/4 v5, 0x0

    sget v6, Lmain/Constants_H;->WIDTH__:I

    sub-int/2addr v6, v11

    aput v6, v4, v5

    sget v5, Lmain/Constants_H;->HEIGHT__:I

    sub-int/2addr v5, v11

    aput v5, v4, v10

    aput v11, v4, v9

    aput v11, v4, v12

    const/4 v5, 0x4

    const/16 v6, 0x270f

    aput v6, v4, v5

    aput-object v4, v2, v3

    new-array v3, v8, [I

    sget v4, Lmain/Constants_H;->HEIGHT__:I

    sub-int/2addr v4, v11

    aput v4, v3, v10

    aput v11, v3, v9

    aput v11, v3, v12

    const/4 v4, 0x4

    .line 106
    const/16 v5, 0x270f

    aput v5, v3, v4

    aput-object v3, v2, v10

    .line 107
    new-array v3, v8, [I

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH__:I

    sub-int/2addr v5, v11

    aput v5, v3, v4

    sget v4, Lmain/Constants_H;->HEIGHT__:I

    sub-int/2addr v4, v11

    const/16 v5, 0x78

    sub-int/2addr v4, v5

    const/16 v5, 0x28

    sub-int/2addr v4, v5

    aput v4, v3, v10

    aput v11, v3, v9

    aput v11, v3, v12

    const/4 v4, 0x4

    const/16 v5, 0x270f

    aput v5, v3, v4

    aput-object v3, v2, v9

    new-array v3, v8, [I

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH__:I

    sub-int/2addr v5, v11

    aput v5, v3, v4

    sget v4, Lmain/Constants_H;->HEIGHT__:I

    sub-int/2addr v4, v11

    sub-int/2addr v4, v11

    const/16 v5, 0x14

    sub-int/2addr v4, v5

    aput v4, v3, v10

    aput v11, v3, v9

    aput v11, v3, v12

    const/4 v4, 0x4

    .line 108
    const/16 v5, 0x270f

    aput v5, v3, v4

    aput-object v3, v2, v12

    const/4 v3, 0x4

    .line 109
    new-array v4, v8, [I

    const/4 v5, 0x0

    sget v6, Lmain/Constants_H;->WIDTH__:I

    sub-int/2addr v6, v11

    const/16 v7, 0x78

    sub-int/2addr v6, v7

    const/16 v7, 0x28

    sub-int/2addr v6, v7

    aput v6, v4, v5

    sget v5, Lmain/Constants_H;->HEIGHT__:I

    sub-int/2addr v5, v11

    aput v5, v4, v10

    aput v11, v4, v9

    aput v11, v4, v12

    const/4 v5, 0x4

    const/16 v6, 0x270f

    aput v6, v4, v5

    aput-object v4, v2, v3

    new-array v3, v8, [I

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH__:I

    sub-int/2addr v5, v11

    sub-int/2addr v5, v11

    const/16 v6, 0x14

    sub-int/2addr v5, v6

    aput v5, v3, v4

    sget v4, Lmain/Constants_H;->HEIGHT__:I

    sub-int/2addr v4, v11

    aput v4, v3, v10

    aput v11, v3, v9

    .line 111
    aput v11, v3, v12

    const/4 v4, 0x4

    const/16 v5, 0x270f

    aput v5, v3, v4

    aput-object v3, v2, v8

    const/4 v3, 0x6

    new-array v4, v8, [I

    const/4 v5, 0x0

    sget v6, Lmain/Constants_H;->WIDTH__:I

    sub-int/2addr v6, v11

    aput v6, v4, v5

    sget v5, Lmain/Constants_H;->HEIGHT__:I

    sub-int/2addr v5, v11

    const/16 v6, 0xb4

    sub-int/2addr v5, v6

    sub-int/2addr v5, v11

    aput v5, v4, v10

    aput v11, v4, v9

    aput v11, v4, v12

    const/4 v5, 0x4

    const/16 v6, 0x270f

    aput v6, v4, v5

    aput-object v4, v2, v3

    aput-object v2, v0, v1

    const/4 v1, 0x7

    .line 113
    new-array v2, v10, [[I

    const/4 v3, 0x0

    new-array v4, v8, [I

    const/4 v5, 0x0

    sget v6, Lmain/Constants_H;->WIDTH:I

    const/16 v7, 0x32

    sub-int/2addr v6, v7

    aput v6, v4, v5

    sget v5, Lmain/Constants_H;->HEIGHT:I

    const/16 v6, 0x32

    sub-int/2addr v5, v6

    aput v5, v4, v10

    const/16 v5, 0x32

    aput v5, v4, v9

    const/16 v5, 0x32

    aput v5, v4, v12

    const/4 v5, 0x4

    const/4 v6, -0x7

    aput v6, v4, v5

    aput-object v4, v2, v3

    aput-object v2, v0, v1

    const/16 v1, 0x8

    .line 116
    new-array v2, v9, [[I

    const/4 v3, 0x0

    new-array v4, v8, [I

    const/16 v5, 0x136

    aput v5, v4, v10

    const/16 v5, 0x32

    aput v5, v4, v9

    const/16 v5, 0x32

    aput v5, v4, v12

    const/4 v5, 0x4

    const/4 v6, -0x6

    aput v6, v4, v5

    aput-object v4, v2, v3

    .line 117
    new-array v3, v8, [I

    fill-array-data v3, :array_8

    aput-object v3, v2, v10

    aput-object v2, v0, v1

    const/16 v1, 0x9

    .line 119
    new-array v2, v10, [[I

    const/4 v3, 0x0

    new-array v4, v8, [I

    const/16 v5, 0x280

    aput v5, v4, v9

    const/16 v5, 0x168

    aput v5, v4, v12

    const/4 v5, 0x4

    const/16 v6, 0x30

    aput v6, v4, v5

    aput-object v4, v2, v3

    aput-object v2, v0, v1

    const/16 v1, 0xa

    .line 122
    const/4 v2, 0x7

    new-array v2, v2, [[I

    const/4 v3, 0x0

    new-array v4, v8, [I

    const/4 v5, 0x0

    sget v6, Lmain/Constants_H;->WIDTH:I

    const/16 v7, 0x1e

    sub-int/2addr v6, v7

    aput v6, v4, v5

    sget v5, Lmain/Constants_H;->HEIGHT:I

    const/16 v6, 0x1e

    sub-int/2addr v5, v6

    aput v5, v4, v10

    const/16 v5, 0x1e

    aput v5, v4, v9

    const/16 v5, 0x1e

    aput v5, v4, v12

    const/4 v5, 0x4

    const/16 v6, 0x270f

    aput v6, v4, v5

    aput-object v4, v2, v3

    new-array v3, v8, [I

    sget v4, Lmain/Constants_H;->HEIGHT:I

    const/16 v5, 0x1e

    sub-int/2addr v4, v5

    aput v4, v3, v10

    const/16 v4, 0x1e

    aput v4, v3, v9

    const/16 v4, 0x1e

    aput v4, v3, v12

    const/4 v4, 0x4

    .line 123
    const/16 v5, 0x270f

    aput v5, v3, v4

    aput-object v3, v2, v10

    .line 124
    new-array v3, v8, [I

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH:I

    const/16 v6, 0x1e

    sub-int/2addr v5, v6

    aput v5, v3, v4

    sget v4, Lmain/Constants_H;->HEIGHT:I

    const/16 v5, 0x1e

    sub-int/2addr v4, v5

    const/16 v5, 0x5a

    sub-int/2addr v4, v5

    const/16 v5, 0x19

    sub-int/2addr v4, v5

    aput v4, v3, v10

    const/16 v4, 0x1e

    aput v4, v3, v9

    const/16 v4, 0x1e

    aput v4, v3, v12

    const/4 v4, 0x4

    const/16 v5, 0x270f

    aput v5, v3, v4

    aput-object v3, v2, v9

    new-array v3, v8, [I

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH:I

    const/16 v6, 0x1e

    sub-int/2addr v5, v6

    aput v5, v3, v4

    sget v4, Lmain/Constants_H;->HEIGHT:I

    const/16 v5, 0x1e

    sub-int/2addr v4, v5

    const/16 v5, 0x2d

    sub-int/2addr v4, v5

    const/16 v5, 0xf

    sub-int/2addr v4, v5

    aput v4, v3, v10

    const/16 v4, 0x1e

    aput v4, v3, v9

    const/16 v4, 0x1e

    aput v4, v3, v12

    const/4 v4, 0x4

    .line 125
    const/16 v5, 0x270f

    aput v5, v3, v4

    aput-object v3, v2, v12

    const/4 v3, 0x4

    .line 126
    new-array v4, v8, [I

    const/4 v5, 0x0

    sget v6, Lmain/Constants_H;->WIDTH:I

    const/16 v7, 0x1e

    sub-int/2addr v6, v7

    const/16 v7, 0x5a

    sub-int/2addr v6, v7

    const/16 v7, 0x28

    sub-int/2addr v6, v7

    aput v6, v4, v5

    sget v5, Lmain/Constants_H;->HEIGHT:I

    const/16 v6, 0x1e

    sub-int/2addr v5, v6

    aput v5, v4, v10

    const/16 v5, 0x1e

    aput v5, v4, v9

    const/16 v5, 0x1e

    aput v5, v4, v12

    const/4 v5, 0x4

    const/16 v6, 0x270f

    aput v6, v4, v5

    aput-object v4, v2, v3

    new-array v3, v8, [I

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH:I

    const/16 v6, 0x1e

    sub-int/2addr v5, v6

    const/16 v6, 0x2d

    sub-int/2addr v5, v6

    const/16 v6, 0x14

    sub-int/2addr v5, v6

    aput v5, v3, v4

    sget v4, Lmain/Constants_H;->HEIGHT:I

    const/16 v5, 0x1e

    sub-int/2addr v4, v5

    aput v4, v3, v10

    const/16 v4, 0x1e

    aput v4, v3, v9

    .line 127
    const/16 v4, 0x1e

    aput v4, v3, v12

    const/4 v4, 0x4

    const/16 v5, 0x270f

    aput v5, v3, v4

    aput-object v3, v2, v8

    const/4 v3, 0x6

    new-array v4, v8, [I

    const/4 v5, 0x0

    sget v6, Lmain/Constants_H;->WIDTH:I

    const/16 v7, 0x1e

    sub-int/2addr v6, v7

    aput v6, v4, v5

    sget v5, Lmain/Constants_H;->HEIGHT:I

    const/16 v6, 0x1e

    sub-int/2addr v5, v6

    const/16 v6, 0x87

    sub-int/2addr v5, v6

    const/16 v6, 0x23

    sub-int/2addr v5, v6

    aput v5, v4, v10

    const/16 v5, 0x1e

    aput v5, v4, v9

    const/16 v5, 0x1e

    aput v5, v4, v12

    const/4 v5, 0x4

    const/16 v6, 0x270f

    aput v6, v4, v5

    aput-object v4, v2, v3

    aput-object v2, v0, v1

    iput-object v0, p0, Lmain/PointerKey;->button_pos:[[[I

    .line 340
    const/4 v0, -0x1

    iput v0, p0, Lmain/PointerKey;->i0:I

    const/4 v0, -0x1

    iput v0, p0, Lmain/PointerKey;->i1:I

    .line 16
    iput-object p1, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;

    .line 17
    iget-object v0, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    .line 18
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    iput-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    .line 19
    return-void

    .line 62
    :array_0
    .array-data 4
        0xaa
        0x113
        0x6a
        0x61
        -0x3
    .end array-data

    .line 63
    :array_1
    .array-data 4
        0x16b
        0x11d
        0x6c
        0x53
        -0x4
    .end array-data

    .line 64
    :array_2
    .array-data 4
        0x119
        0x122
        0x4c
        0x58
        0x35
    .end array-data

    .line 69
    :array_3
    .array-data 4
        0x1ce
        0x2a
        0x53
        0x48
        0x270f
    .end array-data

    :array_4
    .array-data 4
        0x224
        0x74
        0x53
        0x47
        0x270f
    .end array-data

    .line 70
    :array_5
    .array-data 4
        0x1d2
        0xb6
        0x55
        0x4b
        0x270f
    .end array-data

    :array_6
    .array-data 4
        0x20c
        0x10a
        0x5b
        0x44
        0x270f
    .end array-data

    .line 71
    :array_7
    .array-data 4
        0x30
        0x115
        0x57
        0x50
        0x270f
    .end array-data

    .line 117
    :array_8
    .array-data 4
        0x24e
        0x136
        0x32
        0x32
        -0x7
    .end array-data
.end method

.method private isMove(II)Z
    .locals 17
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 294
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->dir:B

    const/4 v2, 0x3

    if-ne v1, v2, :cond_1

    .line 295
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->x:S

    const/16 v2, 0x14

    sub-int v6, v1, v2

    .line 296
    .local v6, "npcX":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    const/16 v2, 0x3c

    sub-int v7, v1, v2

    .line 307
    .local v7, "npcY":I
    :goto_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/4 v4, 0x1

    const/4 v5, 0x1

    const/16 v8, 0x14

    const/16 v9, 0x50

    move/from16 v2, p1

    move/from16 v3, p2

    invoke-virtual/range {v1 .. v9}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v1

    if-nez v1, :cond_0

    .line 308
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v8

    move-object/from16 v0, p0

    iget v0, v0, Lmain/PointerKey;->i0:I

    move v9, v0

    move-object/from16 v0, p0

    iget v0, v0, Lmain/PointerKey;->i1:I

    move v10, v0

    const/4 v11, 0x1

    const/4 v12, 0x1

    sget v1, Lmain/Constants_H;->WIDTH_H:I

    const/16 v2, 0x1e

    sub-int v13, v1, v2

    sget v1, Lmain/Constants_H;->HEIGHT:I

    const/16 v2, 0x3c

    sub-int v14, v1, v2

    const/16 v15, 0x3c

    const/16 v16, 0x3c

    invoke-virtual/range {v8 .. v16}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 309
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v2, v0

    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v2, Ldm/Npc;->x:S

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v3, v0

    iget-object v3, v3, Lmain/Map;->my:Ldm/Npc;

    iget-short v3, v3, Ldm/Npc;->y:S

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v4, v0

    iget-object v4, v4, Lmain/Map;->dir_select:[[B

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v5, v0

    iget-object v5, v5, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->dir:B

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v5, v0

    iget-object v5, v5, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed:B

    mul-int/2addr v4, v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v5, v0

    iget-object v5, v5, Lmain/Map;->dir_select:[[B

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v6, v0

    .end local v6    # "npcX":I
    iget-object v6, v6, Lmain/Map;->my:Ldm/Npc;

    iget-byte v6, v6, Ldm/Npc;->dir:B

    aget-object v5, v5, v6

    const/4 v6, 0x1

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v6, v0

    iget-object v6, v6, Lmain/Map;->my:Ldm/Npc;

    iget-byte v6, v6, Ldm/Npc;->speed:B

    mul-int/2addr v5, v6

    invoke-virtual {v1, v2, v3, v4, v5}, Lmain/Map;->checkSoftKey(IIII)B

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_4

    .line 310
    const/4 v1, 0x0

    .line 311
    :goto_1
    return v1

    .line 297
    .end local v7    # "npcY":I
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->dir:B

    const/4 v2, 0x4

    if-ne v1, v2, :cond_2

    .line 298
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->x:S

    add-int/lit8 v6, v1, 0x14

    .line 299
    .restart local v6    # "npcX":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    const/16 v2, 0x3c

    sub-int v7, v1, v2

    .restart local v7    # "npcY":I
    goto/16 :goto_0

    .line 300
    .end local v6    # "npcX":I
    .end local v7    # "npcY":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->dir:B

    const/4 v2, 0x1

    if-ne v1, v2, :cond_3

    .line 301
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v6, v1, Ldm/Npc;->x:S

    .line 302
    .restart local v6    # "npcX":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    const/16 v2, 0x50

    sub-int v7, v1, v2

    .restart local v7    # "npcY":I
    goto/16 :goto_0

    .line 304
    .end local v6    # "npcX":I
    .end local v7    # "npcY":I
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v6, v1, Ldm/Npc;->x:S

    .line 305
    .restart local v6    # "npcX":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;

    move-object v1, v0

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    const/16 v2, 0x28

    sub-int v7, v1, v2

    .restart local v7    # "npcY":I
    goto/16 :goto_0

    .line 311
    .end local v6    # "npcX":I
    :cond_4
    const/4 v1, 0x1

    goto :goto_1
.end method


# virtual methods
.method public checkButton(I)I
    .locals 2
    .param p1, "check_no"    # I

    .prologue
    .line 22
    iget v0, p0, Lmain/PointerKey;->i0:I

    iget v1, p0, Lmain/PointerKey;->i1:I

    invoke-virtual {p0, p1, v0, v1}, Lmain/PointerKey;->checkButton(III)I

    move-result v0

    return v0
.end method

.method public checkButton(III)I
    .locals 12
    .param p1, "check_no"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I

    .prologue
    const/4 v11, 0x3

    const/4 v3, 0x2

    const/4 v10, 0x1

    .line 25
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    iget-object v0, p0, Lmain/PointerKey;->button_pos:[[[I

    aget-object v0, v0, p1

    array-length v0, v0

    if-lt v9, v0, :cond_0

    .line 37
    const/4 v0, -0x1

    :goto_1
    return v0

    .line 27
    :cond_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    sub-int v1, p2, v10

    sub-int v2, p3, v10

    iget-object v4, p0, Lmain/PointerKey;->button_pos:[[[I

    aget-object v4, v4, p1

    aget-object v4, v4, v9

    const/4 v5, 0x0

    aget v5, v4, v5

    iget-object v4, p0, Lmain/PointerKey;->button_pos:[[[I

    aget-object v4, v4, p1

    aget-object v4, v4, v9

    aget v6, v4, v10

    iget-object v4, p0, Lmain/PointerKey;->button_pos:[[[I

    aget-object v4, v4, p1

    aget-object v4, v4, v9

    aget v7, v4, v3

    iget-object v4, p0, Lmain/PointerKey;->button_pos:[[[I

    aget-object v4, v4, p1

    aget-object v4, v4, v9

    aget v8, v4, v11

    move v4, v3

    invoke-virtual/range {v0 .. v8}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 28
    iget-object v0, p0, Lmain/PointerKey;->button_pos:[[[I

    aget-object v0, v0, p1

    aget-object v0, v0, v9

    const/4 v1, 0x4

    aget v0, v0, v1

    sput v0, Ldm/Ms;->key:I

    .line 29
    if-ne p1, v11, :cond_1

    sget v0, Ldm/Ms;->key:I

    const/16 v1, 0x35

    if-ne v0, v1, :cond_1

    .line 30
    const-string v0, "touch"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u6309\u4e0b\u786e\u5b9a\u952e\u3002\u3002\u3002menu_state: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;

    iget v2, v2, Lmain/MainCanvas;->menu_state:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 32
    :cond_1
    sput-boolean v10, Ldm/Ms;->keyRepeat:Z

    .line 33
    invoke-virtual {p0}, Lmain/PointerKey;->initPointer()V

    move v0, v9

    .line 34
    goto :goto_1

    .line 25
    :cond_2
    add-int/lit8 v9, v9, 0x1

    goto :goto_0
.end method

.method public initPointer()V
    .locals 1

    .prologue
    const/4 v0, -0x1

    .line 342
    iput v0, p0, Lmain/PointerKey;->i1:I

    iput v0, p0, Lmain/PointerKey;->i0:I

    .line 343
    iput v0, p0, Lmain/PointerKey;->m1:I

    iput v0, p0, Lmain/PointerKey;->m0:I

    .line 344
    return-void
.end method

.method public isSelect(IIII)Z
    .locals 9
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    const/4 v3, 0x1

    .line 315
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget v1, p0, Lmain/PointerKey;->i0:I

    iget v2, p0, Lmain/PointerKey;->i1:I

    move v4, v3

    move v5, p1

    move v6, p2

    move v7, p3

    move v8, p4

    invoke-virtual/range {v0 .. v8}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 316
    invoke-virtual {p0}, Lmain/PointerKey;->initPointer()V

    move v0, v3

    .line 319
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public process(II)V
    .locals 7
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    const/16 v6, 0x11

    const/16 v5, 0x9

    const/16 v4, 0x8

    const/16 v3, -0xa

    const/4 v2, -0x1

    .line 176
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x14

    if-ne v0, v1, :cond_1

    const/4 v0, 0x7

    invoke-virtual {p0, v0, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    move-result v0

    if-eq v0, v2, :cond_1

    .line 218
    :cond_0
    :goto_0
    return-void

    .line 177
    :cond_1
    sget v0, Lmain/GameRun;->run_state:I

    if-ne v0, v3, :cond_3

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-eqz v0, :cond_2

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x14

    if-ne v0, v1, :cond_3

    .line 190
    :cond_2
    iget-object v0, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;

    iget v0, v0, Lmain/MainCanvas;->game_state:I

    sparse-switch v0, :sswitch_data_0

    goto :goto_0

    .line 215
    :sswitch_0
    invoke-virtual {p0, p1, p2}, Lmain/PointerKey;->runKeySate(II)V

    goto :goto_0

    .line 179
    :cond_3
    sget v0, Lmain/GameRun;->run_state:I

    if-ne v0, v3, :cond_6

    .line 181
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x12

    if-eq v0, v1, :cond_4

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-ne v0, v6, :cond_5

    :cond_4
    invoke-virtual {p0, v4, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 183
    :cond_5
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x12

    if-eq v0, v1, :cond_2

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-eq v0, v6, :cond_2

    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    move-result v0

    if-eq v0, v2, :cond_2

    goto :goto_0

    .line 186
    :cond_6
    sget v0, Lmain/GameRun;->run_state:I

    if-eq v0, v3, :cond_2

    invoke-virtual {p0, v4, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    move-result v0

    if-eq v0, v2, :cond_2

    goto :goto_0

    .line 192
    :sswitch_1
    invoke-virtual {p0, v5, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    .line 193
    const-string v0, "soars"

    const-string v1, "checkButton"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 196
    :sswitch_2
    iget-object v0, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;

    iget v0, v0, Lmain/MainCanvas;->menu_state:I

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 198
    :pswitch_0
    iget-object v0, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;

    iget v0, v0, Lmain/MainCanvas;->load_c:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_7

    .line 199
    iput p1, p0, Lmain/PointerKey;->i0:I

    .line 200
    iput p2, p0, Lmain/PointerKey;->i1:I

    .line 201
    const/4 v0, 0x3

    invoke-virtual {p0, v0, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    goto/16 :goto_0

    .line 203
    :cond_7
    invoke-virtual {p0, v5, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    goto/16 :goto_0

    .line 190
    nop

    :sswitch_data_0
    .sparse-switch
        0x1e -> :sswitch_0
        0x28 -> :sswitch_2
        0x62 -> :sswitch_1
    .end sparse-switch

    .line 196
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public runKeySate(II)V
    .locals 5
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    const/4 v4, -0x1

    const/4 v3, 0x1

    const/4 v2, 0x2

    .line 224
    sget v0, Lmain/GameRun;->run_state:I

    sparse-switch v0, :sswitch_data_0

    .line 282
    :cond_0
    :goto_0
    return-void

    .line 234
    :sswitch_0
    invoke-virtual {p0, v3, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    goto :goto_0

    .line 237
    :sswitch_1
    iput p1, p0, Lmain/PointerKey;->i0:I

    .line 238
    iput p2, p0, Lmain/PointerKey;->i1:I

    .line 240
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x16

    if-ne v0, v1, :cond_2

    .line 241
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->say_c:B

    if-gez v0, :cond_1

    invoke-virtual {p0, v2, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    goto :goto_0

    .line 242
    :cond_1
    invoke-virtual {p0, v3, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    goto :goto_0

    .line 243
    :cond_2
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-eq v0, v3, :cond_3

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0xa

    if-ne v0, v1, :cond_4

    .line 244
    :cond_3
    invoke-virtual {p0, v2, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    goto :goto_0

    .line 245
    :cond_4
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-nez v0, :cond_7

    .line 246
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->say_c:B

    if-ne v0, v4, :cond_6

    invoke-virtual {p0, v2, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    .line 248
    :cond_5
    :goto_1
    iput p1, p0, Lmain/PointerKey;->i0:I

    .line 249
    iput p2, p0, Lmain/PointerKey;->i1:I

    goto :goto_0

    .line 247
    :cond_6
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    iget v0, v0, Lmain/GameRun;->say_s:I

    if-nez v0, :cond_5

    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->say_c:B

    if-nez v0, :cond_5

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget v0, v0, Lmain/Map;->map_x:I

    neg-int v0, v0

    add-int/2addr v0, p1

    iget-object v1, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget v1, v1, Lmain/Map;->map_y:I

    neg-int v1, v1

    add-int/2addr v1, p2

    invoke-direct {p0, v0, v1}, Lmain/PointerKey;->isMove(II)Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-virtual {p0, p1, p2}, Lmain/PointerKey;->setMove(II)V

    goto :goto_1

    .line 250
    :cond_7
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0xc

    if-eq v0, v1, :cond_8

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x12

    if-eq v0, v1, :cond_8

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x11

    if-eq v0, v1, :cond_8

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x10

    if-eq v0, v1, :cond_8

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x14

    if-eq v0, v1, :cond_8

    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-ne v0, v2, :cond_0

    .line 251
    :cond_8
    iput p1, p0, Lmain/PointerKey;->i0:I

    .line 252
    iput p2, p0, Lmain/PointerKey;->i1:I

    goto/16 :goto_0

    .line 264
    :sswitch_2
    iput p1, p0, Lmain/PointerKey;->i0:I

    .line 265
    iput p2, p0, Lmain/PointerKey;->i1:I

    goto/16 :goto_0

    .line 268
    :sswitch_3
    iput p1, p0, Lmain/PointerKey;->i0:I

    .line 269
    iput p2, p0, Lmain/PointerKey;->i1:I

    goto/16 :goto_0

    .line 273
    :sswitch_4
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->battle_state:B

    if-ne v0, v2, :cond_9

    .line 274
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    const/4 v1, 0x5

    invoke-virtual {p0, v1, p1, p2}, Lmain/PointerKey;->checkButton(III)I

    move-result v1

    int-to-byte v1, v1

    iput-byte v1, v0, Lmain/GameRun;->cur_a:B

    .line 275
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    if-eq v0, v4, :cond_0

    invoke-virtual {p0}, Lmain/PointerKey;->setKey5()V

    goto/16 :goto_0

    .line 277
    :cond_9
    iput p1, p0, Lmain/PointerKey;->i0:I

    .line 278
    iput p2, p0, Lmain/PointerKey;->i1:I

    goto/16 :goto_0

    .line 224
    :sswitch_data_0
    .sparse-switch
        -0x1f -> :sswitch_4
        -0x14 -> :sswitch_2
        -0xa -> :sswitch_1
        0x12 -> :sswitch_2
        0x19 -> :sswitch_2
        0x23 -> :sswitch_2
        0x3c -> :sswitch_0
        0x3d -> :sswitch_2
        0x41 -> :sswitch_2
        0x42 -> :sswitch_2
        0x44 -> :sswitch_2
        0x45 -> :sswitch_3
        0x61 -> :sswitch_2
        0x62 -> :sswitch_0
    .end sparse-switch
.end method

.method public runMove()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/4 v5, -0x1

    .line 365
    sget v3, Lmain/GameRun;->run_state:I

    const/16 v4, -0xa

    if-ne v3, v4, :cond_0

    iget-object v3, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v3, v3, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->state:B

    if-nez v3, :cond_0

    iget v3, p0, Lmain/PointerKey;->m0:I

    if-ne v3, v5, :cond_1

    .line 380
    :cond_0
    :goto_0
    return-void

    .line 366
    :cond_1
    iget v3, p0, Lmain/PointerKey;->m0:I

    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->x:S

    sub-int v1, v3, v4

    .local v1, "x":I
    iget v3, p0, Lmain/PointerKey;->m1:I

    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->y:S

    sub-int v2, v3, v4

    .line 367
    .local v2, "y":I
    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v3

    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed:B

    if-ge v3, v4, :cond_2

    invoke-static {v2}, Ldm/Ms;->abs(I)I

    move-result v3

    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed:B

    if-ge v3, v4, :cond_2

    .line 368
    invoke-virtual {p0}, Lmain/PointerKey;->stopMove()V

    goto :goto_0

    .line 371
    :cond_2
    iget-boolean v3, p0, Lmain/PointerKey;->dir:Z

    if-eqz v3, :cond_4

    invoke-static {v2}, Ldm/Ms;->abs(I)I

    move-result v3

    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed:B

    if-ge v3, v4, :cond_3

    move v0, v7

    .line 372
    .local v0, "bb":Z
    :goto_1
    if-eqz v0, :cond_7

    .line 373
    if-gez v1, :cond_6

    const/4 v3, -0x3

    :goto_2
    sput v3, Ldm/Ms;->key:I

    .line 378
    :goto_3
    iget-object v3, p0, Lmain/PointerKey;->map:Lmain/Map;

    sget v4, Ldm/Ms;->key:I

    neg-int v4, v4

    int-to-byte v4, v4

    iput-byte v4, v3, Lmain/Map;->map_key:B

    .line 379
    iget-object v3, p0, Lmain/PointerKey;->map:Lmain/Map;

    invoke-virtual {v3}, Lmain/Map;->doKey()V

    goto :goto_0

    .end local v0    # "bb":Z
    :cond_3
    move v0, v6

    .line 371
    goto :goto_1

    :cond_4
    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v3

    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed:B

    if-lt v3, v4, :cond_5

    move v0, v7

    goto :goto_1

    :cond_5
    move v0, v6

    goto :goto_1

    .line 373
    .restart local v0    # "bb":Z
    :cond_6
    const/4 v3, -0x4

    goto :goto_2

    .line 375
    :cond_7
    if-gez v2, :cond_8

    move v3, v5

    :goto_4
    sput v3, Ldm/Ms;->key:I

    goto :goto_3

    :cond_8
    const/4 v3, -0x2

    goto :goto_4
.end method

.method public selectListSY(IIIIIIII)V
    .locals 12
    .param p1, "len"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "kw"    # I
    .param p6, "kh"    # I
    .param p7, "dis"    # I
    .param p8, "sel"    # I

    .prologue
    .line 322
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_0
    if-lt v11, p1, :cond_0

    .line 329
    return-void

    .line 323
    :cond_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget v3, p0, Lmain/PointerKey;->i0:I

    iget v4, p0, Lmain/PointerKey;->i1:I

    const/4 v5, 0x1

    const/4 v6, 0x1

    add-int v7, p6, p7

    mul-int/2addr v7, v11

    add-int v8, p3, v7

    move v7, p2

    move/from16 v9, p4

    move/from16 v10, p6

    invoke-virtual/range {v2 .. v10}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 324
    iget-object v2, p0, Lmain/PointerKey;->gr:Lmain/GameRun;

    int-to-byte v3, v11

    iput-byte v3, v2, Lmain/GameRun;->selecty:B

    .line 325
    move v0, v11

    move/from16 v1, p8

    if-ne v0, v1, :cond_1

    invoke-virtual {p0}, Lmain/PointerKey;->setKey5()V

    .line 326
    :cond_1
    invoke-virtual {p0}, Lmain/PointerKey;->initPointer()V

    .line 322
    :cond_2
    add-int/lit8 v11, v11, 0x1

    goto :goto_0
.end method

.method public selectMenuX(IIIII)B
    .locals 10
    .param p1, "len"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "h"    # I

    .prologue
    const/4 v3, 0x1

    .line 331
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    if-lt v9, p1, :cond_0

    .line 337
    const/4 v0, -0x1

    :goto_1
    return v0

    .line 332
    :cond_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget v1, p0, Lmain/PointerKey;->i0:I

    iget v2, p0, Lmain/PointerKey;->i1:I

    mul-int v4, v9, p4

    add-int v5, p2, v4

    move v4, v3

    move v6, p3

    move v7, p4

    move v8, p5

    invoke-virtual/range {v0 .. v8}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 333
    invoke-virtual {p0}, Lmain/PointerKey;->initPointer()V

    .line 334
    int-to-byte v0, v9

    goto :goto_1

    .line 331
    :cond_1
    add-int/lit8 v9, v9, 0x1

    goto :goto_0
.end method

.method public setKey5()V
    .locals 1

    .prologue
    .line 284
    const/16 v0, 0x35

    sput v0, Ldm/Ms;->key:I

    .line 285
    const/4 v0, 0x1

    sput-boolean v0, Ldm/Ms;->keyRepeat:Z

    .line 286
    return-void
.end method

.method public setKeySoftkey1()V
    .locals 1

    .prologue
    .line 288
    const/4 v0, -0x6

    sput v0, Ldm/Ms;->key:I

    .line 289
    const/4 v0, 0x1

    sput-boolean v0, Ldm/Ms;->keyRepeat:Z

    .line 290
    return-void
.end method

.method public setMove(II)V
    .locals 4
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    const/4 v3, 0x1

    .line 347
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget v0, v0, Lmain/Map;->map_x:I

    neg-int v0, v0

    add-int/2addr v0, p1

    div-int/lit8 v0, v0, 0x14

    mul-int/lit8 v0, v0, 0x14

    iput v0, p0, Lmain/PointerKey;->m0:I

    .line 348
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget v0, v0, Lmain/Map;->map_y:I

    neg-int v0, v0

    add-int/2addr v0, p2

    div-int/lit8 v0, v0, 0x14

    mul-int/lit8 v0, v0, 0x14

    iput v0, p0, Lmain/PointerKey;->m1:I

    .line 349
    iget v0, p0, Lmain/PointerKey;->m0:I

    iget-object v1, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->x:S

    sub-int/2addr v0, v1

    invoke-static {v0}, Ldm/Ms;->abs(I)I

    move-result v0

    iget v1, p0, Lmain/PointerKey;->m1:I

    iget-object v2, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v2, Ldm/Npc;->y:S

    sub-int/2addr v1, v2

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v1

    if-ge v0, v1, :cond_0

    move v0, v3

    :goto_0
    iput-boolean v0, p0, Lmain/PointerKey;->dir:Z

    .line 350
    iput-boolean v3, p0, Lmain/PointerKey;->isGo:Z

    .line 351
    iput p1, p0, Lmain/PointerKey;->tempx:I

    .line 352
    iput p2, p0, Lmain/PointerKey;->tempy:I

    .line 353
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget v0, v0, Lmain/Map;->map_x:I

    neg-int v0, v0

    iget v1, p0, Lmain/PointerKey;->tempx:I

    add-int/2addr v0, v1

    iput v0, p0, Lmain/PointerKey;->gox:I

    .line 354
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;

    iget v0, v0, Lmain/Map;->map_y:I

    neg-int v0, v0

    iget v1, p0, Lmain/PointerKey;->tempy:I

    add-int/2addr v0, v1

    iput v0, p0, Lmain/PointerKey;->goy:I

    .line 355
    return-void

    .line 349
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public stopMove()V
    .locals 1

    .prologue
    .line 357
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 358
    invoke-virtual {p0}, Lmain/PointerKey;->initPointer()V

    .line 359
    const/4 v0, 0x0

    iput-boolean v0, p0, Lmain/PointerKey;->isGo:Z

    .line 360
    return-void
.end method
