package javax.microedition.rms;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
public class RecordStore {
    public static final int AUTHMODE_ANY = 1;
    public static final int AUTHMODE_PRIVATE = 0;
    private static final long INT_MAX = 2147483647L;
    private SQLiteDatabase db;
    private String table_name;

    public int addRecord(byte[] data, int offset, int numBytes) throws RecordStoreNotOpenException, RecordStoreException, RecordStoreFullException {
        byte[] datarecord = new byte[numBytes];
        int i = offset;
        int j = 0;
        while (i < numBytes + offset) {
            datarecord[j] = data[i];
            i++;
            j++;
        }
        ContentValues values = new ContentValues();
        values.put("content", datarecord);
        int result = (int) this.db.insert(this.table_name, null, values);
        return result;
    }

    public void closeRecordStore() throws RecordStoreNotOpenException, RecordStoreException {
        if (this.db != null && this.db.isOpen()) {
            this.db.close();
        } else {
            new RecordStoreNotOpenException("RecordStore is not open");
        }
    }

    public void deleteRecord(int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        String sql = "delete from " + this.table_name + " where _ID=" + recordId;
        this.db.execSQL(sql);
    }

    public static void deleteRecordStore(String recordStoreName) throws RecordStoreException, RecordStoreNotFoundException {
        CwaActivity.getContextInstance().deleteDatabase(recordStoreName);
    }

    public RecordEnumeration enumerateRecords(RecordFilter filter, RecordComparator comparator, boolean keepUpdated) throws RecordStoreNotOpenException {
        RecordEnumeration record_enumeration = new RecordEnumeration();
        Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        record_enumeration.cursor = cursor;
        record_enumeration.old_cursor = cursor;
        return record_enumeration;
    }

    public String getName() throws RecordStoreNotOpenException {
        return this.table_name;
    }

    public int getNextRecordID() throws RecordStoreNotOpenException, RecordStoreException {
        Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        if (!cursor.moveToLast()) {
            return -1;
        }
        int result = cursor.getInt(0) + 1;
        return result;
    }

    public int getNumRecords() throws RecordStoreNotOpenException {
        Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        int result = cursor.getCount();
        return result;
    }

    public byte[] getRecord(int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        Cursor cursor = this.db.query(this.table_name, null, "_id=" + recordId, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        if (!cursor.moveToNext()) {
            return null;
        }
        byte[] data = cursor.getBlob(1);
        return data;
    }

    public int getRecord(int recordId, byte[] buffer, int offset) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        Cursor cursor = this.db.query(this.table_name, null, "_id=" + recordId, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        if (!cursor.moveToNext()) {
            return -1;
        }
        byte[] data = cursor.getBlob(1);
        int i = offset;
        int j = 0;
        while (i < data.length) {
            buffer[j] = data[i];
            i++;
            j++;
        }
        if (data == null) {
            return -1;
        }
        return recordId;
    }

    public int getRecordSize(int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        Cursor cursor = this.db.query(this.table_name, null, "_id=" + recordId, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        if (!cursor.moveToNext()) {
            return -1;
        }
        byte[] data = cursor.getBlob(1);
        int result = data.length;
        return result;
    }

    public static RecordStore openRecordStore(String recordStoreName, boolean createIfNecessary) throws RecordStoreException, RecordStoreFullException, RecordStoreNotFoundException {
        RecordStore rs = new RecordStore();
        rs.table_name = recordStoreName;
        rs.db = CwaActivity.getContextInstance().openOrCreateDatabase(recordStoreName, 0, null);
        try {
            rs.db.query(recordStoreName, null, null, null, null, null, null);
        } catch (Exception e) {
            if (!createIfNecessary) {
                if (rs.db.isOpen()) {
                    rs.db.close();
                }
                throw new RecordStoreException();
            }
            Log.d("RMS", "no table and create table");
            String sql = "create table " + recordStoreName + "(_id integer primary key autoincrement,content text not null);";
            rs.db.execSQL(sql);
        }
        return rs;
    }

    public void setRecord(int recordId, byte[] newData, int offset, int numBytes) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException, RecordStoreFullException {
        if (getRecord(recordId) == null) {
            throw new InvalidRecordIDException("recordId is invalid");
        }
        byte[] datarecord = new byte[numBytes];
        int i = offset;
        int j = 0;
        while (i < numBytes + offset) {
            datarecord[j] = newData[i];
            i++;
            j++;
        }
        ContentValues values = new ContentValues();
        values.put("content", datarecord);
        this.db.update(this.table_name, values, " _ID=" + recordId, null);
    }

    public int getSizeAvailable() throws RecordStoreNotOpenException {
        long sizeavailable = this.db.getMaximumSize();
        if (sizeavailable > INT_MAX) {
            return Integer.MAX_VALUE;
        }
        return (int) sizeavailable;
    }
}
