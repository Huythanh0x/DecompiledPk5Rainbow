package com.uc.paymentsdk.network.AndroidHttpClient$1;
import org.apache.http.HttpRequestInterceptor;
import java.lang.Object;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;
import android.os.Looper;
import java.lang.RuntimeException;
import java.lang.String;

class AndroidHttpClient$1 implements HttpRequestInterceptor	// class@000099 from classes.dex
{

    void AndroidHttpClient$1(){
       super();
    }
    public void process(HttpRequest paramHttpRequest,HttpContext paramHttpContext){
       if (Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper()) {
          throw new RuntimeException("This thread forbids HTTP requests");
       }
       return;
    }
}
