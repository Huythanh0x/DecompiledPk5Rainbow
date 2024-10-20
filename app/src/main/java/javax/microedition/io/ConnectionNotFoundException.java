package javax.microedition.io;

public class ConnectionNotFoundException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    public ConnectionNotFoundException() {
        super();
    }
    
    public ConnectionNotFoundException(final String message) {
        super(message);
    }
}
