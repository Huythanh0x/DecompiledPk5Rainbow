.class public Lcom/uc/paymentsdk/payment/sms/SmsInfos;
.super Ljava/lang/Object;
.source "SmsInfos.java"


# instance fields
.field public smsInfos:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/uc/paymentsdk/payment/sms/SmsInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;

    .line 7
    return-void
.end method

.method private static parsePayment(I)Ljava/util/ArrayList;
    .locals 3
    .param p0, "paymoney"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 56
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 57
    .local v1, "smsSuitPrice":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    move v0, p0

    .line 59
    .local v0, "i":I
    :cond_0
    rem-int v2, p0, v0

    if-nez v2, :cond_1

    .line 60
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 61
    :cond_1
    add-int/lit8 v0, v0, -0x1

    .line 62
    if-gtz v0, :cond_0

    .line 63
    return-object v1
.end method


# virtual methods
.method public add(Lcom/uc/paymentsdk/payment/sms/SmsInfo;)V
    .locals 1
    .param p1, "paramSmsInfo"    # Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    .prologue
    .line 11
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 12
    return-void
.end method

.method public filterSmsInfo(Landroid/content/Context;I)Lcom/uc/paymentsdk/payment/sms/SmsInfo;
    .locals 9
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paymoney"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;
        }
    .end annotation

    .prologue
    .line 23
    const/4 v5, 0x0

    .line 24
    .local v5, "smsSuitPriceArr":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    const/4 v3, 0x0

    .line 25
    .local v3, "maxMoney":I
    const/4 v4, -0x1

    .line 26
    .local v4, "selectIndex":I
    iget-object v7, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    const/4 v8, 0x1

    if-ne v7, v8, :cond_0

    .line 27
    iget-object v7, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p0

    .end local p0    # "this":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    check-cast p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-object v7, p0

    .line 47
    :goto_0
    return-object v7

    .line 30
    .restart local p0    # "this":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v7, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-lt v1, v7, :cond_1

    .line 46
    const/4 v7, -0x1

    if-eq v4, v7, :cond_5

    .line 47
    iget-object v7, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;

    invoke-virtual {v7, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object p0

    .end local p0    # "this":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    check-cast p0, Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-object v7, p0

    goto :goto_0

    .line 31
    .restart local p0    # "this":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    :cond_1
    iget-object v7, p0, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->smsInfos:Ljava/util/ArrayList;

    invoke-virtual {v7, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    .line 32
    .local v2, "localSmsInfo":Lcom/uc/paymentsdk/payment/sms/SmsInfo;
    if-nez v5, :cond_2

    .line 33
    invoke-static {p2}, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->parsePayment(I)Ljava/util/ArrayList;

    move-result-object v5

    .line 34
    :cond_2
    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 35
    .local v6, "smsSuitriceIte":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/Integer;>;"
    :cond_3
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_4

    .line 30
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 36
    :cond_4
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 37
    .local v0, "aPrice":Ljava/lang/Integer;
    iget v7, v2, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->money:I

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v8

    if-ne v7, v8, :cond_3

    .line 38
    iget v7, v2, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->money:I

    if-le v7, v3, :cond_3

    .line 39
    iget v3, v2, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->money:I

    .line 40
    move v4, v1

    goto :goto_2

    .line 50
    .end local v0    # "aPrice":Ljava/lang/Integer;
    .end local v2    # "localSmsInfo":Lcom/uc/paymentsdk/payment/sms/SmsInfo;
    .end local v6    # "smsSuitriceIte":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/Integer;>;"
    :cond_5
    new-instance v7, Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;

    const-string v8, "\u5bf9\u4e0d\u8d77\uff0c\u60a8\u6240\u4f7f\u7528\u7684\u624b\u673a\u8fd0\u8425\u5546\u4e0d\u652f\u6301\u6b64\u77ed\u4fe1\u6fc0\u6d3b\u529f\u80fd\u3002"

    invoke-direct {v7, v8}, Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;-><init>(Ljava/lang/String;)V

    throw v7
.end method
