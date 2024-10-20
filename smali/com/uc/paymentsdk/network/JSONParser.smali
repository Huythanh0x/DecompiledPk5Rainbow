.class public Lcom/uc/paymentsdk/network/JSONParser;
.super Ljava/lang/Object;
.source "JSONParser.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parseAlipayOrder(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 4
    .param p0, "paramString"    # Ljava/lang/String;
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

    .prologue
    .line 13
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 14
    .local v2, "localJSONObject":Lorg/json/JSONObject;
    const-string v3, "resultCode"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 15
    .local v0, "i":I
    const/4 v3, 0x1

    if-ne v3, v0, :cond_0

    .line 17
    new-instance v1, Ljava/util/ArrayList;

    const/4 v3, 0x2

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 18
    .local v1, "localArrayList":Ljava/util/ArrayList;
    const-string v3, "alipayParam"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 19
    const-string v3, "orderNo"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move-object v3, v1

    .line 22
    .end local v1    # "localArrayList":Ljava/util/ArrayList;
    :goto_0
    return-object v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static parseAlipayResult(Ljava/lang/String;)I
    .locals 2
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 28
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 29
    .local v0, "localJSONObject":Lorg/json/JSONObject;
    const-string v1, "resultCode"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    return v1
.end method

.method public static parseChargeChannel(Ljava/lang/String;)[Ljava/lang/String;
    .locals 8
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 57
    new-instance v5, Lorg/json/JSONObject;

    invoke-direct {v5, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 58
    .local v5, "localJSONObject":Lorg/json/JSONObject;
    const-string v7, "resultCode"

    invoke-virtual {v5, v7}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 59
    .local v1, "i":I
    const/4 v7, 0x1

    if-ne v7, v1, :cond_1

    .line 61
    const-string v7, "channels"

    invoke-virtual {v5, v7}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v4

    .line 62
    .local v4, "localJSONArray":Lorg/json/JSONArray;
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v7

    new-array v0, v7, [Ljava/lang/String;

    .line 63
    .local v0, "arrayOfString":[Ljava/lang/String;
    const/4 v2, 0x0

    .line 64
    .local v2, "j":I
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v3

    .line 65
    .local v3, "k":I
    :goto_0
    if-lt v2, v3, :cond_0

    move-object v7, v0

    .line 83
    .end local v0    # "arrayOfString":[Ljava/lang/String;
    .end local v2    # "j":I
    .end local v3    # "k":I
    .end local v4    # "localJSONArray":Lorg/json/JSONArray;
    :goto_1
    return-object v7

    .line 67
    .restart local v0    # "arrayOfString":[Ljava/lang/String;
    .restart local v2    # "j":I
    .restart local v3    # "k":I
    .restart local v4    # "localJSONArray":Lorg/json/JSONArray;
    :cond_0
    invoke-virtual {v4, v2}, Lorg/json/JSONArray;->getInt(I)I

    move-result v6

    .line 68
    .local v6, "m":I
    packed-switch v6, :pswitch_data_0

    .line 79
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 71
    :pswitch_0
    const-string v7, "alipay"

    aput-object v7, v0, v2

    goto :goto_2

    .line 74
    :pswitch_1
    const-string v7, "g"

    aput-object v7, v0, v2

    goto :goto_2

    .line 77
    :pswitch_2
    const-string v7, "phonecard"

    aput-object v7, v0, v2

    goto :goto_2

    .line 83
    .end local v0    # "arrayOfString":[Ljava/lang/String;
    .end local v2    # "j":I
    .end local v3    # "k":I
    .end local v4    # "localJSONArray":Lorg/json/JSONArray;
    .end local v6    # "m":I
    :cond_1
    const/4 v7, 0x0

    goto :goto_1

    .line 68
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static parseChargeG(Ljava/lang/String;)I
    .locals 2
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 35
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 36
    .local v0, "localJSONObject":Lorg/json/JSONObject;
    const-string v1, "resultCode"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v1

    return v1
.end method

.method public static parseJifengquanAndGBalance(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 4
    .param p0, "paramString"    # Ljava/lang/String;
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

    .prologue
    .line 42
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 43
    .local v2, "localJSONObject":Lorg/json/JSONObject;
    const-string v3, "resultCode"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 44
    .local v0, "i":I
    const/4 v3, 0x1

    if-ne v3, v0, :cond_0

    .line 46
    new-instance v1, Ljava/util/ArrayList;

    const/4 v3, 0x2

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 47
    .local v1, "localArrayList":Ljava/util/ArrayList;
    const-string v3, "gVolume"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 48
    const-string v3, "gMoney"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    move-object v3, v1

    .line 51
    .end local v1    # "localArrayList":Ljava/util/ArrayList;
    :goto_0
    return-object v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method
