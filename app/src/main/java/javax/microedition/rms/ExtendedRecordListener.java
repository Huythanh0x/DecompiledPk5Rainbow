package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * The ExtendedRecordListener interface extends the RecordListener interface 
 * to provide additional event handling capabilities for record store operations.
 * It includes constants representing various record store events and methods 
 * to handle these events.
 */
public interface ExtendedRecordListener extends RecordListener {
    public static final int RECORDSTORE_CLOSE = 9;
    public static final int RECORDSTORE_DELETE = 10;
    public static final int RECORDSTORE_OPEN = 8;
    public static final int RECORD_ADD = 1;
    public static final int RECORD_CHANGE = 3;
    public static final int RECORD_DELETE = 4;
    public static final int RECORD_READ = 2;

    /**
     * Handles a record event.
     *
     * @param eventType The type of the event (e.g., RECORD_ADD, RECORD_CHANGE, etc.).
     * @param timestamp The timestamp of the event.
     * @param recordStore The RecordStore where the event occurred.
     * @param recordId The ID of the record involved in the event.
     */
    void recordEvent(int eventType, long timestamp, RecordStore recordStore, int recordId);

    /**
     * Handles a record store event.
     *
     * @param eventType The type of the event (e.g., RECORDSTORE_OPEN, RECORDSTORE_CLOSE, etc.).
     * @param timestamp The timestamp of the event.
     * @param recordStoreName The name of the RecordStore where the event occurred.
     */
    void recordStoreEvent(int eventType, long timestamp, String recordStoreName);
}
