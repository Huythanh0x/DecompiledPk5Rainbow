/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStoreException
 */
package javax.microedition.rms;

import javax.microedition.rms.RecordStoreException;

public class RecordStoreNotOpenException
extends RecordStoreException {
    private static final long serialVersionUID = 1L;

    public RecordStoreNotOpenException() {
    }

    public RecordStoreNotOpenException(String string) {
        super(string);
    }
}
