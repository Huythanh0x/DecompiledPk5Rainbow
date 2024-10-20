.class public Ldm/Sprite;
.super Ljava/lang/Object;
.source "Sprite.java"


# instance fields
.field private action_byte:[[[B

.field private action_short:[[[S

.field private frame_byte:[[[B

.field private frame_short:[[[S

.field public img:Ljavax/microedition/lcdui/Image;

.field private module_byte:[[B

.field private module_short:[[S

.field private type:Z


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 5
    const/4 v0, 0x1

    iput-boolean v0, p0, Ldm/Sprite;->type:Z

    .line 7
    iput-object v1, p0, Ldm/Sprite;->module_byte:[[B

    .line 8
    iput-object v1, p0, Ldm/Sprite;->frame_byte:[[[B

    .line 9
    iput-object v1, p0, Ldm/Sprite;->action_byte:[[[B

    .line 12
    iput-object v1, p0, Ldm/Sprite;->module_short:[[S

    .line 13
    iput-object v1, p0, Ldm/Sprite;->frame_short:[[[S

    .line 14
    iput-object v1, p0, Ldm/Sprite;->action_short:[[[S

    .line 17
    invoke-virtual {p0}, Ldm/Sprite;->nullIMFA()V

    return-void
.end method

.method public static Create(Ljavax/microedition/lcdui/Image;[[B[[[B[[[B)Ldm/Sprite;
    .registers 6
    .param p0, "_img"    # Ljavax/microedition/lcdui/Image;
    .param p1, "_module"    # [[B
    .param p2, "_frame"    # [[[B
    .param p3, "_action"    # [[[B

    .prologue
    .line 28
    new-instance v0, Ldm/Sprite;

    invoke-direct {v0}, Ldm/Sprite;-><init>()V

    .line 29
    .local v0, "sp":Ldm/Sprite;
    const/4 v1, 0x1

    iput-boolean v1, v0, Ldm/Sprite;->type:Z

    .line 30
    iput-object p0, v0, Ldm/Sprite;->img:Ljavax/microedition/lcdui/Image;

    .line 31
    iput-object p1, v0, Ldm/Sprite;->module_byte:[[B

    .line 32
    iput-object p2, v0, Ldm/Sprite;->frame_byte:[[[B

    .line 33
    iput-object p3, v0, Ldm/Sprite;->action_byte:[[[B

    .line 34
    return-object v0
.end method

.method public static Create(Ljavax/microedition/lcdui/Image;[[S[[[S[[[S)Ldm/Sprite;
    .registers 6
    .param p0, "_img"    # Ljavax/microedition/lcdui/Image;
    .param p1, "_module"    # [[S
    .param p2, "_frame"    # [[[S
    .param p3, "_action"    # [[[S

    .prologue
    .line 45
    new-instance v0, Ldm/Sprite;

    invoke-direct {v0}, Ldm/Sprite;-><init>()V

    .line 46
    .local v0, "sp":Ldm/Sprite;
    const/4 v1, 0x0

    iput-boolean v1, v0, Ldm/Sprite;->type:Z

    .line 47
    iput-object p0, v0, Ldm/Sprite;->img:Ljavax/microedition/lcdui/Image;

    .line 48
    iput-object p1, v0, Ldm/Sprite;->module_short:[[S

    .line 49
    iput-object p2, v0, Ldm/Sprite;->frame_short:[[[S

    .line 50
    iput-object p3, v0, Ldm/Sprite;->action_short:[[[S

    .line 51
    return-object v0
.end method


# virtual methods
.method public Set(Ljavax/microedition/lcdui/Image;[[B[[[B[[[B)V
    .registers 6
    .param p1, "_img"    # Ljavax/microedition/lcdui/Image;
    .param p2, "_module"    # [[B
    .param p3, "_frame"    # [[[B
    .param p4, "_action"    # [[[B

    .prologue
    .line 37
    invoke-virtual {p0}, Ldm/Sprite;->nullIMFA()V

    .line 38
    const/4 v0, 0x1

    iput-boolean v0, p0, Ldm/Sprite;->type:Z

    .line 39
    iput-object p1, p0, Ldm/Sprite;->img:Ljavax/microedition/lcdui/Image;

    .line 40
    iput-object p2, p0, Ldm/Sprite;->module_byte:[[B

    .line 41
    iput-object p3, p0, Ldm/Sprite;->frame_byte:[[[B

    .line 42
    iput-object p4, p0, Ldm/Sprite;->action_byte:[[[B

    .line 43
    return-void
.end method

.method public Set(Ljavax/microedition/lcdui/Image;[[S[[[S[[[S)V
    .registers 6
    .param p1, "_img"    # Ljavax/microedition/lcdui/Image;
    .param p2, "_module"    # [[S
    .param p3, "_frame"    # [[[S
    .param p4, "_action"    # [[[S

    .prologue
    .line 54
    invoke-virtual {p0}, Ldm/Sprite;->nullIMFA()V

    .line 55
    const/4 v0, 0x0

    iput-boolean v0, p0, Ldm/Sprite;->type:Z

    .line 56
    iput-object p1, p0, Ldm/Sprite;->img:Ljavax/microedition/lcdui/Image;

    .line 57
    iput-object p2, p0, Ldm/Sprite;->module_short:[[S

    .line 58
    iput-object p3, p0, Ldm/Sprite;->frame_short:[[[S

    .line 59
    iput-object p4, p0, Ldm/Sprite;->action_short:[[[S

    .line 60
    return-void
.end method

.method public aLength()I
    .registers 2

    .prologue
    .line 65
    iget-boolean v0, p0, Ldm/Sprite;->type:Z

    if-eqz v0, :cond_8

    iget-object v0, p0, Ldm/Sprite;->action_byte:[[[B

    array-length v0, v0

    :goto_7
    return v0

    :cond_8
    iget-object v0, p0, Ldm/Sprite;->action_short:[[[S

    array-length v0, v0

    goto :goto_7
.end method

.method public aLength(I)I
    .registers 3
    .param p1, "i"    # I

    .prologue
    .line 64
    iget-boolean v0, p0, Ldm/Sprite;->type:Z

    if-eqz v0, :cond_a

    iget-object v0, p0, Ldm/Sprite;->action_byte:[[[B

    aget-object v0, v0, p1

    array-length v0, v0

    :goto_9
    return v0

    :cond_a
    iget-object v0, p0, Ldm/Sprite;->action_short:[[[S

    aget-object v0, v0, p1

    array-length v0, v0

    goto :goto_9
.end method

.method public action(III)I
    .registers 5
    .param p1, "i"    # I
    .param p2, "j"    # I
    .param p3, "k"    # I

    .prologue
    .line 63
    iget-boolean v0, p0, Ldm/Sprite;->type:Z

    if-eqz v0, :cond_d

    iget-object v0, p0, Ldm/Sprite;->action_byte:[[[B

    aget-object v0, v0, p1

    aget-object v0, v0, p2

    aget-byte v0, v0, p3

    :goto_c
    return v0

    :cond_d
    iget-object v0, p0, Ldm/Sprite;->action_short:[[[S

    aget-object v0, v0, p1

    aget-object v0, v0, p2

    aget-short v0, v0, p3

    goto :goto_c
.end method

.method public fLength(I)I
    .registers 3
    .param p1, "i"    # I

    .prologue
    .line 66
    iget-boolean v0, p0, Ldm/Sprite;->type:Z

    if-eqz v0, :cond_a

    iget-object v0, p0, Ldm/Sprite;->frame_byte:[[[B

    aget-object v0, v0, p1

    array-length v0, v0

    :goto_9
    return v0

    :cond_a
    iget-object v0, p0, Ldm/Sprite;->frame_short:[[[S

    aget-object v0, v0, p1

    array-length v0, v0

    goto :goto_9
.end method

.method public frame(III)I
    .registers 5
    .param p1, "i"    # I
    .param p2, "j"    # I
    .param p3, "k"    # I

    .prologue
    .line 62
    iget-boolean v0, p0, Ldm/Sprite;->type:Z

    if-eqz v0, :cond_d

    iget-object v0, p0, Ldm/Sprite;->frame_byte:[[[B

    aget-object v0, v0, p1

    aget-object v0, v0, p2

    aget-byte v0, v0, p3

    :goto_c
    return v0

    :cond_d
    iget-object v0, p0, Ldm/Sprite;->frame_short:[[[S

    aget-object v0, v0, p1

    aget-object v0, v0, p2

    aget-short v0, v0, p3

    goto :goto_c
.end method

.method public module(II)I
    .registers 4
    .param p1, "i"    # I
    .param p2, "j"    # I

    .prologue
    .line 61
    iget-boolean v0, p0, Ldm/Sprite;->type:Z

    if-eqz v0, :cond_b

    iget-object v0, p0, Ldm/Sprite;->module_byte:[[B

    aget-object v0, v0, p1

    aget-byte v0, v0, p2

    :goto_a
    return v0

    :cond_b
    iget-object v0, p0, Ldm/Sprite;->module_short:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    goto :goto_a
.end method

.method public nullIMFA()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    .line 19
    iput-object v0, p0, Ldm/Sprite;->img:Ljavax/microedition/lcdui/Image;

    .line 20
    iput-object v0, p0, Ldm/Sprite;->module_byte:[[B

    .line 21
    iput-object v0, p0, Ldm/Sprite;->frame_byte:[[[B

    .line 22
    iput-object v0, p0, Ldm/Sprite;->action_byte:[[[B

    .line 23
    iput-object v0, p0, Ldm/Sprite;->module_short:[[S

    .line 24
    iput-object v0, p0, Ldm/Sprite;->frame_short:[[[S

    .line 25
    iput-object v0, p0, Ldm/Sprite;->action_short:[[[S

    .line 26
    return-void
.end method
