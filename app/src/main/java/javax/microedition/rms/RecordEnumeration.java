package javax.microedition.rms;

import android.database.Cursor;
import javax.microedition.lcdui.CwaActivity;

/* loaded from: classes.dex */
public class RecordEnumeration {
    public Cursor cursor = null;
    public Cursor old_cursor = null;

    public void destroy() {
        checkDestroy();
        this.cursor = null;
    }

    public int nextRecordId() {
        CwaActivity.getInstance().startManagingCursor(this.cursor);
        if (this.cursor.moveToNext()) {
            return this.cursor.getInt(0) + 1;
        }
        return 0;
    }

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

    public void checkDestroy() {
        if (this.cursor == null) {
            throw new IllegalStateException("");
        }
    }
}
