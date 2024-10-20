.class public Lcom/nokia/mid/ui/DirectGraphics;
.super Ljava/lang/Object;
.source "DirectGraphics.java"


# static fields
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


# instance fields
.field g:Ljavax/microedition/lcdui/Graphics;


# direct methods
.method static constructor <clinit>()V
    .registers 7

    .prologue
    const/4 v6, 0x5

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v2, 0x1

    const/4 v3, 0x4

    .line 8
    const/16 v0, 0x2000

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->FLIP_HORIZONTAL:I

    .line 9
    const/16 v0, 0x4000

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->FLIP_VERTICAL:I

    .line 10
    const/16 v0, 0xb4

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_180:I

    .line 11
    const/16 v0, 0x10e

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_270:I

    .line 12
    const/16 v0, 0x5a

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_90:I

    .line 13
    sput v2, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_1_GRAY:I

    .line 14
    const/4 v0, -0x1

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_1_GRAY_VERTICAL:I

    .line 15
    sput v4, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_2_GRAY:I

    .line 16
    const/16 v0, 0x14c

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_332_RGB:I

    .line 17
    sput v3, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_4_GRAY:I

    .line 18
    const/16 v0, 0x8

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_BYTE_8_GRAY:I

    .line 19
    const/16 v0, 0x378

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_INT_888_RGB:I

    .line 20
    const/16 v0, 0x22b8

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_INT_8888_ARGB:I

    .line 21
    const/16 v0, 0x613

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_1555_ARGB:I

    .line 22
    const/16 v0, 0x1bc

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_444_RGB:I

    .line 23
    const/16 v0, 0x115c

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_4444_ARGB:I

    .line 24
    const/16 v0, 0x22b

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_555_RGB:I

    .line 25
    const/16 v0, 0x235

    sput v0, Lcom/nokia/mid/ui/DirectGraphics;->TYPE_USHORT_565_RGB:I

    .line 31
    const/16 v0, 0x8

    new-array v0, v0, [I

    const/4 v1, 0x6

    aput v1, v0, v2

    aput v5, v0, v4

    aput v6, v0, v5

    aput v4, v0, v3

    aput v3, v0, v6

    const/4 v1, 0x6

    aput v2, v0, v1

    const/4 v1, 0x7

    const/4 v2, 0x7

    aput v2, v0, v1

    sput-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transA:[I

    .line 32
    new-array v0, v3, [I

    fill-array-data v0, :array_66

    sput-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transB:[I

    .line 6
    return-void

    .line 32
    :array_66
    .array-data 4
        0x1
        0x7
        0x2
        0x4
    .end array-data
.end method

.method protected constructor <init>()V
    .registers 1

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method


# virtual methods
.method public drawImage(Ljavax/microedition/lcdui/Image;IIII)V
    .registers 16
    .param p1, "img"    # Ljavax/microedition/lcdui/Image;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "anchor"    # I
    .param p5, "trans"    # I

    .prologue
    const/4 v2, 0x0

    .line 34
    const/4 v6, 0x0

    .line 35
    .local v6, "tmpTrans":I
    and-int/lit16 v0, p5, 0x2000

    if-eqz v0, :cond_25

    .line 36
    add-int/lit16 p5, p5, -0x2000

    .line 37
    sget-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transA:[I

    sget v1, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_90:I

    div-int v1, p5, v1

    add-int/lit8 v1, v1, 0x4

    aget v6, v0, v1

    .line 47
    :goto_12
    iget-object v0, p0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getWidth()I

    move-result v4

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getHeight()I

    move-result v5

    move-object v1, p1

    move v3, v2

    move v7, p2

    move v8, p3

    move v9, p4

    invoke-virtual/range {v0 .. v9}, Ljavax/microedition/lcdui/Graphics;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIII)V

    .line 48
    return-void

    .line 39
    :cond_25
    and-int/lit16 v0, p5, 0x4000

    if-eqz v0, :cond_34

    .line 40
    add-int/lit16 p5, p5, -0x4000

    .line 42
    sget-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transB:[I

    sget v1, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_90:I

    div-int v1, p5, v1

    aget v6, v0, v1

    goto :goto_12

    .line 44
    :cond_34
    sget-object v0, Lcom/nokia/mid/ui/DirectGraphics;->transA:[I

    sget v1, Lcom/nokia/mid/ui/DirectGraphics;->ROTATE_90:I

    div-int v1, p5, v1

    aget v6, v0, v1

    goto :goto_12
.end method

.method public fillPolygon([II[IIII)V
    .registers 14
    .param p1, "xPoints"    # [I
    .param p2, "xOffset"    # I
    .param p3, "yPoints"    # [I
    .param p4, "yOffset"    # I
    .param p5, "nPoints"    # I
    .param p6, "argbColor"    # I

    .prologue
    .line 78
    iget-object v0, p0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p6}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 79
    iget-object v0, p0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v1, 0x0

    aget v1, p1, v1

    const/4 v2, 0x0

    aget v2, p3, v2

    const/4 v3, 0x1

    aget v3, p1, v3

    const/4 v4, 0x1

    aget v4, p3, v4

    const/4 v5, 0x2

    aget v5, p1, v5

    const/4 v6, 0x2

    aget v6, p3, v6

    invoke-virtual/range {v0 .. v6}, Ljavax/microedition/lcdui/Graphics;->fillTriangle(IIIIII)V

    .line 80
    iget-object v0, p0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v1, 0x0

    aget v1, p1, v1

    const/4 v2, 0x0

    aget v2, p3, v2

    const/4 v3, 0x3

    aget v3, p1, v3

    const/4 v4, 0x3

    aget v4, p3, v4

    const/4 v5, 0x2

    aget v5, p1, v5

    const/4 v6, 0x2

    aget v6, p3, v6

    invoke-virtual/range {v0 .. v6}, Ljavax/microedition/lcdui/Graphics;->fillTriangle(IIIIII)V

    .line 81
    return-void
.end method
