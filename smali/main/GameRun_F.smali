.class public Lmain/GameRun_F;
.super Ljava/lang/Object;
.source "GameRun_F.java"

# interfaces
.implements Lmain/Key_H;


# static fields
.field static dg:Lcom/nokia/mid/ui/DirectGraphics;

.field static g:Ljavax/microedition/lcdui/Graphics;

.field public static mc:Lmain/MainCanvas;

.field static offG:Ljavax/microedition/lcdui/Graphics;

.field public static run_state:I

.field static scrT:Ljavax/microedition/lcdui/Image;


# instance fields
.field public about_a:[Ljava/lang/StringBuffer;

.field public about_b:[Ljava/lang/StringBuffer;

.field public about_c:[Ljava/lang/StringBuffer;

.field public about_d:[Ljava/lang/StringBuffer;

.field public action_str:[Ljava/lang/String;

.field final anchor:[B

.field private brow5:B

.field public cMon_count:B

.field public cMonsters:[Ldm/Monster;

.field public cur_a:B

.field public cur_b:B

.field public cur_c:B

.field public cur_emon:Ldm/Monster;

.field public cur_mon:Ldm/Monster;

.field public gogoST:Ljava/lang/String;

.field public gogoString:Ljava/lang/String;

.field public help_page:B

.field public info:[B

.field public introT:I

.field public introX:I

.field public items:[[[B

.field public itemsLength:[B

.field public len:[B

.field public map:Lmain/Map;

.field public max_monsters:B

.field public max_takes:B

.field public monInfoList:[B

.field public move_x:S

.field public move_y:S

.field public myMon_length:B

.field public myMonsters:[Ldm/Monster;

.field public nidusList:[[B

.field public nidusMap:[B

.field public page_max:B

.field public pkey:Lmain/PointerKey;

.field public popMenu:B

.field public rmsNidus:[B

.field public rmsOther:[B

.field public rmsSms:[B

.field public select:[[B

.field public selectBag:[[B

.field public select_it:[B

.field public select_st:[B

.field public selectx:B

.field public selecty:B

.field public showS:[Ljava/lang/StringBuffer;

.field public src_c:[B

.field public str_cur:Ljava/lang/String;

.field final transB:[S


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 29
    const/4 v0, 0x1

    sput v0, Lmain/GameRun_F;->run_state:I

    .line 23
    return-void
.end method

.method public constructor <init>()V
    .registers 8

    .prologue
    const/16 v1, 0x8

    const/4 v6, 0x3

    const/4 v5, 0x0

    const/4 v4, 0x2

    const/4 v3, 0x4

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    new-array v0, v1, [B

    fill-array-data v0, :array_7c

    iput-object v0, p0, Lmain/GameRun_F;->anchor:[B

    .line 43
    new-array v0, v1, [S

    const/4 v1, 0x1

    const/16 v2, 0x5a

    aput-short v2, v0, v1

    const/16 v1, 0xb4

    aput-short v1, v0, v4

    const/16 v1, 0x10e

    aput-short v1, v0, v6

    const/16 v1, 0x2000

    aput-short v1, v0, v3

    const/4 v1, 0x5

    const/16 v2, 0x205a

    aput-short v2, v0, v1

    const/4 v1, 0x6

    const/16 v2, 0x20b4

    aput-short v2, v0, v1

    const/4 v1, 0x7

    const/16 v2, 0x210e

    aput-short v2, v0, v1

    iput-object v0, p0, Lmain/GameRun_F;->transB:[S

    .line 77
    sget v0, Lmain/Constants_H;->WIDTH_H:I

    iput v0, p0, Lmain/GameRun_F;->introX:I

    .line 78
    const-string v0, ""

    iput-object v0, p0, Lmain/GameRun_F;->gogoString:Ljava/lang/String;

    .line 92
    const/16 v0, 0x280

    iput v0, p0, Lmain/GameRun_F;->introT:I

    .line 93
    const-string v0, ""

    iput-object v0, p0, Lmain/GameRun_F;->gogoST:Ljava/lang/String;

    .line 113
    iput-byte v5, p0, Lmain/GameRun_F;->brow5:B

    .line 191
    iput-byte v5, p0, Lmain/GameRun_F;->page_max:B

    .line 192
    iput-byte v5, p0, Lmain/GameRun_F;->help_page:B

    .line 226
    new-array v0, v3, [B

    iput-object v0, p0, Lmain/GameRun_F;->src_c:[B

    .line 277
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun_F;->popMenu:B

    .line 280
    new-array v0, v3, [B

    iput-object v0, p0, Lmain/GameRun_F;->select_it:[B

    .line 281
    new-array v0, v3, [B

    iput-object v0, p0, Lmain/GameRun_F;->select_st:[B

    .line 282
    filled-new-array {v3, v4}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[B

    iput-object v0, p0, Lmain/GameRun_F;->selectBag:[[B

    .line 283
    filled-new-array {v4, v4}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[B

    iput-object v0, p0, Lmain/GameRun_F;->select:[[B

    .line 427
    iput-byte v6, p0, Lmain/GameRun_F;->max_takes:B

    .line 428
    const/16 v0, 0xa

    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B

    .line 23
    return-void

    .line 42
    :array_7c
    .array-data 1
        0x14t
        0x24t
        0x28t
        0x18t
        0x18t
        0x28t
        0x24t
        0x14t
    .end array-data
.end method

.method private drawSnare5(II)V
    .registers 9
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    const/4 v4, 0x0

    .line 116
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0x8

    iget-byte v2, p0, Lmain/GameRun_F;->brow5:B

    rem-int/lit8 v2, v2, 0x3

    if-nez v2, :cond_23

    const/4 v2, 0x1

    :goto_e
    add-int v3, p2, v2

    move v2, p1

    move v5, v4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 120
    iget-byte v0, p0, Lmain/GameRun_F;->brow5:B

    add-int/lit8 v1, v0, 0x1

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/GameRun_F;->brow5:B

    const/16 v1, 0x64

    if-le v0, v1, :cond_22

    iput-byte v4, p0, Lmain/GameRun_F;->brow5:B

    .line 121
    :cond_22
    return-void

    :cond_23
    move v2, v4

    .line 116
    goto :goto_e
.end method


# virtual methods
.method public addNidus(I)Z
    .registers 7
    .param p1, "id"    # I

    .prologue
    const/4 v4, 0x0

    .line 717
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_2
    iget-object v1, p0, Lmain/GameRun_F;->rmsNidus:[B

    array-length v1, v1

    if-lt v0, v1, :cond_9

    move v1, v4

    .line 725
    :goto_8
    return v1

    .line 718
    :cond_9
    iget-object v1, p0, Lmain/GameRun_F;->rmsNidus:[B

    aget-byte v1, v1, v0

    const/4 v2, -0x2

    if-eq v1, v2, :cond_14

    .line 717
    add-int/lit8 v1, v0, 0x5

    int-to-byte v0, v1

    goto :goto_2

    .line 719
    :cond_14
    iget-object v1, p0, Lmain/GameRun_F;->rmsNidus:[B

    int-to-byte v2, p1

    aput-byte v2, v1, v0

    .line 721
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun_F;->rmsNidus:[B

    add-int/lit8 v3, v0, 0x1

    invoke-virtual {v1, v4, v2, v3}, Ldm/Ms;->putShort(I[BI)V

    .line 722
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/16 v2, 0xc8

    iget-object v3, p0, Lmain/GameRun_F;->rmsNidus:[B

    add-int/lit8 v4, v0, 0x3

    invoke-virtual {v1, v2, v3, v4}, Ldm/Ms;->putShort(I[BI)V

    .line 723
    const/4 v1, 0x1

    goto :goto_8
.end method

.method public createData(I)[B
    .registers 4
    .param p1, "no"    # I

    .prologue
    .line 265
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "4"

    invoke-virtual {v0, v1, p1}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    return-object v0
.end method

.method public createString(Ljava/lang/String;)Ljava/lang/String;
    .registers 7
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 260
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v4, Ldm/Ms;->skip:I

    .line 261
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    const/4 v3, -0x1

    invoke-virtual {v2, p1, v3}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v0

    .line 262
    .local v0, "str":[Ljava/lang/StringBuffer;
    aget-object v1, v0, v4

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public delNidus(I)V
    .registers 5
    .param p1, "i"    # I

    .prologue
    .line 727
    iget-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B

    mul-int/lit8 v1, p1, 0x5

    const/4 v2, -0x2

    aput-byte v2, v0, v1

    return-void
.end method

.method public drawHelpStr(Ljavax/microedition/lcdui/Graphics;[Ljava/lang/StringBuffer;IIII)V
    .registers 16
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;
    .param p2, "help_strbuff"    # [Ljava/lang/StringBuffer;
    .param p3, "line_num"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I
    .param p6, "anchor"    # I

    .prologue
    .line 199
    iget-byte v0, p0, Lmain/GameRun_F;->help_page:B

    mul-int/2addr v0, p3

    int-to-byte v8, v0

    .line 201
    .local v8, "line_start":B
    move v7, v8

    .local v7, "i":B
    :goto_5
    add-int v0, v8, p3

    if-ge v7, v0, :cond_c

    array-length v0, p2

    if-lt v7, v0, :cond_5c

    .line 203
    :cond_c
    array-length v0, p2

    if-le v0, p3, :cond_79

    .line 204
    array-length v0, p2

    div-int/2addr v0, p3

    array-length v1, p2

    rem-int/2addr v1, p3

    if-eqz v1, :cond_77

    const/4 v1, 0x1

    :goto_16
    add-int/2addr v0, v1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun_F;->page_max:B

    .line 205
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    iget-byte v2, p0, Lmain/GameRun_F;->help_page:B

    add-int/lit8 v2, v2, 0x1

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-byte v2, p0, Lmain/GameRun_F;->page_max:B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sget v2, Lmain/Constants_H;->WIDTH_H:I

    sget v3, Lmain/Constants_H;->HEIGHT:I

    const/4 v4, 0x2

    sub-int/2addr v3, v4

    const/4 v4, 0x1

    or-int/lit8 v4, v4, 0x20

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 206
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    sget v1, Lmain/Constants_H;->WIDTH_H:I

    sget v2, Lmain/Constants_H;->HEIGHT:I

    const/16 v3, 0xc

    sub-int/2addr v2, v3

    const/16 v3, 0x4b

    const/4 v4, 0x1

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 208
    :goto_5b
    return-void

    .line 202
    :cond_5c
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    aget-object v1, p2, v7

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    sub-int v2, v7, v8

    mul-int/lit8 v2, v2, 0x1b

    add-int v3, p5, v2

    const/4 v5, 0x3

    const/4 v6, 0x0

    move v2, p4

    move v4, p6

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 201
    add-int/lit8 v0, v7, 0x1

    int-to-byte v7, v0

    goto :goto_5

    .line 204
    :cond_77
    const/4 v1, 0x0

    goto :goto_16

    .line 207
    :cond_79
    const/4 v0, 0x1

    iput-byte v0, p0, Lmain/GameRun_F;->page_max:B

    goto :goto_5b
.end method

.method public drawMenu([Ljava/lang/StringBuffer;III)V
    .registers 13
    .param p1, "menu"    # [Ljava/lang/StringBuffer;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I

    .prologue
    .line 293
    const/16 v5, 0xa

    .line 294
    .local v5, "color":B
    if-lez p4, :cond_15

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    array-length v1, p1

    mul-int/lit8 v1, v1, 0x1b

    add-int/lit8 v1, v1, 0xc

    invoke-virtual {v0, p2, p3, p4, v1}, Ldm/Ui;->drawKuang(IIII)V

    .line 297
    :goto_10
    const/4 v7, 0x0

    .local v7, "d":B
    :goto_11
    array-length v0, p1

    if-lt v7, v0, :cond_1d

    .line 304
    return-void

    .line 295
    .end local v7    # "d":B
    :cond_15
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {p4}, Ldm/Ms;->abs(I)I

    move-result p4

    goto :goto_10

    .line 298
    .restart local v7    # "d":B
    :cond_1d
    if-nez v7, :cond_3e

    const/16 v5, 0x9

    .line 301
    :goto_21
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    aget-object v1, p1, v7

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    shr-int/lit8 v2, p4, 0x1

    add-int/2addr v2, p2

    add-int/lit8 v3, p3, 0x4

    mul-int/lit8 v4, v7, 0x1b

    add-int/2addr v3, v4

    const/4 v4, 0x1

    or-int/lit8 v4, v4, 0x10

    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 297
    add-int/lit8 v0, v7, 0x1

    int-to-byte v7, v0

    goto :goto_11

    .line 299
    :cond_3e
    iget-byte v0, p0, Lmain/GameRun_F;->cur_a:B

    if-ne v7, v0, :cond_45

    const/16 v5, 0x8

    goto :goto_21

    .line 300
    :cond_45
    const/4 v5, 0x0

    goto :goto_21
.end method

.method public drawPauseMenu(IIII)V
    .registers 17
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    .line 357
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v5, 0x1

    move v1, p1

    move v2, p2

    move v3, p3

    move/from16 v4, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK2(IIIII)V

    .line 358
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p1, 0x9

    add-int/lit8 v2, p2, 0x19

    add-int/lit8 v2, v2, 0xb

    const/16 v3, 0x12

    sub-int v3, p3, v3

    const/16 v4, 0x19

    sub-int v4, p4, v4

    const/16 v5, 0x13

    sub-int/2addr v4, v5

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 369
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x6

    add-int/lit8 v2, p1, 0x8

    add-int/lit8 v3, p2, 0x19

    add-int/lit8 v3, v3, 0xd

    const/16 v4, 0x10

    sub-int v4, p3, v4

    const/4 v5, 0x1

    const/16 v6, 0x21

    const/4 v7, -0x1

    iget-byte v8, p0, Lmain/GameRun_F;->selecty:B

    const/4 v9, 0x4

    const/4 v10, 0x2

    invoke-virtual/range {v0 .. v10}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 373
    iget-object v0, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;

    iget-object v1, p0, Lmain/GameRun_F;->action_str:[Ljava/lang/String;

    array-length v1, v1

    add-int/lit8 v2, p1, 0x8

    add-int/lit8 v3, p2, 0x19

    add-int/lit8 v3, v3, 0xd

    const/16 v4, 0x10

    sub-int v4, p3, v4

    const/4 v5, 0x1

    const/16 v6, 0x21

    const/4 v7, -0x1

    iget-byte v8, p0, Lmain/GameRun_F;->selecty:B

    invoke-virtual/range {v0 .. v8}, Lmain/PointerKey;->selectListSY(IIIIIIII)V

    .line 374
    iget-object v0, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;

    const/4 v1, 0x2

    add-int/lit8 v3, p2, 0x3

    shr-int/lit8 v4, p3, 0x1

    const/16 v5, 0x26

    move v2, p1

    invoke-virtual/range {v0 .. v5}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v11

    .line 375
    .local v11, "t":B
    const/4 v0, -0x1

    if-eq v11, v0, :cond_73

    .line 376
    iput-byte v11, p0, Lmain/GameRun_F;->selectx:B

    .line 377
    const/4 v0, 0x0

    iput-byte v0, p0, Lmain/GameRun_F;->selecty:B

    .line 378
    iget-byte v0, p0, Lmain/GameRun_F;->selectx:B

    invoke-virtual {p0, v0}, Lmain/GameRun_F;->setPauseS(I)V

    .line 390
    :cond_73
    iget-byte v0, p0, Lmain/GameRun_F;->selectx:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_11a

    .line 392
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    shr-int/lit8 v1, p3, 0x1

    add-int/2addr v1, p1

    add-int/lit8 v1, v1, 0x19

    const/16 v2, 0x8

    sub-int/2addr v1, v2

    const/16 v2, 0x3c

    sub-int/2addr v1, v2

    add-int/lit8 v2, p2, 0x19

    add-int/lit8 v2, v2, 0x10

    add-int/lit8 v2, v2, 0x21

    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v3

    invoke-virtual {v3}, Ldm/Sound;->getVolume()B

    move-result v3

    iget-byte v4, p0, Lmain/GameRun_F;->selecty:B

    const/4 v5, 0x1

    if-ne v4, v5, :cond_118

    const/4 v4, 0x1

    :goto_9b
    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawVolume(IIIZ)V

    .line 394
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun_F;->action_str:[Ljava/lang/String;

    add-int/lit8 v2, p1, 0x8

    add-int/lit8 v3, p2, 0x19

    add-int/lit8 v3, v3, 0xd

    const/16 v4, 0x10

    sub-int v4, p3, v4

    const/16 v5, 0x20

    iget-byte v6, p0, Lmain/GameRun_F;->selecty:B

    const/4 v7, 0x0

    const/4 v8, 0x3

    const/4 v9, 0x0

    invoke-virtual/range {v0 .. v9}, Ldm/Ui;->drawListSYHasSound([Ljava/lang/Object;IIIIIIII)V

    .line 407
    :goto_b8
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    shr-int/lit8 v1, p3, 0x1

    add-int/2addr v1, p1

    iget-byte v2, p0, Lmain/GameRun_F;->selectx:B

    if-nez v2, :cond_135

    const/16 v2, -0x3c

    :goto_c5
    add-int/2addr v1, v2

    add-int/lit8 v2, p2, 0x4

    const/16 v3, 0x38

    const/16 v4, 0x1d

    const/4 v5, 0x4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 408
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const-string v1, "\u83dc\u5355"

    shr-int/lit8 v2, p3, 0x1

    add-int/2addr v2, p1

    const/16 v3, 0x19

    sub-int/2addr v2, v3

    const/4 v3, 0x3

    sub-int/2addr v2, v3

    add-int/lit8 v3, p2, 0x3

    const/4 v4, 0x1

    or-int/lit8 v4, v4, 0x10

    iget-byte v5, p0, Lmain/GameRun_F;->selectx:B

    if-nez v5, :cond_137

    const/4 v5, 0x0

    :goto_e8
    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 409
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const-string v1, "\u7cfb\u7edf"

    shr-int/lit8 v2, p3, 0x1

    add-int/2addr v2, p1

    add-int/lit8 v2, v2, 0x19

    add-int/lit8 v2, v2, 0x3

    add-int/lit8 v3, p2, 0x3

    const/4 v4, 0x1

    or-int/lit8 v4, v4, 0x10

    iget-byte v5, p0, Lmain/GameRun_F;->selectx:B

    if-nez v5, :cond_139

    const/4 v5, 0x1

    :goto_103
    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 416
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    shr-int/lit8 v1, p3, 0x1

    add-int/2addr v1, p1

    add-int/lit8 v2, p2, 0xc

    const/16 v3, 0x50

    const/4 v4, 0x1

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 419
    return-void

    .line 392
    :cond_118
    const/4 v4, 0x0

    goto :goto_9b

    .line 397
    :cond_11a
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun_F;->action_str:[Ljava/lang/String;

    add-int/lit8 v2, p1, 0x8

    add-int/lit8 v3, p2, 0x19

    add-int/lit8 v3, v3, 0xd

    const/16 v4, 0x10

    sub-int v4, p3, v4

    const/16 v5, 0x20

    iget-byte v6, p0, Lmain/GameRun_F;->selecty:B

    const/4 v7, 0x0

    const/4 v8, 0x3

    const/4 v9, 0x0

    invoke-virtual/range {v0 .. v9}, Ldm/Ui;->drawListSY([Ljava/lang/Object;IIIIIIII)V

    goto :goto_b8

    .line 407
    :cond_135
    const/4 v2, 0x2

    goto :goto_c5

    .line 408
    :cond_137
    const/4 v5, 0x1

    goto :goto_e8

    .line 409
    :cond_139
    const/4 v5, 0x0

    goto :goto_103
.end method

.method public drawSelectMenu([Ljava/lang/Object;IIIIII)V
    .registers 16
    .param p1, "menu"    # [Ljava/lang/Object;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "dis"    # I
    .param p6, "cn"    # I
    .param p7, "s_f"    # I

    .prologue
    .line 311
    const/4 v7, 0x0

    .local v7, "d":B
    :goto_1
    array-length v0, p1

    if-lt v7, v0, :cond_5

    .line 327
    return-void

    .line 312
    :cond_5
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p5, 0x21

    mul-int/2addr v1, v7

    add-int v2, p3, v1

    const/16 v4, 0x21

    if-ne v7, p7, :cond_63

    const/4 v1, 0x1

    move v5, v1

    :goto_14
    move v1, p2

    move v3, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK0(IIIII)V

    .line 313
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    aget-object v1, p1, v7

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    shr-int/lit8 v2, p4, 0x1

    add-int/2addr v2, p2

    add-int/lit8 v3, p3, 0x2

    add-int/lit8 v4, p5, 0x21

    mul-int/2addr v4, v7

    add-int/2addr v3, v4

    const/4 v4, 0x1

    or-int/lit8 v4, v4, 0x10

    if-ne v7, p7, :cond_65

    const/4 v5, 0x0

    :goto_32
    const/4 v6, 0x1

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 315
    const-string v0, "sk"

    const-string v1, "drawSelectMenu"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 316
    iget-object v0, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;

    add-int/lit8 v1, p5, 0x21

    mul-int/2addr v1, v7

    add-int/2addr v1, p3

    const/16 v2, 0x21

    invoke-virtual {v0, p2, v1, p4, v2}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v0

    if-eqz v0, :cond_5f

    .line 317
    iget-object v0, p0, Lmain/GameRun_F;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0xc

    if-ne v0, v1, :cond_6a

    .line 318
    if-ne v7, p7, :cond_67

    iget-object v0, p0, Lmain/GameRun_F;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0xd

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 311
    :cond_5f
    :goto_5f
    add-int/lit8 v0, v7, 0x1

    int-to-byte v7, v0

    goto :goto_1

    :cond_63
    move v5, p6

    .line 312
    goto :goto_14

    .line 313
    :cond_65
    const/4 v5, 0x3

    goto :goto_32

    .line 319
    :cond_67
    iput-byte v7, p0, Lmain/GameRun_F;->cur_a:B

    goto :goto_5f

    .line 320
    :cond_6a
    sget v0, Lmain/GameRun_F;->run_state:I

    const/16 v1, 0x23

    if-eq v0, v1, :cond_92

    sget v0, Lmain/GameRun_F;->run_state:I

    const/16 v1, 0x19

    if-eq v0, v1, :cond_92

    iget-object v0, p0, Lmain/GameRun_F;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x10

    if-eq v0, v1, :cond_92

    sget v0, Lmain/GameRun_F;->run_state:I

    const/16 v1, 0x41

    if-eq v0, v1, :cond_92

    sget v0, Lmain/GameRun_F;->run_state:I

    const/16 v1, 0x42

    if-eq v0, v1, :cond_92

    sget v0, Lmain/GameRun_F;->run_state:I

    const/16 v1, 0x3d

    if-ne v0, v1, :cond_5f

    .line 321
    :cond_92
    if-ne v7, p7, :cond_9a

    iget-object v0, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;

    invoke-virtual {v0}, Lmain/PointerKey;->setKey5()V

    goto :goto_5f

    .line 322
    :cond_9a
    iput-byte v7, p0, Lmain/GameRun_F;->popMenu:B

    goto :goto_5f
.end method

.method public drawSelectMenu_([Ljava/lang/Object;IIIIII)V
    .registers 19
    .param p1, "menu"    # [Ljava/lang/Object;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "dis"    # I
    .param p6, "cn"    # I
    .param p7, "s_f"    # I

    .prologue
    .line 330
    const/16 v9, 0x19

    .line 332
    .local v9, "FONT_H":I
    const/4 v10, 0x0

    .local v10, "d":B
    :goto_3
    array-length v2, p1

    if-lt v10, v2, :cond_7

    .line 349
    return-void

    .line 333
    :cond_7
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    add-int/lit8 v3, v9, 0x8

    add-int/lit8 v3, p5, 0x21

    mul-int/2addr v3, v10

    add-int v4, p3, v3

    add-int/lit8 v6, v9, 0x8

    move v0, v10

    move/from16 v1, p7

    if-ne v0, v1, :cond_8e

    const/4 v3, 0x1

    move v7, v3

    :goto_1b
    move v3, p2

    move v5, p4

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawK0(IIIII)V

    .line 334
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    aget-object v3, p1, v10

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    shr-int/lit8 v4, p4, 0x1

    add-int/2addr v4, p2

    add-int/lit8 v5, p3, 0x2

    add-int/lit8 v6, v9, 0x8

    add-int/lit8 v6, p5, 0x21

    mul-int/2addr v6, v10

    add-int/2addr v5, v6

    const/4 v6, 0x1

    or-int/lit8 v6, v6, 0x10

    move v0, v10

    move/from16 v1, p7

    if-ne v0, v1, :cond_91

    const/4 v7, 0x0

    :goto_3e
    const/4 v8, 0x1

    invoke-virtual/range {v2 .. v8}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 337
    sget-object v2, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;

    const/high16 v3, 0xff0000

    invoke-virtual {v2, v3}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 338
    iget-object v2, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;

    sget v3, Lmain/Constants_H;->WIDTH:I

    mul-int/2addr v3, p2

    sget v4, Lmain/Constants_H;->WIDTH__:I

    div-int/2addr v3, v4

    add-int/lit8 v4, v9, 0x8

    add-int/lit8 v4, p5, 0x21

    mul-int/2addr v4, v10

    add-int/2addr v4, p3

    sget v5, Lmain/Constants_H;->WIDTH:I

    mul-int/2addr v4, v5

    sget v5, Lmain/Constants_H;->WIDTH__:I

    div-int/2addr v4, v5

    sget v5, Lmain/Constants_H;->WIDTH:I

    mul-int/2addr v5, p4

    sget v6, Lmain/Constants_H;->WIDTH__:I

    div-int/2addr v5, v6

    add-int/lit8 v6, v9, 0x8

    sget v6, Lmain/Constants_H;->WIDTH:I

    mul-int/lit8 v6, v6, 0x21

    sget v7, Lmain/Constants_H;->WIDTH__:I

    div-int/2addr v6, v7

    invoke-virtual {v2, v3, v4, v5, v6}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v2

    if-eqz v2, :cond_89

    .line 339
    iget-object v2, p0, Lmain/GameRun_F;->map:Lmain/Map;

    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->state:B

    const/16 v3, 0xc

    if-ne v2, v3, :cond_96

    .line 340
    move v0, v10

    move/from16 v1, p7

    if-ne v0, v1, :cond_93

    iget-object v2, p0, Lmain/GameRun_F;->map:Lmain/Map;

    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;

    const/16 v3, 0xd

    iput-byte v3, v2, Ldm/Npc;->state:B

    .line 332
    :cond_89
    :goto_89
    add-int/lit8 v2, v10, 0x1

    int-to-byte v10, v2

    goto/16 :goto_3

    :cond_8e
    move/from16 v7, p6

    .line 333
    goto :goto_1b

    .line 334
    :cond_91
    const/4 v7, 0x3

    goto :goto_3e

    .line 341
    :cond_93
    iput-byte v10, p0, Lmain/GameRun_F;->cur_a:B

    goto :goto_89

    .line 342
    :cond_96
    sget v2, Lmain/GameRun_F;->run_state:I

    const/16 v3, 0x23

    if-eq v2, v3, :cond_b8

    sget v2, Lmain/GameRun_F;->run_state:I

    const/16 v3, 0x19

    if-eq v2, v3, :cond_b8

    iget-object v2, p0, Lmain/GameRun_F;->map:Lmain/Map;

    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->state:B

    const/16 v3, 0x10

    if-eq v2, v3, :cond_b8

    sget v2, Lmain/GameRun_F;->run_state:I

    const/16 v3, 0x41

    if-eq v2, v3, :cond_b8

    sget v2, Lmain/GameRun_F;->run_state:I

    const/16 v3, 0x42

    if-ne v2, v3, :cond_89

    .line 343
    :cond_b8
    move v0, v10

    move/from16 v1, p7

    if-ne v0, v1, :cond_c3

    iget-object v2, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;

    invoke-virtual {v2}, Lmain/PointerKey;->setKey5()V

    goto :goto_89

    .line 344
    :cond_c3
    iput-byte v10, p0, Lmain/GameRun_F;->popMenu:B

    goto :goto_89
.end method

.method public drawSrcLine(Ljavax/microedition/lcdui/Graphics;IIIZZ)V
    .registers 15
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;
    .param p2, "y"    # I
    .param p3, "h"    # I
    .param p4, "piece"    # I
    .param p5, "dir"    # Z
    .param p6, "mode"    # Z

    .prologue
    .line 236
    const/16 v0, 0x280

    .line 237
    .local v0, "WIDTH":I
    const/4 v1, 0x0

    .local v1, "i":B
    div-int v4, p3, p4

    int-to-byte v2, v4

    .line 239
    .local v2, "ph":B
    const/4 v4, 0x0

    invoke-virtual {p1, v4}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 240
    if-nez p5, :cond_68

    .line 241
    const/4 v4, 0x2

    iget-object v5, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    shl-int/2addr v4, v5

    int-to-short v3, v4

    .line 242
    .local v3, "speed":S
    const/4 v4, 0x1

    sub-int v4, p4, v4

    int-to-byte v1, v4

    :goto_18
    const/4 v4, -0x1

    if-gt v1, v4, :cond_31

    .line 246
    if-eqz p6, :cond_54

    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    const/16 v5, 0xc

    if-ge v4, v5, :cond_54

    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v5, 0x0

    aget-byte v6, v4, v5

    add-int/lit8 v6, v6, 0x1

    int-to-byte v6, v6

    aput-byte v6, v4, v5

    .line 257
    :cond_30
    :goto_30
    return-void

    .line 243
    :cond_31
    sub-int v4, v2, v3

    if-gtz v4, :cond_3d

    .line 242
    :goto_35
    const/4 v4, 0x1

    sub-int v4, v1, v4

    int-to-byte v1, v4

    div-int/lit8 v4, v3, 0x2

    int-to-short v3, v4

    goto :goto_18

    .line 244
    :cond_3d
    const/4 v4, 0x0

    mul-int v5, v1, v2

    add-int/2addr v5, p2

    const/4 v6, 0x2

    if-ge v3, v6, :cond_50

    const/4 v6, 0x0

    :goto_45
    add-int/2addr v5, v6

    const/4 v6, 0x2

    if-ge v3, v6, :cond_52

    const/4 v6, 0x0

    :goto_4a
    sub-int v6, v2, v6

    invoke-virtual {p1, v4, v5, v0, v6}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    goto :goto_35

    :cond_50
    move v6, v3

    goto :goto_45

    :cond_52
    move v6, v3

    goto :goto_4a

    .line 247
    :cond_54
    if-nez p6, :cond_30

    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    if-lez v4, :cond_30

    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v5, 0x0

    aget-byte v6, v4, v5

    const/4 v7, 0x1

    sub-int/2addr v6, v7

    int-to-byte v6, v6

    aput-byte v6, v4, v5

    goto :goto_30

    .line 249
    .end local v3    # "speed":S
    :cond_68
    const/4 v4, 0x2

    iget-object v5, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v6, 0x1

    aget-byte v5, v5, v6

    shl-int/2addr v4, v5

    int-to-short v3, v4

    .line 250
    .restart local v3    # "speed":S
    :goto_70
    if-eqz p5, :cond_74

    if-lt v1, p4, :cond_8a

    .line 254
    :cond_74
    if-eqz p6, :cond_a5

    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v5, 0x1

    aget-byte v4, v4, v5

    const/16 v5, 0xc

    if-ge v4, v5, :cond_a5

    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v5, 0x1

    aget-byte v6, v4, v5

    add-int/lit8 v6, v6, 0x1

    int-to-byte v6, v6

    aput-byte v6, v4, v5

    goto :goto_30

    .line 251
    :cond_8a
    sub-int v4, v2, v3

    if-gtz v4, :cond_95

    .line 250
    :goto_8e
    add-int/lit8 v4, v1, 0x1

    int-to-byte v1, v4

    div-int/lit8 v4, v3, 0x2

    int-to-short v3, v4

    goto :goto_70

    .line 252
    :cond_95
    const/4 v4, 0x0

    mul-int v5, v1, v2

    add-int/2addr v5, p2

    const/4 v6, 0x2

    if-ge v3, v6, :cond_a3

    const/4 v6, 0x0

    :goto_9d
    sub-int v6, v2, v6

    invoke-virtual {p1, v4, v5, v0, v6}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    goto :goto_8e

    :cond_a3
    move v6, v3

    goto :goto_9d

    .line 255
    :cond_a5
    if-nez p6, :cond_30

    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v5, 0x1

    aget-byte v4, v4, v5

    if-lez v4, :cond_30

    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B

    const/4 v5, 0x1

    aget-byte v6, v4, v5

    const/4 v7, 0x1

    sub-int/2addr v6, v7

    int-to-byte v6, v6

    aput-byte v6, v4, v5

    goto/16 :goto_30
.end method

.method public drawZero(IIII)V
    .registers 12
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "anchor"    # I
    .param p4, "color"    # I

    .prologue
    .line 65
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const-string v1, "\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed"

    const/4 v6, 0x0

    move v2, p1

    move v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 69
    return-void
.end method

.method public drawZero(Ljava/lang/String;I)V
    .registers 10
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "y"    # I

    .prologue
    const/4 v5, 0x0

    .line 72
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u70b9\u51fb\u5c4f\u5e55"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sget v2, Lmain/Constants_H;->WIDTH_H:I

    const/4 v3, 0x1

    or-int/lit8 v4, v3, 0x20

    move v3, p2

    move v6, v5

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 76
    return-void
.end method

.method public getNLevel(I)B
    .registers 4
    .param p1, "i"    # I

    .prologue
    .line 713
    iget-object v0, p0, Lmain/GameRun_F;->nidusList:[[B

    const/4 v1, 0x1

    aget-object v0, v0, v1

    invoke-virtual {p0, p1}, Lmain/GameRun_F;->getRid(I)B

    move-result v1

    aget-byte v0, v0, v1

    return v0
.end method

.method public getNexp(II)S
    .registers 6
    .param p1, "i"    # I
    .param p2, "n"    # I

    .prologue
    .line 714
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun_F;->rmsNidus:[B

    mul-int/lit8 v2, p1, 0x5

    add-int/2addr v2, p2

    invoke-virtual {v0, v1, v2}, Ldm/Ms;->getShort([BI)S

    move-result v0

    return v0
.end method

.method public getNid(I)B
    .registers 4
    .param p1, "i"    # I

    .prologue
    .line 712
    iget-object v0, p0, Lmain/GameRun_F;->nidusList:[[B

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-virtual {p0, p1}, Lmain/GameRun_F;->getRid(I)B

    move-result v1

    aget-byte v0, v0, v1

    return v0
.end method

.method public getRid(I)B
    .registers 4
    .param p1, "i"    # I

    .prologue
    .line 711
    iget-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B

    mul-int/lit8 v1, p1, 0x5

    aget-byte v0, v0, v1

    return v0
.end method

.method public getSIndexW(Ljava/lang/String;)S
    .registers 7
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 54
    const/4 v1, 0x0

    .local v1, "num":B
    const/4 v2, 0x0

    .local v2, "start":B
    const-string v3, "#"

    invoke-virtual {p1, v3, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v3

    int-to-byte v0, v3

    .line 55
    .local v0, "end":B
    if-nez v0, :cond_c

    const/4 v0, 0x1

    .line 56
    :cond_c
    :goto_c
    const/4 v3, -0x1

    if-ne v0, v3, :cond_1c

    .line 61
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    const-string v4, "#1"

    invoke-virtual {v3, v4}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v3

    mul-int/2addr v3, v1

    int-to-short v3, v3

    return v3

    .line 57
    :cond_1c
    add-int v3, v2, v0

    int-to-byte v2, v3

    .line 58
    const-string v3, "#"

    invoke-virtual {p1, v3, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v3

    int-to-byte v0, v3

    .line 59
    add-int/lit8 v3, v1, 0x1

    int-to-byte v1, v3

    goto :goto_c
.end method

.method public gogoWord(Ljava/lang/String;IIIIII)V
    .registers 17
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "color"    # I
    .param p6, "strT"    # I
    .param p7, "speed"    # I

    .prologue
    .line 82
    const/16 v7, 0x280

    .local v7, "WIDTH":I
    const/16 v6, 0x168

    .line 83
    .local v6, "HEIGHT":I
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0, p1}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p0, p1}, Lmain/GameRun_F;->getSIndexW(Ljava/lang/String;)S

    move-result v1

    sub-int/2addr v0, v1

    int-to-short v8, v0

    .line 84
    .local v8, "sw":S
    sub-int v0, v7, p2

    sub-int/2addr v0, p4

    if-le v8, v0, :cond_48

    .line 85
    iget v0, p0, Lmain/GameRun_F;->introX:I

    sub-int v0, v0, p7

    iput v0, p0, Lmain/GameRun_F;->introX:I

    .line 86
    iget v0, p0, Lmain/GameRun_F;->introX:I

    add-int/2addr v0, v8

    if-ge v0, p2, :cond_29

    sub-int v0, v7, p4

    const/16 v1, 0x4b

    sub-int/2addr v0, v1

    iput v0, p0, Lmain/GameRun_F;->introX:I

    .line 88
    :cond_29
    :goto_29
    sget-object v0, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v1, v7, p4

    sub-int/2addr v1, p2

    const/16 v2, 0x1e

    invoke-virtual {v0, p2, p3, v1, v2}, Ljavax/microedition/lcdui/Graphics;->clipRect(IIII)V

    .line 89
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget v2, p0, Lmain/GameRun_F;->introX:I

    move-object v1, p1

    move v3, p3

    move v4, p5

    move v5, p6

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V

    .line 90
    sget-object v0, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v7, v6}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 91
    return-void

    .line 87
    :cond_48
    iput p2, p0, Lmain/GameRun_F;->introX:I

    goto :goto_29
.end method

.method public gogoWordM(Ljava/lang/String;IIIII)V
    .registers 17
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "color"    # I
    .param p5, "strT"    # I
    .param p6, "speed"    # I

    .prologue
    .line 97
    const/16 v8, 0x280

    .local v8, "WIDTH":I
    const/16 v7, 0x168

    .line 98
    .local v7, "HEIGHT":I
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0, p1}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v0

    int-to-short v9, v0

    .line 99
    .local v9, "sw":S
    iget v0, p0, Lmain/GameRun_F;->introT:I

    sub-int v0, v0, p6

    iput v0, p0, Lmain/GameRun_F;->introT:I

    .line 100
    iget v0, p0, Lmain/GameRun_F;->introT:I

    add-int/2addr v0, v9

    shl-int/lit8 v1, p3, 0x1

    if-ge v0, v1, :cond_1e

    add-int/lit8 v0, v8, 0x1

    iput v0, p0, Lmain/GameRun_F;->introT:I

    .line 101
    :cond_1e
    sget-object v0, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;

    shl-int/lit8 v1, p3, 0x1

    sub-int v1, v8, v1

    const/16 v2, 0x1e

    invoke-virtual {v0, p3, p2, v1, v2}, Ljavax/microedition/lcdui/Graphics;->clipRect(IIII)V

    .line 102
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget v2, p0, Lmain/GameRun_F;->introT:I

    const/4 v4, 0x0

    move-object v1, p1

    move v3, p2

    move v5, p4

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 104
    sget-object v0, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v8, v7}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 105
    return-void
.end method

.method public initGraphics(Ljavax/microedition/lcdui/Graphics;)V
    .registers 3
    .param p1, "_g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 35
    sput-object p1, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;

    .line 36
    invoke-static {p1}, Lcom/nokia/mid/ui/DirectUtils;->getDirectGraphics(Ljavax/microedition/lcdui/Graphics;)Lcom/nokia/mid/ui/DirectGraphics;

    move-result-object v0

    sput-object v0, Lmain/GameRun_F;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    .line 37
    return-void
.end method

.method public initOffG()V
    .registers 3

    .prologue
    .line 39
    sget v0, Lmain/Constants_H;->WIDTH:I

    add-int/lit8 v0, v0, 0x14

    sget v1, Lmain/Constants_H;->HEIGHT:I

    add-int/lit8 v1, v1, 0x14

    invoke-static {v0, v1}, Ljavax/microedition/lcdui/Image;->createImage(II)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    sput-object v0, Lmain/GameRun_F;->scrT:Ljavax/microedition/lcdui/Image;

    .line 40
    sget-object v0, Lmain/GameRun_F;->scrT:Ljavax/microedition/lcdui/Image;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Image;->getGraphics()Ljavax/microedition/lcdui/Graphics;

    move-result-object v0

    sput-object v0, Lmain/GameRun_F;->offG:Ljavax/microedition/lcdui/Graphics;

    .line 41
    return-void
.end method

.method public initRmsOther()V
    .registers 4

    .prologue
    .line 668
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    .line 669
    const/16 v0, 0xc

    new-array v0, v0, [B

    const/4 v1, 0x0

    .line 670
    const/4 v2, -0x1

    aput-byte v2, v0, v1

    const/4 v1, 0x3

    const/4 v2, 0x1

    aput-byte v2, v0, v1

    .line 669
    iput-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    .line 676
    return-void
.end method

.method public isMyLevel(Z)B
    .registers 7
    .param p1, "bb"    # Z

    .prologue
    const/4 v4, 0x5

    const/4 v3, 0x4

    const/16 v1, 0x67

    const/4 v2, 0x3

    .line 581
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    aget-byte v0, v0, v2

    packed-switch v0, :pswitch_data_54

    .line 626
    :goto_c
    const/4 v0, -0x1

    :goto_d
    return v0

    .line 584
    :pswitch_e
    if-eqz p1, :cond_1c

    iget-object v0, p0, Lmain/GameRun_F;->monInfoList:[B

    aget-byte v0, v0, v1

    if-le v0, v3, :cond_1c

    .line 585
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    const/4 v1, 0x2

    aput-byte v1, v0, v2

    goto :goto_c

    :cond_1c
    move v0, v4

    .line 586
    goto :goto_d

    .line 589
    :pswitch_1e
    if-eqz p1, :cond_2d

    iget-object v0, p0, Lmain/GameRun_F;->monInfoList:[B

    aget-byte v0, v0, v1

    const/16 v1, 0x9

    if-le v0, v1, :cond_2d

    .line 590
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    aput-byte v2, v0, v2

    goto :goto_c

    .line 591
    :cond_2d
    const/16 v0, 0xa

    goto :goto_d

    .line 594
    :pswitch_30
    if-eqz p1, :cond_3f

    iget-object v0, p0, Lmain/GameRun_F;->monInfoList:[B

    aget-byte v0, v0, v1

    const/16 v1, 0xe

    if-le v0, v1, :cond_3f

    .line 595
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    aput-byte v3, v0, v2

    goto :goto_c

    .line 596
    :cond_3f
    const/16 v0, 0xf

    goto :goto_d

    .line 599
    :pswitch_42
    if-eqz p1, :cond_51

    iget-object v0, p0, Lmain/GameRun_F;->monInfoList:[B

    aget-byte v0, v0, v1

    const/16 v1, 0x1d

    if-le v0, v1, :cond_51

    .line 600
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    aput-byte v4, v0, v2

    goto :goto_c

    .line 601
    :cond_51
    const/16 v0, 0x1e

    goto :goto_d

    .line 581
    :pswitch_data_54
    .packed-switch 0x1
        :pswitch_e
        :pswitch_1e
        :pswitch_30
        :pswitch_42
    .end packed-switch
.end method

.method public loadInfoList()V
    .registers 7

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 523
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/4 v2, 0x6

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v5, v3}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun_F;->info:[B

    .line 524
    iget-object v1, p0, Lmain/GameRun_F;->info:[B

    aget-byte v1, v1, v4

    const/4 v2, -0x1

    if-ne v1, v2, :cond_2b

    .line 525
    const/16 v1, 0x69

    new-array v1, v1, [B

    iput-object v1, p0, Lmain/GameRun_F;->monInfoList:[B

    .line 526
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1c
    iget-object v1, p0, Lmain/GameRun_F;->monInfoList:[B

    array-length v1, v1

    if-lt v0, v1, :cond_24

    .line 530
    .end local v0    # "i":I
    :goto_21
    iput-object v5, p0, Lmain/GameRun_F;->info:[B

    .line 531
    return-void

    .line 527
    .restart local v0    # "i":I
    :cond_24
    iget-object v1, p0, Lmain/GameRun_F;->monInfoList:[B

    aput-byte v4, v1, v0

    .line 526
    add-int/lit8 v0, v0, 0x1

    goto :goto_1c

    .line 529
    .end local v0    # "i":I
    :cond_2b
    iget-object v1, p0, Lmain/GameRun_F;->info:[B

    iput-object v1, p0, Lmain/GameRun_F;->monInfoList:[B

    goto :goto_21
.end method

.method public loadItem()V
    .registers 10

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, 0x0

    const/4 v5, 0x4

    .line 644
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3, v5, v6, v8}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v3

    iput-object v3, p0, Lmain/GameRun_F;->info:[B

    .line 646
    new-array v3, v5, [B

    fill-array-data v3, :array_8a

    iput-object v3, p0, Lmain/GameRun_F;->len:[B

    .line 650
    new-array v3, v5, [B

    iput-object v3, p0, Lmain/GameRun_F;->itemsLength:[B

    .line 651
    const/4 v0, 0x0

    .local v0, "i":I
    const/4 v1, 0x0

    .local v1, "j":I
    const/4 v2, 0x0

    .line 652
    .local v2, "k":I
    iget-object v3, p0, Lmain/GameRun_F;->info:[B

    aget-byte v3, v3, v7

    const/4 v4, -0x1

    if-eq v3, v4, :cond_26

    const/4 v0, 0x0

    :goto_24
    if-lt v0, v5, :cond_39

    .line 653
    :cond_26
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B

    array-length v3, v3

    new-array v3, v3, [[[B

    iput-object v3, p0, Lmain/GameRun_F;->items:[[[B

    .line 654
    const/4 v0, 0x0

    const/4 v2, 0x0

    :goto_2f
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B

    array-length v3, v3

    if-lt v0, v3, :cond_44

    .line 661
    iput-object v6, p0, Lmain/GameRun_F;->info:[B

    .line 662
    iput-object v6, p0, Lmain/GameRun_F;->len:[B

    .line 663
    return-void

    .line 652
    :cond_39
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B

    iget-object v4, p0, Lmain/GameRun_F;->info:[B

    aget-byte v4, v4, v0

    aput-byte v4, v3, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_24

    .line 655
    :cond_44
    iget-object v4, p0, Lmain/GameRun_F;->items:[[[B

    iget-object v3, p0, Lmain/GameRun_F;->len:[B

    aget-byte v3, v3, v0

    const/4 v5, 0x2

    filled-new-array {v3, v5}, [I

    move-result-object v3

    sget-object v5, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v5, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [[B

    aput-object v3, v4, v0

    .line 656
    const/4 v1, 0x0

    :goto_5a
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B

    aget-byte v3, v3, v0

    if-lt v1, v3, :cond_63

    .line 654
    add-int/lit8 v0, v0, 0x1

    goto :goto_2f

    .line 657
    :cond_63
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B

    aget-object v3, v3, v0

    aget-object v3, v3, v1

    iget-object v4, p0, Lmain/GameRun_F;->info:[B

    mul-int/lit8 v5, v2, 0x2

    add-int/lit8 v5, v5, 0x4

    aget-byte v4, v4, v5

    aput-byte v4, v3, v7

    .line 658
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B

    aget-object v3, v3, v0

    aget-object v3, v3, v1

    iget-object v4, p0, Lmain/GameRun_F;->info:[B

    mul-int/lit8 v5, v2, 0x2

    add-int/lit8 v5, v5, 0x4

    add-int/lit8 v5, v5, 0x1

    aget-byte v4, v4, v5

    aput-byte v4, v3, v8

    .line 656
    add-int/lit8 v1, v1, 0x1

    add-int/lit8 v2, v2, 0x1

    goto :goto_5a

    .line 646
    :array_8a
    .array-data 1
        0x10t
        0x13t
        0x17t
        0xct
    .end array-data
.end method

.method public loadMon(I[[B)V
    .registers 11
    .param p1, "flag"    # I
    .param p2, "data"    # [[B

    .prologue
    const/4 v7, 0x0

    const/4 v6, -0x1

    .line 484
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    add-int/lit8 v4, p1, 0x8

    const/4 v5, 0x1

    invoke-virtual {v3, v4, v7, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v3

    iput-object v3, p0, Lmain/GameRun_F;->info:[B

    .line 485
    const/4 v2, 0x0

    .line 487
    .local v2, "i":I
    if-nez p1, :cond_56

    .line 488
    const/16 v3, 0x5f

    :try_start_14
    new-array v3, v3, [Ldm/Monster;

    iput-object v3, p0, Lmain/GameRun_F;->cMonsters:[Ldm/Monster;

    .line 489
    iget-object v3, p0, Lmain/GameRun_F;->info:[B

    const/4 v4, 0x0

    aget-byte v3, v3, v4

    if-ne v3, v6, :cond_23

    .line 490
    const/4 v3, 0x0

    iput-byte v3, p0, Lmain/GameRun_F;->cMon_count:B

    .line 518
    :goto_22
    return-void

    .line 493
    :cond_23
    new-instance v0, Ljava/io/ByteArrayInputStream;

    iget-object v3, p0, Lmain/GameRun_F;->info:[B

    invoke-direct {v0, v3}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 494
    .local v0, "byteArray":Ljava/io/ByteArrayInputStream;
    invoke-virtual {v0}, Ljava/io/ByteArrayInputStream;->read()I

    move-result v3

    int-to-byte v3, v3

    iput-byte v3, p0, Lmain/GameRun_F;->cMon_count:B

    .line 495
    :goto_31
    iget-byte v3, p0, Lmain/GameRun_F;->cMon_count:B

    if-lt v2, v3, :cond_43

    .line 512
    :cond_35
    invoke-virtual {v0}, Ljava/io/ByteArrayInputStream;->close()V

    .line 513
    const/4 v0, 0x0

    .line 514
    const/4 v3, 0x0

    iput-object v3, p0, Lmain/GameRun_F;->info:[B
    :try_end_3c
    .catch Ljava/lang/Exception; {:try_start_14 .. :try_end_3c} :catch_3d

    goto :goto_22

    .line 515
    .end local v0    # "byteArray":Ljava/io/ByteArrayInputStream;
    :catch_3d
    move-exception v3

    move-object v1, v3

    .line 516
    .local v1, "ex":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_22

    .line 496
    .end local v1    # "ex":Ljava/lang/Exception;
    .restart local v0    # "byteArray":Ljava/io/ByteArrayInputStream;
    :cond_43
    :try_start_43
    iget-object v3, p0, Lmain/GameRun_F;->cMonsters:[Ldm/Monster;

    new-instance v4, Ldm/Monster;

    invoke-direct {v4}, Ldm/Monster;-><init>()V

    aput-object v4, v3, v2

    .line 497
    iget-object v3, p0, Lmain/GameRun_F;->cMonsters:[Ldm/Monster;

    aget-object v3, v3, v2

    invoke-virtual {p0, v0, v3, p2}, Lmain/GameRun_F;->loadMon(Ljava/io/ByteArrayInputStream;Ldm/Monster;[[B)V

    .line 495
    add-int/lit8 v2, v2, 0x1

    goto :goto_31

    .line 500
    .end local v0    # "byteArray":Ljava/io/ByteArrayInputStream;
    :cond_56
    const/4 v3, 0x5

    new-array v3, v3, [Ldm/Monster;

    iput-object v3, p0, Lmain/GameRun_F;->myMonsters:[Ldm/Monster;

    .line 501
    iget-object v3, p0, Lmain/GameRun_F;->info:[B

    const/4 v4, 0x0

    aget-byte v3, v3, v4

    if-ne v3, v6, :cond_66

    .line 502
    const/4 v3, 0x0

    iput-byte v3, p0, Lmain/GameRun_F;->myMon_length:B

    goto :goto_22

    .line 505
    :cond_66
    new-instance v0, Ljava/io/ByteArrayInputStream;

    iget-object v3, p0, Lmain/GameRun_F;->info:[B

    invoke-direct {v0, v3}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 506
    .restart local v0    # "byteArray":Ljava/io/ByteArrayInputStream;
    invoke-virtual {v0}, Ljava/io/ByteArrayInputStream;->read()I

    move-result v3

    int-to-byte v3, v3

    iput-byte v3, p0, Lmain/GameRun_F;->myMon_length:B

    .line 507
    :goto_74
    iget-byte v3, p0, Lmain/GameRun_F;->myMon_length:B

    if-ge v2, v3, :cond_35

    .line 508
    iget-object v3, p0, Lmain/GameRun_F;->myMonsters:[Ldm/Monster;

    new-instance v4, Ldm/Monster;

    invoke-direct {v4}, Ldm/Monster;-><init>()V

    aput-object v4, v3, v2

    .line 509
    iget-object v3, p0, Lmain/GameRun_F;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v2

    invoke-virtual {p0, v0, v3, p2}, Lmain/GameRun_F;->loadMon(Ljava/io/ByteArrayInputStream;Ldm/Monster;[[B)V
    :try_end_88
    .catch Ljava/lang/Exception; {:try_start_43 .. :try_end_88} :catch_3d

    .line 507
    add-int/lit8 v2, v2, 0x1

    goto :goto_74
.end method

.method public loadMon(Ljava/io/ByteArrayInputStream;Ldm/Monster;[[B)V
    .registers 9
    .param p1, "byteArray"    # Ljava/io/ByteArrayInputStream;
    .param p2, "mon"    # Ldm/Monster;
    .param p3, "data"    # [[B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 450
    const/16 v1, 0x12

    new-array v1, v1, [B

    iput-object v1, p2, Ldm/Monster;->monster:[B

    .line 451
    const/16 v1, 0x8

    new-array v1, v1, [S

    iput-object v1, p2, Ldm/Monster;->monsterPro:[S

    .line 452
    iget-object v1, p2, Ldm/Monster;->monster:[B

    invoke-virtual {p1, v1}, Ljava/io/ByteArrayInputStream;->read([B)I

    .line 453
    const/16 v1, 0xa

    new-array v1, v1, [B

    iput-object v1, p0, Lmain/GameRun_F;->len:[B

    .line 454
    iget-object v1, p0, Lmain/GameRun_F;->len:[B

    invoke-virtual {p1, v1}, Ljava/io/ByteArrayInputStream;->read([B)I

    .line 455
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1d
    const/4 v1, 0x5

    if-lt v0, v1, :cond_2e

    .line 457
    iget-object v1, p2, Ldm/Monster;->monster:[B

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    aget-object v1, p3, v1

    invoke-virtual {p2, v1}, Ldm/Monster;->setProAFD([B)V

    .line 458
    const/4 v1, 0x0

    iput-object v1, p0, Lmain/GameRun_F;->len:[B

    .line 459
    return-void

    .line 456
    :cond_2e
    iget-object v1, p2, Ldm/Monster;->monsterPro:[S

    iget-object v2, p0, Lmain/GameRun_F;->len:[B

    mul-int/lit8 v3, v0, 0x2

    add-int/lit8 v3, v3, 0x1

    aget-byte v2, v2, v3

    and-int/lit16 v2, v2, 0xff

    shl-int/lit8 v2, v2, 0x8

    iget-object v3, p0, Lmain/GameRun_F;->len:[B

    mul-int/lit8 v4, v0, 0x2

    add-int/lit8 v4, v4, 0x0

    aget-byte v3, v3, v4

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v1, v0

    .line 455
    add-int/lit8 v0, v0, 0x1

    goto :goto_1d
.end method

.method public loadRmsNidus()V
    .registers 8

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x3

    const/4 v4, 0x0

    const/4 v3, -0x2

    const/16 v2, 0xa

    .line 698
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v5, v6, v1}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B

    .line 699
    iget-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B

    aget-byte v0, v0, v4

    const/4 v1, -0x1

    if-ne v0, v1, :cond_54

    .line 700
    iput-object v6, p0, Lmain/GameRun_F;->rmsNidus:[B

    .line 701
    const/16 v0, 0x19

    new-array v0, v0, [B

    .line 702
    aput-byte v3, v0, v4

    aput-byte v2, v0, v5

    const/4 v1, 0x4

    aput-byte v2, v0, v1

    const/4 v1, 0x5

    .line 703
    aput-byte v3, v0, v1

    const/16 v1, 0x8

    aput-byte v2, v0, v1

    const/16 v1, 0x9

    aput-byte v2, v0, v1

    .line 704
    aput-byte v3, v0, v2

    const/16 v1, 0xd

    aput-byte v2, v0, v1

    const/16 v1, 0xe

    aput-byte v2, v0, v1

    const/16 v1, 0xf

    .line 705
    aput-byte v3, v0, v1

    const/16 v1, 0x12

    aput-byte v2, v0, v1

    const/16 v1, 0x13

    aput-byte v2, v0, v1

    const/16 v1, 0x14

    .line 706
    aput-byte v3, v0, v1

    const/16 v1, 0x17

    aput-byte v2, v0, v1

    const/16 v1, 0x18

    aput-byte v2, v0, v1

    .line 701
    iput-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B

    .line 709
    :cond_54
    return-void
.end method

.method public loadRmsOther()V
    .registers 6

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 533
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/16 v1, 0xa

    invoke-virtual {v0, v1, v4, v3}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun_F;->info:[B

    .line 534
    iget-object v0, p0, Lmain/GameRun_F;->info:[B

    aget-byte v0, v0, v2

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1f

    .line 535
    invoke-virtual {p0, v3}, Lmain/GameRun_F;->setMaxTakes(Z)V

    .line 536
    invoke-virtual {p0}, Lmain/GameRun_F;->initRmsOther()V

    .line 541
    :goto_1c
    iput-object v4, p0, Lmain/GameRun_F;->info:[B

    .line 542
    return-void

    .line 538
    :cond_1f
    iget-object v0, p0, Lmain/GameRun_F;->info:[B

    iput-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    .line 539
    invoke-virtual {p0, v2}, Lmain/GameRun_F;->setMaxTakes(Z)V

    goto :goto_1c
.end method

.method public loadRmsSms()V
    .registers 6

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 679
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x5

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v4, v2}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun_F;->rmsSms:[B

    .line 680
    iget-object v0, p0, Lmain/GameRun_F;->rmsSms:[B

    if-eqz v0, :cond_19

    iget-object v0, p0, Lmain/GameRun_F;->rmsSms:[B

    aget-byte v0, v0, v3

    const/4 v1, -0x1

    if-ne v0, v1, :cond_20

    .line 681
    :cond_19
    iput-object v4, p0, Lmain/GameRun_F;->rmsSms:[B

    .line 684
    const/4 v0, 0x7

    new-array v0, v0, [B

    iput-object v0, p0, Lmain/GameRun_F;->rmsSms:[B

    .line 690
    :cond_20
    iget-object v0, p0, Lmain/GameRun_F;->rmsSms:[B

    aget-byte v0, v0, v3

    const/16 v1, 0xa

    if-ne v0, v1, :cond_32

    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    const/4 v1, 0x2

    aget-byte v2, v0, v1

    or-int/lit8 v2, v2, 0x8

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 694
    :cond_32
    return-void
.end method

.method public saveInfoList()V
    .registers 5

    .prologue
    .line 520
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x6

    iget-object v2, p0, Lmain/GameRun_F;->monInfoList:[B

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 521
    return-void
.end method

.method public saveItem()V
    .registers 9

    .prologue
    const/4 v7, 0x4

    .line 629
    const/4 v2, 0x0

    .line 630
    .local v2, "len":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_3
    if-lt v0, v7, :cond_27

    .line 631
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B

    array-length v3, v3

    mul-int/lit8 v4, v2, 0x2

    add-int/2addr v3, v4

    new-array v3, v3, [B

    iput-object v3, p0, Lmain/GameRun_F;->info:[B

    .line 632
    const/4 v2, 0x0

    .line 633
    const/4 v0, 0x0

    :goto_11
    if-lt v0, v7, :cond_2f

    .line 634
    const/4 v0, 0x0

    :goto_14
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B

    array-length v3, v3

    if-lt v0, v3, :cond_3a

    .line 639
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun_F;->info:[B

    const/4 v5, 0x2

    invoke-virtual {v3, v7, v4, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 640
    const/4 v3, 0x0

    iput-object v3, p0, Lmain/GameRun_F;->info:[B

    .line 641
    return-void

    .line 630
    :cond_27
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B

    aget-byte v3, v3, v0

    add-int/2addr v2, v3

    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 633
    :cond_2f
    iget-object v3, p0, Lmain/GameRun_F;->info:[B

    iget-object v4, p0, Lmain/GameRun_F;->itemsLength:[B

    aget-byte v4, v4, v0

    aput-byte v4, v3, v0

    add-int/lit8 v0, v0, 0x1

    goto :goto_11

    .line 635
    :cond_3a
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_3b
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B

    aget-byte v3, v3, v0

    if-lt v1, v3, :cond_44

    .line 634
    add-int/lit8 v0, v0, 0x1

    goto :goto_14

    .line 636
    :cond_44
    iget-object v3, p0, Lmain/GameRun_F;->info:[B

    mul-int/lit8 v4, v2, 0x2

    add-int/lit8 v4, v4, 0x4

    iget-object v5, p0, Lmain/GameRun_F;->items:[[[B

    aget-object v5, v5, v0

    aget-object v5, v5, v1

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    aput-byte v5, v3, v4

    .line 637
    iget-object v3, p0, Lmain/GameRun_F;->info:[B

    mul-int/lit8 v4, v2, 0x2

    add-int/lit8 v4, v4, 0x4

    add-int/lit8 v4, v4, 0x1

    iget-object v5, p0, Lmain/GameRun_F;->items:[[[B

    aget-object v5, v5, v0

    aget-object v5, v5, v1

    const/4 v6, 0x1

    aget-byte v5, v5, v6

    aput-byte v5, v3, v4

    .line 635
    add-int/lit8 v1, v1, 0x1

    add-int/lit8 v2, v2, 0x1

    goto :goto_3b
.end method

.method public saveMon(I)V
    .registers 9
    .param p1, "flag"    # I

    .prologue
    .line 462
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 463
    .local v0, "byteArray":Ljava/io/ByteArrayOutputStream;
    const/4 v2, 0x0

    .line 465
    .local v2, "i":I
    if-nez p1, :cond_2e

    .line 466
    :try_start_8
    iget-byte v3, p0, Lmain/GameRun_F;->cMon_count:B

    invoke-virtual {v0, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 467
    :goto_d
    iget-byte v3, p0, Lmain/GameRun_F;->cMon_count:B

    if-lt v2, v3, :cond_24

    .line 469
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    const/16 v4, 0x8

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v5

    const/4 v6, 0x2

    invoke-virtual {v3, v4, v5, v6}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 476
    :goto_1f
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 477
    const/4 v0, 0x0

    .line 481
    :goto_23
    return-void

    .line 468
    :cond_24
    iget-object v3, p0, Lmain/GameRun_F;->cMonsters:[Ldm/Monster;

    aget-object v3, v3, v2

    invoke-virtual {p0, v0, v3}, Lmain/GameRun_F;->saveMon(Ljava/io/ByteArrayOutputStream;Ldm/Monster;)V

    .line 467
    add-int/lit8 v2, v2, 0x1

    goto :goto_d

    .line 471
    :cond_2e
    iget-byte v3, p0, Lmain/GameRun_F;->myMon_length:B

    invoke-virtual {v0, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 472
    :goto_33
    iget-byte v3, p0, Lmain/GameRun_F;->myMon_length:B

    if-lt v2, v3, :cond_4c

    .line 474
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    const/16 v4, 0x9

    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v5

    const/4 v6, 0x2

    invoke-virtual {v3, v4, v5, v6}, Ldm/Ms;->rmsOptions(I[BI)[B
    :try_end_45
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_45} :catch_46

    goto :goto_1f

    .line 478
    :catch_46
    move-exception v3

    move-object v1, v3

    .line 479
    .local v1, "ex":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_23

    .line 473
    .end local v1    # "ex":Ljava/lang/Exception;
    :cond_4c
    :try_start_4c
    iget-object v3, p0, Lmain/GameRun_F;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v2

    invoke-virtual {p0, v0, v3}, Lmain/GameRun_F;->saveMon(Ljava/io/ByteArrayOutputStream;Ldm/Monster;)V
    :try_end_53
    .catch Ljava/lang/Exception; {:try_start_4c .. :try_end_53} :catch_46

    .line 472
    add-int/lit8 v2, v2, 0x1

    goto :goto_33
.end method

.method public saveMon(Ljava/io/ByteArrayOutputStream;Ldm/Monster;)V
    .registers 6
    .param p1, "byteArray"    # Ljava/io/ByteArrayOutputStream;
    .param p2, "mon"    # Ldm/Monster;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 440
    iget-object v2, p2, Ldm/Monster;->monster:[B

    invoke-virtual {p1, v2}, Ljava/io/ByteArrayOutputStream;->write([B)V

    .line 441
    const/4 v1, 0x0

    .local v1, "xxx":I
    const/4 v0, 0x0

    .line 442
    .local v0, "i":I
    :goto_7
    const/4 v2, 0x5

    if-lt v0, v2, :cond_b

    .line 448
    return-void

    .line 443
    :cond_b
    iget-object v2, p2, Ldm/Monster;->monsterPro:[S

    aget-short v1, v2, v0

    .line 444
    and-int/lit16 v2, v1, 0xff

    int-to-byte v2, v2

    invoke-virtual {p1, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 445
    shr-int/lit8 v2, v1, 0x8

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    invoke-virtual {p1, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 442
    add-int/lit8 v0, v0, 0x1

    goto :goto_7
.end method

.method public setAction_str([Ljava/lang/String;)V
    .registers 2
    .param p1, "temp_str"    # [Ljava/lang/String;

    .prologue
    .line 273
    iput-object p1, p0, Lmain/GameRun_F;->action_str:[Ljava/lang/String;

    .line 274
    const/4 p1, 0x0

    check-cast p1, [Ljava/lang/String;

    .line 275
    return-void
.end method

.method public setGogoWord()V
    .registers 6

    .prologue
    .line 107
    sget v1, Lmain/Constants_H;->WIDTH:I

    iput v1, p0, Lmain/GameRun_F;->introT:I

    .line 108
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v1, 0x0

    sput v1, Ldm/Ms;->skip:I

    .line 109
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    const-string v3, "data/other/hint.t"

    const/4 v4, -0x1

    invoke-virtual {v2, v3, v4}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v0

    .line 110
    .local v0, "sr":[Ljava/lang/StringBuffer;
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    array-length v1, v0

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    aget-object v1, v0, v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun_F;->gogoST:Ljava/lang/String;

    .line 111
    const/4 v0, 0x0

    check-cast v0, [Ljava/lang/StringBuffer;

    .line 112
    return-void
.end method

.method public setMaxTakes(Z)V
    .registers 7
    .param p1, "bb"    # Z

    .prologue
    const/4 v4, 0x4

    const/4 v3, 0x5

    const/4 v2, 0x3

    .line 544
    if-eqz p1, :cond_c

    .line 545
    iput-byte v2, p0, Lmain/GameRun_F;->max_takes:B

    .line 546
    const/16 v0, 0xa

    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B

    .line 578
    :cond_b
    :goto_b
    return-void

    .line 549
    :cond_c
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    aget-byte v0, v0, v2

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1a

    .line 550
    iput-byte v4, p0, Lmain/GameRun_F;->max_takes:B

    .line 551
    const/16 v0, 0x14

    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B

    goto :goto_b

    .line 552
    :cond_1a
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    aget-byte v0, v0, v2

    if-ne v0, v2, :cond_27

    .line 553
    iput-byte v3, p0, Lmain/GameRun_F;->max_takes:B

    .line 554
    const/16 v0, 0x28

    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B

    goto :goto_b

    .line 555
    :cond_27
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    aget-byte v0, v0, v2

    if-ne v0, v4, :cond_34

    .line 556
    iput-byte v3, p0, Lmain/GameRun_F;->max_takes:B

    .line 557
    const/16 v0, 0x50

    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B

    goto :goto_b

    .line 558
    :cond_34
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B

    aget-byte v0, v0, v2

    if-ne v0, v3, :cond_b

    .line 559
    iput-byte v3, p0, Lmain/GameRun_F;->max_takes:B

    .line 560
    const/16 v0, 0x5f

    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B

    goto :goto_b
.end method

.method public setNidusExp(I)V
    .registers 9
    .param p1, "exp"    # I

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x1

    .line 729
    div-int/lit8 v1, p1, 0xa

    if-ge v1, v5, :cond_c

    move p1, v5

    .line 730
    :goto_7
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_8
    const/4 v1, 0x5

    if-lt v0, v1, :cond_10

    .line 735
    return-void

    .line 729
    .end local v0    # "i":B
    :cond_c
    div-int/lit8 v1, p1, 0xa

    move p1, v1

    goto :goto_7

    .line 731
    .restart local v0    # "i":B
    :cond_10
    invoke-virtual {p0, v0}, Lmain/GameRun_F;->getRid(I)B

    move-result v1

    const/4 v2, -0x2

    if-ne v1, v2, :cond_1b

    .line 730
    :cond_17
    :goto_17
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_8

    .line 732
    :cond_1b
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {p0, v0, v5}, Lmain/GameRun_F;->getNexp(II)S

    move-result v2

    add-int/2addr v2, p1

    iget-object v3, p0, Lmain/GameRun_F;->rmsNidus:[B

    mul-int/lit8 v4, v0, 0x5

    add-int/lit8 v4, v4, 0x1

    invoke-virtual {v1, v2, v3, v4}, Ldm/Ms;->putShort(I[BI)V

    .line 733
    invoke-virtual {p0, v0, v5}, Lmain/GameRun_F;->getNexp(II)S

    move-result v1

    invoke-virtual {p0, v0, v6}, Lmain/GameRun_F;->getNexp(II)S

    move-result v2

    if-le v1, v2, :cond_17

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {p0, v0, v6}, Lmain/GameRun_F;->getNexp(II)S

    move-result v2

    iget-object v3, p0, Lmain/GameRun_F;->rmsNidus:[B

    mul-int/lit8 v4, v0, 0x5

    add-int/lit8 v4, v4, 0x1

    invoke-virtual {v1, v2, v3, v4}, Ldm/Ms;->putShort(I[BI)V

    goto :goto_17
.end method

.method public setPauseS(I)V
    .registers 9
    .param p1, "mode"    # I

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 351
    if-nez p1, :cond_27

    .line 352
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "\u4fdd\u5b58\u6e38\u620f"

    aput-object v1, v0, v2

    const-string v1, "\u67e5\u770b\u5ba0\u7269"

    aput-object v1, v0, v3

    const-string v1, "\u4eba\u7269\u80cc\u5305"

    aput-object v1, v0, v4

    const-string v1, "\u5ba0\u7269\u56fe\u9274"

    aput-object v1, v0, v5

    const-string v1, "\u67e5\u770b\u4efb\u52a1"

    aput-object v1, v0, v6

    const/4 v1, 0x5

    const-string v2, "\u8fd4\u56de\u6e38\u620f"

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lmain/GameRun_F;->setAction_str([Ljava/lang/String;)V

    .line 355
    :goto_26
    return-void

    .line 354
    :cond_27
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "\u8bfb\u53d6\u8fdb\u5ea6"

    aput-object v1, v0, v2

    const-string v1, "\u58f0\u97f3"

    aput-object v1, v0, v3

    const-string v1, "\u6e38\u620f\u5e2e\u52a9"

    aput-object v1, v0, v4

    const-string v1, "\u56de\u4e3b\u83dc\u5355"

    aput-object v1, v0, v5

    invoke-virtual {p0, v0}, Lmain/GameRun_F;->setAction_str([Ljava/lang/String;)V

    goto :goto_26
.end method

.method public setStringB(Ljava/lang/String;II)V
    .registers 5
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "w"    # I
    .param p3, "mode"    # I

    .prologue
    .line 47
    if-nez p3, :cond_d

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun_F;->about_a:[Ljava/lang/StringBuffer;

    .line 51
    :cond_c
    :goto_c
    return-void

    .line 48
    :cond_d
    const/4 v0, 0x1

    if-ne p3, v0, :cond_1b

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun_F;->about_b:[Ljava/lang/StringBuffer;

    goto :goto_c

    .line 49
    :cond_1b
    const/4 v0, 0x2

    if-ne p3, v0, :cond_29

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun_F;->about_c:[Ljava/lang/StringBuffer;

    goto :goto_c

    .line 50
    :cond_29
    const/4 v0, 0x3

    if-ne p3, v0, :cond_c

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun_F;->about_d:[Ljava/lang/StringBuffer;

    goto :goto_c
.end method

.method public showString(Ljava/lang/String;II)V
    .registers 15
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "y"    # I
    .param p3, "offx"    # I

    .prologue
    .line 138
    const/16 v8, 0x280

    .local v8, "WIDTH":I
    const/16 v6, 0x168

    .line 139
    .local v6, "HEIGHT":I
    const/16 v9, 0x140

    .local v9, "WIDTH_H":I
    const/16 v7, 0xb4

    .line 141
    .local v7, "HEIGHT_H":I
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    div-int/lit8 v0, v0, 0xb

    int-to-byte v10, v0

    .line 144
    .local v10, "strNum":B
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p3, -0x5

    add-int/lit8 v3, v8, 0xa

    add-int/lit8 v2, v10, 0x1

    mul-int/lit8 v2, v2, 0x19

    add-int/lit8 v4, v2, 0x8

    const/4 v5, 0x3

    move v2, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK0(IIIII)V

    .line 145
    add-int v2, v9, p3

    add-int/lit8 v3, p2, 0x3

    const/16 v4, 0xb

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v5}, Lmain/GameRun_F;->showStringM(Ljava/lang/String;IIII)V

    .line 146
    return-void
.end method

.method public showString([Ljava/lang/StringBuffer;III)V
    .registers 23
    .param p1, "showS"    # [Ljava/lang/StringBuffer;
    .param p2, "y"    # I
    .param p3, "offx"    # I
    .param p4, "mode"    # I

    .prologue
    .line 125
    sget v15, Lmain/Constants_H;->WIDTH__:I

    .local v15, "WIDTH":I
    const/16 v13, 0x168

    .line 126
    .local v13, "HEIGHT":I
    sget v5, Lmain/Constants_H;->WIDTH__:I

    div-int/lit8 v16, v5, 0x2

    .local v16, "WIDTH_H":I
    const/16 v14, 0xb4

    .line 127
    .local v14, "HEIGHT_H":I
    const/16 v12, 0x19

    .local v12, "FONT_W":I
    const/16 v11, 0x19

    .line 128
    .local v11, "FONT_H":I
    add-int/lit8 p2, p2, 0x5

    .line 130
    if-eqz p4, :cond_42

    .line 131
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    add-int/lit8 v6, p3, -0x5

    add-int/lit8 v7, v15, 0xa

    move-object/from16 v0, p1

    array-length v0, v0

    move v8, v0

    mul-int/2addr v8, v11

    add-int/lit8 v8, v8, 0xc

    move-object v0, v5

    move v1, v6

    move/from16 v2, p2

    move v3, v7

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawKuang(IIII)V

    .line 132
    const/4 v5, 0x2

    move/from16 v0, p4

    move v1, v5

    if-ne v0, v1, :cond_42

    add-int v5, v16, p3

    move-object/from16 v0, p1

    array-length v0, v0

    move v6, v0

    mul-int/2addr v6, v11

    add-int v6, v6, p2

    add-int/lit8 v6, v6, 0x4

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    invoke-direct {v0, v1, v2}, Lmain/GameRun_F;->drawSnare5(II)V

    .line 134
    :cond_42
    const/16 v17, 0x0

    .local v17, "d":B
    :goto_44
    move-object/from16 v0, p1

    array-length v0, v0

    move v5, v0

    move/from16 v0, v17

    move v1, v5

    if-lt v0, v1, :cond_4e

    .line 136
    return-void

    .line 135
    :cond_4e
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    aget-object v6, p1, v17

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    add-int v7, v12, p3

    add-int/lit8 v8, p2, 0x4

    mul-int v9, v17, v11

    add-int/2addr v8, v9

    const/4 v9, -0x1

    const/4 v10, 0x1

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V

    .line 134
    add-int/lit8 v5, v17, 0x1

    move v0, v5

    int-to-byte v0, v0

    move/from16 v17, v0

    goto :goto_44
.end method

.method public showStringM(Ljava/lang/String;IIII)V
    .registers 15
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "num"    # I
    .param p5, "c"    # I

    .prologue
    .line 148
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    div-int/2addr v0, p4

    int-to-byte v8, v0

    .line 149
    .local v8, "strNum":B
    const/4 v7, 0x0

    .local v7, "d":B
    :goto_7
    if-le v7, v8, :cond_a

    .line 157
    return-void

    .line 150
    :cond_a
    if-nez v8, :cond_26

    .line 151
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x1

    or-int/lit8 v4, v1, 0x10

    const/4 v6, 0x1

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v5, p5

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 152
    const-string v0, "sk"

    const-string v1, "strNum == 0"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 149
    :goto_22
    add-int/lit8 v0, v7, 0x1

    int-to-byte v7, v0

    goto :goto_7

    .line 154
    :cond_26
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    mul-int v1, v7, p4

    add-int/lit8 v2, v7, 0x1

    if-le v2, v8, :cond_4d

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    :goto_34
    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 155
    mul-int/lit8 v2, v7, 0x19

    add-int v3, p3, v2

    const/4 v2, 0x1

    or-int/lit8 v4, v2, 0x10

    const/4 v6, 0x0

    move v2, p2

    move v5, p5

    .line 154
    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 156
    const-string v0, "sk"

    const-string v1, "else"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_22

    .line 154
    :cond_4d
    add-int/lit8 v2, v7, 0x1

    mul-int/2addr v2, p4

    goto :goto_34
.end method

.method public showStringM_(Ljava/lang/String;IIII)V
    .registers 16
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "num"    # I
    .param p5, "c"    # I

    .prologue
    .line 159
    const/16 v7, 0x19

    .line 160
    .local v7, "FONT_H":I
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    div-int/2addr v0, p4

    int-to-byte v9, v0

    .line 161
    .local v9, "strNum":B
    const/4 v8, 0x0

    .local v8, "d":B
    :goto_9
    if-le v8, v9, :cond_c

    .line 169
    return-void

    .line 162
    :cond_c
    if-nez v9, :cond_28

    .line 163
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x1

    or-int/lit8 v4, v1, 0x10

    const/4 v6, 0x1

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v5, p5

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 164
    const-string v0, "sk"

    const-string v1, "strNum == 0"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 161
    :goto_24
    add-int/lit8 v0, v8, 0x1

    int-to-byte v8, v0

    goto :goto_9

    .line 167
    :cond_28
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    mul-int v1, v8, p4

    add-int/lit8 v2, v8, 0x1

    if-le v2, v9, :cond_48

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    :goto_36
    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 168
    mul-int v2, v8, v7

    add-int v3, p3, v2

    const/4 v2, 0x1

    or-int/lit8 v4, v2, 0x10

    const/4 v6, 0x0

    move v2, p2

    move v5, p5

    .line 167
    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto :goto_24

    :cond_48
    add-int/lit8 v2, v8, 0x1

    mul-int/2addr v2, p4

    goto :goto_36
.end method
