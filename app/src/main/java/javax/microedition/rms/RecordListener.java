package javax.microedition.rms;

/* loaded from: classes.dex */
public interface RecordListener {
    void recordAdded(RecordStore recordStore, int i);

    void recordChanged(RecordStore recordStore, int i);

    void recordDeleted(RecordStore recordStore, int i);
}
