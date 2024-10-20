.class public Lcom/uc/paymentsdk/network/ApiTask;
.super Landroid/os/AsyncTask;
.source "ApiTask.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "pay"


# instance fields
.field private httpmethod:Ljava/lang/String;

.field private mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;

.field private mContext:Landroid/content/Context;

.field private mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

.field private mParameter:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private mReuqestAction:I


# direct methods
.method constructor <init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V
    .locals 2
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paramInt"    # I
    .param p3, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    .param p5, "httpMethod"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "I",
            "Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 37
    .local p4, "paramHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 39
    iput-object p1, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;

    .line 40
    iput p2, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I

    .line 41
    iput-object p3, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    .line 42
    iput-object p4, p0, Lcom/uc/paymentsdk/network/ApiTask;->mParameter:Ljava/util/HashMap;

    .line 43
    invoke-static {}, Lcom/uc/paymentsdk/network/HttpClientFactory;->get()Lcom/uc/paymentsdk/network/HttpClientFactory;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/network/HttpClientFactory;->getSDKHttpClient(Ljava/lang/String;)Lcom/uc/paymentsdk/network/AndroidHttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;

    .line 44
    iput-object p5, p0, Lcom/uc/paymentsdk/network/ApiTask;->httpmethod:Ljava/lang/String;

    .line 45
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/uc/paymentsdk/network/ApiTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected doInBackground([Ljava/lang/Void;)Ljava/lang/Object;
    .locals 14
    .param p1, "paramArrayOfVoid"    # [Ljava/lang/Void;

    .prologue
    const/4 v13, -0x1

    .line 50
    :try_start_0
    sget-object v11, Lcom/uc/paymentsdk/util/Constants;->API_URLS:[Ljava/lang/String;

    iget v12, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I

    aget-object v10, v11, v12

    .line 51
    .local v10, "requestUrl":Ljava/lang/String;
    const/4 v4, 0x0

    .line 52
    .local v4, "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    const/4 v3, 0x0

    .line 55
    .local v3, "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->httpmethod:Ljava/lang/String;

    const-string v12, "post"

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 56
    new-instance v4, Lorg/apache/http/client/methods/HttpPost;

    .end local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    invoke-direct {v4, v10}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 57
    .restart local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mParameter:Ljava/util/HashMap;

    invoke-static {v11}, Lcom/uc/paymentsdk/util/Utils;->getQueryString(Ljava/util/HashMap;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/ConnectException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v9

    .line 59
    .local v9, "querystr":Ljava/lang/String;
    :try_start_1
    new-instance v11, Lorg/apache/http/entity/ByteArrayEntity;

    const-string v12, "UTF-8"

    invoke-virtual {v9, v12}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v12

    invoke-direct {v11, v12}, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V

    invoke-virtual {v4, v11}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_1
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/net/ConnectException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/net/SocketException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    .line 62
    :goto_0
    :try_start_2
    const-string v11, "Content-Type"

    const-string v12, "application/x-www-form-urlencoded"

    invoke-virtual {v4, v11, v12}, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;

    invoke-virtual {v11, v4}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .line 69
    .local v5, "localHttpResponse":Lorg/apache/http/HttpResponse;
    :goto_1
    if-nez v5, :cond_2

    .line 70
    const/4 v11, 0x0

    .line 104
    .end local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .end local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .end local v9    # "querystr":Ljava/lang/String;
    .end local v10    # "requestUrl":Ljava/lang/String;
    :goto_2
    return-object v11

    .line 65
    .restart local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v10    # "requestUrl":Ljava/lang/String;
    :cond_0
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mParameter:Ljava/util/HashMap;

    invoke-static {v11}, Lcom/uc/paymentsdk/util/Utils;->getQueryString(Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v9

    .line 66
    .restart local v9    # "querystr":Ljava/lang/String;
    new-instance v3, Lorg/apache/http/client/methods/HttpGet;

    .end local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    const-string v11, "?"

    invoke-virtual {v10, v11}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v11

    if-lez v11, :cond_1

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "&"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    :goto_3
    invoke-direct {v3, v11}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 67
    .restart local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;

    invoke-virtual {v11, v3}, Lcom/uc/paymentsdk/network/AndroidHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v5

    .restart local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    goto :goto_1

    .line 66
    .end local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    :cond_1
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "?"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    goto :goto_3

    .line 71
    .restart local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    :cond_2
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v0

    .line 72
    .local v0, "j":I
    const/16 v11, 0xc8

    if-eq v11, v0, :cond_3

    .line 73
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    :try_end_2
    .catch Ljava/net/ConnectException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/net/SocketException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    move-result-object v11

    goto :goto_2

    .line 75
    :cond_3
    :try_start_3
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    if-eqz v11, :cond_b

    .line 76
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;

    instance-of v11, v11, Landroid/app/Activity;

    if-eqz v11, :cond_7

    .line 77
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;

    check-cast v11, Landroid/app/Activity;

    invoke-virtual {v11}, Landroid/app/Activity;->isFinishing()Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result v11

    if-eqz v11, :cond_7

    .line 78
    move-object v6, v5

    .line 88
    .local v6, "localObject2":Lorg/apache/http/HttpResponse;
    if-eqz v4, :cond_6

    .line 89
    :try_start_4
    invoke-virtual {v4}, Lorg/apache/http/client/methods/HttpPost;->abort()V

    .line 92
    :cond_4
    :goto_4
    if-eqz v5, :cond_5

    .line 93
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/HttpEntity;->consumeContent()V

    :cond_5
    move-object v11, v6

    .line 79
    goto :goto_2

    .line 90
    :cond_6
    if-eqz v3, :cond_4

    .line 91
    invoke-virtual {v3}, Lorg/apache/http/client/methods/HttpGet;->abort()V
    :try_end_4
    .catch Ljava/net/ConnectException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/net/SocketException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    goto :goto_4

    .line 95
    .end local v0    # "j":I
    .end local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .end local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .end local v6    # "localObject2":Lorg/apache/http/HttpResponse;
    .end local v9    # "querystr":Ljava/lang/String;
    .end local v10    # "requestUrl":Ljava/lang/String;
    :catch_0
    move-exception v11

    move-object v1, v11

    .line 96
    .local v1, "localConnectException":Ljava/net/ConnectException;
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    goto/16 :goto_2

    .line 81
    .end local v1    # "localConnectException":Ljava/net/ConnectException;
    .restart local v0    # "j":I
    .restart local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .restart local v9    # "querystr":Ljava/lang/String;
    .restart local v10    # "requestUrl":Ljava/lang/String;
    :cond_7
    :try_start_5
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    .line 82
    iget v12, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I

    .line 81
    invoke-interface {v11, v12, v5}, Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;->onPreHandle(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move-result-object v6

    .line 88
    .local v6, "localObject2":Ljava/lang/Object;
    if-eqz v4, :cond_a

    .line 89
    :try_start_6
    invoke-virtual {v4}, Lorg/apache/http/client/methods/HttpPost;->abort()V

    .line 92
    :cond_8
    :goto_5
    if-eqz v5, :cond_9

    .line 93
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/HttpEntity;->consumeContent()V

    :cond_9
    move-object v11, v6

    .line 83
    goto/16 :goto_2

    .line 90
    :cond_a
    if-eqz v3, :cond_8

    .line 91
    invoke-virtual {v3}, Lorg/apache/http/client/methods/HttpGet;->abort()V
    :try_end_6
    .catch Ljava/net/ConnectException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Ljava/net/SocketException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_3

    goto :goto_5

    .line 97
    .end local v0    # "j":I
    .end local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .end local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .end local v6    # "localObject2":Ljava/lang/Object;
    .end local v9    # "querystr":Ljava/lang/String;
    .end local v10    # "requestUrl":Ljava/lang/String;
    :catch_1
    move-exception v11

    move-object v8, v11

    .line 98
    .local v8, "localSocketTimeoutException":Ljava/net/SocketTimeoutException;
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    goto/16 :goto_2

    .line 85
    .end local v8    # "localSocketTimeoutException":Ljava/net/SocketTimeoutException;
    .restart local v0    # "j":I
    .restart local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .restart local v9    # "querystr":Ljava/lang/String;
    .restart local v10    # "requestUrl":Ljava/lang/String;
    :cond_b
    move-object v6, v5

    .line 88
    .local v6, "localObject2":Lorg/apache/http/HttpResponse;
    if-eqz v4, :cond_e

    .line 89
    :try_start_7
    invoke-virtual {v4}, Lorg/apache/http/client/methods/HttpPost;->abort()V

    .line 92
    :cond_c
    :goto_6
    if-eqz v5, :cond_d

    .line 93
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v11

    invoke-interface {v11}, Lorg/apache/http/HttpEntity;->consumeContent()V

    :cond_d
    move-object v11, v6

    .line 86
    goto/16 :goto_2

    .line 90
    :cond_e
    if-eqz v3, :cond_c

    .line 91
    invoke-virtual {v3}, Lorg/apache/http/client/methods/HttpGet;->abort()V
    :try_end_7
    .catch Ljava/net/ConnectException; {:try_start_7 .. :try_end_7} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_7 .. :try_end_7} :catch_1
    .catch Ljava/net/SocketException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_3

    goto :goto_6

    .line 99
    .end local v0    # "j":I
    .end local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .end local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .end local v6    # "localObject2":Lorg/apache/http/HttpResponse;
    .end local v9    # "querystr":Ljava/lang/String;
    .end local v10    # "requestUrl":Ljava/lang/String;
    :catch_2
    move-exception v11

    move-object v7, v11

    .line 100
    .local v7, "localSocketException":Ljava/net/SocketException;
    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    goto/16 :goto_2

    .line 87
    .end local v7    # "localSocketException":Ljava/net/SocketException;
    .restart local v0    # "j":I
    .restart local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .restart local v9    # "querystr":Ljava/lang/String;
    .restart local v10    # "requestUrl":Ljava/lang/String;
    :catchall_0
    move-exception v11

    .line 88
    if-eqz v4, :cond_11

    .line 89
    :try_start_8
    invoke-virtual {v4}, Lorg/apache/http/client/methods/HttpPost;->abort()V

    .line 92
    :cond_f
    :goto_7
    if-eqz v5, :cond_10

    .line 93
    invoke-interface {v5}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v12

    invoke-interface {v12}, Lorg/apache/http/HttpEntity;->consumeContent()V

    .line 94
    :cond_10
    throw v11
    :try_end_8
    .catch Ljava/net/ConnectException; {:try_start_8 .. :try_end_8} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_8 .. :try_end_8} :catch_1
    .catch Ljava/net/SocketException; {:try_start_8 .. :try_end_8} :catch_2
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_3

    .line 101
    .end local v0    # "j":I
    .end local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .end local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .end local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .end local v9    # "querystr":Ljava/lang/String;
    .end local v10    # "requestUrl":Ljava/lang/String;
    :catch_3
    move-exception v11

    move-object v2, v11

    .line 102
    .local v2, "localException":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    .line 104
    const/4 v11, -0x3

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    goto/16 :goto_2

    .line 90
    .end local v2    # "localException":Ljava/lang/Exception;
    .restart local v0    # "j":I
    .restart local v3    # "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    .restart local v4    # "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    .restart local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    .restart local v9    # "querystr":Ljava/lang/String;
    .restart local v10    # "requestUrl":Ljava/lang/String;
    :cond_11
    if-eqz v3, :cond_f

    .line 91
    :try_start_9
    invoke-virtual {v3}, Lorg/apache/http/client/methods/HttpGet;->abort()V
    :try_end_9
    .catch Ljava/net/ConnectException; {:try_start_9 .. :try_end_9} :catch_0
    .catch Ljava/net/SocketTimeoutException; {:try_start_9 .. :try_end_9} :catch_1
    .catch Ljava/net/SocketException; {:try_start_9 .. :try_end_9} :catch_2
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_3

    goto :goto_7

    .line 60
    .end local v0    # "j":I
    .end local v5    # "localHttpResponse":Lorg/apache/http/HttpResponse;
    :catch_4
    move-exception v11

    goto/16 :goto_0
.end method

.method protected onPostExecute(Ljava/lang/Object;)V
    .locals 3
    .param p1, "paramObject"    # Ljava/lang/Object;

    .prologue
    .line 109
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    if-nez v0, :cond_1

    .line 124
    .end local p1    # "paramObject":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-void

    .line 111
    .restart local p1    # "paramObject":Ljava/lang/Object;
    :cond_1
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;

    instance-of v0, v0, Landroid/app/Activity;

    if-eqz v0, :cond_2

    .line 112
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 114
    :cond_2
    if-nez p1, :cond_3

    .line 115
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    iget v1, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I

    const/16 v2, 0x1f4

    invoke-interface {v0, v1, v2}, Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;->onError(II)V

    goto :goto_0

    .line 118
    :cond_3
    instance-of v0, p1, Ljava/lang/Integer;

    if-eqz v0, :cond_4

    .line 119
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    iget v1, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I

    .line 120
    check-cast p1, Ljava/lang/Integer;

    .end local p1    # "paramObject":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 119
    invoke-interface {v0, v1, v2}, Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;->onError(II)V

    goto :goto_0

    .line 123
    .restart local p1    # "paramObject":Ljava/lang/Object;
    :cond_4
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    iget v1, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I

    invoke-interface {v0, v1, p1}, Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;->onSuccess(ILjava/lang/Object;)V

    goto :goto_0
.end method
