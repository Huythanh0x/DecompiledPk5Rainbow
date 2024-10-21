/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.AndroidHttpClient
 *  com.uc.paymentsdk.network.AndroidHttpClient$CurlLogger
 *  org.apache.http.HttpRequestInterceptor
 *  org.apache.http.conn.ClientConnectionManager
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.params.HttpParams
 *  org.apache.http.protocol.BasicHttpContext
 *  org.apache.http.protocol.BasicHttpProcessor
 *  org.apache.http.protocol.HttpContext
 */
package com.uc.paymentsdk.network;

import com.uc.paymentsdk.network.AndroidHttpClient;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

class AndroidHttpClient.2
extends DefaultHttpClient {
    final AndroidHttpClient this$0;

    AndroidHttpClient.2(AndroidHttpClient androidHttpClient, ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.this$0 = androidHttpClient;
        super(clientConnectionManager, httpParams);
    }

    protected HttpContext createHttpContext() {
        BasicHttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute("http.authscheme-registry", (Object)this.getAuthSchemes());
        basicHttpContext.setAttribute("http.cookiespec-registry", (Object)this.getCookieSpecs());
        basicHttpContext.setAttribute("http.auth.credentials-provider", (Object)this.getCredentialsProvider());
        basicHttpContext.setAttribute("http.cookie-store", (Object)this.getCookieStore());
        return basicHttpContext;
    }

    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor basicHttpProcessor = super.createHttpProcessor();
        basicHttpProcessor.addRequestInterceptor(AndroidHttpClient.access$1());
        basicHttpProcessor.addRequestInterceptor((HttpRequestInterceptor)new AndroidHttpClient.CurlLogger(this.this$0, null));
        return basicHttpProcessor;
    }
}
