package javax.microedition.rms;

public interface ExtendedRecordListener extends RecordListener
{
    public static final int RECORDSTORE_CLOSE = 9;
    public static final int RECORDSTORE_DELETE = 10;
    public static final int RECORDSTORE_OPEN = 8;
    public static final int RECORD_ADD = 1;
    public static final int RECORD_CHANGE = 3;
    public static final int RECORD_DELETE = 4;
    public static final int RECORD_READ = 2;
    
    void recordEvent(final int p0, final long p1, final RecordStore p2, final int p3);
    
    void recordStoreEvent(final int p0, final long p1, final String p2);
}
