.class public Lcom/uc/paymentsdk/commons/codec/Hex;
.super Ljava/lang/Object;
.implements Lcom/uc/paymentsdk/commons/codec/BinaryEncoder;
.implements Lcom/uc/paymentsdk/commons/codec/BinaryDecoder;
.source "Hex.java"

.field private final static DIGITS:[C

.method static constructor <clinit>()V
  .registers 1
  .prologue
  .line 6
    const/16 v0, 16
    new-array v0, v0, [C
    fill-array-data v0, :L0
    sput-object v0, Lcom/uc/paymentsdk/commons/codec/Hex;->DIGITS:[C
  .line 3
    return-void
  .line 6
  :L0
  .array-data 2
    48t 0t
    49t 0t
    50t 0t
    51t 0t
    52t 0t
    53t 0t
    54t 0t
    55t 0t
    56t 0t
    57t 0t
    97t 0t
    98t 0t
    99t 0t
    100t 0t
    101t 0t
    102t 0t
  .end array-data
.end method

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 3
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static decodeHex([C)[B
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lcom/uc/paymentsdk/commons/codec/DecoderException;
    }
  .end annotation
  .parameter "paramArrayOfChar" # [C
  .registers 8
  .prologue
  .line 11
    array-length v1, p0
  .line 12
  .local v1, "i":I
    and-int/lit8 v5, v1, 1
    if-eqz v5, :L0
  .line 13
    new-instance v5, Lcom/uc/paymentsdk/commons/codec/DecoderException;
    const-string v6, "Odd number of characters."
    invoke-direct { v5, v6 }, Lcom/uc/paymentsdk/commons/codec/DecoderException;-><init>(Ljava/lang/String;)V
    throw v5
  :L0
  .line 14
    shr-int/lit8 v5, v1, 1
    new-array v0, v5, [B
  .line 15
  .local v0, "arrayOfByte":[B
    const/4 v2, 0
  .line 16
  .local v2, "j":I
    const/4 v3, 0
  :L1
  .line 17
  .local v3, "k":I
    if-lt v3, v1, :L2
  .line 26
    return-object v0
  :L2
  .line 19
    aget-char v5, p0, v3
    invoke-static { v5, v3 }, Lcom/uc/paymentsdk/commons/codec/Hex;->toDigit(CI)I
    move-result v5
    shl-int/lit8 v4, v5, 4
  .line 20
  .local v4, "m":I
    add-int/lit8 v3, v3, 1
  .line 21
    aget-char v5, p0, v3
    invoke-static { v5, v3 }, Lcom/uc/paymentsdk/commons/codec/Hex;->toDigit(CI)I
    move-result v5
    or-int/2addr v4, v5
  .line 22
    add-int/lit8 v3, v3, 1
  .line 23
    and-int/lit16 v5, v4, 255
    int-to-byte v5, v5
    aput-byte v5, v0, v2
  .line 24
    add-int/lit8 v2, v2, 1
    goto :L1
.end method

.method public static encodeHex([B)[C
  .parameter "paramArrayOfByte" # [B
  .registers 8
  .prologue
  .line 40
    array-length v1, p0
  .line 41
  .local v1, "i":I
    shl-int/lit8 v5, v1, 1
    new-array v0, v5, [C
  .line 42
  .local v0, "arrayOfChar":[C
    const/4 v2, 0
  .line 43
  .local v2, "j":I
    const/4 v3, 0
  .local v3, "k":I
    move v4, v3
  :L0
  .line 44
  .end local v3
  .local v4, "k":I
    if-lt v2, v1, :L1
  .line 50
    return-object v0
  :L1
  .line 46
    add-int/lit8 v3, v4, 1
  .end local v4
  .restart local v3
    sget-object v5, Lcom/uc/paymentsdk/commons/codec/Hex;->DIGITS:[C
    aget-byte v6, p0, v2
    and-int/lit16 v6, v6, 240
    ushr-int/lit8 v6, v6, 4
    aget-char v5, v5, v6
    aput-char v5, v0, v4
  .line 47
    add-int/lit8 v4, v3, 1
  .end local v3
  .restart local v4
    sget-object v5, Lcom/uc/paymentsdk/commons/codec/Hex;->DIGITS:[C
    aget-byte v6, p0, v2
    and-int/lit8 v6, v6, 15
    aget-char v5, v5, v6
    aput-char v5, v0, v3
  .line 48
    add-int/lit8 v2, v2, 1
    goto :L0
.end method

.method protected static toDigit(CI)I
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lcom/uc/paymentsdk/commons/codec/DecoderException;
    }
  .end annotation
  .parameter "paramChar" # C
  .parameter "paramInt" # I
  .registers 6
  .prologue
  .line 32
    const/16 v1, 16
    invoke-static { p0, v1 }, Ljava/lang/Character;->digit(CI)I
    move-result v0
  .line 33
  .local v0, "i":I
    const/4 v1, -1
    if-ne v0, v1, :L0
  .line 34
    new-instance v1, Lcom/uc/paymentsdk/commons/codec/DecoderException;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Illegal hexadecimal charcter "
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v2, p0 }, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, " at index "
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct { v1, v2 }, Lcom/uc/paymentsdk/commons/codec/DecoderException;-><init>(Ljava/lang/String;)V
    throw v1
  :L0
  .line 35
    return v0
.end method

.method public decode(Ljava/lang/Object;)Ljava/lang/Object;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lcom/uc/paymentsdk/commons/codec/DecoderException;
    }
  .end annotation
  .parameter "paramObject" # Ljava/lang/Object;
  .catch Ljava/lang/ClassCastException; { :L0 .. :L3 } :L4
  .registers 6
  :L0
  .prologue
  .line 66
    instance-of v2, p1, Ljava/lang/String;
    if-eqz v2, :L2
    check-cast p1, Ljava/lang/String;
  .end local p1
    invoke-virtual { p1 }, Ljava/lang/String;->toCharArray()[C
    move-result-object v2
    move-object v0, v2
  :L1
  .line 67
  .local v0, "arrayOfChar":[C
    invoke-static { v0 }, Lcom/uc/paymentsdk/commons/codec/Hex;->decodeHex([C)[B
    move-result-object v2
    return-object v2
  :L2
  .line 66
  .end local v0
  .restart local p1
    check-cast p1, [C
  :L3
    move-object v0, p1
    goto :L1
  :L4
  .line 69
  .end local p1
    move-exception v2
    move-object v1, v2
  .line 71
  .local v1, "localClassCastException":Ljava/lang/ClassCastException;
    new-instance v2, Lcom/uc/paymentsdk/commons/codec/DecoderException;
    invoke-virtual { v1 }, Ljava/lang/ClassCastException;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-direct { v2, v3 }, Lcom/uc/paymentsdk/commons/codec/DecoderException;-><init>(Ljava/lang/String;)V
    throw v2
.end method

.method public decode([B)[B
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lcom/uc/paymentsdk/commons/codec/DecoderException;
    }
  .end annotation
  .parameter "paramArrayOfByte" # [B
  .registers 3
  .prologue
  .line 57
    new-instance v0, Ljava/lang/String;
    invoke-direct { v0, p1 }, Ljava/lang/String;-><init>([B)V
    invoke-virtual { v0 }, Ljava/lang/String;->toCharArray()[C
    move-result-object v0
    invoke-static { v0 }, Lcom/uc/paymentsdk/commons/codec/Hex;->decodeHex([C)[B
    move-result-object v0
    return-object v0
.end method

.method public encode(Ljava/lang/Object;)Ljava/lang/Object;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lcom/uc/paymentsdk/commons/codec/EncoderException;
    }
  .end annotation
  .parameter "paramObject" # Ljava/lang/Object;
  .catch Ljava/lang/ClassCastException; { :L0 .. :L3 } :L4
  .registers 6
  :L0
  .prologue
  .line 88
    instance-of v2, p1, Ljava/lang/String;
    if-eqz v2, :L2
    check-cast p1, Ljava/lang/String;
  .end local p1
    invoke-virtual { p1 }, Ljava/lang/String;->getBytes()[B
    move-result-object v2
    move-object v0, v2
  :L1
  .line 89
  .local v0, "arrayOfByte":[B
    invoke-static { v0 }, Lcom/uc/paymentsdk/commons/codec/Hex;->encodeHex([B)[C
    move-result-object v2
    return-object v2
  :L2
  .line 88
  .end local v0
  .restart local p1
    check-cast p1, [B
  :L3
    move-object v0, p1
    goto :L1
  :L4
  .line 91
  .end local p1
    move-exception v2
    move-object v1, v2
  .line 93
  .local v1, "localClassCastException":Ljava/lang/ClassCastException;
    new-instance v2, Lcom/uc/paymentsdk/commons/codec/EncoderException;
    invoke-virtual { v1 }, Ljava/lang/ClassCastException;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-direct { v2, v3 }, Lcom/uc/paymentsdk/commons/codec/EncoderException;-><init>(Ljava/lang/String;)V
    throw v2
.end method

.method public encode([B)[B
  .parameter "paramArrayOfByte" # [B
  .registers 4
  .prologue
  .line 79
    new-instance v0, Ljava/lang/String;
    invoke-static { p1 }, Lcom/uc/paymentsdk/commons/codec/Hex;->encodeHex([B)[C
    move-result-object v1
    invoke-direct { v0, v1 }, Ljava/lang/String;-><init>([C)V
    invoke-virtual { v0 }, Ljava/lang/String;->getBytes()[B
    move-result-object v0
    return-object v0
.end method
