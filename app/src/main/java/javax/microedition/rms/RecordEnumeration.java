package javax.microedition.rms;

import android.database.Cursor;
import javax.microedition.lcdui.CwaActivity;

public class RecordEnumeration {
   public Cursor cursor = null;
   public Cursor old_cursor = null;

   public RecordEnumeration() {
      super();
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
      int var1;
      if (this.cursor.moveToNext()) {
         var1 = this.cursor.getInt(0) + 1;
      } else {
         var1 = 0;
      }

      return var1;
   }

   public void reset() {
      CwaActivity.getInstance().startManagingCursor(this.cursor);
      CwaActivity.getInstance().startManagingCursor(this.old_cursor);
      this.checkDestroy();
      if (this.old_cursor != null) {
         this.cursor = this.old_cursor;
      } else {
         throw new IllegalStateException();
      }
   }
}
