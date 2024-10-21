package com.uc.paymentsdk.util;

public interface RegisterDialogListener
{
    void onRegisterDialogCancel(final int p0);
    
    void onRegisterDialogOK(final int p0, final String p1, final String p2, final String p3);
}
