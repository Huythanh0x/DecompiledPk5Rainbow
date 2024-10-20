package javax.microedition.midlet;

/* loaded from: classes.dex */
/**
 * This class represents an exception that is thrown to indicate that a 
 * MIDlet state change has failed. It extends the {@link Exception} class.
 * 
 * <p>The {@code MIDletStateChangeException} can be used to signal issues 
 * during the lifecycle transitions of a MIDlet, such as when starting, 
 * pausing, or destroying a MIDlet.</p>
 * 
 * <p>There are two constructors available:</p>
 * <ul>
 *   <li>{@link #MIDletStateChangeException()}: Constructs a new exception 
 *       with {@code null} as its detail message.</li>
 *   <li>{@link #MIDletStateChangeException(String)}: Constructs a new 
 *       exception with the specified detail message.</li>
 * </ul>
 * 
 * @see Exception
 */
public class MIDletStateChangeException extends Exception {
    private static final long serialVersionUID = 1;

    public MIDletStateChangeException() {
    }

    public MIDletStateChangeException(String s) {
        super(s);
    }
}
