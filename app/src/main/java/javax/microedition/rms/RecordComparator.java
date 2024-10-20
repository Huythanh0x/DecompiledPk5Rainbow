package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * The RecordComparator interface defines a method for comparing two records.
 * Implementations of this interface can be used to sort records in a RecordStore.
 */
public interface RecordComparator {
    
    /**
     * Indicates that the two records are equivalent.
     */
    public static final int EQUIVALENT = 0;

    /**
     * Indicates that the first record follows the second record.
     */
    public static final int FOLLOWS = 1;

    /**
     * Indicates that the first record precedes the second record.
     */
    public static final int PRECEDES = -1;

    /**
     * Compares two records.
     *
     * @param bArr the first record to compare
     * @param bArr2 the second record to compare
     * @return an integer indicating the order of the two records:
     *         {@code EQUIVALENT} if the records are equivalent,
     *         {@code FOLLOWS} if the first record follows the second,
     *         {@code PRECEDES} if the first record precedes the second
     */
    int compare(byte[] bArr, byte[] bArr2);
}
