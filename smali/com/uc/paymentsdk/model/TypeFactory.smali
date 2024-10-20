.class public Lcom/uc/paymentsdk/model/TypeFactory;
.super Ljava/lang/Object;
.source "TypeFactory.java"


# static fields
.field public static final TYPE_PAY_SMS:Ljava/lang/String; = "sms"

.field public static final TYPE_PAY_UPOINT:Ljava/lang/String; = "upoint"

.field private static sTypes:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/ref/SoftReference",
            "<",
            "Lcom/uc/paymentsdk/model/IType;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clear()V
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x0

    sput-object v0, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;

    .line 68
    return-void
.end method

.method public static declared-synchronized factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
    .locals 6
    .param p0, "paramString"    # Ljava/lang/String;

    .prologue
    .line 16
    const-class v3, Lcom/uc/paymentsdk/model/TypeFactory;

    monitor-enter v3

    :try_start_0
    sget-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;

    if-nez v2, :cond_0

    .line 17
    new-instance v2, Ljava/util/HashMap;

    const/4 v4, 0x4

    invoke-direct {v2, v4}, Ljava/util/HashMap;-><init>(I)V

    sput-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;

    .line 19
    :cond_0
    sget-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;

    invoke-virtual {v2, p0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 21
    sget-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;

    invoke-virtual {v2, p0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/SoftReference;

    invoke-virtual {v2}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uc/paymentsdk/model/IType;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 22
    .local v0, "localObject":Lcom/uc/paymentsdk/model/IType;
    if-eqz v0, :cond_1

    move-object v1, v0

    .line 30
    .end local v0    # "localObject":Lcom/uc/paymentsdk/model/IType;
    .local v1, "localObject":Lcom/uc/paymentsdk/model/IType;
    :goto_0
    monitor-exit v3

    return-object v1

    .line 25
    .end local v1    # "localObject":Lcom/uc/paymentsdk/model/IType;
    :cond_1
    :try_start_1
    const-string v2, "upoint"

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string v2, "sms"

    invoke-virtual {v2, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 26
    :cond_2
    new-instance v0, Lcom/uc/paymentsdk/model/PayType;

    invoke-static {p0}, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0}, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeDesc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0}, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeIconFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v0, p0, v2, v4, v5}, Lcom/uc/paymentsdk/model/PayType;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    .restart local v0    # "localObject":Lcom/uc/paymentsdk/model/IType;
    :goto_1
    sget-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;

    new-instance v4, Ljava/lang/ref/SoftReference;

    invoke-direct {v4, v0}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v2, p0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v1, v0

    .line 30
    .end local v0    # "localObject":Lcom/uc/paymentsdk/model/IType;
    .restart local v1    # "localObject":Lcom/uc/paymentsdk/model/IType;
    goto :goto_0

    .line 28
    .end local v1    # "localObject":Lcom/uc/paymentsdk/model/IType;
    :cond_3
    new-instance v0, Lcom/uc/paymentsdk/model/ChargeType;

    invoke-static {p0}, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {p0}, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeDesc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p0}, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeIconFileName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v0, p0, v2, v4, v5}, Lcom/uc/paymentsdk/model/ChargeType;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .restart local v0    # "localObject":Lcom/uc/paymentsdk/model/IType;
    goto :goto_1

    .line 16
    .end local v0    # "localObject":Lcom/uc/paymentsdk/model/IType;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method private static getTypeDesc(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "paramString"    # Ljava/lang/String;

    .prologue
    .line 35
    const-string v0, "upoint"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 36
    const-string v0, "\u7528U\u70b9\u8d2d\u4e70<br /><small><small><font color=\'#999999\'>10U\u70b9\u4ef7\u503c1\u5143</font></small></small>"

    .line 38
    :goto_0
    return-object v0

    .line 37
    :cond_0
    const-string v0, "sms"

    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 38
    const-string v0, "\u53d1\u77ed\u4fe1\u76f4\u63a5\u8d2d\u4e70<br /><small><small><font color=\'#999999\'>\u53d1\u9001%s\u5143\u77ed\u4fe1\uff0c\u53ef\u8d2d\u4e70\u8be5\u5185\u5bb9</font></small></small>"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getSmsPayment()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 39
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "type not supported. "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private static getTypeIconFileName(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "paramString"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->isHdpi()Z

    move-result v0

    .line 50
    .local v0, "bool":Z
    const-string v1, "upoint"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 52
    if-eqz v0, :cond_0

    .line 53
    const-string v1, "upoint_logo_hdpi.png"

    .line 60
    :goto_0
    return-object v1

    .line 54
    :cond_0
    const-string v1, "upoint_logo.png"

    goto :goto_0

    .line 56
    :cond_1
    const-string v1, "sms"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 58
    if-eqz v0, :cond_2

    .line 59
    const-string v1, "sms_logo_hdpi.png"

    goto :goto_0

    .line 60
    :cond_2
    const-string v1, "sms_logo.png"

    goto :goto_0

    .line 62
    :cond_3
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "type not supported."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private static getTypeName(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "paramString"    # Ljava/lang/String;

    .prologue
    .line 44
    const/4 v0, 0x0

    return-object v0
.end method
