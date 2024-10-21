/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  org.apache.http.HttpRequest
 *  org.apache.http.HttpRequestInterceptor
 *  org.apache.http.protocol.HttpContext
 */
package com.uc.paymentsdk.network;

import android.os.Looper;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

class AndroidHttpClient.1
implements HttpRequestInterceptor {
    AndroidHttpClient.1() {
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("This thread forbids HTTP requests");
        }
    }
}
