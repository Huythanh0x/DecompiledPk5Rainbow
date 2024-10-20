.class public Lcom/nokia/mid/ui/DirectUtils;
.super Ljava/lang/Object;
.source "DirectUtils.java"


# static fields
.field private static dg:Lcom/nokia/mid/ui/DirectGraphics;


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createImage(III)Ljavax/microedition/lcdui/Image;
    .registers 4
    .param p0, "width"    # I
    .param p1, "height"    # I
    .param p2, "ARGBcolor"    # I

    .prologue
    .line 14
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Ljavax/microedition/lcdui/Image;->createImage(III)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    return-object v0
.end method

.method public static getDirectGraphics(Ljavax/microedition/lcdui/Graphics;)Lcom/nokia/mid/ui/DirectGraphics;
    .registers 2
    .param p0, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 18
    new-instance v0, Lcom/nokia/mid/ui/DirectGraphics;

    invoke-direct {v0}, Lcom/nokia/mid/ui/DirectGraphics;-><init>()V

    sput-object v0, Lcom/nokia/mid/ui/DirectUtils;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    .line 19
    sget-object v0, Lcom/nokia/mid/ui/DirectUtils;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    iput-object p0, v0, Lcom/nokia/mid/ui/DirectGraphics;->g:Ljavax/microedition/lcdui/Graphics;

    .line 20
    sget-object v0, Lcom/nokia/mid/ui/DirectUtils;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    return-object v0
.end method
