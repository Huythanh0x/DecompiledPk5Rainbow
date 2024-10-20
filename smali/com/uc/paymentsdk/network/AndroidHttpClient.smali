.class public final Lcom/uc/paymentsdk/network/AndroidHttpClient;
.super Ljava/lang/Object;
.source "AndroidHttpClient.java"

# interfaces
.implements Lorg/apache/http/client/HttpClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/uc/paymentsdk/network/AndroidHttpClient$CurlLogger;,
        Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;
    }
.end annotation


# static fields
.field public static DEFAULT_SYNC_MIN_GZIP_BYTES:J = 0x0L

.field private static final TAG:Ljava/lang/String; = "AndroidHttpClient"

.field private static final sThreadCheckInterceptor:Lorg/apache/http/HttpRequestInterceptor;


# instance fields
.field private volatile curlConfiguration:Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;

.field private final delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

.field private mIsLoadCookies:Z

.field private mLeakedException:Ljava/lang/RuntimeException;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 51
    const-wide/16 v0, 0x100

    sput-wide v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->DEFAULT_SYNC_MIN_GZIP_BYTES:J

    .line 54
    new-instance v0, Lcom/uc/paymentsdk/network/AndroidHttpClient$1;

    invoke-direct {v0}, Lcom/uc/paymentsdk/network/AndroidHttpClient$1;-><init>()V

    sput-object v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->sThreadCheckInterceptor:Lorg/apache/http/HttpRequestInterceptor;

    .line 48
    return-void
.end method

.method private constructor <init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    .locals 2
    .param p1, "paramClientConnectionManager"    # Lorg/apache/http/conn/ClientConnectionManager;
    .param p2, "paramHttpParams"    # Lorg/apache/http/params/HttpParams;

    .prologue
    .line 101
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mIsLoadCookies:Z

    .line 64
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "AndroidHttpClient created and never closed"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    .line 103
    new-instance v0, Lcom/uc/paymentsdk/network/AndroidHttpClient$2;

    invoke-direct {v0, p0, p1, p2}, Lcom/uc/paymentsdk/network/AndroidHttpClient$2;-><init>(Lcom/uc/paymentsdk/network/AndroidHttpClient;Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    iput-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    .line 125
    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/AndroidHttpClient;)Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->curlConfiguration:Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;

    return-object v0
.end method

.method static synthetic access$1()Lorg/apache/http/HttpRequestInterceptor;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->sThreadCheckInterceptor:Lorg/apache/http/HttpRequestInterceptor;

    return-object v0
.end method

.method public static getCompressedEntity([B)Lorg/apache/http/entity/AbstractHttpEntity;
    .locals 7
    .param p0, "paramArrayOfByte"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 297
    array-length v3, p0

    int-to-long v3, v3

    invoke-static {}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->getMinGzipSize()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 299
    new-instance v0, Lorg/apache/http/entity/ByteArrayEntity;

    invoke-direct {v0, p0}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V

    .line 310
    .local v0, "localByteArrayEntity":Lorg/apache/http/entity/ByteArrayEntity;
    :goto_0
    return-object v0

    .line 303
    .end local v0    # "localByteArrayEntity":Lorg/apache/http/entity/ByteArrayEntity;
    :cond_0
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 304
    .local v1, "localByteArrayOutputStream":Ljava/io/ByteArrayOutputStream;
    new-instance v2, Ljava/util/zip/GZIPOutputStream;

    invoke-direct {v2, v1}, Ljava/util/zip/GZIPOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 305
    .local v2, "localGZIPOutputStream":Ljava/util/zip/GZIPOutputStream;
    invoke-virtual {v2, p0}, Ljava/util/zip/GZIPOutputStream;->write([B)V

    .line 306
    invoke-virtual {v2}, Ljava/util/zip/GZIPOutputStream;->close()V

    .line 307
    new-instance v0, Lorg/apache/http/entity/ByteArrayEntity;

    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    invoke-direct {v0, v3}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V

    .line 308
    .restart local v0    # "localByteArrayEntity":Lorg/apache/http/entity/ByteArrayEntity;
    const-string v3, "gzip"

    invoke-virtual {v0, v3}, Lorg/apache/http/entity/ByteArrayEntity;->setContentEncoding(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getMinGzipSize()J
    .locals 2

    .prologue
    .line 315
    sget-wide v0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->DEFAULT_SYNC_MIN_GZIP_BYTES:J

    return-wide v0
.end method

.method public static getUngzippedContent(Lorg/apache/http/HttpEntity;)Ljava/io/InputStream;
    .locals 5
    .param p0, "paramHttpEntity"    # Lorg/apache/http/HttpEntity;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 202
    invoke-interface {p0}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v1

    .line 203
    .local v1, "localObject":Ljava/io/InputStream;
    if-nez v1, :cond_0

    move-object v2, v1

    .line 213
    .end local v1    # "localObject":Ljava/io/InputStream;
    .local v2, "localObject":Ljava/io/InputStream;
    :goto_0
    return-object v2

    .line 205
    .end local v2    # "localObject":Ljava/io/InputStream;
    .restart local v1    # "localObject":Ljava/io/InputStream;
    :cond_0
    invoke-interface {p0}, Lorg/apache/http/HttpEntity;->getContentEncoding()Lorg/apache/http/Header;

    move-result-object v0

    .line 206
    .local v0, "localHeader":Lorg/apache/http/Header;
    if-nez v0, :cond_1

    move-object v2, v1

    .line 207
    .end local v1    # "localObject":Ljava/io/InputStream;
    .restart local v2    # "localObject":Ljava/io/InputStream;
    goto :goto_0

    .line 208
    .end local v2    # "localObject":Ljava/io/InputStream;
    .restart local v1    # "localObject":Ljava/io/InputStream;
    :cond_1
    invoke-interface {v0}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 209
    .local v3, "str":Ljava/lang/String;
    if-nez v3, :cond_2

    move-object v2, v1

    .line 210
    .end local v1    # "localObject":Ljava/io/InputStream;
    .restart local v2    # "localObject":Ljava/io/InputStream;
    goto :goto_0

    .line 211
    .end local v2    # "localObject":Ljava/io/InputStream;
    .restart local v1    # "localObject":Ljava/io/InputStream;
    :cond_2
    const-string v4, "gzip"

    invoke-virtual {v3, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 212
    new-instance v2, Ljava/util/zip/GZIPInputStream;

    invoke-direct {v2, v1}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    .end local v1    # "localObject":Ljava/io/InputStream;
    .restart local v2    # "localObject":Ljava/io/InputStream;
    move-object v1, v2

    .end local v2    # "localObject":Ljava/io/InputStream;
    .restart local v1    # "localObject":Ljava/io/InputStream;
    :cond_3
    move-object v2, v1

    .line 213
    .end local v1    # "localObject":Ljava/io/InputStream;
    .restart local v2    # "localObject":Ljava/io/InputStream;
    goto :goto_0
.end method

.method public static modifyRequestContentType(Lorg/apache/http/HttpRequest;Ljava/lang/String;)V
    .locals 1
    .param p0, "paramHttpRequest"    # Lorg/apache/http/HttpRequest;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 196
    const-string v0, "Content-Type"

    invoke-interface {p0, v0, p1}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    return-void
.end method

.method public static modifyRequestToAcceptGzipResponse(Lorg/apache/http/HttpRequest;)V
    .locals 2
    .param p0, "paramHttpRequest"    # Lorg/apache/http/HttpRequest;

    .prologue
    .line 191
    const-string v0, "Accept-Encoding"

    const-string v1, "gzip"

    invoke-interface {p0, v0, v1}, Lorg/apache/http/HttpRequest;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 192
    return-void
.end method

.method public static newInstance(Ljava/lang/String;)Lcom/uc/paymentsdk/network/AndroidHttpClient;
    .locals 2
    .param p0, "paramString"    # Ljava/lang/String;

    .prologue
    .line 90
    const/4 v1, 0x0

    invoke-static {p0, v1}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->newInstance(Ljava/lang/String;Landroid/content/Context;)Lcom/uc/paymentsdk/network/AndroidHttpClient;

    move-result-object v0

    .line 91
    .local v0, "localAndroidHttpClient":Lcom/uc/paymentsdk/network/AndroidHttpClient;
    return-object v0
.end method

.method public static newInstance(Ljava/lang/String;Landroid/content/Context;)Lcom/uc/paymentsdk/network/AndroidHttpClient;
    .locals 9
    .param p0, "paramString"    # Ljava/lang/String;
    .param p1, "paramContext"    # Landroid/content/Context;

    .prologue
    const v5, 0xea60

    const/16 v8, 0x50

    const/16 v7, 0x14

    const/4 v6, 0x0

    .line 69
    new-instance v0, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v0}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 70
    .local v0, "localBasicHttpParams":Lorg/apache/http/params/BasicHttpParams;
    invoke-static {v0, v6}, Lorg/apache/http/params/HttpConnectionParams;->setStaleCheckingEnabled(Lorg/apache/http/params/HttpParams;Z)V

    .line 71
    invoke-static {v0, v5}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 72
    invoke-static {v0, v5}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 73
    const/16 v5, 0x2000

    invoke-static {v0, v5}, Lorg/apache/http/params/HttpConnectionParams;->setSocketBufferSize(Lorg/apache/http/params/HttpParams;I)V

    .line 74
    const/16 v5, 0x3c

    invoke-static {v0, v5}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxTotalConnections(Lorg/apache/http/params/HttpParams;I)V

    .line 75
    new-instance v1, Lorg/apache/http/conn/params/ConnPerRouteBean;

    invoke-direct {v1, v7}, Lorg/apache/http/conn/params/ConnPerRouteBean;-><init>(I)V

    .line 76
    .local v1, "localConnPerRouteBean":Lorg/apache/http/conn/params/ConnPerRouteBean;
    new-instance v2, Lorg/apache/http/HttpHost;

    const-string v5, "locahost"

    invoke-direct {v2, v5, v8}, Lorg/apache/http/HttpHost;-><init>(Ljava/lang/String;I)V

    .line 77
    .local v2, "localHttpHost":Lorg/apache/http/HttpHost;
    new-instance v5, Lorg/apache/http/conn/routing/HttpRoute;

    invoke-direct {v5, v2}, Lorg/apache/http/conn/routing/HttpRoute;-><init>(Lorg/apache/http/HttpHost;)V

    invoke-virtual {v1, v5, v7}, Lorg/apache/http/conn/params/ConnPerRouteBean;->setMaxForRoute(Lorg/apache/http/conn/routing/HttpRoute;I)V

    .line 78
    invoke-static {v0, v1}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxConnectionsPerRoute(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V

    .line 79
    invoke-static {v0, v6}, Lorg/apache/http/client/params/HttpClientParams;->setRedirecting(Lorg/apache/http/params/HttpParams;Z)V

    .line 80
    invoke-static {v0, p0}, Lorg/apache/http/params/HttpProtocolParams;->setUserAgent(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V

    .line 81
    new-instance v3, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v3}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 82
    .local v3, "localSchemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v5, Lorg/apache/http/conn/scheme/Scheme;

    const-string v6, "http"

    invoke-static {}, Lorg/apache/http/conn/scheme/PlainSocketFactory;->getSocketFactory()Lorg/apache/http/conn/scheme/PlainSocketFactory;

    move-result-object v7

    invoke-direct {v5, v6, v7, v8}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v5}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 83
    new-instance v5, Lorg/apache/http/conn/scheme/Scheme;

    const-string v6, "https"

    invoke-static {}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->getSocketFactory()Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-result-object v7

    const/16 v8, 0x1bb

    invoke-direct {v5, v6, v7, v8}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    invoke-virtual {v3, v5}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 84
    new-instance v4, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v4, v0, v3}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 85
    .local v4, "localThreadSafeClientConnManager":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    new-instance v5, Lcom/uc/paymentsdk/network/AndroidHttpClient;

    invoke-direct {v5, v4, v0}, Lcom/uc/paymentsdk/network/AndroidHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    return-object v5
.end method

.method private static toCurl(Lorg/apache/http/client/methods/HttpUriRequest;Z)Ljava/lang/String;
    .locals 13
    .param p0, "paramHttpUriRequest"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p1, "paramBoolean"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 335
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 336
    .local v6, "localStringBuilder":Ljava/lang/StringBuilder;
    const-string v8, "curl "

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 338
    invoke-interface {p0}, Lorg/apache/http/client/methods/HttpUriRequest;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v8

    array-length v9, v8

    const/4 v10, 0x0

    :goto_0
    if-lt v10, v9, :cond_2

    .line 346
    invoke-interface {p0}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v2

    .line 348
    .local v2, "aurl":Ljava/net/URI;
    instance-of v8, p0, Lorg/apache/http/impl/client/RequestWrapper;

    if-eqz v8, :cond_0

    .line 350
    move-object v0, p0

    check-cast v0, Lorg/apache/http/impl/client/RequestWrapper;

    move-object v8, v0

    invoke-virtual {v8}, Lorg/apache/http/impl/client/RequestWrapper;->getOriginal()Lorg/apache/http/HttpRequest;

    move-result-object v5

    .line 351
    .local v5, "localObject2":Lorg/apache/http/HttpRequest;
    instance-of v8, v5, Lorg/apache/http/client/methods/HttpUriRequest;

    if-eqz v8, :cond_0

    .line 352
    check-cast v5, Lorg/apache/http/client/methods/HttpUriRequest;

    .end local v5    # "localObject2":Lorg/apache/http/HttpRequest;
    invoke-interface {v5}, Lorg/apache/http/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v2

    .line 354
    :cond_0
    const-string v8, "\""

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 355
    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 356
    const-string v8, "\""

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 357
    instance-of v8, p0, Lorg/apache/http/HttpEntityEnclosingRequest;

    if-eqz v8, :cond_1

    .line 359
    move-object v5, p0

    .line 360
    .local v5, "localObject2":Lorg/apache/http/client/methods/HttpUriRequest;
    check-cast v5, Lorg/apache/http/HttpEntityEnclosingRequest;

    .end local v5    # "localObject2":Lorg/apache/http/client/methods/HttpUriRequest;
    invoke-interface {v5}, Lorg/apache/http/HttpEntityEnclosingRequest;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v4

    .line 361
    .local v4, "localHttpEntity":Lorg/apache/http/HttpEntity;
    if-eqz v4, :cond_1

    invoke-interface {v4}, Lorg/apache/http/HttpEntity;->isRepeatable()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 362
    invoke-interface {v4}, Lorg/apache/http/HttpEntity;->getContentLength()J

    move-result-wide v8

    const-wide/16 v10, 0x400

    cmp-long v8, v8, v10

    if-gez v8, :cond_5

    .line 364
    new-instance v3, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v3}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 365
    .local v3, "localByteArrayOutputStream":Ljava/io/ByteArrayOutputStream;
    invoke-interface {v4, v3}, Lorg/apache/http/HttpEntity;->writeTo(Ljava/io/OutputStream;)V

    .line 366
    invoke-virtual {v3}, Ljava/io/ByteArrayOutputStream;->toString()Ljava/lang/String;

    move-result-object v7

    .line 367
    .local v7, "str":Ljava/lang/String;
    const-string v8, " --data-ascii \""

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "\""

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 374
    .end local v3    # "localByteArrayOutputStream":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "localHttpEntity":Lorg/apache/http/HttpEntity;
    .end local v7    # "str":Ljava/lang/String;
    :cond_1
    :goto_1
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    return-object v8

    .line 338
    .end local v2    # "aurl":Ljava/net/URI;
    :cond_2
    aget-object v1, v8, v10

    .line 340
    .local v1, "aheader":Lorg/apache/http/Header;
    if-nez p1, :cond_4

    invoke-interface {v1}, Lorg/apache/http/Header;->getName()Ljava/lang/String;

    move-result-object v11

    const-string v12, "Authorization"

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-nez v11, :cond_3

    invoke-interface {v1}, Lorg/apache/http/Header;->getName()Ljava/lang/String;

    move-result-object v11

    const-string v12, "Cookie"

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_4

    .line 338
    :cond_3
    :goto_2
    add-int/lit8 v10, v10, 0x1

    goto/16 :goto_0

    .line 342
    :cond_4
    const-string v11, "--header \""

    invoke-virtual {v6, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 343
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v6, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 344
    const-string v11, "\" "

    invoke-virtual {v6, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 371
    .end local v1    # "aheader":Lorg/apache/http/Header;
    .restart local v2    # "aurl":Ljava/net/URI;
    .restart local v4    # "localHttpEntity":Lorg/apache/http/HttpEntity;
    :cond_5
    const-string v8, " [TOO MUCH DATA TO INCLUDE]"

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1
.end method


# virtual methods
.method public addRequestInterceptor(Lorg/apache/http/HttpRequestInterceptor;)V
    .locals 2
    .param p1, "paramHttpRequestInterceptor"    # Lorg/apache/http/HttpRequestInterceptor;

    .prologue
    .line 151
    if-nez p1, :cond_0

    .line 154
    :goto_0
    return-void

    .line 153
    :cond_0
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    iget-object v1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->getRequestInterceptorCount()I

    move-result v1

    invoke-virtual {v0, p1, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->addRequestInterceptor(Lorg/apache/http/HttpRequestInterceptor;I)V

    goto :goto_0
.end method

.method public addResponseInterceptor(Lorg/apache/http/HttpResponseInterceptor;)V
    .locals 2
    .param p1, "paramHttpResponseInterceptor"    # Lorg/apache/http/HttpResponseInterceptor;

    .prologue
    .line 165
    if-nez p1, :cond_0

    .line 168
    :goto_0
    return-void

    .line 167
    :cond_0
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    iget-object v1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->getResponseInterceptorCount()I

    move-result v1

    invoke-virtual {v0, p1, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->addResponseInterceptor(Lorg/apache/http/HttpResponseInterceptor;I)V

    goto :goto_0
.end method

.method public clearCookies()V
    .locals 2

    .prologue
    .line 379
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    if-eqz v0, :cond_0

    .line 380
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->setCookieStore(Lorg/apache/http/client/CookieStore;)V

    .line 381
    :cond_0
    return-void
.end method

.method public close()V
    .locals 1

    .prologue
    .line 218
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    if-eqz v0, :cond_0

    .line 220
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    .line 221
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    .line 223
    :cond_0
    return-void
.end method

.method public disableCurlLogging()V
    .locals 1

    .prologue
    .line 329
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->curlConfiguration:Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;

    .line 330
    return-void
.end method

.method public enableCurlLogging(Ljava/lang/String;I)V
    .locals 2
    .param p1, "paramString"    # Ljava/lang/String;
    .param p2, "paramInt"    # I

    .prologue
    .line 320
    if-nez p1, :cond_0

    .line 321
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "name"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 322
    :cond_0
    const/4 v0, 0x2

    if-lt p2, v0, :cond_1

    const/4 v0, 0x7

    if-le p2, v0, :cond_2

    .line 323
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Level is out of range [2..7]"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 324
    :cond_2
    new-instance v0, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;

    const/4 v1, 0x0

    invoke-direct {v0, p1, p2, v1}, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;-><init>(Ljava/lang/String;ILcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;)V

    iput-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->curlConfiguration:Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;

    .line 325
    return-void
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    .locals 1
    .param p1, "paramHttpHost"    # Lorg/apache/http/HttpHost;
    .param p2, "paramHttpRequest"    # Lorg/apache/http/HttpRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/apache/http/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 283
    .local p3, "paramResponseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1, p2, p3}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "paramHttpHost"    # Lorg/apache/http/HttpHost;
    .param p2, "paramHttpRequest"    # Lorg/apache/http/HttpRequest;
    .param p4, "paramHttpContext"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/HttpHost;",
            "Lorg/apache/http/HttpRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/apache/http/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 290
    .local p3, "paramResponseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1, p2, p3, p4}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;
    .locals 1
    .param p1, "paramHttpUriRequest"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/apache/http/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 269
    .local p2, "paramResponseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1, p2}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;
    .locals 1
    .param p1, "paramHttpUriRequest"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p3, "paramHttpContext"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lorg/apache/http/client/methods/HttpUriRequest;",
            "Lorg/apache/http/client/ResponseHandler",
            "<+TT;>;",
            "Lorg/apache/http/protocol/HttpContext;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/apache/http/client/ClientProtocolException;
        }
    .end annotation

    .prologue
    .line 276
    .local p2, "paramResponseHandler":Lorg/apache/http/client/ResponseHandler;, "Lorg/apache/http/client/ResponseHandler<+TT;>;"
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1, p2, p3}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/client/ResponseHandler;Lorg/apache/http/protocol/HttpContext;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "paramHttpHost"    # Lorg/apache/http/HttpHost;
    .param p2, "paramHttpRequest"    # Lorg/apache/http/HttpRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 255
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1, p2}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "paramHttpHost"    # Lorg/apache/http/HttpHost;
    .param p2, "paramHttpRequest"    # Lorg/apache/http/HttpRequest;
    .param p3, "paramHttpContext"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 262
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1, p2, p3}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "paramHttpUriRequest"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 241
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method public execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    .locals 1
    .param p1, "paramHttpUriRequest"    # Lorg/apache/http/client/methods/HttpUriRequest;
    .param p2, "paramHttpContext"    # Lorg/apache/http/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 248
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1, p2}, Lorg/apache/http/impl/client/DefaultHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;

    move-result-object v0

    return-object v0
.end method

.method protected finalize()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 181
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 182
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    if-eqz v0, :cond_0

    .line 184
    const-string v0, "AndroidHttpClient"

    const-string v1, "Leak found"

    iget-object v2, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    invoke-static {v0, v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 185
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mLeakedException:Ljava/lang/RuntimeException;

    .line 187
    :cond_0
    return-void
.end method

.method public getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;
    .locals 1

    .prologue
    .line 234
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0}, Lorg/apache/http/impl/client/DefaultHttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v0

    return-object v0
.end method

.method public getCookies()Lorg/apache/http/client/CookieStore;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    if-eqz v0, :cond_0

    .line 97
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0}, Lorg/apache/http/impl/client/DefaultHttpClient;->getCookieStore()Lorg/apache/http/client/CookieStore;

    move-result-object v0

    .line 98
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getParams()Lorg/apache/http/params/HttpParams;
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0}, Lorg/apache/http/impl/client/DefaultHttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v0

    return-object v0
.end method

.method public isLoadOwnCookies()Z
    .locals 1

    .prologue
    .line 146
    iget-boolean v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mIsLoadCookies:Z

    return v0
.end method

.method public loadCookies(Lorg/apache/http/client/CookieStore;)V
    .locals 1
    .param p1, "paramCookieStore"    # Lorg/apache/http/client/CookieStore;

    .prologue
    .line 140
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->mIsLoadCookies:Z

    .line 141
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0, p1}, Lorg/apache/http/impl/client/DefaultHttpClient;->setCookieStore(Lorg/apache/http/client/CookieStore;)V

    .line 142
    return-void
.end method

.method public removeRequestInterceptor(Lorg/apache/http/HttpRequestInterceptor;)V
    .locals 2
    .param p1, "paramHttpRequestInterceptor"    # Lorg/apache/http/HttpRequestInterceptor;

    .prologue
    .line 158
    if-nez p1, :cond_0

    .line 161
    :goto_0
    return-void

    .line 160
    :cond_0
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->removeRequestInterceptorByClass(Ljava/lang/Class;)V

    goto :goto_0
.end method

.method public removeResponseInterceptor(Lorg/apache/http/HttpResponseInterceptor;)V
    .locals 2
    .param p1, "paramHttpResponseInterceptor"    # Lorg/apache/http/HttpResponseInterceptor;

    .prologue
    .line 172
    if-nez p1, :cond_0

    .line 175
    :goto_0
    return-void

    .line 174
    :cond_0
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->removeResponseInterceptorByClass(Ljava/lang/Class;)V

    goto :goto_0
.end method

.method public useCmwapConnection()V
    .locals 4

    .prologue
    .line 129
    new-instance v0, Lorg/apache/http/HttpHost;

    const-string v1, "10.0.0.172"

    const/16 v2, 0x50

    const-string v3, "http"

    invoke-direct {v0, v1, v2, v3}, Lorg/apache/http/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    .line 130
    .local v0, "localHttpHost":Lorg/apache/http/HttpHost;
    iget-object v1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v1}, Lorg/apache/http/impl/client/DefaultHttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v1

    const-string v2, "http.route.default-proxy"

    invoke-interface {v1, v2, v0}, Lorg/apache/http/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/http/params/HttpParams;

    .line 131
    return-void
.end method

.method public useDefaultConnection()V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient;->delegate:Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-virtual {v0}, Lorg/apache/http/impl/client/DefaultHttpClient;->getParams()Lorg/apache/http/params/HttpParams;

    move-result-object v0

    const-string v1, "http.route.default-proxy"

    invoke-interface {v0, v1}, Lorg/apache/http/params/HttpParams;->removeParameter(Ljava/lang/String;)Z

    .line 136
    return-void
.end method
