.class public Lmain/GameRun;
.super Lmain/GameRun_F;
.source "GameRun.java"


# static fields
.field public static isSay:Z


# instance fields
.field private NAME:[Ljava/lang/StringBuffer;

.field private Shuxing:[[B

.field am:Ldm/Battle;

.field public b_c:B

.field public b_ico:B

.field battleSay:[Ljava/lang/String;

.field public battle_state:B

.field public battle_type:B

.field public bg_c:B

.field private buff_help:[Ljava/lang/StringBuffer;

.field private buff_name:[Ljava/lang/StringBuffer;

.field private buyItem:[[B

.field public buyItemID:B

.field public buyOk:B

.field private buyPrice:[[S

.field cThrowS:S

.field cThrowX:S

.field cThrowY:S

.field public cityName_c:B

.field private city_name:[Ljava/lang/StringBuffer;

.field public coin:I

.field public createOver:B

.field public dead_c:B

.field dm:Ldm/Battle;

.field private effectImage:[Ljavax/microedition/lcdui/Image;

.field enB:Ldm/Battle;

.field public enemyList:[[B

.field public enemyOff:I

.field private evolve:[Z

.field exp:S

.field public first_battle:B

.field getSkill:B

.field private hit_rate:I

.field private imgBG:[Ljavax/microedition/lcdui/Image;

.field private imgBattle:[Ljavax/microedition/lcdui/Image;

.field public imgIco:[Ljavax/microedition/lcdui/Image;

.field private imgItem:[Ljavax/microedition/lcdui/Image;

.field public immueEnemy:B

.field private infoStart:B

.field public inhesion:[B

.field private initFealty:[B

.field private isChangeSound:Ljava/lang/Boolean;

.field public isKillAll:Z

.field isTalk:Z

.field public isUpdateList:Z

.field private itemMine:[[B

.field private item_help:[Ljava/lang/StringBuffer;

.field private item_img:Ljavax/microedition/lcdui/Image;

.field private item_modules:[[B

.field private item_name:[Ljava/lang/StringBuffer;

.field private item_type:B

.field public lastSkill:B

.field public levelUp_in_battle:[[B

.field public line_max:B

.field private list_rows:B

.field public mList_id:[[B

.field public magic:[Ldm/Sprite;

.field public magic_id:B

.field public magic_x:I

.field public magic_y:I

.field public makeLevel:[B

.field public mapMove:[B

.field public mapRect:[[B

.field public mini_state:B

.field public mon:[Ldm/Sprite;

.field private monAppearMap:[[B

.field private monInfo_dir:[[B

.field public monPro:[B

.field private mon_action:B

.field private mon_action_c:B

.field public mon_in_battle:[B

.field public money:I

.field private monsterInfo:[Ljava/lang/StringBuffer;

.field private monsterMake:[[B

.field public monsterT:[Ljava/lang/StringBuffer;

.field public monster_pro:[[B

.field public mouduls:[[B

.field public musicNo:[B

.field myB:Ldm/Battle;

.field private nameTemp:[Ljava/lang/StringBuffer;

.field private now_action:[B

.field private now_action_Magic:[S

.field private now_time:[B

.field private now_time_Magic:[S

.field public npc2ImageType:[B

.field public off:B

.field public overMode:B

.field public proReplace:[[S

.field public sayFlag:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field public sayOverSms:B

.field public sayStr:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public say_c:B

.field public say_mode:B

.field public say_s:I

.field public select_S:B

.field public select_T:B

.field sell_money:I

.field private skill:[[B

.field private skill_help:[Ljava/lang/StringBuffer;

.field private skill_list:[B

.field private skill_name:[Ljava/lang/StringBuffer;

.field private skill_up:[[B

.field strHit:Ljava/lang/String;

.field public t_battle_state:B

.field public t_length:B

.field public threadType:B

.field public time_count:B

.field public view_state:B

.field zb:[B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 3945
    const/4 v0, 0x0

    sput-boolean v0, Lmain/GameRun;->isSay:Z

    .line 29
    return-void
.end method

.method public constructor <init>(Lmain/MainCanvas;)V
    .locals 8
    .param p1, "maincanvas"    # Lmain/MainCanvas;

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x1

    const/4 v4, 0x2

    const/4 v3, 0x0

    .line 82
    invoke-direct {p0}, Lmain/GameRun_F;-><init>()V

    .line 41
    iput-byte v3, p0, Lmain/GameRun;->immueEnemy:B

    .line 45
    const/16 v0, 0x3e8

    iput v0, p0, Lmain/GameRun;->money:I

    const/16 v0, 0xa

    iput v0, p0, Lmain/GameRun;->coin:I

    .line 48
    iput-byte v5, p0, Lmain/GameRun;->view_state:B

    .line 54
    iput-byte v3, p0, Lmain/GameRun;->threadType:B

    .line 60
    iput-byte v3, p0, Lmain/GameRun;->mini_state:B

    .line 65
    iput-boolean v3, p0, Lmain/GameRun;->isKillAll:Z

    .line 70
    iput-byte v3, p0, Lmain/GameRun;->buyItemID:B

    .line 71
    iput-byte v3, p0, Lmain/GameRun;->battle_state:B

    .line 756
    iput-byte v3, p0, Lmain/GameRun;->buyOk:B

    .line 966
    iput-byte v3, p0, Lmain/GameRun;->off:B

    .line 1284
    const/16 v0, 0x8

    iput-byte v0, p0, Lmain/GameRun;->list_rows:B

    .line 1449
    iput-byte v3, p0, Lmain/GameRun;->infoStart:B

    .line 2691
    iput v3, p0, Lmain/GameRun;->sell_money:I

    .line 2765
    iput-byte v3, p0, Lmain/GameRun;->mon_action_c:B

    .line 3781
    new-array v0, v4, [B

    fill-array-data v0, :array_0

    iput-object v0, p0, Lmain/GameRun;->initFealty:[B

    .line 3865
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun;->isChangeSound:Ljava/lang/Boolean;

    .line 3919
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lmain/GameRun;->sayStr:Ljava/util/ArrayList;

    .line 3920
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lmain/GameRun;->sayFlag:Ljava/util/ArrayList;

    .line 3947
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun;->sayOverSms:B

    .line 4300
    const/16 v0, 0x10

    new-array v0, v0, [B

    const/4 v1, -0x6

    aput-byte v1, v0, v3

    const/4 v1, -0x4

    aput-byte v1, v0, v5

    const/4 v1, -0x3

    aput-byte v1, v0, v4

    const/4 v1, -0x2

    aput-byte v1, v0, v6

    const/4 v1, -0x1

    aput-byte v1, v0, v7

    const/4 v1, 0x6

    aput-byte v5, v0, v1

    const/4 v1, 0x7

    aput-byte v4, v0, v1

    const/16 v1, 0x8

    aput-byte v6, v0, v1

    const/16 v1, 0x9

    aput-byte v7, v0, v1

    const/16 v1, 0xa

    const/16 v2, 0x8

    aput-byte v2, v0, v1

    const/16 v1, 0xb

    const/4 v2, -0x3

    aput-byte v2, v0, v1

    const/16 v1, 0xc

    aput-byte v4, v0, v1

    const/16 v1, 0xd

    const/4 v2, -0x1

    aput-byte v2, v0, v1

    const/16 v1, 0xe

    aput-byte v5, v0, v1

    const/16 v1, 0xf

    aput-byte v5, v0, v1

    iput-object v0, p0, Lmain/GameRun;->zb:[B

    .line 4396
    const/4 v0, 0x5

    new-array v0, v0, [[B

    .line 4397
    new-array v1, v4, [B

    fill-array-data v1, :array_1

    aput-object v1, v0, v3

    .line 4398
    new-array v1, v4, [B

    fill-array-data v1, :array_2

    aput-object v1, v0, v5

    .line 4399
    new-array v1, v4, [B

    aput-byte v7, v1, v3

    aput-object v1, v0, v4

    .line 4400
    new-array v1, v4, [B

    aput-byte v5, v1, v5

    aput-object v1, v0, v6

    .line 4401
    new-array v1, v4, [B

    fill-array-data v1, :array_3

    aput-object v1, v0, v7

    iput-object v0, p0, Lmain/GameRun;->Shuxing:[[B

    .line 4410
    iput v3, p0, Lmain/GameRun;->hit_rate:I

    .line 5066
    const/4 v0, -0x2

    iput-byte v0, p0, Lmain/GameRun;->magic_id:B

    .line 5067
    iput v3, p0, Lmain/GameRun;->magic_x:I

    iput v3, p0, Lmain/GameRun;->magic_y:I

    .line 5478
    new-array v0, v4, [Ldm/Sprite;

    iput-object v0, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    const/4 v0, 0x6

    new-array v0, v0, [Ldm/Sprite;

    iput-object v0, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    .line 5480
    const/4 v0, 0x6

    new-array v0, v0, [S

    iput-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    .line 5481
    const/4 v0, 0x6

    new-array v0, v0, [S

    iput-object v0, p0, Lmain/GameRun;->now_time_Magic:[S

    .line 5483
    iput-byte v3, p0, Lmain/GameRun;->overMode:B

    .line 5485
    const/4 v0, 0x5

    new-array v0, v0, [Z

    fill-array-data v0, :array_4

    iput-object v0, p0, Lmain/GameRun;->evolve:[Z

    .line 5488
    new-array v0, v4, [B

    iput-object v0, p0, Lmain/GameRun;->now_action:[B

    .line 5489
    new-array v0, v4, [B

    iput-object v0, p0, Lmain/GameRun;->now_time:[B

    .line 5513
    new-array v0, v6, [Ljava/lang/String;

    const-string v1, "\u654c\u4eba\u51fa\u73b0\u4e86\uff0c\u6218\u6597\u5427\uff01"

    aput-object v1, v0, v3

    const-string v1, "\u8003\u9a8c\u7684\u65f6\u523b\u6765\u4e86\uff0c\u8bad\u7ec3\u5e08\uff01"

    aput-object v1, v0, v5

    const-string v1, "\u5c3d\u60c5\u6355\u6349\u5ba0\u7269\u5427\uff01"

    aput-object v1, v0, v4

    iput-object v0, p0, Lmain/GameRun;->battleSay:[Ljava/lang/String;

    .line 5548
    iput-boolean v3, p0, Lmain/GameRun;->isUpdateList:Z

    .line 5600
    iput-byte v3, p0, Lmain/GameRun;->first_battle:B

    .line 5601
    iput-byte v3, p0, Lmain/GameRun;->lastSkill:B

    .line 5818
    const/16 v0, 0x9

    new-array v0, v0, [B

    iput-object v0, p0, Lmain/GameRun;->skill_list:[B

    .line 5874
    iput-byte v4, p0, Lmain/GameRun;->b_ico:B

    .line 83
    sput-object p1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    .line 84
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    .line 85
    new-instance v0, Lmain/Map;

    invoke-direct {v0, p0}, Lmain/Map;-><init>(Lmain/GameRun;)V

    iput-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    .line 88
    invoke-direct {p0}, Lmain/GameRun;->initOtherImage()V

    .line 89
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ui;->initUiModules()V

    .line 90
    invoke-virtual {p0}, Lmain/GameRun;->loadRmsOther()V

    .line 92
    invoke-virtual {p0}, Lmain/GameRun;->loadRmsSms()V

    .line 93
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    .line 98
    sput-object p0, Lcom/PetKing5_480x800/PetKing5;->gr:Lmain/GameRun;

    .line 100
    return-void

    .line 3781
    nop

    :array_0
    .array-data 1
        0x64t
        0x78t
    .end array-data

    .line 4397
    nop

    :array_1
    .array-data 1
        0x2t
        0x3t
    .end array-data

    .line 4398
    nop

    :array_2
    .array-data 1
        0x3t
        0x4t
    .end array-data

    .line 4401
    nop

    :array_3
    .array-data 1
        0x1t
        0x2t
    .end array-data

    .line 5485
    nop

    :array_4
    .array-data 1
        0x1t
        0x1t
        0x1t
        0x1t
        0x1t
    .end array-data
.end method

.method private AddHP(ILdm/Monster;)V
    .locals 4
    .param p1, "hp"    # I
    .param p2, "A_Monster"    # Ldm/Monster;

    .prologue
    const/4 v3, 0x2

    const/4 v2, 0x0

    .line 661
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v2

    add-int/2addr p1, v0

    .line 662
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    if-lt p1, v0, :cond_0

    .line 663
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    iget-object v1, p2, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v3

    aput-short v1, v0, v2

    .line 666
    :goto_0
    return-void

    .line 665
    :cond_0
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    int-to-short v1, p1

    aput-short v1, v0, v2

    goto :goto_0
.end method

.method private AddMP(ILdm/Monster;)V
    .locals 4
    .param p1, "hp"    # I
    .param p2, "A_Monster"    # Ldm/Monster;

    .prologue
    const/4 v3, 0x3

    const/4 v2, 0x1

    .line 654
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v2

    add-int/2addr p1, v0

    .line 655
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    if-le p1, v0, :cond_0

    .line 656
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    iget-object v1, p2, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v3

    aput-short v1, v0, v2

    .line 659
    :goto_0
    return-void

    .line 658
    :cond_0
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    int-to-short v1, p1

    aput-short v1, v0, v2

    goto :goto_0
.end method

.method private aiEnemy()V
    .locals 11

    .prologue
    const/4 v10, 0x4

    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 5679
    const/4 v3, 0x5

    .local v3, "skill_num":B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v4, 0x64

    invoke-static {v4}, Ldm/Ms;->getRandom(I)I

    move-result v4

    int-to-byte v1, v4

    .line 5680
    .local v1, "n":B
    :goto_0
    const/4 v4, -0x1

    if-le v3, v4, :cond_0

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    add-int/lit8 v5, v3, 0x8

    aget-byte v4, v4, v5

    const/4 v5, -0x1

    if-eq v4, v5, :cond_2

    .line 5682
    :cond_0
    add-int/lit8 v4, v3, 0x1

    int-to-byte v3, v4

    .line 5683
    iget-byte v4, p0, Lmain/GameRun;->battle_type:B

    if-ne v4, v10, :cond_9

    .line 5684
    packed-switch v3, :pswitch_data_0

    .line 5698
    const/16 v4, 0x2d

    if-ge v1, v4, :cond_6

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    sub-int v5, v3, v6

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    .line 5753
    :cond_1
    :goto_1
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v5, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v5}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v5

    iget-object v5, v5, Ldm/Monster;->monster:[B

    iget-object v6, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v6, v6, Ldm/Battle;->skill:B

    add-int/lit8 v6, v6, 0x8

    aget-byte v5, v5, v6

    iput-byte v5, v4, Ldm/Battle;->skill:B

    .line 5755
    return-void

    .line 5680
    :cond_2
    sub-int v4, v3, v6

    int-to-byte v3, v4

    goto :goto_0

    .line 5686
    :pswitch_0
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v7, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5689
    :pswitch_1
    const/16 v4, 0x41

    if-ge v1, v4, :cond_3

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v6, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5690
    :cond_3
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v7, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5693
    :pswitch_2
    const/16 v4, 0x2d

    if-ge v1, v4, :cond_4

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v8, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5694
    :cond_4
    const/16 v4, 0x4b

    if-le v1, v4, :cond_5

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v6, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5695
    :cond_5
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v7, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5699
    :cond_6
    const/16 v4, 0x4b

    if-ge v1, v4, :cond_7

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    sub-int v5, v3, v8

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5700
    :cond_7
    const/16 v4, 0x5f

    if-ge v1, v4, :cond_8

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    sub-int v5, v3, v9

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5701
    :cond_8
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    sub-int v5, v3, v10

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5705
    :cond_9
    const/4 v0, 0x0

    .local v0, "i":B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v4, 0x64

    invoke-static {v4}, Ldm/Ms;->getRandom(I)I

    move-result v4

    int-to-byte v2, v4

    .line 5706
    .local v2, "rand":B
    :goto_2
    if-lt v0, v8, :cond_a

    .line 5722
    :goto_3
    if-le v0, v6, :cond_1

    .line 5723
    packed-switch v3, :pswitch_data_1

    .line 5743
    const/16 v4, 0x3c

    if-ge v1, v4, :cond_11

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    sub-int v5, v3, v6

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    goto :goto_1

    .line 5707
    :cond_a
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    add-int/lit8 v5, v0, 0xe

    aget-byte v4, v4, v5

    packed-switch v4, :pswitch_data_2

    .line 5706
    :cond_b
    add-int/lit8 v4, v0, 0x1

    int-to-byte v0, v4

    goto :goto_2

    .line 5709
    :pswitch_3
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    const/16 v5, 0x32

    invoke-direct {p0, v4, v5}, Lmain/GameRun;->isMonHp(Ldm/Monster;I)Z

    move-result v4

    if-eqz v4, :cond_b

    const/16 v4, 0x1e

    if-ge v2, v4, :cond_b

    .line 5719
    :goto_4
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    add-int/lit8 v5, v0, 0x6

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    goto :goto_3

    .line 5713
    :pswitch_4
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    const/16 v5, 0x1e

    invoke-direct {p0, v4, v5}, Lmain/GameRun;->isMonHp(Ldm/Monster;I)Z

    move-result v4

    if-eqz v4, :cond_b

    const/16 v4, 0x1e

    if-ge v2, v4, :cond_b

    goto :goto_4

    .line 5725
    :pswitch_5
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v7, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5728
    :pswitch_6
    const/16 v4, 0x14

    if-ge v1, v4, :cond_c

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v7, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5729
    :cond_c
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v6, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5732
    :pswitch_7
    const/4 v4, 0x5

    if-ge v1, v4, :cond_d

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v7, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5733
    :cond_d
    const/16 v4, 0x28

    if-le v1, v4, :cond_e

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v8, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5734
    :cond_e
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v6, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5737
    :pswitch_8
    const/16 v4, 0xf

    if-ge v1, v4, :cond_f

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v6, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5738
    :cond_f
    const/16 v4, 0x28

    if-ge v1, v4, :cond_10

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v8, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5739
    :cond_10
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v9, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5744
    :cond_11
    const/16 v4, 0x55

    if-ge v1, v4, :cond_12

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    sub-int v5, v3, v8

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5745
    :cond_12
    const/16 v4, 0x5f

    if-ge v1, v4, :cond_13

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    sub-int v5, v3, v9

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5746
    :cond_13
    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    sub-int v5, v3, v10

    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Battle;->skill:B

    goto/16 :goto_1

    .line 5684
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch

    .line 5723
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch

    .line 5707
    :pswitch_data_2
    .packed-switch 0x1b
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method private allAdd(I)V
    .locals 9
    .param p1, "hp"    # I

    .prologue
    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 3722
    const/4 v1, 0x0

    .local v1, "bmp":Z
    const/4 v0, 0x0

    .line 3724
    .local v0, "bhp":Z
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v5

    if-ge v2, v6, :cond_0

    .line 3727
    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v5

    invoke-virtual {p0, v3}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 3759
    :goto_0
    return-void

    .line 3729
    :cond_0
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v6

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    iget-object v3, v3, Ldm/Monster;->monsterPro:[S

    aget-short v3, v3, v8

    if-ge v2, v3, :cond_1

    .line 3730
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v5

    if-lez v2, :cond_1

    .line 3731
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v8

    mul-int/2addr v2, p1

    div-int/lit8 v2, v2, 0x64

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    invoke-direct {p0, v2, v3}, Lmain/GameRun;->AddMP(ILdm/Monster;)V

    .line 3732
    const/4 v1, 0x1

    .line 3734
    :cond_1
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v5

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    iget-object v3, v3, Ldm/Monster;->monsterPro:[S

    aget-short v3, v3, v7

    if-ge v2, v3, :cond_2

    .line 3735
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v5

    if-lez v2, :cond_2

    .line 3736
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v7

    mul-int/2addr v2, p1

    div-int/lit8 v2, v2, 0x64

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    invoke-direct {p0, v2, v3}, Lmain/GameRun;->AddHP(ILdm/Monster;)V

    .line 3737
    const/4 v0, 0x1

    .line 3739
    :cond_2
    if-nez v0, :cond_3

    if-eqz v1, :cond_4

    .line 3742
    :cond_3
    iget-object v2, p0, Lmain/GameRun;->select_it:[B

    aget-byte v2, v2, v5

    invoke-direct {p0, v5, v2}, Lmain/GameRun;->useState(II)V

    goto/16 :goto_0

    .line 3746
    :cond_4
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v5

    if-ge v2, v6, :cond_5

    .line 3747
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v7

    mul-int/2addr v2, p1

    div-int/lit8 v2, v2, 0x64

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    invoke-direct {p0, v2, v3}, Lmain/GameRun;->AddHP(ILdm/Monster;)V

    .line 3748
    const/4 v0, 0x1

    goto/16 :goto_0

    .line 3752
    :cond_5
    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v5

    invoke-virtual {p0, v3}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0
.end method

.method private arangeMonster()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 4489
    iget-byte v2, p0, Lmain/GameRun;->myMon_length:B

    if-le v2, v4, :cond_0

    .line 4491
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-byte v2, p0, Lmain/GameRun;->myMon_length:B

    sub-int/2addr v2, v4

    if-lt v0, v2, :cond_1

    .line 4497
    .end local v0    # "i":B
    :cond_0
    return-void

    .line 4492
    .restart local v0    # "i":B
    :cond_1
    add-int/lit8 v2, v0, 0x1

    int-to-byte v1, v2

    .local v1, "j":B
    :goto_1
    iget-byte v2, p0, Lmain/GameRun;->myMon_length:B

    if-lt v1, v2, :cond_2

    .line 4491
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    goto :goto_0

    .line 4493
    :cond_2
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v4

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v1

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v4

    if-le v2, v3, :cond_3

    .line 4494
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v1

    invoke-direct {p0, v2, v3}, Lmain/GameRun;->changeMonster(Ldm/Monster;Ldm/Monster;)V

    .line 4492
    :cond_3
    add-int/lit8 v2, v1, 0x1

    int-to-byte v1, v2

    goto :goto_1
.end method

.method private bufferAI(Ldm/Monster;)Z
    .locals 2
    .param p1, "mon"    # Ldm/Monster;

    .prologue
    const/4 v1, 0x0

    .line 5676
    invoke-virtual {p1, v1}, Ldm/Monster;->isMonEffect(I)Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private changeEffect()V
    .locals 4

    .prologue
    const/4 v2, 0x7

    const/4 v3, 0x0

    .line 3762
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-byte v0, v0, Ldm/Monster;->effect:B

    if-eq v0, v2, :cond_0

    .line 3763
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iput-byte v2, v0, Ldm/Monster;->effect:B

    .line 3764
    iget-object v0, p0, Lmain/GameRun;->select_it:[B

    aget-byte v0, v0, v3

    invoke-direct {p0, v3, v0}, Lmain/GameRun;->useState(II)V

    .line 3767
    :goto_0
    return-void

    .line 3766
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u6ca1\u6709\u5f02\u5e38\uff01"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private changeMon(Ldm/Battle;I)Z
    .locals 5
    .param p1, "be"    # Ldm/Battle;
    .param p2, "length"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 4823
    const/4 v0, 0x0

    .local v0, "d":B
    iget-byte v1, p1, Ldm/Battle;->now_id:B

    .line 4825
    .local v1, "last_id":B
    :cond_0
    iget-byte v2, p1, Ldm/Battle;->now_id:B

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    iput-byte v2, p1, Ldm/Battle;->now_id:B

    if-lt v2, p2, :cond_1

    iput-byte v3, p1, Ldm/Battle;->now_id:B

    .line 4826
    :cond_1
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    .line 4827
    if-gt v0, p2, :cond_2

    iget-byte v2, p1, Ldm/Battle;->now_id:B

    if-eq v1, v2, :cond_0

    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v3

    if-lt v2, v4, :cond_0

    .line 4828
    :cond_2
    if-le v0, p2, :cond_3

    iput-byte v1, p1, Ldm/Battle;->now_id:B

    .line 4830
    :cond_3
    if-gt v0, p2, :cond_4

    move v2, v4

    :goto_0
    return v2

    :cond_4
    move v2, v3

    goto :goto_0
.end method

.method private changeMonster(Ldm/Monster;Ldm/Monster;)V
    .locals 2
    .param p1, "a"    # Ldm/Monster;
    .param p2, "b"    # Ldm/Monster;

    .prologue
    .line 2729
    new-instance v0, Ldm/Monster;

    invoke-direct {v0}, Ldm/Monster;-><init>()V

    .line 2730
    .local v0, "c":Ldm/Monster;
    iget-object v1, p1, Ldm/Monster;->monster:[B

    iput-object v1, v0, Ldm/Monster;->monster:[B

    .line 2731
    iget-byte v1, p1, Ldm/Monster;->effect:B

    iput-byte v1, v0, Ldm/Monster;->effect:B

    .line 2732
    iget-object v1, p1, Ldm/Monster;->monsterPro:[S

    iput-object v1, v0, Ldm/Monster;->monsterPro:[S

    .line 2733
    iget-object v1, p2, Ldm/Monster;->monster:[B

    iput-object v1, p1, Ldm/Monster;->monster:[B

    .line 2734
    iget-byte v1, p2, Ldm/Monster;->effect:B

    iput-byte v1, p1, Ldm/Monster;->effect:B

    .line 2735
    iget-object v1, p2, Ldm/Monster;->monsterPro:[S

    iput-object v1, p1, Ldm/Monster;->monsterPro:[S

    .line 2736
    iget-object v1, v0, Ldm/Monster;->monster:[B

    iput-object v1, p2, Ldm/Monster;->monster:[B

    .line 2737
    iget-byte v1, v0, Ldm/Monster;->effect:B

    iput-byte v1, p2, Ldm/Monster;->effect:B

    .line 2738
    iget-object v1, v0, Ldm/Monster;->monsterPro:[S

    iput-object v1, p2, Ldm/Monster;->monsterPro:[S

    .line 2739
    const/4 v0, 0x0

    .line 2740
    return-void
.end method

.method private changeMy()Z
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4798
    const/4 v0, 0x1

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    if-lt v0, v1, :cond_0

    move v1, v2

    .line 4805
    :goto_1
    return v1

    .line 4799
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v2

    if-lez v1, :cond_1

    .line 4800
    invoke-virtual {p0, v3}, Lmain/GameRun;->setAimBattle(I)V

    .line 4801
    invoke-virtual {p0}, Lmain/GameRun;->goVIEW_MONSTER()V

    move v1, v3

    .line 4802
    goto :goto_1

    .line 4798
    :cond_1
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method private dItemIn(II)V
    .locals 5
    .param p1, "item_type"    # I
    .param p2, "item_no"    # I

    .prologue
    const/4 v4, 0x1

    .line 3661
    move v0, p2

    .line 3662
    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lmain/GameRun;->itemsLength:[B

    aget-byte v1, v1, p1

    sub-int/2addr v1, v4

    if-lt v0, v1, :cond_0

    .line 3664
    iget-object v1, p0, Lmain/GameRun;->itemsLength:[B

    aget-byte v2, v1, p1

    sub-int/2addr v2, v4

    int-to-byte v2, v2

    aput-byte v2, v1, p1

    .line 3665
    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/GameRun;->itemsLength:[B

    aget-byte v2, v2, p1

    const/4 v3, 0x0

    aput-object v3, v1, v2

    .line 3666
    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/GameRun;->itemsLength:[B

    aget-byte v2, v2, p1

    const/4 v3, 0x2

    new-array v3, v3, [B

    aput-object v3, v1, v2

    .line 3668
    return-void

    .line 3663
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, p1

    add-int/lit8 v3, v0, 0x1

    aget-object v2, v2, v3

    aput-object v2, v1, v0

    .line 3662
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private damage(Ldm/Battle;Ldm/Battle;Ldm/Monster;Ldm/Monster;II)V
    .locals 17
    .param p1, "amB"    # Ldm/Battle;
    .param p2, "dmB"    # Ldm/Battle;
    .param p3, "am"    # Ldm/Monster;
    .param p4, "dm"    # Ldm/Monster;
    .param p5, "skill_no"    # I
    .param p6, "mini"    # I

    .prologue
    .line 4358
    move-object/from16 v0, p3

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v14, v0

    const/4 v15, 0x2

    aget-byte v6, v14, v15

    .line 4359
    .local v6, "LevelA":I
    move-object/from16 v0, p4

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v14, v0

    const/4 v15, 0x2

    aget-byte v7, v14, v15

    .line 4360
    .local v7, "LevelB":I
    const/4 v4, 0x0

    .line 4361
    .local v4, "DebuffB":I
    move-object/from16 v0, p3

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    move-object v14, v0

    const/4 v15, 0x6

    aget-short v10, v14, v15

    .line 4362
    .local v10, "StrA":I
    move-object/from16 v0, p4

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    move-object v14, v0

    const/4 v15, 0x7

    aget-short v5, v14, v15

    .line 4363
    .local v5, "DefB":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill:[[B

    move-object v14, v0

    aget-object v14, v14, p5

    const/4 v15, 0x0

    aget-byte v9, v14, v15

    .line 4365
    .local v9, "SkillDam":I
    sub-int v8, v6, v7

    .line 4368
    .local v8, "LevelCha":I
    const/16 v12, 0x64

    .line 4371
    .local v12, "buff":B
    mul-int v14, v10, v9

    const/16 v15, 0x3e8

    mul-int/lit8 v16, v5, 0x5

    sub-int v15, v15, v16

    mul-int/2addr v14, v15

    div-int/lit16 v14, v14, 0x2710

    div-int/lit8 v15, v5, 0xa

    sub-int/2addr v14, v15

    mul-int/lit8 v15, v9, 0x2

    div-int v15, v6, v15

    sub-int v13, v14, v15

    .line 4372
    .local v13, "hit":I
    add-int/lit8 v14, v13, 0x6

    const/4 v15, 0x1

    sub-int v15, v6, v15

    div-int/lit8 v15, v15, 0xa

    sub-int v13, v14, v15

    .line 4373
    const/16 v14, 0xa

    if-le v8, v14, :cond_7

    const/16 v8, 0xa

    .line 4376
    :cond_0
    :goto_0
    mul-int/lit8 v14, v8, 0x4

    add-int/lit8 v14, v14, 0x64

    mul-int/2addr v14, v13

    div-int/lit8 v13, v14, 0x64

    .line 4381
    move-object/from16 v0, p4

    iget-byte v0, v0, Ldm/Monster;->effect:B

    move v14, v0

    if-nez v14, :cond_1

    const/16 v4, -0x1e

    .line 4383
    :cond_1
    move-object/from16 v0, p1

    iget-object v0, v0, Ldm/Battle;->countS:[B

    move-object v14, v0

    const/4 v15, 0x1

    aget-byte v14, v14, v15

    add-int/2addr v14, v4

    add-int/lit8 v14, v14, 0x64

    mul-int/2addr v14, v13

    div-int/lit8 v13, v14, 0x64

    .line 4384
    const/4 v11, 0x1

    .line 4385
    .local v11, "baoji":B
    const/16 v14, 0x9

    move-object/from16 v0, p3

    move v1, v14

    invoke-virtual {v0, v1}, Ldm/Monster;->isBuffRate(I)Z

    move-result v14

    if-eqz v14, :cond_2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v14, 0x64

    invoke-static {v14}, Ldm/Ms;->getRandom(I)I

    move-result v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->inhesion:[B

    move-object v15, v0

    const/16 v16, 0x9

    aget-byte v15, v15, v16

    if-lt v14, v15, :cond_3

    .line 4386
    :cond_2
    const/16 v14, 0x30

    move-object/from16 v0, p4

    move v1, v14

    invoke-virtual {v0, v1}, Ldm/Monster;->isMonReel(I)Z

    move-result v14

    if-eqz v14, :cond_8

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v14, 0x64

    invoke-static {v14}, Ldm/Ms;->getRandom(I)I

    move-result v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill:[[B

    move-object v15, v0

    const/16 v16, 0x30

    aget-object v15, v15, v16

    const/16 v16, 0x0

    aget-byte v15, v15, v16

    if-ge v14, v15, :cond_8

    :cond_3
    shr-int/lit8 v13, v13, 0x1

    .line 4391
    :cond_4
    :goto_1
    move-object/from16 v0, p4

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v14, v0

    const/4 v15, 0x3

    aget-byte v14, v14, v15

    const/4 v15, 0x1

    if-ne v14, v15, :cond_5

    const/16 v14, 0x21

    move-object/from16 v0, p4

    move v1, v14

    invoke-virtual {v0, v1}, Ldm/Monster;->isMonReel(I)Z

    move-result v14

    if-eqz v14, :cond_5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill:[[B

    move-object v14, v0

    const/16 v15, 0x21

    aget-object v14, v14, v15

    const/4 v15, 0x0

    aget-byte v12, v14, v15

    .line 4392
    :cond_5
    mul-int v14, v13, v12

    div-int/lit8 v13, v14, 0x64

    .line 4393
    const/4 v14, 0x1

    if-ge v13, v14, :cond_6

    const/4 v13, 0x1

    .line 4394
    :cond_6
    const/4 v14, 0x0

    move-object/from16 v0, p2

    move v1, v13

    move v2, v11

    move v3, v14

    invoke-virtual {v0, v1, v2, v3}, Ldm/Battle;->addHit(III)V

    .line 4395
    return-void

    .line 4375
    .end local v11    # "baoji":B
    :cond_7
    const/16 v14, -0xa

    if-ge v8, v14, :cond_0

    const/16 v8, -0xa

    goto/16 :goto_0

    .line 4387
    .restart local v11    # "baoji":B
    :cond_8
    const/16 v14, 0xa

    move-object/from16 v0, p3

    move v1, v14

    invoke-virtual {v0, v1}, Ldm/Monster;->isBuffRate(I)Z

    move-result v14

    if-eqz v14, :cond_4

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v14, 0x64

    invoke-static {v14}, Ldm/Ms;->getRandom(I)I

    move-result v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->inhesion:[B

    move-object v15, v0

    const/16 v16, 0xa

    aget-byte v15, v15, v16

    if-ge v14, v15, :cond_4

    .line 4388
    mul-int/lit8 v14, v13, 0xf

    div-int/lit8 v13, v14, 0xa

    .line 4389
    const/4 v11, 0x2

    goto :goto_1
.end method

.method private data_null()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 4103
    iput-object v0, p0, Lmain/GameRun;->skill_up:[[B

    .line 4104
    iput-object v0, p0, Lmain/GameRun;->monster_pro:[[B

    .line 4105
    iput-object v0, p0, Lmain/GameRun;->skill:[[B

    .line 4106
    iput-object v0, p0, Lmain/GameRun;->city_name:[Ljava/lang/StringBuffer;

    .line 4107
    iput-object v0, p0, Lmain/GameRun;->skill_help:[Ljava/lang/StringBuffer;

    .line 4108
    iput-object v0, p0, Lmain/GameRun;->skill_name:[Ljava/lang/StringBuffer;

    .line 4109
    iput-object v0, p0, Lmain/GameRun;->NAME:[Ljava/lang/StringBuffer;

    .line 4110
    iput-object v0, p0, Lmain/GameRun;->item_help:[Ljava/lang/StringBuffer;

    .line 4111
    iput-object v0, p0, Lmain/GameRun;->item_name:[Ljava/lang/StringBuffer;

    .line 4112
    return-void
.end method

.method private delItemEvolve(B)V
    .locals 4
    .param p1, "id"    # B

    .prologue
    .line 2536
    const/4 v0, 0x2

    .line 2539
    .local v0, "i":B
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v1, v1, p1

    aget-byte v1, v1, v0

    iget-object v2, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v2, v2, p1

    add-int/lit8 v3, v0, 0x1

    aget-byte v2, v2, v3

    invoke-virtual {p0, v1, v2}, Lmain/GameRun;->deleteItems(II)V

    .line 2540
    add-int/lit8 v1, v0, 0x2

    int-to-byte v0, v1

    .line 2541
    iget-object v1, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v1, v1, p1

    array-length v1, v1

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    if-lt v0, v1, :cond_0

    .line 2542
    return-void
.end method

.method private delItemSkill(Ldm/Monster;)V
    .locals 4
    .param p1, "mon"    # Ldm/Monster;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 2686
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u4e60\u5f97\u6280\u80fd\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->getSkill:B

    invoke-direct {p0, v1}, Lmain/GameRun;->getNameSkill(B)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2687
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lmain/GameRun;->goMY_BAG(I)V

    .line 2688
    iget-byte v0, p0, Lmain/GameRun;->getSkill:B

    add-int/lit8 v0, v0, 0x23

    const/16 v1, 0x19

    sub-int/2addr v0, v1

    sub-int/2addr v0, v3

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->deleteItems(II)V

    .line 2689
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v3, p0, Lmain/GameRun;->selectx:B

    aget-byte v2, v2, v3

    iget-byte v3, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->correctSelect([BII)V

    .line 2690
    return-void
.end method

.method private doBuffValue(Ldm/Battle;)V
    .locals 4
    .param p1, "be"    # Ldm/Battle;

    .prologue
    const/4 v3, 0x4

    const/4 v2, 0x1

    .line 4790
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x0

    aget-short v0, v0, v1

    if-ge v0, v2, :cond_1

    .line 4796
    :cond_0
    :goto_0
    return-void

    .line 4791
    :cond_1
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    invoke-virtual {v0, v3}, Ldm/Monster;->isBuffRate(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4794
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x2

    aget-short v0, v0, v1

    neg-int v0, v0

    iget-object v1, p0, Lmain/GameRun;->inhesion:[B

    aget-byte v1, v1, v3

    mul-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x64

    invoke-virtual {p1, v0, v2, v2}, Ldm/Battle;->addHit(III)V

    goto :goto_0
.end method

.method private doEffectValue(Ldm/Battle;)V
    .locals 5
    .param p1, "be"    # Ldm/Battle;

    .prologue
    const/4 v4, 0x3

    const/4 v3, 0x0

    .line 4780
    const/4 v0, 0x0

    .line 4781
    .local v0, "hit":S
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Ldm/Monster;->isMonEffect(I)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 4782
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v3

    div-int/lit8 v1, v1, 0xa

    int-to-short v0, v1

    .line 4785
    :cond_0
    :goto_0
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    invoke-virtual {v1, v4}, Ldm/Monster;->isMonReel(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 4786
    iget-object v1, p0, Lmain/GameRun;->inhesion:[B

    aget-byte v1, v1, v4

    mul-int/2addr v1, v0

    div-int/lit8 v1, v1, 0x64

    add-int/2addr v1, v0

    int-to-short v0, v1

    .line 4787
    :cond_1
    if-eqz v0, :cond_2

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1, v3}, Ldm/Battle;->addHit(III)V

    .line 4788
    :cond_2
    return-void

    .line 4783
    :cond_3
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    const/4 v2, 0x5

    invoke-virtual {v1, v2}, Ldm/Monster;->isMonEffect(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 4784
    iget-byte v1, p1, Ldm/Battle;->fs_level:B

    iget-byte v2, p1, Ldm/Battle;->fs_level:B

    mul-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x4

    int-to-short v0, v1

    goto :goto_0
.end method

.method private drawAnimationBattle(Ldm/Battle;I)V
    .locals 8
    .param p1, "amB"    # Ldm/Battle;
    .param p2, "mini_am"    # I

    .prologue
    const/4 v2, 0x5

    const/4 v7, 0x1

    .line 4547
    iget-byte v0, p1, Ldm/Battle;->action:B

    if-eqz v0, :cond_1

    .line 4561
    :cond_0
    :goto_0
    return-void

    .line 4548
    :cond_1
    iget-byte v0, p1, Ldm/Battle;->skill:B

    div-int/lit8 v0, v0, 0x5

    int-to-byte v1, v0

    .local v1, "skill_type":B
    iget-byte v0, p1, Ldm/Battle;->skill:B

    rem-int/lit8 v0, v0, 0x5

    int-to-byte v3, v0

    .line 4549
    .local v3, "skill_id":B
    if-le v1, v2, :cond_2

    const/4 v1, 0x5

    .line 4550
    :cond_2
    if-ne v1, v2, :cond_3

    iget-byte v0, p1, Ldm/Battle;->skill:B

    const/16 v2, 0x19

    sub-int/2addr v0, v2

    int-to-byte v3, v0

    .line 4554
    :cond_3
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    iget-byte v2, p1, Ldm/Battle;->skill:B

    invoke-direct {p0, v0, v2, v7}, Lmain/GameRun;->getBXY(IIZ)I

    move-result v4

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    iget-byte v2, p1, Ldm/Battle;->skill:B

    const/4 v5, 0x0

    invoke-direct {p0, v0, v2, v5}, Lmain/GameRun;->getBXY(IIZ)I

    move-result v5

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    xor-int/lit8 v6, v0, 0x1

    move-object v0, p0

    move v2, v1

    .line 4553
    invoke-virtual/range {v0 .. v6}, Lmain/GameRun;->drawMagicC(IIIIII)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4555
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-ne v0, v7, :cond_4

    .line 4556
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v2, v0, v7

    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-byte v5, p1, Ldm/Battle;->skill:B

    invoke-direct {p0, v4, v5}, Lmain/GameRun;->getSkillMana(Ldm/Monster;I)I

    move-result v4

    sub-int/2addr v2, v4

    int-to-short v2, v2

    aput-short v2, v0, v7

    .line 4557
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    invoke-virtual {p0, v0}, Lmain/GameRun;->valueMend(Ldm/Monster;)V

    .line 4559
    :cond_4
    invoke-direct {p0}, Lmain/GameRun;->runHit()V

    goto :goto_0
.end method

.method private drawBG0(IIIII)V
    .locals 10
    .param p1, "id"    # I
    .param p2, "lx"    # I
    .param p3, "ly"    # I
    .param p4, "sh"    # I
    .param p5, "w"    # I

    .prologue
    .line 2290
    const/16 v8, 0x280

    .local v8, "WIDTH":I
    const/16 v6, 0x168

    .line 2291
    .local v6, "HEIGHT":I
    const/16 v9, 0x140

    .local v9, "WIDTH_H":I
    const/16 v7, 0xb4

    .line 2294
    .local v7, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const v1, 0x52bdef

    const/4 v2, 0x1

    sub-int v2, p2, v2

    const/4 v3, 0x0

    add-int/lit8 v4, p5, 0xd

    const/4 v5, 0x2

    sub-int v5, v6, v5

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 2295
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->imgBG:[Ljavax/microedition/lcdui/Image;

    aget-object v1, v1, p1

    const/4 v2, 0x0

    const/16 v3, 0x11

    invoke-virtual {v0, v1, v9, v2, v3}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 2317
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    shl-int/lit8 v1, p2, 0x1

    sub-int v3, v8, v1

    sub-int v4, v6, p3

    const/4 v5, 0x0

    move v1, p2

    move v2, p3

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK2(IIIII)V

    .line 2318
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p2, 0x5

    add-int/lit8 v2, p3, 0x19

    add-int/lit8 v2, v2, 0x7

    add-int/2addr v2, p4

    sub-int v3, v6, p3

    const/16 v4, 0x24

    sub-int/2addr v3, v4

    sub-int v4, v3, p4

    const/4 v5, 0x1

    move v3, p5

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 2320
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p2, 0x7

    const/16 v2, 0x32

    sub-int v2, v6, v2

    const/16 v3, 0x16

    sub-int/2addr v2, v3

    const/4 v3, 0x4

    sub-int v3, p5, v3

    const/16 v4, 0x3a

    const/4 v5, 0x3

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 2324
    return-void
.end method

.method private drawBUY_ITEM()V
    .locals 24

    .prologue
    .line 759
    const/16 v19, 0x280

    .local v19, "WIDTH":I
    const/16 v18, 0x168

    .line 760
    .local v18, "HEIGHT":I
    const/16 v20, 0x140

    .local v20, "WIDTH_H":I
    const/16 v14, 0xb4

    .line 761
    .local v14, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ui;->fillRectB()V

    .line 762
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x2

    const/4 v8, 0x2

    sub-int v8, v19, v8

    const/4 v9, 0x2

    sub-int v9, v18, v9

    const/4 v10, 0x0

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK2(IIIII)V

    .line 763
    const/4 v12, 0x0

    .local v12, "i":B
    const/16 v22, 0x25

    .local v22, "ly":B
    const/16 v21, 0x1e

    .line 764
    .local v21, "fh":B
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_b:B

    move v5, v0

    if-nez v5, :cond_2

    .line 767
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/16 v6, 0x1d

    sub-int v6, v20, v6

    const/4 v7, 0x6

    const/16 v8, 0x3a

    const/16 v9, 0x1c

    const/4 v10, 0x4

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK1(IIIII)V

    .line 769
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    move-object v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v7, v0

    aget-object v6, v6, v7

    const/4 v8, 0x5

    const/16 v9, 0x11

    const/4 v10, 0x0

    const/4 v11, 0x0

    move/from16 v7, v20

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 801
    :goto_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x6

    const/16 v7, 0x1a

    sub-int v8, v19, v7

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->list_rows:B

    move v7, v0

    mul-int v7, v7, v21

    add-int/lit8 v9, v7, 0x6

    const/4 v10, 0x1

    move/from16 v7, v22

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK1(IIIII)V

    .line 807
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->list_rows:B

    move v7, v0

    mul-int v7, v7, v21

    add-int v7, v7, v22

    add-int/lit8 v7, v7, 0x10

    const/16 v8, 0xc

    sub-int v8, v19, v8

    mul-int/lit8 v9, v21, 0x3

    const/4 v10, 0x2

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK1(IIIII)V

    .line 809
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_b:B

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->itemsLength:[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v6, v0

    aget-byte v5, v5, v6

    :goto_1
    int-to-byte v12, v5

    .line 810
    const/16 v6, 0xa

    add-int/lit8 v7, v22, 0x3

    const/16 v5, 0x1a

    sub-int v8, v19, v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->list_rows:B

    move v9, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v5, v0

    const/4 v10, 0x0

    aget-object v10, v5, v10

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v11, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_b:B

    move v5, v0

    const/4 v13, 0x1

    if-ne v5, v13, :cond_7

    const/4 v5, 0x2

    move v13, v5

    :goto_2
    move-object/from16 v5, p0

    invoke-direct/range {v5 .. v13}, Lmain/GameRun;->drawItemList(IIII[BIII)V

    .line 811
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v7

    const/16 v5, 0xf

    sub-int v8, v19, v5

    add-int/lit8 v9, v22, 0x5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->list_rows:B

    move v5, v0

    mul-int v5, v5, v21

    const/4 v6, 0x6

    sub-int v10, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v5, v0

    const/4 v6, 0x0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-byte v11, v5, v6

    const/4 v13, 0x1

    invoke-virtual/range {v7 .. v13}, Ldm/Ui;->sliding(IIIIIZ)V

    .line 813
    if-lez v12, :cond_0

    .line 814
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_b:B

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->items:[[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v6, v0

    const/4 v7, 0x0

    aget-object v6, v6, v7

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    move v12, v5

    .line 818
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->item_help:[Ljava/lang/StringBuffer;

    move-object v5, v0

    aget-object v5, v5, v12

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    const-string v6, "\u590d\u6d3b\u6b7b\u4ea1\u7684\u5ba0\u7269\u5e76\u4e3a\u5176\u56de\u590d\u751f\u547d\u503c\u7684"

    invoke-virtual {v5, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 819
    const-string v6, "\u590d\u6d3b\u6b7b\u4ea1\u7684\u5ba0\u7269\u5e76\u4e3a\u5176\u56de\u590d\u751f\u547d\u503c\u768430%,\u8bf7\u52ff\u5728\u5ba0\u7269\u6218\u6597\u4e2d\u8d2d\u4e70!"

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->list_rows:B

    move v5, v0

    mul-int v5, v5, v21

    add-int v5, v5, v22

    add-int/lit8 v8, v5, 0x12

    const/16 v9, 0xa

    const/4 v10, 0x3

    move-object/from16 v5, p0

    move/from16 v7, v20

    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 827
    :cond_0
    :goto_4
    const/4 v5, 0x2

    sub-int v5, v18, v5

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_b:B

    move v7, v0

    const/4 v8, 0x1

    if-eq v7, v8, :cond_a

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v7, v0

    const/4 v8, 0x2

    if-ne v7, v8, :cond_a

    const/4 v7, 0x1

    :goto_5
    move-object/from16 v0, p0

    move/from16 v1, v20

    move v2, v5

    move v3, v6

    move v4, v7

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawMoney(IIIZ)V

    .line 829
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    const/4 v6, -0x1

    if-eq v5, v6, :cond_1

    .line 830
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->buyOk:B

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_b

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_b:B

    move v5, v0

    const/4 v6, 0x1

    if-eq v5, v6, :cond_b

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->buyItem:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v6, v0

    const/4 v7, 0x0

    aget-object v6, v6, v7

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    aget-byte v5, v5, v6

    const/16 v6, 0x23

    if-lt v5, v6, :cond_b

    .line 831
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->makeLevel:[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->buyItem:[[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v7, v0

    aget-object v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v7, v0

    const/4 v8, 0x0

    aget-object v7, v7, v8

    const/4 v8, 0x0

    aget-byte v7, v7, v8

    aget-byte v6, v6, v7

    const/16 v7, 0x23

    sub-int/2addr v6, v7

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    move-object v6, v0

    const/4 v7, 0x3

    aget-byte v6, v6, v7

    if-le v5, v6, :cond_b

    .line 832
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, -0x5

    const/16 v7, 0x32

    sub-int v7, v14, v7

    add-int/lit8 v8, v19, 0xa

    const/16 v9, 0x6c

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawKuang(IIII)V

    .line 833
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\u9700\u8981\u8bad\u7ec3\u5e08"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->makeLevel:[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->buyItem:[[B

    move-object v7, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v8, v0

    aget-object v7, v7, v8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v8, v0

    const/4 v9, 0x0

    aget-object v8, v8, v9

    const/4 v9, 0x0

    aget-byte v8, v8, v9

    aget-byte v7, v7, v8

    const/16 v8, 0x23

    sub-int/2addr v7, v8

    aget-byte v6, v6, v7

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\u7ea7\u624d\u80fd\u5b66\u4e60\uff01"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 834
    const/16 v5, 0x19

    sub-int v8, v14, v5

    const/16 v9, 0xc

    const/16 v10, 0x9

    move-object/from16 v5, p0

    move/from16 v7, v20

    .line 833
    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 835
    const-string v5, "\u662f\u5426\u8d2d\u4e70\uff1f"

    add-int/lit8 v6, v14, 0x19

    const/4 v7, 0x0

    move-object/from16 v0, p0

    move-object v1, v5

    move v2, v6

    move v3, v7

    invoke-virtual {v0, v1, v2, v3}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    .line 837
    :goto_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    const/4 v6, 0x2

    const/4 v7, 0x0

    const/4 v8, 0x0

    move/from16 v9, v20

    move/from16 v10, v18

    invoke-virtual/range {v5 .. v10}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v23

    .line 838
    .local v23, "t":B
    const/4 v5, -0x1

    move/from16 v0, v23

    move v1, v5

    if-eq v0, v1, :cond_1

    .line 839
    if-nez v23, :cond_e

    const/4 v5, -0x3

    :goto_7
    sput v5, Ldm/Ms;->key:I

    .line 840
    const/4 v5, 0x1

    sput-boolean v5, Ldm/Ms;->keyRepeat:Z

    .line 843
    .end local v23    # "t":B
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 844
    return-void

    .line 780
    :cond_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v6, v0

    mul-int/lit16 v6, v6, 0xd2

    add-int/lit8 v6, v6, 0x46

    const/4 v7, 0x6

    const/16 v8, 0x46

    const/16 v9, 0x1c

    const/4 v10, 0x4

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK1(IIIII)V

    .line 781
    :goto_8
    const/4 v5, 0x3

    if-lt v12, v5, :cond_4

    .line 782
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    const/4 v6, 0x3

    const/16 v7, 0x46

    const/4 v8, 0x0

    const/16 v9, 0xd2

    const/16 v10, 0x3e

    invoke-virtual/range {v5 .. v10}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v23

    .line 783
    .restart local v23    # "t":B
    const/4 v5, -0x1

    move/from16 v0, v23

    move v1, v5

    if-eq v0, v1, :cond_3

    .line 784
    move/from16 v0, v23

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->cur_a:B

    .line 785
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v5, v0

    const/4 v6, 0x0

    aget-object v5, v5, v6

    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v7, v0

    const/4 v8, 0x0

    aget-object v7, v7, v8

    const/4 v8, 0x0

    const/4 v9, 0x0

    aput-byte v9, v7, v8

    aput-byte v9, v5, v6

    .line 796
    :cond_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/16 v7, 0xf

    const/16 v8, 0x149

    const/4 v9, 0x1

    const/4 v10, 0x1

    move/from16 v6, v20

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawTriangle(IIIZZ)V

    goto/16 :goto_0

    .line 781
    .end local v23    # "t":B
    :cond_4
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    move-object v6, v0

    aget-object v6, v6, v12

    mul-int/lit16 v7, v12, 0xd2

    add-int/lit8 v7, v7, 0x50

    const/4 v8, 0x5

    const/4 v9, 0x0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v10, v0

    if-ne v10, v12, :cond_5

    const/4 v10, 0x0

    :goto_9
    const/4 v11, 0x0

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    add-int/lit8 v5, v12, 0x1

    int-to-byte v12, v5

    goto :goto_8

    :cond_5
    const/4 v10, 0x4

    goto :goto_9

    .line 809
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->buyItem:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v6, v0

    aget-object v5, v5, v6

    array-length v5, v5

    goto/16 :goto_1

    .line 810
    :cond_7
    const/4 v5, 0x1

    move v13, v5

    goto/16 :goto_2

    .line 814
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->buyItem:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v6, v0

    const/4 v7, 0x0

    aget-object v6, v6, v7

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    aget-byte v5, v5, v6

    move v12, v5

    goto/16 :goto_3

    .line 821
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->item_help:[Ljava/lang/StringBuffer;

    move-object v5, v0

    aget-object v5, v5, v12

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->list_rows:B

    move v5, v0

    mul-int v5, v5, v21

    add-int v5, v5, v22

    add-int/lit8 v8, v5, 0x12

    const/16 v9, 0xa

    const/4 v10, 0x3

    move-object/from16 v5, p0

    move/from16 v7, v20

    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    goto/16 :goto_4

    .line 827
    :cond_a
    const/4 v7, 0x0

    goto/16 :goto_5

    .line 836
    :cond_b
    const/16 v15, 0x96

    const/16 v16, 0x32

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_b:B

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_c

    const/4 v5, 0x1

    move/from16 v17, v5

    :goto_a
    move-object/from16 v11, p0

    move/from16 v13, v20

    invoke-direct/range {v11 .. v17}, Lmain/GameRun;->drawBuy(IIIIII)V

    goto/16 :goto_6

    :cond_c
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v5, v0

    const/4 v6, 0x2

    if-ne v5, v6, :cond_d

    const/16 v5, 0x10

    move/from16 v17, v5

    goto :goto_a

    :cond_d
    const/16 v5, 0x11

    move/from16 v17, v5

    goto :goto_a

    .line 839
    .restart local v23    # "t":B
    :cond_e
    const/4 v5, -0x4

    goto/16 :goto_7
.end method

.method private drawBattleBG()V
    .locals 11

    .prologue
    const/16 v2, 0xc8

    const/4 v4, 0x0

    .line 4621
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ui;->fillRectB()V

    .line 4629
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->imgBG:[Ljavax/microedition/lcdui/Image;

    iget-object v3, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v3, v3, Ldm/Battle;->bg_id:B

    aget-object v1, v1, v3

    const/16 v3, 0x14

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 4630
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->imgBG:[Ljavax/microedition/lcdui/Image;

    iget-object v3, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v3, v3, Ldm/Battle;->bg_id:B

    aget-object v1, v1, v3

    const/16 v3, 0x90

    sget-object v5, Lmain/GameRun;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    sget v5, Lcom/nokia/mid/ui/DirectGraphics;->FLIP_HORIZONTAL:I

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;IIII)V

    .line 4631
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x2

    const/16 v7, 0x13

    const/16 v8, 0xc3

    const/16 v9, 0xfa

    move v10, v4

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK2(IIIII)V

    .line 4677
    return-void
.end method

.method private drawBattleExp(Ldm/Monster;I)V
    .locals 8
    .param p1, "mon"    # Ldm/Monster;
    .param p2, "y"    # I

    .prologue
    .line 5178
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0xc8

    const/16 v3, 0xf0

    const/16 v4, 0xa

    const/4 v5, 0x0

    move v2, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK0(IIIII)V

    .line 5179
    const/16 v2, 0xf0

    add-int/lit8 v3, p2, 0x3

    const/16 v4, 0xc3

    const/4 v5, 0x2

    const/4 v6, 0x2

    .line 5180
    iget-byte v0, p0, Lmain/GameRun;->battle_state:B

    const/4 v1, -0x5

    if-eq v0, v1, :cond_0

    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x4

    aget-short v0, v0, v1

    move v7, v0

    :goto_0
    move-object v0, p0

    move-object v1, p1

    .line 5179
    invoke-direct/range {v0 .. v7}, Lmain/GameRun;->drawMonsterHp(Ldm/Monster;IIIIII)V

    .line 5182
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const-string v1, "\u7ecf\u9a8c"

    const/16 v2, 0xc8

    add-int/lit8 v3, p2, 0x12

    const/16 v4, 0x24

    const/4 v5, 0x0

    const/4 v6, 0x2

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 5183
    return-void

    .line 5180
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-short v0, v0, Ldm/Battle;->cexp:S

    move v7, v0

    goto :goto_0
.end method

.method private drawBuffList(Ldm/Monster;IIIII[B)V
    .locals 17
    .param p1, "monster"    # Ldm/Monster;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "fontH"    # I
    .param p6, "show_num"    # I
    .param p7, "sel"    # [B

    .prologue
    .line 2161
    const/16 v16, 0x0

    .line 2162
    .local v16, "i":B
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v10, 0x3

    const/4 v12, 0x0

    const/4 v6, 0x0

    aget-byte v6, p7, v6

    const/4 v7, 0x1

    aget-byte v7, p7, v7

    sub-int v13, v6, v7

    const/4 v14, 0x4

    const/4 v15, 0x2

    move/from16 v6, p6

    move/from16 v7, p2

    move/from16 v8, p3

    move/from16 v9, p4

    move/from16 v11, p5

    invoke-virtual/range {v5 .. v15}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 2163
    :goto_0
    const/4 v5, 0x2

    move/from16 v0, v16

    move v1, v5

    if-lt v0, v1, :cond_0

    .line 2185
    return-void

    .line 2164
    :cond_0
    if-lez v16, :cond_2

    move-object/from16 v0, p1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v5, v0

    add-int/lit8 v6, v16, 0x10

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    if-ge v5, v6, :cond_2

    .line 2183
    :cond_1
    :goto_1
    add-int/lit8 v5, v16, 0x1

    move v0, v5

    int-to-byte v0, v0

    move/from16 v16, v0

    goto :goto_0

    .line 2170
    :cond_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/16 v6, 0x31

    add-int/lit8 v7, p2, 0x8

    add-int/lit8 v8, p3, 0x8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v9, v0

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    aget-byte v9, v9, v10

    sub-int v9, v16, v9

    mul-int v9, v9, p5

    add-int/2addr v8, v9

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawUi(IIIII)V

    .line 2175
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v6, v0

    add-int/lit8 v7, v16, 0x10

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    move v1, v6

    invoke-direct {v0, v1}, Lmain/GameRun;->getNameBuff(I)Ljava/lang/String;

    move-result-object v6

    add-int/lit8 v7, p2, 0x15

    add-int/lit8 v8, p3, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v9, v0

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x1

    aget-byte v9, v9, v10

    sub-int v9, v16, v9

    mul-int v9, v9, p5

    add-int/2addr v8, v9

    const/4 v9, 0x0

    const/4 v10, 0x0

    aget-byte v10, p7, v10

    move v0, v10

    move/from16 v1, v16

    if-ne v0, v1, :cond_3

    const/4 v10, 0x0

    :goto_2
    const/4 v11, 0x0

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2178
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    add-int/lit8 v6, p3, 0x1

    const/4 v7, 0x1

    aget-byte v7, p7, v7

    sub-int v7, v16, v7

    mul-int v7, v7, p5

    add-int/2addr v6, v7

    move-object v0, v5

    move/from16 v1, p2

    move v2, v6

    move/from16 v3, p4

    move/from16 v4, p5

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 2179
    const/4 v5, 0x0

    aput-byte v16, p7, v5

    goto :goto_1

    .line 2175
    :cond_3
    const/4 v10, 0x3

    goto :goto_2
.end method

.method private drawBuy(IIIIII)V
    .locals 12
    .param p1, "id"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w_h"    # I
    .param p5, "h_h"    # I
    .param p6, "d"    # I

    .prologue
    .line 848
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    sub-int v1, p2, p4

    sub-int v2, p3, p5

    shl-int/lit8 v3, p4, 0x1

    shl-int/lit8 v4, p5, 0x1

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawKuang(IIII)V

    .line 849
    sub-int v0, p3, p5

    and-int/lit8 v1, p6, 0x10

    if-eqz v1, :cond_2

    const/4 v1, 0x2

    :goto_0
    add-int v3, v0, v1

    .line 856
    .local v3, "t":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u6570\u91cf\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v2, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-byte v2, p0, Lmain/GameRun;->t_length:B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/16 v4, 0x11

    const/4 v5, 0x3

    const/4 v6, 0x0

    move v2, p2

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 857
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    .line 858
    .local v11, "s":Ljava/lang/StringBuffer;
    and-int/lit8 v0, p6, 0x10

    if-eqz v0, :cond_3

    const-string v0, "\u9700\u8981\uff1a"

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 860
    :goto_1
    iget v0, p0, Lmain/GameRun;->sell_money:I

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    mul-int/2addr v0, v1

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 861
    and-int/lit8 v0, p6, 0x1

    if-eqz v0, :cond_4

    const-string v0, "\u91d1"

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 863
    :goto_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    add-int/lit8 v0, v3, 0x19

    add-int/lit8 v7, v0, 0x4

    const/16 v8, 0x11

    const/4 v9, 0x6

    const/4 v10, 0x0

    move v6, p2

    invoke-virtual/range {v4 .. v10}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 864
    and-int/lit8 v0, p6, 0x10

    if-eqz v0, :cond_0

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\u73b0\u6709\uff1a"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const/4 v1, -0x2

    const/4 v2, 0x1

    invoke-virtual {p0, v1, p1, v2}, Lmain/GameRun;->findItem(IIZ)B

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    add-int/lit8 v7, v3, 0x3a

    const/16 v8, 0x11

    const/4 v9, 0x3

    const/4 v10, 0x0

    move v6, p2

    invoke-virtual/range {v4 .. v10}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 865
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    const/4 v0, 0x2

    sub-int v6, p3, v0

    const/4 v8, 0x1

    iget-byte v0, p0, Lmain/GameRun;->cur_b:B

    const/4 v1, 0x2

    if-eq v0, v1, :cond_5

    const/4 v0, 0x1

    move v9, v0

    :goto_3
    move v5, p2

    move/from16 v7, p4

    invoke-virtual/range {v4 .. v9}, Ldm/Ui;->drawTriangle1(IIIZZ)V

    .line 867
    const/4 v11, 0x0

    .line 868
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 869
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\u662f\u5426"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    and-int/lit8 v1, p6, 0x10

    if-eqz v1, :cond_6

    const-string v1, "\u8d2d\u4e70"

    :goto_4
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\uff1f"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sget v1, Lmain/Constants_H;->HEIGHT_H:I

    add-int/lit8 v1, v1, 0x19

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    .line 870
    :cond_1
    return-void

    .line 849
    .end local v3    # "t":I
    .end local v11    # "s":Ljava/lang/StringBuffer;
    :cond_2
    const/16 v1, 0xc

    goto/16 :goto_0

    .line 859
    .restart local v3    # "t":I
    .restart local v11    # "s":Ljava/lang/StringBuffer;
    :cond_3
    const-string v0, "\u83b7\u5f97\uff1a"

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_1

    .line 862
    :cond_4
    const-string v0, "\u5fbd\u7ae0"

    invoke-virtual {v11, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto/16 :goto_2

    .line 865
    :cond_5
    const/4 v0, 0x0

    move v9, v0

    goto :goto_3

    .line 869
    :cond_6
    const-string v1, "\u5356\u51fa"

    goto :goto_4
.end method

.method private drawClipPic(IIIIIIIII)V
    .locals 13
    .param p1, "action_id"    # I
    .param p2, "id"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "w"    # I
    .param p6, "h"    # I
    .param p7, "piece"    # I
    .param p8, "cc"    # I
    .param p9, "dir"    # I

    .prologue
    .line 4143
    const/4 v10, 0x1

    .local v10, "i":B
    div-int v2, p5, p7

    int-to-byte v11, v2

    .line 4144
    .local v11, "ph":B
    const/4 v2, 0x2

    shl-int v2, v2, p8

    int-to-short v12, v2

    .line 4147
    .local v12, "speed":S
    :goto_0
    move v0, v10

    move/from16 v1, p7

    if-lt v0, v1, :cond_0

    .line 4155
    return-void

    .line 4148
    :cond_0
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    mul-int v3, v10, v11

    sub-int v3, p3, v3

    sub-int v4, p4, p6

    sub-int v5, v11, v12

    if-gtz v5, :cond_1

    move v5, v11

    :goto_1
    add-int/lit8 v6, p6, 0x14

    invoke-virtual {v2, v3, v4, v5, v6}, Ljavax/microedition/lcdui/Graphics;->clipRect(IIII)V

    .line 4149
    mul-int/lit8 v5, p1, 0x3

    const/4 v8, 0x1

    move-object v2, p0

    move v3, p2

    move v4, p2

    move/from16 v6, p3

    move/from16 v7, p4

    move/from16 v9, p9

    invoke-virtual/range {v2 .. v9}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    .line 4150
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v3, 0x0

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH:I

    sget v6, Lmain/Constants_H;->HEIGHT:I

    invoke-virtual {v2, v3, v4, v5, v6}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 4151
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v3, 0x1

    sub-int v3, v10, v3

    mul-int/2addr v3, v11

    add-int v3, v3, p3

    sub-int v4, p4, p6

    sub-int v5, v11, v12

    if-gtz v5, :cond_2

    move v5, v11

    :goto_2
    add-int/lit8 v6, p6, 0x14

    invoke-virtual {v2, v3, v4, v5, v6}, Ljavax/microedition/lcdui/Graphics;->clipRect(IIII)V

    .line 4152
    mul-int/lit8 v5, p1, 0x3

    const/4 v8, 0x1

    move-object v2, p0

    move v3, p2

    move v4, p2

    move/from16 v6, p3

    move/from16 v7, p4

    move/from16 v9, p9

    invoke-virtual/range {v2 .. v9}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    .line 4153
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v3, 0x0

    const/4 v4, 0x0

    sget v5, Lmain/Constants_H;->WIDTH:I

    sget v6, Lmain/Constants_H;->HEIGHT:I

    invoke-virtual {v2, v3, v4, v5, v6}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 4147
    add-int/lit8 v2, v10, 0x1

    int-to-byte v10, v2

    div-int/lit8 v2, v12, 0x2

    int-to-short v12, v2

    goto :goto_0

    :cond_1
    move v5, v12

    .line 4148
    goto :goto_1

    :cond_2
    move v5, v12

    .line 4151
    goto :goto_2
.end method

.method private drawColorLine(IIIIIIIIII)V
    .locals 4
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I
    .param p5, "line_height"    # I
    .param p6, "max_h"    # I
    .param p7, "speed"    # I
    .param p8, "dir"    # I
    .param p9, "bgColor"    # I
    .param p10, "lineColor"    # I

    .prologue
    .line 4580
    const/high16 v2, -0x1000000

    and-int/2addr v2, p9

    if-eqz v2, :cond_0

    .line 4581
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v2, p9}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 4582
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v2, p1, p2, p3, p4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 4584
    :cond_0
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v2, p10}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 4585
    const/4 v1, 0x0

    .local v1, "over":I
    const/4 v0, 0x1

    .line 4586
    .local v0, "grid":I
    const/4 v2, 0x1

    if-ne p8, v2, :cond_5

    .line 4587
    add-int v1, p2, p4

    .line 4588
    :cond_1
    :goto_0
    if-lt p2, v1, :cond_3

    .line 4618
    :cond_2
    return-void

    .line 4589
    :cond_3
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v2, p1, p2, p3, p5}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 4590
    add-int/2addr p2, p5

    .line 4591
    add-int/2addr p2, v0

    .line 4592
    sub-int/2addr p5, p7

    .line 4594
    if-gtz p5, :cond_1

    .line 4595
    add-int/lit8 p6, p6, -0x1

    .line 4596
    if-ge v0, p6, :cond_4

    .line 4597
    add-int/lit8 v0, v0, 0x1

    .line 4598
    :cond_4
    const/4 p5, 0x1

    goto :goto_0

    .line 4601
    :cond_5
    const/4 v2, 0x2

    if-ne p8, v2, :cond_2

    .line 4602
    move v1, p2

    .line 4603
    add-int/2addr p2, p4

    .line 4604
    :cond_6
    :goto_1
    if-le p2, v1, :cond_2

    .line 4605
    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v3, p2, p5

    invoke-virtual {v2, p1, v3, p3, p5}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 4606
    sub-int/2addr p2, p5

    .line 4607
    sub-int/2addr p2, v0

    .line 4608
    sub-int/2addr p5, p7

    .line 4610
    if-gtz p5, :cond_6

    .line 4611
    add-int/lit8 p6, p6, -0x1

    .line 4612
    if-ge v0, p6, :cond_7

    .line 4613
    add-int/lit8 v0, v0, 0x1

    .line 4614
    :cond_7
    const/4 p5, 0x1

    goto :goto_1
.end method

.method private drawDarkScreen()V
    .locals 11

    .prologue
    const/4 v1, 0x0

    .line 4572
    const/16 v3, 0x280

    .local v3, "WIDTH":I
    const/16 v4, 0x168

    .line 4573
    .local v4, "HEIGHT":I
    iget-byte v0, p0, Lmain/GameRun;->b_c:B

    add-int/lit8 v5, v0, 0x1

    const/4 v6, 0x6

    const/4 v7, 0x1

    const/4 v8, 0x2

    const v9, 0xffffff

    const v10, 0x494949

    move-object v0, p0

    move v2, v1

    invoke-direct/range {v0 .. v10}, Lmain/GameRun;->drawColorLine(IIIIIIIIII)V

    .line 4574
    return-void
.end method

.method private drawEffectImage(Ldm/Monster;II)V
    .locals 6
    .param p1, "monster"    # Ldm/Monster;
    .param p2, "x"    # I
    .param p3, "y"    # I

    .prologue
    const/16 v3, 0x8

    .line 677
    iget-byte v0, p1, Ldm/Monster;->effect:B

    const/4 v1, -0x1

    if-le v0, v1, :cond_0

    iget-byte v0, p1, Ldm/Monster;->effect:B

    const/4 v1, 0x7

    if-ge v0, v1, :cond_0

    iget-byte v0, p1, Ldm/Monster;->effect_time:B

    if-lez v0, :cond_0

    .line 679
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->effectImage:[Ljavax/microedition/lcdui/Image;

    iget-byte v2, p1, Ldm/Monster;->effect:B

    aget-object v1, v1, v2

    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v2, v3, 0x20

    invoke-virtual {v0, v1, p2, p3, v2}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 680
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-byte v2, p1, Ldm/Monster;->effect_time:B

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v4, v3, 0x20

    const/4 v5, 0x0

    move v2, p2

    move v3, p3

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 682
    :cond_0
    return-void
.end method

.method private drawEnemy()V
    .locals 10

    .prologue
    const/4 v8, 0x1

    const/4 v1, 0x0

    .line 5248
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    const/16 v2, 0x1b3

    const/16 v3, 0x28

    invoke-direct {p0, v0, v2, v3}, Lmain/GameRun;->drawEffectImage(Ldm/Monster;II)V

    .line 5252
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v1

    if-ge v0, v8, :cond_0

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->dead:B

    if-ne v0, v8, :cond_0

    .line 5264
    :goto_0
    return-void

    .line 5253
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v1

    aget-object v0, v0, v2

    aget-byte v0, v0, v8

    mul-int/lit8 v0, v0, 0x3

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->action:B

    add-int v3, v0, v2

    .line 5254
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->ceff:[B

    aget-byte v0, v0, v1

    if-eqz v0, :cond_2

    const/4 v0, 0x3

    :goto_1
    add-int/lit16 v4, v0, 0x179

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->ceff:[B

    aget-byte v0, v0, v1

    if-eqz v0, :cond_3

    const/4 v0, -0x3

    :goto_2
    add-int/lit8 v5, v0, 0x61

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->action:B

    if-nez v0, :cond_4

    move v6, v8

    :goto_3
    move-object v0, p0

    move v2, v1

    move v7, v1

    .line 5253
    invoke-virtual/range {v0 .. v7}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 5255
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v1

    if-ge v0, v8, :cond_5

    .line 5256
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    const/4 v2, 0x2

    iput-byte v2, v0, Ldm/Battle;->action:B

    .line 5257
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v8, v0, Ldm/Battle;->dead:B

    .line 5260
    :cond_1
    :goto_4
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->ceff:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v3, v3, Ldm/Battle;->ceff:[B

    aget-byte v3, v3, v1

    invoke-virtual {v2, v3, v1, v8, v8}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v2

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 5261
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    const/16 v4, 0x160

    const/16 v5, 0x61

    const/16 v6, 0x32

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-short v9, v0, Ldm/Battle;->chp:S

    move-object v2, p0

    move v7, v1

    invoke-direct/range {v2 .. v9}, Lmain/GameRun;->drawMonsterHp(Ldm/Monster;IIIIII)V

    .line 5262
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-short v3, v3, Ldm/Battle;->chp:S

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aget-short v4, v4, v1

    .line 5263
    iget-object v5, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-short v5, v5, Ldm/Battle;->chp:S

    iget-object v6, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v6}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v6

    iget-object v6, v6, Ldm/Monster;->monsterPro:[S

    aget-short v1, v6, v1

    if-ge v5, v1, :cond_6

    const/16 v1, 0x14

    .line 5262
    :goto_5
    invoke-virtual {v2, v3, v4, v1, v8}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v1

    iput-short v1, v0, Ldm/Battle;->chp:S

    goto/16 :goto_0

    :cond_2
    move v0, v1

    .line 5254
    goto/16 :goto_1

    :cond_3
    move v0, v1

    goto/16 :goto_2

    :cond_4
    move v6, v1

    goto :goto_3

    .line 5258
    :cond_5
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->dead:B

    if-eq v0, v8, :cond_1

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v1, v0, Ldm/Battle;->action:B

    goto :goto_4

    .line 5263
    :cond_6
    const/4 v1, 0x6

    goto :goto_5
.end method

.method private drawEnemyState()V
    .locals 11

    .prologue
    .line 5289
    const/16 v1, 0xa

    .local v1, "x":I
    const/16 v2, 0x19

    .line 5290
    .local v2, "y":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v3, 0xb3

    const/16 v4, 0x6e

    const/4 v5, 0x2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 5291
    const/16 v10, 0x93

    .line 5292
    .local v10, "w":S
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v3, v1, 0x2

    add-int/lit8 v4, v2, 0x2

    const/16 v5, 0x21

    invoke-virtual {v0, v3, v4, v10, v5}, Ldm/Ui;->drawKuang(IIII)V

    .line 5293
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v3, 0x3

    aget-byte v0, v0, v3

    const/4 v3, -0x1

    if-eq v0, v3, :cond_0

    .line 5294
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v4, 0x3

    aget-byte v0, v0, v4

    add-int/lit8 v4, v0, 0x5

    add-int/lit8 v5, v1, 0x10

    add-int/lit8 v6, v2, 0x10

    const/4 v7, 0x3

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawUi(IIIII)V

    .line 5295
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v4, 0x0

    aget-byte v0, v0, v4

    invoke-virtual {p0, v0}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 5296
    add-int/lit8 v0, v1, 0x4b

    add-int/lit8 v5, v0, 0xe

    add-int/lit8 v6, v2, 0x1

    const/16 v7, 0x11

    const/4 v8, 0x4

    const/4 v9, 0x2

    .line 5295
    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 5297
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x2

    aget-byte v4, v4, v5

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "\u7ea7"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    add-int/lit8 v0, v1, 0x7d

    add-int/lit8 v5, v0, 0x1b

    add-int/lit8 v6, v2, 0x14

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 5298
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    add-int/lit8 v4, v1, 0x2

    add-int/lit8 v0, v2, 0x19

    add-int/lit8 v5, v0, 0xb

    const/16 v6, 0x3e

    const/16 v7, 0xe

    const/4 v8, 0x4

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawK0(IIIII)V

    .line 5299
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const/16 v4, 0x22

    add-int/lit8 v5, v1, 0x4

    add-int/lit8 v0, v2, 0x19

    add-int/lit8 v6, v0, 0xc

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawUi(IIIII)V

    .line 5300
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v4, v4, Ldm/Battle;->countS:[B

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    add-int/lit8 v4, v4, 0x64

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "%"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    add-int/lit8 v5, v1, 0x3c

    add-int/lit8 v0, v2, 0x19

    add-int/lit8 v6, v0, 0x18

    const/4 v7, 0x1

    const/4 v8, 0x1

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 5302
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const-string v4, "\u5ba0\u7269\u6863\u6b21"

    add-int/lit8 v5, v1, 0x2

    add-int/lit8 v0, v2, 0x19

    add-int/lit8 v6, v0, 0x1e

    const/16 v7, 0x14

    const/4 v8, 0x4

    const/4 v9, 0x2

    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 5303
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v3, 0x4

    aget-byte v0, v0, v3

    add-int/lit8 v3, v1, 0x64

    add-int/lit8 v3, v3, 0x8

    add-int/lit8 v4, v2, 0x19

    add-int/lit8 v4, v4, 0x26

    const/4 v5, 0x0

    invoke-direct {p0, v0, v3, v4, v5}, Lmain/GameRun;->drawMonKind(BIII)V

    .line 5304
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    iget-object v0, p0, Lmain/GameRun;->monInfoList:[B

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-byte v0, v0, v4

    const/4 v4, 0x2

    if-ne v0, v4, :cond_1

    const-string v0, "\u5df2\u6355\u83b7"

    move-object v4, v0

    :goto_0
    add-int/lit8 v5, v1, 0x2

    add-int/lit8 v0, v2, 0x32

    add-int/lit8 v6, v0, 0x20

    const/16 v7, 0x14

    const/4 v8, 0x4

    const/4 v9, 0x2

    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 5305
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    iget-object v0, p0, Lmain/GameRun;->monInfoList:[B

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-byte v0, v0, v4

    const/4 v4, 0x2

    if-ne v0, v4, :cond_2

    const/16 v0, 0x19

    move v4, v0

    :goto_1
    add-int/lit8 v0, v1, 0x64

    add-int/lit8 v5, v0, 0x4

    add-int/lit8 v0, v2, 0x32

    add-int/lit8 v6, v0, 0x28

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawUi(IIIII)V

    .line 5306
    return-void

    .line 5304
    :cond_1
    const-string v0, "\u672a\u6355\u83b7"

    move-object v4, v0

    goto :goto_0

    .line 5305
    :cond_2
    const/16 v0, 0x1a

    move v4, v0

    goto :goto_1
.end method

.method private drawEvolveMake(IIII)V
    .locals 9
    .param p1, "id"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "fontH"    # I

    .prologue
    .line 2566
    const/4 v7, 0x2

    .local v7, "i":B
    const/4 v8, 0x0

    .line 2568
    .local v8, "j":B
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v2, v2, p1

    aget-byte v2, v2, v7

    invoke-virtual {p0, v2}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "\uff08"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, -0x2

    iget-object v3, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v3, v3, p1

    aget-byte v3, v3, v7

    const/4 v4, 0x1

    invoke-virtual {p0, v2, v3, v4}, Lmain/GameRun;->findItem(IIZ)B

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v2, v2, p1

    add-int/lit8 v3, v7, 0x1

    aget-byte v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\uff09"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 2569
    mul-int v2, v8, p4

    add-int v3, p3, v2

    const/4 v4, 0x0

    const/4 v5, 0x3

    const/4 v6, 0x0

    move v2, p2

    .line 2568
    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2570
    add-int/lit8 v0, v7, 0x2

    int-to-byte v7, v0

    .line 2571
    add-int/lit8 v0, v8, 0x1

    int-to-byte v8, v0

    .line 2572
    iget-object v0, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v0, v0, p1

    array-length v0, v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    if-lt v7, v0, :cond_0

    .line 2573
    iget-object v0, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v0, v0, p1

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    if-lez v0, :cond_1

    .line 2574
    const/4 v0, -0x2

    const/16 v1, 0x22

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->findItem(IIZ)B

    move-result v7

    .line 2575
    if-lez v7, :cond_1

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const/16 v2, 0x22

    invoke-virtual {p0, v2}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "\uff08"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\uff09"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    mul-int v2, v8, p4

    add-int v3, p3, v2

    const/4 v4, 0x0

    const/4 v5, -0x1

    const/4 v6, 0x0

    move v2, p2

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2577
    :cond_1
    return-void
.end method

.method private drawHitOne(Ldm/Battle;Ldm/Battle;II)Z
    .locals 9
    .param p1, "dm"    # Ldm/Battle;
    .param p2, "am"    # Ldm/Battle;
    .param p3, "x"    # I
    .param p4, "y"    # I

    .prologue
    .line 4303
    const/4 v7, 0x1

    .line 4304
    .local v7, "bb":Z
    const-string v0, ""

    iput-object v0, p0, Lmain/GameRun;->strHit:Ljava/lang/String;

    .line 4305
    const/4 v8, 0x0

    .local v8, "i":B
    :goto_0
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    array-length v0, v0

    if-lt v8, v0, :cond_0

    .line 4343
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    invoke-virtual {p0, v0}, Lmain/GameRun;->valueMend(Ldm/Monster;)V

    .line 4344
    return v7

    .line 4306
    :cond_0
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x4

    aget-short v0, v0, v1

    iget-object v1, p0, Lmain/GameRun;->zb:[B

    array-length v1, v1

    if-lt v0, v1, :cond_2

    .line 4305
    :cond_1
    :goto_1
    add-int/lit8 v0, v8, 0x1

    int-to-byte v8, v0

    goto :goto_0

    .line 4307
    :cond_2
    const/4 v7, 0x0

    .line 4308
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    const/4 v1, -0x1

    if-ne v0, v1, :cond_6

    const-string v0, "\u95ea\u907f"

    iput-object v0, p0, Lmain/GameRun;->strHit:Ljava/lang/String;

    .line 4311
    :goto_2
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    if-lez v0, :cond_a

    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    const/4 v1, 0x4

    if-ge v0, v1, :cond_a

    .line 4315
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    const/4 v1, 0x2

    if-ne v0, v1, :cond_3

    .line 4316
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0x20

    iget-object v2, p1, Ldm/Battle;->hit:[[S

    aget-object v2, v2, v8

    const/4 v3, 0x2

    aget-short v2, v2, v3

    add-int/2addr v2, p3

    iget-object v3, p0, Lmain/GameRun;->strHit:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    shr-int/lit8 v3, v3, 0x1

    mul-int/lit8 v3, v3, 0xe

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0xf

    iget-object v3, p1, Ldm/Battle;->hit:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x3

    aget-short v3, v3, v4

    add-int/2addr v3, p4

    add-int/lit8 v3, v3, 0x8

    const/16 v4, 0x28

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 4317
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0x21

    iget-object v2, p1, Ldm/Battle;->hit:[[S

    aget-object v2, v2, v8

    const/4 v3, 0x2

    aget-short v2, v2, v3

    add-int/2addr v2, p3

    iget-object v3, p0, Lmain/GameRun;->strHit:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    shr-int/lit8 v3, v3, 0x1

    mul-int/lit8 v3, v3, 0xe

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0xf

    iget-object v3, p1, Ldm/Battle;->hit:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x3

    aget-short v3, v3, v4

    add-int/2addr v3, p4

    add-int/lit8 v3, v3, 0x8

    const/16 v4, 0x24

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 4319
    :cond_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->strHit:Ljava/lang/String;

    iget-object v2, p1, Ldm/Battle;->hit:[[S

    aget-object v2, v2, v8

    const/4 v3, 0x2

    aget-short v2, v2, v3

    add-int/2addr v2, p3

    iget-object v3, p1, Ldm/Battle;->hit:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x3

    aget-short v3, v3, v4

    add-int/2addr v3, p4

    const/4 v4, 0x0

    iget-object v5, p1, Ldm/Battle;->hit:[[S

    aget-object v5, v5, v8

    const/4 v6, 0x0

    aget-short v5, v5, v6

    const/4 v6, 0x2

    if-ne v5, v6, :cond_9

    const/4 v5, 0x2

    :goto_3
    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 4323
    :cond_4
    :goto_4
    if-nez v8, :cond_e

    .line 4324
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x2

    aget-short v2, v0, v1

    iget-byte v3, p0, Lmain/GameRun;->mini_state:B

    const/4 v4, 0x1

    if-ne v3, v4, :cond_d

    const/4 v3, 0x1

    :goto_5
    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 4325
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x3

    aget-short v2, v0, v1

    iget-object v3, p0, Lmain/GameRun;->zb:[B

    iget-object v4, p1, Ldm/Battle;->hit:[[S

    aget-object v4, v4, v8

    const/4 v5, 0x4

    aget-short v4, v4, v5

    aget-byte v3, v3, v4

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 4333
    :cond_5
    :goto_6
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x4

    aget-short v2, v0, v1

    add-int/lit8 v2, v2, 0x1

    int-to-short v2, v2

    aput-short v2, v0, v1

    const/4 v0, 0x1

    if-ne v2, v0, :cond_1

    .line 4334
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    const/4 v1, 0x4

    if-ne v0, v1, :cond_11

    .line 4335
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x1

    aget-short v2, v0, v1

    iget-object v3, p1, Ldm/Battle;->hit:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x1

    aget-short v3, v3, v4

    sub-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    goto/16 :goto_1

    .line 4309
    :cond_6
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    const/4 v1, -0x2

    if-ne v0, v1, :cond_7

    const-string v0, "\u5fe0\u8bda\u5ea6\u51cf\u5c11"

    iput-object v0, p0, Lmain/GameRun;->strHit:Ljava/lang/String;

    goto/16 :goto_2

    .line 4310
    :cond_7
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p1, Ldm/Battle;->hit:[[S

    aget-object v1, v1, v8

    const/4 v2, 0x1

    aget-short v1, v1, v2

    const/4 v2, -0x1

    if-le v1, v2, :cond_8

    const-string v1, "-"

    :goto_7
    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v1, p1, Ldm/Battle;->hit:[[S

    aget-object v1, v1, v8

    const/4 v2, 0x1

    aget-short v1, v1, v2

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun;->strHit:Ljava/lang/String;

    goto/16 :goto_2

    :cond_8
    const-string v1, "+"

    goto :goto_7

    .line 4319
    :cond_9
    const/4 v5, 0x1

    goto/16 :goto_3

    .line 4321
    :cond_a
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    if-ltz v0, :cond_b

    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    const/4 v1, 0x4

    if-ne v0, v1, :cond_4

    .line 4322
    :cond_b
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->strHit:Ljava/lang/String;

    iget-object v2, p1, Ldm/Battle;->hit:[[S

    aget-object v2, v2, v8

    const/4 v3, 0x2

    aget-short v2, v2, v3

    add-int/2addr v2, p3

    iget-object v3, p1, Ldm/Battle;->hit:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x3

    aget-short v3, v3, v4

    add-int/2addr v3, p4

    const/4 v4, 0x0

    iget-object v5, p1, Ldm/Battle;->hit:[[S

    aget-object v5, v5, v8

    const/4 v6, 0x0

    aget-short v5, v5, v6

    const/4 v6, 0x4

    if-ne v5, v6, :cond_c

    const/4 v5, 0x1

    :goto_8
    const/4 v6, 0x2

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto/16 :goto_4

    :cond_c
    const/4 v5, 0x0

    goto :goto_8

    .line 4324
    :cond_d
    const/4 v3, -0x1

    goto/16 :goto_5

    .line 4326
    :cond_e
    const/4 v0, 0x1

    if-ne v8, v0, :cond_10

    .line 4327
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x2

    aget-short v2, v0, v1

    iget-byte v3, p0, Lmain/GameRun;->mini_state:B

    const/4 v4, 0x1

    if-ne v3, v4, :cond_f

    const/4 v3, 0x1

    :goto_9
    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 4328
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x3

    aget-short v2, v0, v1

    iget-object v3, p0, Lmain/GameRun;->zb:[B

    iget-object v4, p1, Ldm/Battle;->hit:[[S

    aget-object v4, v4, v8

    const/4 v5, 0x4

    aget-short v4, v4, v5

    aget-byte v3, v3, v4

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    goto/16 :goto_6

    .line 4327
    :cond_f
    const/4 v3, -0x1

    goto :goto_9

    .line 4329
    :cond_10
    const/4 v0, 0x2

    if-ne v8, v0, :cond_5

    .line 4331
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x3

    aget-short v2, v0, v1

    iget-object v3, p1, Ldm/Battle;->hit:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x4

    aget-short v3, v3, v4

    div-int/lit8 v3, v3, 0x3

    sub-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    goto/16 :goto_6

    .line 4336
    :cond_11
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    const/4 v1, -0x2

    if-ne v0, v1, :cond_12

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-nez v0, :cond_12

    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    const/16 v1, 0x28

    invoke-virtual {v0, v1}, Ldm/Monster;->isMonReel(I)Z

    move-result v0

    if-nez v0, :cond_12

    .line 4337
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v1, 0x6

    aget-byte v2, v0, v1

    iget-object v3, p1, Ldm/Battle;->hit:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x1

    aget-short v3, v3, v4

    sub-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 4338
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    goto/16 :goto_1

    .line 4339
    :cond_12
    iget-object v0, p1, Ldm/Battle;->hit:[[S

    aget-object v0, v0, v8

    const/4 v1, 0x0

    aget-short v0, v0, v1

    if-lez v0, :cond_1

    .line 4340
    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x0

    aget-short v2, v0, v1

    iget-object v3, p1, Ldm/Battle;->hit:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x1

    aget-short v3, v3, v4

    sub-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    goto/16 :goto_1
.end method

.method private drawInfoBG(II)V
    .locals 13
    .param p1, "w"    # I
    .param p2, "fh"    # I

    .prologue
    const/4 v8, 0x2

    const/4 v12, 0x4

    const/4 v1, 0x0

    .line 1516
    const/16 v4, 0x280

    .local v4, "WIDTH":I
    const/16 v11, 0x168

    .line 1518
    .local v11, "HEIGHT":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    move v2, v1

    move v3, v1

    move v5, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 1519
    sget-object v0, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v2, v11, p2

    invoke-virtual {v0, v1, v2, v4, p2}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 1520
    sget-object v0, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v2, p2, v8

    invoke-virtual {v0, v1, v2, v4, p2}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 1521
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const v6, 0xeafcff

    sub-int v10, p2, v12

    move v7, v1

    move v9, v4

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->fillRect(IIIII)V

    .line 1522
    sget-object v0, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v2, v11, p2

    add-int/lit8 v2, v2, 0x2

    sub-int v3, p2, v12

    invoke-virtual {v0, v1, v2, v4, v3}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 1523
    sget-object v0, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sub-int v2, p2, v12

    invoke-virtual {v0, v1, p2, v4, v2}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 1541
    return-void
.end method

.method private drawInfoList(IIIIII[B)V
    .locals 19
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "sh"    # I
    .param p5, "show_num"    # I
    .param p6, "listMax"    # I
    .param p7, "sel"    # [B

    .prologue
    .line 1546
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x4

    sub-int v7, p1, v6

    add-int/lit8 v8, p2, 0x5

    const/4 v10, 0x4

    add-int/lit8 v11, p4, 0x4

    const/4 v12, 0x2

    const/4 v6, 0x0

    aget-byte v6, p7, v6

    const/4 v9, 0x1

    aget-byte v9, p7, v9

    sub-int v13, v6, v9

    const/4 v14, 0x4

    const/4 v15, 0x2

    move/from16 v6, p5

    move/from16 v9, p3

    invoke-virtual/range {v5 .. v15}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 1547
    const/4 v5, 0x1

    aget-byte v18, p7, v5

    .local v18, "i":B
    :goto_0
    const/4 v5, 0x1

    aget-byte v5, p7, v5

    add-int v5, v5, p5

    move/from16 v0, v18

    move v1, v5

    if-ge v0, v1, :cond_0

    move/from16 v0, v18

    move/from16 v1, p6

    if-lt v0, v1, :cond_1

    .line 1563
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    add-int v5, p1, p3

    add-int/lit8 v12, v5, 0x5

    add-int/lit8 v13, p2, 0xa

    add-int/lit8 v5, p4, 0x4

    add-int/lit8 v5, v5, 0x2

    mul-int v5, v5, p5

    const/4 v6, 0x4

    sub-int v14, v5, v6

    const/4 v5, 0x0

    aget-byte v15, p7, v5

    const/16 v17, 0x0

    move/from16 v16, p6

    invoke-virtual/range {v11 .. v17}, Ldm/Ui;->sliding(IIIIIZ)V

    .line 1564
    return-void

    .line 1548
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfoList:[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfo_dir:[[B

    move-object v7, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v8, v0

    aget-object v7, v7, v8

    aget-byte v7, v7, v18

    aget-byte v6, v6, v7

    const/4 v7, 0x2

    if-ne v6, v7, :cond_3

    const/16 v6, 0x19

    :goto_1
    const/16 v7, 0xa

    sub-int v7, p1, v7

    const/4 v8, 0x1

    aget-byte v8, p7, v8

    sub-int v8, v18, v8

    add-int/lit8 v9, p4, 0x4

    add-int/lit8 v9, v9, 0x2

    mul-int/2addr v8, v9

    add-int v8, v8, p2

    add-int/lit8 v8, v8, 0xb

    sget-object v9, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v9, 0x8

    sget-object v10, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v9, v9, 0x10

    const/4 v10, 0x0

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawUi(IIIII)V

    .line 1549
    const/4 v5, 0x0

    aget-byte v5, p7, v5

    move v0, v5

    move/from16 v1, v18

    if-ne v0, v1, :cond_4

    const/4 v5, 0x0

    :goto_2
    int-to-byte v10, v5

    .line 1550
    .local v10, "color":B
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->infoStart:B

    move v7, v0

    add-int v7, v7, v18

    add-int/lit8 v7, v7, 0x1

    const/16 v8, 0xa

    if-ge v7, v8, :cond_6

    const-string v7, "0"

    :goto_3
    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->infoStart:B

    move v7, v0

    add-int v7, v7, v18

    add-int/lit8 v7, v7, 0x1

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfoList:[B

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfo_dir:[[B

    move-object v8, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v9, v0

    aget-object v8, v8, v9

    aget-byte v8, v8, v18

    aget-byte v7, v7, v8

    if-eqz v7, :cond_7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfo_dir:[[B

    move-object v7, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v8, v0

    aget-object v7, v7, v8

    aget-byte v7, v7, v18

    move-object/from16 v0, p0

    move v1, v7

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v7

    :goto_4
    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 1551
    add-int/lit8 v7, p1, 0xa

    const/4 v8, 0x1

    aget-byte v8, p7, v8

    sub-int v8, v18, v8

    add-int/lit8 v9, p4, 0x4

    add-int/lit8 v9, v9, 0x2

    mul-int/2addr v8, v9

    add-int v8, v8, p2

    add-int/lit8 v8, v8, 0x5

    const/4 v9, 0x0

    const/4 v11, 0x0

    .line 1550
    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1552
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monAppearMap:[[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfo_dir:[[B

    move-object v7, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v8, v0

    aget-object v7, v7, v8

    aget-byte v7, v7, v18

    aget-object v6, v6, v7

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    move v1, v6

    invoke-direct {v0, v1}, Lmain/GameRun;->getInfoType(I)Ljava/lang/String;

    move-result-object v6

    .line 1553
    sget v7, Lmain/Constants_H;->WIDTH:I

    const/16 v8, 0x19

    sub-int/2addr v7, v8

    const/16 v8, 0xf

    sub-int/2addr v7, v8

    const/4 v8, 0x1

    aget-byte v8, p7, v8

    sub-int v8, v18, v8

    add-int/lit8 v9, p4, 0x4

    add-int/lit8 v9, v9, 0x2

    mul-int/2addr v8, v9

    add-int v8, v8, p2

    add-int/lit8 v8, v8, 0x5

    sget-object v9, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v9, 0x8

    sget-object v11, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v9, v9, 0x10

    const/4 v11, 0x0

    .line 1552
    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1554
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    const/4 v6, 0x1

    aget-byte v6, p7, v6

    sub-int v6, v18, v6

    add-int/lit8 v7, p4, 0x4

    add-int/lit8 v7, v7, 0x2

    mul-int/2addr v6, v7

    add-int v6, v6, p2

    add-int/lit8 v6, v6, 0x5

    add-int/lit8 v7, p4, 0x4

    add-int/lit8 v7, v7, 0x2

    move-object v0, v5

    move/from16 v1, p1

    move v2, v6

    move/from16 v3, p3

    move v4, v7

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 1555
    const/4 v5, 0x0

    aget-byte v5, p7, v5

    move v0, v5

    move/from16 v1, v18

    if-ne v0, v1, :cond_8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/PointerKey;->setKey5()V

    .line 1547
    :cond_2
    :goto_5
    add-int/lit8 v5, v18, 0x1

    move v0, v5

    int-to-byte v0, v0

    move/from16 v18, v0

    goto/16 :goto_0

    .line 1548
    .end local v10    # "color":B
    :cond_3
    const/16 v6, 0x30

    goto/16 :goto_1

    .line 1549
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfoList:[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfo_dir:[[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v7, v0

    aget-object v6, v6, v7

    aget-byte v6, v6, v18

    aget-byte v5, v5, v6

    if-eqz v5, :cond_5

    const/4 v5, 0x3

    goto/16 :goto_2

    :cond_5
    const/4 v5, -0x1

    goto/16 :goto_2

    .line 1550
    .restart local v10    # "color":B
    :cond_6
    const-string v7, ""

    goto/16 :goto_3

    :cond_7
    const-string v7, "\u672a\u77e5\u5ba0\u7269"

    goto/16 :goto_4

    .line 1557
    :cond_8
    const/4 v5, 0x0

    aput-byte v18, p7, v5

    .line 1558
    const/4 v5, 0x1

    aget-byte v5, p7, v5

    sub-int v5, v18, v5

    if-nez v5, :cond_9

    const/4 v5, 0x1

    aget-byte v5, p7, v5

    if-lez v5, :cond_9

    const/4 v5, 0x1

    aget-byte v6, p7, v5

    const/4 v7, 0x1

    sub-int/2addr v6, v7

    int-to-byte v6, v6

    aput-byte v6, p7, v5

    goto :goto_5

    .line 1559
    :cond_9
    const/4 v5, 0x1

    aget-byte v5, p7, v5

    sub-int v5, v18, v5

    const/4 v6, 0x1

    sub-int v6, p5, v6

    if-ne v5, v6, :cond_2

    const/4 v5, 0x1

    aget-byte v5, p7, v5

    add-int v5, v5, p5

    move v0, v5

    move/from16 v1, p6

    if-ge v0, v1, :cond_2

    const/4 v5, 0x1

    aget-byte v6, p7, v5

    add-int/lit8 v6, v6, 0x1

    int-to-byte v6, v6

    aput-byte v6, p7, v5

    goto :goto_5
.end method

.method private drawItemList(IIII[BIII)V
    .locals 19
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "show_num"    # I
    .param p5, "sel"    # [B
    .param p6, "itemType"    # I
    .param p7, "length"    # I
    .param p8, "mode"    # I

    .prologue
    .line 1070
    const/4 v5, 0x1

    aget-byte v17, p5, v5

    .local v17, "i":B
    const/16 v16, 0x1e

    .line 1071
    .local v16, "fh":B
    const-string v18, ""

    .line 1072
    .local v18, "str":Ljava/lang/String;
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x4

    sub-int v7, p1, v6

    const/4 v10, 0x4

    add-int/lit8 v11, v16, 0x1

    const/4 v12, -0x1

    const/4 v6, 0x0

    aget-byte v6, p5, v6

    const/4 v8, 0x1

    aget-byte v8, p5, v8

    sub-int v13, v6, v8

    const/4 v14, 0x4

    const/4 v15, 0x2

    move/from16 v6, p4

    move/from16 v8, p2

    move/from16 v9, p3

    invoke-virtual/range {v5 .. v15}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    move-object/from16 v6, v18

    .line 1073
    .end local v18    # "str":Ljava/lang/String;
    .local v6, "str":Ljava/lang/String;
    :goto_0
    const/4 v5, 0x1

    aget-byte v5, p5, v5

    add-int v5, v5, p4

    move/from16 v0, v17

    move v1, v5

    if-lt v0, v1, :cond_0

    .line 1107
    return-void

    .line 1074
    :cond_0
    move/from16 v0, v17

    move/from16 v1, p7

    if-ge v0, v1, :cond_2

    .line 1075
    if-eqz p8, :cond_1

    const/4 v5, 0x2

    move/from16 v0, p8

    move v1, v5

    if-ne v0, v1, :cond_6

    .line 1076
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->items:[[[B

    move-object v5, v0

    aget-object v5, v5, p6

    aget-object v5, v5, v17

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    .end local v6    # "str":Ljava/lang/String;
    add-int/lit8 v6, p1, 0x3

    add-int/lit8 v7, p2, 0x4

    const/4 v8, 0x1

    aget-byte v8, p5, v8

    sub-int v8, v17, v8

    mul-int v8, v8, v16

    add-int/2addr v7, v8

    const/4 v8, 0x0

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawItem(IIII)V

    .line 1077
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->items:[[[B

    move-object v6, v0

    aget-object v6, v6, p6

    aget-object v6, v6, v17

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    move v1, v6

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v6

    add-int/lit8 v7, p1, 0x15

    add-int/lit8 v8, p2, 0x1

    const/4 v9, 0x1

    aget-byte v9, p5, v9

    sub-int v9, v17, v9

    mul-int v9, v9, v16

    add-int/2addr v8, v9

    const/4 v9, 0x0

    const/4 v10, 0x0

    aget-byte v10, p5, v10

    move v0, v10

    move/from16 v1, v17

    if-ne v0, v1, :cond_3

    const/4 v10, 0x0

    :goto_1
    const/4 v11, 0x0

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1078
    const/4 v5, 0x2

    move/from16 v0, p8

    move v1, v5

    if-ne v0, v1, :cond_4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->items:[[[B

    move-object v6, v0

    aget-object v6, v6, p6

    aget-object v6, v6, v17

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    const/4 v7, 0x0

    move-object/from16 v0, p0

    move/from16 v1, p6

    move v2, v6

    move v3, v7

    invoke-direct {v0, v1, v2, v3}, Lmain/GameRun;->getPrice(IIZ)S

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\u91d1"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 1080
    .restart local v6    # "str":Ljava/lang/String;
    :goto_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    add-int v7, p1, p3

    const/16 v8, 0xc

    sub-int/2addr v7, v8

    add-int/lit8 v8, p2, 0x1

    const/4 v9, 0x1

    aget-byte v9, p5, v9

    sub-int v9, v17, v9

    mul-int v9, v9, v16

    add-int/2addr v8, v9

    sget-object v9, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v9, 0x8

    sget-object v10, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v9, v9, 0x10

    const/4 v10, 0x0

    aget-byte v10, p5, v10

    move v0, v10

    move/from16 v1, v17

    if-ne v0, v1, :cond_5

    const/4 v10, 0x0

    :goto_3
    const/4 v11, 0x0

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1090
    :goto_4
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    const/4 v7, -0x1

    if-ne v5, v7, :cond_2

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->say_c:B

    move v5, v0

    if-nez v5, :cond_2

    .line 1091
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    const/4 v7, 0x1

    aget-byte v7, p5, v7

    sub-int v7, v17, v7

    mul-int v7, v7, v16

    add-int v7, v7, p2

    sget v8, Lmain/Constants_H;->WIDTH:I

    move-object v0, v5

    move/from16 v1, p1

    move v2, v7

    move v3, v8

    move/from16 v4, v16

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 1092
    const/4 v5, 0x0

    aget-byte v5, p5, v5

    move v0, v5

    move/from16 v1, v17

    if-ne v0, v1, :cond_9

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/PointerKey;->setKey5()V

    .line 1104
    :cond_2
    :goto_5
    add-int/lit8 v5, v17, 0x1

    move v0, v5

    int-to-byte v0, v0

    move/from16 v17, v0

    goto/16 :goto_0

    .line 1077
    .end local v6    # "str":Ljava/lang/String;
    :cond_3
    const/4 v10, 0x3

    goto/16 :goto_1

    .line 1079
    :cond_4
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "x"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->items:[[[B

    move-object v6, v0

    aget-object v6, v6, p6

    aget-object v6, v6, v17

    const/4 v7, 0x1

    aget-byte v6, v6, v7

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .restart local v6    # "str":Ljava/lang/String;
    goto/16 :goto_2

    .line 1080
    :cond_5
    const/4 v10, 0x3

    goto :goto_3

    .line 1082
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->buyItem:[[B

    move-object v5, v0

    aget-object v5, v5, p6

    aget-byte v5, v5, v17

    add-int/lit8 v6, p1, 0x2

    add-int/lit8 v7, p2, 0x4

    const/4 v8, 0x1

    aget-byte v8, p5, v8

    .end local v6    # "str":Ljava/lang/String;
    sub-int v8, v17, v8

    mul-int v8, v8, v16

    add-int/2addr v7, v8

    const/4 v8, 0x0

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawItem(IIII)V

    .line 1083
    const/4 v5, 0x0

    aget-byte v5, p5, v5

    move v0, v5

    move/from16 v1, v17

    if-ne v0, v1, :cond_7

    const/4 v5, 0x0

    :goto_6
    int-to-byte v12, v5

    .line 1084
    .local v12, "color":B
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->buyItem:[[B

    move-object v5, v0

    aget-object v5, v5, p6

    aget-byte v5, v5, v17

    move-object/from16 v0, p0

    move v1, v5

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v8

    add-int/lit8 v9, p1, 0x14

    const/4 v5, 0x1

    aget-byte v5, p5, v5

    sub-int v5, v17, v5

    mul-int v5, v5, v16

    add-int v10, p2, v5

    const/4 v11, 0x0

    const/4 v13, 0x0

    invoke-virtual/range {v7 .. v13}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1085
    const/4 v5, 0x2

    move/from16 v0, p6

    move v1, v5

    if-ne v0, v1, :cond_8

    const-string v6, "\u5fbd\u7ae0"

    .line 1087
    .restart local v6    # "str":Ljava/lang/String;
    :goto_7
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v7

    new-instance v5, Ljava/lang/StringBuilder;

    const/4 v8, 0x1

    move-object/from16 v0, p0

    move/from16 v1, p6

    move/from16 v2, v17

    move v3, v8

    invoke-direct {v0, v1, v2, v3}, Lmain/GameRun;->getPrice(IIZ)S

    move-result v8

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v5, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    add-int v5, p1, p3

    const/16 v9, 0xc

    sub-int v9, v5, v9

    add-int/lit8 v5, p2, 0x1

    const/4 v10, 0x1

    aget-byte v10, p5, v10

    sub-int v10, v17, v10

    mul-int v10, v10, v16

    add-int/2addr v10, v5

    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v5, 0x8

    sget-object v11, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v11, v5, 0x10

    const/4 v13, 0x0

    invoke-virtual/range {v7 .. v13}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto/16 :goto_4

    .line 1083
    .end local v6    # "str":Ljava/lang/String;
    .end local v12    # "color":B
    :cond_7
    const/4 v5, 0x3

    goto :goto_6

    .line 1086
    .restart local v12    # "color":B
    :cond_8
    const-string v6, "\u91d1"

    .restart local v6    # "str":Ljava/lang/String;
    goto :goto_7

    .line 1094
    .end local v12    # "color":B
    :cond_9
    const/4 v5, 0x0

    aput-byte v17, p5, v5

    .line 1095
    const/4 v5, 0x1

    aget-byte v5, p5, v5

    sub-int v5, v17, v5

    if-nez v5, :cond_b

    const/4 v5, 0x1

    aget-byte v5, p5, v5

    if-lez v5, :cond_b

    const/4 v5, 0x1

    aget-byte v7, p5, v5

    const/4 v8, 0x1

    sub-int/2addr v7, v8

    int-to-byte v7, v7

    aput-byte v7, p5, v5

    .line 1097
    :cond_a
    :goto_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select_it:[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->selectx:B

    move v7, v0

    const/4 v8, 0x0

    aget-byte v8, p5, v8

    aput-byte v8, v5, v7

    .line 1098
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select_st:[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->selectx:B

    move v7, v0

    const/4 v8, 0x1

    aget-byte v8, p5, v8

    aput-byte v8, v5, v7

    goto/16 :goto_5

    .line 1096
    :cond_b
    const/4 v5, 0x1

    aget-byte v5, p5, v5

    sub-int v5, v17, v5

    const/4 v7, 0x1

    sub-int v7, p4, v7

    if-ne v5, v7, :cond_a

    const/4 v5, 0x1

    aget-byte v5, p5, v5

    add-int v5, v5, p4

    move v0, v5

    move/from16 v1, p7

    if-ge v0, v1, :cond_a

    const/4 v5, 0x1

    aget-byte v7, p5, v5

    add-int/lit8 v7, v7, 0x1

    int-to-byte v7, v7

    aput-byte v7, p5, v5

    goto :goto_8
.end method

.method private drawLIST_INFO()V
    .locals 13

    .prologue
    .line 1451
    const/16 v9, 0x280

    .local v9, "WIDTH":I
    const/16 v8, 0x168

    .line 1452
    .local v8, "HEIGHT":I
    const/16 v10, 0x140

    .line 1453
    .local v10, "WIDTH_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ui;->fillRectB()V

    .line 1454
    const/16 v0, 0x18

    const/16 v1, 0x23

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->drawInfoBG(II)V

    .line 1462
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u53d1\u73b0\u5ea6 "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->monInfoList:[B

    const/16 v4, 0x66

    aget-byte v3, v3, v4

    mul-int/lit16 v3, v3, 0x3e8

    div-int/lit8 v3, v3, 0x66

    invoke-virtual {v2, v3}, Ldm/Ms;->getPrecision(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "%"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0xc

    sub-int v2, v9, v2

    const/16 v3, 0x22

    sget-object v4, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v4, 0x8

    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v4, v4, 0x10

    const/4 v5, 0x3

    const/4 v6, 0x1

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1463
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->monsterT:[Ljava/lang/StringBuffer;

    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x1c

    const/16 v3, 0x22

    const/4 v4, 0x0

    const/4 v5, 0x1

    const/4 v6, 0x2

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1471
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u6355\u6349\u79cd\u7c7b "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/GameRun;->monInfoList:[B

    const/16 v3, 0x67

    aget-byte v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x64

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    add-int/lit8 v3, v8, 0x1

    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v2, 0x1

    sget-object v4, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v4, v2, 0x20

    const/4 v5, 0x3

    const/4 v6, 0x1

    move v2, v10

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1472
    iget-object v0, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    const/4 v1, 0x5

    const/16 v2, 0x64

    const/4 v3, 0x0

    div-int/lit8 v4, v9, 0x6

    const/16 v5, 0x23

    invoke-virtual/range {v0 .. v5}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v12

    .line 1473
    .local v12, "t":B
    const/4 v0, -0x1

    if-eq v12, v0, :cond_1

    .line 1474
    iput-byte v12, p0, Lmain/GameRun;->cur_a:B

    .line 1475
    const/4 v0, 0x0

    iput-byte v0, p0, Lmain/GameRun;->infoStart:B

    .line 1476
    iget-byte v0, p0, Lmain/GameRun;->cur_a:B

    if-lez v0, :cond_0

    .line 1477
    const/4 v11, 0x0

    .local v11, "i":B
    :goto_0
    iget-byte v0, p0, Lmain/GameRun;->cur_a:B

    if-lt v11, v0, :cond_2

    .line 1480
    .end local v11    # "i":B
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->monInfo_dir:[[B

    iget-byte v1, p0, Lmain/GameRun;->cur_a:B

    aget-object v0, v0, v1

    array-length v0, v0

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->t_length:B

    .line 1481
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/4 v1, 0x0

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    const/4 v3, 0x0

    aget-object v2, v2, v3

    const/4 v3, 0x1

    const/4 v4, 0x0

    aput-byte v4, v2, v3

    aput-byte v4, v0, v1

    .line 1489
    :cond_1
    const/4 v11, 0x0

    .restart local v11    # "i":B
    :goto_1
    const/4 v0, 0x5

    if-lt v11, v0, :cond_3

    .line 1505
    const/16 v1, 0x20

    const/16 v2, 0x43

    const/16 v0, 0x32

    sub-int v3, v9, v0

    const/16 v4, 0x1d

    iget-byte v5, p0, Lmain/GameRun;->list_rows:B

    iget-byte v6, p0, Lmain/GameRun;->t_length:B

    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v7, 0x0

    aget-object v7, v0, v7

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lmain/GameRun;->drawInfoList(IIIIII[B)V

    .line 1507
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, v10, 0xa

    const/16 v2, 0xc

    const/16 v3, 0x14b

    const/4 v4, 0x1

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 1513
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->monInfoList:[B

    invoke-direct {p0}, Lmain/GameRun;->getMonInfo_dir()B

    move-result v2

    aget-byte v1, v1, v2

    if-eqz v1, :cond_5

    const/4 v1, 0x1

    :goto_2
    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 1514
    return-void

    .line 1478
    :cond_2
    iget-byte v0, p0, Lmain/GameRun;->infoStart:B

    iget-object v1, p0, Lmain/GameRun;->monInfo_dir:[[B

    aget-object v1, v1, v11

    array-length v1, v1

    add-int/2addr v0, v1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->infoStart:B

    .line 1477
    add-int/lit8 v0, v11, 0x1

    int-to-byte v11, v0

    goto :goto_0

    .line 1490
    :cond_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->cur_a:B

    if-ne v1, v11, :cond_4

    const/4 v1, 0x5

    :goto_3
    add-int/2addr v1, v11

    const/16 v2, 0x1a

    sub-int v2, v9, v2

    add-int/lit8 v2, v11, 0x1

    mul-int/lit16 v2, v2, 0x266

    div-int/lit8 v2, v2, 0x6

    add-int/lit8 v2, v2, 0x12

    const/16 v3, 0xc

    sget-object v4, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v4, 0x4

    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v4, v4, 0x2

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 1489
    add-int/lit8 v0, v11, 0x1

    int-to-byte v11, v0

    goto :goto_1

    .line 1490
    :cond_4
    const/4 v1, 0x0

    goto :goto_3

    .line 1513
    :cond_5
    const/4 v1, 0x0

    goto :goto_2
.end method

.method private drawMONSTER_INFO(I)V
    .locals 33
    .param p1, "id"    # I

    .prologue
    .line 1770
    const/16 v28, 0x280

    .local v28, "WIDTH":I
    const/16 v27, 0x168

    .line 1771
    .local v27, "HEIGHT":I
    const/16 v29, 0x140

    .line 1775
    .local v29, "WIDTH_H":I
    const/16 v2, 0x8c

    sub-int v3, v29, v2

    .local v3, "offx":I
    const/16 v5, 0x118

    .line 1776
    .local v5, "offw":I
    add-int/lit8 v12, v3, 0xc

    .local v12, "x":I
    const/16 v13, 0x23

    .line 1790
    .local v13, "y":I
    const/16 v14, 0x64

    .local v14, "w":I
    const/16 v15, 0x5a

    .line 1796
    .local v15, "h":I
    const/16 v30, 0x1d

    .local v30, "fw":I
    const/16 v10, 0x1d

    .line 1798
    .local v10, "fh":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ui;->fillRectB()V

    .line 1800
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v4, 0x2

    const/4 v6, 0x2

    sub-int v6, v27, v6

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawK2(IIIII)V

    .line 1809
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    mul-int/lit8 v2, v30, 0x4

    sub-int v2, v29, v2

    const/4 v3, 0x4

    sub-int v7, v2, v3

    const/4 v8, 0x6

    mul-int/lit8 v9, v30, 0x8

    const/4 v11, 0x4

    invoke-virtual/range {v6 .. v11}, Ldm/Ui;->drawK1(IIIII)V

    .line 1811
    .end local v3    # "offx":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    const/16 v16, 0x1

    invoke-virtual/range {v11 .. v16}, Ldm/Ui;->drawK1(IIIII)V

    .line 1823
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    move/from16 v0, v30

    add-int/lit16 v0, v0, 0xc0

    move v2, v0

    add-int/lit8 v17, v2, 0x8

    add-int v2, v13, v15

    add-int/lit8 v18, v2, 0x4

    add-int/lit8 v2, v30, 0x19

    sub-int v19, v5, v2

    mul-int/lit8 v20, v10, 0x4

    const/16 v21, 0x1

    invoke-virtual/range {v16 .. v21}, Ldm/Ui;->drawK1(IIIII)V

    .line 1827
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    add-int v2, v13, v15

    add-int/lit8 v18, v2, 0x4

    mul-int/lit8 v20, v10, 0x4

    const/16 v21, 0x3

    move/from16 v17, v12

    move/from16 v19, v30

    invoke-virtual/range {v16 .. v21}, Ldm/Ui;->drawK1(IIIII)V

    .line 1828
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    const/16 v2, 0xd

    sub-int v2, v27, v2

    mul-int/lit8 v3, v10, 0x3

    sub-int v18, v2, v3

    shl-int/lit8 v2, v12, 0x1

    sub-int v2, v28, v2

    add-int/lit8 v19, v2, 0x2

    mul-int/lit8 v2, v10, 0x3

    add-int/lit8 v20, v2, 0xa

    const/16 v21, 0x2

    move/from16 v17, v12

    invoke-virtual/range {v16 .. v21}, Ldm/Ui;->drawK1(IIIII)V

    .line 1830
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 1831
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->cur_a:B

    move v2, v0

    add-int/lit8 v17, v2, 0x5

    add-int/lit8 v18, v12, 0x2

    add-int/lit8 v19, v13, 0x2

    const/16 v20, 0x0

    const/16 v21, 0x0

    invoke-virtual/range {v16 .. v21}, Ldm/Ui;->drawUi(IIIII)V

    .line 1832
    const-string v2, "sk"

    const-string v3, "drawUi"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1833
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-virtual/range {p0 .. p1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "\uff08"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monInfoList:[B

    move-object v3, v0

    aget-byte v3, v3, p1

    const/4 v4, 0x2

    if-ne v3, v4, :cond_2

    const-string v3, "\u5df2\u6355\u83b7"

    :goto_0
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\uff09"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    const/16 v19, 0x6

    const/16 v20, 0x11

    const/16 v21, 0x0

    const/16 v22, 0x0

    move/from16 v18, v29

    invoke-virtual/range {v16 .. v22}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1834
    const/16 v17, 0x1

    const/16 v18, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v2, v0

    aget-object v2, v2, p1

    const/4 v3, 0x1

    aget-byte v2, v2, v3

    mul-int/lit8 v2, v2, 0x3

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mon_action:B

    move v3, v0

    add-int v19, v2, v3

    .line 1835
    shr-int/lit8 v2, v14, 0x1

    add-int/lit8 v20, v12, 0x32

    add-int v2, v13, v15

    const/16 v3, 0xa

    sub-int v21, v2, v3

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mon_action:B

    move v2, v0

    const/4 v3, 0x1

    if-ne v2, v3, :cond_3

    const/4 v2, 0x0

    move/from16 v22, v2

    :goto_1
    const/16 v23, 0x0

    move-object/from16 v16, p0

    .line 1834
    invoke-virtual/range {v16 .. v23}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1835
    const/4 v2, 0x0

    move v0, v2

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->mon_action:B

    .line 1842
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    const-string v17, "\u53d1\u73b0\u5730\u70b9"

    add-int/lit16 v2, v14, 0xc0

    add-int/lit8 v18, v2, 0x5

    const/16 v20, 0x0

    const/16 v21, 0x1

    const/16 v22, 0x1

    move/from16 v19, v13

    invoke-virtual/range {v16 .. v22}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1845
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monAppearMap:[[B

    move-object v2, v0

    aget-object v2, v2, p1

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    const/4 v3, -0x1

    if-le v2, v3, :cond_5

    .line 1853
    const/16 v31, 0x0

    .local v31, "i":B
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monAppearMap:[[B

    move-object v2, v0

    aget-object v2, v2, p1

    array-length v2, v2

    move/from16 v0, v31

    move v1, v2

    if-lt v0, v1, :cond_4

    .line 1864
    .end local v31    # "i":B
    :goto_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    const-string v17, "\u8fdb"

    add-int/lit8 v2, v12, 0xc

    add-int/lit8 v18, v2, 0x2

    add-int v2, v13, v15

    add-int/lit8 v19, v2, 0x14

    const/16 v20, 0x11

    const/16 v21, 0x3

    const/16 v22, 0x1

    invoke-virtual/range {v16 .. v22}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1865
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    const-string v17, "\u5316"

    add-int/lit8 v2, v12, 0xc

    add-int/lit8 v18, v2, 0x2

    add-int v2, v13, v15

    add-int/lit8 v2, v2, 0x1c

    move v0, v10

    add-int/lit16 v0, v0, 0x99

    move/from16 v19, v0

    const/16 v20, 0x11

    const/16 v21, 0x3

    const/16 v22, 0x1

    invoke-virtual/range {v16 .. v22}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1866
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    const/16 v17, 0x3

    move/from16 v0, v30

    add-int/lit16 v0, v0, 0xc0

    move v2, v0

    add-int/lit8 v18, v2, 0x8

    add-int v2, v13, v15

    add-int/lit8 v19, v2, 0xa

    add-int/lit8 v2, v30, 0x19

    sub-int v20, v5, v2

    const/16 v21, 0x3

    add-int/lit8 v22, v10, 0x4

    const/16 v23, 0x0

    const/16 v24, -0x1

    const/16 v25, 0x4

    const/16 v26, 0x2

    invoke-virtual/range {v16 .. v26}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 1872
    const/16 v31, 0x2

    .restart local v31    # "i":B
    const/16 v32, 0x0

    .end local v5    # "offw":I
    .local v32, "j":B
    :goto_4
    const/4 v2, 0x7

    move/from16 v0, v31

    move v1, v2

    if-lt v0, v1, :cond_6

    .line 1885
    invoke-virtual/range {p0 .. p1}, Lmain/GameRun;->getNameMonsterInfo(I)Ljava/lang/String;

    move-result-object v17

    const/16 v2, 0xc

    sub-int v2, v27, v2

    mul-int/lit8 v3, v10, 0x3

    sub-int v19, v2, v3

    const/16 v20, 0xa

    const/16 v21, 0x3

    move-object/from16 v16, p0

    move/from16 v18, v29

    invoke-virtual/range {v16 .. v21}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 1888
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mon_action_c:B

    move v2, v0

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    move v0, v2

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->mon_action_c:B

    const/16 v3, 0x32

    if-le v2, v3, :cond_1

    .line 1889
    const/4 v2, 0x0

    move v0, v2

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->mon_action_c:B

    .line 1890
    const/4 v2, 0x1

    move v0, v2

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->mon_action:B

    .line 1892
    :cond_1
    return-void

    .line 1833
    .end local v31    # "i":B
    .end local v32    # "j":B
    .restart local v5    # "offw":I
    :cond_2
    const-string v3, "\u672a\u6355\u83b7"

    goto/16 :goto_0

    .line 1835
    :cond_3
    const/4 v2, 0x1

    move/from16 v22, v2

    goto/16 :goto_1

    .line 1854
    .restart local v31    # "i":B
    :cond_4
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->city_name:[Ljava/lang/StringBuffer;

    move-object v2, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monAppearMap:[[B

    move-object v3, v0

    aget-object v3, v3, p1

    aget-byte v3, v3, v31

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v17

    add-int/lit16 v2, v14, 0xc0

    add-int/lit8 v18, v2, 0x5

    add-int/lit8 v2, v31, 0x1

    mul-int/lit8 v2, v2, 0x19

    add-int v19, v13, v2

    const/16 v20, 0x0

    const/16 v21, 0x1

    const/16 v22, 0x0

    invoke-virtual/range {v16 .. v22}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1853
    add-int/lit8 v2, v31, 0x1

    move v0, v2

    int-to-byte v0, v0

    move/from16 v31, v0

    goto/16 :goto_2

    .line 1856
    .end local v31    # "i":B
    :cond_5
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    const-string v17, "\u672a\u77e5"

    add-int/lit16 v2, v14, 0xc0

    add-int/lit8 v18, v2, 0x5

    add-int/lit8 v19, v13, 0x19

    const/16 v20, 0x0

    const/16 v21, 0x1

    const/16 v22, 0x0

    invoke-virtual/range {v16 .. v22}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto/16 :goto_3

    .line 1873
    .end local v5    # "offw":I
    .restart local v31    # "i":B
    .restart local v32    # "j":B
    :cond_6
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v16

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u6750\u6599\uff1a"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monsterMake:[[B

    move-object v3, v0

    aget-object v3, v3, p1

    array-length v3, v3

    if-eqz v3, :cond_7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monsterMake:[[B

    move-object v3, v0

    aget-object v3, v3, p1

    array-length v3, v3

    move/from16 v0, v31

    move v1, v3

    if-lt v0, v1, :cond_8

    :cond_7
    const-string v3, ""

    .line 1877
    :goto_5
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move/from16 v0, v30

    add-int/lit16 v0, v0, 0xc0

    move v2, v0

    add-int/lit8 v18, v2, 0xe

    add-int v2, v13, v15

    add-int/lit8 v2, v2, 0xc

    add-int/lit8 v2, v10, 0x4

    mul-int/lit8 v2, v32, 0x21

    move v0, v2

    add-int/lit16 v0, v0, 0x89

    move/from16 v19, v0

    const/16 v20, 0x0

    const/16 v21, 0x3

    const/16 v22, 0x0

    .line 1873
    invoke-virtual/range {v16 .. v22}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1872
    add-int/lit8 v2, v31, 0x2

    move v0, v2

    int-to-byte v0, v0

    move/from16 v31, v0

    add-int/lit8 v2, v32, 0x1

    move v0, v2

    int-to-byte v0, v0

    move/from16 v32, v0

    goto/16 :goto_4

    .line 1877
    :cond_8
    new-instance v3, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monsterMake:[[B

    move-object v4, v0

    aget-object v4, v4, p1

    aget-byte v4, v4, v31

    move-object/from16 v0, p0

    move v1, v4

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " x"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monsterMake:[[B

    move-object v4, v0

    aget-object v4, v4, p1

    add-int/lit8 v5, v31, 0x1

    aget-byte v4, v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_5
.end method

.method private drawMONSTER_UI([Ldm/Monster;)V
    .locals 29
    .param p1, "monsters"    # [Ldm/Monster;

    .prologue
    .line 1896
    const/16 v27, 0x280

    .local v27, "WIDTH":I
    const/16 v25, 0x168

    .line 1897
    .local v25, "HEIGHT":I
    const/16 v28, 0x140

    .local v28, "WIDTH_H":I
    const/16 v26, 0xb4

    .line 1899
    .local v26, "HEIGHT_H":I
    const/16 v4, 0x8c

    sub-int v5, v28, v4

    .local v5, "offx":I
    const/16 v7, 0x118

    .line 1900
    .local v7, "offw":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    invoke-virtual {v4}, Ldm/Ui;->fillRectB()V

    .line 1901
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    const/4 v6, 0x2

    const/4 v8, 0x2

    sub-int v8, v25, v8

    const/4 v9, 0x0

    invoke-virtual/range {v4 .. v9}, Ldm/Ui;->drawK2(IIIII)V

    .line 1916
    add-int/lit8 v9, v5, 0x6

    .local v9, "lx":I
    const/16 v16, 0x5

    .local v16, "ly":I
    const/16 v11, 0x76

    .local v11, "lw":I
    const/16 v12, 0x74

    .line 1920
    .local v12, "lh":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    add-int/lit8 v10, v16, 0x6

    const/4 v13, 0x1

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawK1(IIIII)V

    .line 1921
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->t_length:B

    move v4, v0

    if-eqz v4, :cond_0

    .line 1927
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    .end local v5    # "offx":I
    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-object v14, p1, v4

    add-int/lit8 v15, v9, 0x1e

    const/16 v17, 0x4a

    const/16 v18, 0x2

    const/16 v19, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-object v4, p1, v4

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    const/4 v5, 0x4

    aget-short v20, v4, v5

    move-object/from16 v13, p0

    invoke-direct/range {v13 .. v20}, Lmain/GameRun;->drawMonsterHp(Ldm/Monster;IIIIII)V

    .line 1929
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    new-instance v4, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v5, v0

    const/4 v6, 0x0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    aget-object v5, p1, v5

    iget-object v5, v5, Ldm/Monster;->monster:[B

    const/4 v6, 0x2

    aget-byte v5, v5, v6

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "\u7ea7"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    add-int/lit8 v19, v9, 0x2

    add-int/lit8 v20, v16, 0xa

    const/16 v21, 0x0

    const/16 v22, 0x0

    invoke-virtual/range {v17 .. v22}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 1930
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-object v4, p1, v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x3

    aget-byte v4, v4, v5

    add-int/lit8 v18, v4, 0x5

    add-int/lit8 v19, v9, 0x9

    add-int/lit8 v20, v16, 0xb

    const/16 v21, 0x11

    const/16 v22, 0x0

    invoke-virtual/range {v17 .. v22}, Ldm/Ui;->drawUi(IIIII)V

    .line 1931
    const/16 v18, 0x1

    const/16 v19, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v4, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v5, v0

    const/4 v6, 0x0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    aget-object v5, p1, v5

    iget-object v5, v5, Ldm/Monster;->monster:[B

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    aget-object v4, v4, v5

    const/4 v5, 0x1

    aget-byte v4, v4, v5

    mul-int/lit8 v4, v4, 0x3

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mon_action:B

    move v5, v0

    add-int v20, v4, v5

    .line 1932
    const/16 v21, 0xf8

    const/16 v22, 0x6f

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mon_action:B

    move v4, v0

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    const/4 v4, 0x0

    move/from16 v23, v4

    :goto_0
    const/16 v24, 0x0

    move-object/from16 v17, p0

    .line 1931
    invoke-virtual/range {v17 .. v24}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1932
    const/4 v4, 0x0

    move v0, v4

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->mon_action:B

    .line 1935
    :cond_0
    add-int/lit8 v4, v12, 0x16

    move/from16 v0, v16

    add-int/lit16 v0, v0, 0x8a

    move/from16 v16, v0

    shl-int/lit8 v4, v9, 0x1

    sub-int v4, v27, v4

    int-to-short v11, v4

    .line 1936
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v14

    sub-int v4, v25, v12

    const/16 v5, 0x20

    sub-int v18, v4, v5

    const/16 v19, 0x1

    move v15, v9

    move/from16 v17, v11

    invoke-virtual/range {v14 .. v19}, Ldm/Ui;->drawK1(IIIII)V

    .line 1944
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    add-int/lit8 v18, v9, 0x8

    add-int/lit8 v19, v16, 0xa

    const/16 v4, 0x10

    sub-int v20, v11, v4

    const/16 v21, 0x21

    const/16 v22, 0x3

    invoke-virtual/range {v17 .. v22}, Ldm/Ui;->drawK(IIIII)V

    .line 1946
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    add-int/lit8 v18, v9, 0x8

    move/from16 v0, v16

    add-int/lit16 v0, v0, 0x96

    move v4, v0

    add-int/lit8 v19, v4, 0xb

    const/16 v4, 0x10

    sub-int v20, v11, v4

    const/16 v21, 0x21

    const/16 v22, 0x3

    invoke-virtual/range {v17 .. v22}, Ldm/Ui;->drawK(IIIII)V

    .line 1952
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->t_length:B

    move v4, v0

    if-eqz v4, :cond_1

    .line 1974
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-object v4, p1, v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    move-object/from16 v0, p0

    move v1, v4

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNameMonsterInfo(I)Ljava/lang/String;

    move-result-object v18

    add-int/lit8 v19, v9, 0x9

    move/from16 v0, v16

    add-int/lit16 v0, v0, 0x96

    move v4, v0

    add-int/lit8 v20, v4, 0xd

    const/16 v4, 0x46

    sub-int v21, v11, v4

    const/16 v22, 0x0

    const/16 v23, 0x1

    const/16 v24, 0x2

    move-object/from16 v17, p0

    invoke-virtual/range {v17 .. v24}, Lmain/GameRun;->gogoWord(Ljava/lang/String;IIIIII)V

    .line 1978
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-object v4, p1, v4

    add-int/lit8 v5, v9, 0x2

    const/16 v6, 0xe

    sub-int v6, v16, v6

    move-object/from16 v0, p0

    move-object v1, v4

    move v2, v5

    move v3, v6

    invoke-direct {v0, v1, v2, v3}, Lmain/GameRun;->drawMonsterFealty(Ldm/Monster;II)V

    .line 1979
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monsterT:[Ljava/lang/StringBuffer;

    move-object v4, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v5, v0

    const/4 v6, 0x0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    aget-object v5, p1, v5

    iget-object v5, v5, Ldm/Monster;->monster:[B

    const/4 v6, 0x3

    aget-byte v5, v5, v6

    aget-object v4, v4, v5

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v18

    add-int/lit8 v19, v9, 0x19

    add-int/lit8 v20, v16, 0xc

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x1

    invoke-virtual/range {v17 .. v23}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1980
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-object v4, p1, v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x5

    aget-byte v4, v4, v5

    if-nez v4, :cond_5

    .line 1981
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    const-string v18, "\u4e0d\u53ef\u8fdb\u5316"

    add-int/lit8 v19, v9, 0x73

    add-int/lit8 v20, v16, 0xc

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x1

    invoke-virtual/range {v17 .. v23}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1985
    :cond_1
    :goto_1
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v9

    move/from16 v3, v16

    invoke-direct {v0, v1, v2, v3}, Lmain/GameRun;->drawMonPro([Ldm/Monster;II)V

    .line 1991
    add-int/lit16 v4, v7, 0xb4

    const/16 v5, 0x4b

    sub-int/2addr v4, v5

    const/16 v5, 0xf

    sub-int v9, v4, v5

    const/16 v16, 0x0

    const/16 v11, 0x4b

    .line 1995
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->t_length:B

    move v4, v0

    if-eqz v4, :cond_2

    .line 1999
    add-int/lit8 v19, v9, 0x2

    add-int/lit8 v20, v16, 0xd

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->list_rows:B

    move/from16 v21, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->t_length:B

    move/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v23, v4, v5

    move-object/from16 v17, p0

    move-object/from16 v18, p1

    invoke-direct/range {v17 .. v23}, Lmain/GameRun;->drawMonList([Ldm/Monster;IIII[B)V

    .line 2002
    :cond_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    add-int/lit16 v4, v7, 0xb4

    const/16 v5, 0x11

    sub-int v18, v4, v5

    add-int/lit8 v19, v16, 0xc

    add-int/lit8 v20, v12, 0x6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v21, v4, v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->t_length:B

    move/from16 v22, v0

    const/16 v23, 0x1

    invoke-virtual/range {v17 .. v23}, Ldm/Ui;->sliding(IIIIIZ)V

    .line 2003
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    new-instance v4, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->t_length:B

    move v5, v0

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mini_state:B

    move v5, v0

    const/4 v6, 0x6

    if-ne v5, v6, :cond_6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->max_monsters:B

    move v5, v0

    :goto_2
    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    add-int/lit16 v4, v7, 0xb4

    const/16 v5, 0x28

    sub-int v19, v4, v5

    add-int/lit8 v20, v16, 0xc

    const/16 v21, 0x0

    const/16 v22, 0x0

    invoke-virtual/range {v17 .. v22}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 2010
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v4, v0

    const/4 v5, -0x1

    if-eq v4, v5, :cond_3

    .line 2014
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    move-object/from16 v18, v0

    const/16 v4, 0x19

    sub-int v19, v28, v4

    const/16 v20, 0x1e

    const/16 v21, 0x4b

    const/16 v22, 0x2

    const/16 v23, 0x0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move/from16 v24, v0

    move-object/from16 v17, p0

    invoke-virtual/range {v17 .. v24}, Lmain/GameRun;->drawSelectMenu([Ljava/lang/Object;IIIIII)V

    .line 2016
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->buyOk:B

    move v4, v0

    const/4 v5, 0x1

    if-ne v4, v5, :cond_3

    .line 2018
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->gogoString:Ljava/lang/String;

    move-object v4, v0

    const/16 v5, 0x19

    sub-int v5, v26, v5

    const/4 v6, 0x0

    move-object/from16 v0, p0

    move-object v1, v4

    move v2, v5

    move v3, v6

    invoke-virtual {v0, v1, v2, v3}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    .line 2021
    :cond_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->t_length:B

    move v5, v0

    if-eqz v5, :cond_7

    const/4 v5, 0x1

    :goto_3
    const/4 v6, 0x1

    invoke-virtual {v4, v5, v6}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 2022
    return-void

    .line 1932
    :cond_4
    const/4 v4, 0x1

    move/from16 v23, v4

    goto/16 :goto_0

    .line 1982
    :cond_5
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v17

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "\u53ef\u8fdb\u5316"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v5, v0

    const/4 v6, 0x0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    aget-object v5, p1, v5

    iget-object v5, v5, Ldm/Monster;->monster:[B

    const/4 v6, 0x5

    aget-byte v5, v5, v6

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\u6b21"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    add-int/lit8 v19, v9, 0x73

    add-int/lit8 v20, v16, 0xc

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v23, 0x1

    invoke-virtual/range {v17 .. v23}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto/16 :goto_1

    .line 2003
    :cond_6
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->max_takes:B

    move v5, v0

    goto/16 :goto_2

    .line 2021
    :cond_7
    const/4 v5, 0x0

    goto :goto_3
.end method

.method private drawMY_BAG(IIII)V
    .locals 11
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    .line 971
    iget-object v0, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    array-length v0, v0

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    int-to-byte v9, v0

    .line 972
    .local v9, "i":B
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ui;->fillRectB()V

    .line 973
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p1, 0x1

    add-int/lit8 v2, p2, 0x3

    const/4 v3, 0x2

    sub-int v3, p3, v3

    const/4 v4, 0x3

    sub-int v4, p4, v4

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK2(IIIII)V

    .line 977
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p1, 0x5

    add-int/lit8 v2, p2, 0x19

    add-int/lit8 v2, v2, 0xe

    const/16 v3, 0x17

    sub-int v3, p3, v3

    iget-byte v4, p0, Lmain/GameRun;->list_rows:B

    mul-int/lit8 v4, v4, 0x1f

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 984
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, p1, 0x5

    add-int/lit8 v2, p2, 0x19

    add-int/lit8 v2, v2, 0x14

    iget-byte v3, p0, Lmain/GameRun;->list_rows:B

    mul-int/lit8 v3, v3, 0x1f

    add-int/2addr v2, v3

    const/16 v3, 0xa

    sub-int v3, p3, v3

    const/16 v4, 0x5a

    const/4 v5, 0x2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 986
    if-nez v9, :cond_3

    .line 987
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    shr-int/lit8 v1, p3, 0x1

    add-int/2addr v1, p1

    const/16 v2, 0x19

    sub-int/2addr v1, v2

    const/16 v2, 0x9

    sub-int/2addr v1, v2

    add-int/lit8 v2, p2, 0x8

    const/16 v3, 0x42

    const/16 v4, 0x1c

    const/4 v5, 0x4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 988
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    aget-object v1, v1, v9

    shr-int/lit8 v2, p3, 0x1

    add-int/2addr v2, p1

    add-int/lit8 v3, p2, 0x7

    const/16 v4, 0x11

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 989
    const-string v0, "sk"

    const-string v1, "drawMY_BAG"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1042
    :cond_0
    :goto_0
    add-int/lit8 v1, p1, 0x9

    add-int/lit8 v0, p2, 0x19

    add-int/lit8 v2, v0, 0x11

    const/16 v0, 0x17

    sub-int v3, p3, v0

    iget-byte v4, p0, Lmain/GameRun;->list_rows:B

    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v5, 0x0

    aget-object v5, v0, v5

    iget-byte v6, p0, Lmain/GameRun;->selectx:B

    iget-object v0, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v7, p0, Lmain/GameRun;->selectx:B

    aget-byte v7, v0, v7

    const/4 v8, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v8}, Lmain/GameRun;->drawItemList(IIII[BIII)V

    .line 1043
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int v1, p1, p3

    const/16 v2, 0xf

    sub-int/2addr v1, v2

    add-int/lit8 v2, p2, 0x19

    add-int/lit8 v2, v2, 0x11

    iget-byte v3, p0, Lmain/GameRun;->list_rows:B

    mul-int/lit8 v3, v3, 0x1f

    const/4 v4, 0x6

    sub-int/2addr v3, v4

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    iget-object v5, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v6, p0, Lmain/GameRun;->selectx:B

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->sliding(IIIIIZ)V

    .line 1044
    iget-object v0, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    aget-byte v0, v0, v1

    if-lez v0, :cond_1

    iget-object v0, p0, Lmain/GameRun;->item_help:[Ljava/lang/StringBuffer;

    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    iget-byte v2, p0, Lmain/GameRun;->selectx:B

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    const/4 v3, 0x0

    aget-object v2, v2, v3

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1045
    shr-int/lit8 v0, p3, 0x1

    add-int v2, p1, v0

    add-int/lit8 v0, p2, 0x19

    add-int/lit8 v0, v0, 0x16

    iget-byte v3, p0, Lmain/GameRun;->list_rows:B

    mul-int/lit8 v3, v3, 0x1f

    add-int/2addr v3, v0

    const/16 v4, 0xa

    const/4 v5, 0x3

    move-object v0, p0

    .line 1044
    invoke-virtual/range {v0 .. v5}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 1048
    :cond_1
    shr-int/lit8 v0, p3, 0x1

    add-int/2addr v0, p1

    add-int v1, p2, p4

    const/4 v2, 0x2

    sub-int/2addr v1, v2

    const/4 v2, 0x0

    iget-byte v3, p0, Lmain/GameRun;->selectx:B

    const/4 v4, 0x2

    if-ne v3, v4, :cond_6

    const/4 v3, 0x1

    :goto_1
    invoke-virtual {p0, v0, v1, v2, v3}, Lmain/GameRun;->drawMoney(IIIZ)V

    .line 1051
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v2, p0, Lmain/GameRun;->selectx:B

    aget-byte v1, v1, v2

    if-nez v1, :cond_7

    const/4 v1, 0x0

    :goto_2
    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 1054
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    const/4 v1, -0x1

    if-eq v0, v1, :cond_2

    .line 1055
    iget-object v1, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    shr-int/lit8 v0, p3, 0x1

    add-int/2addr v0, p1

    const/16 v2, 0x19

    sub-int/2addr v0, v2

    const/16 v2, 0x8

    sub-int v2, v0, v2

    const/16 v3, 0x32

    const/16 v4, 0x4b

    const/4 v5, 0x2

    const/4 v6, 0x0

    iget-byte v7, p0, Lmain/GameRun;->popMenu:B

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Lmain/GameRun;->drawSelectMenu([Ljava/lang/Object;IIIIII)V

    .line 1056
    :cond_2
    return-void

    .line 993
    :cond_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    add-int/lit8 v1, v1, 0x1

    mul-int/2addr v1, p3

    div-int/lit8 v1, v1, 0x5

    add-int/2addr v1, p1

    const/16 v2, 0x16

    sub-int/2addr v1, v2

    add-int/lit8 v2, p2, 0x8

    const/16 v3, 0x46

    const/16 v4, 0x1c

    const/4 v5, 0x4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 997
    :goto_3
    const/4 v0, -0x1

    if-gt v9, v0, :cond_4

    .line 1023
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    shr-int/lit8 v1, p3, 0x1

    add-int/2addr v1, p1

    add-int/lit8 v2, p2, 0xe

    const/16 v3, 0x162

    const/4 v4, 0x1

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 1024
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 1025
    iget-object v0, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    const/4 v1, 0x4

    const/4 v2, 0x0

    const/4 v3, 0x0

    div-int/lit8 v4, p3, 0x4

    const/16 v5, 0x23

    invoke-virtual/range {v0 .. v5}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v10

    .line 1026
    .local v10, "t":B
    const/4 v0, -0x1

    if-eq v10, v0, :cond_0

    .line 1027
    iput-byte v10, p0, Lmain/GameRun;->selectx:B

    .line 1028
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lmain/GameRun;->select_st:[B

    iget-byte v3, p0, Lmain/GameRun;->selectx:B

    aget-byte v2, v2, v3

    aput-byte v2, v0, v1

    .line 1029
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/4 v1, 0x0

    iget-object v2, p0, Lmain/GameRun;->select_it:[B

    iget-byte v3, p0, Lmain/GameRun;->selectx:B

    aget-byte v2, v2, v3

    aput-byte v2, v0, v1

    goto/16 :goto_0

    .line 998
    .end local v10    # "t":B
    :cond_4
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    aget-object v1, v1, v9

    add-int/lit8 v2, v9, 0x1

    mul-int/2addr v2, p3

    div-int/lit8 v2, v2, 0x5

    add-int/2addr v2, p1

    const/16 v3, 0xe

    sub-int/2addr v2, v3

    add-int/lit8 v3, p2, 0x7

    const/4 v4, 0x0

    iget-byte v5, p0, Lmain/GameRun;->selectx:B

    if-ne v5, v9, :cond_5

    const/4 v5, 0x0

    :goto_4
    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 997
    const/4 v0, 0x1

    sub-int v0, v9, v0

    int-to-byte v9, v0

    goto :goto_3

    .line 998
    :cond_5
    const/4 v5, 0x1

    goto :goto_4

    .line 1048
    :cond_6
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 1051
    :cond_7
    const/4 v1, 0x1

    goto/16 :goto_2
.end method

.method private drawMagicUI(Ldm/Monster;)V
    .locals 26
    .param p1, "monsters"    # Ldm/Monster;

    .prologue
    .line 2187
    const/16 v6, 0x280

    .local v6, "WIDTH":I
    const/16 v7, 0x168

    .line 2188
    .local v7, "HEIGHT":I
    const/16 v23, 0x140

    .local v23, "WIDTH_H":I
    const/16 v22, 0xb4

    .line 2190
    .local v22, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const v3, 0x52bdef

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->fillRect(IIIII)V

    .line 2191
    const/16 v2, 0x8c

    sub-int v24, v23, v2

    .local v24, "offx":I
    const/16 v13, 0x10b

    .line 2192
    .local v13, "offw":I
    const/4 v2, 0x1

    add-int/lit16 v10, v2, 0xb4

    .local v10, "lx":I
    const/16 v11, 0x6c

    .line 2193
    .local v11, "ly":I
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->bg_c:B

    move v9, v0

    const/4 v12, 0x0

    move-object/from16 v8, p0

    invoke-direct/range {v8 .. v13}, Lmain/GameRun;->drawBG0(IIIII)V

    .line 2194
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v14, v0

    const/4 v15, 0x2

    const/16 v18, 0x78

    const/16 v19, 0x1d

    move/from16 v16, v10

    move/from16 v17, v11

    invoke-virtual/range {v14 .. v19}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v25

    .line 2195
    .local v25, "t":B
    const/4 v2, -0x1

    move/from16 v0, v25

    move v1, v2

    if-eq v0, v1, :cond_0

    .line 2196
    const/4 v2, -0x3

    sput v2, Ldm/Ms;->key:I

    .line 2197
    const/4 v2, 0x1

    sput-boolean v2, Ldm/Ms;->keyRepeat:Z

    .line 2221
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v14

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v2, v0

    if-nez v2, :cond_3

    const/16 v2, -0x8f

    :goto_0
    add-int v15, v23, v2

    add-int/lit8 v16, v11, 0x3

    const/16 v17, 0x7b

    const/16 v18, 0x1b

    const/16 v19, 0x4

    invoke-virtual/range {v14 .. v19}, Ldm/Ui;->drawK1(IIIII)V

    .line 2222
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v14

    const-string v15, "\u666e\u901a\u6280\u80fd"

    const/16 v2, 0x19

    sub-int v16, v23, v2

    add-int/lit8 v17, v11, 0x1

    sget-object v2, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v2, 0x8

    sget-object v3, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v18, v2, 0x10

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v2, v0

    if-nez v2, :cond_4

    const/4 v2, 0x0

    move/from16 v19, v2

    :goto_1
    const/16 v20, 0x0

    invoke-virtual/range {v14 .. v20}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2223
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v14

    const-string v15, "\u5929\u8d4b\u6280\u80fd"

    add-int/lit8 v16, v23, 0x19

    add-int/lit8 v17, v11, 0x1

    const/16 v18, 0x0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v2, v0

    if-nez v2, :cond_5

    const/4 v2, 0x1

    move/from16 v19, v2

    :goto_2
    const/16 v20, 0x0

    invoke-virtual/range {v14 .. v20}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2230
    const/4 v15, 0x1

    const/16 v16, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v2, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v3, v0

    const/4 v4, 0x0

    aget-byte v3, v3, v4

    aget-object v2, v2, v3

    const/4 v3, 0x1

    aget-byte v2, v2, v3

    mul-int/lit8 v2, v2, 0x3

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mon_action:B

    move v3, v0

    add-int v17, v2, v3

    .line 2231
    const/16 v2, 0x179

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/GameRun;->move_x:S

    move v3, v0

    sub-int v18, v2, v3

    const/16 v2, 0x61

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/GameRun;->move_y:S

    move v3, v0

    sub-int v19, v2, v3

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mon_action:B

    move v2, v0

    const/4 v3, 0x1

    if-ne v2, v3, :cond_6

    const/4 v2, 0x0

    move/from16 v20, v2

    :goto_3
    const/16 v21, 0x0

    move-object/from16 v14, p0

    .line 2230
    invoke-virtual/range {v14 .. v21}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 2231
    const/4 v2, 0x0

    move v0, v2

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->mon_action:B

    .line 2233
    :cond_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/GameRun;->move_x:S

    move v3, v0

    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v4, v5}, Ldm/Ms;->mathSpeedDown(IIZ)S

    move-result v2

    move v0, v2

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/GameRun;->move_x:S

    .line 2234
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/GameRun;->move_y:S

    move v3, v0

    const/4 v4, 0x3

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v4, v5}, Ldm/Ms;->mathSpeedDown(IIZ)S

    move-result v2

    move v0, v2

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/GameRun;->move_y:S

    .line 2236
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v2, v0

    if-nez v2, :cond_7

    .line 2244
    add-int/lit8 v15, v10, 0x7

    add-int/lit8 v2, v11, 0x19

    add-int/lit8 v16, v2, 0xc

    const/16 v2, 0x1d

    sub-int v17, v13, v2

    const/16 v18, 0x1f

    const/16 v19, 0x5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v2, v0

    const/4 v3, 0x0

    aget-object v20, v2, v3

    move-object/from16 v14, p0

    invoke-direct/range {v14 .. v20}, Lmain/GameRun;->drawSkillList(IIIII[B)V

    .line 2248
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v2, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v3, v0

    const/4 v4, 0x0

    aget-object v3, v3, v4

    const/4 v4, 0x0

    aget-byte v3, v3, v4

    aget-byte v2, v2, v3

    const/4 v3, -0x1

    if-eq v2, v3, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_help:[Ljava/lang/StringBuffer;

    move-object v2, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v3, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-byte v3, v3, v4

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v15

    .line 2249
    add-int/lit8 v16, v10, 0xa

    const/16 v2, 0x19

    sub-int v2, v7, v2

    const/16 v3, 0x16

    sub-int v17, v2, v3

    const/16 v18, 0xc8

    const/16 v19, 0x0

    const/16 v20, 0x1

    const/16 v21, 0x2

    move-object/from16 v14, p0

    .line 2248
    invoke-virtual/range {v14 .. v21}, Lmain/GameRun;->gogoWord(Ljava/lang/String;IIIIII)V

    .line 2262
    :cond_2
    :goto_4
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v14

    add-int/lit16 v2, v13, 0xb4

    const/16 v3, 0xd

    sub-int v15, v2, v3

    add-int/lit8 v2, v11, 0x19

    add-int/lit8 v16, v2, 0xd

    sub-int v2, v7, v11

    const/16 v3, 0x78

    sub-int v17, v2, v3

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v2, v0

    const/4 v3, 0x0

    aget-object v2, v2, v3

    const/4 v3, 0x0

    aget-byte v18, v2, v3

    .line 2263
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v2, v0

    if-nez v2, :cond_8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v2, v0

    const/16 v3, 0x8

    aget-byte v2, v2, v3

    move/from16 v19, v2

    :goto_5
    const/16 v20, 0x1

    .line 2262
    invoke-virtual/range {v14 .. v20}, Ldm/Ui;->sliding(IIIIIZ)V

    .line 2274
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mini_state:B

    move v2, v0

    const/16 v3, 0xd

    if-eq v2, v3, :cond_a

    .line 2281
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v14

    add-int/lit8 v16, v11, 0xc

    const/16 v17, 0x96

    const/16 v18, 0x1

    const/16 v19, 0x1

    move/from16 v15, v23

    invoke-virtual/range {v14 .. v19}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 2283
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 2287
    :goto_6
    return-void

    .line 2221
    :cond_3
    const/16 v2, 0x15

    goto/16 :goto_0

    .line 2222
    :cond_4
    const/4 v2, 0x1

    move/from16 v19, v2

    goto/16 :goto_1

    .line 2223
    :cond_5
    const/4 v2, 0x0

    move/from16 v19, v2

    goto/16 :goto_2

    .line 2231
    :cond_6
    const/4 v2, 0x1

    move/from16 v20, v2

    goto/16 :goto_3

    .line 2258
    :cond_7
    add-int/lit8 v16, v10, 0x7

    add-int/lit8 v2, v11, 0x19

    add-int/lit8 v17, v2, 0xc

    const/16 v2, 0x1d

    sub-int v18, v13, v2

    const/16 v19, 0x1f

    const/16 v20, 0x5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v2, v0

    const/4 v3, 0x0

    aget-object v21, v2, v3

    move-object/from16 v14, p0

    move-object/from16 v15, p1

    invoke-direct/range {v14 .. v21}, Lmain/GameRun;->drawBuffList(Ldm/Monster;IIIII[B)V

    .line 2259
    move-object/from16 v0, p1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v2, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v3, v0

    const/4 v4, 0x0

    aget-object v3, v3, v4

    const/4 v4, 0x0

    aget-byte v3, v3, v4

    add-int/lit8 v3, v3, 0x10

    aget-byte v2, v2, v3

    if-lez v2, :cond_2

    .line 2260
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->buff_help:[Ljava/lang/StringBuffer;

    move-object v2, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v3, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v4, v0

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    add-int/lit8 v4, v4, 0x10

    aget-byte v3, v3, v4

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v15

    const/16 v2, 0x32

    sub-int v2, v7, v2

    const/16 v3, 0x16

    sub-int v17, v2, v3

    const/16 v18, 0x9

    const/16 v19, 0x0

    move-object/from16 v14, p0

    move/from16 v16, v23

    invoke-virtual/range {v14 .. v19}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    goto/16 :goto_4

    .line 2263
    :cond_8
    move-object/from16 v0, p1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    move-object v2, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    move-object v3, v0

    const/4 v4, 0x0

    aget-object v3, v3, v4

    const/4 v4, 0x0

    aget-byte v3, v3, v4

    add-int/lit8 v3, v3, 0x10

    aget-byte v2, v2, v3

    if-lez v2, :cond_9

    const/4 v2, 0x2

    move/from16 v19, v2

    goto/16 :goto_5

    :cond_9
    const/4 v2, 0x1

    move/from16 v19, v2

    goto/16 :goto_5

    .line 2286
    :cond_a
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x1

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Ldm/Ui;->drawYesNo(ZZ)V

    goto/16 :goto_6
.end method

.method private drawMonKind(BIII)V
    .locals 7
    .param p1, "monKind"    # B
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "arh"    # I

    .prologue
    .line 3010
    const/4 v6, 0x0

    .local v6, "i":B
    :goto_0
    const/4 v0, 0x5

    if-lt v6, v0, :cond_0

    .line 3016
    return-void

    .line 3014
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    if-le p1, v6, :cond_1

    const/16 v1, 0x17

    :goto_1
    mul-int/lit8 v2, v6, 0xe

    add-int/2addr v2, p2

    const/4 v5, 0x0

    move v3, p3

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 3010
    add-int/lit8 v0, v6, 0x1

    int-to-byte v6, v0

    goto :goto_0

    .line 3014
    :cond_1
    const/16 v1, 0x18

    goto :goto_1
.end method

.method private drawMonList([Ldm/Monster;IIII[B)V
    .locals 8
    .param p1, "monster"    # [Ldm/Monster;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "show_num"    # I
    .param p5, "max_length"    # I
    .param p6, "select"    # [B

    .prologue
    .line 2081
    const/4 v0, 0x1

    aget-byte v7, p6, v0

    .line 2083
    .local v7, "i":B
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    const/4 v1, 0x6

    if-eq v0, v1, :cond_0

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0x22

    const/16 v2, 0x32

    sub-int v2, p2, v2

    const/4 v3, 0x5

    sub-int/2addr v2, v3

    add-int/lit8 v3, p3, 0x2

    sget-object v4, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v4, 0x8

    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v4, v4, 0x10

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 2091
    :cond_0
    :goto_0
    const/4 v0, 0x1

    aget-byte v0, p6, v0

    add-int/2addr v0, p4

    if-ge v7, v0, :cond_1

    if-lt v7, p5, :cond_2

    .line 2123
    :cond_1
    return-void

    .line 2099
    :cond_2
    const/4 v0, 0x0

    aget-byte v0, p6, v0

    if-ne v0, v7, :cond_3

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0x32

    sub-int v1, p2, v1

    const/4 v2, 0x1

    aget-byte v2, p6, v2

    sub-int v2, v7, v2

    mul-int/lit8 v2, v2, 0x1d

    add-int/2addr v2, p3

    const/16 v3, 0x6c

    const/16 v4, 0x1a

    const/4 v5, 0x1

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 2100
    :cond_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    aget-object v1, p1, v7

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v1

    add-int/lit8 v2, p2, 0x4

    const/4 v3, 0x2

    sub-int v3, p3, v3

    const/4 v4, 0x1

    aget-byte v4, p6, v4

    sub-int v4, v7, v4

    mul-int/lit8 v4, v4, 0x1d

    add-int/2addr v3, v4

    const/16 v4, 0x11

    const/4 v5, 0x0

    aget-byte v5, p6, v5

    if-ne v5, v7, :cond_5

    const/4 v5, 0x0

    :goto_1
    const/4 v6, 0x1

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2104
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    const/4 v1, -0x1

    if-ne v0, v1, :cond_4

    .line 2105
    iget-object v0, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    const/16 v1, 0x32

    sub-int v1, p2, v1

    const/4 v2, 0x1

    aget-byte v2, p6, v2

    sub-int v2, v7, v2

    mul-int/lit8 v2, v2, 0x1d

    add-int/2addr v2, p3

    const/16 v3, 0x64

    const/16 v4, 0x1a

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 2106
    const/4 v0, 0x0

    aget-byte v0, p6, v0

    if-ne v0, v7, :cond_6

    .line 2107
    const/16 v0, 0x35

    sput v0, Ldm/Ms;->key:I

    .line 2108
    const/4 v0, 0x1

    sput-boolean v0, Ldm/Ms;->keyRepeat:Z

    .line 2121
    :cond_4
    :goto_2
    add-int/lit8 v0, v7, 0x1

    int-to-byte v7, v0

    goto :goto_0

    .line 2100
    :cond_5
    const/4 v5, 0x1

    goto :goto_1

    .line 2110
    :cond_6
    const/4 v0, 0x0

    aput-byte v7, p6, v0

    .line 2111
    const/4 v0, 0x1

    aget-byte v0, p6, v0

    sub-int v0, v7, v0

    if-nez v0, :cond_8

    const/4 v0, 0x1

    aget-byte v0, p6, v0

    if-lez v0, :cond_8

    const/4 v0, 0x1

    aget-byte v1, p6, v0

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    int-to-byte v1, v1

    aput-byte v1, p6, v0

    .line 2113
    :cond_7
    :goto_3
    const/4 v0, 0x2

    iget-object v1, p0, Lmain/GameRun;->mList_id:[[B

    const/4 v2, 0x0

    aget-byte v2, p6, v2

    aget-object v2, p1, v2

    iget-object v2, v2, Ldm/Monster;->monster:[B

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->initMonStream(III)V

    .line 2114
    const/4 v0, 0x0

    aget-byte v0, p6, v0

    aget-object v0, p1, v0

    invoke-direct {p0, v0}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    .line 2115
    sget v0, Lmain/Constants_H;->WIDTH_H:I

    iput v0, p0, Lmain/GameRun;->introT:I

    .line 2116
    sget v0, Lmain/Constants_H;->WIDTH_H:I

    iput v0, p0, Lmain/GameRun;->introX:I

    goto :goto_2

    .line 2112
    :cond_8
    const/4 v0, 0x1

    aget-byte v0, p6, v0

    sub-int v0, v7, v0

    const/4 v1, 0x1

    sub-int v1, p4, v1

    if-ne v0, v1, :cond_7

    const/4 v0, 0x1

    aget-byte v0, p6, v0

    add-int/2addr v0, p4

    if-ge v0, p5, :cond_7

    const/4 v0, 0x1

    aget-byte v1, p6, v0

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    aput-byte v1, p6, v0

    goto :goto_3
.end method

.method private drawMonPro([Ldm/Monster;II)V
    .locals 9
    .param p1, "monsters"    # [Ldm/Monster;
    .param p2, "lx"    # I
    .param p3, "ly"    # I

    .prologue
    .line 2061
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    add-int/lit8 v2, p2, 0x12

    add-int/lit8 v3, p3, 0x2c

    const/4 v4, 0x0

    const/4 v5, 0x3

    const/16 v6, 0x1f

    const/4 v7, 0x3

    const/4 v8, 0x0

    invoke-virtual/range {v0 .. v8}, Ldm/Ui;->drawStringY([Ljava/lang/Object;IIIIIII)V

    .line 2062
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;

    add-int/lit16 v2, p2, 0xa0

    add-int/lit8 v3, p3, 0x2c

    const/4 v4, 0x0

    const/4 v5, 0x3

    const/16 v6, 0x1f

    const/4 v7, 0x3

    const/4 v8, 0x0

    invoke-virtual/range {v0 .. v8}, Ldm/Ui;->drawStringY([Ljava/lang/Object;IIIIIII)V

    .line 2063
    iget-byte v0, p0, Lmain/GameRun;->t_length:B

    if-eqz v0, :cond_0

    .line 2064
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->about_c:[Ljava/lang/StringBuffer;

    add-int/lit16 v2, p2, 0xa5

    add-int/lit8 v2, v2, 0x32

    add-int/lit8 v3, p3, 0x2c

    const/4 v4, 0x0

    const/4 v5, 0x3

    const/16 v6, 0x1f

    const/4 v7, -0x1

    const/4 v8, 0x0

    invoke-virtual/range {v0 .. v8}, Ldm/Ui;->drawStringY([Ljava/lang/Object;IIIIIII)V

    .line 2065
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    aget-object v1, p1, v0

    add-int/lit8 v0, p2, 0x13

    add-int/lit8 v0, v0, 0x32

    add-int/lit8 v2, v0, 0x4

    add-int/lit8 v3, p3, 0x3b

    const/16 v4, 0x30

    const/4 v5, 0x0

    const/4 v6, 0x0

    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v7, 0x0

    aget-object v0, v0, v7

    const/4 v7, 0x0

    aget-byte v0, v0, v7

    aget-object v0, p1, v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v7, 0x0

    aget-short v7, v0, v7

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lmain/GameRun;->drawMonsterHp(Ldm/Monster;IIIIII)V

    .line 2066
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    aget-object v1, p1, v0

    add-int/lit8 v0, p2, 0x13

    add-int/lit8 v0, v0, 0x32

    add-int/lit8 v2, v0, 0x4

    add-int/lit8 v0, p3, 0x3b

    add-int/lit8 v0, v0, 0x19

    add-int/lit8 v3, v0, 0x3

    const/16 v4, 0x30

    const/4 v5, 0x1

    const/4 v6, 0x0

    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v7, 0x0

    aget-object v0, v0, v7

    const/4 v7, 0x0

    aget-byte v0, v0, v7

    aget-object v0, p1, v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v7, 0x1

    aget-short v7, v0, v7

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lmain/GameRun;->drawMonsterHp(Ldm/Monster;IIIIII)V

    .line 2067
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    aget-object v0, p1, v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v1, 0x4

    aget-byte v0, v0, v1

    add-int/lit8 v1, p2, 0x13

    add-int/lit8 v1, v1, 0x32

    add-int/lit8 v1, v1, 0x4

    add-int/lit8 v2, p3, 0x4c

    add-int/lit8 v2, v2, 0x1c

    const/4 v3, 0x0

    invoke-direct {p0, v0, v1, v2, v3}, Lmain/GameRun;->drawMonKind(BIII)V

    .line 2079
    :cond_0
    return-void
.end method

.method private drawMonsterFealty(Ldm/Monster;II)V
    .locals 5
    .param p1, "monster"    # Ldm/Monster;
    .param p2, "x"    # I
    .param p3, "y"    # I

    .prologue
    const/4 v4, 0x4

    .line 2994
    iget-object v3, p1, Ldm/Monster;->monster:[B

    aget-byte v0, v3, v4

    .line 2995
    .local v0, "kind":B
    iget-object v3, p0, Lmain/GameRun;->initFealty:[B

    if-ge v0, v4, :cond_0

    const/4 v4, 0x0

    :goto_0
    aget-byte v3, v3, v4

    div-int/lit8 v3, v3, 0x14

    int-to-byte v2, v3

    .line 2996
    .local v2, "nn":B
    iget-object v3, p1, Ldm/Monster;->monster:[B

    const/4 v4, 0x6

    aget-byte v3, v3, v4

    div-int/lit8 v3, v3, 0x14

    int-to-byte v1, v3

    .line 2997
    .local v1, "n":B
    invoke-virtual {p0, v2, v1, p2, p3}, Lmain/GameRun;->drawFealty(IIII)V

    .line 2998
    return-void

    .line 2995
    .end local v1    # "n":B
    .end local v2    # "nn":B
    :cond_0
    const/4 v4, 0x1

    goto :goto_0
.end method

.method private drawMonsterHp(Ldm/Monster;IIIIII)V
    .locals 13
    .param p1, "monster"    # Ldm/Monster;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "w"    # I
    .param p5, "mode"    # I
    .param p6, "type"    # I
    .param p7, "t2"    # I

    .prologue
    .line 3318
    const/4 v4, 0x2

    move/from16 v0, p5

    move v1, v4

    if-ge v0, v1, :cond_1

    .line 3319
    iget-object v4, p1, Ldm/Monster;->monsterPro:[S

    add-int/lit8 v5, p5, 0x0

    aget-short v11, v4, v5

    .line 3320
    .local v11, "t0":S
    iget-object v4, p1, Ldm/Monster;->monsterPro:[S

    add-int/lit8 v5, p5, 0x2

    aget-short v12, v4, v5

    .line 3327
    .local v12, "t1":S
    :goto_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    const/4 v6, 0x2

    sub-int v6, p4, v6

    move-object v0, v5

    move/from16 v1, p7

    move v2, v6

    move v3, v12

    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->mathPercent(III)S

    move-result v8

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    const/4 v6, 0x2

    sub-int v6, p4, v6

    invoke-virtual {v5, v11, v6, v12}, Ldm/Ms;->mathPercent(III)S

    move-result v9

    move v5, p2

    move/from16 v6, p3

    move/from16 v7, p4

    move/from16 v10, p5

    invoke-virtual/range {v4 .. v10}, Ldm/Ui;->drawBarOne(IIIIII)V

    .line 3328
    const/4 v4, 0x2

    move/from16 v0, p6

    move v1, v4

    if-eq v0, v1, :cond_0

    .line 3329
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v11}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 3330
    .local v5, "s":Ljava/lang/String;
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v6

    mul-int/lit8 v6, v6, 0x8

    sub-int v6, p4, v6

    shr-int/lit8 v6, v6, 0x1

    add-int/2addr v6, p2

    const/4 v7, 0x1

    move/from16 v0, p6

    move v1, v7

    if-ne v0, v1, :cond_3

    const/4 v7, 0x5

    :goto_1
    add-int v7, v7, p3

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual/range {v4 .. v9}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 3333
    .end local v5    # "s":Ljava/lang/String;
    :cond_0
    return-void

    .line 3323
    .end local v11    # "t0":S
    .end local v12    # "t1":S
    :cond_1
    if-nez p7, :cond_2

    iget-object v4, p1, Ldm/Monster;->monsterPro:[S

    const/4 v5, 0x4

    aget-short p7, v4, v5

    .line 3324
    :cond_2
    move/from16 v0, p7

    int-to-short v0, v0

    move v11, v0

    .line 3325
    .restart local v11    # "t0":S
    invoke-direct {p0, p1}, Lmain/GameRun;->getMonsterExp(Ldm/Monster;)S

    move-result v12

    .restart local v12    # "t1":S
    goto :goto_0

    .line 3330
    .restart local v5    # "s":Ljava/lang/String;
    :cond_3
    const/4 v7, 0x0

    goto :goto_1
.end method

.method private drawMyMonState()V
    .locals 11

    .prologue
    .line 5345
    const/16 v1, 0xa

    .local v1, "x":S
    const/16 v10, 0x93

    .local v10, "w":S
    const/16 v2, 0x8c

    .line 5346
    .local v2, "y":S
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v3, 0xb3

    const/16 v4, 0x6e

    const/4 v5, 0x2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK(IIIII)V

    .line 5347
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v3, v1, 0x2

    add-int/lit8 v4, v2, 0x2

    const/16 v5, 0x21

    invoke-virtual {v0, v3, v4, v10, v5}, Ldm/Ui;->drawKuang(IIII)V

    .line 5348
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v4, 0x3

    aget-byte v0, v0, v4

    add-int/lit8 v4, v0, 0x5

    add-int/lit8 v5, v1, 0x10

    add-int/lit8 v6, v2, 0x10

    const/4 v7, 0x3

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawUi(IIIII)V

    .line 5349
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v4, 0x0

    aget-byte v0, v0, v4

    invoke-virtual {p0, v0}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    .line 5350
    add-int/lit8 v0, v1, 0x4b

    add-int/lit8 v5, v0, 0xe

    add-int/lit8 v6, v2, 0x1

    const/16 v7, 0x11

    const/4 v8, 0x4

    const/4 v9, 0x2

    .line 5349
    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 5351
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x2

    aget-byte v4, v4, v5

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "\u7ea7"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    add-int/lit8 v0, v1, 0x7d

    add-int/lit8 v5, v0, 0x1b

    add-int/lit8 v6, v2, 0x14

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 5352
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    add-int/lit8 v4, v1, 0x2

    add-int/lit8 v0, v2, 0x19

    add-int/lit8 v5, v0, 0xb

    const/16 v6, 0x3e

    const/16 v7, 0xe

    const/4 v8, 0x4

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawK0(IIIII)V

    .line 5353
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const/16 v4, 0x22

    add-int/lit8 v5, v1, 0x4

    add-int/lit8 v0, v2, 0x19

    add-int/lit8 v6, v0, 0xc

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawUi(IIIII)V

    .line 5354
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v4, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v4, v4, Ldm/Battle;->countS:[B

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    add-int/lit8 v4, v4, 0x64

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "%"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    add-int/lit8 v5, v1, 0x3c

    add-int/lit8 v0, v2, 0x19

    add-int/lit8 v6, v0, 0x18

    const/4 v7, 0x1

    const/4 v8, 0x1

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 5356
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const-string v4, "\u5ba0\u7269\u6863\u6b21"

    add-int/lit8 v5, v1, 0x2

    add-int/lit8 v0, v2, 0x19

    add-int/lit8 v6, v0, 0x1e

    const/16 v7, 0x14

    const/4 v8, 0x4

    const/4 v9, 0x2

    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 5357
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v3, 0x4

    aget-byte v0, v0, v3

    add-int/lit8 v3, v1, 0x64

    add-int/lit8 v3, v3, 0x8

    add-int/lit8 v4, v2, 0x19

    add-int/lit8 v4, v4, 0x26

    const/4 v5, 0x0

    invoke-direct {p0, v0, v3, v4, v5}, Lmain/GameRun;->drawMonKind(BIII)V

    .line 5358
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const-string v4, "\u5174\u594b\u5ea6"

    add-int/lit8 v5, v1, 0x2

    add-int/lit8 v0, v2, 0x32

    add-int/lit8 v6, v0, 0x20

    const/16 v7, 0x14

    const/4 v8, 0x4

    const/4 v9, 0x2

    invoke-virtual/range {v3 .. v9}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 5359
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    add-int/lit8 v1, v1, 0x64

    add-int/lit8 v1, v1, 0x4

    add-int/lit8 v2, v2, 0x32

    add-int/lit8 v2, v2, 0x2a

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->drawMonsterFealty(Ldm/Monster;II)V

    .line 5360
    .end local v1    # "x":S
    .end local v2    # "y":S
    return-void
.end method

.method private drawNidus(II)V
    .locals 22
    .param p1, "x"    # I
    .param p2, "w"    # I

    .prologue
    .line 1308
    const/16 v18, 0x168

    .line 1309
    .local v18, "HEIGHT":I
    const/16 v20, 0x140

    .local v20, "WIDTH_H":I
    const/16 v19, 0xb4

    .line 1310
    .local v19, "HEIGHT_H":I
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mini_state:B

    move v5, v0

    const/16 v6, 0x10

    if-ne v5, v6, :cond_1

    .line 1311
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    move-object v6, v0

    const/16 v5, 0x4b

    sub-int v7, v20, v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    move-object v5, v0

    array-length v5, v5

    shr-int/lit8 v5, v5, 0x1

    mul-int/lit8 v5, v5, 0x19

    sub-int v8, v19, v5

    const/16 v9, 0x96

    const/4 v10, 0x1

    const/4 v11, 0x0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v12, v0

    move-object/from16 v5, p0

    invoke-virtual/range {v5 .. v12}, Lmain/GameRun;->drawSelectMenu([Ljava/lang/Object;IIIIII)V

    .line 1364
    :cond_0
    :goto_0
    return-void

    .line 1313
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ui;->fillRectB()V

    .line 1314
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->bg_c:B

    move v6, v0

    add-int/lit8 v7, p1, 0x1

    const/16 v8, 0x6c

    const/4 v9, 0x0

    move-object/from16 v5, p0

    move/from16 v10, p2

    invoke-direct/range {v5 .. v10}, Lmain/GameRun;->drawBG0(IIIII)V

    .line 1316
    const-string v5, "sk"

    const-string v6, "drawNidus"

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1317
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v7, v0

    add-int/lit8 v7, v7, 0x1

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const/4 v7, 0x5

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    add-int/lit8 v7, p1, 0xa

    const/16 v8, 0x6a

    const/16 v9, 0x24

    const/4 v10, 0x0

    const/4 v11, 0x2

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1319
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    move-object/from16 v0, p0

    move v1, v6

    invoke-virtual {v0, v1}, Lmain/GameRun;->getRid(I)B

    move-result v6

    const/4 v7, -0x2

    if-ne v6, v7, :cond_5

    const-string v6, "\u6b64\u4f4d\u7f6e\u76ee\u524d\u662f\u7a7a\u7684"

    .line 1320
    :goto_1
    add-int/lit8 v7, p1, 0x14

    const/16 v8, 0x6e

    const/4 v9, 0x0

    const/4 v10, 0x1

    const/4 v11, 0x0

    .line 1319
    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1321
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    move-object/from16 v0, p0

    move v1, v5

    invoke-virtual {v0, v1}, Lmain/GameRun;->getRid(I)B

    move-result v5

    const/4 v6, -0x2

    if-eq v5, v6, :cond_3

    .line 1322
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v6, 0x2

    if-ge v5, v6, :cond_7

    const/4 v6, 0x1

    const/4 v7, 0x1

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->mon_action:B

    move v8, v0

    const/16 v9, 0x179

    const/16 v10, 0x61

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v11, 0x1

    if-ne v5, v11, :cond_6

    const/4 v5, 0x0

    move v11, v5

    :goto_2
    const/4 v12, 0x0

    move-object/from16 v5, p0

    invoke-virtual/range {v5 .. v12}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 1323
    const/4 v5, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v7, v0

    move-object/from16 v0, p0

    move v1, v7

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNid(I)B

    move-result v7

    aget-object v6, v6, v7

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    const/4 v7, 0x1

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    invoke-virtual {v0, v1, v2, v3}, Lmain/GameRun;->initMonStream(III)V

    .line 1324
    const/4 v5, 0x2

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->b_c:B

    .line 1330
    :cond_2
    :goto_3
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v6, -0x1

    if-eq v5, v6, :cond_a

    .line 1331
    const/16 v5, 0x28

    sub-int v5, p2, v5

    int-to-short v8, v5

    .line 1332
    .local v8, "barW":S
    new-instance v5, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    const/4 v7, 0x1

    move-object/from16 v0, p0

    move v1, v6

    move v2, v7

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "/"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    const/4 v7, 0x3

    move-object/from16 v0, p0

    move v1, v6

    move v2, v7

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object v0, v5

    move-object/from16 v1, p0

    iput-object v0, v1, Lmain/GameRun;->str_cur:Ljava/lang/String;

    .line 1333
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    add-int/lit8 v6, p1, 0x14

    const/16 v7, 0x9e

    .line 1334
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v9

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v10, v0

    const/4 v11, 0x1

    move-object/from16 v0, p0

    move v1, v10

    move v2, v11

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v10

    const/4 v11, 0x2

    sub-int v11, v8, v11

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v12, v0

    const/4 v13, 0x3

    move-object/from16 v0, p0

    move v1, v12

    move v2, v13

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v12

    invoke-virtual {v9, v10, v11, v12}, Ldm/Ms;->mathPercent(III)S

    move-result v9

    .line 1335
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v10

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v11, v0

    const/4 v12, 0x1

    move-object/from16 v0, p0

    move v1, v11

    move v2, v12

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v11

    const/4 v12, 0x2

    sub-int v12, v8, v12

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v13, v0

    const/4 v14, 0x3

    move-object/from16 v0, p0

    move v1, v13

    move v2, v14

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v13

    invoke-virtual {v10, v11, v12, v13}, Ldm/Ms;->mathPercent(III)S

    move-result v10

    const/4 v11, 0x2

    .line 1333
    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawBarOne(IIIIII)V

    .line 1336
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v9

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->str_cur:Ljava/lang/String;

    move-object v10, v0

    add-int/lit8 v5, p1, 0x14

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->str_cur:Ljava/lang/String;

    move-object v6, v0

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    mul-int/lit8 v6, v6, 0x8

    sub-int v6, v8, v6

    shr-int/lit8 v6, v6, 0x1

    add-int v11, v5, v6

    const/16 v12, 0xa4

    const/4 v13, 0x0

    const/4 v14, 0x0

    invoke-virtual/range {v9 .. v14}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 1337
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v9

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    const/4 v6, 0x1

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    const/4 v7, 0x3

    move-object/from16 v0, p0

    move v1, v6

    move v2, v7

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v6

    if-ne v5, v6, :cond_9

    .line 1338
    const-string v5, "\u5b75\u5316\u5df2\u5b8c\u6210"

    move-object v10, v5

    :goto_4
    add-int/lit8 v5, p1, 0x14

    shr-int/lit8 v6, v8, 0x1

    add-int v11, v5, v6

    const/16 v12, 0xa4

    const/16 v13, 0x11

    const/4 v14, 0x3

    const/4 v15, 0x1

    .line 1337
    invoke-virtual/range {v9 .. v15}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1339
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v9

    const-string v10, "\u5b75\u5316\u6240\u9700\u6750\u6599"

    add-int/lit8 v5, p1, 0x14

    shr-int/lit8 v6, v8, 0x1

    add-int v11, v5, v6

    const/16 v12, 0xd0

    const/16 v13, 0x11

    const/4 v14, 0x3

    const/4 v15, 0x1

    invoke-virtual/range {v9 .. v15}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1340
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    move-object/from16 v0, p0

    move v1, v5

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNid(I)B

    move-result v5

    add-int/lit8 v6, p1, 0x19

    const/16 v7, 0xef

    const/16 v8, 0x1c

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-direct {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawEvolveMake(IIII)V

    .line 1351
    .end local v8    # "barW":S
    :goto_5
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    const/4 v6, 0x1

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    const/4 v7, 0x3

    move-object/from16 v0, p0

    move v1, v6

    move v2, v7

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->getNexp(II)S

    move-result v6

    if-ne v5, v6, :cond_3

    .line 1352
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v9

    const-string v10, "\u6309\u786e\u5b9a\u952e\u5b8c\u6210\u5b75\u5316"

    add-int/lit8 v11, p1, 0x14

    const/16 v5, 0x19

    sub-int v5, v18, v5

    const/16 v6, 0x15

    sub-int v12, v5, v6

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-virtual/range {v9 .. v15}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1354
    :cond_3
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v6, -0x2

    if-ne v5, v6, :cond_4

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v9

    const/16 v11, 0x78

    const/16 v12, 0x96

    const/4 v13, 0x1

    const/4 v14, 0x1

    move/from16 v10, v20

    invoke-virtual/range {v9 .. v14}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 1355
    :cond_4
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    move-object/from16 v0, p0

    move v1, v6

    invoke-virtual {v0, v1}, Lmain/GameRun;->getRid(I)B

    move-result v6

    const/4 v7, -0x2

    if-ne v6, v7, :cond_b

    const/4 v6, 0x0

    :goto_6
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v7, v0

    const/4 v8, -0x1

    if-eq v7, v8, :cond_c

    const/4 v7, 0x1

    :goto_7
    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 1357
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v9, v0

    const/4 v10, 0x2

    const/4 v11, 0x0

    const/4 v12, 0x0

    move/from16 v13, v20

    move/from16 v14, v18

    invoke-virtual/range {v9 .. v14}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v21

    .line 1358
    .local v21, "t":B
    const/4 v5, -0x1

    move/from16 v0, v21

    move v1, v5

    if-eq v0, v1, :cond_0

    .line 1359
    if-nez v21, :cond_d

    const/4 v5, -0x3

    :goto_8
    sput v5, Ldm/Ms;->key:I

    .line 1360
    const/4 v5, 0x1

    sput-boolean v5, Ldm/Ms;->keyRepeat:Z

    goto/16 :goto_0

    .line 1319
    .end local v21    # "t":B
    :cond_5
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monsterT:[Ljava/lang/StringBuffer;

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monster_pro:[[B

    move-object v8, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v9, v0

    move-object/from16 v0, p0

    move v1, v9

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNid(I)B

    move-result v9

    aget-object v8, v8, v9

    const/4 v9, 0x6

    aget-byte v8, v8, v9

    aget-object v7, v7, v8

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\u7684\u5ba0\u7269\u86cb"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto/16 :goto_1

    .line 1322
    :cond_6
    const/4 v5, 0x1

    move v11, v5

    goto/16 :goto_2

    .line 1325
    :cond_7
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v6, 0x1

    if-le v5, v6, :cond_2

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/16 v6, 0xe

    if-ge v5, v6, :cond_2

    .line 1326
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    move-object/from16 v0, p0

    move v1, v6

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNid(I)B

    move-result v6

    aget-object v5, v5, v6

    const/4 v6, 0x1

    aget-byte v6, v5, v6

    const/4 v7, 0x1

    const/16 v8, 0x179

    const/16 v9, 0x61

    const/16 v10, 0x50

    const/16 v11, 0x4d

    const/16 v12, 0xf

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v13, 0x2

    sub-int v13, v5, v13

    const/4 v14, 0x0

    move-object/from16 v5, p0

    invoke-direct/range {v5 .. v14}, Lmain/GameRun;->drawClipPic(IIIIIIIII)V

    .line 1327
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    add-int/lit8 v5, v5, 0x1

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->b_c:B

    const/16 v6, 0xe

    if-ne v5, v6, :cond_8

    const/4 v5, -0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->b_c:B

    .line 1328
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    move-object/from16 v0, p0

    move v1, v6

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNid(I)B

    move-result v6

    aget-object v5, v5, v6

    const/4 v6, 0x1

    aget-byte v5, v5, v6

    mul-int/lit8 v5, v5, 0x3

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->mon_action:B

    goto/16 :goto_3

    .line 1338
    .restart local v8    # "barW":S
    :cond_9
    const-string v5, "\u5b75\u5316\u4e2d..."

    move-object v10, v5

    goto/16 :goto_4

    .line 1342
    .end local v8    # "barW":S
    :cond_a
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v9

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    move-object v10, v0

    add-int/lit8 v11, p1, 0x1a

    const/16 v12, 0x9b

    const/4 v13, 0x0

    const/4 v14, 0x3

    const/16 v15, 0x1e

    const/16 v16, 0x3

    const/16 v17, 0x0

    invoke-virtual/range {v9 .. v17}, Ldm/Ui;->drawStringY([Ljava/lang/Object;IIIIIII)V

    .line 1343
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v9

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;

    move-object v10, v0

    add-int/lit8 v11, p1, 0x7e

    const/16 v12, 0x9b

    const/4 v13, 0x0

    const/4 v14, 0x3

    const/16 v15, 0x1e

    const/16 v16, 0x3

    const/16 v17, 0x0

    invoke-virtual/range {v9 .. v17}, Ldm/Ui;->drawStringY([Ljava/lang/Object;IIIIIII)V

    .line 1344
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v9

    const-string v10, "\u6863\u6b21\uff1a"

    add-int/lit8 v5, p1, 0x14

    add-int/lit8 v11, v5, 0x32

    const/16 v12, 0x102

    const/4 v13, 0x0

    const/4 v14, 0x3

    const/4 v15, 0x1

    invoke-virtual/range {v9 .. v15}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1346
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->monster_pro:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v6, v0

    move-object/from16 v0, p0

    move v1, v6

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNid(I)B

    move-result v6

    aget-object v5, v5, v6

    const/4 v6, 0x5

    aget-byte v5, v5, v6

    add-int/lit8 v6, p1, 0x17

    add-int/lit8 v6, v6, 0x64

    add-int/lit8 v6, v6, 0xa

    const/16 v7, 0x107

    const/4 v8, 0x0

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-direct {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawMonKind(BIII)V

    goto/16 :goto_5

    .line 1355
    :cond_b
    const/4 v6, 0x1

    goto/16 :goto_6

    :cond_c
    const/4 v7, 0x0

    goto/16 :goto_7

    .line 1359
    .restart local v21    # "t":B
    :cond_d
    const/4 v5, -0x4

    goto/16 :goto_8
.end method

.method private drawPlayer(Ljavax/microedition/lcdui/Graphics;)V
    .locals 0
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 4679
    invoke-virtual {p0}, Lmain/GameRun;->drawMyMon()V

    .line 4680
    invoke-direct {p0}, Lmain/GameRun;->drawMyMonState()V

    .line 4681
    invoke-direct {p0}, Lmain/GameRun;->drawEnemy()V

    .line 4682
    invoke-direct {p0}, Lmain/GameRun;->drawEnemyState()V

    .line 4683
    return-void
.end method

.method private drawPlayerAppear(Ljavax/microedition/lcdui/Graphics;)V
    .locals 13
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    const/16 v5, 0x61

    const/4 v12, 0x1

    const/4 v8, 0x2

    const/4 v1, 0x0

    .line 4228
    iget-byte v0, p0, Lmain/GameRun;->battle_state:B

    packed-switch v0, :pswitch_data_0

    .line 4247
    :goto_0
    return-void

    .line 4231
    :pswitch_0
    iget-byte v0, p0, Lmain/GameRun;->battle_type:B

    if-le v0, v8, :cond_3

    .line 4232
    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    aget-byte v0, v0, v8

    if-nez v0, :cond_1

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->throw_state:B

    const/4 v2, -0x1

    if-ne v0, v2, :cond_1

    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    aget-byte v0, v0, v1

    const/16 v2, 0xc

    if-ne v0, v2, :cond_1

    .line 4233
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v1, v0, Ldm/Battle;->throw_state:B

    .line 4244
    :cond_0
    :goto_1
    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    const/16 v4, 0x10a

    const/16 v5, 0xec

    move-object v0, p0

    move v3, v12

    invoke-direct/range {v0 .. v5}, Lmain/GameRun;->drawThrowBall(Ldm/Battle;Ldm/Monster;III)V

    goto :goto_0

    .line 4234
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->throw_state:B

    if-eqz v0, :cond_2

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->throw_state:B

    if-ne v0, v8, :cond_0

    .line 4235
    :cond_2
    iget-object v0, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v1

    aget-object v0, v0, v2

    aget-byte v0, v0, v12

    mul-int/lit8 v0, v0, 0x3

    .line 4236
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->action:B

    add-int v3, v0, v2

    iget v0, p0, Lmain/GameRun;->enemyOff:I

    add-int/lit16 v4, v0, 0x179

    move-object v0, p0

    move v2, v1

    move v6, v1

    move v7, v1

    .line 4235
    invoke-virtual/range {v0 .. v7}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    .line 4237
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget v2, p0, Lmain/GameRun;->enemyOff:I

    const/4 v3, 0x4

    invoke-virtual {v0, v2, v1, v3, v1}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v0

    iput v0, p0, Lmain/GameRun;->enemyOff:I

    .line 4238
    iget v0, p0, Lmain/GameRun;->enemyOff:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v8, v0, Ldm/Battle;->throw_state:B

    goto :goto_1

    .line 4240
    :cond_3
    iget-byte v0, p0, Lmain/GameRun;->battle_type:B

    if-ge v0, v8, :cond_0

    iget-object v7, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v8

    const/16 v10, 0x179

    move-object v6, p0

    move v9, v1

    move v11, v5

    invoke-direct/range {v6 .. v11}, Lmain/GameRun;->drawThrowBall(Ldm/Battle;Ldm/Monster;III)V

    goto :goto_1

    .line 4228
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method private drawSelectMenu(Ljavax/microedition/lcdui/Graphics;ZI)V
    .locals 11
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;
    .param p2, "bb"    # Z
    .param p3, "y"    # I

    .prologue
    const/4 v10, 0x5

    const/4 v5, 0x0

    .line 5186
    const/16 v8, 0x168

    .line 5187
    .local v8, "HEIGHT":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0xc8

    add-int/lit8 v2, p3, 0xf

    const/16 v3, 0xf0

    sub-int v4, v8, p3

    const/16 v6, 0x14

    sub-int/2addr v4, v6

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK2(IIIII)V

    .line 5188
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    add-int/lit8 v1, p3, 0x3

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->drawBattleExp(Ldm/Monster;I)V

    .line 5189
    if-eqz p2, :cond_1

    .line 5194
    :cond_0
    return-void

    .line 5190
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v1

    const-string v2, "\u8981\u505a\u4ec0\u4e48\uff1f"

    const/16 v3, 0x1c2

    const/16 v4, 0xa

    const/4 v7, 0x2

    move v6, v5

    invoke-virtual/range {v1 .. v7}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 5191
    const/4 v9, 0x0

    .local v9, "i":B
    :goto_0
    iget-object v0, p0, Lmain/GameRun;->imgBattle:[Ljavax/microedition/lcdui/Image;

    array-length v0, v0

    if-ge v9, v0, :cond_0

    .line 5192
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->imgBattle:[Ljavax/microedition/lcdui/Image;

    aget-object v1, v1, v9

    iget-object v2, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v2, v2, Lmain/PointerKey;->button_pos:[[[I

    aget-object v2, v2, v10

    aget-object v2, v2, v9

    aget v2, v2, v5

    iget-object v3, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v3, v3, Lmain/PointerKey;->button_pos:[[[I

    aget-object v3, v3, v10

    aget-object v3, v3, v9

    const/4 v4, 0x1

    aget v3, v3, v4

    invoke-virtual {v0, v1, v2, v3, v5}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 5191
    add-int/lit8 v0, v9, 0x1

    int-to-byte v9, v0

    goto :goto_0
.end method

.method private drawSkillList(IIIII[B)V
    .locals 17
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "fontH"    # I
    .param p5, "show_num"    # I
    .param p6, "sel"    # [B

    .prologue
    .line 2125
    const/4 v5, 0x1

    aget-byte v16, p6, v5

    .line 2126
    .local v16, "i":B
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v10, 0x3

    const/4 v12, 0x0

    const/4 v6, 0x0

    aget-byte v6, p6, v6

    const/4 v7, 0x1

    aget-byte v7, p6, v7

    sub-int v13, v6, v7

    const/4 v14, 0x4

    const/4 v15, 0x2

    move/from16 v6, p5

    move/from16 v7, p1

    move/from16 v8, p2

    move/from16 v9, p3

    move/from16 v11, p4

    invoke-virtual/range {v5 .. v15}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 2127
    :goto_0
    const/4 v5, 0x1

    aget-byte v5, p6, v5

    add-int v5, v5, p5

    move/from16 v0, v16

    move v1, v5

    if-ge v0, v1, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v5, v0

    const/16 v6, 0x8

    aget-byte v5, v5, v6

    move/from16 v0, v16

    move v1, v5

    if-lt v0, v1, :cond_1

    .line 2159
    :cond_0
    return-void

    .line 2132
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v6, v0

    aget-byte v6, v6, v16

    const/16 v7, 0x19

    if-le v6, v7, :cond_3

    const/16 v6, 0x32

    :goto_1
    add-int/lit8 v7, p1, 0x8

    add-int/lit8 v8, p2, 0x8

    const/4 v9, 0x1

    aget-byte v9, p6, v9

    sub-int v9, v16, v9

    mul-int v9, v9, p4

    add-int/2addr v8, v9

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawUi(IIIII)V

    .line 2139
    const-string v5, "sk"

    const-string v6, "\u666e\u901a\u653b\u51fb"

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2140
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v6, v0

    aget-byte v6, v6, v16

    move-object/from16 v0, p0

    move v1, v6

    invoke-direct {v0, v1}, Lmain/GameRun;->getNameSkill(B)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v6

    add-int/lit8 v7, p1, 0x15

    add-int/lit8 v8, p2, 0x1

    const/4 v9, 0x1

    aget-byte v9, p6, v9

    sub-int v9, v16, v9

    mul-int v9, v9, p4

    add-int/2addr v8, v9

    const/4 v9, 0x0

    const/4 v10, 0x0

    aget-byte v10, p6, v10

    move v0, v10

    move/from16 v1, v16

    if-ne v0, v1, :cond_4

    const/4 v10, 0x0

    :goto_2
    const/4 v11, 0x0

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2141
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v6, v0

    aget-byte v6, v6, v16

    const/16 v7, 0x1e

    if-gt v6, v7, :cond_5

    new-instance v6, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill:[[B

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v8, v0

    aget-byte v8, v8, v16

    aget-object v7, v7, v8

    const/4 v8, 0x1

    aget-byte v7, v7, v8

    invoke-static {v7}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, "\u80fd\u91cf"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 2142
    :goto_3
    add-int v7, p1, p3

    const/16 v8, 0x8

    sub-int/2addr v7, v8

    add-int/lit8 v8, p2, 0x1

    const/4 v9, 0x1

    aget-byte v9, p6, v9

    sub-int v9, v16, v9

    mul-int v9, v9, p4

    add-int/2addr v8, v9

    sget-object v9, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v9, 0x8

    sget-object v10, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v9, v9, 0x10

    const/4 v10, 0x0

    aget-byte v10, p6, v10

    move v0, v10

    move/from16 v1, v16

    if-ne v0, v1, :cond_6

    const/4 v10, 0x0

    :goto_4
    const/4 v11, 0x0

    .line 2141
    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2146
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->say_c:B

    move v5, v0

    const/4 v6, 0x1

    if-ge v5, v6, :cond_2

    .line 2147
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    const/4 v6, 0x1

    aget-byte v6, p6, v6

    sub-int v6, v16, v6

    mul-int v6, v6, p4

    add-int v6, v6, p2

    move-object v0, v5

    move/from16 v1, p1

    move v2, v6

    move/from16 v3, p3

    move/from16 v4, p4

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 2148
    const/4 v5, 0x0

    aget-byte v5, p6, v5

    move v0, v5

    move/from16 v1, v16

    if-ne v0, v1, :cond_7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/PointerKey;->setKey5()V

    .line 2157
    :cond_2
    :goto_5
    add-int/lit8 v5, v16, 0x1

    move v0, v5

    int-to-byte v0, v0

    move/from16 v16, v0

    goto/16 :goto_0

    .line 2132
    :cond_3
    const/16 v6, 0x33

    goto/16 :goto_1

    .line 2140
    :cond_4
    const/4 v10, 0x3

    goto/16 :goto_2

    .line 2141
    :cond_5
    const-string v6, "\u88ab\u52a8"

    goto :goto_3

    .line 2142
    :cond_6
    const/4 v10, 0x3

    goto :goto_4

    .line 2150
    :cond_7
    const/4 v5, 0x0

    aput-byte v16, p6, v5

    .line 2151
    const/4 v5, 0x1

    aget-byte v5, p6, v5

    sub-int v5, v16, v5

    if-nez v5, :cond_8

    const/4 v5, 0x1

    aget-byte v5, p6, v5

    if-lez v5, :cond_8

    const/4 v5, 0x1

    aget-byte v6, p6, v5

    const/4 v7, 0x1

    sub-int/2addr v6, v7

    int-to-byte v6, v6

    aput-byte v6, p6, v5

    goto :goto_5

    .line 2152
    :cond_8
    const/4 v5, 0x1

    aget-byte v5, p6, v5

    sub-int v5, v16, v5

    const/4 v6, 0x1

    sub-int v6, p5, v6

    if-ne v5, v6, :cond_2

    const/4 v5, 0x1

    aget-byte v5, p6, v5

    add-int v5, v5, p5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->skill_list:[B

    move-object v6, v0

    const/16 v7, 0x8

    aget-byte v6, v6, v7

    if-ge v5, v6, :cond_2

    const/4 v5, 0x1

    aget-byte v6, p6, v5

    add-int/lit8 v6, v6, 0x1

    int-to-byte v6, v6

    aput-byte v6, p6, v5

    goto :goto_5
.end method

.method private drawThrowBall(Ldm/Battle;Ldm/Monster;III)V
    .locals 10
    .param p1, "be"    # Ldm/Battle;
    .param p2, "mon"    # Ldm/Monster;
    .param p3, "mini"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I

    .prologue
    const/4 v2, 0x2

    const/4 v3, 0x0

    const/4 v6, 0x1

    .line 4200
    iget-byte v0, p1, Ldm/Battle;->throw_state:B

    if-nez v0, :cond_1

    .line 4201
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->imgItem:[Ljavax/microedition/lcdui/Image;

    aget-object v1, v1, v3

    iget-object v2, p1, Ldm/Battle;->cThrow:[S

    aget-short v2, v2, v3

    add-int/2addr v2, p4

    iget-object v3, p1, Ldm/Battle;->cThrow:[S

    aget-short v3, v3, v6

    sub-int v3, p5, v3

    sget-object v4, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sget-object v4, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v4, v6, 0x20

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 4209
    :cond_0
    :goto_0
    invoke-direct {p0, p1, p2, p3}, Lmain/GameRun;->runThrowBall(Ldm/Battle;Ldm/Monster;I)V

    .line 4210
    return-void

    .line 4202
    :cond_1
    iget-byte v0, p1, Ldm/Battle;->throw_state:B

    if-ne v0, v6, :cond_2

    .line 4203
    iget-object v0, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v1, p2, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    aget-byte v1, v0, v6

    .line 4204
    const/16 v5, 0x50

    const/16 v6, 0x4d

    const/16 v7, 0xf

    iget-object v0, p1, Ldm/Battle;->cThrow:[S

    aget-short v8, v0, v2

    move-object v0, p0

    move v2, p3

    move v3, p4

    move v4, p5

    move v9, p3

    .line 4203
    invoke-direct/range {v0 .. v9}, Lmain/GameRun;->drawClipPic(IIIIIIIII)V

    goto :goto_0

    .line 4205
    :cond_2
    iget-byte v0, p1, Ldm/Battle;->throw_state:B

    if-ne v0, v2, :cond_0

    .line 4206
    iget-object v0, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v1, p2, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    aget-byte v0, v0, v6

    mul-int/lit8 v3, v0, 0x3

    move-object v0, p0

    move v1, p3

    move v2, p3

    move v4, p4

    move v5, p5

    move v7, p3

    invoke-virtual/range {v0 .. v7}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    goto :goto_0
.end method

.method private drawVIEW_COMPUTER()V
    .locals 12

    .prologue
    .line 1291
    const/16 v9, 0x19

    .local v9, "FONT_W":I
    const/16 v8, 0x19

    .line 1292
    .local v8, "FONT_H":I
    const/16 v11, 0x140

    .local v11, "WIDTH_H":I
    const/16 v10, 0xb4

    .line 1293
    .local v10, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    mul-int/lit8 v1, v9, 0x2

    sub-int v1, v11, v1

    const/16 v2, 0x8

    sub-int/2addr v1, v2

    mul-int/lit8 v2, v8, 0x2

    sub-int v2, v10, v2

    const/16 v3, 0x8

    sub-int/2addr v2, v3

    mul-int/lit8 v3, v9, 0x4

    add-int/lit8 v3, v3, 0x10

    mul-int/lit8 v4, v8, 0x6

    add-int/lit8 v4, v4, 0x10

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK2(IIIII)V

    .line 1294
    iget-object v1, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    sub-int v0, v11, v9

    const/4 v2, 0x4

    sub-int v2, v0, v2

    sub-int v3, v10, v8

    add-int/lit8 v0, v9, 0x4

    mul-int/lit8 v4, v0, 0x2

    const/4 v5, 0x2

    const/4 v6, 0x0

    iget-byte v7, p0, Lmain/GameRun;->popMenu:B

    move-object v0, p0

    invoke-virtual/range {v0 .. v7}, Lmain/GameRun;->drawSelectMenu([Ljava/lang/Object;IIIIII)V

    .line 1295
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const-string v1, "\u5bc4\u5b58\u5ba0\u7269"

    mul-int/lit8 v2, v8, 0x2

    sub-int v2, v10, v2

    const/4 v3, 0x6

    sub-int v3, v2, v3

    const/16 v4, 0x11

    const/4 v5, 0x1

    const/4 v6, 0x1

    move v2, v11

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1296
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 1297
    return-void
.end method

.method private effectR(Ldm/Monster;)V
    .locals 2
    .param p1, "monster"    # Ldm/Monster;

    .prologue
    .line 685
    iget-byte v0, p1, Ldm/Monster;->effect_time:B

    if-lez v0, :cond_0

    iget-byte v0, p1, Ldm/Monster;->effect_time:B

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    int-to-byte v0, v0

    iput-byte v0, p1, Ldm/Monster;->effect_time:B

    .line 686
    :cond_0
    iget-byte v0, p1, Ldm/Monster;->effect_time:B

    if-nez v0, :cond_1

    const/4 v0, 0x7

    iput-byte v0, p1, Ldm/Monster;->effect:B

    .line 687
    :cond_1
    return-void
.end method

.method private enemy_init()V
    .locals 12

    .prologue
    const/4 v11, 0x4

    const/4 v10, 0x1

    const/4 v9, -0x1

    const/4 v8, 0x3

    const/4 v7, 0x0

    .line 5550
    iget-object v2, p0, Lmain/GameRun;->enemyList:[[B

    array-length v2, v2

    new-array v0, v2, [Ldm/Monster;

    .line 5551
    .local v0, "eMonsters":[Ldm/Monster;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lmain/GameRun;->enemyList:[[B

    array-length v2, v2

    if-lt v1, v2, :cond_0

    .line 5560
    const/4 v2, 0x0

    iput-object v2, p0, Lmain/GameRun;->enemyList:[[B

    .line 5561
    new-instance v2, Ldm/Battle;

    invoke-direct {v2, v0}, Ldm/Battle;-><init>([Ldm/Monster;)V

    iput-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    .line 5562
    return-void

    .line 5552
    :cond_0
    new-instance v2, Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->enemyList:[[B

    aget-object v3, v3, v1

    aget-byte v3, v3, v7

    iget-object v4, p0, Lmain/GameRun;->enemyList:[[B

    aget-object v4, v4, v1

    aget-byte v4, v4, v10

    .line 5553
    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, v7

    const/16 v6, 0x27

    invoke-virtual {v5, v6}, Ldm/Monster;->isMonReel(I)Z

    move-result v5

    if-eqz v5, :cond_2

    move v5, v10

    :goto_1
    invoke-direct {v2, p0, v3, v4, v5}, Ldm/Monster;-><init>(Lmain/GameRun;III)V

    .line 5552
    aput-object v2, v0, v1

    .line 5554
    iget-byte v2, p0, Lmain/GameRun;->battle_type:B

    if-eq v2, v8, :cond_1

    iget-byte v2, p0, Lmain/GameRun;->battle_type:B

    if-nez v2, :cond_4

    .line 5555
    :cond_1
    aget-object v2, v0, v1

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v8

    if-ne v2, v9, :cond_3

    aget-object v2, v0, v1

    iget-object v3, p0, Lmain/GameRun;->enemyList:[[B

    aget-object v3, v3, v1

    aget-byte v3, v3, v11

    invoke-virtual {v2, v3}, Ldm/Monster;->resetBoss(I)V

    .line 5557
    :goto_2
    aget-object v2, v0, v1

    invoke-virtual {v2, p0}, Ldm/Monster;->resetPro(Lmain/GameRun;)V

    .line 5551
    :goto_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_2
    move v5, v7

    .line 5553
    goto :goto_1

    .line 5556
    :cond_3
    aget-object v2, v0, v1

    iget-object v3, p0, Lmain/GameRun;->enemyList:[[B

    aget-object v3, v3, v1

    const/4 v4, 0x2

    aget-byte v3, v3, v4

    iget-object v4, p0, Lmain/GameRun;->enemyList:[[B

    aget-object v4, v4, v1

    aget-byte v4, v4, v8

    iget-object v5, p0, Lmain/GameRun;->enemyList:[[B

    aget-object v5, v5, v1

    aget-byte v5, v5, v11

    invoke-virtual {v2, v3, v4, v5}, Ldm/Monster;->resetMonster(III)V

    goto :goto_2

    .line 5558
    :cond_4
    aget-object v2, v0, v1

    invoke-virtual {v2, p0, v9}, Ldm/Monster;->resetMonster(Lmain/GameRun;I)V

    goto :goto_3
.end method

.method private getBXY(IIZ)I
    .locals 3
    .param p1, "state"    # I
    .param p2, "skill"    # I
    .param p3, "bb"    # Z

    .prologue
    .line 4564
    const/16 v0, 0x10a

    .local v0, "x":I
    const/16 v1, 0xec

    .line 4565
    .local v1, "y":I
    const/4 v2, 0x1

    if-ne p1, v2, :cond_0

    invoke-direct {p0, p2}, Lmain/GameRun;->isSkillToMe(I)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    if-nez p1, :cond_2

    invoke-direct {p0, p2}, Lmain/GameRun;->isSkillToMe(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 4566
    :cond_1
    const/16 v0, 0x179

    .line 4567
    const/16 v1, 0x61

    .line 4569
    :cond_2
    if-eqz p3, :cond_3

    move v2, v0

    :goto_0
    return v2

    :cond_3
    move v2, v1

    goto :goto_0
.end method

.method private getBattleBG(Ldm/Battle;Ldm/Monster;)V
    .locals 3
    .param p1, "be"    # Ldm/Battle;
    .param p2, "mon"    # Ldm/Monster;

    .prologue
    .line 5665
    iget-object v1, p0, Lmain/GameRun;->monPro:[B

    array-length v1, v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lmain/GameRun;->monPro:[B

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    iput-byte v1, p1, Ldm/Battle;->bg_id:B

    .line 5666
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    const/4 v1, 0x5

    if-lt v0, v1, :cond_1

    .line 5672
    :goto_1
    return-void

    .line 5667
    :cond_1
    add-int/lit8 v1, v0, 0x2b

    invoke-virtual {p2, v1}, Ldm/Monster;->isMonReel(I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 5668
    iput-byte v0, p1, Ldm/Battle;->bg_id:B

    goto :goto_1

    .line 5666
    :cond_2
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method private getBuyItemCount(IIZ)I
    .locals 7
    .param p1, "type"    # I
    .param p2, "select"    # I
    .param p3, "bb"    # Z

    .prologue
    const/4 v6, 0x1

    .line 745
    if-eqz p3, :cond_3

    .line 746
    const/4 v2, 0x2

    if-ne p1, v2, :cond_1

    iget v2, p0, Lmain/GameRun;->coin:I

    iget v3, p0, Lmain/GameRun;->sell_money:I

    div-int/2addr v2, v3

    move v0, v2

    .line 747
    .local v0, "c0":I
    :goto_0
    const/16 v2, 0x63

    const/4 v3, -0x2

    iget-object v4, p0, Lmain/GameRun;->buyItem:[[B

    iget-byte v5, p0, Lmain/GameRun;->cur_a:B

    aget-object v4, v4, v5

    aget-byte v4, v4, p2

    invoke-virtual {p0, v3, v4, v6}, Lmain/GameRun;->findItem(IIZ)B

    move-result v3

    sub-int v1, v2, v3

    .line 748
    .local v1, "c1":I
    if-gez v1, :cond_0

    const/4 v1, 0x0

    .line 749
    :cond_0
    if-le v0, v1, :cond_2

    move v2, v1

    .line 751
    .end local v0    # "c0":I
    .end local v1    # "c1":I
    :goto_1
    return v2

    .line 746
    :cond_1
    iget v2, p0, Lmain/GameRun;->money:I

    iget v3, p0, Lmain/GameRun;->sell_money:I

    div-int/2addr v2, v3

    move v0, v2

    goto :goto_0

    .restart local v0    # "c0":I
    .restart local v1    # "c1":I
    :cond_2
    move v2, v0

    .line 749
    goto :goto_1

    .line 751
    .end local v0    # "c0":I
    .end local v1    # "c1":I
    :cond_3
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    iget-byte v3, p0, Lmain/GameRun;->cur_a:B

    aget-object v2, v2, v3

    aget-object v2, v2, p2

    aget-byte v2, v2, v6

    goto :goto_1
.end method

.method private getExpOne(Z)V
    .locals 5
    .param p1, "half"    # Z

    .prologue
    const/4 v3, 0x2

    const/4 v4, 0x0

    .line 4472
    const/4 v0, 0x0

    .line 4473
    .local v0, "i":B
    iput-short v4, p0, Lmain/GameRun;->exp:S

    .line 4474
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, v1, Ldm/Battle;->mon:[Ldm/Monster;

    aget-object v1, v1, v4

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    sput v1, Ldm/Ms;->skip2:I

    .line 4475
    :goto_0
    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, v1, Ldm/Battle;->mon:[Ldm/Monster;

    array-length v1, v1

    if-lt v0, v1, :cond_1

    .line 4483
    iget-short v1, p0, Lmain/GameRun;->exp:S

    const/16 v2, 0x38

    iget-object v3, p0, Lmain/GameRun;->mon_in_battle:[B

    aget-byte v3, v3, v4

    div-int/2addr v2, v3

    iget-object v3, p0, Lmain/GameRun;->mon_in_battle:[B

    aget-byte v3, v3, v4

    const/4 v4, 0x1

    sub-int/2addr v3, v4

    mul-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x2c

    mul-int/2addr v1, v2

    div-int/lit8 v1, v1, 0x64

    int-to-short v1, v1

    iput-short v1, p0, Lmain/GameRun;->exp:S

    .line 4484
    if-nez p1, :cond_0

    iget-short v1, p0, Lmain/GameRun;->exp:S

    div-int/lit8 v1, v1, 0x2

    int-to-short v1, v1

    iput-short v1, p0, Lmain/GameRun;->exp:S

    .line 4486
    :cond_0
    return-void

    .line 4476
    :cond_1
    iget-short v1, p0, Lmain/GameRun;->exp:S

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v2, v2, Ldm/Battle;->mon:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v3

    mul-int/lit8 v2, v2, 0x3

    add-int/lit8 v2, v2, 0x50

    add-int/2addr v1, v2

    int-to-short v1, v1

    iput-short v1, p0, Lmain/GameRun;->exp:S

    .line 4477
    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, v1, Ldm/Battle;->mon:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v2, Ldm/Ms;->skip2:I

    if-le v1, v2, :cond_2

    .line 4478
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, v1, Ldm/Battle;->mon:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    sput v1, Ldm/Ms;->skip2:I

    .line 4475
    :cond_2
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method private getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V
    .locals 8
    .param p1, "be"    # Ldm/Battle;
    .param p2, "am"    # Ldm/Monster;
    .param p3, "dm"    # Ldm/Monster;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x3

    const/4 v5, 0x1

    .line 4282
    iget-object v1, p1, Ldm/Battle;->countS:[B

    aput-byte v7, v1, v5

    .line 4284
    iget-object v1, p2, Ldm/Monster;->monster:[B

    const/4 v2, 0x6

    aget-byte v1, v1, v2

    const/16 v2, 0x63

    sub-int/2addr v1, v2

    int-to-byte v0, v1

    .line 4285
    .local v0, "coe":B
    iget-object v1, p1, Ldm/Battle;->countS:[B

    aget-byte v2, v1, v5

    if-le v0, v5, :cond_1

    const/16 v3, 0x14

    :goto_0
    add-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v1, v5

    .line 4288
    iget-object v1, p2, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v6

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    iget-byte v1, p1, Ldm/Battle;->bg_id:B

    iget-object v2, p2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v6

    if-eq v1, v2, :cond_0

    .line 4290
    iget-object v1, p1, Ldm/Battle;->countS:[B

    aget-byte v2, v1, v5

    iget-byte v3, p1, Ldm/Battle;->bg_id:B

    iget-object v4, p2, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v6

    if-ne v3, v4, :cond_2

    move v3, v7

    :goto_1
    add-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v1, v5

    .line 4296
    :cond_0
    iget-object v1, p1, Ldm/Battle;->countS:[B

    aget-byte v2, v1, v5

    invoke-direct {p0, p2, p3}, Lmain/GameRun;->isShuXing(Ldm/Monster;Ldm/Monster;)B

    move-result v3

    add-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v1, v5

    .line 4298
    return-void

    .line 4285
    :cond_1
    div-int/lit8 v3, v0, 0x14

    mul-int/lit8 v3, v3, 0x14

    goto :goto_0

    .line 4290
    :cond_2
    const/16 v3, -0x14

    goto :goto_1
.end method

.method private getInfoType(I)Ljava/lang/String;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 1677
    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    const-string v0, "\u4efb\u52a1"

    .line 1684
    :goto_0
    return-object v0

    .line 1678
    :cond_0
    const/4 v0, -0x2

    if-ne p1, v0, :cond_1

    const-string v0, "\u8fdb\u5316"

    goto :goto_0

    .line 1679
    :cond_1
    const/4 v0, -0x3

    if-ne p1, v0, :cond_2

    const-string v0, "\u5f02\u5316"

    goto :goto_0

    .line 1680
    :cond_2
    const/4 v0, -0x4

    if-ne p1, v0, :cond_3

    const-string v0, "\u7ade\u6280\u573a"

    goto :goto_0

    .line 1682
    :cond_3
    const/4 v0, -0x5

    if-ne p1, v0, :cond_4

    const-string v0, "\u5b75\u5316"

    goto :goto_0

    .line 1684
    :cond_4
    const-string v0, "\u6355\u83b7"

    goto :goto_0
.end method

.method private getMonInfo_dir()B
    .locals 2

    .prologue
    .line 1696
    iget-object v0, p0, Lmain/GameRun;->monInfo_dir:[[B

    iget-byte v1, p0, Lmain/GameRun;->cur_a:B

    aget-object v0, v0, v1

    invoke-direct {p0}, Lmain/GameRun;->getSelInfo()B

    move-result v1

    aget-byte v0, v0, v1

    return v0
.end method

.method private getMonster(Ldm/Monster;IZ)B
    .locals 4
    .param p1, "monster"    # Ldm/Monster;
    .param p2, "evolve"    # I
    .param p3, "bb"    # Z

    .prologue
    const/4 v3, 0x2

    const/4 v2, 0x0

    .line 3545
    iget-object v0, p0, Lmain/GameRun;->monInfoList:[B

    iget-object v1, p1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    aget-byte v0, v0, v1

    if-eq v0, v3, :cond_0

    .line 3546
    iget-object v0, p0, Lmain/GameRun;->monInfoList:[B

    iget-object v1, p1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    aput-byte v3, v0, v1

    .line 3547
    invoke-virtual {p0}, Lmain/GameRun;->addMonInfoListBH()V

    .line 3548
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, p1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    invoke-virtual {v0, v1}, Lmain/Map;->addAnole(I)V

    .line 3551
    :cond_0
    iget-byte v0, p0, Lmain/GameRun;->myMon_length:B

    iget-byte v1, p0, Lmain/GameRun;->max_takes:B

    if-ge v0, v1, :cond_2

    .line 3552
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    aput-object p1, v0, v1

    .line 3553
    if-eqz p3, :cond_1

    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    aget-object v0, v0, v1

    invoke-virtual {v0, p0, p2}, Ldm/Monster;->resetMonster(Lmain/GameRun;I)V

    .line 3556
    :cond_1
    iget-byte v0, p0, Lmain/GameRun;->myMon_length:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->myMon_length:B

    move v0, v2

    .line 3571
    :goto_0
    return v0

    .line 3559
    :cond_2
    iget-byte v0, p0, Lmain/GameRun;->cMon_count:B

    iget-byte v1, p0, Lmain/GameRun;->max_monsters:B

    if-ge v0, v1, :cond_4

    .line 3561
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\u643a\u5e26\u5df2\u6ee1\uff0c"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\u5df2\u8f6c\u5165\u5bc4\u653e\u5904"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 3562
    iget-object v0, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->cMon_count:B

    aput-object p1, v0, v1

    .line 3563
    if-eqz p3, :cond_3

    iget-object v0, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->cMon_count:B

    aget-object v0, v0, v1

    invoke-virtual {v0, p0, p2}, Ldm/Monster;->resetMonster(Lmain/GameRun;I)V

    .line 3565
    :cond_3
    iget-byte v0, p0, Lmain/GameRun;->cMon_count:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->cMon_count:B

    .line 3569
    const/4 v0, 0x1

    goto :goto_0

    .line 3571
    :cond_4
    const/4 v0, -0x1

    goto :goto_0
.end method

.method private getMonsterExp(Ldm/Monster;)S
    .locals 2
    .param p1, "monster"    # Ldm/Monster;

    .prologue
    const/4 v1, 0x2

    .line 3335
    iget-object v0, p1, Ldm/Monster;->monster:[B

    aget-byte v0, v0, v1

    mul-int/lit16 v0, v0, 0xd2

    div-int/lit8 v0, v0, 0xa

    sub-int/2addr v0, v1

    int-to-short v0, v0

    return v0
.end method

.method private getNameBuff(I)Ljava/lang/String;
    .locals 1
    .param p1, "buff_id"    # I

    .prologue
    .line 3912
    const/4 v0, 0x1

    if-ge p1, v0, :cond_0

    const/4 p1, 0x0

    .line 3913
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->buff_name:[Ljava/lang/StringBuffer;

    aget-object v0, v0, p1

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getNameSkill(B)Ljava/lang/String;
    .locals 1
    .param p1, "skill_id"    # B

    .prologue
    .line 3910
    iget-object v0, p0, Lmain/GameRun;->skill_name:[Ljava/lang/StringBuffer;

    aget-object v0, v0, p1

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getPrice(IIZ)S
    .locals 4
    .param p1, "type"    # I
    .param p2, "select"    # I
    .param p3, "bb"    # Z

    .prologue
    const/4 v2, 0x0

    .line 734
    if-eqz p3, :cond_2

    .line 735
    const/4 v1, 0x2

    if-ne p1, v1, :cond_1

    iget-object v1, p0, Lmain/GameRun;->buyPrice:[[S

    const/4 v2, 0x1

    aget-object v1, v1, v2

    aget-short v1, v1, p2

    move v0, v1

    .line 737
    .local v0, "price":S
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    .line 738
    mul-int/lit8 v1, v0, 0xc

    div-int/lit8 v1, v1, 0xa

    int-to-short v0, v1

    .line 741
    :cond_0
    :goto_1
    return v0

    .line 735
    .end local v0    # "price":S
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->buyPrice:[[S

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/GameRun;->buyItem:[[B

    iget-byte v3, p0, Lmain/GameRun;->cur_a:B

    aget-object v2, v2, v3

    aget-byte v2, v2, p2

    aget-short v1, v1, v2

    move v0, v1

    goto :goto_0

    .line 740
    :cond_2
    iget-object v1, p0, Lmain/GameRun;->buyPrice:[[S

    aget-object v1, v1, v2

    aget-short v1, v1, p2

    div-int/lit8 v1, v1, 0x5

    int-to-short v0, v1

    .restart local v0    # "price":S
    goto :goto_1
.end method

.method private getSelInfo()B
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1688
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v1

    aget-byte v0, v0, v1

    return v0
.end method

.method private getSkill(II)V
    .locals 2
    .param p1, "skill_level"    # I
    .param p2, "pro"    # I

    .prologue
    .line 5762
    if-nez p1, :cond_0

    const/16 v0, 0x19

    :goto_0
    iput-byte v0, p0, Lmain/GameRun;->getSkill:B

    .line 5763
    return-void

    .line 5762
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->skill_up:[[B

    const/4 v1, 0x1

    sub-int v1, p1, v1

    aget-object v0, v0, v1

    aget-byte v0, v0, p2

    goto :goto_0
.end method

.method private getSkillLevel(I)I
    .locals 3
    .param p1, "skill"    # I

    .prologue
    const/16 v1, 0x19

    .line 5765
    if-ne p1, v1, :cond_0

    const/4 v0, 0x0

    .line 5767
    :goto_0
    return v0

    .line 5766
    :cond_0
    if-ge p1, v1, :cond_1

    rem-int/lit8 v0, p1, 0x5

    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 5767
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->makeLevel:[B

    sub-int v1, p1, v1

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    aget-byte v0, v0, v1

    goto :goto_0
.end method

.method private getSkillMana(Ldm/Monster;I)I
    .locals 3
    .param p1, "mon"    # Ldm/Monster;
    .param p2, "sl"    # I

    .prologue
    .line 5770
    iget-object v1, p0, Lmain/GameRun;->skill:[[B

    aget-object v1, v1, p2

    const/4 v2, 0x1

    aget-byte v0, v1, v2

    .line 5771
    .local v0, "vaule":B
    iget-object v1, p1, Ldm/Monster;->monster:[B

    const/4 v2, 0x3

    aget-byte v1, v1, v2

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    const/16 v1, 0x23

    invoke-virtual {p1, v1}, Ldm/Monster;->isMonReel(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 5772
    iget-object v1, p0, Lmain/GameRun;->skill:[[B

    aget-object v1, v1, p2

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    mul-int/2addr v1, v0

    div-int/lit8 v1, v1, 0x64

    .line 5771
    :goto_0
    return v1

    :cond_0
    move v1, v0

    .line 5772
    goto :goto_0
.end method

.method private getbuffRateV(Ldm/Monster;I)S
    .locals 3
    .param p1, "mon"    # Ldm/Monster;
    .param p2, "temp"    # I

    .prologue
    const/4 v2, 0x2

    const/4 v1, 0x1

    .line 3437
    invoke-virtual {p1, v2}, Ldm/Monster;->isBuffRate(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3438
    iget-object v0, p0, Lmain/GameRun;->inhesion:[B

    aget-byte v0, v0, v2

    mul-int/2addr v0, p2

    div-int/lit8 v0, v0, 0x64

    add-int/2addr p2, v0

    .line 3441
    :cond_0
    :goto_0
    int-to-short v0, p2

    return v0

    .line 3439
    :cond_1
    invoke-virtual {p1, v1}, Ldm/Monster;->isBuffRate(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3440
    iget-object v0, p0, Lmain/GameRun;->inhesion:[B

    aget-byte v0, v0, v1

    mul-int/2addr v0, p2

    div-int/lit8 v0, v0, 0x64

    add-int/2addr p2, v0

    goto :goto_0
.end method

.method private goBattleExp(Z)V
    .locals 3
    .param p1, "half"    # Z

    .prologue
    const/4 v1, 0x0

    .line 4515
    const/4 v0, -0x5

    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 4516
    iput-byte v1, p0, Lmain/GameRun;->cur_c:B

    .line 4517
    iput-byte v1, p0, Lmain/GameRun;->b_c:B

    .line 4518
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->now_id:B

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x1

    aget-byte v1, v1, v2

    iput-byte v1, v0, Ldm/Battle;->now_id:B

    .line 4519
    iget-object v0, p0, Lmain/GameRun;->proReplace:[[S

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v1, v1, Ldm/Battle;->now_id:B

    aget-object v0, v0, v1

    const/4 v1, 0x2

    const/4 v2, -0x2

    aput-short v2, v0, v1

    .line 4520
    invoke-direct {p0}, Lmain/GameRun;->arangeMonster()V

    .line 4521
    invoke-direct {p0, p1}, Lmain/GameRun;->getExpOne(Z)V

    .line 4522
    return-void
.end method

.method private goBattleItem()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/16 v3, 0x20

    .line 4499
    const/4 v1, -0x4

    iput-byte v1, p0, Lmain/GameRun;->battle_state:B

    .line 4500
    const/4 v1, -0x1

    iput-byte v1, p0, Lmain/GameRun;->cur_b:B

    .line 4501
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 4503
    .local v0, "sbuff":Ljava/lang/StringBuffer;
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v1, 0x64

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    const/16 v2, 0x32

    if-ge v1, v2, :cond_0

    const/4 v1, -0x2

    invoke-virtual {p0, v1, v3, v4}, Lmain/GameRun;->findItem(IIZ)B

    move-result v1

    const/16 v2, 0x63

    if-ge v1, v2, :cond_0

    .line 4507
    invoke-virtual {p0, v3, v4}, Lmain/GameRun;->addItem(II)B

    .line 4508
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u83b7\u5f97\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v3}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "x1"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 4510
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x2710

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v2, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 4511
    const/4 v0, 0x0

    .line 4512
    return-void
.end method

.method private goBattleOver()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 4524
    const/16 v0, -0xf

    sput v0, Lmain/GameRun;->run_state:I

    .line 4525
    iput-byte v1, p0, Lmain/GameRun;->b_c:B

    .line 4526
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v1, v0, Ldm/Battle;->now_id:B

    .line 4527
    const/4 v0, 0x3

    iput-byte v0, p0, Lmain/GameRun;->mini_state:B

    .line 4528
    const/4 v0, 0x1

    iput-byte v0, p0, Lmain/GameRun;->view_state:B

    .line 4529
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->bg_id:B

    iput-byte v0, p0, Lmain/GameRun;->bg_c:B

    .line 4531
    iget-object v0, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ldm/Sprite;->nullIMFA()V

    .line 4532
    return-void
.end method

.method private goBattleState()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 5526
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "\u653b\u51fb"

    aput-object v2, v0, v1

    const-string v1, "\u9053\u5177"

    aput-object v1, v0, v3

    const-string v1, "\u5ba0\u7269"

    aput-object v1, v0, v4

    const/4 v1, 0x3

    const-string v2, "\u5546\u5e97"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "\u9003\u8dd1"

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    .line 5530
    const/16 v0, -0x1f

    sput v0, Lmain/GameRun;->run_state:I

    .line 5531
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-ne v0, v3, :cond_0

    move v0, v4

    :goto_0
    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 5532
    return-void

    :cond_0
    move v0, v3

    .line 5531
    goto :goto_0
.end method

.method private goCatchMonster()V
    .locals 1

    .prologue
    .line 4123
    const/16 v0, -0x13

    sput v0, Lmain/GameRun;->run_state:I

    .line 4124
    const/16 v0, 0x83

    iput-short v0, p0, Lmain/GameRun;->cThrowX:S

    .line 4125
    const/16 v0, -0x14

    iput-short v0, p0, Lmain/GameRun;->cThrowY:S

    .line 4126
    const/16 v0, 0xb0

    iput-short v0, p0, Lmain/GameRun;->cThrowS:S

    .line 4127
    const/4 v0, 0x0

    iput-byte v0, p0, Lmain/GameRun;->b_c:B

    .line 4139
    return-void
.end method

.method private goGO_RUNINMAP()V
    .locals 1

    .prologue
    .line 2797
    const/4 v0, 0x0

    iput-byte v0, p0, Lmain/GameRun;->b_c:B

    .line 2799
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 2800
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 2801
    const/16 v0, -0xb

    sput v0, Lmain/GameRun;->run_state:I

    .line 2802
    return-void
.end method

.method private goLIST_INFO(Z)V
    .locals 5
    .param p1, "bb"    # Z

    .prologue
    const/4 v4, 0x0

    .line 1735
    const/16 v1, 0x44

    sput v1, Lmain/GameRun;->run_state:I

    .line 1736
    iget-object v1, p0, Lmain/GameRun;->monInfo_dir:[[B

    if-nez v1, :cond_0

    .line 1737
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/book.d"

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 1738
    .local v0, "data":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v4, Ldm/Ms;->skip:I

    .line 1739
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->monInfo_dir:[[B

    .line 1740
    const/4 v1, 0x0

    check-cast v1, [B

    .line 1742
    .end local v0    # "data":[B
    :cond_0
    if-eqz p1, :cond_1

    .line 1743
    iput-byte v4, p0, Lmain/GameRun;->infoStart:B

    .line 1744
    iput-byte v4, p0, Lmain/GameRun;->cur_a:B

    .line 1745
    iput-byte v4, p0, Lmain/GameRun;->cur_b:B

    .line 1746
    const/4 v1, 0x6

    iput-short v1, p0, Lmain/GameRun;->move_x:S

    .line 1747
    iput-short v4, p0, Lmain/GameRun;->move_y:S

    .line 1748
    iget-object v1, p0, Lmain/GameRun;->monInfo_dir:[[B

    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    aget-object v1, v1, v2

    array-length v1, v1

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/GameRun;->t_length:B

    .line 1750
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aput-byte v4, v1, v4

    .line 1751
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    const/4 v2, 0x1

    aput-byte v4, v1, v2

    .line 1760
    :cond_1
    const/4 v1, 0x7

    iput-byte v1, p0, Lmain/GameRun;->list_rows:B

    .line 1764
    return-void
.end method

.method private goMONSTER_INFO(I)V
    .locals 3
    .param p1, "id"    # I

    .prologue
    .line 1766
    const/16 v0, 0x43

    sput v0, Lmain/GameRun;->run_state:I

    .line 1767
    const/4 v0, 0x2

    iget-object v1, p0, Lmain/GameRun;->mList_id:[[B

    aget-object v1, v1, p1

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->initMonStream(III)V

    .line 1768
    return-void
.end method

.method private goMY_BAG(I)V
    .locals 6
    .param p1, "type"    # I

    .prologue
    const/4 v2, 0x2

    const/4 v5, -0x1

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 2805
    const/16 v0, 0xf

    iput-byte v0, p0, Lmain/GameRun;->mini_state:B

    .line 2813
    const/4 v0, 0x6

    iput-byte v0, p0, Lmain/GameRun;->list_rows:B

    .line 2815
    const/16 v0, 0x19

    sput v0, Lmain/GameRun;->run_state:I

    .line 2816
    iput-byte v5, p0, Lmain/GameRun;->popMenu:B

    .line 2818
    iget-byte v0, p0, Lmain/GameRun;->view_state:B

    if-ne v0, v3, :cond_1

    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "\u9053\u5177"

    aput-object v1, v0, v4

    const-string v1, "\u8f85\u52a9"

    aput-object v1, v0, v3

    const-string v1, "\u5377\u8f74"

    aput-object v1, v0, v2

    const/4 v1, 0x3

    const-string v2, "\u5b75\u5316"

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    .line 2826
    :cond_0
    :goto_0
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/GameRun;->selectx:B

    .line 2827
    iput-byte v4, p0, Lmain/GameRun;->selecty:B

    .line 2828
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    iget-object v1, p0, Lmain/GameRun;->select_st:[B

    iget-byte v2, p0, Lmain/GameRun;->selectx:B

    aget-byte v1, v1, v2

    aput-byte v1, v0, v3

    .line 2829
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    iget-object v1, p0, Lmain/GameRun;->select_it:[B

    iget-byte v2, p0, Lmain/GameRun;->selectx:B

    aget-byte v1, v1, v2

    aput-byte v1, v0, v4

    .line 2830
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    iget-object v2, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v3, p0, Lmain/GameRun;->selectx:B

    aget-byte v2, v2, v3

    iget-byte v3, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->correctSelect([BII)V

    .line 2832
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/GameRun;->itemMine:[[B

    .line 2833
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v4, Ldm/Ms;->skip:I

    .line 2834
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/box.d"

    invoke-virtual {v1, v2, v5}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun;->itemMine:[[B

    .line 2835
    return-void

    .line 2822
    :cond_1
    iget-byte v0, p0, Lmain/GameRun;->view_state:B

    if-ne v0, v5, :cond_2

    new-array v0, v3, [Ljava/lang/String;

    const-string v1, "\u9053\u5177"

    aput-object v1, v0, v4

    invoke-virtual {p0, v0}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    goto :goto_0

    .line 2824
    :cond_2
    iget-byte v0, p0, Lmain/GameRun;->view_state:B

    if-ne v0, v2, :cond_0

    new-array v0, v3, [Ljava/lang/String;

    const-string v1, "\u5b75\u5316"

    aput-object v1, v0, v4

    invoke-virtual {p0, v0}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    goto :goto_0
.end method

.method private goMontsterAppear()V
    .locals 1

    .prologue
    .line 4158
    const/16 v0, -0x32

    sput v0, Lmain/GameRun;->run_state:I

    .line 4159
    const/4 v0, 0x0

    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 4161
    const/16 v0, 0x3f

    iput v0, p0, Lmain/GameRun;->enemyOff:I

    .line 4165
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lmain/GameRun;->setAimBattle(I)V

    .line 4166
    return-void
.end method

.method private goRUN_IN_MAP(Z)V
    .locals 4
    .param p1, "bb"    # Z

    .prologue
    const/4 v3, 0x0

    .line 3872
    iput-byte v3, p0, Lmain/GameRun;->selecty:B

    .line 3873
    iput-byte v3, p0, Lmain/GameRun;->selectx:B

    .line 3874
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v3

    const/4 v1, 0x1

    aput-byte v3, v0, v1

    .line 3875
    iput-byte v3, p0, Lmain/GameRun;->mini_state:B

    .line 3876
    iput-byte v3, p0, Lmain/GameRun;->view_state:B

    .line 3877
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/16 v1, 0x1e

    iput v1, v0, Lmain/MainCanvas;->game_state:I

    .line 3878
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "aaaaaaaaaaaaaaaaa"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 3879
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v3, v0, Ldm/Npc;->state:B

    .line 3884
    iget-object v0, p0, Lmain/GameRun;->isChangeSound:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 3885
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->musicNo:[B

    iget-object v2, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v2, v2, Lmain/Map;->mapNo:B

    aget-byte v1, v1, v2

    invoke-virtual {v0, v1}, Ldm/Sound;->setMusicId(I)V

    .line 3887
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, p1}, Ldm/Sound;->setMusic(Z)V

    .line 3888
    const-string v0, "soars"

    const-string v1, "tttttttttttttttttttttt"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 3890
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->isChangeSound:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3891
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->musicNo:[B

    iget-object v2, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v2, v2, Lmain/Map;->mapNo:B

    aget-byte v1, v1, v2

    invoke-virtual {v0, v1}, Ldm/Sound;->setMusicId(I)V

    .line 3892
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, p1}, Ldm/Sound;->setMusicForMenu(Z)V

    .line 3894
    const-string v0, "soars"

    const-string v1, "ffffffffffffffffffffffffffffffff"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 3897
    :cond_1
    const/16 v0, -0xa

    sput v0, Lmain/GameRun;->run_state:I

    .line 3899
    iput-byte v3, p0, Lmain/GameRun;->createOver:B

    .line 3900
    iput-byte v3, p0, Lmain/GameRun;->buyItemID:B

    .line 3904
    return-void
.end method

.method private goSelectAction(I)V
    .locals 3
    .param p1, "mini"    # I

    .prologue
    const/4 v1, 0x1

    .line 5535
    const/16 v0, -0x1f

    sput v0, Lmain/GameRun;->run_state:I

    .line 5536
    if-ne p1, v1, :cond_1

    const/4 v0, 0x2

    :goto_0
    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 5537
    invoke-virtual {p0, p1}, Lmain/GameRun;->setAimBattle(I)V

    .line 5538
    if-ne p1, v1, :cond_0

    .line 5539
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    invoke-virtual {p0, v0}, Lmain/GameRun;->initSkillList(Ldm/Monster;)V

    .line 5542
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 5543
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 5544
    return-void

    :cond_1
    move v0, v1

    .line 5536
    goto :goto_0
.end method

.method private goView()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 2558
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v2

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    aput-byte v1, v0, v3

    .line 2559
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v2

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aput-byte v1, v0, v2

    .line 2560
    iput-byte v2, p0, Lmain/GameRun;->cur_c:B

    .line 2561
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 2562
    const-string v0, "\u751f\u547d#n\u80fd\u91cf#n\u6863\u6b21"

    sget v1, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2563
    const-string v0, "\u529b\u91cf#n\u9632\u5fa1#n\u654f\u6377"

    sget v1, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v0, v1, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2564
    return-void
.end method

.method private hit_rate(Ldm/Battle;Ldm/Battle;Ldm/Monster;Ldm/Monster;I)V
    .locals 8
    .param p1, "amB"    # Ldm/Battle;
    .param p2, "dmB"    # Ldm/Battle;
    .param p3, "am"    # Ldm/Monster;
    .param p4, "dm"    # Ldm/Monster;
    .param p5, "skill_no"    # I

    .prologue
    .line 4412
    invoke-virtual {p1}, Ldm/Battle;->initHit()V

    .line 4413
    invoke-virtual {p2}, Ldm/Battle;->initHit()V

    .line 4415
    iget-object v0, p3, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x5

    aget-short v0, v0, v1

    iget-object v1, p4, Ldm/Monster;->monsterPro:[S

    const/4 v2, 0x5

    aget-short v1, v1, v2

    sub-int/2addr v0, v1

    iput v0, p0, Lmain/GameRun;->hit_rate:I

    .line 4416
    iget v0, p0, Lmain/GameRun;->hit_rate:I

    div-int/lit8 v0, v0, 0x2

    add-int/lit8 v0, v0, 0x5c

    iget-byte v1, p1, Ldm/Battle;->rate_off:B

    add-int/2addr v0, v1

    iput v0, p0, Lmain/GameRun;->hit_rate:I

    .line 4419
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v0, 0x64

    invoke-static {v0}, Ldm/Ms;->getRandom(I)I

    move-result v0

    int-to-byte v7, v0

    .line 4422
    .local v7, "rand":B
    const/4 v0, 0x0

    iput-byte v0, p1, Ldm/Battle;->rate_off:B

    .line 4424
    const/16 v0, 0x1a

    if-le p5, v0, :cond_1

    const/16 v0, 0x1e

    if-ge p5, v0, :cond_1

    .line 4425
    packed-switch p5, :pswitch_data_0

    .line 4452
    :cond_0
    :goto_0
    return-void

    .line 4428
    :pswitch_0
    iget-object v0, p0, Lmain/GameRun;->skill:[[B

    aget-object v0, v0, p5

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    neg-int v0, v0

    mul-int/lit8 v0, v0, 0xa

    const/4 v1, 0x1

    const/4 v2, 0x1

    invoke-virtual {p1, v0, v1, v2}, Ldm/Battle;->addHit(III)V

    goto :goto_0

    .line 4431
    :pswitch_1
    iget-object v0, p3, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x6

    aget-short v0, v0, v1

    iget-object v1, p0, Lmain/GameRun;->skill:[[B

    aget-object v1, v1, p5

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    mul-int/2addr v0, v1

    iget-object v1, p3, Ldm/Monster;->monsterPro:[S

    const/4 v2, 0x1

    aget-short v1, v1, v2

    add-int/2addr v0, v1

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p2, v0, v1, v2}, Ldm/Battle;->addHit(III)V

    .line 4432
    iget-object v0, p3, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x1

    aget-short v0, v0, v1

    const/4 v1, 0x4

    const/4 v2, 0x2

    invoke-virtual {p1, v0, v1, v2}, Ldm/Battle;->addHit(III)V

    goto :goto_0

    .line 4436
    :cond_1
    iget v0, p0, Lmain/GameRun;->hit_rate:I

    if-lt v7, v0, :cond_2

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_6

    iget-object v0, p3, Ldm/Monster;->monster:[B

    const/4 v1, 0x2

    aget-byte v0, v0, v1

    const/16 v1, 0xb

    if-ge v0, v1, :cond_6

    .line 4437
    :cond_2
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    xor-int/lit8 v6, v0, 0x1

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    invoke-direct/range {v0 .. v6}, Lmain/GameRun;->damage(Ldm/Battle;Ldm/Battle;Ldm/Monster;Ldm/Monster;II)V

    .line 4438
    const/16 v0, 0x1a

    if-ne p5, v0, :cond_4

    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    const/16 v1, 0x28

    invoke-virtual {v0, v1}, Ldm/Monster;->isMonReel(I)Z

    move-result v0

    if-nez v0, :cond_4

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v0, 0x64

    invoke-static {v0}, Ldm/Ms;->getRandom(I)I

    move-result v0

    iget-object v1, p0, Lmain/GameRun;->skill:[[B

    aget-object v1, v1, p5

    const/4 v2, 0x2

    aget-byte v1, v1, v2

    if-ge v0, v1, :cond_4

    .line 4439
    iget-object v0, p0, Lmain/GameRun;->skill:[[B

    aget-object v0, v0, p5

    const/4 v1, 0x3

    aget-byte v0, v0, v1

    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x6

    aget-byte v1, v1, v2

    mul-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x64

    const/4 v1, -0x2

    const/4 v2, 0x2

    invoke-virtual {p2, v0, v1, v2}, Ldm/Battle;->addHit(III)V

    .line 4441
    :cond_3
    :goto_1
    iget-object v0, p3, Ldm/Monster;->monster:[B

    const/4 v1, 0x3

    aget-byte v0, v0, v1

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/16 v0, 0x22

    invoke-virtual {p3, v0}, Ldm/Monster;->isMonReel(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4442
    iget-object v0, p4, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x3

    aget-short v0, v0, v1

    iget-object v1, p0, Lmain/GameRun;->skill:[[B

    const/16 v2, 0x22

    aget-object v1, v1, v2

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    mul-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x64

    const/4 v1, 0x4

    const/4 v2, 0x2

    invoke-virtual {p2, v0, v1, v2}, Ldm/Battle;->addHit(III)V

    goto/16 :goto_0

    .line 4440
    :cond_4
    const/16 v0, 0x19

    if-lt p5, v0, :cond_5

    const/16 v0, 0x1e

    if-ne p5, v0, :cond_3

    :cond_5
    invoke-direct {p0, p2, p3, p4, p5}, Lmain/GameRun;->magicEffectRate(Ldm/Battle;Ldm/Monster;Ldm/Monster;I)Z

    goto :goto_1

    .line 4444
    :cond_6
    const/4 v0, 0x0

    const/4 v1, -0x1

    const/4 v2, 0x2

    invoke-virtual {p2, v0, v1, v2}, Ldm/Battle;->addHit(III)V

    .line 4445
    const/16 v0, 0x14

    iput-byte v0, p1, Ldm/Battle;->rate_off:B

    goto/16 :goto_0

    .line 4425
    nop

    :pswitch_data_0
    .packed-switch 0x1b
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private hpAdd(II)V
    .locals 5
    .param p1, "hp"    # I
    .param p2, "offer"    # I

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x0

    .line 3708
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v4

    if-ge v0, v1, :cond_0

    .line 3709
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    if-lez v0, :cond_0

    .line 3710
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v4

    mul-int/2addr v0, p1

    div-int/lit8 p1, v0, 0x64

    .line 3711
    add-int v0, p2, p1

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->AddHP(ILdm/Monster;)V

    .line 3712
    iget-object v0, p0, Lmain/GameRun;->select_it:[B

    aget-byte v0, v0, v3

    invoke-direct {p0, v3, v0}, Lmain/GameRun;->useState(II)V

    .line 3719
    :goto_0
    return-void

    .line 3715
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    const/4 v1, 0x1

    if-ge v0, v1, :cond_1

    .line 3716
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 3718
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private initMagicStream(I)V
    .locals 4
    .param p1, "i"    # I

    .prologue
    .line 5493
    iget-object v1, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    aget-object v1, v1, p1

    if-eqz v1, :cond_0

    .line 5497
    :goto_0
    return-void

    .line 5494
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "data/battle/s"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 5496
    .local v0, "s":Ljava/lang/String;
    iget-object v1, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;

    move-result-object v2

    aput-object v2, v1, p1

    goto :goto_0
.end method

.method private initOtherImage()V
    .locals 5

    .prologue
    .line 4042
    iget-object v1, p0, Lmain/GameRun;->imgItem:[Ljavax/microedition/lcdui/Image;

    if-nez v1, :cond_0

    .line 4047
    const/4 v1, 0x2

    new-array v1, v1, [Ljavax/microedition/lcdui/Image;

    iput-object v1, p0, Lmain/GameRun;->imgItem:[Ljavax/microedition/lcdui/Image;

    .line 4048
    iget-object v1, p0, Lmain/GameRun;->imgItem:[Ljavax/microedition/lcdui/Image;

    const/4 v2, 0x0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    const-string v4, "data/ball"

    invoke-virtual {v3, v4}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v3

    aput-object v3, v1, v2

    .line 4049
    iget-object v1, p0, Lmain/GameRun;->imgItem:[Ljavax/microedition/lcdui/Image;

    const/4 v2, 0x1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    const-string v4, "data/ll"

    invoke-virtual {v3, v4}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v3

    aput-object v3, v1, v2

    .line 4051
    invoke-virtual {p0}, Lmain/GameRun;->initItemModules()V

    .line 4055
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->imgBG:[Ljavax/microedition/lcdui/Image;

    if-nez v1, :cond_1

    .line 4056
    const/4 v1, 0x5

    new-array v1, v1, [Ljavax/microedition/lcdui/Image;

    iput-object v1, p0, Lmain/GameRun;->imgBG:[Ljavax/microedition/lcdui/Image;

    .line 4057
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-object v1, p0, Lmain/GameRun;->imgBG:[Ljavax/microedition/lcdui/Image;

    array-length v1, v1

    if-lt v0, v1, :cond_2

    .line 4061
    .end local v0    # "i":B
    :cond_1
    invoke-virtual {p0}, Lmain/GameRun;->initImgIco()V

    .line 4062
    return-void

    .line 4058
    .restart local v0    # "i":B
    :cond_2
    iget-object v1, p0, Lmain/GameRun;->imgBG:[Ljavax/microedition/lcdui/Image;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "data/battle/"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v2

    aput-object v2, v1, v0

    .line 4057
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method private isBagUse(I)Z
    .locals 4
    .param p1, "id"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 1144
    iget-byte v0, p0, Lmain/GameRun;->view_state:B

    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 1145
    const/16 v0, 0xe

    if-eq p1, v0, :cond_0

    const/16 v0, 0xf

    if-eq p1, v0, :cond_0

    move v0, v3

    .line 1146
    :goto_0
    return v0

    :cond_0
    move v0, v2

    .line 1145
    goto :goto_0

    .line 1146
    :cond_1
    const/16 v0, 0x9

    if-eq p1, v0, :cond_2

    const/16 v0, 0xa

    if-eq p1, v0, :cond_2

    const/16 v0, 0xb

    if-eq p1, v0, :cond_2

    const/16 v0, 0x8

    if-eq p1, v0, :cond_2

    move v0, v3

    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_0
.end method

.method private isEvolveKind(BB)B
    .locals 2
    .param p1, "kind"    # B
    .param p2, "level"    # B

    .prologue
    .line 2544
    const/4 v0, -0x1

    .line 2546
    .local v0, "dd":B
    const/4 v1, 0x1

    if-ne p1, v1, :cond_1

    const/16 v1, 0xf

    if-ge p2, v1, :cond_1

    const/4 v0, -0x2

    .line 2554
    :cond_0
    :goto_0
    return v0

    .line 2547
    :cond_1
    const/4 v1, 0x2

    if-ne p1, v1, :cond_2

    const/16 v1, 0x19

    if-ge p2, v1, :cond_2

    const/4 v0, -0x3

    goto :goto_0

    .line 2548
    :cond_2
    const/4 v1, 0x3

    if-ne p1, v1, :cond_0

    const/16 v1, 0x1e

    if-ge p2, v1, :cond_0

    const/4 v0, -0x4

    goto :goto_0
.end method

.method private isEvolveMake(I)B
    .locals 8
    .param p1, "id"    # I

    .prologue
    const/4 v7, -0x2

    const/4 v6, 0x1

    .line 2583
    const/4 v2, 0x2

    .local v2, "i":B
    iget-object v3, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v3, v3, p1

    const/4 v4, 0x0

    aget-byte v0, v3, v4

    .line 2586
    .local v0, "evolve":B
    :cond_0
    iget-object v3, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v3, v3, p1

    aget-byte v3, v3, v2

    invoke-virtual {p0, v7, v3, v6}, Lmain/GameRun;->findItem(IIZ)B

    move-result v3

    iget-object v4, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v4, v4, p1

    add-int/lit8 v5, v2, 0x1

    aget-byte v4, v4, v5

    if-ge v3, v4, :cond_1

    .line 2587
    const/4 v0, -0x1

    move v1, v0

    .line 2591
    .end local v0    # "evolve":B
    .local v1, "evolve":I
    :goto_0
    return v1

    .line 2588
    .end local v1    # "evolve":I
    .restart local v0    # "evolve":B
    :cond_1
    add-int/lit8 v3, v2, 0x2

    int-to-byte v2, v3

    .line 2589
    iget-object v3, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v3, v3, p1

    array-length v3, v3

    sub-int/2addr v3, v6

    if-lt v2, v3, :cond_0

    .line 2590
    if-lez v0, :cond_2

    const/16 v3, 0x22

    invoke-virtual {p0, v7, v3, v6}, Lmain/GameRun;->findItem(IIZ)B

    move-result v3

    if-ge v3, v6, :cond_2

    const/4 v0, 0x0

    :cond_2
    move v1, v0

    .line 2591
    .restart local v1    # "evolve":I
    goto :goto_0
.end method

.method private isMonHp(Ldm/Monster;I)Z
    .locals 4
    .param p1, "mon"    # Ldm/Monster;
    .param p2, "percent"    # I

    .prologue
    const/4 v3, 0x0

    .line 5757
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    iget-object v1, p1, Ldm/Monster;->monster:[B

    const/4 v2, 0x2

    aget-byte v1, v1, v2

    mul-int/2addr v1, p2

    div-int/lit8 v1, v1, 0x64

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    move v0, v3

    goto :goto_0
.end method

.method private isMyMonsters(I)Z
    .locals 3
    .param p1, "select_i"    # I

    .prologue
    const/4 v2, 0x0

    .line 4808
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    if-lt v0, v1, :cond_0

    move v1, v2

    .line 4813
    :goto_1
    return v1

    .line 4809
    :cond_0
    if-eq v0, p1, :cond_1

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v2

    if-lez v1, :cond_1

    .line 4810
    const/4 v1, 0x1

    goto :goto_1

    .line 4808
    :cond_1
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method private isShuXing(Ldm/Monster;Ldm/Monster;)B
    .locals 5
    .param p1, "am"    # Ldm/Monster;
    .param p2, "dm"    # Ldm/Monster;

    .prologue
    const/16 v4, 0x1e

    const/4 v3, 0x0

    const/4 v2, 0x3

    .line 4405
    iget-object v0, p1, Ldm/Monster;->monster:[B

    aget-byte v0, v0, v2

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    move v0, v4

    .line 4408
    :goto_0
    return v0

    .line 4406
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->Shuxing:[[B

    iget-object v1, p1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    aget-object v0, v0, v1

    aget-byte v0, v0, v3

    iget-object v1, p2, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    if-ne v0, v1, :cond_1

    move v0, v4

    goto :goto_0

    .line 4407
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->Shuxing:[[B

    iget-object v1, p1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    aget-object v0, v0, v1

    const/4 v1, 0x1

    aget-byte v0, v0, v1

    iget-object v1, p2, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v2

    if-ne v0, v1, :cond_2

    move v0, v3

    goto :goto_0

    :cond_2
    move v0, v3

    .line 4408
    goto :goto_0
.end method

.method private isSkillToMe(I)Z
    .locals 1
    .param p1, "skill"    # I

    .prologue
    .line 4562
    const/16 v0, 0x1b

    if-eq p1, v0, :cond_0

    const/16 v0, 0x1c

    if-eq p1, v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private keyBattleState()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v4, 0x2

    const/4 v6, -0x1

    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 5076
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_delay()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 5174
    :cond_0
    :goto_0
    return-void

    .line 5077
    :cond_1
    iget-byte v2, p0, Lmain/GameRun;->battle_state:B

    packed-switch v2, :pswitch_data_0

    goto :goto_0

    .line 5079
    :pswitch_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Left_Right()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 5080
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-byte v3, p0, Lmain/GameRun;->cur_a:B

    iget-object v4, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    array-length v4, v4

    sub-int/2addr v4, v5

    invoke-virtual {v2, v3, v7, v4}, Ldm/Ms;->select(III)B

    move-result v2

    iput-byte v2, p0, Lmain/GameRun;->cur_a:B

    goto :goto_0

    .line 5081
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_S1_Num5()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 5082
    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    if-nez v2, :cond_5

    .line 5083
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monster:[B

    const/4 v3, 0x6

    aget-byte v2, v2, v3

    if-nez v2, :cond_3

    const-string v2, "\u5ba0\u7269\u5fe0\u8bda\u5ea6\u4e3a0\uff0c\u8bf7\u7acb\u523b\u8865\u5145\uff01"

    invoke-virtual {p0, v2, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 5085
    :cond_3
    const/4 v2, 0x3

    iput-byte v2, p0, Lmain/GameRun;->battle_state:B

    .line 5086
    :goto_1
    iget-object v2, p0, Lmain/GameRun;->skill_list:[B

    iget-byte v3, p0, Lmain/GameRun;->lastSkill:B

    aget-byte v2, v2, v3

    const/16 v3, 0x1e

    if-gt v2, v3, :cond_4

    .line 5087
    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v7

    iget-byte v3, p0, Lmain/GameRun;->lastSkill:B

    aput-byte v3, v2, v7

    .line 5088
    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v7

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v7

    aget-byte v3, v3, v7

    const/4 v4, 0x5

    sub-int/2addr v3, v4

    int-to-byte v3, v3

    aput-byte v3, v2, v5

    .line 5089
    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v7

    aget-byte v2, v2, v5

    if-ge v2, v5, :cond_0

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v7

    aput-byte v7, v2, v5

    goto :goto_0

    .line 5086
    :cond_4
    iget-byte v2, p0, Lmain/GameRun;->lastSkill:B

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    iput-byte v2, p0, Lmain/GameRun;->lastSkill:B

    goto :goto_1

    .line 5091
    :cond_5
    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    if-ne v2, v5, :cond_7

    .line 5092
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-byte v2, v2, Ldm/Monster;->effect:B

    if-ne v2, v8, :cond_6

    .line 5093
    const-string v2, "\u7981\u9522\u4e2d\u65e0\u6cd5\u4f7f\u7528\u9053\u5177\uff01"

    invoke-virtual {p0, v2, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 5094
    :cond_6
    invoke-direct {p0, v7}, Lmain/GameRun;->goMY_BAG(I)V

    goto/16 :goto_0

    .line 5095
    :cond_7
    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    if-ne v2, v4, :cond_9

    .line 5096
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-byte v2, v2, Ldm/Monster;->effect:B

    if-ne v2, v8, :cond_8

    .line 5097
    const-string v2, "\u7981\u9522\u4e2d\u65e0\u6cd5\u66f4\u6362\u5ba0\u7269\uff01"

    invoke-virtual {p0, v2, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 5099
    :cond_8
    const/4 v2, -0x2

    iput-byte v2, p0, Lmain/GameRun;->view_state:B

    .line 5100
    invoke-virtual {p0}, Lmain/GameRun;->goVIEW_MONSTER()V

    goto/16 :goto_0

    .line 5104
    :cond_9
    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    const/4 v3, 0x3

    if-ne v2, v3, :cond_a

    .line 5105
    invoke-virtual {p0, v7, v7}, Lmain/GameRun;->goBUY_ITEM(II)V

    goto/16 :goto_0

    .line 5106
    :cond_a
    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    if-ne v2, v8, :cond_0

    .line 5110
    iget-byte v2, p0, Lmain/GameRun;->battle_type:B

    if-ne v2, v8, :cond_12

    .line 5111
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v4

    .line 5112
    iget-object v3, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v3}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v4

    .line 5111
    sub-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x3c

    int-to-short v0, v2

    .line 5113
    .local v0, "EscRate":S
    const/4 v1, 0x0

    .line 5114
    .local v1, "succ":B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v2, 0x64

    invoke-static {v2}, Ldm/Ms;->getRandom(I)I

    move-result v2

    if-ge v2, v0, :cond_c

    .line 5116
    :goto_2
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    const/16 v3, 0x2a

    invoke-virtual {v2, v3}, Ldm/Monster;->isMonReel(I)Z

    move-result v2

    if-eqz v2, :cond_d

    const/4 v1, 0x0

    .line 5118
    :cond_b
    :goto_3
    if-nez v1, :cond_f

    .line 5119
    invoke-direct {p0}, Lmain/GameRun;->arangeMonster()V

    .line 5120
    invoke-direct {p0}, Lmain/GameRun;->setNullBattle()V

    .line 5121
    invoke-direct {p0}, Lmain/GameRun;->goGO_RUNINMAP()V

    goto/16 :goto_0

    .line 5115
    :cond_c
    const/4 v1, 0x1

    goto :goto_2

    .line 5117
    :cond_d
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Ldm/Monster;->isEffect(I)Z

    move-result v2

    if-nez v2, :cond_e

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-virtual {v2, v8}, Ldm/Monster;->isEffect(I)Z

    move-result v2

    if-eqz v2, :cond_b

    :cond_e
    const/4 v1, 0x2

    goto :goto_3

    .line 5123
    :cond_f
    if-ne v1, v5, :cond_10

    .line 5124
    const-string v2, "\u9003\u8dd1\u5931\u8d25\uff01"

    invoke-virtual {p0, v2, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 5125
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v7, v2, Ldm/Battle;->act_num:B

    .line 5126
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v5, v2, Ldm/Battle;->act_num:B

    .line 5127
    const/16 v2, 0x9

    iput-byte v2, p0, Lmain/GameRun;->battle_state:B

    goto/16 :goto_0

    .line 5128
    :cond_10
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u88ab\u602a\u7269"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v3}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    invoke-virtual {v3, v8}, Ldm/Monster;->isEffect(I)Z

    move-result v3

    if-eqz v3, :cond_11

    const-string v3, "\u7981\u9522\u4e2d"

    :goto_4
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\uff0c"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\u65e0\u6cd5\u9003\u8dd1\uff01"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    :cond_11
    const-string v3, "\u7684\u7535\u773c\u9b45\u60d1\u4e86"

    goto :goto_4

    .line 5130
    .end local v0    # "EscRate":S
    .end local v1    # "succ":B
    :cond_12
    const-string v2, "\u65e0\u6cd5\u9003\u8dd1\uff01"

    invoke-virtual {p0, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 5135
    :pswitch_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Up_Down()Z

    move-result v2

    if-eqz v2, :cond_13

    .line 5139
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v7

    iget-object v4, p0, Lmain/GameRun;->skill_list:[B

    const/16 v5, 0x8

    aget-byte v4, v4, v5

    const/4 v5, 0x6

    invoke-virtual {v2, v3, v7, v4, v5}, Ldm/Ms;->selectS([BIII)V

    .line 5141
    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v7

    aget-byte v2, v2, v7

    iput-byte v2, p0, Lmain/GameRun;->lastSkill:B

    goto/16 :goto_0

    .line 5142
    :cond_13
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_S1_Num5()Z

    move-result v2

    if-eqz v2, :cond_17

    .line 5143
    iget-object v2, p0, Lmain/GameRun;->skill_list:[B

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v7

    aget-byte v3, v3, v7

    aget-byte v2, v2, v3

    const/16 v3, 0x1e

    if-le v2, v3, :cond_14

    const-string v2, "\u88ab\u52a8\u6280\u80fd\u65e0\u6cd5\u4f7f\u7528!"

    invoke-virtual {p0, v2, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 5144
    :cond_14
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-byte v2, v2, Ldm/Monster;->effect:B

    const/4 v3, 0x6

    if-ne v2, v3, :cond_15

    iget-object v2, p0, Lmain/GameRun;->skill_list:[B

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v7

    aget-byte v3, v3, v7

    aget-byte v2, v2, v3

    invoke-direct {p0, v2}, Lmain/GameRun;->getSkillLevel(I)I

    move-result v2

    const/4 v3, 0x3

    if-le v2, v3, :cond_15

    .line 5145
    const-string v2, "\u5c01\u95ed\u6548\u679c\uff0c\u4e0d\u80fd\u4f7f\u75284\u7ea7\u4ee5\u4e0a\u6280\u80fd"

    invoke-virtual {p0, v2, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 5146
    :cond_15
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v5

    .line 5147
    iget-object v3, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v3}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun;->skill_list:[B

    iget-object v5, p0, Lmain/GameRun;->select:[[B

    aget-object v5, v5, v7

    aget-byte v5, v5, v7

    aget-byte v4, v4, v5

    invoke-direct {p0, v3, v4}, Lmain/GameRun;->getSkillMana(Ldm/Monster;I)I

    move-result v3

    if-lt v2, v3, :cond_16

    .line 5148
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v7

    aget-byte v4, v4, v7

    aget-byte v3, v3, v4

    iput-byte v3, v2, Ldm/Battle;->skill:B

    .line 5149
    const/16 v2, 0x9

    iput-byte v2, p0, Lmain/GameRun;->battle_state:B

    goto/16 :goto_0

    .line 5150
    :cond_16
    const-string v2, "\u9700\u8981\u7684\u6280\u80fd\u503c\u4e0d\u591f\uff01"

    invoke-virtual {p0, v2, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 5152
    :cond_17
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_S2()Z

    move-result v2

    if-eqz v2, :cond_0

    iput-byte v4, p0, Lmain/GameRun;->battle_state:B

    goto/16 :goto_0

    .line 5155
    :pswitch_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Up_Down()Z

    move-result v2

    if-eqz v2, :cond_18

    .line 5156
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v7

    const/4 v4, 0x6

    iget-object v5, p0, Lmain/GameRun;->skill_list:[B

    const/16 v6, 0x8

    aget-byte v5, v5, v6

    invoke-virtual {v2, v3, v7, v4, v5}, Ldm/Ms;->selectS([BIII)V

    goto/16 :goto_0

    .line 5157
    :cond_18
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_S1_Num5()Z

    move-result v2

    if-nez v2, :cond_0

    .line 5159
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_S2()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 5160
    iput-byte v4, p0, Lmain/GameRun;->battle_state:B

    goto/16 :goto_0

    .line 5164
    :pswitch_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Up_Down()Z

    move-result v2

    if-eqz v2, :cond_19

    .line 5165
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v7

    const/4 v4, 0x6

    iget-object v5, p0, Lmain/GameRun;->skill_list:[B

    const/16 v6, 0x8

    aget-byte v5, v5, v6

    invoke-virtual {v2, v3, v7, v4, v5}, Ldm/Ms;->selectS([BIII)V

    goto/16 :goto_0

    .line 5166
    :cond_19
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_S1_Num5()Z

    move-result v2

    if-nez v2, :cond_0

    .line 5168
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_S2()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 5169
    iput-byte v4, p0, Lmain/GameRun;->battle_state:B

    goto/16 :goto_0

    .line 5077
    nop

    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_2
    .end packed-switch
.end method

.method private keyBuyItem()V
    .locals 8

    .prologue
    const/4 v1, 0x0

    const/4 v7, 0x2

    const/4 v6, -0x1

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 872
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 917
    :cond_0
    :goto_0
    return-void

    .line 873
    :cond_1
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    if-ne v0, v6, :cond_a

    .line 874
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-byte v0, p0, Lmain/GameRun;->cur_b:B

    if-eqz v0, :cond_2

    .line 875
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->cur_a:B

    invoke-virtual {v0, v1, v4, v7}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lmain/GameRun;->cur_a:B

    .line 876
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aput-byte v4, v1, v4

    aput-byte v4, v0, v5

    goto :goto_0

    .line 877
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 878
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    iget-byte v2, p0, Lmain/GameRun;->cur_b:B

    if-ne v2, v5, :cond_3

    iget-object v2, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v3, p0, Lmain/GameRun;->cur_a:B

    aget-byte v2, v2, v3

    :goto_1
    iget-byte v3, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v0, v1, v4, v2, v3}, Ldm/Ms;->selectS([BIII)V

    goto :goto_0

    :cond_3
    iget-object v2, p0, Lmain/GameRun;->buyItem:[[B

    iget-byte v3, p0, Lmain/GameRun;->cur_a:B

    aget-object v2, v2, v3

    array-length v2, v2

    goto :goto_1

    .line 879
    :cond_4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 880
    iput-byte v5, p0, Lmain/GameRun;->popMenu:B

    .line 881
    iget-byte v0, p0, Lmain/GameRun;->cur_a:B

    iget-byte v1, p0, Lmain/GameRun;->cur_b:B

    if-eq v1, v5, :cond_5

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aget-byte v1, v1, v4

    :goto_2
    iget-byte v2, p0, Lmain/GameRun;->cur_b:B

    if-eq v2, v5, :cond_6

    move v2, v5

    :goto_3
    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->getPrice(IIZ)S

    move-result v0

    iput v0, p0, Lmain/GameRun;->sell_money:I

    .line 882
    iget-byte v0, p0, Lmain/GameRun;->cur_a:B

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aget-byte v1, v1, v4

    iget-byte v2, p0, Lmain/GameRun;->cur_b:B

    if-eq v2, v5, :cond_7

    move v2, v5

    :goto_4
    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->getBuyItemCount(IIZ)I

    move-result v0

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->t_length:B

    goto/16 :goto_0

    .line 881
    :cond_5
    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-object v1, v1, v2

    aget-byte v1, v1, v4

    goto :goto_2

    :cond_6
    move v2, v4

    goto :goto_3

    :cond_7
    move v2, v4

    .line 882
    goto :goto_4

    .line 884
    :cond_8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 885
    iput-object v1, p0, Lmain/GameRun;->buyItem:[[B

    .line 886
    iput-object v1, p0, Lmain/GameRun;->buyPrice:[[S

    .line 888
    iget-byte v0, p0, Lmain/GameRun;->view_state:B

    if-ne v0, v6, :cond_9

    .line 889
    invoke-direct {p0}, Lmain/GameRun;->goBattleState()V

    goto/16 :goto_0

    .line 892
    :cond_9
    invoke-direct {p0}, Lmain/GameRun;->goGO_RUNINMAP()V

    goto/16 :goto_0

    .line 895
    :cond_a
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-nez v0, :cond_b

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_b

    .line 896
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    iget-byte v2, p0, Lmain/GameRun;->t_length:B

    invoke-virtual {v0, v1, v5, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    .line 897
    :cond_b
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_12

    .line 898
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-ne v0, v5, :cond_11

    .line 899
    iget-byte v0, p0, Lmain/GameRun;->cur_b:B

    if-ne v0, v5, :cond_f

    .line 900
    iget v0, p0, Lmain/GameRun;->money:I

    iget v1, p0, Lmain/GameRun;->sell_money:I

    iget-byte v2, p0, Lmain/GameRun;->popMenu:B

    mul-int/2addr v1, v2

    add-int/2addr v0, v1

    iput v0, p0, Lmain/GameRun;->money:I

    .line 901
    iget-object v0, p0, Lmain/GameRun;->items:[[[B

    iget-byte v1, p0, Lmain/GameRun;->cur_a:B

    aget-object v0, v0, v1

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aget-byte v1, v1, v4

    aget-object v0, v0, v1

    aget-byte v0, v0, v4

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0, v1}, Lmain/GameRun;->deleteItems(II)V

    .line 902
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    aget-byte v0, v0, v4

    iget-object v1, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    aget-byte v1, v1, v2

    if-lt v0, v1, :cond_d

    .line 903
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    aget-byte v1, v0, v4

    sub-int/2addr v1, v5

    int-to-byte v1, v1

    aput-byte v1, v0, v4

    if-gez v1, :cond_c

    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    aput-byte v4, v0, v4

    .line 904
    :cond_c
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    aget-byte v1, v0, v5

    sub-int/2addr v1, v5

    int-to-byte v1, v1

    aput-byte v1, v0, v5

    if-gez v1, :cond_d

    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    aput-byte v4, v0, v5

    .line 906
    :cond_d
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\u83b7\u5f97\u91d1\u94b1\uff1a"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Lmain/GameRun;->sell_money:I

    iget-byte v2, p0, Lmain/GameRun;->popMenu:B

    mul-int/2addr v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 910
    :cond_e
    :goto_5
    iput-byte v4, p0, Lmain/GameRun;->buyOk:B

    .line 911
    iput-byte v6, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    .line 907
    :cond_f
    iget-byte v0, p0, Lmain/GameRun;->cur_a:B

    iget-object v1, p0, Lmain/GameRun;->buyItem:[[B

    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-byte v1, v1, v2

    iget-byte v2, p0, Lmain/GameRun;->popMenu:B

    iget-byte v3, p0, Lmain/GameRun;->cur_a:B

    if-eq v3, v7, :cond_10

    move v3, v5

    :goto_6
    invoke-virtual {p0, v0, v1, v2, v3}, Lmain/GameRun;->isMoneyItem(IIIZ)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 908
    iget-object v0, p0, Lmain/GameRun;->buyItem:[[B

    iget-byte v1, p0, Lmain/GameRun;->cur_a:B

    aget-object v0, v0, v1

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aget-byte v1, v1, v4

    aget-byte v0, v0, v1

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0, v1}, Lmain/GameRun;->addItem(II)B

    move-result v0

    if-eq v0, v6, :cond_e

    const-string v0, "\u8d2d\u4e70\u6210\u529f"

    invoke-virtual {p0, v0, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_5

    :cond_10
    move v3, v4

    .line 907
    goto :goto_6

    .line 912
    :cond_11
    iput-byte v5, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_0

    .line 913
    :cond_12
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 914
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-nez v0, :cond_13

    iput-byte v6, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    .line 915
    :cond_13
    iput-byte v4, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_0
.end method

.method private keyEvolveUI()V
    .locals 11

    .prologue
    const/4 v10, -0x1

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 2503
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    invoke-virtual {v4}, Ldm/Ms;->key_S1_Num5()Z

    move-result v4

    if-eqz v4, :cond_7

    iget-byte v4, p0, Lmain/GameRun;->b_c:B

    if-nez v4, :cond_7

    .line 2504
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v5, p0, Lmain/GameRun;->selecty:B

    aget-object v4, v4, v5

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x4

    aget-byte v2, v4, v5

    .line 2505
    .local v2, "kind":B
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v5, p0, Lmain/GameRun;->selecty:B

    aget-object v4, v4, v5

    iget-object v4, v4, Ldm/Monster;->monster:[B

    const/4 v5, 0x2

    aget-byte v3, v4, v5

    .line 2506
    .local v3, "level":B
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v5, p0, Lmain/GameRun;->selecty:B

    aget-object v4, v4, v5

    iget-object v4, v4, Ldm/Monster;->monster:[B

    aget-byte v1, v4, v8

    .line 2507
    .local v1, "id":B
    invoke-direct {p0, v1}, Lmain/GameRun;->isEvolveMake(I)B

    move-result v0

    .line 2508
    .local v0, "dd":B
    invoke-direct {p0, v2, v3}, Lmain/GameRun;->isEvolveKind(BB)B

    move-result v4

    if-eq v4, v10, :cond_0

    invoke-direct {p0, v2, v3}, Lmain/GameRun;->isEvolveKind(BB)B

    move-result v0

    .line 2509
    :cond_0
    if-nez v0, :cond_2

    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v5, p0, Lmain/GameRun;->selecty:B

    aget-object v4, v4, v5

    iget-object v5, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v5, v5, v1

    aget-byte v5, v5, v9

    invoke-virtual {v4, p0, v5, v9}, Ldm/Monster;->evolveMonster(Lmain/GameRun;II)V

    .line 2518
    :goto_0
    if-le v0, v10, :cond_1

    .line 2519
    iput-byte v9, p0, Lmain/GameRun;->b_c:B

    .line 2520
    const/4 v4, 0x6

    invoke-virtual {p0, v4}, Lmain/GameRun;->setMagic(I)V

    .line 2521
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v5, p0, Lmain/GameRun;->selecty:B

    aget-object v4, v4, v5

    invoke-direct {p0, v4}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    .line 2522
    iput-byte v8, p0, Lmain/GameRun;->popMenu:B

    .line 2523
    invoke-direct {p0, v1}, Lmain/GameRun;->delItemEvolve(B)V

    .line 2524
    if-lez v0, :cond_1

    const/16 v4, 0x22

    invoke-virtual {p0, v4, v9}, Lmain/GameRun;->deleteItems(II)V

    .line 2534
    .end local v0    # "dd":B
    .end local v1    # "id":B
    .end local v2    # "kind":B
    .end local v3    # "level":B
    :cond_1
    :goto_1
    return-void

    .line 2510
    .restart local v0    # "dd":B
    .restart local v1    # "id":B
    .restart local v2    # "kind":B
    .restart local v3    # "level":B
    :cond_2
    if-lez v0, :cond_3

    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v5, p0, Lmain/GameRun;->selecty:B

    aget-object v4, v4, v5

    iget-object v5, p0, Lmain/GameRun;->monsterMake:[[B

    aget-object v5, v5, v1

    aget-byte v5, v5, v8

    .line 2511
    iget-object v6, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v7, p0, Lmain/GameRun;->selecty:B

    aget-object v6, v6, v7

    iget-object v6, v6, Ldm/Monster;->monster:[B

    const/4 v7, 0x5

    aget-byte v6, v6, v7

    .line 2510
    invoke-virtual {v4, p0, v5, v6}, Ldm/Monster;->evolveMonster(Lmain/GameRun;II)V

    goto :goto_0

    .line 2512
    :cond_3
    if-ne v0, v10, :cond_4

    .line 2513
    const-string v4, "\u6750\u6599\u4e0d\u8db3\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01"

    invoke-virtual {p0, v4, v8}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2514
    iput-byte v9, p0, Lmain/GameRun;->popMenu:B

    goto :goto_0

    .line 2515
    :cond_4
    const/4 v4, -0x2

    if-ne v0, v4, :cond_5

    const-string v4, "\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523015\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01"

    invoke-virtual {p0, v4, v8}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 2516
    :cond_5
    const/4 v4, -0x3

    if-ne v0, v4, :cond_6

    const-string v4, "\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523025\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01"

    invoke-virtual {p0, v4, v8}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 2517
    :cond_6
    const-string v4, "\u7b49\u7ea7\u6ca1\u6709\u8fbe\u523030\u7ea7\uff0c\u4e0d\u80fd\u8fdb\u5316\uff01"

    invoke-virtual {p0, v4, v8}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 2526
    .end local v0    # "dd":B
    .end local v1    # "id":B
    .end local v2    # "kind":B
    .end local v3    # "level":B
    :cond_7
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    invoke-virtual {v4}, Ldm/Ms;->key_S2()Z

    move-result v4

    if-eqz v4, :cond_8

    .line 2527
    invoke-direct {p0}, Lmain/GameRun;->goView()V

    .line 2528
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v5, p0, Lmain/GameRun;->selecty:B

    aget-object v4, v4, v5

    invoke-direct {p0, v4}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    goto :goto_1

    .line 2529
    :cond_8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    invoke-virtual {v4}, Ldm/Ms;->key_Left_Right()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 2530
    iget-byte v4, p0, Lmain/GameRun;->b_c:B

    if-gtz v4, :cond_1

    .line 2532
    iget-byte v4, p0, Lmain/GameRun;->popMenu:B

    xor-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    iput-byte v4, p0, Lmain/GameRun;->popMenu:B

    goto :goto_1
.end method

.method private keyGetSkill(Ldm/Monster;)V
    .locals 7
    .param p1, "mon"    # Ldm/Monster;

    .prologue
    const/4 v6, 0x3

    const/16 v5, 0x23

    const/16 v4, 0xe

    const/4 v2, -0x1

    const/4 v3, 0x0

    .line 2664
    iget-byte v0, p0, Lmain/GameRun;->getSkill:B

    add-int/lit8 v0, v0, 0x9

    if-lt v0, v5, :cond_0

    iget-object v0, p0, Lmain/GameRun;->makeLevel:[B

    iget-byte v1, p0, Lmain/GameRun;->getSkill:B

    add-int/lit8 v1, v1, 0x9

    sub-int/2addr v1, v5

    aget-byte v0, v0, v1

    iget-object v1, p0, Lmain/GameRun;->rmsOther:[B

    aget-byte v1, v1, v6

    if-le v0, v1, :cond_0

    .line 2665
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\u9700\u8981\u8bad\u7ec3\u5e08"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lmain/GameRun;->makeLevel:[B

    iget-byte v2, p0, Lmain/GameRun;->getSkill:B

    add-int/lit8 v2, v2, 0x9

    sub-int/2addr v2, v5

    aget-byte v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\u7ea7\u624d\u80fd\u5b66\u4e60\uff01"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2684
    :goto_0
    return-void

    .line 2666
    :cond_0
    iget-byte v0, p0, Lmain/GameRun;->getSkill:B

    invoke-virtual {p1, v0}, Ldm/Monster;->isMonReel(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2667
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u5df2\u62e5\u6709\u8be5\u6280\u80fd"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 2669
    :cond_1
    iget-object v0, p1, Ldm/Monster;->monster:[B

    aget-byte v0, v0, v4

    if-eq v0, v2, :cond_2

    .line 2670
    iget-object v0, p1, Ldm/Monster;->monster:[B

    const/16 v1, 0xf

    aget-byte v0, v0, v1

    if-eq v0, v2, :cond_2

    .line 2671
    invoke-virtual {p0, p1}, Lmain/GameRun;->initSkillList(Ldm/Monster;)V

    .line 2674
    iget-object v0, p1, Ldm/Monster;->monster:[B

    aget-byte v0, v0, v6

    iput-byte v0, p0, Lmain/GameRun;->bg_c:B

    .line 2675
    const/4 v0, 0x1

    invoke-direct {p0, v0, v3}, Lmain/GameRun;->restMove(II)V

    .line 2676
    const-string v0, "\u8bf7\u9009\u62e9\u8981\u66ff\u6362\u7684\u6280\u80fd\uff01"

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 2678
    :cond_2
    iget-object v0, p1, Ldm/Monster;->monster:[B

    aget-byte v0, v0, v4

    if-ne v0, v2, :cond_3

    .line 2679
    iget-object v0, p1, Ldm/Monster;->monster:[B

    iget-byte v1, p0, Lmain/GameRun;->getSkill:B

    aput-byte v1, v0, v4

    .line 2681
    :goto_1
    invoke-direct {p0, p1}, Lmain/GameRun;->delItemSkill(Ldm/Monster;)V

    goto :goto_0

    .line 2680
    :cond_3
    iget-object v0, p1, Ldm/Monster;->monster:[B

    const/16 v1, 0xf

    iget-byte v2, p0, Lmain/GameRun;->getSkill:B

    aput-byte v2, v0, v1

    goto :goto_1
.end method

.method private keyMY_BAG()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v3, -0x1

    const/4 v2, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1239
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1283
    :cond_0
    :goto_0
    return-void

    .line 1240
    :cond_1
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    if-ne v0, v3, :cond_9

    .line 1241
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    aget-byte v0, v0, v1

    if-lez v0, :cond_2

    .line 1243
    iget-byte v0, p0, Lmain/GameRun;->selectx:B

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aget-byte v1, v1, v4

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->popBagMenu(II)V

    goto :goto_0

    .line 1245
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1246
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    iget-object v2, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    array-length v2, v2

    sub-int/2addr v2, v5

    invoke-virtual {v0, v1, v4, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lmain/GameRun;->selectx:B

    .line 1247
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    iget-object v1, p0, Lmain/GameRun;->select_st:[B

    iget-byte v2, p0, Lmain/GameRun;->selectx:B

    aget-byte v1, v1, v2

    aput-byte v1, v0, v5

    .line 1248
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    iget-object v1, p0, Lmain/GameRun;->select_it:[B

    iget-byte v2, p0, Lmain/GameRun;->selectx:B

    aget-byte v1, v1, v2

    aput-byte v1, v0, v4

    goto :goto_0

    .line 1250
    :cond_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 1252
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    const/16 v1, 0x9

    if-ne v0, v1, :cond_4

    .line 1253
    const/4 v0, 0x5

    iput-byte v0, p0, Lmain/GameRun;->mini_state:B

    .line 1255
    iget-byte v0, p0, Lmain/GameRun;->select_T:B

    iput-byte v0, p0, Lmain/GameRun;->selecty:B

    .line 1256
    iput-byte v4, p0, Lmain/GameRun;->selecty:B

    .line 1257
    invoke-virtual {p0}, Lmain/GameRun;->goVIEW_MONSTER()V

    goto :goto_0

    .line 1258
    :cond_4
    iget-byte v0, p0, Lmain/GameRun;->view_state:B

    if-ne v0, v3, :cond_5

    .line 1259
    iput-byte v5, p0, Lmain/GameRun;->mini_state:B

    .line 1260
    invoke-direct {p0}, Lmain/GameRun;->goBattleState()V

    .line 1261
    iget-object v0, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v4

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v4

    aget-object v0, v0, v1

    aget-byte v0, v0, v4

    invoke-virtual {p0, v2, v0, v5}, Lmain/GameRun;->initMonStream(III)V

    .line 1262
    iput-object v6, p0, Lmain/GameRun;->itemMine:[[B

    goto/16 :goto_0

    .line 1264
    :cond_5
    iget-byte v0, p0, Lmain/GameRun;->view_state:B

    if-ne v0, v2, :cond_6

    .line 1265
    const/16 v0, -0xa

    sput v0, Lmain/GameRun;->run_state:I

    .line 1266
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->paint()V

    .line 1267
    invoke-virtual {p0, v4}, Lmain/GameRun;->goNidus(I)V

    goto/16 :goto_0

    .line 1270
    :cond_6
    invoke-virtual {p0, v4}, Lmain/GameRun;->doPaint(I)V

    .line 1271
    invoke-virtual {p0, v2}, Lmain/GameRun;->goYouPAUSE(I)V

    .line 1272
    iput-object v6, p0, Lmain/GameRun;->itemMine:[[B

    goto/16 :goto_0

    .line 1275
    :cond_7
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1276
    iget-object v0, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    aget-byte v0, v0, v1

    if-lez v0, :cond_8

    .line 1277
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    iget-object v2, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v3, p0, Lmain/GameRun;->selectx:B

    aget-byte v2, v2, v3

    iget-byte v3, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v0, v1, v4, v2, v3}, Ldm/Ms;->selectS([BIII)V

    .line 1278
    :cond_8
    iget-object v0, p0, Lmain/GameRun;->select_it:[B

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aput-byte v2, v0, v1

    .line 1279
    iget-object v0, p0, Lmain/GameRun;->select_st:[B

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v5

    aput-byte v2, v0, v1

    goto/16 :goto_0

    .line 1282
    :cond_9
    invoke-direct {p0}, Lmain/GameRun;->popBagState()V

    goto/16 :goto_0
.end method

.method private keyMagicUI()V
    .locals 6

    .prologue
    const/16 v5, 0x11

    const/16 v3, 0xe

    const/16 v1, 0xd

    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 2327
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-ne v0, v1, :cond_3

    .line 2328
    iget-object v0, p0, Lmain/GameRun;->skill_list:[B

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aget-byte v1, v1, v4

    aget-byte v0, v0, v1

    const/16 v1, 0x19

    if-gt v0, v1, :cond_1

    const-string v0, "\u8be5\u6280\u80fd\u4e0d\u80fd\u66ff\u6362\uff01"

    invoke-virtual {p0, v0, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2366
    :cond_0
    :goto_0
    return-void

    .line 2330
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->skill_list:[B

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aget-byte v1, v1, v4

    aget-byte v0, v0, v1

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v2, p0, Lmain/GameRun;->selecty:B

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    if-ne v0, v1, :cond_2

    .line 2331
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    iget-byte v1, p0, Lmain/GameRun;->getSkill:B

    aput-byte v1, v0, v3

    .line 2333
    :goto_1
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aget-object v0, v0, v1

    invoke-direct {p0, v0}, Lmain/GameRun;->delItemSkill(Ldm/Monster;)V

    goto :goto_0

    .line 2332
    :cond_2
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/16 v1, 0xf

    iget-byte v2, p0, Lmain/GameRun;->getSkill:B

    aput-byte v2, v0, v1

    goto :goto_1

    .line 2335
    :cond_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 2340
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    iget-byte v1, p0, Lmain/GameRun;->selectx:B

    aput-byte v1, v0, v2

    .line 2341
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aput-byte v1, v0, v4

    .line 2342
    iput-byte v4, p0, Lmain/GameRun;->cur_c:B

    .line 2343
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    goto :goto_0

    .line 2345
    :cond_4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-eq v0, v1, :cond_5

    .line 2346
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    xor-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 2347
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    aput-byte v4, v1, v4

    aput-byte v4, v0, v2

    goto :goto_0

    .line 2348
    :cond_5
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2349
    sget v0, Lmain/Constants_H;->WIDTH_H:I

    iput v0, p0, Lmain/GameRun;->introX:I

    .line 2350
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    if-nez v0, :cond_6

    .line 2356
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v4

    iget-object v2, p0, Lmain/GameRun;->skill_list:[B

    const/16 v3, 0x8

    aget-byte v2, v2, v3

    const/4 v3, 0x5

    invoke-virtual {v0, v1, v4, v2, v3}, Ldm/Ms;->selectS([BIII)V

    goto/16 :goto_0

    .line 2359
    :cond_6
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    const/4 v1, 0x6

    if-ne v0, v1, :cond_7

    .line 2360
    iget-object v0, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    aget-byte v0, v0, v5

    if-lez v0, :cond_0

    .line 2361
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    aget-byte v1, v0, v4

    xor-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    aput-byte v1, v0, v4

    goto/16 :goto_0

    .line 2362
    :cond_7
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monster:[B

    aget-byte v0, v0, v5

    if-lez v0, :cond_0

    .line 2363
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    aget-byte v1, v0, v4

    xor-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    aput-byte v1, v0, v4

    goto/16 :goto_0
.end method

.method private keyNidus()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v2, -0x1

    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v3, -0x2

    .line 1366
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1415
    :cond_0
    :goto_0
    return-void

    .line 1367
    :cond_1
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    const/16 v1, 0x10

    if-ne v0, v1, :cond_7

    .line 1368
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1369
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    array-length v2, v2

    sub-int/2addr v2, v5

    invoke-virtual {v0, v1, v4, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    goto :goto_0

    .line 1370
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 1371
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v2, p0, Lmain/GameRun;->popMenu:B

    aget-object v1, v1, v2

    const-string v2, "\u67e5\u770b\u5b75\u5316"

    invoke-virtual {v0, v1, v2}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 1372
    const/16 v0, 0x11

    iput-byte v0, p0, Lmain/GameRun;->mini_state:B

    .line 1373
    iput-byte v4, p0, Lmain/GameRun;->popMenu:B

    .line 1374
    const/16 v0, 0x38

    invoke-virtual {p0, v4, v0, v5}, Lmain/GameRun;->initMonStream(III)V

    .line 1375
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->getRid(I)B

    move-result v0

    if-ne v0, v3, :cond_3

    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    iput-byte v0, p0, Lmain/GameRun;->bg_c:B

    goto :goto_0

    .line 1377
    :cond_3
    iget-object v0, p0, Lmain/GameRun;->monster_pro:[[B

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNid(I)B

    move-result v1

    aget-object v0, v0, v1

    const/4 v1, 0x6

    aget-byte v0, v0, v1

    iput-byte v0, p0, Lmain/GameRun;->bg_c:B

    .line 1378
    iget-byte v0, p0, Lmain/GameRun;->bg_c:B

    add-int/lit8 v0, v0, 0x17

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->mon_action:B

    goto :goto_0

    .line 1381
    :cond_4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v2, p0, Lmain/GameRun;->popMenu:B

    aget-object v1, v1, v2

    const-string v2, "\u9009\u62e9\u86cb"

    invoke-virtual {v0, v1, v2}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1382
    const/4 v0, 0x2

    iput-byte v0, p0, Lmain/GameRun;->view_state:B

    .line 1383
    invoke-direct {p0, v6}, Lmain/GameRun;->goMY_BAG(I)V

    goto/16 :goto_0

    .line 1384
    :cond_5
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v2, p0, Lmain/GameRun;->popMenu:B

    aget-object v1, v1, v2

    const-string v2, "\u79bb\u5f00"

    invoke-virtual {v0, v1, v2}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lmain/GameRun;->exitNidus()V

    goto/16 :goto_0

    .line 1385
    :cond_6
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lmain/GameRun;->exitNidus()V

    goto/16 :goto_0

    .line 1387
    :cond_7
    iget-byte v0, p0, Lmain/GameRun;->b_c:B

    if-ne v0, v3, :cond_9

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1388
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    const/4 v2, 0x4

    invoke-virtual {v0, v1, v4, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 1389
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->getRid(I)B

    move-result v0

    if-ne v0, v3, :cond_8

    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    iput-byte v0, p0, Lmain/GameRun;->bg_c:B

    goto/16 :goto_0

    .line 1391
    :cond_8
    iget-object v0, p0, Lmain/GameRun;->monster_pro:[[B

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNid(I)B

    move-result v1

    aget-object v0, v0, v1

    const/4 v1, 0x6

    aget-byte v0, v0, v1

    iput-byte v0, p0, Lmain/GameRun;->bg_c:B

    .line 1392
    iget-byte v0, p0, Lmain/GameRun;->bg_c:B

    add-int/lit8 v0, v0, 0x17

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->mon_action:B

    goto/16 :goto_0

    .line 1395
    :cond_9
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_d

    .line 1396
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->getRid(I)B

    move-result v0

    if-eq v0, v3, :cond_0

    .line 1397
    iget-byte v0, p0, Lmain/GameRun;->b_c:B

    if-ne v0, v3, :cond_c

    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0, v5}, Lmain/GameRun;->getNexp(II)S

    move-result v0

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v1, v6}, Lmain/GameRun;->getNexp(II)S

    move-result v1

    if-ne v0, v1, :cond_c

    .line 1399
    iget-byte v0, p0, Lmain/GameRun;->cMon_count:B

    iget-byte v1, p0, Lmain/GameRun;->max_monsters:B

    if-ne v0, v1, :cond_a

    iget-byte v0, p0, Lmain/GameRun;->myMon_length:B

    iget-byte v1, p0, Lmain/GameRun;->max_takes:B

    if-ne v0, v1, :cond_a

    const-string v0, "\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1"

    invoke-virtual {p0, v0, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 1400
    :cond_a
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->getNid(I)B

    move-result v0

    invoke-direct {p0, v0}, Lmain/GameRun;->isEvolveMake(I)B

    move-result v0

    if-nez v0, :cond_b

    .line 1402
    iget-byte v0, p0, Lmain/GameRun;->bg_c:B

    add-int/lit8 v0, v0, 0x1c

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->mon_action:B

    .line 1403
    iput-byte v5, p0, Lmain/GameRun;->b_c:B

    .line 1404
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->getNid(I)B

    move-result v0

    invoke-direct {p0, v0, v5}, Lmain/GameRun;->setNidusPro(II)V

    .line 1405
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->getNid(I)B

    move-result v0

    invoke-direct {p0, v0}, Lmain/GameRun;->delItemEvolve(B)V

    goto/16 :goto_0

    .line 1406
    :cond_b
    const-string v0, "\u6750\u6599\u4e0d\u8db3\uff0c\u4e0d\u80fd\u5b75\u5316"

    invoke-virtual {p0, v0, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 1407
    :cond_c
    iget-byte v0, p0, Lmain/GameRun;->b_c:B

    if-ne v0, v2, :cond_0

    .line 1408
    iput-byte v3, p0, Lmain/GameRun;->b_c:B

    .line 1409
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->getNid(I)B

    move-result v0

    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNLevel(I)B

    move-result v1

    invoke-virtual {p0, v0, v1, v3, v2}, Lmain/GameRun;->getMonster(IIII)B

    .line 1410
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->delNidus(I)V

    .line 1411
    const/16 v0, 0x38

    invoke-virtual {p0, v4, v0, v5}, Lmain/GameRun;->initMonStream(III)V

    goto/16 :goto_0

    .line 1413
    :cond_d
    iget-byte v0, p0, Lmain/GameRun;->b_c:B

    if-ne v0, v3, :cond_0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lmain/GameRun;->exitNidus()V

    goto/16 :goto_0
.end method

.method private key_MONSTER_LIST([Ldm/Monster;)V
    .locals 8
    .param p1, "mon"    # [Ldm/Monster;

    .prologue
    const/4 v7, -0x1

    const/16 v4, 0xf

    const/4 v3, 0x3

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 2595
    iget-byte v1, p0, Lmain/GameRun;->popMenu:B

    if-ne v1, v7, :cond_1a

    .line 2596
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_S1_Num5()Z

    move-result v1

    if-eqz v1, :cond_d

    iget-byte v1, p0, Lmain/GameRun;->t_length:B

    if-eqz v1, :cond_d

    .line 2597
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-ne v1, v6, :cond_a

    .line 2598
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    if-ne v1, v4, :cond_1

    .line 2599
    invoke-direct {p0}, Lmain/GameRun;->useItem()V

    .line 2662
    :cond_0
    :goto_0
    return-void

    .line 2600
    :cond_1
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/16 v2, 0xd

    if-ne v1, v2, :cond_2

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    aget-object v1, p1, v1

    invoke-direct {p0, v1}, Lmain/GameRun;->keyGetSkill(Ldm/Monster;)V

    goto :goto_0

    .line 2602
    :cond_2
    new-instance v0, Ljava/lang/StringBuffer;

    const-string v1, "\u5929\u8d4b#n\u6280\u80fd"

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 2603
    .local v0, "sbuff":Ljava/lang/StringBuffer;
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/4 v2, 0x4

    if-ne v1, v2, :cond_5

    .line 2604
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    aget-object v1, p1, v1

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x5

    aget-byte v1, v1, v2

    if-lez v1, :cond_3

    const-string v1, "#n\u8fdb\u5316"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2605
    :cond_3
    iget-byte v1, p0, Lmain/GameRun;->t_length:B

    if-le v1, v6, :cond_4

    const-string v1, "#n\u5b58\u653e#n\u5356\u5ba0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2614
    :cond_4
    :goto_1
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v1, v2, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2615
    const/4 v0, 0x0

    .line 2616
    iput-byte v5, p0, Lmain/GameRun;->popMenu:B

    goto :goto_0

    .line 2606
    :cond_5
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/4 v2, 0x6

    if-ne v1, v2, :cond_7

    .line 2607
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-boolean v1, v1, Lmain/Map;->gmErr:Z

    if-nez v1, :cond_6

    const-string v1, "#n\u53d6\u51fa#n\u5356\u5ba0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 2608
    :cond_6
    const-string v1, "#n\u5356\u5ba0"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 2610
    :cond_7
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    if-eqz v1, :cond_8

    const-string v1, "#n\u53c2\u6218"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2611
    :cond_8
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    aget-object v1, p1, v1

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x5

    aget-byte v1, v1, v2

    if-lez v1, :cond_9

    const-string v1, "#n\u8fdb\u5316"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2612
    :cond_9
    iget-byte v1, p0, Lmain/GameRun;->t_length:B

    if-le v1, v6, :cond_4

    const-string v1, "#n\u653e\u751f"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 2618
    .end local v0    # "sbuff":Ljava/lang/StringBuffer;
    :cond_a
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-gez v1, :cond_0

    .line 2619
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    if-ne v1, v4, :cond_b

    invoke-direct {p0}, Lmain/GameRun;->useItem()V

    goto/16 :goto_0

    .line 2621
    :cond_b
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    if-eqz v1, :cond_c

    const-string v1, "\u53c2\u6218#n\u6280\u80fd"

    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v1, v2, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2623
    :goto_2
    iput-byte v5, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    .line 2622
    :cond_c
    const-string v1, "\u6280\u80fd"

    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v1, v2, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    goto :goto_2

    .line 2626
    :cond_d
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_S2()Z

    move-result v1

    if-eqz v1, :cond_19

    .line 2628
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/16 v2, 0xd

    if-ne v1, v2, :cond_e

    .line 2629
    const/4 v1, 0x2

    invoke-direct {p0, v1}, Lmain/GameRun;->goMY_BAG(I)V

    goto/16 :goto_0

    .line 2630
    :cond_e
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-ne v1, v6, :cond_14

    .line 2631
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    if-ne v1, v4, :cond_f

    .line 2632
    invoke-direct {p0, v5}, Lmain/GameRun;->goMY_BAG(I)V

    .line 2633
    iput-byte v3, p0, Lmain/GameRun;->mini_state:B

    goto/16 :goto_0

    .line 2634
    :cond_f
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/4 v2, 0x6

    if-eq v1, v2, :cond_10

    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/4 v2, 0x4

    if-ne v1, v2, :cond_13

    .line 2635
    :cond_10
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-boolean v1, v1, Lmain/Map;->gmErr:Z

    if-nez v1, :cond_12

    .line 2636
    invoke-virtual {p0, v5}, Lmain/GameRun;->doPaint(I)V

    .line 2637
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/4 v2, 0x6

    if-ne v1, v2, :cond_11

    move v1, v6

    :goto_3
    invoke-virtual {p0, v1}, Lmain/GameRun;->goVIEW_COMPUTER(I)V

    goto/16 :goto_0

    :cond_11
    move v1, v5

    goto :goto_3

    .line 2638
    :cond_12
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v1}, Lmain/Map;->bkEvent_getMon()V

    goto/16 :goto_0

    .line 2640
    :cond_13
    invoke-virtual {p0, v5}, Lmain/GameRun;->doPaint(I)V

    .line 2641
    invoke-virtual {p0, v6}, Lmain/GameRun;->goYouPAUSE(I)V

    goto/16 :goto_0

    .line 2643
    :cond_14
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    const/4 v2, -0x2

    if-ne v1, v2, :cond_17

    .line 2644
    aget-object v1, p1, v5

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v5

    if-lez v1, :cond_16

    .line 2645
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    if-eqz v1, :cond_15

    const/4 v1, 0x2

    iget-object v2, p0, Lmain/GameRun;->mList_id:[[B

    aget-object v3, p1, v5

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    aget-byte v2, v2, v5

    invoke-virtual {p0, v1, v2, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 2646
    :cond_15
    invoke-direct {p0}, Lmain/GameRun;->goBattleState()V

    .line 2649
    :goto_4
    iput-byte v7, p0, Lmain/GameRun;->view_state:B

    goto/16 :goto_0

    .line 2648
    :cond_16
    const-string v1, "\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218"

    invoke-virtual {p0, v1, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_4

    .line 2650
    :cond_17
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-ne v1, v7, :cond_0

    .line 2651
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    if-ne v1, v4, :cond_18

    .line 2652
    invoke-direct {p0, v5}, Lmain/GameRun;->goMY_BAG(I)V

    goto/16 :goto_0

    .line 2653
    :cond_18
    const-string v1, "\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218"

    invoke-virtual {p0, v1, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 2655
    :cond_19
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_Up_Down()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-byte v1, p0, Lmain/GameRun;->t_length:B

    if-eqz v1, :cond_0

    .line 2656
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    iget-byte v3, p0, Lmain/GameRun;->t_length:B

    iget-byte v4, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v1, v2, v5, v3, v4}, Ldm/Ms;->selectS([BIII)V

    .line 2657
    const/4 v1, 0x2

    iget-object v2, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v3, p1, v3

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    aget-byte v2, v2, v5

    invoke-virtual {p0, v1, v2, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 2658
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    aget-object v1, p1, v1

    invoke-direct {p0, v1}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    .line 2659
    sget v1, Lmain/Constants_H;->WIDTH_H:I

    iput v1, p0, Lmain/GameRun;->introT:I

    goto/16 :goto_0

    .line 2661
    :cond_1a
    invoke-virtual {p0}, Lmain/GameRun;->popState()V

    goto/16 :goto_0
.end method

.method private level_up(II)Z
    .locals 11
    .param p1, "no"    # I
    .param p2, "mode"    # I

    .prologue
    const/4 v10, -0x1

    const/4 v9, 0x2

    const/4 v6, 0x0

    const/4 v8, 0x4

    const/4 v7, 0x1

    .line 3338
    if-nez p2, :cond_8

    .line 3340
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v9

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v5, Ldm/Ms;->skip2:I

    sub-int/2addr v4, v5

    int-to-byte v0, v4

    .line 3341
    .local v0, "LevelCha":B
    const/4 v1, 0x0

    .line 3342
    .local v1, "buff":S
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-short v4, p0, Lmain/GameRun;->exp:S

    sput v4, Ldm/Ms;->skip:I

    .line 3343
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    const/16 v5, 0x24

    invoke-virtual {v4, v5}, Ldm/Monster;->isMonReel(I)Z

    move-result v4

    if-eqz v4, :cond_0

    add-int/lit8 v4, v1, 0x64

    int-to-short v1, v4

    .line 3344
    :cond_0
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    const/16 v5, 0x25

    invoke-virtual {v4, v5}, Ldm/Monster;->isMonReel(I)Z

    move-result v4

    if-eqz v4, :cond_1

    add-int/lit16 v4, v1, 0xc8

    int-to-short v1, v4

    .line 3346
    :cond_1
    if-gez v0, :cond_7

    const/4 v0, 0x0

    .line 3351
    :cond_2
    :goto_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v4, Ldm/Ms;->skip:I

    const/16 v5, 0x9

    mul-int/lit8 v6, v0, 0x2

    sub-int/2addr v5, v6

    mul-int/2addr v4, v5

    add-int/lit8 v5, v1, 0x64

    mul-int/2addr v4, v5

    div-int/lit16 v4, v4, 0x3e8

    int-to-short v4, v4

    sput v4, Ldm/Ms;->skip:I

    .line 3355
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v4, Ldm/Ms;->skip:I

    if-ge v4, v7, :cond_3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v4, 0x6

    invoke-static {v4}, Ldm/Ms;->getRandom(I)I

    move-result v4

    add-int/lit8 v4, v4, 0x5

    sput v4, Ldm/Ms;->skip:I

    .line 3356
    :cond_3
    iget-byte v4, p0, Lmain/GameRun;->battle_type:B

    const/4 v5, 0x3

    if-eq v4, v5, :cond_4

    iget-byte v4, p0, Lmain/GameRun;->battle_type:B

    if-nez v4, :cond_5

    .line 3357
    :cond_4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v4, Ldm/Ms;->skip:I

    mul-int/lit8 v4, v4, 0x3

    div-int/lit8 v4, v4, 0x2

    int-to-short v4, v4

    sput v4, Ldm/Ms;->skip:I

    .line 3360
    :cond_5
    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, p1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v5, Ldm/Ms;->skip:I

    int-to-short v5, v5

    aput-short v5, v4, v9

    .end local v0    # "LevelCha":B
    .end local v1    # "buff":S
    :cond_6
    :goto_1
    move v4, v7

    .line 3393
    :goto_2
    return v4

    .line 3347
    .restart local v0    # "LevelCha":B
    .restart local v1    # "buff":S
    :cond_7
    if-le v0, v8, :cond_2

    const/4 v0, 0x5

    goto :goto_0

    .line 3365
    .end local v0    # "LevelCha":B
    .end local v1    # "buff":S
    :cond_8
    if-ne p2, v7, :cond_b

    .line 3366
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v9

    const/16 v5, 0x3c

    if-ge v4, v5, :cond_a

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v4, Ldm/Ms;->skip:I

    if-lez v4, :cond_a

    .line 3367
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    invoke-direct {p0, v4}, Lmain/GameRun;->getMonsterExp(Ldm/Monster;)S

    move-result v3

    .line 3368
    .local v3, "tempLevelExp":S
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aget-short v4, v4, v8

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v5, Ldm/Ms;->skip:I

    add-int/2addr v4, v5

    int-to-short v2, v4

    .line 3369
    .local v2, "expt":S
    if-lt v2, v3, :cond_9

    .line 3371
    iget-object v4, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monsterPro:[S

    aget-short v5, v5, v8

    iput-short v5, v4, Ldm/Battle;->cexp:S

    .line 3372
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aput-short v3, v4, v8

    .line 3373
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sub-int v4, v2, v3

    int-to-short v4, v4

    sput v4, Ldm/Ms;->skip:I

    goto :goto_1

    .line 3375
    :cond_9
    iget-object v4, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monsterPro:[S

    aget-short v5, v5, v8

    iput-short v5, v4, Ldm/Battle;->cexp:S

    .line 3376
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aget-short v5, v4, v8

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v6, Ldm/Ms;->skip:I

    add-int/2addr v5, v6

    int-to-short v5, v5

    aput-short v5, v4, v8

    .line 3377
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v10, Ldm/Ms;->skip:I

    goto :goto_1

    .line 3380
    .end local v2    # "expt":S
    .end local v3    # "tempLevelExp":S
    :cond_a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v10, Ldm/Ms;->skip:I

    .line 3381
    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, p1

    aput-short v6, v4, v9

    goto :goto_1

    .line 3384
    :cond_b
    if-ne p2, v9, :cond_6

    .line 3385
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v4, Ldm/Ms;->skip:I

    if-le v4, v10, :cond_c

    .line 3386
    invoke-virtual {p0, p1, v6}, Lmain/GameRun;->levelPro(IZ)V

    .line 3387
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    invoke-virtual {p0, v4}, Lmain/GameRun;->getMagic(Ldm/Monster;)V

    .line 3388
    iget-object v4, p0, Lmain/GameRun;->levelUp_in_battle:[[B

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monster:[B

    aget-byte v5, v5, v7

    aget-object v4, v4, v5

    aput-byte v7, v4, v6

    .line 3389
    iget-object v4, p0, Lmain/GameRun;->levelUp_in_battle:[[B

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monster:[B

    aget-byte v5, v5, v7

    aget-object v4, v4, v5

    iget-byte v5, p0, Lmain/GameRun;->getSkill:B

    aput-byte v5, v4, v7

    .line 3390
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aput-short v6, v4, v8

    goto/16 :goto_1

    :cond_c
    move v4, v6

    .line 3391
    goto/16 :goto_2
.end method

.method private loadGame()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 3305
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iput-byte v1, v0, Lmain/Map;->firstDrawMap:B

    .line 3306
    iput-byte v1, p0, Lmain/GameRun;->buyOk:B

    .line 3307
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    const/4 v1, 0x0

    iput-object v1, v0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    .line 3308
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "loadGame 111111111111"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 3309
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->goGameLoading()V

    .line 3310
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "loadGame 22222222222"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 3311
    return-void
.end method

.method private magicEffectRate(Ldm/Battle;Ldm/Monster;Ldm/Monster;I)Z
    .locals 9
    .param p1, "dmB"    # Ldm/Battle;
    .param p2, "am"    # Ldm/Monster;
    .param p3, "dm"    # Ldm/Monster;
    .param p4, "skill_no"    # I

    .prologue
    const/4 v8, 0x7

    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x4

    const/4 v4, 0x5

    .line 619
    iget-byte v2, p3, Ldm/Monster;->effect:B

    if-eq v2, v8, :cond_0

    move v2, v6

    .line 651
    :goto_0
    return v2

    .line 620
    :cond_0
    iget-object v2, p0, Lmain/GameRun;->skill:[[B

    aget-object v2, v2, p4

    const/4 v3, 0x3

    aget-byte v1, v2, v3

    .local v1, "buff":B
    iget-object v2, p0, Lmain/GameRun;->skill:[[B

    aget-object v2, v2, p4

    aget-byte v0, v2, v7

    .line 621
    .local v0, "DebuffRate":B
    if-nez v0, :cond_1

    move v2, v6

    goto :goto_0

    .line 622
    :cond_1
    if-nez v1, :cond_7

    .line 623
    invoke-virtual {p3, v4}, Ldm/Monster;->isBuffRate(I)Z

    move-result v2

    if-eqz v2, :cond_6

    iget-object v2, p0, Lmain/GameRun;->inhesion:[B

    aget-byte v2, v2, v4

    add-int/2addr v2, v0

    int-to-byte v0, v2

    .line 633
    :cond_2
    :goto_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v2, 0x64

    invoke-static {v2}, Ldm/Ms;->getRandom(I)I

    move-result v2

    if-ge v2, v0, :cond_12

    .line 634
    iput-byte v1, p3, Ldm/Monster;->effect:B

    .line 637
    const/4 v2, 0x3

    if-eq v1, v2, :cond_3

    if-eq v1, v5, :cond_3

    if-ne v1, v4, :cond_c

    :cond_3
    iput-byte v5, p3, Ldm/Monster;->effect_time:B

    .line 648
    :cond_4
    :goto_2
    if-ne v1, v4, :cond_5

    const/16 v2, 0x1f

    invoke-virtual {p2, v2}, Ldm/Monster;->isMonReel(I)Z

    move-result v2

    if-eqz v2, :cond_11

    iget-object v2, p0, Lmain/GameRun;->skill:[[B

    const/16 v3, 0x1f

    aget-object v2, v2, v3

    aget-byte v2, v2, v6

    :goto_3
    add-int/2addr v2, p4

    int-to-byte v2, v2

    iput-byte v2, p1, Ldm/Battle;->fs_level:B

    .line 649
    :cond_5
    const/4 v2, 0x1

    goto :goto_0

    .line 624
    :cond_6
    const/4 v2, 0x6

    invoke-virtual {p3, v2}, Ldm/Monster;->isBuffRate(I)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lmain/GameRun;->inhesion:[B

    const/4 v3, 0x6

    aget-byte v2, v2, v3

    add-int/2addr v2, v0

    int-to-byte v0, v2

    goto :goto_1

    .line 625
    :cond_7
    if-ne v1, v5, :cond_9

    .line 626
    invoke-virtual {p3, v8}, Ldm/Monster;->isBuffRate(I)Z

    move-result v2

    if-eqz v2, :cond_8

    iget-object v2, p0, Lmain/GameRun;->inhesion:[B

    aget-byte v2, v2, v8

    add-int/2addr v2, v0

    int-to-byte v0, v2

    goto :goto_1

    .line 627
    :cond_8
    const/16 v2, 0x8

    invoke-virtual {p3, v2}, Ldm/Monster;->isBuffRate(I)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lmain/GameRun;->inhesion:[B

    const/16 v3, 0x8

    aget-byte v2, v2, v3

    add-int/2addr v2, v0

    int-to-byte v0, v2

    goto :goto_1

    .line 628
    :cond_9
    if-eq v1, v7, :cond_a

    if-ne v1, v4, :cond_2

    .line 629
    :cond_a
    const/16 v2, 0xb

    invoke-virtual {p3, v2}, Ldm/Monster;->isBuffRate(I)Z

    move-result v2

    if-eqz v2, :cond_b

    iget-object v2, p0, Lmain/GameRun;->inhesion:[B

    const/16 v3, 0xb

    aget-byte v2, v2, v3

    add-int/2addr v2, v0

    int-to-byte v0, v2

    goto :goto_1

    .line 630
    :cond_b
    const/16 v2, 0xc

    invoke-virtual {p3, v2}, Ldm/Monster;->isBuffRate(I)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lmain/GameRun;->inhesion:[B

    const/16 v3, 0xc

    aget-byte v2, v2, v3

    add-int/2addr v2, v0

    int-to-byte v0, v2

    goto/16 :goto_1

    .line 638
    :cond_c
    if-ne v1, v7, :cond_e

    const/16 v2, 0x20

    invoke-virtual {p2, v2}, Ldm/Monster;->isMonReel(I)Z

    move-result v2

    if-eqz v2, :cond_d

    move v2, v4

    :goto_4
    int-to-byte v2, v2

    iput-byte v2, p3, Ldm/Monster;->effect_time:B

    goto :goto_2

    :cond_d
    move v2, v5

    goto :goto_4

    .line 639
    :cond_e
    if-nez v1, :cond_f

    iput-byte v7, p3, Ldm/Monster;->effect_time:B

    goto/16 :goto_2

    .line 641
    :cond_f
    const/4 v2, 0x6

    if-ne v1, v2, :cond_4

    .line 642
    iget-object v2, p3, Ldm/Monster;->monster:[B

    const/4 v3, 0x3

    aget-byte v2, v2, v3

    const/4 v3, -0x1

    if-ne v2, v3, :cond_10

    .line 643
    iput-byte v8, p3, Ldm/Monster;->effect:B

    .line 644
    const-string v2, "\u5c01\u95ed\u6548\u679c\uff0c\u5bf9\u5e7d\u6697\u9b3c\u738b\u4e0d\u8d77\u4f5c\u7528"

    const/4 v3, -0x1

    invoke-virtual {p0, v2, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_2

    .line 646
    :cond_10
    iput-byte v5, p3, Ldm/Monster;->effect_time:B

    goto/16 :goto_2

    .line 648
    :cond_11
    const/4 v2, 0x1

    goto/16 :goto_3

    :cond_12
    move v2, v6

    .line 651
    goto/16 :goto_0
.end method

.method private monsterRemove(I)B
    .locals 5
    .param p1, "no"    # I

    .prologue
    const/4 v4, 0x1

    .line 3468
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    if-le v1, v4, :cond_2

    .line 3472
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    const/4 v2, 0x0

    aput-object v2, v1, p1

    .line 3474
    int-to-byte v0, p1

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    sub-int/2addr v1, v4

    if-lt v0, v1, :cond_0

    .line 3478
    iget-byte v0, p0, Lmain/GameRun;->myMon_length:B

    :goto_1
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    array-length v1, v1

    if-lt v0, v1, :cond_1

    .line 3481
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    sub-int/2addr v1, v4

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/GameRun;->myMon_length:B

    move v1, v4

    .line 3484
    .end local v0    # "i":B
    :goto_2
    return v1

    .line 3475
    .restart local v0    # "i":B
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    add-int/lit8 v3, v0, 0x1

    aget-object v2, v2, v3

    aput-object v2, v1, v0

    .line 3476
    iget-object v1, p0, Lmain/GameRun;->evolve:[Z

    iget-object v2, p0, Lmain/GameRun;->evolve:[Z

    add-int/lit8 v3, v0, 0x1

    aget-boolean v2, v2, v3

    aput-boolean v2, v1, v0

    .line 3474
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0

    .line 3479
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->evolve:[Z

    aput-boolean v4, v1, v0

    .line 3478
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_1

    .line 3484
    .end local v0    # "i":B
    :cond_2
    const/4 v1, -0x1

    goto :goto_2
.end method

.method private mpAdd(I)V
    .locals 6
    .param p1, "hp"    # I

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 3690
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v4

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v5

    if-ge v0, v1, :cond_0

    .line 3691
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->select_T:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    if-lez v0, :cond_0

    .line 3692
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v5

    mul-int/2addr v0, p1

    div-int/lit8 p1, v0, 0x64

    .line 3693
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    invoke-direct {p0, p1, v0}, Lmain/GameRun;->AddMP(ILdm/Monster;)V

    .line 3694
    iget-object v0, p0, Lmain/GameRun;->select_it:[B

    aget-byte v0, v0, v3

    invoke-direct {p0, v3, v0}, Lmain/GameRun;->useState(II)V

    .line 3705
    :goto_0
    return-void

    .line 3697
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v4

    if-ge v0, v4, :cond_1

    .line 3699
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u5df2\u7ecf\u6b7b\u4ea1\uff0c\u65e0\u6cd5\u4f7f\u7528\uff01"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 3704
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u4e0d\u9700\u8981\u4f7f\u7528\u8fd9\u4e2a\u9053\u5177"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private paintBATTLE_OVER()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 3446
    iget-byte v0, p0, Lmain/GameRun;->b_c:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->now_id:B

    invoke-virtual {p0, v2, v0, v2}, Lmain/GameRun;->drawEvolveUI(IIZ)V

    .line 3447
    :cond_0
    return-void
.end method

.method private paintBattleState(Ljavax/microedition/lcdui/Graphics;)V
    .locals 10
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 4685
    const/16 v9, 0x140

    .line 4687
    .local v9, "WIDTH_H":I
    iget-byte v0, p0, Lmain/GameRun;->battle_state:B

    packed-switch v0, :pswitch_data_0

    .line 4778
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 4689
    :pswitch_1
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->drawAnimationBattle(Ldm/Battle;I)V

    goto :goto_0

    .line 4715
    :pswitch_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0x96

    sub-int v1, v9, v1

    const/16 v2, 0x32

    const/16 v3, 0x12c

    const/16 v4, 0xc1

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK0(IIIII)V

    .line 4716
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v1, v9, 0x7d

    const/16 v2, 0x3c

    const/16 v3, 0xad

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    iget-object v5, p0, Lmain/GameRun;->skill_list:[B

    const/16 v6, 0x8

    aget-byte v5, v5, v6

    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->sliding(IIIIIZ)V

    .line 4717
    const/16 v0, 0x96

    sub-int v0, v9, v0

    add-int/lit8 v1, v0, 0xa

    const/16 v2, 0x3c

    const/16 v3, 0xfa

    const/16 v4, 0x1c

    const/4 v5, 0x6

    iget-object v0, p0, Lmain/GameRun;->select:[[B

    const/4 v6, 0x0

    aget-object v6, v0, v6

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Lmain/GameRun;->drawSkillList(IIIII[B)V

    .line 4726
    iget-object v0, p0, Lmain/GameRun;->skill_help:[Ljava/lang/StringBuffer;

    iget-object v1, p0, Lmain/GameRun;->skill_list:[B

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    const/4 v3, 0x0

    aget-object v2, v2, v3

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    aget-byte v1, v1, v2

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    const/16 v3, 0x10d

    const/4 v4, 0x7

    const/4 v5, 0x0

    move-object v0, p0

    move v2, v9

    invoke-virtual/range {v0 .. v5}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 4729
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ldm/Ui;->drawYesNo(ZZ)V

    goto :goto_0

    .line 4740
    :pswitch_3
    iget-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-byte v2, p0, Lmain/GameRun;->mini_state:B

    iget-object v3, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-byte v3, v3, Ldm/Battle;->skill:B

    const/4 v4, 0x1

    invoke-direct {p0, v2, v3, v4}, Lmain/GameRun;->getBXY(IIZ)I

    move-result v2

    const/16 v3, 0xf

    sub-int/2addr v2, v3

    iget-byte v3, p0, Lmain/GameRun;->mini_state:B

    iget-object v4, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-byte v4, v4, Ldm/Battle;->skill:B

    const/4 v5, 0x0

    invoke-direct {p0, v3, v4, v5}, Lmain/GameRun;->getBXY(IIZ)I

    move-result v3

    const/16 v4, 0x22

    sub-int/2addr v3, v4

    invoke-direct {p0, v0, v1, v2, v3}, Lmain/GameRun;->drawHitOne(Ldm/Battle;Ldm/Battle;II)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4741
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iget-byte v2, p0, Lmain/GameRun;->mini_state:B

    xor-int/lit8 v2, v2, 0x1

    const/16 v3, 0x19

    const/4 v4, 0x1

    invoke-direct {p0, v2, v3, v4}, Lmain/GameRun;->getBXY(IIZ)I

    move-result v2

    const/16 v3, 0xf

    sub-int/2addr v2, v3

    iget-byte v3, p0, Lmain/GameRun;->mini_state:B

    xor-int/lit8 v3, v3, 0x1

    const/16 v4, 0x19

    const/4 v5, 0x0

    invoke-direct {p0, v3, v4, v5}, Lmain/GameRun;->getBXY(IIZ)I

    move-result v3

    const/16 v4, 0x22

    sub-int/2addr v3, v4

    invoke-direct {p0, v0, v1, v2, v3}, Lmain/GameRun;->drawHitOne(Ldm/Battle;Ldm/Battle;II)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4742
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iget-byte v2, p0, Lmain/GameRun;->mini_state:B

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->runHitToState(Ldm/Battle;Ldm/Battle;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4743
    const/4 v0, -0x3

    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 4744
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->initHit()V

    .line 4745
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    invoke-direct {p0, v0}, Lmain/GameRun;->doEffectValue(Ldm/Battle;)V

    .line 4746
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    invoke-direct {p0, v0}, Lmain/GameRun;->doBuffValue(Ldm/Battle;)V

    goto/16 :goto_0

    .line 4751
    :pswitch_4
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iget-byte v2, p0, Lmain/GameRun;->mini_state:B

    xor-int/lit8 v2, v2, 0x1

    const/16 v3, 0x19

    const/4 v4, 0x1

    invoke-direct {p0, v2, v3, v4}, Lmain/GameRun;->getBXY(IIZ)I

    move-result v2

    const/16 v3, 0xf

    sub-int/2addr v2, v3

    iget-byte v3, p0, Lmain/GameRun;->mini_state:B

    xor-int/lit8 v3, v3, 0x1

    const/16 v4, 0x19

    const/4 v5, 0x0

    invoke-direct {p0, v3, v4, v5}, Lmain/GameRun;->getBXY(IIZ)I

    move-result v3

    const/16 v4, 0x22

    sub-int/2addr v3, v4

    invoke-direct {p0, v0, v1, v2, v3}, Lmain/GameRun;->drawHitOne(Ldm/Battle;Ldm/Battle;II)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4752
    iget-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-byte v2, p0, Lmain/GameRun;->mini_state:B

    xor-int/lit8 v2, v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->runHitToState(Ldm/Battle;Ldm/Battle;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4753
    const/16 v0, 0x9

    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 4754
    iget-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    invoke-direct {p0, v0}, Lmain/GameRun;->effectR(Ldm/Monster;)V

    goto/16 :goto_0

    .line 4760
    :pswitch_5
    iget-object v0, p0, Lmain/GameRun;->proReplace:[[S

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v1, v1, Ldm/Battle;->now_id:B

    aget-object v0, v0, v1

    const/4 v1, 0x2

    aget-short v0, v0, v1

    const/4 v1, -0x1

    if-le v0, v1, :cond_1

    .line 4761
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->now_id:B

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u83b7\u5f97\u7ecf\u9a8c\uff1a"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 4762
    .local v1, "s":Ljava/lang/String;
    const-string v0, "sk"

    const-string v2, "\u83b7\u5f97\u7ecf\u9a8c"

    invoke-static {v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4763
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v2, 0xcc

    const/16 v3, 0x134

    const/16 v4, 0x24

    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 4765
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lmain/GameRun;->proReplace:[[S

    .end local v1    # "s":Ljava/lang/String;
    iget-object v3, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v3, v3, Ldm/Battle;->now_id:B

    aget-object v1, v1, v3

    const/4 v3, 0x2

    aget-short v1, v1, v3

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0xdc

    const/16 v5, 0x13b

    const/4 v6, 0x0

    const/4 v7, 0x1

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawNum(Ljava/lang/String;IIII)V

    .line 4767
    const/4 v1, 0x0

    .restart local v1    # "s":Ljava/lang/String;
    goto/16 :goto_0

    .line 4768
    .end local v1    # "s":Ljava/lang/String;
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->proReplace:[[S

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v1, v1, Ldm/Battle;->now_id:B

    aget-object v0, v0, v1

    const/4 v1, 0x2

    aget-short v0, v0, v1

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 4770
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const-string v3, "\u60a8\u7684\u5ba0\u7269\u5df2\u7ecf\u65e0\u6cd5\u83b7\u5f97\u7ecf\u9a8c"

    const/16 v4, 0xcc

    const/16 v5, 0x11a

    const/16 v6, 0x24

    const/4 v7, 0x7

    const/4 v8, 0x0

    invoke-virtual/range {v2 .. v8}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 4774
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/16 v1, 0x258

    invoke-virtual {v0, v1}, Ldm/Ms;->sleep(I)V

    goto/16 :goto_0

    .line 4687
    :pswitch_data_0
    .packed-switch -0x5
        :pswitch_5
        :pswitch_0
        :pswitch_4
        :pswitch_3
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method private popBagMenu(II)V
    .locals 5
    .param p1, "selectx"    # I
    .param p2, "select_i"    # I

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x0

    .line 1132
    const-string v1, "\u8fd4\u56de"

    .line 1133
    .local v1, "ts":Ljava/lang/String;
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, p1

    aget-object v2, v2, p2

    aget-byte v0, v2, v3

    .line 1134
    .local v0, "id":B
    if-eqz p1, :cond_0

    const/16 v2, 0x20

    if-eq v0, v2, :cond_0

    const/16 v2, 0x21

    if-ne v0, v2, :cond_2

    :cond_0
    invoke-direct {p0, v0}, Lmain/GameRun;->isBagUse(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1135
    const-string v1, "\u4f7f\u7528#n\u8fd4\u56de"

    .line 1140
    :cond_1
    :goto_0
    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v1, v2, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 1141
    iput-byte v3, p0, Lmain/GameRun;->popMenu:B

    .line 1142
    return-void

    .line 1136
    :cond_2
    if-ne p1, v4, :cond_3

    const-string v1, "\u5b66\u4e60#n\u8fd4\u56de"

    goto :goto_0

    .line 1138
    :cond_3
    iget-byte v2, p0, Lmain/GameRun;->view_state:B

    if-ne v2, v4, :cond_1

    const/4 v2, 0x3

    if-ne p1, v2, :cond_1

    const-string v1, "\u5b75\u5316#n\u8fd4\u56de"

    goto :goto_0
.end method

.method private popBagState()V
    .locals 13

    .prologue
    const/4 v12, -0x2

    const/16 v11, 0x20

    const/4 v10, -0x1

    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 1149
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ms;->key_Up_Down()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 1150
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    iget-byte v6, p0, Lmain/GameRun;->popMenu:B

    iget-object v7, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    array-length v7, v7

    sub-int/2addr v7, v8

    invoke-virtual {v5, v6, v9, v7}, Ldm/Ms;->select(III)B

    move-result v5

    iput-byte v5, p0, Lmain/GameRun;->popMenu:B

    .line 1151
    :cond_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ms;->key_S1_Num5()Z

    move-result v5

    if-eqz v5, :cond_16

    .line 1152
    iget-object v5, p0, Lmain/GameRun;->items:[[[B

    iget-byte v6, p0, Lmain/GameRun;->selectx:B

    aget-object v5, v5, v6

    iget-object v6, p0, Lmain/GameRun;->select:[[B

    aget-object v6, v6, v9

    aget-byte v6, v6, v9

    aget-object v5, v5, v6

    aget-byte v1, v5, v9

    .line 1154
    .local v1, "id":B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    iget-object v6, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    iget-byte v7, p0, Lmain/GameRun;->popMenu:B

    aget-object v6, v6, v7

    const-string v7, "\u4f7f\u7528"

    invoke-virtual {v5, v6, v7}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_12

    .line 1155
    sparse-switch v1, :sswitch_data_0

    .line 1211
    invoke-virtual {p0}, Lmain/GameRun;->goVIEW_MONSTER()V

    .line 1212
    const/16 v5, 0xf

    iput-byte v5, p0, Lmain/GameRun;->mini_state:B

    .line 1229
    :cond_1
    :goto_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    iget-object v6, p0, Lmain/GameRun;->select:[[B

    aget-object v6, v6, v9

    iget-object v7, p0, Lmain/GameRun;->itemsLength:[B

    iget-byte v8, p0, Lmain/GameRun;->selectx:B

    aget-byte v7, v7, v8

    iget-byte v8, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v5, v6, v7, v8}, Ldm/Ms;->correctSelect([BII)V

    .line 1237
    .end local v1    # "id":B
    :cond_2
    :goto_1
    return-void

    .line 1159
    .restart local v1    # "id":B
    :sswitch_0
    iget-byte v5, p0, Lmain/GameRun;->battle_type:B

    const/4 v6, 0x4

    if-eq v5, v6, :cond_3

    iget-byte v5, p0, Lmain/GameRun;->battle_type:B

    if-ne v5, v8, :cond_4

    .line 1160
    :cond_3
    invoke-direct {p0}, Lmain/GameRun;->goCatchMonster()V

    goto :goto_0

    .line 1162
    :cond_4
    const-string v5, "\u7279\u6b8a\u60c5\u51b5\uff0c\u65e0\u6cd5\u6355\u83b7\uff01"

    invoke-virtual {p0, v5, v8}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1163
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    const/16 v6, 0x190

    invoke-virtual {v5, v6}, Ldm/Ms;->sleep(I)V

    goto :goto_0

    .line 1168
    :sswitch_1
    iput-byte v10, p0, Lmain/GameRun;->popMenu:B

    .line 1170
    iget-object v5, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v5, v5, Lmain/Map;->notMeet:B

    if-nez v5, :cond_5

    .line 1171
    iget-object v5, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v5, v8, v1}, Lmain/Map;->notMeet(II)V

    .line 1172
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\u4f7f\u7528"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\uff0c"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\u83b7\u5f97\u4e86"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\u8eb2\u907f\u602a\u7269\u6548\u679c"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5, v8}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1173
    invoke-virtual {p0, v1, v8}, Lmain/GameRun;->deleteItems(II)V

    goto :goto_0

    .line 1174
    :cond_5
    iget-object v5, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v5, v5, Lmain/Map;->notMeet:B

    if-ne v5, v8, :cond_1

    .line 1175
    const-string v5, "\u5df2\u62e5\u6709\u8eb2\u907f\u602a\u7269\u6548\u679c"

    invoke-virtual {p0, v5, v9}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 1179
    :sswitch_2
    if-ne v1, v11, :cond_8

    const/16 v5, 0x21

    :goto_2
    invoke-virtual {p0, v12, v5, v8}, Lmain/GameRun;->findItem(IIZ)B

    move-result v5

    if-lez v5, :cond_10

    .line 1180
    invoke-virtual {p0, v11, v8}, Lmain/GameRun;->deleteItems(II)V

    .line 1181
    const/16 v5, 0x21

    invoke-virtual {p0, v5, v8}, Lmain/GameRun;->deleteItems(II)V

    .line 1182
    const/4 v4, 0x3

    .local v4, "type":B
    const/4 v0, 0x1

    .line 1183
    .local v0, "d":B
    const/4 v2, -0x1

    .local v2, "rId":B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v5, 0x64

    invoke-static {v5}, Ldm/Ms;->getRandom(I)I

    move-result v5

    int-to-byte v3, v5

    .line 1185
    .local v3, "rand":B
    const/16 v5, 0x46

    if-ge v3, v5, :cond_9

    const/4 v4, 0x0

    .line 1193
    :cond_6
    :goto_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v5, 0x64

    invoke-static {v5}, Ldm/Ms;->getRandom(I)I

    move-result v5

    int-to-byte v3, v5

    .line 1194
    :goto_4
    iget-object v5, p0, Lmain/GameRun;->itemMine:[[B

    aget-object v5, v5, v4

    array-length v5, v5

    if-lt v0, v5, :cond_b

    .line 1200
    :goto_5
    const/16 v5, 0x22

    if-ne v2, v5, :cond_d

    invoke-virtual {p0, v12, v2, v8}, Lmain/GameRun;->findItem(IIZ)B

    move-result v5

    if-lez v5, :cond_d

    const/4 v2, -0x1

    .line 1202
    :cond_7
    :goto_6
    if-eq v2, v10, :cond_f

    .line 1203
    invoke-virtual {p0, v2, v8}, Lmain/GameRun;->addItem(II)B

    .line 1204
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\u83b7\u5f97\uff1a"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "x1"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5, v9}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1208
    .end local v0    # "d":B
    .end local v2    # "rId":B
    .end local v3    # "rand":B
    .end local v4    # "type":B
    :goto_7
    iput-byte v10, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    :cond_8
    move v5, v11

    .line 1179
    goto :goto_2

    .line 1186
    .restart local v0    # "d":B
    .restart local v2    # "rId":B
    .restart local v3    # "rand":B
    .restart local v4    # "type":B
    :cond_9
    const/16 v5, 0x55

    if-ge v3, v5, :cond_a

    const/4 v4, 0x1

    goto :goto_3

    .line 1187
    :cond_a
    const/16 v5, 0x5f

    if-ge v3, v5, :cond_6

    const/4 v4, 0x2

    goto :goto_3

    .line 1195
    :cond_b
    iget-object v5, p0, Lmain/GameRun;->itemMine:[[B

    aget-object v5, v5, v4

    aget-byte v5, v5, v0

    if-ge v3, v5, :cond_c

    .line 1196
    iget-object v5, p0, Lmain/GameRun;->itemMine:[[B

    aget-object v5, v5, v4

    sub-int v6, v0, v8

    aget-byte v2, v5, v6

    .line 1197
    goto :goto_5

    .line 1194
    :cond_c
    add-int/lit8 v5, v0, 0x2

    int-to-byte v0, v5

    goto :goto_4

    .line 1201
    :cond_d
    if-eq v2, v10, :cond_e

    invoke-virtual {p0, v12, v2, v8}, Lmain/GameRun;->findItem(IIZ)B

    move-result v5

    const/16 v6, 0x63

    if-lt v5, v6, :cond_7

    :cond_e
    const/4 v2, -0x1

    goto :goto_6

    .line 1206
    :cond_f
    const-string v5, "\u8fd9\u4e2a\u5b9d\u7bb1\u662f\u7a7a\u7684\u3002"

    invoke-virtual {p0, v5, v9}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_7

    .line 1207
    .end local v0    # "d":B
    .end local v2    # "rId":B
    .end local v3    # "rand":B
    .end local v4    # "type":B
    :cond_10
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\u6ca1\u6709"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-ne v1, v11, :cond_11

    const-string v6, "\u94a5\u5319\uff0c\u94a5\u5319\u5728\u5546\u5e97\u4e2d\u53ef\u4ee5\u8d2d\u4e70\u3002"

    :goto_8
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5, v9}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_7

    :cond_11
    const-string v6, "\u5b9d\u7bb1\uff0c\u5b9d\u7bb1\u5728\u6218\u6597\u540e\u4e00\u5b9a\u51e0\u7387\u83b7\u5f97\u3002"

    goto :goto_8

    .line 1215
    :cond_12
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    iget-object v6, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    iget-byte v7, p0, Lmain/GameRun;->popMenu:B

    aget-object v6, v6, v7

    const-string v7, "\u5b66\u4e60"

    invoke-virtual {v5, v6, v7}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_13

    .line 1216
    const/16 v5, 0xd

    iput-byte v5, p0, Lmain/GameRun;->mini_state:B

    .line 1217
    const/16 v5, 0x9

    sub-int v5, v1, v5

    int-to-byte v5, v5

    iput-byte v5, p0, Lmain/GameRun;->getSkill:B

    .line 1218
    invoke-virtual {p0}, Lmain/GameRun;->goVIEW_MONSTER()V

    goto/16 :goto_0

    .line 1220
    :cond_13
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    iget-object v6, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    iget-byte v7, p0, Lmain/GameRun;->popMenu:B

    aget-object v6, v6, v7

    const-string v7, "\u5b75\u5316"

    invoke-virtual {v5, v6, v7}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_15

    .line 1221
    const/16 v5, 0x3a

    sub-int v5, v1, v5

    invoke-virtual {p0, v5}, Lmain/GameRun;->addNidus(I)Z

    move-result v5

    if-eqz v5, :cond_14

    .line 1222
    invoke-virtual {p0, v1, v8}, Lmain/GameRun;->deleteItems(II)V

    .line 1223
    iget-object v5, p0, Lmain/GameRun;->select_it:[B

    iget-byte v6, p0, Lmain/GameRun;->selectx:B

    iget-object v7, p0, Lmain/GameRun;->select:[[B

    aget-object v7, v7, v9

    aget-byte v7, v7, v9

    aput-byte v7, v5, v6

    .line 1224
    iget-object v5, p0, Lmain/GameRun;->select_st:[B

    iget-byte v6, p0, Lmain/GameRun;->selectx:B

    iget-object v7, p0, Lmain/GameRun;->select:[[B

    aget-object v7, v7, v9

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 1226
    :goto_9
    iput-byte v10, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    .line 1225
    :cond_14
    const-string v5, "\u5b75\u5316\u6240\u5df2\u7ecf\u6ca1\u6709\u7a7a\u4f4d\u4e86"

    invoke-virtual {p0, v5, v9}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_9

    .line 1228
    :cond_15
    iput-byte v10, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    .line 1231
    .end local v1    # "id":B
    :cond_16
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ms;->key_S2()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 1235
    iput-byte v10, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_1

    .line 1155
    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_0
        0xa -> :sswitch_0
        0xb -> :sswitch_0
        0xe -> :sswitch_1
        0xf -> :sswitch_1
        0x20 -> :sswitch_2
        0x21 -> :sswitch_2
    .end sparse-switch
.end method

.method private putMonster()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 2701
    iget-byte v0, p0, Lmain/GameRun;->cMon_count:B

    iget-byte v1, p0, Lmain/GameRun;->max_monsters:B

    if-lt v0, v1, :cond_0

    .line 2702
    const-string v0, "\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1"

    invoke-virtual {p0, v0, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2710
    :goto_0
    return-void

    .line 2703
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v4

    aget-byte v0, v0, v4

    invoke-direct {p0, v0}, Lmain/GameRun;->isMyMonsters(I)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2704
    const-string v0, "\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01"

    invoke-virtual {p0, v0, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 2706
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->cMon_count:B

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v4

    aget-byte v3, v3, v4

    aget-object v2, v2, v3

    aput-object v2, v0, v1

    .line 2707
    iget-byte v0, p0, Lmain/GameRun;->cMon_count:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->cMon_count:B

    .line 2708
    invoke-direct {p0}, Lmain/GameRun;->setPutMonster()V

    goto :goto_0
.end method

.method private resetFealty(I)V
    .locals 7
    .param p1, "hp"    # I

    .prologue
    const/4 v6, -0x1

    const/4 v5, 0x6

    const/4 v4, 0x0

    .line 3784
    iget-object v1, p0, Lmain/GameRun;->initFealty:[B

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v4

    aget-byte v3, v3, v4

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monster:[B

    const/4 v3, 0x4

    aget-byte v2, v2, v3

    div-int/lit8 v2, v2, 0x4

    aget-byte v0, v1, v2

    .line 3785
    .local v0, "fealty":B
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v5

    if-ge v1, v0, :cond_3

    .line 3786
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v4

    if-lez v1, :cond_3

    .line 3787
    if-ne p1, v6, :cond_1

    .line 3788
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aput-byte v0, v1, v5

    .line 3794
    :goto_0
    iget-object v1, p0, Lmain/GameRun;->select_it:[B

    aget-byte v1, v1, v4

    invoke-direct {p0, v4, v1}, Lmain/GameRun;->useState(II)V

    .line 3795
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-ne v1, v6, :cond_0

    .line 3796
    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v3}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    invoke-direct {p0, v1, v2, v3}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 3802
    :cond_0
    :goto_1
    return-void

    .line 3790
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v5

    add-int/2addr v1, p1

    if-le v1, v0, :cond_2

    .line 3791
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aput-byte v0, v1, v5

    goto :goto_0

    .line 3793
    :cond_2
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v2, v1, v5

    add-int/2addr v2, p1

    int-to-byte v2, v2

    aput-byte v2, v1, v5

    goto :goto_0

    .line 3798
    :cond_3
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v4

    aget-byte v2, v2, v4

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v4

    if-lez v1, :cond_0

    .line 3799
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v4

    aget-byte v3, v3, v4

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v4

    invoke-virtual {p0, v2}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "\u5fe0\u8bda\u5ea6\u5df2\u6ee1"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_1
.end method

.method private resetMonster(I)V
    .locals 4
    .param p1, "hp"    # I

    .prologue
    const/4 v3, 0x0

    .line 3772
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    const/4 v1, 0x1

    if-ge v0, v1, :cond_0

    .line 3773
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x3

    aget-short v0, v0, v1

    mul-int/2addr v0, p1

    div-int/lit8 v0, v0, 0x64

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->AddMP(ILdm/Monster;)V

    .line 3774
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x2

    aget-short v0, v0, v1

    mul-int/2addr v0, p1

    div-int/lit8 v0, v0, 0x64

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->AddHP(ILdm/Monster;)V

    .line 3775
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    const/4 v1, 0x7

    iput-byte v1, v0, Ldm/Monster;->effect:B

    .line 3776
    iget-object v0, p0, Lmain/GameRun;->select_it:[B

    aget-byte v0, v0, v3

    invoke-direct {p0, v3, v0}, Lmain/GameRun;->useState(II)V

    .line 3779
    :goto_0
    return-void

    .line 3778
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v3

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "\u6ca1\u6709\u6b7b\u4ea1\uff01"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private restMove(II)V
    .locals 4
    .param p1, "type"    # I
    .param p2, "i"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 2957
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v2

    aget-byte v0, v0, v3

    iput-byte v0, p0, Lmain/GameRun;->selectx:B

    .line 2958
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v2

    aget-byte v0, v0, v2

    iput-byte v0, p0, Lmain/GameRun;->selecty:B

    .line 2959
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/GameRun;->cur_c:B

    .line 2960
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v2

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v2

    aput-byte v2, v1, v2

    aput-byte v2, v0, v3

    .line 2961
    int-to-byte v0, p2

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 2962
    const/16 v0, 0x81

    iput-short v0, p0, Lmain/GameRun;->move_x:S

    .line 2963
    const/16 v0, -0xe

    iput-short v0, p0, Lmain/GameRun;->move_y:S

    .line 2964
    return-void
.end method

.method private runBattleState()V
    .locals 11

    .prologue
    const/4 v10, -0x1

    const/4 v9, 0x4

    const/4 v8, 0x2

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 4834
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v2, v2, Ldm/Battle;->countS:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v4, v4, Ldm/Battle;->countS:[B

    aget-byte v4, v4, v7

    iget-object v5, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v5, v5, Ldm/Battle;->countS:[B

    aget-byte v5, v5, v6

    invoke-virtual {v3, v4, v5, v6, v7}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v3

    int-to-byte v3, v3

    aput-byte v3, v2, v7

    .line 4835
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v2, v2, Ldm/Battle;->countS:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v4, v4, Ldm/Battle;->countS:[B

    aget-byte v4, v4, v7

    iget-object v5, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v5, v5, Ldm/Battle;->countS:[B

    aget-byte v5, v5, v6

    invoke-virtual {v3, v4, v5, v6, v7}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v3

    int-to-byte v3, v3

    aput-byte v3, v2, v7

    .line 4836
    iget-byte v2, p0, Lmain/GameRun;->battle_state:B

    sparse-switch v2, :sswitch_data_0

    .line 4942
    :cond_0
    :goto_0
    :sswitch_0
    return-void

    .line 4838
    :sswitch_1
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-direct {p0, v2}, Lmain/GameRun;->bufferAI(Ldm/Monster;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 4839
    invoke-direct {p0}, Lmain/GameRun;->aiEnemy()V

    .line 4840
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-byte v2, v2, Ldm/Monster;->effect:B

    const/4 v3, 0x6

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->skill:B

    invoke-direct {p0, v2}, Lmain/GameRun;->getSkillLevel(I)I

    move-result v2

    const/4 v3, 0x3

    if-gt v2, v3, :cond_0

    .line 4841
    :cond_1
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-direct {p0, v2}, Lmain/GameRun;->setAcionSkill(Ldm/Battle;)V

    goto :goto_0

    .line 4843
    :cond_2
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v7, v2, Ldm/Battle;->act_num:B

    .line 4844
    const/4 v2, -0x2

    iput-byte v2, p0, Lmain/GameRun;->battle_state:B

    goto :goto_0

    .line 4849
    :sswitch_2
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->act_num:B

    if-nez v2, :cond_3

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->act_num:B

    if-nez v2, :cond_3

    .line 4850
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v6, v2, Ldm/Battle;->act_num:B

    .line 4851
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v6, v2, Ldm/Battle;->act_num:B

    .line 4852
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-virtual {v2, v7}, Ldm/Monster;->isMonEffect(I)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 4853
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v7, v2, Ldm/Battle;->act_num:B

    .line 4854
    const-string v2, "\u77f3\u5316\u6548\u679c\u65e0\u6cd5\u884c\u52a8\uff0c\u53d7\u5230\u7684\u4f24\u5bb3\u51cf\u5c1130%"

    invoke-virtual {p0, v2, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 4872
    :cond_3
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->act_num:B

    if-eqz v2, :cond_a

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->act_num:B

    if-eqz v2, :cond_a

    .line 4873
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    const/4 v3, 0x5

    aget-short v2, v2, v3

    .line 4874
    iget-object v3, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v3}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    iget-object v3, v3, Ldm/Monster;->monsterPro:[S

    const/4 v4, 0x5

    aget-short v3, v3, v4

    if-lt v2, v3, :cond_9

    move v2, v6

    .line 4873
    :goto_1
    invoke-virtual {p0, v2}, Lmain/GameRun;->setAimBattle(I)V

    .line 4876
    :goto_2
    iget-byte v2, p0, Lmain/GameRun;->mini_state:B

    if-ne v2, v6, :cond_e

    .line 4877
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v7, v2, Ldm/Battle;->act_num:B

    .line 4878
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monster:[B

    const/4 v3, 0x6

    aget-byte v2, v2, v3

    const/16 v3, 0x29

    if-ge v2, v3, :cond_c

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v2, 0x64

    invoke-static {v2}, Ldm/Ms;->getRandom(I)I

    move-result v2

    const/16 v3, 0x19

    if-ge v2, v3, :cond_c

    .line 4879
    const-string v2, "\u5fe0\u8bda\u5ea6\u8fc7\u4f4e\uff0c\u5ba0\u7269\u4e0d\u670d\u4ece\u4e3b\u4eba\u547d\u4ee4"

    invoke-virtual {p0, v2, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 4856
    :cond_4
    invoke-virtual {p0, v6}, Lmain/GameRun;->setAimBattle(I)V

    .line 4857
    invoke-direct {p0}, Lmain/GameRun;->goBattleState()V

    .line 4858
    const-string v1, ""

    .line 4859
    .local v1, "s":Ljava/lang/String;
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-virtual {v2, v8}, Ldm/Monster;->isMonEffect(I)Z

    move-result v2

    if-eqz v2, :cond_6

    const-string v1, "\u6495\u88c2\u6548\u679c\uff0c\u51cf\u5c11\u5f53\u524d\u8840\u91cf\u768410%"

    .line 4865
    :cond_5
    :goto_3
    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-virtual {p0, v1, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 4861
    :cond_6
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Ldm/Monster;->isMonEffect(I)Z

    move-result v2

    if-eqz v2, :cond_7

    const-string v1, "\u9b45\u60d1\u6548\u679c\uff0c\u4e0d\u80fd\u9003\u8dd1\uff0c\u589e\u52a0\u6355\u83b7\u5ba0\u7269\u7684\u51e0\u7387"

    goto :goto_3

    .line 4862
    :cond_7
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-virtual {v2, v9}, Ldm/Monster;->isMonEffect(I)Z

    move-result v2

    if-eqz v2, :cond_8

    const-string v1, "\u7981\u9522\u6548\u679c\uff0c\u4e0d\u80fd\u9003\u8dd1\uff0c\u4e0d\u80fd\u6362\u602a\uff0c\u4e0d\u80fd\u4f7f\u7528\u9053\u5177"

    goto :goto_3

    .line 4863
    :cond_8
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    const/4 v3, 0x5

    invoke-virtual {v2, v3}, Ldm/Monster;->isMonEffect(I)Z

    move-result v2

    if-eqz v2, :cond_5

    const-string v1, "\u8150\u8680\u6548\u679c\uff0c\u6bcf\u56de\u5408\u53d7\u5230\u4e00\u5b9a\u4f24\u5bb3"

    goto :goto_3

    .end local v1    # "s":Ljava/lang/String;
    :cond_9
    move v2, v7

    .line 4874
    goto/16 :goto_1

    .line 4875
    :cond_a
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->act_num:B

    if-eqz v2, :cond_b

    move v2, v6

    :goto_4
    invoke-virtual {p0, v2}, Lmain/GameRun;->setAimBattle(I)V

    goto/16 :goto_2

    :cond_b
    move v2, v7

    goto :goto_4

    .line 4880
    :cond_c
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-virtual {v2, v7}, Ldm/Monster;->isMonEffect(I)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 4881
    const-string v2, "\u77f3\u5316\u6548\u679c\u65e0\u6cd5\u884c\u52a8\uff0c\u53d7\u5230\u7684\u4f24\u5bb3\u51cf\u5c1130%"

    invoke-virtual {p0, v2, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 4882
    :cond_d
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-direct {p0, v2}, Lmain/GameRun;->setAcionSkill(Ldm/Battle;)V

    goto/16 :goto_0

    .line 4883
    :cond_e
    iget-byte v2, p0, Lmain/GameRun;->say_c:B

    if-nez v2, :cond_0

    .line 4884
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v7, v2, Ldm/Battle;->act_num:B

    .line 4885
    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-virtual {v2, v7}, Ldm/Monster;->isMonEffect(I)Z

    move-result v2

    if-nez v2, :cond_0

    .line 4886
    iput-byte v6, p0, Lmain/GameRun;->battle_state:B

    goto/16 :goto_0

    .line 4892
    :sswitch_3
    iget-byte v2, p0, Lmain/GameRun;->b_c:B

    if-nez v2, :cond_f

    iget-byte v2, p0, Lmain/GameRun;->cur_c:B

    iget-object v3, p0, Lmain/GameRun;->mon_in_battle:[B

    aget-byte v3, v3, v7

    if-lt v2, v3, :cond_f

    .line 4893
    invoke-direct {p0}, Lmain/GameRun;->goBattleOver()V

    .line 4895
    iget-short v2, p0, Lmain/GameRun;->exp:S

    invoke-virtual {p0, v2}, Lmain/GameRun;->setNidusExp(I)V

    goto/16 :goto_0

    .line 4899
    :cond_f
    iget-object v2, p0, Lmain/GameRun;->mon_in_battle:[B

    iget-byte v3, p0, Lmain/GameRun;->cur_c:B

    add-int/lit8 v3, v3, 0x1

    aget-byte v0, v2, v3

    .line 4900
    .local v0, "id":B
    iget-byte v2, p0, Lmain/GameRun;->b_c:B

    if-nez v2, :cond_13

    .line 4902
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    aget-short v2, v2, v7

    if-lez v2, :cond_12

    .line 4903
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    const/16 v3, 0x28

    invoke-virtual {v2, v3}, Ldm/Monster;->isMonReel(I)Z

    move-result v2

    if-nez v2, :cond_10

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    const/4 v3, 0x6

    aget-byte v4, v2, v3

    sub-int/2addr v4, v6

    int-to-byte v4, v4

    aput-byte v4, v2, v3

    .line 4904
    :cond_10
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v0, v2, Ldm/Battle;->now_id:B

    .line 4905
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v0

    iget-object v3, v3, Ldm/Monster;->monsterPro:[S

    aget-short v3, v3, v7

    iput-short v3, v2, Ldm/Battle;->chp:S

    .line 4906
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v0

    iget-object v3, v3, Ldm/Monster;->monsterPro:[S

    aget-short v3, v3, v9

    iput-short v3, v2, Ldm/Battle;->cexp:S

    .line 4908
    iget-object v2, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v0

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v7

    aget-object v2, v2, v3

    aget-byte v2, v2, v7

    invoke-virtual {p0, v8, v2, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 4909
    invoke-direct {p0, v0, v7}, Lmain/GameRun;->level_up(II)Z

    move-result v2

    if-eqz v2, :cond_11

    iput-byte v6, p0, Lmain/GameRun;->b_c:B

    .line 4926
    :cond_11
    :goto_5
    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-short v4, v4, Ldm/Battle;->cexp:S

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, v0

    iget-object v5, v5, Ldm/Monster;->monsterPro:[S

    aget-short v5, v5, v9

    const/16 v6, 0x8

    invoke-virtual {v3, v4, v5, v6, v7}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v3

    iput-short v3, v2, Ldm/Battle;->cexp:S

    goto/16 :goto_0

    .line 4911
    :cond_12
    iget-byte v2, p0, Lmain/GameRun;->cur_c:B

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    iput-byte v2, p0, Lmain/GameRun;->cur_c:B

    goto :goto_5

    .line 4913
    :cond_13
    iget-byte v2, p0, Lmain/GameRun;->b_c:B

    if-ne v2, v6, :cond_14

    .line 4914
    invoke-direct {p0, v0, v6}, Lmain/GameRun;->level_up(II)Z

    .line 4915
    iput-byte v8, p0, Lmain/GameRun;->b_c:B

    goto :goto_5

    .line 4916
    :cond_14
    iget-byte v2, p0, Lmain/GameRun;->b_c:B

    if-ne v2, v8, :cond_16

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-short v2, v2, Ldm/Battle;->cexp:S

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v0

    iget-object v3, v3, Ldm/Monster;->monsterPro:[S

    aget-short v3, v3, v9

    if-ne v2, v3, :cond_16

    .line 4917
    invoke-direct {p0, v0, v8}, Lmain/GameRun;->level_up(II)Z

    move-result v2

    if-nez v2, :cond_15

    const/16 v2, 0xf

    iput-byte v2, p0, Lmain/GameRun;->b_c:B

    goto :goto_5

    .line 4918
    :cond_15
    iput-byte v6, p0, Lmain/GameRun;->b_c:B

    goto :goto_5

    .line 4919
    :cond_16
    iget-byte v2, p0, Lmain/GameRun;->b_c:B

    if-le v2, v8, :cond_11

    iget-byte v2, p0, Lmain/GameRun;->b_c:B

    const/16 v3, 0x15

    if-ge v2, v3, :cond_17

    move v2, v6

    :goto_6
    iget-object v3, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-short v3, v3, Ldm/Battle;->cexp:S

    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, v0

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aget-short v4, v4, v9

    if-ne v3, v4, :cond_18

    move v3, v6

    :goto_7
    and-int/2addr v2, v3

    if-eqz v2, :cond_11

    .line 4920
    iget-byte v2, p0, Lmain/GameRun;->b_c:B

    sub-int/2addr v2, v6

    int-to-byte v2, v2

    iput-byte v2, p0, Lmain/GameRun;->b_c:B

    const/4 v3, 0x3

    if-ne v2, v3, :cond_11

    .line 4921
    iput-byte v7, p0, Lmain/GameRun;->b_c:B

    .line 4922
    iget-byte v2, p0, Lmain/GameRun;->cur_c:B

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    iput-byte v2, p0, Lmain/GameRun;->cur_c:B

    goto :goto_5

    :cond_17
    move v2, v7

    .line 4919
    goto :goto_6

    :cond_18
    move v3, v7

    goto :goto_7

    .line 4930
    .end local v0    # "id":B
    :sswitch_4
    iget-byte v2, p0, Lmain/GameRun;->say_c:B

    if-nez v2, :cond_0

    .line 4931
    iget-byte v2, p0, Lmain/GameRun;->cur_b:B

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    iput-byte v2, p0, Lmain/GameRun;->cur_b:B

    iget-object v3, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    array-length v3, v3

    if-lt v2, v3, :cond_19

    .line 4932
    const/4 v2, 0x0

    iput-object v2, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    .line 4933
    invoke-direct {p0, v6}, Lmain/GameRun;->goBattleExp(Z)V

    goto/16 :goto_0

    .line 4937
    :cond_19
    const-string v2, "soars"

    iget-object v3, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    iget-byte v4, p0, Lmain/GameRun;->cur_b:B

    aget-object v3, v3, v4

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 4938
    iget-object v2, p0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->cur_b:B

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 4836
    nop

    :sswitch_data_0
    .sparse-switch
        -0x5 -> :sswitch_3
        -0x4 -> :sswitch_4
        -0x3 -> :sswitch_0
        0x1 -> :sswitch_1
        0x9 -> :sswitch_2
    .end sparse-switch
.end method

.method private runHit()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 4460
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-boolean v0, v0, Ldm/Battle;->b_renascence:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iget-boolean v0, v0, Ldm/Battle;->b_renascence:Z

    if-nez v0, :cond_0

    .line 4461
    iget-object v1, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-object v2, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    iget-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    iget-byte v5, v0, Ldm/Battle;->skill:B

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lmain/GameRun;->hit_rate(Ldm/Battle;Ldm/Battle;Ldm/Monster;Ldm/Monster;I)V

    .line 4466
    :goto_0
    const/4 v0, -0x2

    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 4467
    return-void

    .line 4463
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    iput-boolean v1, v0, Ldm/Battle;->b_renascence:Z

    .line 4464
    iget-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iput-boolean v1, v0, Ldm/Battle;->b_renascence:Z

    goto :goto_0
.end method

.method private runHitToState(Ldm/Battle;Ldm/Battle;I)Z
    .locals 6
    .param p1, "amB"    # Ldm/Battle;
    .param p2, "dmB"    # Ldm/Battle;
    .param p3, "mState"    # I

    .prologue
    const/16 v5, 0x26

    const/4 v3, 0x2

    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 4945
    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v4

    if-lez v0, :cond_0

    move v0, v2

    .line 5039
    :goto_0
    return v0

    .line 4946
    :cond_0
    iget-byte v0, p2, Ldm/Battle;->dead:B

    if-ne v0, v2, :cond_a

    .line 4947
    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    invoke-virtual {v0, v5}, Ldm/Monster;->isMonReel(I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 4948
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v0, 0x64

    invoke-static {v0}, Ldm/Ms;->getRandom(I)I

    move-result v0

    iget-object v1, p0, Lmain/GameRun;->skill:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v2

    if-ge v0, v1, :cond_2

    invoke-direct {p0, p1, p2}, Lmain/GameRun;->setRelive(Ldm/Battle;Ldm/Battle;)V

    :cond_1
    :goto_1
    move v0, v4

    .line 5039
    goto :goto_0

    .line 4950
    :cond_2
    if-nez p3, :cond_7

    .line 4951
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v2, v0, Ldm/Battle;->act_num:B

    .line 4954
    invoke-direct {p0}, Lmain/GameRun;->changeMy()Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v4

    goto :goto_0

    .line 4955
    :cond_3
    iget-byte v0, p0, Lmain/GameRun;->overMode:B

    if-eqz v0, :cond_5

    .line 4956
    iget-byte v0, p0, Lmain/GameRun;->overMode:B

    if-ne v0, v3, :cond_4

    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iput-byte v2, v0, Lmain/Map;->sIfElse:B

    .line 4957
    :cond_4
    iput-byte v4, p0, Lmain/GameRun;->overMode:B

    .line 4958
    invoke-direct {p0}, Lmain/GameRun;->arangeMonster()V

    .line 4959
    invoke-direct {p0}, Lmain/GameRun;->setNullBattle()V

    .line 4960
    invoke-direct {p0}, Lmain/GameRun;->goGO_RUNINMAP()V

    .line 4961
    invoke-virtual {p0, v4}, Lmain/GameRun;->healMonster(Z)V

    move v0, v4

    .line 4962
    goto :goto_0

    .line 4964
    :cond_5
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v0

    iget-boolean v0, v0, Lmain/SMSSender;->sms_a:Z

    if-eqz v0, :cond_6

    .line 4965
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "aaaaaaaaaaaaa"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 4968
    iget-byte v0, p0, Lmain/GameRun;->say_c:B

    if-nez v0, :cond_1

    .line 4969
    iput-boolean v2, p0, Lmain/GameRun;->isKillAll:Z

    .line 4979
    sget-boolean v0, Lmain/GameRun;->isSay:Z

    if-nez v0, :cond_1

    .line 4980
    const-string v0, "\u643a\u5e26\u7684\u5ba0\u7269\u5168\u90fd\u727a\u7272\u4e86!"

    const/4 v1, -0x1

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->say(Ljava/lang/String;II)V

    goto :goto_1

    .line 4988
    :cond_6
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "bbbbbbbbbb"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 4989
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v0

    iput-boolean v2, v0, Lmain/SMSSender;->sms_a:Z

    .line 4990
    invoke-virtual {p0}, Lmain/GameRun;->goGameOver()V

    goto :goto_1

    .line 5018
    :cond_7
    if-ne p3, v2, :cond_1

    .line 5019
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, v1, Ldm/Battle;->mon:[Ldm/Monster;

    array-length v1, v1

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->changeMon(Ldm/Battle;I)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 5020
    invoke-direct {p0}, Lmain/GameRun;->setEnemyThrow()V

    .line 5021
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v4, v0, Ldm/Battle;->act_num:B

    .line 5022
    const/16 v0, -0x32

    sput v0, Lmain/GameRun;->run_state:I

    .line 5023
    iget-byte v0, p0, Lmain/GameRun;->battle_state:B

    iput-byte v0, p0, Lmain/GameRun;->t_battle_state:B

    .line 5024
    iput-byte v4, p0, Lmain/GameRun;->battle_state:B

    goto :goto_1

    .line 5027
    :cond_8
    invoke-direct {p0}, Lmain/GameRun;->goBattleItem()V

    .line 5028
    iget-byte v0, p0, Lmain/GameRun;->overMode:B

    if-ne v0, v3, :cond_9

    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iput-byte v4, v0, Lmain/Map;->sIfElse:B

    .line 5029
    :cond_9
    iput-byte v4, p0, Lmain/GameRun;->overMode:B

    goto/16 :goto_1

    .line 5033
    :cond_a
    iget-byte v0, p2, Ldm/Battle;->action:B

    if-eq v0, v3, :cond_1

    .line 5034
    iput-byte v3, p2, Ldm/Battle;->action:B

    .line 5035
    iget-object v0, p0, Lmain/GameRun;->now_action:[B

    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    aput-byte v4, v0, v1

    .line 5036
    iget-object v0, p0, Lmain/GameRun;->now_time:[B

    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    aput-byte v4, v0, v1

    .line 5037
    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    const/16 v1, 0x28

    invoke-virtual {v0, v1}, Ldm/Monster;->isMonReel(I)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monster:[B

    const/4 v1, 0x6

    aget-byte v2, v0, v1

    const/16 v3, 0xa

    sub-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    goto/16 :goto_1
.end method

.method private runMonsterAppear()V
    .locals 6

    .prologue
    const/4 v2, 0x2

    const/4 v5, 0x1

    const/4 v3, -0x2

    const/4 v4, 0x0

    .line 4249
    iget-byte v1, p0, Lmain/GameRun;->battle_state:B

    packed-switch v1, :pswitch_data_0

    .line 4279
    :cond_0
    :goto_0
    return-void

    .line 4251
    :pswitch_0
    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v1, v1, Ldm/Battle;->throw_state:B

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v1, v1, Ldm/Battle;->throw_state:B

    if-ne v1, v2, :cond_0

    .line 4252
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-ne v1, v3, :cond_1

    .line 4253
    invoke-virtual {p0, v4}, Lmain/GameRun;->setAimBattle(I)V

    .line 4254
    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v4, v1, Ldm/Battle;->act_num:B

    .line 4255
    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v4, v1, Ldm/Battle;->act_num:B

    .line 4257
    :cond_1
    const/4 v1, -0x1

    iput-byte v1, p0, Lmain/GameRun;->view_state:B

    .line 4258
    invoke-direct {p0}, Lmain/GameRun;->goBattleState()V

    .line 4259
    iget-byte v1, p0, Lmain/GameRun;->t_battle_state:B

    const/4 v2, -0x3

    if-eq v1, v2, :cond_2

    iget-byte v1, p0, Lmain/GameRun;->t_battle_state:B

    if-ne v1, v3, :cond_3

    .line 4260
    :cond_2
    iget-byte v1, p0, Lmain/GameRun;->t_battle_state:B

    iput-byte v1, p0, Lmain/GameRun;->battle_state:B

    .line 4261
    iput-byte v4, p0, Lmain/GameRun;->t_battle_state:B

    .line 4263
    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v3}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    invoke-direct {p0, v1, v2, v3}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 4266
    :goto_1
    iget-byte v1, p0, Lmain/GameRun;->first_battle:B

    if-nez v1, :cond_0

    .line 4267
    iput-byte v5, p0, Lmain/GameRun;->first_battle:B

    .line 4268
    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x6

    aget-byte v1, v1, v2

    const/16 v2, 0x63

    sub-int/2addr v1, v2

    int-to-byte v0, v1

    .line 4269
    .local v0, "coe":B
    if-le v0, v5, :cond_4

    const/16 v1, 0x14

    :goto_2
    int-to-byte v0, v1

    .line 4271
    if-gez v0, :cond_0

    const-string v1, "\u5fe0\u8bda\u5ea6\u964d\u4f4e\uff0c\u653b\u51fb\u529b\u4e0b\u964d\uff0c\u8bf7\u53ca\u65f6\u8865\u5145\uff01"

    invoke-virtual {p0, v1, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 4265
    .end local v0    # "coe":B
    :cond_3
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    invoke-direct {p0, v1}, Lmain/GameRun;->goSelectAction(I)V

    goto :goto_1

    .line 4269
    .restart local v0    # "coe":B
    :cond_4
    div-int/lit8 v1, v0, 0x14

    mul-int/lit8 v1, v1, 0x14

    goto :goto_2

    .line 4249
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method private runThrowBall(Ldm/Battle;Ldm/Monster;I)V
    .locals 7
    .param p1, "be"    # Ldm/Battle;
    .param p2, "mon"    # Ldm/Monster;
    .param p3, "mini"    # I

    .prologue
    const/16 v2, 0xc

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 4212
    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    add-int/lit8 v1, p3, 0x2

    aget-byte v0, v0, v1

    if-nez v0, :cond_2

    iget-byte v0, p1, Ldm/Battle;->throw_state:B

    const/4 v1, -0x1

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    aget-byte v0, v0, p3

    if-ne v0, v2, :cond_2

    iput-byte v4, p1, Ldm/Battle;->throw_state:B

    .line 4217
    :cond_0
    :goto_0
    iget-byte v0, p1, Ldm/Battle;->throw_state:B

    if-nez v0, :cond_3

    .line 4218
    iget-object v0, p1, Ldm/Battle;->cThrow:[S

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p1, Ldm/Battle;->cThrow:[S

    aget-short v2, v2, v4

    const/4 v3, 0x6

    invoke-virtual {v1, v2, v4, v3, v4}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v1

    int-to-byte v1, v1

    aput-short v1, v0, v4

    .line 4219
    iget-object v0, p1, Ldm/Battle;->cThrow:[S

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p1, Ldm/Battle;->cThrow:[S

    aget-short v2, v2, v5

    const/16 v3, 0x3e

    invoke-virtual {v1, v2, v3, v6}, Ldm/Ms;->mathSpeedUp(III)S

    move-result v1

    int-to-byte v1, v1

    aput-short v1, v0, v5

    .line 4220
    iget-object v0, p1, Ldm/Battle;->cThrow:[S

    aget-short v0, v0, v4

    if-nez v0, :cond_1

    iget-object v0, p1, Ldm/Battle;->cThrow:[S

    aget-short v0, v0, v5

    if-nez v0, :cond_1

    iput-byte v5, p1, Ldm/Battle;->throw_state:B

    .line 4226
    :cond_1
    :goto_1
    return-void

    .line 4213
    :cond_2
    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    add-int/lit8 v1, p3, 0x2

    aget-byte v0, v0, v1

    if-ne v0, v5, :cond_0

    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    aget-byte v0, v0, p3

    if-nez v0, :cond_0

    .line 4214
    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    add-int/lit8 v1, p3, 0x2

    aput-byte v4, v0, v1

    .line 4215
    invoke-direct {p0, p1, p2}, Lmain/GameRun;->getBattleBG(Ldm/Battle;Ldm/Monster;)V

    goto :goto_0

    .line 4222
    :cond_3
    iget-byte v0, p1, Ldm/Battle;->throw_state:B

    if-ne v0, v5, :cond_1

    .line 4223
    iget-object v0, p1, Ldm/Battle;->cThrow:[S

    aget-short v0, v0, v6

    if-ge v0, v2, :cond_4

    iget-object v0, p1, Ldm/Battle;->cThrow:[S

    aget-short v1, v0, v6

    add-int/lit8 v1, v1, 0x1

    int-to-short v1, v1

    aput-short v1, v0, v6

    goto :goto_1

    .line 4224
    :cond_4
    iput-byte v6, p1, Ldm/Battle;->throw_state:B

    goto :goto_1
.end method

.method private sellMonster(Ldm/Monster;)V
    .locals 3
    .param p1, "mon"    # Ldm/Monster;

    .prologue
    .line 2695
    iget-object v0, p1, Ldm/Monster;->monster:[B

    const/4 v1, 0x2

    aget-byte v0, v0, v1

    iget-object v1, p1, Ldm/Monster;->monster:[B

    const/4 v2, 0x4

    aget-byte v1, v1, v2

    mul-int/lit8 v1, v1, 0x5

    mul-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x64

    iput v0, p0, Lmain/GameRun;->sell_money:I

    .line 2699
    return-void
.end method

.method private setAcionSkill(Ldm/Battle;)V
    .locals 3
    .param p1, "be"    # Ldm/Battle;

    .prologue
    const/4 v2, 0x0

    .line 5059
    const/4 v0, 0x1

    iput-byte v0, p1, Ldm/Battle;->action:B

    .line 5060
    iget-object v0, p0, Lmain/GameRun;->now_action:[B

    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    aput-byte v2, v0, v1

    .line 5061
    iget-object v0, p0, Lmain/GameRun;->now_time:[B

    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    aput-byte v2, v0, v1

    .line 5062
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 5063
    iget-byte v0, p1, Ldm/Battle;->skill:B

    div-int/lit8 v0, v0, 0x5

    invoke-virtual {p0, v0}, Lmain/GameRun;->setMagic(I)V

    .line 5064
    return-void
.end method

.method private setCartoonFrameMagic_C(IIIZ)Z
    .locals 5
    .param p1, "i"    # I
    .param p2, "skill_mode"    # I
    .param p3, "select"    # I
    .param p4, "mode"    # Z

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 5414
    iget-object v0, p0, Lmain/GameRun;->now_time_Magic:[S

    aget-short v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    int-to-short v1, v1

    aput-short v1, v0, p1

    iget-object v0, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    aget-object v0, v0, p2

    iget-object v2, p0, Lmain/GameRun;->now_action_Magic:[S

    aget-short v2, v2, p1

    invoke-virtual {v0, p3, v2, v3}, Ldm/Sprite;->action(III)I

    move-result v0

    if-lt v1, v0, :cond_0

    .line 5415
    iget-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    aget-short v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    int-to-short v1, v1

    aput-short v1, v0, p1

    .line 5416
    iget-object v0, p0, Lmain/GameRun;->now_time_Magic:[S

    aput-short v4, v0, p1

    .line 5417
    if-nez p4, :cond_0

    iget-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    aget-short v0, v0, p1

    iget-object v1, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    aget-object v1, v1, p2

    invoke-virtual {v1, p3}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 5418
    iget-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    aget-short v1, v0, p1

    sub-int/2addr v1, v3

    int-to-short v1, v1

    aput-short v1, v0, p1

    move v0, v3

    .line 5422
    :goto_0
    return v0

    :cond_0
    move v0, v4

    goto :goto_0
.end method

.method private setCartoonFrame_C(IIIZ)Z
    .locals 5
    .param p1, "i"    # I
    .param p2, "skill_mode"    # I
    .param p3, "select"    # I
    .param p4, "mode"    # Z

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 5445
    iget-object v0, p0, Lmain/GameRun;->now_time:[B

    aget-byte v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    aput-byte v1, v0, p1

    iget-object v0, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v0, v0, p2

    iget-object v2, p0, Lmain/GameRun;->now_action:[B

    aget-byte v2, v2, p1

    invoke-virtual {v0, p3, v2, v3}, Ldm/Sprite;->action(III)I

    move-result v0

    if-lt v1, v0, :cond_0

    .line 5446
    iget-object v0, p0, Lmain/GameRun;->now_action:[B

    aget-byte v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    aput-byte v1, v0, p1

    .line 5447
    iget-object v0, p0, Lmain/GameRun;->now_time:[B

    aput-byte v4, v0, p1

    .line 5448
    if-nez p4, :cond_0

    iget-object v0, p0, Lmain/GameRun;->now_action:[B

    aget-byte v0, v0, p1

    iget-object v1, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v1, v1, p2

    invoke-virtual {v1, p3}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 5449
    iget-object v0, p0, Lmain/GameRun;->now_action:[B

    aget-byte v1, v0, p1

    sub-int/2addr v1, v3

    int-to-byte v1, v1

    aput-byte v1, v0, p1

    move v0, v3

    .line 5453
    :goto_0
    return v0

    :cond_0
    move v0, v4

    goto :goto_0
.end method

.method private setEnemyThrow()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 4170
    const/16 v0, 0x3f

    iput v0, p0, Lmain/GameRun;->enemyOff:I

    .line 4174
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->cThrow:[S

    sget v1, Lmain/Constants_H;->WIDTH:I

    const/16 v2, 0x179

    sub-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x14

    int-to-byte v1, v1

    aput-short v1, v0, v3

    .line 4175
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->cThrow:[S

    const/4 v1, 0x1

    const/16 v2, 0x3c

    aput-short v2, v0, v1

    .line 4176
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->cThrow:[S

    const/4 v1, 0x2

    aput-short v3, v0, v1

    .line 4177
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    invoke-direct {p0, v0, v1, v3}, Lmain/GameRun;->setThrow(Ldm/Battle;Ldm/Monster;I)V

    .line 4178
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 4179
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 4180
    return-void
.end method

.method private setEvolveStringB(Ldm/Monster;)V
    .locals 13
    .param p1, "monster"    # Ldm/Monster;

    .prologue
    const/4 v12, 0x5

    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 2966
    iget-object v3, p1, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v8

    add-int/lit8 v3, v3, 0x1

    int-to-byte v1, v3

    .line 2967
    .local v1, "eid":B
    iget-object v3, p1, Ldm/Monster;->monster:[B

    aget-byte v2, v3, v10

    .line 2968
    .local v2, "level":B
    const/4 v0, 0x0

    .line 2970
    .local v0, "b_e":Z
    iget-object v3, p0, Lmain/GameRun;->monsterMake:[[B

    iget-object v4, p1, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v8

    aget-object v3, v3, v4

    aget-byte v3, v3, v8

    if-lez v3, :cond_0

    const/4 v3, -0x2

    const/16 v4, 0x22

    invoke-virtual {p0, v3, v4, v9}, Lmain/GameRun;->findItem(IIZ)B

    move-result v3

    if-lez v3, :cond_0

    .line 2971
    iget-object v3, p0, Lmain/GameRun;->monsterMake:[[B

    iget-object v4, p1, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v8

    aget-object v3, v3, v4

    aget-byte v1, v3, v8

    .line 2972
    const/4 v0, 0x1

    .line 2975
    :cond_0
    const/4 v3, 0x0

    iput-object v3, p0, Lmain/GameRun;->proReplace:[[S

    .line 2976
    const/4 v3, 0x6

    filled-new-array {v9, v3}, [I

    move-result-object v3

    sget-object v4, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [[S

    iput-object v3, p0, Lmain/GameRun;->proReplace:[[S

    .line 2977
    iget-object v3, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v3, v3, v8

    iget-object v4, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v4, v4, v1

    aget-byte v4, v4, v8

    iget-object v5, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v5, v5, v1

    const/4 v6, 0x7

    aget-byte v5, v5, v6

    mul-int/2addr v5, v2

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    invoke-direct {p0, p1, v4}, Lmain/GameRun;->getbuffRateV(Ldm/Monster;I)S

    move-result v4

    iget-object v5, p1, Ldm/Monster;->monsterPro:[S

    aget-short v5, v5, v10

    sub-int/2addr v4, v5

    int-to-short v4, v4

    aput-short v4, v3, v8

    .line 2979
    iget-object v3, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v3, v3, v8

    iget-object v4, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v4, v4, v1

    aget-byte v4, v4, v9

    iget-object v5, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v5, v5, v1

    const/16 v6, 0x8

    aget-byte v5, v5, v6

    mul-int/2addr v5, v2

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    iget-object v5, p1, Ldm/Monster;->monsterPro:[S

    aget-short v5, v5, v11

    sub-int/2addr v4, v5

    int-to-short v4, v4

    aput-short v4, v3, v9

    .line 2980
    iget-object v3, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v3, v3, v8

    if-eqz v0, :cond_1

    iget-object v4, p1, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v12

    :goto_0
    neg-int v4, v4

    int-to-short v4, v4

    aput-short v4, v3, v10

    .line 2981
    iget-object v3, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v3, v3, v8

    iget-object v4, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v4, v4, v1

    aget-byte v4, v4, v11

    iget-object v5, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v5, v5, v1

    const/16 v6, 0xa

    aget-byte v5, v5, v6

    mul-int/2addr v5, v2

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    iget-object v5, p1, Ldm/Monster;->monsterPro:[S

    const/4 v6, 0x6

    aget-short v5, v5, v6

    sub-int/2addr v4, v5

    int-to-byte v4, v4

    aput-short v4, v3, v11

    .line 2982
    iget-object v3, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v3, v3, v8

    const/4 v4, 0x4

    iget-object v5, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v5, v5, v1

    const/4 v6, 0x4

    aget-byte v5, v5, v6

    iget-object v6, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v6, v6, v1

    const/16 v7, 0xb

    aget-byte v6, v6, v7

    mul-int/2addr v6, v2

    div-int/lit8 v6, v6, 0xa

    add-int/2addr v5, v6

    iget-object v6, p1, Ldm/Monster;->monsterPro:[S

    const/4 v7, 0x7

    aget-short v6, v6, v7

    sub-int/2addr v5, v6

    int-to-byte v5, v5

    aput-short v5, v3, v4

    .line 2983
    iget-object v3, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v3, v3, v8

    iget-object v4, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v4, v4, v1

    aget-byte v4, v4, v10

    iget-object v5, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v5, v5, v1

    const/16 v6, 0x9

    aget-byte v5, v5, v6

    mul-int/2addr v5, v2

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    iget-object v5, p1, Ldm/Monster;->monsterPro:[S

    aget-short v5, v5, v12

    sub-int/2addr v4, v5

    int-to-byte v4, v4

    aput-short v4, v3, v12

    .line 2984
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\u751f\u547d\uff1a+"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, v8

    aget-short v4, v4, v8

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2985
    const-string v4, "\u80fd\u91cf"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\uff1a+"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, v8

    aget-short v4, v4, v9

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2986
    const-string v4, "\u8fdb\u5316"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\uff1a"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, v8

    aget-short v4, v4, v10

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    sget v4, Lmain/Constants_H;->WIDTH:I

    .line 2984
    invoke-virtual {p0, v3, v4, v8}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2987
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "\u529b\u91cf\uff1a+"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, v8

    aget-short v4, v4, v11

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2988
    const-string v4, "\u9632\u5fa1"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\uff1a+"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, v8

    const/4 v5, 0x4

    aget-short v4, v4, v5

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 2989
    const-string v4, "\u654f\u6377"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\uff1a+"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, v8

    aget-short v4, v4, v12

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    sget v4, Lmain/Constants_H;->WIDTH:I

    .line 2987
    invoke-virtual {p0, v3, v4, v9}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2990
    const/4 v3, 0x0

    iput-object v3, p0, Lmain/GameRun;->proReplace:[[S

    .line 2991
    return-void

    :cond_1
    move v4, v9

    .line 2980
    goto/16 :goto_0
.end method

.method private setMyThrow()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4182
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->cThrow:[S

    const/16 v1, -0x11e

    aput-short v1, v0, v2

    .line 4183
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->cThrow:[S

    const/16 v1, 0x3c

    aput-short v1, v0, v3

    .line 4184
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->cThrow:[S

    const/4 v1, 0x2

    aput-short v2, v0, v1

    .line 4185
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    invoke-direct {p0, v0, v1, v3}, Lmain/GameRun;->setThrow(Ldm/Battle;Ldm/Monster;I)V

    .line 4186
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 4187
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 4188
    return-void
.end method

.method private setNidusPro(II)V
    .locals 9
    .param p1, "i"    # I
    .param p2, "level"    # I

    .prologue
    const/16 v8, 0xb

    const/4 v7, 0x4

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1422
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 1423
    .local v0, "sbuff":Ljava/lang/StringBuffer;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u751f\u547d\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v2, v2, p1

    aget-byte v2, v2, v5

    iget-object v3, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v3, v3, p1

    const/4 v4, 0x7

    aget-byte v3, v3, v4

    mul-int/2addr v3, p2

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1424
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u80fd\u91cf\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v2, v2, p1

    aget-byte v2, v2, v6

    iget-object v3, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v3, v3, p1

    const/16 v4, 0x8

    aget-byte v3, v3, v4

    mul-int/2addr v3, p2

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1425
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u8fdb\u5316\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v2, v2, p1

    const/16 v3, 0xc

    aget-byte v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1426
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v1, v2, v5}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 1427
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->length()I

    move-result v1

    invoke-virtual {v0, v5, v1}, Ljava/lang/StringBuffer;->delete(II)Ljava/lang/StringBuffer;

    .line 1428
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u529b\u91cf\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v2, v2, p1

    const/4 v3, 0x3

    aget-byte v2, v2, v3

    iget-object v3, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v3, v3, p1

    const/16 v4, 0xa

    aget-byte v3, v3, v4

    mul-int/2addr v3, p2

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1429
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u9632\u5fa1\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v2, v2, p1

    aget-byte v2, v2, v7

    iget-object v3, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v3, v3, p1

    aget-byte v3, v3, v8

    mul-int/2addr v3, p2

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1430
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u654f\u6377\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v2, v2, p1

    aget-byte v2, v2, v7

    iget-object v3, p0, Lmain/GameRun;->monster_pro:[[B

    aget-object v3, v3, p1

    aget-byte v3, v3, v8

    mul-int/2addr v3, p2

    div-int/lit8 v3, v3, 0xa

    add-int/2addr v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1431
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v1, v2, v6}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 1432
    const/4 v0, 0x0

    .line 1433
    return-void
.end method

.method private setNullBattle()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 4534
    iput-object v0, p0, Lmain/GameRun;->proReplace:[[S

    .line 4535
    iput-object v0, p0, Lmain/GameRun;->effectImage:[Ljavax/microedition/lcdui/Image;

    .line 4537
    iput-object v0, p0, Lmain/GameRun;->imgBattle:[Ljavax/microedition/lcdui/Image;

    .line 4539
    iput-object v0, p0, Lmain/GameRun;->levelUp_in_battle:[[B

    .line 4540
    iput-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    .line 4541
    iput-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    .line 4542
    return-void
.end method

.method private setPutMonster()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 2713
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v0, v1, v5

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    sub-int/2addr v1, v6

    if-lt v0, v1, :cond_1

    .line 2717
    iget-byte v0, p0, Lmain/GameRun;->myMon_length:B

    :goto_1
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    array-length v1, v1

    if-lt v0, v1, :cond_2

    .line 2719
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    sub-int/2addr v1, v6

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/GameRun;->myMon_length:B

    .line 2720
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    iget-byte v2, p0, Lmain/GameRun;->myMon_length:B

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v2, v1, v5

    sub-int/2addr v2, v6

    int-to-byte v2, v2

    aput-byte v2, v1, v5

    .line 2721
    :cond_0
    const/4 v1, 0x2

    iget-object v2, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    aget-byte v2, v2, v5

    invoke-virtual {p0, v1, v2, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 2722
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    invoke-direct {p0, v1}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    .line 2723
    sget v1, Lmain/Constants_H;->WIDTH_H:I

    iput v1, p0, Lmain/GameRun;->introT:I

    .line 2724
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    iput-byte v1, p0, Lmain/GameRun;->t_length:B

    .line 2725
    const/4 v1, -0x1

    iput-byte v1, p0, Lmain/GameRun;->popMenu:B

    .line 2726
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    iget-byte v3, p0, Lmain/GameRun;->t_length:B

    iget-byte v4, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v1, v2, v3, v4}, Ldm/Ms;->correctSelect([BII)V

    .line 2727
    return-void

    .line 2714
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    add-int/lit8 v3, v0, 0x1

    aget-object v2, v2, v3

    aput-object v2, v1, v0

    .line 2715
    iget-object v1, p0, Lmain/GameRun;->evolve:[Z

    iget-object v2, p0, Lmain/GameRun;->evolve:[Z

    add-int/lit8 v3, v0, 0x1

    aget-boolean v2, v2, v3

    aput-boolean v2, v1, v0

    .line 2713
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0

    .line 2718
    :cond_2
    iget-object v1, p0, Lmain/GameRun;->evolve:[Z

    aput-boolean v6, v1, v0

    .line 2717
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_1
.end method

.method private setRelive(Ldm/Battle;Ldm/Battle;)V
    .locals 5
    .param p1, "amB"    # Ldm/Battle;
    .param p2, "dmB"    # Ldm/Battle;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 5044
    invoke-virtual {p2}, Ldm/Battle;->initHit()V

    .line 5045
    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x2

    aget-short v0, v0, v1

    neg-int v0, v0

    iget-object v1, p0, Lmain/GameRun;->skill:[[B

    const/16 v2, 0x26

    aget-object v1, v1, v2

    aget-byte v1, v1, v3

    mul-int/2addr v0, v1

    div-int/lit8 v0, v0, 0x64

    invoke-virtual {p2, v0, v4, v4}, Ldm/Battle;->addHit(III)V

    .line 5046
    const/16 v0, 0x1c

    iput-byte v0, p2, Ldm/Battle;->skill:B

    .line 5047
    iput-byte v3, p2, Ldm/Battle;->dead:B

    .line 5048
    iput-byte v3, p2, Ldm/Battle;->action:B

    .line 5049
    iput-boolean v4, p2, Ldm/Battle;->b_renascence:Z

    .line 5050
    iput-byte v3, p2, Ldm/Battle;->act_num:B

    .line 5051
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 5052
    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Lmain/GameRun;->setMagic(I)V

    .line 5053
    invoke-virtual {p2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    invoke-virtual {p1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    invoke-direct {p0, p2, v0, v1}, Lmain/GameRun;->getHitCoefficient(Ldm/Battle;Ldm/Monster;Ldm/Monster;)V

    .line 5054
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    xor-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Lmain/GameRun;->setAimBattle(I)V

    .line 5055
    return-void
.end method

.method private setShowPro(Ldm/Monster;)V
    .locals 4
    .param p1, "monster"    # Ldm/Monster;

    .prologue
    .line 2789
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 2790
    .local v0, "sbuff":Ljava/lang/StringBuffer;
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p1, Ldm/Monster;->monsterPro:[S

    const/4 v3, 0x6

    aget-short v2, v2, v3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "#n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2791
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p1, Ldm/Monster;->monsterPro:[S

    const/4 v3, 0x7

    aget-short v2, v2, v3

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "#n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 2792
    iget-object v1, p1, Ldm/Monster;->monsterPro:[S

    const/4 v2, 0x5

    aget-short v1, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 2793
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    sget v2, Lmain/Constants_H;->WIDTH:I

    const/4 v3, 0x2

    invoke-virtual {p0, v1, v2, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2794
    const/4 v0, 0x0

    .line 2795
    return-void
.end method

.method private setTakenMonster()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 2752
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v0, v1, v5

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->cMon_count:B

    sub-int/2addr v1, v6

    if-lt v0, v1, :cond_2

    .line 2754
    iget-byte v1, p0, Lmain/GameRun;->cMon_count:B

    sub-int/2addr v1, v6

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/GameRun;->cMon_count:B

    .line 2755
    iget-byte v1, p0, Lmain/GameRun;->cMon_count:B

    iput-byte v1, p0, Lmain/GameRun;->t_length:B

    .line 2756
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    iget-byte v2, p0, Lmain/GameRun;->cMon_count:B

    if-ne v1, v2, :cond_0

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v2, v1, v5

    sub-int/2addr v2, v6

    int-to-byte v2, v2

    aput-byte v2, v1, v5

    .line 2757
    :cond_0
    iget-byte v1, p0, Lmain/GameRun;->t_length:B

    if-lez v1, :cond_1

    .line 2758
    const/4 v1, 0x2

    iget-object v2, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v3, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    aget-byte v2, v2, v5

    invoke-virtual {p0, v1, v2, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 2759
    iget-object v1, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    invoke-direct {p0, v1}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    .line 2761
    :cond_1
    sget v1, Lmain/Constants_H;->WIDTH_H:I

    iput v1, p0, Lmain/GameRun;->introT:I

    .line 2762
    const/4 v1, -0x1

    iput-byte v1, p0, Lmain/GameRun;->popMenu:B

    .line 2763
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    iget-byte v3, p0, Lmain/GameRun;->t_length:B

    iget-byte v4, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v1, v2, v3, v4}, Ldm/Ms;->correctSelect([BII)V

    .line 2764
    return-void

    .line 2753
    :cond_2
    iget-object v1, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    add-int/lit8 v3, v0, 0x1

    aget-object v2, v2, v3

    aput-object v2, v1, v0

    .line 2752
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method private setThrow(Ldm/Battle;Ldm/Monster;I)V
    .locals 6
    .param p1, "be"    # Ldm/Battle;
    .param p2, "mon"    # Ldm/Monster;
    .param p3, "mini"    # I

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 4190
    const/4 v0, -0x1

    iput-byte v0, p1, Ldm/Battle;->throw_state:B

    .line 4191
    const/4 v0, 0x2

    iget-object v1, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v2, p2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    aget-byte v1, v1, v3

    invoke-virtual {p0, v0, v1, p3}, Lmain/GameRun;->initMonStream(III)V

    .line 4192
    iget-object v0, p2, Ldm/Monster;->monster:[B

    aget-byte v0, v0, v5

    add-int/lit8 v0, v0, 0x2b

    invoke-virtual {p2, v0}, Ldm/Monster;->isMonReel(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 4193
    iget-byte v0, p1, Ldm/Battle;->bg_id:B

    iget-object v1, p2, Ldm/Monster;->monster:[B

    aget-byte v1, v1, v5

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    add-int/lit8 v1, p3, 0x2

    aput-byte v4, v0, v1

    .line 4195
    :cond_0
    :goto_0
    iput-byte v3, p1, Ldm/Battle;->action:B

    .line 4196
    iput-byte v3, p1, Ldm/Battle;->dead:B

    .line 4197
    iget-object v0, p2, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    iput-short v0, p1, Ldm/Battle;->chp:S

    .line 4198
    return-void

    .line 4194
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->monPro:[B

    array-length v0, v0

    if-eqz v0, :cond_0

    iget-byte v0, p1, Ldm/Battle;->bg_id:B

    iget-object v1, p0, Lmain/GameRun;->monPro:[B

    aget-byte v1, v1, v3

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    add-int/lit8 v1, p3, 0x2

    aput-byte v4, v0, v1

    goto :goto_0
.end method

.method private takenMonster()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 2742
    iget-byte v0, p0, Lmain/GameRun;->myMon_length:B

    iget-byte v1, p0, Lmain/GameRun;->max_takes:B

    if-ge v0, v1, :cond_0

    .line 2743
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    iget-object v2, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v4

    aget-byte v3, v3, v4

    aget-object v2, v2, v3

    aput-object v2, v0, v1

    .line 2744
    iget-object v0, p0, Lmain/GameRun;->evolve:[Z

    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    aput-boolean v5, v0, v1

    .line 2745
    iget-byte v0, p0, Lmain/GameRun;->myMon_length:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->myMon_length:B

    .line 2746
    invoke-direct {p0}, Lmain/GameRun;->setTakenMonster()V

    .line 2750
    :goto_0
    return-void

    .line 2748
    :cond_0
    const-string v0, "\u6240\u80fd\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\uff01"

    invoke-virtual {p0, v0, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private useItem()V
    .locals 6

    .prologue
    const/16 v5, 0x32

    const/16 v4, 0x64

    const/16 v3, 0x1e

    const/4 v2, 0x0

    .line 3805
    iget-object v0, p0, Lmain/GameRun;->items:[[[B

    aget-object v0, v0, v2

    iget-object v1, p0, Lmain/GameRun;->select_it:[B

    aget-byte v1, v1, v2

    aget-object v0, v0, v1

    aget-byte v0, v0, v2

    packed-switch v0, :pswitch_data_0

    .line 3843
    :goto_0
    :pswitch_0
    return-void

    .line 3807
    :pswitch_1
    invoke-direct {p0, v5}, Lmain/GameRun;->allAdd(I)V

    goto :goto_0

    .line 3810
    :pswitch_2
    invoke-direct {p0, v4}, Lmain/GameRun;->allAdd(I)V

    goto :goto_0

    .line 3813
    :pswitch_3
    const/4 v0, -0x1

    invoke-direct {p0, v0}, Lmain/GameRun;->resetFealty(I)V

    goto :goto_0

    .line 3816
    :pswitch_4
    invoke-direct {p0, v3}, Lmain/GameRun;->resetFealty(I)V

    goto :goto_0

    .line 3821
    :pswitch_5
    invoke-direct {p0, v3}, Lmain/GameRun;->resetMonster(I)V

    goto :goto_0

    .line 3824
    :pswitch_6
    invoke-direct {p0, v4}, Lmain/GameRun;->mpAdd(I)V

    goto :goto_0

    .line 3827
    :pswitch_7
    invoke-direct {p0, v5}, Lmain/GameRun;->mpAdd(I)V

    goto :goto_0

    .line 3830
    :pswitch_8
    invoke-direct {p0, v4, v2}, Lmain/GameRun;->hpAdd(II)V

    goto :goto_0

    .line 3833
    :pswitch_9
    const/16 v0, 0x23

    invoke-direct {p0, v0, v3}, Lmain/GameRun;->hpAdd(II)V

    goto :goto_0

    .line 3836
    :pswitch_a
    const/16 v0, 0x41

    invoke-direct {p0, v0, v3}, Lmain/GameRun;->hpAdd(II)V

    goto :goto_0

    .line 3839
    :pswitch_b
    invoke-direct {p0}, Lmain/GameRun;->changeEffect()V

    goto :goto_0

    .line 3805
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_9
        :pswitch_a
        :pswitch_8
        :pswitch_7
        :pswitch_6
        :pswitch_1
        :pswitch_2
        :pswitch_5
        :pswitch_b
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_3
    .end packed-switch
.end method

.method private useState(II)V
    .locals 5
    .param p1, "type"    # I
    .param p2, "id"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 3671
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->paint()V

    .line 3672
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/16 v1, 0xc8

    invoke-virtual {v0, v1}, Ldm/Ms;->sleep(I)V

    .line 3673
    iget-byte v0, p0, Lmain/GameRun;->view_state:B

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 3677
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v3, v0, Ldm/Battle;->act_num:B

    .line 3679
    invoke-direct {p0}, Lmain/GameRun;->goBattleState()V

    .line 3680
    const/16 v0, 0x9

    iput-byte v0, p0, Lmain/GameRun;->battle_state:B

    .line 3681
    const/4 v0, 0x2

    iget-object v1, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    aget-byte v1, v1, v3

    invoke-virtual {p0, v0, v1, v4}, Lmain/GameRun;->initMonStream(III)V

    .line 3686
    :goto_0
    iget-object v0, p0, Lmain/GameRun;->items:[[[B

    aget-object v0, v0, p1

    aget-object v0, v0, p2

    aget-byte v0, v0, v3

    invoke-virtual {p0, v0, v4}, Lmain/GameRun;->deleteItems(II)V

    .line 3687
    return-void

    .line 3684
    :cond_0
    invoke-direct {p0, p1}, Lmain/GameRun;->goMY_BAG(I)V

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized Success()V
    .locals 3

    .prologue
    .line 6267
    monitor-enter p0

    :try_start_0
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Lmain/SMSSender;->setSendSms(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 6270
    :try_start_1
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    sget-byte v1, Lmain/SMSSender;->smsType:B

    const/4 v2, 0x6

    if-ne v1, v2, :cond_0

    .line 6271
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    invoke-virtual {v1}, Lmain/SMSSender;->sendSuccess()V

    .line 6272
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Lmain/SMSSender;->setSendSms(I)V

    .line 6273
    const/16 v1, -0xa

    sput v1, Lmain/GameRun;->run_state:I

    .line 6274
    sget-object v1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v2, Lmain/GameRun;->run_state:I

    iput v2, v1, Lmain/MainCanvas;->temp_state:I

    .line 6275
    sget-object v1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 6276
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lmain/Map;->setRegState(Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 6290
    :goto_0
    monitor-exit p0

    return-void

    .line 6283
    :cond_0
    :try_start_2
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    invoke-virtual {v1}, Lmain/SMSSender;->sendSuccess()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 6286
    :catch_0
    move-exception v1

    move-object v0, v1

    .line 6288
    .local v0, "e":Ljava/lang/Exception;
    :try_start_3
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 6267
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public addItem(II)B
    .locals 8
    .param p1, "item_id"    # I
    .param p2, "count"    # I

    .prologue
    const/16 v7, 0x63

    const/4 v6, -0x1

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 3625
    invoke-virtual {p0, p1}, Lmain/GameRun;->findItemType(I)B

    move-result v1

    .local v1, "item_type":B
    invoke-virtual {p0, v1, p1, v4}, Lmain/GameRun;->findItem(IIZ)B

    move-result v0

    .line 3627
    .local v0, "item_no":B
    if-eq v0, v6, :cond_0

    .line 3629
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    aget-byte v3, v2, v5

    add-int/2addr v3, p2

    int-to-byte v3, v3

    aput-byte v3, v2, v5

    if-le v3, v7, :cond_1

    .line 3630
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    aput-byte v7, v2, v5

    .line 3631
    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lmain/GameRun;->items:[[[B

    aget-object v3, v3, v1

    aget-object v3, v3, v0

    aget-byte v3, v3, v4

    invoke-virtual {p0, v3}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "\u6570\u91cf\u5df2\u5230\u4e0a\u9650"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    move v2, v6

    .line 3647
    :goto_0
    return v2

    .line 3639
    :cond_0
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, v1

    iget-object v3, p0, Lmain/GameRun;->itemsLength:[B

    aget-byte v3, v3, v1

    aget-object v2, v2, v3

    int-to-byte v3, p1

    aput-byte v3, v2, v4

    .line 3640
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, v1

    iget-object v3, p0, Lmain/GameRun;->itemsLength:[B

    aget-byte v3, v3, v1

    aget-object v2, v2, v3

    int-to-byte v3, p2

    aput-byte v3, v2, v5

    .line 3641
    iget-object v2, p0, Lmain/GameRun;->itemsLength:[B

    aget-byte v3, v2, v1

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    aput-byte v3, v2, v1

    :cond_1
    move v2, v5

    .line 3647
    goto :goto_0
.end method

.method public addMonInfoListBH()V
    .locals 4

    .prologue
    const/16 v3, 0x67

    .line 3575
    iget-object v0, p0, Lmain/GameRun;->monInfoList:[B

    const/16 v1, 0x68

    aget-byte v2, v0, v1

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 3576
    iget-object v0, p0, Lmain/GameRun;->monInfoList:[B

    aget-byte v1, v0, v3

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    aput-byte v1, v0, v3

    .line 3578
    iget-object v0, p0, Lmain/GameRun;->monInfoList:[B

    aget-byte v0, v0, v3

    const/16 v1, 0x66

    if-ne v0, v1, :cond_0

    .line 3580
    const-string v0, "\u606d\u559c\u60a8\u628a\u6240\u6709\u7684\u5ba0\u7269\u90fd\u6536\u96c6\u9f50\u4e86"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 3581
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->paint()V

    .line 3582
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/16 v1, 0x258

    invoke-virtual {v0, v1}, Ldm/Ms;->sleep(I)V

    .line 3584
    :cond_0
    return-void
.end method

.method public battleType(I)V
    .locals 1
    .param p1, "mode"    # I

    .prologue
    .line 5547
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/GameRun;->battle_type:B

    return-void
.end method

.method public checkMonster()Z
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 6156
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    if-lt v0, v1, :cond_0

    .line 6161
    const-string v1, "\u60a8\u7684\u5ba0\u7269\u4e0d\u9700\u8981\u56de\u590d\uff01"

    invoke-virtual {p0, v1, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    move v1, v5

    .line 6162
    :goto_1
    return v1

    .line 6157
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v5

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    const/4 v3, 0x3

    aget-short v2, v2, v3

    if-lt v1, v2, :cond_1

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v4

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monsterPro:[S

    const/4 v3, 0x2

    aget-short v2, v2, v3

    if-ge v1, v2, :cond_2

    :cond_1
    move v1, v4

    .line 6158
    goto :goto_1

    .line 6156
    :cond_2
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method public data_init()V
    .locals 4

    .prologue
    .line 4065
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/data.d"

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 4066
    .local v0, "data":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v1, 0x0

    sput v1, Ldm/Ms;->skip:I

    .line 4067
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->skill_up:[[B

    .line 4068
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->monster_pro:[[B

    .line 4069
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->skill:[[B

    .line 4070
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->skill_help:[Ljava/lang/StringBuffer;

    .line 4071
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->skill_name:[Ljava/lang/StringBuffer;

    .line 4072
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->monsterT:[Ljava/lang/StringBuffer;

    .line 4073
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->NAME:[Ljava/lang/StringBuffer;

    .line 4074
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->item_help:[Ljava/lang/StringBuffer;

    .line 4075
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->item_name:[Ljava/lang/StringBuffer;

    .line 4076
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->city_name:[Ljava/lang/StringBuffer;

    .line 4077
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->buff_name:[Ljava/lang/StringBuffer;

    .line 4078
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->buff_help:[Ljava/lang/StringBuffer;

    .line 4079
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->monAppearMap:[[B

    .line 4080
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->mList_id:[[B

    .line 4081
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->monsterMake:[[B

    .line 4082
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createStringArray([B)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->monsterInfo:[Ljava/lang/StringBuffer;

    .line 4083
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createArray([B)[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->inhesion:[B

    .line 4084
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createArray([B)[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->makeLevel:[B

    .line 4085
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createArray([B)[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->musicNo:[B

    .line 4087
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createArray([B)[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->npc2ImageType:[B

    .line 4088
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v2

    iput-object v2, v1, Lmain/Map;->boatCourse:[[B

    .line 4089
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->nidusList:[[B

    .line 4091
    const/4 v0, 0x0

    check-cast v0, [B

    .line 4101
    return-void
.end method

.method public delMonster(I)B
    .locals 4
    .param p1, "no"    # I

    .prologue
    const/4 v2, -0x1

    const/4 v3, 0x0

    .line 3455
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, p1

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aget-byte v0, v1, v3

    .line 3456
    .local v0, "id":B
    invoke-direct {p0, p1}, Lmain/GameRun;->monsterRemove(I)B

    move-result v1

    if-eq v1, v2, :cond_0

    .line 3457
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u5931\u53bb\u5ba0\u7269\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 3458
    const/4 v1, 0x1

    .line 3461
    :goto_0
    return v1

    .line 3460
    :cond_0
    const-string v1, "\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01"

    invoke-virtual {p0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    move v1, v2

    .line 3461
    goto :goto_0
.end method

.method public deleteItems(II)V
    .locals 5
    .param p1, "item_id"    # I
    .param p2, "count"    # I

    .prologue
    const/4 v4, 0x1

    .line 3651
    invoke-virtual {p0, p1}, Lmain/GameRun;->findItemType(I)B

    move-result v1

    .local v1, "item_type":B
    const/4 v2, 0x0

    invoke-virtual {p0, v1, p1, v2}, Lmain/GameRun;->findItem(IIZ)B

    move-result v0

    .line 3652
    .local v0, "item_no":B
    const/4 v2, -0x1

    if-eq v0, v2, :cond_1

    .line 3653
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    aget-byte v2, v2, v4

    if-lt v2, p2, :cond_0

    .line 3654
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    aget-byte v3, v2, v4

    sub-int/2addr v3, p2

    int-to-byte v3, v3

    aput-byte v3, v2, v4

    .line 3655
    :cond_0
    iget-object v2, p0, Lmain/GameRun;->items:[[[B

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    aget-byte v2, v2, v4

    if-nez v2, :cond_1

    .line 3656
    invoke-direct {p0, v1, v0}, Lmain/GameRun;->dItemIn(II)V

    .line 3658
    :cond_1
    return-void
.end method

.method public doPaint(I)V
    .locals 1
    .param p1, "mode"    # I

    .prologue
    .line 183
    if-eqz p1, :cond_0

    .line 184
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/GameRun;->b_c:B

    .line 187
    :goto_0
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->paint()V

    .line 188
    return-void

    .line 186
    :cond_0
    const/16 v0, -0xa

    sput v0, Lmain/GameRun;->run_state:I

    goto :goto_0
.end method

.method public doSayOverSms()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 3951
    iget-byte v0, p0, Lmain/GameRun;->sayOverSms:B

    .line 3952
    .local v0, "temp":I
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "doSayOverSms() sayOverSms= "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v3, p0, Lmain/GameRun;->sayOverSms:B

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 3953
    const/4 v1, -0x1

    iput-byte v1, p0, Lmain/GameRun;->sayOverSms:B

    .line 3954
    if-nez v0, :cond_1

    .line 3956
    sput-boolean v4, Lmain/GameRun;->isSay:Z

    .line 3957
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    const/4 v2, 0x4

    invoke-virtual {v1, v2, v4}, Lmain/SMSSender;->go(IZ)V

    .line 3958
    const/4 v1, 0x0

    sput-boolean v1, Lmain/GameRun;->isSay:Z

    .line 3962
    :cond_0
    :goto_0
    return-void

    .line 3959
    :cond_1
    if-ne v0, v4, :cond_0

    .line 3960
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    const/4 v2, 0x3

    invoke-virtual {v1, v2, v4}, Lmain/SMSSender;->go(IZ)V

    goto :goto_0
.end method

.method public drawCartoonOne(IIIIIZI)Z
    .locals 6
    .param p1, "i"    # I
    .param p2, "skill_mode"    # I
    .param p3, "select"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I
    .param p6, "mode"    # Z
    .param p7, "dir"    # I

    .prologue
    const/4 v4, 0x0

    .line 5436
    iget-object v0, p0, Lmain/GameRun;->now_action:[B

    aget-byte v0, v0, p1

    iget-object v1, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v1, v1, p2

    invoke-virtual {v1, p3}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 5438
    iget-object v0, p0, Lmain/GameRun;->now_action:[B

    aput-byte v4, v0, p1

    .line 5440
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v1, v1, p2

    iget-object v2, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v2, v2, p2

    iget-object v3, p0, Lmain/GameRun;->now_action:[B

    aget-byte v3, v3, p1

    invoke-virtual {v2, p3, v3, v4}, Ldm/Sprite;->action(III)I

    move-result v2

    move v3, p4

    move v4, p5

    move v5, p7

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    .line 5441
    invoke-direct {p0, p1, p2, p3, p6}, Lmain/GameRun;->setCartoonFrame_C(IIIZ)Z

    move-result v0

    return v0
.end method

.method public drawChangeMap(ZIIII)V
    .locals 17
    .param p1, "bb"    # Z
    .param p2, "t_c"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "w"    # I

    .prologue
    .line 5831
    const/16 v9, 0x280

    .local v9, "WIDTH":I
    const/16 v10, 0x168

    .line 5832
    .local v10, "HEIGHT":I
    mul-int/lit8 p2, p2, 0x2

    .line 5833
    if-eqz p1, :cond_0

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const v6, 0x52bdef

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->fillRect(IIIII)V

    .line 5834
    :cond_0
    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 5835
    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v6, p4, 0x1

    const/4 v7, 0x5

    move-object v0, v5

    move/from16 v1, p3

    move v2, v6

    move/from16 v3, p5

    move v4, v7

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 5836
    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v6, p3, 0x1

    const/4 v7, 0x2

    sub-int v7, p5, v7

    const/4 v8, 0x7

    move-object v0, v5

    move v1, v6

    move/from16 v2, p4

    move v3, v7

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 5837
    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const v6, 0xeafcff

    invoke-virtual {v5, v6}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 5838
    const/4 v5, 0x4

    sub-int v5, p5, v5

    mul-int v5, v5, p2

    div-int/lit8 v5, v5, 0x3c

    move v0, v5

    move/from16 v1, p5

    if-le v0, v1, :cond_2

    .line 5840
    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v6, p3, 0x2

    add-int/lit8 v7, p4, 0x1

    const/4 v8, 0x5

    move-object v0, v5

    move v1, v6

    move v2, v7

    move/from16 v3, p5

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 5841
    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v6, p3, 0x1

    add-int/lit8 v7, p4, 0x2

    const/4 v8, 0x3

    move-object v0, v5

    move v1, v6

    move v2, v7

    move/from16 v3, p5

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 5850
    .end local v9    # "WIDTH":I
    :goto_0
    if-eqz p1, :cond_1

    sget-object v5, Lmain/Map;->npcSp:[[Ldm/Sprite;

    const/4 v6, 0x1

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-object v5, v5, v6

    iget-object v5, v5, Ldm/Sprite;->img:Ljavax/microedition/lcdui/Image;

    if-eqz v5, :cond_1

    .line 5853
    const/4 v5, 0x4

    sub-int v5, p5, v5

    mul-int v5, v5, p2

    div-int/lit8 v5, v5, 0x3c

    move v0, v5

    move/from16 v1, p5

    if-le v0, v1, :cond_3

    .line 5854
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    move-object v11, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    move-object v5, v0

    iget-object v12, v5, Lmain/Map;->my:Ldm/Npc;

    const/4 v13, 0x0

    add-int/lit8 v15, p4, 0xa

    const/16 v16, 0x5

    move/from16 v14, p5

    invoke-virtual/range {v11 .. v16}, Lmain/Map;->drawMyAni(Ldm/Npc;IIII)V

    .line 5858
    :cond_1
    :goto_1
    return-void

    .line 5845
    .restart local v9    # "WIDTH":I
    :cond_2
    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v6, p3, 0x2

    add-int/lit8 v7, p4, 0x1

    const/4 v8, 0x4

    sub-int v8, p5, v8

    mul-int v8, v8, p2

    div-int/lit8 v8, v8, 0x3c

    const/4 v9, 0x5

    invoke-virtual {v5, v6, v7, v8, v9}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 5846
    .end local v9    # "WIDTH":I
    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    add-int/lit8 v6, p3, 0x1

    add-int/lit8 v7, p4, 0x2

    const/4 v8, 0x2

    sub-int v8, p5, v8

    mul-int v8, v8, p2

    div-int/lit8 v8, v8, 0x3c

    const/4 v9, 0x3

    invoke-virtual {v5, v6, v7, v8, v9}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    goto :goto_0

    .line 5856
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    move-object v11, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    move-object v5, v0

    iget-object v12, v5, Lmain/Map;->my:Ldm/Npc;

    const/4 v13, 0x0

    const/4 v5, 0x4

    sub-int v5, p5, v5

    mul-int v5, v5, p2

    div-int/lit8 v5, v5, 0x3c

    add-int v14, p3, v5

    add-int/lit8 v15, p4, 0xa

    const/16 v16, 0x5

    invoke-virtual/range {v11 .. v16}, Lmain/Map;->drawMyAni(Ldm/Npc;IIII)V

    goto :goto_1
.end method

.method public drawCityName()V
    .locals 9

    .prologue
    const/4 v5, 0x0

    .line 4030
    const/16 v7, 0x19

    .line 4031
    .local v7, "FONT_H":I
    sget v0, Lmain/Constants_H;->WIDTH__:I

    div-int/lit8 v2, v0, 0x2

    .line 4032
    .local v2, "WIDTH_H":I
    iget-byte v0, p0, Lmain/GameRun;->cityName_c:B

    const/16 v1, -0x14

    if-ne v0, v1, :cond_0

    .line 4037
    :goto_0
    return-void

    .line 4033
    :cond_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->city_name:[Ljava/lang/StringBuffer;

    iget-object v3, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v3, v3, Lmain/Map;->mapNo:B

    aget-object v1, v1, v3

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v0

    add-int/lit8 v0, v0, 0x8

    int-to-short v8, v0

    .line 4034
    .local v8, "w":S
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    shr-int/lit8 v1, v8, 0x1

    sub-int v1, v2, v1

    iget-byte v3, p0, Lmain/GameRun;->cityName_c:B

    if-lez v3, :cond_1

    move v3, v5

    :goto_1
    add-int/lit8 v4, v7, 0x6

    invoke-virtual {v0, v1, v3, v8, v4}, Ldm/Ui;->drawKuang(IIII)V

    .line 4035
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->city_name:[Ljava/lang/StringBuffer;

    iget-object v3, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v3, v3, Lmain/Map;->mapNo:B

    aget-object v1, v1, v3

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    iget-byte v3, p0, Lmain/GameRun;->cityName_c:B

    if-lez v3, :cond_2

    move v3, v5

    :goto_2
    const/16 v4, 0x11

    const/4 v5, 0x4

    const/4 v6, 0x2

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 4036
    iget-byte v0, p0, Lmain/GameRun;->cityName_c:B

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->cityName_c:B

    goto :goto_0

    .line 4034
    :cond_1
    iget-byte v3, p0, Lmain/GameRun;->cityName_c:B

    goto :goto_1

    .line 4035
    :cond_2
    iget-byte v3, p0, Lmain/GameRun;->cityName_c:B

    goto :goto_2
.end method

.method public drawEvolveUI(IIZ)V
    .locals 27
    .param p1, "mode"    # I
    .param p2, "id"    # I
    .param p3, "bb"    # Z

    .prologue
    .line 2368
    const/16 v23, 0x280

    .local v23, "WIDTH":I
    const/16 v21, 0x168

    .line 2369
    .local v21, "HEIGHT":I
    const/16 v24, 0x140

    .local v24, "WIDTH_H":I
    const/16 v22, 0xb4

    .line 2370
    .local v22, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ui;->fillRectB()V

    .line 2372
    const/16 v7, 0xc8

    .local v7, "lx":S
    const/16 v8, 0x6c

    .local v8, "ly":S
    const/16 v25, 0x0

    .line 2373
    .local v25, "magicType":S
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->bg_c:B

    move v6, v0

    const/4 v9, 0x5

    const/16 v10, 0xe6

    move-object/from16 v5, p0

    invoke-direct/range {v5 .. v10}, Lmain/GameRun;->drawBG0(IIIII)V

    .line 2387
    const/4 v5, 0x1

    move/from16 v0, p1

    move v1, v5

    if-ne v0, v1, :cond_4

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    if-lez v5, :cond_4

    .line 2388
    const/4 v10, 0x5

    .line 2389
    .end local v25    # "magicType":S
    .local v10, "magicType":S
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_3

    .line 2390
    const/4 v5, 0x5

    if-ne v10, v5, :cond_2

    const/4 v5, 0x6

    move v12, v5

    :goto_0
    const/16 v13, 0x179

    const/16 v14, 0x61

    const/4 v15, 0x0

    move-object/from16 v9, p0

    move v11, v10

    .line 2389
    invoke-virtual/range {v9 .. v15}, Lmain/GameRun;->drawMagicC(IIIIII)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 2391
    const/4 v5, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v9, v0

    aget-object v9, v9, p2

    iget-object v9, v9, Ldm/Monster;->monster:[B

    const/4 v11, 0x0

    aget-byte v9, v9, v11

    aget-object v6, v6, v9

    const/4 v9, 0x0

    aget-byte v6, v6, v9

    const/4 v9, 0x1

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v9

    invoke-virtual {v0, v1, v2, v3}, Lmain/GameRun;->initMonStream(III)V

    .line 2392
    const/4 v5, 0x2

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->b_c:B

    .line 2404
    :cond_0
    :goto_1
    const/4 v5, 0x1

    move/from16 v0, p1

    move v1, v5

    if-ne v0, v1, :cond_5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_5

    .line 2410
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v5, v0

    aget-object v5, v5, p2

    iget-object v5, v5, Ldm/Monster;->monster:[B

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    add-int/lit8 v6, v7, 0x19

    add-int/lit8 v9, v8, 0x19

    add-int/lit8 v9, v9, 0x16

    const/16 v10, 0x1c

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v9

    move v4, v10

    invoke-direct {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawEvolveMake(IIII)V

    .line 2441
    .end local v10    # "magicType":S
    :goto_2
    if-nez p1, :cond_8

    .line 2442
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/GameRun;->move_y:S

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/GameRun;->move_x:S

    .line 2444
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    new-instance v5, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v6, v0

    aget-object v6, v6, p2

    iget-object v6, v6, Ldm/Monster;->monster:[B

    const/4 v9, 0x0

    aget-byte v6, v6, v9

    move-object/from16 v0, p0

    move v1, v6

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, "\u5347\u5230\u4e86"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v6, v0

    aget-object v6, v6, p2

    iget-object v6, v6, Ldm/Monster;->monster:[B

    const/4 v9, 0x2

    aget-byte v6, v6, v9

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\u7ea7"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 2445
    const/16 v13, 0x1b0

    add-int/lit8 v14, v8, 0x4

    sget-object v5, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v5, 0x8

    sget-object v6, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v15, v5, 0x10

    const/16 v16, 0x1

    const/16 v17, 0x0

    .line 2444
    invoke-virtual/range {v11 .. v17}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2453
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->imgItem:[Ljavax/microedition/lcdui/Image;

    move-object v6, v0

    const/4 v9, 0x1

    aget-object v6, v6, v9

    move-object/from16 v0, p0

    iget v0, v0, Lmain/GameRun;->say_s:I

    move v9, v0

    sub-int/2addr v7, v9

    const/4 v9, 0x4

    sub-int/2addr v8, v9

    const/16 v9, 0x24

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 2455
    .end local v7    # "lx":S
    .end local v8    # "ly":S
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->levelUp_in_battle:[[B

    move-object v5, v0

    if-eqz p3, :cond_6

    move/from16 v6, p2

    :goto_3
    aget-object v5, v5, v6

    const/4 v6, 0x1

    aget-byte v5, v5, v6

    const/4 v6, -0x1

    if-eq v5, v6, :cond_1

    .line 2461
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\u4e60\u5f97\u6280\u80fd\uff1a"

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->levelUp_in_battle:[[B

    move-object v6, v0

    if-eqz p3, :cond_7

    move/from16 v7, p2

    :goto_4
    aget-object v6, v6, v7

    const/4 v7, 0x1

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    move v1, v6

    invoke-direct {v0, v1}, Lmain/GameRun;->getNameSkill(B)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    const/16 v5, 0x3c

    sub-int v14, v21, v5

    const/16 v15, 0x11

    const/16 v16, 0x9

    const/16 v17, 0x0

    move/from16 v13, v24

    invoke-virtual/range {v11 .. v17}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2500
    :cond_1
    :goto_5
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 2501
    return-void

    .line 2390
    .restart local v7    # "lx":S
    .restart local v8    # "ly":S
    .restart local v10    # "magicType":S
    :cond_2
    const/4 v5, 0x1

    move v12, v5

    goto/16 :goto_0

    .line 2393
    :cond_3
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v6, 0x1

    if-le v5, v6, :cond_0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/16 v6, 0xe

    if-ge v5, v6, :cond_0

    .line 2394
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v6, v0

    aget-object v6, v6, p2

    iget-object v6, v6, Ldm/Monster;->monster:[B

    const/4 v9, 0x0

    aget-byte v6, v6, v9

    aget-object v5, v5, v6

    const/4 v6, 0x1

    aget-byte v12, v5, v6

    .line 2395
    const/4 v13, 0x1

    const/16 v14, 0x179

    const/16 v15, 0x61

    const/16 v16, 0x50

    const/16 v17, 0x4d

    const/16 v18, 0xf

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    const/4 v6, 0x2

    sub-int v19, v5, v6

    const/16 v20, 0x0

    move-object/from16 v11, p0

    .line 2394
    invoke-direct/range {v11 .. v20}, Lmain/GameRun;->drawClipPic(IIIIIIIII)V

    .line 2396
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    move v5, v0

    add-int/lit8 v5, v5, 0x1

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->b_c:B

    const/16 v6, 0xe

    if-ne v5, v6, :cond_0

    .line 2397
    const/4 v5, -0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->b_c:B

    .line 2398
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\u8fdb\u5316\u6210  "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v6, v0

    aget-object v6, v6, p2

    iget-object v6, v6, Ldm/Monster;->monster:[B

    const/4 v9, 0x0

    aget-byte v6, v6, v9

    move-object/from16 v0, p0

    move v1, v6

    invoke-virtual {v0, v1}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    move-object/from16 v0, p0

    move-object v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_1

    .line 2401
    .end local v10    # "magicType":S
    .restart local v25    # "magicType":S
    :cond_4
    const/4 v12, 0x1

    const/4 v13, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->mList_id:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v6, v0

    aget-object v6, v6, p2

    iget-object v6, v6, Ldm/Monster;->monster:[B

    const/4 v9, 0x0

    aget-byte v6, v6, v9

    aget-object v5, v5, v6

    const/4 v6, 0x1

    aget-byte v5, v5, v6

    mul-int/lit8 v14, v5, 0x3

    .line 2402
    const/16 v5, 0x179

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/GameRun;->move_x:S

    move v6, v0

    sub-int v15, v5, v6

    const/16 v5, 0x61

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/GameRun;->move_y:S

    move v6, v0

    sub-int v16, v5, v6

    const/16 v17, 0x1

    const/16 v18, 0x0

    move-object/from16 v11, p0

    .line 2401
    invoke-virtual/range {v11 .. v18}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    move/from16 v10, v25

    .end local v25    # "magicType":S
    .restart local v10    # "magicType":S
    goto/16 :goto_1

    .line 2422
    :cond_5
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->about_b:[Ljava/lang/StringBuffer;

    move-object v12, v0

    add-int/lit8 v5, v7, 0x19

    const/16 v6, 0x10

    sub-int v13, v5, v6

    add-int/lit8 v5, v8, 0x19

    add-int/lit8 v14, v5, 0x16

    const/4 v15, 0x0

    const/16 v16, 0x3

    const/16 v17, 0x28

    const/16 v18, 0x3

    const/16 v19, 0x0

    invoke-virtual/range {v11 .. v19}, Ldm/Ui;->drawStringY([Ljava/lang/Object;IIIIIII)V

    .line 2435
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    move-object v12, v0

    add-int/lit8 v5, v7, 0x7d

    const/4 v6, 0x3

    sub-int v13, v5, v6

    add-int/lit8 v5, v8, 0x19

    add-int/lit8 v14, v5, 0x16

    const/4 v15, 0x0

    const/16 v16, 0x3

    const/16 v17, 0x28

    const/16 v18, 0x3

    const/16 v19, 0x0

    invoke-virtual/range {v11 .. v19}, Ldm/Ui;->drawStringY([Ljava/lang/Object;IIIIIII)V

    goto/16 :goto_2

    .line 2455
    .end local v7    # "lx":S
    .end local v8    # "ly":S
    .end local v10    # "magicType":S
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v6, v0

    aget-object v6, v6, p2

    iget-object v6, v6, Ldm/Monster;->monster:[B

    const/4 v7, 0x1

    aget-byte v6, v6, v7

    goto/16 :goto_3

    .line 2461
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    move-object v7, v0

    aget-object v7, v7, p2

    iget-object v7, v7, Ldm/Monster;->monster:[B

    const/4 v8, 0x1

    aget-byte v7, v7, v8

    goto/16 :goto_4

    .line 2463
    .restart local v7    # "lx":S
    .restart local v8    # "ly":S
    :cond_8
    const/4 v5, 0x1

    move/from16 v0, p1

    move v1, v5

    if-ne v0, v1, :cond_1

    .line 2475
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    if-nez v5, :cond_a

    const/16 v5, -0x7f

    :goto_6
    add-int v12, v24, v5

    .line 2476
    add-int/lit8 v13, v8, 0x6

    const/16 v14, 0x71

    const/16 v15, 0x1b

    const/16 v16, 0x4

    .line 2475
    invoke-virtual/range {v11 .. v16}, Ldm/Ui;->drawK1(IIIII)V

    .line 2477
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    const-string v12, "\u57fa\u672c\u5c5e\u6027"

    const/16 v5, 0x4b

    sub-int v5, v24, v5

    add-int/lit8 v13, v5, 0x4

    add-int/lit8 v14, v8, 0x5

    const/16 v15, 0x11

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    if-nez v5, :cond_b

    const/4 v5, 0x0

    move/from16 v16, v5

    :goto_7
    const/16 v17, 0x0

    invoke-virtual/range {v11 .. v17}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2478
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    const-string v12, "\u8fdb\u5316\u7d20\u6750"

    add-int/lit8 v5, v24, 0x4b

    const/4 v6, 0x4

    sub-int v13, v5, v6

    add-int/lit8 v14, v8, 0x5

    const/16 v15, 0x11

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/GameRun;->popMenu:B

    move v5, v0

    if-nez v5, :cond_c

    const/4 v5, 0x1

    move/from16 v16, v5

    :goto_8
    const/16 v17, 0x0

    invoke-virtual/range {v11 .. v17}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2486
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    move-object v11, v0

    const/4 v12, 0x2

    const/4 v13, 0x0

    add-int/lit8 v14, v8, 0x5

    const/16 v16, 0x21

    move/from16 v15, v24

    invoke-virtual/range {v11 .. v16}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v26

    .line 2487
    .local v26, "t":B
    const/4 v5, -0x1

    move/from16 v0, v26

    move v1, v5

    if-eq v0, v1, :cond_9

    move/from16 v0, v26

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/GameRun;->popMenu:B

    .line 2494
    :cond_9
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    add-int/lit8 v13, v8, 0xf

    const/16 v14, 0x96

    const/4 v15, 0x1

    const/16 v16, 0x1

    move/from16 v12, v24

    invoke-virtual/range {v11 .. v16}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 2496
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/GameRun;->move_x:S

    move v6, v0

    const/4 v7, 0x3

    const/4 v8, 0x0

    invoke-virtual {v5, v6, v7, v8}, Ldm/Ms;->mathSpeedDown(IIZ)S

    .end local v7    # "lx":S
    .end local v8    # "ly":S
    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/GameRun;->move_x:S

    .line 2497
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/GameRun;->move_y:S

    move v6, v0

    const/4 v7, 0x3

    const/4 v8, 0x0

    invoke-virtual {v5, v6, v7, v8}, Ldm/Ms;->mathSpeedDown(IIZ)S

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/GameRun;->move_y:S

    .line 2498
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    const-string v12, "\u786e\u5b9a\u8fdb\u5316\u8be5\u5ba0\u7269\uff1f"

    const/16 v5, 0x19

    sub-int v5, v21, v5

    const/16 v6, 0x16

    sub-int v14, v5, v6

    const/16 v15, 0x11

    const/16 v16, 0x0

    const/16 v17, 0x1

    move/from16 v13, v24

    invoke-virtual/range {v11 .. v17}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto/16 :goto_5

    .line 2475
    .end local v26    # "t":B
    .restart local v7    # "lx":S
    .restart local v8    # "ly":S
    :cond_a
    const/16 v5, 0xf

    goto/16 :goto_6

    .line 2477
    :cond_b
    const/4 v5, 0x1

    move/from16 v16, v5

    goto/16 :goto_7

    .line 2478
    :cond_c
    const/4 v5, 0x0

    move/from16 v16, v5

    goto/16 :goto_8
.end method

.method public drawFealty(IIII)V
    .locals 7
    .param p1, "length"    # I
    .param p2, "n"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I

    .prologue
    const/4 v4, 0x0

    .line 3000
    const/4 v6, 0x0

    .local v6, "i":B
    :goto_0
    if-lt v6, p1, :cond_0

    .line 3006
    return-void

    .line 3004
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    if-le v6, p2, :cond_1

    const/16 v1, 0x16

    :goto_1
    mul-int/lit8 v2, v6, 0xe

    add-int/2addr v2, p3

    move v3, p4

    move v5, v4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 3000
    add-int/lit8 v0, v6, 0x1

    int-to-byte v6, v0

    goto :goto_0

    .line 3004
    :cond_1
    const/16 v1, 0x15

    goto :goto_1
.end method

.method public drawItem(IIII)V
    .locals 11
    .param p1, "action"    # I
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "anchor"    # I

    .prologue
    const/16 v2, 0x3a

    const/16 v1, 0x23

    const/4 v9, 0x0

    .line 1117
    if-lt p1, v2, :cond_1

    iget-object v0, p0, Lmain/GameRun;->monster_pro:[[B

    iget-object v1, p0, Lmain/GameRun;->nidusList:[[B

    aget-object v1, v1, v9

    sub-int v2, p1, v2

    aget-byte v1, v1, v2

    aget-object v0, v0, v1

    const/4 v1, 0x6

    aget-byte v0, v0, v1

    add-int/lit8 p1, v0, 0x28

    .line 1126
    :cond_0
    :goto_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->item_img:Ljavax/microedition/lcdui/Image;

    iget-object v2, p0, Lmain/GameRun;->item_modules:[[B

    aget-object v2, v2, p1

    aget-byte v2, v2, v9

    iget-object v3, p0, Lmain/GameRun;->item_modules:[[B

    aget-object v3, v3, p1

    const/4 v4, 0x1

    aget-byte v3, v3, v4

    .line 1127
    iget-object v4, p0, Lmain/GameRun;->item_modules:[[B

    aget-object v4, v4, p1

    const/4 v5, 0x2

    aget-byte v4, v4, v5

    iget-object v5, p0, Lmain/GameRun;->item_modules:[[B

    aget-object v5, v5, p1

    const/4 v6, 0x3

    aget-byte v5, v5, v6

    sget-object v10, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    move v6, p2

    move v7, p3

    move v8, p4

    .line 1126
    invoke-virtual/range {v0 .. v10}, Ldm/Ui;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIIILjavax/microedition/lcdui/Graphics;)V

    .line 1129
    return-void

    .line 1118
    :cond_1
    if-lt p1, v1, :cond_0

    iget-object v0, p0, Lmain/GameRun;->makeLevel:[B

    sub-int v1, p1, v1

    aget-byte v0, v0, v1

    add-int/lit8 p1, v0, 0x22

    goto :goto_0
.end method

.method public drawMagicC(IIIIII)Z
    .locals 7
    .param p1, "i"    # I
    .param p2, "skill_mode"    # I
    .param p3, "select"    # I
    .param p4, "x"    # I
    .param p5, "y"    # I
    .param p6, "dir"    # I

    .prologue
    const/4 v4, 0x2

    const/4 v6, 0x1

    const/4 v3, 0x0

    .line 5384
    iget-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    aget-short v0, v0, p1

    iget-object v1, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    aget-object v1, v1, p2

    invoke-virtual {v1, p3}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 5385
    iget-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    aput-short v3, v0, p1

    move v0, v6

    .line 5410
    :goto_0
    return v0

    .line 5389
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    aget-object v0, v0, p2

    iget-object v1, p0, Lmain/GameRun;->now_action_Magic:[S

    aget-short v1, v1, p1

    invoke-virtual {v0, p3, v1, v3}, Ldm/Sprite;->action(III)I

    move-result v0

    int-to-short v2, v0

    .line 5392
    .local v2, "frame_id":S
    :goto_1
    iget-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    if-eqz v0, :cond_1

    if-lt v2, v4, :cond_2

    .line 5408
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    aget-object v1, v1, p2

    move v3, p4

    move v4, p5

    move v5, p6

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    .line 5410
    invoke-direct {p0, p1, p2, p3, v6}, Lmain/GameRun;->setCartoonFrameMagic_C(IIIZ)Z

    move-result v0

    goto :goto_0

    .line 5393
    :cond_2
    if-nez v2, :cond_3

    .line 5394
    iget-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->ceff:[B

    aput-byte v4, v0, v3

    .line 5398
    :cond_3
    iget-object v0, p0, Lmain/GameRun;->now_time_Magic:[S

    aput-short v3, v0, p1

    .line 5399
    iget-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    aget-short v1, v0, p1

    add-int/lit8 v1, v1, 0x1

    int-to-short v1, v1

    aput-short v1, v0, p1

    iget-object v0, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    aget-object v0, v0, p2

    invoke-virtual {v0, p3}, Ldm/Sprite;->aLength(I)I

    move-result v0

    if-lt v1, v0, :cond_4

    .line 5400
    iget-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    aput-short v3, v0, p1

    move v0, v6

    .line 5401
    goto :goto_0

    .line 5404
    :cond_4
    iget-object v0, p0, Lmain/GameRun;->magic:[Ldm/Sprite;

    aget-object v0, v0, p2

    iget-object v1, p0, Lmain/GameRun;->now_action_Magic:[S

    aget-short v1, v1, p1

    invoke-virtual {v0, p3, v1, v3}, Ldm/Sprite;->action(III)I

    move-result v0

    int-to-short v2, v0

    goto :goto_1
.end method

.method public drawMoney(IIIZ)V
    .locals 8
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "c"    # I
    .param p4, "bb"    # Z

    .prologue
    const/4 v6, 0x1

    .line 1058
    new-instance v0, Ljava/lang/StringBuilder;

    if-eqz p4, :cond_0

    iget v1, p0, Lmain/GameRun;->coin:I

    :goto_0
    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz p4, :cond_1

    const-string v1, "\u5fbd\u7ae0"

    :goto_1
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 1059
    .local v7, "s":Ljava/lang/String;
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    if-eqz p4, :cond_2

    const/16 v1, 0x35

    :goto_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2, v7}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v2

    shr-int/lit8 v2, v2, 0x1

    sub-int v2, p1, v2

    sub-int/2addr v2, v6

    sget-object v3, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    const/16 v3, 0x8

    sget-object v4, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v4, v3, 0x20

    const/4 v5, 0x0

    move v3, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 1063
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int/lit8 v3, p2, 0x3

    sget-object v1, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    sget-object v1, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    or-int/lit8 v4, v6, 0x20

    move-object v1, v7

    move v2, p1

    move v5, p3

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1065
    const/4 v7, 0x0

    .line 1066
    return-void

    .line 1058
    .end local v7    # "s":Ljava/lang/String;
    :cond_0
    iget v1, p0, Lmain/GameRun;->money:I

    goto :goto_0

    :cond_1
    const-string v1, "\u91d1"

    goto :goto_1

    .line 1059
    .restart local v7    # "s":Ljava/lang/String;
    :cond_2
    const/16 v1, 0x34

    goto :goto_2
.end method

.method public drawMyMon()V
    .locals 14

    .prologue
    const/16 v13, 0xf1

    const/16 v12, 0x32

    const/4 v11, 0x2

    const/4 v1, 0x1

    const/4 v10, 0x0

    .line 5269
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    const/16 v2, 0xdc

    const/16 v3, 0xa4

    invoke-direct {p0, v0, v2, v3}, Lmain/GameRun;->drawEffectImage(Ldm/Monster;II)V

    .line 5273
    iget-object v0, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v10

    aget-object v0, v0, v2

    aget-byte v0, v0, v1

    mul-int/lit8 v0, v0, 0x3

    iget-object v2, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v2, v2, Ldm/Battle;->action:B

    add-int v3, v0, v2

    .line 5274
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->ceff:[B

    aget-byte v0, v0, v10

    if-eqz v0, :cond_1

    const/4 v0, -0x3

    :goto_0
    add-int/lit16 v4, v0, 0x10a

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->ceff:[B

    aget-byte v0, v0, v10

    if-eqz v0, :cond_2

    const/4 v0, 0x3

    :goto_1
    add-int/lit16 v5, v0, 0xec

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v0, v0, Ldm/Battle;->action:B

    if-nez v0, :cond_3

    move v6, v1

    :goto_2
    move-object v0, p0

    move v2, v1

    move v7, v1

    .line 5273
    invoke-virtual/range {v0 .. v7}, Lmain/GameRun;->drawCartoonOne(IIIIIZI)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 5275
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v10

    if-ge v0, v1, :cond_4

    .line 5276
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v11, v0, Ldm/Battle;->action:B

    .line 5277
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v1, v0, Ldm/Battle;->dead:B

    .line 5280
    :cond_0
    :goto_3
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v0, v0, Ldm/Battle;->ceff:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v3, v3, Ldm/Battle;->ceff:[B

    aget-byte v3, v3, v10

    invoke-virtual {v2, v3, v10, v1, v1}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v2

    int-to-byte v2, v2

    aput-byte v2, v0, v10

    .line 5281
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    const/16 v5, 0xed

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-short v9, v0, Ldm/Battle;->chp:S

    move-object v2, p0

    move v4, v13

    move v6, v12

    move v7, v10

    move v8, v1

    invoke-direct/range {v2 .. v9}, Lmain/GameRun;->drawMonsterHp(Ldm/Monster;IIIIII)V

    .line 5282
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    const/16 v5, 0xf2

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v0}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v0

    iget-object v0, v0, Ldm/Monster;->monsterPro:[S

    aget-short v9, v0, v1

    move-object v2, p0

    move v4, v13

    move v6, v12

    move v7, v1

    move v8, v11

    invoke-direct/range {v2 .. v9}, Lmain/GameRun;->drawMonsterHp(Ldm/Monster;IIIIII)V

    .line 5283
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-short v3, v3, Ldm/Battle;->chp:S

    iget-object v4, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v4}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v4

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aget-short v4, v4, v10

    .line 5284
    iget-object v5, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-short v5, v5, Ldm/Battle;->chp:S

    iget-object v6, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v6}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v6

    iget-object v6, v6, Ldm/Monster;->monsterPro:[S

    aget-short v6, v6, v10

    if-ge v5, v6, :cond_5

    const/16 v5, 0x14

    .line 5283
    :goto_4
    invoke-virtual {v2, v3, v4, v5, v1}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v1

    iput-short v1, v0, Ldm/Battle;->chp:S

    .line 5285
    return-void

    :cond_1
    move v0, v10

    .line 5274
    goto/16 :goto_0

    :cond_2
    move v0, v10

    goto/16 :goto_1

    :cond_3
    move v6, v10

    goto/16 :goto_2

    .line 5278
    :cond_4
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v10, v0, Ldm/Battle;->action:B

    goto :goto_3

    .line 5284
    :cond_5
    const/4 v5, 0x6

    goto :goto_4
.end method

.method public drawPauseIco(I)V
    .locals 8
    .param p1, "state"    # I

    .prologue
    const/4 v7, 0x6

    const/4 v6, 0x0

    .line 5876
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->b_ico:B

    if-lt v0, v1, :cond_0

    .line 5881
    return-void

    .line 5879
    :cond_0
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->imgIco:[Ljavax/microedition/lcdui/Image;

    aget-object v2, v2, v0

    iget-object v3, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v3, v3, Lmain/PointerKey;->button_pos:[[[I

    aget-object v3, v3, v7

    aget-object v3, v3, v0

    aget v3, v3, v6

    iget-object v4, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v4, v4, Lmain/PointerKey;->button_pos:[[[I

    aget-object v4, v4, v7

    aget-object v4, v4, v0

    const/4 v5, 0x1

    aget v4, v4, v5

    invoke-virtual {v1, v2, v3, v4, v6}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 5876
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method public exitNidus()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 1417
    const/16 v0, -0xa

    sput v0, Lmain/GameRun;->run_state:I

    .line 1418
    iget-object v0, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    const/4 v1, 0x0

    aput-object v1, v0, v2

    .line 1419
    invoke-virtual {p0, v2}, Lmain/GameRun;->initNidusMap(I)V

    .line 1420
    return-void
.end method

.method public falselly(I)V
    .locals 4
    .param p1, "id"    # I

    .prologue
    const/4 v3, 0x1

    .line 6293
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v1, v2}, Lmain/SMSSender;->setSendSms(I)V

    .line 6297
    const/4 v1, 0x7

    if-ne p1, v1, :cond_1

    .line 6298
    :try_start_0
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    const/4 v2, 0x1

    iput-boolean v2, v1, Lmain/SMSSender;->sms_a:Z

    .line 6299
    invoke-virtual {p0}, Lmain/GameRun;->goGameOver()V

    .line 6300
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "ccccccccc"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 6301
    sget-object v1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 6329
    :cond_0
    :goto_0
    return-void

    .line 6302
    :cond_1
    const/4 v1, 0x5

    if-ne p1, v1, :cond_2

    .line 6304
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    invoke-virtual {v1}, Lmain/SMSSender;->getTstate()I

    move-result v1

    sput v1, Lmain/GameRun;->run_state:I

    .line 6305
    sget-object v1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v2, Lmain/GameRun;->run_state:I

    iput v2, v1, Lmain/MainCanvas;->temp_state:I

    .line 6306
    sget-object v1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 6325
    :catch_0
    move-exception v1

    move-object v0, v1

    .line 6327
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 6308
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_2
    const/4 v1, 0x6

    if-ne p1, v1, :cond_3

    .line 6309
    const/16 v1, -0xa

    :try_start_1
    sput v1, Lmain/GameRun;->run_state:I

    .line 6312
    sget-object v1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v2, Lmain/GameRun;->run_state:I

    iput v2, v1, Lmain/MainCanvas;->temp_state:I

    .line 6313
    sget-object v1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 6314
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "  \u6211\u7684mc.setSmsIsSetRun_state(true);"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 6315
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lmain/Map;->setRegState(Z)V

    goto :goto_0

    .line 6316
    :cond_3
    if-ne p1, v3, :cond_0

    .line 6317
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    invoke-virtual {v1}, Lmain/SMSSender;->getSmsSenderMenuState()B

    move-result v1

    if-eqz v1, :cond_0

    .line 6319
    const-string v1, "soars"

    const-string v2, "soooooooooooooooooooooooooooooooooooooooo"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 6320
    sget-object v1, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 6321
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    invoke-virtual {v1}, Lmain/SMSSender;->getTstate()I

    move-result v1

    sput v1, Lmain/GameRun;->run_state:I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method public findItem(IIZ)B
    .locals 3
    .param p1, "item_type"    # I
    .param p2, "item_id"    # I
    .param p3, "bb"    # Z

    .prologue
    const/4 v2, 0x0

    .line 3605
    const/4 v0, 0x0

    .line 3606
    .local v0, "i":B
    const/4 v1, -0x2

    if-ne p1, v1, :cond_0

    invoke-virtual {p0, p2}, Lmain/GameRun;->findItemType(I)B

    move-result p1

    .line 3607
    :cond_0
    :goto_0
    iget-object v1, p0, Lmain/GameRun;->itemsLength:[B

    aget-byte v1, v1, p1

    if-lt v0, v1, :cond_1

    .line 3611
    if-eqz p3, :cond_4

    move v1, v2

    :goto_1
    int-to-byte v1, v1

    :goto_2
    return v1

    .line 3608
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    aget-object v1, v1, p1

    aget-object v1, v1, v0

    aget-byte v1, v1, v2

    if-ne v1, p2, :cond_3

    .line 3609
    if-eqz p3, :cond_2

    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    aget-object v1, v1, p1

    aget-object v1, v1, v0

    const/4 v2, 0x1

    aget-byte v1, v1, v2

    goto :goto_2

    :cond_2
    move v1, v0

    goto :goto_2

    .line 3607
    :cond_3
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0

    .line 3611
    :cond_4
    const/4 v1, -0x1

    goto :goto_1
.end method

.method public findItemType(I)B
    .locals 1
    .param p1, "item_id"    # I

    .prologue
    .line 3588
    const/16 v0, 0x10

    if-ge p1, v0, :cond_0

    const/4 v0, 0x0

    .line 3592
    :goto_0
    return v0

    .line 3589
    :cond_0
    const/16 v0, 0x23

    if-ge p1, v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    .line 3591
    :cond_1
    const/16 v0, 0x3a

    if-ge p1, v0, :cond_2

    const/4 v0, 0x2

    goto :goto_0

    .line 3592
    :cond_2
    const/4 v0, 0x3

    goto :goto_0
.end method

.method public findMonster(II)B
    .locals 3
    .param p1, "id"    # I
    .param p2, "lv"    # I

    .prologue
    .line 3501
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    if-lt v0, v1, :cond_0

    .line 3506
    const/4 v1, -0x1

    :goto_1
    return v1

    .line 3502
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    if-ne v1, p1, :cond_1

    .line 3503
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x2

    aget-byte v1, v1, v2

    if-lt v1, p2, :cond_1

    move v1, v0

    .line 3504
    goto :goto_1

    .line 3501
    :cond_1
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method public findMonsterMinLv(II)B
    .locals 7
    .param p1, "id"    # I
    .param p2, "lv"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v5, -0x1

    const/4 v4, 0x2

    .line 3510
    const/4 v1, -0x1

    .line 3511
    .local v1, "minLv":B
    iget-byte v2, p0, Lmain/GameRun;->myMon_length:B

    sub-int/2addr v2, v6

    int-to-byte v0, v2

    .local v0, "i":B
    :goto_0
    if-gt v0, v5, :cond_0

    .line 3518
    return v1

    .line 3512
    :cond_0
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    if-ne v2, p1, :cond_2

    .line 3513
    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v4

    if-lt v2, p2, :cond_2

    .line 3514
    if-eq v1, v5, :cond_1

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v4

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v1

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v4

    if-ge v2, v3, :cond_2

    .line 3515
    :cond_1
    move v1, v0

    .line 3511
    :cond_2
    sub-int v2, v0, v6

    int-to-byte v0, v2

    goto :goto_0
.end method

.method public gameCheckRegIsOK()Z
    .locals 4

    .prologue
    .line 6243
    iget-object v1, p0, Lmain/GameRun;->rmsSms:[B

    const/4 v2, 0x6

    aget-byte v1, v1, v2

    const/16 v2, 0xa

    if-ne v1, v2, :cond_0

    const/4 v1, 0x1

    move v0, v1

    .line 6244
    .local v0, "reged":Z
    :goto_0
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "gameCheckRegIsOK reged= "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 6245
    return v0

    .line 6243
    .end local v0    # "reged":Z
    :cond_0
    const/4 v1, 0x0

    move v0, v1

    goto :goto_0
.end method

.method public getEnemy([BII)V
    .locals 5
    .param p1, "enemy_list"    # [B
    .param p2, "type"    # I
    .param p3, "level"    # I

    .prologue
    const/4 v4, 0x6

    const/4 v3, 0x3

    const/4 v2, 0x1

    .line 5585
    const/4 v0, -0x1

    if-ne p2, v0, :cond_2

    .line 5586
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v0, 0x64

    invoke-static {v0}, Ldm/Ms;->getRandom(I)I

    move-result v0

    const/4 v1, 0x5

    if-ge v0, v1, :cond_0

    iget-object v0, p0, Lmain/GameRun;->monPro:[B

    array-length v0, v0

    if-le v0, v4, :cond_0

    const/4 p2, 0x6

    .line 5588
    :goto_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v0, p0, Lmain/GameRun;->monPro:[B

    const/4 v1, 0x2

    aget-byte v0, v0, v1

    add-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Ldm/Ms;->getRandom(I)I

    move-result v0

    iget-object v1, p0, Lmain/GameRun;->monPro:[B

    aget-byte v1, v1, v2

    add-int/2addr v0, v1

    int-to-byte v0, v0

    aput-byte v0, p1, v2

    .line 5593
    :goto_1
    const/4 v0, 0x0

    int-to-byte v1, p2

    aput-byte v1, p1, v0

    .line 5597
    return-void

    .line 5587
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->monPro:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v1, p0, Lmain/GameRun;->monPro:[B

    array-length v1, v1

    if-le v1, v4, :cond_1

    move v1, v3

    :goto_2
    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    add-int/lit8 v1, v1, 0x3

    aget-byte p2, v0, v1

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lmain/GameRun;->monPro:[B

    array-length v1, v1

    sub-int/2addr v1, v3

    goto :goto_2

    .line 5590
    :cond_2
    int-to-byte v0, p3

    aput-byte v0, p1, v2

    goto :goto_1
.end method

.method public getItem(II)B
    .locals 3
    .param p1, "item_id"    # I
    .param p2, "count"    # I

    .prologue
    const/4 v2, 0x1

    .line 3616
    invoke-virtual {p0, p1, p2}, Lmain/GameRun;->addItem(II)B

    move-result v0

    if-ne v0, v2, :cond_0

    .line 3617
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "\u83b7\u5f97\uff1a\u201c"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    int-to-byte v1, p1

    invoke-virtual {p0, v1}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\u201dx"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    move v0, v2

    .line 3621
    :goto_0
    return v0

    :cond_0
    const/4 v0, -0x1

    goto :goto_0
.end method

.method public getItemCount(I)B
    .locals 4
    .param p1, "id"    # I

    .prologue
    const/4 v3, 0x0

    .line 691
    iget-byte v1, p0, Lmain/GameRun;->buyItemID:B

    const/4 v2, 0x2

    if-eq v1, v2, :cond_0

    .line 692
    invoke-virtual {p0, p1}, Lmain/GameRun;->findItemType(I)B

    .line 693
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    iget-byte v2, p0, Lmain/GameRun;->item_type:B

    aget-object v1, v1, v2

    array-length v1, v1

    if-lt v0, v1, :cond_1

    .end local v0    # "i":I
    :cond_0
    move v1, v3

    .line 699
    :goto_1
    return v1

    .line 694
    .restart local v0    # "i":I
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    iget-byte v2, p0, Lmain/GameRun;->item_type:B

    aget-object v1, v1, v2

    aget-object v1, v1, v0

    aget-byte v1, v1, v3

    if-ne v1, p1, :cond_2

    .line 695
    iget-object v1, p0, Lmain/GameRun;->items:[[[B

    iget-byte v2, p0, Lmain/GameRun;->item_type:B

    aget-object v1, v1, v2

    aget-object v1, v1, v0

    const/4 v2, 0x1

    aget-byte v1, v1, v2

    goto :goto_1

    .line 693
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public getMagic(Ldm/Monster;)V
    .locals 8
    .param p1, "monster"    # Ldm/Monster;

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, -0x1

    .line 5777
    const/4 v2, 0x6

    new-array v1, v2, [B

    const/4 v2, 0x1

    const/4 v3, 0x7

    aput-byte v3, v1, v2

    const/16 v2, 0xe

    aput-byte v2, v1, v6

    const/16 v2, 0x15

    aput-byte v2, v1, v7

    const/4 v2, 0x4

    const/16 v3, 0x1c

    aput-byte v3, v1, v2

    const/4 v2, 0x5

    const/16 v3, 0x23

    aput-byte v3, v1, v2

    .line 5778
    .local v1, "level":[B
    iput-byte v5, p0, Lmain/GameRun;->getSkill:B

    .line 5779
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    array-length v2, v1

    if-lt v0, v2, :cond_0

    .line 5785
    return-void

    .line 5780
    :cond_0
    iget-object v2, p1, Ldm/Monster;->monster:[B

    add-int/lit8 v3, v0, 0x8

    aget-byte v2, v2, v3

    if-ne v2, v5, :cond_1

    iget-object v2, p1, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v6

    aget-byte v3, v1, v0

    if-lt v2, v3, :cond_1

    .line 5781
    iget-object v2, p1, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v7

    invoke-direct {p0, v0, v2}, Lmain/GameRun;->getSkill(II)V

    .line 5782
    iget-object v2, p1, Ldm/Monster;->monster:[B

    add-int/lit8 v3, v0, 0x8

    iget-byte v4, p0, Lmain/GameRun;->getSkill:B

    aput-byte v4, v2, v3

    .line 5779
    :cond_1
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    goto :goto_0
.end method

.method public getMonster(IIII)B
    .locals 5
    .param p1, "id"    # I
    .param p2, "level"    # I
    .param p3, "evolve"    # I
    .param p4, "buff"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 3525
    new-instance v0, Ldm/Monster;

    invoke-direct {v0, p0, p1, p2, p4}, Ldm/Monster;-><init>(Lmain/GameRun;III)V

    .line 3526
    .local v0, "enemyMB":Ldm/Monster;
    iget-byte v1, p0, Lmain/GameRun;->cMon_count:B

    iget-byte v2, p0, Lmain/GameRun;->max_monsters:B

    if-ne v1, v2, :cond_0

    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    iget-byte v2, p0, Lmain/GameRun;->max_takes:B

    if-ne v1, v2, :cond_0

    .line 3527
    const-string v1, "\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1"

    invoke-virtual {p0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 3528
    const/4 v1, -0x1

    .line 3536
    :goto_0
    return v1

    .line 3531
    :cond_0
    invoke-direct {p0, v0, p3, v4}, Lmain/GameRun;->getMonster(Ldm/Monster;IZ)B

    move-result v1

    if-eq v1, v4, :cond_1

    .line 3532
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u83b7\u5f97\u5ba0\u7269\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    int-to-byte v2, p1

    invoke-virtual {p0, v2}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 3535
    :goto_1
    const/4 v0, 0x0

    move v1, v4

    .line 3536
    goto :goto_0

    .line 3534
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u643a\u5e26\u5df2\u6ee1\uff0c"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, v0, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v3

    invoke-virtual {p0, v2}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\u5df2\u8f6c\u5165\u5bc4\u653e\u5904"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_1
.end method

.method public getNameCity(I)Ljava/lang/String;
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 3908
    iget-object v0, p0, Lmain/GameRun;->city_name:[Ljava/lang/StringBuffer;

    aget-object v0, v0, p1

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getNameItem(I)Ljava/lang/String;
    .locals 1
    .param p1, "item_id"    # I

    .prologue
    .line 3907
    iget-object v0, p0, Lmain/GameRun;->item_name:[Ljava/lang/StringBuffer;

    aget-object v0, v0, p1

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getNameMon(I)Ljava/lang/String;
    .locals 1
    .param p1, "mon_id"    # I

    .prologue
    .line 3909
    iget-object v0, p0, Lmain/GameRun;->NAME:[Ljava/lang/StringBuffer;

    aget-object v0, v0, p1

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getNameMonsterInfo(I)Ljava/lang/String;
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 3906
    iget-object v0, p0, Lmain/GameRun;->monsterInfo:[Ljava/lang/StringBuffer;

    aget-object v0, v0, p1

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public goBUY_ITEM(II)V
    .locals 7
    .param p1, "id"    # I
    .param p2, "mode"    # I

    .prologue
    const/4 v1, 0x3

    const/4 v6, 0x2

    const/4 v5, -0x1

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 708
    if-eq p2, v4, :cond_0

    new-array v1, v1, [Ljava/lang/String;

    const-string v2, "\u9053\u5177"

    aput-object v2, v1, v3

    const-string v2, "\u77ff\u77f3"

    aput-object v2, v1, v4

    const-string v2, "\u5fbd\u7ae0"

    aput-object v2, v1, v6

    invoke-virtual {p0, v1}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    .line 710
    :goto_0
    int-to-byte v1, p1

    iput-byte v1, p0, Lmain/GameRun;->cur_a:B

    .line 711
    int-to-byte v1, p2

    iput-byte v1, p0, Lmain/GameRun;->cur_b:B

    .line 712
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v3

    aput-byte v3, v2, v3

    aput-byte v3, v1, v4

    .line 713
    const/16 v1, 0x12

    sput v1, Lmain/GameRun;->run_state:I

    .line 721
    const/4 v1, 0x6

    iput-byte v1, p0, Lmain/GameRun;->list_rows:B

    .line 723
    iput-byte v3, p0, Lmain/GameRun;->buyOk:B

    .line 724
    iput-byte v5, p0, Lmain/GameRun;->popMenu:B

    .line 725
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/shop.d"

    invoke-virtual {v1, v2, v5}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 726
    .local v0, "data":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v3, Ldm/Ms;->skip:I

    .line 727
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->buyItem:[[B

    .line 728
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0, v3}, Ldm/Ms;->createShort2Array([BI)[[S

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->buyPrice:[[S

    .line 729
    const/4 v0, 0x0

    check-cast v0, [B

    .line 730
    return-void

    .line 709
    .end local v0    # "data":[B
    :cond_0
    new-array v1, v1, [Ljava/lang/String;

    const-string v2, "\u9053\u5177"

    aput-object v2, v1, v3

    const-string v2, "\u8f85\u52a9"

    aput-object v2, v1, v4

    const-string v2, "\u5377\u8f74"

    aput-object v2, v1, v6

    invoke-virtual {p0, v1}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    goto :goto_0
.end method

.method public goBattle()V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v3, 0x0

    const/4 v6, 0x7

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 5614
    iput-byte v4, p0, Lmain/GameRun;->first_battle:B

    .line 5615
    iput-byte v4, p0, Lmain/GameRun;->lastSkill:B

    .line 5616
    iput-byte v4, p0, Lmain/GameRun;->b_c:B

    .line 5617
    iput-byte v4, p0, Lmain/GameRun;->cur_a:B

    .line 5618
    iput-object v3, p0, Lmain/GameRun;->mon_in_battle:[B

    .line 5619
    iget-byte v1, p0, Lmain/GameRun;->max_takes:B

    add-int/lit8 v1, v1, 0x1

    new-array v1, v1, [B

    iput-object v1, p0, Lmain/GameRun;->mon_in_battle:[B

    .line 5620
    iput-object v3, p0, Lmain/GameRun;->levelUp_in_battle:[[B

    .line 5621
    iget-byte v1, p0, Lmain/GameRun;->max_takes:B

    filled-new-array {v1, v7}, [I

    move-result-object v1

    sget-object v2, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v2, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [[B

    iput-object v1, p0, Lmain/GameRun;->levelUp_in_battle:[[B

    .line 5622
    iput-object v3, p0, Lmain/GameRun;->proReplace:[[S

    .line 5623
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    array-length v1, v1

    filled-new-array {v1, v6}, [I

    move-result-object v1

    sget-object v2, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {v2, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [[S

    iput-object v1, p0, Lmain/GameRun;->proReplace:[[S

    .line 5624
    new-instance v1, Ldm/Battle;

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    invoke-direct {v1, v2}, Ldm/Battle;-><init>([Ldm/Monster;)V

    iput-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    .line 5625
    invoke-direct {p0}, Lmain/GameRun;->enemy_init()V

    .line 5626
    const/4 v0, 0x0

    .line 5627
    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    if-lt v0, v1, :cond_3

    .line 5633
    const/4 v0, 0x0

    :goto_1
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    if-lt v0, v1, :cond_4

    .line 5640
    :cond_0
    :goto_2
    iget-object v1, p0, Lmain/GameRun;->effectImage:[Ljavax/microedition/lcdui/Image;

    if-nez v1, :cond_1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/brow/e"

    invoke-virtual {v1, v6, v2}, Ldm/Ms;->createImageArray(ILjava/lang/String;)[Ljavax/microedition/lcdui/Image;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->effectImage:[Ljavax/microedition/lcdui/Image;

    .line 5642
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->imgBattle:[Ljavax/microedition/lcdui/Image;

    if-nez v1, :cond_2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/4 v2, 0x5

    const-string v3, "data/battle/b"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->createImageArray(ILjava/lang/String;)[Ljavax/microedition/lcdui/Image;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->imgBattle:[Ljavax/microedition/lcdui/Image;

    .line 5644
    :cond_2
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    const/16 v2, 0xf

    iput-byte v2, v1, Ldm/Npc;->state:B

    .line 5645
    const/16 v1, -0x1e

    sput v1, Lmain/GameRun;->run_state:I

    .line 5646
    const/4 v1, -0x1

    iput-byte v1, p0, Lmain/GameRun;->view_state:B

    .line 5647
    new-instance v1, Lmain/CreateThread;

    invoke-direct {v1, p0, v5}, Lmain/CreateThread;-><init>(Lmain/GameRun;I)V

    .line 5648
    return-void

    .line 5628
    :cond_3
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iput-byte v6, v1, Ldm/Monster;->effect:B

    .line 5629
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iput-byte v4, v1, Ldm/Monster;->effect_time:B

    .line 5630
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monster:[B

    aput-byte v0, v1, v5

    .line 5631
    iget-object v1, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v1, v1, v0

    const/4 v2, 0x6

    iget-object v3, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v0

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v7

    aput-short v3, v1, v2

    .line 5627
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0

    .line 5634
    :cond_4
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v4

    if-lez v1, :cond_5

    .line 5635
    iget-object v1, p0, Lmain/GameRun;->mon_in_battle:[B

    iget-object v2, p0, Lmain/GameRun;->mon_in_battle:[B

    aget-byte v3, v2, v4

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    aput-byte v3, v2, v4

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v5

    aput-byte v2, v1, v3

    .line 5636
    if-eqz v0, :cond_0

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v4

    invoke-direct {p0, v1, v2}, Lmain/GameRun;->changeMonster(Ldm/Monster;Ldm/Monster;)V

    goto/16 :goto_2

    .line 5633
    :cond_5
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto/16 :goto_1
.end method

.method public goBattlePVC()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 5515
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/GameRun;->enemyList:[[B

    .line 5516
    const/4 v0, 0x2

    filled-new-array {v3, v0}, [I

    move-result-object v0

    sget-object v1, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v1, v0}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [[B

    iput-object v0, p0, Lmain/GameRun;->enemyList:[[B

    .line 5517
    iget-object v0, p0, Lmain/GameRun;->enemyList:[[B

    aget-object v0, v0, v2

    const/4 v1, -0x1

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->getEnemy([BII)V

    .line 5518
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Ldm/Sound;->setMusicId(I)V

    .line 5519
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, v3}, Ldm/Sound;->setMusic(Z)V

    .line 5520
    invoke-virtual {p0}, Lmain/GameRun;->goBattle()V

    .line 5522
    return-void
.end method

.method public goGameOver()V
    .locals 1

    .prologue
    .line 4544
    const/16 v0, 0x3c

    sput v0, Lmain/GameRun;->run_state:I

    .line 4545
    return-void
.end method

.method public goMAIN_MENU()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 154
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/16 v1, 0x1d

    iput v1, v0, Lmain/MainCanvas;->logo_c:I

    .line 155
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    iput-object v2, v0, Lmain/MainCanvas;->image_logo:Ljavax/microedition/lcdui/Image;

    .line 156
    invoke-virtual {p0, v4}, Lmain/GameRun;->setNull(Z)V

    .line 158
    iput-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    .line 159
    iput-object v2, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    .line 160
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 167
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->createFlashImage()V

    .line 171
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->goMain_menu()V

    .line 174
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "\u8bfb\u53d6\u8fdb\u5ea6"

    aput-object v1, v0, v3

    const-string v1, "\u65b0\u6e38\u620f"

    aput-object v1, v0, v4

    const/4 v1, 0x2

    const-string v2, "\u58f0\u97f3"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "\u6e38\u620f\u5e2e\u52a9"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "\u5173   \u4e8e"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "\u9000\u51fa\u6e38\u620f"

    aput-object v2, v0, v1

    invoke-virtual {p0, v0}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    .line 180
    iget-object v0, p0, Lmain/GameRun;->rmsOther:[B

    aget-byte v0, v0, v3

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    move v0, v4

    :goto_0
    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->selecty:B

    iput-byte v0, p0, Lmain/GameRun;->selectx:B

    .line 181
    return-void

    :cond_0
    move v0, v3

    .line 180
    goto :goto_0
.end method

.method public goNidus(I)V
    .locals 3
    .param p1, "pop"    # I

    .prologue
    .line 1301
    const/16 v0, 0x42

    sput v0, Lmain/GameRun;->run_state:I

    .line 1302
    const/16 v0, 0x10

    iput-byte v0, p0, Lmain/GameRun;->mini_state:B

    .line 1303
    const-string v0, "\u67e5\u770b\u5b75\u5316#n\u9009\u62e9\u86cb#n\u79bb\u5f00"

    sget v1, Lmain/Constants_H;->WIDTH:I

    const/4 v2, 0x3

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 1304
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 1305
    const/4 v0, -0x2

    iput-byte v0, p0, Lmain/GameRun;->b_c:B

    .line 1306
    return-void
.end method

.method public goVIEW_COMPUTER(I)V
    .locals 3
    .param p1, "pop"    # I

    .prologue
    .line 1286
    const/16 v0, 0x41

    sput v0, Lmain/GameRun;->run_state:I

    .line 1287
    const-string v0, "\u5b58\u653e#n\u53d6\u51fa#n\u79bb\u5f00"

    sget v1, Lmain/Constants_H;->WIDTH:I

    const/4 v2, 0x3

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 1288
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 1289
    return-void
.end method

.method public goVIEW_MONSTER()V
    .locals 5

    .prologue
    const/4 v2, 0x6

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 2767
    const/16 v0, 0x23

    sput v0, Lmain/GameRun;->run_state:I

    .line 2768
    iput-byte v3, p0, Lmain/GameRun;->cur_c:B

    iput-byte v3, p0, Lmain/GameRun;->selecty:B

    iput-byte v3, p0, Lmain/GameRun;->selectx:B

    .line 2769
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-ne v0, v2, :cond_1

    iget-byte v0, p0, Lmain/GameRun;->cMon_count:B

    :goto_0
    iput-byte v0, p0, Lmain/GameRun;->t_length:B

    .line 2770
    iget-object v0, p0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v3

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aput-byte v3, v1, v4

    aput-byte v3, v0, v3

    .line 2771
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 2775
    const/4 v0, 0x5

    iput-byte v0, p0, Lmain/GameRun;->list_rows:B

    .line 2779
    iput-byte v3, p0, Lmain/GameRun;->mon_action:B

    .line 2780
    const-string v0, "\u751f\u547d#n\u80fd\u91cf#n\u6863\u6b21"

    sget v1, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v0, v1, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2781
    const-string v0, "\u529b\u91cf#n\u9632\u5fa1#n\u654f\u6377"

    sget v1, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {p0, v0, v1, v4}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2782
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-ne v0, v2, :cond_2

    iget-object v0, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    :goto_1
    iput-object v0, p0, Lmain/GameRun;->cur_mon:Ldm/Monster;

    .line 2783
    iget-byte v0, p0, Lmain/GameRun;->t_length:B

    if-eqz v0, :cond_0

    .line 2784
    iget-object v0, p0, Lmain/GameRun;->cur_mon:Ldm/Monster;

    invoke-direct {p0, v0}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    .line 2785
    const/4 v0, 0x2

    iget-object v1, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v2, p0, Lmain/GameRun;->cur_mon:Ldm/Monster;

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v3

    aget-object v1, v1, v2

    aget-byte v1, v1, v3

    invoke-virtual {p0, v0, v1, v4}, Lmain/GameRun;->initMonStream(III)V

    .line 2787
    :cond_0
    return-void

    .line 2769
    :cond_1
    iget-byte v0, p0, Lmain/GameRun;->myMon_length:B

    goto :goto_0

    .line 2782
    :cond_2
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v3

    aget-byte v1, v1, v3

    aget-object v0, v0, v1

    goto :goto_1
.end method

.method public goYouPAUSE(I)V
    .locals 2
    .param p1, "sy"    # I

    .prologue
    const/4 v1, 0x0

    .line 3853
    const/16 v0, 0x61

    sput v0, Lmain/GameRun;->run_state:I

    .line 3854
    iput-byte v1, p0, Lmain/GameRun;->selectx:B

    .line 3855
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/GameRun;->selecty:B

    .line 3856
    invoke-virtual {p0, v1}, Lmain/GameRun;->setPauseS(I)V

    .line 3857
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Sound;->soundStop()V

    .line 3858
    iput-byte v1, p0, Lmain/GameRun;->say_c:B

    .line 3859
    const/4 v0, 0x1

    iput-byte v0, p0, Lmain/GameRun;->view_state:B

    .line 3860
    const/4 v0, 0x3

    iput-byte v0, p0, Lmain/GameRun;->mini_state:B

    .line 3861
    iput-byte v1, p0, Lmain/GameRun;->buyItemID:B

    .line 3862
    iput-byte v1, p0, Lmain/GameRun;->buyOk:B

    .line 3863
    const-string v0, "\u91d1\u5c5e\u514b\u91ce\u517d\uff0c\u91ce\u517d\u514b\u690d\u7269\uff0c\u690d\u7269\u514b\u98de\u884c\uff0c\u98de\u884c\u514b\u6d77\u6d0b\uff0c\u6d77\u6d0b\u514b\u91d1\u5c5e"

    iput-object v0, p0, Lmain/GameRun;->gogoString:Ljava/lang/String;

    .line 3864
    return-void
.end method

.method healMonster(Ldm/Monster;)V
    .locals 4
    .param p1, "monster"    # Ldm/Monster;

    .prologue
    .line 3488
    const/4 v0, 0x7

    iput-byte v0, p1, Ldm/Monster;->effect:B

    .line 3489
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x1

    iget-object v2, p1, Ldm/Monster;->monsterPro:[S

    const/4 v3, 0x3

    aget-short v2, v2, v3

    aput-short v2, v0, v1

    .line 3490
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    const/4 v1, 0x0

    iget-object v2, p1, Ldm/Monster;->monsterPro:[S

    const/4 v3, 0x2

    aget-short v2, v2, v3

    aput-short v2, v0, v1

    .line 3491
    return-void
.end method

.method public healMonster(Z)V
    .locals 3
    .param p1, "bb"    # Z

    .prologue
    .line 3494
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    if-lt v0, v1, :cond_1

    .line 3497
    if-eqz p1, :cond_0

    const-string v1, "\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u56de\u590d\u3002"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 3498
    :cond_0
    return-void

    .line 3495
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    invoke-virtual {p0, v1}, Lmain/GameRun;->healMonster(Ldm/Monster;)V

    .line 3494
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method public initBattle()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 5654
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 5655
    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    iget-object v1, p0, Lmain/GameRun;->src_c:[B

    const/4 v2, 0x1

    iget-object v3, p0, Lmain/GameRun;->src_c:[B

    const/4 v4, 0x2

    iget-object v5, p0, Lmain/GameRun;->src_c:[B

    const/4 v6, 0x3

    aput-byte v7, v5, v6

    aput-byte v7, v3, v4

    aput-byte v7, v1, v2

    aput-byte v7, v0, v7

    .line 5656
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->getBattleBG(Ldm/Battle;Ldm/Monster;)V

    .line 5657
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v1}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v1

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->getBattleBG(Ldm/Battle;Ldm/Monster;)V

    .line 5659
    invoke-direct {p0}, Lmain/GameRun;->setEnemyThrow()V

    .line 5660
    invoke-direct {p0}, Lmain/GameRun;->setMyThrow()V

    .line 5661
    return-void
.end method

.method public initImgIco()V
    .locals 4

    .prologue
    .line 5862
    iget-object v0, p0, Lmain/GameRun;->imgIco:[Ljavax/microedition/lcdui/Image;

    if-eqz v0, :cond_0

    .line 5871
    :goto_0
    return-void

    .line 5866
    :cond_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x7

    const-string v2, "data/brow/i"

    const/4 v3, 0x1

    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->createImageArray_(ILjava/lang/String;I)[Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun;->imgIco:[Ljavax/microedition/lcdui/Image;

    goto :goto_0
.end method

.method public initItemModules()V
    .locals 4

    .prologue
    .line 1111
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "data/item"

    invoke-virtual {v0, v1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun;->item_img:Ljavax/microedition/lcdui/Image;

    .line 1112
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v0, 0x0

    sput v0, Ldm/Ms;->skip:I

    .line 1113
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/item_m.d"

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun;->item_modules:[[B

    .line 1114
    return-void
.end method

.method public initMonPro(IZ)V
    .locals 4
    .param p1, "no"    # I
    .param p2, "mode"    # Z

    .prologue
    .line 5575
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v1, 0x0

    sput v1, Ldm/Ms;->skip:I

    .line 5576
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "data/map/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz p2, :cond_0

    const-string v3, "m"

    :goto_0
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".d"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v3, -0x1

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 5577
    .local v0, "data":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createArray([B)[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->monPro:[B

    .line 5579
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->createArray([B)[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->mapMove:[B

    .line 5580
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->mapRect:[[B

    .line 5582
    return-void

    .line 5576
    .end local v0    # "data":[B
    :cond_0
    const-string v3, "boss"

    goto :goto_0
.end method

.method public initMonStream(III)V
    .locals 4
    .param p1, "type"    # I
    .param p2, "id"    # I
    .param p3, "i"    # I

    .prologue
    .line 5504
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "data/npc"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 5505
    .local v1, "name":Ljava/lang/String;
    const/4 v0, 0x1

    .line 5507
    .local v0, "bb":Z
    const/4 v2, 0x2

    if-ne p1, v2, :cond_0

    invoke-virtual {p0, p2}, Lmain/GameRun;->isNpc2ImageType(I)Z

    move-result v0

    .line 5509
    :cond_0
    iget-object v2, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v2, v2, p3

    if-nez v2, :cond_1

    iget-object v2, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3, v1, v0}, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;

    move-result-object v3

    aput-object v3, v2, p3

    .line 5511
    :goto_0
    return-void

    .line 5510
    :cond_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v3, v3, p3

    invoke-virtual {v2, v3, v1, v0}, Ldm/Ms;->setSprite(Ldm/Sprite;Ljava/lang/String;Z)V

    goto :goto_0
.end method

.method public initNidusMap(I)V
    .locals 8
    .param p1, "mode"    # I

    .prologue
    const/4 v7, 0x4

    const/4 v6, -0x1

    const/4 v5, 0x0

    .line 1435
    iget-object v1, p0, Lmain/GameRun;->nidusMap:[B

    if-nez v1, :cond_0

    const/4 v1, 0x5

    new-array v1, v1, [B

    iput-object v1, p0, Lmain/GameRun;->nidusMap:[B

    .line 1436
    :cond_0
    const/4 v0, 0x0

    .line 1437
    .local v0, "i":B
    if-nez p1, :cond_3

    :goto_0
    iget-object v1, p0, Lmain/GameRun;->nidusMap:[B

    array-length v1, v1

    if-lt v0, v1, :cond_1

    .line 1445
    :goto_1
    return-void

    .line 1437
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->nidusMap:[B

    aput-byte v6, v1, v0

    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0

    .line 1439
    :cond_2
    iget-object v1, p0, Lmain/GameRun;->nidusMap:[B

    aget-byte v1, v1, v0

    if-ne v1, v6, :cond_4

    .line 1438
    :goto_2
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    :cond_3
    iget-object v1, p0, Lmain/GameRun;->nidusMap:[B

    array-length v1, v1

    if-lt v0, v1, :cond_2

    goto :goto_1

    .line 1440
    :cond_4
    invoke-virtual {p0, v0}, Lmain/GameRun;->getRid(I)B

    move-result v1

    const/4 v2, -0x2

    if-eq v1, v2, :cond_5

    .line 1441
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, v1, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    iget-object v2, p0, Lmain/GameRun;->nidusMap:[B

    aget-byte v2, v2, v0

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Npc;->other:[B

    const/4 v2, 0x1

    aput-byte v2, v1, v7

    .line 1442
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, v1, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    iget-object v2, p0, Lmain/GameRun;->nidusMap:[B

    aget-byte v2, v2, v0

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Npc;->other:[B

    const/4 v2, 0x7

    iget-object v3, p0, Lmain/GameRun;->monster_pro:[[B

    invoke-virtual {p0, v0}, Lmain/GameRun;->getNid(I)B

    move-result v4

    aget-object v3, v3, v4

    const/4 v4, 0x6

    aget-byte v3, v3, v4

    add-int/lit8 v3, v3, 0x11

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    goto :goto_2

    .line 1443
    :cond_5
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, v1, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    iget-object v2, p0, Lmain/GameRun;->nidusMap:[B

    aget-byte v2, v2, v0

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Npc;->other:[B

    aput-byte v5, v1, v7

    goto :goto_2
.end method

.method public initSkillList(Ldm/Monster;)V
    .locals 9
    .param p1, "mon"    # Ldm/Monster;

    .prologue
    const/4 v8, -0x1

    const/16 v7, 0x8

    const/4 v6, 0x1

    .line 5459
    const/4 v2, 0x0

    .line 5460
    .local v2, "temp":B
    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    const/4 v4, 0x0

    aput-byte v4, v3, v7

    .line 5462
    const/4 v0, 0x7

    .local v0, "i":B
    :goto_0
    if-gt v0, v8, :cond_0

    .line 5467
    const/4 v0, 0x1

    :goto_1
    if-lt v0, v7, :cond_2

    .line 5474
    return-void

    .line 5463
    :cond_0
    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    iget-object v4, p1, Ldm/Monster;->monster:[B

    add-int/lit8 v5, v0, 0x8

    aget-byte v4, v4, v5

    aput-byte v4, v3, v0

    .line 5464
    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    aget-byte v3, v3, v0

    if-eq v3, v8, :cond_1

    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    aget-byte v4, v3, v7

    add-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    aput-byte v4, v3, v7

    .line 5462
    :cond_1
    sub-int v3, v0, v6

    int-to-byte v0, v3

    goto :goto_0

    .line 5468
    :cond_2
    move v1, v0

    .local v1, "j":B
    :goto_2
    if-lez v1, :cond_3

    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    aget-byte v3, v3, v1

    iget-object v4, p0, Lmain/GameRun;->skill_list:[B

    sub-int v5, v1, v6

    aget-byte v4, v4, v5

    if-gt v3, v4, :cond_4

    .line 5467
    :cond_3
    add-int/lit8 v3, v0, 0x1

    int-to-byte v0, v3

    goto :goto_1

    .line 5469
    :cond_4
    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    aget-byte v2, v3, v1

    .line 5470
    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    iget-object v4, p0, Lmain/GameRun;->skill_list:[B

    sub-int v5, v1, v6

    aget-byte v4, v4, v5

    aput-byte v4, v3, v1

    .line 5471
    iget-object v3, p0, Lmain/GameRun;->skill_list:[B

    sub-int v4, v1, v6

    aput-byte v2, v3, v4

    .line 5468
    sub-int v3, v1, v6

    int-to-byte v1, v3

    goto :goto_2
.end method

.method public isMoney(IZ)Z
    .locals 3
    .param p1, "sell_money"    # I
    .param p2, "bb"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 951
    if-eqz p2, :cond_1

    .line 952
    iget v0, p0, Lmain/GameRun;->money:I

    if-lt v0, p1, :cond_0

    .line 953
    iget v0, p0, Lmain/GameRun;->money:I

    sub-int/2addr v0, p1

    iput v0, p0, Lmain/GameRun;->money:I

    move v0, v2

    .line 964
    :goto_0
    return v0

    .line 956
    :cond_0
    const-string v0, "\u91d1\u94b1\u4e0d\u8db3\uff01"

    invoke-virtual {p0, v0, v1}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    :goto_1
    move v0, v1

    .line 964
    goto :goto_0

    .line 958
    :cond_1
    iget v0, p0, Lmain/GameRun;->coin:I

    if-lt v0, p1, :cond_2

    .line 959
    iget v0, p0, Lmain/GameRun;->coin:I

    sub-int/2addr v0, p1

    iput v0, p0, Lmain/GameRun;->coin:I

    move v0, v2

    .line 960
    goto :goto_0

    .line 962
    :cond_2
    const-string v0, "\u5fbd\u7ae0\u4e0d\u8db3\uff01"

    invoke-virtual {p0, v0, v1}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_1
.end method

.method public isMoneyItem(IIIZ)Z
    .locals 5
    .param p1, "type"    # I
    .param p2, "item_id"    # I
    .param p3, "num"    # I
    .param p4, "bb"    # Z

    .prologue
    const/4 v4, -0x1

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 920
    const/4 v0, -0x2

    invoke-virtual {p0, v0, p2, v3}, Lmain/GameRun;->findItem(IIZ)B

    move-result v0

    add-int/2addr v0, p3

    const/16 v1, 0x63

    if-le v0, v1, :cond_0

    .line 921
    const-string v0, "\u6570\u91cf\u5df2\u5230\u4e0a\u9650"

    invoke-virtual {p0, v0, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    move v0, v2

    .line 948
    :goto_0
    return v0

    .line 925
    :cond_0
    if-eqz p4, :cond_3

    .line 926
    iget v0, p0, Lmain/GameRun;->money:I

    iget v1, p0, Lmain/GameRun;->sell_money:I

    mul-int/2addr v1, p3

    if-lt v0, v1, :cond_1

    .line 927
    iget v0, p0, Lmain/GameRun;->money:I

    iget v1, p0, Lmain/GameRun;->sell_money:I

    mul-int/2addr v1, p3

    sub-int/2addr v0, v1

    iput v0, p0, Lmain/GameRun;->money:I

    move v0, v3

    .line 928
    goto :goto_0

    .line 930
    :cond_1
    iget v0, p0, Lmain/GameRun;->money:I

    iget v1, p0, Lmain/GameRun;->sell_money:I

    mul-int/2addr v1, p3

    if-ge v0, v1, :cond_2

    .line 935
    const-string v0, "\u91d1\u94b1\u4e0d\u8db3\uff01"

    invoke-virtual {p0, v0, v4, v2}, Lmain/GameRun;->say(Ljava/lang/String;II)V

    :goto_1
    move v0, v2

    .line 948
    goto :goto_0

    .line 938
    :cond_2
    const-string v0, "\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3\u3002"

    invoke-virtual {p0, v0, v2, v4}, Lmain/GameRun;->say(Ljava/lang/String;II)V

    goto :goto_1

    .line 940
    :cond_3
    iget v0, p0, Lmain/GameRun;->coin:I

    iget v1, p0, Lmain/GameRun;->sell_money:I

    mul-int/2addr v1, p3

    if-lt v0, v1, :cond_4

    .line 941
    iget v0, p0, Lmain/GameRun;->coin:I

    iget v1, p0, Lmain/GameRun;->sell_money:I

    mul-int/2addr v1, p3

    sub-int/2addr v0, v1

    iput v0, p0, Lmain/GameRun;->coin:I

    move v0, v3

    .line 942
    goto :goto_0

    .line 944
    :cond_4
    iget v0, p0, Lmain/GameRun;->coin:I

    iget v1, p0, Lmain/GameRun;->sell_money:I

    mul-int/2addr v1, p3

    if-ge v0, v1, :cond_5

    .line 945
    const-string v0, "\u5fbd\u7ae0\u4e0d\u8db3\uff01"

    invoke-virtual {p0, v0, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_1

    .line 946
    :cond_5
    const-string v0, "\u80cc\u5305\u7a7a\u95f4\u4e0d\u8db3\u3002"

    invoke-virtual {p0, v0, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_1
.end method

.method public isNpc2ImageType(I)Z
    .locals 2
    .param p1, "id"    # I

    .prologue
    .line 4115
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-object v1, p0, Lmain/GameRun;->npc2ImageType:[B

    array-length v1, v1

    if-lt v0, v1, :cond_0

    .line 4117
    const/4 v1, 0x1

    :goto_1
    return v1

    .line 4116
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->npc2ImageType:[B

    aget-byte v1, v1, v0

    if-ne v1, p1, :cond_1

    const/4 v1, 0x0

    goto :goto_1

    .line 4115
    :cond_1
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_0
.end method

.method public keyGameOver1(Z)V
    .locals 2
    .param p1, "over"    # Z

    .prologue
    .line 3018
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 3020
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 3024
    invoke-virtual {p0}, Lmain/GameRun;->goMAIN_MENU()V

    .line 3040
    :cond_0
    :goto_0
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    .line 3051
    :cond_1
    :goto_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 3052
    return-void

    .line 3026
    :cond_2
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    if-nez v0, :cond_0

    .line 3027
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "loadGame soars"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 3028
    invoke-direct {p0}, Lmain/GameRun;->loadGame()V

    goto :goto_0

    .line 3048
    :cond_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3049
    iget-byte v0, p0, Lmain/GameRun;->popMenu:B

    xor-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->popMenu:B

    goto :goto_1
.end method

.method public keyLIST_INFO()V
    .locals 6

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x0

    .line 1698
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_delay()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 1732
    :cond_0
    :goto_0
    return-void

    .line 1699
    :cond_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_S1_Num5()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1700
    iget-object v1, p0, Lmain/GameRun;->monInfoList:[B

    invoke-direct {p0}, Lmain/GameRun;->getMonInfo_dir()B

    move-result v2

    aget-byte v1, v1, v2

    if-eqz v1, :cond_0

    .line 1701
    invoke-direct {p0}, Lmain/GameRun;->getMonInfo_dir()B

    move-result v1

    invoke-direct {p0, v1}, Lmain/GameRun;->goMONSTER_INFO(I)V

    goto :goto_0

    .line 1702
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_S2()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 1703
    iput-object v2, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    .line 1704
    iput-object v2, p0, Lmain/GameRun;->monInfo_dir:[[B

    .line 1705
    invoke-virtual {p0, v5}, Lmain/GameRun;->doPaint(I)V

    .line 1706
    const/4 v1, 0x3

    invoke-virtual {p0, v1}, Lmain/GameRun;->goYouPAUSE(I)V

    goto :goto_0

    .line 1708
    :cond_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_Left_Right()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 1709
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    const/4 v3, 0x4

    invoke-virtual {v1, v2, v5, v3}, Ldm/Ms;->select(III)B

    move-result v1

    iput-byte v1, p0, Lmain/GameRun;->cur_a:B

    .line 1710
    iput-byte v5, p0, Lmain/GameRun;->infoStart:B

    .line 1711
    iget-byte v1, p0, Lmain/GameRun;->cur_a:B

    if-lez v1, :cond_4

    .line 1712
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_1
    iget-byte v1, p0, Lmain/GameRun;->cur_a:B

    if-lt v0, v1, :cond_5

    .line 1715
    .end local v0    # "i":B
    :cond_4
    iget-object v1, p0, Lmain/GameRun;->monInfo_dir:[[B

    iget-byte v2, p0, Lmain/GameRun;->cur_a:B

    aget-object v1, v1, v2

    array-length v1, v1

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/GameRun;->t_length:B

    .line 1717
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    const/4 v3, 0x1

    aput-byte v5, v2, v3

    aput-byte v5, v1, v5

    goto :goto_0

    .line 1713
    .restart local v0    # "i":B
    :cond_5
    iget-byte v1, p0, Lmain/GameRun;->infoStart:B

    iget-object v2, p0, Lmain/GameRun;->monInfo_dir:[[B

    aget-object v2, v2, v0

    array-length v2, v2

    add-int/2addr v1, v2

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/GameRun;->infoStart:B

    .line 1712
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_1

    .line 1719
    .end local v0    # "i":B
    :cond_6
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_Up_Down()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1720
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    iget-byte v3, p0, Lmain/GameRun;->t_length:B

    iget-byte v4, p0, Lmain/GameRun;->list_rows:B

    invoke-virtual {v1, v2, v5, v3, v4}, Ldm/Ms;->selectS([BIII)V

    goto/16 :goto_0
.end method

.method public key_gameRun()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x3

    const/4 v2, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 3072
    sget v0, Lmain/GameRun;->run_state:I

    const/16 v1, 0x62

    if-ne v0, v1, :cond_3

    .line 3073
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Num0()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 3079
    :cond_0
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->doShowNotify()V

    .line 3081
    :cond_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 3082
    const-string v0, "soars"

    const-string v1, "doShowNotify2"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 3302
    :cond_2
    :goto_0
    return-void

    .line 3085
    :cond_3
    iget-byte v0, p0, Lmain/GameRun;->say_c:B

    if-lez v0, :cond_4

    .line 3086
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto :goto_0

    .line 3088
    :cond_4
    iget-byte v0, p0, Lmain/GameRun;->say_c:B

    if-gez v0, :cond_6

    .line 3089
    iget v0, p0, Lmain/GameRun;->say_s:I

    if-nez v0, :cond_5

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 3091
    iput-byte v3, p0, Lmain/GameRun;->say_c:B

    .line 3093
    invoke-virtual {p0}, Lmain/GameRun;->doSayOverSms()V

    .line 3096
    :cond_5
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto :goto_0

    .line 3099
    :cond_6
    sget v0, Lmain/GameRun;->run_state:I

    sparse-switch v0, :sswitch_data_0

    .line 3301
    :cond_7
    :goto_1
    :sswitch_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-nez v0, :cond_8

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto :goto_0

    .line 3101
    :sswitch_1
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0}, Lmain/Map;->key_map()V

    goto :goto_1

    .line 3104
    :sswitch_2
    invoke-direct {p0}, Lmain/GameRun;->keyBattleState()V

    goto :goto_1

    .line 3107
    :sswitch_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-nez v0, :cond_2

    .line 3108
    iget-byte v0, p0, Lmain/GameRun;->b_c:B

    if-ne v0, v4, :cond_7

    iget v0, p0, Lmain/GameRun;->say_s:I

    if-nez v0, :cond_7

    iput-byte v3, p0, Lmain/GameRun;->b_c:B

    goto :goto_1

    .line 3118
    :sswitch_4
    invoke-virtual {p0, v4}, Lmain/GameRun;->keyGameOver1(Z)V

    goto :goto_1

    .line 3121
    :sswitch_5
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 3122
    const/16 v0, 0x3d

    sput v0, Lmain/GameRun;->run_state:I

    .line 3123
    new-array v0, v2, [Ljava/lang/String;

    const-string v1, "\u7ee7\u7eed"

    aput-object v1, v0, v3

    const-string v1, "\u653e\u5f03"

    aput-object v1, v0, v4

    invoke-virtual {p0, v0}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    .line 3124
    iput-byte v3, p0, Lmain/GameRun;->popMenu:B

    goto :goto_1

    .line 3127
    :sswitch_6
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 3128
    invoke-direct {p0, v3}, Lmain/GameRun;->goLIST_INFO(Z)V

    .line 3129
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto :goto_1

    .line 3133
    :sswitch_7
    invoke-virtual {p0}, Lmain/GameRun;->keyLIST_INFO()V

    goto :goto_1

    .line 3136
    :sswitch_8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-nez v0, :cond_2

    .line 3137
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_15

    .line 3138
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 3139
    iget-byte v0, p0, Lmain/GameRun;->selectx:B

    if-nez v0, :cond_f

    .line 3158
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    if-nez v0, :cond_a

    .line 3159
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-ne v0, v4, :cond_9

    .line 3160
    const/16 v0, 0x64

    sput v0, Lmain/GameRun;->run_state:I

    .line 3161
    iput-byte v3, p0, Lmain/GameRun;->b_c:B

    .line 3162
    iput-byte v3, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_1

    .line 3163
    :cond_9
    iput-byte v4, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_1

    .line 3167
    :cond_a
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    if-ne v0, v4, :cond_b

    .line 3172
    invoke-virtual {p0}, Lmain/GameRun;->goVIEW_MONSTER()V

    goto/16 :goto_1

    .line 3173
    :cond_b
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    if-ne v0, v2, :cond_c

    .line 3174
    invoke-direct {p0, v3}, Lmain/GameRun;->goMY_BAG(I)V

    goto/16 :goto_1

    .line 3175
    :cond_c
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    if-ne v0, v5, :cond_d

    .line 3176
    invoke-direct {p0, v4}, Lmain/GameRun;->goLIST_INFO(Z)V

    goto/16 :goto_1

    .line 3179
    :cond_d
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    const/4 v1, 0x4

    if-ne v0, v1, :cond_e

    .line 3180
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0, v3, v4}, Lmain/Map;->goMission(IZ)V

    goto/16 :goto_1

    .line 3182
    :cond_e
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    const/4 v1, 0x5

    if-ne v0, v1, :cond_7

    .line 3183
    invoke-direct {p0, v4}, Lmain/GameRun;->goRUN_IN_MAP(Z)V

    .line 3184
    iput-object v6, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    goto/16 :goto_1

    .line 3193
    :cond_f
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    if-nez v0, :cond_11

    .line 3194
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-ne v0, v2, :cond_10

    invoke-direct {p0}, Lmain/GameRun;->loadGame()V

    goto/16 :goto_1

    .line 3195
    :cond_10
    iput-byte v2, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_1

    .line 3196
    :cond_11
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    if-ne v0, v4, :cond_12

    .line 3199
    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun;->isChangeSound:Ljava/lang/Boolean;

    .line 3200
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, v3}, Ldm/Sound;->keyVolume(I)V

    goto/16 :goto_1

    .line 3206
    :cond_12
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    if-ne v0, v2, :cond_13

    .line 3207
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0, v4}, Lmain/MainCanvas;->goHELP_dialog(I)V

    goto/16 :goto_1

    .line 3208
    :cond_13
    iget-byte v0, p0, Lmain/GameRun;->selecty:B

    if-ne v0, v5, :cond_7

    .line 3209
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-ne v0, v5, :cond_14

    .line 3210
    sput v3, Lmain/GameRun;->run_state:I

    .line 3211
    iput-object v6, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    .line 3212
    invoke-virtual {p0}, Lmain/GameRun;->goMAIN_MENU()V

    .line 3213
    iput-byte v3, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_1

    .line 3214
    :cond_14
    iput-byte v5, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_1

    .line 3215
    :cond_15
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_17

    .line 3216
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-nez v0, :cond_16

    .line 3217
    iput-object v6, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    .line 3218
    invoke-direct {p0, v4}, Lmain/GameRun;->goRUN_IN_MAP(Z)V

    goto/16 :goto_1

    .line 3220
    :cond_16
    invoke-virtual {p0, v3}, Lmain/GameRun;->doPaint(I)V

    .line 3221
    const/16 v0, 0x61

    sput v0, Lmain/GameRun;->run_state:I

    .line 3222
    iput-byte v3, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_1

    .line 3224
    :cond_17
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-nez v0, :cond_7

    .line 3225
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_18

    .line 3226
    iget-byte v0, p0, Lmain/GameRun;->selectx:B

    xor-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/GameRun;->selectx:B

    .line 3227
    iput-byte v3, p0, Lmain/GameRun;->selecty:B

    .line 3228
    iget-byte v0, p0, Lmain/GameRun;->selectx:B

    invoke-virtual {p0, v0}, Lmain/GameRun;->setPauseS(I)V

    goto/16 :goto_1

    .line 3229
    :cond_18
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 3230
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    iget-object v2, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    array-length v2, v2

    sub-int/2addr v2, v4

    invoke-virtual {v0, v1, v3, v2}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lmain/GameRun;->selecty:B

    goto/16 :goto_1

    .line 3238
    :sswitch_9
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Num0()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 3242
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v3, v0, Ldm/Npc;->state:B

    .line 3243
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iput-byte v2, v0, Lmain/Map;->eventGoing:B

    .line 3244
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 3245
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    const/4 v1, -0x1

    iput-byte v1, v0, Lmain/Map;->dialog_no:B

    .line 3246
    invoke-direct {p0}, Lmain/GameRun;->goGO_RUNINMAP()V

    goto/16 :goto_1

    .line 3257
    :sswitch_a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-nez v0, :cond_2

    .line 3258
    iget-byte v0, p0, Lmain/GameRun;->cur_c:B

    if-nez v0, :cond_1a

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    const/4 v1, 0x6

    if-ne v0, v1, :cond_19

    iget-object v0, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    :goto_2
    invoke-direct {p0, v0}, Lmain/GameRun;->key_MONSTER_LIST([Ldm/Monster;)V

    goto/16 :goto_1

    :cond_19
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    goto :goto_2

    .line 3259
    :cond_1a
    iget-byte v0, p0, Lmain/GameRun;->cur_c:B

    if-ne v0, v4, :cond_1b

    invoke-direct {p0}, Lmain/GameRun;->keyMagicUI()V

    goto/16 :goto_1

    .line 3260
    :cond_1b
    iget-byte v0, p0, Lmain/GameRun;->cur_c:B

    if-ne v0, v2, :cond_7

    invoke-direct {p0}, Lmain/GameRun;->keyEvolveUI()V

    goto/16 :goto_1

    .line 3263
    :sswitch_b
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-nez v0, :cond_2

    .line 3264
    invoke-virtual {p0}, Lmain/GameRun;->popState()V

    goto/16 :goto_1

    .line 3268
    :sswitch_c
    invoke-direct {p0}, Lmain/GameRun;->keyNidus()V

    goto/16 :goto_1

    .line 3272
    :sswitch_d
    invoke-direct {p0}, Lmain/GameRun;->keyMY_BAG()V

    goto/16 :goto_1

    .line 3275
    :sswitch_e
    invoke-direct {p0}, Lmain/GameRun;->keyBuyItem()V

    goto/16 :goto_1

    .line 3279
    :sswitch_f
    invoke-static {}, Lminigame/Mg;->i()Lminigame/Mg;

    move-result-object v0

    invoke-virtual {v0, p0}, Lminigame/Mg;->key(Lmain/GameRun;)V

    goto/16 :goto_1

    .line 3284
    :sswitch_10
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v0

    invoke-virtual {v0}, Lmain/SMSSender;->key()V

    goto/16 :goto_1

    .line 3296
    :sswitch_11
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v0

    invoke-virtual {v0}, Lmain/SMSSender;->keyLevel()V

    .line 3297
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Sound;->soundStop()V

    goto/16 :goto_1

    .line 3099
    :sswitch_data_0
    .sparse-switch
        -0x1f -> :sswitch_2
        -0x15 -> :sswitch_11
        -0x14 -> :sswitch_10
        -0xf -> :sswitch_3
        -0xa -> :sswitch_1
        0x12 -> :sswitch_e
        0x19 -> :sswitch_d
        0x23 -> :sswitch_a
        0x32 -> :sswitch_0
        0x33 -> :sswitch_9
        0x34 -> :sswitch_0
        0x3c -> :sswitch_5
        0x3d -> :sswitch_4
        0x41 -> :sswitch_b
        0x42 -> :sswitch_c
        0x43 -> :sswitch_6
        0x44 -> :sswitch_7
        0x45 -> :sswitch_f
        0x61 -> :sswitch_8
    .end sparse-switch
.end method

.method public levelPro(IZ)V
    .locals 11
    .param p1, "no"    # I
    .param p2, "bb"    # Z

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x7

    const/4 v7, 0x3

    const/4 v8, 0x2

    const/4 v6, 0x0

    .line 3398
    if-eqz p2, :cond_0

    .line 3399
    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, p1

    const/4 v5, 0x6

    aget-short v4, v4, v5

    int-to-byte v1, v4

    .line 3400
    .local v1, "enlevel_star":B
    iget-object v4, p0, Lmain/GameRun;->monster_pro:[[B

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monster:[B

    aget-byte v5, v5, v6

    aget-object v3, v4, v5

    .line 3401
    .local v3, "temp_pro":[B
    aget-byte v4, v3, v6

    aget-byte v5, v3, v9

    mul-int/2addr v5, v1

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    int-to-short v2, v4

    .line 3402
    .local v2, "temp":S
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    invoke-direct {p0, v4, v2}, Lmain/GameRun;->getbuffRateV(Ldm/Monster;I)S

    move-result v2

    .line 3403
    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, p1

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monsterPro:[S

    aget-short v5, v5, v8

    sub-int/2addr v5, v2

    int-to-short v5, v5

    aput-short v5, v4, v6

    .line 3404
    aget-byte v4, v3, v10

    const/16 v5, 0x8

    aget-byte v5, v3, v5

    mul-int/2addr v5, v1

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    int-to-short v2, v4

    .line 3405
    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, p1

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monsterPro:[S

    aget-short v5, v5, v7

    sub-int/2addr v5, v2

    int-to-short v5, v5

    aput-short v5, v4, v10

    .line 3406
    aget-byte v4, v3, v7

    const/16 v5, 0xa

    aget-byte v5, v3, v5

    mul-int/2addr v5, v1

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    int-to-short v2, v4

    .line 3407
    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, p1

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monsterPro:[S

    const/4 v6, 0x6

    aget-short v5, v5, v6

    sub-int/2addr v5, v2

    int-to-short v5, v5

    aput-short v5, v4, v7

    .line 3408
    const/4 v4, 0x4

    aget-byte v4, v3, v4

    const/16 v5, 0xb

    aget-byte v5, v3, v5

    mul-int/2addr v5, v1

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    int-to-short v2, v4

    .line 3409
    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, p1

    const/4 v5, 0x4

    iget-object v6, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v6, v6, p1

    iget-object v6, v6, Ldm/Monster;->monsterPro:[S

    aget-short v6, v6, v9

    sub-int/2addr v6, v2

    int-to-short v6, v6

    aput-short v6, v4, v5

    .line 3410
    aget-byte v4, v3, v8

    const/16 v5, 0x9

    aget-byte v5, v3, v5

    mul-int/2addr v5, v1

    div-int/lit8 v5, v5, 0xa

    add-int/2addr v4, v5

    int-to-short v2, v4

    .line 3411
    iget-object v4, p0, Lmain/GameRun;->proReplace:[[S

    aget-object v4, v4, p1

    const/4 v5, 0x5

    iget-object v6, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v6, v6, p1

    iget-object v6, v6, Ldm/Monster;->monsterPro:[S

    const/4 v7, 0x5

    aget-short v6, v6, v7

    sub-int/2addr v6, v2

    int-to-short v6, v6

    aput-short v6, v4, v5

    .line 3412
    const/4 v3, 0x0

    check-cast v3, [B

    .line 3433
    .end local v1    # "enlevel_star":B
    .end local v2    # "temp":S
    :goto_0
    return-void

    .line 3414
    .end local v3    # "temp_pro":[B
    :cond_0
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monster:[B

    aget-byte v5, v4, v8

    add-int/lit8 v5, v5, 0x1

    int-to-byte v0, v5

    aput-byte v0, v4, v8

    .line 3415
    .local v0, "enemylevel":B
    iget-object v4, p0, Lmain/GameRun;->monster_pro:[[B

    iget-object v5, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v5, v5, p1

    iget-object v5, v5, Ldm/Monster;->monster:[B

    aget-byte v5, v5, v6

    aget-object v3, v4, v5

    .line 3416
    .restart local v3    # "temp_pro":[B
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aget-byte v5, v3, v6

    aget-byte v6, v3, v9

    mul-int/2addr v6, v0

    div-int/lit8 v6, v6, 0xa

    add-int/2addr v5, v6

    int-to-short v5, v5

    aput-short v5, v4, v8

    .line 3417
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    aget-byte v5, v3, v10

    const/16 v6, 0x8

    aget-byte v6, v3, v6

    mul-int/2addr v6, v0

    div-int/lit8 v6, v6, 0xa

    add-int/2addr v5, v6

    int-to-short v5, v5

    aput-short v5, v4, v7

    .line 3418
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    const/4 v5, 0x6

    aget-byte v6, v3, v7

    const/16 v7, 0xa

    aget-byte v7, v3, v7

    mul-int/2addr v7, v0

    div-int/lit8 v7, v7, 0xa

    add-int/2addr v6, v7

    int-to-byte v6, v6

    aput-short v6, v4, v5

    .line 3419
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    const/4 v5, 0x4

    aget-byte v5, v3, v5

    const/16 v6, 0xb

    aget-byte v6, v3, v6

    mul-int/2addr v6, v0

    div-int/lit8 v6, v6, 0xa

    add-int/2addr v5, v6

    int-to-byte v5, v5

    aput-short v5, v4, v9

    .line 3420
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    iget-object v4, v4, Ldm/Monster;->monsterPro:[S

    const/4 v5, 0x5

    aget-byte v6, v3, v8

    const/16 v7, 0x9

    aget-byte v7, v3, v7

    mul-int/2addr v7, v0

    div-int/lit8 v7, v7, 0xa

    add-int/2addr v6, v7

    int-to-byte v6, v6

    aput-short v6, v4, v5

    .line 3421
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    invoke-virtual {v4, p0}, Ldm/Monster;->resetPro(Lmain/GameRun;)V

    .line 3422
    const/4 v3, 0x0

    check-cast v3, [B

    .line 3423
    iget-object v4, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, p1

    invoke-virtual {p0, v4}, Lmain/GameRun;->healMonster(Ldm/Monster;)V

    goto/16 :goto_0
.end method

.method public map_flashString()V
    .locals 11

    .prologue
    const/16 v7, 0x16

    const/16 v6, 0xc

    const/4 v10, 0x3

    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 4004
    sget v2, Lmain/Constants_H;->WIDTH__:I

    .local v2, "WIDTH":I
    sget v0, Lmain/Constants_H;->HEIGHT__:I

    .line 4005
    .local v0, "HEIGHT":I
    const/16 v3, 0x140

    .local v3, "WIDTH_H":I
    sget v4, Lmain/Constants_H;->HEIGHT__:I

    div-int/lit8 v1, v4, 0x2

    .line 4007
    .local v1, "HEIGHT_H":I
    invoke-virtual {p0}, Lmain/GameRun;->setSay()V

    .line 4008
    iget-byte v4, p0, Lmain/GameRun;->say_c:B

    if-lez v4, :cond_4

    sget v4, Lmain/GameRun;->run_state:I

    const/16 v5, 0x62

    if-eq v4, v5, :cond_4

    .line 4009
    iget-object v4, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-boolean v4, v4, Lmain/Map;->fontSizeControl:Z

    if-nez v4, :cond_0

    .line 4010
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v4, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v4, v7}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 4011
    :cond_0
    iget-object v4, p0, Lmain/GameRun;->showS:[Ljava/lang/StringBuffer;

    iget-byte v5, p0, Lmain/GameRun;->say_mode:B

    if-nez v5, :cond_2

    iget-object v5, p0, Lmain/GameRun;->showS:[Ljava/lang/StringBuffer;

    array-length v5, v5

    shr-int/lit8 v5, v5, 0x1

    mul-int/lit8 v5, v5, 0x19

    sub-int v5, v1, v5

    sub-int/2addr v5, v6

    :goto_0
    iget v6, p0, Lmain/GameRun;->say_s:I

    invoke-virtual {p0, v4, v5, v6, v8}, Lmain/GameRun;->showString([Ljava/lang/StringBuffer;III)V

    .line 4012
    iget v4, p0, Lmain/GameRun;->say_s:I

    if-nez v4, :cond_3

    iget-byte v4, p0, Lmain/GameRun;->say_c:B

    sub-int/2addr v4, v8

    int-to-byte v4, v4

    iput-byte v4, p0, Lmain/GameRun;->say_c:B

    .line 4023
    :cond_1
    :goto_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v4, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v5, 0x1a

    invoke-virtual {v4, v5}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 4024
    return-void

    .line 4011
    :cond_2
    const/16 v5, 0x32

    sub-int v5, v0, v5

    const/16 v6, 0x12

    sub-int/2addr v5, v6

    goto :goto_0

    .line 4013
    :cond_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    iget v5, p0, Lmain/GameRun;->say_s:I

    invoke-virtual {v4, v5, v10, v8}, Ldm/Ms;->mathSpeedDown(IIZ)S

    move-result v4

    iput v4, p0, Lmain/GameRun;->say_s:I

    goto :goto_1

    .line 4014
    :cond_4
    iget-byte v4, p0, Lmain/GameRun;->say_c:B

    if-gez v4, :cond_1

    sget v4, Lmain/GameRun;->run_state:I

    const/16 v5, 0x62

    if-eq v4, v5, :cond_1

    .line 4015
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v4, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    invoke-virtual {v4, v7}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 4016
    iget-object v4, p0, Lmain/GameRun;->showS:[Ljava/lang/StringBuffer;

    iget-object v5, p0, Lmain/GameRun;->showS:[Ljava/lang/StringBuffer;

    array-length v5, v5

    shr-int/lit8 v5, v5, 0x1

    mul-int/lit8 v5, v5, 0x19

    sub-int v5, v1, v5

    sub-int/2addr v5, v6

    iget v6, p0, Lmain/GameRun;->say_s:I

    const/4 v7, 0x2

    invoke-virtual {p0, v4, v5, v6, v7}, Lmain/GameRun;->showString([Ljava/lang/StringBuffer;III)V

    .line 4017
    iget v4, p0, Lmain/GameRun;->say_s:I

    if-eqz v4, :cond_5

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    iget v5, p0, Lmain/GameRun;->say_s:I

    invoke-virtual {v4, v5, v10, v8}, Ldm/Ms;->mathSpeedDown(IIZ)S

    move-result v4

    iput v4, p0, Lmain/GameRun;->say_s:I

    .line 4019
    :cond_5
    iget-object v4, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v4, v9, v9, v2, v0}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v4

    if-eqz v4, :cond_1

    iget-object v4, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v4}, Lmain/PointerKey;->setKey5()V

    goto :goto_1
.end method

.method public paint_gameRun(Ljavax/microedition/lcdui/Graphics;)V
    .locals 13
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 422
    const/16 v10, 0x280

    .local v10, "WIDTH":I
    const/16 v8, 0x168

    .line 423
    .local v8, "HEIGHT":I
    const/16 v11, 0x140

    .local v11, "WIDTH_H":I
    const/16 v9, 0xb4

    .line 426
    .local v9, "HEIGHT_H":I
    sget v0, Lmain/GameRun;->run_state:I

    sparse-switch v0, :sswitch_data_0

    .line 613
    :cond_0
    :goto_0
    :sswitch_0
    invoke-virtual {p0}, Lmain/GameRun;->map_flashString()V

    .line 615
    return-void

    .line 429
    :sswitch_1
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0, p1}, Lmain/Map;->paint_map(Ljavax/microedition/lcdui/Graphics;)V

    goto :goto_0

    .line 432
    :sswitch_2
    invoke-direct {p0}, Lmain/GameRun;->drawBattleBG()V

    .line 433
    const/4 v0, 0x1

    const/16 v1, 0xfc

    invoke-direct {p0, p1, v0, v1}, Lmain/GameRun;->drawSelectMenu(Ljavax/microedition/lcdui/Graphics;ZI)V

    .line 435
    const/16 v2, 0xf

    const/16 v3, 0x7c

    const/16 v4, 0xa

    const/4 v5, 0x0

    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    const/4 v1, 0x2

    aget-byte v0, v0, v1

    if-nez v0, :cond_1

    const/4 v0, 0x1

    move v6, v0

    :goto_1
    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v6}, Lmain/GameRun;->drawSrcLine(Ljavax/microedition/lcdui/Graphics;IIIZZ)V

    .line 436
    const/16 v2, 0x83

    const/16 v3, 0x7c

    const/16 v4, 0xa

    const/4 v5, 0x1

    iget-object v0, p0, Lmain/GameRun;->src_c:[B

    const/4 v1, 0x3

    aget-byte v0, v0, v1

    if-nez v0, :cond_2

    const/4 v0, 0x1

    move v6, v0

    :goto_2
    move-object v0, p0

    move-object v1, p1

    invoke-virtual/range {v0 .. v6}, Lmain/GameRun;->drawSrcLine(Ljavax/microedition/lcdui/Graphics;IIIZZ)V

    .line 441
    invoke-direct {p0, p1}, Lmain/GameRun;->drawPlayerAppear(Ljavax/microedition/lcdui/Graphics;)V

    goto :goto_0

    .line 435
    :cond_1
    const/4 v0, 0x0

    move v6, v0

    goto :goto_1

    .line 436
    :cond_2
    const/4 v0, 0x0

    move v6, v0

    goto :goto_2

    .line 444
    :sswitch_3
    invoke-direct {p0}, Lmain/GameRun;->drawBattleBG()V

    .line 445
    invoke-direct {p0, p1}, Lmain/GameRun;->drawPlayer(Ljavax/microedition/lcdui/Graphics;)V

    .line 446
    iget-byte v0, p0, Lmain/GameRun;->battle_state:B

    const/4 v1, 0x2

    if-eq v0, v1, :cond_3

    const/4 v0, 0x1

    :goto_3
    const/16 v1, 0xfc

    invoke-direct {p0, p1, v0, v1}, Lmain/GameRun;->drawSelectMenu(Ljavax/microedition/lcdui/Graphics;ZI)V

    .line 447
    invoke-direct {p0, p1}, Lmain/GameRun;->paintBattleState(Ljavax/microedition/lcdui/Graphics;)V

    goto :goto_0

    .line 446
    :cond_3
    const/4 v0, 0x0

    goto :goto_3

    .line 450
    :sswitch_4
    invoke-direct {p0}, Lmain/GameRun;->drawBattleBG()V

    .line 451
    const/4 v0, 0x1

    const/16 v1, 0xfc

    invoke-direct {p0, p1, v0, v1}, Lmain/GameRun;->drawSelectMenu(Ljavax/microedition/lcdui/Graphics;ZI)V

    .line 452
    invoke-virtual {p0}, Lmain/GameRun;->drawMyMon()V

    .line 453
    invoke-direct {p0}, Lmain/GameRun;->drawEnemy()V

    .line 454
    iget-short v0, p0, Lmain/GameRun;->cThrowY:S

    const/16 v1, 0x11

    if-ge v0, v1, :cond_4

    .line 455
    iget-short v0, p0, Lmain/GameRun;->cThrowS:S

    iget-short v1, p0, Lmain/GameRun;->cThrowY:S

    add-int/2addr v0, v1

    int-to-short v0, v0

    iput-short v0, p0, Lmain/GameRun;->cThrowS:S

    .line 456
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-short v1, p0, Lmain/GameRun;->cThrowY:S

    const/16 v2, 0x11

    const/4 v3, 0x2

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v0

    iput-short v0, p0, Lmain/GameRun;->cThrowY:S

    .line 458
    :cond_4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-short v1, p0, Lmain/GameRun;->cThrowX:S

    const/4 v2, 0x0

    const/16 v3, 0x8

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v0

    iput-short v0, p0, Lmain/GameRun;->cThrowX:S

    .line 459
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/GameRun;->imgItem:[Ljavax/microedition/lcdui/Image;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    const/16 v2, 0x179

    iget-short v3, p0, Lmain/GameRun;->cThrowX:S

    sub-int/2addr v2, v3

    iget-short v3, p0, Lmain/GameRun;->cThrowS:S

    const/4 v4, 0x1

    or-int/lit8 v4, v4, 0x20

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    goto/16 :goto_0

    .line 462
    :sswitch_5
    invoke-direct {p0}, Lmain/GameRun;->paintBATTLE_OVER()V

    goto/16 :goto_0

    .line 472
    :sswitch_6
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, -0x2

    const/4 v2, 0x0

    add-int/lit8 v3, v10, 0x4

    const/16 v4, 0x21

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK0(IIIII)V

    .line 473
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u8bad\u7ec3\u5e08\u7b49\u7ea7\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/GameRun;->rmsOther:[B

    const/4 v3, 0x3

    aget-byte v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x2

    const/16 v4, 0x11

    const/4 v5, 0x1

    const/4 v6, 0x2

    move v2, v11

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 485
    const/16 v0, 0x64

    sub-int v0, v11, v0

    const/4 v1, 0x5

    sub-int/2addr v0, v1

    const/16 v1, 0x2d

    const/16 v2, 0xd2

    const/16 v3, 0xeb

    invoke-virtual {p0, v0, v1, v2, v3}, Lmain/GameRun;->drawPauseMenu(IIII)V

    .line 506
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, -0x2

    const/16 v2, 0x19

    sub-int v2, v8, v2

    const/16 v3, 0x8

    sub-int/2addr v2, v3

    add-int/lit8 v3, v10, 0x4

    const/16 v4, 0x21

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK0(IIIII)V

    .line 507
    iget-object v1, p0, Lmain/GameRun;->gogoString:Ljava/lang/String;

    const/16 v0, 0x19

    sub-int v0, v8, v0

    const/4 v2, 0x6

    sub-int v2, v0, v2

    const/16 v3, 0x10

    const/4 v4, 0x3

    const/4 v5, 0x0

    const/4 v6, 0x2

    move-object v0, p0

    invoke-virtual/range {v0 .. v6}, Lmain/GameRun;->gogoWordM(Ljava/lang/String;IIIII)V

    .line 511
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    if-eqz v0, :cond_6

    .line 512
    const-string v12, "\u662f\u5426\u4fdd\u5b58\u6e38\u620f?"

    .line 513
    .local v12, "str":Ljava/lang/String;
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    const/4 v1, 0x2

    if-ne v0, v1, :cond_7

    const-string v12, "\u662f\u5426\u8bfb\u53d6\u8fdb\u5ea6?"

    .line 515
    :cond_5
    :goto_4
    const/16 v0, 0x3c

    const/4 v1, 0x0

    invoke-virtual {p0, v12, v0, v1}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    .line 518
    .end local v12    # "str":Ljava/lang/String;
    :cond_6
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ldm/Ui;->drawYesNo(ZZ)V

    goto/16 :goto_0

    .line 514
    .restart local v12    # "str":Ljava/lang/String;
    :cond_7
    iget-byte v0, p0, Lmain/GameRun;->buyOk:B

    const/4 v1, 0x3

    if-ne v0, v1, :cond_5

    const-string v12, "\u4e4b\u524d\u672a\u4fdd\u5b58\u7684\u90e8\u5206\u5c06\u4f1a\u4e22\u5931\uff0c\u662f\u5426\u7ee7\u7eed\uff1f"

    goto :goto_4

    .line 526
    .end local v12    # "str":Ljava/lang/String;
    :sswitch_7
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->drawRectBG()V

    .line 527
    const-string v0, "\u4f60\u8981\u7ee7\u7eed\u6e38\u620f\uff0c\u786e\u5b9a\u5417\uff1f"

    const/16 v1, 0x32

    sub-int v1, v8, v1

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    .line 528
    iget-object v1, p0, Lmain/GameRun;->action_str:[Ljava/lang/String;

    const/16 v0, 0x32

    sub-int v2, v11, v0

    const/16 v0, 0x32

    sub-int v3, v9, v0

    .line 529
    const/16 v4, 0x64

    const/4 v5, 0x2

    const/4 v6, 0x0

    iget-byte v7, p0, Lmain/GameRun;->popMenu:B

    move-object v0, p0

    .line 528
    invoke-virtual/range {v0 .. v7}, Lmain/GameRun;->drawSelectMenu([Ljava/lang/Object;IIIIII)V

    goto/16 :goto_0

    .line 532
    :sswitch_8
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->drawRectBG()V

    .line 533
    const-string v0, "\u6218\u6597\u5931\u8d25\u4e86,\u8bad\u7ec3\u5e08\u7684\u68a6\u60f3\u4e0d\u80fd\u5b9e\u73b0\u4e86!"

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v9, v1}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    .line 534
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ldm/Ui;->drawYesNo(ZZ)V

    goto/16 :goto_0

    .line 537
    :sswitch_9
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->drawRectBG()V

    .line 538
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, -0x5

    const/16 v2, 0x4b

    sub-int v2, v8, v2

    add-int/lit8 v3, v10, 0xa

    const/16 v4, 0x4b

    const/4 v5, 0x3

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawK1(IIIII)V

    .line 539
    const-string v1, "\u6e38\u620f\u6682\u505c\uff0c\u70b9\u51fb\u5c4f\u5e55\u8fd4\u56de\u3002"

    const/16 v0, 0x32

    sub-int v0, v8, v0

    const/4 v2, 0x2

    sub-int v3, v0, v2

    const/16 v4, 0x9

    const/4 v5, 0x3

    move-object v0, p0

    move v2, v11

    invoke-virtual/range {v0 .. v5}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    goto/16 :goto_0

    .line 549
    :sswitch_a
    invoke-direct {p0}, Lmain/GameRun;->drawDarkScreen()V

    goto/16 :goto_0

    .line 552
    :sswitch_b
    const/4 v0, 0x1

    iput-byte v0, p0, Lmain/GameRun;->b_c:B

    .line 553
    const-string v0, "\u4fdd\u5b58\u6e38\u620f\u4e2d"

    const/16 v1, 0x14

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    goto/16 :goto_0

    .line 558
    :sswitch_c
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    const/16 v1, 0x1e

    const/4 v2, 0x1

    invoke-virtual {v0, p1, v1, v2}, Lmain/Map;->drawBlackSRC(Ljavax/microedition/lcdui/Graphics;IZ)V

    .line 559
    const-string v0, "\u7ed3\u675f"

    const/16 v1, 0xa

    sub-int v1, v8, v1

    invoke-virtual {p0, v0, v1}, Lmain/GameRun;->drawZero(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 562
    :sswitch_d
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, v10, v8}, Lmain/GameRun;->drawMY_BAG(IIII)V

    goto/16 :goto_0

    .line 566
    :sswitch_e
    invoke-direct {p0}, Lmain/GameRun;->drawBUY_ITEM()V

    goto/16 :goto_0

    .line 569
    :sswitch_f
    invoke-direct {p0}, Lmain/GameRun;->drawLIST_INFO()V

    goto/16 :goto_0

    .line 572
    :sswitch_10
    invoke-direct {p0}, Lmain/GameRun;->getMonInfo_dir()B

    move-result v0

    invoke-direct {p0, v0}, Lmain/GameRun;->drawMONSTER_INFO(I)V

    goto/16 :goto_0

    .line 576
    :sswitch_11
    iget-byte v0, p0, Lmain/GameRun;->cur_c:B

    if-nez v0, :cond_9

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    const/4 v1, 0x6

    if-ne v0, v1, :cond_8

    iget-object v0, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    :goto_5
    invoke-direct {p0, v0}, Lmain/GameRun;->drawMONSTER_UI([Ldm/Monster;)V

    goto/16 :goto_0

    :cond_8
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    goto :goto_5

    .line 577
    :cond_9
    iget-byte v0, p0, Lmain/GameRun;->cur_c:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_b

    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    const/4 v1, 0x6

    if-ne v0, v1, :cond_a

    iget-object v0, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aget-object v0, v0, v1

    :goto_6
    invoke-direct {p0, v0}, Lmain/GameRun;->drawMagicUI(Ldm/Monster;)V

    goto/16 :goto_0

    :cond_a
    iget-object v0, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    aget-object v0, v0, v1

    goto :goto_6

    .line 578
    :cond_b
    iget-byte v0, p0, Lmain/GameRun;->cur_c:B

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    iget-byte v1, p0, Lmain/GameRun;->selecty:B

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lmain/GameRun;->drawEvolveUI(IIZ)V

    goto/16 :goto_0

    .line 582
    :sswitch_12
    invoke-direct {p0}, Lmain/GameRun;->drawVIEW_COMPUTER()V

    goto/16 :goto_0

    .line 587
    :sswitch_13
    const/16 v0, 0xc8

    const/16 v1, 0xe1

    invoke-direct {p0, v0, v1}, Lmain/GameRun;->drawNidus(II)V

    goto/16 :goto_0

    .line 593
    :sswitch_14
    invoke-static {}, Lminigame/Mg;->i()Lminigame/Mg;

    move-result-object v0

    invoke-virtual {v0}, Lminigame/Mg;->paint()V

    goto/16 :goto_0

    .line 599
    :sswitch_15
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v0

    invoke-virtual {v0}, Lmain/SMSSender;->paint()V

    goto/16 :goto_0

    .line 602
    :sswitch_16
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v0

    invoke-virtual {v0}, Lmain/SMSSender;->paintLevel()V

    goto/16 :goto_0

    .line 426
    :sswitch_data_0
    .sparse-switch
        -0x32 -> :sswitch_2
        -0x20 -> :sswitch_0
        -0x1f -> :sswitch_3
        -0x1e -> :sswitch_a
        -0x15 -> :sswitch_16
        -0x14 -> :sswitch_15
        -0x13 -> :sswitch_4
        -0xf -> :sswitch_5
        -0xb -> :sswitch_0
        -0xa -> :sswitch_1
        0x12 -> :sswitch_e
        0x19 -> :sswitch_d
        0x23 -> :sswitch_11
        0x33 -> :sswitch_c
        0x34 -> :sswitch_0
        0x3c -> :sswitch_8
        0x3d -> :sswitch_7
        0x41 -> :sswitch_12
        0x42 -> :sswitch_13
        0x43 -> :sswitch_10
        0x44 -> :sswitch_f
        0x45 -> :sswitch_14
        0x61 -> :sswitch_6
        0x62 -> :sswitch_9
        0x64 -> :sswitch_b
    .end sparse-switch
.end method

.method public popState()V
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/4 v4, 0x6

    const/4 v7, -0x1

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 2837
    iget-byte v1, p0, Lmain/GameRun;->buyOk:B

    if-nez v1, :cond_1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_Up_Down()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 2838
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-byte v2, p0, Lmain/GameRun;->popMenu:B

    iget-object v3, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    array-length v3, v3

    sub-int/2addr v3, v6

    invoke-virtual {v1, v2, v5, v3}, Ldm/Ms;->select(III)B

    move-result v1

    iput-byte v1, p0, Lmain/GameRun;->popMenu:B

    .line 2955
    :cond_0
    :goto_0
    return-void

    .line 2839
    :cond_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_S1_Num5()Z

    move-result v1

    if-eqz v1, :cond_1f

    .line 2840
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u6280\u80fd"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 2841
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u5929\u8d4b"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 2842
    :cond_2
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    if-ne v1, v4, :cond_4

    iget-object v1, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    :goto_1
    invoke-virtual {p0, v1}, Lmain/GameRun;->initSkillList(Ldm/Monster;)V

    .line 2844
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-lez v1, :cond_6

    .line 2849
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    if-ne v1, v4, :cond_5

    iget-object v1, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x3

    aget-byte v1, v1, v2

    :goto_2
    iput-byte v1, p0, Lmain/GameRun;->bg_c:B

    .line 2852
    :cond_3
    :goto_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u6280\u80fd"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_7

    move v1, v5

    :goto_4
    invoke-direct {p0, v6, v1}, Lmain/GameRun;->restMove(II)V

    goto :goto_0

    .line 2842
    :cond_4
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    goto :goto_1

    .line 2850
    :cond_5
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x3

    aget-byte v1, v1, v2

    goto :goto_2

    .line 2851
    :cond_6
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-gez v1, :cond_3

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v1, v1, Ldm/Battle;->bg_id:B

    iput-byte v1, p0, Lmain/GameRun;->bg_c:B

    goto :goto_3

    :cond_7
    move v1, v6

    .line 2852
    goto :goto_4

    .line 2854
    :cond_8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u53c2\u6218"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 2855
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v5

    if-lez v1, :cond_f

    .line 2856
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-gez v1, :cond_a

    .line 2857
    const/4 v0, 0x1

    .line 2858
    .local v0, "i":B
    :goto_5
    iget-object v1, p0, Lmain/GameRun;->mon_in_battle:[B

    aget-byte v1, v1, v5

    if-le v0, v1, :cond_d

    .line 2863
    :cond_9
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    invoke-virtual {p0, v1}, Lmain/GameRun;->initSkillList(Ldm/Monster;)V

    .line 2865
    .end local v0    # "i":B
    :cond_a
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v5

    invoke-direct {p0, v1, v2}, Lmain/GameRun;->changeMonster(Ldm/Monster;Ldm/Monster;)V

    .line 2866
    iget-object v1, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    aget-byte v1, v1, v5

    invoke-virtual {p0, v8, v1, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 2867
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    invoke-direct {p0, v1}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    .line 2868
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-gez v1, :cond_c

    .line 2869
    invoke-direct {p0}, Lmain/GameRun;->setMyThrow()V

    .line 2870
    const/16 v1, -0x32

    sput v1, Lmain/GameRun;->run_state:I

    .line 2871
    iput-byte v5, p0, Lmain/GameRun;->battle_state:B

    .line 2872
    iget-byte v1, p0, Lmain/GameRun;->view_state:B

    if-ne v1, v7, :cond_b

    .line 2873
    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v6, v1, Ldm/Battle;->act_num:B

    .line 2874
    iget-object v1, p0, Lmain/GameRun;->enB:Ldm/Battle;

    iput-byte v6, v1, Ldm/Battle;->act_num:B

    .line 2876
    :cond_b
    iget-object v1, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v5, v1, Ldm/Battle;->dead:B

    .line 2879
    iput-byte v5, p0, Lmain/GameRun;->first_battle:B

    .line 2881
    :cond_c
    iput-byte v5, p0, Lmain/GameRun;->lastSkill:B

    .line 2883
    :goto_6
    iput-byte v7, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    .line 2859
    .restart local v0    # "i":B
    :cond_d
    iget-object v1, p0, Lmain/GameRun;->mon_in_battle:[B

    aget-byte v1, v1, v0

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v6

    if-eq v1, v2, :cond_9

    .line 2860
    iget-object v1, p0, Lmain/GameRun;->mon_in_battle:[B

    aget-byte v1, v1, v5

    if-ne v0, v1, :cond_e

    iget-object v1, p0, Lmain/GameRun;->mon_in_battle:[B

    iget-object v2, p0, Lmain/GameRun;->mon_in_battle:[B

    aget-byte v3, v2, v5

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    aput-byte v3, v2, v5

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v4, p0, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v5

    aget-byte v4, v4, v5

    aget-object v2, v2, v4

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v6

    aput-byte v2, v1, v3

    .line 2861
    :cond_e
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto/16 :goto_5

    .line 2882
    .end local v0    # "i":B
    :cond_f
    const-string v1, "\u5f53\u524d\u5ba0\u7269\u4e0d\u80fd\u53c2\u6218"

    invoke-virtual {p0, v1, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_6

    .line 2884
    :cond_10
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u8fdb\u5316"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_11

    .line 2885
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    invoke-direct {p0, v1}, Lmain/GameRun;->setEvolveStringB(Ldm/Monster;)V

    .line 2888
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x3

    aget-byte v1, v1, v2

    iput-byte v1, p0, Lmain/GameRun;->bg_c:B

    .line 2889
    iput-byte v5, p0, Lmain/GameRun;->b_c:B

    .line 2890
    invoke-direct {p0, v8, v5}, Lmain/GameRun;->restMove(II)V

    goto/16 :goto_0

    .line 2891
    :cond_11
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u653e\u751f"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_15

    .line 2892
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    invoke-direct {p0, v1}, Lmain/GameRun;->isMyMonsters(I)Z

    move-result v1

    if-nez v1, :cond_12

    .line 2893
    const-string v1, "\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01"

    invoke-virtual {p0, v1, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 2895
    :cond_12
    iget-byte v1, p0, Lmain/GameRun;->buyOk:B

    if-ne v1, v6, :cond_14

    .line 2896
    iput-byte v5, p0, Lmain/GameRun;->buyOk:B

    .line 2897
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    invoke-virtual {p0, v1}, Lmain/GameRun;->delMonster(I)B

    .line 2898
    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    iget-byte v2, p0, Lmain/GameRun;->myMon_length:B

    if-ne v1, v2, :cond_13

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v2, v1, v5

    sub-int/2addr v2, v6

    int-to-byte v2, v2

    aput-byte v2, v1, v5

    .line 2899
    :cond_13
    iget-object v1, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v2, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v3, p0, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v5

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    aget-byte v1, v1, v5

    invoke-virtual {p0, v8, v1, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 2900
    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    invoke-direct {p0, v1}, Lmain/GameRun;->setShowPro(Ldm/Monster;)V

    .line 2901
    sget v1, Lmain/Constants_H;->WIDTH_H:I

    iput v1, p0, Lmain/GameRun;->introT:I

    .line 2902
    iget-byte v1, p0, Lmain/GameRun;->myMon_length:B

    iput-byte v1, p0, Lmain/GameRun;->t_length:B

    .line 2903
    iput-byte v7, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0

    .line 2905
    :cond_14
    iput-byte v6, p0, Lmain/GameRun;->buyOk:B

    .line 2906
    const-string v1, "\u653e\u751f\u7684\u5ba0\u7269\u5c06\u4f1a\u6d88\u5931\uff0c\u662f\u5426\u7ee7\u7eed\uff1f"

    iput-object v1, p0, Lmain/GameRun;->gogoString:Ljava/lang/String;

    goto/16 :goto_0

    .line 2909
    :cond_15
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u5b58\u653e"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_17

    .line 2910
    sget v1, Lmain/GameRun;->run_state:I

    const/16 v2, 0x23

    if-ne v1, v2, :cond_16

    .line 2911
    invoke-direct {p0}, Lmain/GameRun;->putMonster()V

    goto/16 :goto_0

    .line 2913
    :cond_16
    const/4 v1, 0x4

    iput-byte v1, p0, Lmain/GameRun;->mini_state:B

    .line 2914
    iput-byte v6, p0, Lmain/GameRun;->view_state:B

    .line 2915
    invoke-virtual {p0}, Lmain/GameRun;->goVIEW_MONSTER()V

    goto/16 :goto_0

    .line 2917
    :cond_17
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u53d6\u51fa"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_19

    .line 2918
    sget v1, Lmain/GameRun;->run_state:I

    const/16 v2, 0x23

    if-ne v1, v2, :cond_18

    .line 2919
    invoke-direct {p0}, Lmain/GameRun;->takenMonster()V

    goto/16 :goto_0

    .line 2921
    :cond_18
    iput-byte v4, p0, Lmain/GameRun;->mini_state:B

    .line 2922
    iput-byte v6, p0, Lmain/GameRun;->view_state:B

    .line 2923
    invoke-virtual {p0}, Lmain/GameRun;->goVIEW_MONSTER()V

    goto/16 :goto_0

    .line 2925
    :cond_19
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u5356\u5ba0"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1e

    .line 2926
    iget-byte v1, p0, Lmain/GameRun;->buyOk:B

    if-ne v1, v6, :cond_1b

    .line 2927
    iput-byte v5, p0, Lmain/GameRun;->buyOk:B

    .line 2928
    iget v1, p0, Lmain/GameRun;->money:I

    iget v2, p0, Lmain/GameRun;->sell_money:I

    add-int/2addr v1, v2

    iput v1, p0, Lmain/GameRun;->money:I

    .line 2929
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u83b7\u5f97\u91d1\u94b1\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lmain/GameRun;->sell_money:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2930
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    if-ne v1, v4, :cond_1a

    .line 2931
    invoke-direct {p0}, Lmain/GameRun;->setTakenMonster()V

    goto/16 :goto_0

    .line 2932
    :cond_1a
    invoke-direct {p0}, Lmain/GameRun;->setPutMonster()V

    goto/16 :goto_0

    .line 2934
    :cond_1b
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1c

    iget-object v1, p0, Lmain/GameRun;->select:[[B

    aget-object v1, v1, v5

    aget-byte v1, v1, v5

    invoke-direct {p0, v1}, Lmain/GameRun;->isMyMonsters(I)Z

    move-result v1

    if-nez v1, :cond_1c

    .line 2935
    const-string v1, "\u8eab\u4e0a\u5fc5\u987b\u643a\u5e26\u4e00\u53ea\u80fd\u53c2\u6218\u7684\u5ba0\u7269\uff01"

    invoke-virtual {p0, v1, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 2937
    :cond_1c
    iput-byte v6, p0, Lmain/GameRun;->buyOk:B

    .line 2938
    iget-byte v1, p0, Lmain/GameRun;->mini_state:B

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1d

    iget-object v1, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    :goto_7
    invoke-direct {p0, v1}, Lmain/GameRun;->sellMonster(Ldm/Monster;)V

    .line 2939
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u83b7\u5f97\u91d1\u94b1\uff1a"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p0, Lmain/GameRun;->sell_money:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\uff0c\u662f\u5426\u5356\u51fa\uff1f"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lmain/GameRun;->gogoString:Ljava/lang/String;

    goto/16 :goto_0

    .line 2938
    :cond_1d
    iget-object v1, p0, Lmain/GameRun;->cMonsters:[Ldm/Monster;

    iget-object v2, p0, Lmain/GameRun;->select:[[B

    aget-object v2, v2, v5

    aget-byte v2, v2, v5

    aget-object v1, v1, v2

    goto :goto_7

    .line 2942
    :cond_1e
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    iget-byte v3, p0, Lmain/GameRun;->popMenu:B

    aget-object v2, v2, v3

    const-string v3, "\u79bb\u5f00"

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2943
    invoke-direct {p0, v5}, Lmain/GameRun;->goRUN_IN_MAP(Z)V

    goto/16 :goto_0

    .line 2944
    :cond_1f
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_S2()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2948
    iget-byte v1, p0, Lmain/GameRun;->buyOk:B

    if-eqz v1, :cond_20

    iput-byte v5, p0, Lmain/GameRun;->buyOk:B

    goto/16 :goto_0

    .line 2950
    :cond_20
    sget v1, Lmain/GameRun;->run_state:I

    const/16 v2, 0x41

    if-ne v1, v2, :cond_21

    .line 2951
    invoke-direct {p0, v5}, Lmain/GameRun;->goRUN_IN_MAP(Z)V

    goto/16 :goto_0

    .line 2952
    :cond_21
    iput-byte v7, p0, Lmain/GameRun;->popMenu:B

    goto/16 :goto_0
.end method

.method public runPauseIco()Z
    .locals 11

    .prologue
    const/4 v10, 0x3

    const/16 v9, 0xa

    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, 0x2

    .line 5885
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_0
    iget-byte v1, p0, Lmain/GameRun;->b_ico:B

    if-lt v0, v1, :cond_0

    move v1, v7

    .line 5917
    :goto_1
    return v1

    .line 5888
    :cond_0
    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, v1, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->state:B

    if-nez v1, :cond_b

    iget-object v1, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v2, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v2, v2, Lmain/PointerKey;->button_pos:[[[I

    aget-object v2, v2, v9

    aget-object v2, v2, v0

    aget v2, v2, v7

    iget-object v3, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v3, v3, Lmain/PointerKey;->button_pos:[[[I

    aget-object v3, v3, v9

    aget-object v3, v3, v0

    aget v3, v3, v8

    iget-object v4, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v4, v4, Lmain/PointerKey;->button_pos:[[[I

    aget-object v4, v4, v9

    aget-object v4, v4, v0

    aget v4, v4, v6

    iget-object v5, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    iget-object v5, v5, Lmain/PointerKey;->button_pos:[[[I

    aget-object v5, v5, v9

    aget-object v5, v5, v0

    aget v5, v5, v10

    invoke-virtual {v1, v2, v3, v4, v5}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 5889
    iget-byte v1, p0, Lmain/GameRun;->b_ico:B

    if-ne v1, v6, :cond_1

    .line 5890
    iput-boolean v7, p0, Lmain/GameRun;->isTalk:Z

    .line 5891
    iget-object v1, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v1}, Lmain/PointerKey;->setKey5()V

    .line 5893
    :cond_1
    iget-object v1, p0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    invoke-virtual {v1}, Lmain/PointerKey;->initPointer()V

    .line 5896
    if-nez v0, :cond_4

    iget-byte v1, p0, Lmain/GameRun;->b_ico:B

    if-ne v1, v6, :cond_3

    const/4 v1, 0x7

    :goto_2
    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/GameRun;->b_ico:B

    :cond_2
    :goto_3
    move v1, v8

    .line 5914
    goto :goto_1

    :cond_3
    move v1, v6

    .line 5896
    goto :goto_2

    .line 5898
    :cond_4
    sget v1, Lmain/GameRun;->run_state:I

    const/16 v2, 0x62

    if-eq v1, v2, :cond_2

    .line 5899
    if-ne v0, v10, :cond_5

    .line 5900
    invoke-virtual {p0, v7}, Lmain/GameRun;->goYouPAUSE(I)V

    .line 5912
    :goto_4
    iput-byte v6, p0, Lmain/GameRun;->b_ico:B

    goto :goto_3

    .line 5901
    :cond_5
    const/4 v1, 0x6

    if-ne v0, v1, :cond_6

    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    invoke-virtual {v1, v7, v8}, Lmain/SMSSender;->go(IZ)V

    goto :goto_4

    .line 5903
    :cond_6
    if-ne v0, v6, :cond_8

    const/16 v1, 0x30

    sput v1, Ldm/Ms;->key:I

    .line 5910
    :cond_7
    :goto_5
    sput-boolean v8, Ldm/Ms;->keyRepeat:Z

    goto :goto_4

    .line 5904
    :cond_8
    const/4 v1, 0x4

    if-ne v0, v1, :cond_9

    const/16 v1, 0x31

    sput v1, Ldm/Ms;->key:I

    goto :goto_5

    .line 5905
    :cond_9
    const/4 v1, 0x5

    if-ne v0, v1, :cond_a

    const/16 v1, 0x33

    sput v1, Ldm/Ms;->key:I

    goto :goto_5

    .line 5906
    :cond_a
    if-ne v0, v8, :cond_7

    const/16 v1, 0x39

    sput v1, Ldm/Ms;->key:I

    goto :goto_5

    .line 5885
    :cond_b
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto/16 :goto_0
.end method

.method public run_gameRun()V
    .locals 13

    .prologue
    .line 243
    sget v9, Lmain/GameRun;->run_state:I

    sparse-switch v9, :sswitch_data_0

    .line 418
    :cond_0
    :goto_0
    :sswitch_0
    return-void

    .line 245
    :sswitch_1
    iget-object v9, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v9}, Lmain/Map;->run_map()V

    goto :goto_0

    .line 248
    :sswitch_2
    invoke-direct {p0}, Lmain/GameRun;->runMonsterAppear()V

    goto :goto_0

    .line 251
    :sswitch_3
    invoke-direct {p0}, Lmain/GameRun;->runBattleState()V

    goto :goto_0

    .line 254
    :sswitch_4
    iget-short v9, p0, Lmain/GameRun;->cThrowX:S

    if-nez v9, :cond_7

    iget-byte v9, p0, Lmain/GameRun;->b_c:B

    if-nez v9, :cond_7

    .line 255
    iget-object v9, p0, Lmain/GameRun;->items:[[[B

    iget-byte v10, p0, Lmain/GameRun;->selectx:B

    aget-object v9, v9, v10

    iget-object v10, p0, Lmain/GameRun;->select:[[B

    const/4 v11, 0x0

    aget-object v10, v10, v11

    const/4 v11, 0x0

    aget-byte v10, v10, v11

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-byte v4, v9, v10

    .line 256
    .local v4, "id":B
    const/4 v9, 0x1

    invoke-virtual {p0, v4, v9}, Lmain/GameRun;->deleteItems(II)V

    .line 257
    const/4 v9, 0x3

    new-array v0, v9, [B

    fill-array-data v0, :array_0

    .line 260
    .local v0, "CatchBall":[B
    const/16 v9, 0x9

    sub-int v9, v4, v9

    aget-byte v9, v0, v9

    mul-int/lit8 v9, v9, 0x1e

    add-int/lit8 v9, v9, 0x32

    iget-object v10, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v10}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v10

    iget-object v10, v10, Ldm/Monster;->monster:[B

    const/4 v11, 0x2

    aget-byte v10, v10, v11

    sub-int/2addr v9, v10

    .line 261
    const/16 v10, 0x3c

    iget-object v11, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v11}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v11

    iget-object v11, v11, Ldm/Monster;->monster:[B

    const/4 v12, 0x2

    aget-byte v11, v11, v12

    div-int/2addr v10, v11

    .line 260
    add-int/2addr v9, v10

    .line 262
    iget-object v10, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v10}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v10

    iget-object v10, v10, Ldm/Monster;->monsterPro:[S

    const/4 v11, 0x0

    aget-short v10, v10, v11

    mul-int/lit8 v10, v10, 0x64

    .line 263
    iget-object v11, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v11}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v11

    iget-object v11, v11, Ldm/Monster;->monsterPro:[S

    const/4 v12, 0x2

    aget-short v11, v11, v12

    .line 262
    div-int/2addr v10, v11

    .line 260
    sub-int/2addr v9, v10

    int-to-short v2, v9

    .line 270
    .local v2, "getRate":S
    const/4 v9, 0x7

    iget-object v10, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v10}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v10

    iget-object v10, v10, Ldm/Monster;->monster:[B

    const/4 v11, 0x5

    aget-byte v10, v10, v11

    const/4 v11, 0x1

    sub-int/2addr v10, v11

    mul-int/lit8 v10, v10, 0x2

    sub-int/2addr v9, v10

    mul-int/2addr v9, v2

    div-int/lit8 v9, v9, 0xa

    int-to-short v2, v9

    .line 272
    iget-object v9, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v9}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v9

    const/4 v10, 0x3

    invoke-virtual {v9, v10}, Ldm/Monster;->isEffect(I)Z

    move-result v9

    if-eqz v9, :cond_1

    add-int/lit8 v9, v2, 0x1e

    int-to-short v2, v9

    .line 274
    :cond_1
    const/4 v0, 0x0

    check-cast v0, [B

    .line 275
    iget-byte v9, p0, Lmain/GameRun;->cMon_count:B

    iget-byte v10, p0, Lmain/GameRun;->max_monsters:B

    if-ne v9, v10, :cond_2

    iget-byte v9, p0, Lmain/GameRun;->myMon_length:B

    iget-byte v10, p0, Lmain/GameRun;->max_takes:B

    if-ne v9, v10, :cond_2

    .line 276
    const-string v9, "\u6240\u80fd\u643a\u5e26\u7684\u5ba0\u7269\u5df2\u7ecf\u8fbe\u5230\u4e0a\u9650\uff01"

    const/4 v10, -0x1

    invoke-virtual {p0, v9, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 277
    iget-object v9, p0, Lmain/GameRun;->enB:Ldm/Battle;

    const/4 v10, 0x1

    iput-byte v10, v9, Ldm/Battle;->act_num:B

    .line 278
    iget-object v9, p0, Lmain/GameRun;->myB:Ldm/Battle;

    const/4 v10, 0x0

    iput-byte v10, v9, Ldm/Battle;->act_num:B

    .line 279
    const/16 v9, -0x1f

    sput v9, Lmain/GameRun;->run_state:I

    .line 280
    const/16 v9, 0x9

    iput-byte v9, p0, Lmain/GameRun;->battle_state:B

    goto/16 :goto_0

    .line 281
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v9, 0x64

    invoke-static {v9}, Ldm/Ms;->getRandom(I)I

    move-result v9

    if-ge v9, v2, :cond_4

    .line 283
    iget-object v9, p0, Lmain/GameRun;->enB:Ldm/Battle;

    const/4 v10, 0x2

    iput-byte v10, v9, Ldm/Battle;->action:B

    .line 284
    iget-object v9, p0, Lmain/GameRun;->enB:Ldm/Battle;

    const/4 v10, 0x1

    iput-byte v10, v9, Ldm/Battle;->dead:B

    .line 285
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "\u6355\u83b7"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v10, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v10}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v10

    iget-object v10, v10, Ldm/Monster;->monster:[B

    const/4 v11, 0x0

    aget-byte v10, v10, v11

    invoke-virtual {p0, v10}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "\u5df2\u6210\u529f\uff01"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    invoke-virtual {p0, v9, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 286
    iget-object v9, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v9}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v9

    const/4 v10, -0x1

    const/4 v11, 0x0

    invoke-direct {p0, v9, v10, v11}, Lmain/GameRun;->getMonster(Ldm/Monster;IZ)B

    move-result v9

    if-nez v9, :cond_3

    .line 287
    iget-object v9, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v10, p0, Lmain/GameRun;->myMon_length:B

    const/4 v11, 0x1

    sub-int/2addr v10, v11

    aget-object v9, v9, v10

    iget-object v9, v9, Ldm/Monster;->monster:[B

    const/4 v10, 0x1

    iget-byte v11, p0, Lmain/GameRun;->myMon_length:B

    const/4 v12, 0x1

    sub-int/2addr v11, v12

    int-to-byte v11, v11

    aput-byte v11, v9, v10

    .line 288
    :cond_3
    const/16 v9, -0x1f

    sput v9, Lmain/GameRun;->run_state:I

    .line 289
    const/4 v9, 0x0

    invoke-direct {p0, v9}, Lmain/GameRun;->goBattleExp(Z)V

    goto/16 :goto_0

    .line 291
    :cond_4
    const/4 v9, 0x1

    iput-byte v9, p0, Lmain/GameRun;->b_c:B

    .line 292
    new-instance v8, Ljava/lang/StringBuffer;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "\u6ca1\u6709\u6355\u83b7\u5230"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v10, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v10}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v10

    iget-object v10, v10, Ldm/Monster;->monster:[B

    const/4 v11, 0x0

    aget-byte v10, v10, v11

    invoke-virtual {p0, v10}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 293
    .local v8, "str":Ljava/lang/StringBuffer;
    iget-object v9, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v9}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v9

    const/16 v10, 0x29

    invoke-virtual {v9, v10}, Ldm/Monster;->isMonReel(I)Z

    move-result v9

    if-nez v9, :cond_5

    iget-object v9, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v9}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v9

    const/4 v10, 0x4

    invoke-virtual {v9, v10}, Ldm/Monster;->isEffect(I)Z

    move-result v9

    if-nez v9, :cond_5

    .line 294
    iget-object v9, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v9}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v9

    const/4 v10, 0x3

    invoke-virtual {v9, v10}, Ldm/Monster;->isEffect(I)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 295
    :cond_5
    iget-object v9, p0, Lmain/GameRun;->enB:Ldm/Battle;

    const/4 v10, 0x1

    iput-byte v10, v9, Ldm/Battle;->act_num:B

    .line 296
    iget-object v9, p0, Lmain/GameRun;->myB:Ldm/Battle;

    const/4 v10, 0x0

    iput-byte v10, v9, Ldm/Battle;->act_num:B

    .line 297
    const/16 v9, -0x1f

    sput v9, Lmain/GameRun;->run_state:I

    .line 298
    const/16 v9, 0x9

    iput-byte v9, p0, Lmain/GameRun;->battle_state:B

    .line 304
    .end local v0    # "CatchBall":[B
    :goto_1
    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    invoke-virtual {p0, v9, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 300
    .restart local v0    # "CatchBall":[B
    :cond_6
    const/4 v9, 0x3

    new-array v5, v9, [Ljava/lang/String;

    const/4 v9, 0x0

    const-string v10, "\u6d41\u7740\u6cea\u9003\u8dd1\u4e86\uff01"

    aput-object v10, v5, v9

    const/4 v9, 0x1

    const-string v10, "\u62fc\u4e86\u547d\u7684\u9003\u8dd1\u4e86\uff01"

    aput-object v10, v5, v9

    const/4 v9, 0x2

    const-string v10, "\u76ef\u4e86\u4f60\u4e00\u773c\uff0c\u9003\u8d70\u4e86\uff01"

    aput-object v10, v5, v9

    .line 301
    .local v5, "s":[Ljava/lang/String;
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "#n"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v10, p0, Lmain/GameRun;->enB:Ldm/Battle;

    invoke-virtual {v10}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v10

    iget-object v10, v10, Ldm/Monster;->monster:[B

    const/4 v11, 0x0

    aget-byte v10, v10, v11

    invoke-virtual {p0, v10}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v10, 0x3

    invoke-static {v10}, Ldm/Ms;->getRandom(I)I

    move-result v10

    aget-object v10, v5, v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 302
    const/4 v0, 0x0

    check-cast v0, [Ljava/lang/String;

    .end local v0    # "CatchBall":[B
    goto :goto_1

    .line 307
    .end local v2    # "getRate":S
    .end local v4    # "id":B
    .end local v5    # "s":[Ljava/lang/String;
    .end local v8    # "str":Ljava/lang/StringBuffer;
    :cond_7
    iget-byte v9, p0, Lmain/GameRun;->b_c:B

    const/4 v10, 0x1

    if-ne v9, v10, :cond_0

    iget-byte v9, p0, Lmain/GameRun;->say_c:B

    if-nez v9, :cond_0

    .line 308
    invoke-direct {p0}, Lmain/GameRun;->arangeMonster()V

    .line 309
    invoke-direct {p0}, Lmain/GameRun;->setNullBattle()V

    .line 310
    invoke-direct {p0}, Lmain/GameRun;->goGO_RUNINMAP()V

    goto/16 :goto_0

    .line 315
    :sswitch_5
    iget-byte v9, p0, Lmain/GameRun;->b_c:B

    if-nez v9, :cond_14

    .line 316
    iget-object v9, p0, Lmain/GameRun;->levelUp_in_battle:[[B

    iget-object v10, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v10}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v10

    iget-object v10, v10, Ldm/Monster;->monster:[B

    const/4 v11, 0x1

    aget-byte v10, v10, v11

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-byte v9, v9, v10

    const/4 v10, 0x1

    if-ne v9, v10, :cond_c

    .line 317
    iget-object v9, p0, Lmain/GameRun;->levelUp_in_battle:[[B

    iget-object v10, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v10}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v10

    iget-object v10, v10, Ldm/Monster;->monster:[B

    const/4 v11, 0x1

    aget-byte v10, v10, v11

    aget-object v9, v9, v10

    const/4 v10, 0x0

    const/4 v11, 0x0

    aput-byte v11, v9, v10

    .line 318
    const/4 v9, 0x1

    iput-byte v9, p0, Lmain/GameRun;->b_c:B

    .line 319
    const/16 v9, 0x34

    iput v9, p0, Lmain/GameRun;->say_s:I

    .line 320
    iget-object v9, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v9, v9, Ldm/Battle;->now_id:B

    const/4 v10, 0x1

    invoke-virtual {p0, v9, v10}, Lmain/GameRun;->levelPro(IZ)V

    .line 321
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "\u751f\u547d;+"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v10, p0, Lmain/GameRun;->proReplace:[[S

    iget-object v11, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v11, v11, Ldm/Battle;->now_id:B

    aget-object v10, v10, v11

    const/4 v11, 0x0

    aget-short v10, v10, v11

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "#n"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 322
    const-string v10, "\u80fd\u91cf"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ";+"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lmain/GameRun;->proReplace:[[S

    iget-object v11, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v11, v11, Ldm/Battle;->now_id:B

    aget-object v10, v10, v11

    const/4 v11, 0x1

    aget-short v10, v10, v11

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    sget v10, Lmain/Constants_H;->WIDTH:I

    const/4 v11, 0x0

    .line 321
    invoke-virtual {p0, v9, v10, v11}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 323
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "\u529b\u91cf;+"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v10, p0, Lmain/GameRun;->proReplace:[[S

    iget-object v11, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v11, v11, Ldm/Battle;->now_id:B

    aget-object v10, v10, v11

    const/4 v11, 0x3

    aget-short v10, v10, v11

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "#n"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 324
    const-string v10, "\u9632\u5fa1"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ";+"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lmain/GameRun;->proReplace:[[S

    iget-object v11, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v11, v11, Ldm/Battle;->now_id:B

    aget-object v10, v10, v11

    const/4 v11, 0x4

    aget-short v10, v10, v11

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "#n"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    .line 325
    const-string v10, "\u654f\u6377"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, ";+"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lmain/GameRun;->proReplace:[[S

    iget-object v11, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v11, v11, Ldm/Battle;->now_id:B

    aget-object v10, v10, v11

    const/4 v11, 0x5

    aget-short v10, v10, v11

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    sget v10, Lmain/Constants_H;->WIDTH:I

    const/4 v11, 0x1

    .line 323
    invoke-virtual {p0, v9, v10, v11}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 326
    const/4 v9, 0x2

    iget-object v10, p0, Lmain/GameRun;->mList_id:[[B

    iget-object v11, p0, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v11}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v11

    iget-object v11, v11, Ldm/Monster;->monster:[B

    const/4 v12, 0x0

    aget-byte v11, v11, v12

    aget-object v10, v10, v11

    const/4 v11, 0x0

    aget-byte v10, v10, v11

    const/4 v11, 0x1

    invoke-virtual {p0, v9, v10, v11}, Lmain/GameRun;->initMonStream(III)V

    .line 328
    :goto_2
    iget-object v9, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v9, v9, Ldm/Battle;->now_id:B

    iget-byte v10, p0, Lmain/GameRun;->myMon_length:B

    if-lt v9, v10, :cond_0

    .line 329
    const/4 v3, 0x0

    .line 330
    .local v3, "i":B
    const/4 v1, 0x0

    .line 331
    .local v1, "b":Z
    new-instance v6, Ljava/lang/StringBuffer;

    const-string v9, ""

    invoke-direct {v6, v9}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 332
    .local v6, "sbuf":Ljava/lang/StringBuffer;
    :goto_3
    iget-byte v9, p0, Lmain/GameRun;->myMon_length:B

    if-lt v3, v9, :cond_d

    .line 341
    if-eqz v1, :cond_8

    const-string v9, "\u53ef\u4ee5\u8fdb\u5316\u4e86"

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 342
    :cond_8
    new-instance v7, Ljava/lang/StringBuffer;

    const-string v9, ""

    invoke-direct {v7, v9}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 343
    .local v7, "sbuf0":Ljava/lang/StringBuffer;
    const/4 v1, 0x0

    .line 345
    const/4 v3, 0x0

    :goto_4
    const/4 v9, 0x5

    if-lt v3, v9, :cond_10

    .line 351
    if-eqz v1, :cond_a

    .line 352
    const-string v9, "\u7ecf\u9a8c\u5df2\u6ee1\uff0c\u53ef\u4ee5\u5b75\u5316\u4e86\u3002"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 353
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v9

    const-string v10, ""

    invoke-virtual {v9, v6, v10}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_9

    const-string v9, "#n"

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 354
    :cond_9
    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 357
    :cond_a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v9

    const-string v10, ""

    invoke-virtual {v9, v6, v10}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_b

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v10, -0x1

    invoke-virtual {p0, v9, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 358
    :cond_b
    const/4 v6, 0x0

    .line 359
    const/4 v7, 0x0

    .line 360
    invoke-direct {p0}, Lmain/GameRun;->setNullBattle()V

    .line 361
    invoke-direct {p0}, Lmain/GameRun;->goGO_RUNINMAP()V

    goto/16 :goto_0

    .line 327
    .end local v1    # "b":Z
    .end local v3    # "i":B
    .end local v6    # "sbuf":Ljava/lang/StringBuffer;
    .end local v7    # "sbuf0":Ljava/lang/StringBuffer;
    :cond_c
    iget-object v9, p0, Lmain/GameRun;->myB:Ldm/Battle;

    iget-byte v10, v9, Ldm/Battle;->now_id:B

    add-int/lit8 v10, v10, 0x1

    int-to-byte v10, v10

    iput-byte v10, v9, Ldm/Battle;->now_id:B

    goto :goto_2

    .line 333
    .restart local v1    # "b":Z
    .restart local v3    # "i":B
    .restart local v6    # "sbuf":Ljava/lang/StringBuffer;
    :cond_d
    iget-object v9, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v9, v9, v3

    iget-object v9, v9, Ldm/Monster;->monster:[B

    const/4 v10, 0x5

    aget-byte v9, v9, v10

    if-lez v9, :cond_f

    iget-object v9, p0, Lmain/GameRun;->evolve:[Z

    aget-boolean v9, v9, v3

    if-eqz v9, :cond_f

    .line 334
    iget-object v9, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v9, v9, v3

    iget-object v9, v9, Ldm/Monster;->monster:[B

    const/4 v10, 0x4

    aget-byte v9, v9, v10

    iget-object v10, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v10, v10, v3

    iget-object v10, v10, Ldm/Monster;->monster:[B

    const/4 v11, 0x2

    aget-byte v10, v10, v11

    invoke-direct {p0, v9, v10}, Lmain/GameRun;->isEvolveKind(BB)B

    move-result v9

    const/4 v10, -0x1

    if-ne v9, v10, :cond_f

    .line 335
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v9

    const-string v10, ""

    invoke-virtual {v9, v6, v10}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_e

    const-string v9, "\u3001"

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 336
    :cond_e
    iget-object v9, p0, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v9, v9, v3

    iget-object v9, v9, Ldm/Monster;->monster:[B

    const/4 v10, 0x0

    aget-byte v9, v9, v10

    invoke-virtual {p0, v9}, Lmain/GameRun;->getNameMon(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 337
    iget-object v9, p0, Lmain/GameRun;->evolve:[Z

    const/4 v10, 0x0

    aput-boolean v10, v9, v3

    .line 338
    const/4 v1, 0x1

    .line 332
    :cond_f
    add-int/lit8 v9, v3, 0x1

    int-to-byte v3, v9

    goto/16 :goto_3

    .line 346
    .restart local v7    # "sbuf0":Ljava/lang/StringBuffer;
    :cond_10
    invoke-virtual {p0, v3}, Lmain/GameRun;->getRid(I)B

    move-result v9

    const/4 v10, -0x2

    if-eq v9, v10, :cond_11

    const/4 v9, 0x1

    invoke-virtual {p0, v3, v9}, Lmain/GameRun;->getNexp(II)S

    move-result v9

    const/4 v10, 0x3

    invoke-virtual {p0, v3, v10}, Lmain/GameRun;->getNexp(II)S

    move-result v10

    if-eq v9, v10, :cond_12

    .line 345
    :cond_11
    :goto_5
    add-int/lit8 v9, v3, 0x1

    int-to-byte v3, v9

    goto/16 :goto_4

    .line 347
    :cond_12
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v9

    const-string v10, ""

    invoke-virtual {v9, v7, v10}, Ldm/Ms;->equals(Ljava/lang/StringBuffer;Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_13

    const-string v9, "\u3001"

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 348
    :cond_13
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v10, p0, Lmain/GameRun;->monsterT:[Ljava/lang/StringBuffer;

    iget-object v11, p0, Lmain/GameRun;->monster_pro:[[B

    invoke-virtual {p0, v3}, Lmain/GameRun;->getNid(I)B

    move-result v12

    aget-object v11, v11, v12

    const/4 v12, 0x6

    aget-byte v11, v11, v12

    aget-object v10, v10, v11

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "\u7684\u5ba0\u7269\u86cb"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 349
    const/4 v1, 0x1

    goto :goto_5

    .line 363
    .end local v1    # "b":Z
    .end local v3    # "i":B
    .end local v6    # "sbuf":Ljava/lang/StringBuffer;
    .end local v7    # "sbuf0":Ljava/lang/StringBuffer;
    :cond_14
    iget-byte v9, p0, Lmain/GameRun;->b_c:B

    const/4 v10, 0x1

    if-ne v9, v10, :cond_0

    .line 364
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v9

    iget v10, p0, Lmain/GameRun;->say_s:I

    const/4 v11, 0x4

    const/4 v12, 0x1

    invoke-virtual {v9, v10, v11, v12}, Ldm/Ms;->mathSpeedDown(IIZ)S

    move-result v9

    iput v9, p0, Lmain/GameRun;->say_s:I

    goto/16 :goto_0

    .line 373
    :sswitch_6
    const/4 v9, 0x0

    invoke-direct {p0, v9}, Lmain/GameRun;->goRUN_IN_MAP(Z)V

    goto/16 :goto_0

    .line 376
    :sswitch_7
    iget-byte v9, p0, Lmain/GameRun;->createOver:B

    const/4 v10, -0x1

    if-ne v9, v10, :cond_0

    iget-byte v9, p0, Lmain/GameRun;->b_c:B

    add-int/lit8 v9, v9, 0x1

    int-to-byte v9, v9

    iput-byte v9, p0, Lmain/GameRun;->b_c:B

    const/16 v10, 0x8

    if-lt v9, v10, :cond_0

    .line 377
    invoke-direct {p0}, Lmain/GameRun;->goMontsterAppear()V

    goto/16 :goto_0

    .line 381
    :sswitch_8
    iget-byte v9, p0, Lmain/GameRun;->b_c:B

    const/4 v10, 0x1

    if-ne v9, v10, :cond_0

    .line 382
    invoke-virtual {p0}, Lmain/GameRun;->saveGame()V

    .line 383
    const-string v9, "\u6e38\u620f\u5df2\u4fdd\u5b58\u3002"

    const/4 v10, 0x0

    invoke-virtual {p0, v9, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 384
    const/4 v9, 0x0

    iput-byte v9, p0, Lmain/GameRun;->b_c:B

    .line 385
    const/4 v9, 0x1

    invoke-direct {p0, v9}, Lmain/GameRun;->goRUN_IN_MAP(Z)V

    goto/16 :goto_0

    .line 396
    :sswitch_9
    iget-byte v9, p0, Lmain/GameRun;->mon_action_c:B

    add-int/lit8 v9, v9, 0x1

    int-to-byte v9, v9

    iput-byte v9, p0, Lmain/GameRun;->mon_action_c:B

    const/16 v10, 0x32

    if-le v9, v10, :cond_15

    .line 397
    const/4 v9, 0x0

    iput-byte v9, p0, Lmain/GameRun;->mon_action_c:B

    .line 398
    const/4 v9, 0x1

    iput-byte v9, p0, Lmain/GameRun;->mon_action:B

    .line 400
    :cond_15
    iget-byte v9, p0, Lmain/GameRun;->cur_c:B

    const/4 v10, 0x2

    if-ne v9, v10, :cond_0

    iget-byte v9, p0, Lmain/GameRun;->b_c:B

    const/4 v10, -0x1

    if-ne v9, v10, :cond_0

    iget v9, p0, Lmain/GameRun;->say_s:I

    if-nez v9, :cond_0

    .line 401
    invoke-direct {p0}, Lmain/GameRun;->goView()V

    goto/16 :goto_0

    .line 406
    :sswitch_a
    invoke-static {}, Lminigame/Mg;->i()Lminigame/Mg;

    move-result-object v9

    invoke-virtual {v9}, Lminigame/Mg;->run()V

    goto/16 :goto_0

    .line 411
    :sswitch_b
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v9

    invoke-virtual {v9}, Lmain/SMSSender;->run()V

    goto/16 :goto_0

    .line 414
    :sswitch_c
    invoke-static {p0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v9

    invoke-virtual {v9}, Lmain/SMSSender;->runLevel()V

    goto/16 :goto_0

    .line 243
    nop

    :sswitch_data_0
    .sparse-switch
        -0x57 -> :sswitch_0
        -0x56 -> :sswitch_5
        -0x32 -> :sswitch_2
        -0x1f -> :sswitch_3
        -0x1e -> :sswitch_7
        -0x15 -> :sswitch_c
        -0x14 -> :sswitch_b
        -0x13 -> :sswitch_4
        -0xf -> :sswitch_5
        -0xb -> :sswitch_6
        -0xa -> :sswitch_1
        0x23 -> :sswitch_9
        0x45 -> :sswitch_a
        0x64 -> :sswitch_8
    .end sparse-switch

    .line 257
    :array_0
    .array-data 1
        0x1t
        0x3t
        0xet
    .end array-data
.end method

.method public saveGame()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x0

    .line 219
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0}, Lmain/Map;->save()V

    .line 220
    invoke-virtual {p0, v3}, Lmain/GameRun;->saveMon(I)V

    .line 221
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lmain/GameRun;->saveMon(I)V

    .line 222
    invoke-virtual {p0}, Lmain/GameRun;->saveItem()V

    .line 224
    invoke-virtual {p0}, Lmain/GameRun;->saveInfoList()V

    .line 225
    iget-object v0, p0, Lmain/GameRun;->rmsOther:[B

    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v1, v1, Lmain/Map;->mapNo:B

    aput-byte v1, v0, v3

    .line 226
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/16 v1, 0xa

    iget-object v2, p0, Lmain/GameRun;->rmsOther:[B

    invoke-virtual {v0, v1, v2, v4}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 228
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x3

    iget-object v2, p0, Lmain/GameRun;->rmsNidus:[B

    invoke-virtual {v0, v1, v2, v4}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 234
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x4

    invoke-virtual {v0, v3, v1, v2}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 238
    return-void
.end method

.method public say(Ljava/lang/String;I)V
    .locals 3
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "flag"    # I

    .prologue
    .line 3928
    const-string v1, "soars"

    invoke-static {v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 3929
    const-string v0, "\u83dc\u5355\u952e"

    .line 3930
    .local v0, "soars":Ljava/lang/String;
    const-string v1, "#7\u70b9\u51fb\u5c4f\u5e55\u6216\u7528\u5bfc\u822a\u952e#0\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8\u3002"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 3932
    const-string p1, "#7\u70b9\u51fb\u5c4f\u5e55#0\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8\u3002"

    .line 3939
    :cond_0
    :goto_0
    iget-object v1, p0, Lmain/GameRun;->sayStr:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3940
    iget-object v1, p0, Lmain/GameRun;->sayFlag:Ljava/util/ArrayList;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3941
    invoke-virtual {p0}, Lmain/GameRun;->setSay()V

    .line 3942
    return-void

    .line 3933
    :cond_1
    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 3935
    const-string v1, "\u83dc\u5355\u952e"

    const-string v2, "\u53f3\u4e0b\u65b9\u5de5\u5177\u6309\u94ae"

    invoke-virtual {p1, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    goto :goto_0
.end method

.method public say(Ljava/lang/String;II)V
    .locals 6
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "flag"    # I
    .param p3, "sayOverSms"    # I

    .prologue
    const/16 v5, 0xf

    const/4 v4, 0x1

    const/4 v3, -0x1

    .line 3971
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    sget v1, Lmain/Constants_H;->WIDTH:I

    const/16 v2, 0x32

    sub-int/2addr v1, v2

    invoke-virtual {v0, p1, v1}, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;

    move-result-object v0

    iput-object v0, p0, Lmain/GameRun;->showS:[Ljava/lang/StringBuffer;

    .line 3972
    sget v0, Lmain/Constants_H;->WIDTH:I

    iput v0, p0, Lmain/GameRun;->say_s:I

    .line 3973
    const/4 v0, 0x0

    iput-byte v0, p0, Lmain/GameRun;->say_mode:B

    .line 3974
    if-nez p2, :cond_1

    .line 3975
    iput-byte v5, p0, Lmain/GameRun;->say_c:B

    .line 3984
    :cond_0
    :goto_0
    return-void

    .line 3976
    :cond_1
    if-ne p2, v3, :cond_2

    .line 3977
    iput-byte v3, p0, Lmain/GameRun;->say_c:B

    .line 3979
    int-to-byte v0, p3

    iput-byte v0, p0, Lmain/GameRun;->sayOverSms:B

    goto :goto_0

    .line 3980
    :cond_2
    if-ne p2, v4, :cond_0

    .line 3981
    iput-byte v5, p0, Lmain/GameRun;->say_c:B

    .line 3982
    iput-byte v4, p0, Lmain/GameRun;->say_mode:B

    goto :goto_0
.end method

.method public setAimBattle(I)V
    .locals 2
    .param p1, "state"    # I

    .prologue
    const/4 v1, 0x1

    .line 5609
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/GameRun;->mini_state:B

    .line 5610
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    :goto_0
    iput-object v0, p0, Lmain/GameRun;->am:Ldm/Battle;

    .line 5611
    iget-byte v0, p0, Lmain/GameRun;->mini_state:B

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    :goto_1
    iput-object v0, p0, Lmain/GameRun;->dm:Ldm/Battle;

    .line 5612
    return-void

    .line 5610
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->enB:Ldm/Battle;

    goto :goto_0

    .line 5611
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->myB:Ldm/Battle;

    goto :goto_1
.end method

.method public setMagic(I)V
    .locals 2
    .param p1, "pro"    # I

    .prologue
    const/4 v1, 0x0

    .line 5069
    const/4 v0, 0x5

    if-le p1, v0, :cond_0

    const/4 p1, 0x5

    .line 5070
    :cond_0
    invoke-direct {p0, p1}, Lmain/GameRun;->initMagicStream(I)V

    .line 5071
    iget-object v0, p0, Lmain/GameRun;->now_action_Magic:[S

    aput-short v1, v0, p1

    .line 5072
    iget-object v0, p0, Lmain/GameRun;->now_time_Magic:[S

    aput-short v1, v0, p1

    .line 5073
    return-void
.end method

.method public setNull(Z)V
    .locals 3
    .param p1, "bb"    # Z

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 191
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0}, Lmain/Map;->setNull()V

    .line 192
    :cond_0
    iget-object v0, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v0, v0, v1

    if-eqz v0, :cond_1

    iget-object v0, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ldm/Sprite;->nullIMFA()V

    .line 193
    :cond_1
    iget-object v0, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v0, v0, v2

    if-eqz v0, :cond_2

    iget-object v0, p0, Lmain/GameRun;->mon:[Ldm/Sprite;

    aget-object v0, v0, v2

    invoke-virtual {v0}, Ldm/Sprite;->nullIMFA()V

    .line 196
    :cond_2
    if-eqz p1, :cond_3

    invoke-direct {p0}, Lmain/GameRun;->data_null()V

    .line 197
    :cond_3
    return-void
.end method

.method public setSay()V
    .locals 9

    .prologue
    const/16 v8, 0xf

    const/4 v7, 0x1

    const/4 v6, -0x1

    const/4 v5, 0x0

    .line 3986
    iget-byte v2, p0, Lmain/GameRun;->say_c:B

    if-nez v2, :cond_0

    iget-object v2, p0, Lmain/GameRun;->sayStr:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-nez v2, :cond_1

    .line 4002
    :cond_0
    :goto_0
    return-void

    .line 3988
    :cond_1
    iget-object v2, p0, Lmain/GameRun;->sayStr:Ljava/util/ArrayList;

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 3989
    .local v1, "string":Ljava/lang/String;
    iget-object v2, p0, Lmain/GameRun;->sayFlag:Ljava/util/ArrayList;

    invoke-virtual {v2, v5}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Integer;

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 3991
    .local v0, "flag":I
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    sget v3, Lmain/Constants_H;->WIDTH:I

    const/16 v4, 0x32

    sub-int/2addr v3, v4

    invoke-virtual {v2, v1, v3}, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;

    move-result-object v2

    iput-object v2, p0, Lmain/GameRun;->showS:[Ljava/lang/StringBuffer;

    .line 3992
    sget v2, Lmain/Constants_H;->WIDTH:I

    iput v2, p0, Lmain/GameRun;->say_s:I

    .line 3993
    iput-byte v5, p0, Lmain/GameRun;->say_mode:B

    .line 3994
    if-nez v0, :cond_2

    .line 3995
    iput-byte v8, p0, Lmain/GameRun;->say_c:B

    goto :goto_0

    .line 3996
    :cond_2
    if-ne v0, v6, :cond_3

    .line 3997
    iput-byte v6, p0, Lmain/GameRun;->say_c:B

    goto :goto_0

    .line 3998
    :cond_3
    if-ne v0, v7, :cond_0

    .line 3999
    iput-byte v8, p0, Lmain/GameRun;->say_c:B

    .line 4000
    iput-byte v7, p0, Lmain/GameRun;->say_mode:B

    goto :goto_0
.end method

.method public skyCheckRegFull(I)V
    .locals 2
    .param p1, "where"    # I

    .prologue
    const/4 v1, 0x1

    .line 6249
    packed-switch p1, :pswitch_data_0

    .line 6265
    :goto_0
    return-void

    .line 6257
    :pswitch_0
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0, v1}, Lmain/Map;->setRegState(Z)V

    .line 6258
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->skyNewGame()V

    goto :goto_0

    .line 6261
    :pswitch_1
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0, v1}, Lmain/Map;->setRegState(Z)V

    .line 6262
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->skyContinueGame()V

    goto :goto_0

    .line 6249
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public start()V
    .locals 3

    .prologue
    const/4 v2, -0x2

    .line 199
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lmain/GameRun;->goRUN_IN_MAP(Z)V

    .line 200
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0}, Lmain/Map;->insertNpc()V

    .line 201
    const/4 v0, 0x2

    iput-byte v0, p0, Lmain/GameRun;->line_max:B

    .line 202
    const/16 v0, 0x19

    iput-byte v0, p0, Lmain/GameRun;->cityName_c:B

    .line 203
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v0, v0, Lmain/Map;->anole_temp:B

    if-eq v0, v2, :cond_0

    .line 204
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, p0, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v1, v1, Lmain/Map;->anole_temp:B

    iput-byte v1, v0, Lmain/Map;->anole_type:B

    .line 205
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    iput-byte v2, v0, Lmain/Map;->anole_temp:B

    .line 206
    iget-object v0, p0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0}, Lmain/Map;->setAnole()V

    .line 208
    :cond_0
    return-void
.end method

.method public valueMend(Ldm/Monster;)V
    .locals 6
    .param p1, "monster"    # Ldm/Monster;

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4348
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v2

    if-gez v0, :cond_2

    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    aput-short v2, v0, v2

    .line 4351
    :cond_0
    :goto_0
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    if-gez v0, :cond_3

    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    aput-short v2, v0, v3

    .line 4354
    :cond_1
    :goto_1
    return-void

    .line 4349
    :cond_2
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v2

    iget-object v1, p1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v4

    if-le v0, v1, :cond_0

    .line 4350
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    iget-object v1, p1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v4

    aput-short v1, v0, v2

    goto :goto_0

    .line 4352
    :cond_3
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    aget-short v0, v0, v3

    iget-object v1, p1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v5

    if-le v0, v1, :cond_1

    .line 4353
    iget-object v0, p1, Ldm/Monster;->monsterPro:[S

    iget-object v1, p1, Ldm/Monster;->monsterPro:[S

    aget-short v1, v1, v5

    aput-short v1, v0, v3

    goto :goto_1
.end method
