.class public Ljavax/microedition/media/MediaException;
.super Ljava/lang/Exception;
.source "MediaException.java"

.field private final static serialVersionUID:J = 1L

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 11
    invoke-direct { p0 }, Ljava/lang/Exception;-><init>()V
  .line 12
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
  .parameter "s" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 15
    invoke-direct { p0, p1 }, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
  .line 16
    return-void
.end method
