.class public Ljavax/microedition/lcdui/Display;
.super Ljava/lang/Object;
.source "Display.java"

.field private static canvas:Ljavax/microedition/lcdui/Canvas;

.method private constructor <init>()V
  .registers 1
  .prologue
  .line 10
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 12
    return-void
.end method

.method public static getCanvas()Ljavax/microedition/lcdui/Canvas;
  .registers 1
  .prologue
  .line 23
    sget-object v0, Ljavax/microedition/lcdui/Display;->canvas:Ljavax/microedition/lcdui/Canvas;
    return-object v0
.end method

.method public static getDisplay(Ljavax/microedition/midlet/MIDlet;)Ljavax/microedition/lcdui/Display;
  .parameter "midlet" # Ljavax/microedition/midlet/MIDlet;
  .registers 2
  .prologue
  .line 15
    new-instance v0, Ljavax/microedition/lcdui/Display;
    invoke-direct { v0 }, Ljavax/microedition/lcdui/Display;-><init>()V
    return-object v0
.end method

.method public setCurrent(Ljavax/microedition/lcdui/Canvas;)V
  .parameter "gCanvas" # Ljavax/microedition/lcdui/Canvas;
  .registers 3
  .prologue
  .line 18
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0, p1 }, Ljavax/microedition/lcdui/CwaActivity;->setCanvas(Ljavax/microedition/lcdui/Canvas;)V
  .line 19
    sput-object p1, Ljavax/microedition/lcdui/Display;->canvas:Ljavax/microedition/lcdui/Canvas;
  .line 20
    return-void
.end method
