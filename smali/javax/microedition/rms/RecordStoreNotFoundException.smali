.class public Ljavax/microedition/rms/RecordStoreNotFoundException;
.super Ljavax/microedition/rms/RecordStoreException;
.source "RecordStoreNotFoundException.java"


# static fields
.field private static final serialVersionUID:J = 0x1L


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljavax/microedition/rms/RecordStoreException;-><init>()V

    .line 17
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Ljavax/microedition/rms/RecordStoreException;-><init>(Ljava/lang/String;)V

    .line 14
    return-void
.end method
