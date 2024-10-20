package javax.microedition.rms;

public interface RecordListener {
    void recordAdded(RecordStore arg1, int arg2);

    void recordChanged(RecordStore arg1, int arg2);

    void recordDeleted(RecordStore arg1, int arg2);
}

