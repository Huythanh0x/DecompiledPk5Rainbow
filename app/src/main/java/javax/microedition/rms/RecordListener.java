package javax.microedition.rms;

public interface RecordListener {
  void recordAdded(RecordStore paramRecordStore, int paramInt);
  
  void recordChanged(RecordStore paramRecordStore, int paramInt);
  
  void recordDeleted(RecordStore paramRecordStore, int paramInt);
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/rms/RecordListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */