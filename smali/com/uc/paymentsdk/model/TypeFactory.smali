.class public Lcom/uc/paymentsdk/model/TypeFactory;
.super Ljava/lang/Object;
.source "TypeFactory.java"

.field public final static TYPE_PAY_SMS:Ljava/lang/String; = "sms"

.field public final static TYPE_PAY_UPOINT:Ljava/lang/String; = "upoint"

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

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 8
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static clear()V
  .registers 1
  .prologue
  .line 67
    const/4 v0, 0
    sput-object v0, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;
  .line 68
    return-void
.end method

.method public static declared-synchronized factory(Ljava/lang/String;)Lcom/uc/paymentsdk/model/IType;
  .parameter "paramString" # Ljava/lang/String;
  .catchall { :L0 .. :L2 } :L9
  .catchall { :L4 .. :L8 } :L9
  .registers 7
  .prologue
  .line 16
    const-class v3, Lcom/uc/paymentsdk/model/TypeFactory;
    monitor-enter v3
  :L0
    sget-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;
    if-nez v2, :L1
  .line 17
    new-instance v2, Ljava/util/HashMap;
    const/4 v4, 4
    invoke-direct { v2, v4 }, Ljava/util/HashMap;-><init>(I)V
    sput-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;
  :L1
  .line 19
    sget-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;
    invoke-virtual { v2, p0 }, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, :L4
  .line 21
    sget-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;
    invoke-virtual { v2, p0 }, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/ref/SoftReference;
    invoke-virtual { v2 }, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/uc/paymentsdk/model/IType;
  :L2
  .line 22
  .local v0, "localObject":Lcom/uc/paymentsdk/model/IType;
    if-eqz v0, :L4
    move-object v1, v0
  :L3
  .line 30
  .end local v0
  .local v1, "localObject":Lcom/uc/paymentsdk/model/IType;
    monitor-exit v3
    return-object v1
  :L4
  .line 25
  .end local v1
    const-string v2, "upoint"
    invoke-virtual { v2, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, :L5
    const-string v2, "sms"
    invoke-virtual { v2, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, :L7
  :L5
  .line 26
    new-instance v0, Lcom/uc/paymentsdk/model/PayType;
    invoke-static { p0 }, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-static { p0 }, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeDesc(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static { p0 }, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeIconFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-direct { v0, p0, v2, v4, v5 }, Lcom/uc/paymentsdk/model/PayType;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  :L6
  .line 29
  .restart local v0
    sget-object v2, Lcom/uc/paymentsdk/model/TypeFactory;->sTypes:Ljava/util/HashMap;
    new-instance v4, Ljava/lang/ref/SoftReference;
    invoke-direct { v4, v0 }, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V
    invoke-virtual { v2, p0, v4 }, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    move-object v1, v0
  .line 30
  .end local v0
  .restart local v1
    goto :L3
  :L7
  .line 28
  .end local v1
    new-instance v0, Lcom/uc/paymentsdk/model/ChargeType;
    invoke-static { p0 }, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-static { p0 }, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeDesc(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static { p0 }, Lcom/uc/paymentsdk/model/TypeFactory;->getTypeIconFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-direct { v0, p0, v2, v4, v5 }, Lcom/uc/paymentsdk/model/ChargeType;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  :L8
  .restart local v0
    goto :L6
  :L9
  .line 16
  .end local v0
    move-exception v2
    monitor-exit v3
    throw v2
.end method

.method private static getTypeDesc(Ljava/lang/String;)Ljava/lang/String;
  .parameter "paramString" # Ljava/lang/String;
  .registers 5
  .prologue
  .line 35
    const-string v0, "upoint"
    invoke-virtual { v0, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, :L1
  .line 36
    const-string v0, "\u7528U\u70b9\u8d2d\u4e70<br /><small><small><font color='#999999'>10U\u70b9\u4ef7\u503c1\u5143</font></small></small>"
  :L0
  .line 38
    return-object v0
  :L1
  .line 37
    const-string v0, "sms"
    invoke-virtual { v0, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, :L2
  .line 38
    const-string v0, "\u53d1\u77ed\u4fe1\u76f4\u63a5\u8d2d\u4e70<br /><small><small><font color='#999999'>\u53d1\u9001%s\u5143\u77ed\u4fe1\uff0c\u53ef\u8d2d\u4e70\u8be5\u5185\u5bb9</font></small></small>"
    const/4 v1, 1
    new-array v1, v1, [Ljava/lang/Object;
    const/4 v2, 0
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getSmsPayment()I
    move-result v3
    invoke-static { v3 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    aput-object v3, v1, v2
    invoke-static { v0, v1 }, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    goto :L0
  :L2
  .line 39
    new-instance v0, Ljava/lang/IllegalArgumentException;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "type not supported. "
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v1, p0 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct { v0, v1 }, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method private static getTypeIconFileName(Ljava/lang/String;)Ljava/lang/String;
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 49
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->isHdpi()Z
    move-result v0
  .line 50
  .local v0, "bool":Z
    const-string v1, "upoint"
    invoke-virtual { v1, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, :L2
  .line 52
    if-eqz v0, :L1
  .line 53
    const-string v1, "upoint_logo_hdpi.png"
  :L0
  .line 60
    return-object v1
  :L1
  .line 54
    const-string v1, "upoint_logo.png"
    goto :L0
  :L2
  .line 56
    const-string v1, "sms"
    invoke-virtual { v1, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, :L4
  .line 58
    if-eqz v0, :L3
  .line 59
    const-string v1, "sms_logo_hdpi.png"
    goto :L0
  :L3
  .line 60
    const-string v1, "sms_logo.png"
    goto :L0
  :L4
  .line 62
    new-instance v1, Ljava/lang/IllegalArgumentException;
    const-string v2, "type not supported."
    invoke-direct { v1, v2 }, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method private static getTypeName(Ljava/lang/String;)Ljava/lang/String;
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 44
    const/4 v0, 0
    return-object v0
.end method
