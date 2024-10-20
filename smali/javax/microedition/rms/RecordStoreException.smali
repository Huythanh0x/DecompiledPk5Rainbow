.class public Ljavax/microedition/rms/RecordStoreException;
.super Ljava/lang/Exception;
.source "RecordStoreException.java"

.field private final static serialVersionUID:J = 1L

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 16
    invoke-direct { p0 }, Ljava/lang/Exception;-><init>()V
  .line 17
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
  .parameter "message" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 13
    invoke-direct { p0, p1 }, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
  .line 14
    return-void
.end method
