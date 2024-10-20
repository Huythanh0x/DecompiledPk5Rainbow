.class public Lcom/uc/paymentsdk/commons/codec/Hex;
.super Ljava/lang/Object;
.source "Hex.java"

# interfaces
.implements Lcom/uc/paymentsdk/commons/codec/BinaryEncoder;
.implements Lcom/uc/paymentsdk/commons/codec/BinaryDecoder;


# static fields
.field private static final DIGITS:[C


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 6
    const/16 v0, 0x10

    new-array v0, v0, [C

    fill-array-data v0, :array_0

    sput-object v0, Lcom/uc/paymentsdk/commons/codec/Hex;->DIGITS:[C

    .line 3
    return-void

    .line 6
    :array_0
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static decodeHex([C)[B
    .locals 7
    .param p0, "paramArrayOfChar"    # [C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/uc/paymentsdk/commons/codec/DecoderException;
        }
    .end annotation

    .prologue
    .line 11
    array-length v1, p0

    .line 12
    .local v1, "i":I
    and-int/lit8 v5, v1, 0x1

    if-eqz v5, :cond_0

    .line 13
    new-instance v5, Lcom/uc/paymentsdk/commons/codec/DecoderException;

    const-string v6, "Odd number of characters."

    invoke-direct {v5, v6}, Lcom/uc/paymentsdk/commons/codec/DecoderException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 14
    :cond_0
    shr-int/lit8 v5, v1, 0x1

    new-array v0, v5, [B

    .line 15
    .local v0, "arrayOfByte":[B
    const/4 v2, 0x0

    .line 16
    .local v2, "j":I
    const/4 v3, 0x0

    .line 17
    .local v3, "k":I
    :goto_0
    if-lt v3, v1, :cond_1

    .line 26
    return-object v0

    .line 19
    :cond_1
    aget-char v5, p0, v3

    invoke-static {v5, v3}, Lcom/uc/paymentsdk/commons/codec/Hex;->toDigit(CI)I

    move-result v5

    shl-int/lit8 v4, v5, 0x4

    .line 20
    .local v4, "m":I
    add-int/lit8 v3, v3, 0x1

    .line 21
    aget-char v5, p0, v3

    invoke-static {v5, v3}, Lcom/uc/paymentsdk/commons/codec/Hex;->toDigit(CI)I

    move-result v5

    or-int/2addr v4, v5

    .line 22
    add-int/lit8 v3, v3, 0x1

    .line 23
    and-int/lit16 v5, v4, 0xff

    int-to-byte v5, v5

    aput-byte v5, v0, v2

    .line 24
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public static encodeHex([B)[C
    .locals 7
    .param p0, "paramArrayOfByte"    # [B

    .prologue
    .line 40
    array-length v1, p0

    .line 41
    .local v1, "i":I
    shl-int/lit8 v5, v1, 0x1

    new-array v0, v5, [C

    .line 42
    .local v0, "arrayOfChar":[C
    const/4 v2, 0x0

    .line 43
    .local v2, "j":I
    const/4 v3, 0x0

    .local v3, "k":I
    move v4, v3

    .line 44
    .end local v3    # "k":I
    .local v4, "k":I
    :goto_0
    if-lt v2, v1, :cond_0

    .line 50
    return-object v0

    .line 46
    :cond_0
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "k":I
    .restart local v3    # "k":I
    sget-object v5, Lcom/uc/paymentsdk/commons/codec/Hex;->DIGITS:[C

    aget-byte v6, p0, v2

    and-int/lit16 v6, v6, 0xf0

    ushr-int/lit8 v6, v6, 0x4

    aget-char v5, v5, v6

    aput-char v5, v0, v4

    .line 47
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "k":I
    .restart local v4    # "k":I
    sget-object v5, Lcom/uc/paymentsdk/commons/codec/Hex;->DIGITS:[C

    aget-byte v6, p0, v2

    and-int/lit8 v6, v6, 0xf

    aget-char v5, v5, v6

    aput-char v5, v0, v3

    .line 48
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method protected static toDigit(CI)I
    .locals 4
    .param p0, "paramChar"    # C
    .param p1, "paramInt"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/uc/paymentsdk/commons/codec/DecoderException;
        }
    .end annotation

    .prologue
    .line 32
    const/16 v1, 0x10

    invoke-static {p0, v1}, Ljava/lang/Character;->digit(CI)I

    move-result v0

    .line 33
    .local v0, "i":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 34
    new-instance v1, Lcom/uc/paymentsdk/commons/codec/DecoderException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Illegal hexadecimal charcter "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " at index "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/uc/paymentsdk/commons/codec/DecoderException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 35
    :cond_0
    return v0
.end method


# virtual methods
.method public decode(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "paramObject"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/uc/paymentsdk/commons/codec/DecoderException;
        }
    .end annotation

    .prologue
    .line 66
    :try_start_0
    instance-of v2, p1, Ljava/lang/String;

    if-eqz v2, :cond_0

    check-cast p1, Ljava/lang/String;

    .end local p1    # "paramObject":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/String;->toCharArray()[C

    move-result-object v2

    move-object v0, v2

    .line 67
    .local v0, "arrayOfChar":[C
    :goto_0
    invoke-static {v0}, Lcom/uc/paymentsdk/commons/codec/Hex;->decodeHex([C)[B

    move-result-object v2

    return-object v2

    .line 66
    .end local v0    # "arrayOfChar":[C
    .restart local p1    # "paramObject":Ljava/lang/Object;
    :cond_0
    check-cast p1, [C
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, p1

    goto :goto_0

    .line 69
    .end local p1    # "paramObject":Ljava/lang/Object;
    :catch_0
    move-exception v2

    move-object v1, v2

    .line 71
    .local v1, "localClassCastException":Ljava/lang/ClassCastException;
    new-instance v2, Lcom/uc/paymentsdk/commons/codec/DecoderException;

    invoke-virtual {v1}, Ljava/lang/ClassCastException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/uc/paymentsdk/commons/codec/DecoderException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public decode([B)[B
    .locals 1
    .param p1, "paramArrayOfByte"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/uc/paymentsdk/commons/codec/DecoderException;
        }
    .end annotation

    .prologue
    .line 57
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p1}, Ljava/lang/String;-><init>([B)V

    invoke-virtual {v0}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    invoke-static {v0}, Lcom/uc/paymentsdk/commons/codec/Hex;->decodeHex([C)[B

    move-result-object v0

    return-object v0
.end method

.method public encode(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "paramObject"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/uc/paymentsdk/commons/codec/EncoderException;
        }
    .end annotation

    .prologue
    .line 88
    :try_start_0
    instance-of v2, p1, Ljava/lang/String;

    if-eqz v2, :cond_0

    check-cast p1, Ljava/lang/String;

    .end local p1    # "paramObject":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    move-object v0, v2

    .line 89
    .local v0, "arrayOfByte":[B
    :goto_0
    invoke-static {v0}, Lcom/uc/paymentsdk/commons/codec/Hex;->encodeHex([B)[C

    move-result-object v2

    return-object v2

    .line 88
    .end local v0    # "arrayOfByte":[B
    .restart local p1    # "paramObject":Ljava/lang/Object;
    :cond_0
    check-cast p1, [B
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, p1

    goto :goto_0

    .line 91
    .end local p1    # "paramObject":Ljava/lang/Object;
    :catch_0
    move-exception v2

    move-object v1, v2

    .line 93
    .local v1, "localClassCastException":Ljava/lang/ClassCastException;
    new-instance v2, Lcom/uc/paymentsdk/commons/codec/EncoderException;

    invoke-virtual {v1}, Ljava/lang/ClassCastException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/uc/paymentsdk/commons/codec/EncoderException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public encode([B)[B
    .locals 2
    .param p1, "paramArrayOfByte"    # [B

    .prologue
    .line 79
    new-instance v0, Ljava/lang/String;

    invoke-static {p1}, Lcom/uc/paymentsdk/commons/codec/Hex;->encodeHex([B)[C

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>([C)V

    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    return-object v0
.end method
