.class public Ldm/Ui;
.super Ljava/lang/Object;
.source "Ui.java"


# static fields
.field public static dg:Lcom/nokia/mid/ui/DirectGraphics;

.field public static g:Ljavax/microedition/lcdui/Graphics;

.field private static final transforms:[S

.field private static uiListener:Ldm/Ui;


# instance fields
.field private MIRROR:[I

.field private MIRROR2:[[B

.field private MIRROR3:[B

.field public cTriangle:B

.field private rz:B

.field private ui_img:Ljavax/microedition/lcdui/Image;

.field private ui_modules:[[S


# direct methods
.method static constructor <clinit>()V
    .registers 7

    .prologue
    const/4 v6, 0x5

    const/4 v5, 0x4

    const/4 v4, 0x3

    const/4 v3, 0x2

    const/4 v2, 0x1

    .line 103
    const/16 v0, 0x8

    new-array v0, v0, [S

    aput-short v6, v0, v2

    aput-short v4, v0, v3

    const/4 v1, 0x6

    aput-short v1, v0, v4

    aput-short v3, v0, v5

    aput-short v5, v0, v6

    const/4 v1, 0x6

    aput-short v2, v0, v1

    const/4 v1, 0x7

    const/4 v2, 0x7

    aput-short v2, v0, v1

    sput-object v0, Ldm/Ui;->transforms:[S

    .line 19
    return-void
.end method

.method public constructor <init>()V
    .registers 10

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x0

    const/4 v5, 0x1

    const/4 v4, 0x2

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-array v0, v4, [[B

    const/16 v1, 0x8

    new-array v1, v1, [B

    aput-byte v5, v1, v5

    aput-byte v4, v1, v4

    aput-byte v7, v1, v7

    aput-byte v8, v1, v8

    const/4 v2, 0x5

    const/4 v3, 0x5

    aput-byte v3, v1, v2

    const/4 v2, 0x6

    const/4 v3, 0x6

    aput-byte v3, v1, v2

    const/4 v2, 0x7

    const/4 v3, 0x7

    aput-byte v3, v1, v2

    aput-object v1, v0, v6

    const/16 v1, 0x8

    new-array v1, v1, [B

    aput-byte v8, v1, v6

    const/4 v2, 0x5

    aput-byte v2, v1, v5

    const/4 v2, 0x6

    aput-byte v2, v1, v4

    const/4 v2, 0x7

    aput-byte v2, v1, v7

    const/4 v2, 0x5

    aput-byte v5, v1, v2

    const/4 v2, 0x6

    aput-byte v4, v1, v2

    const/4 v2, 0x7

    aput-byte v7, v1, v2

    aput-object v1, v0, v5

    iput-object v0, p0, Ldm/Ui;->MIRROR2:[[B

    .line 35
    new-array v0, v4, [B

    fill-array-data v0, :array_5a

    iput-object v0, p0, Ldm/Ui;->MIRROR3:[B

    .line 37
    new-array v0, v4, [I

    or-int/lit8 v1, v8, 0x10

    aput v1, v0, v6

    const/16 v1, 0x8

    or-int/lit8 v1, v1, 0x10

    aput v1, v0, v5

    iput-object v0, p0, Ldm/Ui;->MIRROR:[I

    .line 576
    iput-byte v6, p0, Ldm/Ui;->cTriangle:B

    .line 21
    sput-object p0, Ldm/Ui;->uiListener:Ldm/Ui;

    return-void

    .line 35
    :array_5a
    .array-data 1
        0x1t
        -0x1t
    .end array-data
.end method

.method public static i()Ldm/Ui;
    .registers 1

    .prologue
    .line 23
    sget-object v0, Ldm/Ui;->uiListener:Ldm/Ui;

    if-nez v0, :cond_b

    new-instance v0, Ldm/Ui;

    invoke-direct {v0}, Ldm/Ui;-><init>()V

    sput-object v0, Ldm/Ui;->uiListener:Ldm/Ui;

    .line 24
    :cond_b
    sget-object v0, Ldm/Ui;->uiListener:Ldm/Ui;

    return-object v0
.end method


# virtual methods
.method public drawActionOne(Ldm/Sprite;III[BIZ)Z
    .registers 16
    .param p1, "sp"    # Ldm/Sprite;
    .param p2, "a_id"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "now_a"    # [B
    .param p6, "dir"    # I
    .param p7, "mode"    # Z

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 130
    aget-byte v0, p5, v6

    invoke-virtual {p1, p2, v0, v6}, Ldm/Sprite;->action(III)I

    move-result v2

    move-object v0, p0

    move-object v1, p1

    move v3, p3

    move v4, p4

    move v5, p6

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    .line 131
    aget-byte v0, p5, v7

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    aput-byte v0, p5, v7

    aget-byte v1, p5, v6

    invoke-virtual {p1, p2, v1, v7}, Ldm/Sprite;->action(III)I

    move-result v1

    if-le v0, v1, :cond_3c

    .line 132
    aput-byte v6, p5, v7

    .line 133
    aget-byte v0, p5, v6

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    aput-byte v0, p5, v6

    invoke-virtual {p1, p2}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_3c

    .line 134
    if-nez p7, :cond_3a

    .line 135
    invoke-virtual {p1, p2}, Ldm/Sprite;->aLength(I)I

    move-result v0

    sub-int/2addr v0, v7

    int-to-byte v0, v0

    aput-byte v0, p5, v6

    move v0, v7

    .line 141
    :goto_39
    return v0

    .line 138
    :cond_3a
    aput-byte v6, p5, v6

    :cond_3c
    move v0, v6

    .line 141
    goto :goto_39
.end method

.method public drawBDir(IIII)V
    .registers 10
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    .line 300
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const v1, 0x7ecef4

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 301
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    mul-int/lit8 v1, p3, 0x3

    shl-int/lit8 v2, p4, 0x1

    invoke-virtual {v0, p1, p2, v1, v2}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 302
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int v1, p1, p3

    shl-int/lit8 v2, p4, 0x1

    invoke-virtual {v0, v1, p2, p3, v2}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 303
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    int-to-float v1, p1

    add-int v2, p2, p4

    int-to-float v2, v2

    mul-int/lit8 v3, p3, 0x3

    add-int/2addr v3, p1

    int-to-float v3, v3

    add-int v4, p2, p4

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 304
    return-void
.end method

.method public drawBarOne(IIIIII)V
    .registers 15
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "cMin"    # I
    .param p5, "cMax"    # I
    .param p6, "mode"    # I

    .prologue
    const/4 v3, 0x1

    .line 490
    const v6, 0xf60e1c

    .local v6, "c0":I
    const v7, 0xff9f01

    .local v7, "c1":I
    const/4 v5, 0x5

    .line 491
    .local v5, "h":I
    if-ne p6, v3, :cond_3c

    const v6, 0xd8ff

    .line 494
    :cond_d
    :goto_d
    const v1, 0x3e1141    # 5.69999E-39f

    add-int/lit8 v2, p1, 0x1

    sub-int v4, p3, v3

    move-object v0, p0

    move v3, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 495
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p2, 0x1

    const/4 v2, 0x3

    sub-int v2, v5, v2

    invoke-virtual {v0, p1, v1, p3, v2}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 497
    add-int/lit8 v5, v5, -0x2

    .line 498
    add-int/lit8 v2, p1, 0x1

    add-int/lit8 v3, p2, 0x1

    move-object v0, p0

    move v1, v7

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 499
    add-int/lit8 v2, p1, 0x1

    add-int/lit8 v3, p2, 0x1

    if-le p4, p5, :cond_43

    move v4, p5

    :goto_36
    move-object v0, p0

    move v1, v6

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 500
    return-void

    .line 492
    :cond_3c
    const/4 v0, 0x2

    if-ne p6, v0, :cond_d

    const v6, 0xeb11

    goto :goto_d

    :cond_43
    move v4, p4

    .line 499
    goto :goto_36
.end method

.method public drawFrameOne(Ldm/Sprite;IIII)V
    .registers 14
    .param p1, "sp"    # Ldm/Sprite;
    .param p2, "f_id"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "dir"    # I

    .prologue
    .line 120
    const/4 v7, 0x0

    .line 121
    .local v7, "now_frame":S
    :goto_1
    invoke-virtual {p1, p2}, Ldm/Sprite;->fLength(I)I

    move-result v0

    if-lt v7, v0, :cond_8

    .line 128
    return-void

    .line 122
    :cond_8
    const/4 v0, 0x0

    invoke-virtual {p1, p2, v7, v0}, Ldm/Sprite;->frame(III)I

    move-result v2

    .line 123
    const/4 v0, 0x1

    invoke-virtual {p1, p2, v7, v0}, Ldm/Sprite;->frame(III)I

    move-result v0

    iget-object v1, p0, Ldm/Ui;->MIRROR3:[B

    aget-byte v1, v1, p5

    mul-int/2addr v0, v1

    add-int v3, p3, v0

    .line 124
    const/4 v0, 0x2

    invoke-virtual {p1, p2, v7, v0}, Ldm/Sprite;->frame(III)I

    move-result v0

    add-int v4, p4, v0

    .line 125
    const/4 v0, 0x3

    invoke-virtual {p1, p2, v7, v0}, Ldm/Sprite;->frame(III)I

    move-result v6

    move-object v0, p0

    move-object v1, p1

    move v5, p5

    .line 122
    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawModuleOne(Ldm/Sprite;IIIII)V

    .line 126
    add-int/lit8 v0, v7, 0x1

    int-to-short v7, v0

    goto :goto_1
.end method

.method public drawImage(Ljavax/microedition/lcdui/Image;III)V
    .registers 6
    .param p1, "image"    # Ljavax/microedition/lcdui/Image;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "archor"    # I

    .prologue
    .line 166
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1, p2, p3, p4}, Ljavax/microedition/lcdui/Graphics;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 167
    return-void
.end method

.method public drawImage(Ljavax/microedition/lcdui/Image;IIII)V
    .registers 12
    .param p1, "image"    # Ljavax/microedition/lcdui/Image;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "archor"    # I
    .param p5, "trans"    # I

    .prologue
    .line 169
    if-nez p5, :cond_8

    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1, p2, p3, p4}, Ljavax/microedition/lcdui/Graphics;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 171
    :goto_7
    return-void

    .line 170
    :cond_8
    sget-object v0, Ldm/Ui;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/nokia/mid/ui/DirectGraphics;->drawImage(Ljavax/microedition/lcdui/Image;IIII)V

    goto :goto_7
.end method

.method public drawK(IIIII)V
    .registers 10
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "c"    # I

    .prologue
    const/4 v3, 0x2

    .line 329
    if-nez p5, :cond_1e

    const p5, 0xeafcff

    .line 335
    :goto_6
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p5}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 336
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x1

    sub-int v2, p3, v3

    invoke-virtual {v0, v1, p2, v2, p4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 337
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p2, 0x1

    sub-int v2, p4, v3

    invoke-virtual {v0, p1, v1, p3, v2}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 338
    return-void

    .line 330
    :cond_1e
    const/4 v0, 0x1

    if-ne p5, v0, :cond_25

    const p5, 0xbc7afc

    goto :goto_6

    .line 331
    :cond_25
    if-ne p5, v3, :cond_2b

    const p5, 0xbbe2ff

    goto :goto_6

    .line 332
    :cond_2b
    const/4 v0, 0x3

    if-ne p5, v0, :cond_32

    const p5, 0x4fc7ff

    goto :goto_6

    .line 333
    :cond_32
    const/4 v0, 0x4

    if-ne p5, v0, :cond_38

    const/16 p5, 0x78ff

    goto :goto_6

    .line 334
    :cond_38
    const p5, 0xa9b4dc

    goto :goto_6
.end method

.method public drawK0(IIIII)V
    .registers 14
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "c"    # I

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x1

    const/4 v4, 0x2

    .line 344
    int-to-byte v5, p5

    .line 346
    .local v5, "c0":B
    if-ne p5, v4, :cond_31

    const p5, 0xeafcff

    .line 348
    :goto_9
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p5}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 349
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x1

    sub-int v2, p3, v7

    sub-int v3, p4, v6

    invoke-virtual {v0, v1, p2, v2, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 350
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p2, 0x1

    sub-int v2, p3, v6

    sub-int v3, p4, v7

    invoke-virtual {v0, p1, v1, v2, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 351
    add-int/lit8 v1, p1, 0x1

    add-int/lit8 v2, p2, 0x1

    sub-int v3, p3, v4

    sub-int v4, p4, v4

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 352
    return-void

    .line 347
    :cond_31
    const p5, 0x1d1e35

    goto :goto_9
.end method

.method public drawK1(IIIII)V
    .registers 14
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "c"    # I

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x1

    const/4 v5, 0x2

    .line 359
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    if-nez p5, :cond_47

    const v1, 0x535453

    :goto_a
    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 360
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p2, 0x2

    sub-int v2, p4, v7

    invoke-virtual {v0, p1, v1, p3, v2}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 361
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x1

    int-to-float v1, v1

    add-int v2, p2, p4

    int-to-float v2, v2

    add-int v3, p1, p3

    sub-int/2addr v3, v6

    int-to-float v3, v3

    add-int v4, p2, p4

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 362
    if-eqz p5, :cond_2c

    if-ne p5, v6, :cond_4b

    :cond_2c
    const p5, 0xeafcff

    .line 366
    :goto_2f
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p5}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 367
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x1

    sub-int v2, p3, v5

    invoke-virtual {v0, v1, p2, v2, p4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 368
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p2, 0x1

    sub-int v2, p4, v5

    invoke-virtual {v0, p1, v1, p3, v2}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 369
    return-void

    .line 359
    :cond_47
    const v1, 0x1d1e35

    goto :goto_a

    .line 363
    :cond_4b
    if-ne p5, v5, :cond_51

    const p5, 0xd3fbff

    goto :goto_2f

    .line 364
    :cond_51
    if-ne p5, v7, :cond_57

    const p5, 0x75eaff

    goto :goto_2f

    .line 365
    :cond_57
    const p5, 0xbc7afc

    goto :goto_2f
.end method

.method public drawK2(IIIII)V
    .registers 11
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "arc"    # I

    .prologue
    const/4 v4, 0x4

    .line 375
    if-nez p5, :cond_24

    const/4 p5, 0x5

    .line 377
    :goto_4
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 379
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1, p2, p3, p4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 380
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v1, 0x78ff

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 382
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x2

    add-int/lit8 v2, p2, 0x2

    sub-int v3, p3, v4

    sub-int v4, p4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 383
    return-void

    .line 376
    :cond_24
    const/16 p5, 0x14

    goto :goto_4
.end method

.method public drawK3(IIII)V
    .registers 12
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    const/4 v6, 0x2

    const/4 v0, 0x1

    .line 385
    sub-int v3, p3, v0

    sub-int v4, p4, v0

    const/4 v5, 0x0

    move-object v0, p0

    move v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK0(IIIII)V

    .line 386
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const v1, 0x1d1e35

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 387
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x2

    add-int/lit8 v2, p2, 0x2

    sub-int v3, p3, v6

    sub-int v4, p4, v6

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 388
    return-void
.end method

.method public drawK4(IIII)V
    .registers 12
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x2

    .line 390
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const v1, 0xffe92d

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 391
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x1

    int-to-float v1, v1

    int-to-float v2, p2

    add-int v3, p1, p3

    sub-int/2addr v3, v5

    int-to-float v3, v3

    int-to-float v4, p2

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 392
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x1

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

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 393
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    int-to-float v1, p1

    add-int/lit8 v2, p2, 0x1

    int-to-float v2, v2

    int-to-float v3, p1

    add-int v4, p2, p4

    sub-int/2addr v4, v5

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 394
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int v1, p1, p3

    sub-int/2addr v1, v6

    int-to-float v1, v1

    add-int/lit8 v2, p2, 0x1

    int-to-float v2, v2

    add-int v3, p1, p3

    sub-int/2addr v3, v6

    int-to-float v3, v3

    add-int v4, p2, p4

    sub-int/2addr v4, v5

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 396
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    int-to-float v1, p1

    add-int/lit8 v2, p2, 0x1

    int-to-float v2, v2

    add-int/lit8 v3, p1, 0x1

    int-to-float v3, v3

    add-int/lit8 v4, p2, 0x1

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 397
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int v1, p1, p3

    sub-int/2addr v1, v5

    int-to-float v1, v1

    add-int/lit8 v2, p2, 0x1

    int-to-float v2, v2

    add-int v3, p1, p3

    sub-int/2addr v3, v6

    int-to-float v3, v3

    add-int/lit8 v4, p2, 0x1

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 398
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    int-to-float v1, p1

    add-int v2, p2, p4

    sub-int/2addr v2, v5

    int-to-float v2, v2

    add-int/lit8 v3, p1, 0x1

    int-to-float v3, v3

    add-int v4, p2, p4

    sub-int/2addr v4, v5

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

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

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 400
    return-void
.end method

.method public drawKuang(IIII)V
    .registers 13
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    const/4 v4, 0x4

    const/4 v7, 0x1

    const/4 v6, 0x3

    const/4 v5, 0x2

    .line 409
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const v1, 0x1d1e35

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 410
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x1

    sub-int v2, p3, v4

    sub-int v3, p4, v5

    invoke-virtual {v0, v1, p2, v2, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 411
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x2

    add-int/lit8 v2, p2, 0x1

    sub-int v3, p3, v4

    sub-int v4, p4, v5

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 412
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    int-to-float v1, p1

    add-int/lit8 v2, p2, 0x1

    int-to-float v2, v2

    int-to-float v3, p1

    add-int v4, p2, p4

    sub-int/2addr v4, v6

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 413
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int v1, p1, p3

    sub-int/2addr v1, v7

    int-to-float v1, v1

    add-int/lit8 v2, p2, 0x2

    int-to-float v2, v2

    add-int v3, p1, p3

    sub-int/2addr v3, v7

    int-to-float v3, v3

    add-int v4, p2, p4

    sub-int/2addr v4, v5

    int-to-float v4, v4

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 414
    const v1, 0xeafcff

    add-int/lit8 v2, p1, 0x1

    add-int/lit8 v3, p2, 0x1

    sub-int v4, p3, v6

    sub-int v5, p4, v6

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 415
    return-void
.end method

.method public drawKuangAdorn(IIIII)V
    .registers 16
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "mode"    # I

    .prologue
    const/16 v5, 0x16

    const/4 v9, 0x1

    const/4 v8, 0x0

    const/16 v7, 0x19

    const/16 v6, 0xb

    .line 442
    if-nez p5, :cond_58

    .line 443
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const v1, 0x1c1d34

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 444
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x14

    sub-int v2, p2, v5

    const/16 v3, 0x15

    sub-int v3, p3, v3

    const/16 v4, 0x14

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 445
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x14

    sub-int v2, p2, v5

    sub-int v3, p3, v5

    const/16 v4, 0x15

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 446
    const v1, 0xe6dc90

    add-int/lit8 v2, p1, 0x14

    sub-int v3, p2, v5

    sub-int v4, p3, v5

    const/16 v5, 0x14

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 447
    const/16 v1, 0x21

    const/16 v4, 0x24

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v5, v8

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 448
    const/16 v1, 0x1f

    add-int v0, p1, p3

    const/4 v2, 0x4

    sub-int v2, v0, v2

    const/16 v4, 0x24

    move-object v0, p0

    move v3, p2

    move v5, v8

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 472
    :cond_57
    :goto_57
    return-void

    .line 449
    :cond_58
    if-ne p5, v9, :cond_f4

    .line 450
    const/16 v1, 0x20

    const/4 v0, 0x7

    sub-int v3, p2, v0

    move-object v0, p0

    move v2, p1

    move v4, v8

    move v5, v8

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 451
    const/16 v1, 0x20

    add-int v0, p1, p3

    add-int/lit8 v2, v0, 0x5

    const/4 v0, 0x7

    sub-int v3, p2, v0

    const/16 v0, 0x8

    or-int/lit8 v4, v0, 0x10

    move-object v0, p0

    move v5, v8

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 452
    const v1, 0xcec36d

    add-int/lit8 v2, p1, 0xf

    const/4 v0, 0x5

    sub-int v3, p2, v0

    sub-int v4, p3, v7

    const/16 v5, 0xd

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 453
    const v1, 0xf5ea9f

    add-int/lit8 v2, p1, 0xf

    const/4 v0, 0x3

    sub-int v3, p2, v0

    sub-int v4, p3, v7

    const/16 v5, 0xa

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 454
    const v1, 0xc78f36

    add-int/lit8 v2, p1, 0xf

    add-int/lit8 v3, p2, 0xa

    sub-int v4, p3, v7

    const/4 v5, 0x5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 455
    const v1, 0x1c1d34

    add-int/lit8 v2, p1, 0xf

    const/4 v0, 0x7

    sub-int v3, p2, v0

    add-int v0, p1, p3

    sub-int v4, v0, v6

    const/4 v0, 0x7

    sub-int v5, p2, v0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 456
    const v1, 0xfaf3c3

    add-int/lit8 v2, p1, 0xf

    const/4 v0, 0x6

    sub-int v3, p2, v0

    add-int v0, p1, p3

    sub-int v4, v0, v6

    const/4 v0, 0x6

    sub-int v5, p2, v0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 457
    const v1, 0x5e2103

    add-int/lit8 v2, p1, 0xf

    add-int/lit8 v3, p2, 0xc

    add-int v0, p1, p3

    sub-int v4, v0, v6

    add-int/lit8 v5, p2, 0xc

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 458
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const v1, 0xcaa856

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 459
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0xf

    add-int/lit8 v2, p2, 0x8

    const/16 v3, 0x1a

    sub-int v3, p3, v3

    invoke-virtual {v0, v1, v2, v3, v9}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    goto/16 :goto_57

    .line 460
    :cond_f4
    const/4 v0, 0x2

    if-ne p5, v0, :cond_57

    .line 461
    const/16 v1, 0x20

    add-int v0, p2, p4

    sub-int v3, v0, v9

    const/16 v4, 0x24

    const/4 v5, 0x6

    move-object v0, p0

    move v2, p1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 462
    const/16 v1, 0x20

    add-int v0, p1, p3

    add-int/lit8 v2, v0, 0x5

    add-int v0, p2, p4

    sub-int v3, v0, v9

    const/16 v4, 0x28

    const/4 v5, 0x6

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 463
    const v1, 0xcec36d

    add-int/lit8 v2, p1, 0xf

    add-int v0, p2, p4

    const/16 v3, 0x10

    sub-int v3, v0, v3

    sub-int v4, p3, v7

    const/16 v5, 0xd

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 464
    const v1, 0xf5ea9f

    add-int/lit8 v2, p1, 0xf

    add-int v0, p2, p4

    const/16 v3, 0xf

    sub-int v3, v0, v3

    sub-int v4, p3, v7

    const/16 v5, 0xa

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 465
    const v1, 0xc78f36

    add-int/lit8 v2, p1, 0xf

    add-int v0, p2, p4

    const/16 v3, 0x17

    sub-int v3, v0, v3

    sub-int v4, p3, v7

    const/4 v5, 0x5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 466
    const v1, 0x1c1d34

    add-int/lit8 v2, p1, 0xf

    add-int v0, p2, p4

    const/4 v3, 0x2

    sub-int v3, v0, v3

    add-int v0, p1, p3

    sub-int v4, v0, v6

    add-int v0, p2, p4

    const/4 v5, 0x2

    sub-int v5, v0, v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 467
    const v1, 0xfaf3c3

    add-int/lit8 v2, p1, 0xf

    add-int v0, p2, p4

    const/4 v3, 0x3

    sub-int v3, v0, v3

    add-int v0, p1, p3

    sub-int v4, v0, v6

    add-int v0, p2, p4

    const/4 v5, 0x3

    sub-int v5, v0, v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 468
    const v1, 0x5e2103

    add-int/lit8 v2, p1, 0xf

    add-int v0, p2, p4

    const/16 v3, 0x15

    sub-int v3, v0, v3

    add-int v0, p1, p3

    sub-int v4, v0, v6

    add-int v0, p2, p4

    const/16 v5, 0x15

    sub-int v5, v0, v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 469
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    const v1, 0xcaa856

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 470
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0xf

    add-int v2, p2, p4

    const/16 v3, 0x12

    sub-int/2addr v2, v3

    const/16 v3, 0x1a

    sub-int v3, p3, v3

    invoke-virtual {v0, v1, v2, v3, v9}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    goto/16 :goto_57
.end method

.method public drawKuangMap(IIIIZ)V
    .registers 13
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "mode"    # Z

    .prologue
    const/4 v6, 0x2

    .line 433
    if-eqz p5, :cond_21

    const/16 v0, 0x3a71

    move v1, v0

    :goto_6
    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 434
    if-eqz p5, :cond_26

    const v0, 0x6699ff

    move v1, v0

    :goto_14
    add-int/lit8 v2, p1, 0x1

    add-int/lit8 v3, p2, 0x1

    sub-int v4, p3, v6

    sub-int v5, p4, v6

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 435
    return-void

    .line 433
    :cond_21
    const v0, 0xffc500

    move v1, v0

    goto :goto_6

    .line 434
    :cond_26
    const v0, 0xad7e34

    move v1, v0

    goto :goto_14
.end method

.method public drawKuangSelect(IIIII)V
    .registers 12
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I
    .param p5, "mode"    # I

    .prologue
    const/4 v5, 0x3

    const/4 v3, 0x2

    const/4 v4, 0x1

    .line 422
    const v0, 0xcaa856

    .line 423
    .local v0, "color":I
    if-ne p5, v4, :cond_25

    const v0, 0xad7e34

    .line 428
    :cond_b
    :goto_b
    sget-object v1, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v1, v0}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 429
    sget-object v1, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v2, p1, 0x1

    sub-int v3, p3, v3

    invoke-virtual {v1, v2, p2, v3, p4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 430
    sget-object v1, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v2, p2, 0x1

    sub-int v3, p3, v4

    sub-int v4, p4, v5

    invoke-virtual {v1, p1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 431
    return-void

    .line 424
    :cond_25
    if-ne p5, v3, :cond_2b

    const v0, 0x221300

    goto :goto_b

    .line 425
    :cond_2b
    if-ne p5, v5, :cond_31

    const v0, 0xe6dc90

    goto :goto_b

    .line 426
    :cond_31
    const/4 v1, 0x4

    if-ne p5, v1, :cond_38

    const v0, 0xffc500

    goto :goto_b

    .line 427
    :cond_38
    const/4 v1, 0x5

    if-ne p5, v1, :cond_b

    const v0, 0x5e2103

    goto :goto_b
.end method

.method public drawLine(IIIII)V
    .registers 11
    .param p1, "c"    # I
    .param p2, "x0"    # I
    .param p3, "y0"    # I
    .param p4, "x1"    # I
    .param p5, "y1"    # I

    .prologue
    .line 177
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 178
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    int-to-float v1, p2

    int-to-float v2, p3

    int-to-float v3, p4

    int-to-float v4, p5

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawLine(FFFF)V

    .line 179
    return-void
.end method

.method public drawListKY(IIIIIIIIII)V
    .registers 18
    .param p1, "length"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "kw"    # I
    .param p6, "kh"    # I
    .param p7, "dis"    # I
    .param p8, "sel"    # I
    .param p9, "c0"    # I
    .param p10, "c1"    # I

    .prologue
    .line 692
    const/4 v6, 0x0

    .local v6, "d":B
    :goto_1
    if-lt v6, p1, :cond_15

    .line 694
    const/4 v0, -0x1

    if-eq p8, v0, :cond_14

    add-int v0, p6, p7

    mul-int/2addr v0, p8

    add-int v2, p3, v0

    move-object v0, p0

    move v1, p2

    move v3, p4

    move v4, p6

    move/from16 v5, p9

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 695
    :cond_14
    return-void

    .line 693
    :cond_15
    if-eq v6, p8, :cond_29

    add-int v1, p2, p5

    add-int v0, p6, p7

    mul-int/2addr v0, v6

    add-int v2, p3, v0

    shl-int/lit8 v0, p5, 0x1

    sub-int v3, p4, v0

    move-object v0, p0

    move v4, p6

    move/from16 v5, p10

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK0(IIIII)V

    .line 692
    :cond_29
    add-int/lit8 v0, v6, 0x1

    int-to-byte v6, v0

    goto :goto_1
.end method

.method public drawListSY([Ljava/lang/Object;IIIIIIII)V
    .registers 18
    .param p1, "menu"    # [Ljava/lang/Object;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "sh"    # I
    .param p6, "sel"    # I
    .param p7, "c0"    # I
    .param p8, "c1"    # I
    .param p9, "strT"    # I

    .prologue
    .line 687
    const/4 v7, 0x0

    .local v7, "d":B
    :goto_1
    array-length v0, p1

    if-lt v7, v0, :cond_c

    .line 689
    const-string v0, "sk"

    const-string v1, "drawListSY"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 690
    return-void

    .line 688
    :cond_c
    aget-object v0, p1, v7

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    shr-int/lit8 v0, p4, 0x1

    add-int v2, p2, v0

    add-int/lit8 v0, p3, 0x2

    mul-int v3, v7, p5

    add-int/2addr v3, v0

    const/16 v4, 0x11

    if-ne v7, p6, :cond_2a

    move v5, p7

    :goto_20
    move-object v0, p0

    move/from16 v6, p9

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 687
    add-int/lit8 v0, v7, 0x1

    int-to-byte v7, v0

    goto :goto_1

    :cond_2a
    move/from16 v5, p8

    .line 688
    goto :goto_20
.end method

.method public drawListSYHasSound([Ljava/lang/Object;IIIIIIII)V
    .registers 18
    .param p1, "menu"    # [Ljava/lang/Object;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "sh"    # I
    .param p6, "sel"    # I
    .param p7, "c0"    # I
    .param p8, "c1"    # I
    .param p9, "strT"    # I

    .prologue
    .line 702
    const/4 v7, 0x0

    .local v7, "d":B
    :goto_1
    array-length v0, p1

    if-lt v7, v0, :cond_5

    .line 705
    return-void

    .line 703
    :cond_5
    aget-object v0, p1, v7

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    shr-int/lit8 v0, p4, 0x1

    add-int v2, p2, v0

    add-int/lit8 v0, p3, 0x2

    mul-int v3, v7, p5

    add-int/2addr v3, v0

    aget-object v0, p1, v7

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v4, "\u58f0\u97f3"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_32

    const/16 v0, 0x14

    move v4, v0

    :goto_25
    if-ne v7, p6, :cond_36

    move v5, p7

    :goto_28
    move-object v0, p0

    move/from16 v6, p9

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 702
    add-int/lit8 v0, v7, 0x1

    int-to-byte v7, v0

    goto :goto_1

    .line 703
    :cond_32
    const/16 v0, 0x11

    move v4, v0

    goto :goto_25

    :cond_36
    move/from16 v5, p8

    goto :goto_28
.end method

.method public drawModuleOne(Ldm/Sprite;IIIII)V
    .registers 18
    .param p1, "sp"    # Ldm/Sprite;
    .param p2, "m_id"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "dir"    # I
    .param p6, "manipulation"    # I

    .prologue
    .line 115
    iget-object v1, p1, Ldm/Sprite;->img:Ljavax/microedition/lcdui/Image;

    const/4 v0, 0x0

    invoke-virtual {p1, p2, v0}, Ldm/Sprite;->module(II)I

    move-result v2

    const/4 v0, 0x1

    invoke-virtual {p1, p2, v0}, Ldm/Sprite;->module(II)I

    move-result v3

    const/4 v0, 0x2

    invoke-virtual {p1, p2, v0}, Ldm/Sprite;->module(II)I

    move-result v4

    const/4 v0, 0x3

    invoke-virtual {p1, p2, v0}, Ldm/Sprite;->module(II)I

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
    invoke-virtual/range {v0 .. v10}, Ldm/Ui;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIIILjavax/microedition/lcdui/Graphics;)V

    .line 118
    return-void
.end method

.method public drawNum(Ljava/lang/String;IIII)V
    .registers 21
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "anchor"    # I
    .param p5, "type"    # I

    .prologue
    .line 533
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_7

    .line 566
    :goto_6
    return-void

    .line 534
    :cond_7
    if-nez p4, :cond_4b

    const/4 v2, 0x0

    :goto_a
    int-to-byte v12, v2

    .line 535
    .local v12, "i":B
    const/4 v13, 0x0

    .line 538
    .local v13, "sw":S
    :cond_c
    if-nez p5, :cond_52

    const/16 v14, 0x8

    .line 541
    .local v14, "w":B
    :goto_10
    const/4 v3, -0x1

    .line 542
    .local v3, "bid":B
    move-object/from16 v0, p1

    move v1, v12

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v11

    .line 543
    .local v11, "cr":C
    const/16 v2, 0x30

    if-lt v11, v2, :cond_6c

    const/16 v2, 0x39

    if-gt v11, v2, :cond_6c

    .line 544
    const/16 v2, 0x30

    sub-int v2, v11, v2

    int-to-byte v3, v2

    .line 545
    if-nez p5, :cond_5e

    add-int/lit8 v2, v3, 0xa

    int-to-byte v3, v2

    .line 554
    :cond_2a
    :goto_2a
    const/4 v2, -0x1

    if-eq v3, v2, :cond_a9

    .line 555
    if-nez p4, :cond_9d

    add-int v4, p2, v13

    const/16 v6, 0x24

    const/4 v7, 0x0

    move-object v2, p0

    move/from16 v5, p3

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawUi(IIIII)V

    .line 557
    :goto_3a
    add-int v2, v13, v14

    int-to-short v13, v2

    .line 563
    :goto_3d
    if-nez p4, :cond_e3

    add-int/lit8 v2, v12, 0x1

    int-to-byte v12, v2

    .line 565
    :goto_42
    if-nez p4, :cond_e9

    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v2

    if-lt v12, v2, :cond_c

    goto :goto_6

    .line 534
    .end local v3    # "bid":B
    .end local v11    # "cr":C
    .end local v12    # "i":B
    .end local v13    # "sw":S
    .end local v14    # "w":B
    :cond_4b
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v2

    const/4 v3, 0x1

    sub-int/2addr v2, v3

    goto :goto_a

    .line 539
    .restart local v12    # "i":B
    .restart local v13    # "sw":S
    :cond_52
    const/4 v2, 0x1

    move/from16 v0, p5

    move v1, v2

    if-ne v0, v1, :cond_5b

    const/16 v14, 0xa

    .restart local v14    # "w":B
    goto :goto_10

    .line 540
    .end local v14    # "w":B
    :cond_5b
    const/16 v14, 0xe

    .restart local v14    # "w":B
    goto :goto_10

    .line 546
    .restart local v3    # "bid":B
    .restart local v11    # "cr":C
    :cond_5e
    const/4 v2, 0x1

    move/from16 v0, p5

    move v1, v2

    if-ne v0, v1, :cond_68

    add-int/lit8 v2, v3, 0x23

    int-to-byte v3, v2

    goto :goto_2a

    .line 547
    :cond_68
    add-int/lit8 v2, v3, 0x39

    int-to-byte v3, v2

    goto :goto_2a

    .line 548
    :cond_6c
    const/16 v2, 0x2f

    if-ne v11, v2, :cond_73

    const/16 v3, 0x14

    goto :goto_2a

    .line 549
    :cond_73
    const/16 v2, 0x2d

    if-ne v11, v2, :cond_84

    const/4 v2, 0x2

    move/from16 v0, p5

    move v1, v2

    if-ne v0, v1, :cond_81

    const/16 v2, 0x38

    :goto_7f
    int-to-byte v3, v2

    goto :goto_2a

    :cond_81
    const/16 v2, 0x2e

    goto :goto_7f

    .line 550
    :cond_84
    const/16 v2, 0x2b

    if-ne v11, v2, :cond_8b

    const/16 v3, 0x2f

    goto :goto_2a

    .line 551
    :cond_8b
    const/16 v2, 0x25

    if-ne v11, v2, :cond_94

    const/16 v3, 0x2d

    const/16 v14, 0xe

    goto :goto_2a

    .line 552
    :cond_94
    const/16 v2, 0x7ea7

    if-ne v11, v2, :cond_2a

    const/16 v3, 0x1d

    const/16 v14, 0xc

    goto :goto_2a

    .line 556
    :cond_9d
    sub-int v4, p2, v13

    const/16 v6, 0x28

    const/4 v7, 0x0

    move-object v2, p0

    move/from16 v5, p3

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawUi(IIIII)V

    goto :goto_3a

    .line 559
    :cond_a9
    if-nez p4, :cond_c9

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    add-int v6, p2, v13

    add-int/lit8 v7, p3, 0x5

    const/16 v8, 0x24

    const/4 v9, 0x3

    const/4 v10, 0x0

    move-object v4, p0

    invoke-virtual/range {v4 .. v10}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 561
    :goto_c4
    add-int/lit8 v2, v13, 0x19

    int-to-short v13, v2

    goto/16 :goto_3d

    .line 560
    :cond_c9
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    sub-int v6, p2, v13

    add-int/lit8 v7, p3, 0x5

    const/16 v8, 0x28

    const/4 v9, 0x3

    const/4 v10, 0x0

    move-object v4, p0

    invoke-virtual/range {v4 .. v10}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto :goto_c4

    .line 564
    :cond_e3
    const/4 v2, 0x1

    sub-int v2, v12, v2

    int-to-byte v12, v2

    goto/16 :goto_42

    .line 565
    :cond_e9
    const/4 v2, -0x1

    if-gt v12, v2, :cond_c

    goto/16 :goto_6
.end method

.method public drawRect(IIIII)V
    .registers 7
    .param p1, "c"    # I
    .param p2, "x0"    # I
    .param p3, "y0"    # I
    .param p4, "w"    # I
    .param p5, "h"    # I

    .prologue
    .line 181
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 182
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p2, p3, p4, p5}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 183
    return-void
.end method

.method public drawRectZ(IIIIII)V
    .registers 12
    .param p1, "color"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "h"    # I
    .param p6, "s"    # I

    .prologue
    .line 569
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 570
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v1, p0, Ldm/Ui;->rz:B

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v1

    sub-int v1, p2, v1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v2, p0, Ldm/Ui;->rz:B

    invoke-static {v2}, Ldm/Ms;->abs(I)I

    move-result v2

    sub-int v2, p3, v2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v3, p0, Ldm/Ui;->rz:B

    invoke-static {v3}, Ldm/Ms;->abs(I)I

    move-result v3

    shl-int/lit8 v3, v3, 0x1

    add-int/2addr v3, p4

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v4, p0, Ldm/Ui;->rz:B

    invoke-static {v4}, Ldm/Ms;->abs(I)I

    move-result v4

    shl-int/lit8 v4, v4, 0x1

    add-int/2addr v4, p5

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 571
    iget-byte v0, p0, Ldm/Ui;->rz:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Ldm/Ui;->rz:B

    if-le v0, p6, :cond_45

    neg-int v0, p6

    int-to-byte v0, v0

    iput-byte v0, p0, Ldm/Ui;->rz:B

    .line 572
    :cond_45
    return-void
.end method

.method public drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIIILjavax/microedition/lcdui/Graphics;)V
    .registers 21
    .param p1, "image"    # Ljavax/microedition/lcdui/Image;
    .param p2, "mx"    # I
    .param p3, "my"    # I
    .param p4, "mw"    # I
    .param p5, "mh"    # I
    .param p6, "realX"    # I
    .param p7, "realY"    # I
    .param p8, "anchor"    # I
    .param p9, "manipulation"    # I
    .param p10, "g"    # Ljavax/microedition/lcdui/Graphics;

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

    invoke-virtual/range {v0 .. v9}, Ljavax/microedition/lcdui/Graphics;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIII)V

    .line 107
    return-void
.end method

.method public drawString(Ljava/lang/String;IIIII)V
    .registers 13
    .param p1, "str_hit"    # Ljava/lang/String;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "anchor"    # I
    .param p5, "color"    # I
    .param p6, "mode"    # I

    .prologue
    const/4 v5, 0x1

    .line 195
    const v0, 0xcaa856

    .line 196
    .local v0, "c0":I
    const v1, 0x381808

    .line 197
    .local v1, "c1":I
    add-int/lit8 p3, p3, 0x1

    .line 198
    packed-switch p5, :pswitch_data_b8

    .line 245
    :goto_c
    const/4 v2, 0x2

    if-ne p6, v2, :cond_54

    .line 246
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v2, v0}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 247
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v3, p2, v5

    invoke-virtual {v2, p1, v3, p3, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 248
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v3, p2, 0x1

    invoke-virtual {v2, p1, v3, p3, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 249
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v3, p3, v5

    invoke-virtual {v2, p1, p2, v3, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 250
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v3, p3, 0x1

    invoke-virtual {v2, p1, p2, v3, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 251
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v3, p2, 0x1

    add-int/lit8 v4, p3, 0x1

    invoke-virtual {v2, p1, v3, v4, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 252
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v3, p2, v5

    add-int/lit8 v4, p3, 0x1

    invoke-virtual {v2, p1, v3, v4, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 253
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v3, p2, v5

    sub-int v4, p3, v5

    invoke-virtual {v2, p1, v3, v4, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 254
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v3, p2, 0x1

    sub-int v4, p3, v5

    invoke-virtual {v2, p1, v3, v4, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 256
    :cond_54
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v2, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 257
    if-ne p6, v5, :cond_62

    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v3, p2, 0x1

    invoke-virtual {v2, p1, v3, p3, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 258
    :cond_62
    sget-object v2, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v2, p1, p2, p3, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 259
    return-void

    .line 200
    :pswitch_68
    const/4 v0, 0x0

    .line 202
    const v1, 0xffffff

    .line 203
    goto :goto_c

    .line 205
    :pswitch_6d
    const v0, 0x535453

    .line 206
    const v1, 0x75eaff

    .line 207
    goto :goto_c

    .line 209
    :pswitch_74
    const v0, 0x2951d8

    .line 210
    const v1, 0xa808

    .line 211
    goto :goto_c

    .line 213
    :pswitch_7b
    const v0, 0x1d1e35

    .line 214
    const/16 v1, 0x5ee7

    .line 215
    goto :goto_c

    .line 217
    :pswitch_81
    const v0, 0x140e03

    .line 218
    const v1, 0x4fc7ff

    .line 219
    goto :goto_c

    .line 221
    :pswitch_88
    const v0, 0x221503

    .line 222
    const v1, 0xff6c00

    .line 223
    goto/16 :goto_c

    .line 225
    :pswitch_90
    const v0, 0x7b3939

    .line 226
    const v1, 0xf70808

    .line 227
    goto/16 :goto_c

    .line 229
    :pswitch_98
    const v0, 0x442b01

    .line 230
    const v1, 0xffb400

    .line 231
    goto/16 :goto_c

    .line 233
    :pswitch_a0
    const v0, 0x9a7604

    .line 234
    const v1, 0xc000ff

    .line 235
    goto/16 :goto_c

    .line 237
    :pswitch_a8
    const v0, 0xb07038

    .line 238
    const v1, 0x381808

    .line 239
    goto/16 :goto_c

    .line 241
    :pswitch_b0
    const v0, 0x140225

    .line 242
    const v1, 0x868686

    goto/16 :goto_c

    .line 198
    :pswitch_data_b8
    .packed-switch 0x0
        :pswitch_68
        :pswitch_6d
        :pswitch_74
        :pswitch_7b
        :pswitch_81
        :pswitch_88
        :pswitch_90
        :pswitch_98
        :pswitch_a0
        :pswitch_a8
        :pswitch_b0
    .end packed-switch
.end method

.method public drawStringColor(Ljava/lang/String;IIII)V
    .registers 25
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "color"    # I
    .param p5, "mode"    # I

    .prologue
    .line 261
    move/from16 v0, p4

    int-to-byte v0, v0

    move v8, v0

    .local v8, "c":B
    const/16 v17, 0x0

    .line 262
    .local v17, "start":B
    const/16 v18, 0x0

    .line 265
    .local v18, "tw":S
    :cond_8
    const-string v3, "#"

    move-object/from16 v0, p1

    move-object v1, v3

    move/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v3

    move v0, v3

    int-to-byte v0, v0

    move/from16 v16, v0

    .line 266
    .local v16, "end":B
    const/4 v3, -0x1

    move/from16 v0, v16

    move v1, v3

    if-eq v0, v1, :cond_68

    .line 267
    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v16

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 268
    .local v4, "ssub":Ljava/lang/String;
    add-int v5, p2, v18

    const/4 v7, 0x0

    move-object/from16 v3, p0

    move/from16 v6, p3

    move/from16 v9, p5

    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 269
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3, v4}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v3

    add-int v3, v3, v18

    move v0, v3

    int-to-short v0, v0

    move/from16 v18, v0

    .line 270
    add-int/lit8 v3, v16, 0x1

    add-int/lit8 v4, v16, 0x2

    move-object/from16 v0, p1

    move v1, v3

    move v2, v4

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .end local v4    # "ssub":Ljava/lang/String;
    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    const/4 v4, 0x1

    sub-int/2addr v3, v4

    int-to-byte v8, v3

    .line 271
    add-int/lit8 v3, v16, 0x2

    move v0, v3

    int-to-byte v0, v0

    move/from16 v17, v0

    .line 272
    const/4 v3, -0x1

    if-ne v8, v3, :cond_61

    move/from16 v0, p4

    int-to-byte v0, v0

    move v8, v0

    .line 276
    :cond_61
    :goto_61
    const/4 v3, -0x1

    move/from16 v0, v16

    move v1, v3

    if-ne v0, v1, :cond_8

    .line 277
    return-void

    .line 274
    :cond_68
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v3

    move-object/from16 v0, p1

    move/from16 v1, v17

    move v2, v3

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    add-int v11, p2, v18

    const/4 v13, 0x0

    move-object/from16 v9, p0

    move/from16 v12, p3

    move v14, v8

    move/from16 v15, p5

    invoke-virtual/range {v9 .. v15}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto :goto_61
.end method

.method public drawStringY([Ljava/lang/Object;IIIIIII)V
    .registers 17
    .param p1, "str"    # [Ljava/lang/Object;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "start"    # I
    .param p5, "end"    # I
    .param p6, "sh"    # I
    .param p7, "c"    # I
    .param p8, "strT"    # I

    .prologue
    .line 697
    int-to-byte v7, p4

    .local v7, "i":B
    :goto_1
    if-ge v7, p5, :cond_6

    array-length v0, p1

    if-lt v7, v0, :cond_7

    .line 699
    :cond_6
    return-void

    .line 698
    :cond_7
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    aget-object v1, p1, v7

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    sub-int v2, v7, p4

    mul-int/2addr v2, p6

    add-int v3, p3, v2

    const/4 v4, 0x0

    move v2, p2

    move v5, p7

    move/from16 v6, p8

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 697
    add-int/lit8 v0, v7, 0x1

    int-to-byte v7, v0

    goto :goto_1
.end method

.method public drawStringY([Ljava/lang/StringBuffer;IIIII)V
    .registers 14
    .param p1, "showS"    # [Ljava/lang/StringBuffer;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "fh"    # I
    .param p5, "color"    # I
    .param p6, "mode"    # I

    .prologue
    .line 279
    const/4 v6, 0x0

    .local v6, "d":B
    :goto_1
    array-length v0, p1

    if-lt v6, v0, :cond_5

    .line 281
    return-void

    .line 280
    :cond_5
    aget-object v0, p1, v6

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    add-int/lit8 v0, p3, 0x4

    mul-int v2, v6, p4

    add-int v3, v0, v2

    move-object v0, p0

    move v2, p2

    move v4, p5

    move v5, p6

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V

    .line 279
    add-int/lit8 v0, v6, 0x1

    int-to-byte v6, v0

    goto :goto_1
.end method

.method public drawTriangle(IIIZZ)V
    .registers 6
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "dir"    # Z
    .param p5, "ct"    # Z

    .prologue
    .line 602
    return-void
.end method

.method public drawTriangle1(IIIZZ)V
    .registers 12
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "dir"    # Z
    .param p5, "ct"    # Z

    .prologue
    .line 603
    const/16 v1, 0x1e

    sub-int v0, p1, p3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v2, p0, Ldm/Ui;->cTriangle:B

    invoke-static {v2}, Ldm/Ms;->abs(I)I

    move-result v2

    sub-int v2, v0, v2

    const/4 v0, 0x4

    or-int/lit8 v4, v0, 0x2

    const/4 v5, 0x4

    move-object v0, p0

    move v3, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 604
    const/16 v1, 0x1e

    add-int v0, p1, p3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v2, p0, Ldm/Ui;->cTriangle:B

    invoke-static {v2}, Ldm/Ms;->abs(I)I

    move-result v2

    add-int/2addr v2, v0

    const/16 v0, 0x8

    or-int/lit8 v4, v0, 0x2

    const/4 v5, 0x0

    move-object v0, p0

    move v3, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 605
    if-eqz p5, :cond_3f

    iget-byte v0, p0, Ldm/Ui;->cTriangle:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Ldm/Ui;->cTriangle:B

    const/4 v1, 0x4

    if-le v0, v1, :cond_3f

    const/4 v0, -0x3

    iput-byte v0, p0, Ldm/Ui;->cTriangle:B

    .line 606
    :cond_3f
    return-void
.end method

.method public drawUi(IIIII)V
    .registers 17
    .param p1, "action"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "anchor"    # I
    .param p5, "manipulation"    # I

    .prologue
    .line 295
    iget-object v1, p0, Ldm/Ui;->ui_img:Ljavax/microedition/lcdui/Image;

    iget-object v0, p0, Ldm/Ui;->ui_modules:[[S

    aget-object v0, v0, p1

    const/4 v2, 0x0

    aget-short v2, v0, v2

    iget-object v0, p0, Ldm/Ui;->ui_modules:[[S

    aget-object v0, v0, p1

    const/4 v3, 0x1

    aget-short v3, v0, v3

    iget-object v0, p0, Ldm/Ui;->ui_modules:[[S

    aget-object v0, v0, p1

    const/4 v4, 0x2

    aget-short v4, v0, v4

    .line 296
    iget-object v0, p0, Ldm/Ui;->ui_modules:[[S

    aget-object v0, v0, p1

    const/4 v5, 0x3

    aget-short v5, v0, v5

    sget-object v10, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    move-object v0, p0

    move v6, p2

    move v7, p3

    move v8, p4

    move/from16 v9, p5

    .line 295
    invoke-virtual/range {v0 .. v10}, Ldm/Ui;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIIILjavax/microedition/lcdui/Graphics;)V

    .line 298
    return-void
.end method

.method public drawVolume(IIIZ)V
    .registers 14
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "v"    # I
    .param p4, "bb"    # Z

    .prologue
    const/16 v8, 0x8

    const/4 v7, 0x1

    const/4 v6, 0x7

    const/4 v5, 0x6

    const/4 v4, 0x5

    .line 313
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    if-eqz p4, :cond_9e

    const v1, 0x7004b

    :goto_d
    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 314
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v1, p1, v7

    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v2, p2, 0x5

    const/16 v3, 0xa

    invoke-virtual {v0, v1, v2, v6, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 315
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x5

    add-int/lit8 v1, v1, 0x2

    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v2, p2, 0x2

    const/16 v3, 0xd

    invoke-virtual {v0, v1, v2, v6, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 316
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0xb

    add-int/lit8 v1, v1, 0x4

    add-int/lit8 v1, v1, 0x3

    sub-int v2, p2, v7

    const/16 v3, 0x10

    invoke-virtual {v0, v1, v2, v8, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 317
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    if-eqz p4, :cond_a3

    const v1, 0xf4e110

    :goto_42
    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 318
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x3

    add-int/lit8 v2, p2, 0x6

    invoke-virtual {v0, v1, v2, v5, v8}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 319
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x6

    add-int/lit8 v1, v1, 0x2

    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v2, p2, 0x3

    const/16 v3, 0xb

    invoke-virtual {v0, v1, v2, v5, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 320
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0xc

    add-int/lit8 v1, v1, 0x4

    add-int/lit8 v1, v1, 0x3

    const/16 v2, 0xe

    invoke-virtual {v0, v1, p2, v5, v2}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 321
    if-lez p3, :cond_77

    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x1

    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v2, p2, 0x7

    invoke-virtual {v0, v1, v2, v4, v6}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 322
    :cond_77
    const/16 v0, 0x1e

    if-le p3, v0, :cond_8a

    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0x7

    add-int/lit8 v1, v1, 0x2

    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v2, p2, 0x4

    const/16 v3, 0xa

    invoke-virtual {v0, v1, v2, v4, v3}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 323
    :cond_8a
    const/16 v0, 0x3c

    if-le p3, v0, :cond_9d

    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v1, p1, 0xd

    add-int/lit8 v1, v1, 0x4

    add-int/lit8 v1, v1, 0x3

    add-int/lit8 v2, p2, 0x1

    const/16 v3, 0xd

    invoke-virtual {v0, v1, v2, v4, v3}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 324
    :cond_9d
    return-void

    .line 313
    :cond_9e
    const v1, 0xb07038

    goto/16 :goto_d

    .line 317
    :cond_a3
    const v1, 0x381808

    goto :goto_42
.end method

.method public drawYesNo(ZZ)V
    .registers 13
    .param p1, "a"    # Z
    .param p2, "b"    # Z

    .prologue
    const/4 v2, 0x0

    .line 608
    const/16 v6, 0x280

    .local v6, "WIDTH":I
    const/16 v3, 0x168

    .line 609
    .local v3, "HEIGHT":I
    if-eqz p1, :cond_10

    const/16 v1, 0x1b

    const/16 v4, 0x24

    move-object v0, p0

    move v5, v2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 610
    :cond_10
    if-eqz p2, :cond_1c

    const/16 v5, 0x1c

    const/16 v8, 0x28

    move-object v4, p0

    move v7, v3

    move v9, v2

    invoke-virtual/range {v4 .. v9}, Ldm/Ui;->drawUi(IIIII)V

    .line 611
    :cond_1c
    return-void
.end method

.method public drawYesNo_(ZZ)V
    .registers 12
    .param p1, "a"    # Z
    .param p2, "b"    # Z

    .prologue
    const/4 v2, 0x0

    .line 613
    if-eqz p1, :cond_e

    const/16 v1, 0x1b

    sget v3, Lmain/Constants_H;->HEIGHT:I

    const/16 v4, 0x24

    move-object v0, p0

    move v5, v2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 614
    :cond_e
    if-eqz p2, :cond_1d

    const/16 v4, 0x1c

    sget v5, Lmain/Constants_H;->WIDTH:I

    sget v6, Lmain/Constants_H;->HEIGHT:I

    const/16 v7, 0x28

    move-object v3, p0

    move v8, v2

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawUi(IIIII)V

    .line 615
    :cond_1d
    return-void
.end method

.method public drawYesNo__(ZZ)V
    .registers 13
    .param p1, "a"    # Z
    .param p2, "b"    # Z

    .prologue
    const/4 v2, 0x0

    .line 617
    sget v6, Lmain/Constants_H;->WIDTH__:I

    .local v6, "WIDTH":I
    sget v3, Lmain/Constants_H;->HEIGHT__:I

    .line 618
    .local v3, "HEIGHT":I
    if-eqz p1, :cond_10

    const/16 v1, 0x1b

    const/16 v4, 0x24

    move-object v0, p0

    move v5, v2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 619
    :cond_10
    if-eqz p2, :cond_1c

    const/16 v5, 0x1c

    const/16 v8, 0x28

    move-object v4, p0

    move v7, v3

    move v9, v2

    invoke-virtual/range {v4 .. v9}, Ldm/Ui;->drawUi(IIIII)V

    .line 620
    :cond_1c
    return-void
.end method

.method public fillArc(IIIIIII)V
    .registers 15
    .param p1, "c"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "h"    # I
    .param p6, "a0"    # I
    .param p7, "a1"    # I

    .prologue
    .line 185
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 186
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    move v5, p6

    move v6, p7

    invoke-virtual/range {v0 .. v6}, Ljavax/microedition/lcdui/Graphics;->fillArc(IIIIII)V

    .line 187
    return-void
.end method

.method public fillRect(IIIII)V
    .registers 7
    .param p1, "c"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "h"    # I

    .prologue
    .line 173
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 174
    sget-object v0, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p2, p3, p4, p5}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 175
    return-void
.end method

.method public fillRectB()V
    .registers 7

    .prologue
    const/4 v2, 0x0

    .line 574
    const/16 v4, 0x280

    .local v4, "WIDTH":I
    const/16 v5, 0x168

    .line 575
    .local v5, "HEIGHT":I
    const v1, 0x52bdef

    move-object v0, p0

    move v3, v2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    return-void
.end method

.method public initGraphics(Ljavax/microedition/lcdui/Graphics;)V
    .registers 3
    .param p1, "_g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 29
    sput-object p1, Ldm/Ui;->g:Ljavax/microedition/lcdui/Graphics;

    .line 30
    invoke-static {p1}, Lcom/nokia/mid/ui/DirectUtils;->getDirectGraphics(Ljavax/microedition/lcdui/Graphics;)Lcom/nokia/mid/ui/DirectGraphics;

    move-result-object v0

    sput-object v0, Ldm/Ui;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    .line 31
    return-void
.end method

.method public initUiModules()V
    .registers 6

    .prologue
    const/4 v4, 0x0

    .line 286
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "data/ui"

    invoke-virtual {v0, v1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Ldm/Ui;->ui_img:Ljavax/microedition/lcdui/Image;

    .line 287
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v4, Ldm/Ms;->skip:I

    .line 288
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/ui_m.d"

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v1

    invoke-virtual {v0, v1, v4}, Ldm/Ms;->createShort2Array([BI)[[S

    move-result-object v0

    iput-object v0, p0, Ldm/Ui;->ui_modules:[[S

    .line 289
    return-void
.end method

.method public sliding(IIIIIZ)V
    .registers 15
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "h"    # I
    .param p4, "now"    # I
    .param p5, "all"    # I
    .param p6, "type"    # Z

    .prologue
    .line 507
    const/16 v7, 0xa

    .line 508
    .local v7, "w":B
    if-nez p6, :cond_13

    const/4 v0, 0x2

    sub-int v1, p1, v0

    const/4 v0, 0x2

    sub-int v2, p2, v0

    add-int/lit8 v3, v7, 0x4

    add-int/lit8 v4, p3, 0x4

    const/4 v5, 0x0

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 509
    :cond_13
    if-eqz p6, :cond_58

    const/4 v0, 0x0

    move v5, v0

    :goto_17
    move-object v0, p0

    move v1, p1

    move v2, p2

    move v3, v7

    move v4, p3

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 511
    const/16 v4, 0xb

    if-eqz p6, :cond_5b

    const/4 v0, 0x3

    move v5, v0

    :goto_25
    move-object v0, p0

    move v1, p1

    move v2, p2

    move v3, v7

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 512
    add-int v0, p2, p3

    const/16 v1, 0xb

    sub-int v2, v0, v1

    const/16 v4, 0xb

    if-eqz p6, :cond_5e

    const/4 v0, 0x3

    move v5, v0

    :goto_38
    move-object v0, p0

    move v1, p1

    move v3, v7

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 520
    add-int/lit8 p3, p3, -0x16

    .line 521
    add-int/lit8 p5, p5, -0x1

    .line 522
    const/4 v0, 0x1

    if-ge p5, v0, :cond_64

    .line 523
    add-int/lit8 v1, p1, 0x1

    add-int/lit8 v2, p2, 0xc

    const/4 v0, 0x2

    sub-int v3, v7, v0

    const/4 v0, 0x2

    sub-int v4, p3, v0

    if-eqz p6, :cond_61

    const/4 v0, 0x3

    move v5, v0

    :goto_53
    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 530
    :goto_57
    return-void

    .line 509
    :cond_58
    const/4 v0, 0x3

    move v5, v0

    goto :goto_17

    .line 511
    :cond_5b
    const/4 v0, 0x0

    move v5, v0

    goto :goto_25

    .line 512
    :cond_5e
    const/4 v0, 0x0

    move v5, v0

    goto :goto_38

    .line 523
    :cond_61
    const/4 v0, 0x0

    move v5, v0

    goto :goto_53

    .line 525
    :cond_64
    add-int/lit8 v0, p5, 0x1

    div-int v0, p3, v0

    int-to-byte v4, v0

    .line 526
    .local v4, "kh":B
    const/16 v0, 0xf

    if-ge v4, v0, :cond_6f

    const/16 v4, 0xf

    .line 527
    :cond_6f
    const/4 v0, 0x2

    sub-int v0, p3, v0

    sub-int/2addr v0, v4

    mul-int/2addr v0, p4

    div-int/2addr v0, p5

    int-to-short v6, v0

    .line 528
    .local v6, "k2":S
    add-int/lit8 v1, p1, 0x1

    add-int/lit8 v0, p2, 0xc

    add-int v2, v0, v6

    const/4 v0, 0x2

    sub-int v3, v7, v0

    if-eqz p6, :cond_88

    const/4 v0, 0x3

    move v5, v0

    :goto_83
    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    goto :goto_57

    :cond_88
    const/4 v0, 0x0

    move v5, v0

    goto :goto_83
.end method
