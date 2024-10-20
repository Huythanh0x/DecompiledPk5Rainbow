.class public abstract Ljavax/microedition/lcdui/Canvas;
.super Landroid/view/View;
.source "Canvas.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;
.implements Landroid/view/View$OnKeyListener;


# static fields
.field public static final DOWN:I = 0x14

.field public static final FIRE:I = 0x17

.field public static final GAME_A:I = 0x9

.field public static final GAME_B:I = 0xa

.field public static final GAME_C:I = 0xb

.field public static final GAME_D:I = 0xc

.field public static final KEY_NUM0:I = 0x7

.field public static final KEY_NUM1:I = 0x8

.field public static final KEY_NUM2:I = 0x9

.field public static final KEY_NUM3:I = 0xa

.field public static final KEY_NUM4:I = 0xb

.field public static final KEY_NUM5:I = 0xc

.field public static final KEY_NUM6:I = 0xd

.field public static final KEY_NUM7:I = 0xe

.field public static final KEY_NUM8:I = 0xf

.field public static final KEY_NUM9:I = 0x10

.field public static final KEY_POUND:I = 0x12

.field public static final KEY_STAR:I = 0x11

.field public static final LEFT:I = 0x15

.field public static final RIGHT:I = 0x16

.field public static final UP:I = 0x13


# instance fields
.field private g:Ljavax/microedition/lcdui/Graphics;

.field public keyxx:F

.field public keyyy:F

.field scale_x:F

.field scale_y:F


# direct methods
.method protected constructor <init>()V
    .registers 4

    .prologue
    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x1

    .line 48
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 101
    iput v2, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F

    iput v2, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F

    .line 49
    invoke-virtual {p0, v1}, Ljavax/microedition/lcdui/Canvas;->setFocusable(Z)V

    .line 50
    invoke-virtual {p0, v1}, Ljavax/microedition/lcdui/Canvas;->setFocusableInTouchMode(Z)V

    .line 51
    invoke-virtual {p0, v1}, Ljavax/microedition/lcdui/Canvas;->setLongClickable(Z)V

    .line 52
    invoke-virtual {p0, p0}, Ljavax/microedition/lcdui/Canvas;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 53
    invoke-virtual {p0, p0}, Ljavax/microedition/lcdui/Canvas;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 54
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .registers 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/high16 v1, 0x3f800000    # 1.0f

    const/4 v0, 0x1

    .line 57
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 101
    iput v1, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F

    iput v1, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F

    .line 58
    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/Canvas;->setFocusable(Z)V

    .line 59
    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/Canvas;->setFocusableInTouchMode(Z)V

    .line 60
    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/Canvas;->setLongClickable(Z)V

    .line 61
    invoke-virtual {p0, p0}, Ljavax/microedition/lcdui/Canvas;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 62
    invoke-virtual {p0, p0}, Ljavax/microedition/lcdui/Canvas;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 63
    return-void
.end method


# virtual methods
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
    .registers 2
    .param p1, "keyCode"    # I

    .prologue
    .line 71
    return-void
.end method

.method protected keyReleased(I)V
    .registers 2
    .param p1, "keyCode"    # I

    .prologue
    .line 75
    return-void
.end method

.method protected keyRepeated(I)V
    .registers 2
    .param p1, "keyCode"    # I

    .prologue
    .line 73
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .registers 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v1, 0x3f800000    # 1.0f

    .line 116
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;

    if-nez v0, :cond_38

    .line 117
    new-instance v0, Ljavax/microedition/lcdui/Graphics;

    invoke-direct {v0, p1}, Ljavax/microedition/lcdui/Graphics;-><init>(Landroid/graphics/Canvas;)V

    iput-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;

    .line 122
    :goto_d
    iget v0, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_20

    iget v0, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_20

    .line 123
    iget v0, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F

    iget v1, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->scale(FF)V

    .line 126
    :cond_20
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Graphics;->isAutoResetPainter()Z

    move-result v0

    if-eqz v0, :cond_2d

    .line 127
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Graphics;->painterReset()V

    .line 130
    :cond_2d
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/Canvas;->paint(Ljavax/microedition/lcdui/Graphics;)V

    .line 131
    sget-object v0, Lcom/android/Util/AndroidUtil;->cv:Landroid/os/ConditionVariable;

    invoke-virtual {v0}, Landroid/os/ConditionVariable;->open()V

    .line 132
    return-void

    .line 119
    :cond_38
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1}, Ljavax/microedition/lcdui/Graphics;->setCanvas(Landroid/graphics/Canvas;)V

    goto :goto_d
.end method

.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .registers 9
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v4, 0x3

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 168
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    packed-switch v0, :pswitch_data_5a

    .line 199
    const-string v0, "Canvas"

    const-string v1, "not this key"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v2

    .line 204
    :goto_12
    return v0

    .line 170
    :pswitch_13
    const/16 v0, 0x19

    if-ne p2, v0, :cond_23

    .line 173
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v0

    iget-object v0, v0, Ljavax/microedition/lcdui/CwaActivity;->audioManager:Landroid/media/AudioManager;

    const/4 v1, -0x1

    invoke-virtual {v0, v4, v1, v2}, Landroid/media/AudioManager;->adjustStreamVolume(III)V

    :cond_21
    :goto_21
    move v0, v3

    .line 194
    goto :goto_12

    .line 174
    :cond_23
    const/16 v0, 0x18

    if-ne p2, v0, :cond_31

    .line 177
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v0

    iget-object v0, v0, Ljavax/microedition/lcdui/CwaActivity;->audioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v4, v3, v2}, Landroid/media/AudioManager;->adjustStreamVolume(III)V

    goto :goto_21

    .line 178
    :cond_31
    const/4 v0, 0x4

    if-ne p2, v0, :cond_49

    .line 179
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v0

    if-nez v0, :cond_21

    .line 180
    invoke-static {}, Ljavax/microedition/midlet/MIDletManager;->getInstance()Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyPaused()V

    .line 181
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/lcdui/CwaActivity;->showExitDialog()V

    goto :goto_21

    .line 184
    :cond_49
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/Canvas;->keyPressed(I)V

    goto :goto_21

    .line 196
    :pswitch_51
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/Canvas;->keyReleased(I)V

    move v0, v3

    .line 197
    goto :goto_12

    .line 168
    :pswitch_data_5a
    .packed-switch 0x0
        :pswitch_13
        :pswitch_51
    .end packed-switch
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .registers 7
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 140
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    iget v3, p0, Ljavax/microedition/lcdui/Canvas;->keyxx:F

    div-float/2addr v2, v3

    float-to-int v0, v2

    .line 141
    .local v0, "x":I
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    iget v3, p0, Ljavax/microedition/lcdui/Canvas;->keyyy:F

    div-float/2addr v2, v3

    float-to-int v1, v2

    .line 143
    .local v1, "y":I
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    packed-switch v2, :pswitch_data_26

    .line 154
    :goto_17
    const/4 v2, 0x1

    return v2

    .line 145
    :pswitch_19
    invoke-virtual {p0, v0, v1}, Ljavax/microedition/lcdui/Canvas;->pointerPressed(II)V

    goto :goto_17

    .line 148
    :pswitch_1d
    invoke-virtual {p0, v0, v1}, Ljavax/microedition/lcdui/Canvas;->pointerReleased(II)V

    goto :goto_17

    .line 151
    :pswitch_21
    invoke-virtual {p0, v0, v1}, Ljavax/microedition/lcdui/Canvas;->pointerDragged(II)V

    goto :goto_17

    .line 143
    nop

    :pswitch_data_26
    .packed-switch 0x0
        :pswitch_19
        :pswitch_1d
        :pswitch_21
    .end packed-switch
.end method

.method protected abstract paint(Ljavax/microedition/lcdui/Graphics;)V
.end method

.method protected pointerDragged(II)V
    .registers 3
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 81
    return-void
.end method

.method protected pointerPressed(II)V
    .registers 3
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 77
    return-void
.end method

.method protected pointerReleased(II)V
    .registers 3
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 79
    return-void
.end method

.method public final repaint()V
    .registers 1

    .prologue
    .line 88
    invoke-virtual {p0}, Ljavax/microedition/lcdui/Canvas;->postInvalidate()V

    .line 89
    return-void
.end method

.method public final repaint(IIII)V
    .registers 7
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 84
    add-int v0, p1, p3

    add-int v1, p2, p4

    invoke-virtual {p0, p1, p2, v0, v1}, Ljavax/microedition/lcdui/Canvas;->postInvalidate(IIII)V

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
    .registers 2
    .param p1, "mode"    # Z

    .prologue
    .line 69
    return-void
.end method

.method public setScale(FF)V
    .registers 4
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    .line 103
    iput p1, p0, Ljavax/microedition/lcdui/Canvas;->scale_x:F

    .line 104
    iput p2, p0, Ljavax/microedition/lcdui/Canvas;->scale_y:F

    .line 105
    iget-object v0, p0, Ljavax/microedition/lcdui/Canvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, p1, p2}, Ljavax/microedition/lcdui/Graphics;->getXY(FF)V

    .line 106
    return-void
.end method

.method public showNotify()V
    .registers 1

    .prologue
    .line 93
    return-void
.end method
