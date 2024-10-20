package javax.microedition.rms;

/* loaded from: classes.dex */
/**
 * The RecordFilter interface defines a method for determining whether a 
 * record matches a particular criteria. Implementations of this interface 
 * can be used to filter records in a record store.
 */
public interface RecordFilter {

    /**
     * Tests whether or not the specified record matches the criteria defined 
     * by this filter.
     *
     * @param bArr the record to be tested as a byte array
     * @return true if the record matches the criteria, false otherwise
     */
    boolean matches(byte[] bArr);
}
