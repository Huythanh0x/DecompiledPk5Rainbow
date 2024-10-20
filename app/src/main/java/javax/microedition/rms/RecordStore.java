package javax.microedition.rms;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import javax.microedition.lcdui.CwaActivity;

public class RecordStore {
  public static final int AUTHMODE_ANY = 1;
  
  public static final int AUTHMODE_PRIVATE = 0;
  
  private static final long INT_MAX = 2147483647L;
  
  private SQLiteDatabase db;
  
  private String table_name;
  
  public static void deleteRecordStore(String paramString) throws RecordStoreException, RecordStoreNotFoundException {
    CwaActivity.getContextInstance().deleteDatabase(paramString);
  }
  
  public static RecordStore openRecordStore(String paramString, boolean paramBoolean) throws RecordStoreException, RecordStoreFullException, RecordStoreNotFoundException {
    RecordStore recordStore = new RecordStore();
    recordStore.table_name = paramString;
    recordStore.db = CwaActivity.getContextInstance().openOrCreateDatabase(paramString, 0, null);
    try {
      recordStore.db.query(paramString, null, null, null, null, null, null);
    } catch (Exception exception) {}
    return recordStore;
  }
  
  public int addRecord(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws RecordStoreNotOpenException, RecordStoreException, RecordStoreFullException {
    byte[] arrayOfByte = new byte[paramInt2];
    int i = paramInt1;
    for (byte b = 0;; b++) {
      ContentValues contentValues;
      if (i >= paramInt2 + paramInt1) {
        contentValues = new ContentValues();
        contentValues.put("content", arrayOfByte);
        return (int)this.db.insert(this.table_name, null, contentValues);
      } 
      arrayOfByte[b] = contentValues[i];
      i++;
    } 
  }
  
  public void closeRecordStore() throws RecordStoreNotOpenException, RecordStoreException {
    if (this.db != null && this.db.isOpen()) {
      this.db.close();
      return;
    } 
    new RecordStoreNotOpenException("RecordStore is not open");
  }
  
  public void deleteRecord(int paramInt) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
    String str = "delete from " + this.table_name + " where _ID=" + paramInt;
    this.db.execSQL(str);
  }
  
  public RecordEnumeration enumerateRecords(RecordFilter paramRecordFilter, RecordComparator paramRecordComparator, boolean paramBoolean) throws RecordStoreNotOpenException {
    RecordEnumeration recordEnumeration = new RecordEnumeration();
    Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
    CwaActivity.getInstance().startManagingCursor(cursor);
    recordEnumeration.cursor = cursor;
    recordEnumeration.old_cursor = cursor;
    return recordEnumeration;
  }
  
  public String getName() throws RecordStoreNotOpenException {
    return this.table_name;
  }
  
  public int getNextRecordID() throws RecordStoreNotOpenException, RecordStoreException {
    int i = -1;
    Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
    CwaActivity.getInstance().startManagingCursor(cursor);
    if (cursor.moveToLast())
      i = cursor.getInt(0) + 1; 
    return i;
  }
  
  public int getNumRecords() throws RecordStoreNotOpenException {
    Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
    CwaActivity.getInstance().startManagingCursor(cursor);
    return cursor.getCount();
  }
  
  public int getRecord(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
    byte b = -1;
    Cursor cursor = this.db.query(this.table_name, null, "_id=" + paramInt1, null, null, null, null);
    CwaActivity.getInstance().startManagingCursor(cursor);
    int i = b;
    if (cursor.moveToNext()) {
      byte[] arrayOfByte = cursor.getBlob(1);
      i = paramInt2;
      for (paramInt2 = 0;; paramInt2++) {
        if (i >= arrayOfByte.length) {
          i = b;
          if (arrayOfByte != null)
            i = paramInt1; 
          return i;
        } 
        paramArrayOfbyte[paramInt2] = arrayOfByte[i];
        i++;
      } 
    } 
    return i;
  }
  
  public byte[] getRecord(int paramInt) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
    null = this.db.query(this.table_name, null, "_id=" + paramInt, null, null, null, null);
    CwaActivity.getInstance().startManagingCursor(null);
    return null.moveToNext() ? null.getBlob(1) : null;
  }
  
  public int getRecordSize(int paramInt) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
    byte b = -1;
    Cursor cursor = this.db.query(this.table_name, null, "_id=" + paramInt, null, null, null, null);
    CwaActivity.getInstance().startManagingCursor(cursor);
    paramInt = b;
    if (cursor.moveToNext())
      paramInt = (cursor.getBlob(1)).length; 
    return paramInt;
  }
  
  public int getSizeAvailable() throws RecordStoreNotOpenException {
    long l = this.db.getMaximumSize();
    return (l > 2147483647L) ? Integer.MAX_VALUE : (int)l;
  }
  
  public void setRecord(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException, RecordStoreFullException {
    if (getRecord(paramInt1) == null)
      throw new InvalidRecordIDException("recordId is invalid"); 
    byte[] arrayOfByte = new byte[paramInt3];
    int i = paramInt2;
    for (byte b = 0;; b++) {
      ContentValues contentValues;
      if (i >= paramInt3 + paramInt2) {
        contentValues = new ContentValues();
        contentValues.put("content", arrayOfByte);
        this.db.update(this.table_name, contentValues, " _ID=" + paramInt1, null);
        return;
      } 
      arrayOfByte[b] = contentValues[i];
      i++;
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/rms/RecordStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */