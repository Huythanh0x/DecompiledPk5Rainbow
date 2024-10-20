package javax.microedition.media;

/* loaded from: classes.dex */
/**
 * The MediaException class is a custom exception that extends the standard Exception class.
 * It is used to signal media-related errors in the application.
 * 
 * <p>This class provides two constructors:</p>
 * <ul>
 *   <li>A no-argument constructor that creates a MediaException without a detailed message.</li>
 *   <li>A constructor that accepts a string message, which can be used to provide additional details about the exception.</li>
 * </ul>
 * 
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * try {
 *     // some media-related code that might throw a MediaException
 * } catch (MediaException e) {
 *     // handle the exception
 * }
 * }
 * </pre>
 */
public class MediaException extends Exception {
    private static final long serialVersionUID = 1;

    public MediaException() {
    }

    public MediaException(String s) {
        super(s);
    }
}
