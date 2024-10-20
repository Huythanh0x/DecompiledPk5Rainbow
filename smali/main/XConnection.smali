.class public final Lmain/XConnection;
.super Ljavax/microedition/midlet/MIDlet;
.source "XConnection.java"


# instance fields
.field public gamecanvas:Lmain/MainCanvas;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 15
    invoke-direct {p0}, Ljavax/microedition/midlet/MIDlet;-><init>()V

    .line 16
    new-instance v0, Lmain/MainCanvas;

    invoke-direct {v0, p0}, Lmain/MainCanvas;-><init>(Lmain/XConnection;)V

    iput-object v0, p0, Lmain/XConnection;->gamecanvas:Lmain/MainCanvas;

    .line 18
    invoke-static {p0}, Ljavax/microedition/lcdui/Display;->getDisplay(Ljavax/microedition/midlet/MIDlet;)Ljavax/microedition/lcdui/Display;

    move-result-object v0

    iget-object v1, p0, Lmain/XConnection;->gamecanvas:Lmain/MainCanvas;

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Display;->setCurrent(Ljavax/microedition/lcdui/Canvas;)V

    .line 19
    iget-object v0, p0, Lmain/XConnection;->gamecanvas:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->game_start()V

    .line 21
    return-void
.end method


# virtual methods
.method public destroyApp(Z)V
    .locals 1
    .param p1, "parm"    # Z

    .prologue
    .line 55
    iget-object v0, p0, Lmain/XConnection;->gamecanvas:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->game_stop()V

    .line 56
    invoke-virtual {p0}, Lmain/XConnection;->notifyDestroyed()V

    .line 58
    return-void
.end method

.method public pauseApp()V
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lmain/XConnection;->gamecanvas:Lmain/MainCanvas;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lmain/XConnection;->gamecanvas:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->hideNotify()V

    .line 47
    :cond_0
    return-void
.end method

.method public startApp()V
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lmain/XConnection;->gamecanvas:Lmain/MainCanvas;

    if-eqz v0, :cond_0

    .line 36
    iget-object v0, p0, Lmain/XConnection;->gamecanvas:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->showNotify()V

    .line 38
    :cond_0
    return-void
.end method
