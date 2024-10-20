.class public Lcom/uc/paymentsdk/network/JSONParser;
.super Ljava/lang/Object;
.source "JSONParser.java"

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 8
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static parseAlipayOrder(Ljava/lang/String;)Ljava/util/ArrayList;
  .annotation system Ldalvik/annotation/Signature;
    value = {
      "(",
      "Ljava/lang/String;",
      ")",
      "Ljava/util/ArrayList",
      "<",
      "Ljava/lang/String;",
      ">;"
    }
  .end annotation
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lorg/json/JSONException;
    }
  .end annotation
  .parameter "paramString" # Ljava/lang/String;
  .registers 5
  .prologue
  .line 13
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct { v2, p0 }, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
  .line 14
  .local v2, "localJSONObject":Lorg/json/JSONObject;
    const-string v3, "resultCode"
    invoke-virtual { v2, v3 }, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    move-result v0
  .line 15
  .local v0, "i":I
    const/4 v3, 1
    if-ne v3, v0, :L1
  .line 17
    new-instance v1, Ljava/util/ArrayList;
    const/4 v3, 2
    invoke-direct { v1, v3 }, Ljava/util/ArrayList;-><init>(I)V
  .line 18
  .local v1, "localArrayList":Ljava/util/ArrayList;
    const-string v3, "alipayParam"
    invoke-virtual { v2, v3 }, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v1, v3 }, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
  .line 19
    const-string v3, "orderNo"
    invoke-virtual { v2, v3 }, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v1, v3 }, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    move-object v3, v1
  :L0
  .line 22
  .end local v1
    return-object v3
  :L1
    const/4 v3, 0
    goto :L0
.end method

.method public static parseAlipayResult(Ljava/lang/String;)I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lorg/json/JSONException;
    }
  .end annotation
  .parameter "paramString" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 28
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct { v0, p0 }, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
  .line 29
  .local v0, "localJSONObject":Lorg/json/JSONObject;
    const-string v1, "resultCode"
    invoke-virtual { v0, v1 }, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    move-result v1
    return v1
.end method

.method public static parseChargeChannel(Ljava/lang/String;)[Ljava/lang/String;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lorg/json/JSONException;
    }
  .end annotation
  .parameter "paramString" # Ljava/lang/String;
  .registers 9
  .prologue
  .line 57
    new-instance v5, Lorg/json/JSONObject;
    invoke-direct { v5, p0 }, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
  .line 58
  .local v5, "localJSONObject":Lorg/json/JSONObject;
    const-string v7, "resultCode"
    invoke-virtual { v5, v7 }, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    move-result v1
  .line 59
  .local v1, "i":I
    const/4 v7, 1
    if-ne v7, v1, :L7
  .line 61
    const-string v7, "channels"
    invoke-virtual { v5, v7 }, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    move-result-object v4
  .line 62
  .local v4, "localJSONArray":Lorg/json/JSONArray;
    invoke-virtual { v4 }, Lorg/json/JSONArray;->length()I
    move-result v7
    new-array v0, v7, [Ljava/lang/String;
  .line 63
  .local v0, "arrayOfString":[Ljava/lang/String;
    const/4 v2, 0
  .line 64
  .local v2, "j":I
    invoke-virtual { v4 }, Lorg/json/JSONArray;->length()I
    move-result v3
  :L0
  .line 65
  .local v3, "k":I
    if-lt v2, v3, :L2
    move-object v7, v0
  :L1
  .line 83
  .end local v0
  .end local v2
  .end local v3
  .end local v4
    return-object v7
  :L2
  .line 67
  .restart local v0
  .restart local v2
  .restart local v3
  .restart local v4
    invoke-virtual { v4, v2 }, Lorg/json/JSONArray;->getInt(I)I
    move-result v6
  .line 68
  .local v6, "m":I
    packed-switch v6, :L8
  :L3
  .line 79
    add-int/lit8 v2, v2, 1
    goto :L0
  :L4
  .line 71
    const-string v7, "alipay"
    aput-object v7, v0, v2
    goto :L3
  :L5
  .line 74
    const-string v7, "g"
    aput-object v7, v0, v2
    goto :L3
  :L6
  .line 77
    const-string v7, "phonecard"
    aput-object v7, v0, v2
    goto :L3
  :L7
  .line 83
  .end local v0
  .end local v2
  .end local v3
  .end local v4
  .end local v6
    const/4 v7, 0
    goto :L1
  .line 68
  :L8
  .packed-switch 1
    :L4
    :L5
    :L6
  .end packed-switch
.end method

.method public static parseChargeG(Ljava/lang/String;)I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lorg/json/JSONException;
    }
  .end annotation
  .parameter "paramString" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 35
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct { v0, p0 }, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
  .line 36
  .local v0, "localJSONObject":Lorg/json/JSONObject;
    const-string v1, "resultCode"
    invoke-virtual { v0, v1 }, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    move-result v1
    return v1
.end method

.method public static parseJifengquanAndGBalance(Ljava/lang/String;)Ljava/util/ArrayList;
  .annotation system Ldalvik/annotation/Signature;
    value = {
      "(",
      "Ljava/lang/String;",
      ")",
      "Ljava/util/ArrayList",
      "<",
      "Ljava/lang/Integer;",
      ">;"
    }
  .end annotation
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lorg/json/JSONException;
    }
  .end annotation
  .parameter "paramString" # Ljava/lang/String;
  .registers 5
  .prologue
  .line 42
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct { v2, p0 }, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
  .line 43
  .local v2, "localJSONObject":Lorg/json/JSONObject;
    const-string v3, "resultCode"
    invoke-virtual { v2, v3 }, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    move-result v0
  .line 44
  .local v0, "i":I
    const/4 v3, 1
    if-ne v3, v0, :L1
  .line 46
    new-instance v1, Ljava/util/ArrayList;
    const/4 v3, 2
    invoke-direct { v1, v3 }, Ljava/util/ArrayList;-><init>(I)V
  .line 47
  .local v1, "localArrayList":Ljava/util/ArrayList;
    const-string v3, "gVolume"
    invoke-virtual { v2, v3 }, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    move-result v3
    invoke-static { v3 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual { v1, v3 }, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
  .line 48
    const-string v3, "gMoney"
    invoke-virtual { v2, v3 }, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I
    move-result v3
    invoke-static { v3 }, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual { v1, v3 }, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    move-object v3, v1
  :L0
  .line 51
  .end local v1
    return-object v3
  :L1
    const/4 v3, 0
    goto :L0
.end method
