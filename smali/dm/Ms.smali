.class public Ldm/Ms;
.super Ljava/lang/Object;
.implements Lmain/Key_H;
.source "Ms.java"

.field public static font:Ljavax/microedition/lcdui/Font;

.field public static key:I

.field public static keyRepeat:Z

.field public static key_delay:B

.field public static key_time:B

.field private static msListener:Ldm/Ms;

.field private static random:Ljava/util/Random;

.field private static rms:Ljavax/microedition/rms/RecordStore;

.field public static skip:I

.field public static skip2:I

.field final RMSSIZE:I

.field private sleep_time:I

.field private final transA:[B

.method static constructor <clinit>()V
  .registers 2
  .prologue
    const/4 v1, 0
  .line 561
    new-instance v0, Ljava/util/Random;
    invoke-direct { v0 }, Ljava/util/Random;-><init>()V
    sput-object v0, Ldm/Ms;->random:Ljava/util/Random;
  .line 574
    const/16 v0, 26
    invoke-static { v1, v1, v0 }, Ljavax/microedition/lcdui/Font;->getFont(III)Ljavax/microedition/lcdui/Font;
    move-result-object v0
    sput-object v0, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;
  .line 675
    sput-byte v1, Ldm/Ms;->key_delay:B
    const/16 v0, 10
    sput-byte v0, Ldm/Ms;->key_time:B
  .line 24
    return-void
.end method

.method public constructor <init>()V
  .registers 8
  .prologue
    const/4 v6, 5
    const/4 v5, 4
    const/4 v4, 3
    const/4 v3, 2
    const/4 v2, 1
  .line 26
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 37
    const/16 v0, 15360
    iput v0, p0, Ldm/Ms;->RMSSIZE:I
  .line 429
    const/16 v0, 8
    new-array v0, v0, [B
    const/4 v1, 6
    aput-byte v1, v0, v2
    aput-byte v4, v0, v3
    aput-byte v6, v0, v4
    aput-byte v3, v0, v5
    const/4 v1, 7
    aput-byte v1, v0, v6
    const/4 v1, 6
    aput-byte v2, v0, v1
    const/4 v1, 7
    aput-byte v5, v0, v1
    iput-object v0, p0, Ldm/Ms;->transA:[B
  .line 26
    sput-object p0, Ldm/Ms;->msListener:Ldm/Ms;
    return-void
.end method

.method public static abs(I)I
  .parameter "a" # I
  .registers 2
  .prologue
  .line 565
    if-lez p0, :L1
    move v0, p0
  :L0
    return v0
  :L1
    neg-int v0, p0
    goto :L0
.end method

.method private checkIsSimulate()Z
  .catch Ljava/lang/Exception; { :L1 .. :L2 } :L3
  .registers 8
  .prologue
    const/4 v6, 1
    const/4 v5, -1
  .line 660
    invoke-static { }, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/Runtime;->totalMemory()J
    move-result-wide v1
    const-wide/32 v3, 8000000
    cmp-long v1, v1, v3
    if-ltz v1, :L1
    move v1, v6
  :L0
  .line 669
    return v1
  :L1
  .line 662
    const-string v1, "emulator.Emulator"
    invoke-static { v1 }, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
  .line 663
    const-string v1, "com.sprintpcs.util.System"
    invoke-static { v1 }, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
  :L2
    move v1, v6
  .line 664
    goto :L0
  :L3
  .line 665
    move-exception v1
  .line 666
    const-string v1, "microedition.platform"
    invoke-static { v1 }, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
  .line 667
  .local v0, "platForm":Ljava/lang/String;
    invoke-virtual { v0 }, Ljava/lang/String;->toLowerCase()Ljava/lang/String;
    move-result-object v1
    const-string v2, "wtk"
    invoke-virtual { v1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v1
    if-ne v1, v5, :L4
  .line 668
    invoke-virtual { v0 }, Ljava/lang/String;->toLowerCase()Ljava/lang/String;
    move-result-object v1
    const-string v2, "javasdk"
    invoke-virtual { v1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v1
    if-ne v1, v5, :L4
  .line 669
    invoke-virtual { v0 }, Ljava/lang/String;->toLowerCase()Ljava/lang/String;
    move-result-object v1
    const-string v2, "j2me"
    invoke-virtual { v1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v1
    if-ne v1, v5, :L4
    const/4 v1, 0
    goto :L0
  :L4
    move v1, v6
  .line 667
    goto :L0
.end method

.method public static compare_min(II)I
  .parameter "c0" # I
  .parameter "c1" # I
  .registers 3
  .prologue
  .line 567
    if-gt p0, p1, :L1
    move v0, p0
  :L0
    return v0
  :L1
    move v0, p1
    goto :L0
.end method

.method public static getNum([B)J
  .parameter "b" # [B
  .registers 8
  .prologue
  .line 142
    const/4 v2, 0
  .local v2, "rtn":I
    array-length v1, p0
  .line 143
  .local v1, "len":I
    const/4 v0, 0
  :L0
  .local v0, "i":I
    if-lt v0, v1, :L1
  .line 159
    int-to-long v3, v2
    return-wide v3
  :L1
  .line 144
    packed-switch v1, :L7
  :L2
  .line 143
    add-int/lit8 v0, v0, 1
    goto :L0
  :L3
  .line 146
    aget-byte v3, p0, v0
    and-int/lit16 v3, v3, 255
    mul-int/lit8 v4, v0, 8
    shl-int/2addr v3, v4
    int-to-byte v3, v3
    add-int/2addr v2, v3
  .line 147
    goto :L2
  :L4
  .line 149
    aget-byte v3, p0, v0
    and-int/lit16 v3, v3, 255
    mul-int/lit8 v4, v0, 8
    shl-int/2addr v3, v4
    int-to-short v3, v3
    add-int/2addr v2, v3
  .line 150
    goto :L2
  :L5
  .line 152
    aget-byte v3, p0, v0
    and-int/lit16 v3, v3, 255
    mul-int/lit8 v4, v0, 8
    shl-int/2addr v3, v4
    add-int/2addr v2, v3
  .line 153
    goto :L2
  :L6
  .line 155
    int-to-long v3, v2
    aget-byte v5, p0, v0
    and-int/lit16 v5, v5, 255
    mul-int/lit8 v6, v0, 8
    shl-int/2addr v5, v6
    int-to-long v5, v5
    add-long/2addr v3, v5
    long-to-int v2, v3
    goto :L2
  .line 144
  :L7
  .packed-switch 1
    :L3
    :L4
    :L2
    :L5
    :L2
    :L2
    :L2
    :L6
  .end packed-switch
.end method

.method public static getRandom(I)I
  .parameter "ss" # I
  .registers 3
  .prologue
  .line 563
    sget-object v0, Ldm/Ms;->random:Ljava/util/Random;
    invoke-virtual { v0 }, Ljava/util/Random;->nextInt()I
    move-result v0
    const v1, 2147483647
    and-int/2addr v0, v1
    rem-int/2addr v0, p0
    return v0
.end method

.method private getStreamL([BI)S
  .parameter "data" # [B
  .parameter "mode" # I
  .registers 6
  .prologue
  .line 203
    if-nez p2, :L1
    sget v0, Ldm/Ms;->skip:I
    add-int/lit8 v1, v0, 1
    sput v1, Ldm/Ms;->skip:I
    aget-byte v0, p1, v0
  :L0
  .line 206
    return v0
  :L1
  .line 204
    const/4 v0, 1
    if-ne p2, v0, :L2
    sget v0, Ldm/Ms;->skip:I
    add-int/lit8 v1, v0, 1
    sput v1, Ldm/Ms;->skip:I
    aget-byte v0, p1, v0
    add-int/lit8 v0, v0, 100
    int-to-short v0, v0
    goto :L0
  :L2
  .line 205
    const/4 v0, 2
    if-ne p2, v0, :L3
    sget v0, Ldm/Ms;->skip:I
    add-int/lit8 v1, v0, 1
    sput v1, Ldm/Ms;->skip:I
    aget-byte v0, p1, v0
    and-int/lit16 v0, v0, 255
    shl-int/lit8 v0, v0, 8
    sget v1, Ldm/Ms;->skip:I
    add-int/lit8 v2, v1, 1
    sput v2, Ldm/Ms;->skip:I
    aget-byte v1, p1, v1
    and-int/lit16 v1, v1, 255
    or-int/2addr v0, v1
    int-to-short v0, v0
    goto :L0
  :L3
  .line 206
    sget v0, Ldm/Ms;->skip:I
    add-int/lit8 v1, v0, 1
    sput v1, Ldm/Ms;->skip:I
    aget-byte v0, p1, v0
    and-int/lit16 v0, v0, 255
    sget v1, Ldm/Ms;->skip:I
    add-int/lit8 v2, v1, 1
    sput v2, Ldm/Ms;->skip:I
    aget-byte v1, p1, v1
    and-int/lit16 v1, v1, 255
    shl-int/lit8 v1, v1, 8
    or-int/2addr v0, v1
    int-to-short v0, v0
    goto :L0
.end method

.method public static i()Ldm/Ms;
  .registers 1
  .prologue
  .line 28
    sget-object v0, Ldm/Ms;->msListener:Ldm/Ms;
    if-nez v0, :L0
    new-instance v0, Ldm/Ms;
    invoke-direct { v0 }, Ldm/Ms;-><init>()V
    sput-object v0, Ldm/Ms;->msListener:Ldm/Ms;
  :L0
  .line 29
    sget-object v0, Ldm/Ms;->msListener:Ldm/Ms;
    return-object v0
.end method

.method public byteArrayToShortArray([B)[S
  .parameter "bytebuf" # [B
  .registers 6
  .prologue
  .line 185
    const/4 v3, 0
    sput v3, Ldm/Ms;->skip:I
  .line 186
    array-length v3, p1
    shr-int/lit8 v1, v3, 1
  .line 187
  .local v1, "len":I
    new-array v2, v1, [S
  .line 188
  .local v2, "shortbuf":[S
    const/4 v0, 0
  :L0
  .local v0, "i":I
    if-lt v0, v1, :L1
  .line 191
    return-object v2
  :L1
  .line 189
    const/4 v3, 2
    invoke-direct { p0, p1, v3 }, Ldm/Ms;->getStreamL([BI)S
    move-result v3
    aput-short v3, v2, v0
  .line 188
    add-int/lit8 v0, v0, 1
    goto :L0
.end method

.method public correctSelect([BII)V
  .parameter "select" # [B
  .parameter "max" # I
  .parameter "showLine" # I
  .registers 7
  .prologue
    const/4 v2, 1
    const/4 v1, 0
  .line 648
    aget-byte v0, p1, v1
    if-ge v0, p2, :L3
  .line 649
    aget-byte v0, p1, v1
    sub-int/2addr v0, p3
    add-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    aput-byte v0, p1, v2
  :L0
  .line 654
    aget-byte v0, p1, v1
    if-gez v0, :L1
    aput-byte v1, p1, v1
  :L1
  .line 655
    aget-byte v0, p1, v2
    if-gez v0, :L2
    aput-byte v1, p1, v2
  :L2
  .line 656
    return-void
  :L3
  .line 651
    sub-int v0, p2, v2
    int-to-byte v0, v0
    aput-byte v0, p1, v1
  .line 652
    sub-int v0, p2, p3
    int-to-byte v0, v0
    aput-byte v0, p1, v2
    goto :L0
.end method

.method public create2Array([B)[[B
  .parameter "data" # [B
  .registers 6
  .prologue
  .line 259
    sget v2, Ldm/Ms;->skip:I
    add-int/lit8 v3, v2, 1
    sput v3, Ldm/Ms;->skip:I
    aget-byte v2, p1, v2
    invoke-virtual { p0, v2 }, Ldm/Ms;->getLen_byte(B)I
    move-result v2
    new-array v0, v2, [[B
  .line 260
  .local v0, "array":[[B
    const/4 v1, 0
  :L0
  .local v1, "i":I
    array-length v2, v0
    if-lt v1, v2, :L1
  .line 262
    return-object v0
  :L1
  .line 261
    invoke-virtual { p0, p1 }, Ldm/Ms;->createArray([B)[B
    move-result-object v2
    aput-object v2, v0, v1
  .line 260
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public create3Array([B)[[[B
  .parameter "data" # [B
  .registers 6
  .prologue
  .line 265
    sget v2, Ldm/Ms;->skip:I
    add-int/lit8 v3, v2, 1
    sput v3, Ldm/Ms;->skip:I
    aget-byte v2, p1, v2
    invoke-virtual { p0, v2 }, Ldm/Ms;->getLen_byte(B)I
    move-result v2
    new-array v0, v2, [[[B
  .line 266
  .local v0, "array":[[[B
    const/4 v1, 0
  :L0
  .local v1, "i":I
    array-length v2, v0
    if-lt v1, v2, :L1
  .line 268
    return-object v0
  :L1
  .line 267
    invoke-virtual { p0, p1 }, Ldm/Ms;->create2Array([B)[[B
    move-result-object v2
    aput-object v2, v0, v1
  .line 266
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public create4Array([B)[[[[B
  .parameter "data" # [B
  .registers 6
  .prologue
  .line 271
    sget v2, Ldm/Ms;->skip:I
    add-int/lit8 v3, v2, 1
    sput v3, Ldm/Ms;->skip:I
    aget-byte v2, p1, v2
    invoke-virtual { p0, v2 }, Ldm/Ms;->getLen_byte(B)I
    move-result v2
    new-array v0, v2, [[[[B
  .line 272
  .local v0, "array":[[[[B
    const/4 v1, 0
  :L0
  .local v1, "i":I
    array-length v2, v0
    if-lt v1, v2, :L1
  .line 274
    return-object v0
  :L1
  .line 273
    invoke-virtual { p0, p1 }, Ldm/Ms;->create3Array([B)[[[B
    move-result-object v2
    aput-object v2, v0, v1
  .line 272
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public createArray([B)[B
  .parameter "data" # [B
  .registers 6
  .prologue
  .line 253
    sget v2, Ldm/Ms;->skip:I
    add-int/lit8 v3, v2, 1
    sput v3, Ldm/Ms;->skip:I
    aget-byte v2, p1, v2
    invoke-virtual { p0, v2 }, Ldm/Ms;->getLen_byte(B)I
    move-result v2
    new-array v0, v2, [B
  .line 254
  .local v0, "array":[B
    const/4 v1, 0
  :L0
  .local v1, "j":I
    array-length v2, v0
    if-lt v1, v2, :L1
  .line 256
    return-object v0
  :L1
  .line 255
    sget v2, Ldm/Ms;->skip:I
    add-int/lit8 v3, v2, 1
    sput v3, Ldm/Ms;->skip:I
    aget-byte v2, p1, v2
    aput-byte v2, v0, v1
  .line 254
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method createCellImage(Ljavax/microedition/lcdui/Image;IIII)Ljavax/microedition/lcdui/Image;
  .parameter "image" # Ljavax/microedition/lcdui/Image;
  .parameter "cell_index" # I
  .parameter "cell_width" # I
  .parameter "cell_height" # I
  .parameter "trans" # I
  .registers 13
  .prologue
  .line 443
    invoke-virtual { p1 }, Ljavax/microedition/lcdui/Image;->getWidth()I
    move-result v0
    div-int/2addr v0, p3
    rem-int v0, p2, v0
    mul-int v2, v0, p3
  .line 444
  .local v2, "temp_cell_x":I
    invoke-virtual { p1 }, Ljavax/microedition/lcdui/Image;->getHeight()I
    move-result v0
    div-int/2addr v0, p4
    rem-int v0, p2, v0
    mul-int v3, v0, p4
  .local v3, "temp_cell_y":I
    move-object v0, p0
    move-object v1, p1
    move v4, p3
    move v5, p4
    move v6, p5
  .line 454
    invoke-virtual/range { v0 .. v6 }, Ldm/Ms;->createImage(Ljavax/microedition/lcdui/Image;IIIII)Ljavax/microedition/lcdui/Image;
    move-result-object v0
    return-object v0
.end method

.method public createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
  .parameter "imageName" # Ljava/lang/String;
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L3
  .registers 5
  :L0
  .prologue
  .line 476
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "/"
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v1, p1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ".png"
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static { v1 }, Ljavax/microedition/lcdui/Image;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
  :L1
    move-result-object v1
  :L2
  .line 479
    return-object v1
  :L3
  .line 477
    move-exception v1
    move-object v0, v1
  .line 479
  .local v0, "ex":Ljava/lang/Exception;
    const/4 v1, 0
    goto :L2
.end method

.method public createImage(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
  .parameter "name" # Ljava/lang/String;
  .parameter "no" # I
  .registers 6
  .prologue
  .line 470
    invoke-virtual { p0, p1, p2 }, Ldm/Ms;->getStream(Ljava/lang/String;I)[B
    move-result-object v0
  .line 471
  .local v0, "data":[B
    const/4 v1, 0
    array-length v2, v0
    invoke-static { v0, v1, v2 }, Ljavax/microedition/lcdui/Image;->createImage([BII)Ljavax/microedition/lcdui/Image;
    move-result-object v1
    return-object v1
.end method

.method createImage(Ljavax/microedition/lcdui/Image;IIIII)Ljavax/microedition/lcdui/Image;
  .parameter "image" # Ljavax/microedition/lcdui/Image;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "width" # I
  .parameter "height" # I
  .parameter "trans" # I
  .registers 13
  .prologue
  .line 431
    add-int v0, p2, p4
    invoke-virtual { p1 }, Ljavax/microedition/lcdui/Image;->getWidth()I
    move-result v1
    if-le v0, v1, :L0
    invoke-virtual { p1 }, Ljavax/microedition/lcdui/Image;->getWidth()I
    move-result v0
    sub-int p4, v0, p2
  :L0
  .line 432
    add-int v0, p3, p5
    invoke-virtual { p1 }, Ljavax/microedition/lcdui/Image;->getHeight()I
    move-result v1
    if-le v0, v1, :L1
    invoke-virtual { p1 }, Ljavax/microedition/lcdui/Image;->getHeight()I
    move-result v0
    sub-int p5, v0, p3
  :L1
  .line 433
    iget-object v0, p0, Ldm/Ms;->transA:[B
    aget-byte v5, v0, p6
    move-object v0, p1
    move v1, p2
    move v2, p3
    move v3, p4
    move v4, p5
    invoke-static/range { v0 .. v5 }, Ljavax/microedition/lcdui/Image;->createImage(Ljavax/microedition/lcdui/Image;IIIII)Ljavax/microedition/lcdui/Image;
    move-result-object v0
    return-object v0
.end method

.method public createImageArray(ILjava/lang/String;)[Ljavax/microedition/lcdui/Image;
  .parameter "len" # I
  .parameter "name" # Ljava/lang/String;
  .registers 7
  .prologue
  .line 457
    new-array v1, p1, [Ljavax/microedition/lcdui/Image;
  .line 458
  .local v1, "img":[Ljavax/microedition/lcdui/Image;
    const/4 v0, 0
  :L0
  .local v0, "i":S
    array-length v2, v1
    if-lt v0, v2, :L1
  .line 460
    return-object v1
  :L1
  .line 459
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-static { p2 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v2, v0 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual { p0, v2 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v2
    aput-object v2, v1, v0
  .line 458
    add-int/lit8 v2, v0, 1
    int-to-short v0, v2
    goto :L0
.end method

.method public createImageArray_(ILjava/lang/String;I)[Ljavax/microedition/lcdui/Image;
  .parameter "len" # I
  .parameter "name" # Ljava/lang/String;
  .parameter "a" # I
  .registers 8
  .prologue
  .line 463
    new-array v1, p1, [Ljavax/microedition/lcdui/Image;
  .line 464
  .local v1, "img":[Ljavax/microedition/lcdui/Image;
    const/4 v0, 0
  :L0
  .local v0, "i":S
    array-length v2, v1
    if-lt v0, v2, :L1
  .line 466
    return-object v1
  :L1
  .line 465
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-static { p2 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v2, v0 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual { p0, v2, p3 }, Ldm/Ms;->createImage_(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
    move-result-object v2
    aput-object v2, v1, v0
  .line 464
    add-int/lit8 v2, v0, 1
    int-to-short v0, v2
    goto :L0
.end method

.method public createImage_(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
  .parameter "imageName" # Ljava/lang/String;
  .parameter "a" # I
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L3
  .registers 6
  :L0
  .prologue
  .line 484
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "/"
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v1, p1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ".png"
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static { v1, p2 }, Ljavax/microedition/lcdui/Image;->createImage(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
  :L1
    move-result-object v1
  :L2
  .line 487
    return-object v1
  :L3
  .line 485
    move-exception v1
    move-object v0, v1
  .line 487
  .local v0, "ex":Ljava/lang/Exception;
    const/4 v1, 0
    goto :L2
.end method

.method public createIntArray([B)[I
  .parameter "data" # [B
  .registers 7
  .prologue
  .line 226
    const/4 v2, 0
    invoke-direct { p0, p1, v2 }, Ldm/Ms;->getStreamL([BI)S
    move-result v2
    new-array v0, v2, [I
  .line 227
  .local v0, "array":[I
    const/4 v1, 0
  :L0
  .local v1, "i":I
    array-length v2, v0
    if-lt v1, v2, :L1
  .line 230
    return-object v0
  :L1
  .line 228
    sget v2, Ldm/Ms;->skip:I
    add-int/lit8 v3, v2, 1
    sput v3, Ldm/Ms;->skip:I
    aget-byte v2, p1, v2
    and-int/lit16 v2, v2, 255
    sget v3, Ldm/Ms;->skip:I
    add-int/lit8 v4, v3, 1
    sput v4, Ldm/Ms;->skip:I
    aget-byte v3, p1, v3
    and-int/lit16 v3, v3, 255
    shl-int/lit8 v3, v3, 8
    or-int/2addr v2, v3
  .line 229
    sget v3, Ldm/Ms;->skip:I
    add-int/lit8 v4, v3, 1
    sput v4, Ldm/Ms;->skip:I
    aget-byte v3, p1, v3
    and-int/lit16 v3, v3, 255
    shl-int/lit8 v3, v3, 16
    or-int/2addr v2, v3
    sget v3, Ldm/Ms;->skip:I
    add-int/lit8 v4, v3, 1
    sput v4, Ldm/Ms;->skip:I
    aget-byte v3, p1, v3
    and-int/lit16 v3, v3, 255
    shl-int/lit8 v3, v3, 24
    or-int/2addr v2, v3
  .line 228
    aput v2, v0, v1
  .line 227
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public createShort2Array([BI)[[S
  .parameter "data" # [B
  .parameter "mode" # I
  .registers 6
  .prologue
  .line 241
    invoke-direct { p0, p1, p2 }, Ldm/Ms;->getStreamL([BI)S
    move-result v2
    new-array v0, v2, [[S
  .line 242
  .local v0, "array":[[S
    const/4 v1, 0
  :L0
  .local v1, "i":I
    array-length v2, v0
    if-lt v1, v2, :L1
  .line 244
    return-object v0
  :L1
  .line 243
    invoke-virtual { p0, p1, p2 }, Ldm/Ms;->createShortArray([BI)[S
    move-result-object v2
    aput-object v2, v0, v1
  .line 242
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public createShort3Array([BI)[[[S
  .parameter "data" # [B
  .parameter "mode" # I
  .registers 6
  .prologue
  .line 247
    invoke-direct { p0, p1, p2 }, Ldm/Ms;->getStreamL([BI)S
    move-result v2
    new-array v0, v2, [[[S
  .line 248
  .local v0, "array":[[[S
    const/4 v1, 0
  :L0
  .local v1, "i":I
    array-length v2, v0
    if-lt v1, v2, :L1
  .line 250
    return-object v0
  :L1
  .line 249
    invoke-virtual { p0, p1, p2 }, Ldm/Ms;->createShort2Array([BI)[[S
    move-result-object v2
    aput-object v2, v0, v1
  .line 248
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public createShortArray([BI)[S
  .parameter "data" # [B
  .parameter "mode" # I
  .registers 7
  .prologue
    const/4 v3, 2
  .line 235
    invoke-direct { p0, p1, p2 }, Ldm/Ms;->getStreamL([BI)S
    move-result v2
    new-array v0, v2, [S
  .line 236
  .local v0, "array":[S
    const/4 v1, 0
  :L0
  .local v1, "j":I
    array-length v2, v0
    if-lt v1, v2, :L1
  .line 238
    return-object v0
  :L1
  .line 237
    if-ne p2, v3, :L3
    move v2, v3
  :L2
    invoke-direct { p0, p1, v2 }, Ldm/Ms;->getStreamL([BI)S
    move-result v2
    aput-short v2, v0, v1
  .line 236
    add-int/lit8 v1, v1, 1
    goto :L0
  :L3
  .line 237
    const/4 v2, -1
    goto :L2
.end method

.method public createSprite(Ljava/lang/String;Z)Ldm/Sprite;
  .parameter "name" # Ljava/lang/String;
  .parameter "mode" # Z
  .registers 8
  .prologue
    const/4 v4, 2
  .line 491
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-static { p1 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v2, ".data"
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const/4 v2, -1
    invoke-virtual { p0, v1, v2 }, Ldm/Ms;->getStream(Ljava/lang/String;I)[B
    move-result-object v0
  .line 493
  .local v0, "date":[B
    const/4 v1, 0
    sput v1, Ldm/Ms;->skip:I
  .line 494
    if-eqz p2, :L1
  .line 495
    invoke-virtual { p0, p1 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v1
  .line 496
    invoke-virtual { p0, v0 }, Ldm/Ms;->create2Array([B)[[B
    move-result-object v2
  .line 497
    invoke-virtual { p0, v0 }, Ldm/Ms;->create3Array([B)[[[B
    move-result-object v3
  .line 498
    invoke-virtual { p0, v0 }, Ldm/Ms;->create3Array([B)[[[B
    move-result-object v4
  .line 494
    invoke-static { v1, v2, v3, v4 }, Ldm/Sprite;->Create(Ljavax/microedition/lcdui/Image;[[B[[[B[[[B)Ldm/Sprite;
    move-result-object v1
  :L0
    return-object v1
  :L1
  .line 500
    invoke-virtual { p0, p1 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v1
  .line 501
    invoke-virtual { p0, v0, v4 }, Ldm/Ms;->createShort2Array([BI)[[S
    move-result-object v2
  .line 502
    invoke-virtual { p0, v0, v4 }, Ldm/Ms;->createShort3Array([BI)[[[S
    move-result-object v3
  .line 503
    invoke-virtual { p0, v0, v4 }, Ldm/Ms;->createShort3Array([BI)[[[S
    move-result-object v4
  .line 499
    invoke-static { v1, v2, v3, v4 }, Ldm/Sprite;->Create(Ljavax/microedition/lcdui/Image;[[S[[[S[[[S)Ldm/Sprite;
    move-result-object v1
    goto :L0
.end method

.method public createString2Array([B)[[Ljava/lang/StringBuffer;
  .parameter "dataa" # [B
  .registers 7
  .prologue
  .line 292
    sget v3, Ldm/Ms;->skip:I
    add-int/lit8 v4, v3, 1
    sput v4, Ldm/Ms;->skip:I
    aget-byte v1, p1, v3
  .line 293
  .local v1, "len":B
    new-array v2, v1, [[Ljava/lang/StringBuffer;
  .line 294
  .local v2, "string":[[Ljava/lang/StringBuffer;
    const/4 v0, 0
  :L0
  .local v0, "i":B
    array-length v3, v2
    if-lt v0, v3, :L1
  .line 296
    return-object v2
  :L1
  .line 295
    invoke-virtual { p0, p1 }, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;
    move-result-object v3
    aput-object v3, v2, v0
  .line 294
    add-int/lit8 v3, v0, 1
    int-to-byte v0, v3
    goto :L0
.end method

.method public createStringArray([B)[Ljava/lang/StringBuffer;
  .parameter "data" # [B
  .registers 7
  .prologue
  .line 279
    sget v3, Ldm/Ms;->skip:I
    add-int/lit8 v4, v3, 1
    sput v4, Ldm/Ms;->skip:I
    aget-byte v3, p1, v3
    invoke-virtual { p0, v3 }, Ldm/Ms;->getLen_byte(B)I
    move-result v3
    new-array v2, v3, [Ljava/lang/StringBuffer;
  .line 280
  .local v2, "string":[Ljava/lang/StringBuffer;
    const/4 v0, 0
  :L0
  .local v0, "i":B
    array-length v3, v2
    if-lt v0, v3, :L1
  .line 286
    return-object v2
  :L1
  .line 281
    sget v3, Ldm/Ms;->skip:I
    aget-byte v1, p1, v3
  .line 282
  .local v1, "l_c":S
    if-gez v1, :L2
    add-int/lit16 v3, v1, 256
    int-to-short v1, v3
  :L2
  .line 283
    new-instance v3, Ljava/lang/StringBuffer;
    sget v4, Ldm/Ms;->skip:I
    add-int/lit8 v4, v4, 1
    invoke-virtual { p0, p1, v4, v1 }, Ldm/Ms;->getDialogs([BII)Ljava/lang/String;
    move-result-object v4
    invoke-direct { v3, v4 }, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V
    aput-object v3, v2, v0
  .line 284
    sget v3, Ldm/Ms;->skip:I
    mul-int/lit8 v4, v1, 2
    add-int/lit8 v4, v4, 1
    add-int/2addr v3, v4
    sput v3, Ldm/Ms;->skip:I
  .line 280
    add-int/lit8 v3, v0, 1
    int-to-byte v0, v3
    goto :L0
.end method

.method public createStringArrayOne([B)Ljava/lang/StringBuffer;
  .parameter "data" # [B
  .registers 5
  .prologue
  .line 289
    new-instance v0, Ljava/lang/StringBuffer;
    const/4 v1, 2
    const/4 v2, 1
    aget-byte v2, p1, v2
    invoke-virtual { p0, v2 }, Ldm/Ms;->getLen_byte(B)I
    move-result v2
    invoke-virtual { p0, p1, v1, v2 }, Ldm/Ms;->getDialogs([BII)Ljava/lang/String;
    move-result-object v1
    invoke-direct { v0, v1 }, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z
  .parameter "sbuff" # Ljava/lang/StringBuffer;
  .parameter "str" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 524
    invoke-virtual { p1 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual { v0, p2 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    return v0
.end method

.method public getDialogs([BII)Ljava/lang/String;
  .parameter "data" # [B
  .parameter "start" # I
  .parameter "len" # I
  .registers 8
  .prologue
  .line 310
    new-instance v0, Ljava/lang/StringBuffer;
    invoke-direct { v0 }, Ljava/lang/StringBuffer;-><init>()V
  .line 312
  .local v0, "dialog":Ljava/lang/StringBuffer;
    const/4 v1, 0
  :L0
  .local v1, "i":I
    if-lt v1, p3, :L1
  .line 315
    invoke-virtual { v0 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
  :L1
  .line 313
    shl-int/lit8 v2, v1, 1
    add-int/2addr v2, p2
    aget-byte v2, p1, v2
    shl-int/lit8 v2, v2, 8
  .line 314
    shl-int/lit8 v3, v1, 1
    add-int/2addr v3, p2
    add-int/lit8 v3, v3, 1
    aget-byte v3, p1, v3
    and-int/lit16 v3, v3, 255
    or-int/2addr v2, v3
    int-to-char v2, v2
  .line 313
    invoke-virtual { v0, v2 }, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;
  .line 312
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public getEventNowData([[S)[B
  .parameter "event_now" # [[S
  .registers 6
  .prologue
  .line 104
    new-instance v0, Ljava/io/ByteArrayOutputStream;
    invoke-direct { v0 }, Ljava/io/ByteArrayOutputStream;-><init>()V
  .line 105
  .local v0, "byteArray":Ljava/io/ByteArrayOutputStream;
    array-length v3, p1
    invoke-virtual { v0, v3 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  .line 107
    const/4 v1, 0
  :L0
  .local v1, "i":I
    array-length v3, p1
    if-lt v1, v3, :L1
  .line 118
    invoke-virtual { v0 }, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v3
    return-object v3
  :L1
  .line 108
    aget-object v3, p1, v1
    if-nez v3, :L3
  .line 109
    const/4 v3, 0
    invoke-virtual { v0, v3 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  :L2
  .line 107
    add-int/lit8 v1, v1, 1
    goto :L0
  :L3
  .line 112
    aget-object v3, p1, v1
    array-length v3, v3
    invoke-virtual { v0, v3 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  .line 113
    const/4 v2, 0
  :L4
  .local v2, "j":I
    aget-object v3, p1, v1
    array-length v3, v3
    if-ge v2, v3, :L2
  .line 114
    aget-object v3, p1, v1
    aget-short v3, v3, v2
    and-int/lit16 v3, v3, 255
    invoke-virtual { v0, v3 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  .line 115
    aget-object v3, p1, v1
    aget-short v3, v3, v2
    shr-int/lit8 v3, v3, 8
    and-int/lit16 v3, v3, 255
    invoke-virtual { v0, v3 }, Ljava/io/ByteArrayOutputStream;->write(I)V
  .line 113
    add-int/lit8 v2, v2, 1
    goto :L4
.end method

.method public getInt([BI)I
  .parameter "buf" # [B
  .parameter "i" # I
  .registers 5
  .prologue
  .line 163
    aget-byte v0, p1, p2
    and-int/lit16 v0, v0, 255
    shl-int/lit8 v0, v0, 24
    add-int/lit8 v1, p2, 1
    aget-byte v1, p1, v1
    and-int/lit16 v1, v1, 255
    shl-int/lit8 v1, v1, 16
    or-int/2addr v0, v1
  .line 164
    add-int/lit8 v1, p2, 2
    aget-byte v1, p1, v1
    and-int/lit16 v1, v1, 255
    shl-int/lit8 v1, v1, 8
  .line 163
    or-int/2addr v0, v1
  .line 164
    add-int/lit8 v1, p2, 3
    aget-byte v1, p1, v1
    and-int/lit16 v1, v1, 255
  .line 163
    or-int/2addr v0, v1
    return v0
.end method

.method public getLen_byte(B)I
  .parameter "value" # B
  .registers 3
  .prologue
  .line 161
    if-gez p1, :L1
    add-int/lit16 v0, p1, 256
  :L0
    return v0
  :L1
    move v0, p1
    goto :L0
.end method

.method public getLen_short(S)I
  .parameter "value" # S
  .registers 3
  .prologue
  .line 162
    if-gez p1, :L1
    const/high16 v0, 1
    add-int/2addr v0, p1
  :L0
    return v0
  :L1
    move v0, p1
    goto :L0
.end method

.method public getMin(BB)B
  .parameter "i0" # B
  .parameter "i1" # B
  .registers 4
  .prologue
  .line 577
    if-le p1, p2, :L1
    move v0, p2
  :L0
    return v0
  :L1
    move v0, p1
    goto :L0
.end method

.method public getPrecision(I)Ljava/lang/String;
  .parameter "t" # I
  .registers 4
  .prologue
  .line 537
    new-instance v0, Ljava/lang/StringBuilder;
    div-int/lit8 v1, p1, 10
    invoke-static { v1 }, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    invoke-direct { v0, v1 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v1, "."
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    rem-int/lit8 v1, p1, 10
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual { v0 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getShort([BI)S
  .parameter "buf" # [B
  .parameter "i" # I
  .registers 5
  .prologue
  .line 173
    aget-byte v0, p1, p2
    and-int/lit16 v0, v0, 255
    shl-int/lit8 v0, v0, 8
    add-int/lit8 v1, p2, 1
    aget-byte v1, p1, v1
    and-int/lit16 v1, v1, 255
    or-int/2addr v0, v1
    int-to-short v0, v0
    return v0
.end method

.method public getSleep()I
  .registers 2
  .prologue
  .line 33
    iget v0, p0, Ldm/Ms;->sleep_time:I
    return v0
.end method

.method public getStream(Ljava/lang/String;I)[B
  .parameter "i" # Ljava/lang/String;
  .parameter "num" # I
  .catch Ljava/lang/Exception; { :L0 .. :L5 } :L6
  .registers 9
  .prologue
  .line 209
    const/4 v0, 0
    check-cast v0, [B
  :L0
  .line 212
  .local v0, "data":[B
    new-instance v1, Ljava/io/DataInputStream;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "/"
    invoke-direct { v4, v5 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v4, p1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual { v4 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static { v4 }, Lcom/android/Util/AndroidUtil;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;
    move-result-object v4
    invoke-direct { v1, v4 }, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V
  .line 213
  .local v1, "dataInput":Ljava/io/DataInputStream;
    const/4 v4, -1
    if-le p2, v4, :L2
  .line 214
    invoke-virtual { v1 }, Ljava/io/DataInputStream;->readByte()B
  .line 215
    const/4 v3, 0
  :L1
  .local v3, "n":B
    if-lt v3, p2, :L4
  :L2
  .line 218
  .end local v3
    invoke-virtual { v1 }, Ljava/io/DataInputStream;->readShort()S
    move-result v4
    invoke-virtual { p0, v4 }, Ldm/Ms;->getLen_short(S)I
    move-result v4
    new-array v0, v4, [B
  .line 219
    invoke-virtual { v1, v0 }, Ljava/io/DataInputStream;->read([B)I
  .line 220
    invoke-virtual { v1 }, Ljava/io/DataInputStream;->close()V
  .line 221
    const/4 v1, 0
  :L3
  .line 223
  .end local v1
    return-object v0
  :L4
  .line 216
  .restart local v1
  .restart local v3
    invoke-virtual { v1 }, Ljava/io/DataInputStream;->readShort()S
    move-result v4
    invoke-virtual { p0, v4 }, Ldm/Ms;->getLen_short(S)I
    move-result v4
    int-to-long v4, v4
    invoke-virtual { v1, v4, v5 }, Ljava/io/DataInputStream;->skip(J)J
  :L5
  .line 215
    add-int/lit8 v4, v3, 1
    int-to-byte v3, v4
    goto :L1
  :L6
  .line 222
  .end local v1
  .end local v3
    move-exception v4
    move-object v2, v4
  .local v2, "ex":Ljava/lang/Exception;
    invoke-virtual { v2 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L3
.end method

.method public getStringWidth(Ljava/lang/String;)I
  .parameter "str" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 576
    sget-object v0, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;
    invoke-virtual { v0, p1 }, Ljavax/microedition/lcdui/Font;->stringWidth(Ljava/lang/String;)I
    move-result v0
    return v0
.end method

.method public groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;
  .parameter "info" # Ljava/lang/String;
  .parameter "width" # I
  .registers 17
  .prologue
  .line 323
    const/16 v11, 30
    new-array v9, v11, [Ljava/lang/StringBuffer;
  .line 324
  .local v9, "tempResult":[Ljava/lang/StringBuffer;
    new-instance v8, Ljava/lang/StringBuffer;
    invoke-direct { v8 }, Ljava/lang/StringBuffer;-><init>()V
  .line 325
  .local v8, "temp":Ljava/lang/StringBuffer;
    new-instance v3, Ljava/lang/StringBuffer;
    invoke-direct { v3, p1 }, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V
  .line 326
  .local v3, "orig":Ljava/lang/StringBuffer;
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v11
    int-to-short v1, v11
  .line 327
  .local v1, "infoLength":S
    const/4 v6, 0
  .local v6, "tc":B
    const-string v11, "#0"
    invoke-virtual { p0, v11 }, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I
    move-result v11
    int-to-byte v10, v11
  .local v10, "tw":B
    const/4 v5, -1
  .line 328
  .local v5, "rows":B
    const/4 v2, 0
  .line 329
  .local v2, "isNewRow":Z
    const-string v7, ""
  .line 331
  .local v7, "tcolor":Ljava/lang/String;
    const/4 v0, 0
  :L0
  .local v0, "i":I
    if-lt v0, v1, :L1
  .line 363
    add-int/lit8 v11, v5, 1
    new-array v4, v11, [Ljava/lang/StringBuffer;
  .line 364
  .local v4, "result":[Ljava/lang/StringBuffer;
    const/4 v11, 0
    const/4 v12, 0
    add-int/lit8 v13, v5, 1
    invoke-static { v9, v11, v4, v12, v13 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  .line 365
    const/4 v9, 0
    check-cast v9, [Ljava/lang/StringBuffer;
  .line 366
    const/4 v3, 0
    move-object v8, v3
  .line 367
    const/4 v7, 0
  .line 368
    return-object v4
  :L1
  .line 332
  .end local v4
    const/4 v11, 0
    invoke-virtual { v3, v11 }, Ljava/lang/StringBuffer;->charAt(I)C
    move-result v11
    const/16 v12, 35
    if-ne v11, v12, :L7
  .line 333
    const/4 v11, 1
    invoke-virtual { v3, v11 }, Ljava/lang/StringBuffer;->charAt(I)C
    move-result v11
    const/16 v12, 110
    if-ne v11, v12, :L6
    const/4 v2, 1
  :L2
  .line 339
    const/4 v11, 0
    invoke-virtual { v3, v11 }, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;
  .line 340
    const/4 v11, 0
    invoke-virtual { v3, v11 }, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;
  .line 341
    add-int/lit8 v0, v0, 1
  :L3
  .line 353
    if-eqz v2, :L5
  .line 354
    add-int/lit8 v11, v5, 1
    int-to-byte v5, v11
  .line 355
    invoke-virtual { v7 }, Ljava/lang/String;->length()I
    move-result v11
    if-nez v11, :L11
    const/4 v11, 0
  :L4
    int-to-byte v6, v11
  .line 356
    const/4 v2, 0
  .line 357
    aput-object v8, v9, v5
  .line 358
    const/4 v8, 0
  .line 359
    new-instance v8, Ljava/lang/StringBuffer;
  .end local v8
    invoke-direct { v8 }, Ljava/lang/StringBuffer;-><init>()V
  .line 360
  .restart local v8
    invoke-virtual { v8, v7 }, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
  :L5
  .line 331
    add-int/lit8 v0, v0, 1
    goto :L0
  :L6
  .line 335
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v12, "#"
    invoke-direct { v11, v12 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const/4 v12, 1
    invoke-virtual { v3, v12 }, Ljava/lang/StringBuffer;->charAt(I)C
    move-result v12
    invoke-virtual { v11, v12 }, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual { v11 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
  .line 336
    invoke-virtual { v8, v7 }, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
  .line 337
    add-int/lit8 v11, v6, 1
    int-to-byte v6, v11
    goto :L2
  :L7
  .line 343
    const/4 v11, 0
    invoke-virtual { v3, v11 }, Ljava/lang/StringBuffer;->charAt(I)C
    move-result v11
    invoke-virtual { v8, v11 }, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;
  .line 344
    if-eqz p2, :L9
    invoke-virtual { v8 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual { p0, v11 }, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I
    move-result v11
    mul-int v12, v10, v6
    add-int v12, v12, p2
    if-gt v11, v12, :L9
  .line 345
    const/4 v11, 0
    invoke-virtual { v3, v11 }, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;
  :L8
  .line 351
    const/4 v11, 1
    sub-int v11, v1, v11
    if-ne v0, v11, :L3
    if-nez v2, :L3
    const/4 v2, 1
    goto :L3
  :L9
  .line 346
    if-eqz p2, :L10
  .line 347
    add-int/lit8 v0, v0, -1
  .line 348
    invoke-virtual { v8 }, Ljava/lang/StringBuffer;->length()I
    move-result v11
    const/4 v12, 1
    sub-int/2addr v11, v12
    invoke-virtual { v8, v11 }, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;
  .line 349
    const/4 v2, 1
    goto :L8
  :L10
  .line 350
    const/4 v11, 0
    invoke-virtual { v3, v11 }, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;
    goto :L8
  :L11
  .line 355
    const/4 v11, 1
    goto :L4
.end method

.method public isRect(IIIIIIII)Z
  .parameter "a0" # I
  .parameter "a1" # I
  .parameter "aw" # I
  .parameter "ah" # I
  .parameter "b0" # I
  .parameter "b1" # I
  .parameter "bw" # I
  .parameter "bh" # I
  .registers 10
  .prologue
  .line 529
    add-int v0, p5, p7
    if-ge p1, v0, :L1
    add-int v0, p1, p3
    if-le v0, p5, :L1
    add-int v0, p6, p8
    if-ge p2, v0, :L1
    add-int v0, p2, p4
    if-le v0, p6, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public keyRelease()V
  .registers 2
  .prologue
    const/4 v0, 0
  .line 685
    sput-boolean v0, Ldm/Ms;->keyRepeat:Z
    sput-byte v0, Ldm/Ms;->key_delay:B
    const/16 v0, 10
    sput-byte v0, Ldm/Ms;->key_time:B
    return-void
.end method

.method public key_Down()Z
  .registers 3
  .prologue
  .line 688
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -2
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_Left()Z
  .registers 3
  .prologue
  .line 690
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -3
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_Left_Right()Z
  .registers 3
  .prologue
  .line 689
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -3
    if-eq v0, v1, :L1
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -4
    if-eq v0, v1, :L1
    const/4 v0, 0
  :L0
    return v0
  :L1
    const/4 v0, 1
    goto :L0
.end method

.method public key_Num0()Z
  .registers 3
  .prologue
  .line 700
    sget v0, Ldm/Ms;->key:I
    const/16 v1, 48
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_Num1()Z
  .registers 3
  .prologue
  .line 701
    sget v0, Ldm/Ms;->key:I
    const/16 v1, 49
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_Num3()Z
  .registers 3
  .prologue
  .line 702
    sget v0, Ldm/Ms;->key:I
    const/16 v1, 51
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_Num9()Z
  .registers 3
  .prologue
  .line 703
    sget v0, Ldm/Ms;->key:I
    const/16 v1, 57
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_Right()Z
  .registers 3
  .prologue
  .line 691
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -4
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_S1()Z
  .registers 3
  .prologue
  .line 697
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -6
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_S1_Num5()Z
  .registers 3
  .prologue
  .line 692
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -6
    if-eq v0, v1, :L1
    sget v0, Ldm/Ms;->key:I
    const/16 v1, 53
    if-eq v0, v1, :L1
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -5
    if-eq v0, v1, :L1
    const/4 v0, 0
  :L0
    return v0
  :L1
    const/4 v0, 1
    goto :L0
.end method

.method public key_S2()Z
  .registers 3
  .prologue
  .line 698
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -7
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_Up()Z
  .registers 3
  .prologue
  .line 687
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -1
    if-ne v0, v1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public key_Up_Down()Z
  .registers 3
  .prologue
  .line 686
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -1
    if-eq v0, v1, :L1
    sget v0, Ldm/Ms;->key:I
    const/4 v1, -2
    if-eq v0, v1, :L1
    const/4 v0, 0
  :L0
    return v0
  :L1
    const/4 v0, 1
    goto :L0
.end method

.method public key_delay()Z
  .registers 3
  .prologue
    const/4 v1, 1
  .line 678
    sget-byte v0, Ldm/Ms;->key_delay:B
    if-nez v0, :L2
  .line 679
    sget-byte v0, Ldm/Ms;->key_time:B
    sput-byte v0, Ldm/Ms;->key_delay:B
  .line 680
    sget-byte v0, Ldm/Ms;->key_time:B
    if-le v0, v1, :L0
    sget-byte v0, Ldm/Ms;->key_time:B
    sub-int/2addr v0, v1
    int-to-byte v0, v0
    sput-byte v0, Ldm/Ms;->key_time:B
  :L0
  .line 681
    const/4 v0, 0
  :L1
  .line 683
    return v0
  :L2
    move v0, v1
    goto :L1
.end method

.method public loadText([B)[Ljava/lang/String;
  .parameter "word_uni" # [B
  .catch Ljava/lang/Exception; { :L0 .. :L8 } :L9
  .catch Ljava/lang/Exception; { :L10 .. :L14 } :L9
  .registers 16
  :L0
  .prologue
  .line 378
    new-instance v9, Ljava/lang/StringBuffer;
    const-string v12, ""
    invoke-direct { v9, v12 }, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V
  .line 380
  .local v9, "stringbuffer":Ljava/lang/StringBuffer;
    const/4 v2, 2
  .local v2, "j":I
    move v3, v2
  :L1
  .end local v2
  .local v3, "j":I
    array-length v12, p1
    if-lt v3, v12, :L5
  .line 388
    invoke-virtual { v9 }, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    move-result-object v8
  .line 389
  .local v8, "strReturn":Ljava/lang/String;
    const/4 v9, 0
  .line 390
    new-instance v11, Ljava/util/Vector;
    invoke-direct { v11 }, Ljava/util/Vector;-><init>()V
  .line 391
  .local v11, "vecString":Ljava/util/Vector;
    const/4 v4, 0
  .line 392
  .local v4, "k":I
    const/4 v5, 0
  .line 393
  .local v5, "l":I
    const/4 v2, 0
  :L2
  .end local v3
  .restart local v2
    invoke-virtual { v8 }, Ljava/lang/String;->length()I
    move-result v12
    if-lt v2, v12, :L10
  .line 402
    const/4 v8, 0
  .line 404
    invoke-virtual { v11 }, Ljava/util/Vector;->size()I
    move-result v12
    new-array v6, v12, [Ljava/lang/String;
  .line 406
  .local v6, "reStr":[Ljava/lang/String;
    const/4 v2, 0
  :L3
    invoke-virtual { v11 }, Ljava/util/Vector;->size()I
    move-result v12
    if-lt v2, v12, :L13
  .line 410
    const/4 v11, 0
    move-object v12, v6
  :L4
  .line 416
  .end local v2
  .end local v4
  .end local v5
  .end local v6
  .end local v8
  .end local v9
  .end local v11
    return-object v12
  :L5
  .line 381
  .restart local v3
  .restart local v9
    add-int/lit8 v2, v3, 1
  .end local v3
  .restart local v2
    aget-byte v4, p1, v3
  .line 382
  .restart local v4
    if-gez v4, :L6
    add-int/lit16 v4, v4, 256
  :L6
  .line 383
    add-int/lit8 v3, v2, 1
  .end local v2
  .restart local v3
    aget-byte v5, p1, v2
  .line 384
  .restart local v5
    if-gez v5, :L7
    add-int/lit16 v5, v5, 256
  :L7
  .line 385
    shl-int/lit8 v12, v5, 8
    add-int/2addr v12, v4
    int-to-char v0, v12
  .line 386
  .local v0, "c":C
    invoke-virtual { v9, v0 }, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;
  :L8
    goto :L1
  :L9
  .line 412
  .end local v0
  .end local v3
  .end local v4
  .end local v5
  .end local v9
    move-exception v12
    move-object v1, v12
  .line 413
  .local v1, "e":Ljava/lang/Exception;
    invoke-virtual { v1 }, Ljava/lang/Exception;->printStackTrace()V
  .line 414
    const/4 v12, 0
    goto :L4
  :L10
  .line 395
  .end local v1
  .restart local v2
  .restart local v4
  .restart local v5
  .restart local v8
  .restart local v9
  .restart local v11
    invoke-virtual { v8, v2 }, Ljava/lang/String;->charAt(I)C
    move-result v12
    const/16 v13, 10
    if-eq v12, v13, :L11
    invoke-virtual { v8 }, Ljava/lang/String;->length()I
    move-result v12
    if-ne v2, v12, :L12
  :L11
  .line 396
    invoke-virtual { v8, v4, v5 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
    move-result-object v10
  .line 397
  .local v10, "temp":Ljava/lang/String;
    invoke-virtual { v11, v10 }, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V
  .line 398
    add-int/lit8 v4, v5, 1
  :L12
  .line 400
  .end local v10
    add-int/lit8 v5, v5, 1
  .line 393
    add-int/lit8 v2, v2, 1
    goto :L2
  :L13
  .line 407
  .restart local v6
    invoke-virtual { v11, v2 }, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
  .line 408
  .local v7, "s":Ljava/lang/String;
    aput-object v7, v6, v2
  :L14
  .line 406
    add-int/lit8 v2, v2, 1
    goto :L3
.end method

.method public mathPercent(III)S
  .parameter "m0" # I
  .parameter "m1" # I
  .parameter "per" # I
  .registers 5
  .prologue
  .line 570
    const/4 v0, 1
    if-ge p3, v0, :L0
    const/4 p3, 1
  :L0
  .line 571
    mul-int v0, p1, p2
    div-int/2addr v0, p3
    int-to-short v0, v0
    return v0
.end method

.method public mathSpeedDown(IIZ)S
  .parameter "volue" # I
  .parameter "num" # I
  .parameter "bb" # Z
  .registers 5
  .prologue
  .line 586
    div-int v0, p1, p2
    if-eqz v0, :L1
    div-int v0, p1, p2
    sub-int/2addr p1, v0
  :L0
  .line 590
    int-to-short v0, p1
    return v0
  :L1
  .line 587
    if-eqz p3, :L2
    if-lez p1, :L2
    add-int/lit8 p1, p1, -1
    goto :L0
  :L2
  .line 588
    if-eqz p3, :L3
    if-gez p1, :L3
    add-int/lit8 p1, p1, 1
    goto :L0
  :L3
  .line 589
    const/4 p1, 0
    goto :L0
.end method

.method public mathSpeedN(IIIZ)S
  .parameter "volue" # I
  .parameter "maxv" # I
  .parameter "speed" # I
  .parameter "bb" # Z
  .registers 6
  .prologue
  .line 611
    if-le p1, p2, :L1
    sub-int v0, p1, p3
    if-le v0, p2, :L1
    sub-int/2addr p1, p3
  :L0
  .line 616
    int-to-short v0, p1
    return v0
  :L1
  .line 612
    if-ge p1, p2, :L2
    add-int v0, p1, p3
    if-ge v0, p2, :L2
    add-int/2addr p1, p3
    goto :L0
  :L2
  .line 613
    if-eqz p4, :L3
    if-le p1, p2, :L3
    add-int/lit8 p1, p1, -1
    goto :L0
  :L3
  .line 614
    if-eqz p4, :L4
    if-ge p1, p2, :L4
    add-int/lit8 p1, p1, 1
    goto :L0
  :L4
  .line 615
    move p1, p2
    goto :L0
.end method

.method public mathSpeedUp(III)S
  .parameter "volue" # I
  .parameter "max" # I
  .parameter "speed" # I
  .registers 5
  .prologue
  .line 601
    sub-int v0, p2, p1
    div-int/2addr v0, p3
    sub-int/2addr p1, v0
  .line 602
    if-gez p1, :L1
    const/4 v0, 0
  :L0
    int-to-short v0, v0
    return v0
  :L1
    move v0, p1
    goto :L0
.end method

.method public putInt(I[BI)V
  .parameter "value" # I
  .parameter "buf" # [B
  .parameter "i" # I
  .registers 6
  .prologue
  .line 166
    shr-int/lit8 v0, p1, 24
    and-int/lit16 v0, v0, 255
    int-to-byte v0, v0
    aput-byte v0, p2, p3
  .line 167
    add-int/lit8 v0, p3, 1
    shr-int/lit8 v1, p1, 16
    and-int/lit16 v1, v1, 255
    int-to-byte v1, v1
    aput-byte v1, p2, v0
  .line 168
    add-int/lit8 v0, p3, 2
    shr-int/lit8 v1, p1, 8
    and-int/lit16 v1, v1, 255
    int-to-byte v1, v1
    aput-byte v1, p2, v0
  .line 169
    add-int/lit8 v0, p3, 3
    and-int/lit16 v1, p1, 255
    int-to-byte v1, v1
    aput-byte v1, p2, v0
  .line 170
    return-void
.end method

.method public putShort(I[BI)V
  .parameter "value" # I
  .parameter "buf" # [B
  .parameter "i" # I
  .registers 6
  .prologue
  .line 175
    shr-int/lit8 v0, p1, 8
    and-int/lit16 v0, v0, 255
    int-to-byte v0, v0
    aput-byte v0, p2, p3
  .line 176
    add-int/lit8 v0, p3, 1
    and-int/lit16 v1, p1, 255
    int-to-byte v1, v1
    aput-byte v1, p2, v0
  .line 177
    return-void
.end method

.method public putShort([BI)V
  .parameter "buf" # [B
  .parameter "value" # I
  .registers 5
  .prologue
  .line 180
    sget v0, Ldm/Ms;->skip:I
    add-int/lit8 v1, v0, 1
    sput v1, Ldm/Ms;->skip:I
    shr-int/lit8 v1, p2, 8
    and-int/lit16 v1, v1, 255
    int-to-byte v1, v1
    aput-byte v1, p1, v0
  .line 181
    sget v0, Ldm/Ms;->skip:I
    add-int/lit8 v1, v0, 1
    sput v1, Ldm/Ms;->skip:I
    shr-int/lit8 v1, p2, 0
    and-int/lit16 v1, v1, 255
    int-to-byte v1, v1
    aput-byte v1, p1, v0
  .line 182
    return-void
.end method

.method public readEventNowData()[[S
  .registers 10
  .prologue
    const/4 v6, 0
  .line 121
    move-object v0, v6
    check-cast v0, [[S
    move-object v2, v0
  .line 123
  .local v2, "event_now":[[S
    new-instance v1, Ljava/io/ByteArrayInputStream;
    const/16 v7, 12
    const/4 v8, 1
    invoke-virtual { p0, v7, v6, v8 }, Ldm/Ms;->rmsOptions(I[BI)[B
    move-result-object v6
    invoke-direct { v1, v6 }, Ljava/io/ByteArrayInputStream;-><init>([B)V
  .line 124
  .local v1, "byteArray":Ljava/io/ByteArrayInputStream;
    invoke-virtual { v1 }, Ljava/io/ByteArrayInputStream;->read()I
    move-result v6
    new-array v2, v6, [[S
  .line 126
    const/4 v3, 0
  :L0
  .local v3, "i":I
    array-length v6, v2
    if-lt v3, v6, :L1
  .line 133
    return-object v2
  :L1
  .line 127
    invoke-virtual { v1 }, Ljava/io/ByteArrayInputStream;->read()I
    move-result v5
  .line 128
  .local v5, "nn":I
    if-nez v5, :L3
  :L2
  .line 126
    add-int/lit8 v3, v3, 1
    goto :L0
  :L3
  .line 129
    new-array v6, v5, [S
    aput-object v6, v2, v3
  .line 130
    const/4 v4, 0
  :L4
  .local v4, "j":I
    aget-object v6, v2, v3
    array-length v6, v6
    if-ge v4, v6, :L2
  .line 131
    aget-object v6, v2, v3
    invoke-virtual { v1 }, Ljava/io/ByteArrayInputStream;->read()I
    move-result v7
    invoke-virtual { v1 }, Ljava/io/ByteArrayInputStream;->read()I
    move-result v8
    shl-int/lit8 v8, v8, 8
    or-int/2addr v7, v8
    int-to-short v7, v7
    aput-short v7, v6, v4
  .line 130
    add-int/lit8 v4, v4, 1
    goto :L4
.end method

.method public rmsOptions(I[BI)[B
  .parameter "recordId" # I
  .parameter "info" # [B
  .parameter "flag" # I
  .catch Ljava/lang/Exception; { :L0 .. :L7 } :L8
  .catch Ljava/lang/Exception; { :L10 .. :L12 } :L8
  .registers 9
  .prologue
    const/4 v4, 0
    const/4 v3, 1
  :L0
  .line 46
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    if-nez v1, :L1
  .line 47
    const-string v1, "pk5_caihong"
    const/4 v2, 1
    invoke-static { v1, v2 }, Ljavax/microedition/rms/RecordStore;->openRecordStore(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
    move-result-object v1
    sput-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
  :L1
  .line 49
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    invoke-virtual { v1 }, Ljavax/microedition/rms/RecordStore;->getNumRecords()I
    move-result v1
    if-nez v1, :L2
  .line 50
    const/4 v1, 1
    invoke-virtual { p0, v1 }, Ldm/Ms;->setRmsInit(Z)V
  :L2
  .line 52
    if-eqz p3, :L5
  .line 54
    if-ne p3, v3, :L4
  .line 55
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    invoke-virtual { v1, p1 }, Ljavax/microedition/rms/RecordStore;->getRecord(I)[B
    move-result-object p2
    move-object v1, p2
  :L3
  .line 77
    return-object v1
  :L4
  .line 57
    const/4 v1, 2
    if-ne p3, v1, :L6
  .line 58
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    const/4 v2, 0
    array-length v3, p2
    invoke-virtual { v1, p1, p2, v2, v3 }, Ljavax/microedition/rms/RecordStore;->setRecord(I[BII)V
  :L5
    move-object v1, v4
  .line 77
    goto :L3
  :L6
  .line 59
    const/4 v1, 3
    if-ne p3, v1, :L9
  .line 60
    const/4 v1, 0
    invoke-virtual { p0, v1 }, Ldm/Ms;->setRmsInit(Z)V
  :L7
    goto :L5
  :L8
  .line 74
    move-exception v1
    move-object v0, v1
  .line 75
  .local v0, "e":Ljava/lang/Exception;
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L5
  :L9
  .line 61
  .end local v0
    const/4 v1, 4
    if-ne p3, v1, :L11
  :L10
  .line 62
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    if-eqz v1, :L5
  .line 63
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    invoke-virtual { v1 }, Ljavax/microedition/rms/RecordStore;->closeRecordStore()V
  .line 64
    const/4 v1, 0
    sput-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    goto :L5
  :L11
  .line 66
    const/4 v1, 5
    if-ne p3, v1, :L5
  .line 67
    const-string v1, "rms.getSizeAvailable() = "
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct { v2 }, Ljava/lang/StringBuilder;-><init>()V
    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    invoke-virtual { v3 }, Ljavax/microedition/rms/RecordStore;->getSizeAvailable()I
    move-result v3
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static { v1, v2 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  :L12
    move-object v1, v4
  .line 72
    goto :L3
.end method

.method public runDelay()V
  .registers 3
  .prologue
  .line 676
    sget-byte v0, Ldm/Ms;->key_delay:B
    if-lez v0, :L0
    sget-byte v0, Ldm/Ms;->key_delay:B
    const/4 v1, 1
    sub-int/2addr v0, v1
    int-to-byte v0, v0
    sput-byte v0, Ldm/Ms;->key_delay:B
  :L0
    return-void
.end method

.method public select(III)B
  .parameter "select" # I
  .parameter "min" # I
  .parameter "max" # I
  .registers 6
  .prologue
  .line 628
    if-nez p3, :L1
    int-to-byte v0, p1
  :L0
  .line 633
    return v0
  :L1
  .line 629
    sget v0, Ldm/Ms;->key:I
    invoke-static { v0 }, Ldm/Ms;->abs(I)I
    move-result v0
    rem-int/lit8 v0, v0, 2
    const/4 v1, 1
    if-ne v0, v1, :L3
    add-int/lit8 p1, p1, -1
    if-ge p1, p2, :L3
  .line 630
    move p1, p3
  :L2
  .line 633
    int-to-byte v0, p1
    goto :L0
  :L3
  .line 631
    sget v0, Ldm/Ms;->key:I
    invoke-static { v0 }, Ldm/Ms;->abs(I)I
    move-result v0
    rem-int/lit8 v0, v0, 2
    if-nez v0, :L2
    add-int/lit8 p1, p1, 1
    if-le p1, p3, :L2
  .line 632
    move p1, p2
    goto :L2
.end method

.method public selectS([BIII)V
  .parameter "select" # [B
  .parameter "min" # I
  .parameter "max" # I
  .parameter "showLine" # I
  .registers 9
  .prologue
    const/4 v3, 0
    const/4 v2, 1
  .line 636
    if-nez p3, :L1
  :L0
  .line 646
    return-void
  :L1
  .line 637
    aget-byte v0, p1, v3
    sub-int v1, p3, v2
    invoke-virtual { p0, v0, p2, v1 }, Ldm/Ms;->select(III)B
    move-result v0
    aput-byte v0, p1, v3
  .line 638
    aget-byte v0, p1, v2
    sub-int/2addr v0, v2
    aget-byte v1, p1, v3
    if-ne v0, v1, :L2
  .line 639
    aget-byte v0, p1, v2
    sub-int/2addr v0, v2
    int-to-byte v0, v0
    aput-byte v0, p1, v2
    goto :L0
  :L2
  .line 640
    aget-byte v0, p1, v2
    add-int/2addr v0, p4
    aget-byte v1, p1, v3
    if-ne v0, v1, :L3
  .line 641
    aget-byte v0, p1, v2
    add-int/lit8 v0, v0, 1
    int-to-byte v0, v0
    aput-byte v0, p1, v2
    goto :L0
  :L3
  .line 642
    aget-byte v0, p1, v3
    sub-int v1, p3, v2
    if-ne v0, v1, :L6
  .line 643
    sub-int v0, p3, p2
    if-ge v0, p4, :L5
    move v0, p2
  :L4
    int-to-byte v0, v0
    aput-byte v0, p1, v2
    goto :L0
  :L5
    sub-int v0, p3, p4
    goto :L4
  :L6
  .line 644
    aget-byte v0, p1, v3
    if-ne v0, p2, :L0
  .line 645
    int-to-byte v0, p2
    aput-byte v0, p1, v2
    goto :L0
.end method

.method public setRmsInit(Z)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/lang/Exception;
    }
  .end annotation
  .parameter "mode" # Z
  .registers 9
  .prologue
    const/4 v6, 0
  .line 85
    const/16 v3, 140
    new-array v2, v3, [B
  .line 86
  .local v2, "info":[B
    const/4 v3, -1
    aput-byte v3, v2, v6
  .line 87
    const/16 v3, 280
    new-array v0, v3, [B
  .line 88
  .local v0, "aaa":[B
    const/4 v1, 0
  :L0
  .line 89
  .local v1, "i":I
    const/16 v3, 83
    if-lt v1, v3, :L1
  .line 99
    const/4 v2, 0
    check-cast v2, [B
  .line 100
    return-void
  :L1
  .line 90
    if-nez p1, :L3
    const/4 v3, 4
    if-ne v1, v3, :L3
  :L2
  .line 89
    add-int/lit8 v1, v1, 1
    goto :L0
  :L3
  .line 91
    const/16 v3, 12
    if-eq v1, v3, :L5
  .line 92
    if-eqz p1, :L4
    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    array-length v4, v2
    invoke-virtual { v3, v2, v6, v4 }, Ljavax/microedition/rms/RecordStore;->addRecord([BII)I
    goto :L2
  :L4
  .line 93
    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    add-int/lit8 v4, v1, 1
    array-length v5, v2
    invoke-virtual { v3, v4, v2, v6, v5 }, Ljavax/microedition/rms/RecordStore;->setRecord(I[BII)V
    goto :L2
  :L5
  .line 95
    if-eqz p1, :L6
    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    array-length v4, v0
    invoke-virtual { v3, v0, v6, v4 }, Ljavax/microedition/rms/RecordStore;->addRecord([BII)I
    goto :L2
  :L6
  .line 96
    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;
    add-int/lit8 v4, v1, 1
    array-length v5, v0
    invoke-virtual { v3, v4, v0, v6, v5 }, Ljavax/microedition/rms/RecordStore;->setRecord(I[BII)V
    goto :L2
.end method

.method public setSprite(Ldm/Sprite;Ljava/lang/String;Z)V
  .parameter "sp" # Ldm/Sprite;
  .parameter "name" # Ljava/lang/String;
  .parameter "mode" # Z
  .registers 9
  .prologue
    const/4 v4, 2
  .line 506
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-static { p2 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v2, ".data"
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const/4 v2, -1
    invoke-virtual { p0, v1, v2 }, Ldm/Ms;->getStream(Ljava/lang/String;I)[B
    move-result-object v0
  .line 507
  .local v0, "date":[B
    const/4 v1, 0
    sput v1, Ldm/Ms;->skip:I
  .line 508
    invoke-virtual { p1 }, Ldm/Sprite;->nullIMFA()V
  .line 509
    if-eqz p3, :L1
  .line 510
    invoke-virtual { p0, p2 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v1
  .line 511
    invoke-virtual { p0, v0 }, Ldm/Ms;->create2Array([B)[[B
    move-result-object v2
  .line 512
    invoke-virtual { p0, v0 }, Ldm/Ms;->create3Array([B)[[[B
    move-result-object v3
  .line 513
    invoke-virtual { p0, v0 }, Ldm/Ms;->create3Array([B)[[[B
    move-result-object v4
  .line 509
    invoke-virtual { p1, v1, v2, v3, v4 }, Ldm/Sprite;->Set(Ljavax/microedition/lcdui/Image;[[B[[[B[[[B)V
  :L0
  .line 519
    const/4 v0, 0
    check-cast v0, [B
  .line 520
    return-void
  :L1
  .line 515
    invoke-virtual { p0, p2 }, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    move-result-object v1
  .line 516
    invoke-virtual { p0, v0, v4 }, Ldm/Ms;->createShort2Array([BI)[[S
    move-result-object v2
  .line 517
    invoke-virtual { p0, v0, v4 }, Ldm/Ms;->createShort3Array([BI)[[[S
    move-result-object v3
  .line 518
    invoke-virtual { p0, v0, v4 }, Ldm/Ms;->createShort3Array([BI)[[[S
    move-result-object v4
  .line 514
    invoke-virtual { p1, v1, v2, v3, v4 }, Ldm/Sprite;->Set(Ljavax/microedition/lcdui/Image;[[S[[[S[[[S)V
    goto :L0
.end method

.method public shortArrayToByteArray([S)[B
  .parameter "shortbuf" # [S
  .registers 6
  .prologue
  .line 194
    const/4 v3, 0
    sput v3, Ldm/Ms;->skip:I
  .line 195
    array-length v2, p1
  .line 196
  .local v2, "len":I
    shl-int/lit8 v3, v2, 1
    new-array v0, v3, [B
  .line 197
  .local v0, "bytebuf":[B
    const/4 v1, 0
  :L0
  .local v1, "i":I
    if-lt v1, v2, :L1
  .line 200
    return-object v0
  :L1
  .line 198
    aget-short v3, p1, v1
    invoke-virtual { p0, v0, v3 }, Ldm/Ms;->putShort([BI)V
  .line 197
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public sleep(I)V
  .parameter "time" # I
  .registers 2
  .prologue
  .line 32
    iput p1, p0, Ldm/Ms;->sleep_time:I
    return-void
.end method

.method public sqrt(I)I
  .parameter "x" # I
  .registers 5
  .prologue
  .line 550
    if-lez p1, :L2
  .line 551
    mul-int/lit16 p1, p1, 10000
  .line 552
    const/16 v0, 10000
  :L0
  .line 554
  .local v0, "b":I
    move v1, v0
  .line 555
  .local v1, "y":I
    div-int v2, p1, v0
    add-int/2addr v2, v0
    shr-int/lit8 v0, v2, 1
  .line 556
    if-lt v0, v1, :L0
  .line 557
    div-int/lit8 v1, v1, 100
    move v2, v1
  :L1
  .line 559
  .end local v0
  .end local v1
    return v2
  :L2
    const/4 v2, 0
    goto :L1
.end method
