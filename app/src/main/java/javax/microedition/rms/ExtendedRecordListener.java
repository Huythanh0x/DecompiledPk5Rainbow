package javax.microedition.rms.ExtendedRecordListener;
import javax.microedition.rms.RecordListener;
import javax.microedition.rms.RecordStore;
import java.lang.String;

public interface abstract ExtendedRecordListener implements RecordListener	// class@000154 from classes.dex
{
    public static final int RECORDSTORE_CLOSE = 9;
    public static final int RECORDSTORE_DELETE = 10;
    public static final int RECORDSTORE_OPEN = 8;
    public static final int RECORD_ADD = 1;
    public static final int RECORD_CHANGE = 3;
    public static final int RECORD_DELETE = 4;
    public static final int RECORD_READ = 2;

    void recordEvent(int p0,long p1,RecordStore p2,int p3);
    void recordStoreEvent(int p0,long p1,String p2);
}
