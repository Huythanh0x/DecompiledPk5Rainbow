.class public Ljavax/microedition/lcdui/Display;
.super Ljava/lang/Object;
.source "Display.java"


# static fields
.field private static canvas:Ljavax/microedition/lcdui/Canvas;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    return-void
.end method

.method public static getCanvas()Ljavax/microedition/lcdui/Canvas;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Ljavax/microedition/lcdui/Display;->canvas:Ljavax/microedition/lcdui/Canvas;

    return-object v0
.end method

.method public static getDisplay(Ljavax/microedition/midlet/MIDlet;)Ljavax/microedition/lcdui/Display;
    .locals 1
    .param p0, "midlet"    # Ljavax/microedition/midlet/MIDlet;

    .prologue
    .line 15
    new-instance v0, Ljavax/microedition/lcdui/Display;

    invoke-direct {v0}, Ljavax/microedition/lcdui/Display;-><init>()V

    return-object v0
.end method


# virtual methods
.method public setCurrent(Ljavax/microedition/lcdui/Canvas;)V
    .locals 1
    .param p1, "gCanvas"    # Ljavax/microedition/lcdui/Canvas;

    .prologue
    .line 18
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljavax/microedition/lcdui/CwaActivity;->setCanvas(Ljavax/microedition/lcdui/Canvas;)V

    .line 19
    sput-object p1, Ljavax/microedition/lcdui/Display;->canvas:Ljavax/microedition/lcdui/Canvas;

    .line 20
    return-void
.end method
