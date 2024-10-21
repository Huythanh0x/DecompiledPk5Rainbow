package com.uc.paymentsdk.util;

public interface RatingDialogListener
{
    void onRatingDialogCancel();
    
    void onRatingDialogOK(final int p0, final float p1);
}
