package javax.microedition.io;

import java.io.IOException;

/* loaded from: classes.dex */
/**
 * The {@code Connection} interface defines a method for closing a connection.
 * Implementations of this interface are expected to provide the logic for
 * releasing any resources associated with the connection.
 */
public interface Connection {
    void close() throws IOException;
}
