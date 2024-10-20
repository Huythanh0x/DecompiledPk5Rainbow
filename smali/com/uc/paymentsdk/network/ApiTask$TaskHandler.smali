.class public interface abstract Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
.super Ljava/lang/Object;
.source "ApiTask.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uc/paymentsdk/network/ApiTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "TaskHandler"
.end annotation


# virtual methods
.method public abstract onError(II)V
.end method

.method public abstract onPreHandle(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
.end method

.method public abstract onSuccess(ILjava/lang/Object;)V
.end method
