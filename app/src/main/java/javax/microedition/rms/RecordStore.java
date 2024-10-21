package javax.microedition.rms.RecordStore;
import java.lang.Object;
import java.lang.String;
import android.content.Context;
import javax.microedition.lcdui.CwaActivity;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;
import javax.microedition.rms.RecordStoreException;
import android.util.Log;
import java.lang.StringBuilder;
import android.content.ContentValues;
import javax.microedition.rms.RecordStoreNotOpenException;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.InvalidRecordIDException;

public class RecordStore	// class@00015a from classes.dex
{
    private SQLiteDatabase db;
    private String table_name;
    public static final int AUTHMODE_ANY = 1;
    public static final int AUTHMODE_PRIVATE = 0;
    private static final long INT_MAX = 0x7fffffff;

    public void RecordStore(){
       super();
    }
    public static void deleteRecordStore(String recordStoreName){
       CwaActivity.getContextInstance().deleteDatabase(recordStoreName);
    }
    public static RecordStore openRecordStore(String recordStoreName,boolean createIfNecessary){
       RecordStore rs = new RecordStore();
       rs.table_name = recordStoreName;
       SQLiteDatabase sQLiteDataba = CwaActivity.getContextInstance().openOrCreateDatabase(recordStoreName, 0, null);
       try{
          rs.db = sQLiteDataba;
          rs.db.query(recordStoreName, null, null, null, null, null, null);
       }catch(java.lang.Exception e0){
          Exception e = e0;
          if (!createIfNecessary) {
             if (rs.db.isOpen()) {
                rs.db.close();
             }
             throw new RecordStoreException();
          }else {
             Log.d("RMS", "no table and create table");
             String sql = "create table "+recordStoreName+"\("+"_id"+" integer primary key autoincrement,content text not null\);";
             rs.db.execSQL(sql);
          }
       }
       return rs;
    }
    public int addRecord(byte[] data,int offset,int numBytes){
       int result = -1;
       byte[] datarecord = new byte[numBytes];
       int i = offset;
       int j = 0;
       while (true) {
          int ix = numBytes + offset;
          if (i >= ix) {
             break ;
          }else {
             datarecord[j] = data[i];
             i++;
             j++;
          }
       }
       ContentValues values = new ContentValues();
       values.put("content", datarecord);
       result = (int)this.db.insert(this.table_name, null, values);
       return result;
    }
    public void closeRecordStore(){
       if (this.db != null && this.db.isOpen()) {
          this.db.close();
       }else {
          RecordStoreNotOpenException recordStoreN = new RecordStoreNotOpenException("RecordStore is not open");
       }
       return;
    }
    public void deleteRecord(int recordId){
       String sql = "delete from "+this.table_name+" where _ID="+recordId;
       this.db.execSQL(sql);
    }
    public RecordEnumeration enumerateRecords(RecordFilter filter,RecordComparator comparator,boolean keepUpdated){
       RecordEnumeration record_enumeration = new RecordEnumeration();
       Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
       CwaActivity.getInstance().startManagingCursor(cursor);
       record_enumeration.cursor = cursor;
       record_enumeration.old_cursor = cursor;
       return record_enumeration;
    }
    public String getName(){
       return this.table_name;
    }
    public int getNextRecordID(){
       int result = -1;
       Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
       CwaActivity.getInstance().startManagingCursor(cursor);
       if (cursor.moveToLast()) {
          result = cursor.getInt(0) + 1;
       }
       return result;
    }
    public int getNumRecords(){
       int result = 0;
       Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
       CwaActivity.getInstance().startManagingCursor(cursor);
       result = cursor.getCount();
       return result;
    }
    public int getRecord(int recordId,byte[] buffer,int offset){
       int result = -1;
       Cursor cursor = this.db.query(this.table_name, null, "_id="+recordId, null, null, null, null);
       CwaActivity.getInstance().startManagingCursor(cursor);
       if (cursor.moveToNext()) {
          byte[] data = cursor.getBlob(1);
          int i = offset;
          int j = 0;
          while (i < data.length) {
             buffer[j] = data[i];
             i++;
             j++;
          }
          if (data != null) {
             result = recordId;
          }
       }
       return result;
    }
    public byte[] getRecord(int recordId){
       byte[] uobyteArray;
       Cursor cursor = this.db.query(this.table_name, null, "_id="+recordId, null, null, null, null);
       CwaActivity.getInstance().startManagingCursor(cursor);
       if (cursor.moveToNext()) {
          byte[] data = cursor.getBlob(1);
          uobyteArray = data;
       }else {
          uobyteArray = null;
       }
       return uobyteArray;
    }
    public int getRecordSize(int recordId){
       int result = -1;
       Cursor cursor = this.db.query(this.table_name, null, "_id="+recordId, null, null, null, null);
       CwaActivity.getInstance().startManagingCursor(cursor);
       if (cursor.moveToNext()) {
          byte[] data = cursor.getBlob(1);
          result = data.length;
       }
       return result;
    }
    public int getSizeAvailable(){
       long sizeavailable = this.db.getMaximumSize();
       int i = ((sizeavailable - 0x7fffffff) > 0)? Integer.MAX_VALUE: (int)sizeavailable;
       return i;
    }
    public void setRecord(int recordId,byte[] newData,int offset,int numBytes){
       if (this.getRecord(recordId) == null) {
          throw new InvalidRecordIDException("recordId is invalid");
       }
       byte[] datarecord = new byte[numBytes];
       int i = offset;
       int j = 0;
       while (true) {
          int ix = numBytes + offset;
          if (i >= ix) {
             break ;
          }else {
             datarecord[j] = newData[i];
             i++;
             j++;
          }
       }
       ContentValues values = new ContentValues();
       values.put("content", datarecord);
       this.db.update(this.table_name, values, " _ID="+recordId, null);
       return;
    }
}
