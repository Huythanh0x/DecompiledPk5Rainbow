.class public final Ljavax/microedition/lcdui/Font;
.super Ljava/lang/Object;
.source "Font.java"


# static fields
.field public static final FACE_MONOSPACE:I = 0x20

.field public static final FACE_PROPORTIONAL:I = 0x40

.field public static final FACE_SYSTEM:I = 0x0

.field public static final FONT_INPUT_TEXT:I = 0x1

.field public static final FONT_STATIC_TEXT:I = 0x0

.field public static final SIZE_LARGE:I = 0x1a

.field public static final SIZE_MEDIUM:I = 0x16

.field public static final SIZE_SMALL:I = 0x8

.field public static final STYLE_BOLD:I = 0x1

.field public static final STYLE_ITALIC:I = 0x2

.field public static final STYLE_PLAIN:I = 0x0

.field public static final STYLE_UNDERLINED:I = 0x4

.field private static fontSize:[I

.field static font_style:I


# instance fields
.field cHarr:[C

.field private metrics:Landroid/graphics/Paint$FontMetricsInt;

.field private nowSize:I

.field private tTypeface:Landroid/graphics/Typeface;

.field protected tmpPaint:Landroid/graphics/Paint;

.field private tmpSize:I


# direct methods
.method static constructor <clinit>()V
    .registers 2

    .prologue
    .line 42
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/lcdui/CwaActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/high16 v1, 0x7f050000

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getIntArray(I)[I

    move-result-object v0

    sput-object v0, Ljavax/microedition/lcdui/Font;->fontSize:[I

    .line 66
    const/4 v0, 0x0

    sput v0, Ljavax/microedition/lcdui/Font;->font_style:I

    .line 17
    return-void
.end method

.method private constructor <init>()V
    .registers 2

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    .line 124
    const/4 v0, 0x1

    new-array v0, v0, [C

    iput-object v0, p0, Ljavax/microedition/lcdui/Font;->cHarr:[C

    .line 140
    const/4 v0, -0x1

    iput v0, p0, Ljavax/microedition/lcdui/Font;->tmpSize:I

    .line 47
    return-void
.end method

.method public static getDefaultFont()Ljavax/microedition/lcdui/Font;
    .registers 5

    .prologue
    .line 56
    new-instance v0, Ljavax/microedition/lcdui/Font;

    invoke-direct {v0}, Ljavax/microedition/lcdui/Font;-><init>()V

    .line 57
    .local v0, "font":Ljavax/microedition/lcdui/Font;
    const/4 v1, 0x0

    .line 58
    .local v1, "style":I
    sget-object v2, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    or-int/lit8 v1, v1, 0x0

    invoke-static {v2, v1}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object v2

    iput-object v2, v0, Ljavax/microedition/lcdui/Font;->tTypeface:Landroid/graphics/Typeface;

    .line 59
    iget-object v2, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    iget-object v3, v0, Ljavax/microedition/lcdui/Font;->tTypeface:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 60
    iget-object v2, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    sget-object v3, Ljavax/microedition/lcdui/Font;->fontSize:[I

    const/4 v4, 0x0

    aget v3, v3, v4

    int-to-float v3, v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 61
    iget-object v2, v0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v2}, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v2

    iput-object v2, v0, Ljavax/microedition/lcdui/Font;->metrics:Landroid/graphics/Paint$FontMetricsInt;

    .line 62
    return-object v0
.end method

.method public static getFont(III)Ljavax/microedition/lcdui/Font;
    .registers 8
    .param p0, "face"    # I
    .param p1, "style"    # I
    .param p2, "size"    # I

    .prologue
    const/4 v4, 0x0

    .line 69
    new-instance v1, Ljavax/microedition/lcdui/Font;

    invoke-direct {v1}, Ljavax/microedition/lcdui/Font;-><init>()V

    .line 70
    .local v1, "font":Ljavax/microedition/lcdui/Font;
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    .line 71
    .local v0, "family":Landroid/graphics/Typeface;
    sparse-switch p0, :sswitch_data_78

    .line 83
    :goto_b
    sput v4, Ljavax/microedition/lcdui/Font;->font_style:I

    .line 84
    if-eqz v4, :cond_15

    .line 85
    sget v3, Ljavax/microedition/lcdui/Font;->font_style:I

    or-int/lit8 v3, v3, 0x0

    sput v3, Ljavax/microedition/lcdui/Font;->font_style:I

    .line 87
    :cond_15
    and-int/lit8 v3, p1, 0x1

    if-eqz v3, :cond_1f

    .line 88
    sget v3, Ljavax/microedition/lcdui/Font;->font_style:I

    or-int/lit8 v3, v3, 0x1

    sput v3, Ljavax/microedition/lcdui/Font;->font_style:I

    .line 90
    :cond_1f
    and-int/lit8 v3, p1, 0x2

    if-eqz v3, :cond_29

    .line 91
    sget v3, Ljavax/microedition/lcdui/Font;->font_style:I

    or-int/lit8 v3, v3, 0x2

    sput v3, Ljavax/microedition/lcdui/Font;->font_style:I

    .line 93
    :cond_29
    const/4 v2, 0x0

    .line 94
    .local v2, "underLine":Z
    and-int/lit8 v3, p1, 0x4

    if-eqz v3, :cond_2f

    .line 95
    const/4 v2, 0x1

    .line 97
    :cond_2f
    sget v3, Ljavax/microedition/lcdui/Font;->font_style:I

    invoke-static {v0, v3}, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;

    move-result-object v3

    iput-object v3, v1, Ljavax/microedition/lcdui/Font;->tTypeface:Landroid/graphics/Typeface;

    .line 99
    sparse-switch p2, :sswitch_data_86

    .line 110
    :goto_3a
    iget-object v3, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    iget-object v4, v1, Ljavax/microedition/lcdui/Font;->tTypeface:Landroid/graphics/Typeface;

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 111
    iget-object v3, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    iget v4, v1, Ljavax/microedition/lcdui/Font;->nowSize:I

    int-to-float v4, v4

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 112
    iget-object v3, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v3, v2}, Landroid/graphics/Paint;->setUnderlineText(Z)V

    .line 114
    iget-object v3, v1, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v3}, Landroid/graphics/Paint;->getFontMetricsInt()Landroid/graphics/Paint$FontMetricsInt;

    move-result-object v3

    iput-object v3, v1, Ljavax/microedition/lcdui/Font;->metrics:Landroid/graphics/Paint$FontMetricsInt;

    .line 115
    return-object v1

    .line 73
    .end local v2    # "underLine":Z
    :sswitch_57
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    .line 74
    goto :goto_b

    .line 76
    :sswitch_5a
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE:Landroid/graphics/Typeface;

    .line 77
    goto :goto_b

    .line 79
    :sswitch_5d
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    goto :goto_b

    .line 101
    .restart local v2    # "underLine":Z
    :sswitch_60
    sget-object v3, Ljavax/microedition/lcdui/Font;->fontSize:[I

    aget v3, v3, v4

    iput v3, v1, Ljavax/microedition/lcdui/Font;->nowSize:I

    goto :goto_3a

    .line 104
    :sswitch_67
    sget-object v3, Ljavax/microedition/lcdui/Font;->fontSize:[I

    const/4 v4, 0x1

    aget v3, v3, v4

    iput v3, v1, Ljavax/microedition/lcdui/Font;->nowSize:I

    goto :goto_3a

    .line 107
    :sswitch_6f
    sget-object v3, Ljavax/microedition/lcdui/Font;->fontSize:[I

    const/4 v4, 0x2

    aget v3, v3, v4

    iput v3, v1, Ljavax/microedition/lcdui/Font;->nowSize:I

    goto :goto_3a

    .line 71
    nop

    :sswitch_data_78
    .sparse-switch
        0x0 -> :sswitch_57
        0x20 -> :sswitch_5a
        0x40 -> :sswitch_5d
    .end sparse-switch

    .line 99
    :sswitch_data_86
    .sparse-switch
        0x8 -> :sswitch_60
        0x16 -> :sswitch_67
        0x1a -> :sswitch_6f
    .end sparse-switch
.end method


# virtual methods
.method public charWidth(C)I
    .registers 6
    .param p1, "ch"    # C

    .prologue
    const/4 v3, 0x0

    .line 126
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->cHarr:[C

    aput-char p1, v0, v3

    .line 127
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    iget-object v1, p0, Ljavax/microedition/lcdui/Font;->cHarr:[C

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v3, v2}, Landroid/graphics/Paint;->measureText([CII)F

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

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->getFontMetricsInt(Landroid/graphics/Paint$FontMetricsInt;)I

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
    .registers 4
    .param p1, "i"    # I

    .prologue
    .line 142
    iget v0, p0, Ljavax/microedition/lcdui/Font;->tmpSize:I

    if-ne v0, p1, :cond_5

    .line 145
    :goto_4
    return-void

    .line 143
    :cond_5
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    int-to-float v1, p1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 144
    iput p1, p0, Ljavax/microedition/lcdui/Font;->tmpSize:I

    goto :goto_4
.end method

.method public stringWidth(Ljava/lang/String;)I
    .registers 3
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 132
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v0

    float-to-int v0, v0

    return v0
.end method

.method public substringWidth(Ljava/lang/String;II)I
    .registers 6
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "offset"    # I
    .param p3, "len"    # I

    .prologue
    .line 137
    iget-object v0, p0, Ljavax/microedition/lcdui/Font;->tmpPaint:Landroid/graphics/Paint;

    add-int v1, p2, p3

    invoke-virtual {v0, p1, p2, v1}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;II)F

    move-result v0

    float-to-int v0, v0

    return v0
.end method
