package javax.microedition.rms;

public interface ExtendedRecordListener extends RecordListener {
    public static final int RECORDSTORE_CLOSE = 9;
    public static final int RECORDSTORE_DELETE = 10;
    public static final int RECORDSTORE_OPEN = 8;
    public static final int RECORD_ADD = 1;
    public static final int RECORD_CHANGE = 3;
    public static final int RECORD_DELETE = 4;
    public static final int RECORD_READ = 2;

    void recordEvent(int arg1, long arg2, RecordStore arg3, int arg4);

    void recordStoreEvent(int arg1, long arg2, String arg3);
}

