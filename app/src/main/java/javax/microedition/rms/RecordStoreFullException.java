package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * This class represents an exception that is thrown when a record store is full.
 * It extends the {@link RecordStoreException} class.
 */
public class RecordStoreFullException extends RecordStoreException {
    private static final long serialVersionUID = 1;

    /**
     * Constructs a new {@code RecordStoreFullException} with the specified detail message.
     *
     * @param message the detail message
     */
    public RecordStoreFullException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code RecordStoreFullException} with no detail message.
     */
    public RecordStoreFullException() {
    }
}
