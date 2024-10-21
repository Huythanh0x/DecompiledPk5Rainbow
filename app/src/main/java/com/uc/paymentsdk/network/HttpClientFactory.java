package com.uc.paymentsdk.network;

import java.util.WeakHashMap;
import org.apache.http.params.HttpProtocolParams;

/* loaded from: classes.dex */
public class HttpClientFactory {
    private static final int DEFAULT_SIZE = 2;
    private static final String SDK_CLIENT = "sdk";
    private static HttpClientFactory mInstance;
    private WeakHashMap<String, AndroidHttpClient> mHttpClientMap;

    private HttpClientFactory() {
        synchronized (this) {
            this.mHttpClientMap = new WeakHashMap<>(2);
        }
    }

    public static HttpClientFactory get() {
        if (mInstance == null) {
            mInstance = new HttpClientFactory();
        }
        return mInstance;
    }

    public synchronized AndroidHttpClient getSDKHttpClient(String paramString) {
        AndroidHttpClient localAndroidHttpClient;
        AndroidHttpClient localAndroidHttpClient2;
        if (!this.mHttpClientMap.containsKey(SDK_CLIENT) || (localAndroidHttpClient2 = this.mHttpClientMap.get(SDK_CLIENT)) == null) {
            AndroidHttpClient localAndroidHttpClient3 = AndroidHttpClient.newInstance(paramString);
            this.mHttpClientMap.put(SDK_CLIENT, localAndroidHttpClient3);
            localAndroidHttpClient = localAndroidHttpClient3;
        } else {
            localAndroidHttpClient = localAndroidHttpClient2;
        }
        return localAndroidHttpClient;
    }

    public void updateUserAgent(String paramString) {
        AndroidHttpClient localAndroidHttpClient = this.mHttpClientMap.get(SDK_CLIENT);
        if (localAndroidHttpClient != null) {
            HttpProtocolParams.setUserAgent(localAndroidHttpClient.getParams(), paramString);
        }
    }

    public synchronized void close() {
        AndroidHttpClient localAndroidHttpClient;
        if (this.mHttpClientMap.containsKey(SDK_CLIENT) && (localAndroidHttpClient = this.mHttpClientMap.get(SDK_CLIENT)) != null) {
            localAndroidHttpClient.close();
        }
        this.mHttpClientMap.clear();
        mInstance = null;
    }
}
