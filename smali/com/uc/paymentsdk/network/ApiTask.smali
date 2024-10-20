.class public Lcom/uc/paymentsdk/network/ApiTask;
.super Landroid/os/AsyncTask;
.source "ApiTask.java"

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

.field private final static TAG:Ljava/lang/String; = "pay"

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

.method constructor <init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V
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
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramInt" # I
  .parameter "paramTaskHandler" # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
  .parameter # Ljava/util/HashMap;
  .parameter "httpMethod" # Ljava/lang/String;
  .registers 8
  .local p4, "paramHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
  .prologue
  .line 37
    invoke-direct { p0 }, Landroid/os/AsyncTask;-><init>()V
  .line 39
    iput-object p1, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;
  .line 40
    iput p2, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I
  .line 41
    iput-object p3, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
  .line 42
    iput-object p4, p0, Lcom/uc/paymentsdk/network/ApiTask;->mParameter:Ljava/util/HashMap;
  .line 43
    invoke-static { }, Lcom/uc/paymentsdk/network/HttpClientFactory;->get()Lcom/uc/paymentsdk/network/HttpClientFactory;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual { v0, v1 }, Lcom/uc/paymentsdk/network/HttpClientFactory;->getSDKHttpClient(Ljava/lang/String;)Lcom/uc/paymentsdk/network/AndroidHttpClient;
    move-result-object v0
    iput-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;
  .line 44
    iput-object p5, p0, Lcom/uc/paymentsdk/network/ApiTask;->httpmethod:Ljava/lang/String;
  .line 45
    return-void
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
  .registers 3
  .prologue
  .line 1
    check-cast p1, [Ljava/lang/Void;
    invoke-virtual { p0, p1 }, Lcom/uc/paymentsdk/network/ApiTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method protected doInBackground([Ljava/lang/Void;)Ljava/lang/Object;
  .parameter "paramArrayOfVoid" # [Ljava/lang/Void;
  .catch Ljava/net/ConnectException; { :L0 .. :L1 } :L18
  .catch Ljava/net/SocketTimeoutException; { :L0 .. :L1 } :L26
  .catch Ljava/net/SocketException; { :L0 .. :L1 } :L33
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L38
  .catch Ljava/lang/ArrayIndexOutOfBoundsException; { :L2 .. :L3 } :L42
  .catch Ljava/net/ConnectException; { :L2 .. :L3 } :L18
  .catch Ljava/net/SocketTimeoutException; { :L2 .. :L3 } :L26
  .catch Ljava/net/SocketException; { :L2 .. :L3 } :L33
  .catch Ljava/lang/Exception; { :L2 .. :L3 } :L38
  .catch Ljava/net/ConnectException; { :L3 .. :L10 } :L18
  .catch Ljava/net/SocketTimeoutException; { :L3 .. :L10 } :L26
  .catch Ljava/net/SocketException; { :L3 .. :L10 } :L33
  .catch Ljava/lang/Exception; { :L3 .. :L10 } :L38
  .catchall { :L11 .. :L12 } :L34
  .catch Ljava/net/ConnectException; { :L13 .. :L17 } :L18
  .catch Ljava/net/SocketTimeoutException; { :L13 .. :L17 } :L26
  .catch Ljava/net/SocketException; { :L13 .. :L17 } :L33
  .catch Ljava/lang/Exception; { :L13 .. :L17 } :L38
  .catchall { :L19 .. :L20 } :L34
  .catch Ljava/net/ConnectException; { :L21 .. :L25 } :L18
  .catch Ljava/net/SocketTimeoutException; { :L21 .. :L25 } :L26
  .catch Ljava/net/SocketException; { :L21 .. :L25 } :L33
  .catch Ljava/lang/Exception; { :L21 .. :L25 } :L38
  .catch Ljava/net/ConnectException; { :L28 .. :L32 } :L18
  .catch Ljava/net/SocketTimeoutException; { :L28 .. :L32 } :L26
  .catch Ljava/net/SocketException; { :L28 .. :L32 } :L33
  .catch Ljava/lang/Exception; { :L28 .. :L32 } :L38
  .catch Ljava/net/ConnectException; { :L35 .. :L38 } :L18
  .catch Ljava/net/SocketTimeoutException; { :L35 .. :L38 } :L26
  .catch Ljava/net/SocketException; { :L35 .. :L38 } :L33
  .catch Ljava/lang/Exception; { :L35 .. :L38 } :L38
  .catch Ljava/net/ConnectException; { :L40 .. :L41 } :L18
  .catch Ljava/net/SocketTimeoutException; { :L40 .. :L41 } :L26
  .catch Ljava/net/SocketException; { :L40 .. :L41 } :L33
  .catch Ljava/lang/Exception; { :L40 .. :L41 } :L38
  .registers 16
  .prologue
    const/4 v13, -1
  :L0
  .line 50
    sget-object v11, Lcom/uc/paymentsdk/util/Constants;->API_URLS:[Ljava/lang/String;
    iget v12, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I
    aget-object v10, v11, v12
  .line 51
  .local v10, "requestUrl":Ljava/lang/String;
    const/4 v4, 0
  .line 52
  .local v4, "localHttpPost":Lorg/apache/http/client/methods/HttpPost;
    const/4 v3, 0
  .line 55
  .local v3, "localHttpGet":Lorg/apache/http/client/methods/HttpGet;
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->httpmethod:Ljava/lang/String;
    const-string v12, "post"
    invoke-virtual { v11, v12 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, :L6
  .line 56
    new-instance v4, Lorg/apache/http/client/methods/HttpPost;
  .end local v4
    invoke-direct { v4, v10 }, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V
  .line 57
  .restart local v4
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mParameter:Ljava/util/HashMap;
    invoke-static { v11 }, Lcom/uc/paymentsdk/util/Utils;->getQueryString(Ljava/util/HashMap;)Ljava/lang/String;
  :L1
    move-result-object v9
  :L2
  .line 59
  .local v9, "querystr":Ljava/lang/String;
    new-instance v11, Lorg/apache/http/entity/ByteArrayEntity;
    const-string v12, "UTF-8"
    invoke-virtual { v9, v12 }, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    move-result-object v12
    invoke-direct { v11, v12 }, Lorg/apache/http/entity/ByteArrayEntity;-><init>([B)V
    invoke-virtual { v4, v11 }, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V
  :L3
  .line 62
    const-string v11, "Content-Type"
    const-string v12, "application/x-www-form-urlencoded"
    invoke-virtual { v4, v11, v12 }, Lorg/apache/http/client/methods/HttpPost;->addHeader(Ljava/lang/String;Ljava/lang/String;)V
  .line 63
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;
    invoke-virtual { v11, v4 }, Lcom/uc/paymentsdk/network/AndroidHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    move-result-object v5
  :L4
  .line 69
  .local v5, "localHttpResponse":Lorg/apache/http/HttpResponse;
    if-nez v5, :L9
  .line 70
    const/4 v11, 0
  :L5
  .line 104
  .end local v3
  .end local v4
  .end local v5
  .end local v9
  .end local v10
    return-object v11
  :L6
  .line 65
  .restart local v3
  .restart local v4
  .restart local v10
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mParameter:Ljava/util/HashMap;
    invoke-static { v11 }, Lcom/uc/paymentsdk/util/Utils;->getQueryString(Ljava/util/HashMap;)Ljava/lang/String;
    move-result-object v9
  .line 66
  .restart local v9
    new-instance v3, Lorg/apache/http/client/methods/HttpGet;
  .end local v3
    const-string v11, "?"
    invoke-virtual { v10, v11 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v11
    if-lez v11, :L8
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-static { v10 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v12
    invoke-direct { v11, v12 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v12, "&"
    invoke-virtual { v11, v12 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual { v11, v9 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual { v11 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
  :L7
    invoke-direct { v3, v11 }, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V
  .line 67
  .restart local v3
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;
    invoke-virtual { v11, v3 }, Lcom/uc/paymentsdk/network/AndroidHttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    move-result-object v5
  .restart local v5
    goto :L4
  :L8
  .line 66
  .end local v3
  .end local v5
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-static { v10 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v12
    invoke-direct { v11, v12 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v12, "?"
    invoke-virtual { v11, v12 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual { v11, v9 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual { v11 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    goto :L7
  :L9
  .line 71
  .restart local v3
  .restart local v5
    invoke-interface { v5 }, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;
    move-result-object v11
    invoke-interface { v11 }, Lorg/apache/http/StatusLine;->getStatusCode()I
    move-result v0
  .line 72
  .local v0, "j":I
    const/16 v11, 200
    if-eq v11, v0, :L11
  .line 73
    invoke-static { v0 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
  :L10
    move-result-object v11
    goto :L5
  :L11
  .line 75
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    if-eqz v11, :L27
  .line 76
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;
    instance-of v11, v11, Landroid/app/Activity;
    if-eqz v11, :L19
  .line 77
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;
    check-cast v11, Landroid/app/Activity;
    invoke-virtual { v11 }, Landroid/app/Activity;->isFinishing()Z
  :L12
    move-result v11
    if-eqz v11, :L19
  .line 78
    move-object v6, v5
  .line 88
  .local v6, "localObject2":Lorg/apache/http/HttpResponse;
    if-eqz v4, :L16
  :L13
  .line 89
    invoke-virtual { v4 }, Lorg/apache/http/client/methods/HttpPost;->abort()V
  :L14
  .line 92
    if-eqz v5, :L15
  .line 93
    invoke-interface { v5 }, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;
    move-result-object v11
    invoke-interface { v11 }, Lorg/apache/http/HttpEntity;->consumeContent()V
  :L15
    move-object v11, v6
  .line 79
    goto :L5
  :L16
  .line 90
    if-eqz v3, :L14
  .line 91
    invoke-virtual { v3 }, Lorg/apache/http/client/methods/HttpGet;->abort()V
  :L17
    goto :L14
  :L18
  .line 95
  .end local v0
  .end local v3
  .end local v4
  .end local v5
  .end local v6
  .end local v9
  .end local v10
    move-exception v11
    move-object v1, v11
  .line 96
  .local v1, "localConnectException":Ljava/net/ConnectException;
    invoke-static { v13 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    goto/16 :L5
  :L19
  .line 81
  .end local v1
  .restart local v0
  .restart local v3
  .restart local v4
  .restart local v5
  .restart local v9
  .restart local v10
    iget-object v11, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
  .line 82
    iget v12, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I
  .line 81
    invoke-interface { v11, v12, v5 }, Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;->onPreHandle(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
  :L20
    move-result-object v6
  .line 88
  .local v6, "localObject2":Ljava/lang/Object;
    if-eqz v4, :L24
  :L21
  .line 89
    invoke-virtual { v4 }, Lorg/apache/http/client/methods/HttpPost;->abort()V
  :L22
  .line 92
    if-eqz v5, :L23
  .line 93
    invoke-interface { v5 }, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;
    move-result-object v11
    invoke-interface { v11 }, Lorg/apache/http/HttpEntity;->consumeContent()V
  :L23
    move-object v11, v6
  .line 83
    goto/16 :L5
  :L24
  .line 90
    if-eqz v3, :L22
  .line 91
    invoke-virtual { v3 }, Lorg/apache/http/client/methods/HttpGet;->abort()V
  :L25
    goto :L22
  :L26
  .line 97
  .end local v0
  .end local v3
  .end local v4
  .end local v5
  .end local v6
  .end local v9
  .end local v10
    move-exception v11
    move-object v8, v11
  .line 98
  .local v8, "localSocketTimeoutException":Ljava/net/SocketTimeoutException;
    invoke-static { v13 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    goto/16 :L5
  :L27
  .line 85
  .end local v8
  .restart local v0
  .restart local v3
  .restart local v4
  .restart local v5
  .restart local v9
  .restart local v10
    move-object v6, v5
  .line 88
  .local v6, "localObject2":Lorg/apache/http/HttpResponse;
    if-eqz v4, :L31
  :L28
  .line 89
    invoke-virtual { v4 }, Lorg/apache/http/client/methods/HttpPost;->abort()V
  :L29
  .line 92
    if-eqz v5, :L30
  .line 93
    invoke-interface { v5 }, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;
    move-result-object v11
    invoke-interface { v11 }, Lorg/apache/http/HttpEntity;->consumeContent()V
  :L30
    move-object v11, v6
  .line 86
    goto/16 :L5
  :L31
  .line 90
    if-eqz v3, :L29
  .line 91
    invoke-virtual { v3 }, Lorg/apache/http/client/methods/HttpGet;->abort()V
  :L32
    goto :L29
  :L33
  .line 99
  .end local v0
  .end local v3
  .end local v4
  .end local v5
  .end local v6
  .end local v9
  .end local v10
    move-exception v11
    move-object v7, v11
  .line 100
  .local v7, "localSocketException":Ljava/net/SocketException;
    invoke-static { v13 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    goto/16 :L5
  :L34
  .line 87
  .end local v7
  .restart local v0
  .restart local v3
  .restart local v4
  .restart local v5
  .restart local v9
  .restart local v10
    move-exception v11
  .line 88
    if-eqz v4, :L39
  :L35
  .line 89
    invoke-virtual { v4 }, Lorg/apache/http/client/methods/HttpPost;->abort()V
  :L36
  .line 92
    if-eqz v5, :L37
  .line 93
    invoke-interface { v5 }, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;
    move-result-object v12
    invoke-interface { v12 }, Lorg/apache/http/HttpEntity;->consumeContent()V
  :L37
  .line 94
    throw v11
  :L38
  .line 101
  .end local v0
  .end local v3
  .end local v4
  .end local v5
  .end local v9
  .end local v10
    move-exception v11
    move-object v2, v11
  .line 102
  .local v2, "localException":Ljava/lang/Exception;
    invoke-virtual { v2 }, Ljava/lang/Exception;->printStackTrace()V
  .line 104
    const/4 v11, -3
    invoke-static { v11 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    goto/16 :L5
  :L39
  .line 90
  .end local v2
  .restart local v0
  .restart local v3
  .restart local v4
  .restart local v5
  .restart local v9
  .restart local v10
    if-eqz v3, :L36
  :L40
  .line 91
    invoke-virtual { v3 }, Lorg/apache/http/client/methods/HttpGet;->abort()V
  :L41
    goto :L36
  :L42
  .line 60
  .end local v0
  .end local v5
    move-exception v11
    goto/16 :L3
.end method

.method protected onPostExecute(Ljava/lang/Object;)V
  .parameter "paramObject" # Ljava/lang/Object;
  .registers 5
  .prologue
  .line 109
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    if-nez v0, :L1
  :L0
  .line 124
  .end local p1
    return-void
  :L1
  .line 111
  .restart local p1
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;
    instance-of v0, v0, Landroid/app/Activity;
    if-eqz v0, :L2
  .line 112
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mContext:Landroid/content/Context;
    check-cast v0, Landroid/app/Activity;
    invoke-virtual { v0 }, Landroid/app/Activity;->isFinishing()Z
    move-result v0
    if-nez v0, :L0
  :L2
  .line 114
    if-nez p1, :L3
  .line 115
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    iget v1, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I
    const/16 v2, 500
    invoke-interface { v0, v1, v2 }, Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;->onError(II)V
    goto :L0
  :L3
  .line 118
    instance-of v0, p1, Ljava/lang/Integer;
    if-eqz v0, :L4
  .line 119
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    iget v1, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I
  .line 120
    check-cast p1, Ljava/lang/Integer;
  .end local p1
    invoke-virtual { p1 }, Ljava/lang/Integer;->intValue()I
    move-result v2
  .line 119
    invoke-interface { v0, v1, v2 }, Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;->onError(II)V
    goto :L0
  :L4
  .line 123
  .restart local p1
    iget-object v0, p0, Lcom/uc/paymentsdk/network/ApiTask;->mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    iget v1, p0, Lcom/uc/paymentsdk/network/ApiTask;->mReuqestAction:I
    invoke-interface { v0, v1, p1 }, Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;->onSuccess(ILjava/lang/Object;)V
    goto :L0
.end method
