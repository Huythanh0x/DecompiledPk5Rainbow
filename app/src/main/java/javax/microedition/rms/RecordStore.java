package javax.microedition.rms;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;

public class RecordStore {
    public static final int AUTHMODE_ANY = 1;
    public static final int AUTHMODE_PRIVATE = 0;
    private static final long INT_MAX = 0x7FFFFFFFL;
    private SQLiteDatabase db;
    private String table_name;

    public int addRecord(byte[] data, int offset, int numBytes) throws RecordStoreNotOpenException, RecordStoreException, RecordStoreFullException {
        byte[] datarecord = new byte[numBytes];
        int i = offset;
        for(int j = 0; i < numBytes + offset; ++j) {
            datarecord[j] = data[i];
            ++i;
        }
        ContentValues values = new ContentValues();
        values.put("content", datarecord);
        return (int)this.db.insert(this.table_name, null, values);
    }

    public void closeRecordStore() throws RecordStoreNotOpenException, RecordStoreException {
        if(this.db != null && this.db.isOpen()) {
            this.db.close();
            return;
        }
        new RecordStoreNotOpenException("RecordStore is not open");
    }

    public void deleteRecord(int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        this.db.execSQL("delete from " + this.table_name + " where _ID=" + recordId);
    }

    public static void deleteRecordStore(String recordStoreName) throws RecordStoreException, RecordStoreNotFoundException {
        CwaActivity.getContextInstance().deleteDatabase(recordStoreName);
    }

    public RecordEnumeration enumerateRecords(RecordFilter filter, RecordComparator comparator, boolean keepUpdated) throws RecordStoreNotOpenException {
        RecordEnumeration record_enumeration = new RecordEnumeration();
        Cursor cursor0 = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor0);
        record_enumeration.cursor = cursor0;
        record_enumeration.old_cursor = cursor0;
        return record_enumeration;
    }

    public String getName() throws RecordStoreNotOpenException {
        return this.table_name;
    }

    public int getNextRecordID() throws RecordStoreNotOpenException, RecordStoreException {
        Cursor cursor0 = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor0);
        return cursor0.moveToLast() ? cursor0.getInt(0) + 1 : -1;
    }

    public int getNumRecords() throws RecordStoreNotOpenException {
        Cursor cursor0 = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor0);
        return cursor0.getCount();
    }

    public int getRecord(int recordId, byte[] buffer, int offset) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        Cursor cursor0 = this.db.query(this.table_name, null, "_id=" + recordId, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor0);
        if(cursor0.moveToNext()) {
            byte[] arr_b1 = cursor0.getBlob(1);
            int i = offset;
            for(int j = 0; i < arr_b1.length; ++j) {
                buffer[j] = arr_b1[i];
                ++i;
            }
            return arr_b1 == null ? -1 : recordId;
        }
        return -1;
    }

    public byte[] getRecord(int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        Cursor cursor0 = this.db.query(this.table_name, null, "_id=" + recordId, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor0);
        return cursor0.moveToNext() ? cursor0.getBlob(1) : null;
    }

    public int getRecordSize(int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        Cursor cursor0 = this.db.query(this.table_name, null, "_id=" + recordId, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor0);
        return cursor0.moveToNext() ? cursor0.getBlob(1).length : -1;
    }

    public int getSizeAvailable() throws RecordStoreNotOpenException {
        long v = this.db.getMaximumSize();
        return v <= 0x7FFFFFFFL ? ((int)v) : 0x7FFFFFFF;
    }

    public static RecordStore openRecordStore(String recordStoreName, boolean createIfNecessary) throws RecordStoreException, RecordStoreFullException, RecordStoreNotFoundException {
        RecordStore rs = new RecordStore();
        rs.table_name = recordStoreName;
        rs.db = CwaActivity.getContextInstance().openOrCreateDatabase(recordStoreName, 0, null);
        try {
            rs.db.query(recordStoreName, null, null, null, null, null, null);
        }
        catch(Exception unused_ex) {
            if(!createIfNecessary) {
                if(rs.db.isOpen()) {
                    rs.db.close();
                }
                throw new RecordStoreException();
            }
            Log.d("RMS", "no table and create table");
            rs.db.execSQL("create table " + recordStoreName + "(" + "_id" + " integer primary key autoincrement,content text not null);");
        }
        return rs;
    }

    public void setRecord(int recordId, byte[] newData, int offset, int numBytes) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException, RecordStoreFullException {
        if(this.getRecord(recordId) == null) {
            throw new InvalidRecordIDException("recordId is invalid");
        }
        byte[] datarecord = new byte[numBytes];
        int i = offset;
        for(int j = 0; i < numBytes + offset; ++j) {
            datarecord[j] = newData[i];
            ++i;
        }
        ContentValues values = new ContentValues();
        values.put("content", datarecord);
        this.db.update(this.table_name, values, " _ID=" + recordId, null);
    }
}

