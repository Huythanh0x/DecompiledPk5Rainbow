.class public Ljavax/microedition/midlet/MIDletStateChangeException;
.super Ljava/lang/Exception;
.source "MIDletStateChangeException.java"

.field private final static serialVersionUID:J = 1L

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 14
    invoke-direct { p0 }, Ljava/lang/Exception;-><init>()V
  .line 15
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
  .parameter "s" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 18
    invoke-direct { p0, p1 }, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
  .line 19
    return-void
.end method
