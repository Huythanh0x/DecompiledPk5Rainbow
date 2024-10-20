.class public Ljavax/microedition/lcdui/Image;
.super Ljava/lang/Object;
.source "Image.java"

.field private img_g:Ljavax/microedition/lcdui/Graphics;

.field private mBitmap:Landroid/graphics/Bitmap;

.method private constructor <init>()V
  .registers 1
  .prologue
  .line 16
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 18
    return-void
.end method

.method public static createImage(II)Ljavax/microedition/lcdui/Image;
  .parameter "width" # I
  .parameter "height" # I
  .registers 4
  .prologue
  .line 48
    new-instance v0, Ljavax/microedition/lcdui/Image;
    invoke-direct { v0 }, Ljavax/microedition/lcdui/Image;-><init>()V
  .line 50
  .local v0, "image":Ljavax/microedition/lcdui/Image;
    sget-object v1, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;
    invoke-static { p0, p1, v1 }, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    move-result-object v1
    iput-object v1, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
  .line 51
    return-object v0
.end method

.method public static createImage(III)Ljavax/microedition/lcdui/Image;
  .parameter "width" # I
  .parameter "height" # I
  .parameter "flag" # I
  .registers 5
  .prologue
  .line 68
    new-instance v0, Ljavax/microedition/lcdui/Image;
    invoke-direct { v0 }, Ljavax/microedition/lcdui/Image;-><init>()V
  .line 70
  .local v0, "image":Ljavax/microedition/lcdui/Image;
    sget-object v1, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;
    invoke-static { p0, p1, v1 }, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    move-result-object v1
    iput-object v1, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
  .line 71
    return-object v0
.end method

.method public static createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/io/IOException;
    }
  .end annotation
  .parameter "name" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 75
    new-instance v0, Ljavax/microedition/lcdui/Image;
    invoke-direct { v0 }, Ljavax/microedition/lcdui/Image;-><init>()V
  .line 77
  .local v0, "image":Ljavax/microedition/lcdui/Image;
    invoke-static { p0 }, Lcom/android/Util/AndroidUtil;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;
    move-result-object v1
  .line 78
  .local v1, "is":Ljava/io/InputStream;
    invoke-static { v1 }, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    move-result-object v2
    iput-object v2, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
  .line 79
    iget-object v2, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    if-nez v2, :L0
  .line 80
    new-instance v2, Ljava/io/IOException;
    invoke-direct { v2 }, Ljava/io/IOException;-><init>()V
    throw v2
  :L0
  .line 82
    return-object v0
.end method

.method public static createImage(Ljava/lang/String;I)Ljavax/microedition/lcdui/Image;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/io/IOException;
    }
  .end annotation
  .parameter "name" # Ljava/lang/String;
  .parameter "zoom" # I
  .registers 6
  .prologue
  .line 131
    new-instance v0, Ljavax/microedition/lcdui/Image;
    invoke-direct { v0 }, Ljavax/microedition/lcdui/Image;-><init>()V
  .line 133
  .local v0, "image":Ljavax/microedition/lcdui/Image;
    invoke-static { p0 }, Lcom/android/Util/AndroidUtil;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;
    move-result-object v1
  .line 134
  .local v1, "is":Ljava/io/InputStream;
    new-instance v2, Landroid/graphics/BitmapFactory$Options;
    invoke-direct { v2 }, Landroid/graphics/BitmapFactory$Options;-><init>()V
  .line 135
  .local v2, "opts":Landroid/graphics/BitmapFactory$Options;
    const/4 v3, 1
    iput-boolean v3, v2, Landroid/graphics/BitmapFactory$Options;->inInputShareable:Z
  .line 136
    iput p1, v2, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I
  .line 137
    const/4 v3, 0
    invoke-static { v1, v3, v2 }, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    move-result-object v3
    iput-object v3, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
  .line 138
    iget-object v3, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    if-nez v3, :L0
  .line 139
    new-instance v3, Ljava/io/IOException;
    invoke-direct { v3 }, Ljava/io/IOException;-><init>()V
    throw v3
  :L0
  .line 142
    return-object v0
.end method

.method public static createImage(Ljavax/microedition/lcdui/Image;IIIII)Ljavax/microedition/lcdui/Image;
  .parameter "source" # Ljavax/microedition/lcdui/Image;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "width" # I
  .parameter "height" # I
  .parameter "transform" # I
  .registers 16
  .prologue
    const/4 v6, 0
  .line 28
    move v9, p3
  .local v9, "tmp_w":I
    move v8, p4
  .line 29
  .local v8, "tmp_h":I
    const/4 v0, 3
    if-le p5, v0, :L0
  .line 30
    move v9, p4
  .line 31
    move v8, p3
  :L0
  .line 34
    new-instance v7, Ljavax/microedition/lcdui/Image;
    invoke-direct { v7 }, Ljavax/microedition/lcdui/Image;-><init>()V
  .line 36
  .local v7, "image":Ljavax/microedition/lcdui/Image;
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->tTrans:[[F
    aget-object v0, v0, p5
    sget-object v1, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F
    const/16 v2, 9
    invoke-static { v0, v6, v1, v6, v2 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  .line 38
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F
    const/4 v1, 2
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->tTransXY:[[I
    aget-object v2, v2, p5
    aget v2, v2, v6
    mul-int/2addr v2, v9
    int-to-float v2, v2
    aput v2, v0, v1
  .line 39
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F
    const/4 v1, 5
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->tTransXY:[[I
    aget-object v2, v2, p5
    const/4 v3, 1
    aget v2, v2, v3
    mul-int/2addr v2, v8
    int-to-float v2, v2
    aput v2, v0, v1
  .line 41
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->regionMatrix:Landroid/graphics/Matrix;
    sget-object v1, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F
    invoke-virtual { v0, v1 }, Landroid/graphics/Matrix;->setValues([F)V
  .line 42
    invoke-virtual { p0 }, Ljavax/microedition/lcdui/Image;->getBitMapInpackage()Landroid/graphics/Bitmap;
    move-result-object v0
    sget-object v5, Ljavax/microedition/lcdui/Graphics;->regionMatrix:Landroid/graphics/Matrix;
    move v1, p1
    move v2, p2
    move v3, p3
    move v4, p4
    invoke-static/range { v0 .. v6 }, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    move-result-object v0
    iput-object v0, v7, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
  .line 44
    return-object v7
.end method

.method public static createImage([BII)Ljavax/microedition/lcdui/Image;
  .parameter "imageData" # [B
  .parameter "imageOffset" # I
  .parameter "imageLength" # I
  .registers 5
  .prologue
  .line 21
    new-instance v0, Ljavax/microedition/lcdui/Image;
    invoke-direct { v0 }, Ljavax/microedition/lcdui/Image;-><init>()V
  .line 23
  .local v0, "image":Ljavax/microedition/lcdui/Image;
    invoke-static { p0, p1, p2 }, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;
    move-result-object v1
    iput-object v1, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
  .line 24
    return-object v0
.end method

.method public static createRGBImage([IIIZ)Ljavax/microedition/lcdui/Image;
  .parameter "rgb" # [I
  .parameter "width" # I
  .parameter "height" # I
  .parameter "processAlpha" # Z
  .registers 6
  .prologue
  .line 90
    new-instance v0, Ljavax/microedition/lcdui/Image;
    invoke-direct { v0 }, Ljavax/microedition/lcdui/Image;-><init>()V
  .line 91
  .local v0, "image":Ljavax/microedition/lcdui/Image;
    sget-object v1, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;
    invoke-static { p0, p1, p2, v1 }, Landroid/graphics/Bitmap;->createBitmap([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    move-result-object v1
    iput-object v1, v0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
  .line 92
    return-object v0
.end method

.method public getBitMap()Landroid/graphics/Bitmap;
  .registers 2
  .prologue
  .line 127
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    return-object v0
.end method

.method getBitMapInpackage()Landroid/graphics/Bitmap;
  .registers 2
  .prologue
  .line 86
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    return-object v0
.end method

.method public getGraphics()Ljavax/microedition/lcdui/Graphics;
  .registers 5
  .prologue
  .line 97
    iget-object v2, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    invoke-virtual { v2 }, Landroid/graphics/Bitmap;->isMutable()Z
    move-result v2
    if-eqz v2, :L1
  .line 98
    iget-object v2, p0, Ljavax/microedition/lcdui/Image;->img_g:Ljavax/microedition/lcdui/Graphics;
    if-nez v2, :L0
  .line 99
    new-instance v0, Landroid/graphics/Canvas;
    iget-object v2, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    invoke-direct { v0, v2 }, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V
  .line 100
  .local v0, "imagecanvas":Landroid/graphics/Canvas;
    new-instance v1, Landroid/graphics/Paint;
    invoke-direct { v1 }, Landroid/graphics/Paint;-><init>()V
  .line 101
  .local v1, "painter":Landroid/graphics/Paint;
    new-instance v2, Ljavax/microedition/lcdui/Graphics;
    iget-object v3, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    invoke-direct { v2, v0, v1, v3 }, Ljavax/microedition/lcdui/Graphics;-><init>(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Bitmap;)V
    iput-object v2, p0, Ljavax/microedition/lcdui/Image;->img_g:Ljavax/microedition/lcdui/Graphics;
  :L0
  .line 103
  .end local v0
  .end local v1
    iget-object v2, p0, Ljavax/microedition/lcdui/Image;->img_g:Ljavax/microedition/lcdui/Graphics;
    return-object v2
  :L1
  .line 106
    new-instance v2, Ljava/lang/IllegalStateException;
    invoke-direct { v2 }, Ljava/lang/IllegalStateException;-><init>()V
    throw v2
.end method

.method public getHeight()I
  .registers 2
  .prologue
  .line 111
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    invoke-virtual { v0 }, Landroid/graphics/Bitmap;->getHeight()I
    move-result v0
    return v0
.end method

.method public getRGB([IIIIIII)V
  .parameter "rgbData" # [I
  .parameter "offset" # I
  .parameter "scanlength" # I
  .parameter "x" # I
  .parameter "y" # I
  .parameter "width" # I
  .parameter "height" # I
  .registers 16
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
    invoke-virtual/range { v0 .. v7 }, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V
  .line 116
    return-void
.end method

.method public getWidth()I
  .registers 2
  .prologue
  .line 119
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    invoke-virtual { v0 }, Landroid/graphics/Bitmap;->getWidth()I
    move-result v0
    return v0
.end method

.method public isMutable()Z
  .registers 2
  .prologue
  .line 123
    iget-object v0, p0, Ljavax/microedition/lcdui/Image;->mBitmap:Landroid/graphics/Bitmap;
    invoke-virtual { v0 }, Landroid/graphics/Bitmap;->isMutable()Z
    move-result v0
    return v0
.end method
