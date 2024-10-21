package com.uc.paymentsdk.commons.codec;

public interface BinaryEncoder extends Encoder {
    byte[] encode(byte[] arg1) throws EncoderException;
}

