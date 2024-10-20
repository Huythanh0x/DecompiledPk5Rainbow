package javax.microedition.rms;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
/**
 * The RecordStore class provides a mechanism for managing a collection of records.
 * It supports operations such as adding, deleting, and retrieving records.
 * Records are stored in a SQLite database.
 */
public class RecordStore {
    public static final int AUTHMODE_ANY = 1;
    public static final int AUTHMODE_PRIVATE = 0;
    private static final long INT_MAX = 2147483647L;
    private SQLiteDatabase db;
    private String table_name;

    /**
     * Adds a new record to the record store.
     *
     * @param data the data to be added as a record
     * @param offset the starting offset in the data array
     * @param numBytes the number of bytes to be added
     * @return the record ID of the newly added record
     * @throws RecordStoreNotOpenException if the record store is not open
     * @throws RecordStoreException if a general record store exception occurs
     * @throws RecordStoreFullException if the record store is full
     */
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

    /**
     * Closes the record store.
     *
     * @throws RecordStoreNotOpenException if the record store is not open
     * @throws RecordStoreException if a general record store exception occurs
     */
    public void closeRecordStore() throws RecordStoreNotOpenException, RecordStoreException {
        if (this.db != null && this.db.isOpen()) {
            this.db.close();
        } else {
            new RecordStoreNotOpenException("RecordStore is not open");
        }
    }

    /**
     * Deletes a record from the record store.
     *
     * @param recordId the ID of the record to be deleted
     * @throws RecordStoreNotOpenException if the record store is not open
     * @throws InvalidRecordIDException if the record ID is invalid
     * @throws RecordStoreException if a general record store exception occurs
     */
    public void deleteRecord(int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        String sql = "delete from " + this.table_name + " where _ID=" + recordId;
        this.db.execSQL(sql);
    }

    /**
     * Deletes the record store with the specified name.
     *
     * @param recordStoreName the name of the record store to be deleted
     * @throws RecordStoreException if a general record store exception occurs
     * @throws RecordStoreNotFoundException if the record store is not found
     */
    public static void deleteRecordStore(String recordStoreName) throws RecordStoreException, RecordStoreNotFoundException {
        CwaActivity.getContextInstance().deleteDatabase(recordStoreName);
    }

    /**
     * Returns an enumeration for traversing the records in the record store.
     *
     * @param filter the filter to apply to the records
     * @param comparator the comparator to use for sorting the records
     * @param keepUpdated whether to keep the enumeration updated
     * @return a RecordEnumeration for traversing the records
     * @throws RecordStoreNotOpenException if the record store is not open
     */
    public RecordEnumeration enumerateRecords(RecordFilter filter, RecordComparator comparator, boolean keepUpdated) throws RecordStoreNotOpenException {
        RecordEnumeration record_enumeration = new RecordEnumeration();
        Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        record_enumeration.cursor = cursor;
        record_enumeration.old_cursor = cursor;
        return record_enumeration;
    }

    /**
     * Returns the name of the record store.
     *
     * @return the name of the record store
     * @throws RecordStoreNotOpenException if the record store is not open
     */
    public String getName() throws RecordStoreNotOpenException {
        return this.table_name;
    }

    /**
     * Returns the next available record ID.
     *
     * @return the next available record ID
     * @throws RecordStoreNotOpenException if the record store is not open
     * @throws RecordStoreException if a general record store exception occurs
     */
    public int getNextRecordID() throws RecordStoreNotOpenException, RecordStoreException {
        Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        if (!cursor.moveToLast()) {
            return -1;
        }
        int result = cursor.getInt(0) + 1;
        return result;
    }

    /**
     * Returns the number of records in the record store.
     *
     * @return the number of records in the record store
     * @throws RecordStoreNotOpenException if the record store is not open
     */
    public int getNumRecords() throws RecordStoreNotOpenException {
        Cursor cursor = this.db.query(this.table_name, null, null, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        int result = cursor.getCount();
        return result;
    }

    /**
     * Retrieves the data of a record with the specified ID.
     *
     * @param recordId the ID of the record to be retrieved
     * @return the data of the record
     * @throws RecordStoreNotOpenException if the record store is not open
     * @throws InvalidRecordIDException if the record ID is invalid
     * @throws RecordStoreException if a general record store exception occurs
     */
    public byte[] getRecord(int recordId) throws RecordStoreNotOpenException, InvalidRecordIDException, RecordStoreException {
        Cursor cursor = this.db.query(this.table_name, null, "_id=" + recordId, null, null, null, null);
        CwaActivity.getInstance().startManagingCursor(cursor);
        if (!cursor.moveToNext()) {
            return null;
        }
        byte[] data = cursor.getBlob(1);
        return data;
    }

    /**
     * Retrieves the data of a record with the specified ID into a buffer.
     *
     * @param recordId the ID of the record to be retrieved
     * @param buffer the buffer to store the record data
     * @param offset the starting offset in the buffer
     * @return the record ID if successful, -1 otherwise
     * @throws RecordStoreNotOpenException if the record store is not open
     * @throws InvalidRecordIDException if the record ID is invalid
     * @throws RecordStoreException if a general record store exception occurs
     */
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

    /**
     * Returns the size of a record with the specified ID.
     *
     * @param recordId the ID of the record
     * @return the size of the record
     * @throws RecordStoreNotOpenException if the record store is not open
     * @throws InvalidRecordIDException if the record ID is invalid
     * @throws RecordStoreException if a general record store exception occurs
     */
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

    /**
     * Opens a record store with the specified name.
     *
     * @param recordStoreName the name of the record store
     * @param createIfNecessary whether to create the record store if it does not exist
     * @return the opened RecordStore
     * @throws RecordStoreException if a general record store exception occurs
     * @throws RecordStoreFullException if the record store is full
     * @throws RecordStoreNotFoundException if the record store is not found
     */
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

    /**
     * Sets the data of a record with the specified ID.
     *
     * @param recordId the ID of the record to be updated
     * @param newData the new data for the record
     * @param offset the starting offset in the new data array
     * @param numBytes the number of bytes to be set
     * @throws RecordStoreNotOpenException if the record store is not open
     * @throws InvalidRecordIDException if the record ID is invalid
     * @throws RecordStoreException if a general record store exception occurs
     * @throws RecordStoreFullException if the record store is full
     */
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

    /**
     * Returns the available size in the record store.
     *
     * @return the available size in the record store
     * @throws RecordStoreNotOpenException if the record store is not open
     */
    public int getSizeAvailable() throws RecordStoreNotOpenException {
        long sizeavailable = this.db.getMaximumSize();
        if (sizeavailable > INT_MAX) {
            return Integer.MAX_VALUE;
        }
        return (int) sizeavailable;
    }
}
