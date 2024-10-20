.class public Ljavax/microedition/rms/InvalidRecordIDException;
.super Ljavax/microedition/rms/RecordStoreException;
.source "InvalidRecordIDException.java"


# static fields
.field private static final serialVersionUID:J = 0x1L


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljavax/microedition/rms/RecordStoreException;-><init>()V

    .line 18
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Ljavax/microedition/rms/RecordStoreException;-><init>(Ljava/lang/String;)V

    .line 15
    return-void
.end method
