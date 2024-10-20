.class public Lcom/uc/paymentsdk/util/Utils;
.super Ljava/lang/Object;
.source "Utils.java"

.field private final static TITLE_ICON_BACK:Ljava/lang/String; = "back"

.field private final static TITLE_ICON_CANCEL:Ljava/lang/String; = "cancel"

.field private static rdm:Ljava/util/Random;

.field private static sIsHdpi:Z

.field private static sPaymentInfo:Lcom/uc/paymentsdk/payment/PaymentInfo;

.field private static sSmsInfos:Lcom/uc/paymentsdk/payment/sms/SmsInfos;

.field private static sUPointInfo:Lcom/uc/paymentsdk/payment/upoint/UPointInfo;

.field private static sUPointPayInfo:Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;

.field private static sessionidstr:Ljava/lang/String;

.field private static upconsumeid:Ljava/lang/String;

.method static constructor <clinit>()V
  .registers 1
  .prologue
  .line 73
    const-string v0, ""
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->sessionidstr:Ljava/lang/String;
  .line 74
    const-string v0, ""
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->upconsumeid:Ljava/lang/String;
  .line 66
    return-void
.end method

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 66
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static CheckSimCardSupprotInfo(Landroid/content/Context;)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;
    }
  .end annotation
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 497
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/Utils;->isAirMode(Landroid/content/Context;)Z
    move-result v0
    if-eqz v0, :L0
  .line 498
    new-instance v0, Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;
    const-string v1, "\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002"
    invoke-direct { v0, v1 }, Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;-><init>(Ljava/lang/String;)V
    throw v0
  :L0
  .line 499
    const/4 v0, 5
    const-string v1, "phone"
    invoke-virtual { p0, v1 }, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object p0
  .end local p0
    check-cast p0, Landroid/telephony/TelephonyManager;
  .line 500
    invoke-virtual { p0 }, Landroid/telephony/TelephonyManager;->getSimState()I
    move-result v1
  .line 499
    if-eq v0, v1, :L1
  .line 501
    new-instance v0, Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;
  .line 502
    const-string v1, "\u5bf9\u4e0d\u8d77\uff0c\u77ed\u4fe1\u53d1\u9001\u4e0d\u6210\u529f\u3001\u65e0\u6cd5\u6fc0\u6d3b\u6b64\u529f\u80fd\uff0c\u8bf7\u63d2\u5165SIM\u5361\u540e\u518d\u8bd5\u3002"
  .line 501
    invoke-direct { v0, v1 }, Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;-><init>(Ljava/lang/String;)V
    throw v0
  :L1
  .line 503
    return-void
.end method

.method public static clearSmsInfos()V
  .registers 1
  .prologue
  .line 474
    const/4 v0, 0
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->sSmsInfos:Lcom/uc/paymentsdk/payment/sms/SmsInfos;
  .line 475
    return-void
.end method

.method public static clearUPConsumeid()V
  .registers 1
  .prologue
  .line 662
    const-string v0, ""
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->upconsumeid:Ljava/lang/String;
  .line 663
    return-void
.end method

.method public static clearUPointInfo()V
  .registers 1
  .prologue
  .line 478
    const/4 v0, 0
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->sUPointInfo:Lcom/uc/paymentsdk/payment/upoint/UPointInfo;
  .line 479
    return-void
.end method

.method public static clearUPointPayInfo()V
  .registers 1
  .prologue
  .line 492
    const/4 v0, 0
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->sUPointPayInfo:Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;
  .line 493
    return-void
.end method

.method public static convertStreamToString(Ljava/io/InputStream;)Ljava/lang/String;
  .parameter "paramInputStream" # Ljava/io/InputStream;
  .catch Ljava/io/IOException; { :L0 .. :L1 } :L6
  .catchall { :L0 .. :L1 } :L11
  .catch Ljava/io/IOException; { :L2 .. :L3 } :L15
  .catch Ljava/io/IOException; { :L4 .. :L5 } :L6
  .catchall { :L4 .. :L5 } :L11
  .catchall { :L7 .. :L8 } :L11
  .catch Ljava/io/IOException; { :L8 .. :L9 } :L10
  .catch Ljava/io/IOException; { :L12 .. :L13 } :L14
  .registers 7
  .prologue
  .line 525
    new-instance v0, Ljava/io/BufferedReader;
  .line 526
    new-instance v5, Ljava/io/InputStreamReader;
    invoke-direct { v5, p0 }, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V
  .line 525
    invoke-direct { v0, v5 }, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
  .line 527
  .local v0, "localBufferedReader":Ljava/io/BufferedReader;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct { v3 }, Ljava/lang/StringBuilder;-><init>()V
  .line 528
  .local v3, "localStringBuilder":Ljava/lang/StringBuilder;
    const/4 v4, 0
  :L0
  .line 530
  .local v4, "str":Ljava/lang/String;
    invoke-virtual { v0 }, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;
  :L1
    move-result-object v4
    if-nez v4, :L4
  :L2
  .line 536
    invoke-virtual { p0 }, Ljava/io/InputStream;->close()V
  :L3
  .line 541
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    return-object v5
  :L4
  .line 531
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  :L5
    goto :L0
  :L6
  .line 532
    move-exception v5
    move-object v1, v5
  :L7
  .line 533
  .local v1, "localIOException2":Ljava/io/IOException;
    invoke-virtual { v1 }, Ljava/io/IOException;->printStackTrace()V
  :L8
  .line 536
    invoke-virtual { p0 }, Ljava/io/InputStream;->close()V
  :L9
    goto :L3
  :L10
  .line 537
    move-exception v2
  .line 538
  .local v2, "localIOException4":Ljava/io/IOException;
    invoke-virtual { v2 }, Ljava/io/IOException;->printStackTrace()V
    goto :L3
  :L11
  .line 534
  .end local v1
  .end local v2
    move-exception v5
  :L12
  .line 536
    invoke-virtual { p0 }, Ljava/io/InputStream;->close()V
  :L13
  .line 540
    throw v5
  :L14
  .line 537
    move-exception v2
  .line 538
  .restart local v2
    invoke-virtual { v2 }, Ljava/io/IOException;->printStackTrace()V
    goto :L13
  :L15
  .line 537
  .end local v2
    move-exception v2
  .line 538
  .restart local v2
    invoke-virtual { v2 }, Ljava/io/IOException;->printStackTrace()V
    goto :L3
.end method

.method public static createARanConsumeID(I)Ljava/lang/String;
  .parameter "number" # I
  .registers 5
  .prologue
  .line 552
    const-string v0, ""
  :L0
  .line 553
  .local v0, "rdmstr":Ljava/lang/String;
    invoke-virtual { v0 }, Ljava/lang/String;->length()I
    move-result v1
    if-lt v1, p0, :L2
  .line 556
    invoke-virtual { v0 }, Ljava/lang/String;->length()I
    move-result v1
    if-le v1, p0, :L1
  .line 557
    const/4 v1, 0
    invoke-virtual { v0, v1, p0 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
  :L1
  .line 559
    return-object v0
  :L2
  .line 554
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-static { v0 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-wide/16 v2, 10
    invoke-static { v2, v3 }, Lcom/uc/paymentsdk/util/Utils;->getRan(J)J
    move-result-wide v2
    invoke-virtual { v1, v2, v3 }, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    goto :L0
.end method

.method public static createARanSessionid(I)Ljava/lang/String;
  .parameter "number" # I
  .registers 14
  .prologue
    const-wide/16 v11, 10
  .line 585
    invoke-static { }, Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v5
  .line 586
  .local v5, "timestemp":J
    const-wide/16 v0, 1
  .line 587
  .local v0, "range":J
    const/4 v7, 0
  :L0
  .local v7, "x":I
    if-lt v7, p0, :L2
  .line 590
    invoke-static { v0, v1 }, Lcom/uc/paymentsdk/util/Utils;->getRan(J)J
    move-result-wide v2
  .line 591
  .local v2, "rdmint":J
    invoke-static { v2, v3 }, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v4
  :L1
  .line 592
  .local v4, "rdmstr":Ljava/lang/String;
    invoke-virtual { v4 }, Ljava/lang/String;->length()I
    move-result v8
    if-lt v8, p0, :L3
  .line 595
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-static { v5, v6 }, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v9
    invoke-direct { v8, v9 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v8, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual { v8 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    return-object v8
  :L2
  .line 588
  .end local v2
  .end local v4
    mul-long/2addr v0, v11
  .line 587
    add-int/lit8 v7, v7, 1
    goto :L0
  :L3
  .line 593
  .restart local v2
  .restart local v4
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-static { v4 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v9
    invoke-direct { v8, v9 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-static { v11, v12 }, Lcom/uc/paymentsdk/util/Utils;->getRan(J)J
    move-result-wide v9
    invoke-virtual { v8, v9, v10 }, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual { v8 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    goto :L1
.end method

.method public static dateDiffByDay(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
  .parameter "starttime" # Ljava/lang/String;
  .parameter "endtime" # Ljava/lang/String;
  .parameter "format" # Ljava/lang/String;
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L3
  .registers 15
  .prologue
  .line 615
    new-instance v7, Ljava/text/SimpleDateFormat;
    invoke-direct { v7, p2 }, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V
  .line 616
  .local v7, "sd":Ljava/text/SimpleDateFormat;
    const-wide/32 v5, 86400000
  :L0
  .line 618
  .local v5, "nd":J
    invoke-virtual { v7, p1 }, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    move-result-object v8
    invoke-virtual { v8 }, Ljava/util/Date;->getTime()J
    move-result-wide v8
    invoke-virtual { v7, p0 }, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    move-result-object v10
    invoke-virtual { v10 }, Ljava/util/Date;->getTime()J
    move-result-wide v10
    sub-long v2, v8, v10
  .line 619
  .local v2, "diff":J
    div-long v0, v2, v5
  :L1
  .line 620
  .local v0, "day":J
    long-to-int v8, v0
  :L2
  .line 623
  .end local v0
  .end local v2
    return v8
  :L3
  .line 622
    move-exception v8
    move-object v4, v8
  .line 623
  .local v4, "e":Ljava/lang/Exception;
    const/4 v8, -1
    goto :L2
.end method

.method public static generateBorderView(Landroid/content/Context;)Landroid/widget/TextView;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 300
    new-instance v0, Landroid/widget/TextView;
    invoke-direct { v0, p0 }, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
  .line 301
  .local v0, "localTextView":Landroid/widget/TextView;
    const v1, 17301524
    invoke-virtual { v0, v1 }, Landroid/widget/TextView;->setBackgroundResource(I)V
  .line 302
    return-object v0
.end method

.method public static generateFooterView(Landroid/content/Context;)Landroid/widget/LinearLayout;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 10
  .prologue
    const/16 v8, 20
    const/4 v5, 1
    const/4 v7, 0
    const/4 v6, -1
  .line 244
    new-instance v4, Landroid/widget/LinearLayout;
    invoke-direct { v4, p0 }, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
  .line 245
  .local v4, "localLinearLayout":Landroid/widget/LinearLayout;
    invoke-virtual { v4, v5 }, Landroid/widget/LinearLayout;->setOrientation(I)V
  .line 246
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/Utils;->generateBorderView(Landroid/content/Context;)Landroid/widget/TextView;
    move-result-object v3
  .line 247
  .local v3, "lineTextView":Landroid/widget/TextView;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct { v2, v6, v5 }, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
  .line 249
  .local v2, "lineLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual { v3, v2 }, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
  .line 250
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
  .line 252
    const/4 v5, -2
  .line 250
    invoke-direct { v0, v6, v5 }, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V
  .line 253
  .local v0, "footLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    new-instance v1, Landroid/widget/TextView;
    invoke-direct { v1, p0 }, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
  .line 254
  .local v1, "footerTextView":Landroid/widget/TextView;
    const/high16 v5, 16768
    invoke-virtual { v1, v5 }, Landroid/widget/TextView;->setTextSize(F)V
  .line 255
    const/16 v5, 17
    invoke-virtual { v1, v5 }, Landroid/widget/TextView;->setGravity(I)V
  .line 256
    invoke-virtual { v1, v7, v8, v7, v8 }, Landroid/widget/TextView;->setPadding(IIII)V
  .line 257
    const-string v5, "UC\u6e38\u620f-UC\u4f18\u89c6"
    invoke-virtual { v1, v5 }, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
  .line 258
    const v5, -12303292
    invoke-virtual { v1, v5 }, Landroid/widget/TextView;->setTextColor(I)V
  .line 259
    invoke-virtual { v4, v3 }, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
  .line 260
    invoke-virtual { v4, v1, v0 }, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
  .line 261
    return-object v4
.end method

.method public static generateOrderId(Lcom/uc/paymentsdk/payment/PaymentInfo;)V
  .parameter "paramPaymentInfo" # Lcom/uc/paymentsdk/payment/PaymentInfo;
  .catch Ljava/io/UnsupportedEncodingException; { :L0 .. :L1 } :L3
  .registers 7
  .prologue
  .line 306
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getIpAddress()Ljava/lang/String;
    move-result-object v1
  :L0
  .line 309
  .local v1, "str1":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getUsername()Ljava/lang/String;
    move-result-object v4
    const-string v5, "UTF-8"
    invoke-static { v4, v5 }, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static { v4 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
  .line 310
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getAppkey()Ljava/lang/String;
    move-result-object v4
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
  .line 311
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getPayname()Ljava/lang/String;
    move-result-object v4
    const-string v5, "UTF-8"
    invoke-static { v4, v5 }, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
  .line 312
    invoke-static { }, Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-virtual { v3, v4, v5 }, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3, v1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
  .line 309
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
  :L1
    move-result-object v2
  :L2
  .line 316
  .local v2, "str2":Ljava/lang/String;
    invoke-static { v2 }, Lcom/uc/paymentsdk/commons/codec/DigestUtils;->md5Hex(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual { p0, v3 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->setOrderID(Ljava/lang/String;)V
  .line 317
    return-void
  :L3
  .line 313
  .end local v2
    move-exception v3
    move-object v0, v3
  .line 314
  .local v0, "localUnsupportedEncodingException":Ljava/io/UnsupportedEncodingException;
    const-string v2, ""
  .restart local v2
    goto :L2
.end method

.method public static getAppkey(Landroid/content/Context;)Ljava/lang/String;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Landroid/content/pm/PackageManager$NameNotFoundException;
    }
  .end annotation
  .parameter "paramContext" # Landroid/content/Context;
  .registers 5
  .prologue
  .line 231
    invoke-virtual { p0 }, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v1
  .line 232
    invoke-virtual { p0 }, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    const/16 v3, 128
    invoke-virtual { v1, v2, v3 }, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    move-result-object v0
  .line 233
  .local v0, "localApplicationInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v1, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;
    const-string v2, "ucgame_appkey"
    invoke-virtual { v1, v2 }, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public static getBodyString(ILorg/apache/http/HttpResponse;)Ljava/lang/String;
  .parameter "paramInt" # I
  .parameter "paramHttpResponse" # Lorg/apache/http/HttpResponse;
  .catch Lorg/apache/http/ParseException; { :L0 .. :L1 } :L4
  .catch Ljava/io/IOException; { :L0 .. :L1 } :L3
  .registers 5
  .prologue
  .line 370
    const/4 v0, 0
  :L0
  .line 372
  .local v0, "str":Ljava/lang/String;
    invoke-interface { p1 }, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;
    move-result-object v1
    const-string v2, "UTF-8"
    invoke-static { v1, v2 }, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
  :L1
    move-result-object v0
  :L2
  .line 376
    return-object v0
  :L3
  .line 374
    move-exception v1
    goto :L2
  :L4
  .line 373
    move-exception v1
    goto :L2
.end method

.method public static getCpID(Landroid/content/Context;)Ljava/lang/String;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Landroid/content/pm/PackageManager$NameNotFoundException;
    }
  .end annotation
  .parameter "paramContext" # Landroid/content/Context;
  .registers 5
  .prologue
  .line 238
    invoke-virtual { p0 }, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v1
  .line 239
    invoke-virtual { p0 }, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    const/16 v3, 128
    invoke-virtual { v1, v2, v3 }, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    move-result-object v0
  .line 240
  .local v0, "localApplicationInfo":Landroid/content/pm/ApplicationInfo;
    iget-object v1, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;
    const-string v2, "ucgame_cpid"
    invoke-virtual { v1, v2 }, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method public static getCurrentTime(Z)Ljava/lang/String;
  .parameter "isdateonly" # Z
  .registers 3
  .prologue
  .line 607
    if-eqz p0, :L1
  .line 608
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string v1, "yyyy-MM-dd"
    invoke-direct { v0, v1 }, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V
  :L0
  .line 611
  .local v0, "format1":Ljava/text/DateFormat;
    new-instance v1, Ljava/util/Date;
    invoke-direct { v1 }, Ljava/util/Date;-><init>()V
    invoke-virtual { v0, v1 }, Ljava/text/DateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v1
    return-object v1
  :L1
  .line 610
  .end local v0
    new-instance v0, Ljava/text/SimpleDateFormat;
    const-string v1, "yyyy-MM-dd hh:mm:ss"
    invoke-direct { v0, v1 }, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V
  .restart local v0
    goto :L0
.end method

.method public static getDouble(Ljava/lang/String;)D
  .parameter "paramString" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 101
    invoke-static { p0 }, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D
    move-result-wide v0
    return-wide v0
.end method

.method public static getDrawableFromFile(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 291
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/Utils;->getFileStream(Ljava/lang/String;)Ljava/io/InputStream;
    move-result-object v0
    invoke-static { v0, p0 }, Landroid/graphics/drawable/Drawable;->createFromStream(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    move-result-object v0
    return-object v0
.end method

.method private static getFileStream(Ljava/lang/String;)Ljava/io/InputStream;
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 273
    const-class v0, Lres/FileLoader;
    invoke-virtual { v0, p0 }, Ljava/lang/Class;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;
    move-result-object v0
    return-object v0
.end method

.method public static getInt(ILjava/lang/String;)I
  .parameter "paramInt" # I
  .parameter "paramString" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 89
    const/4 v0, 0
    invoke-static { p0, p1, v0 }, Lcom/uc/paymentsdk/util/Utils;->getInt(ILjava/lang/String;I)I
    move-result v0
    return v0
.end method

.method public static getInt(ILjava/lang/String;I)I
  .parameter "paramInt1" # I
  .parameter "paramString" # Ljava/lang/String;
  .parameter "paramInt2" # I
  .catch Ljava/lang/NumberFormatException; { :L1 .. :L2 } :L3
  .registers 5
  .prologue
  .line 79
    if-nez p1, :L1
    move v0, p2
  :L0
  .line 85
    return v0
  :L1
  .line 82
    invoke-virtual { p1 }, Ljava/lang/String;->trim()Ljava/lang/String;
    move-result-object v0
    invoke-static { v0, p0 }, Ljava/lang/Long;->parseLong(Ljava/lang/String;I)J
  :L2
    move-result-wide v0
    long-to-int v0, v0
    goto :L0
  :L3
  .line 83
    move-exception v0
    move v0, p2
  .line 85
    goto :L0
.end method

.method public static getInt(Ljava/lang/String;)I
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 97
    const/16 v0, 10
    invoke-static { v0, p0 }, Lcom/uc/paymentsdk/util/Utils;->getInt(ILjava/lang/String;)I
    move-result v0
    return v0
.end method

.method public static getInt(Ljava/lang/String;I)I
  .parameter "paramString" # Ljava/lang/String;
  .parameter "paramInt" # I
  .registers 3
  .prologue
  .line 93
    const/16 v0, 10
    invoke-static { v0, p0, p1 }, Lcom/uc/paymentsdk/util/Utils;->getInt(ILjava/lang/String;I)I
    move-result v0
    return v0
.end method

.method private static getIpAddress()Ljava/lang/String;
  .catch Ljava/net/SocketException; { :L0 .. :L2 } :L8
  .catch Ljava/net/SocketException; { :L5 .. :L7 } :L8
  .registers 5
  :L0
  .prologue
  .line 382
    invoke-static { }, Ljava/net/NetworkInterface;->getNetworkInterfaces()Ljava/util/Enumeration;
    move-result-object v0
  :L1
  .line 383
  .local v0, "localEnumeration1":Ljava/util/Enumeration;
    invoke-interface { v0 }, Ljava/util/Enumeration;->hasMoreElements()Z
  :L2
    move-result v4
    if-nez v4, :L5
  :L3
  .line 397
  .end local v0
    const-string v4, ""
  :L4
    return-object v4
  :L5
  .line 385
  .restart local v0
    invoke-interface { v0 }, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/net/NetworkInterface;
  .line 387
  .local v3, "localNetworkInterface":Ljava/net/NetworkInterface;
    invoke-virtual { v3 }, Ljava/net/NetworkInterface;->getInetAddresses()Ljava/util/Enumeration;
    move-result-object v1
  :L6
  .line 388
  .local v1, "localEnumeration2":Ljava/util/Enumeration;
    invoke-interface { v1 }, Ljava/util/Enumeration;->hasMoreElements()Z
    move-result v4
    if-eqz v4, :L1
  .line 390
    invoke-interface { v1 }, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/net/InetAddress;
  .line 391
  .local v2, "localInetAddress":Ljava/net/InetAddress;
    invoke-virtual { v2 }, Ljava/net/InetAddress;->isLoopbackAddress()Z
    move-result v4
    if-nez v4, :L6
  .line 392
    invoke-virtual { v2 }, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;
  :L7
    move-result-object v4
    goto :L4
  :L8
  .line 395
  .end local v0
  .end local v1
  .end local v2
  .end local v3
    move-exception v4
    goto :L3
.end method

.method public static getLong(Ljava/lang/String;)J
  .parameter "paramString" # Ljava/lang/String;
  .catch Ljava/lang/NumberFormatException; { :L1 .. :L2 } :L3
  .registers 4
  .prologue
    const-wide/16 v1, 0
  .line 105
    if-nez p0, :L1
    move-wide v0, v1
  :L0
  .line 111
    return-wide v0
  :L1
  .line 108
    invoke-virtual { p0 }, Ljava/lang/String;->trim()Ljava/lang/String;
    move-result-object v0
    invoke-static { v0 }, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
  :L2
    move-result-wide v0
    goto :L0
  :L3
  .line 109
    move-exception v0
    move-wide v0, v1
  .line 111
    goto :L0
.end method

.method public static getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;
  .registers 1
  .prologue
  .line 265
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sPaymentInfo:Lcom/uc/paymentsdk/payment/PaymentInfo;
    return-object v0
.end method

.method public static getQueryString(Ljava/util/HashMap;)Ljava/lang/String;
  .annotation system Ldalvik/annotation/Signature;
    value = {
      "(",
      "Ljava/util/HashMap",
      "<",
      "Ljava/lang/String;",
      "Ljava/lang/Object;",
      ">;)",
      "Ljava/lang/String;"
    }
  .end annotation
  .registers 6
  .local p0, "paramHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
  .prologue
  .line 341
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct { v1 }, Ljava/lang/StringBuilder;-><init>()V
  .line 342
  .local v1, "querystring":Ljava/lang/StringBuilder;
    invoke-virtual { p0 }, Ljava/util/HashMap;->keySet()Ljava/util/Set;
    move-result-object v3
    invoke-interface { v3 }, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
  :L0
  .line 343
  .local v0, "localIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    invoke-interface { v0 }, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-nez v3, :L1
  .line 352
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
  :L1
  .line 344
    invoke-interface { v0 }, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
  .line 345
  .local v2, "str":Ljava/lang/String;
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->length()I
    move-result v3
    const/4 v4, 1
    if-ge v3, v4, :L3
  .line 346
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-static { v2 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v4, "="
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  :L2
  .line 350
    invoke-virtual { p0, v2 }, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    goto :L0
  :L3
  .line 348
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "&"
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v3, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "="
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto :L2
.end method

.method private static getRan(J)J
  .parameter "range" # J
  .registers 7
  .prologue
  .line 570
    sget-object v2, Lcom/uc/paymentsdk/util/Utils;->rdm:Ljava/util/Random;
    if-nez v2, :L0
  .line 571
    new-instance v2, Ljava/util/Random;
    invoke-direct { v2 }, Ljava/util/Random;-><init>()V
    sput-object v2, Lcom/uc/paymentsdk/util/Utils;->rdm:Ljava/util/Random;
  :L0
  .line 573
    sget-object v2, Lcom/uc/paymentsdk/util/Utils;->rdm:Ljava/util/Random;
    invoke-virtual { v2 }, Ljava/util/Random;->nextLong()J
    move-result-wide v2
    const/4 v4, 1
    ushr-long/2addr v2, v4
    rem-long v0, v2, p0
  .line 574
  .local v0, "rtn":J
    return-wide v0
.end method

.method public static getSessionID(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 633
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/PrefUtil;->getUserSession(Landroid/content/Context;)Ljava/lang/String;
    move-result-object v0
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->sessionidstr:Ljava/lang/String;
  .line 634
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sessionidstr:Ljava/lang/String;
    if-eqz v0, :L0
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sessionidstr:Ljava/lang/String;
    const-string v1, ""
    invoke-virtual { v0, v1 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, :L2
  :L0
  .line 635
    const/16 v0, 8
    invoke-static { v0 }, Lcom/uc/paymentsdk/util/Utils;->createARanSessionid(I)Ljava/lang/String;
    move-result-object v0
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->sessionidstr:Ljava/lang/String;
  .line 636
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sessionidstr:Ljava/lang/String;
    invoke-static { p0, v0 }, Lcom/uc/paymentsdk/util/PrefUtil;->setUserSession(Landroid/content/Context;Ljava/lang/String;)V
  .line 637
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sessionidstr:Ljava/lang/String;
  :L1
  .line 639
    return-object v0
  :L2
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sessionidstr:Ljava/lang/String;
    goto :L1
.end method

.method public static getSimNumber(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 3
  .prologue
  .line 452
    const-string v1, "phone"
    invoke-virtual { p0, v1 }, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object p0
  .end local p0
    check-cast p0, Landroid/telephony/TelephonyManager;
  .line 453
    invoke-virtual { p0 }, Landroid/telephony/TelephonyManager;->getSubscriberId()Ljava/lang/String;
    move-result-object v0
  .line 454
  .local v0, "str":Ljava/lang/String;
    return-object v0
.end method

.method public static getSmsInfos()Lcom/uc/paymentsdk/payment/sms/SmsInfos;
  .registers 1
  .prologue
  .line 458
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sSmsInfos:Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    return-object v0
.end method

.method public static getSmsPayment()I
  .registers 1
  .prologue
  .line 506
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->getPaymentInfo()Lcom/uc/paymentsdk/payment/PaymentInfo;
    move-result-object v0
    invoke-virtual { v0 }, Lcom/uc/paymentsdk/payment/PaymentInfo;->getMoney()I
    move-result v0
    div-int/lit8 v0, v0, 10
    return v0
.end method

.method private static getTitleIconFileName(Ljava/lang/String;)Ljava/lang/String;
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 173
    invoke-static { }, Lcom/uc/paymentsdk/util/Utils;->isHdpi()Z
    move-result v0
  .line 174
  .local v0, "bool":Z
    const-string v1, "back"
    invoke-virtual { v1, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, :L2
  .line 176
    if-eqz v0, :L1
  .line 177
    const-string v1, "back_btn_hdpi.png"
  :L0
  .line 184
    return-object v1
  :L1
  .line 178
    const-string v1, "back_btn.png"
    goto :L0
  :L2
  .line 180
    const-string v1, "cancel"
    invoke-virtual { v1, p0 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, :L4
  .line 182
    if-eqz v0, :L3
  .line 183
    const-string v1, "cancel_btn_hdpi.png"
    goto :L0
  :L3
  .line 184
    const-string v1, "cancel_btn.png"
    goto :L0
  :L4
  .line 186
    new-instance v1, Ljava/lang/IllegalArgumentException;
    const-string v2, "type not supported."
    invoke-direct { v1, v2 }, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static getUPConsumeid(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
  .parameter "uid" # Ljava/lang/String;
  .parameter "cpid" # Ljava/lang/String;
  .parameter "gameid" # Ljava/lang/String;
  .registers 5
  .prologue
  .line 655
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->upconsumeid:Ljava/lang/String;
    if-eqz v0, :L0
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->upconsumeid:Ljava/lang/String;
    const-string v1, ""
    invoke-virtual { v0, v1 }, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, :L1
  :L0
  .line 656
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-static { p1 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-direct { v0, v1 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v0, p2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual { v0, p0 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 10
    invoke-static { v1 }, Lcom/uc/paymentsdk/util/Utils;->createARanConsumeID(I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual { v0, v1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual { v0 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    sput-object v0, Lcom/uc/paymentsdk/util/Utils;->upconsumeid:Ljava/lang/String;
  :L1
  .line 658
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->upconsumeid:Ljava/lang/String;
    return-object v0
.end method

.method public static getUPointInfo()Lcom/uc/paymentsdk/payment/upoint/UPointInfo;
  .registers 1
  .prologue
  .line 466
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sUPointInfo:Lcom/uc/paymentsdk/payment/upoint/UPointInfo;
    return-object v0
.end method

.method public static getUPointPayInfo()Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;
  .registers 1
  .prologue
  .line 484
    sget-object v0, Lcom/uc/paymentsdk/util/Utils;->sUPointPayInfo:Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;
    return-object v0
.end method

.method public static getUTF8Bytes(Ljava/lang/String;)[B
  .parameter "paramString" # Ljava/lang/String;
  .catch Ljava/io/UnsupportedEncodingException; { :L1 .. :L2 } :L3
  .catch Ljava/io/IOException; { :L4 .. :L5 } :L6
  .registers 10
  .prologue
    const/4 v6, 2
    const/4 v8, 0
  .line 132
    if-nez p0, :L1
  .line 133
    new-array v5, v8, [B
  :L0
  .line 152
    return-object v5
  :L1
  .line 135
    const-string v5, "UTF-8"
    invoke-virtual { p0, v5 }, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
  :L2
    move-result-object v5
    goto :L0
  :L3
  .line 136
    move-exception v5
    move-object v4, v5
  :L4
  .line 138
  .local v4, "localUnsupportedEncodingException":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/io/ByteArrayOutputStream;
    invoke-direct { v2 }, Ljava/io/ByteArrayOutputStream;-><init>()V
  .line 139
  .local v2, "localByteArrayOutputStream":Ljava/io/ByteArrayOutputStream;
    new-instance v3, Ljava/io/DataOutputStream;
    invoke-direct { v3, v2 }, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
  .line 141
  .local v3, "localDataOutputStream":Ljava/io/DataOutputStream;
    invoke-virtual { v3, p0 }, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V
  .line 142
    invoke-virtual { v2 }, Ljava/io/ByteArrayOutputStream;->toByteArray()[B
    move-result-object v0
  .line 143
  .local v0, "arrayOfByte1":[B
    invoke-virtual { v2 }, Ljava/io/ByteArrayOutputStream;->close()V
  .line 144
    invoke-virtual { v3 }, Ljava/io/DataOutputStream;->close()V
  .line 145
    array-length v5, v0
    sub-int/2addr v5, v6
    new-array v1, v5, [B
  .line 146
  .local v1, "arrayOfByte2":[B
    const/4 v5, 2
    const/4 v6, 0
  .line 147
    array-length v7, v1
  .line 146
    invoke-static { v0, v5, v1, v6, v7 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  :L5
    move-object v5, v1
  .line 148
    goto :L0
  :L6
  .line 149
  .end local v0
  .end local v1
  .end local v2
  .end local v3
    move-exception v5
  .line 152
    new-array v5, v8, [B
    goto :L0
.end method

.method public static getUTF8String([B)Ljava/lang/String;
  .parameter "paramArrayOfByte" # [B
  .registers 3
  .prologue
  .line 115
    if-nez p0, :L1
  .line 116
    const-string v0, ""
  :L0
  .line 117
    return-object v0
  :L1
    const/4 v0, 0
    array-length v1, p0
    invoke-static { p0, v0, v1 }, Lcom/uc/paymentsdk/util/Utils;->getUTF8String([BII)Ljava/lang/String;
    move-result-object v0
    goto :L0
.end method

.method public static getUTF8String([BII)Ljava/lang/String;
  .parameter "paramArrayOfByte" # [B
  .parameter "paramInt1" # I
  .parameter "paramInt2" # I
  .catch Ljava/io/UnsupportedEncodingException; { :L1 .. :L2 } :L3
  .registers 5
  .prologue
  .line 122
    if-nez p0, :L1
  .line 123
    const-string v0, ""
  :L0
  .line 128
    return-object v0
  :L1
  .line 125
    new-instance v0, Ljava/lang/String;
    const-string v1, "UTF-8"
    invoke-direct { v0, p0, p1, p2, v1 }, Ljava/lang/String;-><init>([BIILjava/lang/String;)V
  :L2
    goto :L0
  :L3
  .line 126
    move-exception v0
  .line 128
    const-string v0, ""
    goto :L0
.end method

.method public static getUserAgent(Landroid/content/Context;)Ljava/lang/String;
  .parameter "paramContext" # Landroid/content/Context;
  .catch Landroid/content/pm/PackageManager$NameNotFoundException; { :L0 .. :L1 } :L3
  .registers 5
  .prologue
  .line 356
    const-string v1, ""
  .line 357
  .local v1, "str":Ljava/lang/String;
    invoke-virtual { p0 }, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v0
  :L0
  .line 361
  .local v0, "localPackageManager":Landroid/content/pm/PackageManager;
    invoke-virtual { p0 }, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v2
    const/16 v3, 128
  .line 360
    invoke-virtual { v0, v2, v3 }, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    move-result-object v2
  .line 359
    invoke-virtual { v0, v2 }, Landroid/content/pm/PackageManager;->getApplicationLabel(Landroid/content/pm/ApplicationInfo;)Ljava/lang/CharSequence;
    move-result-object v2
  .line 361
    invoke-interface { v2 }, Ljava/lang/CharSequence;->toString()Ljava/lang/String;
  :L1
    move-result-object v1
  :L2
  .line 364
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "packageName="
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { p0 }, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ",appName="
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
  .line 365
    invoke-virtual { v2, v1 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ",channelID=1"
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
  .line 364
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
  :L3
  .line 362
    move-exception v2
    goto :L2
.end method

.method public static getXmlFromFile(Ljava/lang/String;)Ljava/lang/String;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/io/IOException;
    }
  .end annotation
  .parameter "paramString" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 296
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/Utils;->getFileStream(Ljava/lang/String;)Ljava/io/InputStream;
    move-result-object v0
    invoke-static { v0 }, Lcom/uc/paymentsdk/util/Utils;->convertStreamToString(Ljava/io/InputStream;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static getXmlRequestBody(Ljava/util/HashMap;Landroid/content/Context;)Ljava/lang/String;
  .annotation system Ldalvik/annotation/Signature;
    value = {
      "(",
      "Ljava/util/HashMap",
      "<",
      "Ljava/lang/String;",
      "Ljava/lang/Object;",
      ">;",
      "Landroid/content/Context;",
      ")",
      "Ljava/lang/String;"
    }
  .end annotation
  .parameter # Ljava/util/HashMap;
  .parameter "paramContext" # Landroid/content/Context;
  .registers 7
  .local p0, "paramHashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
  .prologue
  .line 321
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct { v1 }, Ljava/lang/StringBuilder;-><init>()V
  .line 322
  .local v1, "localStringBuilder":Ljava/lang/StringBuilder;
    const-string v3, "<request"
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  .line 323
    const-string v3, "local_version"
    invoke-virtual { p0, v3 }, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, :L0
  .line 324
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, " local_version=\""
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
  .line 325
    const-string v4, "local_version"
    invoke-virtual { p0, v4 }, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, "\" "
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
  .line 324
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  .line 326
    const-string v3, "local_version"
    invoke-virtual { p0, v3 }, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
  :L0
  .line 328
    const-string v3, ">"
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  .line 329
    invoke-virtual { p0 }, Ljava/util/HashMap;->keySet()Ljava/util/Set;
    move-result-object v3
    invoke-interface { v3 }, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
  :L1
  .line 330
  .local v0, "localIterator":Ljava/util/Iterator;
    invoke-interface { v0 }, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-nez v3, :L2
  .line 336
    const-string v3, "</request>"
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  .line 337
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
  :L2
  .line 331
    invoke-interface { v0 }, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
  .line 332
  .local v2, "str":Ljava/lang/String;
    const-string v3, "<"
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ">"
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
  .line 333
    invoke-virtual { p0, v2 }, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
  .line 334
    const-string v3, "</"
    invoke-virtual { v1, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const-string v4, ">"
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto :L1
.end method

.method public static init(Landroid/content/Context;)V
  .parameter "context" # Landroid/content/Context;
  .catch Landroid/content/pm/PackageManager$NameNotFoundException; { :L0 .. :L1 } :L7
  .catch Ljava/lang/SecurityException; { :L2 .. :L3 } :L4
  .catch Ljava/lang/NoSuchFieldException; { :L2 .. :L3 } :L8
  .catch Ljava/lang/IllegalArgumentException; { :L2 .. :L3 } :L10
  .catch Ljava/lang/IllegalAccessException; { :L2 .. :L3 } :L11
  .catch Landroid/content/pm/PackageManager$NameNotFoundException; { :L2 .. :L3 } :L7
  .catch Landroid/content/pm/PackageManager$NameNotFoundException; { :L5 .. :L6 } :L7
  .catch Landroid/content/pm/PackageManager$NameNotFoundException; { :L9 .. :L12 } :L7
  .registers 18
  .prologue
    const/16 v16, 0
  :L0
  .line 406
    invoke-virtual/range { p0 .. p0 }, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;
    move-result-object v12
  .line 407
    invoke-virtual/range { p0 .. p0 }, Landroid/content/Context;->getPackageName()Ljava/lang/String;
    move-result-object v13
    const/16 v14, 128
    invoke-virtual { v12, v13, v14 }, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
  :L1
    move-result-object v3
  :L2
  .line 409
  .local v3, "localApplicationInfo":Landroid/content/pm/ApplicationInfo;
    invoke-virtual { v3 }, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v12
  .line 410
    const-string v13, "targetSdkVersion"
    invoke-virtual { v12, v13 }, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v4
  .line 411
  .local v4, "localField":Ljava/lang/reflect/Field;
    invoke-virtual { v4, v3 }, Ljava/lang/reflect/Field;->getInt(Ljava/lang/Object;)I
    move-result v2
  .line 412
  .local v2, "i":I
    const/4 v12, 4
    if-ge v2, v12, :L13
  .line 413
    const/4 v12, 0
    sput-boolean v12, Lcom/uc/paymentsdk/util/Utils;->sIsHdpi:Z
  :L3
  .line 439
  .end local v2
  .end local v3
  .end local v4
    return-void
  :L4
  .line 416
  .restart local v3
    move-exception v12
    move-object v10, v12
  .line 417
  .local v10, "localSecurityException":Ljava/lang/SecurityException;
    const/4 v12, 0
  :L5
    sput-boolean v12, Lcom/uc/paymentsdk/util/Utils;->sIsHdpi:Z
  :L6
    goto :L3
  :L7
  .line 429
  .end local v3
  .end local v10
    move-exception v12
    move-object v7, v12
  .line 430
  .local v7, "localNameNotFoundException":Landroid/content/pm/PackageManager$NameNotFoundException;
    sput-boolean v16, Lcom/uc/paymentsdk/util/Utils;->sIsHdpi:Z
    goto :L3
  :L8
  .line 419
  .end local v7
  .restart local v3
    move-exception v12
    move-object v8, v12
  .line 420
  .local v8, "localNoSuchFieldException":Ljava/lang/NoSuchFieldException;
    const/4 v12, 0
  :L9
    sput-boolean v12, Lcom/uc/paymentsdk/util/Utils;->sIsHdpi:Z
    goto :L3
  :L10
  .line 422
  .end local v8
    move-exception v12
    move-object v6, v12
  .line 423
  .local v6, "localIllegalArgumentException":Ljava/lang/IllegalArgumentException;
    const/4 v12, 0
    sput-boolean v12, Lcom/uc/paymentsdk/util/Utils;->sIsHdpi:Z
    goto :L3
  :L11
  .line 425
  .end local v6
    move-exception v12
    move-object v5, v12
  .line 426
  .local v5, "localIllegalAccessException":Ljava/lang/IllegalAccessException;
    const/4 v12, 0
    sput-boolean v12, Lcom/uc/paymentsdk/util/Utils;->sIsHdpi:Z
  :L12
    goto :L3
  :L13
  .line 434
  .end local v5
  .restart local v2
  .restart local v4
    const-string v12, "window"
    move-object/from16 v0, p0
    move-object v1, v12
    invoke-virtual { v0, v1 }, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v11
  .line 433
    check-cast v11, Landroid/view/WindowManager;
  .line 435
  .local v11, "localWindowManager":Landroid/view/WindowManager;
    new-instance v9, Landroid/util/DisplayMetrics;
    invoke-direct { v9 }, Landroid/util/DisplayMetrics;-><init>()V
  .line 436
  .local v9, "localObject":Landroid/util/DisplayMetrics;
    invoke-interface { v11 }, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;
    move-result-object v13
  .line 437
    move-object v0, v9
    check-cast v0, Landroid/util/DisplayMetrics;
    move-object v12, v0
  .line 436
    invoke-virtual { v13, v12 }, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V
  .line 438
    check-cast v9, Landroid/util/DisplayMetrics;
  .end local v9
    iget v12, v9, Landroid/util/DisplayMetrics;->density:F
    float-to-double v12, v12
    const-wide/high16 v14, 16368
    cmpl-double v12, v12, v14
    if-lez v12, :L15
    const/4 v12, 1
  :L14
    sput-boolean v12, Lcom/uc/paymentsdk/util/Utils;->sIsHdpi:Z
    goto :L3
  :L15
    move/from16 v12, v16
    goto :L14
.end method

.method public static initSubTitle(Landroid/content/Context;Landroid/view/View$OnClickListener;Ljava/lang/String;Z)Landroid/widget/RelativeLayout;
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "listener" # Landroid/view/View$OnClickListener;
  .parameter "paramString" # Ljava/lang/String;
  .parameter "iscancel" # Z
  .registers 10
  .prologue
  .line 190
    new-instance v2, Landroid/widget/RelativeLayout;
    invoke-direct { v2, p0 }, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V
  .line 191
  .local v2, "layout":Landroid/widget/RelativeLayout;
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;
    const/4 v1, -1
    const/4 v3, -2
    invoke-direct { v0, v1, v3 }, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V
    invoke-virtual { v2, v0 }, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
  .line 192
    new-instance v0, Landroid/graphics/drawable/GradientDrawable;
    sget-object v1, Landroid/graphics/drawable/GradientDrawable$Orientation;->TOP_BOTTOM:Landroid/graphics/drawable/GradientDrawable$Orientation;
    const/4 v3, 2
    new-array v3, v3, [I
    const/4 v4, 0
    sget v5, Lcom/uc/paymentsdk/util/Constants;->COLOR_SUBTITLE_BACKGROUND1:I
    aput v5, v3, v4
    const/4 v4, 1
    sget v5, Lcom/uc/paymentsdk/util/Constants;->COLOR_SUBTITLE_BACKGROUND2:I
    aput v5, v3, v4
    invoke-direct { v0, v1, v3 }, Landroid/graphics/drawable/GradientDrawable;-><init>(Landroid/graphics/drawable/GradientDrawable$Orientation;[I)V
  .line 193
  .local v0, "gb":Landroid/graphics/drawable/GradientDrawable;
    invoke-virtual { v2, v0 }, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
  .line 194
    new-instance v0, Landroid/widget/ImageView;
  .end local v0
    invoke-direct { v0, p0 }, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
  .line 195
  .local v0, "backicon":Landroid/widget/ImageView;
    const-string v1, "back"
    invoke-static { v1 }, Lcom/uc/paymentsdk/util/Utils;->getTitleIconFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static { v1 }, Lcom/uc/paymentsdk/util/Utils;->getDrawableFromFile(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    move-result-object v1
    invoke-virtual { v0, v1 }, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V
  .line 196
    const/16 v1, 9
    invoke-virtual { v0, v1 }, Landroid/widget/ImageView;->setId(I)V
  .line 197
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;
    const/4 v3, -2
    const/4 v4, -2
    invoke-direct { v1, v3, v4 }, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V
  .line 198
  .local v1, "paramsleft":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v3, 9
    invoke-virtual { v1, v3 }, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V
  .line 199
    const/16 v3, 15
    invoke-virtual { v1, v3 }, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V
  .line 200
    invoke-virtual { v0, v1 }, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
  .line 201
    invoke-virtual { v0, p1 }, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
  .line 202
    const/16 v1, 8
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual { v0, v1, v3, v4, v5 }, Landroid/widget/ImageView;->setPadding(IIII)V
  .line 203
  .end local v1
    new-instance v1, Landroid/widget/ImageView;
    invoke-direct { v1, p0 }, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
  .line 204
  .local v1, "cancelicon":Landroid/widget/ImageView;
    const-string v3, "cancel"
    invoke-static { v3 }, Lcom/uc/paymentsdk/util/Utils;->getTitleIconFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-static { v3 }, Lcom/uc/paymentsdk/util/Utils;->getDrawableFromFile(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    move-result-object v3
    invoke-virtual { v1, v3 }, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V
  .line 205
    const/16 v3, 10
    invoke-virtual { v1, v3 }, Landroid/widget/ImageView;->setId(I)V
  .line 206
    new-instance v3, Landroid/widget/RelativeLayout$LayoutParams;
    const/4 v4, -2
    const/4 v5, -2
    invoke-direct { v3, v4, v5 }, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V
  .line 207
  .local v3, "paramsright":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v4, 11
    invoke-virtual { v3, v4 }, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V
  .line 208
    const/16 v4, 15
    invoke-virtual { v3, v4 }, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V
  .line 209
    invoke-virtual { v1, v3 }, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
  .line 210
    invoke-virtual { v1, p1 }, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
  .line 211
    const/4 p1, 0
    const/4 v3, 0
    const/16 v4, 10
    const/4 v5, 0
    invoke-virtual { v1, p1, v3, v4, v5 }, Landroid/widget/ImageView;->setPadding(IIII)V
  .line 212
  .end local v3
  .end local p1
    new-instance p1, Landroid/widget/TextView;
    invoke-direct { p1, p0 }, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
  .line 213
  .local p1, "localTextView":Landroid/widget/TextView;
    const/16 p0, 17
    invoke-virtual { p1, p0 }, Landroid/widget/TextView;->setGravity(I)V
  .line 214
  .end local p0
    sget p0, Lcom/uc/paymentsdk/util/Constants;->COLOR_TITLE_BACKGROUND:I
    invoke-virtual { p1, p0 }, Landroid/widget/TextView;->setTextColor(I)V
  .line 215
    const/4 p0, 0
    const/16 v3, 10
    const/4 v4, 0
    const/16 v5, 10
    invoke-virtual { p1, p0, v3, v4, v5 }, Landroid/widget/TextView;->setPadding(IIII)V
  .line 216
    const/high16 p0, 16824
    invoke-virtual { p1, p0 }, Landroid/widget/TextView;->setTextSize(F)V
  .line 217
    invoke-virtual { p1, p2 }, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
  .line 218
    new-instance p0, Landroid/widget/RelativeLayout$LayoutParams;
    const/4 p2, -2
    const/4 v3, -2
    invoke-direct { p0, p2, v3 }, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V
  .line 219
  .end local p2
  .local p0, "paramscenter":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 p2, 14
    invoke-virtual { p0, p2 }, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V
  .line 220
    invoke-virtual { p1, p0 }, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
  .line 221
    invoke-virtual { v2, v0 }, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V
  .line 222
    invoke-virtual { v2, p1 }, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V
  .line 223
    if-eqz p3, :L0
  .line 224
    invoke-virtual { v2, v1 }, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V
  :L0
  .line 226
    return-object v2
.end method

.method public static initTitleBar(Landroid/app/Activity;)V
  .parameter "paramActivity" # Landroid/app/Activity;
  .registers 7
  .prologue
  .line 156
    invoke-virtual { p0 }, Landroid/app/Activity;->getWindow()Landroid/view/Window;
    move-result-object v4
  .line 157
    const v5, 16908310
  .line 156
    invoke-virtual { v4, v5 }, Landroid/view/Window;->findViewById(I)Landroid/view/View;
    move-result-object v1
  .line 158
  .local v1, "localView1":Landroid/view/View;
    if-eqz v1, :L1
  .line 159
    instance-of v4, v1, Landroid/widget/TextView;
    if-eqz v4, :L0
  .line 160
    move-object v0, v1
    check-cast v0, Landroid/widget/TextView;
    move-object v4, v0
    const/high16 v5, 16720
    invoke-virtual { v4, v5 }, Landroid/widget/TextView;->setTextSize(F)V
  :L0
  .line 161
    invoke-virtual { v1 }, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v3
  .line 162
  .local v3, "localViewParent":Landroid/view/ViewParent;
    if-eqz v3, :L1
  .line 163
    instance-of v4, v3, Landroid/view/View;
    if-eqz v4, :L1
  .line 164
    move-object v0, v3
    check-cast v0, Landroid/view/View;
    move-object v2, v0
  .line 165
  .local v2, "localView2":Landroid/view/View;
    const v4, 134875644
    invoke-virtual { v2, v4 }, Landroid/view/View;->setBackgroundColor(I)V
  :L1
  .line 168
  .end local v2
  .end local v3
    const-string v4, "UC\u652f\u4ed8"
    invoke-virtual { p0, v4 }, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V
  .line 169
    return-void
.end method

.method public static isAirMode(Landroid/content/Context;)Z
  .parameter "paramContext" # Landroid/content/Context;
  .catch Landroid/provider/Settings$SettingNotFoundException; { :L0 .. :L1 } :L3
  .registers 4
  .prologue
    const/4 v2, 1
  :L0
  .line 443
    invoke-virtual { p0 }, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;
    move-result-object v0
  .line 444
    const-string v1, "airplane_mode_on"
  .line 443
    invoke-static { v0, v1 }, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;)I
  :L1
    move-result v0
    if-ne v0, v2, :L4
    move v0, v2
  :L2
  .line 448
    return v0
  :L3
  .line 446
    move-exception v0
  :L4
  .line 448
    const/4 v0, 0
    goto :L2
.end method

.method public static isHdpi()Z
  .registers 1
  .prologue
  .line 401
    sget-boolean v0, Lcom/uc/paymentsdk/util/Utils;->sIsHdpi:Z
    return v0
.end method

.method public static isNumeric(Ljava/lang/String;)Z
  .parameter "str" # Ljava/lang/String;
  .registers 3
  .prologue
  .line 666
    const-string v1, "[0-9]*"
    invoke-static { v1 }, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;
    move-result-object v0
  .line 667
  .local v0, "pattern":Ljava/util/regex/Pattern;
    invoke-virtual { v0, p0 }, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/util/regex/Matcher;->matches()Z
    move-result v1
    return v1
.end method

.method public static loadFile(Ljava/lang/String;Ljava/lang/String;)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/io/IOException;,
      Ljava/io/FileNotFoundException;
    }
  .end annotation
  .parameter "paramString1" # Ljava/lang/String;
  .parameter "paramString2" # Ljava/lang/String;
  .registers 8
  .prologue
  .line 278
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/Utils;->getFileStream(Ljava/lang/String;)Ljava/io/InputStream;
    move-result-object v4
  .line 279
  .local v4, "localInputStream":Ljava/io/InputStream;
    new-instance v2, Ljava/io/File;
    invoke-direct { v2, p1 }, Ljava/io/File;-><init>(Ljava/lang/String;)V
  .line 280
  .local v2, "localFile":Ljava/io/File;
    invoke-virtual { v2 }, Ljava/io/File;->createNewFile()Z
  .line 281
    new-instance v3, Ljava/io/FileOutputStream;
    invoke-direct { v3, v2 }, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
  .line 282
  .local v3, "localFileOutputStream":Ljava/io/FileOutputStream;
    const/16 v5, 1024
    new-array v0, v5, [B
  .line 283
  .local v0, "arrayOfByte":[B
    const/4 v1, 0
  :L0
  .line 284
  .local v1, "i":I
    invoke-virtual { v4, v0 }, Ljava/io/InputStream;->read([B)I
    move-result v1
    if-gtz v1, :L1
  .line 286
    invoke-virtual { v3 }, Ljava/io/FileOutputStream;->close()V
  .line 287
    invoke-virtual { v4 }, Ljava/io/InputStream;->close()V
  .line 288
    return-void
  :L1
  .line 285
    const/4 v5, 0
    invoke-virtual { v3, v0, v5, v1 }, Ljava/io/FileOutputStream;->write([BII)V
    goto :L0
.end method

.method public static setPaymentInfo(Lcom/uc/paymentsdk/payment/PaymentInfo;)V
  .parameter "paramPaymentInfo" # Lcom/uc/paymentsdk/payment/PaymentInfo;
  .registers 1
  .prologue
  .line 269
    sput-object p0, Lcom/uc/paymentsdk/util/Utils;->sPaymentInfo:Lcom/uc/paymentsdk/payment/PaymentInfo;
  .line 270
    return-void
.end method

.method public static setSmsInfo(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
  .parameter "paramSmsInfos" # Lcom/uc/paymentsdk/payment/sms/SmsInfos;
  .registers 1
  .prologue
  .line 462
    sput-object p0, Lcom/uc/paymentsdk/util/Utils;->sSmsInfos:Lcom/uc/paymentsdk/payment/sms/SmsInfos;
  .line 463
    return-void
.end method

.method public static setUPointInfo(Lcom/uc/paymentsdk/payment/upoint/UPointInfo;)V
  .parameter "sUPointInfo" # Lcom/uc/paymentsdk/payment/upoint/UPointInfo;
  .registers 1
  .prologue
  .line 470
    sput-object p0, Lcom/uc/paymentsdk/util/Utils;->sUPointInfo:Lcom/uc/paymentsdk/payment/upoint/UPointInfo;
  .line 471
    return-void
.end method

.method public static setUPointPayInfo(Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;)V
  .parameter "UPointPayInfo" # Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;
  .registers 1
  .prologue
  .line 488
    sput-object p0, Lcom/uc/paymentsdk/util/Utils;->sUPointPayInfo:Lcom/uc/paymentsdk/payment/upoint/UPointPayInfo;
  .line 489
    return-void
.end method

.method public static writeSmsInfoPayment(Landroid/content/Context;Ljava/lang/String;)V
  .parameter "paramContext" # Landroid/content/Context;
  .parameter "paramString" # Ljava/lang/String;
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L2
  .registers 8
  :L0
  .prologue
  .line 512
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-static { }, Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    invoke-static { v4, v5 }, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v4
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
  .line 513
  .local v2, "str":Ljava/lang/String;
    new-instance v0, Ljava/io/BufferedWriter;
  .line 514
    new-instance v3, Ljava/io/FileWriter;
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-virtual { p0 }, Landroid/content/Context;->getFilesDir()Ljava/io/File;
    move-result-object v5
    invoke-virtual { v5 }, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;
    move-result-object v5
    invoke-static { v5 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    invoke-direct { v4, v5 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
  .line 515
    const-string v5, "/"
    invoke-virtual { v4, v5 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual { v4, v2 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v5, ".smspayment"
    invoke-virtual { v4, v5 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual { v4 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
  .line 514
    invoke-direct { v3, v4 }, Ljava/io/FileWriter;-><init>(Ljava/lang/String;)V
  .line 513
    invoke-direct { v0, v3 }, Ljava/io/BufferedWriter;-><init>(Ljava/io/Writer;)V
  .line 516
  .local v0, "localBufferedWriter":Ljava/io/BufferedWriter;
    invoke-virtual { p1 }, Ljava/lang/String;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v0, v3 }, Ljava/io/BufferedWriter;->write(Ljava/lang/String;)V
  .line 517
    invoke-virtual { v0 }, Ljava/io/BufferedWriter;->flush()V
  .line 518
    invoke-virtual { v0 }, Ljava/io/BufferedWriter;->close()V
  :L1
  .line 522
  .end local v0
  .end local v2
    return-void
  :L2
  .line 519
    move-exception v3
    move-object v1, v3
  .line 520
  .local v1, "localException":Ljava/lang/Exception;
    invoke-virtual { v1 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L1
.end method
