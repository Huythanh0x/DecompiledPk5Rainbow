.class public Lcom/uc/paymentsdk/network/HttpClientFactory;
.super Ljava/lang/Object;
.source "HttpClientFactory.java"


# static fields
.field private static final DEFAULT_SIZE:I = 0x2

.field private static final SDK_CLIENT:Ljava/lang/String; = "sdk"

.field private static mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;


# instance fields
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


# direct methods
.method private constructor <init>()V
    .registers 3

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    monitor-enter p0

    .line 17
    :try_start_4
    new-instance v0, Ljava/util/WeakHashMap;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Ljava/util/WeakHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;

    .line 15
    monitor-exit p0

    .line 19
    return-void

    .line 15
    :catchall_e
    move-exception v0

    monitor-exit p0
    :try_end_10
    .catchall {:try_start_4 .. :try_end_10} :catchall_e

    throw v0
.end method

.method public static get()Lcom/uc/paymentsdk/network/HttpClientFactory;
    .registers 1

    .prologue
    .line 23
    sget-object v0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;

    if-nez v0, :cond_b

    .line 24
    new-instance v0, Lcom/uc/paymentsdk/network/HttpClientFactory;

    invoke-direct {v0}, Lcom/uc/paymentsdk/network/HttpClientFactory;-><init>()V

    sput-object v0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;

    .line 25
    :cond_b
    sget-object v0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;

    return-object v0
.end method


# virtual methods
.method public declared-synchronized close()V
    .registers 4

    .prologue
    .line 50
    monitor-enter p0

    :try_start_1
    iget-object v1, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;

    const-string v2, "sdk"

    invoke-virtual {v1, v2}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1a

    .line 52
    iget-object v1, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;

    const-string v2, "sdk"

    invoke-virtual {v1, v2}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;

    .line 53
    .local v0, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    if-eqz v0, :cond_1a

    .line 55
    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->close()V

    .line 59
    .end local v0    # "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    :cond_1a
    iget-object v1, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;

    invoke-virtual {v1}, Ljava/util/WeakHashMap;->clear()V

    .line 60
    const/4 v1, 0x0

    sput-object v1, Lcom/uc/paymentsdk/network/HttpClientFactory;->mInstance:Lcom/uc/paymentsdk/network/HttpClientFactory;
    :try_end_22
    .catchall {:try_start_1 .. :try_end_22} :catchall_24

    .line 61
    monitor-exit p0

    return-void

    .line 50
    :catchall_24
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public declared-synchronized getSDKHttpClient(Ljava/lang/String;)Lcom/uc/paymentsdk/network/AndroidHttpClient;
    .registers 6
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 30
    monitor-enter p0

    :try_start_1
    iget-object v2, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;

    const-string v3, "sdk"

    invoke-virtual {v2, v3}, Ljava/util/WeakHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1a

    .line 32
    iget-object v2, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;

    const-string v3, "sdk"

    invoke-virtual {v2, v3}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;
    :try_end_15
    .catchall {:try_start_1 .. :try_end_15} :catchall_27

    .line 33
    .local v0, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    if-eqz v0, :cond_1a

    move-object v1, v0

    .line 38
    .end local v0    # "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    .local v1, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    :goto_18
    monitor-exit p0

    return-object v1

    .line 36
    .end local v1    # "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    :cond_1a
    :try_start_1a
    invoke-static {p1}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->newInstance(Ljava/lang/String;)Lcom/uc/paymentsdk/network/AndroidHttpClient;

    move-result-object v0

    .line 37
    .restart local v0    # "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    iget-object v2, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;

    const-string v3, "sdk"

    invoke-virtual {v2, v3, v0}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_25
    .catchall {:try_start_1a .. :try_end_25} :catchall_27

    move-object v1, v0

    .line 38
    .end local v0    # "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    .restart local v1    # "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    goto :goto_18

    .line 30
    .end local v1    # "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    :catchall_27
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public updateUserAgent(Ljava/lang/String;)V
    .registers 5
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 43
    iget-object v1, p0, Lcom/uc/paymentsdk/network/HttpClientFactory;->mHttpClientMap:Ljava/util/WeakHashMap;

    const-string v2, "sdk"

    invoke-virtual {v1, v2}, Ljava/util/WeakHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;

    .line 44
    .local v0, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    if-eqz v0, :cond_13

    .line 45
    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v1

    invoke-static {v1, p1}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 46
    :cond_13
    return-void
.end method
