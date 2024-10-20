.class public Lcom/uc/paymentsdk/network/XMLParser;
.super Ljava/lang/Object;
.source "XMLParser.java"


# static fields
.field private static final RESPONSE:Ljava/lang/String; = "response"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "paramXmlPullParser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 30
    const-string v1, ""

    invoke-interface {p0, v1, p1}, Lorg/xmlpull/v1/XmlPullParser;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 31
    .local v0, "str":Ljava/lang/String;
    if-nez v0, :cond_0

    const-string v1, ""

    :goto_0
    return-object v1

    :cond_0
    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public static parseAccount(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 7
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
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    .line 36
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 37
    const/4 v3, 0x0

    .line 58
    :goto_0
    return-object v3

    .line 38
    :cond_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v3

    .line 39
    invoke-virtual {v3}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v1

    .line 40
    .local v1, "localXmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v3, Ljava/io/StringReader;

    invoke-direct {v3, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v1, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v6}, Ljava/util/ArrayList;-><init>(I)V

    .line 42
    .local v0, "localArrayList":Ljava/util/ArrayList;
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 43
    const-string v3, ""

    const-string v4, "response"

    invoke-interface {v1, v5, v3, v4}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 44
    :goto_1
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    move-result v3

    if-eq v3, v5, :cond_1

    .line 57
    const-string v3, ""

    const-string v4, "response"

    invoke-interface {v1, v6, v3, v4}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    move-object v3, v0

    .line 58
    goto :goto_0

    .line 45
    :cond_1
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "str":Ljava/lang/String;
    const-string v3, ""

    invoke-interface {v1, v5, v3, v2}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 47
    const-string v3, "name"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 48
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 55
    :goto_2
    const-string v3, ""

    invoke-interface {v1, v6, v3, v2}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 49
    :cond_2
    const-string v3, "uid"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 50
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 51
    :cond_3
    const-string v3, "email"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 52
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 54
    :cond_4
    invoke-static {v1}, Lcom/uc/paymentsdk/network/XMLParser;->skipUnknownTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_2
.end method

.method public static parseAppname(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    .line 62
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 63
    const-string v2, ""

    .line 78
    :goto_0
    return-object v2

    .line 64
    :cond_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v2

    .line 65
    invoke-virtual {v2}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v0

    .line 66
    .local v0, "localXmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v2, Ljava/io/StringReader;

    invoke-direct {v2, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v2}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 67
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 68
    const-string v2, ""

    const-string v3, "response"

    invoke-interface {v0, v4, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 69
    :goto_1
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    move-result v2

    if-eq v2, v4, :cond_1

    .line 77
    const-string v2, ""

    const-string v3, "response"

    invoke-interface {v0, v5, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 78
    const-string v2, ""

    goto :goto_0

    .line 70
    :cond_1
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 71
    .local v1, "str":Ljava/lang/String;
    const-string v2, ""

    invoke-interface {v0, v4, v2, v1}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 72
    const-string v2, "appname"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 73
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 74
    :cond_2
    invoke-static {v0}, Lcom/uc/paymentsdk/network/XMLParser;->skipUnknownTag(Lorg/xmlpull/v1/XmlPullParser;)V

    .line 75
    const-string v2, ""

    invoke-interface {v0, v5, v2, v1}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public static parseChargePhoneCard(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    .line 89
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 90
    const/4 v3, 0x0

    .line 109
    :goto_0
    return-object v3

    .line 91
    :cond_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v3

    .line 92
    invoke-virtual {v3}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v0

    .line 93
    .local v0, "localXmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v3, Ljava/io/StringReader;

    invoke-direct {v3, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 94
    const-string v1, ""

    .line 95
    .local v1, "str1":Ljava/lang/String;
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 96
    const-string v3, ""

    const-string v4, "result"

    invoke-interface {v0, v5, v3, v4}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 97
    :goto_1
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    move-result v3

    if-eq v3, v5, :cond_1

    .line 108
    const-string v3, ""

    const-string v4, "result"

    invoke-interface {v0, v6, v3, v4}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    move-object v3, v1

    .line 109
    goto :goto_0

    .line 98
    :cond_1
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 99
    .local v2, "str2":Ljava/lang/String;
    const-string v3, ""

    invoke-interface {v0, v5, v3, v2}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 100
    const-string v3, "pay_result"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 101
    const-string v3, "order_id"

    invoke-static {v0, v3}, Lcom/uc/paymentsdk/network/XMLParser;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 102
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 106
    :goto_2
    const-string v3, ""

    invoke-interface {v0, v6, v3, v2}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 104
    :cond_2
    invoke-static {v0}, Lcom/uc/paymentsdk/network/XMLParser;->skipUnknownTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_2
.end method

.method public static parsePayChannel(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x3

    const/4 v4, 0x2

    .line 139
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    move-object v2, v6

    .line 157
    :goto_0
    return-object v2

    .line 141
    :cond_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v2

    .line 142
    invoke-virtual {v2}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v0

    .line 143
    .local v0, "localXmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v2, Ljava/io/StringReader;

    invoke-direct {v2, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v2}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 144
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 145
    const-string v2, ""

    const-string v3, "response"

    invoke-interface {v0, v4, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 146
    :goto_1
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    move-result v2

    if-eq v2, v4, :cond_1

    .line 156
    const-string v2, ""

    const-string v3, "response"

    invoke-interface {v0, v5, v2, v3}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    move-object v2, v6

    .line 157
    goto :goto_0

    .line 147
    :cond_1
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    .line 148
    .local v1, "str":Ljava/lang/String;
    const-string v2, ""

    invoke-interface {v0, v4, v2, v1}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 149
    const-string v2, "channels"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 150
    invoke-interface {v0}, Lorg/xmlpull/v1/XmlPullParser;->nextText()Ljava/lang/String;

    move-result-object v2

    .line 151
    const-string v3, "1"

    const-string v4, "upoint"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 152
    const-string v3, "2"

    const-string v4, "sms"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 153
    :cond_2
    invoke-static {v0}, Lcom/uc/paymentsdk/network/XMLParser;->skipUnknownTag(Lorg/xmlpull/v1/XmlPullParser;)V

    .line 154
    const-string v2, ""

    invoke-interface {v0, v5, v2, v1}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public static parsePayOrder(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 82
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 83
    const-string v0, ""

    .line 84
    :goto_0
    return-object v0

    :cond_0
    move-object v0, p0

    goto :goto_0
.end method

.method public static parsePhoneCardChargeResult(Ljava/lang/String;)I
    .locals 7
    .param p0, "paramString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    .line 114
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 115
    const/4 v3, -0x1

    .line 135
    :goto_0
    return v3

    .line 116
    :cond_0
    invoke-static {}, Lorg/xmlpull/v1/XmlPullParserFactory;->newInstance()Lorg/xmlpull/v1/XmlPullParserFactory;

    move-result-object v3

    .line 117
    invoke-virtual {v3}, Lorg/xmlpull/v1/XmlPullParserFactory;->newPullParser()Lorg/xmlpull/v1/XmlPullParser;

    move-result-object v1

    .line 118
    .local v1, "localXmlPullParser":Lorg/xmlpull/v1/XmlPullParser;
    new-instance v3, Ljava/io/StringReader;

    invoke-direct {v3, p0}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-interface {v1, v3}, Lorg/xmlpull/v1/XmlPullParser;->setInput(Ljava/io/Reader;)V

    .line 119
    const/4 v0, -0x1

    .line 120
    .local v0, "i":I
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 121
    const-string v3, ""

    const-string v4, "result"

    invoke-interface {v1, v5, v3, v4}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 122
    :goto_1
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    move-result v3

    if-eq v3, v5, :cond_1

    .line 134
    const-string v3, ""

    const-string v4, "result"

    invoke-interface {v1, v6, v3, v4}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    move v3, v0

    .line 135
    goto :goto_0

    .line 123
    :cond_1
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    .line 124
    .local v2, "str":Ljava/lang/String;
    const-string v3, ""

    invoke-interface {v1, v5, v3, v2}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    .line 125
    const-string v3, "pay_result"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 127
    const-string v3, "status"

    invoke-static {v1, v3}, Lcom/uc/paymentsdk/network/XMLParser;->getAttributeValue(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/uc/paymentsdk/util/Utils;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 128
    invoke-interface {v1}, Lorg/xmlpull/v1/XmlPullParser;->nextTag()I

    .line 132
    :goto_2
    const-string v3, ""

    invoke-interface {v1, v6, v3, v2}, Lorg/xmlpull/v1/XmlPullParser;->require(ILjava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 130
    :cond_2
    invoke-static {v1}, Lcom/uc/paymentsdk/network/XMLParser;->skipUnknownTag(Lorg/xmlpull/v1/XmlPullParser;)V

    goto :goto_2
.end method

.method public static parseSmsInfo(Ljava/lang/String;)Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    .locals 14
    .param p0, "usefulsmsinfo"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v13, 0x0

    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 195
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_0

    move-object v6, v13

    .line 248
    :goto_0
    return-object v6

    .line 197
    :cond_0
    new-instance v2, Lcom/uc/paymentsdk/payment/sms/SmsInfos;

    invoke-direct {v2}, Lcom/uc/paymentsdk/payment/sms/SmsInfos;-><init>()V

    .line 198
    .local v2, "localSmsInfos":Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    const-string v6, "\\^\\|\\*"

    invoke-virtual {p0, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 199
    .local v3, "smsarr":[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v6, v3

    if-lt v0, v6, :cond_1

    move-object v6, v2

    .line 248
    goto :goto_0

    .line 200
    :cond_1
    new-instance v1, Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    invoke-direct {v1}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;-><init>()V

    .line 201
    .local v1, "localSmsInfo":Lcom/uc/paymentsdk/payment/sms/SmsInfo;
    const/4 v4, 0x0

    .line 203
    .local v4, "smsconfirm":I
    aget-object v6, v3, v0

    const-string v7, "\\^\\$\\*"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    array-length v6, v6

    if-ge v6, v12, :cond_3

    .line 204
    const/4 v4, 0x0

    .line 209
    :goto_2
    if-ne v4, v11, :cond_4

    .line 210
    iput-boolean v11, v1, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->needconfirm:Z

    .line 215
    :goto_3
    aget-object v6, v3, v0

    .line 216
    aget-object v7, v3, v0

    const-string v8, "^$*"

    invoke-virtual {v7, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v7

    if-lez v7, :cond_5

    aget-object v7, v3, v0

    const-string v8, "^$*"

    invoke-virtual {v7, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v7

    add-int/lit8 v7, v7, 0x3

    :goto_4
    aget-object v8, v3, v0

    const-string v9, "^&*"

    invoke-virtual {v8, v9}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v8

    .line 215
    invoke-virtual {v6, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    .line 217
    const-string v7, ","

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 218
    .local v5, "smsinfoarr":[Ljava/lang/String;
    if-eqz v5, :cond_2

    array-length v6, v5

    if-ge v6, v12, :cond_6

    :cond_2
    move-object v6, v13

    .line 219
    goto :goto_0

    .line 207
    .end local v5    # "smsinfoarr":[Ljava/lang/String;
    :cond_3
    aget-object v6, v3, v0

    const-string v7, "\\^\\$\\*"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    aget-object v6, v6, v10

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    goto :goto_2

    .line 213
    :cond_4
    iput-boolean v10, v1, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->needconfirm:Z

    goto :goto_3

    :cond_5
    move v7, v10

    .line 216
    goto :goto_4

    .line 221
    .restart local v5    # "smsinfoarr":[Ljava/lang/String;
    :cond_6
    const/4 v6, 0x4

    aget-object v6, v5, v6

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setMoney(I)V

    .line 222
    const/4 v6, 0x3

    aget-object v6, v5, v6

    const-string v7, "#"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    aget-object v6, v6, v10

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmstype(I)V

    .line 223
    aget-object v6, v5, v10

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmschannelid(Ljava/lang/String;)V

    .line 224
    aget-object v6, v5, v11

    const-string v7, "#"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    aget-object v6, v6, v10

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmsnumber(Ljava/lang/String;)V

    .line 225
    if-ne v4, v11, :cond_7

    .line 226
    aget-object v6, v5, v11

    const-string v7, "#"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    aget-object v6, v6, v11

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmsconfirmnumber(Ljava/lang/String;)V

    .line 231
    :goto_5
    aget-object v6, v5, v12

    const-string v7, "#"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    aget-object v6, v6, v10

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmsheader(Ljava/lang/String;)V

    .line 232
    if-ne v4, v11, :cond_8

    .line 233
    aget-object v6, v5, v12

    const-string v7, "#"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    aget-object v6, v6, v11

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmsconfirmheader(Ljava/lang/String;)V

    .line 238
    :goto_6
    aget-object v6, v3, v0

    const-string v7, "^&*"

    invoke-virtual {v6, v7}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    if-lez v6, :cond_9

    .line 239
    aget-object v6, v3, v0

    aget-object v7, v3, v0

    .line 240
    const-string v8, "^&*"

    invoke-virtual {v7, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v7

    add-int/lit8 v7, v7, 0x3

    .line 239
    invoke-virtual {v6, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v6

    .line 240
    const-string v7, "#"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    aget-object v6, v6, v10

    .line 239
    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setInfobeforesend(Ljava/lang/String;)V

    .line 245
    :goto_7
    const/4 v6, 0x5

    aget-object v6, v5, v6

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmsendtime(Ljava/lang/String;)V

    .line 246
    invoke-virtual {v2, v1}, Lcom/uc/paymentsdk/payment/sms/SmsInfos;->add(Lcom/uc/paymentsdk/payment/sms/SmsInfo;)V

    .line 199
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    .line 229
    :cond_7
    const-string v6, ""

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmsconfirmnumber(Ljava/lang/String;)V

    goto :goto_5

    .line 236
    :cond_8
    const-string v6, ""

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setSmsconfirmheader(Ljava/lang/String;)V

    goto :goto_6

    .line 243
    :cond_9
    const-string v6, ""

    invoke-virtual {v1, v6}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->setInfobeforesend(Ljava/lang/String;)V

    goto :goto_7
.end method

.method public static parseUPointInfo(Ljava/lang/String;)Lcom/uc/paymentsdk/payment/upoint/UPointInfo;
    .locals 9
    .param p0, "upointinfostr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x7

    const/4 v6, 0x6

    const/4 v5, 0x5

    const/4 v4, 0x4

    .line 161
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 162
    const/4 v2, 0x0

    .line 191
    :goto_0
    return-object v2

    .line 163
    :cond_0
    new-instance v1, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;

    invoke-direct {v1}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;-><init>()V

    .line 164
    .local v1, "localUPointInfo":Lcom/uc/paymentsdk/payment/upoint/UPointInfo;
    const-string v2, "#"

    invoke-virtual {p0, v2}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 165
    .local v0, "infoarr":[Ljava/lang/String;
    aget-object v2, v0, v8

    const-string v3, "none"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 166
    const-string v2, "\u65e0"

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setDiscount(Ljava/lang/String;)V

    .line 167
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getMoney()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setDiscounttext(Ljava/lang/String;)V

    .line 172
    :goto_1
    const/4 v2, 0x2

    aget-object v2, v0, v2

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setDiscountinfo(Ljava/lang/String;)V

    .line 174
    aget-object v2, v0, v4

    if-eqz v2, :cond_1

    .line 175
    aget-object v2, v0, v4

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 176
    aget-object v2, v0, v4

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setUserphone(Ljava/lang/String;)V

    .line 179
    :cond_1
    aget-object v2, v0, v5

    if-eqz v2, :cond_2

    .line 180
    aget-object v2, v0, v5

    const-string v3, "none"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 181
    aget-object v2, v0, v5

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setVipdiscount(Ljava/lang/String;)V

    .line 183
    :cond_2
    aget-object v2, v0, v6

    if-eqz v2, :cond_3

    .line 184
    aget-object v2, v0, v6

    const-string v3, "none"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 185
    aget-object v2, v0, v6

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setDiscounttext(Ljava/lang/String;)V

    .line 187
    :cond_3
    aget-object v2, v0, v7

    if-eqz v2, :cond_4

    .line 188
    aget-object v2, v0, v7

    const-string v3, "none"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 189
    aget-object v2, v0, v7

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setVipdiscounttime(Ljava/lang/String;)V

    :cond_4
    move-object v2, v1

    .line 191
    goto/16 :goto_0

    .line 169
    :cond_5
    aget-object v2, v0, v8

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setDiscount(Ljava/lang/String;)V

    .line 170
    const/4 v2, 0x3

    aget-object v2, v0, v2

    invoke-virtual {v1, v2}, Lcom/uc/paymentsdk/payment/upoint/UPointInfo;->setDiscounttext(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private static skipUnknownTag(Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 3
    .param p0, "paramXmlPullParser"    # Lorg/xmlpull/v1/XmlPullParser;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 21
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    .line 22
    .local v0, "str":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v1

    if-gtz v1, :cond_1

    .line 26
    return-void

    .line 23
    :cond_1
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_0

    .line 24
    invoke-interface {p0}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    goto :goto_0
.end method
