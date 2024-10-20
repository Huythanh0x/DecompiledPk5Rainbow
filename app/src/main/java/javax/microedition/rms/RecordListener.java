package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * The RecordListener interface provides methods to listen for changes in a RecordStore.
 * Implementations of this interface can be used to handle events when records are added,
 * changed, or deleted in a RecordStore.
 */
public interface RecordListener {

    /**
     * Called when a record is added to the RecordStore.
     *
     * @param recordStore the RecordStore to which the record was added
     * @param i the recordId of the newly added record
     */
    void recordAdded(RecordStore recordStore, int i);

    /**
     * Called when a record in the RecordStore is changed.
     *
     * @param recordStore the RecordStore in which the record was changed
     * @param i the recordId of the changed record
     */
    void recordChanged(RecordStore recordStore, int i);

    /**
     * Called when a record is deleted from the RecordStore.
     *
     * @param recordStore the RecordStore from which the record was deleted
     * @param i the recordId of the deleted record
     */
    void recordDeleted(RecordStore recordStore, int i);
}
