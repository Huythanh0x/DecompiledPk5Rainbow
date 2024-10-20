.class public Lcom/uc/paymentsdk/commons/codec/Base64;
.super Ljava/lang/Object;
.source "Base64.java"

# interfaces
.implements Lcom/uc/paymentsdk/commons/codec/BinaryEncoder;
.implements Lcom/uc/paymentsdk/commons/codec/BinaryDecoder;


# static fields
.field static final BASELENGTH:I = 0xff

.field static final CHUNK_SEPARATOR:[B

.field static final CHUNK_SIZE:I = 0x4c

.field static final EIGHTBIT:I = 0x8

.field static final FOURBYTE:I = 0x4

.field static final LOOKUPLENGTH:I = 0x40

.field static final PAD:B = 0x3dt

.field static final SIGN:I = -0x80

.field static final SIXTEENBIT:I = 0x10

.field static final TWENTYFOURBITGROUP:I = 0x18

.field private static base64Alphabet:[B

.field private static lookUpBase64Alphabet:[B


# direct methods
.method static constructor <clinit>()V
    .registers 10

    .prologue
    const/16 v9, 0x3f

    const/16 v8, 0x3e

    const/16 v7, 0x30

    const/16 v6, 0x2f

    const/16 v5, 0x2b

    .line 7
    const-string v3, "\r\n"

    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    sput-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    .line 16
    const/16 v3, 0xff

    new-array v3, v3, [B

    sput-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    .line 17
    const/16 v3, 0x40

    new-array v3, v3, [B

    sput-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    .line 250
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1f
    const/16 v3, 0xff

    if-lt v0, v3, :cond_57

    .line 252
    const/16 v0, 0x5a

    :goto_25
    const/16 v3, 0x41

    if-ge v0, v3, :cond_5f

    .line 254
    const/16 v0, 0x7a

    :goto_2b
    const/16 v3, 0x61

    if-ge v0, v3, :cond_6b

    .line 256
    const/16 v0, 0x39

    :goto_31
    if-ge v0, v7, :cond_79

    .line 258
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    aput-byte v8, v3, v5

    .line 259
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    aput-byte v9, v3, v6

    .line 260
    const/4 v0, 0x0

    :goto_3c
    const/16 v3, 0x19

    if-le v0, v3, :cond_85

    .line 262
    const/16 v1, 0x1a

    .line 263
    .local v1, "icount":I
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_43
    const/16 v3, 0x33

    if-le v1, v3, :cond_8f

    .line 268
    const/16 v1, 0x34

    .line 269
    const/4 v2, 0x0

    :goto_4a
    const/16 v3, 0x3d

    if-le v1, v3, :cond_9b

    .line 274
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    aput-byte v5, v3, v8

    .line 275
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    aput-byte v6, v3, v9

    .line 3
    return-void

    .line 251
    .end local v1    # "icount":I
    .end local v2    # "j":I
    :cond_57
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    const/4 v4, -0x1

    aput-byte v4, v3, v0

    .line 250
    add-int/lit8 v0, v0, 0x1

    goto :goto_1f

    .line 253
    :cond_5f
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    const/16 v4, 0x41

    sub-int v4, v0, v4

    int-to-byte v4, v4

    aput-byte v4, v3, v0

    .line 252
    add-int/lit8 v0, v0, -0x1

    goto :goto_25

    .line 255
    :cond_6b
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    const/16 v4, 0x61

    sub-int v4, v0, v4

    add-int/lit8 v4, v4, 0x1a

    int-to-byte v4, v4

    aput-byte v4, v3, v0

    .line 254
    add-int/lit8 v0, v0, -0x1

    goto :goto_2b

    .line 257
    :cond_79
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    sub-int v4, v0, v7

    add-int/lit8 v4, v4, 0x34

    int-to-byte v4, v4

    aput-byte v4, v3, v0

    .line 256
    add-int/lit8 v0, v0, -0x1

    goto :goto_31

    .line 261
    :cond_85
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    add-int/lit8 v4, v0, 0x41

    int-to-byte v4, v4

    aput-byte v4, v3, v0

    .line 260
    add-int/lit8 v0, v0, 0x1

    goto :goto_3c

    .line 265
    .restart local v1    # "icount":I
    .restart local v2    # "j":I
    :cond_8f
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    add-int/lit8 v4, v2, 0x61

    int-to-byte v4, v4

    aput-byte v4, v3, v1

    .line 266
    add-int/lit8 v1, v1, 0x1

    .line 263
    add-int/lit8 v2, v2, 0x1

    goto :goto_43

    .line 271
    :cond_9b
    sget-object v3, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    add-int/lit8 v4, v2, 0x30

    int-to-byte v4, v4

    aput-byte v4, v3, v1

    .line 272
    add-int/lit8 v1, v1, 0x1

    .line 269
    add-int/lit8 v2, v2, 0x1

    goto :goto_4a
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static decodeBase64([B)[B
    .registers 16
    .param p0, "paramArrayOfByte"    # [B

    .prologue
    const/4 v12, 0x0

    const/16 v14, 0x3d

    .line 147
    invoke-static {p0}, Lcom/uc/paymentsdk/commons/codec/Base64;->discardNonBase64([B)[B

    move-result-object p0

    .line 148
    array-length v11, p0

    if-nez v11, :cond_d

    .line 149
    new-array v11, v12, [B

    .line 195
    :goto_c
    return-object v11

    .line 150
    :cond_d
    array-length v11, p0

    div-int/lit8 v1, v11, 0x4

    .line 151
    .local v1, "i":I
    const/4 v0, 0x0

    check-cast v0, [B

    .line 152
    .local v0, "arrayOfByte":[B
    const/4 v7, 0x0

    .line 153
    .local v7, "j":I
    const/4 v8, 0x0

    .line 154
    .local v8, "k":I
    const/4 v9, 0x0

    .line 155
    .local v9, "m":I
    const/4 v10, 0x0

    .line 156
    .local v10, "n":I
    const/4 v2, 0x0

    .line 157
    .local v2, "i1":I
    const/4 v3, 0x0

    .line 158
    .local v3, "i2":I
    const/4 v4, 0x0

    .line 159
    .local v4, "i3":I
    const/4 v5, 0x0

    .line 160
    .local v5, "i4":I
    array-length v6, p0

    .line 161
    .local v6, "i5":I
    :cond_1c
    const/4 v11, 0x1

    sub-int v11, v6, v11

    aget-byte v11, p0, v11

    if-eq v11, v14, :cond_2c

    .line 167
    sub-int v11, v6, v1

    new-array v0, v11, [B

    .line 168
    const/4 v6, 0x0

    :goto_28
    if-lt v6, v1, :cond_33

    move-object v11, v0

    .line 195
    goto :goto_c

    .line 163
    :cond_2c
    add-int/lit8 v6, v6, -0x1

    .line 164
    if-nez v6, :cond_1c

    .line 165
    new-array v11, v12, [B

    goto :goto_c

    .line 170
    :cond_33
    mul-int/lit8 v5, v6, 0x4

    .line 171
    add-int/lit8 v11, v5, 0x2

    aget-byte v2, p0, v11

    .line 172
    add-int/lit8 v11, v5, 0x3

    aget-byte v3, p0, v11

    .line 173
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    aget-byte v12, p0, v5

    aget-byte v7, v11, v12

    .line 174
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    add-int/lit8 v12, v5, 0x1

    aget-byte v12, p0, v12

    aget-byte v8, v11, v12

    .line 175
    if-eq v2, v14, :cond_7a

    if-eq v3, v14, :cond_7a

    .line 177
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    aget-byte v9, v11, v2

    .line 178
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    aget-byte v10, v11, v3

    .line 179
    shl-int/lit8 v11, v7, 0x2

    shr-int/lit8 v12, v8, 0x4

    or-int/2addr v11, v12

    int-to-byte v11, v11

    aput-byte v11, v0, v4

    .line 180
    add-int/lit8 v11, v4, 0x1

    and-int/lit8 v12, v8, 0xf

    shl-int/lit8 v12, v12, 0x4

    shr-int/lit8 v13, v9, 0x2

    and-int/lit8 v13, v13, 0xf

    or-int/2addr v12, v13

    int-to-byte v12, v12

    aput-byte v12, v0, v11

    .line 181
    add-int/lit8 v11, v4, 0x2

    shl-int/lit8 v12, v9, 0x6

    or-int/2addr v12, v10

    int-to-byte v12, v12

    aput-byte v12, v0, v11

    .line 193
    :cond_75
    :goto_75
    add-int/lit8 v4, v4, 0x3

    .line 168
    add-int/lit8 v6, v6, 0x1

    goto :goto_28

    .line 183
    :cond_7a
    if-ne v2, v14, :cond_85

    .line 185
    shl-int/lit8 v11, v7, 0x2

    shr-int/lit8 v12, v8, 0x4

    or-int/2addr v11, v12

    int-to-byte v11, v11

    aput-byte v11, v0, v4

    goto :goto_75

    .line 187
    :cond_85
    if-ne v3, v14, :cond_75

    .line 189
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    aget-byte v9, v11, v2

    .line 190
    shl-int/lit8 v11, v7, 0x2

    shr-int/lit8 v12, v8, 0x4

    or-int/2addr v11, v12

    int-to-byte v11, v11

    aput-byte v11, v0, v4

    .line 191
    add-int/lit8 v11, v4, 0x1

    and-int/lit8 v12, v8, 0xf

    shl-int/lit8 v12, v12, 0x4

    shr-int/lit8 v13, v9, 0x2

    and-int/lit8 v13, v13, 0xf

    or-int/2addr v12, v13

    int-to-byte v12, v12

    aput-byte v12, v0, v11

    goto :goto_75
.end method

.method static discardNonBase64([B)[B
    .registers 8
    .param p0, "paramArrayOfByte"    # [B

    .prologue
    const/4 v6, 0x0

    .line 220
    array-length v5, p0

    new-array v0, v5, [B

    .line 221
    .local v0, "arrayOfByte1":[B
    const/4 v2, 0x0

    .line 222
    .local v2, "i":I
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_6
    array-length v5, p0

    if-lt v4, v5, :cond_f

    .line 228
    new-array v1, v2, [B

    .line 229
    .local v1, "arrayOfByte2":[B
    invoke-static {v0, v6, v1, v6, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 230
    return-object v1

    .line 224
    .end local v1    # "arrayOfByte2":[B
    :cond_f
    aget-byte v5, p0, v4

    invoke-static {v5}, Lcom/uc/paymentsdk/commons/codec/Base64;->isBase64(B)Z

    move-result v5

    if-nez v5, :cond_1a

    .line 222
    :goto_17
    add-int/lit8 v4, v4, 0x1

    goto :goto_6

    .line 226
    :cond_1a
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "i":I
    .local v3, "i":I
    aget-byte v5, p0, v4

    aput-byte v5, v0, v2

    move v2, v3

    .end local v3    # "i":I
    .restart local v2    # "i":I
    goto :goto_17
.end method

.method static discardWhitespace([B)[B
    .registers 8
    .param p0, "paramArrayOfByte"    # [B

    .prologue
    const/4 v6, 0x0

    .line 200
    array-length v5, p0

    new-array v0, v5, [B

    .line 201
    .local v0, "arrayOfByte1":[B
    const/4 v2, 0x0

    .line 202
    .local v2, "i":I
    const/4 v4, 0x0

    .local v4, "j":I
    :goto_6
    array-length v5, p0

    if-lt v4, v5, :cond_f

    .line 213
    new-array v1, v2, [B

    .line 214
    .local v1, "arrayOfByte2":[B
    invoke-static {v0, v6, v1, v6, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 215
    return-object v1

    .line 203
    .end local v1    # "arrayOfByte2":[B
    :cond_f
    aget-byte v5, p0, v4

    sparse-switch v5, :sswitch_data_1e

    .line 211
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "i":I
    .local v3, "i":I
    aget-byte v5, p0, v4

    aput-byte v5, v0, v2

    move v2, v3

    .line 202
    .end local v3    # "i":I
    .restart local v2    # "i":I
    :sswitch_1b
    add-int/lit8 v4, v4, 0x1

    goto :goto_6

    .line 203
    :sswitch_data_1e
    .sparse-switch
        0x9 -> :sswitch_1b
        0xa -> :sswitch_1b
        0xd -> :sswitch_1b
        0x20 -> :sswitch_1b
    .end sparse-switch
.end method

.method public static encodeBase64([B)[B
    .registers 2
    .param p0, "paramArrayOfByte"    # [B

    .prologue
    .line 40
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/uc/paymentsdk/commons/codec/Base64;->encodeBase64([BZ)[B

    move-result-object v0

    return-object v0
.end method

.method public static encodeBase64([BZ)[B
    .registers 27
    .param p0, "paramArrayOfByte"    # [B
    .param p1, "paramBoolean"    # Z

    .prologue
    .line 65
    move-object/from16 v0, p0

    array-length v0, v0

    move v5, v0

    mul-int/lit8 v5, v5, 0x8

    .line 66
    .local v5, "i":I
    rem-int/lit8 v19, v5, 0x18

    .line 67
    .local v19, "j":I
    div-int/lit8 v20, v5, 0x18

    .line 68
    .local v20, "k":I
    const/4 v5, 0x0

    check-cast v5, [B

    .line 69
    .local v5, "arrayOfByte":[B
    const/4 v5, 0x0

    .line 70
    .local v5, "m":I
    const/4 v6, 0x0

    .line 71
    .local v6, "n":I
    if-eqz v19, :cond_99

    .line 72
    add-int/lit8 v5, v20, 0x1

    mul-int/lit8 v5, v5, 0x4

    .line 75
    :goto_15
    if-eqz p1, :cond_1aa

    .line 77
    sget-object v6, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    .end local v6    # "n":I
    array-length v6, v6

    if-nez v6, :cond_9d

    const/4 v6, 0x0

    .line 78
    .restart local v6    # "n":I
    :goto_1d
    sget-object v7, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    array-length v7, v7

    mul-int/2addr v7, v6

    add-int/2addr v5, v7

    move/from16 v22, v6

    .end local v6    # "n":I
    .local v22, "n":I
    move/from16 v21, v5

    .line 80
    .end local v5    # "m":I
    .local v21, "m":I
    :goto_26
    move/from16 v0, v21

    new-array v0, v0, [B

    move-object v5, v0

    .line 81
    .local v5, "arrayOfByte":[B
    const/4 v6, 0x0

    .line 82
    .local v6, "i1":I
    const/4 v8, 0x0

    .line 83
    .local v8, "i2":I
    const/4 v9, 0x0

    .line 84
    .local v9, "i3":I
    const/4 v10, 0x0

    .line 85
    .local v10, "i4":I
    const/4 v11, 0x0

    .line 86
    .local v11, "i5":I
    const/4 v12, 0x0

    .line 87
    .local v12, "i6":I
    const/4 v13, 0x0

    .line 88
    .local v13, "i7":I
    const/4 v7, 0x0

    .line 89
    .local v7, "i8":I
    const/16 v15, 0x4c

    .line 90
    .local v15, "i9":I
    const/4 v7, 0x0

    .line 93
    .local v7, "i10":I
    const/4 v14, 0x0

    .local v14, "i8":I
    move/from16 v18, v15

    .end local v15    # "i9":I
    .local v18, "i9":I
    move/from16 v17, v14

    .end local v14    # "i8":I
    .local v17, "i8":I
    move v15, v12

    .end local v12    # "i6":I
    .local v15, "i6":I
    move v12, v13

    .end local v13    # "i7":I
    .local v12, "i7":I
    :goto_3d
    move/from16 v0, v17

    move/from16 v1, v20

    if-lt v0, v1, :cond_a9

    .line 116
    mul-int/lit8 v11, v17, 0x3

    .line 117
    .end local v12    # "i7":I
    .local v11, "i7":I
    const/16 v12, 0x8

    move/from16 v0, v19

    move v1, v12

    if-ne v0, v1, :cond_145

    .line 119
    aget-byte v9, p0, v11

    .line 120
    and-int/lit8 p0, v9, 0x3

    move/from16 v0, p0

    int-to-byte v0, v0

    move/from16 p0, v0

    .line 121
    .end local v6    # "i1":I
    .local p0, "i1":I
    and-int/lit8 v6, v9, -0x80

    if-nez v6, :cond_13e

    shr-int/lit8 v6, v9, 0x2

    int-to-byte v6, v6

    .line 122
    .local v6, "i11":I
    :goto_5c
    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    .end local v11    # "i7":I
    aget-byte v6, v11, v6

    .end local v6    # "i11":I
    aput-byte v6, v5, v15

    .line 123
    add-int/lit8 v6, v15, 0x1

    sget-object v11, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    shl-int/lit8 v12, p0, 0x4

    aget-byte v11, v11, v12

    aput-byte v11, v5, v6

    .line 124
    add-int/lit8 v6, v15, 0x2

    const/16 v11, 0x3d

    aput-byte v11, v5, v6

    .line 125
    add-int/lit8 v6, v15, 0x3

    const/16 v11, 0x3d

    aput-byte v11, v5, v6

    move v6, v8

    .end local v8    # "i2":I
    .local v6, "i2":I
    move v8, v9

    .end local v9    # "i3":I
    .local v8, "i3":I
    move v9, v10

    .line 140
    .end local v10    # "i4":I
    .local v9, "i4":I
    :goto_7b
    if-eqz p1, :cond_98

    move v0, v7

    move/from16 v1, v22

    if-ge v0, v1, :cond_98

    .line 141
    sget-object p0, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    .end local p0    # "i1":I
    const/16 p1, 0x0

    sget-object v6, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    .end local v6    # "i2":I
    .end local p1    # "paramBoolean":Z
    array-length v6, v6

    sub-int v6, v21, v6

    sget-object v7, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    .end local v7    # "i10":I
    array-length v7, v7

    move-object/from16 v0, p0

    move/from16 v1, p1

    move-object v2, v5

    move v3, v6

    move v4, v7

    invoke-static {v0, v1, v2, v3, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 142
    :cond_98
    return-object v5

    .line 74
    .end local v8    # "i3":I
    .end local v9    # "i4":I
    .end local v15    # "i6":I
    .end local v17    # "i8":I
    .end local v18    # "i9":I
    .end local v21    # "m":I
    .end local v22    # "n":I
    .local v5, "m":I
    .local v6, "n":I
    .local p0, "paramArrayOfByte":[B
    .restart local p1    # "paramBoolean":Z
    :cond_99
    mul-int/lit8 v5, v20, 0x4

    goto/16 :goto_15

    .line 77
    .end local v6    # "n":I
    :cond_9d
    int-to-float v6, v5

    const/high16 v7, 0x42980000    # 76.0f

    div-float/2addr v6, v7

    float-to-double v6, v6

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-int v6, v6

    goto/16 :goto_1d

    .line 95
    .local v5, "arrayOfByte":[B
    .local v6, "i1":I
    .restart local v7    # "i10":I
    .local v8, "i2":I
    .local v9, "i3":I
    .restart local v10    # "i4":I
    .local v11, "i5":I
    .restart local v12    # "i7":I
    .restart local v15    # "i6":I
    .restart local v17    # "i8":I
    .restart local v18    # "i9":I
    .restart local v21    # "m":I
    .restart local v22    # "n":I
    :cond_a9
    mul-int/lit8 v16, v17, 0x3

    .line 96
    .end local v12    # "i7":I
    .local v16, "i7":I
    aget-byte v12, p0, v16

    .line 97
    .end local v9    # "i3":I
    .local v12, "i3":I
    add-int/lit8 v6, v16, 0x1

    aget-byte v13, p0, v6

    .line 98
    .end local v6    # "i1":I
    .end local v10    # "i4":I
    .local v13, "i4":I
    add-int/lit8 v6, v16, 0x2

    aget-byte v14, p0, v6

    .line 99
    .end local v11    # "i5":I
    .local v14, "i5":I
    and-int/lit8 v6, v13, 0xf

    int-to-byte v11, v6

    .line 100
    .end local v8    # "i2":I
    .local v11, "i2":I
    and-int/lit8 v6, v12, 0x3

    int-to-byte v6, v6

    .line 101
    .restart local v6    # "i1":I
    and-int/lit8 v8, v12, -0x80

    if-nez v8, :cond_112

    shr-int/lit8 v8, v12, 0x2

    int-to-byte v8, v8

    .line 102
    .local v8, "i11":I
    :goto_c2
    and-int/lit8 v9, v13, -0x80

    if-nez v9, :cond_118

    shr-int/lit8 v9, v13, 0x4

    int-to-byte v9, v9

    .line 103
    .local v9, "i12":I
    :goto_c9
    and-int/lit8 v10, v14, -0x80

    if-nez v10, :cond_11e

    shr-int/lit8 v10, v14, 0x6

    int-to-byte v10, v10

    .line 104
    .local v10, "i13":I
    :goto_d0
    sget-object v23, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    aget-byte v8, v23, v8

    .end local v8    # "i11":I
    aput-byte v8, v5, v15

    .line 105
    add-int/lit8 v8, v15, 0x1

    sget-object v23, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    shl-int/lit8 v24, v6, 0x4

    or-int v9, v9, v24

    aget-byte v9, v23, v9

    .end local v9    # "i12":I
    aput-byte v9, v5, v8

    .line 106
    add-int/lit8 v8, v15, 0x2

    sget-object v9, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    shl-int/lit8 v23, v11, 0x2

    or-int v10, v10, v23

    aget-byte v9, v9, v10

    .end local v10    # "i13":I
    aput-byte v9, v5, v8

    .line 107
    add-int/lit8 v8, v15, 0x3

    sget-object v9, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    and-int/lit8 v10, v14, 0x3f

    aget-byte v9, v9, v10

    aput-byte v9, v5, v8

    .line 108
    add-int/lit8 v8, v15, 0x4

    .line 109
    .end local v15    # "i6":I
    .local v8, "i6":I
    if-eqz p1, :cond_1a6

    move v0, v8

    move/from16 v1, v18

    if-eq v0, v1, :cond_124

    move/from16 v10, v18

    .line 93
    .end local v18    # "i9":I
    .local v10, "i9":I
    :goto_103
    add-int/lit8 v9, v17, 0x1

    .end local v17    # "i8":I
    .local v9, "i8":I
    move/from16 v18, v10

    .end local v10    # "i9":I
    .restart local v18    # "i9":I
    move/from16 v17, v9

    .end local v9    # "i8":I
    .restart local v17    # "i8":I
    move v15, v8

    .end local v8    # "i6":I
    .restart local v15    # "i6":I
    move v10, v13

    .end local v13    # "i4":I
    .local v10, "i4":I
    move v9, v12

    .end local v12    # "i3":I
    .local v9, "i3":I
    move v8, v11

    .end local v11    # "i2":I
    .local v8, "i2":I
    move v11, v14

    .end local v14    # "i5":I
    .local v11, "i5":I
    move/from16 v12, v16

    .end local v16    # "i7":I
    .local v12, "i7":I
    goto/16 :goto_3d

    .line 101
    .end local v8    # "i2":I
    .end local v9    # "i3":I
    .end local v10    # "i4":I
    .local v11, "i2":I
    .local v12, "i3":I
    .restart local v13    # "i4":I
    .restart local v14    # "i5":I
    .restart local v16    # "i7":I
    :cond_112
    shr-int/lit8 v8, v12, 0x2

    xor-int/lit16 v8, v8, 0xc0

    int-to-byte v8, v8

    goto :goto_c2

    .line 102
    .local v8, "i11":I
    :cond_118
    shr-int/lit8 v9, v13, 0x4

    xor-int/lit16 v9, v9, 0xf0

    int-to-byte v9, v9

    goto :goto_c9

    .line 103
    .local v9, "i12":I
    :cond_11e
    shr-int/lit8 v10, v14, 0x6

    xor-int/lit16 v10, v10, 0xfc

    int-to-byte v10, v10

    goto :goto_d0

    .line 111
    .end local v9    # "i12":I
    .end local v15    # "i6":I
    .local v8, "i6":I
    :cond_124
    sget-object v9, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    const/4 v10, 0x0

    sget-object v15, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    array-length v15, v15

    invoke-static {v9, v10, v5, v8, v15}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 112
    add-int/lit8 v7, v7, 0x1

    .line 113
    add-int/lit8 v9, v7, 0x1

    mul-int/lit8 v9, v9, 0x4c

    sget-object v10, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    array-length v10, v10

    mul-int/2addr v10, v7

    add-int/2addr v9, v10

    .line 114
    .end local v18    # "i9":I
    .local v9, "i9":I
    sget-object v10, Lcom/uc/paymentsdk/commons/codec/Base64;->CHUNK_SEPARATOR:[B

    array-length v10, v10

    add-int/2addr v8, v10

    move v10, v9

    .end local v9    # "i9":I
    .local v10, "i9":I
    goto :goto_103

    .line 121
    .end local v6    # "i1":I
    .end local v12    # "i3":I
    .end local v13    # "i4":I
    .end local v14    # "i5":I
    .end local v16    # "i7":I
    .local v8, "i2":I
    .local v9, "i3":I
    .local v10, "i4":I
    .local v11, "i7":I
    .restart local v15    # "i6":I
    .restart local v18    # "i9":I
    .local p0, "i1":I
    :cond_13e
    shr-int/lit8 v6, v9, 0x2

    xor-int/lit16 v6, v6, 0xc0

    int-to-byte v6, v6

    goto/16 :goto_5c

    .line 127
    .restart local v6    # "i1":I
    .local p0, "paramArrayOfByte":[B
    :cond_145
    const/16 v12, 0x10

    move/from16 v0, v19

    move v1, v12

    if-ne v0, v1, :cond_19f

    .line 129
    aget-byte v10, p0, v11

    .line 130
    .end local v9    # "i3":I
    .local v10, "i3":I
    add-int/lit8 v6, v11, 0x1

    aget-byte v11, p0, v6

    .line 131
    .end local v6    # "i1":I
    .local v11, "i4":I
    and-int/lit8 p0, v11, 0xf

    move/from16 v0, p0

    int-to-byte v0, v0

    move v9, v0

    .line 132
    .end local v8    # "i2":I
    .local v9, "i2":I
    and-int/lit8 p0, v10, 0x3

    move/from16 v0, p0

    int-to-byte v0, v0

    move/from16 p0, v0

    .line 133
    .local p0, "i1":I
    and-int/lit8 v6, v10, -0x80

    if-nez v6, :cond_193

    shr-int/lit8 v6, v10, 0x2

    int-to-byte v6, v6

    .line 134
    .local v6, "i11":I
    :goto_166
    and-int/lit8 v8, v11, -0x80

    if-nez v8, :cond_199

    shr-int/lit8 v8, v11, 0x4

    int-to-byte v8, v8

    .line 135
    .local v8, "i12":I
    :goto_16d
    sget-object v12, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    aget-byte v6, v12, v6

    .end local v6    # "i11":I
    aput-byte v6, v5, v15

    .line 136
    add-int/lit8 v6, v15, 0x1

    sget-object v12, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    shl-int/lit8 v13, p0, 0x4

    or-int/2addr v8, v13

    aget-byte v8, v12, v8

    .end local v8    # "i12":I
    aput-byte v8, v5, v6

    .line 137
    add-int/lit8 v6, v15, 0x2

    sget-object v8, Lcom/uc/paymentsdk/commons/codec/Base64;->lookUpBase64Alphabet:[B

    shl-int/lit8 v12, v9, 0x2

    aget-byte v8, v8, v12

    aput-byte v8, v5, v6

    .line 138
    add-int/lit8 v6, v15, 0x3

    const/16 v8, 0x3d

    aput-byte v8, v5, v6

    move v8, v10

    .end local v10    # "i3":I
    .local v8, "i3":I
    move v6, v9

    .end local v9    # "i2":I
    .local v6, "i2":I
    move v9, v11

    .end local v11    # "i4":I
    .local v9, "i4":I
    goto/16 :goto_7b

    .line 133
    .end local v6    # "i2":I
    .end local v8    # "i3":I
    .local v9, "i2":I
    .restart local v10    # "i3":I
    .restart local v11    # "i4":I
    :cond_193
    shr-int/lit8 v6, v10, 0x2

    xor-int/lit16 v6, v6, 0xc0

    int-to-byte v6, v6

    goto :goto_166

    .line 134
    .local v6, "i11":I
    :cond_199
    shr-int/lit8 v8, v11, 0x4

    xor-int/lit16 v8, v8, 0xf0

    int-to-byte v8, v8

    goto :goto_16d

    .local v6, "i1":I
    .local v8, "i2":I
    .local v9, "i3":I
    .local v10, "i4":I
    .local v11, "i7":I
    .local p0, "paramArrayOfByte":[B
    :cond_19f
    move/from16 p0, v6

    .end local v6    # "i1":I
    .local p0, "i1":I
    move v6, v8

    .end local v8    # "i2":I
    .local v6, "i2":I
    move v8, v9

    .end local v9    # "i3":I
    .local v8, "i3":I
    move v9, v10

    .end local v10    # "i4":I
    .local v9, "i4":I
    goto/16 :goto_7b

    .end local v9    # "i4":I
    .end local v15    # "i6":I
    .local v6, "i1":I
    .local v8, "i6":I
    .local v11, "i2":I
    .restart local v12    # "i3":I
    .restart local v13    # "i4":I
    .restart local v14    # "i5":I
    .restart local v16    # "i7":I
    .local p0, "paramArrayOfByte":[B
    :cond_1a6
    move/from16 v10, v18

    .end local v18    # "i9":I
    .local v10, "i9":I
    goto/16 :goto_103

    .end local v7    # "i10":I
    .end local v8    # "i6":I
    .end local v10    # "i9":I
    .end local v11    # "i2":I
    .end local v12    # "i3":I
    .end local v13    # "i4":I
    .end local v14    # "i5":I
    .end local v16    # "i7":I
    .end local v17    # "i8":I
    .end local v21    # "m":I
    .end local v22    # "n":I
    .local v5, "m":I
    .local v6, "n":I
    :cond_1aa
    move/from16 v22, v6

    .end local v6    # "n":I
    .restart local v22    # "n":I
    move/from16 v21, v5

    .end local v5    # "m":I
    .restart local v21    # "m":I
    goto/16 :goto_26
.end method

.method public static encodeBase64Chunked([B)[B
    .registers 2
    .param p0, "paramArrayOfByte"    # [B

    .prologue
    .line 45
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/uc/paymentsdk/commons/codec/Base64;->encodeBase64([BZ)[B

    move-result-object v0

    return-object v0
.end method

.method public static isArrayByteBase64([B)Z
    .registers 5
    .param p0, "paramArrayOfByte"    # [B

    .prologue
    const/4 v3, 0x1

    .line 28
    invoke-static {p0}, Lcom/uc/paymentsdk/commons/codec/Base64;->discardWhitespace([B)[B

    move-result-object p0

    .line 29
    array-length v0, p0

    .line 30
    .local v0, "i":I
    if-nez v0, :cond_a

    move v2, v3

    .line 35
    :goto_9
    return v2

    .line 32
    :cond_a
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_b
    if-lt v1, v0, :cond_f

    move v2, v3

    .line 35
    goto :goto_9

    .line 33
    :cond_f
    aget-byte v2, p0, v1

    invoke-static {v2}, Lcom/uc/paymentsdk/commons/codec/Base64;->isBase64(B)Z

    move-result v2

    if-nez v2, :cond_19

    .line 34
    const/4 v2, 0x0

    goto :goto_9

    .line 32
    :cond_19
    add-int/lit8 v1, v1, 0x1

    goto :goto_b
.end method

.method private static isBase64(B)Z
    .registers 4
    .param p0, "paramByte"    # B

    .prologue
    const/4 v2, 0x1

    .line 21
    const/16 v0, 0x3d

    if-ne p0, v0, :cond_7

    move v0, v2

    .line 23
    :goto_6
    return v0

    :cond_7
    sget-object v0, Lcom/uc/paymentsdk/commons/codec/Base64;->base64Alphabet:[B

    aget-byte v0, v0, p0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_10

    move v0, v2

    goto :goto_6

    :cond_10
    const/4 v0, 0x0

    goto :goto_6
.end method


# virtual methods
.method public decode(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4
    .param p1, "paramObject"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/uc/paymentsdk/commons/codec/DecoderException;
        }
    .end annotation

    .prologue
    .line 52
    instance-of v0, p1, [B

    if-nez v0, :cond_c

    .line 53
    new-instance v0, Lcom/uc/paymentsdk/commons/codec/DecoderException;

    const-string v1, "Parameter supplied to Base64 decode is not a byte[]"

    invoke-direct {v0, v1}, Lcom/uc/paymentsdk/commons/codec/DecoderException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 54
    :cond_c
    check-cast p1, [B

    .end local p1    # "paramObject":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/uc/paymentsdk/commons/codec/Base64;->decode([B)[B

    move-result-object v0

    return-object v0
.end method

.method public decode([B)[B
    .registers 3
    .param p1, "paramArrayOfByte"    # [B

    .prologue
    .line 60
    invoke-static {p1}, Lcom/uc/paymentsdk/commons/codec/Base64;->decodeBase64([B)[B

    move-result-object v0

    return-object v0
.end method

.method public encode(Ljava/lang/Object;)Ljava/lang/Object;
    .registers 4
    .param p1, "paramObject"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/uc/paymentsdk/commons/codec/EncoderException;
        }
    .end annotation

    .prologue
    .line 237
    instance-of v0, p1, [B

    if-nez v0, :cond_c

    .line 238
    new-instance v0, Lcom/uc/paymentsdk/commons/codec/EncoderException;

    const-string v1, "Parameter supplied to Base64 encode is not a byte[]"

    invoke-direct {v0, v1}, Lcom/uc/paymentsdk/commons/codec/EncoderException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 239
    :cond_c
    check-cast p1, [B

    .end local p1    # "paramObject":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/uc/paymentsdk/commons/codec/Base64;->encode([B)[B

    move-result-object v0

    return-object v0
.end method

.method public encode([B)[B
    .registers 3
    .param p1, "paramArrayOfByte"    # [B

    .prologue
    .line 245
    const/4 v0, 0x0

    invoke-static {p1, v0}, Lcom/uc/paymentsdk/commons/codec/Base64;->encodeBase64([BZ)[B

    move-result-object v0

    return-object v0
.end method
