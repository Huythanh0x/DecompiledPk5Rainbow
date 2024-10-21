package javax.microedition.rms;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;

public class RecordStore {
   public static final int AUTHMODE_ANY = 1;
   public static final int AUTHMODE_PRIVATE = 0;
   private static final long INT_MAX = 2147483647L;
   private SQLiteDatabase db;
   private String table_name;

   public RecordStore() {
      super();
   }

   public static void deleteRecordStore(String var0) throws RecordStoreException, RecordStoreNotFoundException {
      CwaActivity.getContextInstance().deleteDatabase(var0);
   }

   public static RecordStore openRecordStore(String var0, boolean var1) throws RecordStoreException, RecordStoreFullException, RecordStoreNotFoundException {
      RecordStore var2 = new RecordStore();
      var2.table_name = var0;
      var2.db = CwaActivity.getContextInstance().openOrCreateDatabase(var0, 0, (SQLiteDatabase.CursorFactory)null);

      try {
         var2.db.query(var0, (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
      } catch (Exception var4) {
         if (!var1) {
            if (var2.db.isOpen()) {
               var2.db.close();
            }

            throw new RecordStoreException();
         }

         Log.d("RMS", "no table and create table");
         var0 = "create table " + var0 + "(" + "_id" + " integer primary key autoincrement,content text not null);";
         var2.db.execSQL(var0);
      }

      return var2;
   }

   public int addRecord(byte[] var1, int var2, int var3) throws RecordStoreNotOpenException, RecordStoreException, RecordStoreFullException {
      byte[] var6 = new byte[var3];
      int var5 = var2;

      for(int var4 = 0; var5 < var3 + var2; ++var4) {
         var6[var4] = var1[var5];
         ++var5;
      }

      ContentValues var7 = new ContentValues();
      var7.put("content", var6);
      return (int)this.db.insert(this.table_name, (String)null, var7);
   }

   public void closeRecordStore() throws RecordStoreNotOpenException, RecordStoreException {
      if (this.db != null && this.db.isOpen()) {
         this.db.close();
      } else {
         new RecordStoreNotOpenException("RecordStore is not open");
      }

   }

   public void deleteRecord(int var1) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
      String var2 = "delete from " + this.table_name + " where _ID=" + var1;
      this.db.execSQL(var2);
   }

   public RecordEnumeration enumerateRecords(RecordFilter var1, RecordComparator var2, boolean var3) throws RecordStoreNotOpenException {
      RecordEnumeration var4 = new RecordEnumeration();
      Cursor var5 = this.db.query(this.table_name, (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
      CwaActivity.getInstance().startManagingCursor(var5);
      var4.cursor = var5;
      var4.old_cursor = var5;
      return var4;
   }

   public String getName() throws RecordStoreNotOpenException {
      return this.table_name;
   }

   public int getNextRecordID() throws RecordStoreNotOpenException, RecordStoreException {
      int var1 = -1;
      Cursor var2 = this.db.query(this.table_name, (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
      CwaActivity.getInstance().startManagingCursor(var2);
      if (var2.moveToLast()) {
         var1 = var2.getInt(0) + 1;
      }

      return var1;
   }

   public int getNumRecords() throws RecordStoreNotOpenException {
      Cursor var1 = this.db.query(this.table_name, (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
      CwaActivity.getInstance().startManagingCursor(var1);
      return var1.getCount();
   }

   public int getRecord(int var1, byte[] var2, int var3) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
      byte var5 = -1;
      Cursor var6 = this.db.query(this.table_name, (String[])null, "_id=" + var1, (String[])null, (String)null, (String)null, (String)null);
      CwaActivity.getInstance().startManagingCursor(var6);
      int var4 = var5;
      if (var6.moveToNext()) {
         byte[] var7 = var6.getBlob(1);
         var4 = var3;

         for(var3 = 0; var4 < var7.length; ++var3) {
            var2[var3] = var7[var4];
            ++var4;
         }

         var4 = var5;
         if (var7 != null) {
            var4 = var1;
         }
      }

      return var4;
   }

   public byte[] getRecord(int var1) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
      Cursor var2 = this.db.query(this.table_name, (String[])null, "_id=" + var1, (String[])null, (String)null, (String)null, (String)null);
      CwaActivity.getInstance().startManagingCursor(var2);
      byte[] var3;
      if (var2.moveToNext()) {
         var3 = var2.getBlob(1);
      } else {
         var3 = null;
      }

      return var3;
   }

   public int getRecordSize(int var1) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
      byte var2 = -1;
      Cursor var3 = this.db.query(this.table_name, (String[])null, "_id=" + var1, (String[])null, (String)null, (String)null, (String)null);
      CwaActivity.getInstance().startManagingCursor(var3);
      var1 = var2;
      if (var3.moveToNext()) {
         var1 = var3.getBlob(1).length;
      }

      return var1;
   }

   public int getSizeAvailable() throws RecordStoreNotOpenException {
      long var2 = this.db.getMaximumSize();
      int var1;
      if (var2 > 2147483647L) {
         var1 = Integer.MAX_VALUE;
      } else {
         var1 = (int)var2;
      }

      return var1;
   }

   public void setRecord(int var1, byte[] var2, int var3, int var4) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException, RecordStoreFullException {
      if (this.getRecord(var1) == null) {
         throw new InvalidRecordIDException("recordId is invalid");
      } else {
         byte[] var7 = new byte[var4];
         int var6 = var3;

         for(int var5 = 0; var6 < var4 + var3; ++var5) {
            var7[var5] = var2[var6];
            ++var6;
         }

         ContentValues var8 = new ContentValues();
         var8.put("content", var7);
         this.db.update(this.table_name, var8, " _ID=" + var1, (String[])null);
      }
   }
}
