.class public Lcom/uc/paymentsdk/util/SecurityUtil;
.super Ljava/lang/Object;
.source "SecurityUtil.java"

.field public final static KEY_HTTP_CHARGE_ALIPAY_AND_G:Ljava/lang/String; = "6R4ya0Nee7aLgl4k"

.field private final static SECRET_KEY_HTTP:[B

.field private final static SECRET_KEY_HTTP_CHARGE:[B

.field public final static SECRET_KEY_HTTP_CHARGE_ALIPAY:[B

.method static constructor <clinit>()V
  .registers 1
  .prologue
  .line 8
    const-string v0, "sdk_mappn_201008"
    invoke-virtual { v0 }, Ljava/lang/String;->getBytes()[B
    move-result-object v0
    sput-object v0, Lcom/uc/paymentsdk/util/SecurityUtil;->SECRET_KEY_HTTP:[B
  .line 9
    const-string v0, "MAPPN-ANDY-XIAN-"
    invoke-virtual { v0 }, Ljava/lang/String;->getBytes()[B
    move-result-object v0
    sput-object v0, Lcom/uc/paymentsdk/util/SecurityUtil;->SECRET_KEY_HTTP_CHARGE:[B
  .line 10
    const-string v0, "6R4ya0Nee7aLgl4k"
    invoke-virtual { v0 }, Ljava/lang/String;->getBytes()[B
    move-result-object v0
    sput-object v0, Lcom/uc/paymentsdk/util/SecurityUtil;->SECRET_KEY_HTTP_CHARGE_ALIPAY:[B
  .line 6
    return-void
.end method

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 6
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static decryptHttpChargeAlipayBody([B)Ljava/lang/String;
  .parameter "paramArrayOfByte" # [B
  .registers 4
  .prologue
  .line 30
    new-instance v0, Lcom/uc/paymentsdk/commons/codec/Crypter;
    invoke-direct { v0 }, Lcom/uc/paymentsdk/commons/codec/Crypter;-><init>()V
    invoke-static { p0 }, Lcom/uc/paymentsdk/commons/codec/Base64;->decodeBase64([B)[B
    move-result-object v1
    sget-object v2, Lcom/uc/paymentsdk/util/SecurityUtil;->SECRET_KEY_HTTP_CHARGE_ALIPAY:[B
    invoke-virtual { v0, v1, v2 }, Lcom/uc/paymentsdk/commons/codec/Crypter;->decrypt([B[B)[B
    move-result-object v0
    invoke-static { v0 }, Lcom/uc/paymentsdk/util/Utils;->getUTF8String([B)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static encryptHttpBody(Ljava/lang/String;)[B
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 15
    new-instance v0, Lcom/uc/paymentsdk/commons/codec/Crypter;
    invoke-direct { v0 }, Lcom/uc/paymentsdk/commons/codec/Crypter;-><init>()V
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/Utils;->getUTF8Bytes(Ljava/lang/String;)[B
    move-result-object v1
    sget-object v2, Lcom/uc/paymentsdk/util/SecurityUtil;->SECRET_KEY_HTTP:[B
    invoke-virtual { v0, v1, v2 }, Lcom/uc/paymentsdk/commons/codec/Crypter;->encrypt([B[B)[B
    move-result-object v0
    invoke-static { v0 }, Lcom/uc/paymentsdk/commons/codec/Base64;->encodeBase64([B)[B
    move-result-object v0
    return-object v0
.end method

.method public static encryptHttpChargeAlipayBody(Ljava/lang/String;)[B
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 25
    new-instance v0, Lcom/uc/paymentsdk/commons/codec/Crypter;
    invoke-direct { v0 }, Lcom/uc/paymentsdk/commons/codec/Crypter;-><init>()V
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/Utils;->getUTF8Bytes(Ljava/lang/String;)[B
    move-result-object v1
    sget-object v2, Lcom/uc/paymentsdk/util/SecurityUtil;->SECRET_KEY_HTTP_CHARGE_ALIPAY:[B
    invoke-virtual { v0, v1, v2 }, Lcom/uc/paymentsdk/commons/codec/Crypter;->encrypt([B[B)[B
    move-result-object v0
    invoke-static { v0 }, Lcom/uc/paymentsdk/commons/codec/Base64;->encodeBase64([B)[B
    move-result-object v0
    return-object v0
.end method

.method public static encryptHttpChargePhoneCardBody(Ljava/lang/String;)[B
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 20
    new-instance v0, Lcom/uc/paymentsdk/commons/codec/Crypter;
    invoke-direct { v0 }, Lcom/uc/paymentsdk/commons/codec/Crypter;-><init>()V
    invoke-static { p0 }, Lcom/uc/paymentsdk/util/Utils;->getUTF8Bytes(Ljava/lang/String;)[B
    move-result-object v1
    sget-object v2, Lcom/uc/paymentsdk/util/SecurityUtil;->SECRET_KEY_HTTP_CHARGE:[B
    invoke-virtual { v0, v1, v2 }, Lcom/uc/paymentsdk/commons/codec/Crypter;->encrypt([B[B)[B
    move-result-object v0
    return-object v0
.end method
