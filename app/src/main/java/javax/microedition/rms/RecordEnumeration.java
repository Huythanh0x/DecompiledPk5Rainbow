package javax.microedition.rms.RecordEnumeration;
import java.lang.Object;
import java.lang.IllegalStateException;
import java.lang.String;
import javax.microedition.lcdui.CwaActivity;
import android.database.Cursor;

public class RecordEnumeration	// class@000157 from classes.dex
{
    public Cursor cursor;
    public Cursor old_cursor;

    public void RecordEnumeration(){
       super();
       this.cursor = null;
       this.old_cursor = null;
    }
    public void checkDestroy(){
       if (this.cursor == null) {
          throw new IllegalStateException("");
       }
       return;
    }
    public void destroy(){
       this.checkDestroy();
       this.cursor = null;
    }
    public int nextRecordId(){
       CwaActivity.getInstance().startManagingCursor(this.cursor);
       int i = (this.cursor.moveToNext())? this.cursor.getInt(0) + 1: 0;
       return i;
    }
    public void reset(){
       CwaActivity.getInstance().startManagingCursor(this.cursor);
       CwaActivity.getInstance().startManagingCursor(this.old_cursor);
       this.checkDestroy();
       if (this.old_cursor == null) {
          throw new IllegalStateException();
       }
       this.cursor = this.old_cursor;
       return;
    }
}
