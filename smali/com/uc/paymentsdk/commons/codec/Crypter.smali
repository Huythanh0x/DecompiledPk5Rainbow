.class public Lcom/uc/paymentsdk/commons/codec/Crypter;
.super Ljava/lang/Object;
.source "Crypter.java"


# static fields
.field private static random:Ljava/util/Random;


# instance fields
.field private baos:Ljava/io/ByteArrayOutputStream;

.field private contextStart:I

.field private crypt:I

.field private header:Z

.field private key:[B

.field private out:[B

.field private padding:I

.field private plain:[B

.field private pos:I

.field private preCrypt:I

.field private prePlain:[B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    sput-object v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->random:Ljava/util/Random;

    .line 6
    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->header:Z

    .line 19
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Ljava/io/ByteArrayOutputStream;-><init>(I)V

    iput-object v0, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    .line 6
    return-void
.end method

.method private decipher([B)[B
    .locals 1
    .param p1, "paramArrayOfByte"    # [B

    .prologue
    .line 245
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/uc/paymentsdk/commons/codec/Crypter;->decipher([BI)[B

    move-result-object v0

    return-object v0
.end method

.method private decipher([BI)[B
    .locals 25
    .param p1, "paramArrayOfByte"    # [B
    .param p2, "paramInt"    # I

    .prologue
    .line 209
    const/16 v3, 0x10

    .line 210
    .local v3, "i":I
    const/16 v21, 0x4

    move-object/from16 v0, p1

    move/from16 v1, p2

    move/from16 v2, v21

    invoke-static {v0, v1, v2}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v5

    .line 211
    .local v5, "l1":J
    add-int/lit8 v21, p2, 0x4

    const/16 v22, 0x4

    move-object/from16 v0, p1

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-static {v0, v1, v2}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v7

    .line 212
    .local v7, "l2":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    move-object/from16 v21, v0

    const/16 v22, 0x0

    const/16 v23, 0x4

    invoke-static/range {v21 .. v23}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v9

    .line 213
    .local v9, "l3":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    move-object/from16 v21, v0

    const/16 v22, 0x4

    const/16 v23, 0x4

    invoke-static/range {v21 .. v23}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v11

    .line 214
    .local v11, "l4":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    move-object/from16 v21, v0

    const/16 v22, 0x8

    const/16 v23, 0x4

    invoke-static/range {v21 .. v23}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v13

    .line 215
    .local v13, "l5":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    move-object/from16 v21, v0

    const/16 v22, 0xc

    const/16 v23, 0x4

    invoke-static/range {v21 .. v23}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v15

    .line 216
    .local v15, "l6":J
    const-wide/32 v17, -0x1c886470

    .line 217
    .local v17, "l7":J
    const-wide v21, 0xffffffffL

    and-long v17, v17, v21

    .line 218
    const-wide/32 v19, -0x61c88647

    .line 219
    .local v19, "l8":J
    const-wide v21, 0xffffffffL

    and-long v19, v19, v21

    move v4, v3

    .line 220
    .end local v3    # "i":I
    .local v4, "i":I
    :goto_0
    add-int/lit8 v3, v4, -0x1

    .end local v4    # "i":I
    .restart local v3    # "i":I
    if-gtz v4, :cond_0

    .line 229
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/io/ByteArrayOutputStream;->reset()V

    .line 230
    move-wide v0, v5

    long-to-int v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/uc/paymentsdk/commons/codec/Crypter;->writeInt(I)V

    .line 231
    move-wide v0, v7

    long-to-int v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/uc/paymentsdk/commons/codec/Crypter;->writeInt(I)V

    .line 232
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v21

    return-object v21

    .line 222
    :cond_0
    const/16 v21, 0x4

    shl-long v21, v5, v21

    add-long v21, v21, v13

    add-long v23, v5, v17

    xor-long v21, v21, v23

    const/16 v23, 0x5

    ushr-long v23, v5, v23

    add-long v23, v23, v15

    xor-long v21, v21, v23

    sub-long v7, v7, v21

    .line 223
    const-wide v21, 0xffffffffL

    and-long v7, v7, v21

    .line 224
    const/16 v21, 0x4

    shl-long v21, v7, v21

    add-long v21, v21, v9

    add-long v23, v7, v17

    xor-long v21, v21, v23

    const/16 v23, 0x5

    ushr-long v23, v7, v23

    add-long v23, v23, v11

    xor-long v21, v21, v23

    sub-long v5, v5, v21

    .line 225
    const-wide v21, 0xffffffffL

    and-long v5, v5, v21

    .line 226
    sub-long v17, v17, v19

    .line 227
    const-wide v21, 0xffffffffL

    and-long v17, v17, v21

    move v4, v3

    .end local v3    # "i":I
    .restart local v4    # "i":I
    goto :goto_0
.end method

.method private decrypt8Bytes([BII)Z
    .locals 7
    .param p1, "paramArrayOfByte"    # [B
    .param p2, "paramInt1"    # I
    .param p3, "paramInt2"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 286
    iput v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 287
    :goto_0
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    const/16 v3, 0x8

    if-lt v2, v3, :cond_0

    .line 296
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    invoke-direct {p0, v2}, Lcom/uc/paymentsdk/commons/codec/Crypter;->decipher([B)[B

    move-result-object v2

    iput-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    .line 297
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    if-nez v2, :cond_2

    move v2, v5

    .line 302
    :goto_1
    return v2

    .line 289
    :cond_0
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->contextStart:I

    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/2addr v2, v3

    if-lt v2, p3, :cond_1

    move v2, v6

    .line 290
    goto :goto_1

    .line 291
    :cond_1
    iget v1, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 292
    .local v1, "tmp37_34":I
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    .line 293
    .local v0, "tmp37_30":[B
    aget-byte v2, v0, v1

    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    add-int/2addr v3, p2

    iget v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/2addr v3, v4

    aget-byte v3, p1, v3

    xor-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 294
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    goto :goto_0

    .line 299
    .end local v0    # "tmp37_30":[B
    .end local v1    # "tmp37_34":I
    :cond_2
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->contextStart:I

    add-int/lit8 v2, v2, 0x8

    iput v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->contextStart:I

    .line 300
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    add-int/lit8 v2, v2, 0x8

    iput v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    .line 301
    iput v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    move v2, v6

    .line 302
    goto :goto_1
.end method

.method private encipher([B)[B
    .locals 25
    .param p1, "paramArrayOfByte"    # [B

    .prologue
    .line 182
    const/16 v3, 0x10

    .line 183
    .local v3, "i":I
    const/16 v21, 0x0

    const/16 v22, 0x4

    move-object/from16 v0, p1

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-static {v0, v1, v2}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v5

    .line 184
    .local v5, "l1":J
    const/16 v21, 0x4

    const/16 v22, 0x4

    move-object/from16 v0, p1

    move/from16 v1, v21

    move/from16 v2, v22

    invoke-static {v0, v1, v2}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v7

    .line 185
    .local v7, "l2":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    move-object/from16 v21, v0

    const/16 v22, 0x0

    const/16 v23, 0x4

    invoke-static/range {v21 .. v23}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v9

    .line 186
    .local v9, "l3":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    move-object/from16 v21, v0

    const/16 v22, 0x4

    const/16 v23, 0x4

    invoke-static/range {v21 .. v23}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v11

    .line 187
    .local v11, "l4":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    move-object/from16 v21, v0

    const/16 v22, 0x8

    const/16 v23, 0x4

    invoke-static/range {v21 .. v23}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v13

    .line 188
    .local v13, "l5":J
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    move-object/from16 v21, v0

    const/16 v22, 0xc

    const/16 v23, 0x4

    invoke-static/range {v21 .. v23}, Lcom/uc/paymentsdk/commons/codec/Crypter;->getUnsignedInt([BII)J

    move-result-wide v15

    .line 189
    .local v15, "l6":J
    const-wide/16 v17, 0x0

    .line 190
    .local v17, "l7":J
    const-wide/32 v19, -0x61c88647

    .line 191
    .local v19, "l8":J
    const-wide v21, 0xffffffffL

    and-long v19, v19, v21

    move v4, v3

    .line 192
    .end local v3    # "i":I
    .local v4, "i":I
    :goto_0
    add-int/lit8 v3, v4, -0x1

    .end local v4    # "i":I
    .restart local v3    # "i":I
    if-gtz v4, :cond_0

    .line 201
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/io/ByteArrayOutputStream;->reset()V

    .line 202
    move-wide v0, v5

    long-to-int v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/uc/paymentsdk/commons/codec/Crypter;->writeInt(I)V

    .line 203
    move-wide v0, v7

    long-to-int v0, v0

    move/from16 v21, v0

    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-direct {v0, v1}, Lcom/uc/paymentsdk/commons/codec/Crypter;->writeInt(I)V

    .line 204
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v21

    return-object v21

    .line 194
    :cond_0
    add-long v17, v17, v19

    .line 195
    const-wide v21, 0xffffffffL

    and-long v17, v17, v21

    .line 196
    const/16 v21, 0x4

    shl-long v21, v7, v21

    add-long v21, v21, v9

    add-long v23, v7, v17

    xor-long v21, v21, v23

    const/16 v23, 0x5

    ushr-long v23, v7, v23

    add-long v23, v23, v11

    xor-long v21, v21, v23

    add-long v5, v5, v21

    .line 197
    const-wide v21, 0xffffffffL

    and-long v5, v5, v21

    .line 198
    const/16 v21, 0x4

    shl-long v21, v5, v21

    add-long v21, v21, v13

    add-long v23, v5, v17

    xor-long v21, v21, v23

    const/16 v23, 0x5

    ushr-long v23, v5, v23

    add-long v23, v23, v15

    xor-long v21, v21, v23

    add-long v7, v7, v21

    .line 199
    const-wide v21, 0xffffffffL

    and-long v7, v7, v21

    move v4, v3

    .end local v3    # "i":I
    .restart local v4    # "i":I
    goto :goto_0
.end method

.method private encrypt8Bytes()V
    .locals 13

    .prologue
    const/16 v12, 0x8

    const/4 v11, 0x0

    .line 250
    iput v11, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 251
    :goto_0
    iget v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-lt v7, v12, :cond_0

    .line 267
    iget-object v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    invoke-direct {p0, v7}, Lcom/uc/paymentsdk/commons/codec/Crypter;->encipher([B)[B

    move-result-object v0

    .line 268
    .local v0, "arrayOfByte":[B
    iget-object v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->out:[B

    iget v8, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    invoke-static {v0, v11, v7, v8, v12}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 269
    iput v11, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 270
    :goto_1
    iget v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-lt v7, v12, :cond_2

    .line 277
    iget-object v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    iget-object v8, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    invoke-static {v7, v11, v8, v11, v12}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 278
    iget v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    .line 279
    iget v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    add-int/lit8 v7, v7, 0x8

    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    .line 280
    iput v11, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 281
    iput-boolean v11, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->header:Z

    .line 282
    return-void

    .line 253
    .end local v0    # "arrayOfByte":[B
    :cond_0
    iget-boolean v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->header:Z

    if-eqz v7, :cond_1

    .line 255
    iget v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 256
    .local v4, "tmp29_26":I
    iget-object v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    .line 257
    .local v3, "tmp29_22":[B
    aget-byte v7, v3, v4

    iget-object v8, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    iget v9, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    aget-byte v8, v8, v9

    xor-int/2addr v7, v8

    int-to-byte v7, v7

    aput-byte v7, v3, v4

    .line 265
    .end local v3    # "tmp29_22":[B
    .end local v4    # "tmp29_26":I
    :goto_2
    iget v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    goto :goto_0

    .line 261
    :cond_1
    iget v6, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 262
    .local v6, "tmp54_51":I
    iget-object v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    .line 263
    .local v5, "tmp54_47":[B
    aget-byte v7, v5, v6

    iget-object v8, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->out:[B

    iget v9, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    iget v10, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/2addr v9, v10

    aget-byte v8, v8, v9

    xor-int/2addr v7, v8

    int-to-byte v7, v7

    aput-byte v7, v5, v6

    goto :goto_2

    .line 272
    .end local v5    # "tmp54_47":[B
    .end local v6    # "tmp54_51":I
    .restart local v0    # "arrayOfByte":[B
    :cond_2
    iget v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    iget v8, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int v2, v7, v8

    .line 273
    .local v2, "tmp137_136":I
    iget-object v1, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->out:[B

    .line 274
    .local v1, "tmp137_125":[B
    aget-byte v7, v1, v2

    iget-object v8, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    iget v9, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    aget-byte v8, v8, v9

    xor-int/2addr v7, v8

    int-to-byte v7, v7

    aput-byte v7, v1, v2

    .line 275
    iget v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    goto :goto_1
.end method

.method private static getUnsignedInt([BII)J
    .locals 8
    .param p0, "paramArrayOfByte"    # [B
    .param p1, "paramInt1"    # I
    .param p2, "paramInt2"    # I

    .prologue
    const/16 v6, 0x8

    .line 23
    const-wide/16 v2, 0x0

    .line 24
    .local v2, "l":J
    const/4 v0, 0x0

    .line 25
    .local v0, "i":I
    if-le p2, v6, :cond_0

    .line 26
    add-int/lit8 v0, p1, 0x8

    .line 29
    :goto_0
    move v1, p1

    .local v1, "j":I
    :goto_1
    if-lt v1, v0, :cond_1

    .line 34
    const-wide/16 v4, -0x1

    and-long/2addr v4, v2

    const/16 v6, 0x20

    ushr-long v6, v2, v6

    or-long/2addr v4, v6

    return-wide v4

    .line 28
    .end local v1    # "j":I
    :cond_0
    add-int v0, p1, p2

    goto :goto_0

    .line 31
    .restart local v1    # "j":I
    :cond_1
    shl-long/2addr v2, v6

    .line 32
    aget-byte v4, p0, v1

    and-int/lit16 v4, v4, 0xff

    int-to-long v4, v4

    or-long/2addr v2, v4

    .line 29
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method private rand()I
    .locals 1

    .prologue
    .line 307
    sget-object v0, Lcom/uc/paymentsdk/commons/codec/Crypter;->random:Ljava/util/Random;

    invoke-virtual {v0}, Ljava/util/Random;->nextInt()I

    move-result v0

    return v0
.end method

.method private writeInt(I)V
    .locals 2
    .param p1, "paramInt"    # I

    .prologue
    .line 237
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    ushr-int/lit8 v1, p1, 0x18

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 238
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    ushr-int/lit8 v1, p1, 0x10

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 239
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    ushr-int/lit8 v1, p1, 0x8

    invoke-virtual {v0, v1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 240
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->baos:Ljava/io/ByteArrayOutputStream;

    invoke-virtual {v0, p1}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 241
    return-void
.end method


# virtual methods
.method public decrypt([BII[B)[B
    .locals 10
    .param p1, "paramArrayOfByte1"    # [B
    .param p2, "paramInt1"    # I
    .param p3, "paramInt2"    # I
    .param p4, "paramArrayOfByte2"    # [B

    .prologue
    const/4 v9, 0x1

    const/4 v5, 0x0

    const/4 v8, 0x0

    const/16 v7, 0x8

    .line 39
    if-nez p4, :cond_0

    move-object v3, v8

    .line 107
    :goto_0
    return-object v3

    .line 41
    :cond_0
    iput v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    iput v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    .line 42
    iput-object p4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    .line 43
    add-int/lit8 v3, p2, 0x8

    new-array v0, v3, [B

    .line 44
    .local v0, "arrayOfByte":[B
    rem-int/lit8 v3, p3, 0x8

    if-nez v3, :cond_1

    const/16 v3, 0x10

    if-ge p3, v3, :cond_2

    :cond_1
    move-object v3, v8

    .line 45
    goto :goto_0

    .line 46
    :cond_2
    invoke-direct {p0, p1, p2}, Lcom/uc/paymentsdk/commons/codec/Crypter;->decipher([BI)[B

    move-result-object v3

    iput-object v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    .line 47
    iget-object v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    aget-byte v3, v3, v5

    and-int/lit8 v3, v3, 0x7

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 48
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    sub-int v3, p3, v3

    const/16 v4, 0xa

    sub-int v1, v3, v4

    .line 49
    .local v1, "i":I
    if-gez v1, :cond_3

    move-object v3, v8

    .line 50
    goto :goto_0

    .line 51
    :cond_3
    move v2, p2

    .local v2, "j":I
    :goto_1
    array-length v3, v0

    if-lt v2, v3, :cond_6

    .line 53
    new-array v3, v1, [B

    iput-object v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->out:[B

    .line 54
    iput v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    .line 55
    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    .line 56
    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->contextStart:I

    .line 57
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 58
    iput v9, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    .line 59
    :cond_4
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    const/4 v4, 0x2

    if-le v3, v4, :cond_7

    .line 72
    const/4 v2, 0x0

    .line 73
    :cond_5
    if-nez v1, :cond_9

    .line 89
    iput v9, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    .line 90
    :goto_2
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    if-lt v3, v7, :cond_b

    .line 107
    iget-object v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->out:[B

    goto :goto_0

    .line 52
    :cond_6
    aput-byte v5, v0, v2

    .line 51
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 61
    :cond_7
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ge v3, v7, :cond_8

    .line 63
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 64
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    .line 66
    :cond_8
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ne v3, v7, :cond_4

    .line 68
    move-object v0, p1

    .line 69
    invoke-direct {p0, p1, p2, p3}, Lcom/uc/paymentsdk/commons/codec/Crypter;->decrypt8Bytes([BII)Z

    move-result v3

    if-nez v3, :cond_4

    move-object v3, v8

    .line 70
    goto :goto_0

    .line 75
    :cond_9
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ge v3, v7, :cond_a

    .line 77
    iget-object v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->out:[B

    iget v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    add-int/2addr v4, p2

    iget v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/2addr v4, v5

    aget-byte v4, v0, v4

    iget-object v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    iget v6, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    aget-byte v5, v5, v6

    xor-int/2addr v4, v5

    int-to-byte v4, v4

    aput-byte v4, v3, v2

    .line 78
    add-int/lit8 v2, v2, 0x1

    .line 79
    add-int/lit8 v1, v1, -0x1

    .line 80
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 82
    :cond_a
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ne v3, v7, :cond_5

    .line 84
    move-object v0, p1

    .line 85
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    sub-int/2addr v3, v7

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    .line 86
    invoke-direct {p0, p1, p2, p3}, Lcom/uc/paymentsdk/commons/codec/Crypter;->decrypt8Bytes([BII)Z

    move-result v3

    if-nez v3, :cond_5

    move-object v3, v8

    .line 87
    goto/16 :goto_0

    .line 92
    :cond_b
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ge v3, v7, :cond_d

    .line 94
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    add-int/2addr v3, p2

    iget v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/2addr v3, v4

    aget-byte v3, v0, v3

    iget-object v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    iget v5, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    aget-byte v4, v4, v5

    xor-int/2addr v3, v4

    if-eqz v3, :cond_c

    move-object v3, v8

    .line 95
    goto/16 :goto_0

    .line 96
    :cond_c
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 98
    :cond_d
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ne v3, v7, :cond_e

    .line 100
    move-object v0, p1

    .line 101
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    .line 102
    invoke-direct {p0, p1, p2, p3}, Lcom/uc/paymentsdk/commons/codec/Crypter;->decrypt8Bytes([BII)Z

    move-result v3

    if-nez v3, :cond_e

    move-object v3, v8

    .line 103
    goto/16 :goto_0

    .line 105
    :cond_e
    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    goto/16 :goto_2
.end method

.method public decrypt([B[B)[B
    .locals 2
    .param p1, "paramArrayOfByte1"    # [B
    .param p2, "paramArrayOfByte2"    # [B

    .prologue
    .line 112
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1, p2}, Lcom/uc/paymentsdk/commons/codec/Crypter;->decrypt([BII[B)[B

    move-result-object v0

    return-object v0
.end method

.method public encrypt([BII[B)[B
    .locals 8
    .param p1, "paramArrayOfByte1"    # [B
    .param p2, "paramInt1"    # I
    .param p3, "paramInt2"    # I
    .param p4, "paramArrayOfByte2"    # [B

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    const/16 v5, 0x8

    .line 117
    if-nez p4, :cond_0

    move-object v2, p1

    .line 172
    :goto_0
    return-object v2

    .line 119
    :cond_0
    new-array v2, v5, [B

    iput-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    .line 120
    new-array v2, v5, [B

    iput-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    .line 121
    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 122
    iput v6, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    .line 123
    iput v6, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->preCrypt:I

    iput v6, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->crypt:I

    .line 124
    iput-object p4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->key:[B

    .line 125
    iput-boolean v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->header:Z

    .line 126
    add-int/lit8 v2, p3, 0xa

    rem-int/lit8 v2, v2, 0x8

    iput v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 127
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-eqz v2, :cond_1

    .line 128
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    sub-int v2, v5, v2

    iput v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 129
    :cond_1
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/2addr v2, p3

    add-int/lit8 v2, v2, 0xa

    new-array v2, v2, [B

    iput-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->out:[B

    .line 130
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    invoke-direct {p0}, Lcom/uc/paymentsdk/commons/codec/Crypter;->rand()I

    move-result v3

    and-int/lit16 v3, v3, 0xf8

    iget v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    or-int/2addr v3, v4

    int-to-byte v3, v3

    aput-byte v3, v2, v6

    .line 131
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-le v0, v2, :cond_4

    .line 133
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    .line 134
    const/4 v0, 0x0

    :goto_2
    if-lt v0, v5, :cond_5

    .line 136
    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    .line 137
    :cond_2
    :goto_3
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    const/4 v3, 0x2

    if-le v2, v3, :cond_6

    .line 148
    move v0, p2

    move v1, v0

    .line 149
    .end local v0    # "i":I
    .local v1, "i":I
    :goto_4
    if-gtz p3, :cond_8

    .line 160
    iput v7, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    .line 161
    :cond_3
    :goto_5
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    const/4 v3, 0x7

    if-le v2, v3, :cond_a

    .line 172
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->out:[B

    goto :goto_0

    .line 132
    .end local v1    # "i":I
    .restart local v0    # "i":I
    :cond_4
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    invoke-direct {p0}, Lcom/uc/paymentsdk/commons/codec/Crypter;->rand()I

    move-result v3

    and-int/lit16 v3, v3, 0xff

    int-to-byte v3, v3

    aput-byte v3, v2, v0

    .line 131
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 135
    :cond_5
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->prePlain:[B

    aput-byte v6, v2, v0

    .line 134
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 139
    :cond_6
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ge v2, v5, :cond_7

    .line 141
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    invoke-direct {p0}, Lcom/uc/paymentsdk/commons/codec/Crypter;->rand()I

    move-result v4

    and-int/lit16 v4, v4, 0xff

    int-to-byte v4, v4

    aput-byte v4, v2, v3

    .line 142
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    .line 144
    :cond_7
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ne v2, v5, :cond_2

    .line 146
    invoke-direct {p0}, Lcom/uc/paymentsdk/commons/codec/Crypter;->encrypt8Bytes()V

    goto :goto_3

    .line 151
    .end local v0    # "i":I
    .restart local v1    # "i":I
    :cond_8
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ge v2, v5, :cond_c

    .line 153
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v0, v1, 0x1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    aget-byte v4, p1, v1

    aput-byte v4, v2, v3

    .line 154
    add-int/lit8 p3, p3, -0x1

    .line 156
    :goto_6
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-eq v2, v5, :cond_9

    move v1, v0

    .line 157
    .end local v0    # "i":I
    .restart local v1    # "i":I
    goto :goto_4

    .line 158
    .end local v1    # "i":I
    .restart local v0    # "i":I
    :cond_9
    invoke-direct {p0}, Lcom/uc/paymentsdk/commons/codec/Crypter;->encrypt8Bytes()V

    move v1, v0

    .end local v0    # "i":I
    .restart local v1    # "i":I
    goto :goto_4

    .line 163
    :cond_a
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ge v2, v5, :cond_b

    .line 165
    iget-object v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->plain:[B

    iget v3, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    add-int/lit8 v4, v3, 0x1

    iput v4, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    aput-byte v6, v2, v3

    .line 166
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->padding:I

    .line 168
    :cond_b
    iget v2, p0, Lcom/uc/paymentsdk/commons/codec/Crypter;->pos:I

    if-ne v2, v5, :cond_3

    .line 170
    invoke-direct {p0}, Lcom/uc/paymentsdk/commons/codec/Crypter;->encrypt8Bytes()V

    goto :goto_5

    :cond_c
    move v0, v1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    goto :goto_6
.end method

.method public encrypt([B[B)[B
    .locals 2
    .param p1, "paramArrayOfByte1"    # [B
    .param p2, "paramArrayOfByte2"    # [B

    .prologue
    .line 177
    const/4 v0, 0x0

    array-length v1, p1

    invoke-virtual {p0, p1, v0, v1, p2}, Lcom/uc/paymentsdk/commons/codec/Crypter;->encrypt([BII[B)[B

    move-result-object v0

    return-object v0
.end method
