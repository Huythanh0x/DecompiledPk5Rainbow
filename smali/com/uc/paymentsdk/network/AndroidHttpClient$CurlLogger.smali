.class Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;
.super Ljava/lang/Object;
.implements Lorg/apache/http/HttpRequestInterceptor;
.source "AndroidHttpClient.java"

.annotation system Ldalvik/annotation/EnclosingClass;
  value = Lcom/uc/paymentsdk/network/AndroidHttpClient;
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 2
  name = "CurlLogger"
.end annotation

.field final synthetic this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;

.method private constructor <init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;)V
  .registers 2
  .prologue
  .line 387
    iput-object p1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;->this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;
  .line 386
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 388
    return-void
.end method

.method synthetic constructor <init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;)V
  .registers 3
  .prologue
  .line 386
    invoke-direct { p0, p1 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;-><init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;)V
    return-void
.end method

.method public process(Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lorg/apache/http/HttpException;,
      Ljava/io/IOException;
    }
  .end annotation
  .parameter "paramHttpRequest" # Lorg/apache/http/HttpRequest;
  .parameter "paramHttpContext" # Lorg/apache/http/protocol/HttpContext;
  .registers 5
  .prologue
  .line 394
    iget-object v1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;->this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;
    invoke-static { v1 }, Lcom/uc/paymentsdk/network/AndroidHttpClient;->access$0(Lcom/uc/paymentsdk/network/AndroidHttpClient;)Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;
    move-result-object v0
  .line 395
  .local v0, "localLoggingConfiguration":Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;
    if-eqz v0, :L0
    invoke-static { v0 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->access$0(Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;)Z
    move-result v1
    if-eqz v1, :L0
    instance-of v1, p1, Lorg/apache/http/client/methods/HttpUriRequest;
    if-eqz v1, :L0
  .line 396
    check-cast p1, Lorg/apache/http/client/methods/HttpUriRequest;
  .end local p1
    invoke-interface { p1 }, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/net/URI;->getPath()Ljava/lang/String;
    move-result-object v1
    invoke-static { v0, v1 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->access$1(Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;Ljava/lang/String;)V
  :L0
  .line 397
    return-void
.end method
