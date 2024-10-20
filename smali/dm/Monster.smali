.class public Ldm/Monster;
.super Ljava/lang/Object;
.implements Lmain/Key_H;
.source "Monster.java"

.field public effect:B

.field public effect_time:B

.field public monster:[B

.field public monsterPro:[S

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 73
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public constructor <init>(Lmain/GameRun;III)V
  .parameter "data" # Lmain/GameRun;
  .parameter "enemy_name" # I
  .parameter "enemylevel" # I
  .parameter "enemy_no" # I
  .registers 16
  .prologue
    const/4 v10, 1
    const/4 v9, 2
    const/4 v8, 0
    const/4 v7, 3
    const/4 v6, -1
  .line 16
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 17
    const/16 v1, 8
    new-array v1, v1, [S
    iput-object v1, p0, Ldm/Monster;->monsterPro:[S
  .line 18
    const/16 v1, 18
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
    const/4 v2, 6
    aget-byte v2, v0, v2
    aput-byte v2, v1, v7
  .line 25
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/4 v2, 4
    const/4 v3, 5
    aget-byte v3, v0, v3
    aput-byte v3, v1, v2
  .line 26
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/4 v2, 5
    const/16 v3, 12
    aget-byte v3, v0, v3
    aput-byte v3, v1, v2
  .line 28
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 8
    const/16 v3, 25
    aput-byte v3, v1, v2
  .line 29
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 9
    aput-byte v6, v1, v2
  .line 30
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 10
    aput-byte v6, v1, v2
  .line 31
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 11
    aput-byte v6, v1, v2
  .line 32
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 12
    aput-byte v6, v1, v2
  .line 33
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 13
    aput-byte v6, v1, v2
  .line 34
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 14
    aput-byte v6, v1, v2
  .line 35
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 15
    aput-byte v6, v1, v2
  .line 39
    if-ne p4, v6, :L4
  .line 40
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 16
    iget-object v3, p0, Ldm/Monster;->monster:[B
    aget-byte v3, v3, v7
    mul-int/lit8 v3, v3, 2
    add-int/lit8 v3, v3, 4
    int-to-byte v3, v3
    aput-byte v3, v1, v2
  .line 41
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 17
    aput-byte v9, v1, v2
  :L0
  .line 52
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/4 v2, 6
    iget-object v3, p0, Ldm/Monster;->monster:[B
    const/4 v4, 4
    aget-byte v3, v3, v4
    if-le v3, v7, :L10
    const/16 v3, 120
  :L1
    int-to-byte v3, v3
    aput-byte v3, v1, v2
  .line 53
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S
    aget-byte v2, v0, v8
    const/4 v3, 7
    aget-byte v3, v0, v3
    mul-int/2addr v3, p3
    div-int/lit8 v3, v3, 10
    add-int/2addr v2, v3
    int-to-short v2, v2
    aput-short v2, v1, v9
  .line 54
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S
    aget-byte v2, v0, v10
    const/16 v3, 8
    aget-byte v3, v0, v3
    mul-int/2addr v3, p3
    div-int/lit8 v3, v3, 10
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
    const/4 v2, 4
    aput-short v8, v1, v2
  .line 60
    invoke-virtual { p0, v0 }, Ldm/Monster;->setProAFD([B)V
  .line 61
    iget-object v1, p0, Ldm/Monster;->monster:[B
    aget-byte v1, v1, v7
    if-eq v1, v6, :L2
    invoke-virtual { p1, p0 }, Lmain/GameRun;->getMagic(Ldm/Monster;)V
  :L2
  .line 63
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B
    aget-byte v1, v1, p2
    if-nez v1, :L3
  .line 64
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B
    aput-byte v10, v1, p2
  .line 65
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B
    const/16 v2, 102
    aget-byte v3, v1, v2
    add-int/lit8 v3, v3, 1
    int-to-byte v3, v3
    aput-byte v3, v1, v2
  .line 67
    const-string v1, "\u5ba0\u7269\u56fe\u9274\u5df2\u66f4\u65b0"
    invoke-virtual { p1, v1, v8 }, Lmain/GameRun;->say(Ljava/lang/String;I)V
  :L3
  .line 69
    const/4 v1, 7
    iput-byte v1, p0, Ldm/Monster;->effect:B
  .line 70
    iput-byte v8, p0, Ldm/Monster;->effect_time:B
  .line 71
    const/4 v0, 0
    check-cast v0, [B
  .line 72
    return-void
  :L4
  .line 42
    if-nez p4, :L5
  .line 43
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 16
    iget-object v3, p0, Ldm/Monster;->monster:[B
    aget-byte v3, v3, v7
    mul-int/lit8 v3, v3, 2
    add-int/lit8 v3, v3, 3
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    invoke-static { v9 }, Ldm/Ms;->getRandom(I)I
    move-result v4
    add-int/2addr v3, v4
    int-to-byte v3, v3
    aput-byte v3, v1, v2
  .line 44
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 17
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    invoke-static { v7 }, Ldm/Ms;->getRandom(I)I
    move-result v3
    int-to-byte v3, v3
    aput-byte v3, v1, v2
    goto/16 :L0
  :L5
  .line 45
    if-ne p4, v10, :L0
  .line 46
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 16
    iget-object v3, p0, Ldm/Monster;->monster:[B
    aget-byte v3, v3, v7
    mul-int/lit8 v3, v3, 2
    add-int/lit8 v3, v3, 3
  .line 47
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    const/16 v4, 100
    invoke-static { v4 }, Ldm/Ms;->getRandom(I)I
    move-result v4
    const/16 v5, 70
    if-ge v4, v5, :L8
    move v4, v10
  :L6
    add-int/2addr v3, v4
    int-to-byte v3, v3
  .line 46
    aput-byte v3, v1, v2
  .line 48
    iget-object v1, p0, Ldm/Monster;->monster:[B
    const/16 v2, 17
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    const/16 v3, 100
    invoke-static { v3 }, Ldm/Ms;->getRandom(I)I
    move-result v3
    const/16 v4, 70
    if-ge v3, v4, :L9
    move v3, v9
  :L7
    int-to-byte v3, v3
    aput-byte v3, v1, v2
    goto/16 :L0
  :L8
    move v4, v8
  .line 47
    goto :L6
  :L9
  .line 48
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    invoke-static { v9 }, Ldm/Ms;->getRandom(I)I
    move-result v3
    goto :L7
  :L10
  .line 52
    const/16 v3, 100
    goto/16 :L1
.end method

.method public evolveMonster(Lmain/GameRun;II)V
  .parameter "data" # Lmain/GameRun;
  .parameter "enemy_name" # I
  .parameter "evolve" # I
  .registers 13
  .prologue
    const/4 v8, 5
    const/4 v7, 3
    const/4 v6, 1
    const/4 v4, 0
    const/4 v5, 2
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
    const/4 v2, 4
    aget-byte v3, v0, v8
    aput-byte v3, v1, v2
  .line 143
    iget-object v1, p0, Ldm/Monster;->monster:[B
    aget-byte v2, v1, v8
    sub-int/2addr v2, p3
    int-to-byte v2, v2
    aput-byte v2, v1, v8
  .line 144
    invoke-virtual { p0, v0 }, Ldm/Monster;->setProAFD([B)V
  .line 145
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S
    aget-byte v2, v0, v4
    const/4 v3, 7
    aget-byte v3, v0, v3
    iget-object v4, p0, Ldm/Monster;->monster:[B
    aget-byte v4, v4, v5
    mul-int/2addr v3, v4
    div-int/lit8 v3, v3, 10
    add-int/2addr v2, v3
    int-to-short v2, v2
    aput-short v2, v1, v5
  .line 146
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S
    aget-byte v2, v0, v6
    const/16 v3, 8
    aget-byte v3, v0, v3
    iget-object v4, p0, Ldm/Monster;->monster:[B
    aget-byte v4, v4, v5
    mul-int/2addr v3, v4
    div-int/lit8 v3, v3, 10
    add-int/2addr v2, v3
    int-to-short v2, v2
    aput-short v2, v1, v7
  .line 147
    invoke-virtual { p0, p1 }, Ldm/Monster;->resetPro(Lmain/GameRun;)V
  .line 148
    iget-object v1, p0, Ldm/Monster;->monsterPro:[S
    iget-object v2, p0, Ldm/Monster;->monsterPro:[S
    aget-short v2, v2, v7
    aput-short v2, v1, v6
  .line 149
    const/4 v0, 0
    check-cast v0, [B
  .line 150
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B
    aget-byte v1, v1, p2
    if-eq v1, v5, :L1
  .line 151
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B
    aget-byte v1, v1, p2
    if-nez v1, :L0
  .line 152
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B
    const/16 v2, 102
    aget-byte v3, v1, v2
    add-int/lit8 v3, v3, 1
    int-to-byte v3, v3
    aput-byte v3, v1, v2
  :L0
  .line 153
    invoke-virtual { p1 }, Lmain/GameRun;->addMonInfoListBH()V
  .line 154
    iget-object v1, p1, Lmain/GameRun;->monInfoList:[B
    aput-byte v5, v1, p2
  :L1
  .line 160
    return-void
.end method

.method public isBuffRate(I)Z
  .parameter "effect_id" # I
  .registers 4
  .prologue
  .line 92
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 16
    aget-byte v0, v0, v1
    if-eq v0, p1, :L1
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 17
    aget-byte v0, v0, v1
    if-eq v0, p1, :L1
    const/4 v0, 0
  :L0
    return v0
  :L1
    const/4 v0, 1
    goto :L0
.end method

.method public isEffect(I)Z
  .parameter "id" # I
  .registers 3
  .prologue
  .line 82
    iget-byte v0, p0, Ldm/Monster;->effect:B
    if-ne v0, p1, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public isMonEffect(I)Z
  .parameter "id" # I
  .registers 3
  .prologue
  .line 85
    iget-byte v0, p0, Ldm/Monster;->effect:B
    if-ne v0, p1, :L1
    iget-byte v0, p0, Ldm/Monster;->effect_time:B
    if-eqz v0, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public isMonReel(I)Z
  .parameter "reel" # I
  .registers 4
  .prologue
  .line 89
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 14
    aget-byte v0, v0, v1
    if-eq v0, p1, :L1
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 15
    aget-byte v0, v0, v1
    if-eq v0, p1, :L1
    const/4 v0, 0
  :L0
    return v0
  :L1
    const/4 v0, 1
    goto :L0
.end method

.method public resetBoss(I)V
  .parameter "fealty" # I
  .registers 8
  .prologue
    const/16 v5, 14
    const/16 v4, 10
    const/16 v3, 9
    const/4 v2, 4
  .line 124
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 16
    aput-byte v2, v0, v1
  .line 125
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 17
    aput-byte v4, v0, v1
  .line 126
    iget-object v0, p0, Ldm/Monster;->monster:[B
    aput-byte v2, v0, v3
  .line 127
    iget-object v0, p0, Ldm/Monster;->monster:[B
    aput-byte v3, v0, v4
  .line 128
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 11
    aput-byte v5, v0, v1
  .line 129
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 12
    const/16 v2, 19
    aput-byte v2, v0, v1
  .line 130
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 13
    const/16 v2, 24
    aput-byte v2, v0, v1
  .line 131
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 30
    aput-byte v1, v0, v5
  .line 132
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 15
    const/16 v2, 48
    aput-byte v2, v0, v1
  .line 133
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/4 v1, 6
    int-to-byte v2, p1
    aput-byte v2, v0, v1
  .line 134
    return-void
.end method

.method public resetMonster(III)V
  .parameter "skill6" # I
  .parameter "skill7" # I
  .parameter "fealty" # I
  .registers 8
  .prologue
  .line 116
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 16
    iget-object v2, p0, Ldm/Monster;->monster:[B
    const/4 v3, 3
    aget-byte v2, v2, v3
    mul-int/lit8 v2, v2, 2
    add-int/lit8 v2, v2, 4
    int-to-byte v2, v2
    aput-byte v2, v0, v1
  .line 117
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 17
    const/4 v2, 2
    aput-byte v2, v0, v1
  .line 118
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 14
    int-to-byte v2, p1
    aput-byte v2, v0, v1
  .line 119
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/16 v1, 15
    int-to-byte v2, p2
    aput-byte v2, v0, v1
  .line 120
    iget-object v0, p0, Ldm/Monster;->monster:[B
    const/4 v1, 6
    int-to-byte v2, p3
    aput-byte v2, v0, v1
  .line 121
    return-void
.end method

.method public resetMonster(Lmain/GameRun;I)V
  .parameter "data" # Lmain/GameRun;
  .parameter "evolve" # I
  .registers 6
  .prologue
    const/4 v0, -1
    const/4 v2, 5
  .line 97
    if-le p2, v0, :L1
    iget-object v0, p0, Ldm/Monster;->monster:[B
    int-to-byte v1, p2
    aput-byte v1, v0, v2
  :L0
  .line 102
    invoke-virtual { p0, p1 }, Ldm/Monster;->resetPro(Lmain/GameRun;)V
  .line 103
    return-void
  :L1
  .line 98
    if-ne p2, v0, :L0
  .line 99
    iget-object v0, p0, Ldm/Monster;->monster:[B
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    iget-object v1, p0, Ldm/Monster;->monster:[B
    aget-byte v1, v1, v2
    add-int/lit8 v1, v1, 1
    invoke-static { v1 }, Ldm/Ms;->getRandom(I)I
    move-result v1
    int-to-byte v1, v1
    aput-byte v1, v0, v2
    goto :L0
.end method

.method public resetPro(Lmain/GameRun;)V
  .parameter "data" # Lmain/GameRun;
  .registers 8
  .prologue
    const/4 v5, 1
    const/4 v4, 2
  .line 106
    invoke-virtual { p0, v4 }, Ldm/Monster;->isBuffRate(I)Z
    move-result v0
    if-eqz v0, :L2
  .line 107
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S
    aget-short v1, v0, v4
    iget-object v2, p0, Ldm/Monster;->monsterPro:[S
    aget-short v2, v2, v4
    iget-object v3, p1, Lmain/GameRun;->inhesion:[B
    aget-byte v3, v3, v4
    mul-int/2addr v2, v3
    div-int/lit8 v2, v2, 100
    add-int/2addr v1, v2
    int-to-short v1, v1
    aput-short v1, v0, v4
  :L0
  .line 110
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S
    aget-short v0, v0, v4
    if-ge v0, v5, :L1
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S
    aput-short v5, v0, v4
  :L1
  .line 111
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S
    const/4 v1, 0
    iget-object v2, p0, Ldm/Monster;->monsterPro:[S
    aget-short v2, v2, v4
    aput-short v2, v0, v1
  .line 112
    return-void
  :L2
  .line 108
    invoke-virtual { p0, v5 }, Ldm/Monster;->isBuffRate(I)Z
    move-result v0
    if-eqz v0, :L0
  .line 109
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S
    aget-short v1, v0, v4
    iget-object v2, p0, Ldm/Monster;->monsterPro:[S
    aget-short v2, v2, v4
    iget-object v3, p1, Lmain/GameRun;->inhesion:[B
    aget-byte v3, v3, v5
    mul-int/2addr v2, v3
    div-int/lit8 v2, v2, 100
    add-int/2addr v1, v2
    int-to-short v1, v1
    aput-short v1, v0, v4
    goto :L0
.end method

.method public setProAFD([B)V
  .parameter "data" # [B
  .registers 8
  .prologue
    const/4 v5, 2
  .line 76
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S
    const/4 v1, 5
    aget-byte v2, p1, v5
    const/16 v3, 9
    aget-byte v3, p1, v3
    iget-object v4, p0, Ldm/Monster;->monster:[B
    aget-byte v4, v4, v5
    mul-int/2addr v3, v4
    div-int/lit8 v3, v3, 10
    add-int/2addr v2, v3
    int-to-short v2, v2
    aput-short v2, v0, v1
  .line 77
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S
    const/4 v1, 6
    const/4 v2, 3
    aget-byte v2, p1, v2
    const/16 v3, 10
    aget-byte v3, p1, v3
    iget-object v4, p0, Ldm/Monster;->monster:[B
    aget-byte v4, v4, v5
    mul-int/2addr v3, v4
    div-int/lit8 v3, v3, 10
    add-int/2addr v2, v3
    int-to-short v2, v2
    aput-short v2, v0, v1
  .line 78
    iget-object v0, p0, Ldm/Monster;->monsterPro:[S
    const/4 v1, 7
    const/4 v2, 4
    aget-byte v2, p1, v2
    const/16 v3, 11
    aget-byte v3, p1, v3
    iget-object v4, p0, Ldm/Monster;->monster:[B
    aget-byte v4, v4, v5
    mul-int/2addr v3, v4
    div-int/lit8 v3, v3, 10
    add-int/2addr v2, v3
    int-to-short v2, v2
    aput-short v2, v0, v1
  .line 79
    return-void
.end method
