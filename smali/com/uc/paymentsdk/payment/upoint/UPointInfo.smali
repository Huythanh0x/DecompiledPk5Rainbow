.class public Lcom/uc/paymentsdk/payment/upoint/UPointInfo;
.super Ljava/lang/Object;
.source "UPointInfo.java"


# instance fields
.field discount:Ljava/lang/String;

.field discountinfo:Ljava/lang/String;

.field discounttext:Ljava/lang/String;

.field userphone:Ljava/lang/String;

.field vipdiscount:Ljava/lang/String;

.field vipdiscounttext:Ljava/lang/String;

.field vipdiscounttime:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 4
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discount:Ljava/lang/String;

    .line 5
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discounttext:Ljava/lang/String;

    .line 6
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->userphone:Ljava/lang/String;

    .line 7
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscount:Ljava/lang/String;

    .line 8
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscounttext:Ljava/lang/String;

    .line 9
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscounttime:Ljava/lang/String;

    .line 10
    const-string v0, ""

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discountinfo:Ljava/lang/String;

    .line 3
    return-void
.end method


# virtual methods
.method public getDiscount()Ljava/lang/String;
    .registers 2

    .prologue
    .line 13
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discount:Ljava/lang/String;

    return-object v0
.end method

.method public getDiscountinfo()Ljava/lang/String;
    .registers 2

    .prologue
    .line 49
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discountinfo:Ljava/lang/String;

    return-object v0
.end method

.method public getDiscounttext()Ljava/lang/String;
    .registers 2

    .prologue
    .line 19
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discounttext:Ljava/lang/String;

    return-object v0
.end method

.method public getUserphone()Ljava/lang/String;
    .registers 2

    .prologue
    .line 25
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->userphone:Ljava/lang/String;

    return-object v0
.end method

.method public getVipdiscount()Ljava/lang/String;
    .registers 2

    .prologue
    .line 31
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscount:Ljava/lang/String;

    return-object v0
.end method

.method public getVipdiscounttext()Ljava/lang/String;
    .registers 2

    .prologue
    .line 37
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscounttext:Ljava/lang/String;

    return-object v0
.end method

.method public getVipdiscounttime()Ljava/lang/String;
    .registers 2

    .prologue
    .line 43
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscounttime:Ljava/lang/String;

    return-object v0
.end method

.method public setDiscount(Ljava/lang/String;)V
    .registers 2
    .param p1, "discount"    # Ljava/lang/String;

    .prologue
    .line 16
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discount:Ljava/lang/String;

    .line 17
    return-void
.end method

.method public setDiscountinfo(Ljava/lang/String;)V
    .registers 2
    .param p1, "discountinfo"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discountinfo:Ljava/lang/String;

    .line 53
    return-void
.end method

.method public setDiscounttext(Ljava/lang/String;)V
    .registers 2
    .param p1, "discounttext"    # Ljava/lang/String;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->discounttext:Ljava/lang/String;

    .line 23
    return-void
.end method

.method public setUserphone(Ljava/lang/String;)V
    .registers 2
    .param p1, "userphone"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->userphone:Ljava/lang/String;

    .line 29
    return-void
.end method

.method public setVipdiscount(Ljava/lang/String;)V
    .registers 2
    .param p1, "vipdiscount"    # Ljava/lang/String;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscount:Ljava/lang/String;

    .line 35
    return-void
.end method

.method public setVipdiscounttext(Ljava/lang/String;)V
    .registers 2
    .param p1, "vipdiscounttext"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscounttext:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setVipdiscounttime(Ljava/lang/String;)V
    .registers 2
    .param p1, "vipdiscounttime"    # Ljava/lang/String;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->vipdiscounttime:Ljava/lang/String;

    .line 47
    return-void
.end method
