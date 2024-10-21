package javax.microedition.rms;

public interface RecordComparator {
  public static final int EQUIVALENT = 0;
  
  public static final int FOLLOWS = 1;
  
  public static final int PRECEDES = -1;
  
  int compare(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2);
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/rms/RecordComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */