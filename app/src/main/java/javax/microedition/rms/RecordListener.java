/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStore
 */
package javax.microedition.rms;

import javax.microedition.rms.RecordStore;

public interface RecordListener {
    public void recordAdded(RecordStore var1, int var2);

    public void recordChanged(RecordStore var1, int var2);

    public void recordDeleted(RecordStore var1, int var2);
}
