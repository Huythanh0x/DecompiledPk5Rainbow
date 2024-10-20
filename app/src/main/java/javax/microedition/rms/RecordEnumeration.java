package javax.microedition.rms;

import javax.microedition.lcdui.CwaActivity;
import android.database.Cursor;

public class RecordEnumeration
{
    public Cursor cursor;
    public Cursor old_cursor;
    
    public RecordEnumeration() {
        super();
        this.cursor = null;
        this.old_cursor = null;
    }
    
    public void checkDestroy() {
        if (this.cursor == null) {
            throw new IllegalStateException("");
        }
    }
    
    public void destroy() {
        this.checkDestroy();
        this.cursor = null;
    }
    
    public int nextRecordId() {
        CwaActivity.getInstance().startManagingCursor(this.cursor);
        int n;
        if (this.cursor.moveToNext()) {
            n = this.cursor.getInt(0) + 1;
        }
        else {
            n = 0;
        }
        return n;
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
