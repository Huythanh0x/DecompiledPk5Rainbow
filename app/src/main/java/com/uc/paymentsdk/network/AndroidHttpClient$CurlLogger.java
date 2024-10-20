/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.AndroidHttpClient
 *  com.uc.paymentsdk.network.AndroidHttpClient$LoggingConfiguration
 *  org.apache.http.HttpException
 *  org.apache.http.HttpRequest
 *  org.apache.http.HttpRequestInterceptor
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.protocol.HttpContext
 */
package com.uc.paymentsdk.network;

import com.uc.paymentsdk.network.AndroidHttpClient;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

private class AndroidHttpClient.CurlLogger
implements HttpRequestInterceptor {
    final AndroidHttpClient this$0;

    private AndroidHttpClient.CurlLogger(AndroidHttpClient androidHttpClient) {
        this.this$0 = androidHttpClient;
    }

    /* synthetic */ AndroidHttpClient.CurlLogger(AndroidHttpClient androidHttpClient, AndroidHttpClient.CurlLogger curlLogger) {
        this(androidHttpClient);
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        httpContext = AndroidHttpClient.access$0((AndroidHttpClient)this.this$0);
        if (httpContext != null && AndroidHttpClient.LoggingConfiguration.access$0((AndroidHttpClient.LoggingConfiguration)httpContext) && httpRequest instanceof HttpUriRequest) {
            AndroidHttpClient.LoggingConfiguration.access$1((AndroidHttpClient.LoggingConfiguration)httpContext, (String)((HttpUriRequest)httpRequest).getURI().getPath());
        }
    }
}
