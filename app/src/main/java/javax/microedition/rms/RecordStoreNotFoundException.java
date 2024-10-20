package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * This class represents an exception that is thrown when a record store 
 * cannot be found.
 * 
 * <p>This exception is a subclass of {@link RecordStoreException} and 
 * indicates that the requested record store does not exist.</p>
 */
public class RecordStoreNotFoundException extends RecordStoreException {
    private static final long serialVersionUID = 1;

    /**
     * Constructs a new {@code RecordStoreNotFoundException} with the specified 
     * detail message.
     *
     * @param message the detail message
     */
    public RecordStoreNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code RecordStoreNotFoundException} with no detail 
     * message.
     */
    public RecordStoreNotFoundException() {
    }
}
