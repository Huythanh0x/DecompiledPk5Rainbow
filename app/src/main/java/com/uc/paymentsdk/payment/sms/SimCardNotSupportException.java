package com.uc.paymentsdk.payment.sms;

public class SimCardNotSupportException extends Exception
{
    private static final long serialVersionUID = 138909963862716722L;
    
    public SimCardNotSupportException(final String message) {
        super(message);
    }
}
