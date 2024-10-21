package com.uc.paymentsdk.network;

import java.util.WeakHashMap;
import org.apache.http.params.HttpProtocolParams;

public class HttpClientFactory {
    private static final int DEFAULT_SIZE = 2;
    private static final String SDK_CLIENT = "sdk";
    private WeakHashMap mHttpClientMap;
    private static HttpClientFactory mInstance;

    private HttpClientFactory() {
        synchronized(this) {
            this.mHttpClientMap = new WeakHashMap(2);
        }
    }

    public void close() {
        synchronized(this) {
            if(this.mHttpClientMap.containsKey("sdk")) {
                AndroidHttpClient localAndroidHttpClient = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
                if(localAndroidHttpClient != null) {
                    localAndroidHttpClient.close();
                }
            }
            this.mHttpClientMap.clear();
            HttpClientFactory.mInstance = null;
        }
    }

    public static HttpClientFactory get() {
        if(HttpClientFactory.mInstance == null) {
            HttpClientFactory.mInstance = new HttpClientFactory();
        }
        return HttpClientFactory.mInstance;
    }

    public AndroidHttpClient getSDKHttpClient(String paramString) {
        AndroidHttpClient localAndroidHttpClient;
        synchronized(this) {
            if(this.mHttpClientMap.containsKey("sdk")) {
                AndroidHttpClient localAndroidHttpClient = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
                if(localAndroidHttpClient != null) {
                    return localAndroidHttpClient;
                }
                goto label_7;
            }
            else {
            label_7:
                AndroidHttpClient androidHttpClient2 = AndroidHttpClient.newInstance(paramString);
                this.mHttpClientMap.put("sdk", androidHttpClient2);
                localAndroidHttpClient = androidHttpClient2;
            }
            return localAndroidHttpClient;
        }
    }

    public void updateUserAgent(String paramString) {
        AndroidHttpClient localAndroidHttpClient = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
        if(localAndroidHttpClient != null) {
            HttpProtocolParams.setUserAgent(localAndroidHttpClient.getParams(), paramString);
        }
    }
}

