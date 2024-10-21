package com.uc.paymentsdk.network;

import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.params.HttpParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

class AndroidHttpClient$2 extends DefaultHttpClient {
    final AndroidHttpClient this$0;
    
    AndroidHttpClient$2(final AndroidHttpClient this$0, final ClientConnectionManager clientConnectionManager, final HttpParams httpParams) {
        this.this$0 = this$0;
        super(clientConnectionManager, httpParams);
    }
    
    protected HttpContext createHttpContext() {
        final BasicHttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute("http.authscheme-registry", (Object)this.getAuthSchemes());
        basicHttpContext.setAttribute("http.cookiespec-registry", (Object)this.getCookieSpecs());
        basicHttpContext.setAttribute("http.auth.credentials-provider", (Object)this.getCredentialsProvider());
        basicHttpContext.setAttribute("http.cookie-store", (Object)this.getCookieStore());
        return (HttpContext)basicHttpContext;
    }
    
    protected BasicHttpProcessor createHttpProcessor() {
        final BasicHttpProcessor httpProcessor = super.createHttpProcessor();
        httpProcessor.addRequestInterceptor(AndroidHttpClient.access$1());
        httpProcessor.addRequestInterceptor((HttpRequestInterceptor)this.this$0.new CurlLogger((CurlLogger)null));
        return httpProcessor;
    }
}