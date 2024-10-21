package javax.microedition.rms.RecordListener;
import javax.microedition.rms.RecordStore;

public interface abstract RecordListener	// class@000159 from classes.dex
{

    void recordAdded(RecordStore p0,int p1);
    void recordChanged(RecordStore p0,int p1);
    void recordDeleted(RecordStore p0,int p1);
}
