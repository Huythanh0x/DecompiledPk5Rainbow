package com.uc.paymentsdk.util;

public interface ListCheckboxDialogListener
{
    void onListDialogCancel(final int p0, final CharSequence[] p1);
    
    void onListDialogOK(final int p0, final CharSequence[] p1, final int p2, final int p3);
}
