package javax.microedition.rms;

public class RecordStoreFullException extends RecordStoreException {
    private static final long serialVersionUID = 1L;

    public RecordStoreFullException() {
    }

    public RecordStoreFullException(String message) {
        super(message);
    }
}

