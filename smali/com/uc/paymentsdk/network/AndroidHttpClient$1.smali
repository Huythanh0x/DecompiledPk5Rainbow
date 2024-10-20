.class Lcom/uc/paymentsdk/network/AndroidHttpClient$1;
.super Ljava/lang/Object;
.implements Lorg/apache/http/HttpRequestInterceptor;
.source "AndroidHttpClient.java"

.annotation system Ldalvik/annotation/EnclosingClass;
  value = Lcom/uc/paymentsdk/network/AndroidHttpClient;
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 0
  name = null
.end annotation

.method constructor <init>()V
  .registers 1
  .prologue
  .line 54
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 1
    return-void
.end method

.method public process(Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)V
  .parameter "paramHttpRequest" # Lorg/apache/http/HttpRequest;
  .parameter "paramHttpContext" # Lorg/apache/http/protocol/HttpContext;
  .registers 5
  .prologue
  .line 59
    invoke-static { }, Landroid/os/Looper;->myLooper()Landroid/os/Looper;
    move-result-object v0
    if-eqz v0, :L0
    invoke-static { }, Landroid/os/Looper;->myLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-static { }, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    if-ne v0, v1, :L0
  .line 60
    new-instance v0, Ljava/lang/RuntimeException;
    const-string v1, "This thread forbids HTTP requests"
    invoke-direct { v0, v1 }, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
    throw v0
  :L0
  .line 61
    return-void
.end method
