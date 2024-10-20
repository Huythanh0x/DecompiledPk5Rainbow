package javax.microedition.rms;

import android.database.Cursor;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
/**
 * The RecordEnumeration class provides methods to manage and iterate over records.
 */
public class RecordEnumeration {
    public Cursor cursor = null;
    public Cursor old_cursor = null;

    /**
     * Destroys the current cursor by setting it to null after performing necessary checks.
     * 
     * @throws IllegalStateException if the cursor is already null.
     */
    public void destroy() {
        checkDestroy();
        this.cursor = null;
    }

    /**
     * Moves the cursor to the next record and returns the record ID.
     * 
     * @return the next record ID, or 0 if there are no more records.
     */
    public int nextRecordId() {
        CwaActivity.getInstance().startManagingCursor(this.cursor);
        if (this.cursor.moveToNext()) {
            return this.cursor.getInt(0) + 1;
        }
        return 0;
    }

    /**
     * Resets the cursor to the old cursor if available, otherwise throws an IllegalStateException.
     * 
     * @throws IllegalStateException if the old cursor is null.
     */
    public void reset() {
        CwaActivity.getInstance().startManagingCursor(this.cursor);
        CwaActivity.getInstance().startManagingCursor(this.old_cursor);
        checkDestroy();
        if (this.old_cursor != null) {
            this.cursor = this.old_cursor;
            return;
        }
        throw new IllegalStateException();
    }

    /**
     * Checks if the cursor is null and throws an IllegalStateException if it is.
     * 
     * @throws IllegalStateException if the cursor is null.
     */
    public void checkDestroy() {
        if (this.cursor == null) {
            throw new IllegalStateException("");
        }
    }
}
