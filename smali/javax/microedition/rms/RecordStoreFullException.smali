.class public Ljavax/microedition/rms/RecordStoreFullException;
.super Ljavax/microedition/rms/RecordStoreException;
.source "RecordStoreFullException.java"

.field private final static serialVersionUID:J = 1L

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 17
    invoke-direct { p0 }, Ljavax/microedition/rms/RecordStoreException;-><init>()V
  .line 18
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
  .parameter "message" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 14
    invoke-direct { p0, p1 }, Ljavax/microedition/rms/RecordStoreException;-><init>(Ljava/lang/String;)V
  .line 15
    return-void
.end method
