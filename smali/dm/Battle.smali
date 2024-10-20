.class public Ldm/Battle;
.super Ljava/lang/Object;
.source "Battle.java"


# instance fields
.field public act_num:B

.field public action:B

.field public b_renascence:Z

.field public baoji:B

.field public bg_id:B

.field public cThrow:[S

.field public ceff:[B

.field public cexp:S

.field public chp:S

.field public countS:[B

.field public dead:B

.field public fs_level:B

.field public hit:[[S

.field public mon:[Ldm/Monster;

.field public now_id:B

.field public rate_off:B

.field public skill:B

.field public throw_state:B


# direct methods
.method public constructor <init>([Ldm/Monster;)V
    .locals 2
    .param p1, "_mon"    # [Ldm/Monster;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const/4 v0, -0x1

    iput-byte v0, p0, Ldm/Battle;->throw_state:B

    .line 17
    const/16 v0, 0xa

    new-array v0, v0, [B

    iput-object v0, p0, Ldm/Battle;->countS:[B

    .line 20
    const/4 v0, 0x6

    new-array v0, v0, [B

    iput-object v0, p0, Ldm/Battle;->ceff:[B

    .line 23
    const/4 v0, 0x4

    new-array v0, v0, [S

    iput-object v0, p0, Ldm/Battle;->cThrow:[S

    .line 27
    const/4 v0, 0x3

    const/4 v1, 0x5

    filled-new-array {v0, v1}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[S

    iput-object v0, p0, Ldm/Battle;->hit:[[S

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Ldm/Battle;->b_renascence:Z

    .line 32
    const/4 v0, 0x1

    iput-byte v0, p0, Ldm/Battle;->act_num:B

    .line 33
    iput-object p1, p0, Ldm/Battle;->mon:[Ldm/Monster;

    .line 34
    return-void
.end method


# virtual methods
.method public addHit(III)V
    .locals 4
    .param p1, "h"    # I
    .param p2, "type"    # I
    .param p3, "i"    # I

    .prologue
    const/4 v3, 0x0

    .line 42
    iget-object v0, p0, Ldm/Battle;->hit:[[S

    aget-object v0, v0, p3

    int-to-short v1, p2

    aput-short v1, v0, v3

    .line 43
    iget-object v0, p0, Ldm/Battle;->hit:[[S

    aget-object v0, v0, p3

    const/4 v1, 0x1

    aget-short v2, v0, v1

    add-int/2addr v2, p1

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 44
    iget-object v0, p0, Ldm/Battle;->hit:[[S

    aget-object v0, v0, p3

    const/4 v1, 0x2

    aput-short v3, v0, v1

    .line 45
    iget-object v0, p0, Ldm/Battle;->hit:[[S

    aget-object v0, v0, p3

    const/4 v1, 0x3

    aput-short v3, v0, v1

    .line 46
    iget-object v0, p0, Ldm/Battle;->hit:[[S

    aget-object v0, v0, p3

    const/4 v1, 0x4

    aput-short v3, v0, v1

    .line 47
    return-void
.end method

.method public getMon()Ldm/Monster;
    .locals 2

    .prologue
    .line 35
    iget-object v0, p0, Ldm/Battle;->mon:[Ldm/Monster;

    iget-byte v1, p0, Ldm/Battle;->now_id:B

    aget-object v0, v0, v1

    return-object v0
.end method

.method public initHit()V
    .locals 4

    .prologue
    .line 37
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-object v1, p0, Ldm/Battle;->hit:[[S

    array-length v1, v1

    if-lt v0, v1, :cond_0

    .line 39
    return-void

    .line 38
    :cond_0
    iget-object v1, p0, Ldm/Battle;->hit:[[S

    aget-object v1, v1, v0

    const/4 v2, 0x1

    const/4 v3, 0x0

    aput-short v3, v1, v2

    .line 37
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method
