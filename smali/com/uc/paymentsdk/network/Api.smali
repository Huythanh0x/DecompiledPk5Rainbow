.class public Lcom/uc/paymentsdk/network/Api;
.super Ljava/lang/Object;
.source "Api.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static confirmPayResult(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    .param p2, "paramString1"    # Ljava/lang/String;
    .param p3, "paramString2"    # Ljava/lang/String;

    .prologue
    .line 42
    new-instance v4, Ljava/util/HashMap;

    const/4 v0, 0x2

    invoke-direct {v4, v0}, Ljava/util/HashMap;-><init>(I)V

    .line 43
    .local v4, "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v0, "order_id"

    invoke-virtual {v4, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    const-string v0, "app_key"

    invoke-virtual {v4, v0, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    new-instance v0, Lcom/uc/paymentsdk/network/ApiTask;

    const/4 v2, 0x5

    .line 46
    const-string v5, "post"

    move-object v1, p0

    move-object v3, p1

    .line 45
    invoke-direct/range {v0 .. v5}, Lcom/uc/paymentsdk/network/ApiTask;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V

    .line 47
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/network/ApiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 48
    return-void
.end method

.method public static pay(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Lcom/uc/paymentsdk/payment/PaymentInfo;Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;)V
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    .param p2, "paramPaymentInfo"    # Lcom/uc/paymentsdk/payment/PaymentInfo;
    .param p3, "upayinfo"    # Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;

    .prologue
    .line 19
    new-instance v4, Ljava/util/HashMap;

    const/16 v0, 0x9

    invoke-direct {v4, v0}, Ljava/util/HashMap;-><init>(I)V

    .line 20
    .local v4, "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v0, "user_id"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getUserid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 21
    const-string v0, "&cpid"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getCpid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 22
    const-string v0, "&gameid"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getGameid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 23
    const-string v0, "&optid"

    invoke-virtual {p2}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 24
    const-string v0, "&u_money"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getUpoint()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 25
    const-string v0, "&charge"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getUmoney()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 26
    const-string v0, "&consume_id"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getConsumeid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 27
    const-string v0, "&ucid"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getUsersession()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 28
    const-string v0, "&sign"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getSign()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 29
    const-string v0, "&uc_token"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getUctoken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 30
    const-string v0, "&pay_pwd"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getPaypwd()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    const-string v0, "&consume_time"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getTm()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    const-string v0, "&tm"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getTm()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 33
    const-string v0, "&eid"

    invoke-static {}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getEid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 34
    const-string v0, "&ch_code"

    invoke-virtual {p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->getChcode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 35
    new-instance v0, Lcom/uc/paymentsdk/network/ApiTask;

    const/4 v2, 0x3

    .line 36
    const-string v5, "post"

    move-object v1, p0

    move-object v3, p1

    .line 35
    invoke-direct/range {v0 .. v5}, Lcom/uc/paymentsdk/network/ApiTask;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V

    .line 36
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/network/ApiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 37
    return-void
.end method

.method public static postSmsPayment(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    .param p2, "cpid"    # Ljava/lang/String;
    .param p3, "gameid"    # Ljava/lang/String;
    .param p4, "optid"    # Ljava/lang/String;
    .param p5, "charge"    # I
    .param p6, "optobj"    # Ljava/lang/String;
    .param p7, "sms_channel"    # Ljava/lang/String;
    .param p8, "sms_port"    # Ljava/lang/String;
    .param p9, "sms_content"    # Ljava/lang/String;
    .param p10, "sms_type"    # I

    .prologue
    .line 113
    invoke-static {p0}, Lcom/uc/paymentsdk/util/Utils;->getSessionID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 114
    .local v2, "usersession":Ljava/lang/String;
    const/16 v0, 0x14

    invoke-static {v0}, Lcom/uc/paymentsdk/util/Utils;->createARanConsumeID(I)Ljava/lang/String;

    move-result-object v0

    .line 115
    .local v0, "consumeid":Ljava/lang/String;
    const-string v1, ""

    .line 117
    .local v1, "sign":Ljava/lang/String;
    :try_start_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    const/4 v5, 0x5

    if-gt v4, v5, :cond_0

    move-object v4, v2

    .line 118
    :goto_0
    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 119
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v4

    const/4 v5, 0x5

    if-gt v4, v5, :cond_1

    move-object v4, p2

    :goto_1
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 120
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v4

    const/4 v5, 0x5

    if-gt v4, v5, :cond_2

    move-object v4, p3

    :goto_2
    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 121
    invoke-virtual {v3, p5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 117
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/uc/paymentsdk/commons/codec/MD5;->getMD5(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 125
    :goto_3
    new-instance v4, Ljava/util/HashMap;

    const/4 v3, 0x4

    invoke-direct {v4, v3}, Ljava/util/HashMap;-><init>(I)V

    .line 126
    .local v4, "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v3, "user_id"

    invoke-virtual {v4, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 127
    const-string v2, "cpid"

    .end local v2    # "usersession":Ljava/lang/String;
    invoke-virtual {v4, v2, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 128
    const-string p2, "gameid"

    .end local p2    # "cpid":Ljava/lang/String;
    invoke-virtual {v4, p2, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 129
    const-string p2, "optid"

    invoke-virtual {v4, p2, p4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 130
    const-string p2, "consume_id"

    invoke-virtual {v4, p2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 131
    const-string p2, "charge"

    invoke-static {p5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    .end local p3    # "gameid":Ljava/lang/String;
    invoke-virtual {v4, p2, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 132
    const-string p2, "optobj"

    invoke-virtual {v4, p2, p6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    const-string p2, "sms_channel"

    invoke-virtual {v4, p2, p7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    const-string p2, "sms_port"

    invoke-virtual {v4, p2, p8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 135
    const-string p2, "sms_content"

    invoke-virtual {v4, p2, p9}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 136
    const-string p2, "sms_type"

    invoke-static/range {p10 .. p10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p3

    invoke-virtual {v4, p2, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 137
    const-string p2, "sendtime"

    const/4 p3, 0x0

    invoke-static {p3}, Lcom/uc/paymentsdk/util/Utils;->getCurrentTime(Z)Ljava/lang/String;

    move-result-object p3

    invoke-virtual {v4, p2, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 138
    const-string p2, "sign"

    invoke-virtual {v4, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 139
    new-instance v0, Lcom/uc/paymentsdk/network/ApiTask;

    .end local v0    # "consumeid":Ljava/lang/String;
    const/16 v2, 0x8

    .line 140
    const-string v5, "post"

    move-object v1, p0

    move-object v3, p1

    .line 139
    invoke-direct/range {v0 .. v5}, Lcom/uc/paymentsdk/network/ApiTask;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V

    .line 141
    .end local v1    # "sign":Ljava/lang/String;
    const/4 p0, 0x0

    new-array p0, p0, [Ljava/lang/Void;

    .end local p0    # "paramContext":Landroid/content/Context;
    invoke-virtual {v0, p0}, Lcom/uc/paymentsdk/network/ApiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 142
    return-void

    .line 118
    .end local v4    # "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    .restart local v0    # "consumeid":Ljava/lang/String;
    .restart local v1    # "sign":Ljava/lang/String;
    .restart local v2    # "usersession":Ljava/lang/String;
    .restart local p0    # "paramContext":Landroid/content/Context;
    .restart local p2    # "cpid":Ljava/lang/String;
    .restart local p3    # "gameid":Ljava/lang/String;
    :cond_0
    const/4 v4, 0x0

    const/4 v5, 0x5

    :try_start_1
    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_0

    .line 119
    :cond_1
    const/4 v4, 0x0

    const/4 v5, 0x5

    invoke-virtual {p2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    goto/16 :goto_1

    .line 120
    :cond_2
    const/4 v4, 0x0

    const/4 v5, 0x5

    invoke-virtual {p3, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v4

    goto/16 :goto_2

    .line 122
    :catch_0
    move-exception v3

    goto :goto_3
.end method

.method public static queryUPointDiscount(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    .param p2, "cpid"    # Ljava/lang/String;
    .param p3, "gameid"    # Ljava/lang/String;
    .param p4, "charge"    # I

    .prologue
    .line 53
    new-instance v4, Ljava/util/HashMap;

    const/4 v0, 0x1

    invoke-direct {v4, v0}, Ljava/util/HashMap;-><init>(I)V

    .line 54
    .local v4, "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v0, "cpid"

    invoke-virtual {v4, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 55
    const-string v0, "gameid"

    invoke-virtual {v4, v0, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    const-string v0, "u_money"

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    new-instance v0, Lcom/uc/paymentsdk/network/ApiTask;

    const/16 v2, 0x12

    .line 58
    const-string v5, "post"

    move-object v1, p0

    move-object v3, p1

    .line 57
    invoke-direct/range {v0 .. v5}, Lcom/uc/paymentsdk/network/ApiTask;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V

    .line 59
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/network/ApiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 60
    return-void
.end method

.method public static syncChargeChannel(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;)V
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    .prologue
    .line 64
    new-instance v4, Ljava/util/HashMap;

    const/4 v0, 0x1

    invoke-direct {v4, v0}, Ljava/util/HashMap;-><init>(I)V

    .line 65
    .local v4, "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v0, "action"

    const-string v1, "getRechargeChannels"

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 66
    new-instance v0, Lcom/uc/paymentsdk/network/ApiTask;

    const/16 v2, 0x11

    .line 67
    const-string v5, "post"

    move-object v1, p0

    move-object v3, p1

    .line 66
    invoke-direct/range {v0 .. v5}, Lcom/uc/paymentsdk/network/ApiTask;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V

    .line 68
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/network/ApiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 69
    return-void
.end method

.method public static syncPayChannel(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;)V
    .locals 7
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;

    .prologue
    const/4 v6, 0x0

    .line 73
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4, v6}, Ljava/util/HashMap;-><init>(I)V

    .line 74
    .local v4, "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v0, Lcom/uc/paymentsdk/network/ApiTask;

    const/4 v2, 0x6

    .line 75
    const-string v5, "post"

    move-object v1, p0

    move-object v3, p1

    .line 74
    invoke-direct/range {v0 .. v5}, Lcom/uc/paymentsdk/network/ApiTask;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V

    .line 76
    new-array v1, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/network/ApiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 77
    return-void
.end method

.method public static syncSmsInfo(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    .param p2, "cpid"    # Ljava/lang/String;
    .param p3, "gameid"    # Ljava/lang/String;

    .prologue
    .line 93
    new-instance v4, Ljava/util/HashMap;

    const/4 v0, 0x1

    invoke-direct {v4, v0}, Ljava/util/HashMap;-><init>(I)V

    .line 94
    .local v4, "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {p0}, Lcom/uc/paymentsdk/util/Utils;->getSessionID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v6

    .line 95
    .local v6, "usersession":Ljava/lang/String;
    if-nez v6, :cond_0

    .line 96
    const/16 v0, 0x8

    invoke-static {v0}, Lcom/uc/paymentsdk/util/Utils;->createARanSessionid(I)Ljava/lang/String;

    move-result-object v6

    .line 97
    invoke-static {p0, v6}, Lcom/uc/paymentsdk/util/PrefUtil;->setUserSession(Landroid/content/Context;Ljava/lang/String;)V

    .line 99
    :cond_0
    const-string v0, "user_id"

    invoke-virtual {v4, v0, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 100
    const-string v0, "cpid"

    invoke-virtual {v4, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 101
    const-string v0, "gameid"

    invoke-virtual {v4, v0, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 102
    const-string v0, "area"

    const-string v1, ""

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 103
    const-string v0, "imsi"

    invoke-static {p0}, Lcom/uc/paymentsdk/util/Utils;->getSimNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 104
    new-instance v0, Lcom/uc/paymentsdk/network/ApiTask;

    const/4 v2, 0x7

    .line 105
    const-string v5, "post"

    move-object v1, p0

    move-object v3, p1

    .line 104
    invoke-direct/range {v0 .. v5}, Lcom/uc/paymentsdk/network/ApiTask;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V

    .line 106
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/network/ApiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 107
    return-void
.end method

.method public static syncUPointDiscount(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramTaskHandler"    # Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
    .param p2, "cpid"    # Ljava/lang/String;
    .param p3, "gameid"    # Ljava/lang/String;
    .param p4, "charge"    # I

    .prologue
    .line 82
    new-instance v4, Ljava/util/HashMap;

    const/4 v0, 0x1

    invoke-direct {v4, v0}, Ljava/util/HashMap;-><init>(I)V

    .line 83
    .local v4, "localHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v0, "cpid"

    invoke-virtual {v4, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 84
    const-string v0, "gameid"

    invoke-virtual {v4, v0, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 85
    const-string v0, "u_money"

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 86
    new-instance v0, Lcom/uc/paymentsdk/network/ApiTask;

    const/16 v2, 0x12

    .line 87
    const-string v5, "post"

    move-object v1, p0

    move-object v3, p1

    .line 86
    invoke-direct/range {v0 .. v5}, Lcom/uc/paymentsdk/network/ApiTask;-><init>(Landroid/content/Context;ILcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/util/HashMap;Ljava/lang/String;)V

    .line 88
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/network/ApiTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 89
    return-void
.end method
