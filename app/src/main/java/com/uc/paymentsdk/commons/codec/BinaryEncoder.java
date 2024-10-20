/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.commons.codec.Encoder
 *  com.uc.paymentsdk.commons.codec.EncoderException
 */
package com.uc.paymentsdk.commons.codec;

import com.uc.paymentsdk.commons.codec.Encoder;
import com.uc.paymentsdk.commons.codec.EncoderException;

public interface BinaryEncoder
extends Encoder {
    public byte[] encode(byte[] var1) throws EncoderException;
}
