.class Lcom/uc/paymentsdk/network/AndroidHttpClient$2;
.super Lorg/apache/http/impl/client/DefaultHttpClient;
.source "AndroidHttpClient.java"

.annotation system Ldalvik/annotation/EnclosingMethod;
  value = Lcom/uc/paymentsdk/network/AndroidHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 0
  name = null
.end annotation

.field final synthetic this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;

.method constructor <init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
  .parameter # Lcom/uc/paymentsdk/network/AndroidHttpClient;
  .parameter "$anonymous0" # Lorg/apache/http/conn/ClientConnectionManager;
  .parameter "$anonymous1" # Lorg/apache/http/params/HttpParams;
  .registers 4
  .prologue
  .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$2;->this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;
  .line 103
    invoke-direct { p0, p2, p3 }, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    return-void
.end method

.method protected createHttpContext()Lorg/apache/http/protocol/HttpContext;
  .registers 4
  .prologue
  .line 117
    new-instance v0, Lorg/apache/http/protocol/BasicHttpContext;
    invoke-direct { v0 }, Lorg/apache/http/protocol/BasicHttpContext;-><init>()V
  .line 118
  .local v0, "localBasicHttpContext":Lorg/apache/http/protocol/BasicHttpContext;
    const-string v1, "http.authscheme-registry"
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$2;->getAuthSchemes()Lorg/apache/http/auth/AuthSchemeRegistry;
    move-result-object v2
    invoke-virtual { v0, v1, v2 }, Lorg/apache/http/protocol/BasicHttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
  .line 119
    const-string v1, "http.cookiespec-registry"
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$2;->getCookieSpecs()Lorg/apache/http/cookie/CookieSpecRegistry;
    move-result-object v2
    invoke-virtual { v0, v1, v2 }, Lorg/apache/http/protocol/BasicHttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
  .line 120
    const-string v1, "http.auth.credentials-provider"
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$2;->getCredentialsProvider()Lorg/apache/http/client/CredentialsProvider;
    move-result-object v2
    invoke-virtual { v0, v1, v2 }, Lorg/apache/http/protocol/BasicHttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
  .line 121
    const-string v1, "http.cookie-store"
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$2;->getCookieStore()Lorg/apache/http/client/CookieStore;
    move-result-object v2
    invoke-virtual { v0, v1, v2 }, Lorg/apache/http/protocol/BasicHttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
  .line 122
    return-object v0
.end method

.method protected createHttpProcessor()Lorg/apache/http/protocol/BasicHttpProcessor;
  .registers 5
  .prologue
  .line 108
    invoke-super { p0 }, Lorg/apache/http/impl/client/DefaultHttpClient;->createHttpProcessor()Lorg/apache/http/protocol/BasicHttpProcessor;
    move-result-object v0
  .line 109
  .local v0, "localBasicHttpProcessor":Lorg/apache/http/protocol/BasicHttpProcessor;
    invoke-static { }, Lcom/uc/paymentsdk/network/AndroidHttpClient;->access$1()Lorg/apache/http/HttpRequestInterceptor;
    move-result-object v1
    invoke-virtual { v0, v1 }, Lorg/apache/http/protocol/BasicHttpProcessor;->addRequestInterceptor(Lorg/apache/http/HttpRequestInterceptor;)V
  .line 110
    new-instance v1, Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;
    iget-object v2, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$2;->this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;
    const/4 v3, 0
    invoke-direct { v1, v2, v3 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;-><init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;)V
    invoke-virtual { v0, v1 }, Lorg/apache/http/protocol/BasicHttpProcessor;->addRequestInterceptor(Lorg/apache/http/HttpRequestInterceptor;)V
  .line 111
    return-object v0
.end method
