.class public Lcom/uc/paymentsdk/util/PrefUtil;
.super Ljava/lang/Object;
.source "PrefUtil.java"


# static fields
.field public static final EXTRA_TYPE:Ljava/lang/String; = "type"

.field public static final P_ARRIVE_COUNT:Ljava/lang/String; = "pref.com.uc.androidsdk.arrive"

.field public static final P_AVAILABLE_CHARGE_TYPE:Ljava/lang/String; = "pref.com.uc.androidsdk.availableChargeType"

.field public static final P_AVAILABLE_PAY_TYPE:Ljava/lang/String; = "pref.com.uc.androidsdk.availablePayType"

.field public static final P_DEFAULT_CHARGE_TYPE:Ljava/lang/String; = "pref.com.uc.androidsdk.defaultChargeType"

.field public static final P_PASSWORD:Ljava/lang/String; = "pref.com.uc.androidsdk.passowrd"

.field public static final P_SMSINFO:Ljava/lang/String; = "pref.com.uc.andoridsdk.smsinfo"

.field public static final P_SMSINFO_VERSION:Ljava/lang/String; = "pref.com.uc.andoridsdk.smsinfo.version"

.field public static final P_UID:Ljava/lang/String; = "pref.com.uc.androidsdk.uid"

.field public static final P_USERNAME:Ljava/lang/String; = "pref.com.uc.androidsdk.username"

.field public static final P_USER_SESSION:Ljava/lang/String; = "pref.com.uc.androidsdk.usersession"

.field private static sIsLogin:Z

.field public static sPref:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 26
    const/4 v0, 0x0

    sput-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    .line 14
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static clearArriveCount(Landroid/content/Context;)V
    .registers 2
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 111
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/uc/paymentsdk/util/PrefUtil;->setArriveCount(Landroid/content/Context;I)V

    .line 112
    return-void
.end method

.method public static clearPayedAmount(Landroid/content/Context;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 338
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 339
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 340
    :cond_7
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "_payedAmount"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 341
    .local v0, "str":Ljava/lang/String;
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1, v0}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 342
    return-void
.end method

.method public static clearUCUserName(Landroid/content/Context;)V
    .registers 3
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 54
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 55
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 56
    :cond_7
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 57
    .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.username"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 58
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 59
    return-void
.end method

.method public static clearUCUserPass(Landroid/content/Context;)V
    .registers 3
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 76
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 77
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 78
    :cond_7
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 79
    .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.passowrd"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 80
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 81
    return-void
.end method

.method public static declared-synchronized decreaseArriveCount(Landroid/content/Context;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 120
    const-class v1, Lcom/uc/paymentsdk/util/PrefUtil;

    monitor-enter v1

    :try_start_3
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->getArriveCount(Landroid/content/Context;)I

    move-result v0

    .line 121
    .local v0, "i":I
    if-lez v0, :cond_f

    .line 122
    const/4 v2, 0x1

    sub-int v2, v0, v2

    invoke-static {p0, v2}, Lcom/uc/paymentsdk/util/PrefUtil;->setArriveCount(Landroid/content/Context;I)V
    :try_end_f
    .catchall {:try_start_3 .. :try_end_f} :catchall_11

    .line 123
    :cond_f
    monitor-exit v1

    return-void

    .line 120
    .end local v0    # "i":I
    :catchall_11
    move-exception v2

    monitor-exit v1

    throw v2
.end method

.method public static getArriveCount(Landroid/content/Context;)I
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 98
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 99
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 100
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const-string v1, "pref.com.uc.androidsdk.arrive"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static getAvailableChargeType(Landroid/content/Context;Z)[Lcom/uc/paymentsdk/model/IType;
    .registers 3
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramBoolean"    # Z

    .prologue
    .line 192
    invoke-static {p1}, Lcom/uc/paymentsdk/util/PrefUtil;->getDefaultChargeType(Z)[Lcom/uc/paymentsdk/model/IType;

    move-result-object v0

    return-object v0
.end method

.method public static getAvailablePayType(Landroid/content/Context;Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 3
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/uc/paymentsdk/model/IType;",
            ">;"
        }
    .end annotation

    .prologue
    .line 232
    invoke-static {p1}, Lcom/uc/paymentsdk/util/PrefUtil;->getDefaultPayType(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public static getDefaultChargeType(Landroid/content/Context;)Ljava/lang/String;
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 236
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 237
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 238
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const-string v1, "pref.com.uc.androidsdk.defaultChargeType"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getDefaultChargeType(Z)[Lcom/uc/paymentsdk/model/IType;
    .registers 6
    .param p0, "paramBoolean"    # Z

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 255
    if-eqz p0, :cond_21

    .line 256
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/uc/paymentsdk/model/IType;

    const-string v1, "alipay"

    invoke-static {v1}, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;

    move-result-object v1

    aput-object v1, v0, v2

    .line 257
    const-string v1, "phonecard"

    invoke-static {v1}, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;

    move-result-object v1

    aput-object v1, v0, v3

    const-string v1, "g"

    invoke-static {v1}, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;

    move-result-object v1

    aput-object v1, v0, v4

    .line 258
    :goto_20
    return-object v0

    :cond_21
    new-array v0, v4, [Lcom/uc/paymentsdk/model/IType;

    const-string v1, "alipay"

    invoke-static {v1}, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;

    move-result-object v1

    aput-object v1, v0, v2

    .line 259
    const-string v1, "phonecard"

    invoke-static {v1}, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;

    move-result-object v1

    aput-object v1, v0, v3

    goto :goto_20
.end method

.method private static getDefaultPayType(Ljava/lang/String;)Ljava/util/ArrayList;
    .registers 3
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/uc/paymentsdk/model/IType;",
            ">;"
        }
    .end annotation

    .prologue
    .line 263
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 264
    .local v0, "localArrayList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/uc/paymentsdk/model/IType;>;"
    const-string v1, "overage"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_15

    const-string v1, "all"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1e

    .line 265
    :cond_15
    const-string v1, "upoint"

    invoke-static {v1}, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 266
    :cond_1e
    const-string v1, "sms"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2e

    const-string v1, "all"

    invoke-virtual {v1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_37

    .line 267
    :cond_2e
    const-string v1, "sms"

    invoke-static {v1}, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 268
    :cond_37
    return-object v0
.end method

.method public static getEditor()Landroid/content/SharedPreferences$Editor;
    .registers 1

    .prologue
    .line 36
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return-object v0

    :cond_6
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    goto :goto_5
.end method

.method public static getGFanUID(Landroid/content/Context;)I
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 134
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 135
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 136
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const-string v1, "pref.com.uc.androidsdk.uid"

    const/4 v2, -0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public static getPayedAmount(Landroid/content/Context;)I
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 323
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "_payedAmount"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 324
    .local v0, "str":Ljava/lang/String;
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_22

    .line 325
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 326
    :cond_22
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const/4 v2, 0x0

    invoke-interface {v1, v0, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v1

    return v1
.end method

.method public static getSmsInfo(Landroid/content/Context;)Ljava/lang/String;
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 317
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 318
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 319
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const-string v1, "pref.com.uc.andoridsdk.smsinfo"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getSmsInfoVersion(Landroid/content/Context;)Ljava/lang/String;
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 304
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 305
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 306
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const-string v1, "pref.com.uc.andoridsdk.smsinfo.version"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUCUserName(Landroid/content/Context;)Ljava/lang/String;
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 48
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 49
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 50
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const-string v1, "pref.com.uc.androidsdk.username"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUCUserPass(Landroid/content/Context;)Ljava/lang/String;
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 70
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 71
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 72
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const-string v1, "pref.com.uc.androidsdk.passowrd"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getUserSession(Landroid/content/Context;)Ljava/lang/String;
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 92
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 93
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 94
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    const-string v1, "pref.com.uc.androidsdk.usersession"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static declared-synchronized increaseArriveCount(Landroid/content/Context;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 115
    const-class v1, Lcom/uc/paymentsdk/util/PrefUtil;

    monitor-enter v1

    :try_start_3
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->getArriveCount(Landroid/content/Context;)I

    move-result v0

    .line 116
    .local v0, "i":I
    add-int/lit8 v2, v0, 0x1

    invoke-static {p0, v2}, Lcom/uc/paymentsdk/util/PrefUtil;->setArriveCount(Landroid/content/Context;I)V
    :try_end_c
    .catchall {:try_start_3 .. :try_end_c} :catchall_e

    .line 117
    monitor-exit v1

    return-void

    .line 115
    .end local v0    # "i":I
    :catchall_e
    move-exception v2

    monitor-exit v1

    throw v2
.end method

.method private static declared-synchronized init(Landroid/content/Context;)V
    .registers 3
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 30
    const-class v0, Lcom/uc/paymentsdk/util/PrefUtil;

    monitor-enter v0

    :try_start_3
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_d

    .line 31
    invoke-static {p0}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    sput-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    .line 32
    :cond_d
    const/4 v1, 0x0

    sput-boolean v1, Lcom/uc/paymentsdk/util/PrefUtil;->sIsLogin:Z
    :try_end_10
    .catchall {:try_start_3 .. :try_end_10} :catchall_12

    .line 33
    monitor-exit v0

    return-void

    .line 30
    :catchall_12
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static isLogin(Landroid/content/Context;)Z
    .registers 2
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 140
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 141
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 142
    :cond_7
    sget-boolean v0, Lcom/uc/paymentsdk/util/PrefUtil;->sIsLogin:Z

    return v0
.end method

.method public static login(Landroid/content/Context;)V
    .registers 2
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 146
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 147
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 148
    :cond_7
    const/4 v0, 0x1

    sput-boolean v0, Lcom/uc/paymentsdk/util/PrefUtil;->sIsLogin:Z

    .line 149
    return-void
.end method

.method public static logout(Landroid/content/Context;)V
    .registers 3
    .param p0, "paramContext"    # Landroid/content/Context;

    .prologue
    .line 152
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 153
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 154
    :cond_7
    const/4 v1, 0x0

    sput-boolean v1, Lcom/uc/paymentsdk/util/PrefUtil;->sIsLogin:Z

    .line 155
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 156
    .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.uid"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 157
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 158
    return-void
.end method

.method private static declared-synchronized setArriveCount(Landroid/content/Context;I)V
    .registers 5
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I

    .prologue
    .line 105
    const-class v0, Lcom/uc/paymentsdk/util/PrefUtil;

    monitor-enter v0

    :try_start_3
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_a

    .line 106
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 107
    :cond_a
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "pref.com.uc.androidsdk.arrive"

    invoke-interface {v1, v2, p1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_19
    .catchall {:try_start_3 .. :try_end_19} :catchall_1b

    .line 108
    monitor-exit v0

    return-void

    .line 105
    :catchall_1b
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private static setAvailableChargeType(Landroid/content/Context;[Ljava/lang/String;)V
    .registers 10
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramArrayOfString"    # [Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 162
    sget-object v4, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v4, :cond_9

    .line 163
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 164
    :cond_9
    const/4 v0, 0x0

    .line 165
    .local v0, "i":I
    array-length v1, p1

    .line 166
    .local v1, "j":I
    :goto_b
    if-lt v0, v1, :cond_3b

    .line 176
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 177
    .local v3, "localStringBuilder":Ljava/lang/StringBuilder;
    const/4 v1, 0x0

    .line 178
    array-length v2, p1

    .line 179
    .local v2, "k":I
    :goto_14
    if-lt v1, v2, :cond_67

    .line 183
    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v4

    const/4 v5, -0x1

    if-eq v4, v5, :cond_27

    .line 184
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    sub-int/2addr v4, v6

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    .line 185
    :cond_27
    sget-object v4, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v4}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    .line 186
    const-string v5, "pref.com.uc.androidsdk.availableChargeType"

    .line 187
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 186
    invoke-interface {v4, v5, v6}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v4

    .line 187
    invoke-interface {v4}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 188
    return-void

    .line 167
    .end local v2    # "k":I
    .end local v3    # "localStringBuilder":Ljava/lang/StringBuilder;
    :cond_3b
    const-string v4, "g"

    aget-object v5, p1, v0

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_54

    .line 168
    sub-int v4, v1, v6

    aget-object v4, p1, v4

    aput-object v4, p1, v0

    .line 169
    sub-int v4, v1, v6

    const-string v5, "g"

    aput-object v5, p1, v4

    .line 174
    :cond_51
    :goto_51
    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    .line 170
    :cond_54
    const-string v4, "alipay"

    aget-object v5, p1, v0

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_51

    .line 171
    aget-object v4, p1, v7

    aput-object v4, p1, v0

    .line 172
    const-string v4, "alipay"

    aput-object v4, p1, v7

    goto :goto_51

    .line 180
    .restart local v2    # "k":I
    .restart local v3    # "localStringBuilder":Ljava/lang/StringBuilder;
    :cond_67
    aget-object v4, p1, v1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 181
    add-int/lit8 v1, v1, 0x1

    goto :goto_14
.end method

.method private static setAvailablePayType(Landroid/content/Context;Ljava/lang/String;)V
    .registers 11
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 197
    sget-object v5, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v5, :cond_9

    .line 198
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 199
    :cond_9
    const-string v5, "sms"

    invoke-virtual {p1, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {p1, p1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    if-le v5, v6, :cond_3d

    .line 200
    const-string v5, ","

    invoke-virtual {p1, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 201
    .local v0, "arrayOfString":[Ljava/lang/String;
    const/4 v1, 0x0

    .line 202
    .local v1, "i":I
    array-length v2, v0

    .line 203
    .local v2, "j":I
    :goto_1d
    if-lt v1, v2, :cond_4d

    .line 213
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 214
    .local v4, "localStringBuilder":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .line 215
    array-length v3, v0

    .line 216
    .local v3, "k":I
    :goto_26
    if-lt v2, v3, :cond_79

    .line 220
    const-string v5, ","

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_39

    .line 222
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->length()I

    move-result v5

    sub-int/2addr v5, v7

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;

    .line 223
    :cond_39
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 225
    .end local v0    # "arrayOfString":[Ljava/lang/String;
    .end local v1    # "i":I
    .end local v2    # "j":I
    .end local v3    # "k":I
    .end local v4    # "localStringBuilder":Ljava/lang/StringBuilder;
    :cond_3d
    sget-object v5, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v5}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    .line 226
    const-string v6, "pref.com.uc.androidsdk.availablePayType"

    invoke-interface {v5, v6, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v5

    .line 227
    invoke-interface {v5}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 228
    return-void

    .line 204
    .restart local v0    # "arrayOfString":[Ljava/lang/String;
    .restart local v1    # "i":I
    .restart local v2    # "j":I
    :cond_4d
    const-string v5, "sms"

    aget-object v6, v0, v1

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_66

    .line 205
    sub-int v5, v2, v7

    aget-object v5, v0, v5

    aput-object v5, v0, v1

    .line 206
    sub-int v5, v2, v7

    const-string v6, "sms"

    aput-object v6, v0, v5

    .line 211
    :cond_63
    :goto_63
    add-int/lit8 v1, v1, 0x1

    goto :goto_1d

    .line 207
    :cond_66
    const-string v5, "upoint"

    aget-object v6, v0, v1

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_63

    .line 208
    aget-object v5, v0, v8

    aput-object v5, v0, v1

    .line 209
    const-string v5, "upoint"

    aput-object v5, v0, v8

    goto :goto_63

    .line 217
    .restart local v3    # "k":I
    .restart local v4    # "localStringBuilder":Ljava/lang/StringBuilder;
    :cond_79
    aget-object v5, v0, v2

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ","

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 218
    add-int/lit8 v2, v2, 0x1

    goto :goto_26
.end method

.method public static setDefaultChargeType(Landroid/content/Context;Ljava/lang/String;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 243
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 244
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 245
    :cond_7
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 246
    .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    if-nez p1, :cond_18

    .line 247
    const-string v1, "pref.com.uc.androidsdk.defaultChargeType"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 251
    :goto_14
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 252
    return-void

    .line 249
    :cond_18
    const-string v1, "pref.com.uc.androidsdk.defaultChargeType"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_14
.end method

.method public static setGFanUID(Landroid/content/Context;I)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I

    .prologue
    .line 126
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 127
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 128
    :cond_7
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 129
    .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.uid"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 130
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 131
    return-void
.end method

.method public static setPayedAmount(Landroid/content/Context;I)V
    .registers 6
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramInt"    # I

    .prologue
    .line 330
    sget-object v2, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v2, :cond_7

    .line 331
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 332
    :cond_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "_payedAmount"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 333
    .local v1, "str":Ljava/lang/String;
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->getPayedAmount(Landroid/content/Context;)I

    move-result v0

    .line 334
    .local v0, "i":I
    sget-object v2, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    add-int v3, v0, p1

    invoke-interface {v2, v1, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 335
    return-void
.end method

.method public static setSmsInfo(Landroid/content/Context;Ljava/lang/String;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 310
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 311
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 312
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "pref.com.uc.andoridsdk.smsinfo"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 313
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 314
    return-void
.end method

.method public static setSmsInfoVersion(Landroid/content/Context;Ljava/lang/String;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 296
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v0, :cond_7

    .line 297
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 298
    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 299
    const-string v1, "pref.com.uc.andoridsdk.smsinfo.version"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 300
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 301
    return-void
.end method

.method public static setUCUserName(Landroid/content/Context;Ljava/lang/String;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 40
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 41
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 42
    :cond_7
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 43
    .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.username"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 44
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 45
    return-void
.end method

.method public static setUCUserPass(Landroid/content/Context;Ljava/lang/String;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 62
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 63
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 64
    :cond_7
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 65
    .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.passowrd"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 66
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 67
    return-void
.end method

.method public static setUserSession(Landroid/content/Context;Ljava/lang/String;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 84
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    if-nez v1, :cond_7

    .line 85
    invoke-static {p0}, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V

    .line 86
    :cond_7
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 87
    .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.usersession"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 88
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 89
    return-void
.end method

.method public static supportChargeType(Landroid/content/Context;Ljava/lang/String;)Z
    .registers 7
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    .line 273
    invoke-static {p0, v4}, Lcom/uc/paymentsdk/util/PrefUtil;->getAvailableChargeType(Landroid/content/Context;Z)[Lcom/uc/paymentsdk/model/IType;

    move-result-object v0

    .line 274
    .local v0, "arrayOfIType":[Lcom/uc/paymentsdk/model/IType;
    const/4 v1, 0x0

    .line 275
    .local v1, "i":I
    array-length v2, v0

    .line 276
    .local v2, "j":I
    :goto_7
    if-lt v1, v2, :cond_b

    .line 281
    const/4 v3, 0x0

    :goto_a
    return v3

    .line 277
    :cond_b
    aget-object v3, v0, v1

    invoke-interface {v3}, Lcom/uc/paymentsdk/model/IType;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_19

    move v3, v4

    .line 278
    goto :goto_a

    .line 279
    :cond_19
    add-int/lit8 v1, v1, 0x1

    goto :goto_7
.end method

.method public static declared-synchronized syncChargeChannels(Landroid/content/Context;[Ljava/lang/String;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramArrayOfString"    # [Ljava/lang/String;

    .prologue
    .line 286
    const-class v0, Lcom/uc/paymentsdk/util/PrefUtil;

    monitor-enter v0

    :try_start_3
    invoke-static {p0, p1}, Lcom/uc/paymentsdk/util/PrefUtil;->setAvailableChargeType(Landroid/content/Context;[Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_8

    .line 287
    monitor-exit v0

    return-void

    .line 286
    :catchall_8
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized syncPayChannels(Landroid/content/Context;Ljava/lang/String;)V
    .registers 4
    .param p0, "paramContext"    # Landroid/content/Context;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 291
    const-class v0, Lcom/uc/paymentsdk/util/PrefUtil;

    monitor-enter v0

    :try_start_3
    invoke-static {p0, p1}, Lcom/uc/paymentsdk/util/PrefUtil;->setAvailablePayType(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_3 .. :try_end_6} :catchall_8

    .line 292
    monitor-exit v0

    return-void

    .line 291
    :catchall_8
    move-exception v1

    monitor-exit v0

    throw v1
.end method
