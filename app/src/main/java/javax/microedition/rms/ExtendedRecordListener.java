package javax.microedition.rms;

public interface ExtendedRecordListener extends RecordListener {
  public static final int RECORDSTORE_CLOSE = 9;
  
  public static final int RECORDSTORE_DELETE = 10;
  
  public static final int RECORDSTORE_OPEN = 8;
  
  public static final int RECORD_ADD = 1;
  
  public static final int RECORD_CHANGE = 3;
  
  public static final int RECORD_DELETE = 4;
  
  public static final int RECORD_READ = 2;
  
  void recordEvent(int paramInt1, long paramLong, RecordStore paramRecordStore, int paramInt2);
  
  void recordStoreEvent(int paramInt, long paramLong, String paramString);
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/rms/ExtendedRecordListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */