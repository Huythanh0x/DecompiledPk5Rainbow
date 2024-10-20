.class public final Ljavax/microedition/lcdui/Graphics;
.super Ljava/lang/Object;
.source "Graphics.java"


# static fields
.field public static final BASELINE:I = 0x40

.field public static final BOTTOM:I = 0x20

.field public static final DOTTED:I = 0x1

.field public static final HCENTER:I = 0x1

.field public static final LEFT:I = 0x4

.field public static final RIGHT:I = 0x8

.field public static final SOLID:I = 0x0

.field public static final TOP:I = 0x10

.field public static final VCENTER:I = 0x2

.field private static final dashPathEffect:Landroid/graphics/DashPathEffect;

.field private static rect1:Landroid/graphics/Rect;

.field private static rect2:Landroid/graphics/Rect;

.field protected static regionMatrix:Landroid/graphics/Matrix;

.field private static final sb:Ljava/lang/StringBuffer;

.field protected static tTrans:[[F

.field protected static tTransTemp:[F

.field protected static tTransXY:[[I

.field private static ttmatrix:Landroid/graphics/Matrix;


# instance fields
.field private area:Landroid/graphics/Bitmap;

.field private canvas:Landroid/graphics/Canvas;

.field private cliph:I

.field private clipw:I

.field private clipx:I

.field private clipy:I

.field private font:Ljavax/microedition/lcdui/Font;

.field private graphicbitmap:Landroid/graphics/Bitmap;

.field private isResetPainter:Z

.field private rgb:[I

.field scale_x:F

.field scale_y:F

.field private strokeStyle:I

.field private translateX:I

.field private translateY:I


# direct methods
.method static constructor <clinit>()V
    .registers 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x0

    const/4 v5, 0x1

    const/16 v4, 0x9

    const/4 v3, 0x2

    .line 27
    new-instance v0, Landroid/graphics/DashPathEffect;

    new-array v1, v3, [F

    fill-array-data v1, :array_ae

    .line 29
    const/4 v2, 0x0

    .line 27
    invoke-direct {v0, v1, v2}, Landroid/graphics/DashPathEffect;-><init>([FF)V

    sput-object v0, Ljavax/microedition/lcdui/Graphics;->dashPathEffect:Landroid/graphics/DashPathEffect;

    .line 159
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    sput-object v0, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    .line 236
    const/16 v0, 0x8

    new-array v0, v0, [[F

    .line 237
    new-array v1, v4, [F

    fill-array-data v1, :array_b6

    .line 240
    aput-object v1, v0, v6

    .line 242
    new-array v1, v4, [F

    fill-array-data v1, :array_cc

    .line 245
    aput-object v1, v0, v5

    .line 247
    new-array v1, v4, [F

    fill-array-data v1, :array_e2

    .line 250
    aput-object v1, v0, v3

    .line 252
    new-array v1, v4, [F

    fill-array-data v1, :array_f8

    .line 255
    aput-object v1, v0, v7

    const/4 v1, 0x4

    .line 257
    new-array v2, v4, [F

    fill-array-data v2, :array_10e

    .line 260
    aput-object v2, v0, v1

    const/4 v1, 0x5

    .line 262
    new-array v2, v4, [F

    fill-array-data v2, :array_124

    .line 265
    aput-object v2, v0, v1

    const/4 v1, 0x6

    .line 267
    new-array v2, v4, [F

    fill-array-data v2, :array_13a

    .line 270
    aput-object v2, v0, v1

    const/4 v1, 0x7

    .line 272
    new-array v2, v4, [F

    fill-array-data v2, :array_150

    .line 275
    aput-object v2, v0, v1

    .line 236
    sput-object v0, Ljavax/microedition/lcdui/Graphics;->tTrans:[[F

    .line 279
    new-array v0, v4, [F

    sput-object v0, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    .line 280
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    sput-object v0, Ljavax/microedition/lcdui/Graphics;->regionMatrix:Landroid/graphics/Matrix;

    .line 281
    const/16 v0, 0x8

    new-array v0, v0, [[I

    new-array v1, v3, [I

    aput-object v1, v0, v6

    new-array v1, v3, [I

    aput v5, v1, v5

    aput-object v1, v0, v5

    new-array v1, v3, [I

    aput v5, v1, v6

    aput-object v1, v0, v3

    new-array v1, v3, [I

    fill-array-data v1, :array_166

    aput-object v1, v0, v7

    const/4 v1, 0x4

    .line 282
    new-array v2, v3, [I

    aput-object v2, v0, v1

    const/4 v1, 0x5

    new-array v2, v3, [I

    aput v5, v2, v6

    aput-object v2, v0, v1

    const/4 v1, 0x6

    new-array v2, v3, [I

    aput v5, v2, v5

    aput-object v2, v0, v1

    const/4 v1, 0x7

    new-array v2, v3, [I

    fill-array-data v2, :array_16e

    aput-object v2, v0, v1

    .line 281
    sput-object v0, Ljavax/microedition/lcdui/Graphics;->tTransXY:[[I

    .line 283
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    sput-object v0, Ljavax/microedition/lcdui/Graphics;->rect1:Landroid/graphics/Rect;

    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    sput-object v0, Ljavax/microedition/lcdui/Graphics;->rect2:Landroid/graphics/Rect;

    .line 11
    return-void

    .line 27
    :array_ae
    .array-data 4
        0x40a00000    # 5.0f
        0x40a00000    # 5.0f
    .end array-data

    .line 237
    :array_b6
    .array-data 4
        0x3f800000    # 1.0f
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 242
    :array_cc
    .array-data 4
        0x3f800000    # 1.0f
        0x0
        0x0
        0x0
        -0x40800000    # -1.0f
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 247
    :array_e2
    .array-data 4
        -0x40800000    # -1.0f
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 252
    :array_f8
    .array-data 4
        -0x40800000    # -1.0f
        0x0
        0x0
        0x0
        -0x40800000    # -1.0f
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 257
    :array_10e
    .array-data 4
        0x0
        0x3f800000    # 1.0f
        0x0
        0x3f800000    # 1.0f
        0x0
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 262
    :array_124
    .array-data 4
        0x0
        -0x40800000    # -1.0f
        0x0
        0x3f800000    # 1.0f
        0x0
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 267
    :array_13a
    .array-data 4
        0x0
        0x3f800000    # 1.0f
        0x0
        -0x40800000    # -1.0f
        0x0
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 272
    :array_150
    .array-data 4
        0x0
        -0x40800000    # -1.0f
        0x0
        -0x40800000    # -1.0f
        0x0
        0x0
        0x0
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 281
    :array_166
    .array-data 4
        0x1
        0x1
    .end array-data

    .line 282
    :array_16e
    .array-data 4
        0x1
        0x1
    .end array-data
.end method

.method public constructor <init>()V
    .registers 4

    .prologue
    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x0

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-static {}, Ljavax/microedition/lcdui/Font;->getDefaultFont()Ljavax/microedition/lcdui/Font;

    move-result-object v0

    iput-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    .line 26
    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->strokeStyle:I

    .line 30
    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->translateX:I

    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->translateY:I

    .line 34
    iput-boolean v1, p0, Ljavax/microedition/lcdui/Graphics;->isResetPainter:Z

    .line 230
    iput v2, p0, Ljavax/microedition/lcdui/Graphics;->scale_x:F

    iput v2, p0, Ljavax/microedition/lcdui/Graphics;->scale_y:F

    .line 45
    invoke-direct {p0}, Ljavax/microedition/lcdui/Graphics;->initPaint()V

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/graphics/Canvas;)V
    .registers 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x0

    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-static {}, Ljavax/microedition/lcdui/Font;->getDefaultFont()Ljavax/microedition/lcdui/Font;

    move-result-object v0

    iput-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    .line 26
    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->strokeStyle:I

    .line 30
    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->translateX:I

    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->translateY:I

    .line 34
    iput-boolean v1, p0, Ljavax/microedition/lcdui/Graphics;->isResetPainter:Z

    .line 230
    iput v2, p0, Ljavax/microedition/lcdui/Graphics;->scale_x:F

    iput v2, p0, Ljavax/microedition/lcdui/Graphics;->scale_y:F

    .line 50
    iput-object p1, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    .line 51
    invoke-direct {p0}, Ljavax/microedition/lcdui/Graphics;->initPaint()V

    .line 52
    return-void
.end method

.method constructor <init>(Landroid/graphics/Canvas;Landroid/graphics/Paint;Landroid/graphics/Bitmap;)V
    .registers 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "painter"    # Landroid/graphics/Paint;
    .param p3, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x0

    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-static {}, Ljavax/microedition/lcdui/Font;->getDefaultFont()Ljavax/microedition/lcdui/Font;

    move-result-object v0

    iput-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    .line 26
    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->strokeStyle:I

    .line 30
    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->translateX:I

    iput v1, p0, Ljavax/microedition/lcdui/Graphics;->translateY:I

    .line 34
    iput-boolean v1, p0, Ljavax/microedition/lcdui/Graphics;->isResetPainter:Z

    .line 230
    iput v2, p0, Ljavax/microedition/lcdui/Graphics;->scale_x:F

    iput v2, p0, Ljavax/microedition/lcdui/Graphics;->scale_y:F

    .line 61
    iput-object p1, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    .line 62
    iput-object p3, p0, Ljavax/microedition/lcdui/Graphics;->graphicbitmap:Landroid/graphics/Bitmap;

    .line 63
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iput-object p2, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    .line 64
    invoke-direct {p0}, Ljavax/microedition/lcdui/Graphics;->initPaint()V

    .line 65
    return-void
.end method

.method private initPaint()V
    .registers 3

    .prologue
    .line 40
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 41
    return-void
.end method


# virtual methods
.method public clipRect(IIII)V
    .registers 12
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 69
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    int-to-float v1, p1

    int-to-float v2, p2

    add-int v3, p1, p3

    int-to-float v3, v3

    add-int v4, p2, p4

    int-to-float v4, v4

    sget-object v5, Landroid/graphics/Region$Op;->INTERSECT:Landroid/graphics/Region$Op;

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    .line 70
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v0}, Landroid/graphics/Canvas;->getClipBounds()Landroid/graphics/Rect;

    move-result-object v6

    .line 71
    .local v6, "rect":Landroid/graphics/Rect;
    iget v0, v6, Landroid/graphics/Rect;->left:I

    iput v0, p0, Ljavax/microedition/lcdui/Graphics;->clipx:I

    .line 72
    iget v0, v6, Landroid/graphics/Rect;->top:I

    iput v0, p0, Ljavax/microedition/lcdui/Graphics;->clipy:I

    .line 73
    iget v0, v6, Landroid/graphics/Rect;->right:I

    iget v1, v6, Landroid/graphics/Rect;->left:I

    sub-int/2addr v0, v1

    iput v0, p0, Ljavax/microedition/lcdui/Graphics;->clipw:I

    .line 74
    iget v0, v6, Landroid/graphics/Rect;->bottom:I

    iget v1, v6, Landroid/graphics/Rect;->top:I

    sub-int/2addr v0, v1

    iput v0, p0, Ljavax/microedition/lcdui/Graphics;->cliph:I

    .line 75
    return-void
.end method

.method public copyArea(IIIIIII)V
    .registers 17
    .param p1, "x_src"    # I
    .param p2, "y_src"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .param p5, "x_dest"    # I
    .param p6, "y_dest"    # I
    .param p7, "anchor"    # I

    .prologue
    .line 81
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->graphicbitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_c4

    .line 83
    const/4 v8, 0x0

    .line 85
    .local v8, "anchorError":Z
    if-nez p7, :cond_9

    .line 86
    const/16 p7, 0x14

    .line 89
    :cond_9
    and-int/lit8 v0, p7, 0x40

    if-eqz v0, :cond_e

    .line 90
    const/4 v8, 0x1

    .line 93
    :cond_e
    and-int/lit8 v0, p7, 0x10

    if-eqz v0, :cond_2a

    .line 94
    and-int/lit8 v0, p7, 0x22

    if-eqz v0, :cond_17

    .line 95
    const/4 v8, 0x1

    .line 109
    :cond_17
    :goto_17
    and-int/lit8 v0, p7, 0x4

    if-eqz v0, :cond_46

    .line 110
    and-int/lit8 v0, p7, 0x9

    if-eqz v0, :cond_20

    .line 111
    const/4 v8, 0x1

    .line 125
    :cond_20
    :goto_20
    if-eqz v8, :cond_62

    .line 126
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "anchor error"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 97
    :cond_2a
    and-int/lit8 v0, p7, 0x20

    if-eqz v0, :cond_39

    .line 98
    and-int/lit8 v0, p7, 0x2

    if-eqz v0, :cond_34

    .line 99
    const/4 v8, 0x1

    goto :goto_17

    .line 101
    :cond_34
    const/4 v0, 0x1

    sub-int v0, p4, v0

    sub-int/2addr p6, v0

    goto :goto_17

    .line 103
    :cond_39
    and-int/lit8 v0, p7, 0x2

    if-eqz v0, :cond_44

    .line 104
    const/4 v0, 0x1

    sub-int v0, p4, v0

    ushr-int/lit8 v0, v0, 0x1

    sub-int/2addr p6, v0

    goto :goto_17

    .line 106
    :cond_44
    const/4 v8, 0x1

    goto :goto_17

    .line 113
    :cond_46
    and-int/lit8 v0, p7, 0x8

    if-eqz v0, :cond_55

    .line 114
    and-int/lit8 v0, p7, 0x1

    if-eqz v0, :cond_50

    .line 115
    const/4 v8, 0x1

    goto :goto_20

    .line 117
    :cond_50
    const/4 v0, 0x1

    sub-int v0, p3, v0

    sub-int/2addr p5, v0

    goto :goto_20

    .line 119
    :cond_55
    and-int/lit8 v0, p7, 0x1

    if-eqz v0, :cond_60

    .line 120
    const/4 v0, 0x1

    sub-int v0, p3, v0

    ushr-int/lit8 v0, v0, 0x1

    sub-int/2addr p5, v0

    goto :goto_20

    .line 122
    :cond_60
    const/4 v8, 0x1

    goto :goto_20

    .line 129
    :cond_62
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->area:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_c5

    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->area:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    if-ne v0, p3, :cond_c5

    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->area:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    if-ne v0, p4, :cond_c5

    .line 130
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->rgb:[I

    if-eqz v0, :cond_85

    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->rgb:[I

    if-eqz v0, :cond_8b

    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->rgb:[I

    array-length v0, v0

    mul-int v1, p3, p4

    if-eq v0, v1, :cond_8b

    .line 131
    :cond_85
    mul-int v0, p3, p4

    new-array v0, v0, [I

    iput-object v0, p0, Ljavax/microedition/lcdui/Graphics;->rgb:[I

    .line 133
    :cond_8b
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->graphicbitmap:Landroid/graphics/Bitmap;

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->rgb:[I

    const/4 v2, 0x0

    move v3, p3

    move v4, p1

    move v5, p2

    move v6, p3

    move v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->getPixels([IIIIIII)V

    .line 134
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->area:Landroid/graphics/Bitmap;

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->rgb:[I

    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move v3, p3

    move v6, p3

    move v7, p4

    invoke-virtual/range {v0 .. v7}, Landroid/graphics/Bitmap;->setPixels([IIIIIII)V

    .line 139
    :goto_a5
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 140
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->area:Landroid/graphics/Bitmap;

    int-to-float v2, p5

    int-to-float v3, p6

    iget-object v4, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v4, v4, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 141
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 144
    .end local v8    # "anchorError":Z
    :cond_c4
    return-void

    .line 136
    .restart local v8    # "anchorError":Z
    :cond_c5
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->graphicbitmap:Landroid/graphics/Bitmap;

    invoke-static {v0, p1, p2, p3, p4}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Ljavax/microedition/lcdui/Graphics;->area:Landroid/graphics/Bitmap;

    goto :goto_a5
.end method

.method public drawArc(IIIIII)V
    .registers 13
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .param p5, "startAngle"    # I
    .param p6, "arcAngle"    # I

    .prologue
    .line 148
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 149
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    new-instance v1, Landroid/graphics/RectF;

    int-to-float v2, p1

    int-to-float v3, p2

    add-int v4, p1, p3

    int-to-float v4, v4

    add-int v5, p2, p4

    int-to-float v5, v5

    invoke-direct {v1, v2, v3, v4, v5}, Landroid/graphics/RectF;-><init>(FFFF)V

    int-to-float v2, p5

    int-to-float v3, p6

    const/4 v4, 0x0

    iget-object v5, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v5, v5, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 150
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 151
    return-void
.end method

.method public drawChar(CIII)V
    .registers 8
    .param p1, "character"    # C
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "anchor"    # I

    .prologue
    .line 161
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    const/4 v1, 0x0

    sget-object v2, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuffer;->delete(II)Ljava/lang/StringBuffer;

    .line 162
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 164
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p2, p3, p4}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 165
    return-void
.end method

.method public drawChars([CIIIII)V
    .registers 10
    .param p1, "data"    # [C
    .param p2, "offset"    # I
    .param p3, "length"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I
    .param p6, "anchor"    # I

    .prologue
    .line 196
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    const/4 v1, 0x0

    sget-object v2, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuffer;->delete(II)Ljava/lang/StringBuffer;

    .line 197
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    invoke-virtual {v0, p1, p2, p3}, Ljava/lang/StringBuffer;->append([CII)Ljava/lang/StringBuffer;

    .line 199
    sget-object v0, Ljavax/microedition/lcdui/Graphics;->sb:Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p4, p5, p6}, Ljavax/microedition/lcdui/Graphics;->drawString(Ljava/lang/String;III)V

    .line 200
    return-void
.end method

.method public drawImage(Ljavax/microedition/lcdui/Image;III)V
    .registers 10
    .param p1, "img"    # Ljavax/microedition/lcdui/Image;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "anchor"    # I

    .prologue
    .line 213
    and-int/lit8 v0, p4, 0x8

    if-eqz v0, :cond_22

    .line 214
    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getWidth()I

    move-result v0

    sub-int/2addr p2, v0

    .line 219
    :cond_9
    :goto_9
    and-int/lit8 v0, p4, 0x20

    if-eqz v0, :cond_2e

    .line 220
    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getHeight()I

    move-result v0

    sub-int/2addr p3, v0

    .line 226
    :cond_12
    :goto_12
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getBitMapInpackage()Landroid/graphics/Bitmap;

    move-result-object v1

    int-to-float v2, p2

    int-to-float v3, p3

    iget-object v4, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v4, v4, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 227
    return-void

    .line 216
    :cond_22
    and-int/lit8 v0, p4, 0x1

    if-eqz v0, :cond_9

    .line 217
    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    sub-int/2addr p2, v0

    goto :goto_9

    .line 222
    :cond_2e
    and-int/lit8 v0, p4, 0x2

    if-eqz v0, :cond_12

    .line 223
    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    sub-int/2addr p3, v0

    goto :goto_12
.end method

.method public drawLine(FFFF)V
    .registers 11
    .param p1, "x1"    # F
    .param p2, "y1"    # F
    .param p3, "x2"    # F
    .param p4, "y2"    # F

    .prologue
    .line 564
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v5, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 565
    return-void
.end method

.method public drawRGB([IIIIIIIZ)V
    .registers 31
    .param p1, "rgbData"    # [I
    .param p2, "offset"    # I
    .param p3, "scanlength"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I
    .param p6, "width"    # I
    .param p7, "height"    # I
    .param p8, "processAlpha"    # Z

    .prologue
    .line 337
    if-nez p1, :cond_8

    .line 338
    new-instance v5, Ljava/lang/NullPointerException;

    invoke-direct {v5}, Ljava/lang/NullPointerException;-><init>()V

    throw v5

    .line 340
    :cond_8
    if-lez p6, :cond_c

    if-gtz p7, :cond_d

    .line 367
    :cond_c
    :goto_c
    return-void

    .line 344
    :cond_d
    move-object/from16 v0, p1

    array-length v0, v0

    move v15, v0

    .line 345
    .local v15, "l":I
    if-ltz p6, :cond_32

    if-ltz p7, :cond_32

    if-ltz p2, :cond_32

    move/from16 v0, p2

    move v1, v15

    if-ge v0, v1, :cond_32

    if-gez p3, :cond_25

    const/4 v5, 0x1

    sub-int v5, p7, v5

    mul-int v5, v5, p3

    if-ltz v5, :cond_32

    :cond_25
    if-ltz p3, :cond_38

    const/4 v5, 0x1

    sub-int v5, p7, v5

    mul-int v5, v5, p3

    add-int v5, v5, p6

    const/4 v6, 0x1

    sub-int/2addr v5, v6

    if-lt v5, v15, :cond_38

    .line 346
    :cond_32
    new-instance v5, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v5}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v5

    .line 349
    :cond_38
    const/4 v5, 0x0

    aget v16, p1, v5

    .line 350
    .local v16, "rgb1":I
    div-int/lit8 v5, v15, 0x2

    aget v17, p1, v5

    .line 351
    .local v17, "rgb2":I
    div-int/lit8 v5, v15, 0x3

    aget v18, p1, v5

    .line 352
    .local v18, "rgb3":I
    div-int/lit8 v5, v15, 0x4

    aget v19, p1, v5

    .line 353
    .local v19, "rgb4":I
    mul-int/lit8 v5, v15, 0x5

    div-int/lit8 v5, v5, 0x8

    aget v20, p1, v5

    .line 354
    .local v20, "rgb5":I
    mul-int/lit8 v5, v15, 0x4

    div-int/lit8 v5, v5, 0x5

    aget v21, p1, v5

    .line 355
    .local v21, "rgb6":I
    move/from16 v0, v16

    move/from16 v1, v17

    if-ne v0, v1, :cond_8c

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_8c

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_8c

    move/from16 v0, v19

    move/from16 v1, v20

    if-ne v0, v1, :cond_8c

    move/from16 v0, v20

    move/from16 v1, v21

    if-ne v0, v1, :cond_8c

    .line 356
    move-object/from16 v0, p0

    iget-object v0, v0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    move-object v5, v0

    iget-object v5, v5, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    move-object v0, v5

    move/from16 v1, v16

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 357
    move-object/from16 v0, p0

    move/from16 v1, p4

    move/from16 v2, p5

    move/from16 v3, p6

    move/from16 v4, p7

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    goto :goto_c

    .line 360
    :cond_8c
    move/from16 v0, p3

    move/from16 v1, p6

    if-ge v0, v1, :cond_94

    .line 361
    move/from16 p3, p6

    .line 363
    :cond_94
    move-object/from16 v0, p0

    iget-object v0, v0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    move-object v5, v0

    iget-object v5, v5, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v6, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 364
    move-object/from16 v0, p0

    iget-object v0, v0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    move-object v6, v0

    iget-object v14, v6, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    move-object/from16 v6, p1

    move/from16 v7, p2

    move/from16 v8, p3

    move/from16 v9, p4

    move/from16 v10, p5

    move/from16 v11, p6

    move/from16 v12, p7

    move/from16 v13, p8

    invoke-virtual/range {v5 .. v14}, Landroid/graphics/Canvas;->drawBitmap([IIIIIIIZLandroid/graphics/Paint;)V

    .line 365
    move-object/from16 v0, p0

    iget-object v0, v0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    move-object v5, v0

    iget-object v5, v5, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v6, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v5, v6}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    goto/16 :goto_c
.end method

.method public drawRect(IIII)V
    .registers 11
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 204
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 206
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    int-to-float v1, p1

    int-to-float v2, p2

    add-int v3, p1, p3

    int-to-float v3, v3

    add-int v4, p2, p4

    int-to-float v4, v4

    iget-object v5, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v5, v5, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 207
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 208
    return-void
.end method

.method public drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIII)V
    .registers 17
    .param p1, "src"    # Ljavax/microedition/lcdui/Image;
    .param p2, "x_src"    # I
    .param p3, "y_src"    # I
    .param p4, "width"    # I
    .param p5, "height"    # I
    .param p6, "transform"    # I
    .param p7, "x"    # I
    .param p8, "y"    # I
    .param p9, "anchor"    # I

    .prologue
    .line 287
    move v1, p4

    .local v1, "tmp_w":I
    move v0, p5

    .line 294
    .local v0, "tmp_h":I
    const/4 v2, 0x3

    if-le p6, v2, :cond_7

    .line 295
    move v1, p5

    .line 296
    move v0, p4

    .line 298
    :cond_7
    and-int/lit8 v2, p9, 0x8

    if-eqz v2, :cond_37

    .line 299
    sub-int/2addr p7, v1

    .line 303
    :cond_c
    :goto_c
    and-int/lit8 v2, p9, 0x20

    if-eqz v2, :cond_3f

    .line 304
    sub-int/2addr p8, v0

    .line 309
    :cond_11
    :goto_11
    if-nez p6, :cond_47

    .line 310
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->rect1:Landroid/graphics/Rect;

    add-int v3, p2, p4

    add-int v4, p3, p5

    invoke-virtual {v2, p2, p3, v3, v4}, Landroid/graphics/Rect;->set(IIII)V

    .line 311
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->rect2:Landroid/graphics/Rect;

    add-int v3, p7, p4

    add-int v4, p8, p5

    invoke-virtual {v2, p7, p8, v3, v4}, Landroid/graphics/Rect;->set(IIII)V

    .line 312
    iget-object v2, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getBitMapInpackage()Landroid/graphics/Bitmap;

    move-result-object v3

    sget-object v4, Ljavax/microedition/lcdui/Graphics;->rect1:Landroid/graphics/Rect;

    sget-object v5, Ljavax/microedition/lcdui/Graphics;->rect2:Landroid/graphics/Rect;

    iget-object v6, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v6, v6, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 333
    :goto_36
    return-void

    .line 300
    :cond_37
    and-int/lit8 v2, p9, 0x1

    if-eqz v2, :cond_c

    .line 301
    div-int/lit8 v2, v1, 0x2

    sub-int/2addr p7, v2

    goto :goto_c

    .line 305
    :cond_3f
    and-int/lit8 v2, p9, 0x2

    if-eqz v2, :cond_11

    .line 306
    div-int/lit8 v2, v0, 0x2

    sub-int/2addr p8, v2

    goto :goto_11

    .line 316
    :cond_47
    iget-object v2, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v2}, Landroid/graphics/Canvas;->getMatrix()Landroid/graphics/Matrix;

    move-result-object v2

    sput-object v2, Ljavax/microedition/lcdui/Graphics;->ttmatrix:Landroid/graphics/Matrix;

    .line 319
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->tTrans:[[F

    aget-object v2, v2, p6

    const/4 v3, 0x0

    sget-object v4, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    const/4 v5, 0x0

    const/16 v6, 0x9

    invoke-static {v2, v3, v4, v5, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 321
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    const/4 v3, 0x2

    sget-object v4, Ljavax/microedition/lcdui/Graphics;->tTransXY:[[I

    aget-object v4, v4, p6

    const/4 v5, 0x0

    aget v4, v4, v5

    mul-int/2addr v4, v1

    add-int/2addr v4, p7

    int-to-float v4, v4

    aput v4, v2, v3

    .line 322
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    const/4 v3, 0x5

    sget-object v4, Ljavax/microedition/lcdui/Graphics;->tTransXY:[[I

    aget-object v4, v4, p6

    const/4 v5, 0x1

    aget v4, v4, v5

    mul-int/2addr v4, v0

    add-int/2addr v4, p8

    int-to-float v4, v4

    aput v4, v2, v3

    .line 324
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->regionMatrix:Landroid/graphics/Matrix;

    sget-object v3, Ljavax/microedition/lcdui/Graphics;->tTransTemp:[F

    invoke-virtual {v2, v3}, Landroid/graphics/Matrix;->setValues([F)V

    .line 325
    iget v2, p0, Ljavax/microedition/lcdui/Graphics;->scale_x:F

    const/high16 v3, 0x3f800000    # 1.0f

    cmpl-float v2, v2, v3

    if-nez v2, :cond_91

    iget v2, p0, Ljavax/microedition/lcdui/Graphics;->scale_y:F

    const/high16 v3, 0x3f800000    # 1.0f

    cmpl-float v2, v2, v3

    if-eqz v2, :cond_9a

    .line 326
    :cond_91
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->regionMatrix:Landroid/graphics/Matrix;

    iget v3, p0, Ljavax/microedition/lcdui/Graphics;->scale_x:F

    iget v4, p0, Ljavax/microedition/lcdui/Graphics;->scale_y:F

    invoke-virtual {v2, v3, v4}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 328
    :cond_9a
    iget-object v2, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    sget-object v3, Ljavax/microedition/lcdui/Graphics;->regionMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v2, v3}, Landroid/graphics/Canvas;->setMatrix(Landroid/graphics/Matrix;)V

    .line 329
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->rect1:Landroid/graphics/Rect;

    add-int v3, p2, p4

    add-int v4, p3, p5

    invoke-virtual {v2, p2, p3, v3, v4}, Landroid/graphics/Rect;->set(IIII)V

    .line 330
    sget-object v2, Ljavax/microedition/lcdui/Graphics;->rect2:Landroid/graphics/Rect;

    const/4 v3, 0x0

    const/4 v4, 0x0

    add-int/lit8 v5, p4, 0x1

    invoke-virtual {v2, v3, v4, v5, p5}, Landroid/graphics/Rect;->set(IIII)V

    .line 331
    iget-object v2, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {p1}, Ljavax/microedition/lcdui/Image;->getBitMapInpackage()Landroid/graphics/Bitmap;

    move-result-object v3

    sget-object v4, Ljavax/microedition/lcdui/Graphics;->rect1:Landroid/graphics/Rect;

    sget-object v5, Ljavax/microedition/lcdui/Graphics;->rect2:Landroid/graphics/Rect;

    iget-object v6, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v6, v6, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v3, v4, v5, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 332
    iget-object v2, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    sget-object v3, Ljavax/microedition/lcdui/Graphics;->ttmatrix:Landroid/graphics/Matrix;

    invoke-virtual {v2, v3}, Landroid/graphics/Canvas;->setMatrix(Landroid/graphics/Matrix;)V

    goto/16 :goto_36
.end method

.method public drawRoundRect(IIIIII)V
    .registers 12
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .param p5, "arcWidth"    # I
    .param p6, "arcHeight"    # I

    .prologue
    .line 371
    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v1, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 373
    new-instance v0, Landroid/graphics/RectF;

    int-to-float v1, p1

    int-to-float v2, p2

    add-int v3, p1, p3

    int-to-float v3, v3

    add-int v4, p2, p4

    int-to-float v4, v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/RectF;-><init>(FFFF)V

    .line 374
    .local v0, "rectF":Landroid/graphics/RectF;
    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    int-to-float v2, p5

    int-to-float v3, p6

    iget-object v4, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v4, v4, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v1, v0, v2, v3, v4}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 375
    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v1, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 376
    return-void
.end method

.method public drawString(Ljava/lang/String;III)V
    .registers 9
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "anchor"    # I

    .prologue
    .line 170
    add-int/lit8 p3, p3, -0x5

    .line 172
    if-nez p4, :cond_6

    .line 173
    const/16 p4, 0x14

    .line 175
    :cond_6
    and-int/lit8 v0, p4, 0x10

    if-eqz v0, :cond_2c

    .line 176
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr p3, v0

    .line 183
    :cond_13
    :goto_13
    and-int/lit8 v0, p4, 0x1

    if-eqz v0, :cond_5c

    .line 184
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 191
    :cond_20
    :goto_20
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    int-to-float v1, p2

    int-to-float v2, p3

    iget-object v3, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v3, v3, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 192
    return-void

    .line 177
    :cond_2c
    and-int/lit8 v0, p4, 0x20

    if-eqz v0, :cond_3a

    .line 178
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    sub-int/2addr p3, v0

    goto :goto_13

    .line 179
    :cond_3a
    and-int/lit8 v0, p4, 0x2

    if-eqz v0, :cond_13

    .line 180
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v1}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v1

    iget v1, v1, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x2

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v1}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v1

    iget v1, v1, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    sub-int/2addr v0, v1

    add-int/2addr p3, v0

    goto :goto_13

    .line 185
    :cond_5c
    and-int/lit8 v0, p4, 0x8

    if-eqz v0, :cond_6a

    .line 186
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Align;->RIGHT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    goto :goto_20

    .line 187
    :cond_6a
    and-int/lit8 v0, p4, 0x4

    if-eqz v0, :cond_20

    .line 188
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    goto :goto_20
.end method

.method public drawSubstring(Ljava/lang/String;IIIII)V
    .registers 14
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "offset"    # I
    .param p3, "len"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I
    .param p6, "anchor"    # I

    .prologue
    .line 380
    if-nez p6, :cond_4

    .line 381
    const/16 p6, 0x14

    .line 384
    :cond_4
    and-int/lit8 v0, p6, 0x10

    if-eqz v0, :cond_2e

    .line 385
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->top:I

    sub-int/2addr p5, v0

    .line 392
    :cond_11
    :goto_11
    and-int/lit8 v0, p6, 0x1

    if-eqz v0, :cond_5e

    .line 393
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 400
    :cond_1e
    :goto_1e
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    add-int v3, p3, p2

    int-to-float v4, p4

    int-to-float v5, p5

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v6, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    move-object v1, p1

    move v2, p2

    invoke-virtual/range {v0 .. v6}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;IIFFLandroid/graphics/Paint;)V

    .line 401
    return-void

    .line 386
    :cond_2e
    and-int/lit8 v0, p6, 0x20

    if-eqz v0, :cond_3c

    .line 387
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->bottom:I

    sub-int/2addr p5, v0

    goto :goto_11

    .line 388
    :cond_3c
    and-int/lit8 v0, p6, 0x2

    if-eqz v0, :cond_11

    .line 389
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v0

    iget v0, v0, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v1}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v1

    iget v1, v1, Landroid/graphics/Paint$FontMetricsInt;->ascent:I

    sub-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x2

    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v1}, Ljavax/microedition/lcdui/Font;->getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v1

    iget v1, v1, Landroid/graphics/Paint$FontMetricsInt;->descent:I

    sub-int/2addr v0, v1

    add-int/2addr p5, v0

    goto :goto_11

    .line 394
    :cond_5e
    and-int/lit8 v0, p6, 0x8

    if-eqz v0, :cond_6c

    .line 395
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Align;->RIGHT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    goto :goto_1e

    .line 396
    :cond_6c
    and-int/lit8 v0, p6, 0x4

    if-eqz v0, :cond_1e

    .line 397
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    goto :goto_1e
.end method

.method public fillArc(IIIIII)V
    .registers 13
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .param p5, "startAngle"    # I
    .param p6, "arcAngle"    # I

    .prologue
    .line 406
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    new-instance v1, Landroid/graphics/RectF;

    int-to-float v2, p1

    int-to-float v3, p2

    add-int v4, p1, p3

    int-to-float v4, v4

    add-int v5, p2, p4

    int-to-float v5, v5

    invoke-direct {v1, v2, v3, v4, v5}, Landroid/graphics/RectF;-><init>(FFFF)V

    int-to-float v2, p5

    int-to-float v3, p6

    const/4 v4, 0x0

    iget-object v5, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v5, v5, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawArc(Landroid/graphics/RectF;FFZLandroid/graphics/Paint;)V

    .line 407
    return-void
.end method

.method public fillRect(IIII)V
    .registers 11
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 412
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    int-to-float v1, p1

    int-to-float v2, p2

    add-int v3, p1, p3

    int-to-float v3, v3

    add-int v4, p2, p4

    int-to-float v4, v4

    iget-object v5, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v5, v5, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 413
    return-void
.end method

.method public fillRoundRect(IIIIII)V
    .registers 13
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .param p5, "arcWidth"    # I
    .param p6, "arcHeight"    # I

    .prologue
    .line 418
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    new-instance v1, Landroid/graphics/RectF;

    int-to-float v2, p1

    int-to-float v3, p2

    add-int v4, p1, p3

    int-to-float v4, v4

    add-int v5, p2, p4

    int-to-float v5, v5

    invoke-direct {v1, v2, v3, v4, v5}, Landroid/graphics/RectF;-><init>(FFFF)V

    int-to-float v2, p5

    int-to-float v3, p6

    iget-object v4, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v4, v4, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/graphics/Canvas;->drawRoundRect(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V

    .line 419
    return-void
.end method

.method public fillTriangle(IIIIII)V
    .registers 10
    .param p1, "x1"    # I
    .param p2, "y1"    # I
    .param p3, "x2"    # I
    .param p4, "y2"    # I
    .param p5, "x3"    # I
    .param p6, "y3"    # I

    .prologue
    .line 424
    new-instance v0, Landroid/graphics/Path;

    invoke-direct {v0}, Landroid/graphics/Path;-><init>()V

    .line 425
    .local v0, "path":Landroid/graphics/Path;
    int-to-float v1, p1

    int-to-float v2, p2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 426
    int-to-float v1, p3

    int-to-float v2, p4

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 427
    int-to-float v1, p5

    int-to-float v2, p6

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 428
    int-to-float v1, p1

    int-to-float v2, p2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 430
    iget-object v1, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    iget-object v2, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v2, v2, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v1, v0, v2}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 431
    return-void
.end method

.method public getBlueComponent()I
    .registers 2

    .prologue
    .line 444
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getColor()I

    move-result v0

    and-int/lit16 v0, v0, 0xff

    return v0
.end method

.method public getCanvas()Landroid/graphics/Canvas;
    .registers 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NullPointerException;
        }
    .end annotation

    .prologue
    .line 589
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    if-nez v0, :cond_a

    .line 590
    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    .line 591
    :cond_a
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    return-object v0
.end method

.method public getClipHeight()I
    .registers 2

    .prologue
    .line 459
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->cliph:I

    return v0
.end method

.method public getClipWidth()I
    .registers 2

    .prologue
    .line 464
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->clipw:I

    return v0
.end method

.method public getClipX()I
    .registers 2

    .prologue
    .line 469
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->clipx:I

    return v0
.end method

.method public getClipY()I
    .registers 2

    .prologue
    .line 474
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->clipy:I

    return v0
.end method

.method public getColor()I
    .registers 2

    .prologue
    .line 479
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getColor()I

    move-result v0

    return v0
.end method

.method public getDisplayColor(I)I
    .registers 2
    .param p1, "color"    # I

    .prologue
    .line 484
    return p1
.end method

.method public getFont()Ljavax/microedition/lcdui/Font;
    .registers 2

    .prologue
    .line 489
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    return-object v0
.end method

.method public getGrayScale()I
    .registers 3

    .prologue
    .line 494
    invoke-virtual {p0}, Ljavax/microedition/lcdui/Graphics;->getRedComponent()I

    move-result v0

    invoke-virtual {p0}, Ljavax/microedition/lcdui/Graphics;->getGreenComponent()I

    move-result v1

    add-int/2addr v0, v1

    invoke-virtual {p0}, Ljavax/microedition/lcdui/Graphics;->getBlueComponent()I

    move-result v1

    add-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x3

    return v0
.end method

.method public getGreenComponent()I
    .registers 2

    .prologue
    .line 449
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getColor()I

    move-result v0

    shr-int/lit8 v0, v0, 0x8

    and-int/lit16 v0, v0, 0xff

    return v0
.end method

.method public getRedComponent()I
    .registers 2

    .prologue
    .line 454
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->getColor()I

    move-result v0

    shr-int/lit8 v0, v0, 0x10

    and-int/lit16 v0, v0, 0xff

    return v0
.end method

.method public getStrokeStyle()I
    .registers 2

    .prologue
    .line 499
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->strokeStyle:I

    return v0
.end method

.method public getTranslateX()I
    .registers 2

    .prologue
    .line 518
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->translateX:I

    return v0
.end method

.method public getTranslateY()I
    .registers 2

    .prologue
    .line 523
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->translateY:I

    return v0
.end method

.method public getXY(FF)V
    .registers 3
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 232
    iput p1, p0, Ljavax/microedition/lcdui/Graphics;->scale_x:F

    .line 233
    iput p2, p0, Ljavax/microedition/lcdui/Graphics;->scale_y:F

    .line 234
    return-void
.end method

.method public isAutoResetPainter()Z
    .registers 2

    .prologue
    .line 577
    iget-boolean v0, p0, Ljavax/microedition/lcdui/Graphics;->isResetPainter:Z

    return v0
.end method

.method public painterAutoReset(Z)V
    .registers 2
    .param p1, "flag"    # Z

    .prologue
    .line 573
    iput-boolean p1, p0, Ljavax/microedition/lcdui/Graphics;->isResetPainter:Z

    .line 574
    return-void
.end method

.method public painterReset()V
    .registers 2

    .prologue
    .line 584
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0}, Landroid/graphics/Paint;->reset()V

    .line 585
    return-void
.end method

.method public restCanvas()V
    .registers 3

    .prologue
    .line 594
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    invoke-virtual {v0}, Landroid/graphics/Canvas;->restore()V

    .line 595
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/graphics/Canvas;->save(I)I

    .line 596
    return-void
.end method

.method setCanvas(Landroid/graphics/Canvas;)V
    .registers 2
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 56
    iput-object p1, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    .line 57
    invoke-direct {p0}, Ljavax/microedition/lcdui/Graphics;->initPaint()V

    .line 58
    return-void
.end method

.method public setClip(IIII)V
    .registers 11
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 528
    iput p1, p0, Ljavax/microedition/lcdui/Graphics;->clipx:I

    .line 529
    iput p2, p0, Ljavax/microedition/lcdui/Graphics;->clipy:I

    .line 530
    iput p3, p0, Ljavax/microedition/lcdui/Graphics;->clipw:I

    .line 531
    iput p4, p0, Ljavax/microedition/lcdui/Graphics;->cliph:I

    .line 533
    if-ltz p3, :cond_c

    if-gez p4, :cond_d

    .line 537
    :cond_c
    :goto_c
    return-void

    .line 536
    :cond_d
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    int-to-float v1, p1

    int-to-float v2, p2

    add-int v3, p1, p3

    int-to-float v3, v3

    add-int v4, p2, p4

    int-to-float v4, v4

    sget-object v5, Landroid/graphics/Region$Op;->REPLACE:Landroid/graphics/Region$Op;

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->clipRect(FFFFLandroid/graphics/Region$Op;)Z

    goto :goto_c
.end method

.method public setColor(I)V
    .registers 4
    .param p1, "RGB"    # I

    .prologue
    const/high16 v1, -0x1000000

    .line 541
    and-int v0, p1, v1

    if-eqz v0, :cond_e

    .line 542
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 546
    :goto_d
    return-void

    .line 544
    :cond_e
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    or-int/2addr v1, p1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    goto :goto_d
.end method

.method public setColor(III)V
    .registers 5
    .param p1, "red"    # I
    .param p2, "green"    # I
    .param p3, "blue"    # I

    .prologue
    .line 550
    invoke-static {p1, p2, p3}, Landroid/graphics/Color;->rgb(III)I

    move-result v0

    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 551
    return-void
.end method

.method public setFont(Ljavax/microedition/lcdui/Font;)V
    .registers 2
    .param p1, "font"    # Ljavax/microedition/lcdui/Font;

    .prologue
    .line 155
    iput-object p1, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    .line 156
    return-void
.end method

.method public setGrayScale(I)V
    .registers 3
    .param p1, "grey"    # I

    .prologue
    .line 555
    if-ltz p1, :cond_6

    const/16 v0, 0xff

    if-le p1, v0, :cond_c

    .line 556
    :cond_6
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 558
    :cond_c
    invoke-virtual {p0, p1, p1, p1}, Ljavax/microedition/lcdui/Graphics;->setColor(III)V

    .line 559
    return-void
.end method

.method public setStrokeStyle(I)V
    .registers 4
    .param p1, "style"    # I

    .prologue
    const/4 v0, 0x1

    .line 504
    if-nez p1, :cond_5

    if-eq p1, v0, :cond_b

    .line 505
    :cond_5
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 507
    :cond_b
    iput p1, p0, Ljavax/microedition/lcdui/Graphics;->strokeStyle:I

    .line 509
    if-nez p1, :cond_18

    .line 510
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setPathEffect(Landroid/graphics/PathEffect;)Landroid/graphics/PathEffect;

    .line 514
    :cond_17
    :goto_17
    return-void

    .line 511
    :cond_18
    if-ne p1, v0, :cond_17

    .line 512
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->font:Ljavax/microedition/lcdui/Font;

    iget-object v0, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v1, Ljavax/microedition/lcdui/Graphics;->dashPathEffect:Landroid/graphics/DashPathEffect;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setPathEffect(Landroid/graphics/PathEffect;)Landroid/graphics/PathEffect;

    goto :goto_17
.end method

.method public translate(II)V
    .registers 6
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 435
    iget-object v0, p0, Ljavax/microedition/lcdui/Graphics;->canvas:Landroid/graphics/Canvas;

    int-to-float v1, p1

    int-to-float v2, p2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Canvas;->translate(FF)V

    .line 436
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->translateX:I

    add-int/2addr v0, p1

    iput v0, p0, Ljavax/microedition/lcdui/Graphics;->translateX:I

    .line 437
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->translateY:I

    add-int/2addr v0, p2

    iput v0, p0, Ljavax/microedition/lcdui/Graphics;->translateY:I

    .line 438
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->clipx:I

    sub-int/2addr v0, p1

    iput v0, p0, Ljavax/microedition/lcdui/Graphics;->clipx:I

    .line 439
    iget v0, p0, Ljavax/microedition/lcdui/Graphics;->clipy:I

    sub-int/2addr v0, p2

    iput v0, p0, Ljavax/microedition/lcdui/Graphics;->clipy:I

    .line 440
    return-void
.end method
