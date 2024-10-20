.class public abstract Lcom/nokia/mid/ui/FullCanvas;
.super Ljavax/microedition/lcdui/Canvas;
.source "FullCanvas.java"

.field public static KEY_DOWN_ARROW:I

.field public static KEY_END:I

.field public static KEY_LEFT_ARROW:I

.field public static KEY_RIGHT_ARROW:I

.field public static KEY_SEND:I

.field public static KEY_SOFTKEY1:I

.field public static KEY_SOFTKEY2:I

.field public static KEY_SOFTKEY3:I

.field public static KEY_UP_ARROW:I

.method static constructor <clinit>()V
  .registers 1
  .prologue
  .line 14
    const/16 v0, 19
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_UP_ARROW:I
  .line 15
    const/16 v0, 20
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_DOWN_ARROW:I
  .line 16
    const/16 v0, 21
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_LEFT_ARROW:I
  .line 17
    const/16 v0, 22
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_RIGHT_ARROW:I
  .line 19
    const/4 v0, 6
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_END:I
  .line 20
    const/4 v0, 5
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_SEND:I
  .line 22
    const/4 v0, 1
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_SOFTKEY1:I
  .line 23
    const/4 v0, 2
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_SOFTKEY2:I
  .line 24
    const/16 v0, 23
    sput v0, Lcom/nokia/mid/ui/FullCanvas;->KEY_SOFTKEY3:I
  .line 12
    return-void
.end method

.method protected constructor <init>()V
  .registers 3
  .prologue
  .line 29
    invoke-direct { p0 }, Ljavax/microedition/lcdui/Canvas;-><init>()V
  .line 30
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    const/4 v1, 1
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/CwaActivity;->setFullWindow(Z)V
  .line 31
    return-void
.end method

.method protected constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
  .parameter "context" # Landroid/content/Context;
  .parameter "attrs" # Landroid/util/AttributeSet;
  .registers 3
  .prologue
  .line 33
    invoke-direct { p0 }, Ljavax/microedition/lcdui/Canvas;-><init>()V
  .line 35
    return-void
.end method
