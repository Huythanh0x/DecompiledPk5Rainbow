.class public abstract Ljavax/microedition/lcdui/Canvas;
.super Landroid/view/View;
.implements Landroid/view/View$OnTouchListener;
.implements Landroid/view/View$OnKeyListener;
.source "Canvas.java"

.field public final static DOWN:I = 20

.field public final static FIRE:I = 23

.field public final static GAME_A:I = 9

.field public final static GAME_B:I = 10

.field public final static GAME_C:I = 11

.field public final static GAME_D:I = 12

.field public final static KEY_NUM0:I = 7

.field public final static KEY_NUM1:I = 8

.field public final static KEY_NUM2:I = 9

.field public final static KEY_NUM3:I = 10

.field public final static KEY_NUM4:I = 11

.field public final static KEY_NUM5:I = 12

.field public final static KEY_NUM6:I = 13

.field public final static KEY_NUM7:I = 14

.field public final static KEY_NUM8:I = 15

.field public final static KEY_NUM9:I = 16

.field public final static KEY_POUND:I = 18

.field public final static KEY_STAR:I = 17

.field public final static LEFT:I = 21

.field public final static RIGHT:I = 22

.field public final static UP:I = 19

.field private g:Ljavax/microedition/lcdui/Graphics;

.field public keyxx:F

.field public keyyy:F

.field scale_x:F

.field scale_y:F

.method protected constructor <init>()V
  .registers 4
  .prologue
    const/high16 v2, 16256
    const/4 v1, 1
  .line 48
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;
    move-result-object v0
    invoke-direct { p0, v0 }, Landroid/view/View;-><init>(Landroid/content/Context;)V
  .line 101
    iput v2, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F
    iput v2, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F
  .line 49
    invoke-virtual { p0, v1 }, Ljavax/microedition/lcdui/Canvas;->setFocusable(Z)V
  .line 50
    invoke-virtual { p0, v1 }, Ljavax/microedition/lcdui/Canvas;->setFocusableInTouchMode(Z)V
  .line 51
    invoke-virtual { p0, v1 }, Ljavax/microedition/lcdui/Canvas;->setLongClickable(Z)V
  .line 52
    invoke-virtual { p0, p0 }, Ljavax/microedition/lcdui/Canvas;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V
  .line 53
    invoke-virtual { p0, p0 }, Ljavax/microedition/lcdui/Canvas;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
  .line 54
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
  .parameter "context" # Landroid/content/Context;
  .parameter "attrs" # Landroid/util/AttributeSet;
  .registers 5
  .prologue
    const/high16 v1, 16256
    const/4 v0, 1
  .line 57
    invoke-direct { p0, p1, p2 }, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
  .line 101
    iput v1, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F
    iput v1, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F
  .line 58
    invoke-virtual { p0, v0 }, Ljavax/microedition/lcdui/Canvas;->setFocusable(Z)V
  .line 59
    invoke-virtual { p0, v0 }, Ljavax/microedition/lcdui/Canvas;->setFocusableInTouchMode(Z)V
  .line 60
    invoke-virtual { p0, v0 }, Ljavax/microedition/lcdui/Canvas;->setLongClickable(Z)V
  .line 61
    invoke-virtual { p0, p0 }, Ljavax/microedition/lcdui/Canvas;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V
  .line 62
    invoke-virtual { p0, p0 }, Ljavax/microedition/lcdui/Canvas;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
  .line 63
    return-void
.end method

.method public getScreenHeight()I
  .registers 2
  .prologue
  .line 221
    sget v0, Lcom/android/Util/AndroidUtil;->SCREEN_HEIGHT:I
    return v0
.end method

.method public getScreenWidth()I
  .registers 2
  .prologue
  .line 213
    sget v0, Lcom/android/Util/AndroidUtil;->SCREEN_WIDTH:I
    return v0
.end method

.method public hideNotify()V
  .registers 1
  .prologue
  .line 95
    return-void
.end method

.method protected keyPressed(I)V
  .parameter "keyCode" # I
  .registers 2
  .prologue
  .line 71
    return-void
.end method

.method protected keyReleased(I)V
  .parameter "keyCode" # I
  .registers 2
  .prologue
  .line 75
    return-void
.end method

.method protected keyRepeated(I)V
  .parameter "keyCode" # I
  .registers 2
  .prologue
  .line 73
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
  .parameter "canvas" # Landroid/graphics/Canvas;
  .registers 4
  .prologue
    const/high16 v1, 16256
  .line 116
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;
    if-nez v0, :L3
  .line 117
    new-instance v0, Ljavax/microedition/lcdui/Graphics;
    invoke-direct { v0, p1 }, Ljavax/microedition/lcdui/Graphics;-><init>(Landroid/graphics/Canvas;)V
    iput-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;
  :L0
  .line 122
    iget v0, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F
    cmpl-float v0, v0, v1
    if-eqz v0, :L1
    iget v0, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F
    cmpl-float v0, v0, v1
    if-eqz v0, :L1
  .line 123
    iget v0, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F
    iget v1, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F
    invoke-virtual { p1, v0, v1 }, Landroid/graphics/Canvas;->scale(FF)V
  :L1
  .line 126
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/Graphics;->isAutoResetPainter()Z
    move-result v0
    if-eqz v0, :L2
  .line 127
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/Graphics;->painterReset()V
  :L2
  .line 130
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { p0, v0 }, Ljavax/microedition/lcdui/Canvas;->paint(Ljavax/microedition/lcdui/Graphics;)V
  .line 131
    sget-object v0, Lcom/android/Util/AndroidUtil;->cv:Landroid/os/ConditionVariable;
    invoke-virtual { v0 }, Landroid/os/ConditionVariable;->open()V
  .line 132
    return-void
  :L3
  .line 119
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1 }, Ljavax/microedition/lcdui/Graphics;->setCanvas(Landroid/graphics/Canvas;)V
    goto :L0
.end method

.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
  .parameter "v" # Landroid/view/View;
  .parameter "keyCode" # I
  .parameter "event" # Landroid/view/KeyEvent;
  .registers 9
  .prologue
    const/4 v4, 3
    const/4 v3, 1
    const/4 v2, 0
  .line 168
    invoke-virtual { p3 }, Landroid/view/KeyEvent;->getAction()I
    move-result v0
    packed-switch v0, :L7
  .line 199
    const-string v0, "Canvas"
    const-string v1, "not this key"
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    move v0, v2
  :L0
  .line 204
    return v0
  :L1
  .line 170
    const/16 v0, 25
    if-ne p2, v0, :L3
  .line 173
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    iget-object v0, v0, Ljavax/microedition/lcdui/CwaActivity;->audioManager:Landroid/media/AudioManager;
    const/4 v1, -1
    invoke-virtual { v0, v4, v1, v2 }, Landroid/media/AudioManager;->adjustStreamVolume(III)V
  :L2
    move v0, v3
  .line 194
    goto :L0
  :L3
  .line 174
    const/16 v0, 24
    if-ne p2, v0, :L4
  .line 177
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    iget-object v0, v0, Ljavax/microedition/lcdui/CwaActivity;->audioManager:Landroid/media/AudioManager;
    invoke-virtual { v0, v4, v3, v2 }, Landroid/media/AudioManager;->adjustStreamVolume(III)V
    goto :L2
  :L4
  .line 178
    const/4 v0, 4
    if-ne p2, v0, :L5
  .line 179
    invoke-virtual { p3 }, Landroid/view/KeyEvent;->getRepeatCount()I
    move-result v0
    if-nez v0, :L2
  .line 180
    invoke-static { }, Ljavax/microedition/midlet/MIDletManager;->getInstance()Ljavax/microedition/midlet/MIDletManager;
    move-result-object v0
    invoke-virtual { v0 }, Ljavax/microedition/midlet/MIDletManager;->notifyPaused()V
  .line 181
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/CwaActivity;->showExitDialog()V
    goto :L2
  :L5
  .line 184
    invoke-virtual { p3 }, Landroid/view/KeyEvent;->getKeyCode()I
    move-result v0
    invoke-virtual { p0, v0 }, Ljavax/microedition/lcdui/Canvas;->keyPressed(I)V
    goto :L2
  :L6
  .line 196
    invoke-virtual { p3 }, Landroid/view/KeyEvent;->getKeyCode()I
    move-result v0
    invoke-virtual { p0, v0 }, Ljavax/microedition/lcdui/Canvas;->keyReleased(I)V
    move v0, v3
  .line 197
    goto :L0
  .line 168
  :L7
  .packed-switch 0
    :L1
    :L6
  .end packed-switch
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
  .parameter "v" # Landroid/view/View;
  .parameter "event" # Landroid/view/MotionEvent;
  .registers 7
  .prologue
  .line 140
    invoke-virtual { p2 }, Landroid/view/MotionEvent;->getX()F
    move-result v2
    iget v3, p0, Ljavax/microedition/lcdui/Canvas;->keyxx:F
    div-float/2addr v2, v3
    float-to-int v0, v2
  .line 141
  .local v0, "x":I
    invoke-virtual { p2 }, Landroid/view/MotionEvent;->getY()F
    move-result v2
    iget v3, p0, Ljavax/microedition/lcdui/Canvas;->keyyy:F
    div-float/2addr v2, v3
    float-to-int v1, v2
  .line 143
  .local v1, "y":I
    invoke-virtual { p2 }, Landroid/view/MotionEvent;->getAction()I
    move-result v2
    packed-switch v2, :L4
  :L0
  .line 154
    const/4 v2, 1
    return v2
  :L1
  .line 145
    invoke-virtual { p0, v0, v1 }, Ljavax/microedition/lcdui/Canvas;->pointerPressed(II)V
    goto :L0
  :L2
  .line 148
    invoke-virtual { p0, v0, v1 }, Ljavax/microedition/lcdui/Canvas;->pointerReleased(II)V
    goto :L0
  :L3
  .line 151
    invoke-virtual { p0, v0, v1 }, Ljavax/microedition/lcdui/Canvas;->pointerDragged(II)V
    goto :L0
  .line 143
  :L4
  .packed-switch 0
    :L1
    :L2
    :L3
  .end packed-switch
.end method

.method protected abstract paint(Ljavax/microedition/lcdui/Graphics;)V
.end method

.method protected pointerDragged(II)V
  .parameter "x" # I
  .parameter "y" # I
  .registers 3
  .prologue
  .line 81
    return-void
.end method

.method protected pointerPressed(II)V
  .parameter "x" # I
  .parameter "y" # I
  .registers 3
  .prologue
  .line 77
    return-void
.end method

.method protected pointerReleased(II)V
  .parameter "x" # I
  .parameter "y" # I
  .registers 3
  .prologue
  .line 79
    return-void
.end method

.method public final repaint()V
  .registers 1
  .prologue
  .line 88
    invoke-virtual { p0 }, Ljavax/microedition/lcdui/Canvas;->postInvalidate()V
  .line 89
    return-void
.end method

.method public final repaint(IIII)V
  .parameter "x" # I
  .parameter "y" # I
  .parameter "width" # I
  .parameter "height" # I
  .registers 7
  .prologue
  .line 84
    add-int v0, p1, p3
    add-int v1, p2, p4
    invoke-virtual { p0, p1, p2, v0, v1 }, Ljavax/microedition/lcdui/Canvas;->postInvalidate(IIII)V
  .line 85
    return-void
.end method

.method public final serviceRepaints()V
  .registers 1
  .prologue
  .line 91
    return-void
.end method

.method public setFullScreenMode(Z)V
  .parameter "mode" # Z
  .registers 2
  .prologue
  .line 69
    return-void
.end method

.method public setScale(FF)V
  .parameter "x" # F
  .parameter "y" # F
  .registers 4
  .prologue
  .line 103
    iput p1, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F
  .line 104
    iput p2, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F
  .line 105
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;
    invoke-virtual { v0, p1, p2 }, Ljavax/microedition/lcdui/Graphics;->getXY(FF)V
  .line 106
    return-void
.end method

.method public showNotify()V
  .registers 1
  .prologue
  .line 93
    return-void
.end method
