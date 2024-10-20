package javax.microedition.rms.RecordComparator;

public interface abstract RecordComparator	// class@000156 from classes.dex
{
    public static final int EQUIVALENT = 0;
    public static final int FOLLOWS = 1;
    public static final int PRECEDES = 255;

    int compare(byte[] p0,byte[] p1);
}
