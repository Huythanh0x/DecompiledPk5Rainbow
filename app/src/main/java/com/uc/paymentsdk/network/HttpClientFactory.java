package com.uc.paymentsdk.network;

import java.util.WeakHashMap;
import org.apache.http.params.HttpProtocolParams;

public class HttpClientFactory {
  private static final int DEFAULT_SIZE = 2;
  
  private static final String SDK_CLIENT = "sdk";
  
  private static HttpClientFactory mInstance;
  
  private WeakHashMap<String, AndroidHttpClient> mHttpClientMap;
  
  private HttpClientFactory() {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial <init> : ()V
    //   4: aload_0
    //   5: monitorenter
    //   6: new java/util/WeakHashMap
    //   9: astore_1
    //   10: aload_1
    //   11: iconst_2
    //   12: invokespecial <init> : (I)V
    //   15: aload_0
    //   16: aload_1
    //   17: putfield mHttpClientMap : Ljava/util/WeakHashMap;
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   6	22	23	finally
    //   24	26	23	finally
  }
  
  public static HttpClientFactory get() {
    if (mInstance == null)
      mInstance = new HttpClientFactory(); 
    return mInstance;
  }
  
  public void close() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mHttpClientMap : Ljava/util/WeakHashMap;
    //   6: ldc 'sdk'
    //   8: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   11: ifeq -> 35
    //   14: aload_0
    //   15: getfield mHttpClientMap : Ljava/util/WeakHashMap;
    //   18: ldc 'sdk'
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/uc/paymentsdk/network/AndroidHttpClient
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -> 35
    //   31: aload_1
    //   32: invokevirtual close : ()V
    //   35: aload_0
    //   36: getfield mHttpClientMap : Ljava/util/WeakHashMap;
    //   39: invokevirtual clear : ()V
    //   42: aconst_null
    //   43: putstatic com/uc/paymentsdk/network/HttpClientFactory.mInstance : Lcom/uc/paymentsdk/network/HttpClientFactory;
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	49	finally
    //   31	35	49	finally
    //   35	46	49	finally
  }
  
  public AndroidHttpClient getSDKHttpClient(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mHttpClientMap : Ljava/util/WeakHashMap;
    //   6: ldc 'sdk'
    //   8: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   11: ifeq -> 37
    //   14: aload_0
    //   15: getfield mHttpClientMap : Ljava/util/WeakHashMap;
    //   18: ldc 'sdk'
    //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast com/uc/paymentsdk/network/AndroidHttpClient
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull -> 37
    //   31: aload_2
    //   32: astore_1
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_1
    //   36: areturn
    //   37: aload_1
    //   38: invokestatic newInstance : (Ljava/lang/String;)Lcom/uc/paymentsdk/network/AndroidHttpClient;
    //   41: astore_1
    //   42: aload_0
    //   43: getfield mHttpClientMap : Ljava/util/WeakHashMap;
    //   46: ldc 'sdk'
    //   48: aload_1
    //   49: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   52: pop
    //   53: goto -> 33
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Exception table:
    //   from	to	target	type
    //   2	27	56	finally
    //   37	53	56	finally
  }
  
  public void updateUserAgent(String paramString) {
    AndroidHttpClient androidHttpClient = this.mHttpClientMap.get("sdk");
    if (androidHttpClient != null)
      HttpProtocolParams.setUserAgent(androidHttpClient.getParams(), paramString); 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/HttpClientFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */