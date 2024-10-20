.class public Ldm/Monster;
.super Ljava/lang/Object;
.source "Monster.java"

# interfaces
.implements Lmain/Key_H;


# instance fields
.field public effect:B

.field public effect_time:B

.field public monster:[B

.field public monsterPro:[S


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Lmain/GameRun;III)V
    .registers 16
    .param p1, "data"    # Lmain/GameRun;
    .param p2, "enemy_name"    # I
    .param p3, "enemylevel"    # I
    .param p4, "enemy_no"    # I

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x2

    const/4 v8, 0x0

    const/4 v7, 0x3

    const/4 v6, -0x1

    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    const/16 v1, 0x8

    new-array v1, v1, [S

    iput-object v1, p0, Ldm/Monster;->monsterPro:[S

    .line 18
    const/16 v1, 0x12

    new-array v1, v1, [B

    iput-object v1, p0, Ldm/Monster;->monster:[B

    .line 19
    iget-object v1, p0, Ldm/Monster;->monster:[B

    int-to-byte v2, p2

    aput-byte v2, v1, v8

    .line 20
    iget-object v1, p0, Ldm/Monster;->monster:[B

    int-to-byte v2, p3

    aput-byte v2, v1, v9

    .line 23
    iget-object v1, p1, Lmain/GameRun;->monster_pro:[[B

    aget-object v0, v1, p2

    .line 24
    .local v0, "temp_pro":[B
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/4 v2, 0x6

    aget-byte v2, v0, v2

    aput-byte v2, v1, v7

    .line 25
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/4 v2, 0x4

    const/4 v3, 0x5

    aget-byte v3, v0, v3

    aput-byte v3, v1, v2

    .line 26
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/4 v2, 0x5

    const/16 v3, 0xc

    aget-byte v3, v0, v3

    aput-byte v3, v1, v2

    .line 28
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0x8

    const/16 v3, 0x19

    aput-byte v3, v1, v2

    .line 29
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0x9

    aput-byte v6, v1, v2

    .line 30
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0xa

    aput-byte v6, v1, v2

    .line 31
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0xb

    aput-byte v6, v1, v2

    .line 32
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0xc

    aput-byte v6, v1, v2

    .line 33
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0xd

    aput-byte v6, v1, v2

    .line 34
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0xe

    aput-byte v6, v1, v2

    .line 35
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0xf

    aput-byte v6, v1, v2

    .line 39
    if-ne p4, v6, :cond_f3

    .line 40
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0x10

    iget-object v3, p0, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v7

    mul-int/lit8 v3, v3, 0x2

    add-int/lit8 v3, v3, 0x4

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 41
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0x11

    aput-byte v9, v1, v2

    .line 52
    :cond_83
    :goto_83
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/4 v2, 0x6

    iget-object v3, p0, Ldm/Monster;->monster:[B

    const/4 v4, 0x4

    aget-byte v3, v3, v4

    if-le v3, v7, :cond_15d

    const/16 v3, 0x78

    :goto_8f
    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 53
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S

    aget-byte v2, v0, v8

    const/4 v3, 0x7

    aget-byte v3, v0, v3

    mul-int/2addr v3, p3

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v1, v9

    .line 54
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S

    aget-byte v2, v0, v10

    const/16 v3, 0x8

    aget-byte v3, v0, v3

    mul-int/2addr v3, p3

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v1, v7

    .line 55
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S

    iget-object v2, p0, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v7

    aput-short v2, v1, v10

    .line 56
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S

    iget-object v2, p0, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v9

    aput-short v2, v1, v8

    .line 59
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S

    const/4 v2, 0x4

    aput-short v8, v1, v2

    .line 60
    invoke-virtual {p0, v0}, Ldm/Monster;->setProAFD([B)V

    .line 61
    iget-object v1, p0, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v7

    if-eq v1, v6, :cond_d0

    invoke-virtual {p1, p0}, Lmain/GameRun;->getMagic(Ldm/Monster;)V

    .line 63
    :cond_d0
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B

    aget-byte v1, v1, p2

    if-nez v1, :cond_ea

    .line 64
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B

    aput-byte v10, v1, p2

    .line 65
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B

    const/16 v2, 0x66

    aget-byte v3, v1, v2

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 67
    const-string v1, "\u5ba0\u7269\u56fe\u9274\u5df2\u66f4\u65b0"

    invoke-virtual {p1, v1, v8}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 69
    :cond_ea
    const/4 v1, 0x7

    iput-byte v1, p0, Ldm/Monster;->effect:B

    .line 70
    iput-byte v8, p0, Ldm/Monster;->effect_time:B

    .line 71
    const/4 v0, 0x0

    check-cast v0, [B

    .line 72
    return-void

    .line 42
    :cond_f3
    if-nez p4, :cond_11c

    .line 43
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0x10

    iget-object v3, p0, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v7

    mul-int/lit8 v3, v3, 0x2

    add-int/lit8 v3, v3, 0x3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v9}, Ldm/Ms;->getRandom(I)I

    move-result v4

    add-int/2addr v3, v4

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 44
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0x11

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v7}, Ldm/Ms;->getRandom(I)I

    move-result v3

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    goto/16 :goto_83

    .line 45
    :cond_11c
    if-ne p4, v10, :cond_83

    .line 46
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0x10

    iget-object v3, p0, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v7

    mul-int/lit8 v3, v3, 0x2

    add-int/lit8 v3, v3, 0x3

    .line 47
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v4, 0x64

    invoke-static {v4}, Ldm/Ms;->getRandom(I)I

    move-result v4

    const/16 v5, 0x46

    if-ge v4, v5, :cond_153

    move v4, v10

    :goto_138
    add-int/2addr v3, v4

    int-to-byte v3, v3

    .line 46
    aput-byte v3, v1, v2

    .line 48
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/16 v2, 0x11

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v3, 0x64

    invoke-static {v3}, Ldm/Ms;->getRandom(I)I

    move-result v3

    const/16 v4, 0x46

    if-ge v3, v4, :cond_155

    move v3, v9

    :goto_14e
    int-to-byte v3, v3

    aput-byte v3, v1, v2

    goto/16 :goto_83

    :cond_153
    move v4, v8

    .line 47
    goto :goto_138

    .line 48
    :cond_155
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v9}, Ldm/Ms;->getRandom(I)I

    move-result v3

    goto :goto_14e

    .line 52
    :cond_15d
    const/16 v3, 0x64

    goto/16 :goto_8f
.end method


# virtual methods
.method public evolveMonster(Lmain/GameRun;II)V
    .registers 13
    .param p1, "data"    # Lmain/GameRun;
    .param p2, "enemy_name"    # I
    .param p3, "evolve"    # I

    .prologue
    const/4 v8, 0x5

    const/4 v7, 0x3

    const/4 v6, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x2

    .line 137
    iget-object v1, p0, Ldm/Monster;->monster:[B

    int-to-byte v2, p2

    aput-byte v2, v1, v4

    .line 138
    iget-object v1, p1, Lmain/GameRun;->monster_pro:[[B

    aget-object v0, v1, p2

    .line 142
    .local v0, "temp_pro":[B
    iget-object v1, p0, Ldm/Monster;->monster:[B

    const/4 v2, 0x4

    aget-byte v3, v0, v8

    aput-byte v3, v1, v2

    .line 143
    iget-object v1, p0, Ldm/Monster;->monster:[B

    aget-byte v2, v1, v8

    sub-int/2addr v2, p3

    int-to-byte v2, v2

    aput-byte v2, v1, v8

    .line 144
    invoke-virtual {p0, v0}, Ldm/Monster;->setProAFD([B)V

    .line 145
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S

    aget-byte v2, v0, v4

    const/4 v3, 0x7

    aget-byte v3, v0, v3

    iget-object v4, p0, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v5

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v1, v5

    .line 146
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S

    aget-byte v2, v0, v6

    const/16 v3, 0x8

    aget-byte v3, v0, v3

    iget-object v4, p0, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v5

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v1, v7

    .line 147
    invoke-virtual {p0, p1}, Ldm/Monster;->resetPro(Lmain/GameRun;)V

    .line 148
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S

    iget-object v2, p0, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v7

    aput-short v2, v1, v6

    .line 149
    const/4 v0, 0x0

    check-cast v0, [B

    .line 150
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B

    aget-byte v1, v1, p2

    if-eq v1, v5, :cond_71

    .line 151
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B

    aget-byte v1, v1, p2

    if-nez v1, :cond_6a

    .line 152
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B

    const/16 v2, 0x66

    aget-byte v3, v1, v2

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    .line 153
    :cond_6a
    invoke-virtual {p1}, Lmain/GameRun;->addMonInfoListBH()V

    .line 154
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B

    aput-byte v5, v1, p2

    .line 160
    :cond_71
    return-void
.end method

.method public isBuffRate(I)Z
    .registers 4
    .param p1, "effect_id"    # I

    .prologue
    .line 92
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0x10

    aget-byte v0, v0, v1

    if-eq v0, p1, :cond_12

    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0x11

    aget-byte v0, v0, v1

    if-eq v0, p1, :cond_12

    const/4 v0, 0x0

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x1

    goto :goto_11
.end method

.method public isEffect(I)Z
    .registers 3
    .param p1, "id"    # I

    .prologue
    .line 82
    iget-byte v0, p0, Ldm/Monster;->effect:B

    if-ne v0, p1, :cond_6

    const/4 v0, 0x1

    :goto_5
    return v0

    :cond_6
    const/4 v0, 0x0

    goto :goto_5
.end method

.method public isMonEffect(I)Z
    .registers 3
    .param p1, "id"    # I

    .prologue
    .line 85
    iget-byte v0, p0, Ldm/Monster;->effect:B

    if-ne v0, p1, :cond_a

    iget-byte v0, p0, Ldm/Monster;->effect_time:B

    if-eqz v0, :cond_a

    const/4 v0, 0x1

    :goto_9
    return v0

    :cond_a
    const/4 v0, 0x0

    goto :goto_9
.end method

.method public isMonReel(I)Z
    .registers 4
    .param p1, "reel"    # I

    .prologue
    .line 89
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0xe

    aget-byte v0, v0, v1

    if-eq v0, p1, :cond_12

    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0xf

    aget-byte v0, v0, v1

    if-eq v0, p1, :cond_12

    const/4 v0, 0x0

    :goto_11
    return v0

    :cond_12
    const/4 v0, 0x1

    goto :goto_11
.end method

.method public resetBoss(I)V
    .registers 8
    .param p1, "fealty"    # I

    .prologue
    const/16 v5, 0xe

    const/16 v4, 0xa

    const/16 v3, 0x9

    const/4 v2, 0x4

    .line 124
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0x10

    aput-byte v2, v0, v1

    .line 125
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0x11

    aput-byte v4, v0, v1

    .line 126
    iget-object v0, p0, Ldm/Monster;->monster:[B

    aput-byte v2, v0, v3

    .line 127
    iget-object v0, p0, Ldm/Monster;->monster:[B

    aput-byte v3, v0, v4

    .line 128
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0xb

    aput-byte v5, v0, v1

    .line 129
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0xc

    const/16 v2, 0x13

    aput-byte v2, v0, v1

    .line 130
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0xd

    const/16 v2, 0x18

    aput-byte v2, v0, v1

    .line 131
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0x1e

    aput-byte v1, v0, v5

    .line 132
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0xf

    const/16 v2, 0x30

    aput-byte v2, v0, v1

    .line 133
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/4 v1, 0x6

    int-to-byte v2, p1

    aput-byte v2, v0, v1

    .line 134
    return-void
.end method

.method public resetMonster(III)V
    .registers 8
    .param p1, "skill6"    # I
    .param p2, "skill7"    # I
    .param p3, "fealty"    # I

    .prologue
    .line 116
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0x10

    iget-object v2, p0, Ldm/Monster;->monster:[B

    const/4 v3, 0x3

    aget-byte v2, v2, v3

    mul-int/lit8 v2, v2, 0x2

    add-int/lit8 v2, v2, 0x4

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 117
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0x11

    const/4 v2, 0x2

    aput-byte v2, v0, v1

    .line 118
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0xe

    int-to-byte v2, p1

    aput-byte v2, v0, v1

    .line 119
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/16 v1, 0xf

    int-to-byte v2, p2

    aput-byte v2, v0, v1

    .line 120
    iget-object v0, p0, Ldm/Monster;->monster:[B

    const/4 v1, 0x6

    int-to-byte v2, p3

    aput-byte v2, v0, v1

    .line 121
    return-void
.end method

.method public resetMonster(Lmain/GameRun;I)V
    .registers 6
    .param p1, "data"    # Lmain/GameRun;
    .param p2, "evolve"    # I

    .prologue
    const/4 v0, -0x1

    const/4 v2, 0x5

    .line 97
    if-le p2, v0, :cond_d

    iget-object v0, p0, Ldm/Monster;->monster:[B

    int-to-byte v1, p2

    aput-byte v1, v0, v2

    .line 102
    :cond_9
    :goto_9
    invoke-virtual {p0, p1}, Ldm/Monster;->resetPro(Lmain/GameRun;)V

    .line 103
    return-void

    .line 98
    :cond_d
    if-ne p2, v0, :cond_9

    .line 99
    iget-object v0, p0, Ldm/Monster;->monster:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v1, p0, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    int-to-byte v1, v1

    aput-byte v1, v0, v2

    goto :goto_9
.end method

.method public resetPro(Lmain/GameRun;)V
    .registers 8
    .param p1, "data"    # Lmain/GameRun;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x2

    .line 106
    invoke-virtual {p0, v4}, Ldm/Monster;->isBuffRate(I)Z

    move-result v0

    if-eqz v0, :cond_2f

    .line 107
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S

    aget-short v1, v0, v4

    iget-object v2, p0, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v4

    iget-object v3, p1, Lmain/GameRun;->inhesion:[B

    aget-byte v3, v3, v4

    mul-int/2addr v2, v3

    div-int/lit8 v2, v2, 0x64

    add-int/2addr v1, v2

    int-to-short v1, v1

    aput-short v1, v0, v4

    .line 110
    :cond_1b
    :goto_1b
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v4

    if-ge v0, v5, :cond_25

    iget-object v0, p0, Ldm/Monster;->monsterPro:[S

    aput-short v5, v0, v4

    .line 111
    :cond_25
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x0

    iget-object v2, p0, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v4

    aput-short v2, v0, v1

    .line 112
    return-void

    .line 108
    :cond_2f
    invoke-virtual {p0, v5}, Ldm/Monster;->isBuffRate(I)Z

    move-result v0

    if-eqz v0, :cond_1b

    .line 109
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S

    aget-short v1, v0, v4

    iget-object v2, p0, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v4

    iget-object v3, p1, Lmain/GameRun;->inhesion:[B

    aget-byte v3, v3, v5

    mul-int/2addr v2, v3

    div-int/lit8 v2, v2, 0x64

    add-int/2addr v1, v2

    int-to-short v1, v1

    aput-short v1, v0, v4

    goto :goto_1b
.end method

.method public setProAFD([B)V
    .registers 8
    .param p1, "data"    # [B

    .prologue
    const/4 v5, 0x2

    .line 76
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x5

    aget-byte v2, p1, v5

    const/16 v3, 0x9

    aget-byte v3, p1, v3

    iget-object v4, p0, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v5

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 77
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x6

    const/4 v2, 0x3

    aget-byte v2, p1, v2

    const/16 v3, 0xa

    aget-byte v3, p1, v3

    iget-object v4, p0, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v5

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 78
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x7

    const/4 v2, 0x4

    aget-byte v2, p1, v2

    const/16 v3, 0xb

    aget-byte v3, p1, v3

    iget-object v4, p0, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v5

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 79
    return-void
.end method
