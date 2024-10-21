package javax.microedition.rms;

import android.database.Cursor;
import android.content.ContentValues;
import android.util.Log;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import javax.microedition.lcdui.CwaActivity;
import android.database.sqlite.SQLiteDatabase;

public class RecordStore
{
    public static final int AUTHMODE_ANY = 1;
    public static final int AUTHMODE_PRIVATE = 0;
    private static final long INT_MAX = 2147483647L;
    private SQLiteDatabase db;
    private String table_name;
    
    public RecordStore() {
        super();
    }
    
    public static void deleteRecordStore(final String s) throws RecordStoreException, RecordStoreNotFoundException {
        CwaActivity.getContextInstance().deleteDatabase(s);
    }
    
    public static RecordStore openRecordStore(String string, final boolean b) throws RecordStoreException, RecordStoreFullException, RecordStoreNotFoundException {
        final RecordStore recordStore = new RecordStore();
        recordStore.table_name = string;
        recordStore.db = CwaActivity.getContextInstance().openOrCreateDatabase(string, 0, (SQLiteDatabase$CursorFactory)null);
        try {
            recordStore.db.query(string, (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
            return recordStore;
        }
        catch (final Exception ex) {
            if (!b) {
                if (recordStore.db.isOpen()) {
                    recordStore.db.close();
                }
                throw new RecordStoreException();
            }
            Log.d("RMS", "no table and create table");
            string = "create table " + string + "(" + "_id" + " integer primary key autoincrement,content text not null);";
            recordStore.db.execSQL(string);
            return recordStore;
        }
    }
    
    public int addRecord(final byte[] array, final int n, final int n2) throws RecordStoreNotOpenException, RecordStoreException, RecordStoreFullException {
        final byte[] array2 = new byte[n2];
        for (int i = n, n3 = 0; i < n2 + n; ++i, ++n3) {
            array2[n3] = array[i];
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("content", array2);
        return (int)this.db.insert(this.table_name, (String)null, contentValues);
    }
    
    public void closeRecordStore() throws RecordStoreNotOpenException, RecordStoreException {
        if (this.db != null && this.db.isOpen()) {
            this.db.close();
        }
        else {
            new RecordStoreNotOpenException("RecordStore is not open");
        }
    }
    
    public void deleteRecord(final int i) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        this.db.execSQL("delete from " + this.table_name + " where _ID=" + i);
    }
    
    public RecordEnumeration enumerateRecords(final RecordFilter recordFilter, final RecordComparator recordComparator, final boolean b) throws RecordStoreNotOpenException {
        final RecordEnumeration recordEnumeration = new RecordEnumeration();
        final Cursor query = this.db.query(this.table_name, (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
        CwaActivity.getInstance().startManagingCursor(query);
        recordEnumeration.cursor = query;
        recordEnumeration.old_cursor = query;
        return recordEnumeration;
    }
    
    public String getName() throws RecordStoreNotOpenException {
        return this.table_name;
    }
    
    public int getNextRecordID() throws RecordStoreNotOpenException, RecordStoreException {
        int n = -1;
        final Cursor query = this.db.query(this.table_name, (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
        CwaActivity.getInstance().startManagingCursor(query);
        if (query.moveToLast()) {
            n = query.getInt(0) + 1;
        }
        return n;
    }
    
    public int getNumRecords() throws RecordStoreNotOpenException {
        final Cursor query = this.db.query(this.table_name, (String[])null, (String)null, (String[])null, (String)null, (String)null, (String)null);
        CwaActivity.getInstance().startManagingCursor(query);
        return query.getCount();
    }
    
    public int getRecord(final int i, final byte[] array, int n) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        final int n2 = -1;
        final Cursor query = this.db.query(this.table_name, (String[])null, "_id=" + i, (String[])null, (String)null, (String)null, (String)null);
        CwaActivity.getInstance().startManagingCursor(query);
        int n3 = n2;
        if (query.moveToNext()) {
            byte[] blob;
            int j;
            for (blob = query.getBlob(1), j = n, n = 0; j < blob.length; ++j, ++n) {
                array[n] = blob[j];
            }
            n3 = n2;
            if (blob != null) {
                n3 = i;
            }
        }
        return n3;
    }
    
    public byte[] getRecord(final int i) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        final Cursor query = this.db.query(this.table_name, (String[])null, "_id=" + i, (String[])null, (String)null, (String)null, (String)null);
        CwaActivity.getInstance().startManagingCursor(query);
        byte[] blob;
        if (query.moveToNext()) {
            blob = query.getBlob(1);
        }
        else {
            blob = null;
        }
        return blob;
    }
    
    public int getRecordSize(int length) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        final int n = -1;
        final Cursor query = this.db.query(this.table_name, (String[])null, "_id=" + length, (String[])null, (String)null, (String)null, (String)null);
        CwaActivity.getInstance().startManagingCursor(query);
        length = n;
        if (query.moveToNext()) {
            length = query.getBlob(1).length;
        }
        return length;
    }
    
    public int getSizeAvailable() throws RecordStoreNotOpenException {
        final long maximumSize = this.db.getMaximumSize();
        int n;
        if (maximumSize > 2147483647L) {
            n = Integer.MAX_VALUE;
        }
        else {
            n = (int)maximumSize;
        }
        return n;
    }
    
    public void setRecord(final int i, final byte[] array, final int n, final int n2) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException, RecordStoreFullException {
        if (this.getRecord(i) == null) {
            throw new InvalidRecordIDException("recordId is invalid");
        }
        final byte[] array2 = new byte[n2];
        for (int j = n, n3 = 0; j < n2 + n; ++j, ++n3) {
            array2[n3] = array[j];
        }
        final ContentValues contentValues = new ContentValues();
        contentValues.put("content", array2);
        this.db.update(this.table_name, contentValues, " _ID=" + i, (String[])null);
    }
}
