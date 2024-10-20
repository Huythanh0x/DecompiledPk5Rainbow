/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.util.Log
 *  javax.microedition.lcdui.CwaActivity
 *  javax.microedition.rms.InvalidRecordIDException
 *  javax.microedition.rms.RecordComparator
 *  javax.microedition.rms.RecordEnumeration
 *  javax.microedition.rms.RecordFilter
 *  javax.microedition.rms.RecordStoreException
 *  javax.microedition.rms.RecordStoreFullException
 *  javax.microedition.rms.RecordStoreNotFoundException
 *  javax.microedition.rms.RecordStoreNotOpenException
 */
package javax.microedition.rms;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;
import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordComparator;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordFilter;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

public class RecordStore {
    public static final int AUTHMODE_ANY = 1;
    public static final int AUTHMODE_PRIVATE = 0;
    private static final long INT_MAX = Integer.MAX_VALUE;
    private SQLiteDatabase db;
    private String table_name;

    public static void deleteRecordStore(String string) throws RecordStoreException, RecordStoreNotFoundException {
        CwaActivity.getContextInstance().deleteDatabase(string);
    }

    /*
     * Enabled force condition propagation
     */
    public static RecordStore openRecordStore(String string, boolean bl) throws RecordStoreException, RecordStoreFullException, RecordStoreNotFoundException {
        RecordStore recordStore = new RecordStore();
        recordStore.table_name = string;
        recordStore.db = CwaActivity.getContextInstance().openOrCreateDatabase(string, 0, null);
        try {
            recordStore.db.query(string, null, null, null, null, null, null);
            return recordStore;
        }
        catch (Exception exception) {
            if (!bl) {
                if (!recordStore.db.isOpen()) throw new RecordStoreException();
                recordStore.db.close();
                throw new RecordStoreException();
            }
            Log.d((String)"RMS", (String)"no table and create table");
            string = "create table " + string + "(" + "_id" + " integer primary key autoincrement,content text not null);";
            recordStore.db.execSQL(string);
            return recordStore;
        }
    }

    public int addRecord(byte[] object, int n, int n2) throws RecordStoreNotOpenException, RecordStoreException, RecordStoreFullException {
        byte[] byArray = new byte[n2];
        int n3 = n;
        int n4 = 0;
        while (true) {
            if (n3 >= n2 + n) {
                object = new ContentValues();
                object.put("content", byArray);
                return (int)this.db.insert(this.table_name, null, (ContentValues)object);
            }
            byArray[n4] = object[n3];
            ++n3;
            ++n4;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public void closeRecordStore() throws RecordStoreNotOpenException, RecordStoreException {
        if (this.db != null && this.db.isOpen()) {
            this.db.close();
            return;
        }
        new RecordStoreNotOpenException("RecordStore is not open");
    }

    public void deleteRecord(int n) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        String string = "delete from " + this.table_name + " where _ID=" + n;
        this.db.execSQL(string);
    }

    public RecordEnumeration enumerateRecords(RecordFilter recordFilter, RecordComparator recordComparator, boolean bl) throws RecordStoreNotOpenException {
        recordFilter = new RecordEnumeration();
        recordComparator = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor((Cursor)recordComparator);
        recordFilter.cursor = recordComparator;
        recordFilter.old_cursor = recordComparator;
        return recordFilter;
    }

    public String getName() throws RecordStoreNotOpenException {
        return this.table_name;
    }

    public int getNextRecordID() throws RecordStoreNotOpenException, RecordStoreException {
        int n = -1;
        Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        if (cursor.moveToLast()) {
            n = cursor.getInt(0) + 1;
        }
        return n;
    }

    public int getNumRecords() throws RecordStoreNotOpenException {
        Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        return cursor.getCount();
    }

    /*
     * Enabled force condition propagation
     */
    public int getRecord(int n, byte[] byArray, int n2) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        int n3 = -1;
        Cursor cursor = this.db.query(this.table_name, null, "_id=" + n, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        int n4 = n3;
        if (!cursor.moveToNext()) return n4;
        byte[] byArray2 = cursor.getBlob(1);
        n4 = n2;
        n2 = 0;
        while (true) {
            if (n4 >= byArray2.length) {
                n4 = n3;
                if (byArray2 == null) return n4;
                return n;
            }
            byArray[n2] = byArray2[n4];
            ++n4;
            ++n2;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    public byte[] getRecord(int n) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        void var2_4;
        Cursor cursor = this.db.query(this.table_name, null, "_id=" + n, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        if (cursor.moveToNext()) {
            byte[] byArray = cursor.getBlob(1);
            return var2_4;
        }
        return var2_4;
    }

    public int getRecordSize(int n) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        int n2 = -1;
        Cursor cursor = this.db.query(this.table_name, null, "_id=" + n, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        n = n2;
        if (cursor.moveToNext()) {
            n = cursor.getBlob(1).length;
        }
        return n;
    }

    /*
     * Enabled force condition propagation
     */
    public int getSizeAvailable() throws RecordStoreNotOpenException {
        long l = this.db.getMaximumSize();
        if (l <= Integer.MAX_VALUE) return (int)l;
        return Integer.MAX_VALUE;
    }

    public void setRecord(int n, byte[] object, int n2, int n3) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException, RecordStoreFullException {
        if (this.getRecord(n) == null) {
            throw new InvalidRecordIDException("recordId is invalid");
        }
        byte[] byArray = new byte[n3];
        int n4 = n2;
        int n5 = 0;
        while (true) {
            if (n4 >= n3 + n2) {
                object = new ContentValues();
                object.put("content", byArray);
                this.db.update(this.table_name, (ContentValues)object, " _ID=" + n, null);
                return;
            }
            byArray[n5] = object[n4];
            ++n4;
            ++n5;
        }
    }
}
