.class public Ldm/Npc;
.super Ljava/lang/Object;
.implements Lmain/Key_H;
.source "Npc.java"

.field public b_auto:Z

.field public b_check:Z

.field public bdir:Z

.field public brow_action:B

.field public brow_time:B

.field public brow_type:B

.field public dir:B

.field public frame_c:B

.field public frame_num:B

.field public ix:B

.field public iy:B

.field public lastAction:B

.field public now_action:B

.field public now_time:B

.field public npc_num:B

.field public other:[B

.field public speed:B

.field public speed_x:B

.field public speed_y:B

.field public state:B

.field public timeMove:B

.field public x:S

.field public y:S

.method public constructor <init>()V
  .registers 4
  .prologue
    const/4 v0, 1
    const/4 v2, -1
    const/4 v1, 0
  .line 34
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 10
    iput-boolean v0, p0, Ldm/Npc;->b_check:Z
  .line 11
    iput-boolean v1, p0, Ldm/Npc;->b_auto:Z
  .line 12
    iput-boolean v1, p0, Ldm/Npc;->bdir:Z
  .line 15
    iput-byte v1, p0, Ldm/Npc;->npc_num:B
  .line 16
    iput-byte v2, p0, Ldm/Npc;->frame_c:B
  .line 17
    iput-byte v0, p0, Ldm/Npc;->frame_num:B
  .line 21
    const/16 v0, 127
    iput-byte v0, p0, Ldm/Npc;->lastAction:B
  .line 22
    const/4 v0, 5
    iput-byte v0, p0, Ldm/Npc;->speed:B
  .line 25
    iput-byte v2, p0, Ldm/Npc;->brow_type:B
  .line 26
    iput-byte v2, p0, Ldm/Npc;->ix:B
  .line 27
    iput-byte v2, p0, Ldm/Npc;->iy:B
  .line 29
    const/4 v0, 3
    iput-byte v0, p0, Ldm/Npc;->dir:B
  .line 31
    iput-byte v1, p0, Ldm/Npc;->now_time:B
  .line 32
    iput-byte v1, p0, Ldm/Npc;->now_action:B
  .line 37
    return-void
.end method

.method public constructor <init>(I)V
  .parameter "len" # I
  .registers 5
  .prologue
    const/4 v0, 1
    const/4 v2, -1
    const/4 v1, 0
  .line 38
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 10
    iput-boolean v0, p0, Ldm/Npc;->b_check:Z
  .line 11
    iput-boolean v1, p0, Ldm/Npc;->b_auto:Z
  .line 12
    iput-boolean v1, p0, Ldm/Npc;->bdir:Z
  .line 15
    iput-byte v1, p0, Ldm/Npc;->npc_num:B
  .line 16
    iput-byte v2, p0, Ldm/Npc;->frame_c:B
  .line 17
    iput-byte v0, p0, Ldm/Npc;->frame_num:B
  .line 21
    const/16 v0, 127
    iput-byte v0, p0, Ldm/Npc;->lastAction:B
  .line 22
    const/4 v0, 5
    iput-byte v0, p0, Ldm/Npc;->speed:B
  .line 25
    iput-byte v2, p0, Ldm/Npc;->brow_type:B
  .line 26
    iput-byte v2, p0, Ldm/Npc;->ix:B
  .line 27
    iput-byte v2, p0, Ldm/Npc;->iy:B
  .line 29
    const/4 v0, 3
    iput-byte v0, p0, Ldm/Npc;->dir:B
  .line 31
    iput-byte v1, p0, Ldm/Npc;->now_time:B
  .line 32
    iput-byte v1, p0, Ldm/Npc;->now_action:B
  .line 39
    new-array v0, p1, [B
    iput-object v0, p0, Ldm/Npc;->other:[B
  .line 40
    return-void
.end method

.method public getIx()B
  .registers 2
  .prologue
  .line 78
    iget-short v0, p0, Ldm/Npc;->x:S
    div-int/lit8 v0, v0, 20
    int-to-byte v0, v0
    return v0
.end method

.method public getIx_off()B
  .registers 2
  .prologue
  .line 80
    iget-short v0, p0, Ldm/Npc;->x:S
    rem-int/lit8 v0, v0, 20
    int-to-byte v0, v0
    return v0
.end method

.method public getIy()B
  .registers 2
  .prologue
  .line 79
    iget-short v0, p0, Ldm/Npc;->y:S
    div-int/lit8 v0, v0, 20
    int-to-byte v0, v0
    return v0
.end method

.method public getIy_off()B
  .registers 2
  .prologue
  .line 81
    iget-short v0, p0, Ldm/Npc;->y:S
    rem-int/lit8 v0, v0, 20
    int-to-byte v0, v0
    return v0
.end method

.method public setActionNo(Z)V
  .parameter "mode" # Z
  .registers 6
  .prologue
    const/4 v2, 2
    const/4 v1, 1
    const/4 v3, 7
  .line 50
    iget-boolean v0, p0, Ldm/Npc;->bdir:Z
    if-eqz v0, :L1
  :L0
  .line 55
    return-void
  :L1
  .line 51
    iget-byte v0, p0, Ldm/Npc;->dir:B
    if-ne v0, v2, :L5
    iget-object v0, p0, Ldm/Npc;->other:[B
    if-eqz p1, :L4
    const/4 v1, 3
  :L2
    aput-byte v1, v0, v3
  :L3
  .line 54
    iget-object v0, p0, Ldm/Npc;->other:[B
    aget-byte v1, v0, v3
    iget-byte v2, p0, Ldm/Npc;->npc_num:B
    mul-int/lit8 v2, v2, 6
    add-int/2addr v1, v2
    int-to-byte v1, v1
    aput-byte v1, v0, v3
    goto :L0
  :L4
  .line 51
    const/4 v1, 0
    goto :L2
  :L5
  .line 52
    iget-byte v0, p0, Ldm/Npc;->dir:B
    if-ne v0, v1, :L7
    iget-object v0, p0, Ldm/Npc;->other:[B
    if-eqz p1, :L6
    const/4 v1, 4
  :L6
    aput-byte v1, v0, v3
    goto :L3
  :L7
  .line 53
    iget-object v0, p0, Ldm/Npc;->other:[B
    if-eqz p1, :L9
    const/4 v1, 5
  :L8
    aput-byte v1, v0, v3
    goto :L3
  :L9
    move v1, v2
    goto :L8
.end method

.method public setIXY(II)V
  .parameter "_ix" # I
  .parameter "_iy" # I
  .registers 4
  .prologue
  .line 67
    int-to-byte v0, p1
    iput-byte v0, p0, Ldm/Npc;->ix:B
  .line 68
    int-to-byte v0, p2
    iput-byte v0, p0, Ldm/Npc;->iy:B
  .line 69
    return-void
.end method

.method public setIxIy_npc()V
  .registers 4
  .prologue
  .line 44
    iget-object v0, p0, Ldm/Npc;->other:[B
    const/4 v1, 0
    invoke-virtual { p0 }, Ldm/Npc;->getIx()B
    move-result v2
    aput-byte v2, v0, v1
  .line 45
    iget-object v0, p0, Ldm/Npc;->other:[B
    const/4 v1, 1
    invoke-virtual { p0 }, Ldm/Npc;->getIy()B
    move-result v2
    aput-byte v2, v0, v1
  .line 46
    return-void
.end method

.method public setLastAction(ZI)V
  .parameter "_bdir" # Z
  .parameter "_lastAction" # I
  .registers 4
  .prologue
  .line 71
    iput-boolean p1, p0, Ldm/Npc;->bdir:Z
  .line 72
    int-to-byte v0, p2
    iput-byte v0, p0, Ldm/Npc;->lastAction:B
  .line 73
    return-void
.end method

.method public setNpcNum(I)V
  .parameter "length" # I
  .registers 4
  .prologue
  .line 58
    iget-object v0, p0, Ldm/Npc;->other:[B
    const/4 v1, 7
    aget-byte v0, v0, v1
    div-int/lit8 v0, v0, 6
    int-to-byte v0, v0
    iput-byte v0, p0, Ldm/Npc;->npc_num:B
  .line 59
    iget-byte v0, p0, Ldm/Npc;->npc_num:B
    add-int/lit8 v0, v0, 1
    mul-int/lit8 v0, v0, 6
    if-le v0, p1, :L0
    const/4 v0, 0
    iput-byte v0, p0, Ldm/Npc;->npc_num:B
  :L0
  .line 60
    return-void
.end method

.method public setSpeedXY(II)V
  .parameter "_speed_x" # I
  .parameter "_speed_y" # I
  .registers 4
  .prologue
  .line 63
    int-to-byte v0, p1
    iput-byte v0, p0, Ldm/Npc;->speed_x:B
  .line 64
    int-to-byte v0, p2
    iput-byte v0, p0, Ldm/Npc;->speed_y:B
  .line 65
    return-void
.end method

.method public setXY(IIII)V
  .parameter "ix" # I
  .parameter "iy" # I
  .parameter "offx" # I
  .parameter "offy" # I
  .registers 6
  .prologue
  .line 75
    mul-int/lit8 v0, p1, 20
    add-int/2addr v0, p3
    int-to-short v0, v0
    iput-short v0, p0, Ldm/Npc;->x:S
  .line 76
    mul-int/lit8 v0, p2, 20
    add-int/2addr v0, p4
    int-to-short v0, v0
    iput-short v0, p0, Ldm/Npc;->y:S
  .line 77
    return-void
.end method

.method public setXY_npc()V
  .registers 5
  .prologue
    const/4 v3, 0
  .line 42
    iget-object v0, p0, Ldm/Npc;->other:[B
    aget-byte v0, v0, v3
    iget-object v1, p0, Ldm/Npc;->other:[B
    const/4 v2, 1
    aget-byte v1, v1, v2
    invoke-virtual { p0, v0, v1, v3, v3 }, Ldm/Npc;->setXY(IIII)V
    return-void
.end method
