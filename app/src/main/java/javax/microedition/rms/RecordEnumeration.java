package javax.microedition.rms;

import android.database.Cursor;
import javax.microedition.lcdui.CwaActivity;

public class RecordEnumeration {
  public Cursor cursor = null;
  
  public Cursor old_cursor = null;
  
  public void checkDestroy() {
    if (this.cursor == null)
      throw new IllegalStateException(""); 
  }
  
  public void destroy() {
    checkDestroy();
    this.cursor = null;
  }
  
  public int nextRecordId() {
    CwaActivity.getInstance().startManagingCursor(this.cursor);
    return this.cursor.moveToNext() ? (this.cursor.getInt(0) + 1) : 0;
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
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/rms/RecordEnumeration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */