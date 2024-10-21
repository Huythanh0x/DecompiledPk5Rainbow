/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.commons.codec.Decoder
 *  com.uc.paymentsdk.commons.codec.DecoderException
 */
package com.uc.paymentsdk.commons.codec;

import com.uc.paymentsdk.commons.codec.Decoder;
import com.uc.paymentsdk.commons.codec.DecoderException;

public interface BinaryDecoder
extends Decoder {
    public byte[] decode(byte[] var1) throws DecoderException;
}
