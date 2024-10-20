.class public Lcom/uc/paymentsdk/network/HttpClientFactory;
.super Ljava/lang/Object;
.source "HttpClientFactory.java"

.field private final static DEFAULT_SIZE:I = 2

.field private final static SDK_CLIENT:Ljava/lang/String; = "sdk"

.field private static mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;

.field private mHttpClientMap:Ljava/util/WeakHashMap;
  .annotation system Ldalvik/annotation/Signature;
    value = {
      "Ljava/util/WeakHashMap",
      "<",
      "Ljava/lang/String;",
      "Lcom/uc/paymentsdk/network/AndroidHttpClient;",
      ">;"
    }
  .end annotation
.end field

.method private constructor <init>()V
  .catchall { :L0 .. :L2 } :L1
  .registers 3
  .prologue
  .line 13
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 15
    monitor-enter p0
  :L0
  .line 17
    new-instance v0, Ljava/util/WeakHashMap;
    const/4 v1, 2
    invoke-direct { v0, v1 }, Ljava/util/WeakHashMap;-><init>(I)V
    iput-object v0, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;
  .line 15
    monitor-exit p0
  .line 19
    return-void
  :L1
  .line 15
    move-exception v0
    monitor-exit p0
  :L2
    throw v0
.end method

.method public static get()Lcom/uc/paymentsdk/network/HttpClientFactory;
  .registers 1
  .prologue
  .line 23
    sget-object v0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;
    if-nez v0, :L0
  .line 24
    new-instance v0, Lcom/uc/paymentsdk/network/HttpClientFactory;
    invoke-direct { v0 }, Lcom/uc/paymentsdk/network/HttpClientFactory;-><init>()V
    sput-object v0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;
  :L0
  .line 25
    sget-object v0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;
    return-object v0
.end method

.method public declared-synchronized close()V
  .catchall { :L0 .. :L2 } :L3
  .registers 4
  .prologue
  .line 50
    monitor-enter p0
  :L0
    iget-object v1, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;
    const-string v2, "sdk"
    invoke-virtual { v1, v2 }, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, :L1
  .line 52
    iget-object v1, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;
    const-string v2, "sdk"
    invoke-virtual { v1, v2 }, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;
  .line 53
  .local v0, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    if-eqz v0, :L1
  .line 55
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/AndroidHttpClient;->close()V
  :L1
  .line 59
  .end local v0
    iget-object v1, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;
    invoke-virtual { v1 }, Ljava/util/WeakHashMap;->clear()V
  .line 60
    const/4 v1, 0
    sput-object v1, Lcom/uc/paymentsdk/network/HttpClientFactory;->mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;
  :L2
  .line 61
    monitor-exit p0
    return-void
  :L3
  .line 50
    move-exception v1
    monitor-exit p0
    throw v1
.end method

.method public declared-synchronized getSDKHttpClient(Ljava/lang/String;)Lcom/uc/paymentsdk/network/AndroidHttpClient;
  .parameter "paramString" # Ljava/lang/String;
  .catchall { :L0 .. :L1 } :L5
  .catchall { :L3 .. :L4 } :L5
  .registers 6
  .prologue
  .line 30
    monitor-enter p0
  :L0
    iget-object v2, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;
    const-string v3, "sdk"
    invoke-virtual { v2, v3 }, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, :L3
  .line 32
    iget-object v2, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;
    const-string v3, "sdk"
    invoke-virtual { v2, v3 }, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;
  :L1
  .line 33
  .local v0, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    if-eqz v0, :L3
    move-object v1, v0
  :L2
  .line 38
  .end local v0
  .local v1, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    monitor-exit p0
    return-object v1
  :L3
  .line 36
  .end local v1
    invoke-static { p1 }, Lcom/uc/paymentsdk/network/AndroidHttpClient;->newInstance(Ljava/lang/String;)Lcom/uc/paymentsdk/network/AndroidHttpClient;
    move-result-object v0
  .line 37
  .restart local v0
    iget-object v2, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;
    const-string v3, "sdk"
    invoke-virtual { v2, v3, v0 }, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
  :L4
    move-object v1, v0
  .line 38
  .end local v0
  .restart local v1
    goto :L2
  :L5
  .line 30
  .end local v1
    move-exception v2
    monitor-exit p0
    throw v2
.end method

.method public updateUserAgent(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 5
  .prologue
  .line 43
    iget-object v1, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;
    const-string v2, "sdk"
    invoke-virtual { v1, v2 }, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;
  .line 44
  .local v0, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    if-eqz v0, :L0
  .line 45
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/network/AndroidHttpClient;->getParams()Lorg/apache/http/params/HttpParams;
    move-result-object v1
    invoke-static { v1, p1 }, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
  :L0
  .line 46
    return-void
.end method
