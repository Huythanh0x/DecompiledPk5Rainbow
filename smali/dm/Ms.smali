.class public Ldm/Ms;
.super Ljava/lang/Object;
.source "Ms.java"

# interfaces
.implements Lmain/Key_H;


# static fields
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


# instance fields
.field final RMSSIZE:I

.field private sleep_time:I

.field private final transA:[B


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    const/4 v1, 0x0

    .line 561
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    sput-object v0, Ldm/Ms;->random:Ljava/util/Random;

    .line 574
    const/16 v0, 0x1a

    invoke-static {v1, v1, v0}, Ljavax/microedition/lcdui/Font;->getFont(III)Ljavax/microedition/lcdui/Font;

    move-result-object v0

    sput-object v0, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    .line 675
    sput-byte v1, Ldm/Ms;->key_delay:B

    const/16 v0, 0xa

    sput-byte v0, Ldm/Ms;->key_time:B

    .line 24
    return-void
.end method

.method public constructor <init>()V
    .registers 8

    .prologue
    const/4 v6, 0x5

    const/4 v5, 0x4

    const/4 v4, 0x3

    const/4 v3, 0x2

    const/4 v2, 0x1

    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/16 v0, 0x3c00

    iput v0, p0, Ldm/Ms;->RMSSIZE:I

    .line 429
    const/16 v0, 0x8

    new-array v0, v0, [B

    const/4 v1, 0x6

    aput-byte v1, v0, v2

    aput-byte v4, v0, v3

    aput-byte v6, v0, v4

    aput-byte v3, v0, v5

    const/4 v1, 0x7

    aput-byte v1, v0, v6

    const/4 v1, 0x6

    aput-byte v2, v0, v1

    const/4 v1, 0x7

    aput-byte v5, v0, v1

    iput-object v0, p0, Ldm/Ms;->transA:[B

    .line 26
    sput-object p0, Ldm/Ms;->msListener:Ldm/Ms;

    return-void
.end method

.method public static abs(I)I
    .registers 2
    .param p0, "a"    # I

    .prologue
    .line 565
    if-lez p0, :cond_4

    move v0, p0

    :goto_3
    return v0

    :cond_4
    neg-int v0, p0

    goto :goto_3
.end method

.method private checkIsSimulate()Z
    .registers 8

    .prologue
    const/4 v6, 0x1

    const/4 v5, -0x1

    .line 660
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Runtime;->totalMemory()J

    move-result-wide v1

    const-wide/32 v3, 0x7a1200

    cmp-long v1, v1, v3

    if-ltz v1, :cond_13

    move v1, v6

    .line 669
    :goto_12
    return v1

    .line 662
    :cond_13
    :try_start_13
    const-string v1, "emulator.Emulator"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    .line 663
    const-string v1, "com.sprintpcs.util.System"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_1d
    .catch Ljava/lang/Exception; {:try_start_13 .. :try_end_1d} :catch_1f

    move v1, v6

    .line 664
    goto :goto_12

    .line 665
    :catch_1f
    move-exception v1

    .line 666
    const-string v1, "microedition.platform"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 667
    .local v0, "platForm":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "wtk"

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    if-ne v1, v5, :cond_4c

    .line 668
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "javasdk"

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    if-ne v1, v5, :cond_4c

    .line 669
    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    const-string v2, "j2me"

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    if-ne v1, v5, :cond_4c

    const/4 v1, 0x0

    goto :goto_12

    :cond_4c
    move v1, v6

    .line 667
    goto :goto_12
.end method

.method public static compare_min(II)I
    .registers 3
    .param p0, "c0"    # I
    .param p1, "c1"    # I

    .prologue
    .line 567
    if-gt p0, p1, :cond_4

    move v0, p0

    :goto_3
    return v0

    :cond_4
    move v0, p1

    goto :goto_3
.end method

.method public static getNum([B)J
    .registers 8
    .param p0, "b"    # [B

    .prologue
    .line 142
    const/4 v2, 0x0

    .local v2, "rtn":I
    array-length v1, p0

    .line 143
    .local v1, "len":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_3
    if-lt v0, v1, :cond_7

    .line 159
    int-to-long v3, v2

    return-wide v3

    .line 144
    :cond_7
    packed-switch v1, :pswitch_data_36

    .line 143
    :goto_a
    :pswitch_a
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 146
    :pswitch_d
    aget-byte v3, p0, v0

    and-int/lit16 v3, v3, 0xff

    mul-int/lit8 v4, v0, 0x8

    shl-int/2addr v3, v4

    int-to-byte v3, v3

    add-int/2addr v2, v3

    .line 147
    goto :goto_a

    .line 149
    :pswitch_17
    aget-byte v3, p0, v0

    and-int/lit16 v3, v3, 0xff

    mul-int/lit8 v4, v0, 0x8

    shl-int/2addr v3, v4

    int-to-short v3, v3

    add-int/2addr v2, v3

    .line 150
    goto :goto_a

    .line 152
    :pswitch_21
    aget-byte v3, p0, v0

    and-int/lit16 v3, v3, 0xff

    mul-int/lit8 v4, v0, 0x8

    shl-int/2addr v3, v4

    add-int/2addr v2, v3

    .line 153
    goto :goto_a

    .line 155
    :pswitch_2a
    int-to-long v3, v2

    aget-byte v5, p0, v0

    and-int/lit16 v5, v5, 0xff

    mul-int/lit8 v6, v0, 0x8

    shl-int/2addr v5, v6

    int-to-long v5, v5

    add-long/2addr v3, v5

    long-to-int v2, v3

    goto :goto_a

    .line 144
    :pswitch_data_36
    .packed-switch 0x1
        :pswitch_d
        :pswitch_17
        :pswitch_a
        :pswitch_21
        :pswitch_a
        :pswitch_a
        :pswitch_a
        :pswitch_2a
    .end packed-switch
.end method

.method public static getRandom(I)I
    .registers 3
    .param p0, "ss"    # I

    .prologue
    .line 563
    sget-object v0, Ldm/Ms;->random:Ljava/util/Random;

    invoke-virtual {v0}, Ljava/util/Random;->nextInt()I

    move-result v0

    const v1, 0x7fffffff

    and-int/2addr v0, v1

    rem-int/2addr v0, p0

    return v0
.end method

.method private getStreamL([BI)S
    .registers 6
    .param p1, "data"    # [B
    .param p2, "mode"    # I

    .prologue
    .line 203
    if-nez p2, :cond_b

    sget v0, Ldm/Ms;->skip:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ldm/Ms;->skip:I

    aget-byte v0, p1, v0

    .line 206
    :goto_a
    return v0

    .line 204
    :cond_b
    const/4 v0, 0x1

    if-ne p2, v0, :cond_1a

    sget v0, Ldm/Ms;->skip:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ldm/Ms;->skip:I

    aget-byte v0, p1, v0

    add-int/lit8 v0, v0, 0x64

    int-to-short v0, v0

    goto :goto_a

    .line 205
    :cond_1a
    const/4 v0, 0x2

    if-ne p2, v0, :cond_36

    sget v0, Ldm/Ms;->skip:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ldm/Ms;->skip:I

    aget-byte v0, p1, v0

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x8

    sget v1, Ldm/Ms;->skip:I

    add-int/lit8 v2, v1, 0x1

    sput v2, Ldm/Ms;->skip:I

    aget-byte v1, p1, v1

    and-int/lit16 v1, v1, 0xff

    or-int/2addr v0, v1

    int-to-short v0, v0

    goto :goto_a

    .line 206
    :cond_36
    sget v0, Ldm/Ms;->skip:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ldm/Ms;->skip:I

    aget-byte v0, p1, v0

    and-int/lit16 v0, v0, 0xff

    sget v1, Ldm/Ms;->skip:I

    add-int/lit8 v2, v1, 0x1

    sput v2, Ldm/Ms;->skip:I

    aget-byte v1, p1, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x8

    or-int/2addr v0, v1

    int-to-short v0, v0

    goto :goto_a
.end method

.method public static i()Ldm/Ms;
    .registers 1

    .prologue
    .line 28
    sget-object v0, Ldm/Ms;->msListener:Ldm/Ms;

    if-nez v0, :cond_b

    new-instance v0, Ldm/Ms;

    invoke-direct {v0}, Ldm/Ms;-><init>()V

    sput-object v0, Ldm/Ms;->msListener:Ldm/Ms;

    .line 29
    :cond_b
    sget-object v0, Ldm/Ms;->msListener:Ldm/Ms;

    return-object v0
.end method


# virtual methods
.method public byteArrayToShortArray([B)[S
    .registers 6
    .param p1, "bytebuf"    # [B

    .prologue
    .line 185
    const/4 v3, 0x0

    sput v3, Ldm/Ms;->skip:I

    .line 186
    array-length v3, p1

    shr-int/lit8 v1, v3, 0x1

    .line 187
    .local v1, "len":I
    new-array v2, v1, [S

    .line 188
    .local v2, "shortbuf":[S
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_9
    if-lt v0, v1, :cond_c

    .line 191
    return-object v2

    .line 189
    :cond_c
    const/4 v3, 0x2

    invoke-direct {p0, p1, v3}, Ldm/Ms;->getStreamL([BI)S

    move-result v3

    aput-short v3, v2, v0

    .line 188
    add-int/lit8 v0, v0, 0x1

    goto :goto_9
.end method

.method public correctSelect([BII)V
    .registers 7
    .param p1, "select"    # [B
    .param p2, "max"    # I
    .param p3, "showLine"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 648
    aget-byte v0, p1, v1

    if-ge v0, p2, :cond_1b

    .line 649
    aget-byte v0, p1, v1

    sub-int/2addr v0, p3

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    aput-byte v0, p1, v2

    .line 654
    :goto_e
    aget-byte v0, p1, v1

    if-gez v0, :cond_14

    aput-byte v1, p1, v1

    .line 655
    :cond_14
    aget-byte v0, p1, v2

    if-gez v0, :cond_1a

    aput-byte v1, p1, v2

    .line 656
    :cond_1a
    return-void

    .line 651
    :cond_1b
    sub-int v0, p2, v2

    int-to-byte v0, v0

    aput-byte v0, p1, v1

    .line 652
    sub-int v0, p2, p3

    int-to-byte v0, v0

    aput-byte v0, p1, v2

    goto :goto_e
.end method

.method public create2Array([B)[[B
    .registers 6
    .param p1, "data"    # [B

    .prologue
    .line 259
    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    invoke-virtual {p0, v2}, Ldm/Ms;->getLen_byte(B)I

    move-result v2

    new-array v0, v2, [[B

    .line 260
    .local v0, "array":[[B
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_f
    array-length v2, v0

    if-lt v1, v2, :cond_13

    .line 262
    return-object v0

    .line 261
    :cond_13
    invoke-virtual {p0, p1}, Ldm/Ms;->createArray([B)[B

    move-result-object v2

    aput-object v2, v0, v1

    .line 260
    add-int/lit8 v1, v1, 0x1

    goto :goto_f
.end method

.method public create3Array([B)[[[B
    .registers 6
    .param p1, "data"    # [B

    .prologue
    .line 265
    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    invoke-virtual {p0, v2}, Ldm/Ms;->getLen_byte(B)I

    move-result v2

    new-array v0, v2, [[[B

    .line 266
    .local v0, "array":[[[B
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_f
    array-length v2, v0

    if-lt v1, v2, :cond_13

    .line 268
    return-object v0

    .line 267
    :cond_13
    invoke-virtual {p0, p1}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v2

    aput-object v2, v0, v1

    .line 266
    add-int/lit8 v1, v1, 0x1

    goto :goto_f
.end method

.method public create4Array([B)[[[[B
    .registers 6
    .param p1, "data"    # [B

    .prologue
    .line 271
    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    invoke-virtual {p0, v2}, Ldm/Ms;->getLen_byte(B)I

    move-result v2

    new-array v0, v2, [[[[B

    .line 272
    .local v0, "array":[[[[B
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_f
    array-length v2, v0

    if-lt v1, v2, :cond_13

    .line 274
    return-object v0

    .line 273
    :cond_13
    invoke-virtual {p0, p1}, Ldm/Ms;->create3Array([B)[[[B

    move-result-object v2

    aput-object v2, v0, v1

    .line 272
    add-int/lit8 v1, v1, 0x1

    goto :goto_f
.end method

.method public createArray([B)[B
    .registers 6
    .param p1, "data"    # [B

    .prologue
    .line 253
    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    invoke-virtual {p0, v2}, Ldm/Ms;->getLen_byte(B)I

    move-result v2

    new-array v0, v2, [B

    .line 254
    .local v0, "array":[B
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_f
    array-length v2, v0

    if-lt v1, v2, :cond_13

    .line 256
    return-object v0

    .line 255
    :cond_13
    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    aput-byte v2, v0, v1

    .line 254
    add-int/lit8 v1, v1, 0x1

    goto :goto_f
.end method

.method createCellImage(Ljavax/microedition/lcdui/Image;IIII)Ljavax/microedition/lcdui/Image;
    .registers 13
    .param p1, "image"    # Ljavax/microedition/lcdui/Image;
    .param p2, "cell_index"    # I
    .param p3, "cell_width"    # I
    .param p4, "cell_height"    # I
    .param p5, "trans"    # I

    .prologue
    .line 443
    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getWidth()I

    move-result v0

    div-int/2addr v0, p3

    rem-int v0, p2, v0

    mul-int v2, v0, p3

    .line 444
    .local v2, "temp_cell_x":I
    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getHeight()I

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
    invoke-virtual/range {v0 .. v6}, Ldm/Ms;->createImage(Ljavax/microedition/lcdui/Image;IIIII)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    return-object v0
.end method

.method public createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    .registers 5
    .param p1, "imageName"    # Ljava/lang/String;

    .prologue
    .line 476
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "/"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".png"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljavax/microedition/lcdui/Image;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    :try_end_18
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_18} :catch_1a

    move-result-object v1

    .line 479
    :goto_19
    return-object v1

    .line 477
    :catch_1a
    move-exception v1

    move-object v0, v1

    .line 479
    .local v0, "ex":Ljava/lang/Exception;
    const/4 v1, 0x0

    goto :goto_19
.end method

.method public createImage(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
    .registers 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "no"    # I

    .prologue
    .line 470
    invoke-virtual {p0, p1, p2}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 471
    .local v0, "data":[B
    const/4 v1, 0x0

    array-length v2, v0

    invoke-static {v0, v1, v2}, Ljavax/microedition/lcdui/Image;->createImage([BII)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    return-object v1
.end method

.method createImage(Ljavax/microedition/lcdui/Image;IIIII)Ljavax/microedition/lcdui/Image;
    .registers 13
    .param p1, "image"    # Ljavax/microedition/lcdui/Image;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "width"    # I
    .param p5, "height"    # I
    .param p6, "trans"    # I

    .prologue
    .line 431
    add-int v0, p2, p4

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getWidth()I

    move-result v1

    if-le v0, v1, :cond_e

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getWidth()I

    move-result v0

    sub-int p4, v0, p2

    .line 432
    :cond_e
    add-int v0, p3, p5

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getHeight()I

    move-result v1

    if-le v0, v1, :cond_1c

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getHeight()I

    move-result v0

    sub-int p5, v0, p3

    .line 433
    :cond_1c
    iget-object v0, p0, Ldm/Ms;->transA:[B

    aget-byte v5, v0, p6

    move-object v0, p1

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    invoke-static/range {v0 .. v5}, Ljavax/microedition/lcdui/Image;->createImage(Ljavax/microedition/lcdui/Image;IIIII)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    return-object v0
.end method

.method public createImageArray(ILjava/lang/String;)[Ljavax/microedition/lcdui/Image;
    .registers 7
    .param p1, "len"    # I
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 457
    new-array v1, p1, [Ljavax/microedition/lcdui/Image;

    .line 458
    .local v1, "img":[Ljavax/microedition/lcdui/Image;
    const/4 v0, 0x0

    .local v0, "i":S
    :goto_3
    array-length v2, v1

    if-lt v0, v2, :cond_7

    .line 460
    return-object v1

    .line 459
    :cond_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v2

    aput-object v2, v1, v0

    .line 458
    add-int/lit8 v2, v0, 0x1

    int-to-short v0, v2

    goto :goto_3
.end method

.method public createImageArray_(ILjava/lang/String;I)[Ljavax/microedition/lcdui/Image;
    .registers 8
    .param p1, "len"    # I
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "a"    # I

    .prologue
    .line 463
    new-array v1, p1, [Ljavax/microedition/lcdui/Image;

    .line 464
    .local v1, "img":[Ljavax/microedition/lcdui/Image;
    const/4 v0, 0x0

    .local v0, "i":S
    :goto_3
    array-length v2, v1

    if-lt v0, v2, :cond_7

    .line 466
    return-object v1

    .line 465
    :cond_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, p3}, Ldm/Ms;->createImage_(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;

    move-result-object v2

    aput-object v2, v1, v0

    .line 464
    add-int/lit8 v2, v0, 0x1

    int-to-short v0, v2

    goto :goto_3
.end method

.method public createImage_(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
    .registers 6
    .param p1, "imageName"    # Ljava/lang/String;
    .param p2, "a"    # I

    .prologue
    .line 484
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "/"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".png"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p2}, Ljavax/microedition/lcdui/Image;->createImage(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
    :try_end_18
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_18} :catch_1a

    move-result-object v1

    .line 487
    :goto_19
    return-object v1

    .line 485
    :catch_1a
    move-exception v1

    move-object v0, v1

    .line 487
    .local v0, "ex":Ljava/lang/Exception;
    const/4 v1, 0x0

    goto :goto_19
.end method

.method public createIntArray([B)[I
    .registers 7
    .param p1, "data"    # [B

    .prologue
    .line 226
    const/4 v2, 0x0

    invoke-direct {p0, p1, v2}, Ldm/Ms;->getStreamL([BI)S

    move-result v2

    new-array v0, v2, [I

    .line 227
    .local v0, "array":[I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_8
    array-length v2, v0

    if-lt v1, v2, :cond_c

    .line 230
    return-object v0

    .line 228
    :cond_c
    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    and-int/lit16 v2, v2, 0xff

    sget v3, Ldm/Ms;->skip:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip:I

    aget-byte v3, p1, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x8

    or-int/2addr v2, v3

    .line 229
    sget v3, Ldm/Ms;->skip:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip:I

    aget-byte v3, p1, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x10

    or-int/2addr v2, v3

    sget v3, Ldm/Ms;->skip:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip:I

    aget-byte v3, p1, v3

    and-int/lit16 v3, v3, 0xff

    shl-int/lit8 v3, v3, 0x18

    or-int/2addr v2, v3

    .line 228
    aput v2, v0, v1

    .line 227
    add-int/lit8 v1, v1, 0x1

    goto :goto_8
.end method

.method public createShort2Array([BI)[[S
    .registers 6
    .param p1, "data"    # [B
    .param p2, "mode"    # I

    .prologue
    .line 241
    invoke-direct {p0, p1, p2}, Ldm/Ms;->getStreamL([BI)S

    move-result v2

    new-array v0, v2, [[S

    .line 242
    .local v0, "array":[[S
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_7
    array-length v2, v0

    if-lt v1, v2, :cond_b

    .line 244
    return-object v0

    .line 243
    :cond_b
    invoke-virtual {p0, p1, p2}, Ldm/Ms;->createShortArray([BI)[S

    move-result-object v2

    aput-object v2, v0, v1

    .line 242
    add-int/lit8 v1, v1, 0x1

    goto :goto_7
.end method

.method public createShort3Array([BI)[[[S
    .registers 6
    .param p1, "data"    # [B
    .param p2, "mode"    # I

    .prologue
    .line 247
    invoke-direct {p0, p1, p2}, Ldm/Ms;->getStreamL([BI)S

    move-result v2

    new-array v0, v2, [[[S

    .line 248
    .local v0, "array":[[[S
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_7
    array-length v2, v0

    if-lt v1, v2, :cond_b

    .line 250
    return-object v0

    .line 249
    :cond_b
    invoke-virtual {p0, p1, p2}, Ldm/Ms;->createShort2Array([BI)[[S

    move-result-object v2

    aput-object v2, v0, v1

    .line 248
    add-int/lit8 v1, v1, 0x1

    goto :goto_7
.end method

.method public createShortArray([BI)[S
    .registers 7
    .param p1, "data"    # [B
    .param p2, "mode"    # I

    .prologue
    const/4 v3, 0x2

    .line 235
    invoke-direct {p0, p1, p2}, Ldm/Ms;->getStreamL([BI)S

    move-result v2

    new-array v0, v2, [S

    .line 236
    .local v0, "array":[S
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_8
    array-length v2, v0

    if-lt v1, v2, :cond_c

    .line 238
    return-object v0

    .line 237
    :cond_c
    if-ne p2, v3, :cond_18

    move v2, v3

    :goto_f
    invoke-direct {p0, p1, v2}, Ldm/Ms;->getStreamL([BI)S

    move-result v2

    aput-short v2, v0, v1

    .line 236
    add-int/lit8 v1, v1, 0x1

    goto :goto_8

    .line 237
    :cond_18
    const/4 v2, -0x1

    goto :goto_f
.end method

.method public createSprite(Ljava/lang/String;Z)Ldm/Sprite;
    .registers 8
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "mode"    # Z

    .prologue
    const/4 v4, 0x2

    .line 491
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ".data"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {p0, v1, v2}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 493
    .local v0, "date":[B
    const/4 v1, 0x0

    sput v1, Ldm/Ms;->skip:I

    .line 494
    if-eqz p2, :cond_33

    .line 495
    invoke-virtual {p0, p1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    .line 496
    invoke-virtual {p0, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v2

    .line 497
    invoke-virtual {p0, v0}, Ldm/Ms;->create3Array([B)[[[B

    move-result-object v3

    .line 498
    invoke-virtual {p0, v0}, Ldm/Ms;->create3Array([B)[[[B

    move-result-object v4

    .line 494
    invoke-static {v1, v2, v3, v4}, Ldm/Sprite;->Create(Ljavax/microedition/lcdui/Image;[[B[[[B[[[B)Ldm/Sprite;

    move-result-object v1

    :goto_32
    return-object v1

    .line 500
    :cond_33
    invoke-virtual {p0, p1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    .line 501
    invoke-virtual {p0, v0, v4}, Ldm/Ms;->createShort2Array([BI)[[S

    move-result-object v2

    .line 502
    invoke-virtual {p0, v0, v4}, Ldm/Ms;->createShort3Array([BI)[[[S

    move-result-object v3

    .line 503
    invoke-virtual {p0, v0, v4}, Ldm/Ms;->createShort3Array([BI)[[[S

    move-result-object v4

    .line 499
    invoke-static {v1, v2, v3, v4}, Ldm/Sprite;->Create(Ljavax/microedition/lcdui/Image;[[S[[[S[[[S)Ldm/Sprite;

    move-result-object v1

    goto :goto_32
.end method

.method public createString2Array([B)[[Ljava/lang/StringBuffer;
    .registers 7
    .param p1, "dataa"    # [B

    .prologue
    .line 292
    sget v3, Ldm/Ms;->skip:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip:I

    aget-byte v1, p1, v3

    .line 293
    .local v1, "len":B
    new-array v2, v1, [[Ljava/lang/StringBuffer;

    .line 294
    .local v2, "string":[[Ljava/lang/StringBuffer;
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_b
    array-length v3, v2

    if-lt v0, v3, :cond_f

    .line 296
    return-object v2

    .line 295
    :cond_f
    invoke-virtual {p0, p1}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v3

    aput-object v3, v2, v0

    .line 294
    add-int/lit8 v3, v0, 0x1

    int-to-byte v0, v3

    goto :goto_b
.end method

.method public createStringArray([B)[Ljava/lang/StringBuffer;
    .registers 7
    .param p1, "data"    # [B

    .prologue
    .line 279
    sget v3, Ldm/Ms;->skip:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip:I

    aget-byte v3, p1, v3

    invoke-virtual {p0, v3}, Ldm/Ms;->getLen_byte(B)I

    move-result v3

    new-array v2, v3, [Ljava/lang/StringBuffer;

    .line 280
    .local v2, "string":[Ljava/lang/StringBuffer;
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_f
    array-length v3, v2

    if-lt v0, v3, :cond_13

    .line 286
    return-object v2

    .line 281
    :cond_13
    sget v3, Ldm/Ms;->skip:I

    aget-byte v1, p1, v3

    .line 282
    .local v1, "l_c":S
    if-gez v1, :cond_1c

    add-int/lit16 v3, v1, 0x100

    int-to-short v1, v3

    .line 283
    :cond_1c
    new-instance v3, Ljava/lang/StringBuffer;

    sget v4, Ldm/Ms;->skip:I

    add-int/lit8 v4, v4, 0x1

    invoke-virtual {p0, p1, v4, v1}, Ldm/Ms;->getDialogs([BII)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    aput-object v3, v2, v0

    .line 284
    sget v3, Ldm/Ms;->skip:I

    mul-int/lit8 v4, v1, 0x2

    add-int/lit8 v4, v4, 0x1

    add-int/2addr v3, v4

    sput v3, Ldm/Ms;->skip:I

    .line 280
    add-int/lit8 v3, v0, 0x1

    int-to-byte v0, v3

    goto :goto_f
.end method

.method public createStringArrayOne([B)Ljava/lang/StringBuffer;
    .registers 5
    .param p1, "data"    # [B

    .prologue
    .line 289
    new-instance v0, Ljava/lang/StringBuffer;

    const/4 v1, 0x2

    const/4 v2, 0x1

    aget-byte v2, p1, v2

    invoke-virtual {p0, v2}, Ldm/Ms;->getLen_byte(B)I

    move-result v2

    invoke-virtual {p0, p1, v1, v2}, Ldm/Ms;->getDialogs([BII)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z
    .registers 4
    .param p1, "sbuff"    # Ljava/lang/StringBuffer;
    .param p2, "str"    # Ljava/lang/String;

    .prologue
    .line 524
    invoke-virtual {p1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public getDialogs([BII)Ljava/lang/String;
    .registers 8
    .param p1, "data"    # [B
    .param p2, "start"    # I
    .param p3, "len"    # I

    .prologue
    .line 310
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 312
    .local v0, "dialog":Ljava/lang/StringBuffer;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_6
    if-lt v1, p3, :cond_d

    .line 315
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 313
    :cond_d
    shl-int/lit8 v2, v1, 0x1

    add-int/2addr v2, p2

    aget-byte v2, p1, v2

    shl-int/lit8 v2, v2, 0x8

    .line 314
    shl-int/lit8 v3, v1, 0x1

    add-int/2addr v3, p2

    add-int/lit8 v3, v3, 0x1

    aget-byte v3, p1, v3

    and-int/lit16 v3, v3, 0xff

    or-int/2addr v2, v3

    int-to-char v2, v2

    .line 313
    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 312
    add-int/lit8 v1, v1, 0x1

    goto :goto_6
.end method

.method public getEventNowData([[S)[B
    .registers 6
    .param p1, "event_now"    # [[S

    .prologue
    .line 104
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 105
    .local v0, "byteArray":Ljava/io/ByteArrayOutputStream;
    array-length v3, p1

    invoke-virtual {v0, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 107
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_a
    array-length v3, p1

    if-lt v1, v3, :cond_12

    .line 118
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    return-object v3

    .line 108
    :cond_12
    aget-object v3, p1, v1

    if-nez v3, :cond_1d

    .line 109
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 107
    :cond_1a
    add-int/lit8 v1, v1, 0x1

    goto :goto_a

    .line 112
    :cond_1d
    aget-object v3, p1, v1

    array-length v3, v3

    invoke-virtual {v0, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 113
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_24
    aget-object v3, p1, v1

    array-length v3, v3

    if-ge v2, v3, :cond_1a

    .line 114
    aget-object v3, p1, v1

    aget-short v3, v3, v2

    and-int/lit16 v3, v3, 0xff

    invoke-virtual {v0, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 115
    aget-object v3, p1, v1

    aget-short v3, v3, v2

    shr-int/lit8 v3, v3, 0x8

    and-int/lit16 v3, v3, 0xff

    invoke-virtual {v0, v3}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 113
    add-int/lit8 v2, v2, 0x1

    goto :goto_24
.end method

.method public getInt([BI)I
    .registers 5
    .param p1, "buf"    # [B
    .param p2, "i"    # I

    .prologue
    .line 163
    aget-byte v0, p1, p2

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x18

    add-int/lit8 v1, p2, 0x1

    aget-byte v1, p1, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x10

    or-int/2addr v0, v1

    .line 164
    add-int/lit8 v1, p2, 0x2

    aget-byte v1, p1, v1

    and-int/lit16 v1, v1, 0xff

    shl-int/lit8 v1, v1, 0x8

    .line 163
    or-int/2addr v0, v1

    .line 164
    add-int/lit8 v1, p2, 0x3

    aget-byte v1, p1, v1

    and-int/lit16 v1, v1, 0xff

    .line 163
    or-int/2addr v0, v1

    return v0
.end method

.method public getLen_byte(B)I
    .registers 3
    .param p1, "value"    # B

    .prologue
    .line 161
    if-gez p1, :cond_5

    add-int/lit16 v0, p1, 0x100

    :goto_4
    return v0

    :cond_5
    move v0, p1

    goto :goto_4
.end method

.method public getLen_short(S)I
    .registers 3
    .param p1, "value"    # S

    .prologue
    .line 162
    if-gez p1, :cond_6

    const/high16 v0, 0x10000

    add-int/2addr v0, p1

    :goto_5
    return v0

    :cond_6
    move v0, p1

    goto :goto_5
.end method

.method public getMin(BB)B
    .registers 4
    .param p1, "i0"    # B
    .param p2, "i1"    # B

    .prologue
    .line 577
    if-le p1, p2, :cond_4

    move v0, p2

    :goto_3
    return v0

    :cond_4
    move v0, p1

    goto :goto_3
.end method

.method public getPrecision(I)Ljava/lang/String;
    .registers 4
    .param p1, "t"    # I

    .prologue
    .line 537
    new-instance v0, Ljava/lang/StringBuilder;

    div-int/lit8 v1, p1, 0xa

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    rem-int/lit8 v1, p1, 0xa

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getShort([BI)S
    .registers 5
    .param p1, "buf"    # [B
    .param p2, "i"    # I

    .prologue
    .line 173
    aget-byte v0, p1, p2

    and-int/lit16 v0, v0, 0xff

    shl-int/lit8 v0, v0, 0x8

    add-int/lit8 v1, p2, 0x1

    aget-byte v1, p1, v1

    and-int/lit16 v1, v1, 0xff

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
    .registers 9
    .param p1, "i"    # Ljava/lang/String;
    .param p2, "num"    # I

    .prologue
    .line 209
    const/4 v0, 0x0

    check-cast v0, [B

    .line 212
    .local v0, "data":[B
    :try_start_3
    new-instance v1, Ljava/io/DataInputStream;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "/"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/android/Util/AndroidUtil;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v4

    invoke-direct {v1, v4}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 213
    .local v1, "dataInput":Ljava/io/DataInputStream;
    const/4 v4, -0x1

    if-le p2, v4, :cond_24

    .line 214
    invoke-virtual {v1}, Ljava/io/DataInputStream;->readByte()B

    .line 215
    const/4 v3, 0x0

    .local v3, "n":B
    :goto_22
    if-lt v3, p2, :cond_36

    .line 218
    .end local v3    # "n":B
    :cond_24
    invoke-virtual {v1}, Ljava/io/DataInputStream;->readShort()S

    move-result v4

    invoke-virtual {p0, v4}, Ldm/Ms;->getLen_short(S)I

    move-result v4

    new-array v0, v4, [B

    .line 219
    invoke-virtual {v1, v0}, Ljava/io/DataInputStream;->read([B)I

    .line 220
    invoke-virtual {v1}, Ljava/io/DataInputStream;->close()V

    .line 221
    const/4 v1, 0x0

    .line 223
    .end local v1    # "dataInput":Ljava/io/DataInputStream;
    :goto_35
    return-object v0

    .line 216
    .restart local v1    # "dataInput":Ljava/io/DataInputStream;
    .restart local v3    # "n":B
    :cond_36
    invoke-virtual {v1}, Ljava/io/DataInputStream;->readShort()S

    move-result v4

    invoke-virtual {p0, v4}, Ldm/Ms;->getLen_short(S)I

    move-result v4

    int-to-long v4, v4

    invoke-virtual {v1, v4, v5}, Ljava/io/DataInputStream;->skip(J)J
    :try_end_42
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_42} :catch_46

    .line 215
    add-int/lit8 v4, v3, 0x1

    int-to-byte v3, v4

    goto :goto_22

    .line 222
    .end local v1    # "dataInput":Ljava/io/DataInputStream;
    .end local v3    # "n":B
    :catch_46
    move-exception v4

    move-object v2, v4

    .local v2, "ex":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_35
.end method

.method public getStringWidth(Ljava/lang/String;)I
    .registers 3
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 576
    sget-object v0, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v0, p1}, Ljavax/microedition/lcdui/Font;->stringWidth(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;
    .registers 17
    .param p1, "info"    # Ljava/lang/String;
    .param p2, "width"    # I

    .prologue
    .line 323
    const/16 v11, 0x1e

    new-array v9, v11, [Ljava/lang/StringBuffer;

    .line 324
    .local v9, "tempResult":[Ljava/lang/StringBuffer;
    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    .line 325
    .local v8, "temp":Ljava/lang/StringBuffer;
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3, p1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 326
    .local v3, "orig":Ljava/lang/StringBuffer;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v11

    int-to-short v1, v11

    .line 327
    .local v1, "infoLength":S
    const/4 v6, 0x0

    .local v6, "tc":B
    const-string v11, "#0"

    invoke-virtual {p0, v11}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v11

    int-to-byte v10, v11

    .local v10, "tw":B
    const/4 v5, -0x1

    .line 328
    .local v5, "rows":B
    const/4 v2, 0x0

    .line 329
    .local v2, "isNewRow":Z
    const-string v7, ""

    .line 331
    .local v7, "tcolor":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_20
    if-lt v0, v1, :cond_34

    .line 363
    add-int/lit8 v11, v5, 0x1

    new-array v4, v11, [Ljava/lang/StringBuffer;

    .line 364
    .local v4, "result":[Ljava/lang/StringBuffer;
    const/4 v11, 0x0

    const/4 v12, 0x0

    add-int/lit8 v13, v5, 0x1

    invoke-static {v9, v11, v4, v12, v13}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 365
    const/4 v9, 0x0

    check-cast v9, [Ljava/lang/StringBuffer;

    .line 366
    const/4 v3, 0x0

    move-object v8, v3

    .line 367
    const/4 v7, 0x0

    .line 368
    return-object v4

    .line 332
    .end local v4    # "result":[Ljava/lang/StringBuffer;
    :cond_34
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v11

    const/16 v12, 0x23

    if-ne v11, v12, :cond_88

    .line 333
    const/4 v11, 0x1

    invoke-virtual {v3, v11}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v11

    const/16 v12, 0x6e

    if-ne v11, v12, :cond_6d

    const/4 v2, 0x1

    .line 339
    :goto_47
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 340
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 341
    add-int/lit8 v0, v0, 0x1

    .line 353
    :cond_51
    :goto_51
    if-eqz v2, :cond_6a

    .line 354
    add-int/lit8 v11, v5, 0x1

    int-to-byte v5, v11

    .line 355
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v11

    if-nez v11, :cond_c1

    const/4 v11, 0x0

    :goto_5d
    int-to-byte v6, v11

    .line 356
    const/4 v2, 0x0

    .line 357
    aput-object v8, v9, v5

    .line 358
    const/4 v8, 0x0

    .line 359
    new-instance v8, Ljava/lang/StringBuffer;

    .end local v8    # "temp":Ljava/lang/StringBuffer;
    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    .line 360
    .restart local v8    # "temp":Ljava/lang/StringBuffer;
    invoke-virtual {v8, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 331
    :cond_6a
    add-int/lit8 v0, v0, 0x1

    goto :goto_20

    .line 335
    :cond_6d
    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "#"

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v12, 0x1

    invoke-virtual {v3, v12}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 336
    invoke-virtual {v8, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 337
    add-int/lit8 v11, v6, 0x1

    int-to-byte v6, v11

    goto :goto_47

    .line 343
    :cond_88
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v11

    invoke-virtual {v8, v11}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 344
    if-eqz p2, :cond_ad

    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {p0, v11}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v11

    mul-int v12, v10, v6

    add-int v12, v12, p2

    if-gt v11, v12, :cond_ad

    .line 345
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 351
    :goto_a4
    const/4 v11, 0x1

    sub-int v11, v1, v11

    if-ne v0, v11, :cond_51

    if-nez v2, :cond_51

    const/4 v2, 0x1

    goto :goto_51

    .line 346
    :cond_ad
    if-eqz p2, :cond_bc

    .line 347
    add-int/lit8 v0, v0, -0x1

    .line 348
    invoke-virtual {v8}, Ljava/lang/StringBuffer;->length()I

    move-result v11

    const/4 v12, 0x1

    sub-int/2addr v11, v12

    invoke-virtual {v8, v11}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    .line 349
    const/4 v2, 0x1

    goto :goto_a4

    .line 350
    :cond_bc
    const/4 v11, 0x0

    invoke-virtual {v3, v11}, Ljava/lang/StringBuffer;->deleteCharAt(I)Ljava/lang/StringBuffer;

    goto :goto_a4

    .line 355
    :cond_c1
    const/4 v11, 0x1

    goto :goto_5d
.end method

.method public isRect(IIIIIIII)Z
    .registers 10
    .param p1, "a0"    # I
    .param p2, "a1"    # I
    .param p3, "aw"    # I
    .param p4, "ah"    # I
    .param p5, "b0"    # I
    .param p6, "b1"    # I
    .param p7, "bw"    # I
    .param p8, "bh"    # I

    .prologue
    .line 529
    add-int v0, p5, p7

    if-ge p1, v0, :cond_12

    add-int v0, p1, p3

    if-le v0, p5, :cond_12

    add-int v0, p6, p8

    if-ge p2, v0, :cond_12

    add-int v0, p2, p4

    if-le v0, p6, :cond_12

    const/4 v0, 0x1

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x0

    goto :goto_11
.end method

.method public keyRelease()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    .line 685
    sput-boolean v0, Ldm/Ms;->keyRepeat:Z

    sput-byte v0, Ldm/Ms;->key_delay:B

    const/16 v0, 0xa

    sput-byte v0, Ldm/Ms;->key_time:B

    return-void
.end method

.method public key_Down()Z
    .registers 3

    .prologue
    .line 688
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x2

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public key_Left()Z
    .registers 3

    .prologue
    .line 690
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x3

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public key_Left_Right()Z
    .registers 3

    .prologue
    .line 689
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x3

    if-eq v0, v1, :cond_c

    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x4

    if-eq v0, v1, :cond_c

    const/4 v0, 0x0

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x1

    goto :goto_b
.end method

.method public key_Num0()Z
    .registers 3

    .prologue
    .line 700
    sget v0, Ldm/Ms;->key:I

    const/16 v1, 0x30

    if-ne v0, v1, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public key_Num1()Z
    .registers 3

    .prologue
    .line 701
    sget v0, Ldm/Ms;->key:I

    const/16 v1, 0x31

    if-ne v0, v1, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public key_Num3()Z
    .registers 3

    .prologue
    .line 702
    sget v0, Ldm/Ms;->key:I

    const/16 v1, 0x33

    if-ne v0, v1, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public key_Num9()Z
    .registers 3

    .prologue
    .line 703
    sget v0, Ldm/Ms;->key:I

    const/16 v1, 0x39

    if-ne v0, v1, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public key_Right()Z
    .registers 3

    .prologue
    .line 691
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x4

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public key_S1()Z
    .registers 3

    .prologue
    .line 697
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x6

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public key_S1_Num5()Z
    .registers 3

    .prologue
    .line 692
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x6

    if-eq v0, v1, :cond_12

    sget v0, Ldm/Ms;->key:I

    const/16 v1, 0x35

    if-eq v0, v1, :cond_12

    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x5

    if-eq v0, v1, :cond_12

    const/4 v0, 0x0

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x1

    goto :goto_11
.end method

.method public key_S2()Z
    .registers 3

    .prologue
    .line 698
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x7

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public key_Up()Z
    .registers 3

    .prologue
    .line 687
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    :goto_6
    return v0

    :cond_7
    const/4 v0, 0x0

    goto :goto_6
.end method

.method public key_Up_Down()Z
    .registers 3

    .prologue
    .line 686
    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_c

    sget v0, Ldm/Ms;->key:I

    const/4 v1, -0x2

    if-eq v0, v1, :cond_c

    const/4 v0, 0x0

    :goto_b
    return v0

    :cond_c
    const/4 v0, 0x1

    goto :goto_b
.end method

.method public key_delay()Z
    .registers 3

    .prologue
    const/4 v1, 0x1

    .line 678
    sget-byte v0, Ldm/Ms;->key_delay:B

    if-nez v0, :cond_15

    .line 679
    sget-byte v0, Ldm/Ms;->key_time:B

    sput-byte v0, Ldm/Ms;->key_delay:B

    .line 680
    sget-byte v0, Ldm/Ms;->key_time:B

    if-le v0, v1, :cond_13

    sget-byte v0, Ldm/Ms;->key_time:B

    sub-int/2addr v0, v1

    int-to-byte v0, v0

    sput-byte v0, Ldm/Ms;->key_time:B

    .line 681
    :cond_13
    const/4 v0, 0x0

    .line 683
    :goto_14
    return v0

    :cond_15
    move v0, v1

    goto :goto_14
.end method

.method public loadText([B)[Ljava/lang/String;
    .registers 16
    .param p1, "word_uni"    # [B

    .prologue
    .line 378
    :try_start_0
    new-instance v9, Ljava/lang/StringBuffer;

    const-string v12, ""

    invoke-direct {v9, v12}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 380
    .local v9, "stringbuffer":Ljava/lang/StringBuffer;
    const/4 v2, 0x2

    .local v2, "j":I
    move v3, v2

    .end local v2    # "j":I
    .local v3, "j":I
    :goto_9
    array-length v12, p1

    if-lt v3, v12, :cond_30

    .line 388
    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    .line 389
    .local v8, "strReturn":Ljava/lang/String;
    const/4 v9, 0x0

    .line 390
    new-instance v11, Ljava/util/Vector;

    invoke-direct {v11}, Ljava/util/Vector;-><init>()V

    .line 391
    .local v11, "vecString":Ljava/util/Vector;
    const/4 v4, 0x0

    .line 392
    .local v4, "k":I
    const/4 v5, 0x0

    .line 393
    .local v5, "l":I
    const/4 v2, 0x0

    .end local v3    # "j":I
    .restart local v2    # "j":I
    :goto_19
    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v12

    if-lt v2, v12, :cond_4f

    .line 402
    const/4 v8, 0x0

    .line 404
    invoke-virtual {v11}, Ljava/util/Vector;->size()I

    move-result v12

    new-array v6, v12, [Ljava/lang/String;

    .line 406
    .local v6, "reStr":[Ljava/lang/String;
    const/4 v2, 0x0

    :goto_27
    invoke-virtual {v11}, Ljava/util/Vector;->size()I

    move-result v12

    if-lt v2, v12, :cond_6b

    .line 410
    const/4 v11, 0x0

    move-object v12, v6

    .line 416
    .end local v2    # "j":I
    .end local v4    # "k":I
    .end local v5    # "l":I
    .end local v6    # "reStr":[Ljava/lang/String;
    .end local v8    # "strReturn":Ljava/lang/String;
    .end local v9    # "stringbuffer":Ljava/lang/StringBuffer;
    .end local v11    # "vecString":Ljava/util/Vector;
    :goto_2f
    return-object v12

    .line 381
    .restart local v3    # "j":I
    .restart local v9    # "stringbuffer":Ljava/lang/StringBuffer;
    :cond_30
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "j":I
    .restart local v2    # "j":I
    aget-byte v4, p1, v3

    .line 382
    .restart local v4    # "k":I
    if-gez v4, :cond_38

    add-int/lit16 v4, v4, 0x100

    .line 383
    :cond_38
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "j":I
    .restart local v3    # "j":I
    aget-byte v5, p1, v2

    .line 384
    .restart local v5    # "l":I
    if-gez v5, :cond_40

    add-int/lit16 v5, v5, 0x100

    .line 385
    :cond_40
    shl-int/lit8 v12, v5, 0x8

    add-int/2addr v12, v4

    int-to-char v0, v12

    .line 386
    .local v0, "c":C
    invoke-virtual {v9, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;
    :try_end_47
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_47} :catch_48

    goto :goto_9

    .line 412
    .end local v0    # "c":C
    .end local v3    # "j":I
    .end local v4    # "k":I
    .end local v5    # "l":I
    .end local v9    # "stringbuffer":Ljava/lang/StringBuffer;
    :catch_48
    move-exception v12

    move-object v1, v12

    .line 413
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 414
    const/4 v12, 0x0

    goto :goto_2f

    .line 395
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v2    # "j":I
    .restart local v4    # "k":I
    .restart local v5    # "l":I
    .restart local v8    # "strReturn":Ljava/lang/String;
    .restart local v9    # "stringbuffer":Ljava/lang/StringBuffer;
    .restart local v11    # "vecString":Ljava/util/Vector;
    :cond_4f
    :try_start_4f
    invoke-virtual {v8, v2}, Ljava/lang/String;->charAt(I)C

    move-result v12

    const/16 v13, 0xa

    if-eq v12, v13, :cond_5d

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v12

    if-ne v2, v12, :cond_66

    .line 396
    :cond_5d
    invoke-virtual {v8, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    .line 397
    .local v10, "temp":Ljava/lang/String;
    invoke-virtual {v11, v10}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 398
    add-int/lit8 v4, v5, 0x1

    .line 400
    .end local v10    # "temp":Ljava/lang/String;
    :cond_66
    add-int/lit8 v5, v5, 0x1

    .line 393
    add-int/lit8 v2, v2, 0x1

    goto :goto_19

    .line 407
    .restart local v6    # "reStr":[Ljava/lang/String;
    :cond_6b
    invoke-virtual {v11, v2}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    .line 408
    .local v7, "s":Ljava/lang/String;
    aput-object v7, v6, v2
    :try_end_73
    .catch Ljava/lang/Exception; {:try_start_4f .. :try_end_73} :catch_48

    .line 406
    add-int/lit8 v2, v2, 0x1

    goto :goto_27
.end method

.method public mathPercent(III)S
    .registers 5
    .param p1, "m0"    # I
    .param p2, "m1"    # I
    .param p3, "per"    # I

    .prologue
    .line 570
    const/4 v0, 0x1

    if-ge p3, v0, :cond_4

    const/4 p3, 0x1

    .line 571
    :cond_4
    mul-int v0, p1, p2

    div-int/2addr v0, p3

    int-to-short v0, v0

    return v0
.end method

.method public mathSpeedDown(IIZ)S
    .registers 5
    .param p1, "volue"    # I
    .param p2, "num"    # I
    .param p3, "bb"    # Z

    .prologue
    .line 586
    div-int v0, p1, p2

    if-eqz v0, :cond_9

    div-int v0, p1, p2

    sub-int/2addr p1, v0

    .line 590
    :goto_7
    int-to-short v0, p1

    return v0

    .line 587
    :cond_9
    if-eqz p3, :cond_10

    if-lez p1, :cond_10

    add-int/lit8 p1, p1, -0x1

    goto :goto_7

    .line 588
    :cond_10
    if-eqz p3, :cond_17

    if-gez p1, :cond_17

    add-int/lit8 p1, p1, 0x1

    goto :goto_7

    .line 589
    :cond_17
    const/4 p1, 0x0

    goto :goto_7
.end method

.method public mathSpeedN(IIIZ)S
    .registers 6
    .param p1, "volue"    # I
    .param p2, "maxv"    # I
    .param p3, "speed"    # I
    .param p4, "bb"    # Z

    .prologue
    .line 611
    if-le p1, p2, :cond_9

    sub-int v0, p1, p3

    if-le v0, p2, :cond_9

    sub-int/2addr p1, p3

    .line 616
    :goto_7
    int-to-short v0, p1

    return v0

    .line 612
    :cond_9
    if-ge p1, p2, :cond_11

    add-int v0, p1, p3

    if-ge v0, p2, :cond_11

    add-int/2addr p1, p3

    goto :goto_7

    .line 613
    :cond_11
    if-eqz p4, :cond_18

    if-le p1, p2, :cond_18

    add-int/lit8 p1, p1, -0x1

    goto :goto_7

    .line 614
    :cond_18
    if-eqz p4, :cond_1f

    if-ge p1, p2, :cond_1f

    add-int/lit8 p1, p1, 0x1

    goto :goto_7

    .line 615
    :cond_1f
    move p1, p2

    goto :goto_7
.end method

.method public mathSpeedUp(III)S
    .registers 5
    .param p1, "volue"    # I
    .param p2, "max"    # I
    .param p3, "speed"    # I

    .prologue
    .line 601
    sub-int v0, p2, p1

    div-int/2addr v0, p3

    sub-int/2addr p1, v0

    .line 602
    if-gez p1, :cond_9

    const/4 v0, 0x0

    :goto_7
    int-to-short v0, v0

    return v0

    :cond_9
    move v0, p1

    goto :goto_7
.end method

.method public putInt(I[BI)V
    .registers 6
    .param p1, "value"    # I
    .param p2, "buf"    # [B
    .param p3, "i"    # I

    .prologue
    .line 166
    shr-int/lit8 v0, p1, 0x18

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    aput-byte v0, p2, p3

    .line 167
    add-int/lit8 v0, p3, 0x1

    shr-int/lit8 v1, p1, 0x10

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p2, v0

    .line 168
    add-int/lit8 v0, p3, 0x2

    shr-int/lit8 v1, p1, 0x8

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p2, v0

    .line 169
    add-int/lit8 v0, p3, 0x3

    and-int/lit16 v1, p1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p2, v0

    .line 170
    return-void
.end method

.method public putShort(I[BI)V
    .registers 6
    .param p1, "value"    # I
    .param p2, "buf"    # [B
    .param p3, "i"    # I

    .prologue
    .line 175
    shr-int/lit8 v0, p1, 0x8

    and-int/lit16 v0, v0, 0xff

    int-to-byte v0, v0

    aput-byte v0, p2, p3

    .line 176
    add-int/lit8 v0, p3, 0x1

    and-int/lit16 v1, p1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p2, v0

    .line 177
    return-void
.end method

.method public putShort([BI)V
    .registers 5
    .param p1, "buf"    # [B
    .param p2, "value"    # I

    .prologue
    .line 180
    sget v0, Ldm/Ms;->skip:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ldm/Ms;->skip:I

    shr-int/lit8 v1, p2, 0x8

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p1, v0

    .line 181
    sget v0, Ldm/Ms;->skip:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ldm/Ms;->skip:I

    shr-int/lit8 v1, p2, 0x0

    and-int/lit16 v1, v1, 0xff

    int-to-byte v1, v1

    aput-byte v1, p1, v0

    .line 182
    return-void
.end method

.method public readEventNowData()[[S
    .registers 10

    .prologue
    const/4 v6, 0x0

    .line 121
    move-object v0, v6

    check-cast v0, [[S

    move-object v2, v0

    .line 123
    .local v2, "event_now":[[S
    new-instance v1, Ljava/io/ByteArrayInputStream;

    const/16 v7, 0xc

    const/4 v8, 0x1

    invoke-virtual {p0, v7, v6, v8}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v6

    invoke-direct {v1, v6}, Ljava/io/ByteArrayInputStream;-><init>([B)V

    .line 124
    .local v1, "byteArray":Ljava/io/ByteArrayInputStream;
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->read()I

    move-result v6

    new-array v2, v6, [[S

    .line 126
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_18
    array-length v6, v2

    if-lt v3, v6, :cond_1c

    .line 133
    return-object v2

    .line 127
    :cond_1c
    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->read()I

    move-result v5

    .line 128
    .local v5, "nn":I
    if-nez v5, :cond_25

    .line 126
    :cond_22
    add-int/lit8 v3, v3, 0x1

    goto :goto_18

    .line 129
    :cond_25
    new-array v6, v5, [S

    aput-object v6, v2, v3

    .line 130
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_2a
    aget-object v6, v2, v3

    array-length v6, v6

    if-ge v4, v6, :cond_22

    .line 131
    aget-object v6, v2, v3

    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->read()I

    move-result v7

    invoke-virtual {v1}, Ljava/io/ByteArrayInputStream;->read()I

    move-result v8

    shl-int/lit8 v8, v8, 0x8

    or-int/2addr v7, v8

    int-to-short v7, v7

    aput-short v7, v6, v4

    .line 130
    add-int/lit8 v4, v4, 0x1

    goto :goto_2a
.end method

.method public rmsOptions(I[BI)[B
    .registers 9
    .param p1, "recordId"    # I
    .param p2, "info"    # [B
    .param p3, "flag"    # I

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 46
    :try_start_2
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    if-nez v1, :cond_f

    .line 47
    const-string v1, "pk5_caihong"

    const/4 v2, 0x1

    invoke-static {v1, v2}, Ljavax/microedition/rms/RecordStore;->openRecordStore(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;

    move-result-object v1

    sput-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    .line 49
    :cond_f
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    invoke-virtual {v1}, Ljavax/microedition/rms/RecordStore;->getNumRecords()I

    move-result v1

    if-nez v1, :cond_1b

    .line 50
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Ldm/Ms;->setRmsInit(Z)V

    .line 52
    :cond_1b
    if-eqz p3, :cond_31

    .line 54
    if-ne p3, v3, :cond_27

    .line 55
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    invoke-virtual {v1, p1}, Ljavax/microedition/rms/RecordStore;->getRecord(I)[B

    move-result-object p2

    move-object v1, p2

    .line 77
    :goto_26
    return-object v1

    .line 57
    :cond_27
    const/4 v1, 0x2

    if-ne p3, v1, :cond_33

    .line 58
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    const/4 v2, 0x0

    array-length v3, p2

    invoke-virtual {v1, p1, p2, v2, v3}, Ljavax/microedition/rms/RecordStore;->setRecord(I[BII)V

    :cond_31
    :goto_31
    move-object v1, v4

    .line 77
    goto :goto_26

    .line 59
    :cond_33
    const/4 v1, 0x3

    if-ne p3, v1, :cond_41

    .line 60
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Ldm/Ms;->setRmsInit(Z)V
    :try_end_3a
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_3a} :catch_3b

    goto :goto_31

    .line 74
    :catch_3b
    move-exception v1

    move-object v0, v1

    .line 75
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_31

    .line 61
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_41
    const/4 v1, 0x4

    if-ne p3, v1, :cond_51

    .line 62
    :try_start_44
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    if-eqz v1, :cond_31

    .line 63
    sget-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    invoke-virtual {v1}, Ljavax/microedition/rms/RecordStore;->closeRecordStore()V

    .line 64
    const/4 v1, 0x0

    sput-object v1, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    goto :goto_31

    .line 66
    :cond_51
    const/4 v1, 0x5

    if-ne p3, v1, :cond_31

    .line 67
    const-string v1, "rms.getSizeAvailable() = "

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    invoke-virtual {v3}, Ljavax/microedition/rms/RecordStore;->getSizeAvailable()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6c
    .catch Ljava/lang/Exception; {:try_start_44 .. :try_end_6c} :catch_3b

    move-object v1, v4

    .line 72
    goto :goto_26
.end method

.method public runDelay()V
    .registers 3

    .prologue
    .line 676
    sget-byte v0, Ldm/Ms;->key_delay:B

    if-lez v0, :cond_b

    sget-byte v0, Ldm/Ms;->key_delay:B

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    int-to-byte v0, v0

    sput-byte v0, Ldm/Ms;->key_delay:B

    :cond_b
    return-void
.end method

.method public select(III)B
    .registers 6
    .param p1, "select"    # I
    .param p2, "min"    # I
    .param p3, "max"    # I

    .prologue
    .line 628
    if-nez p3, :cond_4

    int-to-byte v0, p1

    .line 633
    :goto_3
    return v0

    .line 629
    :cond_4
    sget v0, Ldm/Ms;->key:I

    invoke-static {v0}, Ldm/Ms;->abs(I)I

    move-result v0

    rem-int/lit8 v0, v0, 0x2

    const/4 v1, 0x1

    if-ne v0, v1, :cond_16

    add-int/lit8 p1, p1, -0x1

    if-ge p1, p2, :cond_16

    .line 630
    move p1, p3

    .line 633
    :cond_14
    :goto_14
    int-to-byte v0, p1

    goto :goto_3

    .line 631
    :cond_16
    sget v0, Ldm/Ms;->key:I

    invoke-static {v0}, Ldm/Ms;->abs(I)I

    move-result v0

    rem-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_14

    add-int/lit8 p1, p1, 0x1

    if-le p1, p3, :cond_14

    .line 632
    move p1, p2

    goto :goto_14
.end method

.method public selectS([BIII)V
    .registers 9
    .param p1, "select"    # [B
    .param p2, "min"    # I
    .param p3, "max"    # I
    .param p4, "showLine"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 636
    if-nez p3, :cond_5

    .line 646
    :cond_4
    :goto_4
    return-void

    .line 637
    :cond_5
    aget-byte v0, p1, v3

    sub-int v1, p3, v2

    invoke-virtual {p0, v0, p2, v1}, Ldm/Ms;->select(III)B

    move-result v0

    aput-byte v0, p1, v3

    .line 638
    aget-byte v0, p1, v2

    sub-int/2addr v0, v2

    aget-byte v1, p1, v3

    if-ne v0, v1, :cond_1d

    .line 639
    aget-byte v0, p1, v2

    sub-int/2addr v0, v2

    int-to-byte v0, v0

    aput-byte v0, p1, v2

    goto :goto_4

    .line 640
    :cond_1d
    aget-byte v0, p1, v2

    add-int/2addr v0, p4

    aget-byte v1, p1, v3

    if-ne v0, v1, :cond_2c

    .line 641
    aget-byte v0, p1, v2

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    aput-byte v0, p1, v2

    goto :goto_4

    .line 642
    :cond_2c
    aget-byte v0, p1, v3

    sub-int v1, p3, v2

    if-ne v0, v1, :cond_3e

    .line 643
    sub-int v0, p3, p2

    if-ge v0, p4, :cond_3b

    move v0, p2

    :goto_37
    int-to-byte v0, v0

    aput-byte v0, p1, v2

    goto :goto_4

    :cond_3b
    sub-int v0, p3, p4

    goto :goto_37

    .line 644
    :cond_3e
    aget-byte v0, p1, v3

    if-ne v0, p2, :cond_4

    .line 645
    int-to-byte v0, p2

    aput-byte v0, p1, v2

    goto :goto_4
.end method

.method public setRmsInit(Z)V
    .registers 9
    .param p1, "mode"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 85
    const/16 v3, 0x8c

    new-array v2, v3, [B

    .line 86
    .local v2, "info":[B
    const/4 v3, -0x1

    aput-byte v3, v2, v6

    .line 87
    const/16 v3, 0x118

    new-array v0, v3, [B

    .line 88
    .local v0, "aaa":[B
    const/4 v1, 0x0

    .line 89
    .local v1, "i":I
    :goto_d
    const/16 v3, 0x53

    if-lt v1, v3, :cond_15

    .line 99
    const/4 v2, 0x0

    check-cast v2, [B

    .line 100
    return-void

    .line 90
    :cond_15
    if-nez p1, :cond_1d

    const/4 v3, 0x4

    if-ne v1, v3, :cond_1d

    .line 89
    :goto_1a
    add-int/lit8 v1, v1, 0x1

    goto :goto_d

    .line 91
    :cond_1d
    const/16 v3, 0xc

    if-eq v1, v3, :cond_33

    .line 92
    if-eqz p1, :cond_2a

    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    array-length v4, v2

    invoke-virtual {v3, v2, v6, v4}, Ljavax/microedition/rms/RecordStore;->addRecord([BII)I

    goto :goto_1a

    .line 93
    :cond_2a
    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    add-int/lit8 v4, v1, 0x1

    array-length v5, v2

    invoke-virtual {v3, v4, v2, v6, v5}, Ljavax/microedition/rms/RecordStore;->setRecord(I[BII)V

    goto :goto_1a

    .line 95
    :cond_33
    if-eqz p1, :cond_3c

    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    array-length v4, v0

    invoke-virtual {v3, v0, v6, v4}, Ljavax/microedition/rms/RecordStore;->addRecord([BII)I

    goto :goto_1a

    .line 96
    :cond_3c
    sget-object v3, Ldm/Ms;->rms:Ljavax/microedition/rms/RecordStore;

    add-int/lit8 v4, v1, 0x1

    array-length v5, v0

    invoke-virtual {v3, v4, v0, v6, v5}, Ljavax/microedition/rms/RecordStore;->setRecord(I[BII)V

    goto :goto_1a
.end method

.method public setSprite(Ldm/Sprite;Ljava/lang/String;Z)V
    .registers 9
    .param p1, "sp"    # Ldm/Sprite;
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "mode"    # Z

    .prologue
    const/4 v4, 0x2

    .line 506
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ".data"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {p0, v1, v2}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 507
    .local v0, "date":[B
    const/4 v1, 0x0

    sput v1, Ldm/Ms;->skip:I

    .line 508
    invoke-virtual {p1}, Ldm/Sprite;->nullIMFA()V

    .line 509
    if-eqz p3, :cond_38

    .line 510
    invoke-virtual {p0, p2}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    .line 511
    invoke-virtual {p0, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v2

    .line 512
    invoke-virtual {p0, v0}, Ldm/Ms;->create3Array([B)[[[B

    move-result-object v3

    .line 513
    invoke-virtual {p0, v0}, Ldm/Ms;->create3Array([B)[[[B

    move-result-object v4

    .line 509
    invoke-virtual {p1, v1, v2, v3, v4}, Ldm/Sprite;->Set(Ljavax/microedition/lcdui/Image;[[B[[[B[[[B)V

    .line 519
    :goto_34
    const/4 v0, 0x0

    check-cast v0, [B

    .line 520
    return-void

    .line 515
    :cond_38
    invoke-virtual {p0, p2}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    .line 516
    invoke-virtual {p0, v0, v4}, Ldm/Ms;->createShort2Array([BI)[[S

    move-result-object v2

    .line 517
    invoke-virtual {p0, v0, v4}, Ldm/Ms;->createShort3Array([BI)[[[S

    move-result-object v3

    .line 518
    invoke-virtual {p0, v0, v4}, Ldm/Ms;->createShort3Array([BI)[[[S

    move-result-object v4

    .line 514
    invoke-virtual {p1, v1, v2, v3, v4}, Ldm/Sprite;->Set(Ljavax/microedition/lcdui/Image;[[S[[[S[[[S)V

    goto :goto_34
.end method

.method public shortArrayToByteArray([S)[B
    .registers 6
    .param p1, "shortbuf"    # [S

    .prologue
    .line 194
    const/4 v3, 0x0

    sput v3, Ldm/Ms;->skip:I

    .line 195
    array-length v2, p1

    .line 196
    .local v2, "len":I
    shl-int/lit8 v3, v2, 0x1

    new-array v0, v3, [B

    .line 197
    .local v0, "bytebuf":[B
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_9
    if-lt v1, v2, :cond_c

    .line 200
    return-object v0

    .line 198
    :cond_c
    aget-short v3, p1, v1

    invoke-virtual {p0, v0, v3}, Ldm/Ms;->putShort([BI)V

    .line 197
    add-int/lit8 v1, v1, 0x1

    goto :goto_9
.end method

.method public sleep(I)V
    .registers 2
    .param p1, "time"    # I

    .prologue
    .line 32
    iput p1, p0, Ldm/Ms;->sleep_time:I

    return-void
.end method

.method public sqrt(I)I
    .registers 5
    .param p1, "x"    # I

    .prologue
    .line 550
    if-lez p1, :cond_12

    .line 551
    mul-int/lit16 p1, p1, 0x2710

    .line 552
    const/16 v0, 0x2710

    .line 554
    .local v0, "b":I
    :cond_6
    move v1, v0

    .line 555
    .local v1, "y":I
    div-int v2, p1, v0

    add-int/2addr v2, v0

    shr-int/lit8 v0, v2, 0x1

    .line 556
    if-lt v0, v1, :cond_6

    .line 557
    div-int/lit8 v1, v1, 0x64

    move v2, v1

    .line 559
    .end local v0    # "b":I
    .end local v1    # "y":I
    :goto_11
    return v2

    :cond_12
    const/4 v2, 0x0

    goto :goto_11
.end method
