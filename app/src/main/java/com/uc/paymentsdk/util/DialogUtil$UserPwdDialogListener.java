package com.uc.paymentsdk.util;

public interface UserPwdDialogListener
{
    void onUserPwdDialogCancel(final int p0);
    
    void onUserPwdDialogOK(final int p0, final String p1, final String p2, final boolean p3);
    
    void onUserPwdDialogRegister(final int p0);
}
