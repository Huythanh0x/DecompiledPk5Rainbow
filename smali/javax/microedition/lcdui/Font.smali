.class public final Ljavax/microedition/lcdui/Font;
.super Ljava/lang/Object;
.source "Font.java"

.field public final static FACE_MONOSPACE:I = 32

.field public final static FACE_PROPORTIONAL:I = 64

.field public final static FACE_SYSTEM:I = 0

.field public final static FONT_INPUT_TEXT:I = 1

.field public final static FONT_STATIC_TEXT:I = 0

.field public final static SIZE_LARGE:I = 26

.field public final static SIZE_MEDIUM:I = 22

.field public final static SIZE_SMALL:I = 8

.field public final static STYLE_BOLD:I = 1

.field public final static STYLE_ITALIC:I = 2

.field public final static STYLE_PLAIN:I = 0

.field public final static STYLE_UNDERLINED:I = 4

.field private static fontSize:[I

.field static font_style:I

.field cHarr:[C

.field private metrics:Landroid/graphics/Paint$FontMetricsInt;

.field private nowSize:I

.field private tTypeface:Landroid/graphics/Typeface;

.field protected tmpPaint:Landroid/graphics/Paint;

.field private tmpSize:I

.method static constructor <clinit>()V
  .registers 2
  .prologue
  .line 42
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/CwaActivity;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    const/high16 v1, 32517
    invoke-virtual { v0, v1 }, Landroid/content/res/Resources;->getIntArray(I)[I
    move-result-object v0
    sput-object v0, Ljavax/microedition/lcdui/Font;->fontSize:[I
  .line 66
    const/4 v0, 0
    sput v0, Ljavax/microedition/lcdui/Font;->font_style:I
  .line 17
    return-void
.end method

.method private constructor <init>()V
  .registers 2
  .prologue
  .line 45
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 19
    new-instance v0, Landroid/graphics/Paint;
    invoke-direct { v0 }, Landroid/graphics/Paint;-><init>()V
    iput-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
  .line 124
    const/4 v0, 1
    new-array v0, v0, [C
    iput-object v0, p0, Ljavax/microedition/lcdui/Font;->cHarr:[C
  .line 140
    const/4 v0, -1
    iput v0, p0, Ljavax/microedition/lcdui/Font;->tmpSize:I
  .line 47
    return-void
.end method

.method public static getDefaultFont()Ljavax/microedition/lcdui/Font;
  .registers 5
  .prologue
  .line 56
    new-instance v0, Ljavax/microedition/lcdui/Font;
    invoke-direct { v0 }, Ljavax/microedition/lcdui/Font;-><init>()V
  .line 57
  .local v0, "font":Ljavax/microedition/lcdui/Font;
    const/4 v1, 0
  .line 58
  .local v1, "style":I
    sget-object v2, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;
    or-int/lit8 v1, v1, 0
    invoke-static { v2, v1 }, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    move-result-object v2
    iput-object v2, v0, Ljavax/microedition/lcdui/Font;->tTypeface:Landroid/graphics/Typeface;
  .line 59
    iget-object v2, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    iget-object v3, v0, Ljavax/microedition/lcdui/Font;->tTypeface:Landroid/graphics/Typeface;
    invoke-virtual { v2, v3 }, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
  .line 60
    iget-object v2, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    sget-object v3, Ljavax/microedition/lcdui/Font;->fontSize:[I
    const/4 v4, 0
    aget v3, v3, v4
    int-to-float v3, v3
    invoke-virtual { v2, v3 }, Landroid/graphics/Paint;->setTextSize(F)V
  .line 61
    iget-object v2, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    invoke-virtual { v2 }, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;
    move-result-object v2
    iput-object v2, v0, Ljavax/microedition/lcdui/Font;->metrics:Landroid/graphics/Paint$FontMetricsInt;
  .line 62
    return-object v0
.end method

.method public static getFont(III)Ljavax/microedition/lcdui/Font;
  .parameter "face" # I
  .parameter "style" # I
  .parameter "size" # I
  .registers 8
  .prologue
    const/4 v4, 0
  .line 69
    new-instance v1, Ljavax/microedition/lcdui/Font;
    invoke-direct { v1 }, Ljavax/microedition/lcdui/Font;-><init>()V
  .line 70
  .local v1, "font":Ljavax/microedition/lcdui/Font;
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;
  .line 71
  .local v0, "family":Landroid/graphics/Typeface;
    sparse-switch p0, :L12
  :L0
  .line 83
    sput v4, Ljavax/microedition/lcdui/Font;->font_style:I
  .line 84
    if-eqz v4, :L1
  .line 85
    sget v3, Ljavax/microedition/lcdui/Font;->font_style:I
    or-int/lit8 v3, v3, 0
    sput v3, Ljavax/microedition/lcdui/Font;->font_style:I
  :L1
  .line 87
    and-int/lit8 v3, p1, 1
    if-eqz v3, :L2
  .line 88
    sget v3, Ljavax/microedition/lcdui/Font;->font_style:I
    or-int/lit8 v3, v3, 1
    sput v3, Ljavax/microedition/lcdui/Font;->font_style:I
  :L2
  .line 90
    and-int/lit8 v3, p1, 2
    if-eqz v3, :L3
  .line 91
    sget v3, Ljavax/microedition/lcdui/Font;->font_style:I
    or-int/lit8 v3, v3, 2
    sput v3, Ljavax/microedition/lcdui/Font;->font_style:I
  :L3
  .line 93
    const/4 v2, 0
  .line 94
  .local v2, "underLine":Z
    and-int/lit8 v3, p1, 4
    if-eqz v3, :L4
  .line 95
    const/4 v2, 1
  :L4
  .line 97
    sget v3, Ljavax/microedition/lcdui/Font;->font_style:I
    invoke-static { v0, v3 }, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    move-result-object v3
    iput-object v3, v1, Ljavax/microedition/lcdui/Font;->tTypeface:Landroid/graphics/Typeface;
  .line 99
    sparse-switch p2, :L13
  :L5
  .line 110
    iget-object v3, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    iget-object v4, v1, Ljavax/microedition/lcdui/Font;->tTypeface:Landroid/graphics/Typeface;
    invoke-virtual { v3, v4 }, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
  .line 111
    iget-object v3, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    iget v4, v1, Ljavax/microedition/lcdui/Font;->nowSize:I
    int-to-float v4, v4
    invoke-virtual { v3, v4 }, Landroid/graphics/Paint;->setTextSize(F)V
  .line 112
    iget-object v3, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    invoke-virtual { v3, v2 }, Landroid/graphics/Paint;->setUnderlineText(Z)V
  .line 114
    iget-object v3, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    invoke-virtual { v3 }, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;
    move-result-object v3
    iput-object v3, v1, Ljavax/microedition/lcdui/Font;->metrics:Landroid/graphics/Paint$FontMetricsInt;
  .line 115
    return-object v1
  :L6
  .line 73
  .end local v2
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;
  .line 74
    goto :L0
  :L7
  .line 76
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;
  .line 77
    goto :L0
  :L8
  .line 79
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;
    goto :L0
  :L9
  .line 101
  .restart local v2
    sget-object v3, Ljavax/microedition/lcdui/Font;->fontSize:[I
    aget v3, v3, v4
    iput v3, v1, Ljavax/microedition/lcdui/Font;->nowSize:I
    goto :L5
  :L10
  .line 104
    sget-object v3, Ljavax/microedition/lcdui/Font;->fontSize:[I
    const/4 v4, 1
    aget v3, v3, v4
    iput v3, v1, Ljavax/microedition/lcdui/Font;->nowSize:I
    goto :L5
  :L11
  .line 107
    sget-object v3, Ljavax/microedition/lcdui/Font;->fontSize:[I
    const/4 v4, 2
    aget v3, v3, v4
    iput v3, v1, Ljavax/microedition/lcdui/Font;->nowSize:I
    goto :L5
  .line 71
  .line 99
  :L12
  .sparse-switch
    0 -> :L6
    32 -> :L7
    64 -> :L8
  .end sparse-switch
  :L13
  .sparse-switch
    8 -> :L9
    22 -> :L10
    26 -> :L11
  .end sparse-switch
.end method

.method public charWidth(C)I
  .parameter "ch" # C
  .registers 6
  .prologue
    const/4 v3, 0
  .line 126
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->cHarr:[C
    aput-char p1, v0, v3
  .line 127
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    iget-object v1, p0, Ljavax/microedition/lcdui/Font;->cHarr:[C
    const/4 v2, 1
    invoke-virtual { v0, v1, v3, v2 }, Landroid/graphics/Paint;->measureText([CII)F
    move-result v0
    float-to-int v0, v0
    return v0
.end method

.method public getHeight()I
  .registers 3
  .prologue
  .line 120
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    iget-object v1, p0, Ljavax/microedition/lcdui/Font;->metrics:Landroid/graphics/Paint$FontMetricsInt;
    invoke-virtual { v0, v1 }, Landroid/graphics/Paint;->getFontMetricsInt(Landroid/graphics/Paint$FontMetricsInt;)I
    move-result v0
    return v0
.end method

.method protected getMetricsInt()Landroid/graphics/Paint$FontMetricsInt;
  .registers 2
  .prologue
  .line 51
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->metrics:Landroid/graphics/Paint$FontMetricsInt;
    return-object v0
.end method

.method public setSize(I)V
  .parameter "i" # I
  .registers 4
  .prologue
  .line 142
    iget v0, p0, Ljavax/microedition/lcdui/Font;->tmpSize:I
    if-ne v0, p1, :L1
  :L0
  .line 145
    return-void
  :L1
  .line 143
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    int-to-float v1, p1
    invoke-virtual { v0, v1 }, Landroid/graphics/Paint;->setTextSize(F)V
  .line 144
    iput p1, p0, Ljavax/microedition/lcdui/Font;->tmpSize:I
    goto :L0
.end method

.method public stringWidth(Ljava/lang/String;)I
  .parameter "str" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 132
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    invoke-virtual { v0, p1 }, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F
    move-result v0
    float-to-int v0, v0
    return v0
.end method

.method public substringWidth(Ljava/lang/String;II)I
  .parameter "str" # Ljava/lang/String;
  .parameter "offset" # I
  .parameter "len" # I
  .registers 6
  .prologue
  .line 137
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;
    add-int v1, p2, p3
    invoke-virtual { v0, p1, p2, v1 }, Landroid/graphics/Paint;->measureText(Ljava/lang/String;II)F
    move-result v0
    float-to-int v0, v0
    return v0
.end method
