.class public abstract Ljavax/microedition/lcdui/game/GameCanvas;
.super Ljavax/microedition/lcdui/Canvas;
.source "GameCanvas.java"


# static fields
.field public static final DOWN_PRESSED:I = 0x40

.field public static final FIRE_PRESSED:I = 0x100

.field public static final GAME_A_PRESSED:I = 0x200

.field public static final GAME_B_PRESSED:I = 0x400

.field public static final GAME_C_PRESSED:I = 0x800

.field public static final GAME_D_PRESSED:I = 0x1000

.field public static final LEFT_PRESSED:I = 0x4

.field public static final RIGHT_PRESSED:I = 0x20

.field public static final UP_PRESSED:I = 0x2


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Ljavax/microedition/lcdui/Canvas;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    return-void
.end method


# virtual methods
.method public paint(Ljavax/microedition/lcdui/Graphics;)V
    .locals 0
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 40
    return-void
.end method
