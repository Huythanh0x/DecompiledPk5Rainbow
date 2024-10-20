.class public Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;
.super Lcom/uc/paymentsdk/network/chain/Handler;
.source "SyncSmsInfoHandler.java"

# interfaces
.implements Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;


# static fields
.field private static sStatus:I


# instance fields
.field private final LOCK:Ljava/lang/Integer;

.field private mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V

    .line 19
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;)V
    .locals 1
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paramOnFinishListener"    # Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/uc/paymentsdk/network/chain/Handler;-><init>(Landroid/content/Context;)V

    .line 19
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;

    .line 28
    iput-object p2, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    .line 29
    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;)Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;

    return-object v0
.end method

.method public static init()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I

    .line 33
    return-void
.end method


# virtual methods
.method public handleRequest()V
    .locals 3

    .prologue
    .line 37
    sget v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I

    packed-switch v0, :pswitch_data_0

    .line 72
    :cond_0
    :goto_0
    return-void

    .line 39
    :pswitch_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;

    invoke-direct {v1, p0}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler$1;-><init>(Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 56
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 59
    :pswitch_1
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    if-nez v0, :cond_1

    .line 60
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v0}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    goto :goto_0

    .line 64
    :cond_1
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_0

    .line 68
    :pswitch_2
    const/4 v0, 0x1

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I

    .line 69
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mContext:Landroid/content/Context;

    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v1

    .line 70
    invoke-virtual {v1}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getCpID()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmGameID()Ljava/lang/String;

    move-result-object v2

    .line 69
    invoke-static {v0, p0, v1, v2}, Lcom/uc/paymentsdk/network/Api;->syncSmsInfo(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 37
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onError(II)V
    .locals 8
    .param p1, "paramInt1"    # I
    .param p2, "paramInt2"    # I

    .prologue
    const/4 v7, 0x0

    .line 106
    const/4 v4, 0x2

    sput v4, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I

    .line 107
    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getSmsInfos()Lcom/uc/paymentsdk/payment/sms/SmsInfos;

    move-result-object v4

    if-nez v4, :cond_0

    .line 109
    :try_start_0
    iget-object v4, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mContext:Landroid/content/Context;

    invoke-static {v4}, Lcom/uc/paymentsdk/util/PrefUtil;->getSmsInfo(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    .line 110
    .local v3, "str":Ljava/lang/String;
    if-nez v3, :cond_2

    .line 111
    const/4 v4, 0x0

    invoke-static {v4}, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 136
    .end local v3    # "str":Ljava/lang/String;
    :cond_0
    :goto_0
    iget-object v4, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;

    monitor-enter v4

    .line 137
    :try_start_1
    iget-object v5, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Object;->notifyAll()V

    .line 136
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 139
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v4

    if-nez v4, :cond_5

    .line 140
    iget-object v4, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v4, :cond_1

    .line 141
    iget-object v4, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v4}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    .line 144
    :cond_1
    :goto_1
    return-void

    .line 114
    .restart local v3    # "str":Ljava/lang/String;
    :cond_2
    :try_start_2
    invoke-static {v3}, Lcom/uc/paymentsdk/network/XMLParser;->parseSmsInfo(Ljava/lang/String;)Lcom/uc/paymentsdk/payment/sms/SmsInfos;

    move-result-object v2

    .line 115
    .local v2, "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    if-nez v2, :cond_3

    .line 116
    const/4 v4, 0x0

    invoke-static {v4}, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto :goto_0

    .line 128
    .end local v2    # "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    .end local v3    # "str":Ljava/lang/String;
    :catch_0
    move-exception v4

    move-object v1, v4

    .line 129
    .local v1, "localIOException":Ljava/io/IOException;
    sput v7, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I

    .line 130
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 120
    .end local v1    # "localIOException":Ljava/io/IOException;
    .restart local v2    # "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    .restart local v3    # "str":Ljava/lang/String;
    :cond_3
    :try_start_3
    iget-object v4, v2, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    invoke-virtual {v4}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsendtime()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    invoke-static {v5}, Lcom/uc/paymentsdk/util/Utils;->getCurrentTime(Z)Ljava/lang/String;

    move-result-object v5

    const-string v6, "yyyy-MM-dd"

    invoke-static {v4, v5, v6}, Lcom/uc/paymentsdk/util/Utils;->dateDiffByDay(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    if-ltz v4, :cond_4

    .line 121
    const/4 v4, 0x0

    invoke-static {v4}, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 131
    .end local v2    # "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    .end local v3    # "str":Ljava/lang/String;
    :catch_1
    move-exception v4

    move-object v0, v4

    .line 132
    .local v0, "localException":Ljava/lang/Exception;
    sput v7, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I

    .line 133
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 124
    .end local v0    # "localException":Ljava/lang/Exception;
    .restart local v2    # "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    .restart local v3    # "str":Ljava/lang/String;
    :cond_4
    :try_start_4
    invoke-static {v2}, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    goto :goto_0

    .line 136
    .end local v2    # "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    .end local v3    # "str":Ljava/lang/String;
    :catchall_0
    move-exception v5

    :try_start_5
    monitor-exit v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    throw v5

    .line 143
    :cond_5
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v4

    invoke-virtual {v4}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_1
.end method

.method public onPreHandle(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
    .locals 5
    .param p1, "paramInt"    # I
    .param p2, "paramHttpResponse"    # Lorg/apache/http/HttpResponse;

    .prologue
    const/4 v4, 0x0

    .line 90
    invoke-static {p1, p2}, Lcom/uc/paymentsdk/util/Utils;->getBodyString(ILorg/apache/http/HttpResponse;)Ljava/lang/String;

    move-result-object v2

    .line 91
    .local v2, "str":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    move-object v3, v4

    .line 101
    :goto_0
    return-object v3

    .line 95
    :cond_0
    :try_start_0
    invoke-static {v2}, Lcom/uc/paymentsdk/network/XMLParser;->parseSmsInfo(Ljava/lang/String;)Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 100
    .local v1, "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    iget-object v3, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mContext:Landroid/content/Context;

    invoke-static {v3, v2}, Lcom/uc/paymentsdk/util/PrefUtil;->setSmsInfo(Landroid/content/Context;Ljava/lang/String;)V

    move-object v3, v1

    .line 101
    goto :goto_0

    .line 96
    .end local v1    # "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    :catch_0
    move-exception v0

    .line 97
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    move-object v3, v4

    .line 98
    goto :goto_0
.end method

.method public onSuccess(ILjava/lang/Object;)V
    .locals 2
    .param p1, "paramInt"    # I
    .param p2, "paramObject"    # Ljava/lang/Object;

    .prologue
    .line 76
    const/4 v0, 0x2

    sput v0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->sStatus:I

    .line 77
    check-cast p2, Lcom/uc/paymentsdk/payment/sms/SmsInfos;

    .end local p2    # "paramObject":Ljava/lang/Object;
    invoke-static {p2}, Lcom/uc/paymentsdk/util/Utils;->setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V

    .line 78
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;

    monitor-enter v0

    .line 79
    :try_start_0
    iget-object v1, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->LOCK:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Object;->notifyAll()V

    .line 78
    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 81
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    if-nez v0, :cond_1

    .line 82
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    if-eqz v0, :cond_0

    .line 83
    iget-object v0, p0, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;

    invoke-interface {v0}, Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;->onFinish()V

    .line 86
    :cond_0
    :goto_0
    return-void

    .line 78
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 85
    :cond_1
    invoke-virtual {p0}, Lcom/uc/paymentsdk/network/chain/SyncSmsInfoHandler;->getSuccessor()Lcom/uc/paymentsdk/network/chain/Handler;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/network/chain/Handler;->handleRequest()V

    goto :goto_0
.end method
