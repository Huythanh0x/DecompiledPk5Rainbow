.class public Lcom/uc/paymentsdk/payment/sms/SmsInfo;
.super Ljava/lang/Object;
.source "SmsInfo.java"


# static fields
.field public static final ACTION_SMS_SENT:Ljava/lang/String; = "com.uc.androidsdk.SMS_SENT_ACTION"


# instance fields
.field public extinfo:Ljava/lang/String;

.field public infobeforesend:Ljava/lang/String;

.field public money:I

.field public needconfirm:Z

.field public smschannelid:Ljava/lang/String;

.field public smsconfirmheader:Ljava/lang/String;

.field public smsconfirmnumber:Ljava/lang/String;

.field public smsendtime:Ljava/lang/String;

.field public smsheader:Ljava/lang/String;

.field public smsnumber:Ljava/lang/String;

.field public smstype:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-boolean v1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->needconfirm:Z

    .line 13
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsnumber:Ljava/lang/String;

    .line 14
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsconfirmnumber:Ljava/lang/String;

    .line 15
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsheader:Ljava/lang/String;

    .line 16
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsconfirmheader:Ljava/lang/String;

    .line 17
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->infobeforesend:Ljava/lang/String;

    .line 18
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->extinfo:Ljava/lang/String;

    .line 19
    iput v1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smstype:I

    .line 20
    iput v1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->money:I

    .line 21
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smschannelid:Ljava/lang/String;

    .line 22
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsendtime:Ljava/lang/String;

    .line 10
    return-void
.end method

.method public static sendSms(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString1"    # Ljava/lang/String;
    .param p2, "paramString2"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/SecurityException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 62
    invoke-static {}, Landroid/telephony/SmsManager;->getDefault()Landroid/telephony/SmsManager;

    move-result-object v0

    .line 64
    .local v0, "localSmsManager":Landroid/telephony/SmsManager;
    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.uc.androidsdk.SMS_SENT_ACTION"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 63
    invoke-static {p0, v3, v1, v3}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v4

    .line 66
    .local v4, "localPendingIntent":Landroid/app/PendingIntent;
    const/4 v2, 0x0

    .line 67
    const/4 v5, 0x0

    move-object v1, p1

    move-object v3, p2

    .line 66
    :try_start_0
    invoke-virtual/range {v0 .. v5}, Landroid/telephony/SmsManager;->sendTextMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_0

    .line 72
    return-void

    .line 69
    :catch_0
    move-exception v6

    .line 70
    .local v6, "e":Ljava/lang/SecurityException;
    throw v6
.end method


# virtual methods
.method public getContent()Ljava/lang/String;
    .locals 4

    .prologue
    .line 49
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsheader:Ljava/lang/String;

    const-string v2, "\\(\\*\\)"

    const-string v3, "#"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "smscontent":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->extinfo:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 51
    return-object v0
.end method

.method public getExtInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->extinfo:Ljava/lang/String;

    return-object v0
.end method

.method public getInfobeforesend()Ljava/lang/String;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->infobeforesend:Ljava/lang/String;

    return-object v0
.end method

.method public getMoney()I
    .locals 1

    .prologue
    .line 139
    iget v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->money:I

    return v0
.end method

.method public getSmsConfirmContent()Ljava/lang/String;
    .locals 4

    .prologue
    .line 55
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsconfirmheader:Ljava/lang/String;

    const-string v2, "\\(\\*\\)"

    const-string v3, "#"

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 56
    .local v0, "smscontent":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->extinfo:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 57
    return-object v0
.end method

.method public getSmsConfirmNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsconfirmnumber:Ljava/lang/String;

    return-object v0
.end method

.method public getSmschannelid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smschannelid:Ljava/lang/String;

    return-object v0
.end method

.method public getSmsconfirmheader()Ljava/lang/String;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsconfirmheader:Ljava/lang/String;

    return-object v0
.end method

.method public getSmsconfirmnumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 183
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsconfirmnumber:Ljava/lang/String;

    return-object v0
.end method

.method public getSmsendtime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsendtime:Ljava/lang/String;

    return-object v0
.end method

.method public getSmsheader()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsheader:Ljava/lang/String;

    return-object v0
.end method

.method public getSmsnumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsnumber:Ljava/lang/String;

    return-object v0
.end method

.method public getSmstype()I
    .locals 1

    .prologue
    .line 131
    iget v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smstype:I

    return v0
.end method

.method public isNeedconfirm()Z
    .locals 1

    .prologue
    .line 105
    iget-boolean v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->needconfirm:Z

    return v0
.end method

.method public isSuccess(Ljava/lang/String;)Z
    .locals 1
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 45
    const-string v0, "\u786e\u8ba4\u652f\u4ed8"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method public parseConfirmResultSms(Ljava/lang/String;)Z
    .locals 1
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 91
    const-string v0, "\u901a\u4fe1\u8d26\u6237\u652f\u4ed8"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method public parseConfirmSmsConfirmNumber(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 85
    const-string v0, "\u8bf7\u56de\u590d\u6570\u5b57"

    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 86
    const-string v1, "\u8bf7\u56de\u590d\u6570\u5b57"

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v0, v1

    const-string v1, "\u786e\u8ba4\u652f\u4ed8"

    invoke-virtual {p1, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 85
    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected final parseConfirmSmsSupportTelNumber(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "paramString1"    # Ljava/lang/String;
    .param p2, "paramString2"    # Ljava/lang/String;

    .prologue
    .line 97
    .line 98
    :try_start_0
    invoke-virtual {p1, p2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v0, v1

    .line 97
    invoke-virtual {p1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 101
    :goto_0
    return-object v0

    .line 99
    :catch_0
    move-exception v0

    .line 101
    const-string v0, ""

    goto :goto_0
.end method

.method public sendFirstSms(Landroid/content/Context;)V
    .locals 3
    .param p1, "paramContext"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 76
    :try_start_0
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsnumber()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getContent()Ljava/lang/String;

    move-result-object v2

    invoke-static {p1, v1, v2}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->sendSms(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 81
    return-void

    .line 78
    :catch_0
    move-exception v1

    move-object v0, v1

    .line 79
    .local v0, "e":Ljava/lang/Exception;
    throw v0
.end method

.method public setExtInfo(Lcom/uc/paymentsdk/payment/PaymentInfo;)V
    .locals 3
    .param p1, "info"    # Lcom/uc/paymentsdk/payment/PaymentInfo;

    .prologue
    .line 30
    const-string v0, ""

    .line 31
    .local v0, "extinfostr":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getCpID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 32
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmGameID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 33
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 34
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "99"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 35
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "70"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 36
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "00"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 37
    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->extinfo:Ljava/lang/String;

    .line 38
    return-void
.end method

.method public setInfobeforesend(Ljava/lang/String;)V
    .locals 0
    .param p1, "infobeforesend"    # Ljava/lang/String;

    .prologue
    .line 167
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->infobeforesend:Ljava/lang/String;

    .line 168
    return-void
.end method

.method public setMoney(I)V
    .locals 0
    .param p1, "money"    # I

    .prologue
    .line 143
    iput p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->money:I

    .line 144
    return-void
.end method

.method public setNeedconfirm(Z)V
    .locals 0
    .param p1, "needconfirm"    # Z

    .prologue
    .line 187
    iput-boolean p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->needconfirm:Z

    .line 188
    return-void
.end method

.method public setSmschannelid(Ljava/lang/String;)V
    .locals 0
    .param p1, "smschannelid"    # Ljava/lang/String;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smschannelid:Ljava/lang/String;

    .line 152
    return-void
.end method

.method public setSmsconfirmheader(Ljava/lang/String;)V
    .locals 0
    .param p1, "smsconfirmheader"    # Ljava/lang/String;

    .prologue
    .line 175
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsconfirmheader:Ljava/lang/String;

    .line 176
    return-void
.end method

.method public setSmsconfirmnumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "smsconfirmnumber"    # Ljava/lang/String;

    .prologue
    .line 118
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsconfirmnumber:Ljava/lang/String;

    .line 119
    return-void
.end method

.method public setSmsendtime(Ljava/lang/String;)V
    .locals 0
    .param p1, "smsendtime"    # Ljava/lang/String;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsendtime:Ljava/lang/String;

    .line 160
    return-void
.end method

.method public setSmsheader(Ljava/lang/String;)V
    .locals 0
    .param p1, "smsheader"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsheader:Ljava/lang/String;

    .line 127
    return-void
.end method

.method public setSmsnumber(Ljava/lang/String;)V
    .locals 0
    .param p1, "smsnumber"    # Ljava/lang/String;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smsnumber:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public setSmstype(I)V
    .locals 0
    .param p1, "smstype"    # I

    .prologue
    .line 135
    iput p1, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->smstype:I

    .line 136
    return-void
.end method
