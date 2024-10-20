.class public Lmain/GameRun_F;
.super Ljava/lang/Object;
.implements Lmain/Key_H;
.source "GameRun_F.java"

.field static dg:Lcom/nokia/mid/ui/DirectGraphics;

.field static g:Ljavax/microedition/lcdui/Graphics;

.field public static mc:Lmain/MainCanvas;

.field static offG:Ljavax/microedition/lcdui/Graphics;

.field public static run_state:I

.field static scrT:Ljavax/microedition/lcdui/Image;

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

.method static constructor <clinit>()V
  .registers 1
  .prologue
  .line 29
    const/4 v0, 1
    sput v0, Lmain/GameRun_F;->run_state:I
  .line 23
    return-void
.end method

.method public constructor <init>()V
  .registers 8
  .prologue
    const/16 v1, 8
    const/4 v6, 3
    const/4 v5, 0
    const/4 v4, 2
    const/4 v3, 4
  .line 23
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 42
    new-array v0, v1, [B
    fill-array-data v0, :L0
    iput-object v0, p0, Lmain/GameRun_F;->anchor:[B
  .line 43
    new-array v0, v1, [S
    const/4 v1, 1
    const/16 v2, 90
    aput-short v2, v0, v1
    const/16 v1, 180
    aput-short v1, v0, v4
    const/16 v1, 270
    aput-short v1, v0, v6
    const/16 v1, 8192
    aput-short v1, v0, v3
    const/4 v1, 5
    const/16 v2, 8282
    aput-short v2, v0, v1
    const/4 v1, 6
    const/16 v2, 8372
    aput-short v2, v0, v1
    const/4 v1, 7
    const/16 v2, 8462
    aput-short v2, v0, v1
    iput-object v0, p0, Lmain/GameRun_F;->transB:[S
  .line 77
    sget v0, Lmain/Constants_H;->WIDTH_H:I
    iput v0, p0, Lmain/GameRun_F;->introX:I
  .line 78
    const-string v0, ""
    iput-object v0, p0, Lmain/GameRun_F;->gogoString:Ljava/lang/String;
  .line 92
    const/16 v0, 640
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
    const/4 v0, -1
    iput-byte v0, p0, Lmain/GameRun_F;->popMenu:B
  .line 280
    new-array v0, v3, [B
    iput-object v0, p0, Lmain/GameRun_F;->select_it:[B
  .line 281
    new-array v0, v3, [B
    iput-object v0, p0, Lmain/GameRun_F;->select_st:[B
  .line 282
    filled-new-array { v3, v4 }, [I
    move-result-object v0
    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;
    invoke-static { v1, v0 }, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [[B
    iput-object v0, p0, Lmain/GameRun_F;->selectBag:[[B
  .line 283
    filled-new-array { v4, v4 }, [I
    move-result-object v0
    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;
    invoke-static { v1, v0 }, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [[B
    iput-object v0, p0, Lmain/GameRun_F;->select:[[B
  .line 427
    iput-byte v6, p0, Lmain/GameRun_F;->max_takes:B
  .line 428
    const/16 v0, 10
    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B
  .line 23
    return-void
  .line 42
  :L0
  .array-data 1
    20t
    36t
    40t
    24t
    24t
    40t
    36t
    20t
  .end array-data
.end method

.method private drawSnare5(II)V
  .parameter "x" # I
  .parameter "y" # I
  .registers 9
  .prologue
    const/4 v4, 0
  .line 116
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const/16 v1, 8
    iget-byte v2, p0, Lmain/GameRun_F;->brow5:B
    rem-int/lit8 v2, v2, 3
    if-nez v2, :L2
    const/4 v2, 1
  :L0
    add-int v3, p2, v2
    move v2, p1
    move v5, v4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawUi(IIIII)V
  .line 120
    iget-byte v0, p0, Lmain/GameRun_F;->brow5:B
    add-int/lit8 v1, v0, 1
    int-to-byte v1, v1
    iput-byte v1, p0, Lmain/GameRun_F;->brow5:B
    const/16 v1, 100
    if-le v0, v1, :L1
    iput-byte v4, p0, Lmain/GameRun_F;->brow5:B
  :L1
  .line 121
    return-void
  :L2
    move v2, v4
  .line 116
    goto :L0
.end method

.method public addNidus(I)Z
  .parameter "id" # I
  .registers 7
  .prologue
    const/4 v4, 0
  .line 717
    const/4 v0, 0
  :L0
  .local v0, "i":B
    iget-object v1, p0, Lmain/GameRun_F;->rmsNidus:[B
    array-length v1, v1
    if-lt v0, v1, :L2
    move v1, v4
  :L1
  .line 725
    return v1
  :L2
  .line 718
    iget-object v1, p0, Lmain/GameRun_F;->rmsNidus:[B
    aget-byte v1, v1, v0
    const/4 v2, -2
    if-eq v1, v2, :L3
  .line 717
    add-int/lit8 v1, v0, 5
    int-to-byte v0, v1
    goto :L0
  :L3
  .line 719
    iget-object v1, p0, Lmain/GameRun_F;->rmsNidus:[B
    int-to-byte v2, p1
    aput-byte v2, v1, v0
  .line 721
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    iget-object v2, p0, Lmain/GameRun_F;->rmsNidus:[B
    add-int/lit8 v3, v0, 1
    invoke-virtual { v1, v4, v2, v3 }, Ldm/Ms;->putShort(I[BI)V
  .line 722
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const/16 v2, 200
    iget-object v3, p0, Lmain/GameRun_F;->rmsNidus:[B
    add-int/lit8 v4, v0, 3
    invoke-virtual { v1, v2, v3, v4 }, Ldm/Ms;->putShort(I[BI)V
  .line 723
    const/4 v1, 1
    goto :L1
.end method

.method public createData(I)[B
  .parameter "no" # I
  .registers 4
  .prologue
  .line 265
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    const-string v1, "4"
    invoke-virtual { v0, v1, p1 }, Ldm/Ms;->getStream(Ljava/lang/String;I)[B
    move-result-object v0
    return-object v0
.end method

.method public createString(Ljava/lang/String;)Ljava/lang/String;
  .parameter "name" # Ljava/lang/String;
  .registers 7
  .prologue
    const/4 v4, 0
  .line 260
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    sput v4, Ldm/Ms;->skip:I
  .line 261
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v2
    const/4 v3, -1
    invoke-virtual { v2, p1, v3 }, Ldm/Ms;->getStream(Ljava/lang/String;I)[B
    move-result-object v2
    invoke-virtual { v1, v2 }, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;
    move-result-object v0
  .line 262
  .local v0, "str":[Ljava/lang/StringBuffer;
    aget-object v1, v0, v4
    invoke-virtual { v1 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public delNidus(I)V
  .parameter "i" # I
  .registers 5
  .prologue
  .line 727
    iget-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B
    mul-int/lit8 v1, p1, 5
    const/4 v2, -2
    aput-byte v2, v0, v1
    return-void
.end method

.method public drawHelpStr(Ljavax/microedition/lcdui/Graphics;[Ljava/lang/StringBuffer;IIII)V
  .parameter "g" # Ljavax/microedition/lcdui/Graphics;
  .parameter "help_strbuff" # [Ljava/lang/StringBuffer;
  .parameter "line_num" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "anchor" # I
  .registers 16
  .prologue
  .line 199
    iget-byte v0, p0, Lmain/GameRun_F;->help_page:B
    mul-int/2addr v0, p3
    int-to-byte v8, v0
  .line 201
  .local v8, "line_start":B
    move v7, v8
  :L0
  .local v7, "i":B
    add-int v0, v8, p3
    if-ge v7, v0, :L1
    array-length v0, p2
    if-lt v7, v0, :L4
  :L1
  .line 203
    array-length v0, p2
    if-le v0, p3, :L6
  .line 204
    array-length v0, p2
    div-int/2addr v0, p3
    array-length v1, p2
    rem-int/2addr v1, p3
    if-eqz v1, :L5
    const/4 v1, 1
  :L2
    add-int/2addr v0, v1
    int-to-byte v0, v0
    iput-byte v0, p0, Lmain/GameRun_F;->page_max:B
  .line 205
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    iget-byte v2, p0, Lmain/GameRun_F;->help_page:B
    add-int/lit8 v2, v2, 1
    invoke-static { v2 }, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v2
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v2, "/"
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-byte v2, p0, Lmain/GameRun_F;->page_max:B
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    sget v2, Lmain/Constants_H;->WIDTH_H:I
    sget v3, Lmain/Constants_H;->HEIGHT:I
    const/4 v4, 2
    sub-int/2addr v3, v4
    const/4 v4, 1
    or-int/lit8 v4, v4, 32
    const/4 v5, 3
    const/4 v6, 0
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 206
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    sget v1, Lmain/Constants_H;->WIDTH_H:I
    sget v2, Lmain/Constants_H;->HEIGHT:I
    const/16 v3, 12
    sub-int/2addr v2, v3
    const/16 v3, 75
    const/4 v4, 1
    const/4 v5, 1
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawTriangle(IIIZZ)V
  :L3
  .line 208
    return-void
  :L4
  .line 202
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    aget-object v1, p2, v7
    invoke-virtual { v1 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v1
    sub-int v2, v7, v8
    mul-int/lit8 v2, v2, 27
    add-int v3, p5, v2
    const/4 v5, 3
    const/4 v6, 0
    move v2, p4
    move v4, p6
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 201
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L0
  :L5
  .line 204
    const/4 v1, 0
    goto :L2
  :L6
  .line 207
    const/4 v0, 1
    iput-byte v0, p0, Lmain/GameRun_F;->page_max:B
    goto :L3
.end method

.method public drawMenu([Ljava/lang/StringBuffer;III)V
  .parameter "menu" # [Ljava/lang/StringBuffer;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .registers 13
  .prologue
  .line 293
    const/16 v5, 10
  .line 294
  .local v5, "color":B
    if-lez p4, :L2
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    array-length v1, p1
    mul-int/lit8 v1, v1, 27
    add-int/lit8 v1, v1, 12
    invoke-virtual { v0, p2, p3, p4, v1 }, Ldm/Ui;->drawKuang(IIII)V
  :L0
  .line 297
    const/4 v7, 0
  :L1
  .local v7, "d":B
    array-length v0, p1
    if-lt v7, v0, :L3
  .line 304
    return-void
  :L2
  .line 295
  .end local v7
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    invoke-static { p4 }, Ldm/Ms;->abs(I)I
    move-result p4
    goto :L0
  :L3
  .line 298
  .restart local v7
    if-nez v7, :L5
    const/16 v5, 9
  :L4
  .line 301
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    aget-object v1, p1, v7
    invoke-virtual { v1 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v1
    shr-int/lit8 v2, p4, 1
    add-int/2addr v2, p2
    add-int/lit8 v3, p3, 4
    mul-int/lit8 v4, v7, 27
    add-int/2addr v3, v4
    const/4 v4, 1
    or-int/lit8 v4, v4, 16
    const/4 v6, 0
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 297
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L1
  :L5
  .line 299
    iget-byte v0, p0, Lmain/GameRun_F;->cur_a:B
    if-ne v7, v0, :L6
    const/16 v5, 8
    goto :L4
  :L6
  .line 300
    const/4 v5, 0
    goto :L4
.end method

.method public drawPauseMenu(IIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "h" # I
  .registers 17
  .prologue
  .line 357
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const/4 v5, 1
    move v1, p1
    move v2, p2
    move v3, p3
    move/from16 v4, p4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK2(IIIII)V
  .line 358
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    add-int/lit8 v1, p1, 9
    add-int/lit8 v2, p2, 25
    add-int/lit8 v2, v2, 11
    const/16 v3, 18
    sub-int v3, p3, v3
    const/16 v4, 25
    sub-int v4, p4, v4
    const/16 v5, 19
    sub-int/2addr v4, v5
    const/4 v5, 0
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK1(IIIII)V
  .line 369
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const/4 v1, 6
    add-int/lit8 v2, p1, 8
    add-int/lit8 v3, p2, 25
    add-int/lit8 v3, v3, 13
    const/16 v4, 16
    sub-int v4, p3, v4
    const/4 v5, 1
    const/16 v6, 33
    const/4 v7, -1
    iget-byte v8, p0, Lmain/GameRun_F;->selecty:B
    const/4 v9, 4
    const/4 v10, 2
    invoke-virtual/range { v0 .. v10 }, Ldm/Ui;->drawListKY(IIIIIIIIII)V
  .line 373
    iget-object v0, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;
    iget-object v1, p0, Lmain/GameRun_F;->action_str:[Ljava/lang/String;
    array-length v1, v1
    add-int/lit8 v2, p1, 8
    add-int/lit8 v3, p2, 25
    add-int/lit8 v3, v3, 13
    const/16 v4, 16
    sub-int v4, p3, v4
    const/4 v5, 1
    const/16 v6, 33
    const/4 v7, -1
    iget-byte v8, p0, Lmain/GameRun_F;->selecty:B
    invoke-virtual/range { v0 .. v8 }, Lmain/PointerKey;->selectListSY(IIIIIIII)V
  .line 374
    iget-object v0, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;
    const/4 v1, 2
    add-int/lit8 v3, p2, 3
    shr-int/lit8 v4, p3, 1
    const/16 v5, 38
    move v2, p1
    invoke-virtual/range { v0 .. v5 }, Lmain/PointerKey;->selectMenuX(IIIII)B
    move-result v11
  .line 375
  .local v11, "t":B
    const/4 v0, -1
    if-eq v11, v0, :L0
  .line 376
    iput-byte v11, p0, Lmain/GameRun_F;->selectx:B
  .line 377
    const/4 v0, 0
    iput-byte v0, p0, Lmain/GameRun_F;->selecty:B
  .line 378
    iget-byte v0, p0, Lmain/GameRun_F;->selectx:B
    invoke-virtual { p0, v0 }, Lmain/GameRun_F;->setPauseS(I)V
  :L0
  .line 390
    iget-byte v0, p0, Lmain/GameRun_F;->selectx:B
    const/4 v1, 1
    if-ne v0, v1, :L7
  .line 392
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    shr-int/lit8 v1, p3, 1
    add-int/2addr v1, p1
    add-int/lit8 v1, v1, 25
    const/16 v2, 8
    sub-int/2addr v1, v2
    const/16 v2, 60
    sub-int/2addr v1, v2
    add-int/lit8 v2, p2, 25
    add-int/lit8 v2, v2, 16
    add-int/lit8 v2, v2, 33
    invoke-static { }, Ldm/Sound;->i()Ldm/Sound;
    move-result-object v3
    invoke-virtual { v3 }, Ldm/Sound;->getVolume()B
    move-result v3
    iget-byte v4, p0, Lmain/GameRun_F;->selecty:B
    const/4 v5, 1
    if-ne v4, v5, :L6
    const/4 v4, 1
  :L1
    invoke-virtual { v0, v1, v2, v3, v4 }, Ldm/Ui;->drawVolume(IIIZ)V
  .line 394
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-object v1, p0, Lmain/GameRun_F;->action_str:[Ljava/lang/String;
    add-int/lit8 v2, p1, 8
    add-int/lit8 v3, p2, 25
    add-int/lit8 v3, v3, 13
    const/16 v4, 16
    sub-int v4, p3, v4
    const/16 v5, 32
    iget-byte v6, p0, Lmain/GameRun_F;->selecty:B
    const/4 v7, 0
    const/4 v8, 3
    const/4 v9, 0
    invoke-virtual/range { v0 .. v9 }, Ldm/Ui;->drawListSYHasSound([Ljava/lang/Object;IIIIIIII)V
  :L2
  .line 407
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    shr-int/lit8 v1, p3, 1
    add-int/2addr v1, p1
    iget-byte v2, p0, Lmain/GameRun_F;->selectx:B
    if-nez v2, :L8
    const/16 v2, -60
  :L3
    add-int/2addr v1, v2
    add-int/lit8 v2, p2, 4
    const/16 v3, 56
    const/16 v4, 29
    const/4 v5, 4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK1(IIIII)V
  .line 408
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const-string v1, "\u83dc\u5355"
    shr-int/lit8 v2, p3, 1
    add-int/2addr v2, p1
    const/16 v3, 25
    sub-int/2addr v2, v3
    const/4 v3, 3
    sub-int/2addr v2, v3
    add-int/lit8 v3, p2, 3
    const/4 v4, 1
    or-int/lit8 v4, v4, 16
    iget-byte v5, p0, Lmain/GameRun_F;->selectx:B
    if-nez v5, :L9
    const/4 v5, 0
  :L4
    const/4 v6, 0
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 409
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const-string v1, "\u7cfb\u7edf"
    shr-int/lit8 v2, p3, 1
    add-int/2addr v2, p1
    add-int/lit8 v2, v2, 25
    add-int/lit8 v2, v2, 3
    add-int/lit8 v3, p2, 3
    const/4 v4, 1
    or-int/lit8 v4, v4, 16
    iget-byte v5, p0, Lmain/GameRun_F;->selectx:B
    if-nez v5, :L10
    const/4 v5, 1
  :L5
    const/4 v6, 0
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 416
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    shr-int/lit8 v1, p3, 1
    add-int/2addr v1, p1
    add-int/lit8 v2, p2, 12
    const/16 v3, 80
    const/4 v4, 1
    const/4 v5, 1
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawTriangle(IIIZZ)V
  .line 419
    return-void
  :L6
  .line 392
    const/4 v4, 0
    goto :L1
  :L7
  .line 397
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget-object v1, p0, Lmain/GameRun_F;->action_str:[Ljava/lang/String;
    add-int/lit8 v2, p1, 8
    add-int/lit8 v3, p2, 25
    add-int/lit8 v3, v3, 13
    const/16 v4, 16
    sub-int v4, p3, v4
    const/16 v5, 32
    iget-byte v6, p0, Lmain/GameRun_F;->selecty:B
    const/4 v7, 0
    const/4 v8, 3
    const/4 v9, 0
    invoke-virtual/range { v0 .. v9 }, Ldm/Ui;->drawListSY([Ljava/lang/Object;IIIIIIII)V
    goto :L2
  :L8
  .line 407
    const/4 v2, 2
    goto :L3
  :L9
  .line 408
    const/4 v5, 1
    goto :L4
  :L10
  .line 409
    const/4 v5, 0
    goto :L5
.end method

.method public drawSelectMenu([Ljava/lang/Object;IIIIII)V
  .parameter "menu" # [Ljava/lang/Object;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "dis" # I
  .parameter "cn" # I
  .parameter "s_f" # I
  .registers 16
  .prologue
  .line 311
    const/4 v7, 0
  :L0
  .local v7, "d":B
    array-length v0, p1
    if-lt v7, v0, :L1
  .line 327
    return-void
  :L1
  .line 312
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    add-int/lit8 v1, p5, 33
    mul-int/2addr v1, v7
    add-int v2, p3, v1
    const/16 v4, 33
    if-ne v7, p7, :L5
    const/4 v1, 1
    move v5, v1
  :L2
    move v1, p2
    move v3, p4
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK0(IIIII)V
  .line 313
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    aget-object v1, p1, v7
    invoke-virtual { v1 }, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    shr-int/lit8 v2, p4, 1
    add-int/2addr v2, p2
    add-int/lit8 v3, p3, 2
    add-int/lit8 v4, p5, 33
    mul-int/2addr v4, v7
    add-int/2addr v3, v4
    const/4 v4, 1
    or-int/lit8 v4, v4, 16
    if-ne v7, p7, :L6
    const/4 v5, 0
  :L3
    const/4 v6, 1
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 315
    const-string v0, "sk"
    const-string v1, "drawSelectMenu"
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 316
    iget-object v0, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;
    add-int/lit8 v1, p5, 33
    mul-int/2addr v1, v7
    add-int/2addr v1, p3
    const/16 v2, 33
    invoke-virtual { v0, p2, v1, p4, v2 }, Lmain/PointerKey;->isSelect(IIII)Z
    move-result v0
    if-eqz v0, :L4
  .line 317
    iget-object v0, p0, Lmain/GameRun_F;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 12
    if-ne v0, v1, :L8
  .line 318
    if-ne v7, p7, :L7
    iget-object v0, p0, Lmain/GameRun_F;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    const/16 v1, 13
    iput-byte v1, v0, Ldm/Npc;->state:B
  :L4
  .line 311
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L0
  :L5
    move v5, p6
  .line 312
    goto :L2
  :L6
  .line 313
    const/4 v5, 3
    goto :L3
  :L7
  .line 319
    iput-byte v7, p0, Lmain/GameRun_F;->cur_a:B
    goto :L4
  :L8
  .line 320
    sget v0, Lmain/GameRun_F;->run_state:I
    const/16 v1, 35
    if-eq v0, v1, :L9
    sget v0, Lmain/GameRun_F;->run_state:I
    const/16 v1, 25
    if-eq v0, v1, :L9
    iget-object v0, p0, Lmain/GameRun_F;->map:Lmain/Map;
    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;
    iget-byte v0, v0, Ldm/Npc;->state:B
    const/16 v1, 16
    if-eq v0, v1, :L9
    sget v0, Lmain/GameRun_F;->run_state:I
    const/16 v1, 65
    if-eq v0, v1, :L9
    sget v0, Lmain/GameRun_F;->run_state:I
    const/16 v1, 66
    if-eq v0, v1, :L9
    sget v0, Lmain/GameRun_F;->run_state:I
    const/16 v1, 61
    if-ne v0, v1, :L4
  :L9
  .line 321
    if-ne v7, p7, :L10
    iget-object v0, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;
    invoke-virtual { v0 }, Lmain/PointerKey;->setKey5()V
    goto :L4
  :L10
  .line 322
    iput-byte v7, p0, Lmain/GameRun_F;->popMenu:B
    goto :L4
.end method

.method public drawSelectMenu_([Ljava/lang/Object;IIIIII)V
  .parameter "menu" # [Ljava/lang/Object;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "dis" # I
  .parameter "cn" # I
  .parameter "s_f" # I
  .registers 19
  .prologue
  .line 330
    const/16 v9, 25
  .line 332
  .local v9, "FONT_H":I
    const/4 v10, 0
  :L0
  .local v10, "d":B
    array-length v2, p1
    if-lt v10, v2, :L1
  .line 349
    return-void
  :L1
  .line 333
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    add-int/lit8 v3, v9, 8
    add-int/lit8 v3, p5, 33
    mul-int/2addr v3, v10
    add-int v4, p3, v3
    add-int/lit8 v6, v9, 8
    move v0, v10
    move/from16 v1, p7
    if-ne v0, v1, :L5
    const/4 v3, 1
    move v7, v3
  :L2
    move v3, p2
    move v5, p4
    invoke-virtual/range { v2 .. v7 }, Ldm/Ui;->drawK0(IIIII)V
  .line 334
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v2
    aget-object v3, p1, v10
    invoke-virtual { v3 }, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    shr-int/lit8 v4, p4, 1
    add-int/2addr v4, p2
    add-int/lit8 v5, p3, 2
    add-int/lit8 v6, v9, 8
    add-int/lit8 v6, p5, 33
    mul-int/2addr v6, v10
    add-int/2addr v5, v6
    const/4 v6, 1
    or-int/lit8 v6, v6, 16
    move v0, v10
    move/from16 v1, p7
    if-ne v0, v1, :L6
    const/4 v7, 0
  :L3
    const/4 v8, 1
    invoke-virtual/range { v2 .. v8 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 337
    sget-object v2, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;
    const/high16 v3, 255
    invoke-virtual { v2, v3 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 338
    iget-object v2, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;
    sget v3, Lmain/Constants_H;->WIDTH:I
    mul-int/2addr v3, p2
    sget v4, Lmain/Constants_H;->WIDTH__:I
    div-int/2addr v3, v4
    add-int/lit8 v4, v9, 8
    add-int/lit8 v4, p5, 33
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
    add-int/lit8 v6, v9, 8
    sget v6, Lmain/Constants_H;->WIDTH:I
    mul-int/lit8 v6, v6, 33
    sget v7, Lmain/Constants_H;->WIDTH__:I
    div-int/2addr v6, v7
    invoke-virtual { v2, v3, v4, v5, v6 }, Lmain/PointerKey;->isSelect(IIII)Z
    move-result v2
    if-eqz v2, :L4
  .line 339
    iget-object v2, p0, Lmain/GameRun_F;->map:Lmain/Map;
    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;
    iget-byte v2, v2, Ldm/Npc;->state:B
    const/16 v3, 12
    if-ne v2, v3, :L8
  .line 340
    move v0, v10
    move/from16 v1, p7
    if-ne v0, v1, :L7
    iget-object v2, p0, Lmain/GameRun_F;->map:Lmain/Map;
    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;
    const/16 v3, 13
    iput-byte v3, v2, Ldm/Npc;->state:B
  :L4
  .line 332
    add-int/lit8 v2, v10, 1
    int-to-byte v10, v2
    goto/16 :L0
  :L5
    move/from16 v7, p6
  .line 333
    goto :L2
  :L6
  .line 334
    const/4 v7, 3
    goto :L3
  :L7
  .line 341
    iput-byte v10, p0, Lmain/GameRun_F;->cur_a:B
    goto :L4
  :L8
  .line 342
    sget v2, Lmain/GameRun_F;->run_state:I
    const/16 v3, 35
    if-eq v2, v3, :L9
    sget v2, Lmain/GameRun_F;->run_state:I
    const/16 v3, 25
    if-eq v2, v3, :L9
    iget-object v2, p0, Lmain/GameRun_F;->map:Lmain/Map;
    iget-object v2, v2, Lmain/Map;->my:Ldm/Npc;
    iget-byte v2, v2, Ldm/Npc;->state:B
    const/16 v3, 16
    if-eq v2, v3, :L9
    sget v2, Lmain/GameRun_F;->run_state:I
    const/16 v3, 65
    if-eq v2, v3, :L9
    sget v2, Lmain/GameRun_F;->run_state:I
    const/16 v3, 66
    if-ne v2, v3, :L4
  :L9
  .line 343
    move v0, v10
    move/from16 v1, p7
    if-ne v0, v1, :L10
    iget-object v2, p0, Lmain/GameRun_F;->pkey:Lmain/PointerKey;
    invoke-virtual { v2 }, Lmain/PointerKey;->setKey5()V
    goto :L4
  :L10
  .line 344
    iput-byte v10, p0, Lmain/GameRun_F;->popMenu:B
    goto :L4
.end method

.method public drawSrcLine(Ljavax/microedition/lcdui/Graphics;IIIZZ)V
  .parameter "g" # Ljavax/microedition/lcdui/Graphics;
  .parameter "y" # I
  .parameter "h" # I
  .parameter "piece" # I
  .parameter "dir" # Z
  .parameter "mode" # Z
  .registers 15
  .prologue
  .line 236
    const/16 v0, 640
  .line 237
  .local v0, "WIDTH":I
    const/4 v1, 0
  .local v1, "i":B
    div-int v4, p3, p4
    int-to-byte v2, v4
  .line 239
  .local v2, "ph":B
    const/4 v4, 0
    invoke-virtual { p1, v4 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 240
    if-nez p5, :L10
  .line 241
    const/4 v4, 2
    iget-object v5, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v6, 0
    aget-byte v5, v5, v6
    shl-int/2addr v4, v5
    int-to-short v3, v4
  .line 242
  .local v3, "speed":S
    const/4 v4, 1
    sub-int v4, p4, v4
    int-to-byte v1, v4
  :L0
    const/4 v4, -1
    if-gt v1, v4, :L2
  .line 246
    if-eqz p6, :L9
    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v5, 0
    aget-byte v4, v4, v5
    const/16 v5, 12
    if-ge v4, v5, :L9
    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v5, 0
    aget-byte v6, v4, v5
    add-int/lit8 v6, v6, 1
    int-to-byte v6, v6
    aput-byte v6, v4, v5
  :L1
  .line 257
    return-void
  :L2
  .line 243
    sub-int v4, v2, v3
    if-gtz v4, :L4
  :L3
  .line 242
    const/4 v4, 1
    sub-int v4, v1, v4
    int-to-byte v1, v4
    div-int/lit8 v4, v3, 2
    int-to-short v3, v4
    goto :L0
  :L4
  .line 244
    const/4 v4, 0
    mul-int v5, v1, v2
    add-int/2addr v5, p2
    const/4 v6, 2
    if-ge v3, v6, :L7
    const/4 v6, 0
  :L5
    add-int/2addr v5, v6
    const/4 v6, 2
    if-ge v3, v6, :L8
    const/4 v6, 0
  :L6
    sub-int v6, v2, v6
    invoke-virtual { p1, v4, v5, v0, v6 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
    goto :L3
  :L7
    move v6, v3
    goto :L5
  :L8
    move v6, v3
    goto :L6
  :L9
  .line 247
    if-nez p6, :L1
    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v5, 0
    aget-byte v4, v4, v5
    if-lez v4, :L1
    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v5, 0
    aget-byte v6, v4, v5
    const/4 v7, 1
    sub-int/2addr v6, v7
    int-to-byte v6, v6
    aput-byte v6, v4, v5
    goto :L1
  :L10
  .line 249
  .end local v3
    const/4 v4, 2
    iget-object v5, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v6, 1
    aget-byte v5, v5, v6
    shl-int/2addr v4, v5
    int-to-short v3, v4
  :L11
  .line 250
  .restart local v3
    if-eqz p5, :L12
    if-lt v1, p4, :L13
  :L12
  .line 254
    if-eqz p6, :L18
    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v5, 1
    aget-byte v4, v4, v5
    const/16 v5, 12
    if-ge v4, v5, :L18
    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v5, 1
    aget-byte v6, v4, v5
    add-int/lit8 v6, v6, 1
    int-to-byte v6, v6
    aput-byte v6, v4, v5
    goto :L1
  :L13
  .line 251
    sub-int v4, v2, v3
    if-gtz v4, :L15
  :L14
  .line 250
    add-int/lit8 v4, v1, 1
    int-to-byte v1, v4
    div-int/lit8 v4, v3, 2
    int-to-short v3, v4
    goto :L11
  :L15
  .line 252
    const/4 v4, 0
    mul-int v5, v1, v2
    add-int/2addr v5, p2
    const/4 v6, 2
    if-ge v3, v6, :L17
    const/4 v6, 0
  :L16
    sub-int v6, v2, v6
    invoke-virtual { p1, v4, v5, v0, v6 }, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V
    goto :L14
  :L17
    move v6, v3
    goto :L16
  :L18
  .line 255
    if-nez p6, :L1
    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v5, 1
    aget-byte v4, v4, v5
    if-lez v4, :L1
    iget-object v4, p0, Lmain/GameRun_F;->src_c:[B
    const/4 v5, 1
    aget-byte v6, v4, v5
    const/4 v7, 1
    sub-int/2addr v6, v7
    int-to-byte v6, v6
    aput-byte v6, v4, v5
    goto/16 :L1
.end method

.method public drawZero(IIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "anchor" # I
  .parameter "color" # I
  .registers 12
  .prologue
  .line 65
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const-string v1, "\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed"
    const/4 v6, 0
    move v2, p1
    move v3, p2
    move v4, p3
    move v5, p4
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 69
    return-void
.end method

.method public drawZero(Ljava/lang/String;I)V
  .parameter "str" # Ljava/lang/String;
  .parameter "y" # I
  .registers 10
  .prologue
    const/4 v5, 0
  .line 72
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "\u70b9\u51fb\u5c4f\u5e55"
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v1, p1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    sget v2, Lmain/Constants_H;->WIDTH_H:I
    const/4 v3, 1
    or-int/lit8 v4, v3, 32
    move v3, p2
    move v6, v5
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 76
    return-void
.end method

.method public getNLevel(I)B
  .parameter "i" # I
  .registers 4
  .prologue
  .line 713
    iget-object v0, p0, Lmain/GameRun_F;->nidusList:[[B
    const/4 v1, 1
    aget-object v0, v0, v1
    invoke-virtual { p0, p1 }, Lmain/GameRun_F;->getRid(I)B
    move-result v1
    aget-byte v0, v0, v1
    return v0
.end method

.method public getNexp(II)S
  .parameter "i" # I
  .parameter "n" # I
  .registers 6
  .prologue
  .line 714
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    iget-object v1, p0, Lmain/GameRun_F;->rmsNidus:[B
    mul-int/lit8 v2, p1, 5
    add-int/2addr v2, p2
    invoke-virtual { v0, v1, v2 }, Ldm/Ms;->getShort([BI)S
    move-result v0
    return v0
.end method

.method public getNid(I)B
  .parameter "i" # I
  .registers 4
  .prologue
  .line 712
    iget-object v0, p0, Lmain/GameRun_F;->nidusList:[[B
    const/4 v1, 0
    aget-object v0, v0, v1
    invoke-virtual { p0, p1 }, Lmain/GameRun_F;->getRid(I)B
    move-result v1
    aget-byte v0, v0, v1
    return v0
.end method

.method public getRid(I)B
  .parameter "i" # I
  .registers 4
  .prologue
  .line 711
    iget-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B
    mul-int/lit8 v1, p1, 5
    aget-byte v0, v0, v1
    return v0
.end method

.method public getSIndexW(Ljava/lang/String;)S
  .parameter "str" # Ljava/lang/String;
  .registers 7
  .prologue
  .line 54
    const/4 v1, 0
  .local v1, "num":B
    const/4 v2, 0
  .local v2, "start":B
    const-string v3, "#"
    invoke-virtual { p1, v3, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I
    move-result v3
    int-to-byte v0, v3
  .line 55
  .local v0, "end":B
    if-nez v0, :L0
    const/4 v0, 1
  :L0
  .line 56
    const/4 v3, -1
    if-ne v0, v3, :L1
  .line 61
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v3
    const-string v4, "#1"
    invoke-virtual { v3, v4 }, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I
    move-result v3
    mul-int/2addr v3, v1
    int-to-short v3, v3
    return v3
  :L1
  .line 57
    add-int v3, v2, v0
    int-to-byte v2, v3
  .line 58
    const-string v3, "#"
    invoke-virtual { p1, v3, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I
    move-result v3
    int-to-byte v0, v3
  .line 59
    add-int/lit8 v3, v1, 1
    int-to-byte v1, v3
    goto :L0
.end method

.method public gogoWord(Ljava/lang/String;IIIIII)V
  .parameter "string" # Ljava/lang/String;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "w" # I
  .parameter "color" # I
  .parameter "strT" # I
  .parameter "speed" # I
  .registers 17
  .prologue
  .line 82
    const/16 v7, 640
  .local v7, "WIDTH":I
    const/16 v6, 360
  .line 83
  .local v6, "HEIGHT":I
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0, p1 }, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I
    move-result v0
    invoke-virtual { p0, p1 }, Lmain/GameRun_F;->getSIndexW(Ljava/lang/String;)S
    move-result v1
    sub-int/2addr v0, v1
    int-to-short v8, v0
  .line 84
  .local v8, "sw":S
    sub-int v0, v7, p2
    sub-int/2addr v0, p4
    if-le v8, v0, :L1
  .line 85
    iget v0, p0, Lmain/GameRun_F;->introX:I
    sub-int v0, v0, p7
    iput v0, p0, Lmain/GameRun_F;->introX:I
  .line 86
    iget v0, p0, Lmain/GameRun_F;->introX:I
    add-int/2addr v0, v8
    if-ge v0, p2, :L0
    sub-int v0, v7, p4
    const/16 v1, 75
    sub-int/2addr v0, v1
    iput v0, p0, Lmain/GameRun_F;->introX:I
  :L0
  .line 88
    sget-object v0, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;
    sub-int v1, v7, p4
    sub-int/2addr v1, p2
    const/16 v2, 30
    invoke-virtual { v0, p2, p3, v1, v2 }, Ljavax/microedition/lcdui/Graphics;->clipRect(IIII)V
  .line 89
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget v2, p0, Lmain/GameRun_F;->introX:I
    move-object v1, p1
    move v3, p3
    move v4, p5
    move v5, p6
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V
  .line 90
    sget-object v0, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;
    const/4 v1, 0
    const/4 v2, 0
    invoke-virtual { v0, v1, v2, v7, v6 }, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V
  .line 91
    return-void
  :L1
  .line 87
    iput p2, p0, Lmain/GameRun_F;->introX:I
    goto :L0
.end method

.method public gogoWordM(Ljava/lang/String;IIIII)V
  .parameter "string" # Ljava/lang/String;
  .parameter "y" # I
  .parameter "w" # I
  .parameter "color" # I
  .parameter "strT" # I
  .parameter "speed" # I
  .registers 17
  .prologue
  .line 97
    const/16 v8, 640
  .local v8, "WIDTH":I
    const/16 v7, 360
  .line 98
  .local v7, "HEIGHT":I
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0, p1 }, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I
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
    shl-int/lit8 v1, p3, 1
    if-ge v0, v1, :L0
    add-int/lit8 v0, v8, 1
    iput v0, p0, Lmain/GameRun_F;->introT:I
  :L0
  .line 101
    sget-object v0, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;
    shl-int/lit8 v1, p3, 1
    sub-int v1, v8, v1
    const/16 v2, 30
    invoke-virtual { v0, p3, p2, v1, v2 }, Ljavax/microedition/lcdui/Graphics;->clipRect(IIII)V
  .line 102
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    iget v2, p0, Lmain/GameRun_F;->introT:I
    const/4 v4, 0
    move-object v1, p1
    move v3, p2
    move v5, p4
    move v6, p5
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 104
    sget-object v0, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;
    const/4 v1, 0
    const/4 v2, 0
    invoke-virtual { v0, v1, v2, v8, v7 }, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V
  .line 105
    return-void
.end method

.method public initGraphics(Ljavax/microedition/lcdui/Graphics;)V
  .parameter "_g" # Ljavax/microedition/lcdui/Graphics;
  .registers 3
  .prologue
  .line 35
    sput-object p1, Lmain/GameRun_F;->g:Ljavax/microedition/lcdui/Graphics;
  .line 36
    invoke-static { p1 }, Lcom/nokia/mid/ui/DirectUtils;->getDirectGraphics(Ljavax/microedition/lcdui/Graphics;)Lcom/nokia/mid/ui/DirectGraphics;
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
    add-int/lit8 v0, v0, 20
    sget v1, Lmain/Constants_H;->HEIGHT:I
    add-int/lit8 v1, v1, 20
    invoke-static { v0, v1 }, Ljavax/microedition/lcdui/Image;->createImage(II)Ljavax/microedition/lcdui/Image;
    move-result-object v0
    sput-object v0, Lmain/GameRun_F;->scrT:Ljavax/microedition/lcdui/Image;
  .line 40
    sget-object v0, Lmain/GameRun_F;->scrT:Ljavax/microedition/lcdui/Image;
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/Image;->getGraphics()Ljavax/microedition/lcdui/Graphics;
    move-result-object v0
    sput-object v0, Lmain/GameRun_F;->offG:Ljavax/microedition/lcdui/Graphics;
  .line 41
    return-void
.end method

.method public initRmsOther()V
  .registers 4
  .prologue
  .line 668
    const/4 v0, 0
    iput-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
  .line 669
    const/16 v0, 12
    new-array v0, v0, [B
    const/4 v1, 0
  .line 670
    const/4 v2, -1
    aput-byte v2, v0, v1
    const/4 v1, 3
    const/4 v2, 1
    aput-byte v2, v0, v1
  .line 669
    iput-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
  .line 676
    return-void
.end method

.method public isMyLevel(Z)B
  .parameter "bb" # Z
  .registers 7
  .prologue
    const/4 v4, 5
    const/4 v3, 4
    const/16 v1, 103
    const/4 v2, 3
  .line 581
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    aget-byte v0, v0, v2
    packed-switch v0, :L10
  :L0
  .line 626
    const/4 v0, -1
  :L1
    return v0
  :L2
  .line 584
    if-eqz p1, :L3
    iget-object v0, p0, Lmain/GameRun_F;->monInfoList:[B
    aget-byte v0, v0, v1
    if-le v0, v3, :L3
  .line 585
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    const/4 v1, 2
    aput-byte v1, v0, v2
    goto :L0
  :L3
    move v0, v4
  .line 586
    goto :L1
  :L4
  .line 589
    if-eqz p1, :L5
    iget-object v0, p0, Lmain/GameRun_F;->monInfoList:[B
    aget-byte v0, v0, v1
    const/16 v1, 9
    if-le v0, v1, :L5
  .line 590
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    aput-byte v2, v0, v2
    goto :L0
  :L5
  .line 591
    const/16 v0, 10
    goto :L1
  :L6
  .line 594
    if-eqz p1, :L7
    iget-object v0, p0, Lmain/GameRun_F;->monInfoList:[B
    aget-byte v0, v0, v1
    const/16 v1, 14
    if-le v0, v1, :L7
  .line 595
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    aput-byte v3, v0, v2
    goto :L0
  :L7
  .line 596
    const/16 v0, 15
    goto :L1
  :L8
  .line 599
    if-eqz p1, :L9
    iget-object v0, p0, Lmain/GameRun_F;->monInfoList:[B
    aget-byte v0, v0, v1
    const/16 v1, 29
    if-le v0, v1, :L9
  .line 600
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    aput-byte v4, v0, v2
    goto :L0
  :L9
  .line 601
    const/16 v0, 30
    goto :L1
  .line 581
  :L10
  .packed-switch 1
    :L2
    :L4
    :L6
    :L8
  .end packed-switch
.end method

.method public loadInfoList()V
  .registers 7
  .prologue
    const/4 v5, 0
    const/4 v4, 0
  .line 523
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    const/4 v2, 6
    const/4 v3, 1
    invoke-virtual { v1, v2, v5, v3 }, Ldm/Ms;->rmsOptions(I[BI)[B
    move-result-object v1
    iput-object v1, p0, Lmain/GameRun_F;->info:[B
  .line 524
    iget-object v1, p0, Lmain/GameRun_F;->info:[B
    aget-byte v1, v1, v4
    const/4 v2, -1
    if-ne v1, v2, :L3
  .line 525
    const/16 v1, 105
    new-array v1, v1, [B
    iput-object v1, p0, Lmain/GameRun_F;->monInfoList:[B
  .line 526
    const/4 v0, 0
  :L0
  .local v0, "i":I
    iget-object v1, p0, Lmain/GameRun_F;->monInfoList:[B
    array-length v1, v1
    if-lt v0, v1, :L2
  :L1
  .line 530
  .end local v0
    iput-object v5, p0, Lmain/GameRun_F;->info:[B
  .line 531
    return-void
  :L2
  .line 527
  .restart local v0
    iget-object v1, p0, Lmain/GameRun_F;->monInfoList:[B
    aput-byte v4, v1, v0
  .line 526
    add-int/lit8 v0, v0, 1
    goto :L0
  :L3
  .line 529
  .end local v0
    iget-object v1, p0, Lmain/GameRun_F;->info:[B
    iput-object v1, p0, Lmain/GameRun_F;->monInfoList:[B
    goto :L1
.end method

.method public loadItem()V
  .registers 10
  .prologue
    const/4 v8, 1
    const/4 v7, 0
    const/4 v6, 0
    const/4 v5, 4
  .line 644
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v3
    invoke-virtual { v3, v5, v6, v8 }, Ldm/Ms;->rmsOptions(I[BI)[B
    move-result-object v3
    iput-object v3, p0, Lmain/GameRun_F;->info:[B
  .line 646
    new-array v3, v5, [B
    fill-array-data v3, :L7
    iput-object v3, p0, Lmain/GameRun_F;->len:[B
  .line 650
    new-array v3, v5, [B
    iput-object v3, p0, Lmain/GameRun_F;->itemsLength:[B
  .line 651
    const/4 v0, 0
  .local v0, "i":I
    const/4 v1, 0
  .local v1, "j":I
    const/4 v2, 0
  .line 652
  .local v2, "k":I
    iget-object v3, p0, Lmain/GameRun_F;->info:[B
    aget-byte v3, v3, v7
    const/4 v4, -1
    if-eq v3, v4, :L1
    const/4 v0, 0
  :L0
    if-lt v0, v5, :L3
  :L1
  .line 653
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B
    array-length v3, v3
    new-array v3, v3, [[[B
    iput-object v3, p0, Lmain/GameRun_F;->items:[[[B
  .line 654
    const/4 v0, 0
    const/4 v2, 0
  :L2
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B
    array-length v3, v3
    if-lt v0, v3, :L4
  .line 661
    iput-object v6, p0, Lmain/GameRun_F;->info:[B
  .line 662
    iput-object v6, p0, Lmain/GameRun_F;->len:[B
  .line 663
    return-void
  :L3
  .line 652
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B
    iget-object v4, p0, Lmain/GameRun_F;->info:[B
    aget-byte v4, v4, v0
    aput-byte v4, v3, v0
    add-int/lit8 v0, v0, 1
    goto :L0
  :L4
  .line 655
    iget-object v4, p0, Lmain/GameRun_F;->items:[[[B
    iget-object v3, p0, Lmain/GameRun_F;->len:[B
    aget-byte v3, v3, v0
    const/4 v5, 2
    filled-new-array { v3, v5 }, [I
    move-result-object v3
    sget-object v5, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;
    invoke-static { v5, v3 }, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, [[B
    aput-object v3, v4, v0
  .line 656
    const/4 v1, 0
  :L5
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B
    aget-byte v3, v3, v0
    if-lt v1, v3, :L6
  .line 654
    add-int/lit8 v0, v0, 1
    goto :L2
  :L6
  .line 657
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B
    aget-object v3, v3, v0
    aget-object v3, v3, v1
    iget-object v4, p0, Lmain/GameRun_F;->info:[B
    mul-int/lit8 v5, v2, 2
    add-int/lit8 v5, v5, 4
    aget-byte v4, v4, v5
    aput-byte v4, v3, v7
  .line 658
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B
    aget-object v3, v3, v0
    aget-object v3, v3, v1
    iget-object v4, p0, Lmain/GameRun_F;->info:[B
    mul-int/lit8 v5, v2, 2
    add-int/lit8 v5, v5, 4
    add-int/lit8 v5, v5, 1
    aget-byte v4, v4, v5
    aput-byte v4, v3, v8
  .line 656
    add-int/lit8 v1, v1, 1
    add-int/lit8 v2, v2, 1
    goto :L5
  .line 646
  :L7
  .array-data 1
    16t
    19t
    23t
    12t
  .end array-data
.end method

.method public loadMon(I[[B)V
  .parameter "flag" # I
  .parameter "data" # [[B
  .catch Ljava/lang/Exception; { :L0 .. :L5 } :L6
  .catch Ljava/lang/Exception; { :L7 .. :L11 } :L6
  .registers 11
  .prologue
    const/4 v7, 0
    const/4 v6, -1
  .line 484
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v3
    add-int/lit8 v4, p1, 8
    const/4 v5, 1
    invoke-virtual { v3, v4, v7, v5 }, Ldm/Ms;->rmsOptions(I[BI)[B
    move-result-object v3
    iput-object v3, p0, Lmain/GameRun_F;->info:[B
  .line 485
    const/4 v2, 0
  .line 487
  .local v2, "i":I
    if-nez p1, :L8
  .line 488
    const/16 v3, 95
  :L0
    new-array v3, v3, [Ldm/Monster;
    iput-object v3, p0, Lmain/GameRun_F;->cMonsters:[Ldm/Monster;
  .line 489
    iget-object v3, p0, Lmain/GameRun_F;->info:[B
    const/4 v4, 0
    aget-byte v3, v3, v4
    if-ne v3, v6, :L2
  .line 490
    const/4 v3, 0
    iput-byte v3, p0, Lmain/GameRun_F;->cMon_count:B
  :L1
  .line 518
    return-void
  :L2
  .line 493
    new-instance v0, Ljava/io/ByteArrayInputStream;
    iget-object v3, p0, Lmain/GameRun_F;->info:[B
    invoke-direct { v0, v3 }, Ljava/io/ByteArrayInputStream;-><init>([B)V
  .line 494
  .local v0, "byteArray":Ljava/io/ByteArrayInputStream;
    invoke-virtual { v0 }, Ljava/io/ByteArrayInputStream;->read()I
    move-result v3
    int-to-byte v3, v3
    iput-byte v3, p0, Lmain/GameRun_F;->cMon_count:B
  :L3
  .line 495
    iget-byte v3, p0, Lmain/GameRun_F;->cMon_count:B
    if-lt v2, v3, :L7
  :L4
  .line 512
    invoke-virtual { v0 }, Ljava/io/ByteArrayInputStream;->close()V
  .line 513
    const/4 v0, 0
  .line 514
    const/4 v3, 0
    iput-object v3, p0, Lmain/GameRun_F;->info:[B
  :L5
    goto :L1
  :L6
  .line 515
  .end local v0
    move-exception v3
    move-object v1, v3
  .line 516
  .local v1, "ex":Ljava/lang/Exception;
    invoke-virtual { v1 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L1
  :L7
  .line 496
  .end local v1
  .restart local v0
    iget-object v3, p0, Lmain/GameRun_F;->cMonsters:[Ldm/Monster;
    new-instance v4, Ldm/Monster;
    invoke-direct { v4 }, Ldm/Monster;-><init>()V
    aput-object v4, v3, v2
  .line 497
    iget-object v3, p0, Lmain/GameRun_F;->cMonsters:[Ldm/Monster;
    aget-object v3, v3, v2
    invoke-virtual { p0, v0, v3, p2 }, Lmain/GameRun_F;->loadMon(Ljava/io/ByteArrayInputStream;Ldm/Monster;[[B)V
  .line 495
    add-int/lit8 v2, v2, 1
    goto :L3
  :L8
  .line 500
  .end local v0
    const/4 v3, 5
    new-array v3, v3, [Ldm/Monster;
    iput-object v3, p0, Lmain/GameRun_F;->myMonsters:[Ldm/Monster;
  .line 501
    iget-object v3, p0, Lmain/GameRun_F;->info:[B
    const/4 v4, 0
    aget-byte v3, v3, v4
    if-ne v3, v6, :L9
  .line 502
    const/4 v3, 0
    iput-byte v3, p0, Lmain/GameRun_F;->myMon_length:B
    goto :L1
  :L9
  .line 505
    new-instance v0, Ljava/io/ByteArrayInputStream;
    iget-object v3, p0, Lmain/GameRun_F;->info:[B
    invoke-direct { v0, v3 }, Ljava/io/ByteArrayInputStream;-><init>([B)V
  .line 506
  .restart local v0
    invoke-virtual { v0 }, Ljava/io/ByteArrayInputStream;->read()I
    move-result v3
    int-to-byte v3, v3
    iput-byte v3, p0, Lmain/GameRun_F;->myMon_length:B
  :L10
  .line 507
    iget-byte v3, p0, Lmain/GameRun_F;->myMon_length:B
    if-ge v2, v3, :L4
  .line 508
    iget-object v3, p0, Lmain/GameRun_F;->myMonsters:[Ldm/Monster;
    new-instance v4, Ldm/Monster;
    invoke-direct { v4 }, Ldm/Monster;-><init>()V
    aput-object v4, v3, v2
  .line 509
    iget-object v3, p0, Lmain/GameRun_F;->myMonsters:[Ldm/Monster;
    aget-object v3, v3, v2
    invoke-virtual { p0, v0, v3, p2 }, Lmain/GameRun_F;->loadMon(Ljava/io/ByteArrayInputStream;Ldm/Monster;[[B)V
  :L11
  .line 507
    add-int/lit8 v2, v2, 1
    goto :L10
.end method

.method public loadMon(Ljava/io/ByteArrayInputStream;Ldm/Monster;[[B)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/io/IOException;
    }
  .end annotation
  .parameter "byteArray" # Ljava/io/ByteArrayInputStream;
  .parameter "mon" # Ldm/Monster;
  .parameter "data" # [[B
  .registers 9
  .prologue
  .line 450
    const/16 v1, 18
    new-array v1, v1, [B
    iput-object v1, p2, Ldm/Monster;->monster:[B
  .line 451
    const/16 v1, 8
    new-array v1, v1, [S
    iput-object v1, p2, Ldm/Monster;->monsterPro:[S
  .line 452
    iget-object v1, p2, Ldm/Monster;->monster:[B
    invoke-virtual { p1, v1 }, Ljava/io/ByteArrayInputStream;->read([B)I
  .line 453
    const/16 v1, 10
    new-array v1, v1, [B
    iput-object v1, p0, Lmain/GameRun_F;->len:[B
  .line 454
    iget-object v1, p0, Lmain/GameRun_F;->len:[B
    invoke-virtual { p1, v1 }, Ljava/io/ByteArrayInputStream;->read([B)I
  .line 455
    const/4 v0, 0
  :L0
  .local v0, "i":I
    const/4 v1, 5
    if-lt v0, v1, :L1
  .line 457
    iget-object v1, p2, Ldm/Monster;->monster:[B
    const/4 v2, 0
    aget-byte v1, v1, v2
    aget-object v1, p3, v1
    invoke-virtual { p2, v1 }, Ldm/Monster;->setProAFD([B)V
  .line 458
    const/4 v1, 0
    iput-object v1, p0, Lmain/GameRun_F;->len:[B
  .line 459
    return-void
  :L1
  .line 456
    iget-object v1, p2, Ldm/Monster;->monsterPro:[S
    iget-object v2, p0, Lmain/GameRun_F;->len:[B
    mul-int/lit8 v3, v0, 2
    add-int/lit8 v3, v3, 1
    aget-byte v2, v2, v3
    and-int/lit16 v2, v2, 255
    shl-int/lit8 v2, v2, 8
    iget-object v3, p0, Lmain/GameRun_F;->len:[B
    mul-int/lit8 v4, v0, 2
    add-int/lit8 v4, v4, 0
    aget-byte v3, v3, v4
    and-int/lit16 v3, v3, 255
    or-int/2addr v2, v3
    int-to-short v2, v2
    aput-short v2, v1, v0
  .line 455
    add-int/lit8 v0, v0, 1
    goto :L0
.end method

.method public loadRmsNidus()V
  .registers 8
  .prologue
    const/4 v6, 0
    const/4 v5, 3
    const/4 v4, 0
    const/4 v3, -2
    const/16 v2, 10
  .line 698
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    const/4 v1, 1
    invoke-virtual { v0, v5, v6, v1 }, Ldm/Ms;->rmsOptions(I[BI)[B
    move-result-object v0
    iput-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B
  .line 699
    iget-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B
    aget-byte v0, v0, v4
    const/4 v1, -1
    if-ne v0, v1, :L0
  .line 700
    iput-object v6, p0, Lmain/GameRun_F;->rmsNidus:[B
  .line 701
    const/16 v0, 25
    new-array v0, v0, [B
  .line 702
    aput-byte v3, v0, v4
    aput-byte v2, v0, v5
    const/4 v1, 4
    aput-byte v2, v0, v1
    const/4 v1, 5
  .line 703
    aput-byte v3, v0, v1
    const/16 v1, 8
    aput-byte v2, v0, v1
    const/16 v1, 9
    aput-byte v2, v0, v1
  .line 704
    aput-byte v3, v0, v2
    const/16 v1, 13
    aput-byte v2, v0, v1
    const/16 v1, 14
    aput-byte v2, v0, v1
    const/16 v1, 15
  .line 705
    aput-byte v3, v0, v1
    const/16 v1, 18
    aput-byte v2, v0, v1
    const/16 v1, 19
    aput-byte v2, v0, v1
    const/16 v1, 20
  .line 706
    aput-byte v3, v0, v1
    const/16 v1, 23
    aput-byte v2, v0, v1
    const/16 v1, 24
    aput-byte v2, v0, v1
  .line 701
    iput-object v0, p0, Lmain/GameRun_F;->rmsNidus:[B
  :L0
  .line 709
    return-void
.end method

.method public loadRmsOther()V
  .registers 6
  .prologue
    const/4 v4, 0
    const/4 v3, 1
    const/4 v2, 0
  .line 533
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    const/16 v1, 10
    invoke-virtual { v0, v1, v4, v3 }, Ldm/Ms;->rmsOptions(I[BI)[B
    move-result-object v0
    iput-object v0, p0, Lmain/GameRun_F;->info:[B
  .line 534
    iget-object v0, p0, Lmain/GameRun_F;->info:[B
    aget-byte v0, v0, v2
    const/4 v1, -1
    if-ne v0, v1, :L1
  .line 535
    invoke-virtual { p0, v3 }, Lmain/GameRun_F;->setMaxTakes(Z)V
  .line 536
    invoke-virtual { p0 }, Lmain/GameRun_F;->initRmsOther()V
  :L0
  .line 541
    iput-object v4, p0, Lmain/GameRun_F;->info:[B
  .line 542
    return-void
  :L1
  .line 538
    iget-object v0, p0, Lmain/GameRun_F;->info:[B
    iput-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
  .line 539
    invoke-virtual { p0, v2 }, Lmain/GameRun_F;->setMaxTakes(Z)V
    goto :L0
.end method

.method public loadRmsSms()V
  .registers 6
  .prologue
    const/4 v4, 0
    const/4 v3, 0
  .line 679
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    const/4 v1, 5
    const/4 v2, 1
    invoke-virtual { v0, v1, v4, v2 }, Ldm/Ms;->rmsOptions(I[BI)[B
    move-result-object v0
    iput-object v0, p0, Lmain/GameRun_F;->rmsSms:[B
  .line 680
    iget-object v0, p0, Lmain/GameRun_F;->rmsSms:[B
    if-eqz v0, :L0
    iget-object v0, p0, Lmain/GameRun_F;->rmsSms:[B
    aget-byte v0, v0, v3
    const/4 v1, -1
    if-ne v0, v1, :L1
  :L0
  .line 681
    iput-object v4, p0, Lmain/GameRun_F;->rmsSms:[B
  .line 684
    const/4 v0, 7
    new-array v0, v0, [B
    iput-object v0, p0, Lmain/GameRun_F;->rmsSms:[B
  :L1
  .line 690
    iget-object v0, p0, Lmain/GameRun_F;->rmsSms:[B
    aget-byte v0, v0, v3
    const/16 v1, 10
    if-ne v0, v1, :L2
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    const/4 v1, 2
    aget-byte v2, v0, v1
    or-int/lit8 v2, v2, 8
    int-to-byte v2, v2
    aput-byte v2, v0, v1
  :L2
  .line 694
    return-void
.end method

.method public saveInfoList()V
  .registers 5
  .prologue
  .line 520
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    const/4 v1, 6
    iget-object v2, p0, Lmain/GameRun_F;->monInfoList:[B
    const/4 v3, 2
    invoke-virtual { v0, v1, v2, v3 }, Ldm/Ms;->rmsOptions(I[BI)[B
  .line 521
    return-void
.end method

.method public saveItem()V
  .registers 9
  .prologue
    const/4 v7, 4
  .line 629
    const/4 v2, 0
  .line 630
  .local v2, "len":I
    const/4 v0, 0
  :L0
  .local v0, "i":I
    if-lt v0, v7, :L3
  .line 631
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B
    array-length v3, v3
    mul-int/lit8 v4, v2, 2
    add-int/2addr v3, v4
    new-array v3, v3, [B
    iput-object v3, p0, Lmain/GameRun_F;->info:[B
  .line 632
    const/4 v2, 0
  .line 633
    const/4 v0, 0
  :L1
    if-lt v0, v7, :L4
  .line 634
    const/4 v0, 0
  :L2
    iget-object v3, p0, Lmain/GameRun_F;->items:[[[B
    array-length v3, v3
    if-lt v0, v3, :L5
  .line 639
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v3
    iget-object v4, p0, Lmain/GameRun_F;->info:[B
    const/4 v5, 2
    invoke-virtual { v3, v7, v4, v5 }, Ldm/Ms;->rmsOptions(I[BI)[B
  .line 640
    const/4 v3, 0
    iput-object v3, p0, Lmain/GameRun_F;->info:[B
  .line 641
    return-void
  :L3
  .line 630
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B
    aget-byte v3, v3, v0
    add-int/2addr v2, v3
    add-int/lit8 v0, v0, 1
    goto :L0
  :L4
  .line 633
    iget-object v3, p0, Lmain/GameRun_F;->info:[B
    iget-object v4, p0, Lmain/GameRun_F;->itemsLength:[B
    aget-byte v4, v4, v0
    aput-byte v4, v3, v0
    add-int/lit8 v0, v0, 1
    goto :L1
  :L5
  .line 635
    const/4 v1, 0
  :L6
  .local v1, "j":I
    iget-object v3, p0, Lmain/GameRun_F;->itemsLength:[B
    aget-byte v3, v3, v0
    if-lt v1, v3, :L7
  .line 634
    add-int/lit8 v0, v0, 1
    goto :L2
  :L7
  .line 636
    iget-object v3, p0, Lmain/GameRun_F;->info:[B
    mul-int/lit8 v4, v2, 2
    add-int/lit8 v4, v4, 4
    iget-object v5, p0, Lmain/GameRun_F;->items:[[[B
    aget-object v5, v5, v0
    aget-object v5, v5, v1
    const/4 v6, 0
    aget-byte v5, v5, v6
    aput-byte v5, v3, v4
  .line 637
    iget-object v3, p0, Lmain/GameRun_F;->info:[B
    mul-int/lit8 v4, v2, 2
    add-int/lit8 v4, v4, 4
    add-int/lit8 v4, v4, 1
    iget-object v5, p0, Lmain/GameRun_F;->items:[[[B
    aget-object v5, v5, v0
    aget-object v5, v5, v1
    const/4 v6, 1
    aget-byte v5, v5, v6
    aput-byte v5, v3, v4
  .line 635
    add-int/lit8 v1, v1, 1
    add-int/lit8 v2, v2, 1
    goto :L6
.end method

.method public saveMon(I)V
  .parameter "flag" # I
  .catch Ljava/lang/Exception; { :L0 .. :L7 } :L8
  .catch Ljava/lang/Exception; { :L9 .. :L10 } :L8
  .registers 9
  .prologue
  .line 462
    new-instance v0, Ljava/io/ByteArrayOutputStream;
    invoke-direct { v0 }, Ljava/io/ByteArrayOutputStream;-><init>()V
  .line 463
  .local v0, "byteArray":Ljava/io/ByteArrayOutputStream;
    const/4 v2, 0
  .line 465
  .local v2, "i":I
    if-nez p1, :L5
  :L0
  .line 466
    iget-byte v3, p0, Lmain/GameRun_F;->cMon_count:B
    invoke-virtual { v0, v3 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  :L1
  .line 467
    iget-byte v3, p0, Lmain/GameRun_F;->cMon_count:B
    if-lt v2, v3, :L4
  .line 469
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v3
    const/16 v4, 8
    invoke-virtual { v0 }, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v5
    const/4 v6, 2
    invoke-virtual { v3, v4, v5, v6 }, Ldm/Ms;->rmsOptions(I[BI)[B
  :L2
  .line 476
    invoke-virtual { v0 }, Ljava/io/ByteArrayOutputStream;->close()V
  .line 477
    const/4 v0, 0
  :L3
  .line 481
    return-void
  :L4
  .line 468
    iget-object v3, p0, Lmain/GameRun_F;->cMonsters:[Ldm/Monster;
    aget-object v3, v3, v2
    invoke-virtual { p0, v0, v3 }, Lmain/GameRun_F;->saveMon(Ljava/io/ByteArrayOutputStream;Ldm/Monster;)V
  .line 467
    add-int/lit8 v2, v2, 1
    goto :L1
  :L5
  .line 471
    iget-byte v3, p0, Lmain/GameRun_F;->myMon_length:B
    invoke-virtual { v0, v3 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  :L6
  .line 472
    iget-byte v3, p0, Lmain/GameRun_F;->myMon_length:B
    if-lt v2, v3, :L9
  .line 474
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v3
    const/16 v4, 9
    invoke-virtual { v0 }, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v5
    const/4 v6, 2
    invoke-virtual { v3, v4, v5, v6 }, Ldm/Ms;->rmsOptions(I[BI)[B
  :L7
    goto :L2
  :L8
  .line 478
    move-exception v3
    move-object v1, v3
  .line 479
  .local v1, "ex":Ljava/lang/Exception;
    invoke-virtual { v1 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L3
  :L9
  .line 473
  .end local v1
    iget-object v3, p0, Lmain/GameRun_F;->myMonsters:[Ldm/Monster;
    aget-object v3, v3, v2
    invoke-virtual { p0, v0, v3 }, Lmain/GameRun_F;->saveMon(Ljava/io/ByteArrayOutputStream;Ldm/Monster;)V
  :L10
  .line 472
    add-int/lit8 v2, v2, 1
    goto :L6
.end method

.method public saveMon(Ljava/io/ByteArrayOutputStream;Ldm/Monster;)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/io/IOException;
    }
  .end annotation
  .parameter "byteArray" # Ljava/io/ByteArrayOutputStream;
  .parameter "mon" # Ldm/Monster;
  .registers 6
  .prologue
  .line 440
    iget-object v2, p2, Ldm/Monster;->monster:[B
    invoke-virtual { p1, v2 }, Ljava/io/ByteArrayOutputStream;->write([B)V
  .line 441
    const/4 v1, 0
  .local v1, "xxx":I
    const/4 v0, 0
  :L0
  .line 442
  .local v0, "i":I
    const/4 v2, 5
    if-lt v0, v2, :L1
  .line 448
    return-void
  :L1
  .line 443
    iget-object v2, p2, Ldm/Monster;->monsterPro:[S
    aget-short v1, v2, v0
  .line 444
    and-int/lit16 v2, v1, 255
    int-to-byte v2, v2
    invoke-virtual { p1, v2 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  .line 445
    shr-int/lit8 v2, v1, 8
    and-int/lit16 v2, v2, 255
    int-to-byte v2, v2
    invoke-virtual { p1, v2 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  .line 442
    add-int/lit8 v0, v0, 1
    goto :L0
.end method

.method public setAction_str([Ljava/lang/String;)V
  .parameter "temp_str" # [Ljava/lang/String;
  .registers 2
  .prologue
  .line 273
    iput-object p1, p0, Lmain/GameRun_F;->action_str:[Ljava/lang/String;
  .line 274
    const/4 p1, 0
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
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    const/4 v1, 0
    sput v1, Ldm/Ms;->skip:I
  .line 109
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v2
    const-string v3, "data/other/hint.t"
    const/4 v4, -1
    invoke-virtual { v2, v3, v4 }, Ldm/Ms;->getStream(Ljava/lang/String;I)[B
    move-result-object v2
    invoke-virtual { v1, v2 }, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;
    move-result-object v0
  .line 110
  .local v0, "sr":[Ljava/lang/StringBuffer;
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    array-length v1, v0
    invoke-static { v1 }, Ldm/Ms;->getRandom(I)I
    move-result v1
    aget-object v1, v0, v1
    invoke-virtual { v1 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v1
    iput-object v1, p0, Lmain/GameRun_F;->gogoST:Ljava/lang/String;
  .line 111
    const/4 v0, 0
    check-cast v0, [Ljava/lang/StringBuffer;
  .line 112
    return-void
.end method

.method public setMaxTakes(Z)V
  .parameter "bb" # Z
  .registers 7
  .prologue
    const/4 v4, 4
    const/4 v3, 5
    const/4 v2, 3
  .line 544
    if-eqz p1, :L1
  .line 545
    iput-byte v2, p0, Lmain/GameRun_F;->max_takes:B
  .line 546
    const/16 v0, 10
    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B
  :L0
  .line 578
    return-void
  :L1
  .line 549
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    aget-byte v0, v0, v2
    const/4 v1, 2
    if-ne v0, v1, :L2
  .line 550
    iput-byte v4, p0, Lmain/GameRun_F;->max_takes:B
  .line 551
    const/16 v0, 20
    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B
    goto :L0
  :L2
  .line 552
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    aget-byte v0, v0, v2
    if-ne v0, v2, :L3
  .line 553
    iput-byte v3, p0, Lmain/GameRun_F;->max_takes:B
  .line 554
    const/16 v0, 40
    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B
    goto :L0
  :L3
  .line 555
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    aget-byte v0, v0, v2
    if-ne v0, v4, :L4
  .line 556
    iput-byte v3, p0, Lmain/GameRun_F;->max_takes:B
  .line 557
    const/16 v0, 80
    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B
    goto :L0
  :L4
  .line 558
    iget-object v0, p0, Lmain/GameRun_F;->rmsOther:[B
    aget-byte v0, v0, v2
    if-ne v0, v3, :L0
  .line 559
    iput-byte v3, p0, Lmain/GameRun_F;->max_takes:B
  .line 560
    const/16 v0, 95
    iput-byte v0, p0, Lmain/GameRun_F;->max_monsters:B
    goto :L0
.end method

.method public setNidusExp(I)V
  .parameter "exp" # I
  .registers 9
  .prologue
    const/4 v6, 3
    const/4 v5, 1
  .line 729
    div-int/lit8 v1, p1, 10
    if-ge v1, v5, :L2
    move p1, v5
  :L0
  .line 730
    const/4 v0, 0
  :L1
  .local v0, "i":B
    const/4 v1, 5
    if-lt v0, v1, :L3
  .line 735
    return-void
  :L2
  .line 729
  .end local v0
    div-int/lit8 v1, p1, 10
    move p1, v1
    goto :L0
  :L3
  .line 731
  .restart local v0
    invoke-virtual { p0, v0 }, Lmain/GameRun_F;->getRid(I)B
    move-result v1
    const/4 v2, -2
    if-ne v1, v2, :L5
  :L4
  .line 730
    add-int/lit8 v1, v0, 1
    int-to-byte v0, v1
    goto :L1
  :L5
  .line 732
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    invoke-virtual { p0, v0, v5 }, Lmain/GameRun_F;->getNexp(II)S
    move-result v2
    add-int/2addr v2, p1
    iget-object v3, p0, Lmain/GameRun_F;->rmsNidus:[B
    mul-int/lit8 v4, v0, 5
    add-int/lit8 v4, v4, 1
    invoke-virtual { v1, v2, v3, v4 }, Ldm/Ms;->putShort(I[BI)V
  .line 733
    invoke-virtual { p0, v0, v5 }, Lmain/GameRun_F;->getNexp(II)S
    move-result v1
    invoke-virtual { p0, v0, v6 }, Lmain/GameRun_F;->getNexp(II)S
    move-result v2
    if-le v1, v2, :L4
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v1
    invoke-virtual { p0, v0, v6 }, Lmain/GameRun_F;->getNexp(II)S
    move-result v2
    iget-object v3, p0, Lmain/GameRun_F;->rmsNidus:[B
    mul-int/lit8 v4, v0, 5
    add-int/lit8 v4, v4, 1
    invoke-virtual { v1, v2, v3, v4 }, Ldm/Ms;->putShort(I[BI)V
    goto :L4
.end method

.method public setPauseS(I)V
  .parameter "mode" # I
  .registers 9
  .prologue
    const/4 v6, 4
    const/4 v5, 3
    const/4 v4, 2
    const/4 v3, 1
    const/4 v2, 0
  .line 351
    if-nez p1, :L1
  .line 352
    const/4 v0, 6
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
    const/4 v1, 5
    const-string v2, "\u8fd4\u56de\u6e38\u620f"
    aput-object v2, v0, v1
    invoke-virtual { p0, v0 }, Lmain/GameRun_F;->setAction_str([Ljava/lang/String;)V
  :L0
  .line 355
    return-void
  :L1
  .line 354
    new-array v0, v6, [Ljava/lang/String;
    const-string v1, "\u8bfb\u53d6\u8fdb\u5ea6"
    aput-object v1, v0, v2
    const-string v1, "\u58f0\u97f3"
    aput-object v1, v0, v3
    const-string v1, "\u6e38\u620f\u5e2e\u52a9"
    aput-object v1, v0, v4
    const-string v1, "\u56de\u4e3b\u83dc\u5355"
    aput-object v1, v0, v5
    invoke-virtual { p0, v0 }, Lmain/GameRun_F;->setAction_str([Ljava/lang/String;)V
    goto :L0
.end method

.method public setStringB(Ljava/lang/String;II)V
  .parameter "str" # Ljava/lang/String;
  .parameter "w" # I
  .parameter "mode" # I
  .registers 5
  .prologue
  .line 47
    if-nez p3, :L1
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0, p1, p2 }, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;
    move-result-object v0
    iput-object v0, p0, Lmain/GameRun_F;->about_a:[Ljava/lang/StringBuffer;
  :L0
  .line 51
    return-void
  :L1
  .line 48
    const/4 v0, 1
    if-ne p3, v0, :L2
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0, p1, p2 }, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;
    move-result-object v0
    iput-object v0, p0, Lmain/GameRun_F;->about_b:[Ljava/lang/StringBuffer;
    goto :L0
  :L2
  .line 49
    const/4 v0, 2
    if-ne p3, v0, :L3
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0, p1, p2 }, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;
    move-result-object v0
    iput-object v0, p0, Lmain/GameRun_F;->about_c:[Ljava/lang/StringBuffer;
    goto :L0
  :L3
  .line 50
    const/4 v0, 3
    if-ne p3, v0, :L0
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0, p1, p2 }, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;
    move-result-object v0
    iput-object v0, p0, Lmain/GameRun_F;->about_d:[Ljava/lang/StringBuffer;
    goto :L0
.end method

.method public showString(Ljava/lang/String;II)V
  .parameter "string" # Ljava/lang/String;
  .parameter "y" # I
  .parameter "offx" # I
  .registers 15
  .prologue
  .line 138
    const/16 v8, 640
  .local v8, "WIDTH":I
    const/16 v6, 360
  .line 139
  .local v6, "HEIGHT":I
    const/16 v9, 320
  .local v9, "WIDTH_H":I
    const/16 v7, 180
  .line 141
  .local v7, "HEIGHT_H":I
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v0
    div-int/lit8 v0, v0, 11
    int-to-byte v10, v0
  .line 144
  .local v10, "strNum":B
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    add-int/lit8 v1, p3, -5
    add-int/lit8 v3, v8, 10
    add-int/lit8 v2, v10, 1
    mul-int/lit8 v2, v2, 25
    add-int/lit8 v4, v2, 8
    const/4 v5, 3
    move v2, p2
    invoke-virtual/range { v0 .. v5 }, Ldm/Ui;->drawK0(IIIII)V
  .line 145
    add-int v2, v9, p3
    add-int/lit8 v3, p2, 3
    const/16 v4, 11
    const/4 v5, 0
    move-object v0, p0
    move-object v1, p1
    invoke-virtual/range { v0 .. v5 }, Lmain/GameRun_F;->showStringM(Ljava/lang/String;IIII)V
  .line 146
    return-void
.end method

.method public showString([Ljava/lang/StringBuffer;III)V
  .parameter "showS" # [Ljava/lang/StringBuffer;
  .parameter "y" # I
  .parameter "offx" # I
  .parameter "mode" # I
  .registers 23
  .prologue
  .line 125
    sget v15, Lmain/Constants_H;->WIDTH__:I
  .local v15, "WIDTH":I
    const/16 v13, 360
  .line 126
  .local v13, "HEIGHT":I
    sget v5, Lmain/Constants_H;->WIDTH__:I
    div-int/lit8 v16, v5, 2
  .local v16, "WIDTH_H":I
    const/16 v14, 180
  .line 127
  .local v14, "HEIGHT_H":I
    const/16 v12, 25
  .local v12, "FONT_W":I
    const/16 v11, 25
  .line 128
  .local v11, "FONT_H":I
    add-int/lit8 p2, p2, 5
  .line 130
    if-eqz p4, :L0
  .line 131
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    add-int/lit8 v6, p3, -5
    add-int/lit8 v7, v15, 10
    move-object/from16 v0, p1
    array-length v0, v0
    move v8, v0
    mul-int/2addr v8, v11
    add-int/lit8 v8, v8, 12
    move-object v0, v5
    move v1, v6
    move/from16 v2, p2
    move v3, v7
    move v4, v8
    invoke-virtual { v0, v1, v2, v3, v4 }, Ldm/Ui;->drawKuang(IIII)V
  .line 132
    const/4 v5, 2
    move/from16 v0, p4
    move v1, v5
    if-ne v0, v1, :L0
    add-int v5, v16, p3
    move-object/from16 v0, p1
    array-length v0, v0
    move v6, v0
    mul-int/2addr v6, v11
    add-int v6, v6, p2
    add-int/lit8 v6, v6, 4
    move-object/from16 v0, p0
    move v1, v5
    move v2, v6
    invoke-direct { v0, v1, v2 }, Lmain/GameRun_F;->drawSnare5(II)V
  :L0
  .line 134
    const/16 v17, 0
  :L1
  .local v17, "d":B
    move-object/from16 v0, p1
    array-length v0, v0
    move v5, v0
    move/from16 v0, v17
    move v1, v5
    if-lt v0, v1, :L2
  .line 136
    return-void
  :L2
  .line 135
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v5
    aget-object v6, p1, v17
    invoke-virtual { v6 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v6
    add-int v7, v12, p3
    add-int/lit8 v8, p2, 4
    mul-int v9, v17, v11
    add-int/2addr v8, v9
    const/4 v9, -1
    const/4 v10, 1
    invoke-virtual/range { v5 .. v10 }, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V
  .line 134
    add-int/lit8 v5, v17, 1
    move v0, v5
    int-to-byte v0, v0
    move/from16 v17, v0
    goto :L1
.end method

.method public showStringM(Ljava/lang/String;IIII)V
  .parameter "str" # Ljava/lang/String;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "num" # I
  .parameter "c" # I
  .registers 15
  .prologue
  .line 148
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v0
    div-int/2addr v0, p4
    int-to-byte v8, v0
  .line 149
  .local v8, "strNum":B
    const/4 v7, 0
  :L0
  .local v7, "d":B
    if-le v7, v8, :L1
  .line 157
    return-void
  :L1
  .line 150
    if-nez v8, :L3
  .line 151
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const/4 v1, 1
    or-int/lit8 v4, v1, 16
    const/4 v6, 1
    move-object v1, p1
    move v2, p2
    move v3, p3
    move v5, p5
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 152
    const-string v0, "sk"
    const-string v1, "strNum == 0"
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  :L2
  .line 149
    add-int/lit8 v0, v7, 1
    int-to-byte v7, v0
    goto :L0
  :L3
  .line 154
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    mul-int v1, v7, p4
    add-int/lit8 v2, v7, 1
    if-le v2, v8, :L5
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v2
  :L4
    invoke-virtual { p1, v1, v2 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
    move-result-object v1
  .line 155
    mul-int/lit8 v2, v7, 25
    add-int v3, p3, v2
    const/4 v2, 1
    or-int/lit8 v4, v2, 16
    const/4 v6, 0
    move v2, p2
    move v5, p5
  .line 154
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 156
    const-string v0, "sk"
    const-string v1, "else"
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    goto :L2
  :L5
  .line 154
    add-int/lit8 v2, v7, 1
    mul-int/2addr v2, p4
    goto :L4
.end method

.method public showStringM_(Ljava/lang/String;IIII)V
  .parameter "str" # Ljava/lang/String;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "num" # I
  .parameter "c" # I
  .registers 16
  .prologue
  .line 159
    const/16 v7, 25
  .line 160
  .local v7, "FONT_H":I
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v0
    div-int/2addr v0, p4
    int-to-byte v9, v0
  .line 161
  .local v9, "strNum":B
    const/4 v8, 0
  :L0
  .local v8, "d":B
    if-le v8, v9, :L1
  .line 169
    return-void
  :L1
  .line 162
    if-nez v9, :L3
  .line 163
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    const/4 v1, 1
    or-int/lit8 v4, v1, 16
    const/4 v6, 1
    move-object v1, p1
    move v2, p2
    move v3, p3
    move v5, p5
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
  .line 164
    const-string v0, "sk"
    const-string v1, "strNum == 0"
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  :L2
  .line 161
    add-int/lit8 v0, v8, 1
    int-to-byte v8, v0
    goto :L0
  :L3
  .line 167
    invoke-static { }, Ldm/Ui;->i()Ldm/Ui;
    move-result-object v0
    mul-int v1, v8, p4
    add-int/lit8 v2, v8, 1
    if-le v2, v9, :L5
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v2
  :L4
    invoke-virtual { p1, v1, v2 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
    move-result-object v1
  .line 168
    mul-int v2, v8, v7
    add-int v3, p3, v2
    const/4 v2, 1
    or-int/lit8 v4, v2, 16
    const/4 v6, 0
    move v2, p2
    move v5, p5
  .line 167
    invoke-virtual/range { v0 .. v6 }, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V
    goto :L2
  :L5
    add-int/lit8 v2, v8, 1
    mul-int/2addr v2, p4
    goto :L4
.end method
