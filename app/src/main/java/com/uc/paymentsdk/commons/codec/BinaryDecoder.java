package com.uc.paymentsdk.commons.codec;

public interface BinaryDecoder extends Decoder {
   byte[] decode(byte[] var1) throws DecoderException;
}
