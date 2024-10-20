/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  javax.microedition.lcdui.CwaActivity
 */
package javax.microedition.rms;

import android.database.Cursor;
import javax.microedition.lcdui.CwaActivity;

public class RecordEnumeration {
    public Cursor cursor = null;
    public Cursor old_cursor = null;

    public void checkDestroy() {
        if (this.cursor == null) {
            throw new IllegalStateException("");
        }
    }

    public void destroy() {
        this.checkDestroy();
        this.cursor = null;
    }

    /*
     * Enabled force condition propagation
     */
    public int nextRecordId() {
        CwaActivity.getInstance().startManagingCursor(this.cursor);
        if (!this.cursor.moveToNext()) return 0;
        return this.cursor.getInt(0) + 1;
    }

    public void reset() {
        CwaActivity.getInstance().startManagingCursor(this.cursor);
        CwaActivity.getInstance().startManagingCursor(this.old_cursor);
        this.checkDestroy();
        if (this.old_cursor != null) {
            this.cursor = this.old_cursor;
            return;
        }
        throw new IllegalStateException();
    }
}
