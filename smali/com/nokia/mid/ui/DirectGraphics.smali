.class public Lcom/nokia/mid/ui/DirectGraphics;
.super Ljava/lang/Object;
.source "DirectGraphics.java"

.field public static FLIP_HORIZONTAL:I

.field public static FLIP_VERTICAL:I

.field public static ROTATE_180:I

.field public static ROTATE_270:I

.field public static ROTATE_90:I

.field public static TYPE_BYTE_1_GRAY:I

.field public static TYPE_BYTE_1_GRAY_VERTICAL:I

.field public static TYPE_BYTE_2_GRAY:I

.field public static TYPE_BYTE_332_RGB:I

.field public static TYPE_BYTE_4_GRAY:I

.field public static TYPE_BYTE_8_GRAY:I

.field public static TYPE_INT_8888_ARGB:I

.field public static TYPE_INT_888_RGB:I

.field public static TYPE_USHORT_1555_ARGB:I

.field public static TYPE_USHORT_4444_ARGB:I

.field public static TYPE_USHORT_444_RGB:I

.field public static TYPE_USHORT_555_RGB:I

.field public static TYPE_USHORT_565_RGB:I

.field static transA:[I

.field static transB:[I

.field g:Ljavax/microedition/lcdui/Graphics;

.method static constructor <clinit>()V
  .registers 7
  .prologue
    const/4 v6, 5
    const/4 v5, 3
    const/4 v4, 2
    const/4 v2, 1
    const/4 v3, 4
  .line 8
    const/16 v0, 8192
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->FLIP_HORIZONTAL:I
  .line 9
    const/16 v0, 16384
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->FLIP_VERTICAL:I
  .line 10
    const/16 v0, 180
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_180:I
  .line 11
    const/16 v0, 270
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_270:I
  .line 12
    const/16 v0, 90
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_90:I
  .line 13
    sput v2, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_1_GRAY:I
  .line 14
    const/4 v0, -1
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_1_GRAY_VERTICAL:I
  .line 15
    sput v4, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_2_GRAY:I
  .line 16
    const/16 v0, 332
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_332_RGB:I
  .line 17
    sput v3, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_4_GRAY:I
  .line 18
    const/16 v0, 8
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_8_GRAY:I
  .line 19
    const/16 v0, 888
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_INT_888_RGB:I
  .line 20
    const/16 v0, 8888
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_INT_8888_ARGB:I
  .line 21
    const/16 v0, 1555
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_1555_ARGB:I
  .line 22
    const/16 v0, 444
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_444_RGB:I
  .line 23
    const/16 v0, 4444
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_4444_ARGB:I
  .line 24
    const/16 v0, 555
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_555_RGB:I
  .line 25
    const/16 v0, 565
    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_565_RGB:I
  .line 31
    const/16 v0, 8
    new-array v0, v0, [I
    const/4 v1, 6
    aput v1, v0, v2
    aput v5, v0, v4
    aput v6, v0, v5
    aput v4, v0, v3
    aput v3, v0, v6
    const/4 v1, 6
    aput v2, v0, v1
    const/4 v1, 7
    const/4 v2, 7
    aput v2, v0, v1
    sput-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transA:[I
  .line 32
    new-array v0, v3, [I
    fill-array-data v0, :L0
    sput-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transB:[I
  .line 6
    return-void
  .line 32
  :L0
  .array-data 4
    1t 0t 0t 0t
    7t 0t 0t 0t
    2t 0t 0t 0t
    4t 0t 0t 0t
  .end array-data
.end method

.method protected constructor <init>()V
  .registers 1
  .prologue
  .line 27
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 29
    return-void
.end method

.method public drawImage(Ljavax/microedition/lcdui/Image;IIII)V
  .parameter "img" # Ljavax/microedition/lcdui/Image;
  .parameter "x" # I
  .parameter "y" # I
  .parameter "anchor" # I
  .parameter "trans" # I
  .registers 16
  .prologue
    const/4 v2, 0
  .line 34
    const/4 v6, 0
  .line 35
  .local v6, "tmpTrans":I
    and-int/lit16 v0, p5, 8192
    if-eqz v0, :L1
  .line 36
    add-int/lit16 p5, p5, -8192
  .line 37
    sget-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transA:[I
    sget v1, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_90:I
    div-int v1, p5, v1
    add-int/lit8 v1, v1, 4
    aget v6, v0, v1
  :L0
  .line 47
    iget-object v0, p0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { p1 }, Ljavax/microedition/lcdui/Image;->getWidth()I
    move-result v4
    invoke-virtual { p1 }, Ljavax/microedition/lcdui/Image;->getHeight()I
    move-result v5
    move-object v1, p1
    move v3, v2
    move v7, p2
    move v8, p3
    move v9, p4
    invoke-virtual/range { v0 .. v9 }, Ljavax/microedition/lcdui/Graphics;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIII)V
  .line 48
    return-void
  :L1
  .line 39
    and-int/lit16 v0, p5, 16384
    if-eqz v0, :L2
  .line 40
    add-int/lit16 p5, p5, -16384
  .line 42
    sget-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transB:[I
    sget v1, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_90:I
    div-int v1, p5, v1
    aget v6, v0, v1
    goto :L0
  :L2
  .line 44
    sget-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transA:[I
    sget v1, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_90:I
    div-int v1, p5, v1
    aget v6, v0, v1
    goto :L0
.end method

.method public fillPolygon([II[IIII)V
  .parameter "xPoints" # [I
  .parameter "xOffset" # I
  .parameter "yPoints" # [I
  .parameter "yOffset" # I
  .parameter "nPoints" # I
  .parameter "argbColor" # I
  .registers 14
  .prologue
  .line 78
    iget-object v0, p0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p6 }, Ljavax/microedition/lcdui/Graphics;->setColor(I)V
  .line 79
    iget-object v0, p0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;
    const/4 v1, 0
    aget v1, p1, v1
    const/4 v2, 0
    aget v2, p3, v2
    const/4 v3, 1
    aget v3, p1, v3
    const/4 v4, 1
    aget v4, p3, v4
    const/4 v5, 2
    aget v5, p1, v5
    const/4 v6, 2
    aget v6, p3, v6
    invoke-virtual/range { v0 .. v6 }, Ljavax/microedition/lcdui/Graphics;->fillTriangle(IIIIII)V
  .line 80
    iget-object v0, p0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;
    const/4 v1, 0
    aget v1, p1, v1
    const/4 v2, 0
    aget v2, p3, v2
    const/4 v3, 3
    aget v3, p1, v3
    const/4 v4, 3
    aget v4, p3, v4
    const/4 v5, 2
    aget v5, p1, v5
    const/4 v6, 2
    aget v6, p3, v6
    invoke-virtual/range { v0 .. v6 }, Ljavax/microedition/lcdui/Graphics;->fillTriangle(IIIIII)V
  .line 81
    return-void
.end method
