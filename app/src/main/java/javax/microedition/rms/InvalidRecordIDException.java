package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * This class represents an exception that is thrown when an invalid record ID is encountered
 * in a record store operation.
 * 
 * <p>This exception extends {@link RecordStoreException} and provides constructors to create
 * an instance with or without a detailed message.</p>
 */
public class InvalidRecordIDException extends RecordStoreException {
    private static final long serialVersionUID = 1;

    /**
     * Constructs a new {@code InvalidRecordIDException} with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidRecordIDException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code InvalidRecordIDException} with no detail message.
     */
    public InvalidRecordIDException() {
    }
}
