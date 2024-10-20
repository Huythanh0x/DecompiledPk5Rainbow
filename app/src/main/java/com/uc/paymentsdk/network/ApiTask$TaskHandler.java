package com.uc.paymentsdk.network;

import org.apache.http.HttpResponse;

public interface TaskHandler
{
    void onError(final int p0, final int p1);
    
    Object onPreHandle(final int p0, final HttpResponse p1);
    
    void onSuccess(final int p0, final Object p1);
}
