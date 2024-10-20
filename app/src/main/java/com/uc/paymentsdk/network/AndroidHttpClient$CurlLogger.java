package com.uc.paymentsdk.network.AndroidHttpClient$CurlLogger;
import org.apache.http.HttpRequestInterceptor;
import com.uc.paymentsdk.network.AndroidHttpClient;
import java.lang.Object;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;
import com.uc.paymentsdk.network.AndroidHttpClient$LoggingConfiguration;
import org.apache.http.client.methods.HttpUriRequest;
import java.net.URI;
import java.lang.String;

class AndroidHttpClient$CurlLogger implements HttpRequestInterceptor	// class@00009b from classes.dex
{
    final AndroidHttpClient this$0;

    private void AndroidHttpClient$CurlLogger(AndroidHttpClient p0){
       this.this$0 = p0;
       super();
    }
    void AndroidHttpClient$CurlLogger(AndroidHttpClient p0,AndroidHttpClient$CurlLogger p1){
       super(p0);
    }
    public void process(HttpRequest paramHttpRequest,HttpContext paramHttpContext){
       AndroidHttpClient$LoggingConfiguration localLoggingConfiguration;
       if ((localLoggingConfiguration = AndroidHttpClient.access$0(this.this$0)) != null && (AndroidHttpClient$LoggingConfiguration.access$0(localLoggingConfiguration) && paramHttpRequest instanceof HttpUriRequest)) {
          AndroidHttpClient$LoggingConfiguration.access$1(localLoggingConfiguration, paramHttpRequest.getURI().getPath());
       }
       return;
    }
}
