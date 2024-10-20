package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * This class represents an exception that is thrown when an operation is attempted on a record store that is not open.
 * It extends the {@link RecordStoreException} class.
 */
public class RecordStoreNotOpenException extends RecordStoreException {
    private static final long serialVersionUID = 1;

    /**
     * Constructs a new {@code RecordStoreNotOpenException} with the specified detail message.
     *
     * @param message the detail message
     */
    public RecordStoreNotOpenException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code RecordStoreNotOpenException} with no detail message.
     */
    public RecordStoreNotOpenException() {
    }
}
