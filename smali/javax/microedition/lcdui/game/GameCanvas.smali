.class public abstract Ljavax/microedition/lcdui/game/GameCanvas;
.super Ljavax/microedition/lcdui/Canvas;
.source "GameCanvas.java"

.field public final static DOWN_PRESSED:I = 64

.field public final static FIRE_PRESSED:I = 256

.field public final static GAME_A_PRESSED:I = 512

.field public final static GAME_B_PRESSED:I = 1024

.field public final static GAME_C_PRESSED:I = 2048

.field public final static GAME_D_PRESSED:I = 4096

.field public final static LEFT_PRESSED:I = 4

.field public final static RIGHT_PRESSED:I = 32

.field public final static UP_PRESSED:I = 2

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
  .parameter "context" # Landroid/content/Context;
  .parameter "attrs" # Landroid/util/AttributeSet;
  .registers 3
  .prologue
  .line 25
    invoke-direct { p0, p1, p2 }, Ljavax/microedition/lcdui/Canvas;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
  .line 26
    return-void
.end method

.method public paint(Ljavax/microedition/lcdui/Graphics;)V
  .parameter "g" # Ljavax/microedition/lcdui/Graphics;
  .registers 2
  .prologue
  .line 40
    return-void
.end method
