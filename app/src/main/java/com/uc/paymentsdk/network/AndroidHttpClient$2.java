package com.uc.paymentsdk.network.AndroidHttpClient$2;
import org.apache.http.impl.client.DefaultHttpClient;
import com.uc.paymentsdk.network.AndroidHttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.auth.AuthSchemeRegistry;
import java.lang.String;
import java.lang.Object;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.CookieStore;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.HttpRequestInterceptor;
import com.uc.paymentsdk.network.AndroidHttpClient$CurlLogger;

class AndroidHttpClient$2 extends DefaultHttpClient	// class@00009a from classes.dex
{
    final AndroidHttpClient this$0;

    void AndroidHttpClient$2(AndroidHttpClient p0,ClientConnectionManager $anonymous0,HttpParams $anonymous1){
       this.this$0 = p0;
       super($anonymous0, $anonymous1);
    }
    protected HttpContext createHttpContext(){
       BasicHttpContext localBasicHttpContext = new BasicHttpContext();
       localBasicHttpContext.setAttribute("http.authscheme-registry", this.getAuthSchemes());
       localBasicHttpContext.setAttribute("http.cookiespec-registry", this.getCookieSpecs());
       localBasicHttpContext.setAttribute("http.auth.credentials-provider", this.getCredentialsProvider());
       localBasicHttpContext.setAttribute("http.cookie-store", this.getCookieStore());
       return localBasicHttpContext;
    }
    protected BasicHttpProcessor createHttpProcessor(){
       BasicHttpProcessor localBasicHttpProcessor = super.createHttpProcessor();
       localBasicHttpProcessor.addRequestInterceptor(AndroidHttpClient.access$1());
       localBasicHttpProcessor.addRequestInterceptor(new AndroidHttpClient$CurlLogger(this.this$0, null));
       return localBasicHttpProcessor;
    }
}
