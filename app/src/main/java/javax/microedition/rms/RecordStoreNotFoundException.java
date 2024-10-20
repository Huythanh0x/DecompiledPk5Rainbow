/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.rms.RecordStoreException
 */
package javax.microedition.rms;

import javax.microedition.rms.RecordStoreException;

public class RecordStoreNotFoundException
extends RecordStoreException {
    private static final long serialVersionUID = 1L;

    public RecordStoreNotFoundException() {
    }

    public RecordStoreNotFoundException(String string) {
        super(string);
    }
}
