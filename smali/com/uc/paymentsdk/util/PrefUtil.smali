.class public Lcom/uc/paymentsdk/util/PrefUtil;
.super Ljava/lang/Object;
.source "PrefUtil.java"

.field public final static EXTRA_TYPE:Ljava/lang/String; = "type"

.field public final static P_ARRIVE_COUNT:Ljava/lang/String; = "pref.com.uc.androidsdk.arrive"

.field public final static P_AVAILABLE_CHARGE_TYPE:Ljava/lang/String; = "pref.com.uc.androidsdk.availableChargeType"

.field public final static P_AVAILABLE_PAY_TYPE:Ljava/lang/String; = "pref.com.uc.androidsdk.availablePayType"

.field public final static P_DEFAULT_CHARGE_TYPE:Ljava/lang/String; = "pref.com.uc.androidsdk.defaultChargeType"

.field public final static P_PASSWORD:Ljava/lang/String; = "pref.com.uc.androidsdk.passowrd"

.field public final static P_SMSINFO:Ljava/lang/String; = "pref.com.uc.andoridsdk.smsinfo"

.field public final static P_SMSINFO_VERSION:Ljava/lang/String; = "pref.com.uc.andoridsdk.smsinfo.version"

.field public final static P_UID:Ljava/lang/String; = "pref.com.uc.androidsdk.uid"

.field public final static P_USERNAME:Ljava/lang/String; = "pref.com.uc.androidsdk.username"

.field public final static P_USER_SESSION:Ljava/lang/String; = "pref.com.uc.androidsdk.usersession"

.field private static sIsLogin:Z

.field public static sPref:Landroid/content/SharedPreferences;

.method static constructor <clinit>()V
  .registers 1
  .prologue
  .line 26
    const/4 v0, 0
    sput-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
  .line 14
    return-void
.end method

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 14
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static clearArriveCount(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 2
  .prologue
  .line 111
    const/4 v0, 0
    invoke-static { p0, v0 }, Lcom/uc/paymentsdk/util/PrefUtil;->setArriveCount(Landroid/content/Context;I)V
  .line 112
    return-void
.end method

.method public static clearPayedAmount(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 338
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 339
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 340
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;
    move-result-object v2
    invoke-virtual { v2 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;
    move-result-object v2
    invoke-static { v2 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v2, "_payedAmount"
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
  .line 341
  .local v0, "str":Ljava/lang/String;
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    invoke-interface { v1, v0 }, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    invoke-interface { v1 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 342
    return-void
.end method

.method public static clearUCUserName(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 54
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 55
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 56
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 57
  .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.username"
    invoke-interface { v0, v1 }, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
  .line 58
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 59
    return-void
.end method

.method public static clearUCUserPass(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 76
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 77
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 78
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 79
  .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.passowrd"
    invoke-interface { v0, v1 }, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
  .line 80
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 81
    return-void
.end method

.method public static declared-synchronized decreaseArriveCount(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .catchall { :L0 .. :L1 } :L2
  .registers 4
  .prologue
  .line 120
    const-class v1, Lcom/uc/paymentsdk/util/PrefUtil;
    monitor-enter v1
  :L0
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->getArriveCount(Landroid/content/Context;)I
    move-result v0
  .line 121
  .local v0, "i":I
    if-lez v0, :L1
  .line 122
    const/4 v2, 1
    sub-int v2, v0, v2
    invoke-static { p0, v2 }, Lcom/uc/paymentsdk/util/PrefUtil;->setArriveCount(Landroid/content/Context;I)V
  :L1
  .line 123
    monitor-exit v1
    return-void
  :L2
  .line 120
  .end local v0
    move-exception v2
    monitor-exit v1
    throw v2
.end method

.method public static getArriveCount(Landroid/content/Context;)I
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 98
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 99
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 100
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const-string v1, "pref.com.uc.androidsdk.arrive"
    const/4 v2, 0
    invoke-interface { v0, v1, v2 }, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I
    move-result v0
    return v0
.end method

.method public static getAvailableChargeType(Landroid/content/Context;Z)[Lcom/uc/paymentsdk/model/IType;
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramBoolean" # Z
  .registers 3
  .prologue
  .line 192
    invoke-static { p1 }, Lcom/uc/paymentsdk/util/PrefUtil;->getDefaultChargeType(Z)[Lcom/uc/paymentsdk/model/IType;
    move-result-object v0
    return-object v0
.end method

.method public static getAvailablePayType(Landroid/content/Context;Ljava/lang/String;)Ljava/util/ArrayList;
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
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 232
    invoke-static { p1 }, Lcom/uc/paymentsdk/util/PrefUtil;->getDefaultPayType(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v0
    return-object v0
.end method

.method public static getDefaultChargeType(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 236
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 237
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 238
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const-string v1, "pref.com.uc.androidsdk.defaultChargeType"
    const/4 v2, 0
    invoke-interface { v0, v1, v2 }, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static getDefaultChargeType(Z)[Lcom/uc/paymentsdk/model/IType;
  .parameter "paramBoolean" # Z
  .registers 6
  .prologue
    const/4 v4, 2
    const/4 v3, 1
    const/4 v2, 0
  .line 255
    if-eqz p0, :L1
  .line 256
    const/4 v0, 3
    new-array v0, v0, [Lcom/uc/paymentsdk/model/IType;
    const-string v1, "alipay"
    invoke-static { v1 }, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
    move-result-object v1
    aput-object v1, v0, v2
  .line 257
    const-string v1, "phonecard"
    invoke-static { v1 }, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
    move-result-object v1
    aput-object v1, v0, v3
    const-string v1, "g"
    invoke-static { v1 }, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
    move-result-object v1
    aput-object v1, v0, v4
  :L0
  .line 258
    return-object v0
  :L1
    new-array v0, v4, [Lcom/uc/paymentsdk/model/IType;
    const-string v1, "alipay"
    invoke-static { v1 }, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
    move-result-object v1
    aput-object v1, v0, v2
  .line 259
    const-string v1, "phonecard"
    invoke-static { v1 }, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
    move-result-object v1
    aput-object v1, v0, v3
    goto :L0
.end method

.method private static getDefaultPayType(Ljava/lang/String;)Ljava/util/ArrayList;
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
  .parameter "paramString" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 263
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct { v0 }, Ljava/util/ArrayList;-><init>()V
  .line 264
  .local v0, "localArrayList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/uc/paymentsdk/model/IType;>;"
    const-string v1, "overage"
    invoke-virtual { v1, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, :L0
    const-string v1, "all"
    invoke-virtual { v1, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, :L1
  :L0
  .line 265
    const-string v1, "upoint"
    invoke-static { v1 }, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
    move-result-object v1
    invoke-virtual { v0, v1 }, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
  :L1
  .line 266
    const-string v1, "sms"
    invoke-virtual { v1, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, :L2
    const-string v1, "all"
    invoke-virtual { v1, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, :L3
  :L2
  .line 267
    const-string v1, "sms"
    invoke-static { v1 }, Lcom/uc/paymentsdk/model/TypeFactory;->factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
    move-result-object v1
    invoke-virtual { v0, v1 }, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
  :L3
  .line 268
    return-object v0
.end method

.method public static getEditor()Landroid/content/SharedPreferences$Editor;
  .registers 1
  .prologue
  .line 36
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L1
    const/4 v0, 0
  :L0
    return-object v0
  :L1
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v0 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    goto :L0
.end method

.method public static getGFanUID(Landroid/content/Context;)I
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 134
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 135
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 136
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const-string v1, "pref.com.uc.androidsdk.uid"
    const/4 v2, -1
    invoke-interface { v0, v1, v2 }, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I
    move-result v0
    return v0
.end method

.method public static getPayedAmount(Landroid/content/Context;)I
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 323
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;
    move-result-object v2
    invoke-virtual { v2 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;
    move-result-object v2
    invoke-static { v2 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v2, "_payedAmount"
    invoke-virtual { v1, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
  .line 324
  .local v0, "str":Ljava/lang/String;
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 325
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 326
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const/4 v2, 0
    invoke-interface { v1, v0, v2 }, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I
    move-result v1
    return v1
.end method

.method public static getSmsInfo(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 317
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 318
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 319
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const-string v1, "pref.com.uc.andoridsdk.smsinfo"
    const/4 v2, 0
    invoke-interface { v0, v1, v2 }, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static getSmsInfoVersion(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 304
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 305
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 306
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const-string v1, "pref.com.uc.andoridsdk.smsinfo.version"
    const/4 v2, 0
    invoke-interface { v0, v1, v2 }, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static getUCUserName(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 48
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 49
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 50
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const-string v1, "pref.com.uc.androidsdk.username"
    const/4 v2, 0
    invoke-interface { v0, v1, v2 }, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static getUCUserPass(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 70
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 71
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 72
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const-string v1, "pref.com.uc.androidsdk.passowrd"
    const/4 v2, 0
    invoke-interface { v0, v1, v2 }, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static getUserSession(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 4
  .prologue
  .line 92
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 93
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 94
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    const-string v1, "pref.com.uc.androidsdk.usersession"
    const/4 v2, 0
    invoke-interface { v0, v1, v2 }, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static declared-synchronized increaseArriveCount(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .catchall { :L0 .. :L1 } :L2
  .registers 4
  .prologue
  .line 115
    const-class v1, Lcom/uc/paymentsdk/util/PrefUtil;
    monitor-enter v1
  :L0
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->getArriveCount(Landroid/content/Context;)I
    move-result v0
  .line 116
  .local v0, "i":I
    add-int/lit8 v2, v0, 1
    invoke-static { p0, v2 }, Lcom/uc/paymentsdk/util/PrefUtil;->setArriveCount(Landroid/content/Context;I)V
  :L1
  .line 117
    monitor-exit v1
    return-void
  :L2
  .line 115
  .end local v0
    move-exception v2
    monitor-exit v1
    throw v2
.end method

.method private static declared-synchronized init(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .catchall { :L0 .. :L2 } :L3
  .registers 3
  .prologue
  .line 30
    const-class v0, Lcom/uc/paymentsdk/util/PrefUtil;
    monitor-enter v0
  :L0
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L1
  .line 31
    invoke-static { p0 }, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;
    move-result-object v1
    sput-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
  :L1
  .line 32
    const/4 v1, 0
    sput-boolean v1, Lcom/uc/paymentsdk/util/PrefUtil;->sIsLogin:Z
  :L2
  .line 33
    monitor-exit v0
    return-void
  :L3
  .line 30
    move-exception v1
    monitor-exit v0
    throw v1
.end method

.method public static isLogin(Landroid/content/Context;)Z
  .parameter "paramContext" # Landroid/content/Context;
  .registers 2
  .prologue
  .line 140
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 141
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 142
    sget-boolean v0, Lcom/uc/paymentsdk/util/PrefUtil;->sIsLogin:Z
    return v0
.end method

.method public static login(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 2
  .prologue
  .line 146
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 147
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 148
    const/4 v0, 1
    sput-boolean v0, Lcom/uc/paymentsdk/util/PrefUtil;->sIsLogin:Z
  .line 149
    return-void
.end method

.method public static logout(Landroid/content/Context;)V
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 152
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 153
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 154
    const/4 v1, 0
    sput-boolean v1, Lcom/uc/paymentsdk/util/PrefUtil;->sIsLogin:Z
  .line 155
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 156
  .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.uid"
    invoke-interface { v0, v1 }, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
  .line 157
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 158
    return-void
.end method

.method private static declared-synchronized setArriveCount(Landroid/content/Context;I)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramInt" # I
  .catchall { :L0 .. :L2 } :L3
  .registers 5
  .prologue
  .line 105
    const-class v0, Lcom/uc/paymentsdk/util/PrefUtil;
    monitor-enter v0
  :L0
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L1
  .line 106
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L1
  .line 107
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    const-string v2, "pref.com.uc.androidsdk.arrive"
    invoke-interface { v1, v2, p1 }, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    move-result-object v1
    invoke-interface { v1 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  :L2
  .line 108
    monitor-exit v0
    return-void
  :L3
  .line 105
    move-exception v1
    monitor-exit v0
    throw v1
.end method

.method private static setAvailableChargeType(Landroid/content/Context;[Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramArrayOfString" # [Ljava/lang/String;
  .registers 10
  .prologue
    const/4 v7, 0
    const/4 v6, 1
  .line 162
    sget-object v4, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v4, :L0
  .line 163
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 164
    const/4 v0, 0
  .line 165
  .local v0, "i":I
    array-length v1, p1
  :L1
  .line 166
  .local v1, "j":I
    if-lt v0, v1, :L4
  .line 176
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct { v3 }, Ljava/lang/StringBuilder;-><init>()V
  .line 177
  .local v3, "localStringBuilder":Ljava/lang/StringBuilder;
    const/4 v1, 0
  .line 178
    array-length v2, p1
  :L2
  .line 179
  .local v2, "k":I
    if-lt v1, v2, :L7
  .line 183
    const-string v4, ","
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I
    move-result v4
    const/4 v5, -1
    if-eq v4, v5, :L3
  .line 184
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->length()I
    move-result v4
    sub-int/2addr v4, v6
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;
  :L3
  .line 185
    sget-object v4, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v4 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v4
  .line 186
    const-string v5, "pref.com.uc.androidsdk.availableChargeType"
  .line 187
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
  .line 186
    invoke-interface { v4, v5, v6 }, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v4
  .line 187
    invoke-interface { v4 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 188
    return-void
  :L4
  .line 167
  .end local v2
  .end local v3
    const-string v4, "g"
    aget-object v5, p1, v0
    invoke-virtual { v4, v5 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, :L6
  .line 168
    sub-int v4, v1, v6
    aget-object v4, p1, v4
    aput-object v4, p1, v0
  .line 169
    sub-int v4, v1, v6
    const-string v5, "g"
    aput-object v5, p1, v4
  :L5
  .line 174
    add-int/lit8 v0, v0, 1
    goto :L1
  :L6
  .line 170
    const-string v4, "alipay"
    aget-object v5, p1, v0
    invoke-virtual { v4, v5 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, :L5
  .line 171
    aget-object v4, p1, v7
    aput-object v4, p1, v0
  .line 172
    const-string v4, "alipay"
    aput-object v4, p1, v7
    goto :L5
  :L7
  .line 180
  .restart local v2
  .restart local v3
    aget-object v4, p1, v1
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ","
    invoke-virtual { v4, v5 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  .line 181
    add-int/lit8 v1, v1, 1
    goto :L2
.end method

.method private static setAvailablePayType(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 11
  .prologue
    const/4 v8, 0
    const/4 v7, 1
  .line 197
    sget-object v5, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v5, :L0
  .line 198
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 199
    const-string v5, "sms"
    invoke-virtual { p1, v5 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v5
    invoke-virtual { p1, p1 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v6
    if-le v5, v6, :L4
  .line 200
    const-string v5, ","
    invoke-virtual { p1, v5 }, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;
    move-result-object v0
  .line 201
  .local v0, "arrayOfString":[Ljava/lang/String;
    const/4 v1, 0
  .line 202
  .local v1, "i":I
    array-length v2, v0
  :L1
  .line 203
  .local v2, "j":I
    if-lt v1, v2, :L5
  .line 213
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct { v4 }, Ljava/lang/StringBuilder;-><init>()V
  .line 214
  .local v4, "localStringBuilder":Ljava/lang/StringBuilder;
    const/4 v2, 0
  .line 215
    array-length v3, v0
  :L2
  .line 216
  .local v3, "k":I
    if-lt v2, v3, :L8
  .line 220
    const-string v5, ","
    invoke-virtual { v4, v5 }, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I
    move-result v5
    const/4 v6, -1
    if-eq v5, v6, :L3
  .line 222
    invoke-virtual { v4 }, Ljava/lang/StringBuilder;->length()I
    move-result v5
    sub-int/2addr v5, v7
    invoke-virtual { v4, v5 }, Ljava/lang/StringBuilder;->deleteCharAt(I)Ljava/lang/StringBuilder;
  :L3
  .line 223
    invoke-virtual { v4 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object p1
  :L4
  .line 225
  .end local v0
  .end local v1
  .end local v2
  .end local v3
  .end local v4
    sget-object v5, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v5 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v5
  .line 226
    const-string v6, "pref.com.uc.androidsdk.availablePayType"
    invoke-interface { v5, v6, p1 }, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v5
  .line 227
    invoke-interface { v5 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 228
    return-void
  :L5
  .line 204
  .restart local v0
  .restart local v1
  .restart local v2
    const-string v5, "sms"
    aget-object v6, v0, v1
    invoke-virtual { v5, v6 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, :L7
  .line 205
    sub-int v5, v2, v7
    aget-object v5, v0, v5
    aput-object v5, v0, v1
  .line 206
    sub-int v5, v2, v7
    const-string v6, "sms"
    aput-object v6, v0, v5
  :L6
  .line 211
    add-int/lit8 v1, v1, 1
    goto :L1
  :L7
  .line 207
    const-string v5, "upoint"
    aget-object v6, v0, v1
    invoke-virtual { v5, v6 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, :L6
  .line 208
    aget-object v5, v0, v8
    aput-object v5, v0, v1
  .line 209
    const-string v5, "upoint"
    aput-object v5, v0, v8
    goto :L6
  :L8
  .line 217
  .restart local v3
  .restart local v4
    aget-object v5, v0, v2
    invoke-virtual { v4, v5 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v6, ","
    invoke-virtual { v5, v6 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  .line 218
    add-int/lit8 v2, v2, 1
    goto :L2
.end method

.method public static setDefaultChargeType(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 243
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 244
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 245
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 246
  .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    if-nez p1, :L2
  .line 247
    const-string v1, "pref.com.uc.androidsdk.defaultChargeType"
    invoke-interface { v0, v1 }, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
  :L1
  .line 251
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 252
    return-void
  :L2
  .line 249
    const-string v1, "pref.com.uc.androidsdk.defaultChargeType"
    invoke-interface { v0, v1, p1 }, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    goto :L1
.end method

.method public static setGFanUID(Landroid/content/Context;I)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramInt" # I
  .registers 4
  .prologue
  .line 126
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 127
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 128
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 129
  .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.uid"
    invoke-interface { v0, v1, p1 }, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
  .line 130
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 131
    return-void
.end method

.method public static setPayedAmount(Landroid/content/Context;I)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramInt" # I
  .registers 6
  .prologue
  .line 330
    sget-object v2, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v2, :L0
  .line 331
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 332
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;
    move-result-object v3
    invoke-virtual { v3 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;
    move-result-object v3
    invoke-static { v3 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v3, "_payedAmount"
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
  .line 333
  .local v1, "str":Ljava/lang/String;
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->getPayedAmount(Landroid/content/Context;)I
    move-result v0
  .line 334
  .local v0, "i":I
    sget-object v2, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v2 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    add-int v3, v0, p1
    invoke-interface { v2, v1, v3 }, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    invoke-interface { v2 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 335
    return-void
.end method

.method public static setSmsInfo(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 310
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 311
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 312
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v0 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    const-string v1, "pref.com.uc.andoridsdk.smsinfo"
    invoke-interface { v0, v1, p1 }, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 313
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 314
    return-void
.end method

.method public static setSmsInfoVersion(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 296
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v0, :L0
  .line 297
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 298
    sget-object v0, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v0 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 299
    const-string v1, "pref.com.uc.andoridsdk.smsinfo.version"
    invoke-interface { v0, v1, p1 }, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 300
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 301
    return-void
.end method

.method public static setUCUserName(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 40
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 41
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 42
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 43
  .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.username"
    invoke-interface { v0, v1, p1 }, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
  .line 44
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 45
    return-void
.end method

.method public static setUCUserPass(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 62
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 63
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 64
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 65
  .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.passowrd"
    invoke-interface { v0, v1, p1 }, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
  .line 66
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 67
    return-void
.end method

.method public static setUserSession(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 84
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    if-nez v1, :L0
  .line 85
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->init(Landroid/content/Context;)V
  :L0
  .line 86
    sget-object v1, Lcom/uc/paymentsdk/util/PrefUtil;->sPref:Landroid/content/SharedPreferences;
    invoke-interface { v1 }, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
  .line 87
  .local v0, "localEditor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "pref.com.uc.androidsdk.usersession"
    invoke-interface { v0, v1, p1 }, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
  .line 88
    invoke-interface { v0 }, Landroid/content/SharedPreferences$Editor;->commit()Z
  .line 89
    return-void
.end method

.method public static supportChargeType(Landroid/content/Context;Ljava/lang/String;)Z
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .registers 7
  .prologue
    const/4 v4, 1
  .line 273
    invoke-static { p0, v4 }, Lcom/uc/paymentsdk/util/PrefUtil;->getAvailableChargeType(Landroid/content/Context;Z)[Lcom/uc/paymentsdk/model/IType;
    move-result-object v0
  .line 274
  .local v0, "arrayOfIType":[Lcom/uc/paymentsdk/model/IType;
    const/4 v1, 0
  .line 275
  .local v1, "i":I
    array-length v2, v0
  :L0
  .line 276
  .local v2, "j":I
    if-lt v1, v2, :L2
  .line 281
    const/4 v3, 0
  :L1
    return v3
  :L2
  .line 277
    aget-object v3, v0, v1
    invoke-interface { v3 }, Lcom/uc/paymentsdk/model/IType;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual { p1, v3 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, :L3
    move v3, v4
  .line 278
    goto :L1
  :L3
  .line 279
    add-int/lit8 v1, v1, 1
    goto :L0
.end method

.method public static declared-synchronized syncChargeChannels(Landroid/content/Context;[Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramArrayOfString" # [Ljava/lang/String;
  .catchall { :L0 .. :L1 } :L2
  .registers 4
  .prologue
  .line 286
    const-class v0, Lcom/uc/paymentsdk/util/PrefUtil;
    monitor-enter v0
  :L0
    invoke-static { p0, p1 }, Lcom/uc/paymentsdk/util/PrefUtil;->setAvailableChargeType(Landroid/content/Context;[Ljava/lang/String;)V
  :L1
  .line 287
    monitor-exit v0
    return-void
  :L2
  .line 286
    move-exception v1
    monitor-exit v0
    throw v1
.end method

.method public static declared-synchronized syncPayChannels(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .catchall { :L0 .. :L1 } :L2
  .registers 4
  .prologue
  .line 291
    const-class v0, Lcom/uc/paymentsdk/util/PrefUtil;
    monitor-enter v0
  :L0
    invoke-static { p0, p1 }, Lcom/uc/paymentsdk/util/PrefUtil;->setAvailablePayType(Landroid/content/Context;Ljava/lang/String;)V
  :L1
  .line 292
    monitor-exit v0
    return-void
  :L2
  .line 291
    move-exception v1
    monitor-exit v0
    throw v1
.end method
