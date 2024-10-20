.class public Lcom/uc/paymentsdk/commons/codec/Base64;
.super Ljava/lang/Object;
.implements Lcom/uc/paymentsdk/commons/codec/BinaryEncoder;
.implements Lcom/uc/paymentsdk/commons/codec/BinaryDecoder;
.source "Base64.java"

.field final static BASELENGTH:I = 255

.field final static CHUNK_SEPARATOR:[B

.field final static CHUNK_SIZE:I = 76

.field final static EIGHTBIT:I = 8

.field final static FOURBYTE:I = 4

.field final static LOOKUPLENGTH:I = 64

.field final static PAD:B = 61t

.field final static SIGN:I = -128

.field final static SIXTEENBIT:I = 16

.field final static TWENTYFOURBITGROUP:I = 24

.field private static base64Alphabet:[B

.field private static lookUpBase64Alphabet:[B

.method static constructor <clinit>()V
  .registers 10
  .prologue
    const/16 v9, 63
    const/16 v8, 62
    const/16 v7, 48
    const/16 v6, 47
    const/16 v5, 43
  .line 7
    const-string v3, "\r\n"
    invoke-virtual { v3 }, Ljava/lang/String;->getBytes()[B
    move-result-object v3
    sput-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
  .line 16
    const/16 v3, 255
    new-array v3, v3, [B
    sput-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
  .line 17
    const/16 v3, 64
    new-array v3, v3, [B
    sput-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
  .line 250
    const/4 v0, 0
  :L0
  .local v0, "i":I
    const/16 v3, 255
    if-lt v0, v3, :L7
  .line 252
    const/16 v0, 90
  :L1
    const/16 v3, 65
    if-ge v0, v3, :L8
  .line 254
    const/16 v0, 122
  :L2
    const/16 v3, 97
    if-ge v0, v3, :L9
  .line 256
    const/16 v0, 57
  :L3
    if-ge v0, v7, :L10
  .line 258
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    aput-byte v8, v3, v5
  .line 259
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    aput-byte v9, v3, v6
  .line 260
    const/4 v0, 0
  :L4
    const/16 v3, 25
    if-le v0, v3, :L11
  .line 262
    const/16 v1, 26
  .line 263
  .local v1, "icount":I
    const/4 v2, 0
  :L5
  .local v2, "j":I
    const/16 v3, 51
    if-le v1, v3, :L12
  .line 268
    const/16 v1, 52
  .line 269
    const/4 v2, 0
  :L6
    const/16 v3, 61
    if-le v1, v3, :L13
  .line 274
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    aput-byte v5, v3, v8
  .line 275
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    aput-byte v6, v3, v9
  .line 3
    return-void
  :L7
  .line 251
  .end local v1
  .end local v2
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    const/4 v4, -1
    aput-byte v4, v3, v0
  .line 250
    add-int/lit8 v0, v0, 1
    goto :L0
  :L8
  .line 253
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    const/16 v4, 65
    sub-int v4, v0, v4
    int-to-byte v4, v4
    aput-byte v4, v3, v0
  .line 252
    add-int/lit8 v0, v0, -1
    goto :L1
  :L9
  .line 255
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    const/16 v4, 97
    sub-int v4, v0, v4
    add-int/lit8 v4, v4, 26
    int-to-byte v4, v4
    aput-byte v4, v3, v0
  .line 254
    add-int/lit8 v0, v0, -1
    goto :L2
  :L10
  .line 257
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    sub-int v4, v0, v7
    add-int/lit8 v4, v4, 52
    int-to-byte v4, v4
    aput-byte v4, v3, v0
  .line 256
    add-int/lit8 v0, v0, -1
    goto :L3
  :L11
  .line 261
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    add-int/lit8 v4, v0, 65
    int-to-byte v4, v4
    aput-byte v4, v3, v0
  .line 260
    add-int/lit8 v0, v0, 1
    goto :L4
  :L12
  .line 265
  .restart local v1
  .restart local v2
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    add-int/lit8 v4, v2, 97
    int-to-byte v4, v4
    aput-byte v4, v3, v1
  .line 266
    add-int/lit8 v1, v1, 1
  .line 263
    add-int/lit8 v2, v2, 1
    goto :L5
  :L13
  .line 271
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    add-int/lit8 v4, v2, 48
    int-to-byte v4, v4
    aput-byte v4, v3, v1
  .line 272
    add-int/lit8 v1, v1, 1
  .line 269
    add-int/lit8 v2, v2, 1
    goto :L6
.end method

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 3
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static decodeBase64([B)[B
  .parameter "paramArrayOfByte" # [B
  .registers 16
  .prologue
    const/4 v12, 0
    const/16 v14, 61
  .line 147
    invoke-static { p0 }, Lcom/uc/paymentsdk/commons/codec/Base64;->discardNonBase64([B)[B
    move-result-object p0
  .line 148
    array-length v11, p0
    if-nez v11, :L1
  .line 149
    new-array v11, v12, [B
  :L0
  .line 195
    return-object v11
  :L1
  .line 150
    array-length v11, p0
    div-int/lit8 v1, v11, 4
  .line 151
  .local v1, "i":I
    const/4 v0, 0
    check-cast v0, [B
  .line 152
  .local v0, "arrayOfByte":[B
    const/4 v7, 0
  .line 153
  .local v7, "j":I
    const/4 v8, 0
  .line 154
  .local v8, "k":I
    const/4 v9, 0
  .line 155
  .local v9, "m":I
    const/4 v10, 0
  .line 156
  .local v10, "n":I
    const/4 v2, 0
  .line 157
  .local v2, "i1":I
    const/4 v3, 0
  .line 158
  .local v3, "i2":I
    const/4 v4, 0
  .line 159
  .local v4, "i3":I
    const/4 v5, 0
  .line 160
  .local v5, "i4":I
    array-length v6, p0
  :L2
  .line 161
  .local v6, "i5":I
    const/4 v11, 1
    sub-int v11, v6, v11
    aget-byte v11, p0, v11
    if-eq v11, v14, :L4
  .line 167
    sub-int v11, v6, v1
    new-array v0, v11, [B
  .line 168
    const/4 v6, 0
  :L3
    if-lt v6, v1, :L5
    move-object v11, v0
  .line 195
    goto :L0
  :L4
  .line 163
    add-int/lit8 v6, v6, -1
  .line 164
    if-nez v6, :L2
  .line 165
    new-array v11, v12, [B
    goto :L0
  :L5
  .line 170
    mul-int/lit8 v5, v6, 4
  .line 171
    add-int/lit8 v11, v5, 2
    aget-byte v2, p0, v11
  .line 172
    add-int/lit8 v11, v5, 3
    aget-byte v3, p0, v11
  .line 173
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    aget-byte v12, p0, v5
    aget-byte v7, v11, v12
  .line 174
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    add-int/lit8 v12, v5, 1
    aget-byte v12, p0, v12
    aget-byte v8, v11, v12
  .line 175
    if-eq v2, v14, :L7
    if-eq v3, v14, :L7
  .line 177
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    aget-byte v9, v11, v2
  .line 178
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    aget-byte v10, v11, v3
  .line 179
    shl-int/lit8 v11, v7, 2
    shr-int/lit8 v12, v8, 4
    or-int/2addr v11, v12
    int-to-byte v11, v11
    aput-byte v11, v0, v4
  .line 180
    add-int/lit8 v11, v4, 1
    and-int/lit8 v12, v8, 15
    shl-int/lit8 v12, v12, 4
    shr-int/lit8 v13, v9, 2
    and-int/lit8 v13, v13, 15
    or-int/2addr v12, v13
    int-to-byte v12, v12
    aput-byte v12, v0, v11
  .line 181
    add-int/lit8 v11, v4, 2
    shl-int/lit8 v12, v9, 6
    or-int/2addr v12, v10
    int-to-byte v12, v12
    aput-byte v12, v0, v11
  :L6
  .line 193
    add-int/lit8 v4, v4, 3
  .line 168
    add-int/lit8 v6, v6, 1
    goto :L3
  :L7
  .line 183
    if-ne v2, v14, :L8
  .line 185
    shl-int/lit8 v11, v7, 2
    shr-int/lit8 v12, v8, 4
    or-int/2addr v11, v12
    int-to-byte v11, v11
    aput-byte v11, v0, v4
    goto :L6
  :L8
  .line 187
    if-ne v3, v14, :L6
  .line 189
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    aget-byte v9, v11, v2
  .line 190
    shl-int/lit8 v11, v7, 2
    shr-int/lit8 v12, v8, 4
    or-int/2addr v11, v12
    int-to-byte v11, v11
    aput-byte v11, v0, v4
  .line 191
    add-int/lit8 v11, v4, 1
    and-int/lit8 v12, v8, 15
    shl-int/lit8 v12, v12, 4
    shr-int/lit8 v13, v9, 2
    and-int/lit8 v13, v13, 15
    or-int/2addr v12, v13
    int-to-byte v12, v12
    aput-byte v12, v0, v11
    goto :L6
.end method

.method static discardNonBase64([B)[B
  .parameter "paramArrayOfByte" # [B
  .registers 8
  .prologue
    const/4 v6, 0
  .line 220
    array-length v5, p0
    new-array v0, v5, [B
  .line 221
  .local v0, "arrayOfByte1":[B
    const/4 v2, 0
  .line 222
  .local v2, "i":I
    const/4 v4, 0
  :L0
  .local v4, "j":I
    array-length v5, p0
    if-lt v4, v5, :L1
  .line 228
    new-array v1, v2, [B
  .line 229
  .local v1, "arrayOfByte2":[B
    invoke-static { v0, v6, v1, v6, v2 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  .line 230
    return-object v1
  :L1
  .line 224
  .end local v1
    aget-byte v5, p0, v4
    invoke-static { v5 }, Lcom/uc/paymentsdk/commons/codec/Base64;->isBase64(B)Z
    move-result v5
    if-nez v5, :L3
  :L2
  .line 222
    add-int/lit8 v4, v4, 1
    goto :L0
  :L3
  .line 226
    add-int/lit8 v3, v2, 1
  .end local v2
  .local v3, "i":I
    aget-byte v5, p0, v4
    aput-byte v5, v0, v2
    move v2, v3
  .end local v3
  .restart local v2
    goto :L2
.end method

.method static discardWhitespace([B)[B
  .parameter "paramArrayOfByte" # [B
  .registers 8
  .prologue
    const/4 v6, 0
  .line 200
    array-length v5, p0
    new-array v0, v5, [B
  .line 201
  .local v0, "arrayOfByte1":[B
    const/4 v2, 0
  .line 202
  .local v2, "i":I
    const/4 v4, 0
  :L0
  .local v4, "j":I
    array-length v5, p0
    if-lt v4, v5, :L1
  .line 213
    new-array v1, v2, [B
  .line 214
  .local v1, "arrayOfByte2":[B
    invoke-static { v0, v6, v1, v6, v2 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  .line 215
    return-object v1
  :L1
  .line 203
  .end local v1
    aget-byte v5, p0, v4
    sparse-switch v5, :L3
  .line 211
    add-int/lit8 v3, v2, 1
  .end local v2
  .local v3, "i":I
    aget-byte v5, p0, v4
    aput-byte v5, v0, v2
    move v2, v3
  :L2
  .line 202
  .end local v3
  .restart local v2
    add-int/lit8 v4, v4, 1
    goto :L0
  .line 203
  :L3
  .sparse-switch
    9 -> :L2
    10 -> :L2
    13 -> :L2
    32 -> :L2
  .end sparse-switch
.end method

.method public static encodeBase64([B)[B
  .parameter "paramArrayOfByte" # [B
  .registers 2
  .prologue
  .line 40
    const/4 v0, 0
    invoke-static { p0, v0 }, Lcom/uc/paymentsdk/commons/codec/Base64;->encodeBase64([BZ)[B
    move-result-object v0
    return-object v0
.end method

.method public static encodeBase64([BZ)[B
  .parameter "paramArrayOfByte" # [B
  .parameter "paramBoolean" # Z
  .registers 27
  .prologue
  .line 65
    move-object/from16 v0, p0
    array-length v0, v0
    move v5, v0
    mul-int/lit8 v5, v5, 8
  .line 66
  .local v5, "i":I
    rem-int/lit8 v19, v5, 24
  .line 67
  .local v19, "j":I
    div-int/lit8 v20, v5, 24
  .line 68
  .local v20, "k":I
    const/4 v5, 0
    check-cast v5, [B
  .line 69
  .local v5, "arrayOfByte":[B
    const/4 v5, 0
  .line 70
  .local v5, "m":I
    const/4 v6, 0
  .line 71
  .local v6, "n":I
    if-eqz v19, :L7
  .line 72
    add-int/lit8 v5, v20, 1
    mul-int/lit8 v5, v5, 4
  :L0
  .line 75
    if-eqz p1, :L26
  .line 77
    sget-object v6, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
  .end local v6
    array-length v6, v6
    if-nez v6, :L8
    const/4 v6, 0
  :L1
  .line 78
  .restart local v6
    sget-object v7, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
    array-length v7, v7
    mul-int/2addr v7, v6
    add-int/2addr v5, v7
    move/from16 v22, v6
  .end local v6
  .local v22, "n":I
    move/from16 v21, v5
  :L2
  .line 80
  .end local v5
  .local v21, "m":I
    move/from16 v0, v21
    new-array v0, v0, [B
    move-object v5, v0
  .line 81
  .local v5, "arrayOfByte":[B
    const/4 v6, 0
  .line 82
  .local v6, "i1":I
    const/4 v8, 0
  .line 83
  .local v8, "i2":I
    const/4 v9, 0
  .line 84
  .local v9, "i3":I
    const/4 v10, 0
  .line 85
  .local v10, "i4":I
    const/4 v11, 0
  .line 86
  .local v11, "i5":I
    const/4 v12, 0
  .line 87
  .local v12, "i6":I
    const/4 v13, 0
  .line 88
  .local v13, "i7":I
    const/4 v7, 0
  .line 89
  .local v7, "i8":I
    const/16 v15, 76
  .line 90
  .local v15, "i9":I
    const/4 v7, 0
  .line 93
  .local v7, "i10":I
    const/4 v14, 0
  .local v14, "i8":I
    move/from16 v18, v15
  .end local v15
  .local v18, "i9":I
    move/from16 v17, v14
  .end local v14
  .local v17, "i8":I
    move v15, v12
  .end local v12
  .local v15, "i6":I
    move v12, v13
  :L3
  .end local v13
  .local v12, "i7":I
    move/from16 v0, v17
    move/from16 v1, v20
    if-lt v0, v1, :L9
  .line 116
    mul-int/lit8 v11, v17, 3
  .line 117
  .end local v12
  .local v11, "i7":I
    const/16 v12, 8
    move/from16 v0, v19
    move v1, v12
    if-ne v0, v1, :L19
  .line 119
    aget-byte v9, p0, v11
  .line 120
    and-int/lit8 p0, v9, 3
    move/from16 v0, p0
    int-to-byte v0, v0
    move/from16 p0, v0
  .line 121
  .end local v6
  .local p0, "i1":I
    and-int/lit8 v6, v9, -128
    if-nez v6, :L18
    shr-int/lit8 v6, v9, 2
    int-to-byte v6, v6
  :L4
  .line 122
  .local v6, "i11":I
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
  .end local v11
    aget-byte v6, v11, v6
  .end local v6
    aput-byte v6, v5, v15
  .line 123
    add-int/lit8 v6, v15, 1
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    shl-int/lit8 v12, p0, 4
    aget-byte v11, v11, v12
    aput-byte v11, v5, v6
  .line 124
    add-int/lit8 v6, v15, 2
    const/16 v11, 61
    aput-byte v11, v5, v6
  .line 125
    add-int/lit8 v6, v15, 3
    const/16 v11, 61
    aput-byte v11, v5, v6
    move v6, v8
  .end local v8
  .local v6, "i2":I
    move v8, v9
  .end local v9
  .local v8, "i3":I
    move v9, v10
  :L5
  .line 140
  .end local v10
  .local v9, "i4":I
    if-eqz p1, :L6
    move v0, v7
    move/from16 v1, v22
    if-ge v0, v1, :L6
  .line 141
    sget-object p0, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
  .end local p0
    const/16 p1, 0
    sget-object v6, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
  .end local v6
  .end local p1
    array-length v6, v6
    sub-int v6, v21, v6
    sget-object v7, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
  .end local v7
    array-length v7, v7
    move-object/from16 v0, p0
    move/from16 v1, p1
    move-object v2, v5
    move v3, v6
    move v4, v7
    invoke-static { v0, v1, v2, v3, v4 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  :L6
  .line 142
    return-object v5
  :L7
  .line 74
  .end local v8
  .end local v9
  .end local v15
  .end local v17
  .end local v18
  .end local v21
  .end local v22
  .local v5, "m":I
  .local v6, "n":I
  .local p0, "paramArrayOfByte":[B
  .restart local p1
    mul-int/lit8 v5, v20, 4
    goto/16 :L0
  :L8
  .line 77
  .end local v6
    int-to-float v6, v5
    const/high16 v7, 17048
    div-float/2addr v6, v7
    float-to-double v6, v6
    invoke-static { v6, v7 }, Ljava/lang/Math;->ceil(D)D
    move-result-wide v6
    double-to-int v6, v6
    goto/16 :L1
  :L9
  .line 95
  .local v5, "arrayOfByte":[B
  .local v6, "i1":I
  .restart local v7
  .local v8, "i2":I
  .local v9, "i3":I
  .restart local v10
  .local v11, "i5":I
  .restart local v12
  .restart local v15
  .restart local v17
  .restart local v18
  .restart local v21
  .restart local v22
    mul-int/lit8 v16, v17, 3
  .line 96
  .end local v12
  .local v16, "i7":I
    aget-byte v12, p0, v16
  .line 97
  .end local v9
  .local v12, "i3":I
    add-int/lit8 v6, v16, 1
    aget-byte v13, p0, v6
  .line 98
  .end local v6
  .end local v10
  .local v13, "i4":I
    add-int/lit8 v6, v16, 2
    aget-byte v14, p0, v6
  .line 99
  .end local v11
  .local v14, "i5":I
    and-int/lit8 v6, v13, 15
    int-to-byte v11, v6
  .line 100
  .end local v8
  .local v11, "i2":I
    and-int/lit8 v6, v12, 3
    int-to-byte v6, v6
  .line 101
  .restart local v6
    and-int/lit8 v8, v12, -128
    if-nez v8, :L14
    shr-int/lit8 v8, v12, 2
    int-to-byte v8, v8
  :L10
  .line 102
  .local v8, "i11":I
    and-int/lit8 v9, v13, -128
    if-nez v9, :L15
    shr-int/lit8 v9, v13, 4
    int-to-byte v9, v9
  :L11
  .line 103
  .local v9, "i12":I
    and-int/lit8 v10, v14, -128
    if-nez v10, :L16
    shr-int/lit8 v10, v14, 6
    int-to-byte v10, v10
  :L12
  .line 104
  .local v10, "i13":I
    sget-object v23, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    aget-byte v8, v23, v8
  .end local v8
    aput-byte v8, v5, v15
  .line 105
    add-int/lit8 v8, v15, 1
    sget-object v23, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    shl-int/lit8 v24, v6, 4
    or-int v9, v9, v24
    aget-byte v9, v23, v9
  .end local v9
    aput-byte v9, v5, v8
  .line 106
    add-int/lit8 v8, v15, 2
    sget-object v9, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    shl-int/lit8 v23, v11, 2
    or-int v10, v10, v23
    aget-byte v9, v9, v10
  .end local v10
    aput-byte v9, v5, v8
  .line 107
    add-int/lit8 v8, v15, 3
    sget-object v9, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    and-int/lit8 v10, v14, 63
    aget-byte v9, v9, v10
    aput-byte v9, v5, v8
  .line 108
    add-int/lit8 v8, v15, 4
  .line 109
  .end local v15
  .local v8, "i6":I
    if-eqz p1, :L25
    move v0, v8
    move/from16 v1, v18
    if-eq v0, v1, :L17
    move/from16 v10, v18
  :L13
  .line 93
  .end local v18
  .local v10, "i9":I
    add-int/lit8 v9, v17, 1
  .end local v17
  .local v9, "i8":I
    move/from16 v18, v10
  .end local v10
  .restart local v18
    move/from16 v17, v9
  .end local v9
  .restart local v17
    move v15, v8
  .end local v8
  .restart local v15
    move v10, v13
  .end local v13
  .local v10, "i4":I
    move v9, v12
  .end local v12
  .local v9, "i3":I
    move v8, v11
  .end local v11
  .local v8, "i2":I
    move v11, v14
  .end local v14
  .local v11, "i5":I
    move/from16 v12, v16
  .end local v16
  .local v12, "i7":I
    goto/16 :L3
  :L14
  .line 101
  .end local v8
  .end local v9
  .end local v10
  .local v11, "i2":I
  .local v12, "i3":I
  .restart local v13
  .restart local v14
  .restart local v16
    shr-int/lit8 v8, v12, 2
    xor-int/lit16 v8, v8, 192
    int-to-byte v8, v8
    goto :L10
  :L15
  .line 102
  .local v8, "i11":I
    shr-int/lit8 v9, v13, 4
    xor-int/lit16 v9, v9, 240
    int-to-byte v9, v9
    goto :L11
  :L16
  .line 103
  .local v9, "i12":I
    shr-int/lit8 v10, v14, 6
    xor-int/lit16 v10, v10, 252
    int-to-byte v10, v10
    goto :L12
  :L17
  .line 111
  .end local v9
  .end local v15
  .local v8, "i6":I
    sget-object v9, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
    const/4 v10, 0
    sget-object v15, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
    array-length v15, v15
    invoke-static { v9, v10, v5, v8, v15 }, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V
  .line 112
    add-int/lit8 v7, v7, 1
  .line 113
    add-int/lit8 v9, v7, 1
    mul-int/lit8 v9, v9, 76
    sget-object v10, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
    array-length v10, v10
    mul-int/2addr v10, v7
    add-int/2addr v9, v10
  .line 114
  .end local v18
  .local v9, "i9":I
    sget-object v10, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B
    array-length v10, v10
    add-int/2addr v8, v10
    move v10, v9
  .end local v9
  .local v10, "i9":I
    goto :L13
  :L18
  .line 121
  .end local v6
  .end local v12
  .end local v13
  .end local v14
  .end local v16
  .local v8, "i2":I
  .local v9, "i3":I
  .local v10, "i4":I
  .local v11, "i7":I
  .restart local v15
  .restart local v18
  .local p0, "i1":I
    shr-int/lit8 v6, v9, 2
    xor-int/lit16 v6, v6, 192
    int-to-byte v6, v6
    goto/16 :L4
  :L19
  .line 127
  .restart local v6
  .local p0, "paramArrayOfByte":[B
    const/16 v12, 16
    move/from16 v0, v19
    move v1, v12
    if-ne v0, v1, :L24
  .line 129
    aget-byte v10, p0, v11
  .line 130
  .end local v9
  .local v10, "i3":I
    add-int/lit8 v6, v11, 1
    aget-byte v11, p0, v6
  .line 131
  .end local v6
  .local v11, "i4":I
    and-int/lit8 p0, v11, 15
    move/from16 v0, p0
    int-to-byte v0, v0
    move v9, v0
  .line 132
  .end local v8
  .local v9, "i2":I
    and-int/lit8 p0, v10, 3
    move/from16 v0, p0
    int-to-byte v0, v0
    move/from16 p0, v0
  .line 133
  .local p0, "i1":I
    and-int/lit8 v6, v10, -128
    if-nez v6, :L22
    shr-int/lit8 v6, v10, 2
    int-to-byte v6, v6
  :L20
  .line 134
  .local v6, "i11":I
    and-int/lit8 v8, v11, -128
    if-nez v8, :L23
    shr-int/lit8 v8, v11, 4
    int-to-byte v8, v8
  :L21
  .line 135
  .local v8, "i12":I
    sget-object v12, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    aget-byte v6, v12, v6
  .end local v6
    aput-byte v6, v5, v15
  .line 136
    add-int/lit8 v6, v15, 1
    sget-object v12, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    shl-int/lit8 v13, p0, 4
    or-int/2addr v8, v13
    aget-byte v8, v12, v8
  .end local v8
    aput-byte v8, v5, v6
  .line 137
    add-int/lit8 v6, v15, 2
    sget-object v8, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B
    shl-int/lit8 v12, v9, 2
    aget-byte v8, v8, v12
    aput-byte v8, v5, v6
  .line 138
    add-int/lit8 v6, v15, 3
    const/16 v8, 61
    aput-byte v8, v5, v6
    move v8, v10
  .end local v10
  .local v8, "i3":I
    move v6, v9
  .end local v9
  .local v6, "i2":I
    move v9, v11
  .end local v11
  .local v9, "i4":I
    goto/16 :L5
  :L22
  .line 133
  .end local v6
  .end local v8
  .local v9, "i2":I
  .restart local v10
  .restart local v11
    shr-int/lit8 v6, v10, 2
    xor-int/lit16 v6, v6, 192
    int-to-byte v6, v6
    goto :L20
  :L23
  .line 134
  .local v6, "i11":I
    shr-int/lit8 v8, v11, 4
    xor-int/lit16 v8, v8, 240
    int-to-byte v8, v8
    goto :L21
  :L24
  .local v6, "i1":I
  .local v8, "i2":I
  .local v9, "i3":I
  .local v10, "i4":I
  .local v11, "i7":I
  .local p0, "paramArrayOfByte":[B
    move/from16 p0, v6
  .end local v6
  .local p0, "i1":I
    move v6, v8
  .end local v8
  .local v6, "i2":I
    move v8, v9
  .end local v9
  .local v8, "i3":I
    move v9, v10
  .end local v10
  .local v9, "i4":I
    goto/16 :L5
  :L25
  .end local v9
  .end local v15
  .local v6, "i1":I
  .local v8, "i6":I
  .local v11, "i2":I
  .restart local v12
  .restart local v13
  .restart local v14
  .restart local v16
  .local p0, "paramArrayOfByte":[B
    move/from16 v10, v18
  .end local v18
  .local v10, "i9":I
    goto/16 :L13
  :L26
  .end local v7
  .end local v8
  .end local v10
  .end local v11
  .end local v12
  .end local v13
  .end local v14
  .end local v16
  .end local v17
  .end local v21
  .end local v22
  .local v5, "m":I
  .local v6, "n":I
    move/from16 v22, v6
  .end local v6
  .restart local v22
    move/from16 v21, v5
  .end local v5
  .restart local v21
    goto/16 :L2
.end method

.method public static encodeBase64Chunked([B)[B
  .parameter "paramArrayOfByte" # [B
  .registers 2
  .prologue
  .line 45
    const/4 v0, 1
    invoke-static { p0, v0 }, Lcom/uc/paymentsdk/commons/codec/Base64;->encodeBase64([BZ)[B
    move-result-object v0
    return-object v0
.end method

.method public static isArrayByteBase64([B)Z
  .parameter "paramArrayOfByte" # [B
  .registers 5
  .prologue
    const/4 v3, 1
  .line 28
    invoke-static { p0 }, Lcom/uc/paymentsdk/commons/codec/Base64;->discardWhitespace([B)[B
    move-result-object p0
  .line 29
    array-length v0, p0
  .line 30
  .local v0, "i":I
    if-nez v0, :L1
    move v2, v3
  :L0
  .line 35
    return v2
  :L1
  .line 32
    const/4 v1, 0
  :L2
  .local v1, "j":I
    if-lt v1, v0, :L3
    move v2, v3
  .line 35
    goto :L0
  :L3
  .line 33
    aget-byte v2, p0, v1
    invoke-static { v2 }, Lcom/uc/paymentsdk/commons/codec/Base64;->isBase64(B)Z
    move-result v2
    if-nez v2, :L4
  .line 34
    const/4 v2, 0
    goto :L0
  :L4
  .line 32
    add-int/lit8 v1, v1, 1
    goto :L2
.end method

.method private static isBase64(B)Z
  .parameter "paramByte" # B
  .registers 4
  .prologue
    const/4 v2, 1
  .line 21
    const/16 v0, 61
    if-ne p0, v0, :L1
    move v0, v2
  :L0
  .line 23
    return v0
  :L1
    sget-object v0, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B
    aget-byte v0, v0, p0
    const/4 v1, -1
    if-eq v0, v1, :L2
    move v0, v2
    goto :L0
  :L2
    const/4 v0, 0
    goto :L0
.end method

.method public decode(Ljava/lang/Object;)Ljava/lang/Object;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Lcom/uc/paymentsdk/commons/codec/DecoderException;
    }
  .end annotation
  .parameter "paramObject" # Ljava/lang/Object;
  .registers 4
  .prologue
  .line 52
    instance-of v0, p1, [B
    if-nez v0, :L0
  .line 53
    new-instance v0, Lcom/uc/paymentsdk/commons/codec/DecoderException;
    const-string v1, "Parameter supplied to Base64 decode is not a byte[]"
    invoke-direct { v0, v1 }, Lcom/uc/paymentsdk/commons/codec/DecoderException;-><init>(Ljava/lang/String;)V
    throw v0
  :L0
  .line 54
    check-cast p1, [B
  .end local p1
    invoke-virtual { p0, p1 }, Lcom/uc/paymentsdk/commons/codec/Base64;->decode([B)[B
    move-result-object v0
    return-object v0
.end method

.method public decode([B)[B
  .parameter "paramArrayOfByte" # [B
  .registers 3
  .prologue
  .line 60
    invoke-static { p1 }, Lcom/uc/paymentsdk/commons/codec/Base64;->decodeBase64([B)[B
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
  .registers 4
  .prologue
  .line 237
    instance-of v0, p1, [B
    if-nez v0, :L0
  .line 238
    new-instance v0, Lcom/uc/paymentsdk/commons/codec/EncoderException;
    const-string v1, "Parameter supplied to Base64 encode is not a byte[]"
    invoke-direct { v0, v1 }, Lcom/uc/paymentsdk/commons/codec/EncoderException;-><init>(Ljava/lang/String;)V
    throw v0
  :L0
  .line 239
    check-cast p1, [B
  .end local p1
    invoke-virtual { p0, p1 }, Lcom/uc/paymentsdk/commons/codec/Base64;->encode([B)[B
    move-result-object v0
    return-object v0
.end method

.method public encode([B)[B
  .parameter "paramArrayOfByte" # [B
  .registers 3
  .prologue
  .line 245
    const/4 v0, 0
    invoke-static { p1, v0 }, Lcom/uc/paymentsdk/commons/codec/Base64;->encodeBase64([BZ)[B
    move-result-object v0
    return-object v0
.end method
