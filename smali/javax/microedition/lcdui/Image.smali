.class public Ljavax/microedition/lcdui/Image;
.super Ljava/lang/Object;
.source "Image.java"


# instance fields
.field private img_g:Ljavax/microedition/lcdui/Graphics;

.field private mBitmap:Landroid/graphics/Bitmap;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    return-void
.end method

.method public static createImage(II)Ljavax/microedition/lcdui/Image;
    .locals 2
    .param p0, "width"    # I
    .param p1, "height"    # I

    .prologue
    .line 48
    new-instance v0, Ljavax/microedition/lcdui/Image;

    invoke-direct {v0}, Ljavax/microedition/lcdui/Image;-><init>()V

    .line 50
    .local v0, "image":Ljavax/microedition/lcdui/Image;
    sget-object v1, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {p0, p1, v1}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    .line 51
    return-object v0
.end method

.method public static createImage(III)Ljavax/microedition/lcdui/Image;
    .locals 2
    .param p0, "width"    # I
    .param p1, "height"    # I
    .param p2, "flag"    # I

    .prologue
    .line 68
    new-instance v0, Ljavax/microedition/lcdui/Image;

    invoke-direct {v0}, Ljavax/microedition/lcdui/Image;-><init>()V

    .line 70
    .local v0, "image":Ljavax/microedition/lcdui/Image;
    sget-object v1, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {p0, p1, v1}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    .line 71
    return-object v0
.end method

.method public static createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
    .locals 3
    .param p0, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 75
    new-instance v0, Ljavax/microedition/lcdui/Image;

    invoke-direct {v0}, Ljavax/microedition/lcdui/Image;-><init>()V

    .line 77
    .local v0, "image":Ljavax/microedition/lcdui/Image;
    invoke-static {p0}, Lcom/android/Util/AndroidUtil;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 78
    .local v1, "is":Ljava/io/InputStream;
    invoke-static {v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;

    move-result-object v2

    iput-object v2, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    .line 79
    iget-object v2, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    if-nez v2, :cond_0

    .line 80
    new-instance v2, Ljava/io/IOException;

    invoke-direct {v2}, Ljava/io/IOException;-><init>()V

    throw v2

    .line 82
    :cond_0
    return-object v0
.end method

.method public static createImage(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
    .locals 4
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "zoom"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 131
    new-instance v0, Ljavax/microedition/lcdui/Image;

    invoke-direct {v0}, Ljavax/microedition/lcdui/Image;-><init>()V

    .line 133
    .local v0, "image":Ljavax/microedition/lcdui/Image;
    invoke-static {p0}, Lcom/android/Util/AndroidUtil;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v1

    .line 134
    .local v1, "is":Ljava/io/InputStream;
    new-instance v2, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v2}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 135
    .local v2, "opts":Landroid/graphics/BitmapFactory$Options;
    const/4 v3, 0x1

    iput-boolean v3, v2, Landroid/graphics/BitmapFactory$Options;->inInputShareable:Z

    .line 136
    iput p1, v2, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 137
    const/4 v3, 0x0

    invoke-static {v1, v3, v2}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    .line 138
    iget-object v3, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    if-nez v3, :cond_0

    .line 139
    new-instance v3, Ljava/io/IOException;

    invoke-direct {v3}, Ljava/io/IOException;-><init>()V

    throw v3

    .line 142
    :cond_0
    return-object v0
.end method

.method public static createImage(Ljavax/microedition/lcdui/Image;IIIII)Ljavax/microedition/lcdui/Image;
    .locals 10
    .param p0, "source"    # Ljavax/microedition/lcdui/Image;
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .param p5, "transform"    # I

    .prologue
    const/4 v6, 0x0

    .line 28
    move v9, p3

    .local v9, "tmp_w":I
    move v8, p4

    .line 29
    .local v8, "tmp_h":I
    const/4 v0, 0x3

    if-le p5, v0, :cond_0

    .line 30
    move v9, p4

    .line 31
    move v8, p3

    .line 34
    :cond_0
    new-instance v7, Ljavax/microedition/lcdui/Image;

    invoke-direct {v7}, Ljavax/microedition/lcdui/Image;-><init>()V

    .line 36
    .local v7, "image":Ljavax/microedition/lcdui/Image;
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->tTrans:[[F

    aget-object v0, v0, p5

    sget-object v1, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    const/16 v2, 0x9

    invoke-static {v0, v6, v1, v6, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 38
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    const/4 v1, 0x2

    sget-object v2, Ljavax/microedition/lcdui/Graphics;->tTransXY:[[I

    aget-object v2, v2, p5

    aget v2, v2, v6

    mul-int/2addr v2, v9

    int-to-float v2, v2

    aput v2, v0, v1

    .line 39
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    const/4 v1, 0x5

    sget-object v2, Ljavax/microedition/lcdui/Graphics;->tTransXY:[[I

    aget-object v2, v2, p5

    const/4 v3, 0x1

    aget v2, v2, v3

    mul-int/2addr v2, v8

    int-to-float v2, v2

    aput v2, v0, v1

    .line 41
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->regionMatrix:Landroid/graphics/Matrix;

    sget-object v1, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->setValues([F)V

    .line 42
    invoke-virtual {p0}, Ljavax/microedition/lcdui/Image;->getBitMapInpackage()Landroid/graphics/Bitmap;

    move-result-object v0

    sget-object v5, Ljavax/microedition/lcdui/Graphics;->regionMatrix:Landroid/graphics/Matrix;

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v6}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, v7, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    .line 44
    return-object v7
.end method

.method public static createImage([BII)Ljavax/microedition/lcdui/Image;
    .locals 2
    .param p0, "imageData"    # [B
    .param p1, "imageOffset"    # I
    .param p2, "imageLength"    # I

    .prologue
    .line 21
    new-instance v0, Ljavax/microedition/lcdui/Image;

    invoke-direct {v0}, Ljavax/microedition/lcdui/Image;-><init>()V

    .line 23
    .local v0, "image":Ljavax/microedition/lcdui/Image;
    invoke-static {p0, p1, p2}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    .line 24
    return-object v0
.end method

.method public static createRGBImage([IIIZ)Ljavax/microedition/lcdui/Image;
    .locals 2
    .param p0, "rgb"    # [I
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "processAlpha"    # Z

    .prologue
    .line 90
    new-instance v0, Ljavax/microedition/lcdui/Image;

    invoke-direct {v0}, Ljavax/microedition/lcdui/Image;-><init>()V

    .line 91
    .local v0, "image":Ljavax/microedition/lcdui/Image;
    sget-object v1, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {p0, p1, p2, v1}, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    .line 92
    return-object v0
.end method


# virtual methods
.method public getBitMap()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method getBitMapInpackage()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getGraphics()Ljavax/microedition/lcdui/Graphics;
    .locals 4

    .prologue
    .line 97
    iget-object v2, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->isMutable()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 98
    iget-object v2, p0, Ljavax/microedition/lcdui/Image;->img_g:Ljavax/microedition/lcdui/Graphics;

    if-nez v2, :cond_0

    .line 99
    new-instance v0, Landroid/graphics/Canvas;

    iget-object v2, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v0, v2}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 100
    .local v0, "imagecanvas":Landroid/graphics/Canvas;
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    .line 101
    .local v1, "painter":Landroid/graphics/Paint;
    new-instance v2, Ljavax/microedition/lcdui/Graphics;

    iget-object v3, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v2, v0, v1, v3}, Ljavax/microedition/lcdui/Graphics;-><init>(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Bitmap;)V

    iput-object v2, p0, Ljavax/microedition/lcdui/Image;->img_g:Ljavax/microedition/lcdui/Graphics;

    .line 103
    .end local v0    # "imagecanvas":Landroid/graphics/Canvas;
    .end local v1    # "painter":Landroid/graphics/Paint;
    :cond_0
    iget-object v2, p0, Ljavax/microedition/lcdui/Image;->img_g:Ljavax/microedition/lcdui/Graphics;

    return-object v2

    .line 106
    :cond_1
    new-instance v2, Ljava/lang/IllegalStateException;

    invoke-direct {v2}, Ljava/lang/IllegalStateException;-><init>()V

    throw v2
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 111
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    return v0
.end method

.method public getRGB([IIIIIII)V
    .locals 8
    .param p1, "rgbData"    # [I
    .param p2, "offset"    # I
    .param p3, "scanlength"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I
    .param p6, "width"    # I
    .param p7, "height"    # I

    .prologue
    .line 115
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move v6, p6

    move v7, p7

    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 116
    return-void
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    return v0
.end method

.method public isMutable()Z
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isMutable()Z

    move-result v0

    return v0
.end method
