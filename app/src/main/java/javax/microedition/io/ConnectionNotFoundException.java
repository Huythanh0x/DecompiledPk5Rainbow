package javax.microedition.io;

/* loaded from: classes.dex */
/**
 * This class represents an exception that is thrown when a connection cannot be found.
 * It extends the {@link java.lang.Exception} class.
 * 
 * <p>There are two constructors available:
 * <ul>
 *   <li>A no-argument constructor that creates a {@code ConnectionNotFoundException} with no detail message.</li>
 *   <li>A constructor that accepts a {@code String} argument to provide a detail message.</li>
 * </ul>
 * 
 * <p>Usage example:
 * <pre>
 * {@code
 * try {
 *     // code that may throw a ConnectionNotFoundException
 * } catch (ConnectionNotFoundException e) {
 *     // handle the exception
 * }
 * }
 * </pre>
 * 
 * @see java.lang.Exception
 */
public class ConnectionNotFoundException extends Exception {
    private static final long serialVersionUID = 1;

    public ConnectionNotFoundException() {
    }

    public ConnectionNotFoundException(String s) {
        super(s);
    }
}
