.class Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;
.super Ljava/lang/Object;
.source "AndroidHttpClient.java"

# interfaces
.implements Lorg/apache/http/HttpRequestInterceptor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uc/paymentsdk/network/AndroidHttpClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CurlLogger"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;


# direct methods
.method private constructor <init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;)V
    .locals 0

    .prologue
    .line 387
    iput-object p1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;->this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;

    .line 386
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 388
    return-void
.end method

.method synthetic constructor <init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;)V
    .locals 0

    .prologue
    .line 386
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;-><init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;)V

    return-void
.end method


# virtual methods
.method public process(Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)V
    .locals 2
    .param p1, "paramHttpRequest"    # Lorg/apache/http/HttpRequest;
    .param p2, "paramHttpContext"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/apache/http/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 394
    iget-object v1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;->this$0:Lcom/uc/paymentsdk/network/AndroidHttpClient;

    invoke-static {v1}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->access$0(Lcom/uc/paymentsdk/network/AndroidHttpClient;)Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;

    move-result-object v0

    .line 395
    .local v0, "localLoggingConfiguration":Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;
    if-eqz v0, :cond_0

    invoke-static {v0}, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->access$0(Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;)Z

    move-result v1

    if-eqz v1, :cond_0

    instance-of v1, p1, Lorg/apache/http/client/methods/HttpUriRequest;

    if-eqz v1, :cond_0

    .line 396
    check-cast p1, Lorg/apache/http/client/methods/HttpUriRequest;

    .end local p1    # "paramHttpRequest":Lorg/apache/http/HttpRequest;
    invoke-interface {p1}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->access$1(Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;Ljava/lang/String;)V

    .line 397
    :cond_0
    return-void
.end method
