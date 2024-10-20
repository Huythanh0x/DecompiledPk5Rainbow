package javax.microedition.rms;

public interface ExtendedRecordListener extends RecordListener {
   int RECORDSTORE_CLOSE = 9;
   int RECORDSTORE_DELETE = 10;
   int RECORDSTORE_OPEN = 8;
   int RECORD_ADD = 1;
   int RECORD_CHANGE = 3;
   int RECORD_DELETE = 4;
   int RECORD_READ = 2;

   void recordEvent(int var1, long var2, RecordStore var4, int var5);

   void recordStoreEvent(int var1, long var2, String var4);
}
