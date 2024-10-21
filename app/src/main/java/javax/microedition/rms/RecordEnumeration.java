package javax.microedition.rms;

import android.database.Cursor;
import javax.microedition.lcdui.CwaActivity;

public class RecordEnumeration {
    public Cursor cursor;
    public Cursor old_cursor;

    public RecordEnumeration() {
        this.cursor = null;
        this.old_cursor = null;
    }

    public void checkDestroy() {
        if(this.cursor == null) {
            throw new IllegalStateException("");
        }
    }

    public void destroy() {
        this.checkDestroy();
        this.cursor = null;
    }

    public int nextRecordId() {
        CwaActivity.getInstance().startManagingCursor(this.cursor);
        return this.cursor.moveToNext() ? this.cursor.getInt(0) + 1 : 0;
    }

    public void reset() {
        CwaActivity.getInstance().startManagingCursor(this.cursor);
        CwaActivity.getInstance().startManagingCursor(this.old_cursor);
        this.checkDestroy();
        if(this.old_cursor == null) {
            throw new IllegalStateException();
        }
        this.cursor = this.old_cursor;
    }
}

