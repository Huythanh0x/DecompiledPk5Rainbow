package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * This class represents an exception that is thrown when an operation on a 
 * record store fails.
 * 
 * <p>The {@code RecordStoreException} class extends the {@code Exception} class 
 * and provides constructors to create an exception with a specified detail 
 * message or without any detail message.</p>
 */
public class RecordStoreException extends Exception {
    private static final long serialVersionUID = 1;

    /**
     * Constructs a new {@code RecordStoreException} with the specified detail 
     * message.
     *
     * @param message the detail message
     */
    public RecordStoreException(String message) {
        super(message);
    }

    /**
     * Constructs a new {@code RecordStoreException} with no detail message.
     */
    public RecordStoreException() {
    }
}
