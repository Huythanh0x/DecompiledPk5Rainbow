.class public Lcom/uc/paymentsdk/payment/PaymentInfo;
.super Ljava/lang/Object;
.implements Ljava/io/Serializable;
.source "PaymentInfo.java"

.field public final static CHANNELID:Ljava/lang/String; = "70"

.field public final static EXTINFO:Ljava/lang/String; = "00"

.field public final static PAYTYPE_ALL:Ljava/lang/String; = "all"

.field public final static PAYTYPE_OVERAGE:Ljava/lang/String; = "overage"

.field public final static PAYTYPE_SMS:Ljava/lang/String; = "sms"

.field public final static PHONETYPEID:Ljava/lang/String; = "99"

.field private mActionID:Ljava/lang/String;

.field private mAppkey:Ljava/lang/String;

.field private mCpID:Ljava/lang/String;

.field private mGameID:Ljava/lang/String;

.field private mMoney:I

.field private mOrderID:Ljava/lang/String;

.field private mPassword:Ljava/lang/String;

.field private mPayDesc:Ljava/lang/String;

.field private mPayName:Ljava/lang/String;

.field private mPayType:Ljava/lang/String;

.field private mUsername:Ljava/lang/String;

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
  .parameter "payname" # Ljava/lang/String;
  .parameter "gameid" # Ljava/lang/String;
  .parameter "actionid" # Ljava/lang/String;
  .parameter "paydesc" # Ljava/lang/String;
  .parameter "paymoney" # I
  .registers 15
  .prologue
    const/4 v7, 0
  .line 30
    const-string v6, "sms"
    move-object v0, p0
    move-object v1, p1
    move-object v2, p2
    move-object v3, p3
    move-object v4, p4
    move v5, p5
    move-object v8, v7
    invoke-direct/range { v0 .. v8 }, Lcom/uc/paymentsdk/payment/PaymentInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  .line 31
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
  .parameter "payname" # Ljava/lang/String;
  .parameter "gameid" # Ljava/lang/String;
  .parameter "actionid" # Ljava/lang/String;
  .parameter "paydesc" # Ljava/lang/String;
  .parameter "paymoney" # I
  .parameter "orderid" # Ljava/lang/String;
  .registers 16
  .prologue
  .line 35
    const-string v6, "sms"
    const/4 v8, 0
    move-object v0, p0
    move-object v1, p1
    move-object v2, p2
    move-object v3, p3
    move-object v4, p4
    move v5, p5
    move-object v7, p6
    invoke-direct/range { v0 .. v8 }, Lcom/uc/paymentsdk/payment/PaymentInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  .line 36
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  .parameter "payname" # Ljava/lang/String;
  .parameter "gameid" # Ljava/lang/String;
  .parameter "actionid" # Ljava/lang/String;
  .parameter "paydesc" # Ljava/lang/String;
  .parameter "paymoney" # I
  .parameter "paytype" # Ljava/lang/String;
  .parameter "orderid" # Ljava/lang/String;
  .parameter "username" # Ljava/lang/String;
  .registers 9
  .prologue
  .line 38
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 40
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayName:Ljava/lang/String;
  .line 41
    iput-object p4, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayDesc:Ljava/lang/String;
  .line 42
    iput p5, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mMoney:I
  .line 43
    iput-object p6, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayType:Ljava/lang/String;
  .line 44
    iput-object p7, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mOrderID:Ljava/lang/String;
  .line 45
    iput-object p8, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mUsername:Ljava/lang/String;
  .line 46
    iput-object p2, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mGameID:Ljava/lang/String;
  .line 47
    iput-object p3, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mActionID:Ljava/lang/String;
  .line 48
    return-void
.end method

.method public getAppkey()Ljava/lang/String;
  .registers 2
  .prologue
  .line 112
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mAppkey:Ljava/lang/String;
    return-object v0
.end method

.method public getCpID()Ljava/lang/String;
  .registers 2
  .prologue
  .line 132
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mCpID:Ljava/lang/String;
    return-object v0
.end method

.method public getMoney()I
  .registers 2
  .prologue
  .line 72
    iget v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mMoney:I
    return v0
.end method

.method public getOrderID()Ljava/lang/String;
  .registers 2
  .prologue
  .line 122
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mOrderID:Ljava/lang/String;
    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
  .registers 2
  .prologue
  .line 92
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPassword:Ljava/lang/String;
    return-object v0
.end method

.method public getPaydesc()Ljava/lang/String;
  .registers 2
  .prologue
  .line 102
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayDesc:Ljava/lang/String;
    return-object v0
.end method

.method public getPayname()Ljava/lang/String;
  .registers 2
  .prologue
  .line 62
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayName:Ljava/lang/String;
    return-object v0
.end method

.method public getPaytype()Ljava/lang/String;
  .registers 2
  .prologue
  .line 82
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayType:Ljava/lang/String;
    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
  .registers 2
  .prologue
  .line 52
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mUsername:Ljava/lang/String;
    return-object v0
.end method

.method public getmActionID()Ljava/lang/String;
  .registers 2
  .prologue
  .line 149
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mActionID:Ljava/lang/String;
    return-object v0
.end method

.method public getmGameID()Ljava/lang/String;
  .registers 2
  .prologue
  .line 141
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mGameID:Ljava/lang/String;
    return-object v0
.end method

.method public setAppkey(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 117
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mAppkey:Ljava/lang/String;
  .line 118
    return-void
.end method

.method public setCpID(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 137
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mCpID:Ljava/lang/String;
  .line 138
    return-void
.end method

.method public setMoney(I)V
  .parameter "paramInt" # I
  .registers 2
  .prologue
  .line 77
    iput p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mMoney:I
  .line 78
    return-void
.end method

.method public setOrderID(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 127
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mOrderID:Ljava/lang/String;
  .line 128
    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 97
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPassword:Ljava/lang/String;
  .line 98
    return-void
.end method

.method public setPaydesc(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 107
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayDesc:Ljava/lang/String;
  .line 108
    return-void
.end method

.method public setPayname(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 67
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayName:Ljava/lang/String;
  .line 68
    return-void
.end method

.method public setPaytype(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 87
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mPayType:Ljava/lang/String;
  .line 88
    return-void
.end method

.method public setUsername(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 57
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mUsername:Ljava/lang/String;
  .line 58
    return-void
.end method

.method public setmActionID(Ljava/lang/String;)V
  .parameter "mActionID" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 153
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mActionID:Ljava/lang/String;
  .line 154
    return-void
.end method

.method public setmGameID(Ljava/lang/String;)V
  .parameter "mGameID" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 145
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentInfo;->mGameID:Ljava/lang/String;
  .line 146
    return-void
.end method
