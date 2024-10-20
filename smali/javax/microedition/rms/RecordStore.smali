.class public Ljavax/microedition/rms/RecordStore;
.super Ljava/lang/Object;
.source "RecordStore.java"

.field public final static AUTHMODE_ANY:I = 1

.field public final static AUTHMODE_PRIVATE:I = 0

.field private final static INT_MAX:J = 2147483647L

.field private db:Landroid/database/sqlite/SQLiteDatabase;

.field private table_name:Ljava/lang/String;

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 10
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static deleteRecordStore(Ljava/lang/String;)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreException;,
      Ljavax/microedition/rms/RecordStoreNotFoundException;
    }
  .end annotation
  .parameter "recordStoreName" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 57
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;
    move-result-object v0
    invoke-virtual { v0, p0 }, Landroid/content/Context;->deleteDatabase(Ljava/lang/String;)Z
  .line 58
    return-void
.end method

.method public static openRecordStore(Ljava/lang/String;Z)Ljavax/microedition/rms/RecordStore;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreException;,
      Ljavax/microedition/rms/RecordStoreFullException;,
      Ljavax/microedition/rms/RecordStoreNotFoundException;
    }
  .end annotation
  .parameter "recordStoreName" # Ljava/lang/String;
  .parameter "createIfNecessary" # Z
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L2
  .registers 13
  .prologue
    const/4 v2, 0
  .line 153
    new-instance v9, Ljavax/microedition/rms/RecordStore;
    invoke-direct { v9 }, Ljavax/microedition/rms/RecordStore;-><init>()V
  .line 154
  .local v9, "rs":Ljavax/microedition/rms/RecordStore;
    iput-object p0, v9, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
  .line 155
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual { v0, p0, v1, v2 }, Landroid/content/Context;->openOrCreateDatabase(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    move-result-object v0
    iput-object v0, v9, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
  :L0
  .line 158
    iget-object v0, v9, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    move-object v1, p0
    invoke-virtual/range { v0 .. v7 }, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
  :L1
  .line 174
    return-object v9
  :L2
  .line 159
    move-exception v0
    move-object v8, v0
  .line 160
  .local v8, "e":Ljava/lang/Exception;
    if-nez p1, :L4
  .line 161
    iget-object v0, v9, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual { v0 }, Landroid/database/sqlite/SQLiteDatabase;->isOpen()Z
    move-result v0
    if-eqz v0, :L3
  .line 162
    iget-object v0, v9, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual { v0 }, Landroid/database/sqlite/SQLiteDatabase;->close()V
  :L3
  .line 164
    new-instance v0, Ljavax/microedition/rms/RecordStoreException;
    invoke-direct { v0 }, Ljavax/microedition/rms/RecordStoreException;-><init>()V
    throw v0
  :L4
  .line 167
    const-string v0, "RMS"
    const-string v1, "no table and create table"
    invoke-static { v0, v1 }, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
  .line 168
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "create table "
    invoke-direct { v0, v1 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v0, p0 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "("
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "_id"
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
  .line 169
    const-string v1, " integer primary key autoincrement,content text not null);"
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
  .line 168
    invoke-virtual { v0 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
  .line 170
  .local v10, "sql":Ljava/lang/String;
    iget-object v0, v9, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual { v0, v10 }, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
    goto :L1
.end method

.method public addRecord([BII)I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;,
      Ljavax/microedition/rms/RecordStoreException;,
      Ljavax/microedition/rms/RecordStoreFullException;
    }
  .end annotation
  .parameter "data" # [B
  .parameter "offset" # I
  .parameter "numBytes" # I
  .registers 12
  .prologue
  .line 21
    const/4 v3, -1
  .line 23
  .local v3, "result":I
    new-array v0, p3, [B
  .line 24
  .local v0, "datarecord":[B
    move v1, p2
  .local v1, "i":I
    const/4 v2, 0
  :L0
  .local v2, "j":I
    add-int v5, p3, p2
    if-lt v1, v5, :L1
  .line 30
    new-instance v4, Landroid/content/ContentValues;
    invoke-direct { v4 }, Landroid/content/ContentValues;-><init>()V
  .line 31
  .local v4, "values":Landroid/content/ContentValues;
    const-string v5, "content"
    invoke-virtual { v4, v5, v0 }, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V
  .line 33
    iget-object v5, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    iget-object v6, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    const/4 v7, 0
    invoke-virtual { v5, v6, v7, v4 }, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    move-result-wide v5
    long-to-int v3, v5
  .line 35
    return v3
  :L1
  .line 25
  .end local v4
    aget-byte v5, p1, v1
    aput-byte v5, v0, v2
  .line 27
    add-int/lit8 v1, v1, 1
  .line 24
    add-int/lit8 v2, v2, 1
    goto :L0
.end method

.method public closeRecordStore()V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;,
      Ljavax/microedition/rms/RecordStoreException;
    }
  .end annotation
  .registers 3
  .prologue
  .line 41
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    if-eqz v0, :L1
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual { v0 }, Landroid/database/sqlite/SQLiteDatabase;->isOpen()Z
    move-result v0
    if-eqz v0, :L1
  .line 42
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual { v0 }, Landroid/database/sqlite/SQLiteDatabase;->close()V
  :L0
  .line 45
    return-void
  :L1
  .line 44
    new-instance v0, Ljavax/microedition/rms/RecordStoreNotOpenException;
    const-string v1, "RecordStore is not open"
    invoke-direct { v0, v1 }, Ljavax/microedition/rms/RecordStoreNotOpenException;-><init>(Ljava/lang/String;)V
    goto :L0
.end method

.method public deleteRecord(I)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;,
      Ljavax/microedition/rms/InvalidRecordIDException;,
      Ljavax/microedition/rms/RecordStoreException;
    }
  .end annotation
  .parameter "recordId" # I
  .registers 5
  .prologue
  .line 50
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "delete from "
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, " where _ID="
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
  .line 51
  .local v0, "sql":Ljava/lang/String;
    iget-object v1, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual { v1, v0 }, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V
  .line 52
    return-void
.end method

.method public enumerateRecords(Ljavax/microedition/rms/RecordFilter;Ljavax/microedition/rms/RecordComparator;Z)Ljavax/microedition/rms/RecordEnumeration;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;
    }
  .end annotation
  .parameter "filter" # Ljavax/microedition/rms/RecordFilter;
  .parameter "comparator" # Ljavax/microedition/rms/RecordComparator;
  .parameter "keepUpdated" # Z
  .registers 14
  .prologue
    const/4 v2, 0
  .line 63
    new-instance v9, Ljavax/microedition/rms/RecordEnumeration;
    invoke-direct { v9 }, Ljavax/microedition/rms/RecordEnumeration;-><init>()V
  .line 65
  .local v9, "record_enumeration":Ljavax/microedition/rms/RecordEnumeration;
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    iget-object v1, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    move-object v3, v2
    move-object v4, v2
    move-object v5, v2
    move-object v6, v2
    move-object v7, v2
    invoke-virtual/range { v0 .. v7 }, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v8
  .line 66
  .local v8, "cursor":Landroid/database/Cursor;
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0, v8 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 67
    iput-object v8, v9, Ljavax/microedition/rms/RecordEnumeration;->cursor:Landroid/database/Cursor;
  .line 68
    iput-object v8, v9, Ljavax/microedition/rms/RecordEnumeration;->old_cursor:Landroid/database/Cursor;
  .line 70
    return-object v9
.end method

.method public getName()Ljava/lang/String;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;
    }
  .end annotation
  .registers 2
  .prologue
  .line 76
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    return-object v0
.end method

.method public getNextRecordID()I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;,
      Ljavax/microedition/rms/RecordStoreException;
    }
  .end annotation
  .registers 11
  .prologue
    const/4 v2, 0
  .line 82
    const/4 v9, -1
  .line 83
  .local v9, "result":I
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    iget-object v1, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    move-object v3, v2
    move-object v4, v2
    move-object v5, v2
    move-object v6, v2
    move-object v7, v2
    invoke-virtual/range { v0 .. v7 }, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v8
  .line 84
  .local v8, "cursor":Landroid/database/Cursor;
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0, v8 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 85
    invoke-interface { v8 }, Landroid/database/Cursor;->moveToLast()Z
    move-result v0
    if-eqz v0, :L0
  .line 86
    const/4 v0, 0
    invoke-interface { v8, v0 }, Landroid/database/Cursor;->getInt(I)I
    move-result v0
    add-int/lit8 v9, v0, 1
  :L0
  .line 88
    return v9
.end method

.method public getNumRecords()I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;
    }
  .end annotation
  .registers 11
  .prologue
    const/4 v2, 0
  .line 94
    const/4 v9, 0
  .line 95
  .local v9, "result":I
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    iget-object v1, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    move-object v3, v2
    move-object v4, v2
    move-object v5, v2
    move-object v6, v2
    move-object v7, v2
    invoke-virtual/range { v0 .. v7 }, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v8
  .line 96
  .local v8, "cursor":Landroid/database/Cursor;
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0, v8 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 97
    invoke-interface { v8 }, Landroid/database/Cursor;->getCount()I
    move-result v9
  .line 98
    return v9
.end method

.method public getRecord(I[BI)I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;,
      Ljavax/microedition/rms/InvalidRecordIDException;,
      Ljavax/microedition/rms/RecordStoreException;
    }
  .end annotation
  .parameter "recordId" # I
  .parameter "buffer" # [B
  .parameter "offset" # I
  .registers 17
  .prologue
  .line 117
    const/4 v12, -1
  .line 118
  .local v12, "result":I
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    iget-object v1, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    const/4 v2, 0
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "_id="
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v3, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    invoke-virtual/range { v0 .. v7 }, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v8
  .line 119
  .local v8, "cursor":Landroid/database/Cursor;
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0, v8 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 120
    invoke-interface { v8 }, Landroid/database/Cursor;->moveToNext()Z
    move-result v0
    if-eqz v0, :L1
  .line 121
    const/4 v0, 1
    invoke-interface { v8, v0 }, Landroid/database/Cursor;->getBlob(I)[B
    move-result-object v9
  .line 122
  .local v9, "data":[B
    move/from16 v10, p3
  .local v10, "i":I
    const/4 v11, 0
  :L0
  .local v11, "j":I
    array-length v0, v9
    if-lt v10, v0, :L2
  .line 128
    if-eqz v9, :L1
  .line 129
    move v12, p1
  :L1
  .line 133
  .end local v9
  .end local v10
  .end local v11
    return v12
  :L2
  .line 123
  .restart local v9
  .restart local v10
  .restart local v11
    aget-byte v0, v9, v10
    aput-byte v0, p2, v11
  .line 125
    add-int/lit8 v10, v10, 1
  .line 122
    add-int/lit8 v11, v11, 1
    goto :L0
.end method

.method public getRecord(I)[B
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;,
      Ljavax/microedition/rms/InvalidRecordIDException;,
      Ljavax/microedition/rms/RecordStoreException;
    }
  .end annotation
  .parameter "recordId" # I
  .registers 12
  .prologue
    const/4 v2, 0
  .line 104
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    iget-object v1, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "_id="
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v3, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object v4, v2
    move-object v5, v2
    move-object v6, v2
    move-object v7, v2
    invoke-virtual/range { v0 .. v7 }, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v8
  .line 105
  .local v8, "cursor":Landroid/database/Cursor;
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0, v8 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 106
    invoke-interface { v8 }, Landroid/database/Cursor;->moveToNext()Z
    move-result v0
    if-eqz v0, :L1
  .line 107
    const/4 v0, 1
    invoke-interface { v8, v0 }, Landroid/database/Cursor;->getBlob(I)[B
    move-result-object v9
  .local v9, "data":[B
    move-object v0, v9
  :L0
  .line 111
  .end local v9
    return-object v0
  :L1
    move-object v0, v2
    goto :L0
.end method

.method public getRecordSize(I)I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;,
      Ljavax/microedition/rms/InvalidRecordIDException;,
      Ljavax/microedition/rms/RecordStoreException;
    }
  .end annotation
  .parameter "recordId" # I
  .registers 13
  .prologue
    const/4 v2, 0
  .line 139
    const/4 v10, -1
  .line 140
  .local v10, "result":I
    iget-object v0, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    iget-object v1, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "_id="
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v3, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    move-object v4, v2
    move-object v5, v2
    move-object v6, v2
    move-object v7, v2
    invoke-virtual/range { v0 .. v7 }, Landroid/database/sqlite/SQLiteDatabase;->query(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    move-result-object v8
  .line 141
  .local v8, "cursor":Landroid/database/Cursor;
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0, v8 }, Ljavax/microedition/lcdui/CwaActivity;->startManagingCursor(Landroid/database/Cursor;)V
  .line 142
    invoke-interface { v8 }, Landroid/database/Cursor;->moveToNext()Z
    move-result v0
    if-eqz v0, :L0
  .line 143
    const/4 v0, 1
    invoke-interface { v8, v0 }, Landroid/database/Cursor;->getBlob(I)[B
    move-result-object v9
  .line 144
  .local v9, "data":[B
    array-length v10, v9
  :L0
  .line 147
  .end local v9
    return v10
.end method

.method public getSizeAvailable()I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;
    }
  .end annotation
  .registers 5
  .prologue
  .line 198
    iget-object v2, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    invoke-virtual { v2 }, Landroid/database/sqlite/SQLiteDatabase;->getMaximumSize()J
    move-result-wide v0
  .line 199
  .local v0, "sizeavailable":J
    const-wide/32 v2, 2147483647
    cmp-long v2, v0, v2
    if-lez v2, :L1
  .line 200
    const v2, 2147483647
  :L0
  .line 202
    return v2
  :L1
    long-to-int v2, v0
    goto :L0
.end method

.method public setRecord(I[BII)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/rms/RecordStoreNotOpenException;,
      Ljavax/microedition/rms/InvalidRecordIDException;,
      Ljavax/microedition/rms/RecordStoreException;,
      Ljavax/microedition/rms/RecordStoreFullException;
    }
  .end annotation
  .parameter "recordId" # I
  .parameter "newData" # [B
  .parameter "offset" # I
  .parameter "numBytes" # I
  .registers 13
  .prologue
  .line 180
    invoke-virtual { p0, p1 }, Ljavax/microedition/rms/RecordStore;->getRecord(I)[B
    move-result-object v4
    if-nez v4, :L0
  .line 181
    new-instance v4, Ljavax/microedition/rms/InvalidRecordIDException;
    const-string v5, "recordId is invalid"
    invoke-direct { v4, v5 }, Ljavax/microedition/rms/InvalidRecordIDException;-><init>(Ljava/lang/String;)V
    throw v4
  :L0
  .line 183
    new-array v0, p4, [B
  .line 184
  .local v0, "datarecord":[B
    move v1, p3
  .local v1, "i":I
    const/4 v2, 0
  :L1
  .local v2, "j":I
    add-int v4, p4, p3
    if-lt v1, v4, :L2
  .line 190
    new-instance v3, Landroid/content/ContentValues;
    invoke-direct { v3 }, Landroid/content/ContentValues;-><init>()V
  .line 191
  .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "content"
    invoke-virtual { v3, v4, v0 }, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V
  .line 192
    iget-object v4, p0, Ljavax/microedition/rms/RecordStore;->db:Landroid/database/sqlite/SQLiteDatabase;
    iget-object v5, p0, Ljavax/microedition/rms/RecordStore;->table_name:Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, " _ID="
    invoke-direct { v6, v7 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v6, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual { v6 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    invoke-virtual { v4, v5, v3, v6, v7 }, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
  .line 193
    return-void
  :L2
  .line 185
  .end local v3
    aget-byte v4, p2, v1
    aput-byte v4, v0, v2
  .line 187
    add-int/lit8 v1, v1, 1
  .line 184
    add-int/lit8 v2, v2, 1
    goto :L1
.end method
