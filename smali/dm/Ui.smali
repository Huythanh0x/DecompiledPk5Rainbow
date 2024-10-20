.class public Ldm/Ui;
.super Ljava/lang/Object;
.source "Ui.java"

.field public static dg:Lcom/nokia/mid/ui/DirectGraphics;

.field public static g:Ljavax/microedition/lcdui/Graphics;

.field private final static transforms:[S

.field private static uiListener:Ldm/Ui;

.field private MIRROR:[I

.field private MIRROR2:[[B

.field private MIRROR3:[B

.field public cTriangle:B

.field private rz:B

.field private ui_img:Ljavax/microedition/lcdui/Image;

.field private ui_modules:[[S

.method static constructor <clinit>()V
  .registers 7
  .prologue
    const/4 v6, 5
    const/4 v5, 4
    const/4 v4, 3
    const/4 v3, 2
    const/4 v2, 1
  .line 103
    const/16 v0, 8
    new-array v0, v0, [S
    aput-short v6, v0, v2
    aput-short v4, v0, v3
    const/4 v1, 6
    aput-short v1, v0, v4
    aput-short v3, v0, v5
    aput-short v5, v0, v6
    const/4 v1, 6
    aput-short v2, v0, v1
    const/4 v1, 7
    const/4 v2, 7
    aput-short v2, v0, v1
    sput-object v0, Ldm/Ui;->transforms:[S
  .line 19
    return-void
.end method

.method public constructor <init>()V
  .registers 10
  .prologue
    const/4 v8, 4
    const/4 v7, 3
    const/4 v6, 0
    const/4 v5, 1
    const/4 v4, 2
  .line 21
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 34
    new-array v0, v4, [[B
    const/16 v1, 8
    new-array v1, v1, [B
    aput-byte v5, v1, v5
    aput-byte v4, v1, v4
    aput-byte v7, v1, v7
    aput-byte v8, v1, v8
    const/4 v2, 5
    const/4 v3, 5
    aput-byte v3, v1, v2
    const/4 v2, 6
    const/4 v3, 6
    aput-byte v3, v1, v2
    const/4 v2, 7
    const/4 v3, 7
    aput-byte v3, v1, v2
    aput-object v1, v0, v6
    const/16 v1, 8
    new-array v1, v1, [B
    aput-byte v8, v1, v6
    const/4 v2, 5
    aput-byte v2, v1, v5
    const/4 v2, 6
    aput-byte v2, v1, v4
    const/4 v2, 7
    aput-byte v2, v1, v7
    const/4 v2, 5
    aput-byte v5, v1, v2
    const/4 v2, 6
    aput-byte v4, v1, v2
    const/4 v2, 7
    aput-byte v7, v1, v2
    aput-object v1, v0, v5
    iput-object v0, p0, Ldm/Ui;->MIRROR2:[[B
  .line 35
    new-array v0, v4, [B
    fill-array-data v0, :L0
    iput-object v0, p0, Ldm/Ui;->MIRROR3:[B
  .line 37
    new-array v0, v4, [I
    or-int/lit8 v1, v8, 16
    aput v1, v0, v6
    const/16 v1, 8
    or-int/lit8 v1, v1, 16
    aput v1, v0, v5
    iput-object v0, p0, Ldm/Ui;->MIRROR:[I
  .line 576
    iput-byte v6, p0, Ldm/Ui;->cTriangle:B
  .line 21
    sput-object p0, Ldm/Ui;->uiListener:Ldm/Ui;
    return-void
  .line 35
  :L0
  .array-data 1
    1t
    -1t
  .end array-data
.end method

.method public static i()Ldm/Ui;
  .registers 1
  .prologue
  .line 23
    sget-object v0, Ldm/Ui;->uiListener:Ldm/Ui;
    if-nez v0, :L0
    new-instance v0, Ldm/Ui;
    invoke-direct { v0 }, Ldm/Ui;-><init>()V
    sput-object v0, Ldm/Ui;->uiListener:Ldm/Ui;
  :L0
  .line 24
    sget-object v0, Ldm/Ui;->uiListener:Ldm/Ui;
    return-object v0
.end method

.method public drawActionOne(Ldm/Sprite;III[BIZ)Z
  .parameter "sp" # Ldm/Sprite;
  .parameter "a_id" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "now_a" # [B
  .parameter "dir" # I
  .parameter "mode" # Z
  .registers 16
  .prologue
    const/4 v7, 1
    const/4 v6, 0
  .line 130
    aget-byte v0, p5, v6
    invoke-virtual { p1, p2, v0, v6 }, Ldm/Sprite;->action(III)I
    move-result v2
    move-object v0, p0
    move-object v1, p1
    move v3, p3
    move v4, p4
    move v5, p6
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V
  .line 131
    aget-byte v0, p5, v7
    add-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    aput-byte v0, p5, v7
    aget-byte v1, p5, v6
    invoke-virtual { p1, p2, v1, v7 }, Ldm/Sprite;->action(III)I
    move-result v1
    if-le v0, v1, :L2
  .line 132
    aput-byte v6, p5, v7
  .line 133
    aget-byte v0, p5, v6
    add-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    aput-byte v0, p5, v6
    invoke-virtual { p1, p2 }, Ldm/Sprite;->aLength(I)I
    move-result v1
    if-lt v0, v1, :L2
  .line 134
    if-nez p7, :L1
  .line 135
    invoke-virtual { p1, p2 }, Ldm/Sprite;->aLength(I)I
    move-result v0
    sub-int/2addr v0, v7
    int-to-byte v0, v0
    aput-byte v0, p5, v6
    move v0, v7
  :L0
  .line 141
    return v0
  :L1
  .line 138
    aput-byte v6, p5, v6
  :L2
    move v0, v6
  .line 141
    goto :L0
.end method

.method public drawBDir(IIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 10
  .prologue
  .line 300
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const v1, 8310516
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 301
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    mul-int/lit8 v1, p3, 3
    shl-int/lit8 v2, p4, 1
    invoke-virtual { v0, p1, p2, v1, v2 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 302
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int v1, p1, p3
    shl-int/lit8 v2, p4, 1
    invoke-virtual { v0, v1, p2, p3, v2 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 303
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    int-to-float v1, p1
    add-int v2, p2, p4
    int-to-float v2, v2
    mul-int/lit8 v3, p3, 3
    add-int/2addr v3, p1
    int-to-float v3, v3
    add-int v4, p2, p4
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 304
    return-void
.end method

.method public drawBarOne(IIIIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "cMin" # I
  .parameter "cMax" # I
  .parameter "mode" # I
  .registers 15
  .prologue
    const/4 v3, 1
  .line 490
    const v6, 16125468
  .local v6, "c0":I
    const v7, 16752385
  .local v7, "c1":I
    const/4 v5, 5
  .line 491
  .local v5, "h":I
    if-ne p6, v3, :L2
    const v6, 55551
  :L0
  .line 494
    const v1, 4067649
    add-int/lit8 v2, p1, 1
    sub-int v4, p3, v3
    move-object v0, p0
    move v3, p2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 495
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p2, 1
    const/4 v2, 3
    sub-int v2, v5, v2
    invoke-virtual { v0, p1, v1, p3, v2 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 497
    add-int/lit8 v5, v5, -2
  .line 498
    add-int/lit8 v2, p1, 1
    add-int/lit8 v3, p2, 1
    move-object v0, p0
    move v1, v7
    move v4, p4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 499
    add-int/lit8 v2, p1, 1
    add-int/lit8 v3, p2, 1
    if-le p4, p5, :L3
    move v4, p5
  :L1
    move-object v0, p0
    move v1, v6
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 500
    return-void
  :L2
  .line 492
    const/4 v0, 2
    if-ne p6, v0, :L0
    const v6, 60177
    goto :L0
  :L3
    move v4, p4
  .line 499
    goto :L1
.end method

.method public drawFrameOne(Ldm/Sprite;IIII)V
  .parameter "sp" # Ldm/Sprite;
  .parameter "f_id" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "dir" # I
  .registers 14
  .prologue
  .line 120
    const/4 v7, 0
  :L0
  .line 121
  .local v7, "now_frame":S
    invoke-virtual { p1, p2 }, Ldm/Sprite;->fLength(I)I
    move-result v0
    if-lt v7, v0, :L1
  .line 128
    return-void
  :L1
  .line 122
    const/4 v0, 0
    invoke-virtual { p1, p2, v7, v0 }, Ldm/Sprite;->frame(III)I
    move-result v2
  .line 123
    const/4 v0, 1
    invoke-virtual { p1, p2, v7, v0 }, Ldm/Sprite;->frame(III)I
    move-result v0
    iget-object v1, p0, Ldm/Ui;->MIRROR3:[B
    aget-byte v1, v1, p5
    mul-int/2addr v0, v1
    add-int v3, p3, v0
  .line 124
    const/4 v0, 2
    invoke-virtual { p1, p2, v7, v0 }, Ldm/Sprite;->frame(III)I
    move-result v0
    add-int v4, p4, v0
  .line 125
    const/4 v0, 3
    invoke-virtual { p1, p2, v7, v0 }, Ldm/Sprite;->frame(III)I
    move-result v6
    move-object v0, p0
    move-object v1, p1
    move v5, p5
  .line 122
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawModuleOne(Ldm/Sprite;IIIII)V
  .line 126
    add-int/lit8 v0, v7, 1
    int-to-short v7, v0
    goto :L0
.end method

.method public drawImage(Ljavax/microedition/lcdui/Image;III)V
  .parameter "image" # Ljavax/microedition/lcdui/Image;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "archor" # I
  .registers 6
  .prologue
  .line 166
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1, p2, p3, p4 }, Ljavax/microedition/lcdui/Graphics;->drawImage(Ljavax/microedition/lcdui/Image;III)V
  .line 167
    return-void
.end method

.method public drawImage(Ljavax/microedition/lcdui/Image;IIII)V
  .parameter "image" # Ljavax/microedition/lcdui/Image;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "archor" # I
  .parameter "trans" # I
  .registers 12
  .prologue
  .line 169
    if-nez p5, :L1
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1, p2, p3, p4 }, Ljavax/microedition/lcdui/Graphics;->drawImage(Ljavax/microedition/lcdui/Image;III)V
  :L0
  .line 171
    return-void
  :L1
  .line 170
    sget-object v0, Ldm/Ui;->dg:Lcom/nokia/mid/ui/DirectGraphics;
    move-object v1, p1
    move v2, p2
    move v3, p3
    move v4, p4
    move v5, p5
    invoke-virtual/range { v0 .. v5 }, Lcom/nokia/mid/ui/DirectGraphics;->drawImage(Ljavax/microedition/lcdui/Image;IIII)V
    goto :L0
.end method

.method public drawK(IIIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "c" # I
  .registers 10
  .prologue
    const/4 v3, 2
  .line 329
    if-nez p5, :L1
    const p5, 15400191
  :L0
  .line 335
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p5 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 336
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 1
    sub-int v2, p3, v3
    invoke-virtual { v0, v1, p2, v2, p4 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 337
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p2, 1
    sub-int v2, p4, v3
    invoke-virtual { v0, p1, v1, p3, v2 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 338
    return-void
  :L1
  .line 330
    const/4 v0, 1
    if-ne p5, v0, :L2
    const p5, 12352252
    goto :L0
  :L2
  .line 331
    if-ne p5, v3, :L3
    const p5, 12313343
    goto :L0
  :L3
  .line 332
    const/4 v0, 3
    if-ne p5, v0, :L4
    const p5, 5228543
    goto :L0
  :L4
  .line 333
    const/4 v0, 4
    if-ne p5, v0, :L5
    const/16 p5, 30975
    goto :L0
  :L5
  .line 334
    const p5, 11121884
    goto :L0
.end method

.method public drawK0(IIIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "c" # I
  .registers 14
  .prologue
    const/4 v7, 3
    const/4 v6, 1
    const/4 v4, 2
  .line 344
    int-to-byte v5, p5
  .line 346
  .local v5, "c0":B
    if-ne p5, v4, :L1
    const p5, 15400191
  :L0
  .line 348
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p5 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 349
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 1
    sub-int v2, p3, v7
    sub-int v3, p4, v6
    invoke-virtual { v0, v1, p2, v2, v3 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 350
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p2, 1
    sub-int v2, p3, v6
    sub-int v3, p4, v7
    invoke-virtual { v0, p1, v1, v2, v3 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 351
    add-int/lit8 v1, p1, 1
    add-int/lit8 v2, p2, 1
    sub-int v3, p3, v4
    sub-int v4, p4, v4
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  .line 352
    return-void
  :L1
  .line 347
    const p5, 1908277
    goto :L0
.end method

.method public drawK1(IIIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "c" # I
  .registers 14
  .prologue
    const/4 v7, 3
    const/4 v6, 1
    const/4 v5, 2
  .line 359
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    if-nez p5, :L3
    const v1, 5461075
  :L0
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 360
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p2, 2
    sub-int v2, p4, v7
    invoke-virtual { v0, p1, v1, p3, v2 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 361
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 1
    int-to-float v1, v1
    add-int v2, p2, p4
    int-to-float v2, v2
    add-int v3, p1, p3
    sub-int/2addr v3, v6
    int-to-float v3, v3
    add-int v4, p2, p4
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 362
    if-eqz p5, :L1
    if-ne p5, v6, :L4
  :L1
    const p5, 15400191
  :L2
  .line 366
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p5 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 367
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 1
    sub-int v2, p3, v5
    invoke-virtual { v0, v1, p2, v2, p4 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 368
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p2, 1
    sub-int v2, p4, v5
    invoke-virtual { v0, p1, v1, p3, v2 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 369
    return-void
  :L3
  .line 359
    const v1, 1908277
    goto :L0
  :L4
  .line 363
    if-ne p5, v5, :L5
    const p5, 13892607
    goto :L2
  :L5
  .line 364
    if-ne p5, v7, :L6
    const p5, 7727871
    goto :L2
  :L6
  .line 365
    const p5, 12352252
    goto :L2
.end method

.method public drawK2(IIIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "arc" # I
  .registers 11
  .prologue
    const/4 v4, 4
  .line 375
    if-nez p5, :L1
    const/4 p5, 5
  :L0
  .line 377
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const/4 v1, 0
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 379
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1, p2, p3, p4 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 380
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const/16 v1, 30975
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 382
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 2
    add-int/lit8 v2, p2, 2
    sub-int v3, p3, v4
    sub-int v4, p4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 383
    return-void
  :L1
  .line 376
    const/16 p5, 20
    goto :L0
.end method

.method public drawK3(IIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 12
  .prologue
    const/4 v6, 2
    const/4 v0, 1
  .line 385
    sub-int v3, p3, v0
    sub-int v4, p4, v0
    const/4 v5, 0
    move-object v0, p0
    move v1, p1
    move v2, p2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK0(IIIII)V
  .line 386
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const v1, 1908277
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 387
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 2
    add-int/lit8 v2, p2, 2
    sub-int v3, p3, v6
    sub-int v4, p4, v6
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 388
    return-void
.end method

.method public drawK4(IIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 12
  .prologue
    const/4 v6, 1
    const/4 v5, 2
  .line 390
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const v1, 16771373
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 391
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 1
    int-to-float v1, v1
    int-to-float v2, p2
    add-int v3, p1, p3
    sub-int/2addr v3, v5
    int-to-float v3, v3
    int-to-float v4, p2
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 392
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 1
    int-to-float v1, v1
    add-int v2, p2, p4
    sub-int/2addr v2, v6
    int-to-float v2, v2
    add-int v3, p1, p3
    sub-int/2addr v3, v5
    int-to-float v3, v3
    add-int v4, p2, p4
    sub-int/2addr v4, v6
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 393
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    int-to-float v1, p1
    add-int/lit8 v2, p2, 1
    int-to-float v2, v2
    int-to-float v3, p1
    add-int v4, p2, p4
    sub-int/2addr v4, v5
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 394
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int v1, p1, p3
    sub-int/2addr v1, v6
    int-to-float v1, v1
    add-int/lit8 v2, p2, 1
    int-to-float v2, v2
    add-int v3, p1, p3
    sub-int/2addr v3, v6
    int-to-float v3, v3
    add-int v4, p2, p4
    sub-int/2addr v4, v5
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 396
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    int-to-float v1, p1
    add-int/lit8 v2, p2, 1
    int-to-float v2, v2
    add-int/lit8 v3, p1, 1
    int-to-float v3, v3
    add-int/lit8 v4, p2, 1
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 397
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int v1, p1, p3
    sub-int/2addr v1, v5
    int-to-float v1, v1
    add-int/lit8 v2, p2, 1
    int-to-float v2, v2
    add-int v3, p1, p3
    sub-int/2addr v3, v6
    int-to-float v3, v3
    add-int/lit8 v4, p2, 1
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 398
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    int-to-float v1, p1
    add-int v2, p2, p4
    sub-int/2addr v2, v5
    int-to-float v2, v2
    add-int/lit8 v3, p1, 1
    int-to-float v3, v3
    add-int v4, p2, p4
    sub-int/2addr v4, v5
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 399
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int v1, p1, p3
    sub-int/2addr v1, v5
    int-to-float v1, v1
    add-int v2, p2, p4
    sub-int/2addr v2, v5
    int-to-float v2, v2
    add-int v3, p1, p3
    sub-int/2addr v3, v5
    int-to-float v3, v3
    add-int v4, p2, p4
    sub-int/2addr v4, v5
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 400
    return-void
.end method

.method public drawKuang(IIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 13
  .prologue
    const/4 v4, 4
    const/4 v7, 1
    const/4 v6, 3
    const/4 v5, 2
  .line 409
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const v1, 1908277
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 410
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 1
    sub-int v2, p3, v4
    sub-int v3, p4, v5
    invoke-virtual { v0, v1, p2, v2, v3 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 411
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 2
    add-int/lit8 v2, p2, 1
    sub-int v3, p3, v4
    sub-int v4, p4, v5
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 412
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    int-to-float v1, p1
    add-int/lit8 v2, p2, 1
    int-to-float v2, v2
    int-to-float v3, p1
    add-int v4, p2, p4
    sub-int/2addr v4, v6
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 413
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int v1, p1, p3
    sub-int/2addr v1, v7
    int-to-float v1, v1
    add-int/lit8 v2, p2, 2
    int-to-float v2, v2
    add-int v3, p1, p3
    sub-int/2addr v3, v7
    int-to-float v3, v3
    add-int v4, p2, p4
    sub-int/2addr v4, v5
    int-to-float v4, v4
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 414
    const v1, 15400191
    add-int/lit8 v2, p1, 1
    add-int/lit8 v3, p2, 1
    sub-int v4, p3, v6
    sub-int v5, p4, v6
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 415
    return-void
.end method

.method public drawKuangAdorn(IIIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "mode" # I
  .registers 16
  .prologue
    const/16 v5, 22
    const/4 v9, 1
    const/4 v8, 0
    const/16 v7, 25
    const/16 v6, 11
  .line 442
    if-nez p5, :L1
  .line 443
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const v1, 1842484
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 444
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 20
    sub-int v2, p2, v5
    const/16 v3, 21
    sub-int v3, p3, v3
    const/16 v4, 20
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 445
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 20
    sub-int v2, p2, v5
    sub-int v3, p3, v5
    const/16 v4, 21
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 446
    const v1, 15129744
    add-int/lit8 v2, p1, 20
    sub-int v3, p2, v5
    sub-int v4, p3, v5
    const/16 v5, 20
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 447
    const/16 v1, 33
    const/16 v4, 36
    move-object v0, p0
    move v2, p1
    move v3, p2
    move v5, v8
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  .line 448
    const/16 v1, 31
    add-int v0, p1, p3
    const/4 v2, 4
    sub-int v2, v0, v2
    const/16 v4, 36
    move-object v0, p0
    move v3, p2
    move v5, v8
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  :L0
  .line 472
    return-void
  :L1
  .line 449
    if-ne p5, v9, :L2
  .line 450
    const/16 v1, 32
    const/4 v0, 7
    sub-int v3, p2, v0
    move-object v0, p0
    move v2, p1
    move v4, v8
    move v5, v8
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  .line 451
    const/16 v1, 32
    add-int v0, p1, p3
    add-int/lit8 v2, v0, 5
    const/4 v0, 7
    sub-int v3, p2, v0
    const/16 v0, 8
    or-int/lit8 v4, v0, 16
    move-object v0, p0
    move v5, v8
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  .line 452
    const v1, 13550445
    add-int/lit8 v2, p1, 15
    const/4 v0, 5
    sub-int v3, p2, v0
    sub-int v4, p3, v7
    const/16 v5, 13
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 453
    const v1, 16116383
    add-int/lit8 v2, p1, 15
    const/4 v0, 3
    sub-int v3, p2, v0
    sub-int v4, p3, v7
    const/16 v5, 10
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 454
    const v1, 13078326
    add-int/lit8 v2, p1, 15
    add-int/lit8 v3, p2, 10
    sub-int v4, p3, v7
    const/4 v5, 5
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 455
    const v1, 1842484
    add-int/lit8 v2, p1, 15
    const/4 v0, 7
    sub-int v3, p2, v0
    add-int v0, p1, p3
    sub-int v4, v0, v6
    const/4 v0, 7
    sub-int v5, p2, v0
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawLine(IIIII)V
  .line 456
    const v1, 16446403
    add-int/lit8 v2, p1, 15
    const/4 v0, 6
    sub-int v3, p2, v0
    add-int v0, p1, p3
    sub-int v4, v0, v6
    const/4 v0, 6
    sub-int v5, p2, v0
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawLine(IIIII)V
  .line 457
    const v1, 6168835
    add-int/lit8 v2, p1, 15
    add-int/lit8 v3, p2, 12
    add-int v0, p1, p3
    sub-int v4, v0, v6
    add-int/lit8 v5, p2, 12
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawLine(IIIII)V
  .line 458
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const v1, 13281366
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 459
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 15
    add-int/lit8 v2, p2, 8
    const/16 v3, 26
    sub-int v3, p3, v3
    invoke-virtual { v0, v1, v2, v3, v9 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
    goto/16 :L0
  :L2
  .line 460
    const/4 v0, 2
    if-ne p5, v0, :L0
  .line 461
    const/16 v1, 32
    add-int v0, p2, p4
    sub-int v3, v0, v9
    const/16 v4, 36
    const/4 v5, 6
    move-object v0, p0
    move v2, p1
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  .line 462
    const/16 v1, 32
    add-int v0, p1, p3
    add-int/lit8 v2, v0, 5
    add-int v0, p2, p4
    sub-int v3, v0, v9
    const/16 v4, 40
    const/4 v5, 6
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  .line 463
    const v1, 13550445
    add-int/lit8 v2, p1, 15
    add-int v0, p2, p4
    const/16 v3, 16
    sub-int v3, v0, v3
    sub-int v4, p3, v7
    const/16 v5, 13
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 464
    const v1, 16116383
    add-int/lit8 v2, p1, 15
    add-int v0, p2, p4
    const/16 v3, 15
    sub-int v3, v0, v3
    sub-int v4, p3, v7
    const/16 v5, 10
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 465
    const v1, 13078326
    add-int/lit8 v2, p1, 15
    add-int v0, p2, p4
    const/16 v3, 23
    sub-int v3, v0, v3
    sub-int v4, p3, v7
    const/4 v5, 5
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 466
    const v1, 1842484
    add-int/lit8 v2, p1, 15
    add-int v0, p2, p4
    const/4 v3, 2
    sub-int v3, v0, v3
    add-int v0, p1, p3
    sub-int v4, v0, v6
    add-int v0, p2, p4
    const/4 v5, 2
    sub-int v5, v0, v5
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawLine(IIIII)V
  .line 467
    const v1, 16446403
    add-int/lit8 v2, p1, 15
    add-int v0, p2, p4
    const/4 v3, 3
    sub-int v3, v0, v3
    add-int v0, p1, p3
    sub-int v4, v0, v6
    add-int v0, p2, p4
    const/4 v5, 3
    sub-int v5, v0, v5
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawLine(IIIII)V
  .line 468
    const v1, 6168835
    add-int/lit8 v2, p1, 15
    add-int v0, p2, p4
    const/16 v3, 21
    sub-int v3, v0, v3
    add-int v0, p1, p3
    sub-int v4, v0, v6
    add-int v0, p2, p4
    const/16 v5, 21
    sub-int v5, v0, v5
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawLine(IIIII)V
  .line 469
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    const v1, 13281366
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 470
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 15
    add-int v2, p2, p4
    const/16 v3, 18
    sub-int/2addr v2, v3
    const/16 v3, 26
    sub-int v3, p3, v3
    invoke-virtual { v0, v1, v2, v3, v9 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
    goto/16 :L0
.end method

.method public drawKuangMap(IIIIZ)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "mode" # Z
  .registers 13
  .prologue
    const/4 v6, 2
  .line 433
    if-eqz p5, :L2
    const/16 v0, 14961
    move v1, v0
  :L0
    move-object v0, p0
    move v2, p1
    move v3, p2
    move v4, p3
    move v5, p4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 434
    if-eqz p5, :L3
    const v0, 6724095
    move v1, v0
  :L1
    add-int/lit8 v2, p1, 1
    add-int/lit8 v3, p2, 1
    sub-int v4, p3, v6
    sub-int v5, p4, v6
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
  .line 435
    return-void
  :L2
  .line 433
    const v0, 16762112
    move v1, v0
    goto :L0
  :L3
  .line 434
    const v0, 11370036
    move v1, v0
    goto :L1
.end method

.method public drawKuangSelect(IIIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "mode" # I
  .registers 12
  .prologue
    const/4 v5, 3
    const/4 v3, 2
    const/4 v4, 1
  .line 422
    const v0, 13281366
  .line 423
  .local v0, "color":I
    if-ne p5, v4, :L1
    const v0, 11370036
  :L0
  .line 428
    sget-object v1, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v1, v0 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 429
    sget-object v1, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v2, p1, 1
    sub-int v3, p3, v3
    invoke-virtual { v1, v2, p2, v3, p4 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 430
    sget-object v1, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v2, p2, 1
    sub-int v3, p3, v4
    sub-int v4, p4, v5
    invoke-virtual { v1, p1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 431
    return-void
  :L1
  .line 424
    if-ne p5, v3, :L2
    const v0, 2233088
    goto :L0
  :L2
  .line 425
    if-ne p5, v5, :L3
    const v0, 15129744
    goto :L0
  :L3
  .line 426
    const/4 v1, 4
    if-ne p5, v1, :L4
    const v0, 16762112
    goto :L0
  :L4
  .line 427
    const/4 v1, 5
    if-ne p5, v1, :L0
    const v0, 6168835
    goto :L0
.end method

.method public drawLine(IIIII)V
  .parameter "c" # I
  .parameter "x0" # I
  .parameter "y0" # I
  .parameter "x1" # I
  .parameter "y1" # I
  .registers 11
  .prologue
  .line 177
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 178
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    int-to-float v1, p2
    int-to-float v2, p3
    int-to-float v3, p4
    int-to-float v4, p5
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V
  .line 179
    return-void
.end method

.method public drawListKY(IIIIIIIIII)V
  .parameter "length" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "kw" # I
  .parameter "kh" # I
  .parameter "dis" # I
  .parameter "sel" # I
  .parameter "c0" # I
  .parameter "c1" # I
  .registers 18
  .prologue
  .line 692
    const/4 v6, 0
  :L0
  .local v6, "d":B
    if-lt v6, p1, :L2
  .line 694
    const/4 v0, -1
    if-eq p8, v0, :L1
    add-int v0, p6, p7
    mul-int/2addr v0, p8
    add-int v2, p3, v0
    move-object v0, p0
    move v1, p2
    move v3, p4
    move v4, p6
    move/from16 v5, p9
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK1(IIIII)V
  :L1
  .line 695
    return-void
  :L2
  .line 693
    if-eq v6, p8, :L3
    add-int v1, p2, p5
    add-int v0, p6, p7
    mul-int/2addr v0, v6
    add-int v2, p3, v0
    shl-int/lit8 v0, p5, 1
    sub-int v3, p4, v0
    move-object v0, p0
    move v4, p6
    move/from16 v5, p10
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK0(IIIII)V
  :L3
  .line 692
    add-int/lit8 v0, v6, 1
    int-to-byte v6, v0
    goto :L0
.end method

.method public drawListSY([Ljava/lang/Object;IIIIIIII)V
  .parameter "menu" # [Ljava/lang/Object;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "sh" # I
  .parameter "sel" # I
  .parameter "c0" # I
  .parameter "c1" # I
  .parameter "strT" # I
  .registers 18
  .prologue
  .line 687
    const/4 v7, 0
  :L0
  .local v7, "d":B
    array-length v0, p1
    if-lt v7, v0, :L1
  .line 689
    const-string v0, "sk"
    const-string v1, "drawListSY"
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 690
    return-void
  :L1
  .line 688
    aget-object v0, p1, v7
    invoke-virtual { v0 }, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    shr-int/lit8 v0, p4, 1
    add-int v2, p2, v0
    add-int/lit8 v0, p3, 2
    mul-int v3, v7, p5
    add-int/2addr v3, v0
    const/16 v4, 17
    if-ne v7, p6, :L3
    move v5, p7
  :L2
    move-object v0, p0
    move/from16 v6, p9
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 687
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L0
  :L3
    move/from16 v5, p8
  .line 688
    goto :L2
.end method

.method public drawListSYHasSound([Ljava/lang/Object;IIIIIIII)V
  .parameter "menu" # [Ljava/lang/Object;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "sh" # I
  .parameter "sel" # I
  .parameter "c0" # I
  .parameter "c1" # I
  .parameter "strT" # I
  .registers 18
  .prologue
  .line 702
    const/4 v7, 0
  :L0
  .local v7, "d":B
    array-length v0, p1
    if-lt v7, v0, :L1
  .line 705
    return-void
  :L1
  .line 703
    aget-object v0, p1, v7
    invoke-virtual { v0 }, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    shr-int/lit8 v0, p4, 1
    add-int v2, p2, v0
    add-int/lit8 v0, p3, 2
    mul-int v3, v7, p5
    add-int/2addr v3, v0
    aget-object v0, p1, v7
    invoke-virtual { v0 }, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v4, "\u58f0\u97f3"
    invoke-virtual { v0, v4 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, :L4
    const/16 v0, 20
    move v4, v0
  :L2
    if-ne v7, p6, :L5
    move v5, p7
  :L3
    move-object v0, p0
    move/from16 v6, p9
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 702
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L0
  :L4
  .line 703
    const/16 v0, 17
    move v4, v0
    goto :L2
  :L5
    move/from16 v5, p8
    goto :L3
.end method

.method public drawModuleOne(Ldm/Sprite;IIIII)V
  .parameter "sp" # Ldm/Sprite;
  .parameter "m_id" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "dir" # I
  .parameter "manipulation" # I
  .registers 18
  .prologue
  .line 115
    iget-object v1, p1, Ldm/Sprite;->img:Ljavax/microedition/lcdui/Image;
    const/4 v0, 0
    invoke-virtual { p1, p2, v0 }, Ldm/Sprite;->module(II)I
    move-result v2
    const/4 v0, 1
    invoke-virtual { p1, p2, v0 }, Ldm/Sprite;->module(II)I
    move-result v3
    const/4 v0, 2
    invoke-virtual { p1, p2, v0 }, Ldm/Sprite;->module(II)I
    move-result v4
    const/4 v0, 3
    invoke-virtual { p1, p2, v0 }, Ldm/Sprite;->module(II)I
    move-result v5
  .line 116
    iget-object v0, p0, Ldm/Ui;->MIRROR:[I
    aget v8, v0, p5
    iget-object v0, p0, Ldm/Ui;->MIRROR2:[[B
    aget-object v0, v0, p5
    aget-byte v9, v0, p6
    sget-object v10, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    move-object v0, p0
    move v6, p3
    move v7, p4
  .line 115
    invoke-virtual/range { v0 .. v10 }, Ldm/Ui;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIIILjavax/microedition/lcdui/Graphics;)V
  .line 118
    return-void
.end method

.method public drawNum(Ljava/lang/String;IIII)V
  .parameter "str" # Ljava/lang/String;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "anchor" # I
  .parameter "type" # I
  .registers 21
  .prologue
  .line 533
    invoke-virtual/range { p1 .. p1 }, Ljava/lang/String;->length()I
    move-result v2
    if-nez v2, :L1
  :L0
  .line 566
    return-void
  :L1
  .line 534
    if-nez p4, :L9
    const/4 v2, 0
  :L2
    int-to-byte v12, v2
  .line 535
  .local v12, "i":B
    const/4 v13, 0
  :L3
  .line 538
  .local v13, "sw":S
    if-nez p5, :L10
    const/16 v14, 8
  :L4
  .line 541
  .local v14, "w":B
    const/4 v3, -1
  .line 542
  .local v3, "bid":B
    move-object/from16 v0, p1
    move v1, v12
    invoke-virtual { v0, v1 }, Ljava/lang/String;->charAt(I)C
    move-result v11
  .line 543
  .local v11, "cr":C
    const/16 v2, 48
    if-lt v11, v2, :L14
    const/16 v2, 57
    if-gt v11, v2, :L14
  .line 544
    const/16 v2, 48
    sub-int v2, v11, v2
    int-to-byte v3, v2
  .line 545
    if-nez p5, :L12
    add-int/lit8 v2, v3, 10
    int-to-byte v3, v2
  :L5
  .line 554
    const/4 v2, -1
    if-eq v3, v2, :L22
  .line 555
    if-nez p4, :L21
    add-int v4, p2, v13
    const/16 v6, 36
    const/4 v7, 0
    move-object v2, p0
    move/from16 v5, p3
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawUi(IIIII)V
  :L6
  .line 557
    add-int v2, v13, v14
    int-to-short v13, v2
  :L7
  .line 563
    if-nez p4, :L25
    add-int/lit8 v2, v12, 1
    int-to-byte v12, v2
  :L8
  .line 565
    if-nez p4, :L26
    invoke-virtual/range { p1 .. p1 }, Ljava/lang/String;->length()I
    move-result v2
    if-lt v12, v2, :L3
    goto :L0
  :L9
  .line 534
  .end local v3
  .end local v11
  .end local v12
  .end local v13
  .end local v14
    invoke-virtual/range { p1 .. p1 }, Ljava/lang/String;->length()I
    move-result v2
    const/4 v3, 1
    sub-int/2addr v2, v3
    goto :L2
  :L10
  .line 539
  .restart local v12
  .restart local v13
    const/4 v2, 1
    move/from16 v0, p5
    move v1, v2
    if-ne v0, v1, :L11
    const/16 v14, 10
  .restart local v14
    goto :L4
  :L11
  .line 540
  .end local v14
    const/16 v14, 14
  .restart local v14
    goto :L4
  :L12
  .line 546
  .restart local v3
  .restart local v11
    const/4 v2, 1
    move/from16 v0, p5
    move v1, v2
    if-ne v0, v1, :L13
    add-int/lit8 v2, v3, 35
    int-to-byte v3, v2
    goto :L5
  :L13
  .line 547
    add-int/lit8 v2, v3, 57
    int-to-byte v3, v2
    goto :L5
  :L14
  .line 548
    const/16 v2, 47
    if-ne v11, v2, :L15
    const/16 v3, 20
    goto :L5
  :L15
  .line 549
    const/16 v2, 45
    if-ne v11, v2, :L18
    const/4 v2, 2
    move/from16 v0, p5
    move v1, v2
    if-ne v0, v1, :L17
    const/16 v2, 56
  :L16
    int-to-byte v3, v2
    goto :L5
  :L17
    const/16 v2, 46
    goto :L16
  :L18
  .line 550
    const/16 v2, 43
    if-ne v11, v2, :L19
    const/16 v3, 47
    goto :L5
  :L19
  .line 551
    const/16 v2, 37
    if-ne v11, v2, :L20
    const/16 v3, 45
    const/16 v14, 14
    goto :L5
  :L20
  .line 552
    const/16 v2, 32423
    if-ne v11, v2, :L5
    const/16 v3, 29
    const/16 v14, 12
    goto :L5
  :L21
  .line 556
    sub-int v4, p2, v13
    const/16 v6, 40
    const/4 v7, 0
    move-object v2, p0
    move/from16 v5, p3
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawUi(IIIII)V
    goto :L6
  :L22
  .line 559
    if-nez p4, :L24
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct { v2 }, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual { v2, v11 }, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    add-int v6, p2, v13
    add-int/lit8 v7, p3, 5
    const/16 v8, 36
    const/4 v9, 3
    const/4 v10, 0
    move-object v4, p0
    invoke-virtual/range { v4 .. v10 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  :L23
  .line 561
    add-int/lit8 v2, v13, 25
    int-to-short v13, v2
    goto/16 :L7
  :L24
  .line 560
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct { v2 }, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual { v2, v11 }, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    sub-int v6, p2, v13
    add-int/lit8 v7, p3, 5
    const/16 v8, 40
    const/4 v9, 3
    const/4 v10, 0
    move-object v4, p0
    invoke-virtual/range { v4 .. v10 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
    goto :L23
  :L25
  .line 564
    const/4 v2, 1
    sub-int v2, v12, v2
    int-to-byte v12, v2
    goto/16 :L8
  :L26
  .line 565
    const/4 v2, -1
    if-gt v12, v2, :L3
    goto/16 :L0
.end method

.method public drawRect(IIIII)V
  .parameter "c" # I
  .parameter "x0" # I
  .parameter "y0" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 7
  .prologue
  .line 181
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 182
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p2, p3, p4, p5 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 183
    return-void
.end method

.method public drawRectZ(IIIIII)V
  .parameter "color" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "s" # I
  .registers 12
  .prologue
  .line 569
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 570
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-byte v1, p0, Ldm/Ui;->rz:B
    invoke-static { v1 }, Ldm/Ms;->abs(I)I
    move-result v1
    sub-int v1, p2, v1
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-byte v2, p0, Ldm/Ui;->rz:B
    invoke-static { v2 }, Ldm/Ms;->abs(I)I
    move-result v2
    sub-int v2, p3, v2
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-byte v3, p0, Ldm/Ui;->rz:B
    invoke-static { v3 }, Ldm/Ms;->abs(I)I
    move-result v3
    shl-int/lit8 v3, v3, 1
    add-int/2addr v3, p4
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-byte v4, p0, Ldm/Ui;->rz:B
    invoke-static { v4 }, Ldm/Ms;->abs(I)I
    move-result v4
    shl-int/lit8 v4, v4, 1
    add-int/2addr v4, p5
    invoke-virtual { v0, v1, v2, v3, v4 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 571
    iget-byte v0, p0, Ldm/Ui;->rz:B
    add-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    iput-byte v0, p0, Ldm/Ui;->rz:B
    if-le v0, p6, :L0
    neg-int v0, p6
    int-to-byte v0, v0
    iput-byte v0, p0, Ldm/Ui;->rz:B
  :L0
  .line 572
    return-void
.end method

.method public drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIIILjavax/microedition/lcdui/Graphics;)V
  .parameter "image" # Ljavax/microedition/lcdui/Image;
  .parameter "mx" # I
  .parameter "my" # I
  .parameter "mw" # I
  .parameter "mh" # I
  .parameter "realX" # I
  .parameter "realY" # I
  .parameter "anchor" # I
  .parameter "manipulation" # I
  .parameter "g" # Ljavax/microedition/lcdui/Graphics;
  .registers 21
  .prologue
  .line 106
    sget-object v0, Ldm/Ui;->transforms:[S
    aget-short v6, v0, p9
    move-object/from16 v0, p10
    move-object v1, p1
    move v2, p2
    move v3, p3
    move v4, p4
    move v5, p5
    move/from16 v7, p6
    move/from16 v8, p7
    move/from16 v9, p8
    invoke-virtual/range { v0 .. v9 }, Ljavax/microedition/lcdui/Graphics;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIII)V
  .line 107
    return-void
.end method

.method public drawString(Ljava/lang/String;IIIII)V
  .parameter "str_hit" # Ljava/lang/String;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "anchor" # I
  .parameter "color" # I
  .parameter "mode" # I
  .registers 13
  .prologue
    const/4 v5, 1
  .line 195
    const v0, 13281366
  .line 196
  .local v0, "c0":I
    const v1, 3676168
  .line 197
  .local v1, "c1":I
    add-int/lit8 p3, p3, 1
  .line 198
    packed-switch p5, :L14
  :L0
  .line 245
    const/4 v2, 2
    if-ne p6, v2, :L1
  .line 246
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v2, v0 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 247
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    sub-int v3, p2, v5
    invoke-virtual { v2, p1, v3, p3, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  .line 248
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v3, p2, 1
    invoke-virtual { v2, p1, v3, p3, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  .line 249
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    sub-int v3, p3, v5
    invoke-virtual { v2, p1, p2, v3, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  .line 250
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v3, p3, 1
    invoke-virtual { v2, p1, p2, v3, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  .line 251
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v3, p2, 1
    add-int/lit8 v4, p3, 1
    invoke-virtual { v2, p1, v3, v4, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  .line 252
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    sub-int v3, p2, v5
    add-int/lit8 v4, p3, 1
    invoke-virtual { v2, p1, v3, v4, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  .line 253
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    sub-int v3, p2, v5
    sub-int v4, p3, v5
    invoke-virtual { v2, p1, v3, v4, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  .line 254
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v3, p2, 1
    sub-int v4, p3, v5
    invoke-virtual { v2, p1, v3, v4, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  :L1
  .line 256
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v2, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 257
    if-ne p6, v5, :L2
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v3, p2, 1
    invoke-virtual { v2, p1, v3, p3, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  :L2
  .line 258
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v2, p1, p2, p3, p4 }, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V
  .line 259
    return-void
  :L3
  .line 200
    const/4 v0, 0
  .line 202
    const v1, 16777215
  .line 203
    goto :L0
  :L4
  .line 205
    const v0, 5461075
  .line 206
    const v1, 7727871
  .line 207
    goto :L0
  :L5
  .line 209
    const v0, 2707928
  .line 210
    const v1, 43016
  .line 211
    goto :L0
  :L6
  .line 213
    const v0, 1908277
  .line 214
    const/16 v1, 24295
  .line 215
    goto :L0
  :L7
  .line 217
    const v0, 1314307
  .line 218
    const v1, 5228543
  .line 219
    goto :L0
  :L8
  .line 221
    const v0, 2233603
  .line 222
    const v1, 16739328
  .line 223
    goto/16 :L0
  :L9
  .line 225
    const v0, 8075577
  .line 226
    const v1, 16189448
  .line 227
    goto/16 :L0
  :L10
  .line 229
    const v0, 4467457
  .line 230
    const v1, 16757760
  .line 231
    goto/16 :L0
  :L11
  .line 233
    const v0, 10122756
  .line 234
    const v1, 12583167
  .line 235
    goto/16 :L0
  :L12
  .line 237
    const v0, 11563064
  .line 238
    const v1, 3676168
  .line 239
    goto/16 :L0
  :L13
  .line 241
    const v0, 1311269
  .line 242
    const v1, 8816262
    goto/16 :L0
  .line 198
  :L14
  .packed-switch 0
    :L3
    :L4
    :L5
    :L6
    :L7
    :L8
    :L9
    :L10
    :L11
    :L12
    :L13
  .end packed-switch
.end method

.method public drawStringColor(Ljava/lang/String;IIII)V
  .parameter "str" # Ljava/lang/String;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "color" # I
  .parameter "mode" # I
  .registers 25
  .prologue
  .line 261
    move/from16 v0, p4
    int-to-byte v0, v0
    move v8, v0
  .local v8, "c":B
    const/16 v17, 0
  .line 262
  .local v17, "start":B
    const/16 v18, 0
  :L0
  .line 265
  .local v18, "tw":S
    const-string v3, "#"
    move-object/from16 v0, p1
    move-object v1, v3
    move/from16 v2, v17
    invoke-virtual { v0, v1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I
    move-result v3
    move v0, v3
    int-to-byte v0, v0
    move/from16 v16, v0
  .line 266
  .local v16, "end":B
    const/4 v3, -1
    move/from16 v0, v16
    move v1, v3
    if-eq v0, v1, :L2
  .line 267
    move-object/from16 v0, p1
    move/from16 v1, v17
    move/from16 v2, v16
    invoke-virtual { v0, v1, v2 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
    move-result-object v4
  .line 268
  .local v4, "ssub":Ljava/lang/String;
    add-int v5, p2, v18
    const/4 v7, 0
    move-object/from16 v3, p0
    move/from16 v6, p3
    move/from16 v9, p5
    invoke-virtual/range { v3 .. v9 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 269
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v3
    invoke-virtual { v3, v4 }, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I
    move-result v3
    add-int v3, v3, v18
    move v0, v3
    int-to-short v0, v0
    move/from16 v18, v0
  .line 270
    add-int/lit8 v3, v16, 1
    add-int/lit8 v4, v16, 2
    move-object/from16 v0, p1
    move v1, v3
    move v2, v4
    invoke-virtual { v0, v1, v2 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
  .end local v4
    move-result-object v3
    invoke-static { v3 }, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    move-result v3
    const/4 v4, 1
    sub-int/2addr v3, v4
    int-to-byte v8, v3
  .line 271
    add-int/lit8 v3, v16, 2
    move v0, v3
    int-to-byte v0, v0
    move/from16 v17, v0
  .line 272
    const/4 v3, -1
    if-ne v8, v3, :L1
    move/from16 v0, p4
    int-to-byte v0, v0
    move v8, v0
  :L1
  .line 276
    const/4 v3, -1
    move/from16 v0, v16
    move v1, v3
    if-ne v0, v1, :L0
  .line 277
    return-void
  :L2
  .line 274
    invoke-virtual/range { p1 .. p1 }, Ljava/lang/String;->length()I
    move-result v3
    move-object/from16 v0, p1
    move/from16 v1, v17
    move v2, v3
    invoke-virtual { v0, v1, v2 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
    move-result-object v10
    add-int v11, p2, v18
    const/4 v13, 0
    move-object/from16 v9, p0
    move/from16 v12, p3
    move v14, v8
    move/from16 v15, p5
    invoke-virtual/range { v9 .. v15 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
    goto :L1
.end method

.method public drawStringY([Ljava/lang/Object;IIIIIII)V
  .parameter "str" # [Ljava/lang/Object;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "start" # I
  .parameter "end" # I
  .parameter "sh" # I
  .parameter "c" # I
  .parameter "strT" # I
  .registers 17
  .prologue
  .line 697
    int-to-byte v7, p4
  :L0
  .local v7, "i":B
    if-ge v7, p5, :L1
    array-length v0, p1
    if-lt v7, v0, :L2
  :L1
  .line 699
    return-void
  :L2
  .line 698
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    aget-object v1, p1, v7
    invoke-virtual { v1 }, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    sub-int v2, v7, p4
    mul-int/2addr v2, p6
    add-int v3, p3, v2
    const/4 v4, 0
    move v2, p2
    move v5, p7
    move/from16 v6, p8
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 697
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L0
.end method

.method public drawStringY([Ljava/lang/StringBuffer;IIIII)V
  .parameter "showS" # [Ljava/lang/StringBuffer;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "fh" # I
  .parameter "color" # I
  .parameter "mode" # I
  .registers 14
  .prologue
  .line 279
    const/4 v6, 0
  :L0
  .local v6, "d":B
    array-length v0, p1
    if-lt v6, v0, :L1
  .line 281
    return-void
  :L1
  .line 280
    aget-object v0, p1, v6
    invoke-virtual { v0 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v1
    add-int/lit8 v0, p3, 4
    mul-int v2, v6, p4
    add-int v3, v0, v2
    move-object v0, p0
    move v2, p2
    move v4, p5
    move v5, p6
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V
  .line 279
    add-int/lit8 v0, v6, 1
    int-to-byte v6, v0
    goto :L0
.end method

.method public drawTriangle(IIIZZ)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "dir" # Z
  .parameter "ct" # Z
  .registers 6
  .prologue
  .line 602
    return-void
.end method

.method public drawTriangle1(IIIZZ)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "dir" # Z
  .parameter "ct" # Z
  .registers 12
  .prologue
  .line 603
    const/16 v1, 30
    sub-int v0, p1, p3
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-byte v2, p0, Ldm/Ui;->cTriangle:B
    invoke-static { v2 }, Ldm/Ms;->abs(I)I
    move-result v2
    sub-int v2, v0, v2
    const/4 v0, 4
    or-int/lit8 v4, v0, 2
    const/4 v5, 4
    move-object v0, p0
    move v3, p2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  .line 604
    const/16 v1, 30
    add-int v0, p1, p3
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-byte v2, p0, Ldm/Ui;->cTriangle:B
    invoke-static { v2 }, Ldm/Ms;->abs(I)I
    move-result v2
    add-int/2addr v2, v0
    const/16 v0, 8
    or-int/lit8 v4, v0, 2
    const/4 v5, 0
    move-object v0, p0
    move v3, p2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  .line 605
    if-eqz p5, :L0
    iget-byte v0, p0, Ldm/Ui;->cTriangle:B
    add-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    iput-byte v0, p0, Ldm/Ui;->cTriangle:B
    const/4 v1, 4
    if-le v0, v1, :L0
    const/4 v0, -3
    iput-byte v0, p0, Ldm/Ui;->cTriangle:B
  :L0
  .line 606
    return-void
.end method

.method public drawUi(IIIII)V
  .parameter "action" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "anchor" # I
  .parameter "manipulation" # I
  .registers 17
  .prologue
  .line 295
    iget-object v1, p0, Ldm/Ui;->ui_img:Ljavax/microedition/lcdui/Image;
    iget-object v0, p0, Ldm/Ui;->ui_modules:[[S
    aget-object v0, v0, p1
    const/4 v2, 0
    aget-short v2, v0, v2
    iget-object v0, p0, Ldm/Ui;->ui_modules:[[S
    aget-object v0, v0, p1
    const/4 v3, 1
    aget-short v3, v0, v3
    iget-object v0, p0, Ldm/Ui;->ui_modules:[[S
    aget-object v0, v0, p1
    const/4 v4, 2
    aget-short v4, v0, v4
  .line 296
    iget-object v0, p0, Ldm/Ui;->ui_modules:[[S
    aget-object v0, v0, p1
    const/4 v5, 3
    aget-short v5, v0, v5
    sget-object v10, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    move-object v0, p0
    move v6, p2
    move v7, p3
    move v8, p4
    move/from16 v9, p5
  .line 295
    invoke-virtual/range { v0 .. v10 }, Ldm/Ui;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIIILjavax/microedition/lcdui/Graphics;)V
  .line 298
    return-void
.end method

.method public drawVolume(IIIZ)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "v" # I
  .parameter "bb" # Z
  .registers 14
  .prologue
    const/16 v8, 8
    const/4 v7, 1
    const/4 v6, 7
    const/4 v5, 6
    const/4 v4, 5
  .line 313
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    if-eqz p4, :L5
    const v1, 458827
  :L0
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 314
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    sub-int v1, p1, v7
    add-int/lit8 v1, v1, 3
    add-int/lit8 v2, p2, 5
    const/16 v3, 10
    invoke-virtual { v0, v1, v2, v6, v3 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 315
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 5
    add-int/lit8 v1, v1, 2
    add-int/lit8 v1, v1, 3
    add-int/lit8 v2, p2, 2
    const/16 v3, 13
    invoke-virtual { v0, v1, v2, v6, v3 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 316
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 11
    add-int/lit8 v1, v1, 4
    add-int/lit8 v1, v1, 3
    sub-int v2, p2, v7
    const/16 v3, 16
    invoke-virtual { v0, v1, v2, v8, v3 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 317
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    if-eqz p4, :L6
    const v1, 16048400
  :L1
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 318
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 3
    add-int/lit8 v2, p2, 6
    invoke-virtual { v0, v1, v2, v5, v8 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 319
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 6
    add-int/lit8 v1, v1, 2
    add-int/lit8 v1, v1, 3
    add-int/lit8 v2, p2, 3
    const/16 v3, 11
    invoke-virtual { v0, v1, v2, v5, v3 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 320
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 12
    add-int/lit8 v1, v1, 4
    add-int/lit8 v1, v1, 3
    const/16 v2, 14
    invoke-virtual { v0, v1, p2, v5, v2 }, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V
  .line 321
    if-lez p3, :L2
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 1
    add-int/lit8 v1, v1, 3
    add-int/lit8 v2, p2, 7
    invoke-virtual { v0, v1, v2, v4, v6 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  :L2
  .line 322
    const/16 v0, 30
    if-le p3, v0, :L3
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 7
    add-int/lit8 v1, v1, 2
    add-int/lit8 v1, v1, 3
    add-int/lit8 v2, p2, 4
    const/16 v3, 10
    invoke-virtual { v0, v1, v2, v4, v3 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  :L3
  .line 323
    const/16 v0, 60
    if-le p3, v0, :L4
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    add-int/lit8 v1, p1, 13
    add-int/lit8 v1, v1, 4
    add-int/lit8 v1, v1, 3
    add-int/lit8 v2, p2, 1
    const/16 v3, 13
    invoke-virtual { v0, v1, v2, v4, v3 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  :L4
  .line 324
    return-void
  :L5
  .line 313
    const v1, 11563064
    goto/16 :L0
  :L6
  .line 317
    const v1, 3676168
    goto :L1
.end method

.method public drawYesNo(ZZ)V
  .parameter "a" # Z
  .parameter "b" # Z
  .registers 13
  .prologue
    const/4 v2, 0
  .line 608
    const/16 v6, 640
  .local v6, "WIDTH":I
    const/16 v3, 360
  .line 609
  .local v3, "HEIGHT":I
    if-eqz p1, :L0
    const/16 v1, 27
    const/16 v4, 36
    move-object v0, p0
    move v5, v2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  :L0
  .line 610
    if-eqz p2, :L1
    const/16 v5, 28
    const/16 v8, 40
    move-object v4, p0
    move v7, v3
    move v9, v2
    invoke-virtual/range { v4 .. v9 }, Ldm/Ui;->drawUi(IIIII)V
  :L1
  .line 611
    return-void
.end method

.method public drawYesNo_(ZZ)V
  .parameter "a" # Z
  .parameter "b" # Z
  .registers 12
  .prologue
    const/4 v2, 0
  .line 613
    if-eqz p1, :L0
    const/16 v1, 27
    sget v3, Lmain/Constants_H;->HEIGHT:I
    const/16 v4, 36
    move-object v0, p0
    move v5, v2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  :L0
  .line 614
    if-eqz p2, :L1
    const/16 v4, 28
    sget v5, Lmain/Constants_H;->WIDTH:I
    sget v6, Lmain/Constants_H;->HEIGHT:I
    const/16 v7, 40
    move-object v3, p0
    move v8, v2
    invoke-virtual/range { v3 .. v8 }, Ldm/Ui;->drawUi(IIIII)V
  :L1
  .line 615
    return-void
.end method

.method public drawYesNo__(ZZ)V
  .parameter "a" # Z
  .parameter "b" # Z
  .registers 13
  .prologue
    const/4 v2, 0
  .line 617
    sget v6, Lmain/Constants_H;->WIDTH__:I
  .local v6, "WIDTH":I
    sget v3, Lmain/Constants_H;->HEIGHT__:I
  .line 618
  .local v3, "HEIGHT":I
    if-eqz p1, :L0
    const/16 v1, 27
    const/16 v4, 36
    move-object v0, p0
    move v5, v2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  :L0
  .line 619
    if-eqz p2, :L1
    const/16 v5, 28
    const/16 v8, 40
    move-object v4, p0
    move v7, v3
    move v9, v2
    invoke-virtual/range { v4 .. v9 }, Ldm/Ui;->drawUi(IIIII)V
  :L1
  .line 620
    return-void
.end method

.method public fillArc(IIIIIII)V
  .parameter "c" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .parameter "a0" # I
  .parameter "a1" # I
  .registers 15
  .prologue
  .line 185
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 186
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    move v1, p2
    move v2, p3
    move v3, p4
    move v4, p5
    move v5, p6
    move v6, p7
    invoke-virtual/range { v0 .. v6 }, Ljavax/microedition/lcdui/Graphics;->fillArc(IIIIII)V
  .line 187
    return-void
.end method

.method public fillRect(IIIII)V
  .parameter "c" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 7
  .prologue
  .line 173
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 174
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p2, p3, p4, p5 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
  .line 175
    return-void
.end method

.method public fillRectB()V
  .registers 7
  .prologue
    const/4 v2, 0
  .line 574
    const/16 v4, 640
  .local v4, "WIDTH":I
    const/16 v5, 360
  .line 575
  .local v5, "HEIGHT":I
    const v1, 5422575
    move-object v0, p0
    move v3, v2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->fillRect(IIIII)V
    return-void
.end method

.method public initGraphics(Ljavax/microedition/lcdui/Graphics;)V
  .parameter "_g" # Ljavax/microedition/lcdui/Graphics;
  .registers 3
  .prologue
  .line 29
    sput-object p1, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;
  .line 30
    invoke-static { p1 }, Lcom/nokia/mid/ui/DirectUtils;->getDirectGraphics(Ljavax/microedition/lcdui/Graphics;)Lcom/nokia/mid/ui/DirectGraphics;
    move-result-object v0
    sput-object v0, Ldm/Ui;->dg:Lcom/nokia/mid/ui/DirectGraphics;
  .line 31
    return-void
.end method

.method public initUiModules()V
  .registers 6
  .prologue
    const/4 v4, 0
  .line 286
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    const-string v1, "data/ui"
    invoke-virtual { v0, v1 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v0
    iput-object v0, p0, Ldm/Ui;->ui_img:Ljavax/microedition/lcdui/Image;
  .line 287
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    sput v4, Ldm/Ms;->skip:I
  .line 288
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const-string v2, "data/ui_m.d"
    const/4 v3, -1
    invoke-virtual { v1, v2, v3 }, Ldm/Ms;->getStream(Ljava/lang/String;I)[B
    move-result-object v1
    invoke-virtual { v0, v1, v4 }, Ldm/Ms;->createShort2Array([BI)[[S
    move-result-object v0
    iput-object v0, p0, Ldm/Ui;->ui_modules:[[S
  .line 289
    return-void
.end method

.method public sliding(IIIIIZ)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "h" # I
  .parameter "now" # I
  .parameter "all" # I
  .parameter "type" # Z
  .registers 15
  .prologue
  .line 507
    const/16 v7, 10
  .line 508
  .local v7, "w":B
    if-nez p6, :L0
    const/4 v0, 2
    sub-int v1, p1, v0
    const/4 v0, 2
    sub-int v2, p2, v0
    add-int/lit8 v3, v7, 4
    add-int/lit8 v4, p3, 4
    const/4 v5, 0
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  :L0
  .line 509
    if-eqz p6, :L6
    const/4 v0, 0
    move v5, v0
  :L1
    move-object v0, p0
    move v1, p1
    move v2, p2
    move v3, v7
    move v4, p3
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  .line 511
    const/16 v4, 11
    if-eqz p6, :L7
    const/4 v0, 3
    move v5, v0
  :L2
    move-object v0, p0
    move v1, p1
    move v2, p2
    move v3, v7
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  .line 512
    add-int v0, p2, p3
    const/16 v1, 11
    sub-int v2, v0, v1
    const/16 v4, 11
    if-eqz p6, :L8
    const/4 v0, 3
    move v5, v0
  :L3
    move-object v0, p0
    move v1, p1
    move v3, v7
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  .line 520
    add-int/lit8 p3, p3, -22
  .line 521
    add-int/lit8 p5, p5, -1
  .line 522
    const/4 v0, 1
    if-ge p5, v0, :L10
  .line 523
    add-int/lit8 v1, p1, 1
    add-int/lit8 v2, p2, 12
    const/4 v0, 2
    sub-int v3, v7, v0
    const/4 v0, 2
    sub-int v4, p3, v0
    if-eqz p6, :L9
    const/4 v0, 3
    move v5, v0
  :L4
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
  :L5
  .line 530
    return-void
  :L6
  .line 509
    const/4 v0, 3
    move v5, v0
    goto :L1
  :L7
  .line 511
    const/4 v0, 0
    move v5, v0
    goto :L2
  :L8
  .line 512
    const/4 v0, 0
    move v5, v0
    goto :L3
  :L9
  .line 523
    const/4 v0, 0
    move v5, v0
    goto :L4
  :L10
  .line 525
    add-int/lit8 v0, p5, 1
    div-int v0, p3, v0
    int-to-byte v4, v0
  .line 526
  .local v4, "kh":B
    const/16 v0, 15
    if-ge v4, v0, :L11
    const/16 v4, 15
  :L11
  .line 527
    const/4 v0, 2
    sub-int v0, p3, v0
    sub-int/2addr v0, v4
    mul-int/2addr v0, p4
    div-int/2addr v0, p5
    int-to-short v6, v0
  .line 528
  .local v6, "k2":S
    add-int/lit8 v1, p1, 1
    add-int/lit8 v0, p2, 12
    add-int v2, v0, v6
    const/4 v0, 2
    sub-int v3, v7, v0
    if-eqz p6, :L13
    const/4 v0, 3
    move v5, v0
  :L12
    move-object v0, p0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK(IIIII)V
    goto :L5
  :L13
    const/4 v0, 0
    move v5, v0
    goto :L12
.end method
