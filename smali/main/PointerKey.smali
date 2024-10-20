.class public Lmain/PointerKey;
.super Ljava/lang/Object;
.implements Lmain/Key_H;
.source "PointerKey.java"

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

.method public constructor <init>(Lmain/MainCanvas;)V
  .parameter "mc_" # Lmain/MainCanvas;
  .registers 15
  .prologue
    const/4 v12, 3
    const/16 v11, 60
    const/4 v10, 1
    const/4 v9, 2
    const/4 v8, 5
  .line 15
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 53
    const/16 v0, 11
    new-array v0, v0, [[[I
    const/4 v1, 0
  .line 55
    new-array v2, v9, [[I
    const/4 v3, 0
    new-array v4, v8, [I
    sget v5, Lmain/Constants_H;->HEIGHT:I
    const/16 v6, 50
    sub-int/2addr v5, v6
    aput v5, v4, v10
    const/16 v5, 50
    aput v5, v4, v9
    const/16 v5, 50
    aput v5, v4, v12
    const/4 v5, 4
    const/4 v6, -6
    aput v6, v4, v5
    aput-object v4, v2, v3
  .line 56
    new-array v3, v8, [I
    const/4 v4, 0
    sget v5, Lmain/Constants_H;->WIDTH:I
    const/16 v6, 50
    sub-int/2addr v5, v6
    aput v5, v3, v4
    sget v4, Lmain/Constants_H;->HEIGHT:I
    const/16 v5, 50
    sub-int/2addr v4, v5
    aput v4, v3, v10
    const/16 v4, 50
    aput v4, v3, v9
    const/16 v4, 50
    aput v4, v3, v12
    const/4 v4, 4
    const/4 v5, -7
    aput v5, v3, v4
    aput-object v3, v2, v10
    aput-object v2, v0, v1
  .line 58
    new-array v1, v10, [[I
    const/4 v2, 0
    new-array v3, v8, [I
    sget v4, Lmain/Constants_H;->WIDTH:I
    aput v4, v3, v9
    sget v4, Lmain/Constants_H;->HEIGHT:I
    aput v4, v3, v12
    const/4 v4, 4
    const/16 v5, 48
    aput v5, v3, v4
    aput-object v3, v1, v2
    aput-object v1, v0, v10
  .line 60
    new-array v1, v10, [[I
    const/4 v2, 0
    new-array v3, v8, [I
    sget v4, Lmain/Constants_H;->WIDTH:I
    aput v4, v3, v9
    sget v4, Lmain/Constants_H;->HEIGHT:I
    aput v4, v3, v12
    const/4 v4, 4
    const/16 v5, 53
    aput v5, v3, v4
    aput-object v3, v1, v2
    aput-object v1, v0, v9
  .line 62
    new-array v1, v12, [[I
    const/4 v2, 0
    new-array v3, v8, [I
    fill-array-data v3, :L0
    aput-object v3, v1, v2
  .line 63
    new-array v2, v8, [I
    fill-array-data v2, :L1
    aput-object v2, v1, v10
  .line 64
    new-array v2, v8, [I
    fill-array-data v2, :L2
    aput-object v2, v1, v9
    aput-object v1, v0, v12
    const/4 v1, 4
  .line 66
    new-array v2, v9, [[I
    const/4 v3, 0
    new-array v4, v8, [I
    const/16 v5, 320
    aput v5, v4, v9
    const/16 v5, 360
    aput v5, v4, v12
    const/4 v5, 4
    const/4 v6, -3
    aput v6, v4, v5
    aput-object v4, v2, v3
  .line 67
    new-array v3, v8, [I
    const/4 v4, 0
    const/16 v5, 320
    aput v5, v3, v4
    const/16 v4, 320
    aput v4, v3, v9
    const/16 v4, 360
    aput v4, v3, v12
    const/4 v4, 4
    const/4 v5, -4
    aput v5, v3, v4
    aput-object v3, v2, v10
    aput-object v2, v0, v1
  .line 69
    new-array v1, v8, [[I
    const/4 v2, 0
    new-array v3, v8, [I
    fill-array-data v3, :L3
    aput-object v3, v1, v2
    new-array v2, v8, [I
    fill-array-data v2, :L4
    aput-object v2, v1, v10
  .line 70
    new-array v2, v8, [I
    fill-array-data v2, :L5
    aput-object v2, v1, v9
    new-array v2, v8, [I
    fill-array-data v2, :L6
    aput-object v2, v1, v12
    const/4 v2, 4
  .line 71
    new-array v3, v8, [I
    fill-array-data v3, :L7
    aput-object v3, v1, v2
    aput-object v1, v0, v8
    const/4 v1, 6
  .line 105
    const/4 v2, 7
    new-array v2, v2, [[I
    const/4 v3, 0
    new-array v4, v8, [I
    const/4 v5, 0
    sget v6, Lmain/Constants_H;->WIDTH__:I
    sub-int/2addr v6, v11
    aput v6, v4, v5
    sget v5, Lmain/Constants_H;->HEIGHT__:I
    sub-int/2addr v5, v11
    aput v5, v4, v10
    aput v11, v4, v9
    aput v11, v4, v12
    const/4 v5, 4
    const/16 v6, 9999
    aput v6, v4, v5
    aput-object v4, v2, v3
    new-array v3, v8, [I
    sget v4, Lmain/Constants_H;->HEIGHT__:I
    sub-int/2addr v4, v11
    aput v4, v3, v10
    aput v11, v3, v9
    aput v11, v3, v12
    const/4 v4, 4
  .line 106
    const/16 v5, 9999
    aput v5, v3, v4
    aput-object v3, v2, v10
  .line 107
    new-array v3, v8, [I
    const/4 v4, 0
    sget v5, Lmain/Constants_H;->WIDTH__:I
    sub-int/2addr v5, v11
    aput v5, v3, v4
    sget v4, Lmain/Constants_H;->HEIGHT__:I
    sub-int/2addr v4, v11
    const/16 v5, 120
    sub-int/2addr v4, v5
    const/16 v5, 40
    sub-int/2addr v4, v5
    aput v4, v3, v10
    aput v11, v3, v9
    aput v11, v3, v12
    const/4 v4, 4
    const/16 v5, 9999
    aput v5, v3, v4
    aput-object v3, v2, v9
    new-array v3, v8, [I
    const/4 v4, 0
    sget v5, Lmain/Constants_H;->WIDTH__:I
    sub-int/2addr v5, v11
    aput v5, v3, v4
    sget v4, Lmain/Constants_H;->HEIGHT__:I
    sub-int/2addr v4, v11
    sub-int/2addr v4, v11
    const/16 v5, 20
    sub-int/2addr v4, v5
    aput v4, v3, v10
    aput v11, v3, v9
    aput v11, v3, v12
    const/4 v4, 4
  .line 108
    const/16 v5, 9999
    aput v5, v3, v4
    aput-object v3, v2, v12
    const/4 v3, 4
  .line 109
    new-array v4, v8, [I
    const/4 v5, 0
    sget v6, Lmain/Constants_H;->WIDTH__:I
    sub-int/2addr v6, v11
    const/16 v7, 120
    sub-int/2addr v6, v7
    const/16 v7, 40
    sub-int/2addr v6, v7
    aput v6, v4, v5
    sget v5, Lmain/Constants_H;->HEIGHT__:I
    sub-int/2addr v5, v11
    aput v5, v4, v10
    aput v11, v4, v9
    aput v11, v4, v12
    const/4 v5, 4
    const/16 v6, 9999
    aput v6, v4, v5
    aput-object v4, v2, v3
    new-array v3, v8, [I
    const/4 v4, 0
    sget v5, Lmain/Constants_H;->WIDTH__:I
    sub-int/2addr v5, v11
    sub-int/2addr v5, v11
    const/16 v6, 20
    sub-int/2addr v5, v6
    aput v5, v3, v4
    sget v4, Lmain/Constants_H;->HEIGHT__:I
    sub-int/2addr v4, v11
    aput v4, v3, v10
    aput v11, v3, v9
  .line 111
    aput v11, v3, v12
    const/4 v4, 4
    const/16 v5, 9999
    aput v5, v3, v4
    aput-object v3, v2, v8
    const/4 v3, 6
    new-array v4, v8, [I
    const/4 v5, 0
    sget v6, Lmain/Constants_H;->WIDTH__:I
    sub-int/2addr v6, v11
    aput v6, v4, v5
    sget v5, Lmain/Constants_H;->HEIGHT__:I
    sub-int/2addr v5, v11
    const/16 v6, 180
    sub-int/2addr v5, v6
    sub-int/2addr v5, v11
    aput v5, v4, v10
    aput v11, v4, v9
    aput v11, v4, v12
    const/4 v5, 4
    const/16 v6, 9999
    aput v6, v4, v5
    aput-object v4, v2, v3
    aput-object v2, v0, v1
    const/4 v1, 7
  .line 113
    new-array v2, v10, [[I
    const/4 v3, 0
    new-array v4, v8, [I
    const/4 v5, 0
    sget v6, Lmain/Constants_H;->WIDTH:I
    const/16 v7, 50
    sub-int/2addr v6, v7
    aput v6, v4, v5
    sget v5, Lmain/Constants_H;->HEIGHT:I
    const/16 v6, 50
    sub-int/2addr v5, v6
    aput v5, v4, v10
    const/16 v5, 50
    aput v5, v4, v9
    const/16 v5, 50
    aput v5, v4, v12
    const/4 v5, 4
    const/4 v6, -7
    aput v6, v4, v5
    aput-object v4, v2, v3
    aput-object v2, v0, v1
    const/16 v1, 8
  .line 116
    new-array v2, v9, [[I
    const/4 v3, 0
    new-array v4, v8, [I
    const/16 v5, 310
    aput v5, v4, v10
    const/16 v5, 50
    aput v5, v4, v9
    const/16 v5, 50
    aput v5, v4, v12
    const/4 v5, 4
    const/4 v6, -6
    aput v6, v4, v5
    aput-object v4, v2, v3
  .line 117
    new-array v3, v8, [I
    fill-array-data v3, :L8
    aput-object v3, v2, v10
    aput-object v2, v0, v1
    const/16 v1, 9
  .line 119
    new-array v2, v10, [[I
    const/4 v3, 0
    new-array v4, v8, [I
    const/16 v5, 640
    aput v5, v4, v9
    const/16 v5, 360
    aput v5, v4, v12
    const/4 v5, 4
    const/16 v6, 48
    aput v6, v4, v5
    aput-object v4, v2, v3
    aput-object v2, v0, v1
    const/16 v1, 10
  .line 122
    const/4 v2, 7
    new-array v2, v2, [[I
    const/4 v3, 0
    new-array v4, v8, [I
    const/4 v5, 0
    sget v6, Lmain/Constants_H;->WIDTH:I
    const/16 v7, 30
    sub-int/2addr v6, v7
    aput v6, v4, v5
    sget v5, Lmain/Constants_H;->HEIGHT:I
    const/16 v6, 30
    sub-int/2addr v5, v6
    aput v5, v4, v10
    const/16 v5, 30
    aput v5, v4, v9
    const/16 v5, 30
    aput v5, v4, v12
    const/4 v5, 4
    const/16 v6, 9999
    aput v6, v4, v5
    aput-object v4, v2, v3
    new-array v3, v8, [I
    sget v4, Lmain/Constants_H;->HEIGHT:I
    const/16 v5, 30
    sub-int/2addr v4, v5
    aput v4, v3, v10
    const/16 v4, 30
    aput v4, v3, v9
    const/16 v4, 30
    aput v4, v3, v12
    const/4 v4, 4
  .line 123
    const/16 v5, 9999
    aput v5, v3, v4
    aput-object v3, v2, v10
  .line 124
    new-array v3, v8, [I
    const/4 v4, 0
    sget v5, Lmain/Constants_H;->WIDTH:I
    const/16 v6, 30
    sub-int/2addr v5, v6
    aput v5, v3, v4
    sget v4, Lmain/Constants_H;->HEIGHT:I
    const/16 v5, 30
    sub-int/2addr v4, v5
    const/16 v5, 90
    sub-int/2addr v4, v5
    const/16 v5, 25
    sub-int/2addr v4, v5
    aput v4, v3, v10
    const/16 v4, 30
    aput v4, v3, v9
    const/16 v4, 30
    aput v4, v3, v12
    const/4 v4, 4
    const/16 v5, 9999
    aput v5, v3, v4
    aput-object v3, v2, v9
    new-array v3, v8, [I
    const/4 v4, 0
    sget v5, Lmain/Constants_H;->WIDTH:I
    const/16 v6, 30
    sub-int/2addr v5, v6
    aput v5, v3, v4
    sget v4, Lmain/Constants_H;->HEIGHT:I
    const/16 v5, 30
    sub-int/2addr v4, v5
    const/16 v5, 45
    sub-int/2addr v4, v5
    const/16 v5, 15
    sub-int/2addr v4, v5
    aput v4, v3, v10
    const/16 v4, 30
    aput v4, v3, v9
    const/16 v4, 30
    aput v4, v3, v12
    const/4 v4, 4
  .line 125
    const/16 v5, 9999
    aput v5, v3, v4
    aput-object v3, v2, v12
    const/4 v3, 4
  .line 126
    new-array v4, v8, [I
    const/4 v5, 0
    sget v6, Lmain/Constants_H;->WIDTH:I
    const/16 v7, 30
    sub-int/2addr v6, v7
    const/16 v7, 90
    sub-int/2addr v6, v7
    const/16 v7, 40
    sub-int/2addr v6, v7
    aput v6, v4, v5
    sget v5, Lmain/Constants_H;->HEIGHT:I
    const/16 v6, 30
    sub-int/2addr v5, v6
    aput v5, v4, v10
    const/16 v5, 30
    aput v5, v4, v9
    const/16 v5, 30
    aput v5, v4, v12
    const/4 v5, 4
    const/16 v6, 9999
    aput v6, v4, v5
    aput-object v4, v2, v3
    new-array v3, v8, [I
    const/4 v4, 0
    sget v5, Lmain/Constants_H;->WIDTH:I
    const/16 v6, 30
    sub-int/2addr v5, v6
    const/16 v6, 45
    sub-int/2addr v5, v6
    const/16 v6, 20
    sub-int/2addr v5, v6
    aput v5, v3, v4
    sget v4, Lmain/Constants_H;->HEIGHT:I
    const/16 v5, 30
    sub-int/2addr v4, v5
    aput v4, v3, v10
    const/16 v4, 30
    aput v4, v3, v9
  .line 127
    const/16 v4, 30
    aput v4, v3, v12
    const/4 v4, 4
    const/16 v5, 9999
    aput v5, v3, v4
    aput-object v3, v2, v8
    const/4 v3, 6
    new-array v4, v8, [I
    const/4 v5, 0
    sget v6, Lmain/Constants_H;->WIDTH:I
    const/16 v7, 30
    sub-int/2addr v6, v7
    aput v6, v4, v5
    sget v5, Lmain/Constants_H;->HEIGHT:I
    const/16 v6, 30
    sub-int/2addr v5, v6
    const/16 v6, 135
    sub-int/2addr v5, v6
    const/16 v6, 35
    sub-int/2addr v5, v6
    aput v5, v4, v10
    const/16 v5, 30
    aput v5, v4, v9
    const/16 v5, 30
    aput v5, v4, v12
    const/4 v5, 4
    const/16 v6, 9999
    aput v6, v4, v5
    aput-object v4, v2, v3
    aput-object v2, v0, v1
    iput-object v0, p0, Lmain/PointerKey;->button_pos:[[[I
  .line 340
    const/4 v0, -1
    iput v0, p0, Lmain/PointerKey;->i0:I
    const/4 v0, -1
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
  .line 63
  .line 64
  .line 69
  .line 70
  .line 71
  .line 117
  :L0
  .array-data 4
    -86t 0t 0t 0t
    19t 1t 0t 0t
    106t 0t 0t 0t
    97t 0t 0t 0t
    -3t -1t -1t -1t
  .end array-data
  :L1
  .array-data 4
    107t 1t 0t 0t
    29t 1t 0t 0t
    108t 0t 0t 0t
    83t 0t 0t 0t
    -4t -1t -1t -1t
  .end array-data
  :L2
  .array-data 4
    25t 1t 0t 0t
    34t 1t 0t 0t
    76t 0t 0t 0t
    88t 0t 0t 0t
    53t 0t 0t 0t
  .end array-data
  :L3
  .array-data 4
    -50t 1t 0t 0t
    42t 0t 0t 0t
    83t 0t 0t 0t
    72t 0t 0t 0t
    15t 39t 0t 0t
  .end array-data
  :L4
  .array-data 4
    36t 2t 0t 0t
    116t 0t 0t 0t
    83t 0t 0t 0t
    71t 0t 0t 0t
    15t 39t 0t 0t
  .end array-data
  :L5
  .array-data 4
    -46t 1t 0t 0t
    -74t 0t 0t 0t
    85t 0t 0t 0t
    75t 0t 0t 0t
    15t 39t 0t 0t
  .end array-data
  :L6
  .array-data 4
    12t 2t 0t 0t
    10t 1t 0t 0t
    91t 0t 0t 0t
    68t 0t 0t 0t
    15t 39t 0t 0t
  .end array-data
  :L7
  .array-data 4
    48t 0t 0t 0t
    21t 1t 0t 0t
    87t 0t 0t 0t
    80t 0t 0t 0t
    15t 39t 0t 0t
  .end array-data
  :L8
  .array-data 4
    78t 2t 0t 0t
    54t 1t 0t 0t
    50t 0t 0t 0t
    50t 0t 0t 0t
    -7t -1t -1t -1t
  .end array-data
.end method

.method private isMove(II)Z
  .parameter "x" # I
  .parameter "y" # I
  .registers 20
  .prologue
  .line 294
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-byte v1, v1, Ldm/Npc;->dir:B
    const/4 v2, 3
    if-ne v1, v2, :L3
  .line 295
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v1, v1, Ldm/Npc;->x:S
    const/16 v2, 20
    sub-int v6, v1, v2
  .line 296
  .local v6, "npcX":I
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v1, v1, Ldm/Npc;->y:S
    const/16 v2, 60
    sub-int v7, v1, v2
  :L0
  .line 307
  .local v7, "npcY":I
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const/4 v4, 1
    const/4 v5, 1
    const/16 v8, 20
    const/16 v9, 80
    move/from16 v2, p1
    move/from16 v3, p2
    invoke-virtual/range { v1 .. v9 }, Ldm/Ms;->isRect(IIIIIIII)Z
    move-result v1
    if-nez v1, :L1
  .line 308
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v8
    move-object/from16 v0, p0
    iget v0, v0, Lmain/PointerKey;->i0:I
    move v9, v0
    move-object/from16 v0, p0
    iget v0, v0, Lmain/PointerKey;->i1:I
    move v10, v0
    const/4 v11, 1
    const/4 v12, 1
    sget v1, Lmain/Constants_H;->WIDTH_H:I
    const/16 v2, 30
    sub-int v13, v1, v2
    sget v1, Lmain/Constants_H;->HEIGHT:I
    const/16 v2, 60
    sub-int v14, v1, v2
    const/16 v15, 60
    const/16 v16, 60
    invoke-virtual/range { v8 .. v16 }, Ldm/Ms;->isRect(IIIIIIII)Z
    move-result v1
    if-eqz v1, :L6
  :L1
  .line 309
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
    const/4 v5, 0
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
  .end local v6
    iget-object v6, v6, Lmain/Map;->my:Ldm/Npc;
    iget-byte v6, v6, Ldm/Npc;->dir:B
    aget-object v5, v5, v6
    const/4 v6, 1
    aget-byte v5, v5, v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v6, v0
    iget-object v6, v6, Lmain/Map;->my:Ldm/Npc;
    iget-byte v6, v6, Ldm/Npc;->speed:B
    mul-int/2addr v5, v6
    invoke-virtual { v1, v2, v3, v4, v5 }, Lmain/Map;->checkSoftKey(IIII)B
    move-result v1
    const/4 v2, -1
    if-eq v1, v2, :L6
  .line 310
    const/4 v1, 0
  :L2
  .line 311
    return v1
  :L3
  .line 297
  .end local v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-byte v1, v1, Ldm/Npc;->dir:B
    const/4 v2, 4
    if-ne v1, v2, :L4
  .line 298
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v1, v1, Ldm/Npc;->x:S
    add-int/lit8 v6, v1, 20
  .line 299
  .restart local v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v1, v1, Ldm/Npc;->y:S
    const/16 v2, 60
    sub-int v7, v1, v2
  .restart local v7
    goto/16 :L0
  :L4
  .line 300
  .end local v6
  .end local v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-byte v1, v1, Ldm/Npc;->dir:B
    const/4 v2, 1
    if-ne v1, v2, :L5
  .line 301
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v6, v1, Ldm/Npc;->x:S
  .line 302
  .restart local v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v1, v1, Ldm/Npc;->y:S
    const/16 v2, 80
    sub-int v7, v1, v2
  .restart local v7
    goto/16 :L0
  :L5
  .line 304
  .end local v6
  .end local v7
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v6, v1, Ldm/Npc;->x:S
  .line 305
  .restart local v6
    move-object/from16 v0, p0
    iget-object v0, v0, Lmain/PointerKey;->map:Lmain/Map;
    move-object v1, v0
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v1, v1, Ldm/Npc;->y:S
    const/16 v2, 40
    sub-int v7, v1, v2
  .restart local v7
    goto/16 :L0
  :L6
  .line 311
  .end local v6
    const/4 v1, 1
    goto :L2
.end method

.method public checkButton(I)I
  .parameter "check_no" # I
  .registers 4
  .prologue
  .line 22
    iget v0, p0, Lmain/PointerKey;->i0:I
    iget v1, p0, Lmain/PointerKey;->i1:I
    invoke-virtual { p0, p1, v0, v1 }, Lmain/PointerKey;->checkButton(III)I
    move-result v0
    return v0
.end method

.method public checkButton(III)I
  .parameter "check_no" # I
  .parameter "x" # I
  .parameter "y" # I
  .registers 16
  .prologue
    const/4 v11, 3
    const/4 v3, 2
    const/4 v10, 1
  .line 25
    const/4 v9, 0
  :L0
  .local v9, "i":I
    iget-object v0, p0, Lmain/PointerKey;->button_pos:[[[I
    aget-object v0, v0, p1
    array-length v0, v0
    if-lt v9, v0, :L2
  .line 37
    const/4 v0, -1
  :L1
    return v0
  :L2
  .line 27
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    sub-int v1, p2, v10
    sub-int v2, p3, v10
    iget-object v4, p0, Lmain/PointerKey;->button_pos:[[[I
    aget-object v4, v4, p1
    aget-object v4, v4, v9
    const/4 v5, 0
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
    invoke-virtual/range { v0 .. v8 }, Ldm/Ms;->isRect(IIIIIIII)Z
    move-result v0
    if-eqz v0, :L4
  .line 28
    iget-object v0, p0, Lmain/PointerKey;->button_pos:[[[I
    aget-object v0, v0, p1
    aget-object v0, v0, v9
    const/4 v1, 4
    aget v0, v0, v1
    sput v0, Ldm/Ms;->key:I
  .line 29
    if-ne p1, v11, :L3
    sget v0, Ldm/Ms;->key:I
    const/16 v1, 53
    if-ne v0, v1, :L3
  .line 30
    const-string v0, "touch"
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "\u6309\u4e0b\u786e\u5b9a\u952e\u3002\u3002\u3002menu_state: "
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;
    iget v2, v2, Lmain/MainCanvas;->menu_state:I
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  :L3
  .line 32
    sput-boolean v10, Ldm/Ms;->keyRepeat:Z
  .line 33
    invoke-virtual { p0 }, Lmain/PointerKey;->initPointer()V
    move v0, v9
  .line 34
    goto :L1
  :L4
  .line 25
    add-int/lit8 v9, v9, 1
    goto :L0
.end method

.method public initPointer()V
  .registers 2
  .prologue
    const/4 v0, -1
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
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 14
  .prologue
    const/4 v3, 1
  .line 315
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    iget v1, p0, Lmain/PointerKey;->i0:I
    iget v2, p0, Lmain/PointerKey;->i1:I
    move v4, v3
    move v5, p1
    move v6, p2
    move v7, p3
    move v8, p4
    invoke-virtual/range { v0 .. v8 }, Ldm/Ms;->isRect(IIIIIIII)Z
    move-result v0
    if-eqz v0, :L1
  .line 316
    invoke-virtual { p0 }, Lmain/PointerKey;->initPointer()V
    move v0, v3
  :L0
  .line 319
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public process(II)V
  .parameter "x" # I
  .parameter "y" # I
  .registers 10
  .prologue
    const/16 v6, 17
    const/16 v5, 9
    const/16 v4, 8
    const/16 v3, -10
    const/4 v2, -1
  .line 176
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 20
    if-ne v0, v1, :L1
    const/4 v0, 7
    invoke-virtual { p0, v0, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    move-result v0
    if-eq v0, v2, :L1
  :L0
  .line 218
    return-void
  :L1
  .line 177
    sget v0, Lmain/GameRun;->run_state:I
    if-ne v0, v3, :L4
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    if-eqz v0, :L2
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 20
    if-ne v0, v1, :L4
  :L2
  .line 190
    iget-object v0, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;
    iget v0, v0, Lmain/MainCanvas;->game_state:I
    sparse-switch v0, :L12
    goto :L0
  :L3
  .line 215
    invoke-virtual { p0, p1, p2 }, Lmain/PointerKey;->runKeySate(II)V
    goto :L0
  :L4
  .line 179
    sget v0, Lmain/GameRun;->run_state:I
    if-ne v0, v3, :L7
  .line 181
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 18
    if-eq v0, v1, :L5
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    if-ne v0, v6, :L6
  :L5
    invoke-virtual { p0, v4, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    move-result v0
    if-ne v0, v2, :L0
  :L6
  .line 183
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 18
    if-eq v0, v1, :L2
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    if-eq v0, v6, :L2
    const/4 v0, 0
    invoke-virtual { p0, v0, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    move-result v0
    if-eq v0, v2, :L2
    goto :L0
  :L7
  .line 186
    sget v0, Lmain/GameRun;->run_state:I
    if-eq v0, v3, :L2
    invoke-virtual { p0, v4, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    move-result v0
    if-eq v0, v2, :L2
    goto :L0
  :L8
  .line 192
    invoke-virtual { p0, v5, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
  .line 193
    const-string v0, "soars"
    const-string v1, "checkButton"
    invoke-static { v0, v1 }, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    goto :L0
  :L9
  .line 196
    iget-object v0, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;
    iget v0, v0, Lmain/MainCanvas;->menu_state:I
    packed-switch v0, :L13
    goto :L0
  :L10
  .line 198
    iget-object v0, p0, Lmain/PointerKey;->mc:Lmain/MainCanvas;
    iget v0, v0, Lmain/MainCanvas;->load_c:I
    const/4 v1, 1
    if-ne v0, v1, :L11
  .line 199
    iput p1, p0, Lmain/PointerKey;->i0:I
  .line 200
    iput p2, p0, Lmain/PointerKey;->i1:I
  .line 201
    const/4 v0, 3
    invoke-virtual { p0, v0, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    goto/16 :L0
  :L11
  .line 203
    invoke-virtual { p0, v5, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    goto/16 :L0
  .line 190
  .line 196
  :L12
  .sparse-switch
    30 -> :L3
    40 -> :L9
    98 -> :L8
  .end sparse-switch
  :L13
  .packed-switch 0
    :L10
  .end packed-switch
.end method

.method public runKeySate(II)V
  .parameter "x" # I
  .parameter "y" # I
  .registers 8
  .prologue
    const/4 v4, -1
    const/4 v3, 1
    const/4 v2, 2
  .line 224
    sget v0, Lmain/GameRun;->run_state:I
    sparse-switch v0, :L15
  :L0
  .line 282
    return-void
  :L1
  .line 234
    invoke-virtual { p0, v3, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    goto :L0
  :L2
  .line 237
    iput p1, p0, Lmain/PointerKey;->i0:I
  .line 238
    iput p2, p0, Lmain/PointerKey;->i1:I
  .line 240
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 22
    if-ne v0, v1, :L4
  .line 241
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;
    iget-byte v0, v0, Lmain/GameRun;->say_c:B
    if-gez v0, :L3
    invoke-virtual { p0, v2, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    goto :L0
  :L3
  .line 242
    invoke-virtual { p0, v3, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    goto :L0
  :L4
  .line 243
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    if-eq v0, v3, :L5
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 10
    if-ne v0, v1, :L6
  :L5
  .line 244
    invoke-virtual { p0, v2, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    goto :L0
  :L6
  .line 245
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    if-nez v0, :L9
  .line 246
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;
    iget-byte v0, v0, Lmain/GameRun;->say_c:B
    if-ne v0, v4, :L8
    invoke-virtual { p0, v2, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
  :L7
  .line 248
    iput p1, p0, Lmain/PointerKey;->i0:I
  .line 249
    iput p2, p0, Lmain/PointerKey;->i1:I
    goto :L0
  :L8
  .line 247
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;
    iget v0, v0, Lmain/GameRun;->say_s:I
    if-nez v0, :L7
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;
    iget-byte v0, v0, Lmain/GameRun;->say_c:B
    if-nez v0, :L7
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget v0, v0, Lmain/Map;->map_x:I
    neg-int v0, v0
    add-int/2addr v0, p1
    iget-object v1, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget v1, v1, Lmain/Map;->map_y:I
    neg-int v1, v1
    add-int/2addr v1, p2
    invoke-direct { p0, v0, v1 }, Lmain/PointerKey;->isMove(II)Z
    move-result v0
    if-eqz v0, :L7
    invoke-virtual { p0, p1, p2 }, Lmain/PointerKey;->setMove(II)V
    goto :L7
  :L9
  .line 250
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 12
    if-eq v0, v1, :L10
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 18
    if-eq v0, v1, :L10
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 17
    if-eq v0, v1, :L10
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 16
    if-eq v0, v1, :L10
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 20
    if-eq v0, v1, :L10
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    if-ne v0, v2, :L0
  :L10
  .line 251
    iput p1, p0, Lmain/PointerKey;->i0:I
  .line 252
    iput p2, p0, Lmain/PointerKey;->i1:I
    goto/16 :L0
  :L11
  .line 264
    iput p1, p0, Lmain/PointerKey;->i0:I
  .line 265
    iput p2, p0, Lmain/PointerKey;->i1:I
    goto/16 :L0
  :L12
  .line 268
    iput p1, p0, Lmain/PointerKey;->i0:I
  .line 269
    iput p2, p0, Lmain/PointerKey;->i1:I
    goto/16 :L0
  :L13
  .line 273
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;
    iget-byte v0, v0, Lmain/GameRun;->battle_state:B
    if-ne v0, v2, :L14
  .line 274
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;
    const/4 v1, 5
    invoke-virtual { p0, v1, p1, p2 }, Lmain/PointerKey;->checkButton(III)I
    move-result v1
    int-to-byte v1, v1
    iput-byte v1, v0, Lmain/GameRun;->cur_a:B
  .line 275
    iget-object v0, p0, Lmain/PointerKey;->gr:Lmain/GameRun;
    iget-byte v0, v0, Lmain/GameRun;->cur_a:B
    if-eq v0, v4, :L0
    invoke-virtual { p0 }, Lmain/PointerKey;->setKey5()V
    goto/16 :L0
  :L14
  .line 277
    iput p1, p0, Lmain/PointerKey;->i0:I
  .line 278
    iput p2, p0, Lmain/PointerKey;->i1:I
    goto/16 :L0
  .line 224
  :L15
  .sparse-switch
    -31 -> :L13
    -20 -> :L11
    -10 -> :L2
    18 -> :L11
    25 -> :L11
    35 -> :L11
    60 -> :L1
    61 -> :L11
    65 -> :L11
    66 -> :L11
    68 -> :L11
    69 -> :L12
    97 -> :L11
    98 -> :L1
  .end sparse-switch
.end method

.method public runMove()V
  .registers 9
  .prologue
    const/4 v7, 1
    const/4 v6, 0
    const/4 v5, -1
  .line 365
    sget v3, Lmain/GameRun;->run_state:I
    const/16 v4, -10
    if-ne v3, v4, :L0
    iget-object v3, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v3, v3, Lmain/Map;->my:Ldm/Npc;
    iget-byte v3, v3, Ldm/Npc;->state:B
    if-nez v3, :L0
    iget v3, p0, Lmain/PointerKey;->m0:I
    if-ne v3, v5, :L1
  :L0
  .line 380
    return-void
  :L1
  .line 366
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
    invoke-static { v1 }, Ldm/Ms;->abs(I)I
    move-result v3
    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;
    iget-byte v4, v4, Ldm/Npc;->speed:B
    if-ge v3, v4, :L2
    invoke-static { v2 }, Ldm/Ms;->abs(I)I
    move-result v3
    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;
    iget-byte v4, v4, Ldm/Npc;->speed:B
    if-ge v3, v4, :L2
  .line 368
    invoke-virtual { p0 }, Lmain/PointerKey;->stopMove()V
    goto :L0
  :L2
  .line 371
    iget-boolean v3, p0, Lmain/PointerKey;->dir:Z
    if-eqz v3, :L7
    invoke-static { v2 }, Ldm/Ms;->abs(I)I
    move-result v3
    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;
    iget-byte v4, v4, Ldm/Npc;->speed:B
    if-ge v3, v4, :L6
    move v0, v7
  :L3
  .line 372
  .local v0, "bb":Z
    if-eqz v0, :L10
  .line 373
    if-gez v1, :L9
    const/4 v3, -3
  :L4
    sput v3, Ldm/Ms;->key:I
  :L5
  .line 378
    iget-object v3, p0, Lmain/PointerKey;->map:Lmain/Map;
    sget v4, Ldm/Ms;->key:I
    neg-int v4, v4
    int-to-byte v4, v4
    iput-byte v4, v3, Lmain/Map;->map_key:B
  .line 379
    iget-object v3, p0, Lmain/PointerKey;->map:Lmain/Map;
    invoke-virtual { v3 }, Lmain/Map;->doKey()V
    goto :L0
  :L6
  .end local v0
    move v0, v6
  .line 371
    goto :L3
  :L7
    invoke-static { v1 }, Ldm/Ms;->abs(I)I
    move-result v3
    iget-object v4, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v4, v4, Lmain/Map;->my:Ldm/Npc;
    iget-byte v4, v4, Ldm/Npc;->speed:B
    if-lt v3, v4, :L8
    move v0, v7
    goto :L3
  :L8
    move v0, v6
    goto :L3
  :L9
  .line 373
  .restart local v0
    const/4 v3, -4
    goto :L4
  :L10
  .line 375
    if-gez v2, :L12
    move v3, v5
  :L11
    sput v3, Ldm/Ms;->key:I
    goto :L5
  :L12
    const/4 v3, -2
    goto :L11
.end method

.method public selectListSY(IIIIIIII)V
  .parameter "len" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "kw" # I
  .parameter "kh" # I
  .parameter "dis" # I
  .parameter "sel" # I
  .registers 21
  .prologue
  .line 322
    const/4 v11, 0
  :L0
  .local v11, "i":I
    if-lt v11, p1, :L1
  .line 329
    return-void
  :L1
  .line 323
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v2
    iget v3, p0, Lmain/PointerKey;->i0:I
    iget v4, p0, Lmain/PointerKey;->i1:I
    const/4 v5, 1
    const/4 v6, 1
    add-int v7, p6, p7
    mul-int/2addr v7, v11
    add-int v8, p3, v7
    move v7, p2
    move/from16 v9, p4
    move/from16 v10, p6
    invoke-virtual/range { v2 .. v10 }, Ldm/Ms;->isRect(IIIIIIII)Z
    move-result v2
    if-eqz v2, :L3
  .line 324
    iget-object v2, p0, Lmain/PointerKey;->gr:Lmain/GameRun;
    int-to-byte v3, v11
    iput-byte v3, v2, Lmain/GameRun;->selecty:B
  .line 325
    move v0, v11
    move/from16 v1, p8
    if-ne v0, v1, :L2
    invoke-virtual { p0 }, Lmain/PointerKey;->setKey5()V
  :L2
  .line 326
    invoke-virtual { p0 }, Lmain/PointerKey;->initPointer()V
  :L3
  .line 322
    add-int/lit8 v11, v11, 1
    goto :L0
.end method

.method public selectMenuX(IIIII)B
  .parameter "len" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 16
  .prologue
    const/4 v3, 1
  .line 331
    const/4 v9, 0
  :L0
  .local v9, "i":I
    if-lt v9, p1, :L2
  .line 337
    const/4 v0, -1
  :L1
    return v0
  :L2
  .line 332
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    iget v1, p0, Lmain/PointerKey;->i0:I
    iget v2, p0, Lmain/PointerKey;->i1:I
    mul-int v4, v9, p4
    add-int v5, p2, v4
    move v4, v3
    move v6, p3
    move v7, p4
    move v8, p5
    invoke-virtual/range { v0 .. v8 }, Ldm/Ms;->isRect(IIIIIIII)Z
    move-result v0
    if-eqz v0, :L3
  .line 333
    invoke-virtual { p0 }, Lmain/PointerKey;->initPointer()V
  .line 334
    int-to-byte v0, v9
    goto :L1
  :L3
  .line 331
    add-int/lit8 v9, v9, 1
    goto :L0
.end method

.method public setKey5()V
  .registers 2
  .prologue
  .line 284
    const/16 v0, 53
    sput v0, Ldm/Ms;->key:I
  .line 285
    const/4 v0, 1
    sput-boolean v0, Ldm/Ms;->keyRepeat:Z
  .line 286
    return-void
.end method

.method public setKeySoftkey1()V
  .registers 2
  .prologue
  .line 288
    const/4 v0, -6
    sput v0, Ldm/Ms;->key:I
  .line 289
    const/4 v0, 1
    sput-boolean v0, Ldm/Ms;->keyRepeat:Z
  .line 290
    return-void
.end method

.method public setMove(II)V
  .parameter "x" # I
  .parameter "y" # I
  .registers 7
  .prologue
    const/4 v3, 1
  .line 347
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget v0, v0, Lmain/Map;->map_x:I
    neg-int v0, v0
    add-int/2addr v0, p1
    div-int/lit8 v0, v0, 20
    mul-int/lit8 v0, v0, 20
    iput v0, p0, Lmain/PointerKey;->m0:I
  .line 348
    iget-object v0, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget v0, v0, Lmain/Map;->map_y:I
    neg-int v0, v0
    add-int/2addr v0, p2
    div-int/lit8 v0, v0, 20
    mul-int/lit8 v0, v0, 20
    iput v0, p0, Lmain/PointerKey;->m1:I
  .line 349
    iget v0, p0, Lmain/PointerKey;->m0:I
    iget-object v1, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;
    iget-short v1, v1, Ldm/Npc;->x:S
    sub-int/2addr v0, v1
    invoke-static { v0 }, Ldm/Ms;->abs(I)I
    move-result v0
    iget v1, p0, Lmain/PointerKey;->m1:I
    iget-object v2, p0, Lmain/PointerKey;->map:Lmain/Map;
    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;
    iget-short v2, v2, Ldm/Npc;->y:S
    sub-int/2addr v1, v2
    invoke-static { v1 }, Ldm/Ms;->abs(I)I
    move-result v1
    if-ge v0, v1, :L1
    move v0, v3
  :L0
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
  :L1
  .line 349
    const/4 v0, 0
    goto :L0
.end method

.method public stopMove()V
  .registers 2
  .prologue
  .line 357
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->keyRelease()V
  .line 358
    invoke-virtual { p0 }, Lmain/PointerKey;->initPointer()V
  .line 359
    const/4 v0, 0
    iput-boolean v0, p0, Lmain/PointerKey;->isGo:Z
  .line 360
    return-void
.end method
