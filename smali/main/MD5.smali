.class public Lmain/MD5;
.super Ljava/lang/Object;
.source "MD5.java"

.field hex_chr:Ljava/lang/String;

.method public constructor <init>()V
  .registers 2
  .prologue
  .line 12
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 24
    const-string v0, "0123456789abcdef"
    iput-object v0, p0, Lmain/MD5;->hex_chr:Ljava/lang/String;
  .line 12
    return-void
.end method

.method private add(II)I
  .parameter "x" # I
  .parameter "y" # I
  .registers 6
  .prologue
    const v1, 2147483647
    const/high16 v2, -32768
  .line 58
    and-int v0, p1, v1
    and-int/2addr v1, p2
    add-int/2addr v0, v1
    and-int v1, p1, v2
    xor-int/2addr v0, v1
  .line 59
    and-int v1, p2, v2
  .line 58
    xor-int/2addr v0, v1
    return v0
.end method

.method private cmn(IIIIII)I
  .parameter "q" # I
  .parameter "a" # I
  .parameter "b" # I
  .parameter "x" # I
  .parameter "s" # I
  .parameter "t" # I
  .registers 9
  .prologue
  .line 74
    invoke-direct { p0, p2, p1 }, Lmain/MD5;->add(II)I
    move-result v0
    invoke-direct { p0, p4, p6 }, Lmain/MD5;->add(II)I
    move-result v1
    invoke-direct { p0, v0, v1 }, Lmain/MD5;->add(II)I
    move-result v0
    invoke-direct { p0, v0, p5 }, Lmain/MD5;->rol(II)I
    move-result v0
    invoke-direct { p0, v0, p3 }, Lmain/MD5;->add(II)I
    move-result v0
    return v0
.end method

.method private ff(IIIIIII)I
  .parameter "a" # I
  .parameter "b" # I
  .parameter "c" # I
  .parameter "d" # I
  .parameter "x" # I
  .parameter "s" # I
  .parameter "t" # I
  .registers 15
  .prologue
  .line 78
    and-int v0, p2, p3
    xor-int/lit8 v1, p2, -1
    and-int/2addr v1, p4
    or-int/2addr v1, v0
    move-object v0, p0
    move v2, p1
    move v3, p2
    move v4, p5
    move v5, p6
    move v6, p7
    invoke-direct/range { v0 .. v6 }, Lmain/MD5;->cmn(IIIIII)I
    move-result v0
    return v0
.end method

.method private gg(IIIIIII)I
  .parameter "a" # I
  .parameter "b" # I
  .parameter "c" # I
  .parameter "d" # I
  .parameter "x" # I
  .parameter "s" # I
  .parameter "t" # I
  .registers 15
  .prologue
  .line 82
    and-int v0, p2, p4
    xor-int/lit8 v1, p4, -1
    and-int/2addr v1, p3
    or-int/2addr v1, v0
    move-object v0, p0
    move v2, p1
    move v3, p2
    move v4, p5
    move v5, p6
    move v6, p7
    invoke-direct/range { v0 .. v6 }, Lmain/MD5;->cmn(IIIIII)I
    move-result v0
    return v0
.end method

.method private hh(IIIIIII)I
  .parameter "a" # I
  .parameter "b" # I
  .parameter "c" # I
  .parameter "d" # I
  .parameter "x" # I
  .parameter "s" # I
  .parameter "t" # I
  .registers 15
  .prologue
  .line 86
    xor-int v0, p2, p3
    xor-int v1, v0, p4
    move-object v0, p0
    move v2, p1
    move v3, p2
    move v4, p5
    move v5, p6
    move v6, p7
    invoke-direct/range { v0 .. v6 }, Lmain/MD5;->cmn(IIIIII)I
    move-result v0
    return v0
.end method

.method private ii(IIIIIII)I
  .parameter "a" # I
  .parameter "b" # I
  .parameter "c" # I
  .parameter "d" # I
  .parameter "x" # I
  .parameter "s" # I
  .parameter "t" # I
  .registers 15
  .prologue
  .line 90
    xor-int/lit8 v0, p4, -1
    or-int/2addr v0, p2
    xor-int v1, p3, v0
    move-object v0, p0
    move v2, p1
    move v3, p2
    move v4, p5
    move v5, p6
    move v6, p7
    invoke-direct/range { v0 .. v6 }, Lmain/MD5;->cmn(IIIIII)I
    move-result v0
    return v0
.end method

.method private rhex(I)Ljava/lang/String;
  .parameter "num" # I
  .registers 7
  .prologue
  .line 27
    const-string v1, ""
  .line 28
  .local v1, "str":Ljava/lang/String;
    const/4 v0, 0
  :L0
  .local v0, "j":I
    const/4 v2, 3
    if-le v0, v2, :L1
  .line 31
    return-object v1
  :L1
  .line 29
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-static { v1 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, p0, Lmain/MD5;->hex_chr:Ljava/lang/String;
    mul-int/lit8 v4, v0, 8
    add-int/lit8 v4, v4, 4
    shr-int v4, p1, v4
    and-int/lit8 v4, v4, 15
    invoke-virtual { v3, v4 }, Ljava/lang/String;->charAt(I)C
    move-result v3
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
  .line 30
    iget-object v3, p0, Lmain/MD5;->hex_chr:Ljava/lang/String;
    mul-int/lit8 v4, v0, 8
    shr-int v4, p1, v4
    and-int/lit8 v4, v4, 15
    invoke-virtual { v3, v4 }, Ljava/lang/String;->charAt(I)C
    move-result v3
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v2
  .line 29
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
  .line 28
    add-int/lit8 v0, v0, 1
    goto :L0
.end method

.method private rol(II)I
  .parameter "num" # I
  .parameter "cnt" # I
  .registers 5
  .prologue
  .line 66
    shl-int v0, p1, p2
    const/16 v1, 32
    sub-int/2addr v1, p2
    ushr-int v1, p1, v1
    or-int/2addr v0, v1
    return v0
.end method

.method private str2blks_MD5(Ljava/lang/String;)[I
  .parameter "str" # Ljava/lang/String;
  .registers 9
  .prologue
  .line 39
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v3
    add-int/lit8 v3, v3, 8
    shr-int/lit8 v3, v3, 6
    add-int/lit8 v2, v3, 1
  .line 40
  .local v2, "nblk":I
    mul-int/lit8 v3, v2, 16
    new-array v0, v3, [I
  .line 41
  .local v0, "blks":[I
    const/4 v1, 0
  .line 42
  .local v1, "i":I
    const/4 v1, 0
  :L0
    mul-int/lit8 v3, v2, 16
    if-lt v1, v3, :L2
  .line 45
    const/4 v1, 0
  :L1
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v3
    if-lt v1, v3, :L3
  .line 48
    shr-int/lit8 v3, v1, 2
    aget v4, v0, v3
    const/16 v5, 128
    rem-int/lit8 v6, v1, 4
    mul-int/lit8 v6, v6, 8
    shl-int/2addr v5, v6
    or-int/2addr v4, v5
    aput v4, v0, v3
  .line 49
    mul-int/lit8 v3, v2, 16
    const/4 v4, 2
    sub-int/2addr v3, v4
    invoke-virtual { p1 }, Ljava/lang/String;->length()I
    move-result v4
    mul-int/lit8 v4, v4, 8
    aput v4, v0, v3
  .line 51
    return-object v0
  :L2
  .line 43
    const/4 v3, 0
    aput v3, v0, v1
  .line 42
    add-int/lit8 v1, v1, 1
    goto :L0
  :L3
  .line 46
    shr-int/lit8 v3, v1, 2
    aget v4, v0, v3
    invoke-virtual { p1, v1 }, Ljava/lang/String;->charAt(I)C
    move-result v5
    rem-int/lit8 v6, v1, 4
    mul-int/lit8 v6, v6, 8
    shl-int/2addr v5, v6
    or-int/2addr v4, v5
    aput v4, v0, v3
  .line 45
    add-int/lit8 v1, v1, 1
    goto :L1
.end method

.method public calcMD5(Ljava/lang/String;)Ljava/lang/String;
  .parameter "str" # Ljava/lang/String;
  .registers 24
  .prologue
  .line 97
    invoke-direct/range { p0 .. p1 }, Lmain/MD5;->str2blks_MD5(Ljava/lang/String;)[I
    move-result-object v21
  .line 98
  .local v21, "x":[I
    const v4, 1732584193
  .line 99
  .local v4, "a":I
    const v5, -271733879
  .line 100
  .local v5, "b":I
    const v6, -1732584194
  .line 101
  .local v6, "c":I
    const v7, 271733878
  .line 103
  .local v7, "d":I
    const/16 v16, 0
  :L0
  .local v16, "i":I
    move-object/from16 v0, v21
    array-length v0, v0
    move v3, v0
    move/from16 v0, v16
    move v1, v3
    if-lt v0, v1, :L1
  .line 182
    new-instance v3, Ljava/lang/StringBuilder;
    move-object/from16 v0, p0
    move v1, v4
    invoke-direct { v0, v1 }, Lmain/MD5;->rhex(I)Ljava/lang/String;
    move-result-object v4
  .end local v4
    invoke-static { v4 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    move-object/from16 v0, p0
    move v1, v5
    invoke-direct { v0, v1 }, Lmain/MD5;->rhex(I)Ljava/lang/String;
    move-result-object v4
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object/from16 v0, p0
    move v1, v6
    invoke-direct { v0, v1 }, Lmain/MD5;->rhex(I)Ljava/lang/String;
    move-result-object v4
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    move-object/from16 v0, p0
    move v1, v7
    invoke-direct { v0, v1 }, Lmain/MD5;->rhex(I)Ljava/lang/String;
    move-result-object v4
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
  :L1
  .line 104
  .restart local v4
    move/from16 v17, v4
  .line 105
  .local v17, "olda":I
    move/from16 v18, v5
  .line 106
  .local v18, "oldb":I
    move/from16 v19, v6
  .line 107
  .local v19, "oldc":I
    move/from16 v20, v7
  .line 109
  .local v20, "oldd":I
    add-int/lit8 v3, v16, 0
    aget v8, v21, v3
    const/4 v9, 7
    const v10, -680876936
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v4
  .line 110
    add-int/lit8 v3, v16, 1
    aget v13, v21, v3
    const/16 v14, 12
    const v15, -389564586
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v7
  .line 111
    add-int/lit8 v3, v16, 2
    aget v13, v21, v3
    const/16 v14, 17
    const v15, 606105819
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v6
  .line 112
    add-int/lit8 v3, v16, 3
    aget v13, v21, v3
    const/16 v14, 22
    const v15, -1044525330
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v5
  .line 113
    add-int/lit8 v3, v16, 4
    aget v8, v21, v3
    const/4 v9, 7
    const v10, -176418897
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v4
  .line 114
    add-int/lit8 v3, v16, 5
    aget v13, v21, v3
    const/16 v14, 12
    const v15, 1200080426
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v7
  .line 115
    add-int/lit8 v3, v16, 6
    aget v13, v21, v3
    const/16 v14, 17
    const v15, -1473231341
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v6
  .line 116
    add-int/lit8 v3, v16, 7
    aget v13, v21, v3
    const/16 v14, 22
    const v15, -45705983
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v5
  .line 117
    add-int/lit8 v3, v16, 8
    aget v8, v21, v3
    const/4 v9, 7
    const v10, 1770035416
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v4
  .line 118
    add-int/lit8 v3, v16, 9
    aget v13, v21, v3
    const/16 v14, 12
    const v15, -1958414417
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v7
  .line 119
    add-int/lit8 v3, v16, 10
    aget v13, v21, v3
    const/16 v14, 17
    const v15, -42063
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v6
  .line 120
    add-int/lit8 v3, v16, 11
    aget v13, v21, v3
    const/16 v14, 22
    const v15, -1990404162
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v5
  .line 121
    add-int/lit8 v3, v16, 12
    aget v8, v21, v3
    const/4 v9, 7
    const v10, 1804603682
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v4
  .line 122
    add-int/lit8 v3, v16, 13
    aget v13, v21, v3
    const/16 v14, 12
    const v15, -40341101
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v7
  .line 123
    add-int/lit8 v3, v16, 14
    aget v13, v21, v3
    const/16 v14, 17
    const v15, -1502002290
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v6
  .line 124
    add-int/lit8 v3, v16, 15
    aget v13, v21, v3
    const/16 v14, 22
    const v15, 1236535329
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ff(IIIIIII)I
    move-result v5
  .line 126
    add-int/lit8 v3, v16, 1
    aget v8, v21, v3
    const/4 v9, 5
    const v10, -165796510
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v4
  .line 127
    add-int/lit8 v3, v16, 6
    aget v13, v21, v3
    const/16 v14, 9
    const v15, -1069501632
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v7
  .line 128
    add-int/lit8 v3, v16, 11
    aget v13, v21, v3
    const/16 v14, 14
    const v15, 643717713
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v6
  .line 129
    add-int/lit8 v3, v16, 0
    aget v13, v21, v3
    const/16 v14, 20
    const v15, -373897302
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v5
  .line 130
    add-int/lit8 v3, v16, 5
    aget v8, v21, v3
    const/4 v9, 5
    const v10, -701558691
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v4
  .line 131
    add-int/lit8 v3, v16, 10
    aget v13, v21, v3
    const/16 v14, 9
    const v15, 38016083
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v7
  .line 132
    add-int/lit8 v3, v16, 15
    aget v13, v21, v3
    const/16 v14, 14
    const v15, -660478335
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v6
  .line 133
    add-int/lit8 v3, v16, 4
    aget v13, v21, v3
    const/16 v14, 20
    const v15, -405537848
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v5
  .line 134
    add-int/lit8 v3, v16, 9
    aget v8, v21, v3
    const/4 v9, 5
    const v10, 568446438
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v4
  .line 135
    add-int/lit8 v3, v16, 14
    aget v13, v21, v3
    const/16 v14, 9
    const v15, -1019803690
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v7
  .line 136
    add-int/lit8 v3, v16, 3
    aget v13, v21, v3
    const/16 v14, 14
    const v15, -187363961
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v6
  .line 137
    add-int/lit8 v3, v16, 8
    aget v13, v21, v3
    const/16 v14, 20
    const v15, 1163531501
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v5
  .line 138
    add-int/lit8 v3, v16, 13
    aget v8, v21, v3
    const/4 v9, 5
    const v10, -1444681467
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v4
  .line 139
    add-int/lit8 v3, v16, 2
    aget v13, v21, v3
    const/16 v14, 9
    const v15, -51403784
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v7
  .line 140
    add-int/lit8 v3, v16, 7
    aget v13, v21, v3
    const/16 v14, 14
    const v15, 1735328473
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v6
  .line 141
    add-int/lit8 v3, v16, 12
    aget v13, v21, v3
    const/16 v14, 20
    const v15, -1926607734
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->gg(IIIIIII)I
    move-result v5
  .line 143
    add-int/lit8 v3, v16, 5
    aget v8, v21, v3
    const/4 v9, 4
    const v10, -378558
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v4
  .line 144
    add-int/lit8 v3, v16, 8
    aget v13, v21, v3
    const/16 v14, 11
    const v15, -2022574463
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v7
  .line 145
    add-int/lit8 v3, v16, 11
    aget v13, v21, v3
    const/16 v14, 16
    const v15, 1839030562
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v6
  .line 146
    add-int/lit8 v3, v16, 14
    aget v13, v21, v3
    const/16 v14, 23
    const v15, -35309556
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v5
  .line 147
    add-int/lit8 v3, v16, 1
    aget v8, v21, v3
    const/4 v9, 4
    const v10, -1530992060
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v4
  .line 148
    add-int/lit8 v3, v16, 4
    aget v13, v21, v3
    const/16 v14, 11
    const v15, 1272893353
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v7
  .line 149
    add-int/lit8 v3, v16, 7
    aget v13, v21, v3
    const/16 v14, 16
    const v15, -155497632
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v6
  .line 150
    add-int/lit8 v3, v16, 10
    aget v13, v21, v3
    const/16 v14, 23
    const v15, -1094730640
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v5
  .line 151
    add-int/lit8 v3, v16, 13
    aget v8, v21, v3
    const/4 v9, 4
    const v10, 681279174
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v4
  .line 152
    add-int/lit8 v3, v16, 0
    aget v13, v21, v3
    const/16 v14, 11
    const v15, -358537222
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v7
  .line 153
    add-int/lit8 v3, v16, 3
    aget v13, v21, v3
    const/16 v14, 16
    const v15, -722521979
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v6
  .line 154
    add-int/lit8 v3, v16, 6
    aget v13, v21, v3
    const/16 v14, 23
    const v15, 76029189
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v5
  .line 155
    add-int/lit8 v3, v16, 9
    aget v8, v21, v3
    const/4 v9, 4
    const v10, -640364487
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v4
  .line 156
    add-int/lit8 v3, v16, 12
    aget v13, v21, v3
    const/16 v14, 11
    const v15, -421815835
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v7
  .line 157
    add-int/lit8 v3, v16, 15
    aget v13, v21, v3
    const/16 v14, 16
    const v15, 530742520
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v6
  .line 158
    add-int/lit8 v3, v16, 2
    aget v13, v21, v3
    const/16 v14, 23
    const v15, -995338651
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->hh(IIIIIII)I
    move-result v5
  .line 160
    add-int/lit8 v3, v16, 0
    aget v8, v21, v3
    const/4 v9, 6
    const v10, -198630844
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v4
  .line 161
    add-int/lit8 v3, v16, 7
    aget v13, v21, v3
    const/16 v14, 10
    const v15, 1126891415
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v7
  .line 162
    add-int/lit8 v3, v16, 14
    aget v13, v21, v3
    const/16 v14, 15
    const v15, -1416354905
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v6
  .line 163
    add-int/lit8 v3, v16, 5
    aget v13, v21, v3
    const/16 v14, 21
    const v15, -57434055
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v5
  .line 164
    add-int/lit8 v3, v16, 12
    aget v8, v21, v3
    const/4 v9, 6
    const v10, 1700485571
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v4
  .line 165
    add-int/lit8 v3, v16, 3
    aget v13, v21, v3
    const/16 v14, 10
    const v15, -1894986606
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v7
  .line 166
    add-int/lit8 v3, v16, 10
    aget v13, v21, v3
    const/16 v14, 15
    const v15, -1051523
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v6
  .line 167
    add-int/lit8 v3, v16, 1
    aget v13, v21, v3
    const/16 v14, 21
    const v15, -2054922799
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v5
  .line 168
    add-int/lit8 v3, v16, 8
    aget v8, v21, v3
    const/4 v9, 6
    const v10, 1873313359
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v4
  .line 169
    add-int/lit8 v3, v16, 15
    aget v13, v21, v3
    const/16 v14, 10
    const v15, -30611744
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v7
  .line 170
    add-int/lit8 v3, v16, 6
    aget v13, v21, v3
    const/16 v14, 15
    const v15, -1560198380
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v6
  .line 171
    add-int/lit8 v3, v16, 13
    aget v13, v21, v3
    const/16 v14, 21
    const v15, 1309151649
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v5
  .line 172
    add-int/lit8 v3, v16, 4
    aget v8, v21, v3
    const/4 v9, 6
    const v10, -145523070
    move-object/from16 v3, p0
    invoke-direct/range { v3 .. v10 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v4
  .line 173
    add-int/lit8 v3, v16, 11
    aget v13, v21, v3
    const/16 v14, 10
    const v15, -1120210379
    move-object/from16 v8, p0
    move v9, v7
    move v10, v4
    move v11, v5
    move v12, v6
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v7
  .line 174
    add-int/lit8 v3, v16, 2
    aget v13, v21, v3
    const/16 v14, 15
    const v15, 718787259
    move-object/from16 v8, p0
    move v9, v6
    move v10, v7
    move v11, v4
    move v12, v5
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v6
  .line 175
    add-int/lit8 v3, v16, 9
    aget v13, v21, v3
    const/16 v14, 21
    const v15, -343485551
    move-object/from16 v8, p0
    move v9, v5
    move v10, v6
    move v11, v7
    move v12, v4
    invoke-direct/range { v8 .. v15 }, Lmain/MD5;->ii(IIIIIII)I
    move-result v5
  .line 177
    move-object/from16 v0, p0
    move v1, v4
    move/from16 v2, v17
    invoke-direct { v0, v1, v2 }, Lmain/MD5;->add(II)I
    move-result v4
  .line 178
    move-object/from16 v0, p0
    move v1, v5
    move/from16 v2, v18
    invoke-direct { v0, v1, v2 }, Lmain/MD5;->add(II)I
    move-result v5
  .line 179
    move-object/from16 v0, p0
    move v1, v6
    move/from16 v2, v19
    invoke-direct { v0, v1, v2 }, Lmain/MD5;->add(II)I
    move-result v6
  .line 180
    move-object/from16 v0, p0
    move v1, v7
    move/from16 v2, v20
    invoke-direct { v0, v1, v2 }, Lmain/MD5;->add(II)I
    move-result v7
  .line 103
    add-int/lit8 v16, v16, 16
    goto/16 :L0
.end method
