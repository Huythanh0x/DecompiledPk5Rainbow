package com.uc.paymentsdk.network;

import android.os.Looper;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;

class AndroidHttpClient$1 implements HttpRequestInterceptor {
    AndroidHttpClient$1() {
        super();
    }
    
    public void process(final HttpRequest httpRequest, final HttpContext httpContext) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("This thread forbids HTTP requests");
        }
    }
}