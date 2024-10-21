package com.uc.paymentsdk.commons.codec;

public interface BinaryEncoder extends Encoder {
   byte[] encode(byte[] var1) throws EncoderException;
}
