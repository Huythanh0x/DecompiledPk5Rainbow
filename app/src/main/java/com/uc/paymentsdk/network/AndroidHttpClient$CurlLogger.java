package com.uc.paymentsdk.network;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;

private class CurlLogger implements HttpRequestInterceptor
{
    final AndroidHttpClient this$0;
    
    private CurlLogger(final AndroidHttpClient this$0) {
        this.this$0 = this$0;
        super();
    }
    
    CurlLogger(final AndroidHttpClient androidHttpClient, final CurlLogger curlLogger) {
        this(androidHttpClient);
    }
    
    public void process(final HttpRequest httpRequest, final HttpContext httpContext) throws HttpException, IOException {
        final LoggingConfiguration access$0 = AndroidHttpClient.access$0(this.this$0);
        if (access$0 != null && access$0.isLoggable() && httpRequest instanceof HttpUriRequest) {
            access$0.println(((HttpUriRequest)httpRequest).getURI().getPath());
        }
    }
}
