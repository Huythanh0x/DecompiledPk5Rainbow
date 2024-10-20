.class public Lmain/MD5;
.super Ljava/lang/Object;
.source "MD5.java"


# instance fields
.field hex_chr:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    const-string v0, "0123456789abcdef"

    iput-object v0, p0, Lmain/MD5;->hex_chr:Ljava/lang/String;

    .line 12
    return-void
.end method

.method private add(II)I
    .registers 6
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    const v1, 0x7fffffff

    const/high16 v2, -0x80000000

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
    .registers 9
    .param p1, "q"    # I
    .param p2, "a"    # I
    .param p3, "b"    # I
    .param p4, "x"    # I
    .param p5, "s"    # I
    .param p6, "t"    # I

    .prologue
    .line 74
    invoke-direct {p0, p2, p1}, Lmain/MD5;->add(II)I

    move-result v0

    invoke-direct {p0, p4, p6}, Lmain/MD5;->add(II)I

    move-result v1

    invoke-direct {p0, v0, v1}, Lmain/MD5;->add(II)I

    move-result v0

    invoke-direct {p0, v0, p5}, Lmain/MD5;->rol(II)I

    move-result v0

    invoke-direct {p0, v0, p3}, Lmain/MD5;->add(II)I

    move-result v0

    return v0
.end method

.method private ff(IIIIIII)I
    .registers 15
    .param p1, "a"    # I
    .param p2, "b"    # I
    .param p3, "c"    # I
    .param p4, "d"    # I
    .param p5, "x"    # I
    .param p6, "s"    # I
    .param p7, "t"    # I

    .prologue
    .line 78
    and-int v0, p2, p3

    xor-int/lit8 v1, p2, -0x1

    and-int/2addr v1, p4

    or-int/2addr v1, v0

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p5

    move v5, p6

    move v6, p7

    invoke-direct/range {v0 .. v6}, Lmain/MD5;->cmn(IIIIII)I

    move-result v0

    return v0
.end method

.method private gg(IIIIIII)I
    .registers 15
    .param p1, "a"    # I
    .param p2, "b"    # I
    .param p3, "c"    # I
    .param p4, "d"    # I
    .param p5, "x"    # I
    .param p6, "s"    # I
    .param p7, "t"    # I

    .prologue
    .line 82
    and-int v0, p2, p4

    xor-int/lit8 v1, p4, -0x1

    and-int/2addr v1, p3

    or-int/2addr v1, v0

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p5

    move v5, p6

    move v6, p7

    invoke-direct/range {v0 .. v6}, Lmain/MD5;->cmn(IIIIII)I

    move-result v0

    return v0
.end method

.method private hh(IIIIIII)I
    .registers 15
    .param p1, "a"    # I
    .param p2, "b"    # I
    .param p3, "c"    # I
    .param p4, "d"    # I
    .param p5, "x"    # I
    .param p6, "s"    # I
    .param p7, "t"    # I

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

    invoke-direct/range {v0 .. v6}, Lmain/MD5;->cmn(IIIIII)I

    move-result v0

    return v0
.end method

.method private ii(IIIIIII)I
    .registers 15
    .param p1, "a"    # I
    .param p2, "b"    # I
    .param p3, "c"    # I
    .param p4, "d"    # I
    .param p5, "x"    # I
    .param p6, "s"    # I
    .param p7, "t"    # I

    .prologue
    .line 90
    xor-int/lit8 v0, p4, -0x1

    or-int/2addr v0, p2

    xor-int v1, p3, v0

    move-object v0, p0

    move v2, p1

    move v3, p2

    move v4, p5

    move v5, p6

    move v6, p7

    invoke-direct/range {v0 .. v6}, Lmain/MD5;->cmn(IIIIII)I

    move-result v0

    return v0
.end method

.method private rhex(I)Ljava/lang/String;
    .registers 7
    .param p1, "num"    # I

    .prologue
    .line 27
    const-string v1, ""

    .line 28
    .local v1, "str":Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "j":I
    :goto_3
    const/4 v2, 0x3

    if-le v0, v2, :cond_7

    .line 31
    return-object v1

    .line 29
    :cond_7
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lmain/MD5;->hex_chr:Ljava/lang/String;

    mul-int/lit8 v4, v0, 0x8

    add-int/lit8 v4, v4, 0x4

    shr-int v4, p1, v4

    and-int/lit8 v4, v4, 0xf

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 30
    iget-object v3, p0, Lmain/MD5;->hex_chr:Ljava/lang/String;

    mul-int/lit8 v4, v0, 0x8

    shr-int v4, p1, v4

    and-int/lit8 v4, v4, 0xf

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 29
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 28
    add-int/lit8 v0, v0, 0x1

    goto :goto_3
.end method

.method private rol(II)I
    .registers 5
    .param p1, "num"    # I
    .param p2, "cnt"    # I

    .prologue
    .line 66
    shl-int v0, p1, p2

    const/16 v1, 0x20

    sub-int/2addr v1, p2

    ushr-int v1, p1, v1

    or-int/2addr v0, v1

    return v0
.end method

.method private str2blks_MD5(Ljava/lang/String;)[I
    .registers 9
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, 0x8

    shr-int/lit8 v3, v3, 0x6

    add-int/lit8 v2, v3, 0x1

    .line 40
    .local v2, "nblk":I
    mul-int/lit8 v3, v2, 0x10

    new-array v0, v3, [I

    .line 41
    .local v0, "blks":[I
    const/4 v1, 0x0

    .line 42
    .local v1, "i":I
    const/4 v1, 0x0

    :goto_10
    mul-int/lit8 v3, v2, 0x10

    if-lt v1, v3, :cond_36

    .line 45
    const/4 v1, 0x0

    :goto_15
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    if-lt v1, v3, :cond_3c

    .line 48
    shr-int/lit8 v3, v1, 0x2

    aget v4, v0, v3

    const/16 v5, 0x80

    rem-int/lit8 v6, v1, 0x4

    mul-int/lit8 v6, v6, 0x8

    shl-int/2addr v5, v6

    or-int/2addr v4, v5

    aput v4, v0, v3

    .line 49
    mul-int/lit8 v3, v2, 0x10

    const/4 v4, 0x2

    sub-int/2addr v3, v4

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    mul-int/lit8 v4, v4, 0x8

    aput v4, v0, v3

    .line 51
    return-object v0

    .line 43
    :cond_36
    const/4 v3, 0x0

    aput v3, v0, v1

    .line 42
    add-int/lit8 v1, v1, 0x1

    goto :goto_10

    .line 46
    :cond_3c
    shr-int/lit8 v3, v1, 0x2

    aget v4, v0, v3

    invoke-virtual {p1, v1}, Ljava/lang/String;->charAt(I)C

    move-result v5

    rem-int/lit8 v6, v1, 0x4

    mul-int/lit8 v6, v6, 0x8

    shl-int/2addr v5, v6

    or-int/2addr v4, v5

    aput v4, v0, v3

    .line 45
    add-int/lit8 v1, v1, 0x1

    goto :goto_15
.end method


# virtual methods
.method public calcMD5(Ljava/lang/String;)Ljava/lang/String;
    .registers 24
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 97
    invoke-direct/range {p0 .. p1}, Lmain/MD5;->str2blks_MD5(Ljava/lang/String;)[I

    move-result-object v21

    .line 98
    .local v21, "x":[I
    const v4, 0x67452301

    .line 99
    .local v4, "a":I
    const v5, -0x10325477

    .line 100
    .local v5, "b":I
    const v6, -0x67452302

    .line 101
    .local v6, "c":I
    const v7, 0x10325476

    .line 103
    .local v7, "d":I
    const/16 v16, 0x0

    .local v16, "i":I
    :goto_12
    move-object/from16 v0, v21

    array-length v0, v0

    move v3, v0

    move/from16 v0, v16

    move v1, v3

    if-lt v0, v1, :cond_51

    .line 182
    new-instance v3, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    move v1, v4

    invoke-direct {v0, v1}, Lmain/MD5;->rhex(I)Ljava/lang/String;

    move-result-object v4

    .end local v4    # "a":I
    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/MD5;->rhex(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    move v1, v6

    invoke-direct {v0, v1}, Lmain/MD5;->rhex(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    move v1, v7

    invoke-direct {v0, v1}, Lmain/MD5;->rhex(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3

    .line 104
    .restart local v4    # "a":I
    :cond_51
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
    add-int/lit8 v3, v16, 0x0

    aget v8, v21, v3

    const/4 v9, 0x7

    const v10, -0x28955b88

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->ff(IIIIIII)I

    move-result v4

    .line 110
    add-int/lit8 v3, v16, 0x1

    aget v13, v21, v3

    const/16 v14, 0xc

    const v15, -0x173848aa

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v7

    .line 111
    add-int/lit8 v3, v16, 0x2

    aget v13, v21, v3

    const/16 v14, 0x11

    const v15, 0x242070db

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v6

    .line 112
    add-int/lit8 v3, v16, 0x3

    aget v13, v21, v3

    const/16 v14, 0x16

    const v15, -0x3e423112

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v5

    .line 113
    add-int/lit8 v3, v16, 0x4

    aget v8, v21, v3

    const/4 v9, 0x7

    const v10, -0xa83f051

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->ff(IIIIIII)I

    move-result v4

    .line 114
    add-int/lit8 v3, v16, 0x5

    aget v13, v21, v3

    const/16 v14, 0xc

    const v15, 0x4787c62a

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v7

    .line 115
    add-int/lit8 v3, v16, 0x6

    aget v13, v21, v3

    const/16 v14, 0x11

    const v15, -0x57cfb9ed

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v6

    .line 116
    add-int/lit8 v3, v16, 0x7

    aget v13, v21, v3

    const/16 v14, 0x16

    const v15, -0x2b96aff

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v5

    .line 117
    add-int/lit8 v3, v16, 0x8

    aget v8, v21, v3

    const/4 v9, 0x7

    const v10, 0x698098d8

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->ff(IIIIIII)I

    move-result v4

    .line 118
    add-int/lit8 v3, v16, 0x9

    aget v13, v21, v3

    const/16 v14, 0xc

    const v15, -0x74bb0851

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v7

    .line 119
    add-int/lit8 v3, v16, 0xa

    aget v13, v21, v3

    const/16 v14, 0x11

    const v15, -0xa44f

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v6

    .line 120
    add-int/lit8 v3, v16, 0xb

    aget v13, v21, v3

    const/16 v14, 0x16

    const v15, -0x76a32842

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v5

    .line 121
    add-int/lit8 v3, v16, 0xc

    aget v8, v21, v3

    const/4 v9, 0x7

    const v10, 0x6b901122

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->ff(IIIIIII)I

    move-result v4

    .line 122
    add-int/lit8 v3, v16, 0xd

    aget v13, v21, v3

    const/16 v14, 0xc

    const v15, -0x2678e6d

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v7

    .line 123
    add-int/lit8 v3, v16, 0xe

    aget v13, v21, v3

    const/16 v14, 0x11

    const v15, -0x5986bc72

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v6

    .line 124
    add-int/lit8 v3, v16, 0xf

    aget v13, v21, v3

    const/16 v14, 0x16

    const v15, 0x49b40821

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ff(IIIIIII)I

    move-result v5

    .line 126
    add-int/lit8 v3, v16, 0x1

    aget v8, v21, v3

    const/4 v9, 0x5

    const v10, -0x9e1da9e

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->gg(IIIIIII)I

    move-result v4

    .line 127
    add-int/lit8 v3, v16, 0x6

    aget v13, v21, v3

    const/16 v14, 0x9

    const v15, -0x3fbf4cc0

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v7

    .line 128
    add-int/lit8 v3, v16, 0xb

    aget v13, v21, v3

    const/16 v14, 0xe

    const v15, 0x265e5a51

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v6

    .line 129
    add-int/lit8 v3, v16, 0x0

    aget v13, v21, v3

    const/16 v14, 0x14

    const v15, -0x16493856

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v5

    .line 130
    add-int/lit8 v3, v16, 0x5

    aget v8, v21, v3

    const/4 v9, 0x5

    const v10, -0x29d0efa3

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->gg(IIIIIII)I

    move-result v4

    .line 131
    add-int/lit8 v3, v16, 0xa

    aget v13, v21, v3

    const/16 v14, 0x9

    const v15, 0x2441453

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v7

    .line 132
    add-int/lit8 v3, v16, 0xf

    aget v13, v21, v3

    const/16 v14, 0xe

    const v15, -0x275e197f

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v6

    .line 133
    add-int/lit8 v3, v16, 0x4

    aget v13, v21, v3

    const/16 v14, 0x14

    const v15, -0x182c0438

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v5

    .line 134
    add-int/lit8 v3, v16, 0x9

    aget v8, v21, v3

    const/4 v9, 0x5

    const v10, 0x21e1cde6

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->gg(IIIIIII)I

    move-result v4

    .line 135
    add-int/lit8 v3, v16, 0xe

    aget v13, v21, v3

    const/16 v14, 0x9

    const v15, -0x3cc8f82a

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v7

    .line 136
    add-int/lit8 v3, v16, 0x3

    aget v13, v21, v3

    const/16 v14, 0xe

    const v15, -0xb2af279

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v6

    .line 137
    add-int/lit8 v3, v16, 0x8

    aget v13, v21, v3

    const/16 v14, 0x14

    const v15, 0x455a14ed

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v5

    .line 138
    add-int/lit8 v3, v16, 0xd

    aget v8, v21, v3

    const/4 v9, 0x5

    const v10, -0x561c16fb

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->gg(IIIIIII)I

    move-result v4

    .line 139
    add-int/lit8 v3, v16, 0x2

    aget v13, v21, v3

    const/16 v14, 0x9

    const v15, -0x3105c08

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v7

    .line 140
    add-int/lit8 v3, v16, 0x7

    aget v13, v21, v3

    const/16 v14, 0xe

    const v15, 0x676f02d9

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v6

    .line 141
    add-int/lit8 v3, v16, 0xc

    aget v13, v21, v3

    const/16 v14, 0x14

    const v15, -0x72d5b376

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->gg(IIIIIII)I

    move-result v5

    .line 143
    add-int/lit8 v3, v16, 0x5

    aget v8, v21, v3

    const/4 v9, 0x4

    const v10, -0x5c6be

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->hh(IIIIIII)I

    move-result v4

    .line 144
    add-int/lit8 v3, v16, 0x8

    aget v13, v21, v3

    const/16 v14, 0xb

    const v15, -0x788e097f

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v7

    .line 145
    add-int/lit8 v3, v16, 0xb

    aget v13, v21, v3

    const/16 v14, 0x10

    const v15, 0x6d9d6122

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v6

    .line 146
    add-int/lit8 v3, v16, 0xe

    aget v13, v21, v3

    const/16 v14, 0x17

    const v15, -0x21ac7f4

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v5

    .line 147
    add-int/lit8 v3, v16, 0x1

    aget v8, v21, v3

    const/4 v9, 0x4

    const v10, -0x5b4115bc

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->hh(IIIIIII)I

    move-result v4

    .line 148
    add-int/lit8 v3, v16, 0x4

    aget v13, v21, v3

    const/16 v14, 0xb

    const v15, 0x4bdecfa9    # 2.9204306E7f

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v7

    .line 149
    add-int/lit8 v3, v16, 0x7

    aget v13, v21, v3

    const/16 v14, 0x10

    const v15, -0x944b4a0

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v6

    .line 150
    add-int/lit8 v3, v16, 0xa

    aget v13, v21, v3

    const/16 v14, 0x17

    const v15, -0x41404390

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v5

    .line 151
    add-int/lit8 v3, v16, 0xd

    aget v8, v21, v3

    const/4 v9, 0x4

    const v10, 0x289b7ec6

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->hh(IIIIIII)I

    move-result v4

    .line 152
    add-int/lit8 v3, v16, 0x0

    aget v13, v21, v3

    const/16 v14, 0xb

    const v15, -0x155ed806

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v7

    .line 153
    add-int/lit8 v3, v16, 0x3

    aget v13, v21, v3

    const/16 v14, 0x10

    const v15, -0x2b10cf7b

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v6

    .line 154
    add-int/lit8 v3, v16, 0x6

    aget v13, v21, v3

    const/16 v14, 0x17

    const v15, 0x4881d05    # 3.2000097E-36f

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v5

    .line 155
    add-int/lit8 v3, v16, 0x9

    aget v8, v21, v3

    const/4 v9, 0x4

    const v10, -0x262b2fc7

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->hh(IIIIIII)I

    move-result v4

    .line 156
    add-int/lit8 v3, v16, 0xc

    aget v13, v21, v3

    const/16 v14, 0xb

    const v15, -0x1924661b

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v7

    .line 157
    add-int/lit8 v3, v16, 0xf

    aget v13, v21, v3

    const/16 v14, 0x10

    const v15, 0x1fa27cf8

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v6

    .line 158
    add-int/lit8 v3, v16, 0x2

    aget v13, v21, v3

    const/16 v14, 0x17

    const v15, -0x3b53a99b

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->hh(IIIIIII)I

    move-result v5

    .line 160
    add-int/lit8 v3, v16, 0x0

    aget v8, v21, v3

    const/4 v9, 0x6

    const v10, -0xbd6ddbc

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->ii(IIIIIII)I

    move-result v4

    .line 161
    add-int/lit8 v3, v16, 0x7

    aget v13, v21, v3

    const/16 v14, 0xa

    const v15, 0x432aff97

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v7

    .line 162
    add-int/lit8 v3, v16, 0xe

    aget v13, v21, v3

    const/16 v14, 0xf

    const v15, -0x546bdc59

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v6

    .line 163
    add-int/lit8 v3, v16, 0x5

    aget v13, v21, v3

    const/16 v14, 0x15

    const v15, -0x36c5fc7

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v5

    .line 164
    add-int/lit8 v3, v16, 0xc

    aget v8, v21, v3

    const/4 v9, 0x6

    const v10, 0x655b59c3

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->ii(IIIIIII)I

    move-result v4

    .line 165
    add-int/lit8 v3, v16, 0x3

    aget v13, v21, v3

    const/16 v14, 0xa

    const v15, -0x70f3336e

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v7

    .line 166
    add-int/lit8 v3, v16, 0xa

    aget v13, v21, v3

    const/16 v14, 0xf

    const v15, -0x100b83

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v6

    .line 167
    add-int/lit8 v3, v16, 0x1

    aget v13, v21, v3

    const/16 v14, 0x15

    const v15, -0x7a7ba22f

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v5

    .line 168
    add-int/lit8 v3, v16, 0x8

    aget v8, v21, v3

    const/4 v9, 0x6

    const v10, 0x6fa87e4f

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->ii(IIIIIII)I

    move-result v4

    .line 169
    add-int/lit8 v3, v16, 0xf

    aget v13, v21, v3

    const/16 v14, 0xa

    const v15, -0x1d31920

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v7

    .line 170
    add-int/lit8 v3, v16, 0x6

    aget v13, v21, v3

    const/16 v14, 0xf

    const v15, -0x5cfebcec

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v6

    .line 171
    add-int/lit8 v3, v16, 0xd

    aget v13, v21, v3

    const/16 v14, 0x15

    const v15, 0x4e0811a1    # 5.707142E8f

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v5

    .line 172
    add-int/lit8 v3, v16, 0x4

    aget v8, v21, v3

    const/4 v9, 0x6

    const v10, -0x8ac817e

    move-object/from16 v3, p0

    invoke-direct/range {v3 .. v10}, Lmain/MD5;->ii(IIIIIII)I

    move-result v4

    .line 173
    add-int/lit8 v3, v16, 0xb

    aget v13, v21, v3

    const/16 v14, 0xa

    const v15, -0x42c50dcb

    move-object/from16 v8, p0

    move v9, v7

    move v10, v4

    move v11, v5

    move v12, v6

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v7

    .line 174
    add-int/lit8 v3, v16, 0x2

    aget v13, v21, v3

    const/16 v14, 0xf

    const v15, 0x2ad7d2bb

    move-object/from16 v8, p0

    move v9, v6

    move v10, v7

    move v11, v4

    move v12, v5

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v6

    .line 175
    add-int/lit8 v3, v16, 0x9

    aget v13, v21, v3

    const/16 v14, 0x15

    const v15, -0x14792c6f

    move-object/from16 v8, p0

    move v9, v5

    move v10, v6

    move v11, v7

    move v12, v4

    invoke-direct/range {v8 .. v15}, Lmain/MD5;->ii(IIIIIII)I

    move-result v5

    .line 177
    move-object/from16 v0, p0

    move v1, v4

    move/from16 v2, v17

    invoke-direct {v0, v1, v2}, Lmain/MD5;->add(II)I

    move-result v4

    .line 178
    move-object/from16 v0, p0

    move v1, v5

    move/from16 v2, v18

    invoke-direct {v0, v1, v2}, Lmain/MD5;->add(II)I

    move-result v5

    .line 179
    move-object/from16 v0, p0

    move v1, v6

    move/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lmain/MD5;->add(II)I

    move-result v6

    .line 180
    move-object/from16 v0, p0

    move v1, v7

    move/from16 v2, v20

    invoke-direct {v0, v1, v2}, Lmain/MD5;->add(II)I

    move-result v7

    .line 103
    add-int/lit8 v16, v16, 0x10

    goto/16 :goto_12
.end method
