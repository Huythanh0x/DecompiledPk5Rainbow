.class public Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;
.super Ljava/lang/Object;
.source "UPointPayInfo.java"


# static fields
.field private static final EID:Ljava/lang/String; = "4"


# instance fields
.field private chcode:Ljava/lang/String;

.field private consumeid:Ljava/lang/String;

.field private cpid:Ljava/lang/String;

.field private gameid:Ljava/lang/String;

.field private paramcontext:Landroid/content/Context;

.field private paypwd:Ljava/lang/String;

.field private paypwdtoken:Ljava/lang/String;

.field private sign:Ljava/lang/String;

.field private tm:Ljava/lang/String;

.field private uctoken:Ljava/lang/String;

.field private umoney:I

.field private upoint:I

.field private userid:Ljava/lang/String;

.field private userpass:Ljava/lang/String;

.field private usersession:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .registers 10
    .param p1, "userid"    # Ljava/lang/String;
    .param p2, "userpass"    # Ljava/lang/String;
    .param p3, "paypwd"    # Ljava/lang/String;
    .param p4, "cpid"    # Ljava/lang/String;
    .param p5, "gameid"    # Ljava/lang/String;
    .param p6, "upoint"    # I
    .param p7, "timpstamp"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userid:Ljava/lang/String;

    .line 12
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userpass:Ljava/lang/String;

    .line 13
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->usersession:Ljava/lang/String;

    .line 14
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwd:Ljava/lang/String;

    .line 15
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwdtoken:Ljava/lang/String;

    .line 16
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->cpid:Ljava/lang/String;

    .line 17
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->gameid:Ljava/lang/String;

    .line 20
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->sign:Ljava/lang/String;

    .line 21
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->consumeid:Ljava/lang/String;

    .line 22
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->uctoken:Ljava/lang/String;

    .line 23
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    .line 24
    const-string v0, "70"

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->chcode:Ljava/lang/String;

    .line 29
    invoke-virtual {p0, p1}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->setUserid(Ljava/lang/String;)V

    .line 30
    invoke-virtual {p0, p2}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->setUserpass(Ljava/lang/String;)V

    .line 31
    invoke-virtual {p0, p3}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->setPaypwd(Ljava/lang/String;)V

    .line 32
    invoke-virtual {p0, p4}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->setCpid(Ljava/lang/String;)V

    .line 33
    invoke-virtual {p0, p5}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->setGameid(Ljava/lang/String;)V

    .line 34
    invoke-virtual {p0, p7}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->setTm(Ljava/lang/String;)V

    .line 35
    invoke-virtual {p0, p6}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->setUpoint(I)V

    .line 36
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    if-eqz v0, :cond_55

    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x1

    if-ge v0, v1, :cond_58

    .line 37
    :cond_55
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->createTimeStamp()V

    .line 39
    :cond_58
    iget v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->upoint:I

    invoke-virtual {p0, v0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->createCharge(I)V

    .line 40
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->CreateUsersession()V

    .line 41
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->createConsumeId()V

    .line 42
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->createSign()V

    .line 43
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->createUCToken()V

    .line 44
    return-void
.end method

.method public static getEid()Ljava/lang/String;
    .registers 1

    .prologue
    .line 170
    const-string v0, "4"

    return-object v0
.end method


# virtual methods
.method public CreateUsersession()V
    .registers 2

    .prologue
    .line 178
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paramcontext:Landroid/content/Context;

    invoke-static {v0}, Lcom/uc/paymentsdk/util/Utils;->getSessionID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->usersession:Ljava/lang/String;

    .line 179
    return-void
.end method

.method public createCharge(I)V
    .registers 3
    .param p1, "u_money"    # I

    .prologue
    .line 182
    iget v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->upoint:I

    mul-int/lit8 v0, v0, 0xa

    div-int/lit8 v0, v0, 0x64

    iput v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->umoney:I

    .line 183
    return-void
.end method

.method public createConsumeId()V
    .registers 4

    .prologue
    .line 186
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userid:Ljava/lang/String;

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->cpid:Ljava/lang/String;

    iget-object v2, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->gameid:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/uc/paymentsdk/util/Utils;->getUPConsumeid(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->consumeid:Ljava/lang/String;

    .line 187
    return-void
.end method

.method public createPayPwdToken()V
    .registers 5

    .prologue
    .line 203
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwd:Ljava/lang/String;

    if-eqz v1, :cond_4a

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwd:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_4a

    .line 205
    :try_start_c
    new-instance v1, Ljava/lang/StringBuilder;

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userid:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 206
    iget-object v3, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwd:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 205
    invoke-static {v2}, Lcom/uc/paymentsdk/commons/codec/MD5;->getMD5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 206
    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 207
    iget-object v2, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 205
    invoke-static {v1}, Lcom/uc/paymentsdk/commons/codec/MD5;->getMD5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwdtoken:Ljava/lang/String;
    :try_end_42
    .catch Ljava/lang/Exception; {:try_start_c .. :try_end_42} :catch_43

    .line 216
    :goto_42
    return-void

    .line 209
    :catch_43
    move-exception v1

    move-object v0, v1

    .line 210
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, ""

    iput-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwd:Ljava/lang/String;

    goto :goto_42

    .line 214
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_4a
    const-string v1, ""

    iput-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwd:Ljava/lang/String;

    goto :goto_42
.end method

.method public createSign()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x5

    .line 195
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->usersession:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-gt v1, v2, :cond_3e

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->usersession:Ljava/lang/String;

    .line 196
    :goto_e
    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 197
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->cpid:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-gt v1, v2, :cond_45

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->cpid:Ljava/lang/String;

    :goto_1f
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 198
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->gameid:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-gt v1, v2, :cond_4c

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->gameid:Ljava/lang/String;

    :goto_2d
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 199
    iget v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->upoint:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 195
    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->sign:Ljava/lang/String;

    .line 200
    return-void

    .line 195
    :cond_3e
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->usersession:Ljava/lang/String;

    .line 196
    invoke-virtual {v1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    goto :goto_e

    .line 197
    :cond_45
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->cpid:Ljava/lang/String;

    invoke-virtual {v1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    goto :goto_1f

    .line 198
    :cond_4c
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->gameid:Ljava/lang/String;

    invoke-virtual {v1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    goto :goto_2d
.end method

.method public createTimeStamp()V
    .registers 3

    .prologue
    .line 174
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_12

    const/4 v0, 0x0

    invoke-static {v0}, Lcom/uc/paymentsdk/util/Utils;->getCurrentTime(Z)Ljava/lang/String;

    move-result-object v0

    :goto_f
    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    .line 175
    return-void

    .line 174
    :cond_12
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    goto :goto_f
.end method

.method public createUCToken()V
    .registers 3

    .prologue
    .line 219
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "`"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userid:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "`"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userpass:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->uctoken:Ljava/lang/String;

    .line 220
    return-void
.end method

.method public getChcode()Ljava/lang/String;
    .registers 2

    .prologue
    .line 162
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->chcode:Ljava/lang/String;

    return-object v0
.end method

.method public getConsumeid()Ljava/lang/String;
    .registers 2

    .prologue
    .line 136
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->consumeid:Ljava/lang/String;

    return-object v0
.end method

.method public getCpid()Ljava/lang/String;
    .registers 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->cpid:Ljava/lang/String;

    return-object v0
.end method

.method public getGameid()Ljava/lang/String;
    .registers 2

    .prologue
    .line 104
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->gameid:Ljava/lang/String;

    return-object v0
.end method

.method public getParamcontext()Landroid/content/Context;
    .registers 2

    .prologue
    .line 47
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paramcontext:Landroid/content/Context;

    return-object v0
.end method

.method public getPaypwd()Ljava/lang/String;
    .registers 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwd:Ljava/lang/String;

    return-object v0
.end method

.method public getPaypwdtoken()Ljava/lang/String;
    .registers 2

    .prologue
    .line 88
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwdtoken:Ljava/lang/String;

    return-object v0
.end method

.method public getSign()Ljava/lang/String;
    .registers 2

    .prologue
    .line 128
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->sign:Ljava/lang/String;

    return-object v0
.end method

.method public getTm()Ljava/lang/String;
    .registers 2

    .prologue
    .line 152
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    return-object v0
.end method

.method public getUctoken()Ljava/lang/String;
    .registers 2

    .prologue
    .line 144
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->uctoken:Ljava/lang/String;

    return-object v0
.end method

.method public getUmoney()I
    .registers 2

    .prologue
    .line 120
    iget v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->umoney:I

    return v0
.end method

.method public getUpoint()I
    .registers 2

    .prologue
    .line 112
    iget v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->upoint:I

    return v0
.end method

.method public getUserid()Ljava/lang/String;
    .registers 2

    .prologue
    .line 55
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userid:Ljava/lang/String;

    return-object v0
.end method

.method public getUserpass()Ljava/lang/String;
    .registers 2

    .prologue
    .line 63
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userpass:Ljava/lang/String;

    return-object v0
.end method

.method public getUsersession()Ljava/lang/String;
    .registers 2

    .prologue
    .line 71
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->usersession:Ljava/lang/String;

    return-object v0
.end method

.method public setChcode(Ljava/lang/String;)V
    .registers 2
    .param p1, "chcode"    # Ljava/lang/String;

    .prologue
    .line 166
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->chcode:Ljava/lang/String;

    .line 167
    return-void
.end method

.method public setConsumeid(Ljava/lang/String;)V
    .registers 2
    .param p1, "consumeid"    # Ljava/lang/String;

    .prologue
    .line 140
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->consumeid:Ljava/lang/String;

    .line 141
    return-void
.end method

.method public setCpid(Ljava/lang/String;)V
    .registers 2
    .param p1, "cpid"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->cpid:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public setGameid(Ljava/lang/String;)V
    .registers 2
    .param p1, "gameid"    # Ljava/lang/String;

    .prologue
    .line 108
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->gameid:Ljava/lang/String;

    .line 109
    return-void
.end method

.method public setParamcontext(Landroid/content/Context;)V
    .registers 2
    .param p1, "paramcontext"    # Landroid/content/Context;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paramcontext:Landroid/content/Context;

    .line 52
    return-void
.end method

.method public setPaypwd(Ljava/lang/String;)V
    .registers 2
    .param p1, "paypwd"    # Ljava/lang/String;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwd:Ljava/lang/String;

    .line 84
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->createPayPwdToken()V

    .line 85
    return-void
.end method

.method public setPaypwdtoken(Ljava/lang/String;)V
    .registers 2
    .param p1, "paypwdtoken"    # Ljava/lang/String;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->paypwdtoken:Ljava/lang/String;

    .line 93
    return-void
.end method

.method public setSign(Ljava/lang/String;)V
    .registers 2
    .param p1, "sign"    # Ljava/lang/String;

    .prologue
    .line 132
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->sign:Ljava/lang/String;

    .line 133
    return-void
.end method

.method public setTm(Ljava/lang/String;)V
    .registers 2
    .param p1, "tm"    # Ljava/lang/String;

    .prologue
    .line 156
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->tm:Ljava/lang/String;

    .line 157
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->createUCToken()V

    .line 158
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->createPayPwdToken()V

    .line 159
    return-void
.end method

.method public setUctoken(Ljava/lang/String;)V
    .registers 2
    .param p1, "uctoken"    # Ljava/lang/String;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->uctoken:Ljava/lang/String;

    .line 149
    return-void
.end method

.method public setUmoney(I)V
    .registers 2
    .param p1, "umoney"    # I

    .prologue
    .line 124
    iput p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->umoney:I

    .line 125
    return-void
.end method

.method public setUpoint(I)V
    .registers 2
    .param p1, "upoint"    # I

    .prologue
    .line 116
    iput p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->upoint:I

    .line 117
    return-void
.end method

.method public setUserid(Ljava/lang/String;)V
    .registers 2
    .param p1, "userid"    # Ljava/lang/String;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userid:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setUserpass(Ljava/lang/String;)V
    .registers 2
    .param p1, "userpass"    # Ljava/lang/String;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userpass:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setUsersession(Ljava/lang/String;)V
    .registers 2
    .param p1, "usersession"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->usersession:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public updateConsumeId()V
    .registers 4

    .prologue
    .line 190
    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->clearUPConsumeid()V

    .line 191
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->userid:Ljava/lang/String;

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->cpid:Ljava/lang/String;

    iget-object v2, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->gameid:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/uc/paymentsdk/util/Utils;->getUPConsumeid(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;->consumeid:Ljava/lang/String;

    .line 192
    return-void
.end method
