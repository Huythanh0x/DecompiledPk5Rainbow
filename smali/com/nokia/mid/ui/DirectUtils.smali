.class public Lcom/nokia/mid/ui/DirectUtils;
.super Ljava/lang/Object;
.source "DirectUtils.java"

.field private static dg:Lcom/nokia/mid/ui/DirectGraphics;

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 6
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static createImage(III)Ljavax/microedition/lcdui/Image;
  .parameter "width" # I
  .parameter "height" # I
  .parameter "ARGBcolor" # I
  .registers 4
  .prologue
  .line 14
    const/4 v0, 0
    invoke-static { p0, p1, v0 }, Ljavax/microedition/lcdui/Image;->createImage(III)Ljavax/microedition/lcdui/Image;
    move-result-object v0
    return-object v0
.end method

.method public static getDirectGraphics(Ljavax/microedition/lcdui/Graphics;)Lcom/nokia/mid/ui/DirectGraphics;
  .parameter "g" # Ljavax/microedition/lcdui/Graphics;
  .registers 2
  .prologue
  .line 18
    new-instance v0, Lcom/nokia/mid/ui/DirectGraphics;
    invoke-direct { v0 }, Lcom/nokia/mid/ui/DirectGraphics;-><init>()V
    sput-object v0, Lcom/nokia/mid/ui/DirectUtils;->dg:Lcom/nokia/mid/ui/DirectGraphics;
  .line 19
    sget-object v0, Lcom/nokia/mid/ui/DirectUtils;->dg:Lcom/nokia/mid/ui/DirectGraphics;
    iput-object p0, v0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;
  .line 20
    sget-object v0, Lcom/nokia/mid/ui/DirectUtils;->dg:Lcom/nokia/mid/ui/DirectGraphics;
    return-object v0
.end method
