.class public Ljavax/microedition/rms/RecordEnumeration;
.super Ljava/lang/Object;
.source "RecordEnumeration.java"

.field public cursor:Landroid/database/Cursor;

.field public old_cursor:Landroid/database/Cursor;

.method public constructor <init>()V
  .registers 2
  .prologue
    const/4 v0, 0
  .line 10
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 12
    iput-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
  .line 13
    iput-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->old_cursor:Landroid/database/Cursor;
  .line 10
    return-void
.end method

.method public checkDestroy()V
  .registers 3
  .prologue
  .line 52
    iget-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
    if-nez v0, :L0
  .line 53
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, ""
    invoke-direct { v0, v1 }, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
  :L0
  .line 55
    return-void
.end method

.method public destroy()V
  .registers 2
  .prologue
  .line 18
    invoke-virtual { p0 }, Ljavax/microedition/rms/RecordEnumeration;->checkDestroy()V
  .line 19
    const/4 v0, 0
    iput-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
  .line 20
    return-void
.end method

.method public nextRecordId()I
  .registers 4
  .prologue
    const/4 v2, 0
  .line 28
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    iget-object v1, p0, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 29
    iget-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
    invoke-interface { v0 }, Landroid/database/Cursor;->moveToNext()Z
    move-result v0
    if-eqz v0, :L1
  .line 30
    iget-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
    invoke-interface { v0, v2 }, Landroid/database/Cursor;->getInt(I)I
    move-result v0
    add-int/lit8 v0, v0, 1
  :L0
  .line 32
    return v0
  :L1
    move v0, v2
    goto :L0
.end method

.method public reset()V
  .registers 3
  .prologue
  .line 39
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    iget-object v1, p0, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 40
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    iget-object v1, p0, Ljavax/microedition/rms/RecordEnumeration;->old_cursor:Landroid/database/Cursor;
    invoke-virtual { v0, v1 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 41
    invoke-virtual { p0 }, Ljavax/microedition/rms/RecordEnumeration;->checkDestroy()V
  .line 42
    iget-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->old_cursor:Landroid/database/Cursor;
    if-eqz v0, :L0
  .line 43
    iget-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->old_cursor:Landroid/database/Cursor;
    iput-object v0, p0, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
  .line 47
    return-void
  :L0
  .line 45
    new-instance v0, Ljava/lang/IllegalStateException;
    invoke-direct { v0 }, Ljava/lang/IllegalStateException;-><init>()V
    throw v0
.end method
