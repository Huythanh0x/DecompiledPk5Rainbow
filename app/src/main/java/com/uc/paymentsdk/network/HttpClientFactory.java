package com.uc.paymentsdk.network.HttpClientFactory;
import java.lang.Object;
import java.util.WeakHashMap;
import com.uc.paymentsdk.network.AndroidHttpClient;
import java.lang.String;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpClientFactory	// class@0000a1 from classes.dex
{
    private WeakHashMap mHttpClientMap;
    private static final int DEFAULT_SIZE = 2;
    private static final String SDK_CLIENT = "sdk";
    private static HttpClientFactory mInstance;

    private void HttpClientFactory(){
       super();
       _monitor_enter(this);
       this.mHttpClientMap = new WeakHashMap(2);
       _monitor_exit(this);
    }
    public static HttpClientFactory get(){
       if (HttpClientFactory.mInstance == null) {
          HttpClientFactory.mInstance = new HttpClientFactory();
       }
       return HttpClientFactory.mInstance;
    }
    public synchronized void close(){
       AndroidHttpClient uAndroidHttp;
       if (this.mHttpClientMap.containsKey("sdk") && (uAndroidHttp = this.mHttpClientMap.get("sdk")) != null) {
          uAndroidHttp.close();
       }
       this.mHttpClientMap.clear();
       HttpClientFactory.mInstance = null;
       return;
    }
    public synchronized AndroidHttpClient getSDKHttpClient(String paramString){
       AndroidHttpClient uAndroidHttp;
       AndroidHttpClient localAndroidHttpClient;
       if (this.mHttpClientMap.containsKey("sdk") && (uAndroidHttp = this.mHttpClientMap.get("sdk")) != null) {
          localAndroidHttpClient = uAndroidHttp;
       }else {
          uAndroidHttp = AndroidHttpClient.newInstance(paramString);
          this.mHttpClientMap.put("sdk", localAndroidHttpClient);
          localAndroidHttpClient = localAndroidHttpClient;
       }
       return localAndroidHttpClient;
    }
    public void updateUserAgent(String paramString){
       AndroidHttpClient uAndroidHttp;
       if ((uAndroidHttp = this.mHttpClientMap.get("sdk")) != null) {
          HttpProtocolParams.setUserAgent(uAndroidHttp.getParams(), paramString);
       }
       return;
    }
}
