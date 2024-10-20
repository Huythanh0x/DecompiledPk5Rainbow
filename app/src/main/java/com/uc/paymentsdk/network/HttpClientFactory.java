/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  com.uc.paymentsdk.network.AndroidHttpClient
 *  org.apache.http.params.HttpParams
 *  org.apache.http.params.HttpProtocolParams
 */
package com.uc.paymentsdk.network;

import com.uc.paymentsdk.network.AndroidHttpClient;
import java.util.WeakHashMap;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpClientFactory {
    private static final int DEFAULT_SIZE = 2;
    private static final String SDK_CLIENT = "sdk";
    private static HttpClientFactory mInstance;
    private WeakHashMap<String, AndroidHttpClient> mHttpClientMap;

    /*
     * Enabled unnecessary exception pruning
     */
    private HttpClientFactory() {
        // MONITORENTER : this
        WeakHashMap<K, V> weakHashMap = new WeakHashMap<K, V>(2);
        this.mHttpClientMap = weakHashMap;
        // MONITOREXIT : this
    }

    public static HttpClientFactory get() {
        if (mInstance == null) {
            mInstance = new HttpClientFactory();
        }
        return mInstance;
    }

    public void close() {
        AndroidHttpClient androidHttpClient;
        // MONITORENTER : this
        if (this.mHttpClientMap.containsKey(SDK_CLIENT) && (androidHttpClient = this.mHttpClientMap.get(SDK_CLIENT)) != null) {
            androidHttpClient.close();
        }
        this.mHttpClientMap.clear();
        mInstance = null;
        // MONITOREXIT : this
        return;
    }

    /*
     * Enabled force condition propagation
     */
    public AndroidHttpClient getSDKHttpClient(String string) {
        block6: {
            AndroidHttpClient androidHttpClient;
            // MONITORENTER : this
            if (!this.mHttpClientMap.containsKey(SDK_CLIENT) || (androidHttpClient = this.mHttpClientMap.get(SDK_CLIENT)) == null) break block6;
            return androidHttpClient;
        }
        string = AndroidHttpClient.newInstance((String)string);
        this.mHttpClientMap.put(SDK_CLIENT, (AndroidHttpClient)string);
        return string;
    }

    public void updateUserAgent(String string) {
        AndroidHttpClient androidHttpClient = this.mHttpClientMap.get(SDK_CLIENT);
        if (androidHttpClient != null) {
            HttpProtocolParams.setUserAgent((HttpParams)androidHttpClient.getParams(), (String)string);
        }
    }
}
