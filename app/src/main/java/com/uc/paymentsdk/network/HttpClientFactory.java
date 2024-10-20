package com.uc.paymentsdk.network;

import org.apache.http.params.HttpProtocolParams;
import java.util.WeakHashMap;

public class HttpClientFactory
{
    private static final int DEFAULT_SIZE = 2;
    private static final String SDK_CLIENT = "sdk";
    private static HttpClientFactory mInstance;
    private WeakHashMap<String, AndroidHttpClient> mHttpClientMap;
    
    private HttpClientFactory() {
        super();
        synchronized (this) {
            this.mHttpClientMap = new WeakHashMap<String, AndroidHttpClient>(2);
        }
    }
    
    public static HttpClientFactory get() {
        if (HttpClientFactory.mInstance == null) {
            HttpClientFactory.mInstance = new HttpClientFactory();
        }
        return HttpClientFactory.mInstance;
    }
    
    public void close() {
        synchronized (this) {
            if (this.mHttpClientMap.containsKey("sdk")) {
                final AndroidHttpClient androidHttpClient = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
                if (androidHttpClient != null) {
                    androidHttpClient.close();
                }
            }
            this.mHttpClientMap.clear();
            HttpClientFactory.mInstance = null;
        }
    }
    
    public AndroidHttpClient getSDKHttpClient(final String s) {
        synchronized (this) {
            Label_0037: {
                if (!this.mHttpClientMap.containsKey("sdk")) {
                    break Label_0037;
                }
                final AndroidHttpClient androidHttpClient = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
                if (androidHttpClient == null) {
                    break Label_0037;
                }
                return androidHttpClient;
            }
            final AndroidHttpClient instance = AndroidHttpClient.newInstance(s);
            this.mHttpClientMap.put("sdk", instance);
            return instance;
        }
    }
    
    public void updateUserAgent(final String s) {
        final AndroidHttpClient androidHttpClient = (AndroidHttpClient)this.mHttpClientMap.get("sdk");
        if (androidHttpClient != null) {
            HttpProtocolParams.setUserAgent(androidHttpClient.getParams(), s);
        }
    }
}
