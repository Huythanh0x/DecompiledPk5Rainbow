package javax.microedition.rms;

/* loaded from: classes.dex */
public interface ExtendedRecordListener extends RecordListener {
    public static final int RECORDSTORE_CLOSE = 9;
    public static final int RECORDSTORE_DELETE = 10;
    public static final int RECORDSTORE_OPEN = 8;
    public static final int RECORD_ADD = 1;
    public static final int RECORD_CHANGE = 3;
    public static final int RECORD_DELETE = 4;
    public static final int RECORD_READ = 2;

    void recordEvent(int i, long j, RecordStore recordStore, int i2);

    void recordStoreEvent(int i, long j, String str);
}
