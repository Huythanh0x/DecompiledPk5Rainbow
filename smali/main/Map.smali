.class public Lmain/Map;
.super Ljava/lang/Object;
.source "Map.java"

# interfaces
.implements Lmain/Key_H;


# static fields
.field private static cur_npc:Ldm/Npc;

.field private static g:Ljavax/microedition/lcdui/Graphics;

.field static npcSp:[[Ldm/Sprite;


# instance fields
.field private action_5:B

.field private anoleSel:B

.field public anole_temp:B

.field public anole_type:B

.field public bDirTalk:Z

.field bExitBoss:Z

.field public bMission:[B

.field private bPause:Z

.field private bSrc:Z

.field private bSrc_c:S

.field private bStep:B

.field bgColor:I

.field public black_0:S

.field public black_1:S

.field private black_width:S

.field public boatCourse:[[B

.field public boatSelect:B

.field bottomData:[S

.field bottomRow:I

.field brow:Ldm/Sprite;

.field checkNpcT:B

.field checkType:B

.field private cloud:[[S

.field private cols:S

.field public dialog:[Ljava/lang/StringBuffer;

.field public dialog_no:B

.field public dir_select:[[B

.field private door:[[B

.field private event:[[B

.field private eventCount:I

.field public eventGoing:B

.field public event_now:[S

.field public event_now_list:[[S

.field private event_state:B

.field public fString:Ljava/lang/String;

.field private faceDir:Z

.field private faceLast:B

.field private face_c:S

.field public firstDrawMap:B

.field public fmap:B

.field fontSizeControl:Z

.field frontData:[S

.field private get_meet:B

.field public gmErr:Z

.field private go:B

.field public gr:Lmain/GameRun;

.field private hudong:Ljavax/microedition/lcdui/Image;

.field i:I

.field ii:I

.field private imgCloud:Ljavax/microedition/lcdui/Image;

.field private imgFace:Ljavax/microedition/lcdui/Image;

.field public imgShadow:Ljavax/microedition/lcdui/Image;

.field public inShop:B

.field private isNeedWait:Z

.field private item:[[B

.field private lastExit:B

.field private lastMap:B

.field private leftCol:S

.field private littleMapClipY:S

.field public mDirect:[B

.field private mapChange:[B

.field private mapDown_NOmove:S

.field mapImg:[Ljavax/microedition/lcdui/Image;

.field public mapInfo:[S

.field private mapLeft_NOmove:S

.field public mapNo:B

.field mapNotemp:B

.field private mapRight_NOmove:S

.field private mapTemp:[[B

.field private mapUp_NOmove:S

.field map_bottom:I

.field public map_key:B

.field map_left:I

.field map_right:I

.field map_top:I

.field public map_x:I

.field public map_y:I

.field private mapdataArea:[[B

.field private mapdataMap:[[B

.field private mapoffx:S

.field private mapoffy:S

.field private meet_step:S

.field private miniMapMode:Z

.field moduleData:[[S

.field public my:Ldm/Npc;

.field private myMiniMap:B

.field public notMeet:B

.field private now_eV1:B

.field private now_eV2:B

.field public npc:[[Ldm/Npc;

.field public npcDirTalk:B

.field private npcList:[B

.field private npcName:Ljava/lang/String;

.field private npcNameData:[Ljava/lang/String;

.field private npcPos:[B

.field private npcStringData:[Ljava/lang/String;

.field public pkey:Lmain/PointerKey;

.field rightCol:I

.field private roadType:B

.field private rows:S

.field public sEvent_eV1:B

.field public sEvent_eV2:B

.field public sIfElse:B

.field private sMission:[[Ljava/lang/StringBuffer;

.field private selectMap:B

.field private showArea:B

.field private sleep_count:B

.field public smissionLength:I

.field private srcFlash_c:B

.field private srcNpcNo:B

.field private step_MEET:S

.field private time_5:B

.field private topRow:S

.field public walkIco:[Ljavax/microedition/lcdui/Image;

.field worldData:[[S

.field private xxx:B


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    .line 3531
    const/4 v0, 0x3

    new-array v0, v0, [[Ldm/Sprite;

    sput-object v0, Lmain/Map;->npcSp:[[Ldm/Sprite;

    .line 25
    return-void
.end method

.method public constructor <init>(Lmain/GameRun;)V
    .registers 10
    .param p1, "gameRun"    # Lmain/GameRun;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, -0x1

    const/4 v3, 0x0

    .line 136
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    const/4 v0, 0x3

    new-array v0, v0, [[Ldm/Npc;

    iput-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    .line 55
    iput-byte v4, p0, Lmain/Map;->srcNpcNo:B

    .line 59
    iput-byte v3, p0, Lmain/Map;->sleep_count:B

    .line 67
    const/4 v0, 0x4

    iput-short v0, p0, Lmain/Map;->step_MEET:S

    .line 75
    iput-byte v3, p0, Lmain/Map;->event_state:B

    .line 78
    const/16 v0, 0x46

    new-array v0, v0, [[B

    iput-object v0, p0, Lmain/Map;->mapTemp:[[B

    .line 87
    iput-byte v4, p0, Lmain/Map;->anole_temp:B

    .line 88
    iput-byte v4, p0, Lmain/Map;->anole_type:B

    .line 89
    iput-byte v3, p0, Lmain/Map;->mapNo:B

    .line 90
    iput-byte v3, p0, Lmain/Map;->inShop:B

    .line 91
    iput-byte v3, p0, Lmain/Map;->notMeet:B

    .line 92
    iput-byte v4, p0, Lmain/Map;->dialog_no:B

    .line 110
    iput-byte v4, p0, Lmain/Map;->bStep:B

    .line 461
    const/4 v0, -0x2

    iput-byte v0, p0, Lmain/Map;->go:B

    .line 616
    iput-boolean v3, p0, Lmain/Map;->bExitBoss:Z

    .line 624
    iput-byte v3, p0, Lmain/Map;->mapNotemp:B

    .line 633
    iput-byte v4, p0, Lmain/Map;->fmap:B

    .line 669
    iput-byte v4, p0, Lmain/Map;->sIfElse:B

    .line 1258
    iput-boolean v3, p0, Lmain/Map;->gmErr:Z

    .line 1592
    iput-byte v3, p0, Lmain/Map;->xxx:B

    iput v3, p0, Lmain/Map;->i:I

    iput v3, p0, Lmain/Map;->ii:I

    .line 1978
    const/4 v0, 0x5

    new-array v0, v0, [[B

    new-array v1, v6, [B

    aput-object v1, v0, v3

    new-array v1, v6, [B

    aput-byte v4, v1, v5

    aput-object v1, v0, v5

    new-array v1, v6, [B

    aput-byte v5, v1, v5

    aput-object v1, v0, v6

    const/4 v1, 0x3

    new-array v2, v6, [B

    aput-byte v4, v2, v3

    aput-object v2, v0, v1

    const/4 v1, 0x4

    new-array v2, v6, [B

    aput-byte v5, v2, v3

    aput-object v2, v0, v1

    iput-object v0, p0, Lmain/Map;->dir_select:[[B

    .line 2111
    iput-byte v3, p0, Lmain/Map;->anoleSel:B

    .line 2240
    iput-byte v4, p0, Lmain/Map;->npcDirTalk:B

    .line 2241
    iput-boolean v3, p0, Lmain/Map;->bDirTalk:Z

    .line 2333
    iput-byte v4, p0, Lmain/Map;->checkNpcT:B

    .line 2429
    iput-byte v3, p0, Lmain/Map;->roadType:B

    .line 2683
    iput-boolean v3, p0, Lmain/Map;->miniMapMode:Z

    .line 2687
    iput-byte v4, p0, Lmain/Map;->showArea:B

    .line 2690
    const/16 v0, 0x12c

    iput-short v0, p0, Lmain/Map;->littleMapClipY:S

    .line 2862
    iput-boolean v3, p0, Lmain/Map;->bPause:Z

    .line 3090
    iput-object v7, p0, Lmain/Map;->moduleData:[[S

    .line 3091
    iput-object v7, p0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    .line 3131
    iput v3, p0, Lmain/Map;->bgColor:I

    .line 3133
    iput-object v7, p0, Lmain/Map;->bottomData:[S

    .line 3134
    iput-object v7, p0, Lmain/Map;->frontData:[S

    .line 3135
    iput-object v7, p0, Lmain/Map;->worldData:[[S

    .line 3270
    iput-byte v3, p0, Lmain/Map;->firstDrawMap:B

    .line 3323
    iput v3, p0, Lmain/Map;->map_left:I

    .line 3324
    iput v3, p0, Lmain/Map;->map_top:I

    .line 3325
    iput v3, p0, Lmain/Map;->map_right:I

    .line 3326
    iput v3, p0, Lmain/Map;->map_bottom:I

    .line 3327
    iput v3, p0, Lmain/Map;->rightCol:I

    .line 3328
    iput v3, p0, Lmain/Map;->bottomRow:I

    .line 3405
    iput-object v7, p0, Lmain/Map;->imgFace:Ljavax/microedition/lcdui/Image;

    .line 3406
    iput-boolean v3, p0, Lmain/Map;->faceDir:Z

    .line 3407
    iput-byte v4, p0, Lmain/Map;->faceLast:B

    .line 3408
    iput-short v3, p0, Lmain/Map;->face_c:S

    .line 3906
    iput-short v3, p0, Lmain/Map;->bSrc_c:S

    .line 3908
    iput-boolean v3, p0, Lmain/Map;->bSrc:Z

    .line 3910
    iput-byte v3, p0, Lmain/Map;->srcFlash_c:B

    .line 4046
    iput-byte v4, p0, Lmain/Map;->boatSelect:B

    .line 4174
    iput-boolean v5, p0, Lmain/Map;->isNeedWait:Z

    .line 137
    iput-object p1, p0, Lmain/Map;->gr:Lmain/GameRun;

    .line 138
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 139
    invoke-direct {p0}, Lmain/Map;->init()V

    .line 140
    return-void
.end method

.method private addCloud(I)V
    .registers 6
    .param p1, "i"    # I

    .prologue
    .line 4021
    iget-object v0, p0, Lmain/Map;->cloud:[[S

    aget-object v0, v0, p1

    const/4 v1, 0x0

    iget-short v2, p0, Lmain/Map;->leftCol:S

    mul-int/lit8 v2, v2, 0x14

    sget v3, Lmain/Constants_H;->WIDTH:I

    add-int/2addr v2, v3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v3, Lmain/Constants_H;->WIDTH_H:I

    invoke-static {v3}, Ldm/Ms;->getRandom(I)I

    move-result v3

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 4022
    iget-object v0, p0, Lmain/Map;->cloud:[[S

    aget-object v0, v0, p1

    const/4 v1, 0x1

    iget-short v2, p0, Lmain/Map;->topRow:S

    mul-int/lit8 v2, v2, 0x14

    add-int/lit8 v2, v2, 0x14

    add-int/lit8 v2, v2, 0x2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v3, 0x19

    invoke-static {v3}, Ldm/Ms;->getRandom(I)I

    move-result v3

    add-int/lit8 v3, v3, 0x37

    mul-int/2addr v3, p1

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 4023
    iget-object v0, p0, Lmain/Map;->cloud:[[S

    aget-object v0, v0, p1

    const/4 v1, 0x2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v2, 0x3

    invoke-static {v2}, Ldm/Ms;->getRandom(I)I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 4024
    return-void
.end method

.method private canMove(II)V
    .registers 9
    .param p1, "temp_xspeed"    # I
    .param p2, "temp_yspeed"    # I

    .prologue
    const/4 v3, 0x5

    const/4 v5, 0x2

    const/4 v4, -0x1

    .line 2431
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    int-to-byte v1, p1

    iput-byte v1, v0, Ldm/Npc;->speed_x:B

    .line 2432
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    int-to-byte v1, p2

    iput-byte v1, v0, Ldm/Npc;->speed_y:B

    .line 2433
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v0, v0, Ldm/Npc;->x:S

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed_x:B

    add-int/2addr v0, v1

    if-ltz v0, :cond_ad

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v0, v0, Ldm/Npc;->x:S

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed_x:B

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x13

    iget-short v1, p0, Lmain/Map;->cols:S

    mul-int/lit8 v1, v1, 0x14

    if-ge v0, v1, :cond_ad

    .line 2434
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v0, v0, Ldm/Npc;->y:S

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed_y:B

    add-int/2addr v0, v1

    if-ltz v0, :cond_ad

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v0, v0, Ldm/Npc;->y:S

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed_y:B

    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x13

    iget-short v1, p0, Lmain/Map;->rows:S

    mul-int/lit8 v1, v1, 0x14

    if-ge v0, v1, :cond_ad

    .line 2435
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v0, v0, Ldm/Npc;->x:S

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->speed_x:B

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->speed_y:B

    invoke-direct {p0, v0, v1, v2, v3}, Lmain/Map;->checkMap(IIII)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->roadType:B

    .line 2437
    iget-byte v0, p0, Lmain/Map;->roadType:B

    if-nez v0, :cond_63

    invoke-direct {p0}, Lmain/Map;->initMoveMy()V

    .line 2464
    :cond_62
    :goto_62
    return-void

    .line 2438
    :cond_63
    iget-byte v0, p0, Lmain/Map;->checkNpcT:B

    invoke-direct {p0, v0}, Lmain/Map;->checkMoveOff(I)Z

    move-result v0

    if-eqz v0, :cond_6f

    invoke-direct {p0}, Lmain/Map;->initMoveMy()V

    goto :goto_62

    .line 2439
    :cond_6f
    iget-byte v0, p0, Lmain/Map;->checkNpcT:B

    if-eq v0, v4, :cond_79

    invoke-direct {p0}, Lmain/Map;->isCheckNpcOff()Z

    move-result v0

    if-eqz v0, :cond_a2

    .line 2441
    :cond_79
    iget-byte v0, p0, Lmain/Map;->roadType:B

    invoke-direct {p0, v0}, Lmain/Map;->isMapChenk(B)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->roadType:B

    .line 2443
    iget-byte v0, p0, Lmain/Map;->roadType:B

    if-ne v0, v4, :cond_90

    .line 2444
    const/4 v0, 0x3

    const/4 v1, 0x1

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->speed:B

    neg-int v2, v2

    invoke-direct {p0, v0, v1, v2}, Lmain/Map;->moveOff(BBI)V

    goto :goto_62

    .line 2445
    :cond_90
    iget-byte v0, p0, Lmain/Map;->roadType:B

    const/4 v1, -0x2

    if-ne v0, v1, :cond_9e

    .line 2446
    const/4 v0, 0x4

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed:B

    invoke-direct {p0, v0, v5, v1}, Lmain/Map;->moveOff(BBI)V

    goto :goto_62

    .line 2447
    :cond_9e
    invoke-direct {p0}, Lmain/Map;->checkAnole()V

    goto :goto_62

    .line 2451
    :cond_a2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 2452
    invoke-direct {p0}, Lmain/Map;->setMoveStop_m()V

    goto :goto_62

    .line 2455
    :cond_ad
    invoke-direct {p0}, Lmain/Map;->setMoveStop_m()V

    .line 2456
    iget-object v0, p0, Lmain/Map;->door:[[B

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->x:S

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v2, Ldm/Npc;->y:S

    invoke-direct {p0, v0, v1, v2}, Lmain/Map;->checkIfOther([[BII)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->checkType:B

    .line 2457
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-eq v0, v4, :cond_62

    iget-object v0, p0, Lmain/Map;->door:[[B

    iget-byte v1, p0, Lmain/Map;->checkType:B

    aget-object v0, v0, v1

    aget-byte v0, v0, v3

    if-nez v0, :cond_62

    .line 2458
    iget-byte v0, p0, Lmain/Map;->map_key:B

    iget-object v1, p0, Lmain/Map;->door:[[B

    iget-byte v2, p0, Lmain/Map;->checkType:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v5

    if-ne v0, v1, :cond_62

    .line 2459
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v3, v0, Ldm/Npc;->state:B

    .line 2460
    iget-byte v0, p0, Lmain/Map;->checkType:B

    iput-byte v0, p0, Lmain/Map;->get_meet:B

    goto :goto_62
.end method

.method private checkAnole()V
    .registers 10

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x4

    const/4 v6, 0x3

    .line 2528
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v0, Ldm/Npc;->x:S

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v0, Ldm/Npc;->y:S

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v0, Ldm/Npc;->speed_x:B

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v0, Ldm/Npc;->speed_y:B

    const/4 v5, 0x1

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lmain/Map;->checkWorld(IIIIZ)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->checkType:B

    .line 2529
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-ne v0, v8, :cond_26

    invoke-direct {p0, v7}, Lmain/Map;->isCheckAnole(I)Z

    move-result v0

    if-eqz v0, :cond_31

    .line 2545
    :cond_25
    :goto_25
    return-void

    .line 2531
    :cond_26
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-ne v0, v6, :cond_3c

    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lmain/Map;->isCheckAnole(I)Z

    move-result v0

    if-nez v0, :cond_25

    .line 2543
    :cond_31
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 2544
    invoke-direct {p0}, Lmain/Map;->setMoveStop_m()V

    goto :goto_25

    .line 2532
    :cond_3c
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-ne v0, v7, :cond_47

    invoke-direct {p0, v8}, Lmain/Map;->isCheckAnole(I)Z

    move-result v0

    if-eqz v0, :cond_31

    goto :goto_25

    .line 2533
    :cond_47
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-nez v0, :cond_31

    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-ne v0, v7, :cond_31

    .line 2537
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-eq v0, v6, :cond_62

    invoke-direct {p0, v6}, Lmain/Map;->isAnoleType(I)Z

    move-result v0

    if-eqz v0, :cond_62

    iput-byte v6, p0, Lmain/Map;->anole_type:B

    .line 2539
    :goto_5b
    invoke-virtual {p0}, Lmain/Map;->setAnole()V

    .line 2540
    invoke-direct {p0}, Lmain/Map;->initMoveMy()V

    goto :goto_25

    .line 2538
    :cond_62
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/Map;->anole_type:B

    goto :goto_5b
.end method

.method private checkIfNpc([Ldm/Npc;II)B
    .registers 14
    .param p1, "npc"    # [Ldm/Npc;
    .param p2, "ix"    # I
    .param p3, "iy"    # I

    .prologue
    .line 2224
    array-length v0, p1

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    int-to-byte v9, v0

    .local v9, "i":B
    :goto_4
    const/4 v0, -0x1

    if-gt v9, v0, :cond_9

    .line 2229
    const/4 v0, -0x1

    :goto_8
    return v0

    .line 2225
    :cond_9
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/16 v3, 0x13

    const/16 v4, 0x13

    aget-object v1, p1, v9

    iget-short v5, v1, Ldm/Npc;->x:S

    aget-object v1, p1, v9

    iget-short v6, v1, Ldm/Npc;->y:S

    const/16 v7, 0x14

    const/16 v8, 0x14

    move v1, p2

    move v2, p3

    invoke-virtual/range {v0 .. v8}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v0

    if-eqz v0, :cond_3b

    .line 2226
    aget-object v0, p1, v9

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x4

    aget-byte v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_39

    aget-object v0, p1, v9

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x4

    aget-byte v0, v0, v1

    const/4 v1, 0x3

    if-ne v0, v1, :cond_3b

    :cond_39
    move v0, v9

    .line 2227
    goto :goto_8

    .line 2224
    :cond_3b
    const/4 v0, 0x1

    sub-int v0, v9, v0

    int-to-byte v9, v0

    goto :goto_4
.end method

.method private checkIfOther([[BII)B
    .registers 16
    .param p1, "data"    # [[B
    .param p2, "ix"    # I
    .param p3, "iy"    # I

    .prologue
    const/16 v7, 0x14

    const/16 v3, 0x13

    const/4 v11, -0x1

    const/4 v10, 0x1

    .line 2233
    array-length v0, p1

    sub-int/2addr v0, v10

    int-to-byte v9, v0

    .local v9, "i":B
    :goto_9
    if-gt v9, v11, :cond_d

    move v0, v11

    .line 2238
    :goto_c
    return v0

    .line 2234
    :cond_d
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    .line 2235
    aget-object v1, p1, v9

    const/4 v2, 0x0

    aget-byte v1, v1, v2

    mul-int/lit8 v5, v1, 0x14

    aget-object v1, p1, v9

    aget-byte v1, v1, v10

    mul-int/lit8 v6, v1, 0x14

    move v1, p2

    move v2, p3

    move v4, v3

    move v8, v7

    .line 2234
    invoke-virtual/range {v0 .. v8}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v0

    if-eqz v0, :cond_2a

    move v0, v9

    .line 2236
    goto :goto_c

    .line 2233
    :cond_2a
    sub-int v0, v9, v10

    int-to-byte v9, v0

    goto :goto_9
.end method

.method private checkMap(IIII)B
    .registers 13
    .param p1, "A_X"    # I
    .param p2, "A_Y"    # I
    .param p3, "_speed_x"    # I
    .param p4, "_speed_y"    # I

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x5

    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v3, -0x1

    .line 2336
    iput-byte v3, p0, Lmain/Map;->checkNpcT:B

    .line 2337
    iget-object v0, p0, Lmain/Map;->item:[[B

    add-int v1, p1, p3

    add-int v2, p2, p4

    invoke-direct {p0, v0, v1, v2}, Lmain/Map;->checkIfOther([[BII)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->checkType:B

    .line 2338
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-eq v0, v3, :cond_1c

    const/4 v0, -0x2

    iput-byte v0, p0, Lmain/Map;->checkNpcT:B

    move v0, v4

    .line 2359
    :goto_1b
    return v0

    .line 2339
    :cond_1c
    add-int v0, p1, p3

    if-ltz v0, :cond_34

    add-int v0, p1, p3

    iget-short v1, p0, Lmain/Map;->cols:S

    mul-int/lit8 v1, v1, 0x14

    if-ge v0, v1, :cond_34

    .line 2340
    add-int v0, p2, p4

    if-ltz v0, :cond_34

    add-int v0, p2, p4

    iget-short v1, p0, Lmain/Map;->rows:S

    mul-int/lit8 v1, v1, 0x14

    if-lt v0, v1, :cond_36

    :cond_34
    move v0, v4

    goto :goto_1b

    .line 2342
    :cond_36
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v5

    add-int v1, p1, p3

    add-int v2, p2, p4

    invoke-direct {p0, v0, v1, v2}, Lmain/Map;->checkIfNpc([Ldm/Npc;II)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->checkType:B

    .line 2343
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-eq v0, v3, :cond_6a

    .line 2344
    iget-object v0, p0, Lmain/Map;->npcNameData:[Ljava/lang/String;

    iget-byte v1, p0, Lmain/Map;->checkType:B

    aget-object v0, v0, v1

    const-string v1, "\u8def\u4eba"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_64

    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v5

    iget-byte v1, p0, Lmain/Map;->checkType:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v6

    if-lez v0, :cond_68

    .line 2345
    :cond_64
    iget-byte v0, p0, Lmain/Map;->checkType:B

    iput-byte v0, p0, Lmain/Map;->checkNpcT:B

    :cond_68
    move v0, v4

    .line 2346
    goto :goto_1b

    .line 2353
    :cond_6a
    iget-object v0, p0, Lmain/Map;->door:[[B

    add-int v1, p1, p3

    add-int v2, p2, p4

    invoke-direct {p0, v0, v1, v2}, Lmain/Map;->checkIfOther([[BII)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->checkType:B

    .line 2354
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-eq v0, v3, :cond_9a

    iget-object v0, p0, Lmain/Map;->door:[[B

    iget-byte v1, p0, Lmain/Map;->checkType:B

    aget-object v0, v0, v1

    aget-byte v0, v0, v6

    if-eq v0, v7, :cond_90

    iget-byte v0, p0, Lmain/Map;->map_key:B

    iget-object v1, p0, Lmain/Map;->door:[[B

    iget-byte v2, p0, Lmain/Map;->checkType:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v7

    if-ne v0, v1, :cond_9a

    .line 2355
    :cond_90
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v6, v0, Ldm/Npc;->state:B

    .line 2356
    iget-byte v0, p0, Lmain/Map;->checkType:B

    iput-byte v0, p0, Lmain/Map;->get_meet:B

    move v0, v5

    .line 2357
    goto :goto_1b

    :cond_9a
    move-object v0, p0

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    .line 2359
    invoke-direct/range {v0 .. v5}, Lmain/Map;->checkWorld(IIIIZ)B

    move-result v0

    goto/16 :goto_1b
.end method

.method private checkMoveOff(I)Z
    .registers 11
    .param p1, "npcid"    # I

    .prologue
    const/16 v8, 0x14

    const/4 v6, 0x0

    const/4 v7, 0x1

    .line 2490
    const/4 v4, -0x1

    if-le p1, v4, :cond_ad

    .line 2491
    iget-object v4, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v4, v4, v6

    aget-object v4, v4, p1

    iget-short v4, v4, Ldm/Npc;->x:S

    add-int/lit8 v4, v4, 0x14

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v5, v5, Ldm/Npc;->x:S

    sub-int/2addr v4, v5

    int-to-byte v0, v4

    .line 2492
    .local v0, "oxl":B
    iget-object v4, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v4, v4, v6

    aget-object v4, v4, p1

    iget-short v4, v4, Ldm/Npc;->x:S

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v5, v5, Ldm/Npc;->x:S

    sub-int/2addr v4, v5

    sub-int/2addr v4, v8

    int-to-byte v1, v4

    .line 2493
    .local v1, "oxr":B
    iget-object v4, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v4, v4, v6

    aget-object v4, v4, p1

    iget-short v4, v4, Ldm/Npc;->y:S

    add-int/lit8 v4, v4, 0x14

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v5, v5, Ldm/Npc;->y:S

    sub-int/2addr v4, v5

    int-to-byte v2, v4

    .line 2494
    .local v2, "oyl":B
    iget-object v4, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v4, v4, v6

    aget-object v4, v4, p1

    iget-short v4, v4, Ldm/Npc;->y:S

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v5, v5, Ldm/Npc;->y:S

    sub-int/2addr v4, v5

    sub-int/2addr v4, v8

    int-to-byte v3, v4

    .line 2495
    .local v3, "oyr":B
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-gez v4, :cond_5f

    if-eqz v0, :cond_5f

    .line 2496
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_x:B

    if-ge v0, v5, :cond_5d

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_x:B

    :goto_59
    iput-byte v5, v4, Ldm/Npc;->speed_x:B

    move v4, v7

    .line 2525
    :goto_5c
    return v4

    :cond_5d
    move v5, v0

    .line 2496
    goto :goto_59

    .line 2498
    :cond_5f
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-lez v4, :cond_79

    if-eqz v1, :cond_79

    .line 2499
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_x:B

    if-ge v1, v5, :cond_74

    move v5, v1

    :goto_70
    iput-byte v5, v4, Ldm/Npc;->speed_x:B

    move v4, v7

    .line 2500
    goto :goto_5c

    .line 2499
    :cond_74
    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_x:B

    goto :goto_70

    .line 2502
    :cond_79
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_y:B

    if-gez v4, :cond_93

    if-eqz v2, :cond_93

    .line 2503
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    if-ge v2, v5, :cond_91

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    :goto_8d
    iput-byte v5, v4, Ldm/Npc;->speed_y:B

    move v4, v7

    .line 2504
    goto :goto_5c

    :cond_91
    move v5, v2

    .line 2503
    goto :goto_8d

    .line 2505
    :cond_93
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_y:B

    if-lez v4, :cond_133

    if-eqz v3, :cond_133

    .line 2506
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    if-ge v3, v5, :cond_a8

    move v5, v3

    :goto_a4
    iput-byte v5, v4, Ldm/Npc;->speed_y:B

    move v4, v7

    .line 2507
    goto :goto_5c

    .line 2506
    :cond_a8
    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    goto :goto_a4

    .line 2510
    .end local v0    # "oxl":B
    .end local v1    # "oxr":B
    .end local v2    # "oyl":B
    .end local v3    # "oyr":B
    :cond_ad
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v4}, Ldm/Npc;->getIx_off()B

    move-result v0

    .line 2511
    .restart local v0    # "oxl":B
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v4}, Ldm/Npc;->getIx_off()B

    move-result v4

    sub-int v4, v8, v4

    int-to-byte v1, v4

    .line 2512
    .restart local v1    # "oxr":B
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v4}, Ldm/Npc;->getIy_off()B

    move-result v2

    .line 2513
    .restart local v2    # "oyl":B
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v4}, Ldm/Npc;->getIy_off()B

    move-result v4

    sub-int v4, v8, v4

    int-to-byte v3, v4

    .line 2514
    .restart local v3    # "oyr":B
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-eqz v4, :cond_ff

    if-eqz v0, :cond_ff

    .line 2515
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-gez v4, :cond_ee

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    neg-int v5, v0

    iget-object v6, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v6, v6, Ldm/Npc;->speed_x:B

    if-ge v5, v6, :cond_ec

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_x:B

    :goto_e6
    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Npc;->speed_x:B

    :goto_e9
    move v4, v7

    .line 2517
    goto/16 :goto_5c

    .line 2515
    :cond_ec
    neg-int v5, v0

    goto :goto_e6

    .line 2516
    :cond_ee
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_x:B

    if-ge v1, v5, :cond_fa

    move v5, v1

    :goto_f7
    iput-byte v5, v4, Ldm/Npc;->speed_x:B

    goto :goto_e9

    :cond_fa
    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_x:B

    goto :goto_f7

    .line 2519
    :cond_ff
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_y:B

    if-eqz v4, :cond_133

    if-eqz v2, :cond_133

    .line 2520
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_y:B

    if-gez v4, :cond_122

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    neg-int v5, v2

    iget-object v6, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v6, v6, Ldm/Npc;->speed_y:B

    if-ge v5, v6, :cond_120

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    :goto_11a
    int-to-byte v5, v5

    iput-byte v5, v4, Ldm/Npc;->speed_y:B

    :goto_11d
    move v4, v7

    .line 2522
    goto/16 :goto_5c

    .line 2520
    :cond_120
    neg-int v5, v2

    goto :goto_11a

    .line 2521
    :cond_122
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    if-ge v3, v5, :cond_12e

    move v5, v3

    :goto_12b
    iput-byte v5, v4, Ldm/Npc;->speed_y:B

    goto :goto_11d

    :cond_12e
    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    goto :goto_12b

    :cond_133
    move v4, v6

    .line 2525
    goto/16 :goto_5c
.end method

.method private checkWorld(IIIIZ)B
    .registers 11
    .param p1, "A_X"    # I
    .param p2, "A_Y"    # I
    .param p3, "_speed_x"    # I
    .param p4, "_speed_y"    # I
    .param p5, "mode"    # Z

    .prologue
    .line 2362
    const/4 v1, 0x0

    .local v1, "i":B
    const/4 v0, 0x1

    .line 2363
    .local v0, "check_n":B
    if-nez p3, :cond_8

    rem-int/lit8 v4, p1, 0x14

    if-nez v4, :cond_e

    :cond_8
    if-nez p4, :cond_f

    rem-int/lit8 v4, p2, 0x14

    if-eqz v4, :cond_f

    :cond_e
    const/4 v0, 0x2

    .line 2365
    :cond_f
    :goto_f
    if-lt v1, v0, :cond_13

    .line 2376
    const/4 v4, 0x0

    :goto_12
    return v4

    .line 2366
    :cond_13
    if-nez p4, :cond_3b

    .line 2367
    mul-int/lit8 v4, v1, 0x14

    add-int/2addr v4, p2

    div-int/lit8 v4, v4, 0x14

    int-to-byte v3, v4

    .line 2368
    .local v3, "iy":B
    if-ltz p3, :cond_36

    add-int v4, p1, p3

    add-int/lit8 v4, v4, 0x13

    div-int/lit8 v4, v4, 0x14

    :goto_23
    int-to-byte v2, v4

    .line 2373
    .local v2, "ix":B
    :goto_24
    if-eqz p5, :cond_50

    iget-object v4, p0, Lmain/Map;->worldData:[[S

    aget-object v4, v4, v2

    aget-short v4, v4, v3

    if-eqz v4, :cond_58

    iget-object v4, p0, Lmain/Map;->worldData:[[S

    aget-object v4, v4, v2

    aget-short v4, v4, v3

    int-to-byte v4, v4

    goto :goto_12

    .line 2368
    .end local v2    # "ix":B
    :cond_36
    add-int v4, p1, p3

    div-int/lit8 v4, v4, 0x14

    goto :goto_23

    .line 2370
    .end local v3    # "iy":B
    :cond_3b
    mul-int/lit8 v4, v1, 0x14

    add-int/2addr v4, p1

    div-int/lit8 v4, v4, 0x14

    int-to-byte v2, v4

    .line 2371
    .restart local v2    # "ix":B
    if-ltz p4, :cond_4b

    add-int v4, p2, p4

    add-int/lit8 v4, v4, 0x13

    div-int/lit8 v4, v4, 0x14

    :goto_49
    int-to-byte v3, v4

    .restart local v3    # "iy":B
    goto :goto_24

    .end local v3    # "iy":B
    :cond_4b
    add-int v4, p2, p4

    div-int/lit8 v4, v4, 0x14

    goto :goto_49

    .line 2374
    .restart local v3    # "iy":B
    :cond_50
    invoke-direct {p0, v2, v3}, Lmain/Map;->isCan_not_pass(II)Z

    move-result v4

    if-eqz v4, :cond_58

    const/4 v4, 0x1

    goto :goto_12

    .line 2365
    :cond_58
    add-int/lit8 v4, v1, 0x1

    int-to-byte v1, v4

    goto :goto_f
.end method

.method private configureNpc()V
    .registers 4

    .prologue
    .line 275
    sget-object v0, Lmain/Map;->npcSp:[[Ldm/Sprite;

    const/4 v1, 0x0

    const/16 v2, 0x64

    new-array v2, v2, [Ldm/Sprite;

    aput-object v2, v0, v1

    .line 276
    sget-object v0, Lmain/Map;->npcSp:[[Ldm/Sprite;

    const/4 v1, 0x1

    const/4 v2, 0x5

    new-array v2, v2, [Ldm/Sprite;

    aput-object v2, v0, v1

    .line 277
    sget-object v0, Lmain/Map;->npcSp:[[Ldm/Sprite;

    const/4 v1, 0x2

    const/16 v2, 0x3c

    new-array v2, v2, [Ldm/Sprite;

    aput-object v2, v0, v1

    .line 278
    return-void
.end method

.method private createMap()V
    .registers 2

    .prologue
    .line 3087
    invoke-direct {p0}, Lmain/Map;->loadMapModuleAndImage()V

    .line 3088
    iget-byte v0, p0, Lmain/Map;->mapNo:B

    invoke-direct {p0, v0}, Lmain/Map;->loadMapData(I)V

    .line 3089
    return-void
.end method

.method private dialog(Ljava/lang/String;)V
    .registers 16
    .param p1, "npcName"    # Ljava/lang/String;

    .prologue
    .line 2590
    const/16 v7, 0x19

    .line 2591
    .local v7, "FONT_H":I
    sget v9, Lmain/Constants_H;->WIDTH__:I

    .local v9, "WIDTH":I
    sget v8, Lmain/Constants_H;->HEIGHT__:I

    .line 2592
    .local v8, "HEIGHT":I
    const/16 v12, 0xa

    .line 2593
    .local v12, "x":B
    const/16 v0, 0x8

    sub-int v0, v8, v0

    mul-int/lit8 v1, v7, 0x2

    sub-int v13, v0, v1

    .line 2594
    .local v13, "y":I
    mul-int/lit8 v0, v7, 0x2

    add-int/lit8 v10, v0, 0xb

    .line 2595
    .local v10, "height":I
    const/4 v11, 0x0

    .line 2596
    .local v11, "line_c":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x4

    sub-int v2, v8, v10

    const/4 v3, 0x4

    sub-int/2addr v2, v3

    const/4 v3, 0x4

    sub-int v3, v9, v3

    add-int/lit8 v4, v10, 0x4

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawKuang(IIII)V

    .line 2597
    if-eqz p1, :cond_70

    .line 2599
    iget-boolean v0, p0, Lmain/Map;->faceDir:Z

    if-eqz v0, :cond_7c

    const/16 v0, 0x32

    sub-int v0, v9, v0

    :goto_30
    iget-boolean v1, p0, Lmain/Map;->faceDir:Z

    if-eqz v1, :cond_7f

    sub-int v1, v8, v10

    const/4 v2, 0x4

    sub-int/2addr v1, v2

    :goto_38
    const/4 v2, 0x1

    or-int/lit8 v2, v2, 0x20

    invoke-direct {p0, v0, v1, v2}, Lmain/Map;->drawNpcFace(III)V

    .line 2601
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/4 v1, 0x0

    sub-int v2, v13, v10

    add-int/2addr v2, v7

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3, p1}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v3

    add-int/lit8 v3, v3, 0x10

    add-int/lit8 v4, v7, 0x8

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawKuang(IIII)V

    .line 2602
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v2, 0x8

    sub-int v1, v13, v10

    add-int/lit8 v1, v1, 0x2

    add-int v3, v1, v7

    const/4 v4, 0x0

    const/16 v5, 0x9

    const/4 v6, 0x1

    move-object v1, p1

    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2603
    const-string v0, "sk"

    const-string v1, "dialog"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2607
    :cond_70
    :goto_70
    const/4 v0, 0x2

    if-ge v11, v0, :cond_7b

    iget-byte v0, p0, Lmain/Map;->dialog_no:B

    add-int/2addr v0, v11

    iget-object v1, p0, Lmain/Map;->dialog:[Ljava/lang/StringBuffer;

    array-length v1, v1

    if-lt v0, v1, :cond_85

    .line 2611
    :cond_7b
    return-void

    .line 2599
    :cond_7c
    const/16 v0, 0x32

    goto :goto_30

    :cond_7f
    sub-int v1, v8, v10

    const/4 v2, 0x4

    sub-int/2addr v1, v2

    sub-int/2addr v1, v7

    goto :goto_38

    .line 2608
    :cond_85
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->dialog:[Ljava/lang/StringBuffer;

    iget-byte v2, p0, Lmain/Map;->dialog_no:B

    add-int/2addr v2, v11

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    sub-int v2, v13, v2

    mul-int v3, v11, v7

    add-int/2addr v3, v2

    const/4 v4, -0x1

    const/4 v5, 0x1

    move v2, v12

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V

    .line 2609
    add-int/lit8 v11, v11, 0x1

    goto :goto_70
.end method

.method private drawAnoleSel()V
    .registers 20

    .prologue
    .line 1984
    const/16 v17, 0x19

    .line 1986
    .local v17, "h":B
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v2, v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v4, v0

    iget-byte v4, v4, Lmain/GameRun;->cur_a:B

    mul-int/lit8 v5, v17, 0x2

    add-int/lit8 v5, v5, 0xc

    const/16 v6, 0x8

    const/4 v7, 0x0

    invoke-virtual {v3, v4, v5, v6, v7}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v3

    int-to-byte v3, v3

    iput-byte v3, v2, Lmain/GameRun;->cur_a:B

    .line 1988
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x0

    sget v4, Lmain/Constants_H;->HEIGHT:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->cur_a:B

    sub-int/2addr v4, v5

    const/4 v5, 0x2

    sub-int/2addr v4, v5

    const/16 v5, 0x77

    add-int/lit8 v6, v17, 0x4

    add-int/lit8 v6, v6, 0x2

    const/4 v7, 0x2

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawK1(IIIII)V

    .line 1992
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x0

    sget v4, Lmain/Constants_H;->HEIGHT:I

    add-int v4, v4, v17

    add-int/lit8 v4, v4, 0x4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->cur_a:B

    sub-int/2addr v4, v5

    sget v5, Lmain/Constants_H;->WIDTH:I

    add-int/lit8 v6, v17, 0x8

    const/4 v7, 0x0

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawK2(IIIII)V

    .line 1994
    const/16 v18, 0x0

    .local v18, "i":B
    :goto_58
    const/4 v2, 0x5

    move/from16 v0, v18

    move v1, v2

    if-lt v0, v1, :cond_10c

    .line 2026
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anoleSel:B

    move v2, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anole_type:B

    move v3, v0

    if-ne v2, v3, :cond_1d3

    const/4 v9, 0x0

    .line 2035
    .local v9, "j":B
    :goto_6b
    const-string v2, "sk"

    const-string v3, "drawAnoleSel"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2036
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v2, v0

    iget-object v2, v2, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    aget-object v2, v2, v9

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v11

    const/16 v12, 0x3c

    sget v2, Lmain/Constants_H;->HEIGHT:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    sub-int/2addr v2, v3

    const/4 v3, 0x2

    sub-int v13, v2, v3

    const/16 v14, 0x11

    const/4 v15, 0x1

    const/16 v16, 0x2

    invoke-virtual/range {v10 .. v16}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2038
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anoleSel:B

    move v3, v0

    sget v4, Lmain/Constants_H;->WIDTH:I

    mul-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x6

    add-int/lit8 v3, v3, 0x29

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v4, v0

    iget-byte v4, v4, Lmain/GameRun;->cur_b:B

    div-int/lit8 v4, v4, 0x3

    add-int/2addr v3, v4

    .line 2039
    sget v4, Lmain/Constants_H;->HEIGHT:I

    add-int v4, v4, v17

    add-int/lit8 v4, v4, 0x7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->cur_a:B

    sub-int/2addr v4, v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->cur_b:B

    div-int/lit8 v5, v5, 0x3

    add-int/2addr v4, v5

    const/16 v5, 0x16

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-byte v6, v6, Lmain/GameRun;->cur_b:B

    div-int/lit8 v6, v6, 0x3

    shl-int/lit8 v6, v6, 0x1

    sub-int/2addr v5, v6

    const/16 v6, 0x16

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->cur_b:B

    div-int/lit8 v7, v7, 0x3

    shl-int/lit8 v7, v7, 0x1

    sub-int/2addr v6, v7

    .line 2038
    invoke-virtual {v2, v3, v4, v5, v6}, Ldm/Ui;->drawK4(IIII)V

    .line 2040
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v2, v0

    iget-byte v3, v2, Lmain/GameRun_F;->cur_b:B

    add-int/lit8 v4, v3, 0x1

    int-to-byte v4, v4

    iput-byte v4, v2, Lmain/GameRun;->cur_b:B

    const/4 v2, 0x4

    if-le v3, v2, :cond_102

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v2, v0

    const/4 v3, 0x0

    iput-byte v3, v2, Lmain/GameRun;->cur_b:B

    .line 2042
    :cond_102
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Ldm/Ui;->drawYesNo_(ZZ)V

    .line 2044
    return-void

    .line 1995
    .end local v9    # "j":B
    :cond_10c
    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-direct {v0, v1}, Lmain/Map;->isAnoleType(I)Z

    move-result v2

    if-nez v2, :cond_19e

    const/4 v7, 0x6

    .local v7, "c":B
    add-int/lit8 v2, v18, 0x46

    int-to-byte v9, v2

    .line 2016
    .restart local v9    # "j":B
    :goto_11a
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    sget v3, Lmain/Constants_H;->WIDTH:I

    mul-int v3, v3, v18

    div-int/lit8 v3, v3, 0x6

    add-int/lit8 v3, v3, 0x2a

    sget v4, Lmain/Constants_H;->HEIGHT:I

    add-int v4, v4, v17

    add-int/lit8 v4, v4, 0x8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->cur_a:B

    sub-int/2addr v4, v5

    const/16 v5, 0x14

    const/16 v6, 0x14

    invoke-virtual/range {v2 .. v7}, Ldm/Ui;->drawK0(IIIII)V

    .line 2017
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    sget v2, Lmain/Constants_H;->WIDTH:I

    mul-int v2, v2, v18

    div-int/lit8 v2, v2, 0x6

    add-int/lit8 v2, v2, 0x2a

    add-int/lit8 v10, v2, 0xa

    sget v2, Lmain/Constants_H;->HEIGHT:I

    add-int v2, v2, v17

    add-int/lit8 v2, v2, 0x8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    sub-int/2addr v2, v3

    add-int/lit8 v11, v2, 0x12

    const/16 v12, 0x21

    const/4 v13, 0x0

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawUi(IIIII)V

    .line 2019
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v2, v0

    sget v3, Lmain/Constants_H;->WIDTH:I

    mul-int v3, v3, v18

    div-int/lit8 v3, v3, 0x6

    add-int/lit8 v3, v3, 0x2a

    sget v4, Lmain/Constants_H;->HEIGHT:I

    add-int v4, v4, v17

    add-int/lit8 v4, v4, 0x8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->cur_a:B

    sub-int/2addr v4, v5

    const/16 v5, 0x14

    const/16 v6, 0x14

    invoke-virtual {v2, v3, v4, v5, v6}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v2

    if-eqz v2, :cond_196

    .line 2020
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anoleSel:B

    move v2, v0

    move v0, v2

    move/from16 v1, v18

    if-ne v0, v1, :cond_1cc

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v2, v0

    invoke-virtual {v2}, Lmain/PointerKey;->setKeySoftkey1()V

    .line 1994
    :cond_196
    :goto_196
    add-int/lit8 v2, v18, 0x1

    move v0, v2

    int-to-byte v0, v0

    move/from16 v18, v0

    goto/16 :goto_58

    .line 2001
    .end local v7    # "c":B
    .end local v9    # "j":B
    :cond_19e
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anoleSel:B

    move v2, v0

    move/from16 v0, v18

    move v1, v2

    if-ne v0, v1, :cond_1b8

    const/4 v2, 0x1

    :goto_1a9
    int-to-byte v7, v2

    .line 2002
    .restart local v7    # "c":B
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anole_type:B

    move v2, v0

    move/from16 v0, v18

    move v1, v2

    if-ne v0, v1, :cond_1ba

    const/16 v9, 0x45

    .restart local v9    # "j":B
    goto/16 :goto_11a

    .line 2001
    .end local v7    # "c":B
    .end local v9    # "j":B
    :cond_1b8
    const/4 v2, 0x0

    goto :goto_1a9

    .line 2004
    .restart local v7    # "c":B
    :cond_1ba
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anoleSel:B

    move v2, v0

    move/from16 v0, v18

    move v1, v2

    if-ne v0, v1, :cond_1c9

    add-int/lit8 v2, v18, 0x5

    :goto_1c6
    int-to-byte v9, v2

    .restart local v9    # "j":B
    goto/16 :goto_11a

    .end local v9    # "j":B
    :cond_1c9
    move/from16 v2, v18

    goto :goto_1c6

    .line 2021
    .restart local v9    # "j":B
    :cond_1cc
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->anoleSel:B

    goto :goto_196

    .line 2028
    .end local v7    # "c":B
    .end local v9    # "j":B
    :cond_1d3
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anoleSel:B

    move v2, v0

    move-object/from16 v0, p0

    move v1, v2

    invoke-direct {v0, v1}, Lmain/Map;->isAnoleType(I)Z

    move-result v2

    if-eqz v2, :cond_1eb

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->anoleSel:B

    move v2, v0

    add-int/lit8 v2, v2, 0x1

    :goto_1e8
    int-to-byte v9, v2

    .restart local v9    # "j":B
    goto/16 :goto_6b

    .end local v9    # "j":B
    :cond_1eb
    const/4 v2, 0x6

    goto :goto_1e8
.end method

.method private drawBrow()V
    .registers 14

    .prologue
    const/4 v12, 0x4

    const/4 v11, 0x1

    const/4 v10, 0x6

    const/4 v5, 0x0

    const/4 v9, -0x1

    .line 3500
    const/4 v6, 0x0

    .local v6, "i":B
    :goto_6
    iget-object v0, p0, Lmain/Map;->npcList:[B

    array-length v0, v0

    if-lt v6, v0, :cond_c

    .line 3524
    return-void

    .line 3501
    :cond_c
    iget-object v0, p0, Lmain/Map;->npcList:[B

    aget-byte v7, v0, v6

    .line 3502
    .local v7, "id":B
    if-ge v7, v9, :cond_16

    .line 3500
    :cond_12
    :goto_12
    add-int/lit8 v0, v6, 0x1

    int-to-byte v6, v0

    goto :goto_6

    .line 3503
    :cond_16
    if-ne v7, v9, :cond_ce

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    sput-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    .line 3505
    :goto_1c
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v12

    if-eq v0, v11, :cond_2d

    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v12

    const/4 v1, 0x2

    if-ne v0, v1, :cond_12

    .line 3506
    :cond_2d
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->brow_type:B

    if-gt v0, v9, :cond_3b

    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v10

    if-eqz v0, :cond_12

    .line 3507
    :cond_3b
    if-le v7, v9, :cond_4b

    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-short v0, v0, Ldm/Npc;->x:S

    sget-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    invoke-direct {p0, v0, v1}, Lmain/Map;->isNpcSrc(II)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 3508
    :cond_4b
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v10

    if-eqz v0, :cond_5d

    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    sget-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v10

    iput-byte v1, v0, Ldm/Npc;->brow_type:B

    .line 3509
    :cond_5d
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->brow_action:B

    iget-object v1, p0, Lmain/Map;->brow:Ldm/Sprite;

    sget-object v2, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->brow_type:B

    invoke-virtual {v1, v2}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_79

    .line 3510
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v10

    if-eqz v0, :cond_d8

    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iput-byte v5, v0, Ldm/Npc;->brow_action:B

    .line 3516
    :cond_79
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->brow:Ldm/Sprite;

    iget-object v2, p0, Lmain/Map;->brow:Ldm/Sprite;

    sget-object v3, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->brow_type:B

    sget-object v4, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->brow_action:B

    invoke-virtual {v2, v3, v4, v5}, Ldm/Sprite;->action(III)I

    move-result v2

    .line 3517
    iget v3, p0, Lmain/Map;->map_x:I

    sget-object v4, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->x:S

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0xe

    iget v4, p0, Lmain/Map;->map_y:I

    sget-object v8, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-short v8, v8, Ldm/Npc;->y:S

    add-int/2addr v4, v8

    const/16 v8, 0xf

    sub-int/2addr v4, v8

    const/16 v8, 0xa

    sub-int/2addr v4, v8

    .line 3516
    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    .line 3518
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v1, v0, Ldm/Npc;->brow_time:B

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    iput-byte v1, v0, Ldm/Npc;->brow_time:B

    iget-object v0, p0, Lmain/Map;->brow:Ldm/Sprite;

    sget-object v2, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->brow_type:B

    sget-object v3, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->brow_action:B

    invoke-virtual {v0, v2, v3, v11}, Ldm/Sprite;->action(III)I

    move-result v0

    if-le v1, v0, :cond_12

    .line 3519
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-byte v1, v0, Ldm/Npc;->brow_action:B

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    iput-byte v1, v0, Ldm/Npc;->brow_action:B

    .line 3520
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iput-byte v5, v0, Ldm/Npc;->brow_time:B

    goto/16 :goto_12

    .line 3504
    :cond_ce
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v5

    aget-object v0, v0, v7

    sput-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    goto/16 :goto_1c

    .line 3512
    :cond_d8
    sget-object v0, Lmain/Map;->cur_npc:Ldm/Npc;

    iput-byte v9, v0, Ldm/Npc;->brow_type:B

    goto/16 :goto_12
.end method

.method private drawCheck5(I)V
    .registers 10
    .param p1, "id"    # I

    .prologue
    const/4 v5, 0x0

    .line 3462
    iget-byte v0, p0, Lmain/Map;->checkNpcT:B

    const/4 v1, -0x1

    if-eq v0, v1, :cond_c

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-eqz v0, :cond_d

    .line 3478
    :cond_c
    :goto_c
    return-void

    .line 3465
    :cond_d
    invoke-direct {p0}, Lmain/Map;->drawHudong()V

    .line 3468
    iget-byte v0, p0, Lmain/Map;->checkNpcT:B

    if-ltz v0, :cond_c

    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v5

    iget-byte v1, p0, Lmain/Map;->checkNpcT:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x6

    aget-byte v0, v0, v1

    if-nez v0, :cond_c

    .line 3470
    invoke-direct {p0}, Lmain/Map;->drawHudong()V

    .line 3471
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->brow:Ldm/Sprite;

    iget-object v2, p0, Lmain/Map;->brow:Ldm/Sprite;

    iget-byte v3, p0, Lmain/Map;->action_5:B

    invoke-virtual {v2, p1, v3, v5}, Ldm/Sprite;->action(III)I

    move-result v2

    .line 3472
    iget v3, p0, Lmain/Map;->map_x:I

    iget-object v4, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v4, v4, v5

    iget-byte v6, p0, Lmain/Map;->checkNpcT:B

    aget-object v4, v4, v6

    iget-short v4, v4, Ldm/Npc;->x:S

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0xa

    iget v4, p0, Lmain/Map;->map_y:I

    iget-object v6, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v6, v6, v5

    iget-byte v7, p0, Lmain/Map;->checkNpcT:B

    aget-object v6, v6, v7

    iget-short v6, v6, Ldm/Npc;->y:S

    add-int/2addr v4, v6

    const/16 v6, 0x10

    sub-int/2addr v4, v6

    const/16 v6, 0xa

    sub-int/2addr v4, v6

    .line 3471
    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    .line 3473
    iget-byte v0, p0, Lmain/Map;->time_5:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/Map;->time_5:B

    iget-object v1, p0, Lmain/Map;->brow:Ldm/Sprite;

    iget-byte v2, p0, Lmain/Map;->action_5:B

    const/4 v3, 0x1

    invoke-virtual {v1, p1, v2, v3}, Ldm/Sprite;->action(III)I

    move-result v1

    if-le v0, v1, :cond_c

    .line 3474
    iget-byte v0, p0, Lmain/Map;->action_5:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/Map;->action_5:B

    iget-object v1, p0, Lmain/Map;->brow:Ldm/Sprite;

    invoke-virtual {v1, p1}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_7c

    iput-byte v5, p0, Lmain/Map;->action_5:B

    .line 3475
    :cond_7c
    iput-byte v5, p0, Lmain/Map;->time_5:B

    goto :goto_c
.end method

.method private drawCloud()V
    .registers 9

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 4011
    iget-object v1, p0, Lmain/Map;->imgCloud:Ljavax/microedition/lcdui/Image;

    if-nez v1, :cond_7

    .line 4019
    :cond_6
    return-void

    .line 4013
    :cond_7
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_8
    iget-object v1, p0, Lmain/Map;->cloud:[[S

    array-length v1, v1

    if-lt v0, v1, :cond_2c

    .line 4015
    const/4 v0, 0x0

    :goto_e
    iget-object v1, p0, Lmain/Map;->cloud:[[S

    array-length v1, v1

    if-ge v0, v1, :cond_6

    .line 4016
    iget-object v1, p0, Lmain/Map;->cloud:[[S

    aget-object v1, v1, v0

    aget-short v1, v1, v6

    iget-object v2, p0, Lmain/Map;->cloud:[[S

    aget-object v2, v2, v0

    aget-short v2, v2, v7

    invoke-direct {p0, v1, v2}, Lmain/Map;->isNpcSrc(II)Z

    move-result v1

    if-nez v1, :cond_4b

    invoke-direct {p0, v0}, Lmain/Map;->addCloud(I)V

    .line 4015
    :goto_28
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_e

    .line 4014
    :cond_2c
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v1

    iget-object v2, p0, Lmain/Map;->imgCloud:Ljavax/microedition/lcdui/Image;

    iget v3, p0, Lmain/Map;->map_x:I

    iget-object v4, p0, Lmain/Map;->cloud:[[S

    aget-object v4, v4, v0

    aget-short v4, v4, v6

    add-int/2addr v3, v4

    iget v4, p0, Lmain/Map;->map_y:I

    iget-object v5, p0, Lmain/Map;->cloud:[[S

    aget-object v5, v5, v0

    aget-short v5, v5, v7

    add-int/2addr v4, v5

    invoke-virtual {v1, v2, v3, v4, v6}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 4013
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_8

    .line 4017
    :cond_4b
    iget-object v1, p0, Lmain/Map;->cloud:[[S

    aget-object v1, v1, v0

    aget-short v2, v1, v6

    iget-object v3, p0, Lmain/Map;->cloud:[[S

    aget-object v3, v3, v0

    const/4 v4, 0x2

    aget-short v3, v3, v4

    sub-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v1, v6

    goto :goto_28
.end method

.method private drawHudong()V
    .registers 6

    .prologue
    .line 3484
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->hudong:Ljavax/microedition/lcdui/Image;

    sget v2, Lmain/Constants_H;->WIDTH_H:I

    sget v3, Lmain/Constants_H;->HEIGHT:I

    const/16 v4, 0x1e

    sub-int/2addr v3, v4

    const/4 v4, 0x3

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 3485
    return-void
.end method

.method private drawMapRect(BBIZ)V
    .registers 17
    .param p1, "ww"    # B
    .param p2, "hh"    # B
    .param p3, "tmap"    # I
    .param p4, "select"    # Z

    .prologue
    .line 2736
    mul-int/lit8 v4, p1, 0x6

    .local v4, "width":I
    mul-int/lit8 v5, p2, 0x6

    .line 2737
    .local v5, "height":I
    iget-boolean v0, p0, Lmain/Map;->miniMapMode:Z

    if-eqz v0, :cond_1a

    .line 2738
    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v1, 0x6

    aget-byte v0, v0, v1

    mul-int v4, v0, p1

    .line 2739
    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v1, 0x7

    aget-byte v0, v0, v1

    mul-int v5, v0, p2

    .line 2781
    :cond_1a
    if-eqz p4, :cond_3e

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const v1, 0xbc7afc

    iget-object v2, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v2, v2, p3

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    mul-int/2addr v2, p1

    iget-short v3, p0, Lmain/Map;->mapoffx:S

    add-int/2addr v2, v3

    .line 2782
    iget-object v3, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v3, v3, p3

    const/4 v6, 0x1

    aget-byte v3, v3, v6

    mul-int/2addr v3, p2

    iget-short v6, p0, Lmain/Map;->mapoffy:S

    add-int/2addr v3, v6

    const/4 v6, 0x5

    .line 2781
    invoke-virtual/range {v0 .. v6}, Ldm/Ui;->drawRectZ(IIIIII)V

    .line 2795
    :cond_3d
    :goto_3d
    return-void

    .line 2785
    :cond_3e
    iget-byte v0, p0, Lmain/Map;->myMiniMap:B

    if-ne p3, v0, :cond_c2

    .line 2786
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v1

    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v2, 0x0

    aget-byte v0, v0, v2

    mul-int/2addr v0, p1

    iget-short v2, p0, Lmain/Map;->mapoffx:S

    add-int/2addr v2, v0

    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v3, 0x1

    aget-byte v0, v0, v3

    mul-int/2addr v0, p2

    iget-short v3, p0, Lmain/Map;->mapoffy:S

    add-int/2addr v3, v0

    const/4 v6, 0x4

    invoke-virtual/range {v1 .. v6}, Ldm/Ui;->drawK1(IIIII)V

    .line 2788
    :goto_60
    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v0, p3}, Lmain/GameRun;->getNameCity(I)Ljava/lang/String;

    move-result-object v7

    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    mul-int/2addr v0, p1

    iget-short v1, p0, Lmain/Map;->mapoffx:S

    add-int/2addr v0, v1

    shr-int/lit8 v1, v4, 0x1

    add-int v8, v0, v1

    .line 2789
    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v1, 0x1

    aget-byte v0, v0, v1

    mul-int/2addr v0, p2

    iget-short v1, p0, Lmain/Map;->mapoffy:S

    add-int/2addr v0, v1

    shr-int/lit8 v1, v5, 0x1

    add-int/2addr v0, v1

    const/16 v1, 0x19

    sub-int v9, v0, v1

    const/4 v10, 0x4

    iget-byte v0, p0, Lmain/Map;->myMiniMap:B

    if-ne p3, v0, :cond_e1

    const/4 v0, 0x0

    move v11, v0

    .line 2788
    :goto_90
    invoke-virtual/range {v6 .. v11}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 2790
    iget-byte v0, p0, Lmain/Map;->myMiniMap:B

    if-ne p3, v0, :cond_3d

    .line 2791
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    const/16 v7, 0x43

    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    mul-int/2addr v0, p1

    iget-short v1, p0, Lmain/Map;->mapoffx:S

    add-int/2addr v0, v1

    shr-int/lit8 v1, v4, 0x1

    add-int v8, v0, v1

    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v1, 0x1

    aget-byte v0, v0, v1

    mul-int/2addr v0, p2

    iget-short v1, p0, Lmain/Map;->mapoffy:S

    add-int/2addr v0, v1

    shr-int/lit8 v1, v5, 0x1

    add-int v9, v0, v1

    .line 2792
    const/4 v10, 0x3

    const/4 v11, 0x0

    .line 2791
    invoke-virtual/range {v6 .. v11}, Ldm/Ui;->drawUi(IIIII)V

    goto/16 :goto_3d

    .line 2787
    :cond_c2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v1

    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v2, 0x0

    aget-byte v0, v0, v2

    mul-int/2addr v0, p1

    iget-short v2, p0, Lmain/Map;->mapoffx:S

    add-int/2addr v2, v0

    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    aget-object v0, v0, p3

    const/4 v3, 0x1

    aget-byte v0, v0, v3

    mul-int/2addr v0, p2

    iget-short v3, p0, Lmain/Map;->mapoffy:S

    add-int/2addr v3, v0

    const/4 v6, 0x2

    invoke-virtual/range {v1 .. v6}, Ldm/Ui;->drawK0(IIIII)V

    goto :goto_60

    .line 2789
    :cond_e1
    const/4 v0, 0x3

    move v11, v0

    goto :goto_90
.end method

.method private drawMapRect(Ljavax/microedition/lcdui/Graphics;)V
    .registers 15
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    const/16 v3, 0x13

    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 4029
    const/4 v9, 0x0

    .line 4030
    .local v9, "i":B
    invoke-virtual {p1, v11}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 4031
    :goto_8
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->mapRect:[[B

    array-length v0, v0

    if-lt v9, v0, :cond_10

    .line 4042
    return-void

    .line 4032
    :cond_10
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->x:S

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v2, Ldm/Npc;->y:S

    .line 4033
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->mapRect:[[B

    aget-object v4, v4, v9

    aget-byte v4, v4, v11

    mul-int/lit8 v5, v4, 0x14

    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->mapRect:[[B

    aget-object v4, v4, v9

    aget-byte v4, v4, v12

    mul-int/lit8 v6, v4, 0x14

    .line 4034
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->mapRect:[[B

    aget-object v4, v4, v9

    const/4 v7, 0x2

    aget-byte v4, v4, v7

    iget-object v7, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v7, v7, Lmain/GameRun;->mapRect:[[B

    aget-object v7, v7, v9

    aget-byte v7, v7, v11

    sub-int/2addr v4, v7

    add-int/lit8 v4, v4, 0x1

    mul-int/lit8 v7, v4, 0x14

    .line 4035
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->mapRect:[[B

    aget-object v4, v4, v9

    const/4 v8, 0x3

    aget-byte v4, v4, v8

    iget-object v8, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v8, v8, Lmain/GameRun;->mapRect:[[B

    aget-object v8, v8, v9

    aget-byte v8, v8, v12

    sub-int/2addr v4, v8

    add-int/lit8 v4, v4, 0x1

    mul-int/lit8 v8, v4, 0x14

    move v4, v3

    .line 4032
    invoke-virtual/range {v0 .. v8}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v0

    if-eqz v0, :cond_67

    .line 4031
    :cond_63
    add-int/lit8 v0, v9, 0x1

    int-to-byte v9, v0

    goto :goto_8

    .line 4036
    :cond_67
    const/4 v10, 0x4

    .local v10, "j":B
    :goto_68
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->mapRect:[[B

    aget-object v0, v0, v9

    array-length v0, v0

    if-ge v10, v0, :cond_63

    .line 4037
    iget v0, p0, Lmain/Map;->map_x:I

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->mapRect:[[B

    aget-object v1, v1, v9

    aget-byte v1, v1, v10

    mul-int/lit8 v1, v1, 0x14

    add-int/2addr v0, v1

    iget v1, p0, Lmain/Map;->map_y:I

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->mapRect:[[B

    aget-object v2, v2, v9

    add-int/lit8 v4, v10, 0x1

    aget-byte v2, v2, v4

    mul-int/lit8 v2, v2, 0x14

    add-int/2addr v1, v2

    .line 4038
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->mapRect:[[B

    aget-object v2, v2, v9

    add-int/lit8 v4, v10, 0x2

    aget-byte v2, v2, v4

    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->mapRect:[[B

    aget-object v4, v4, v9

    aget-byte v4, v4, v10

    sub-int/2addr v2, v4

    add-int/lit8 v2, v2, 0x1

    mul-int/lit8 v2, v2, 0x14

    .line 4039
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->mapRect:[[B

    aget-object v4, v4, v9

    add-int/lit8 v5, v10, 0x3

    aget-byte v4, v4, v5

    iget-object v5, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v5, v5, Lmain/GameRun;->mapRect:[[B

    aget-object v5, v5, v9

    add-int/lit8 v6, v10, 0x1

    aget-byte v5, v5, v6

    sub-int/2addr v4, v5

    add-int/lit8 v4, v4, 0x1

    mul-int/lit8 v4, v4, 0x14

    .line 4037
    invoke-virtual {p1, v0, v1, v2, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 4036
    add-int/lit8 v0, v10, 0x4

    int-to-byte v10, v0

    goto :goto_68
.end method

.method private drawMiniMap()V
    .registers 23

    .prologue
    .line 2693
    sget-object v5, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v6, Lmain/MainCanvas;->mainxx:F

    iput v6, v5, Lmain/MainCanvas;->keyxx:F

    .line 2694
    sget-object v5, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v6, Lmain/MainCanvas;->mainyy:F

    iput v6, v5, Lmain/MainCanvas;->keyyy:F

    .line 2695
    const/16 v13, 0x280

    .local v13, "WIDTH":I
    const/16 v12, 0x168

    .line 2696
    .local v12, "HEIGHT":I
    const/16 v14, 0x140

    .line 2697
    .local v14, "WIDTH_H":I
    const/16 v21, 0xc

    .local v21, "x":S
    const/16 v15, 0x1d

    .line 2699
    .local v15, "fh":S
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ui;->fillRectB()V

    .line 2700
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x2

    const/4 v8, 0x2

    sub-int v8, v13, v8

    const/4 v9, 0x2

    sub-int v9, v12, v9

    const/4 v10, 0x0

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK2(IIIII)V

    .line 2701
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x6

    const/16 v7, 0x21

    const/16 v8, 0xc

    sub-int v8, v13, v8

    mul-int/lit8 v9, v15, 0x3

    sub-int v9, v12, v9

    const/16 v10, 0xf

    sub-int/2addr v9, v10

    const/4 v10, 0x1

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK1(IIIII)V

    .line 2702
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x6

    const/4 v7, 0x6

    sub-int v7, v12, v7

    mul-int/lit8 v8, v15, 0x2

    sub-int/2addr v7, v8

    const/16 v8, 0xc

    sub-int v8, v13, v8

    mul-int/lit8 v9, v15, 0x2

    const/4 v10, 0x2

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK1(IIIII)V

    .line 2703
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 2704
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const-string v6, "\u6e38\u620f\u5730\u56fe"

    const/4 v8, 0x4

    const/16 v9, 0x11

    const/4 v10, 0x1

    const/4 v11, 0x2

    move v7, v14

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2706
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->showArea:B

    move v5, v0

    const/4 v6, -0x1

    if-ne v5, v6, :cond_90

    .line 2707
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const-string v6, "\u8be5\u533a\u57df\u6ca1\u6709\u5730\u56fe\uff01"

    const/4 v7, 0x4

    sub-int v7, v12, v7

    mul-int/lit8 v8, v15, 0x2

    sub-int v8, v7, v8

    const/16 v7, 0x10

    or-int/lit8 v9, v7, 0x1

    const/4 v10, 0x3

    const/4 v11, 0x0

    move v7, v14

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2734
    :goto_8f
    return-void

    .line 2710
    :cond_90
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "\u4eba\u7269\u5f53\u524d\u4f4d\u7f6e\uff1a"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v7, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->myMiniMap:B

    move v8, v0

    invoke-virtual {v7, v8}, Lmain/GameRun;->getNameCity(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x4

    sub-int v7, v12, v7

    mul-int/lit8 v8, v15, 0x2

    sub-int v8, v7, v8

    const/16 v9, 0xa

    const/4 v10, 0x3

    move v7, v14

    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 2711
    sget-object v5, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v6, 0x6

    const/16 v7, 0x21

    const/16 v8, 0xc

    sub-int v8, v13, v8

    const/16 v9, 0xf

    sub-int v9, v12, v9

    mul-int/lit8 v10, v15, 0x3

    sub-int/2addr v9, v10

    invoke-virtual {v5, v6, v7, v8, v9}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 2712
    const/16 v20, 0x12

    .local v20, "ww":B
    const/16 v16, 0xc

    .local v16, "hh":B
    const/16 v17, 0x0

    .line 2714
    .local v17, "j":B
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataMap:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->selectMap:B

    move v6, v0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    mul-int v5, v5, v20

    sub-int v5, v14, v5

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lmain/Map;->miniMapMode:Z

    move v6, v0

    if-eqz v6, :cond_1b7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataMap:[[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->selectMap:B

    move v7, v0

    aget-object v6, v6, v7

    const/4 v7, 0x6

    aget-byte v6, v6, v7

    mul-int v6, v6, v20

    div-int/lit8 v6, v6, 0x2

    :goto_106
    sub-int v18, v5, v6

    .line 2715
    .local v18, "t":I
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->mapoffx:S

    move v6, v0

    const/16 v7, 0xa

    const/4 v8, 0x0

    move-object v0, v5

    move v1, v6

    move/from16 v2, v18

    move v3, v7

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->mapoffx:S

    .line 2716
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->littleMapClipY:S

    move v5, v0

    div-int/lit8 v5, v5, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataMap:[[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->selectMap:B

    move v7, v0

    aget-object v6, v6, v7

    const/4 v7, 0x1

    aget-byte v6, v6, v7

    mul-int v6, v6, v16

    sub-int/2addr v5, v6

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lmain/Map;->miniMapMode:Z

    move v6, v0

    if-eqz v6, :cond_1bb

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataMap:[[B

    move-object v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->selectMap:B

    move v7, v0

    aget-object v6, v6, v7

    const/4 v7, 0x7

    aget-byte v6, v6, v7

    mul-int v6, v6, v16

    div-int/lit8 v6, v6, 0x2

    :goto_156
    sub-int v18, v5, v6

    .line 2717
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->mapoffy:S

    move v6, v0

    const/16 v7, 0xa

    const/4 v8, 0x0

    move-object v0, v5

    move v1, v6

    move/from16 v2, v18

    move v3, v7

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->mapoffy:S

    .line 2718
    :goto_173
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataArea:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->showArea:B

    move v6, v0

    aget-object v5, v5, v6

    array-length v5, v5

    move/from16 v0, v17

    move v1, v5

    if-lt v0, v1, :cond_1be

    .line 2731
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lmain/Map;->miniMapMode:Z

    move v5, v0

    if-nez v5, :cond_19d

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->myMiniMap:B

    move v5, v0

    const/4 v6, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v16

    move v3, v5

    move v4, v6

    invoke-direct {v0, v1, v2, v3, v4}, Lmain/Map;->drawMapRect(BBIZ)V

    .line 2732
    :cond_19d
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->selectMap:B

    move v5, v0

    const/4 v6, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v16

    move v3, v5

    move v4, v6

    invoke-direct {v0, v1, v2, v3, v4}, Lmain/Map;->drawMapRect(BBIZ)V

    .line 2733
    sget-object v5, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7, v13, v12}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    goto/16 :goto_8f

    .line 2714
    .end local v18    # "t":I
    :cond_1b7
    const/16 v6, 0x19

    goto/16 :goto_106

    .line 2716
    .restart local v18    # "t":I
    :cond_1bb
    const/16 v6, 0xf

    goto :goto_156

    .line 2719
    :cond_1be
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataArea:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->showArea:B

    move v6, v0

    aget-object v5, v5, v6

    aget-byte v19, v5, v17

    .line 2720
    .local v19, "tmap":B
    if-gez v19, :cond_1d5

    .line 2718
    :cond_1ce
    :goto_1ce
    add-int/lit8 v5, v17, 0x1

    move v0, v5

    int-to-byte v0, v0

    move/from16 v17, v0

    goto :goto_173

    .line 2721
    :cond_1d5
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataMap:[[B

    move-object v5, v0

    aget-object v5, v5, v19

    array-length v5, v5

    if-lez v5, :cond_1ce

    .line 2723
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataMap:[[B

    move-object v6, v0

    aget-object v6, v6, v19

    const/4 v7, 0x0

    aget-byte v6, v6, v7

    mul-int v6, v6, v20

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->mapoffx:S

    move v7, v0

    add-int/2addr v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapdataMap:[[B

    move-object v7, v0

    aget-object v7, v7, v19

    const/4 v8, 0x1

    aget-byte v7, v7, v8

    mul-int v7, v7, v16

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->mapoffy:S

    move v8, v0

    add-int/2addr v7, v8

    mul-int/lit8 v8, v20, 0x6

    mul-int/lit8 v9, v16, 0x6

    invoke-virtual {v5, v6, v7, v8, v9}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_218

    .line 2724
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->selectMap:B

    .line 2727
    :cond_218
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lmain/Map;->miniMapMode:Z

    move v5, v0

    if-nez v5, :cond_229

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->myMiniMap:B

    move v5, v0

    move/from16 v0, v19

    move v1, v5

    if-eq v0, v1, :cond_1ce

    .line 2728
    :cond_229
    const/4 v5, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v20

    move/from16 v2, v16

    move/from16 v3, v19

    move v4, v5

    invoke-direct {v0, v1, v2, v3, v4}, Lmain/Map;->drawMapRect(BBIZ)V

    goto :goto_1ce
.end method

.method private drawMission()V
    .registers 21

    .prologue
    .line 2952
    const/16 v16, 0x280

    .local v16, "WIDTH":I
    const/16 v14, 0x168

    .line 2953
    .local v14, "HEIGHT":I
    const/16 v17, 0x140

    .local v17, "WIDTH_H":I
    const/16 v15, 0xb4

    .line 2954
    .local v15, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    invoke-virtual {v3}, Ldm/Ui;->fillRectB()V

    .line 2959
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const/4 v4, 0x1

    const/4 v5, 0x6

    const/4 v6, 0x2

    sub-int v6, v16, v6

    const/4 v7, 0x6

    sub-int v7, v14, v7

    const/4 v8, 0x0

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawK2(IIIII)V

    .line 2960
    const/16 v5, 0x29

    .line 2962
    .local v5, "ly":S
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const/16 v4, 0x8

    const/16 v6, 0x1a

    sub-int v6, v16, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->line_max:B

    mul-int/lit8 v7, v7, 0x1d

    add-int/lit8 v7, v7, 0xa

    const/4 v8, 0x1

    invoke-virtual/range {v3 .. v8}, Ldm/Ui;->drawK1(IIIII)V

    .line 2970
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    const/16 v7, 0x8

    add-int/lit8 v3, v5, 0x12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->line_max:B

    mul-int/lit8 v3, v3, 0x1d

    add-int/lit8 v8, v3, 0x3b

    const/16 v3, 0x10

    sub-int v9, v16, v3

    const/16 v10, 0x7d

    const/4 v11, 0x2

    invoke-virtual/range {v6 .. v11}, Ldm/Ui;->drawK1(IIIII)V

    .line 2972
    const/16 v7, 0x8

    add-int/lit8 v8, v5, 0x6

    const/16 v3, 0x1a

    sub-int v9, v16, v3

    const/16 v10, 0x1d

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v11, v3, Lmain/GameRun;->line_max:B

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-object v3, v3, Lmain/GameRun;->select:[[B

    const/4 v4, 0x0

    aget-object v12, v3, v4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    if-nez v3, :cond_1a5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bMission:[B

    move-object v3, v0

    const/16 v4, 0xe

    aget-byte v3, v3, v4

    add-int/lit8 v3, v3, 0x1

    move v13, v3

    :goto_87
    move-object/from16 v6, p0

    invoke-direct/range {v6 .. v13}, Lmain/Map;->drawMisstionList(IIIII[BI)V

    .line 2973
    const/16 v18, 0x0

    .line 2974
    .local v18, "d":B
    :goto_8e
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-object v3, v3, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    if-eqz v3, :cond_a4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-object v3, v3, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    array-length v3, v3

    move/from16 v0, v18

    move v1, v3

    if-lt v0, v1, :cond_1ae

    .line 2981
    :cond_a4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v6, v0

    const/4 v7, 0x2

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/16 v11, 0x28

    move/from16 v10, v17

    invoke-virtual/range {v6 .. v11}, Lmain/PointerKey;->selectMenuX(IIIII)B

    move-result v19

    .line 2982
    .local v19, "t":B
    const/4 v3, -0x1

    move/from16 v0, v19

    move v1, v3

    if-eq v0, v1, :cond_d7

    .line 2983
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    move/from16 v0, v19

    move-object v1, v3

    iput-byte v0, v1, Lmain/GameRun;->cur_a:B

    .line 2984
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lmain/Map;->bPause:Z

    move v4, v0

    move-object/from16 v0, p0

    move v1, v3

    move v2, v4

    invoke-virtual {v0, v1, v2}, Lmain/Map;->goMission(IZ)V

    .line 2988
    :cond_d7
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    if-nez v3, :cond_1df

    const/16 v3, 0x7d

    sub-int v3, v17, v3

    move v7, v3

    :goto_e9
    const/16 v8, 0x9

    const/16 v9, 0x64

    const/16 v10, 0x1d

    const/4 v11, 0x4

    invoke-virtual/range {v6 .. v11}, Ldm/Ui;->drawK1(IIIII)V

    .line 2989
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    const-string v7, "\u4e3b\u7ebf\u4efb\u52a1"

    const/16 v3, 0x4b

    sub-int v8, v17, v3

    const/16 v9, 0x9

    const/16 v10, 0x11

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    if-nez v3, :cond_1e4

    const/4 v3, 0x0

    move v11, v3

    :goto_10c
    const/4 v12, 0x0

    invoke-virtual/range {v6 .. v12}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2990
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    const-string v7, "\u5206\u652f\u4efb\u52a1"

    add-int/lit8 v8, v17, 0x4b

    const/16 v9, 0x9

    const/16 v10, 0x11

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    const/4 v4, 0x1

    if-ne v3, v4, :cond_1e8

    const/4 v3, 0x0

    move v11, v3

    :goto_128
    const/4 v12, 0x0

    invoke-virtual/range {v6 .. v12}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 2991
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    const/16 v8, 0x14

    const/16 v9, 0x96

    const/4 v10, 0x1

    const/4 v11, 0x1

    move/from16 v7, v17

    invoke-virtual/range {v6 .. v11}, Ldm/Ui;->drawTriangle(IIIZZ)V

    .line 3003
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    new-instance v3, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v4, v0

    iget-byte v4, v4, Lmain/GameRun;->cur_a:B

    if-nez v4, :cond_1ec

    const-string v4, "\u4e3b\u7ebf\u5b8c\u6210\u5ea6\uff1a"

    :goto_14c
    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 3004
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bMission:[B

    move-object v5, v0

    .end local v5    # "ly":S
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->cur_a:B

    if-nez v7, :cond_1f0

    const/16 v7, 0xe

    :goto_167
    aget-byte v5, v5, v7

    mul-int/lit16 v5, v5, 0x3e8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->cur_a:B

    if-nez v7, :cond_1f4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    move-object v7, v0

    array-length v7, v7

    const/4 v8, 0x1

    sub-int/2addr v7, v8

    .line 3005
    :goto_17c
    div-int/2addr v5, v7

    .line 3004
    invoke-virtual {v4, v5}, Ldm/Ms;->getPrecision(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 3005
    const-string v4, "%"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const/4 v3, 0x1

    sub-int v9, v14, v3

    const/16 v10, 0x21

    const/4 v11, -0x1

    const/4 v12, 0x1

    move/from16 v8, v17

    .line 3003
    invoke-virtual/range {v6 .. v12}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 3011
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x1

    invoke-virtual {v3, v4, v5}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 3012
    return-void

    .line 2972
    .end local v18    # "d":B
    .end local v19    # "t":B
    .restart local v5    # "ly":S
    :cond_1a5
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mDirect:[B

    move-object v3, v0

    array-length v3, v3

    move v13, v3

    goto/16 :goto_87

    .line 2978
    .restart local v18    # "d":B
    :cond_1ae
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-object v3, v3, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    aget-object v3, v3, v18

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x19

    add-int/lit8 v3, v5, 0x14

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v3, v0

    iget-byte v3, v3, Lmain/GameRun;->line_max:B

    mul-int/lit8 v3, v3, 0x1d

    add-int/lit8 v3, v3, 0x3d

    mul-int/lit8 v4, v18, 0x19

    add-int v9, v3, v4

    const/4 v10, 0x3

    const/4 v11, 0x0

    invoke-virtual/range {v6 .. v11}, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V

    .line 2974
    add-int/lit8 v3, v18, 0x1

    move v0, v3

    int-to-byte v0, v0

    move/from16 v18, v0

    goto/16 :goto_8e

    .line 2988
    .restart local v19    # "t":B
    :cond_1df
    add-int/lit8 v3, v17, 0x19

    move v7, v3

    goto/16 :goto_e9

    .line 2989
    :cond_1e4
    const/4 v3, 0x1

    move v11, v3

    goto/16 :goto_10c

    .line 2990
    :cond_1e8
    const/4 v3, 0x1

    move v11, v3

    goto/16 :goto_128

    .line 3003
    :cond_1ec
    const-string v4, "\u5206\u652f\u5b8c\u6210\u5ea6\uff1a"

    goto/16 :goto_14c

    .line 3004
    .end local v5    # "ly":S
    :cond_1f0
    const/16 v7, 0xf

    goto/16 :goto_167

    .line 3005
    :cond_1f4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    move-object v7, v0

    array-length v7, v7

    goto :goto_17c
.end method

.method private drawMisstionList(IIIII[BI)V
    .registers 23
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "w"    # I
    .param p4, "sh"    # I
    .param p5, "show_num"    # I
    .param p6, "sel"    # [B
    .param p7, "length"    # I

    .prologue
    .line 3014
    const/16 v13, 0x280

    .line 3015
    .local v13, "WIDTH":I
    const/4 v2, 0x1

    aget-byte v14, p6, v2

    .line 3017
    .local v14, "i":B
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    const/4 v7, 0x6

    const/4 v9, -0x1

    const/4 v3, 0x0

    aget-byte v3, p6, v3

    const/4 v4, 0x1

    aget-byte v4, p6, v4

    sub-int v10, v3, v4

    const/4 v11, 0x4

    const/4 v12, 0x2

    move/from16 v3, p5

    move/from16 v4, p1

    move/from16 v5, p2

    move/from16 v6, p3

    move/from16 v8, p4

    invoke-virtual/range {v2 .. v12}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 3018
    :goto_22
    const/4 v2, 0x1

    aget-byte v2, p6, v2

    add-int v2, v2, p5

    if-lt v14, v2, :cond_3f

    .line 3042
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    add-int v2, p1, p3

    add-int/lit8 v5, v2, 0x4

    mul-int v7, p5, p4

    const/4 v2, 0x0

    aget-byte v8, p6, v2

    const/4 v10, 0x1

    move/from16 v6, p2

    move/from16 v9, p7

    invoke-virtual/range {v4 .. v10}, Ldm/Ui;->sliding(IIIIIZ)V

    .line 3043
    return-void

    .line 3019
    :cond_3f
    move v0, v14

    move/from16 v1, p7

    if-ge v0, v1, :cond_119

    .line 3020
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    if-nez v2, :cond_11e

    new-instance v2, Ljava/lang/StringBuilder;

    add-int/lit8 v3, v14, 0x1

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "\u3001"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    aget-object v3, v3, v14

    const/4 v4, 0x0

    aget-object v3, v3, v4

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 3022
    .local v3, "s":Ljava/lang/String;
    :goto_6e
    const-string v2, "sk"

    const-string v4, "drawMisstionList"

    invoke-static {v2, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 3023
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v2

    add-int/lit8 v4, p1, 0x8

    const/4 v5, 0x1

    aget-byte v5, p6, v5

    sub-int v5, v14, v5

    const/4 v6, 0x1

    sub-int v6, p4, v6

    mul-int/2addr v5, v6

    add-int v5, v5, p2

    const/4 v6, 0x0

    iget-object v7, p0, Lmain/Map;->bMission:[B

    const/16 v8, 0xe

    aget-byte v7, v7, v8

    if-ge v14, v7, :cond_148

    const/4 v7, -0x1

    :goto_90
    const/4 v8, 0x0

    invoke-virtual/range {v2 .. v8}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 3026
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    if-nez v2, :cond_c6

    const/4 v2, 0x1

    sub-int v2, p7, v2

    if-eq v14, v2, :cond_c6

    .line 3027
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    const-string v5, "\u5b8c\u6210"

    add-int v2, p1, p3

    const/16 v3, 0x8

    sub-int v6, v2, v3

    const/4 v2, 0x1

    aget-byte v2, p6, v2

    .end local v3    # "s":Ljava/lang/String;
    sub-int v2, v14, v2

    const/4 v3, 0x1

    sub-int v3, p4, v3

    mul-int/2addr v2, v3

    add-int v7, p2, v2

    .line 3028
    const/16 v8, 0x18

    iget-object v2, p0, Lmain/Map;->bMission:[B

    const/16 v3, 0xe

    aget-byte v2, v2, v3

    if-ge v14, v2, :cond_153

    const/4 v2, -0x1

    move v9, v2

    :goto_c2
    const/4 v10, 0x0

    .line 3027
    invoke-virtual/range {v4 .. v10}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 3031
    :cond_c6
    iget-object v2, p0, Lmain/Map;->pkey:Lmain/PointerKey;

    const/4 v3, 0x0

    const/4 v4, 0x1

    aget-byte v4, p6, v4

    sub-int v4, v14, v4

    const/4 v5, 0x1

    sub-int v5, p4, v5

    mul-int/2addr v4, v5

    add-int v4, v4, p2

    const/4 v5, 0x1

    sub-int v5, p4, v5

    invoke-virtual {v2, v3, v4, v13, v5}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v2

    if-eqz v2, :cond_119

    .line 3032
    const/4 v2, 0x0

    aput-byte v14, p6, v2

    .line 3033
    const/4 v2, 0x1

    aget-byte v2, p6, v2

    sub-int v2, v14, v2

    if-nez v2, :cond_160

    const/4 v2, 0x1

    aget-byte v2, p6, v2

    if-lez v2, :cond_160

    const/4 v2, 0x1

    aget-byte v3, p6, v2

    const/4 v4, 0x1

    sub-int/2addr v3, v4

    int-to-byte v3, v3

    aput-byte v3, p6, v2

    .line 3035
    :cond_f4
    :goto_f4
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    if-nez v2, :cond_17e

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->select:[[B

    const/4 v5, 0x0

    aget-object v4, v4, v5

    const/4 v5, 0x0

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    const/4 v4, 0x1

    aget-object v3, v3, v4

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x32

    sub-int v4, v13, v4

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v4, v5}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 3040
    :cond_119
    :goto_119
    add-int/lit8 v2, v14, 0x1

    int-to-byte v14, v2

    goto/16 :goto_22

    .line 3021
    :cond_11e
    new-instance v2, Ljava/lang/StringBuilder;

    add-int/lit8 v3, v14, 0x1

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "\u3001"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    iget-object v4, p0, Lmain/Map;->mDirect:[B

    aget-byte v4, v4, v14

    aget-object v3, v3, v4

    const/4 v4, 0x0

    aget-object v3, v3, v4

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .restart local v3    # "s":Ljava/lang/String;
    goto/16 :goto_6e

    .line 3023
    :cond_148
    const/4 v7, 0x0

    aget-byte v7, p6, v7

    if-ne v7, v14, :cond_150

    const/4 v7, 0x0

    goto/16 :goto_90

    :cond_150
    const/4 v7, 0x3

    goto/16 :goto_90

    .line 3028
    .end local v3    # "s":Ljava/lang/String;
    :cond_153
    const/4 v2, 0x0

    aget-byte v2, p6, v2

    if-ne v2, v14, :cond_15c

    const/4 v2, 0x0

    move v9, v2

    goto/16 :goto_c2

    :cond_15c
    const/4 v2, 0x3

    move v9, v2

    goto/16 :goto_c2

    .line 3034
    :cond_160
    const/4 v2, 0x1

    aget-byte v2, p6, v2

    sub-int v2, v14, v2

    const/4 v3, 0x1

    sub-int v3, p5, v3

    if-ne v2, v3, :cond_f4

    const/4 v2, 0x1

    aget-byte v2, p6, v2

    add-int v2, v2, p5

    move v0, v2

    move/from16 v1, p7

    if-ge v0, v1, :cond_f4

    const/4 v2, 0x1

    aget-byte v3, p6, v2

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    aput-byte v3, p6, v2

    goto/16 :goto_f4

    .line 3036
    :cond_17e
    iget-object v2, p0, Lmain/Map;->mDirect:[B

    array-length v2, v2

    if-lez v2, :cond_119

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    iget-object v4, p0, Lmain/Map;->mDirect:[B

    iget-object v5, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v5, v5, Lmain/GameRun;->select:[[B

    const/4 v6, 0x0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    aget-byte v5, v5, v6

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    const/4 v4, 0x1

    aget-object v3, v3, v4

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x32

    sub-int v4, v13, v4

    const/4 v5, 0x0

    invoke-virtual {v2, v3, v4, v5}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    goto/16 :goto_119
.end method

.method private drawMySave()V
    .registers 6

    .prologue
    const/4 v4, 0x1

    .line 2848
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v1, "\u662f\u5426\u5b58\u76d8?"

    const/16 v2, 0x11d

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, v3}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    .line 2849
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    invoke-virtual {v0, v4, v4}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 2850
    return-void
.end method

.method private drawNMAni([Ldm/Npc;)V
    .registers 10
    .param p1, "npc"    # [Ldm/Npc;

    .prologue
    .line 3620
    if-nez p1, :cond_3

    .line 3649
    :cond_2
    return-void

    .line 3623
    :cond_3
    const/4 v6, 0x0

    .local v6, "i":B
    :goto_4
    iget-object v0, p0, Lmain/Map;->npcList:[B

    array-length v0, v0

    if-ge v6, v0, :cond_2

    .line 3624
    iget-object v0, p0, Lmain/Map;->npcList:[B

    aget-byte v7, v0, v6

    .line 3625
    .local v7, "id":B
    const/4 v0, -0x1

    if-ne v7, v0, :cond_48

    .line 3627
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x4

    aget-byte v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_24

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x4

    aget-byte v0, v0, v1

    const/4 v1, 0x2

    if-ne v0, v1, :cond_44

    .line 3628
    :cond_24
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v2, 0x0

    iget v0, p0, Lmain/Map;->map_x:I

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v3, v3, Ldm/Npc;->x:S

    add-int/2addr v0, v3

    add-int/lit8 v3, v0, 0xa

    iget v0, p0, Lmain/Map;->map_y:I

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->y:S

    add-int/2addr v0, v4

    add-int/lit8 v4, v0, 0x13

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v5, 0x7

    aget-byte v5, v0, v5

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lmain/Map;->drawMyAni(Ldm/Npc;IIII)V

    .line 3623
    :cond_44
    :goto_44
    add-int/lit8 v0, v6, 0x1

    int-to-byte v6, v0

    goto :goto_4

    .line 3629
    :cond_48
    const/4 v0, -0x1

    if-ge v7, v0, :cond_a3

    .line 3630
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v7}, Ldm/Ms;->abs(I)I

    move-result v0

    const/4 v1, 0x2

    sub-int/2addr v0, v1

    int-to-byte v7, v0

    .line 3631
    iget-object v0, p0, Lmain/Map;->item:[[B

    aget-object v0, v0, v7

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    mul-int/lit8 v0, v0, 0x14

    iget-object v1, p0, Lmain/Map;->item:[[B

    aget-object v1, v1, v7

    const/4 v2, 0x1

    aget-byte v1, v1, v2

    mul-int/lit8 v1, v1, 0x14

    invoke-direct {p0, v0, v1}, Lmain/Map;->isNpcSrc(II)Z

    move-result v0

    if-eqz v0, :cond_44

    .line 3632
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->item:[[B

    aget-object v1, v1, v7

    const/4 v2, 0x2

    aget-byte v1, v1, v2

    const/4 v2, 0x2

    if-ne v1, v2, :cond_a0

    const/16 v1, 0x37

    :goto_7d
    iget v2, p0, Lmain/Map;->map_x:I

    iget-object v3, p0, Lmain/Map;->item:[[B

    aget-object v3, v3, v7

    const/4 v4, 0x0

    aget-byte v3, v3, v4

    mul-int/lit8 v3, v3, 0x14

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0xa

    .line 3633
    iget v3, p0, Lmain/Map;->map_y:I

    iget-object v4, p0, Lmain/Map;->item:[[B

    aget-object v4, v4, v7

    const/4 v5, 0x1

    aget-byte v4, v4, v5

    mul-int/lit8 v4, v4, 0x14

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0x14

    const/16 v4, 0x21

    const/4 v5, 0x0

    .line 3632
    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    goto :goto_44

    :cond_a0
    const/16 v1, 0x36

    goto :goto_7d

    .line 3636
    :cond_a3
    aget-object v0, p1, v7

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x4

    aget-byte v0, v0, v1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_b7

    aget-object v0, p1, v7

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x4

    aget-byte v0, v0, v1

    const/4 v1, 0x2

    if-ne v0, v1, :cond_fa

    :cond_b7
    aget-object v0, p1, v7

    iget-short v0, v0, Ldm/Npc;->x:S

    aget-object v1, p1, v7

    iget-short v1, v1, Ldm/Npc;->y:S

    invoke-direct {p0, v0, v1}, Lmain/Map;->isNpcSrc(II)Z

    move-result v0

    if-eqz v0, :cond_fa

    .line 3637
    aget-object v0, p1, v7

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/16 v1, 0x8

    aget-byte v0, v0, v1

    const/4 v1, 0x3

    if-eq v0, v1, :cond_f7

    iget-object v0, p0, Lmain/Map;->npcNameData:[Ljava/lang/String;

    aget-object v0, v0, v7

    const-string v1, "\u8def\u4eba"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_f7

    .line 3641
    sget-object v0, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    iget-object v1, p0, Lmain/Map;->imgShadow:Ljavax/microedition/lcdui/Image;

    iget v2, p0, Lmain/Map;->map_x:I

    aget-object v3, p1, v7

    iget-short v3, v3, Ldm/Npc;->x:S

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0xa

    .line 3642
    iget v3, p0, Lmain/Map;->map_y:I

    aget-object v4, p1, v7

    iget-short v4, v4, Ldm/Npc;->y:S

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0x14

    const/16 v4, 0x21

    .line 3641
    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 3644
    :cond_f7
    invoke-direct {p0, p1, v7}, Lmain/Map;->drawNpcAniOne([Ldm/Npc;I)V

    .line 3646
    :cond_fa
    invoke-direct {p0, p1, v7}, Lmain/Map;->runNpcAniOne([Ldm/Npc;I)V

    goto/16 :goto_44
.end method

.method private drawNpcAni([Ldm/Npc;)V
    .registers 6
    .param p1, "npc"    # [Ldm/Npc;

    .prologue
    const/4 v3, 0x4

    .line 3608
    if-nez p1, :cond_4

    .line 3617
    :cond_3
    return-void

    .line 3610
    :cond_4
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_5
    array-length v1, p1

    if-ge v0, v1, :cond_3

    .line 3612
    aget-object v1, p1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v3

    const/4 v2, 0x1

    if-eq v1, v2, :cond_1a

    aget-object v1, p1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v3

    const/4 v2, 0x2

    if-ne v1, v2, :cond_2b

    :cond_1a
    aget-object v1, p1, v0

    iget-short v1, v1, Ldm/Npc;->x:S

    aget-object v2, p1, v0

    iget-short v2, v2, Ldm/Npc;->y:S

    invoke-direct {p0, v1, v2}, Lmain/Map;->isNpcSrc(II)Z

    move-result v1

    if-eqz v1, :cond_2b

    .line 3613
    invoke-direct {p0, p1, v0}, Lmain/Map;->drawNpcAniOne([Ldm/Npc;I)V

    .line 3615
    :cond_2b
    invoke-direct {p0, p1, v0}, Lmain/Map;->runNpcAniOne([Ldm/Npc;I)V

    .line 3610
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_5
.end method

.method private drawNpcAniOne([Ldm/Npc;I)V
    .registers 16
    .param p1, "npc"    # [Ldm/Npc;
    .param p2, "i"    # I

    .prologue
    const/16 v2, 0x8

    const/4 v12, 0x1

    const/4 v11, 0x4

    const/4 v10, 0x0

    .line 3653
    aget-object v0, p1, p2

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x3

    aget-byte v0, v0, v1

    sub-int/2addr v0, v12

    int-to-byte v9, v0

    .line 3654
    .local v9, "type":B
    aget-object v0, p1, p2

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x2

    aget-byte v7, v0, v1

    .line 3655
    .local v7, "id":B
    aget-object v0, p1, p2

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x7

    aget-byte v6, v0, v1

    .line 3656
    .local v6, "action_id":B
    aget-object v0, p1, p2

    iget-byte v8, v0, Ldm/Npc;->now_action:B

    .line 3658
    .local v8, "now_action":B
    if-gez v6, :cond_28

    .line 3659
    aget-object v0, p1, p2

    iput-byte v11, v0, Ldm/Npc;->dir:B

    .line 3660
    neg-int v0, v6

    int-to-byte v6, v0

    .line 3662
    :cond_28
    aget-object v0, p1, p2

    iget-byte v0, v0, Ldm/Npc;->now_action:B

    sget-object v1, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v1, v1, v9

    aget-object v1, v1, v7

    invoke-virtual {v1, v6}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_63

    .line 3663
    aget-object v0, p1, p2

    const/4 v8, 0x0

    iput-byte v8, v0, Ldm/Npc;->now_action:B

    .line 3664
    aget-object v0, p1, p2

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v2

    const/4 v1, -0x4

    if-ne v0, v1, :cond_53

    .line 3665
    aget-object v0, p1, p2

    iget-object v0, v0, Ldm/Npc;->other:[B

    aput-byte v10, v0, v2

    .line 3666
    aget-object v0, p1, p2

    iget-object v0, v0, Ldm/Npc;->other:[B

    aput-byte v10, v0, v11

    .line 3678
    :goto_52
    return-void

    .line 3669
    :cond_53
    aget-object v0, p1, p2

    iget-boolean v0, v0, Ldm/Npc;->bdir:Z

    if-nez v0, :cond_63

    invoke-direct {p0, p1, p2}, Lmain/Map;->setlastA([Ldm/Npc;I)Z

    move-result v0

    if-eqz v0, :cond_63

    .line 3670
    invoke-direct {p0, p1, p2}, Lmain/Map;->drawNpcAniOne([Ldm/Npc;I)V

    goto :goto_52

    .line 3674
    :cond_63
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    sget-object v1, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v1, v1, v9

    aget-object v1, v1, v7

    sget-object v2, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v2, v2, v9

    aget-object v2, v2, v7

    invoke-virtual {v2, v6, v8, v10}, Ldm/Sprite;->action(III)I

    move-result v2

    .line 3675
    iget v3, p0, Lmain/Map;->map_x:I

    aget-object v4, p1, p2

    iget-short v4, v4, Ldm/Npc;->x:S

    add-int/2addr v3, v4

    add-int/lit8 v3, v3, 0xa

    iget v4, p0, Lmain/Map;->map_y:I

    aget-object v5, p1, p2

    iget-short v5, v5, Ldm/Npc;->y:S

    add-int/2addr v4, v5

    add-int/lit8 v4, v4, 0x13

    aget-object v5, p1, p2

    iget-byte v5, v5, Ldm/Npc;->dir:B

    if-ne v5, v11, :cond_94

    move v5, v12

    .line 3674
    :goto_90
    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    goto :goto_52

    :cond_94
    move v5, v10

    .line 3675
    goto :goto_90
.end method

.method private drawNpcFace(III)V
    .registers 8
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "dir"    # I

    .prologue
    const/4 v3, 0x0

    .line 3411
    iget-object v0, p0, Lmain/Map;->imgFace:Ljavax/microedition/lcdui/Image;

    if-eqz v0, :cond_11

    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->imgFace:Ljavax/microedition/lcdui/Image;

    iget-short v2, p0, Lmain/Map;->face_c:S

    add-int/2addr v2, p1

    invoke-virtual {v0, v1, v2, p2, p3}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 3412
    :cond_11
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-short v1, p0, Lmain/Map;->face_c:S

    const/16 v2, 0x14

    invoke-virtual {v0, v1, v3, v2, v3}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v0

    iput-short v0, p0, Lmain/Map;->face_c:S

    .line 3413
    return-void
.end method

.method private drawSrcEffect()V
    .registers 12

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v2, 0x0

    .line 3913
    const/16 v7, 0x19

    .local v7, "FONT_W":I
    const/16 v6, 0x19

    .line 3915
    .local v6, "FONT_H":I
    sget v4, Lmain/Constants_H;->WIDTH__:I

    .local v4, "WIDTH":I
    sget v5, Lmain/Constants_H;->HEIGHT__:I

    .line 3916
    .local v5, "HEIGHT":I
    iget-byte v0, p0, Lmain/Map;->srcFlash_c:B

    if-lez v0, :cond_25

    iget-byte v0, p0, Lmain/Map;->srcFlash_c:B

    sub-int v1, v0, v9

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/Map;->srcFlash_c:B

    rem-int/lit8 v0, v0, 0x2

    if-nez v0, :cond_25

    .line 3917
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const v1, 0xffffff

    move v3, v2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 3919
    :cond_25
    iget-boolean v0, p0, Lmain/Map;->bSrc:Z

    if-eqz v0, :cond_47

    .line 3920
    sget v8, Lmain/Constants_H;->SRC_BATTLE_H__:I

    .line 3921
    .local v8, "SRC_BATTLE_H":I
    sget-object v0, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, v2}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 3922
    sget-object v0, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    iget-short v1, p0, Lmain/Map;->black_width:S

    sub-int/2addr v1, v8

    iget-short v3, p0, Lmain/Map;->bSrc_c:S

    sub-int/2addr v1, v3

    invoke-virtual {v0, v2, v1, v4, v8}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 3923
    sget-object v0, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    iget-short v1, p0, Lmain/Map;->black_width:S

    sub-int v1, v5, v1

    iget-short v3, p0, Lmain/Map;->bSrc_c:S

    add-int/2addr v1, v3

    invoke-virtual {v0, v2, v1, v4, v8}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 3926
    .end local v8    # "SRC_BATTLE_H":I
    :cond_47
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x16

    if-ne v0, v1, :cond_6a

    .line 3927
    sget-object v0, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-ne v1, v10, :cond_6b

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    array-length v1, v1

    add-int/lit8 v3, v6, 0x4

    mul-int/lit8 v1, v1, 0x1d

    sub-int v1, v5, v1

    shr-int/lit8 v1, v1, 0x1

    :goto_62
    iget-byte v3, p0, Lmain/Map;->eventGoing:B

    if-ne v3, v10, :cond_67

    move v2, v9

    :cond_67
    invoke-virtual {p0, v0, v1, v2}, Lmain/Map;->drawBlackSRC(Ljavax/microedition/lcdui/Graphics;IZ)V

    .line 3928
    :cond_6a
    return-void

    .line 3927
    :cond_6b
    const/16 v1, 0x2d

    goto :goto_62
.end method

.method private drawStep(Ljavax/microedition/lcdui/Graphics;III)V
    .registers 14
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;
    .param p2, "x"    # I
    .param p3, "y"    # I
    .param p4, "h"    # I

    .prologue
    const/4 v4, 0x4

    const/4 v5, 0x3

    const/4 v8, 0x0

    const/4 v7, 0x1

    const/4 v6, 0x2

    .line 1831
    iget-byte v0, p0, Lmain/Map;->bStep:B

    if-lez v0, :cond_a1

    .line 1832
    const v0, 0x3c3b3b

    invoke-virtual {p1, v0}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 1833
    add-int/lit8 v0, p2, 0x1

    sub-int v1, p4, v6

    invoke-virtual {p1, v0, p3, v1, p4}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 1834
    add-int/lit8 v0, p3, 0x1

    sub-int v1, p4, v6

    invoke-virtual {p1, p2, v0, p4, v1}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 1835
    const v0, 0xcccccc

    invoke-virtual {p1, v0}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 1836
    add-int/lit8 v0, p2, 0x2

    add-int/lit8 v1, p3, 0x1

    sub-int v2, p4, v4

    sub-int v3, p4, v6

    invoke-virtual {p1, v0, v1, v2, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 1837
    add-int/lit8 v0, p2, 0x1

    add-int/lit8 v1, p3, 0x2

    sub-int v2, p4, v6

    sub-int v3, p4, v4

    invoke-virtual {p1, v0, v1, v2, v3}, Ljavax/microedition/lcdui/Graphics;->drawRect(IIII)V

    .line 1838
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const v1, 0xffffff

    add-int/lit8 v2, p2, 0x2

    add-int/lit8 v3, p3, 0x2

    sub-int v4, p4, v5

    sub-int v5, p4, v5

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 1839
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/16 v1, 0x43

    shr-int/lit8 v2, p4, 0x1

    add-int/2addr v2, p2

    shr-int/lit8 v3, p4, 0x1

    add-int/2addr v3, p3

    or-int/lit8 v4, v6, 0x1

    move v5, v8

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawUi(IIIII)V

    .line 1840
    iget-byte v0, p0, Lmain/Map;->bStep:B

    rem-int/lit8 v0, v0, 0xc

    const/4 v1, 0x6

    if-ge v0, v1, :cond_95

    .line 1841
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/high16 v1, 0xee0000

    add-int v2, p2, p4

    sub-int/2addr v2, v7

    add-int v3, p3, p4

    sub-int v5, v3, v7

    move v3, p3

    move v4, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 1842
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    add-int v2, p2, p4

    add-int v5, p3, p4

    move v1, v8

    move v3, p3

    move v4, p2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 1843
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const/high16 v1, 0xee0000

    add-int v2, p2, p4

    add-int/lit8 v3, p3, 0x1

    add-int/lit8 v4, p2, 0x1

    add-int v5, p3, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawLine(IIIII)V

    .line 1845
    :cond_95
    iget-byte v0, p0, Lmain/Map;->bStep:B

    sub-int/2addr v0, v7

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/Map;->bStep:B

    if-ge v0, v6, :cond_a1

    const/16 v0, 0x64

    iput-byte v0, p0, Lmain/Map;->bStep:B

    .line 1847
    :cond_a1
    return-void
.end method

.method private exitBoss(IIII)V
    .registers 7
    .param p1, "map_No"    # I
    .param p2, "zuobiao_x"    # I
    .param p3, "zuobiao_y"    # I
    .param p4, "mydir"    # I

    .prologue
    const/4 v1, 0x0

    .line 618
    invoke-virtual {p0, p1, v1}, Lmain/Map;->chuansong(II)V

    .line 619
    const/4 v0, 0x1

    iput-boolean v0, p0, Lmain/Map;->bExitBoss:Z

    .line 620
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v0, p2, p3, v1, v1}, Ldm/Npc;->setXY(IIII)V

    .line 621
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    int-to-byte v1, p4

    iput-byte v1, v0, Ldm/Npc;->dir:B

    .line 622
    return-void
.end method

.method private getInMap(B[[B)V
    .registers 9
    .param p1, "exit_no"    # B
    .param p2, "door"    # [[B

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 642
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    aget-object v1, p2, p1

    aget-byte v1, v1, v5

    sub-int/2addr v1, v4

    div-int/lit8 v1, v1, 0x2

    mul-int/lit8 v1, v1, 0x2

    add-int/lit8 v1, v1, 0x1

    aget-object v2, p2, p1

    aget-byte v2, v2, v5

    rem-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    int-to-byte v1, v1

    iput-byte v1, v0, Ldm/Npc;->dir:B

    .line 643
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    aget-object v1, p2, p1

    aget-byte v1, v1, v3

    aget-object v2, p2, p1

    aget-byte v2, v2, v4

    invoke-virtual {v0, v1, v2, v3, v3}, Ldm/Npc;->setXY(IIII)V

    .line 644
    return-void
.end method

.method private getItem()V
    .registers 9

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x4

    const/4 v5, 0x2

    .line 2304
    iget-object v1, p0, Lmain/Map;->item:[[B

    iget-byte v2, p0, Lmain/Map;->get_meet:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v5

    if-ne v1, v5, :cond_15

    .line 2305
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v2, "\u8fd9\u4e2a\u5b9d\u7bb1\u662f\u7a7a\u7684\u3002"

    invoke-virtual {v1, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2317
    :goto_14
    return-void

    .line 2308
    :cond_15
    iget-object v1, p0, Lmain/Map;->item:[[B

    iget-byte v2, p0, Lmain/Map;->get_meet:B

    aget-object v1, v1, v2

    const/4 v2, 0x3

    aget-byte v1, v1, v2

    sub-int/2addr v1, v5

    int-to-byte v0, v1

    .line 2309
    .local v0, "id":B
    const/4 v1, -0x2

    if-ne v0, v1, :cond_61

    .line 2310
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v2, v1, Lmain/GameRun;->money:I

    iget-object v3, p0, Lmain/Map;->item:[[B

    iget-byte v4, p0, Lmain/Map;->get_meet:B

    aget-object v3, v3, v4

    aget-byte v3, v3, v6

    mul-int/lit8 v3, v3, 0x64

    add-int/2addr v2, v3

    iput v2, v1, Lmain/GameRun;->money:I

    .line 2311
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u83b7\u5f97\u91d1\u94b1\uff1a"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lmain/Map;->item:[[B

    iget-byte v4, p0, Lmain/Map;->get_meet:B

    aget-object v3, v3, v4

    aget-byte v3, v3, v6

    mul-int/lit8 v3, v3, 0x64

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\u91d1"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2316
    :goto_58
    iget-object v1, p0, Lmain/Map;->item:[[B

    iget-byte v2, p0, Lmain/Map;->get_meet:B

    aget-object v1, v1, v2

    aput-byte v5, v1, v5

    goto :goto_14

    .line 2312
    :cond_61
    const/4 v1, -0x1

    if-ne v0, v1, :cond_96

    .line 2313
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v2, v1, Lmain/GameRun;->coin:I

    iget-object v3, p0, Lmain/Map;->item:[[B

    iget-byte v4, p0, Lmain/Map;->get_meet:B

    aget-object v3, v3, v4

    aget-byte v3, v3, v6

    add-int/2addr v2, v3

    iput v2, v1, Lmain/GameRun;->coin:I

    .line 2314
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u83b7\u5f97\u5fbd\u7ae0\uff1a"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lmain/Map;->item:[[B

    iget-byte v4, p0, Lmain/Map;->get_meet:B

    aget-object v3, v3, v4

    aget-byte v3, v3, v6

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\u5fbd\u7ae0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_58

    .line 2315
    :cond_96
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, p0, Lmain/Map;->item:[[B

    iget-byte v3, p0, Lmain/Map;->get_meet:B

    aget-object v2, v2, v3

    aget-byte v2, v2, v6

    invoke-virtual {v1, v0, v2}, Lmain/GameRun;->getItem(II)B

    goto :goto_58
.end method

.method private getItemData(Ljava/io/ByteArrayOutputStream;[[B)V
    .registers 6
    .param p1, "byteArray"    # Ljava/io/ByteArrayOutputStream;
    .param p2, "data"    # [[B

    .prologue
    .line 2671
    :try_start_0
    array-length v2, p2

    invoke-virtual {p1, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 2673
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_5
    array-length v2, p2

    if-lt v1, v2, :cond_9

    .line 2680
    .end local v1    # "i":I
    :goto_8
    return-void

    .line 2674
    .restart local v1    # "i":I
    :cond_9
    aget-object v2, p2, v1

    array-length v2, v2

    invoke-virtual {p1, v2}, Ljava/io/ByteArrayOutputStream;->write(I)V

    .line 2675
    aget-object v2, p2, v1

    invoke-virtual {p1, v2}, Ljava/io/ByteArrayOutputStream;->write([B)V
    :try_end_14
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_14} :catch_17

    .line 2673
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 2677
    .end local v1    # "i":I
    :catch_17
    move-exception v2

    move-object v0, v2

    .line 2678
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_8
.end method

.method private getNpcData(Ljava/io/ByteArrayOutputStream;[Ldm/Npc;)V
    .registers 7
    .param p1, "byteArray"    # Ljava/io/ByteArrayOutputStream;
    .param p2, "npc"    # [Ldm/Npc;

    .prologue
    .line 2660
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    :try_start_1
    array-length v2, p2

    if-lt v1, v2, :cond_5

    .line 2668
    :goto_4
    return-void

    .line 2661
    :cond_5
    aget-object v2, p2, v1

    iget-object v2, v2, Ldm/Npc;->other:[B

    const/16 v3, 0x9

    aget-byte v2, v2, v3

    const/4 v3, 0x1

    if-ne v2, v3, :cond_17

    .line 2662
    aget-object v2, p2, v1

    iget-object v2, v2, Ldm/Npc;->other:[B

    invoke-virtual {p1, v2}, Ljava/io/ByteArrayOutputStream;->write([B)V
    :try_end_17
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_17} :catch_1a

    .line 2660
    :cond_17
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 2665
    :catch_1a
    move-exception v2

    move-object v0, v2

    .line 2666
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_4
.end method

.method private getNpcData()[B
    .registers 4

    .prologue
    .line 2648
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 2649
    .local v0, "byteArray":Ljava/io/ByteArrayOutputStream;
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-direct {p0, v0, v1}, Lmain/Map;->getNpcData(Ljava/io/ByteArrayOutputStream;[Ldm/Npc;)V

    .line 2650
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    const/4 v2, 0x1

    aget-object v1, v1, v2

    invoke-direct {p0, v0, v1}, Lmain/Map;->getNpcData(Ljava/io/ByteArrayOutputStream;[Ldm/Npc;)V

    .line 2651
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    const/4 v2, 0x2

    aget-object v1, v1, v2

    invoke-direct {p0, v0, v1}, Lmain/Map;->getNpcData(Ljava/io/ByteArrayOutputStream;[Ldm/Npc;)V

    .line 2653
    iget-object v1, p0, Lmain/Map;->item:[[B

    invoke-direct {p0, v0, v1}, Lmain/Map;->getItemData(Ljava/io/ByteArrayOutputStream;[[B)V

    .line 2654
    iget-object v1, p0, Lmain/Map;->door:[[B

    invoke-direct {p0, v0, v1}, Lmain/Map;->getItemData(Ljava/io/ByteArrayOutputStream;[[B)V

    .line 2655
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    return-object v1
.end method

.method private getNpcId(I)B
    .registers 3
    .param p1, "i"    # I

    .prologue
    .line 393
    iget-object v0, p0, Lmain/Map;->npcPos:[B

    aget-byte v0, v0, p1

    and-int/lit8 v0, v0, 0x3f

    int-to-byte v0, v0

    return v0
.end method

.method private getNpcLayer(I)B
    .registers 3
    .param p1, "i"    # I

    .prologue
    .line 392
    iget-object v0, p0, Lmain/Map;->npcPos:[B

    aget-byte v0, v0, p1

    and-int/lit16 v0, v0, 0xff

    shr-int/lit8 v0, v0, 0x6

    int-to-byte v0, v0

    return v0
.end method

.method private getNpcListY(I)S
    .registers 7
    .param p1, "j"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v2, -0x1

    .line 3749
    iget-object v1, p0, Lmain/Map;->npcList:[B

    aget-byte v1, v1, p1

    if-ne v1, v2, :cond_1e

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    iget-object v2, p0, Lmain/Map;->dir_select:[[B

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->dir:B

    aget-object v2, v2, v3

    aget-byte v2, v2, v4

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->speed:B

    mul-int/2addr v2, v3

    add-int/2addr v1, v2

    int-to-short v0, v1

    .line 3752
    .local v0, "y":S
    :goto_1d
    return v0

    .line 3750
    .end local v0    # "y":S
    :cond_1e
    iget-object v1, p0, Lmain/Map;->npcList:[B

    aget-byte v1, v1, p1

    if-ge v1, v2, :cond_3b

    iget-object v1, p0, Lmain/Map;->item:[[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v2, p0, Lmain/Map;->npcList:[B

    aget-byte v2, v2, p1

    invoke-static {v2}, Ldm/Ms;->abs(I)I

    move-result v2

    const/4 v3, 0x2

    sub-int/2addr v2, v3

    aget-object v1, v1, v2

    aget-byte v1, v1, v4

    mul-int/lit8 v1, v1, 0x14

    int-to-short v0, v1

    .restart local v0    # "y":S
    goto :goto_1d

    .line 3751
    .end local v0    # "y":S
    :cond_3b
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/Map;->npcList:[B

    aget-byte v2, v2, p1

    aget-object v1, v1, v2

    iget-short v0, v1, Ldm/Npc;->y:S

    .restart local v0    # "y":S
    goto :goto_1d
.end method

.method private ifEvent(IIIIZ)V
    .registers 8
    .param p1, "i"    # I
    .param p2, "next_id"    # I
    .param p3, "next_mode"    # I
    .param p4, "mode"    # I
    .param p5, "bt"    # Z

    .prologue
    const/4 v1, 0x0

    .line 681
    const/4 v0, 0x1

    invoke-direct {p0, p4, p5, v0}, Lmain/Map;->setSIfElse(IZZ)Z

    move-result v0

    if-eqz v0, :cond_14

    .line 682
    iget-object v0, p0, Lmain/Map;->event_now:[S

    aget-short v1, v0, p1

    add-int/2addr v1, p2

    int-to-short v1, v1

    aput-short v1, v0, p1

    .line 683
    invoke-direct {p0, p3}, Lmain/Map;->nextEvent(I)V

    .line 685
    :cond_13
    :goto_13
    return-void

    .line 684
    :cond_14
    invoke-direct {p0, p4, p5, v1}, Lmain/Map;->setSIfElse(IZZ)Z

    move-result v0

    if-eqz v0, :cond_13

    invoke-direct {p0, p1, v1}, Lmain/Map;->setEventNow(IZ)V

    goto :goto_13
.end method

.method private init()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 255
    invoke-virtual {p0}, Lmain/Map;->initBrowImage()V

    .line 256
    invoke-virtual {p0}, Lmain/Map;->initWalkIco()V

    .line 257
    invoke-direct {p0}, Lmain/Map;->initHudong()V

    .line 258
    invoke-direct {p0}, Lmain/Map;->configureNpc()V

    .line 259
    sget-object v0, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v0, v0, v2

    aget-object v0, v0, v3

    if-nez v0, :cond_34

    .line 260
    sget-object v0, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v0, v0, v2

    new-instance v1, Ldm/Sprite;

    invoke-direct {v1}, Ldm/Sprite;-><init>()V

    aput-object v1, v0, v3

    .line 262
    new-instance v0, Ldm/Npc;

    const/16 v1, 0x8

    invoke-direct {v0, v1}, Ldm/Npc;-><init>(I)V

    iput-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    .line 263
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x4

    aput-byte v2, v0, v1

    .line 264
    invoke-virtual {p0}, Lmain/Map;->setAnole()V

    .line 269
    :cond_34
    iget-object v0, p0, Lmain/Map;->imgShadow:Ljavax/microedition/lcdui/Image;

    if-nez v0, :cond_44

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "data/shadow"

    invoke-virtual {v0, v1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Lmain/Map;->imgShadow:Ljavax/microedition/lcdui/Image;

    .line 273
    :cond_44
    return-void
.end method

.method private initAuto(Ldm/Npc;I)Z
    .registers 9
    .param p1, "npc"    # Ldm/Npc;
    .param p2, "sleep"    # I

    .prologue
    const/16 v5, 0x64

    const/16 v4, 0x32

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 3799
    iget-byte v0, p1, Ldm/Npc;->timeMove:B

    if-nez v0, :cond_3a

    .line 3800
    iget-byte v0, p1, Ldm/Npc;->frame_c:B

    const/4 v1, -0x1

    if-ne v0, v1, :cond_38

    .line 3801
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v5}, Ldm/Ms;->getRandom(I)I

    move-result v0

    if-ge v0, v4, :cond_36

    move v0, v3

    :goto_19
    iput-boolean v0, p1, Ldm/Npc;->b_auto:Z

    .line 3802
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v5}, Ldm/Ms;->getRandom(I)I

    move-result v0

    if-ge v0, v4, :cond_47

    .line 3803
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {p2}, Ldm/Ms;->getRandom(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x14

    neg-int v0, v0

    int-to-byte v0, v0

    iput-byte v0, p1, Ldm/Npc;->timeMove:B

    .line 3804
    invoke-virtual {p1, v2}, Ldm/Npc;->setActionNo(Z)V

    move v0, v2

    .line 3812
    :goto_35
    return v0

    :cond_36
    move v0, v2

    .line 3801
    goto :goto_19

    :cond_38
    move v0, v2

    .line 3807
    goto :goto_35

    .line 3808
    :cond_3a
    iget-byte v0, p1, Ldm/Npc;->timeMove:B

    if-gez v0, :cond_47

    .line 3809
    iget-byte v0, p1, Ldm/Npc;->timeMove:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p1, Ldm/Npc;->timeMove:B

    move v0, v2

    .line 3810
    goto :goto_35

    :cond_47
    move v0, v3

    .line 3812
    goto :goto_35
.end method

.method private initBoat(I)V
    .registers 6
    .param p1, "_select"    # I

    .prologue
    .line 4048
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0x9

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 4049
    const/4 v0, 0x5

    iput-byte v0, p0, Lmain/Map;->anole_type:B

    .line 4050
    invoke-virtual {p0}, Lmain/Map;->setAnole()V

    .line 4051
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/Map;->boatSelect:B

    .line 4052
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v1, 0x0

    iput-byte v1, v0, Lmain/GameRun;->cur_a:B

    .line 4053
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v1, p0, Lmain/Map;->boatCourse:[[B

    iget-byte v2, p0, Lmain/Map;->boatSelect:B

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    aget-byte v1, v1, v2

    iget-object v2, p0, Lmain/Map;->boatCourse:[[B

    iget-byte v3, p0, Lmain/Map;->boatSelect:B

    aget-object v2, v2, v3

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    add-int/lit8 v3, v3, 0x1

    aget-byte v2, v2, v3

    invoke-virtual {v0, v1, v2}, Ldm/Npc;->setIXY(II)V

    .line 4054
    return-void
.end method

.method private initCloud()V
    .registers 5

    .prologue
    const/4 v3, 0x0

    .line 3997
    iget-byte v1, p0, Lmain/Map;->mapNo:B

    const/16 v2, 0x18

    if-eq v1, v2, :cond_1f

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    const/16 v2, 0x19

    if-eq v1, v2, :cond_1f

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    const/16 v2, 0x1a

    if-eq v1, v2, :cond_1f

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    const/16 v2, 0x31

    if-eq v1, v2, :cond_1f

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    const/16 v2, 0x32

    if-ne v1, v2, :cond_4f

    .line 3998
    :cond_1f
    iget-object v1, p0, Lmain/Map;->imgCloud:Ljavax/microedition/lcdui/Image;

    if-nez v1, :cond_41

    .line 3999
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const-string v2, "data/cloud"

    invoke-virtual {v1, v2}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    iput-object v1, p0, Lmain/Map;->imgCloud:Ljavax/microedition/lcdui/Image;

    .line 4000
    iput-object v3, p0, Lmain/Map;->cloud:[[S

    .line 4001
    const/4 v1, 0x4

    const/4 v2, 0x3

    filled-new-array {v1, v2}, [I

    move-result-object v1

    sget-object v2, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {v2, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [[S

    iput-object v1, p0, Lmain/Map;->cloud:[[S

    .line 4003
    :cond_41
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_42
    iget-object v1, p0, Lmain/Map;->cloud:[[S

    array-length v1, v1

    if-lt v0, v1, :cond_48

    .line 4008
    .end local v0    # "i":B
    :goto_47
    return-void

    .line 4003
    .restart local v0    # "i":B
    :cond_48
    invoke-direct {p0, v0}, Lmain/Map;->addCloud(I)V

    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_42

    .line 4005
    .end local v0    # "i":B
    :cond_4f
    iput-object v3, p0, Lmain/Map;->cloud:[[S

    .line 4006
    iput-object v3, p0, Lmain/Map;->imgCloud:Ljavax/microedition/lcdui/Image;

    goto :goto_47
.end method

.method private initHudong()V
    .registers 3

    .prologue
    .line 3481
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "data/brow/hudong"

    invoke-virtual {v0, v1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Lmain/Map;->hudong:Ljavax/microedition/lcdui/Image;

    .line 3482
    return-void
.end method

.method private initMissionList()V
    .registers 10

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    const/4 v6, -0x1

    const/4 v3, 0x0

    .line 2868
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    const/4 v5, 0x7

    invoke-virtual {v4, v5, v3, v8}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v2

    .line 2870
    .local v2, "info":[B
    aget-byte v4, v2, v7

    if-ne v4, v6, :cond_43

    .line 2871
    iput-object v3, p0, Lmain/Map;->bMission:[B

    .line 2873
    :goto_13
    move-object v0, v3

    check-cast v0, [B

    move-object v2, v0

    .line 2874
    iget-object v4, p0, Lmain/Map;->bMission:[B

    if-nez v4, :cond_21

    .line 2875
    const/16 v4, 0x14

    new-array v4, v4, [B

    iput-object v4, p0, Lmain/Map;->bMission:[B

    .line 2879
    :cond_21
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v7, Ldm/Ms;->skip:I

    .line 2880
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    const-string v5, "data/mission0.t"

    invoke-virtual {v4, v5, v6}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v1

    .line 2881
    .local v1, "data":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    invoke-virtual {v4, v1}, Ldm/Ms;->createString2Array([B)[[Ljava/lang/StringBuffer;

    move-result-object v4

    iput-object v4, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    .line 2882
    iget-object v4, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    array-length v4, v4

    sub-int/2addr v4, v8

    iput v4, p0, Lmain/Map;->smissionLength:I

    .line 2883
    iput-object v3, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    .line 2884
    return-void

    .line 2872
    .end local v1    # "data":[B
    :cond_43
    iput-object v2, p0, Lmain/Map;->bMission:[B

    goto :goto_13
.end method

.method private initMoveMy()V
    .registers 3

    .prologue
    .line 3756
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->frame_num:B

    iput-byte v1, v0, Ldm/Npc;->frame_c:B

    .line 3757
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ldm/Npc;->setActionNo(Z)V

    .line 3759
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-nez v0, :cond_1e

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->monPro:[B

    array-length v0, v0

    if-lez v0, :cond_1e

    .line 3760
    invoke-direct {p0}, Lmain/Map;->meetGrass()V

    .line 3761
    :cond_1e
    return-void
.end method

.method private initNpcAni_1(II[B)V
    .registers 7
    .param p1, "length"    # I
    .param p2, "type"    # I
    .param p3, "em"    # [B

    .prologue
    .line 3589
    const/4 v1, 0x1

    sub-int v0, p1, v1

    .local v0, "i":I
    :goto_3
    if-gtz v0, :cond_6

    .line 3594
    return-void

    .line 3590
    :cond_6
    aget-byte v1, p3, v0

    if-eqz v1, :cond_25

    .line 3591
    sget-object v1, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v1, v1, p2

    aget-object v1, v1, v0

    if-nez v1, :cond_22

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, v0, p2}, Lmain/Map;->initNpcAniOne(Ljava/lang/String;II)V

    .line 3589
    :cond_22
    :goto_22
    add-int/lit8 v0, v0, -0x1

    goto :goto_3

    .line 3592
    :cond_25
    sget-object v1, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v1, v1, p2

    const/4 v2, 0x0

    aput-object v2, v1, v0

    goto :goto_22
.end method

.method private isAnole(III)Z
    .registers 9
    .param p1, "_x"    # I
    .param p2, "_y"    # I
    .param p3, "_anole_type"    # I

    .prologue
    const/4 v2, 0x4

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 2380
    if-nez p3, :cond_2a

    const/4 p3, 0x3

    .line 2387
    :goto_6
    const/4 v0, 0x0

    .line 2388
    .local v0, "check_n":B
    rem-int/lit8 v1, p1, 0x14

    if-eqz v1, :cond_e

    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    .line 2389
    :cond_e
    rem-int/lit8 v1, p2, 0x14

    if-eqz v1, :cond_15

    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    .line 2390
    :cond_15
    shl-int v1, v3, v0

    int-to-byte v0, v1

    .line 2391
    if-ne v0, v2, :cond_35

    iget-object v1, p0, Lmain/Map;->worldData:[[S

    add-int/lit8 v2, p1, 0x13

    div-int/lit8 v2, v2, 0x14

    aget-object v1, v1, v2

    div-int/lit8 v2, p2, 0x14

    aget-short v1, v1, v2

    if-ne v1, p3, :cond_35

    move v1, v3

    .line 2396
    .end local v0    # "check_n":B
    :goto_29
    return v1

    .line 2381
    :cond_2a
    const/4 v1, 0x2

    if-ne p3, v1, :cond_2f

    const/4 p3, 0x4

    goto :goto_6

    .line 2382
    :cond_2f
    if-ne p3, v2, :cond_33

    const/4 p3, 0x2

    goto :goto_6

    :cond_33
    move v1, v4

    .line 2386
    goto :goto_29

    .line 2392
    .restart local v0    # "check_n":B
    :cond_35
    if-le v0, v3, :cond_5f

    .line 2393
    rem-int/lit8 v1, p1, 0x14

    if-eqz v1, :cond_4d

    iget-object v1, p0, Lmain/Map;->worldData:[[S

    add-int/lit8 v2, p1, 0x13

    div-int/lit8 v2, v2, 0x14

    aget-object v1, v1, v2

    add-int/lit8 v2, p2, 0x13

    div-int/lit8 v2, v2, 0x14

    aget-short v1, v1, v2

    if-ne v1, p3, :cond_4d

    move v1, v3

    goto :goto_29

    .line 2394
    :cond_4d
    rem-int/lit8 v1, p2, 0x14

    if-eqz v1, :cond_5f

    iget-object v1, p0, Lmain/Map;->worldData:[[S

    div-int/lit8 v2, p1, 0x14

    aget-object v1, v1, v2

    div-int/lit8 v2, p2, 0x14

    aget-short v1, v1, v2

    if-ne v1, p3, :cond_5f

    move v1, v3

    goto :goto_29

    .line 2396
    :cond_5f
    iget-object v1, p0, Lmain/Map;->worldData:[[S

    div-int/lit8 v2, p1, 0x14

    aget-object v1, v1, v2

    div-int/lit8 v2, p2, 0x14

    aget-short v1, v1, v2

    if-ne v1, p3, :cond_6d

    move v1, v3

    goto :goto_29

    :cond_6d
    move v1, v4

    goto :goto_29
.end method

.method private isAnoleType(I)Z
    .registers 5
    .param p1, "i"    # I

    .prologue
    const/4 v2, 0x1

    .line 2120
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    const/4 v1, 0x2

    aget-byte v0, v0, v1

    shl-int v1, v2, p1

    and-int/2addr v0, v1

    if-eqz v0, :cond_f

    move v0, v2

    :goto_e
    return v0

    :cond_f
    const/4 v0, 0x0

    goto :goto_e
.end method

.method private isAuto_canMove(Ldm/Npc;II)Z
    .registers 13
    .param p1, "_npc"    # Ldm/Npc;
    .param p2, "sx"    # I
    .param p3, "sy"    # I

    .prologue
    .line 3816
    iget-short v1, p1, Ldm/Npc;->x:S

    iget-short v2, p1, Ldm/Npc;->y:S

    const/4 v5, 0x0

    move-object v0, p0

    move v3, p2

    move v4, p3

    invoke-direct/range {v0 .. v5}, Lmain/Map;->checkWorld(IIIIZ)B

    move-result v0

    const/4 v1, 0x1

    if-eq v0, v1, :cond_2f

    .line 3817
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-short v1, p1, Ldm/Npc;->x:S

    add-int/2addr v1, p2

    iget-short v2, p1, Ldm/Npc;->y:S

    add-int/2addr v2, p3

    const/16 v3, 0x13

    const/16 v4, 0x13

    .line 3818
    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v5, v5, Ldm/Npc;->x:S

    iget-object v6, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v6, v6, Ldm/Npc;->y:S

    const/16 v7, 0x13

    const/16 v8, 0x13

    .line 3817
    invoke-virtual/range {v0 .. v8}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v0

    if-eqz v0, :cond_31

    .line 3818
    :cond_2f
    const/4 v0, 0x0

    .line 3819
    :goto_30
    return v0

    :cond_31
    const/4 v0, 0x1

    goto :goto_30
.end method

.method private isCan_not_pass(II)Z
    .registers 9
    .param p1, "ix"    # I
    .param p2, "iy"    # I

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x4

    const/4 v3, 0x0

    const/4 v2, 0x2

    const/4 v1, 0x1

    .line 2399
    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-ne v0, v1, :cond_f

    move v0, v1

    .line 2411
    :goto_e
    return v0

    .line 2401
    :cond_f
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-nez v0, :cond_27

    .line 2402
    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-eq v0, v2, :cond_25

    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-eq v0, v4, :cond_25

    move v0, v3

    goto :goto_e

    :cond_25
    move v0, v1

    goto :goto_e

    .line 2403
    :cond_27
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-ne v0, v2, :cond_3f

    .line 2404
    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-eq v0, v5, :cond_3d

    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-eq v0, v2, :cond_3d

    move v0, v3

    goto :goto_e

    :cond_3d
    move v0, v1

    goto :goto_e

    .line 2405
    :cond_3f
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-ne v0, v4, :cond_4f

    .line 2409
    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-eq v0, v2, :cond_4d

    move v0, v1

    goto :goto_e

    :cond_4d
    move v0, v3

    goto :goto_e

    .line 2411
    :cond_4f
    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-eq v0, v2, :cond_69

    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-eq v0, v5, :cond_69

    iget-object v0, p0, Lmain/Map;->worldData:[[S

    aget-object v0, v0, p1

    aget-short v0, v0, p2

    if-eq v0, v4, :cond_69

    move v0, v3

    goto :goto_e

    :cond_69
    move v0, v1

    goto :goto_e
.end method

.method private isCheckAnole(I)Z
    .registers 5
    .param p1, "id"    # I

    .prologue
    .line 2547
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-eq v0, p1, :cond_12

    invoke-direct {p0, p1}, Lmain/Map;->isAnoleType(I)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 2548
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/Map;->anole_type:B

    .line 2549
    invoke-virtual {p0}, Lmain/Map;->setAnole()V

    .line 2551
    const/4 v0, 0x1

    .line 2556
    :goto_11
    return v0

    .line 2554
    :cond_12
    invoke-direct {p0, p1}, Lmain/Map;->isAnoleType(I)Z

    move-result v0

    if-nez v0, :cond_3f

    .line 2555
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u6ca1\u6709"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->monsterT:[Ljava/lang/StringBuffer;

    aget-object v2, v2, p1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\u5750\u9a91"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\uff0c\u4e0d\u80fd\u901a\u8fc7\u8be5\u5730\u5f62"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2556
    :cond_3f
    const/4 v0, 0x0

    goto :goto_11
.end method

.method private isCheckNpcOff()Z
    .registers 9

    .prologue
    const/16 v7, 0x14

    const/16 v6, 0xb

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 2466
    iget-byte v1, p0, Lmain/Map;->checkNpcT:B

    if-gez v1, :cond_c

    move v1, v4

    .line 2477
    :goto_b
    return v1

    .line 2468
    :cond_c
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed_x:B

    if-eqz v1, :cond_31

    .line 2469
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v4

    iget-byte v3, p0, Lmain/Map;->checkNpcT:B

    aget-object v2, v2, v3

    iget-short v2, v2, Ldm/Npc;->y:S

    sub-int/2addr v1, v2

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v1

    sub-int v1, v7, v1

    int-to-byte v0, v1

    .line 2471
    .local v0, "w":B
    if-lez v0, :cond_56

    if-ge v0, v6, :cond_56

    move v1, v5

    goto :goto_b

    .line 2472
    .end local v0    # "w":B
    :cond_31
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed_y:B

    if-eqz v1, :cond_56

    .line 2473
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->x:S

    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v4

    iget-byte v3, p0, Lmain/Map;->checkNpcT:B

    aget-object v2, v2, v3

    iget-short v2, v2, Ldm/Npc;->x:S

    sub-int/2addr v1, v2

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v1

    sub-int v1, v7, v1

    int-to-byte v0, v1

    .line 2475
    .restart local v0    # "w":B
    if-lez v0, :cond_56

    if-ge v0, v6, :cond_56

    move v1, v5

    goto :goto_b

    .end local v0    # "w":B
    :cond_56
    move v1, v4

    .line 2477
    goto :goto_b
.end method

.method private isMapChenk(B)B
    .registers 11
    .param p1, "checkType"    # B

    .prologue
    const/4 v8, -0x1

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 2569
    const/4 v0, 0x0

    .local v0, "checkLeft":B
    const/4 v1, 0x0

    .local v1, "checkRight":B
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->x:S

    div-int/lit8 v4, v4, 0x14

    int-to-byte v2, v4

    .local v2, "ix":B
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->y:S

    div-int/lit8 v4, v4, 0x14

    int-to-byte v3, v4

    .line 2570
    .local v3, "iy":B
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-nez v4, :cond_52

    .line 2571
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->x:S

    rem-int/lit8 v4, v4, 0x14

    if-eqz v4, :cond_4c

    move v4, v6

    :goto_22
    sub-int v4, v2, v4

    mul-int/lit8 v4, v4, 0x14

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    if-ltz v5, :cond_4e

    move v5, v7

    :goto_2d
    add-int/2addr v5, v3

    mul-int/lit8 v5, v5, 0x14

    invoke-direct {p0, v4, v5, v6, v6}, Lmain/Map;->checkMap(IIII)B

    move-result v0

    .line 2572
    add-int/lit8 v4, v2, 0x1

    mul-int/lit8 v4, v4, 0x14

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    if-ltz v5, :cond_50

    move v5, v7

    :goto_3f
    add-int/2addr v5, v3

    mul-int/lit8 v5, v5, 0x14

    invoke-direct {p0, v4, v5, v6, v6}, Lmain/Map;->checkMap(IIII)B

    move-result v1

    .line 2577
    :cond_46
    :goto_46
    if-ne v0, v7, :cond_8c

    if-ne v1, v7, :cond_8c

    move v4, p1

    .line 2586
    :goto_4b
    return v4

    :cond_4c
    move v4, v7

    .line 2571
    goto :goto_22

    :cond_4e
    move v5, v8

    goto :goto_2d

    :cond_50
    move v5, v8

    .line 2572
    goto :goto_3f

    .line 2573
    :cond_52
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_y:B

    if-nez v4, :cond_46

    .line 2574
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-ltz v4, :cond_86

    move v4, v7

    :goto_5f
    add-int/2addr v4, v2

    mul-int/lit8 v4, v4, 0x14

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v5, v5, Ldm/Npc;->y:S

    rem-int/lit8 v5, v5, 0x14

    if-eqz v5, :cond_88

    move v5, v6

    :goto_6b
    sub-int v5, v3, v5

    mul-int/lit8 v5, v5, 0x14

    invoke-direct {p0, v4, v5, v6, v6}, Lmain/Map;->checkMap(IIII)B

    move-result v0

    .line 2575
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-ltz v4, :cond_8a

    move v4, v7

    :goto_7a
    add-int/2addr v4, v2

    mul-int/lit8 v4, v4, 0x14

    add-int/lit8 v5, v3, 0x1

    mul-int/lit8 v5, v5, 0x14

    invoke-direct {p0, v4, v5, v6, v6}, Lmain/Map;->checkMap(IIII)B

    move-result v1

    goto :goto_46

    :cond_86
    move v4, v8

    .line 2574
    goto :goto_5f

    :cond_88
    move v5, v7

    goto :goto_6b

    :cond_8a
    move v4, v8

    .line 2575
    goto :goto_7a

    .line 2580
    :cond_8c
    if-nez v0, :cond_c4

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-nez v4, :cond_be

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->x:S

    rem-int/lit8 v4, v4, 0x14

    if-eqz v4, :cond_bc

    move v4, v6

    :goto_9d
    sub-int v4, v2, v4

    :goto_9f
    mul-int/lit8 v4, v4, 0x14

    .line 2581
    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    if-nez v5, :cond_c2

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v5, v5, Ldm/Npc;->y:S

    rem-int/lit8 v5, v5, 0x14

    if-eqz v5, :cond_c0

    move v5, v6

    :goto_b0
    sub-int v5, v3, v5

    :goto_b2
    mul-int/lit8 v5, v5, 0x14

    .line 2580
    invoke-direct {p0, v4, v5, v6, v6}, Lmain/Map;->checkMap(IIII)B

    move-result v4

    if-nez v4, :cond_c4

    move v4, v8

    .line 2582
    goto :goto_4b

    :cond_bc
    move v4, v7

    .line 2580
    goto :goto_9d

    :cond_be
    move v4, v2

    goto :goto_9f

    :cond_c0
    move v5, v7

    .line 2581
    goto :goto_b0

    :cond_c2
    move v5, v3

    goto :goto_b2

    .line 2583
    :cond_c4
    if-nez v1, :cond_fb

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed_x:B

    if-nez v4, :cond_f5

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v4, v4, Ldm/Npc;->x:S

    rem-int/lit8 v4, v4, 0x14

    if-eqz v4, :cond_f3

    move v4, v6

    :goto_d5
    add-int/2addr v4, v2

    :goto_d6
    mul-int/lit8 v4, v4, 0x14

    .line 2584
    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v5, v5, Ldm/Npc;->speed_y:B

    if-nez v5, :cond_f9

    iget-object v5, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v5, v5, Ldm/Npc;->y:S

    rem-int/lit8 v5, v5, 0x14

    if-eqz v5, :cond_f7

    move v5, v6

    :goto_e7
    add-int/2addr v5, v3

    :goto_e8
    mul-int/lit8 v5, v5, 0x14

    .line 2583
    invoke-direct {p0, v4, v5, v6, v6}, Lmain/Map;->checkMap(IIII)B

    move-result v4

    if-nez v4, :cond_fb

    .line 2585
    const/4 v4, -0x2

    goto/16 :goto_4b

    :cond_f3
    move v4, v7

    .line 2583
    goto :goto_d5

    :cond_f5
    move v4, v2

    goto :goto_d6

    :cond_f7
    move v5, v7

    .line 2584
    goto :goto_e7

    :cond_f9
    move v5, v3

    goto :goto_e8

    :cond_fb
    move v4, p1

    .line 2586
    goto/16 :goto_4b
.end method

.method private isMapEvent(II)Z
    .registers 6
    .param p1, "_mapNo"    # I
    .param p2, "_i"    # I

    .prologue
    const/4 v2, 0x1

    .line 687
    iget-object v0, p0, Lmain/Map;->mapInfo:[S

    mul-int/lit8 v1, p1, 0x2

    add-int/lit8 v1, v1, 0x1

    aget-short v0, v0, v1

    shl-int v1, v2, p2

    and-int/2addr v0, v1

    if-eqz v0, :cond_10

    move v0, v2

    :goto_f
    return v0

    :cond_10
    const/4 v0, 0x0

    goto :goto_f
.end method

.method private isMission(I)Z
    .registers 6
    .param p1, "id"    # I

    .prologue
    const/4 v3, 0x1

    .line 2942
    div-int/lit8 v1, p1, 0x8

    int-to-byte v0, v1

    .line 2943
    .local v0, "type":B
    rem-int/lit8 v1, p1, 0x8

    int-to-byte p1, v1

    .line 2944
    iget-object v1, p0, Lmain/Map;->bMission:[B

    aget-byte v1, v1, v0

    shl-int v2, v3, p1

    and-int/2addr v1, v2

    if-eqz v1, :cond_12

    move v1, v3

    .line 2945
    :goto_11
    return v1

    :cond_12
    const/4 v1, 0x0

    goto :goto_11
.end method

.method private isNpcSrc(II)Z
    .registers 6
    .param p1, "ax"    # I
    .param p2, "ay"    # I

    .prologue
    const/16 v2, -0x50

    .line 3597
    iget v0, p0, Lmain/Map;->map_x:I

    add-int/2addr v0, p1

    if-lt v0, v2, :cond_20

    .line 3598
    iget v0, p0, Lmain/Map;->map_x:I

    add-int/2addr v0, p1

    sget v1, Lmain/Constants_H;->WIDTH:I

    add-int/lit8 v1, v1, 0x3c

    if-gt v0, v1, :cond_20

    .line 3599
    iget v0, p0, Lmain/Map;->map_y:I

    add-int/2addr v0, p2

    if-lt v0, v2, :cond_20

    .line 3600
    iget v0, p0, Lmain/Map;->map_y:I

    add-int/2addr v0, p2

    sget v1, Lmain/Constants_H;->HEIGHT:I

    add-int/lit8 v1, v1, 0x3c

    if-gt v0, v1, :cond_20

    const/4 v0, 0x1

    :goto_1f
    return v0

    :cond_20
    const/4 v0, 0x0

    .line 3597
    goto :goto_1f
.end method

.method private isTrundleNpc(II)Z
    .registers 8
    .param p1, "ix"    # I
    .param p2, "iy"    # I

    .prologue
    const/4 v2, 0x4

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 2324
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v3

    invoke-direct {p0, v1, p1, p2}, Lmain/Map;->checkIfNpc([Ldm/Npc;II)B

    move-result v0

    .line 2325
    .local v0, "type":B
    const/4 v1, -0x1

    if-eq v0, v1, :cond_2b

    .line 2326
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v3

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v2

    if-eq v1, v4, :cond_27

    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v3

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v2

    const/4 v2, 0x3

    if-ne v1, v2, :cond_29

    :cond_27
    move v1, v4

    .line 2329
    :goto_28
    return v1

    :cond_29
    move v1, v3

    .line 2326
    goto :goto_28

    .line 2327
    :cond_2b
    if-ltz p1, :cond_41

    iget-short v1, p0, Lmain/Map;->cols:S

    if-ge p1, v1, :cond_41

    if-ltz p2, :cond_41

    iget-short v1, p0, Lmain/Map;->rows:S

    if-ge p2, v1, :cond_41

    iget-object v1, p0, Lmain/Map;->worldData:[[S

    aget-object v1, v1, p1

    aget-short v1, v1, p2

    if-eq v1, v4, :cond_41

    move v1, v3

    .line 2328
    goto :goto_28

    :cond_41
    move v1, v4

    .line 2329
    goto :goto_28
.end method

.method private keyAnoleSel()V
    .registers 8

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x1

    const/4 v3, -0x1

    const/4 v2, 0x0

    .line 2046
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_10

    .line 2110
    :cond_f
    :goto_f
    return-void

    .line 2048
    :cond_10
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_27

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-byte v1, p0, Lmain/Map;->anoleSel:B

    invoke-virtual {v0, v1, v2, v6}, Ldm/Ms;->select(III)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->anoleSel:B

    goto :goto_f

    .line 2053
    :cond_27
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1()Z

    move-result v0

    if-eqz v0, :cond_ca

    .line 2057
    iget-byte v0, p0, Lmain/Map;->anoleSel:B

    invoke-direct {p0, v0}, Lmain/Map;->isAnoleType(I)Z

    move-result v0

    if-nez v0, :cond_48

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v1, "\u8fd8\u6ca1\u6709\u83b7\u5f97\u8be5\u9a91\u5ba0"

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2105
    :goto_40
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto :goto_f

    .line 2059
    :cond_48
    iget-byte v0, p0, Lmain/Map;->anoleSel:B

    if-ne v0, v6, :cond_54

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v1, "\u53ea\u80fd\u5728\u6c34\u91cc\u4f7f\u7528"

    invoke-virtual {v0, v1, v2}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_40

    .line 2061
    :cond_54
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    iget-byte v1, p0, Lmain/Map;->anoleSel:B

    if-ne v0, v1, :cond_7f

    iput-byte v3, p0, Lmain/Map;->anole_type:B

    .line 2065
    :goto_5c
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsSms:[B

    const/4 v1, 0x6

    aget-byte v0, v0, v1

    const/16 v1, 0xa

    if-ne v0, v1, :cond_84

    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-ne v0, v5, :cond_84

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsSms:[B

    aget-byte v0, v0, v2

    if-nez v0, :cond_84

    .line 2071
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-static {v0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v0

    invoke-virtual {v0, v4, v4}, Lmain/SMSSender;->go(IZ)V

    .line 2073
    iput-byte v3, p0, Lmain/Map;->anole_type:B

    goto :goto_40

    .line 2062
    :cond_7f
    iget-byte v0, p0, Lmain/Map;->anoleSel:B

    iput-byte v0, p0, Lmain/Map;->anole_type:B

    goto :goto_5c

    .line 2075
    :cond_84
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-ne v0, v5, :cond_97

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsSms:[B

    aget-byte v0, v0, v2

    if-nez v0, :cond_97

    .line 2076
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v1, "\u5947\u5f02\u517d\u4e0d\u4ec5\u8dd1\u5f97\u5feb\u800c\u4e14\u53ef\u4ee5\u4e0d\u9047\u654c\uff0c\u73b0\u63d0\u4f9b\u8bd5\u9a91\u4f53\u9a8c\uff0c\u6b63\u7248\u9a8c\u8bc1\u540e\u9700\u8d2d\u4e70\uff01"

    invoke-virtual {v0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 2095
    :cond_97
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v1, 0xd

    iput-byte v1, v0, Lmain/GameRun;->magic_id:B

    .line 2096
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v1, p0, Lmain/Map;->map_x:I

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v2, Ldm/Npc;->x:S

    add-int/2addr v1, v2

    add-int/lit8 v1, v1, 0xa

    iput v1, v0, Lmain/GameRun;->magic_x:I

    .line 2097
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v1, p0, Lmain/Map;->map_y:I

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v2, Ldm/Npc;->y:S

    add-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x13

    iput v1, v0, Lmain/GameRun;->magic_y:I

    .line 2098
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->magic_id:B

    div-int/lit8 v1, v1, 0x5

    invoke-virtual {v0, v1}, Lmain/GameRun;->setMagic(I)V

    .line 2099
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0x15

    iput-byte v1, v0, Ldm/Npc;->state:B

    goto/16 :goto_40

    .line 2106
    :cond_ca
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-nez v0, :cond_de

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Num9()Z

    move-result v0

    if-eqz v0, :cond_f

    .line 2107
    :cond_de
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v2, v0, Ldm/Npc;->state:B

    .line 2108
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto/16 :goto_f
.end method

.method private keyMiniMap()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 2797
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 2798
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-nez v0, :cond_2f

    .line 2799
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-nez v0, :cond_26

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Num0()Z

    move-result v0

    if-eqz v0, :cond_30

    .line 2800
    :cond_26
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v1, 0x0

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 2801
    iput-object v2, p0, Lmain/Map;->mapdataArea:[[B

    .line 2802
    iput-object v2, p0, Lmain/Map;->mapdataMap:[[B

    .line 2807
    :cond_2f
    :goto_2f
    return-void

    .line 2803
    :cond_30
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-nez v0, :cond_44

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_2f

    .line 2804
    :cond_44
    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    iget-byte v1, p0, Lmain/Map;->selectMap:B

    aget-object v0, v0, v1

    array-length v0, v0

    const/4 v1, 0x6

    if-lt v0, v1, :cond_2f

    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    iget-byte v1, p0, Lmain/Map;->selectMap:B

    aget-object v0, v0, v1

    sget v1, Ldm/Ms;->key:I

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    aget-byte v0, v0, v1

    const/4 v1, -0x1

    if-eq v0, v1, :cond_2f

    .line 2805
    iget-object v0, p0, Lmain/Map;->mapdataMap:[[B

    iget-byte v1, p0, Lmain/Map;->selectMap:B

    aget-object v0, v0, v1

    sget v1, Ldm/Ms;->key:I

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    aget-byte v0, v0, v1

    iput-byte v0, p0, Lmain/Map;->selectMap:B

    goto :goto_2f
.end method

.method private keyMission()V
    .registers 10

    .prologue
    const/16 v8, 0x32

    const/16 v4, 0xe

    const/4 v7, 0x1

    const/4 v5, 0x0

    const/4 v6, 0x0

    .line 3045
    const/16 v0, 0x280

    .line 3046
    .local v0, "WIDTH":I
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_delay()Z

    move-result v2

    if-eqz v2, :cond_14

    .line 3082
    :cond_13
    :goto_13
    return-void

    .line 3048
    :cond_14
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Left_Right()Z

    move-result v2

    if-nez v2, :cond_3e

    .line 3049
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Num1()Z

    move-result v2

    if-eqz v2, :cond_2e

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    if-eq v2, v7, :cond_3e

    .line 3050
    :cond_2e
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Num3()Z

    move-result v2

    if-eqz v2, :cond_51

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    if-nez v2, :cond_51

    .line 3051
    :cond_3e
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v3, v2, Lmain/GameRun;->cur_a:B

    xor-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    iput-byte v3, v2, Lmain/GameRun;->cur_a:B

    .line 3052
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    iget-boolean v3, p0, Lmain/Map;->bPause:Z

    invoke-virtual {p0, v2, v3}, Lmain/Map;->goMission(IZ)V

    goto :goto_13

    .line 3053
    :cond_51
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Up_Down()Z

    move-result v2

    if-eqz v2, :cond_d8

    .line 3058
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    if-nez v2, :cond_a9

    .line 3059
    iget-object v2, p0, Lmain/Map;->bMission:[B

    aget-byte v2, v2, v4

    add-int/lit8 v2, v2, 0x1

    iget-object v3, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    array-length v3, v3

    if-le v2, v3, :cond_a2

    iget-object v2, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    array-length v2, v2

    :goto_6f
    int-to-byte v1, v2

    .line 3061
    .local v1, "length":B
    :goto_70
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->select:[[B

    aget-object v3, v3, v6

    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v4, v4, Lmain/GameRun;->line_max:B

    invoke-virtual {v2, v3, v6, v1, v4}, Ldm/Ms;->selectS([BIII)V

    .line 3062
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    if-nez v2, :cond_ae

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->select:[[B

    aget-object v4, v4, v6

    aget-byte v4, v4, v6

    aget-object v3, v3, v4

    aget-object v3, v3, v7

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    sub-int v4, v0, v8

    invoke-virtual {v2, v3, v4, v6}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    goto/16 :goto_13

    .line 3059
    .end local v1    # "length":B
    :cond_a2
    iget-object v2, p0, Lmain/Map;->bMission:[B

    aget-byte v2, v2, v4

    add-int/lit8 v2, v2, 0x1

    goto :goto_6f

    .line 3060
    :cond_a9
    iget-object v2, p0, Lmain/Map;->mDirect:[B

    array-length v2, v2

    int-to-byte v1, v2

    .restart local v1    # "length":B
    goto :goto_70

    .line 3063
    :cond_ae
    iget-object v2, p0, Lmain/Map;->mDirect:[B

    array-length v2, v2

    if-lez v2, :cond_d2

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    iget-object v4, p0, Lmain/Map;->mDirect:[B

    iget-object v5, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v5, v5, Lmain/GameRun;->select:[[B

    aget-object v5, v5, v6

    aget-byte v5, v5, v6

    aget-byte v4, v4, v5

    aget-object v3, v3, v4

    aget-object v3, v3, v7

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    sub-int v4, v0, v8

    invoke-virtual {v2, v3, v4, v6}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    goto/16 :goto_13

    .line 3064
    :cond_d2
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-object v5, v2, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    goto/16 :goto_13

    .line 3066
    .end local v1    # "length":B
    :cond_d8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_S2()Z

    move-result v2

    if-nez v2, :cond_f6

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Num1()Z

    move-result v2

    if-nez v2, :cond_f6

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->key_Num3()Z

    move-result v2

    if-eqz v2, :cond_13

    .line 3070
    :cond_f6
    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v6, v2, Ldm/Npc;->state:B

    .line 3071
    iget-boolean v2, p0, Lmain/Map;->bPause:Z

    if-eqz v2, :cond_118

    .line 3072
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v2, v6}, Lmain/GameRun;->doPaint(I)V

    .line 3073
    const/16 v2, 0x61

    sput v2, Lmain/GameRun;->run_state:I

    .line 3077
    :goto_107
    iput-object v5, p0, Lmain/Map;->mDirect:[B

    .line 3078
    iput-object v5, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    .line 3079
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-object v5, v2, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    .line 3080
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2}, Ldm/Ms;->keyRelease()V

    goto/16 :goto_13

    .line 3075
    :cond_118
    const/16 v2, -0xa

    sput v2, Lmain/GameRun;->run_state:I

    goto :goto_107
.end method

.method private keyMySave()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    .line 2852
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 2853
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 2854
    const/4 v0, 0x2

    iput-byte v0, p0, Lmain/Map;->eventGoing:B

    .line 2859
    :cond_12
    :goto_12
    return-void

    .line 2855
    :cond_13
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_12

    .line 2856
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 2857
    const/4 v0, 0x3

    iput-byte v0, p0, Lmain/Map;->eventGoing:B

    goto :goto_12
.end method

.method private keySelectMenu()V
    .registers 7

    .prologue
    .line 3394
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_b

    .line 3402
    :cond_a
    :goto_a
    return-void

    .line 3395
    :cond_b
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_1c

    .line 3396
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0xd

    iput-byte v1, v0, Ldm/Npc;->state:B

    goto :goto_a

    .line 3399
    :cond_1c
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 3400
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    const/4 v3, 0x0

    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->action_str:[Ljava/lang/String;

    array-length v4, v4

    const/4 v5, 0x1

    sub-int/2addr v4, v5

    invoke-virtual {v1, v2, v3, v4}, Ldm/Ms;->select(III)B

    move-result v1

    iput-byte v1, v0, Lmain/GameRun;->cur_a:B

    goto :goto_a
.end method

.method private loadMapData(I)V
    .registers 22
    .param p1, "id"    # I

    .prologue
    .line 3139
    const/4 v10, 0x0

    .line 3140
    .local v10, "elemNum":I
    const/4 v8, 0x0

    .line 3146
    .local v8, "dataType":I
    const/16 v16, 0x2

    move/from16 v0, v16

    new-array v0, v0, [B

    move-object v7, v0

    .line 3147
    .local v7, "buffShort":[B
    const/16 v16, 0x4

    move/from16 v0, v16

    new-array v0, v0, [B

    move-object v6, v0

    .line 3148
    .local v6, "buffInt":[B
    const/4 v12, 0x0

    .line 3151
    .local v12, "layerType":B
    const/16 v16, 0x0

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    iput-object v0, v1, Lmain/Map;->bottomData:[S

    .line 3152
    const/16 v16, 0x0

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    iput-object v0, v1, Lmain/Map;->frontData:[S

    .line 3153
    const/16 v16, 0x0

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    iput-object v0, v1, Lmain/Map;->worldData:[[S

    .line 3155
    const/4 v3, 0x0

    .line 3158
    .local v3, "arrayIndex":S
    :try_start_2a
    new-instance v9, Ljava/io/DataInputStream;

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "/data/map/"

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v16

    move/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, ".mid"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v16 .. v16}, Lcom/android/Util/AndroidUtil;->getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v16

    move-object v0, v9

    move-object/from16 v1, v16

    invoke-direct {v0, v1}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 3160
    .local v9, "dis":Ljava/io/DataInputStream;
    const-wide/16 v16, 0x2

    move-object v0, v9

    move-wide/from16 v1, v16

    invoke-virtual {v0, v1, v2}, Ljava/io/DataInputStream;->skip(J)J

    .line 3161
    invoke-virtual {v9, v6}, Ljava/io/DataInputStream;->read([B)I

    .line 3162
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v6}, Ldm/Ms;->getNum([B)J

    move-result-wide v16

    move-wide/from16 v0, v16

    long-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->bgColor:I

    .line 3165
    invoke-virtual {v9}, Ljava/io/DataInputStream;->readByte()B

    move-result v8

    .line 3167
    new-array v5, v8, [B

    .line 3168
    .local v5, "buff":[B
    invoke-virtual {v9, v5}, Ljava/io/DataInputStream;->read([B)I

    .line 3170
    invoke-virtual {v9, v5}, Ljava/io/DataInputStream;->read([B)I

    .line 3171
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v5}, Ldm/Ms;->getNum([B)J

    move-result-wide v16

    move-wide/from16 v0, v16

    long-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    int-to-byte v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->cols:S

    .line 3172
    invoke-virtual {v9, v5}, Ljava/io/DataInputStream;->read([B)I

    .line 3173
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v5}, Ldm/Ms;->getNum([B)J

    move-result-wide v16

    move-wide/from16 v0, v16

    long-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    int-to-byte v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->rows:S

    .line 3181
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->cols:S

    move/from16 v16, v0

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->rows:S

    move/from16 v17, v0

    filled-new-array/range {v16 .. v17}, [I

    move-result-object v16

    sget-object v17, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-static {v0, v1}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object p1

    .end local p1    # "id":I
    check-cast p1, [[S

    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lmain/Map;->worldData:[[S

    .line 3191
    const/4 v11, 0x0

    .local v11, "i":B
    :goto_cc
    const/16 v16, 0x3

    move v0, v11

    move/from16 v1, v16

    if-lt v0, v1, :cond_e5

    .line 3234
    invoke-virtual {v9}, Ljava/io/DataInputStream;->close()V

    .line 3235
    const/4 v5, 0x0

    check-cast v5, [B

    .line 3236
    const/4 v9, 0x0

    move-object v0, v9

    check-cast v0, [B

    move-object v7, v0

    .line 3237
    .end local v9    # "dis":Ljava/io/DataInputStream;
    const/4 v9, 0x0

    move-object v0, v9

    check-cast v0, [B

    move-object v6, v0

    .line 3238
    const/4 v9, 0x0

    .line 3257
    .end local v5    # "buff":[B
    .end local v11    # "i":B
    :goto_e4
    return-void

    .line 3192
    .restart local v5    # "buff":[B
    .restart local v9    # "dis":Ljava/io/DataInputStream;
    .restart local v11    # "i":B
    :cond_e5
    invoke-virtual {v9}, Ljava/io/DataInputStream;->readByte()B

    move-result v12

    .line 3193
    const/16 v16, -0x1

    move v0, v12

    move/from16 v1, v16

    if-ne v0, v1, :cond_f7

    .line 3191
    :goto_f0
    add-int/lit8 v16, v11, 0x1

    move/from16 v0, v16

    int-to-byte v0, v0

    move v11, v0

    goto :goto_cc

    .line 3194
    :cond_f7
    invoke-virtual {v9, v6}, Ljava/io/DataInputStream;->read([B)I

    .line 3195
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v6}, Ldm/Ms;->getNum([B)J

    move-result-wide v16

    move-wide/from16 v0, v16

    long-to-int v0, v0

    move v10, v0

    .line 3196
    mul-int/lit8 v10, v10, 0x3

    .line 3197
    packed-switch v12, :pswitch_data_20c

    .line 3209
    :goto_10a
    :pswitch_10a
    const/4 v3, 0x0

    move v4, v3

    .end local v3    # "arrayIndex":S
    .local v4, "arrayIndex":S
    :goto_10c
    if-lt v4, v10, :cond_12a

    move v3, v4

    .end local v4    # "arrayIndex":S
    .restart local v3    # "arrayIndex":S
    goto :goto_f0

    .line 3199
    :pswitch_110
    move v0, v10

    new-array v0, v0, [S

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    iput-object v0, v1, Lmain/Map;->bottomData:[S

    goto :goto_10a

    .line 3239
    .end local v5    # "buff":[B
    .end local v9    # "dis":Ljava/io/DataInputStream;
    .end local v11    # "i":B
    :catch_11c
    move-exception v16

    goto :goto_e4

    .line 3205
    .restart local v5    # "buff":[B
    .restart local v9    # "dis":Ljava/io/DataInputStream;
    .restart local v11    # "i":B
    :pswitch_11e
    move v0, v10

    new-array v0, v0, [S

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    move-object/from16 v1, p0

    iput-object v0, v1, Lmain/Map;->frontData:[S
    :try_end_129
    .catch Ljava/lang/Exception; {:try_start_2a .. :try_end_129} :catch_11c

    goto :goto_10a

    .line 3210
    .end local v3    # "arrayIndex":S
    .restart local v4    # "arrayIndex":S
    :cond_12a
    :try_start_12a
    invoke-virtual {v9, v5}, Ljava/io/DataInputStream;->read([B)I

    .line 3211
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v5}, Ldm/Ms;->getNum([B)J

    move-result-wide v16

    move-wide/from16 v0, v16

    long-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    int-to-short v0, v0

    move v13, v0

    .line 3212
    .local v13, "x":I
    invoke-virtual {v9, v5}, Ljava/io/DataInputStream;->read([B)I

    .line 3213
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->rows:S

    move/from16 v16, v0

    const/16 v17, 0x1

    sub-int v16, v16, v17

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v16, v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v5}, Ldm/Ms;->getNum([B)J

    move-result-wide v18

    sub-long v16, v16, v18

    move-wide/from16 v0, v16

    long-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    int-to-short v0, v0

    move v14, v0

    .line 3214
    .local v14, "y":I
    invoke-virtual {v9, v7}, Ljava/io/DataInputStream;->read([B)I

    .line 3215
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v7}, Ldm/Ms;->getNum([B)J

    move-result-wide v16

    move-wide/from16 v0, v16

    long-to-int v0, v0

    move/from16 v16, v0

    move/from16 v0, v16

    int-to-short v0, v0

    move v15, v0

    .line 3216
    .local v15, "z":I
    packed-switch v12, :pswitch_data_216

    goto :goto_10c

    .line 3218
    :pswitch_178
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bottomData:[S

    move-object/from16 v16, v0
    :try_end_17e
    .catch Ljava/lang/Exception; {:try_start_12a .. :try_end_17e} :catch_204

    add-int/lit8 v17, v4, 0x1

    move/from16 v0, v17

    int-to-short v0, v0

    move v3, v0

    .end local v4    # "arrayIndex":S
    .restart local v3    # "arrayIndex":S
    move v0, v13

    int-to-short v0, v0

    move/from16 v17, v0

    :try_start_188
    aput-short v17, v16, v4

    .line 3219
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bottomData:[S

    move-object/from16 v16, v0
    :try_end_190
    .catch Ljava/lang/Exception; {:try_start_188 .. :try_end_190} :catch_11c

    add-int/lit8 v17, v3, 0x1

    move/from16 v0, v17

    int-to-short v0, v0

    move v4, v0

    .end local v3    # "arrayIndex":S
    .restart local v4    # "arrayIndex":S
    move v0, v14

    int-to-short v0, v0

    move/from16 v17, v0

    :try_start_19a
    aput-short v17, v16, v3

    .line 3220
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bottomData:[S

    move-object/from16 v16, v0
    :try_end_1a2
    .catch Ljava/lang/Exception; {:try_start_19a .. :try_end_1a2} :catch_208

    add-int/lit8 v17, v4, 0x1

    move/from16 v0, v17

    int-to-short v0, v0

    move v3, v0

    .end local v4    # "arrayIndex":S
    .restart local v3    # "arrayIndex":S
    move v0, v15

    int-to-short v0, v0

    move/from16 v17, v0

    :try_start_1ac
    aput-short v17, v16, v4

    move v4, v3

    .line 3221
    .end local v3    # "arrayIndex":S
    .restart local v4    # "arrayIndex":S
    goto/16 :goto_10c

    .line 3223
    :pswitch_1b1
    add-int/lit8 v16, v4, 0x3

    move/from16 v0, v16

    int-to-short v0, v0

    move v3, v0

    .line 3224
    .end local v4    # "arrayIndex":S
    .restart local v3    # "arrayIndex":S
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->worldData:[[S

    move-object/from16 v16, v0

    aget-object v16, v16, v13

    shr-int/lit8 v17, v15, 0x3

    move/from16 v0, v17

    int-to-short v0, v0

    move/from16 v17, v0

    aput-short v17, v16, v14
    :try_end_1c8
    .catch Ljava/lang/Exception; {:try_start_1ac .. :try_end_1c8} :catch_11c

    move v4, v3

    .line 3225
    .end local v3    # "arrayIndex":S
    .restart local v4    # "arrayIndex":S
    goto/16 :goto_10c

    .line 3227
    :pswitch_1cb
    :try_start_1cb
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->frontData:[S

    move-object/from16 v16, v0
    :try_end_1d1
    .catch Ljava/lang/Exception; {:try_start_1cb .. :try_end_1d1} :catch_204

    add-int/lit8 v17, v4, 0x1

    move/from16 v0, v17

    int-to-short v0, v0

    move v3, v0

    .end local v4    # "arrayIndex":S
    .restart local v3    # "arrayIndex":S
    move v0, v13

    int-to-short v0, v0

    move/from16 v17, v0

    :try_start_1db
    aput-short v17, v16, v4

    .line 3228
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->frontData:[S

    move-object/from16 v16, v0
    :try_end_1e3
    .catch Ljava/lang/Exception; {:try_start_1db .. :try_end_1e3} :catch_11c

    add-int/lit8 v17, v3, 0x1

    move/from16 v0, v17

    int-to-short v0, v0

    move v4, v0

    .end local v3    # "arrayIndex":S
    .restart local v4    # "arrayIndex":S
    move v0, v14

    int-to-short v0, v0

    move/from16 v17, v0

    :try_start_1ed
    aput-short v17, v16, v3

    .line 3229
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->frontData:[S

    move-object/from16 v16, v0
    :try_end_1f5
    .catch Ljava/lang/Exception; {:try_start_1ed .. :try_end_1f5} :catch_208

    add-int/lit8 v17, v4, 0x1

    move/from16 v0, v17

    int-to-short v0, v0

    move v3, v0

    .end local v4    # "arrayIndex":S
    .restart local v3    # "arrayIndex":S
    move v0, v15

    int-to-short v0, v0

    move/from16 v17, v0

    :try_start_1ff
    aput-short v17, v16, v4
    :try_end_201
    .catch Ljava/lang/Exception; {:try_start_1ff .. :try_end_201} :catch_11c

    move v4, v3

    .end local v3    # "arrayIndex":S
    .restart local v4    # "arrayIndex":S
    goto/16 :goto_10c

    .line 3239
    .end local v13    # "x":I
    .end local v14    # "y":I
    .end local v15    # "z":I
    :catch_204
    move-exception v16

    move v3, v4

    .end local v4    # "arrayIndex":S
    .restart local v3    # "arrayIndex":S
    goto/16 :goto_e4

    .end local v3    # "arrayIndex":S
    .restart local v4    # "arrayIndex":S
    .restart local v13    # "x":I
    .restart local v14    # "y":I
    .restart local v15    # "z":I
    :catch_208
    move-exception v16

    move v3, v4

    .end local v4    # "arrayIndex":S
    .restart local v3    # "arrayIndex":S
    goto/16 :goto_e4

    .line 3197
    :pswitch_data_20c
    .packed-switch 0x1
        :pswitch_110
        :pswitch_10a
        :pswitch_11e
    .end packed-switch

    .line 3216
    :pswitch_data_216
    .packed-switch 0x1
        :pswitch_178
        :pswitch_1b1
        :pswitch_1cb
    .end packed-switch
.end method

.method private loadMapModuleAndImage()V
    .registers 12

    .prologue
    const/4 v8, 0x0

    const/4 v10, -0x1

    const/4 v5, 0x0

    .line 3099
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v8, Ldm/Ms;->skip:I

    .line 3100
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    const-string v7, "data/map/area.dat"

    invoke-virtual {v6, v7, v10}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v3

    .line 3101
    .local v3, "data":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    invoke-virtual {v6, v3}, Ldm/Ms;->createArray([B)[B

    move-result-object v1

    .line 3102
    .local v1, "areaMap":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    invoke-virtual {v6, v3}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v2

    .line 3103
    .local v2, "areaPic":[[B
    move-object v0, v5

    check-cast v0, [B

    move-object v3, v0

    .line 3105
    iget-object v6, p0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    if-eqz v6, :cond_3d

    iget-byte v6, p0, Lmain/Map;->lastMap:B

    aget-byte v6, v1, v6

    iget-byte v7, p0, Lmain/Map;->mapNo:B

    aget-byte v7, v1, v7

    if-ne v6, v7, :cond_3d

    .line 3106
    move-object v0, v5

    check-cast v0, [B

    move-object v1, v0

    .line 3107
    move-object v0, v5

    check-cast v0, [[B

    move-object v2, v0

    .line 3130
    :goto_3c
    return-void

    .line 3111
    :cond_3d
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v8, Ldm/Ms;->skip:I

    .line 3112
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "data/map/"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v9, p0, Lmain/Map;->mapNo:B

    aget-byte v9, v1, v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ".data"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8, v10}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v7

    const/4 v8, 0x1

    invoke-virtual {v6, v7, v8}, Ldm/Ms;->createShort2Array([BI)[[S

    move-result-object v6

    iput-object v6, p0, Lmain/Map;->moduleData:[[S

    .line 3113
    iput-object v5, p0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    .line 3114
    iget-byte v6, p0, Lmain/Map;->mapNo:B

    aget-byte v6, v1, v6

    aget-object v6, v2, v6

    array-length v6, v6

    new-array v6, v6, [Ljavax/microedition/lcdui/Image;

    iput-object v6, p0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    .line 3115
    const/4 v4, 0x0

    .local v4, "i":B
    :goto_7c
    iget-byte v6, p0, Lmain/Map;->mapNo:B

    aget-byte v6, v1, v6

    aget-object v6, v2, v6

    array-length v6, v6

    if-lt v4, v6, :cond_8e

    .line 3119
    move-object v0, v5

    check-cast v0, [B

    move-object v1, v0

    .line 3120
    move-object v0, v5

    check-cast v0, [[B

    move-object v2, v0

    .line 3130
    goto :goto_3c

    .line 3117
    :cond_8e
    iget-object v6, p0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "data/map/"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v9, p0, Lmain/Map;->mapNo:B

    aget-byte v9, v1, v9

    aget-object v9, v2, v9

    aget-byte v9, v9, v4

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v7

    aput-object v7, v6, v4

    .line 3115
    add-int/lit8 v6, v4, 0x1

    int-to-byte v4, v6

    goto :goto_7c
.end method

.method private map_set(IIIIII)I
    .registers 10
    .param p1, "_my_x"    # I
    .param p2, "cols"    # I
    .param p3, "xcells"    # I
    .param p4, "half_xcells"    # I
    .param p5, "show_width"    # I
    .param p6, "cell_width"    # I

    .prologue
    .line 654
    if-gt p2, p3, :cond_9

    .line 655
    mul-int v1, p6, p2

    sub-int v1, p5, v1

    shr-int/lit8 v0, v1, 0x1

    .line 665
    .local v0, "map_x":I
    :goto_8
    return v0

    .line 656
    .end local v0    # "map_x":I
    :cond_9
    add-int/lit8 v1, p1, 0x1

    if-gt v1, p4, :cond_f

    .line 657
    const/4 v0, 0x0

    .restart local v0    # "map_x":I
    goto :goto_8

    .line 659
    .end local v0    # "map_x":I
    :cond_f
    sub-int v1, p2, p4

    if-lt p1, v1, :cond_18

    .line 660
    mul-int v1, p2, p6

    sub-int v0, p5, v1

    .restart local v0    # "map_x":I
    goto :goto_8

    .line 662
    .end local v0    # "map_x":I
    :cond_18
    div-int/lit8 v1, p5, 0x2

    mul-int v2, p1, p6

    sub-int/2addr v1, v2

    div-int/lit8 v2, p6, 0x2

    sub-int v0, v1, v2

    .restart local v0    # "map_x":I
    goto :goto_8
.end method

.method private meetGrass()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 2419
    iget-short v0, p0, Lmain/Map;->meet_step:S

    iget-short v1, p0, Lmain/Map;->step_MEET:S

    if-ge v0, v1, :cond_24

    iget-object v0, p0, Lmain/Map;->worldData:[[S

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v1}, Ldm/Npc;->getIx()B

    move-result v1

    aget-object v0, v0, v1

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v1}, Ldm/Npc;->getIy()B

    move-result v1

    aget-short v0, v0, v1

    const/4 v1, 0x7

    if-eq v0, v1, :cond_23

    iget-short v0, p0, Lmain/Map;->meet_step:S

    add-int/lit8 v0, v0, 0x1

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->meet_step:S

    .line 2427
    :cond_23
    :goto_23
    return-void

    .line 2421
    :cond_24
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->monPro:[B

    array-length v0, v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_3c

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->immueEnemy:B

    if-nez v0, :cond_3c

    .line 2422
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v2, v0, Ldm/Npc;->frame_c:B

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0x8

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 2425
    :cond_3c
    invoke-virtual {p0, v2, v2}, Lmain/Map;->notMeet(II)V

    goto :goto_23
.end method

.method private moveOff(BBI)V
    .registers 7
    .param p1, "dirx"    # B
    .param p2, "diry"    # B
    .param p3, "speed"    # I

    .prologue
    const/4 v2, 0x0

    .line 2480
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->speed_x:B

    if-nez v0, :cond_2c

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte p1, v0, Ldm/Npc;->dir:B

    .line 2483
    :cond_b
    :goto_b
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed_x:B

    if-eqz v1, :cond_37

    move v1, v2

    :goto_14
    int-to-byte v1, v1

    iput-byte v1, v0, Ldm/Npc;->speed_x:B

    .line 2484
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed_y:B

    if-eqz v1, :cond_39

    move v1, v2

    :goto_20
    int-to-byte v1, v1

    iput-byte v1, v0, Ldm/Npc;->speed_y:B

    .line 2485
    iget-byte v0, p0, Lmain/Map;->checkNpcT:B

    invoke-direct {p0, v0}, Lmain/Map;->checkMoveOff(I)Z

    .line 2486
    invoke-direct {p0}, Lmain/Map;->initMoveMy()V

    .line 2487
    return-void

    .line 2481
    :cond_2c
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->speed_y:B

    if-nez v0, :cond_b

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte p2, v0, Ldm/Npc;->dir:B

    goto :goto_b

    :cond_37
    move v1, p3

    .line 2483
    goto :goto_14

    :cond_39
    move v1, p3

    .line 2484
    goto :goto_20
.end method

.method private nextEvent(I)V
    .registers 4
    .param p1, "mode"    # I

    .prologue
    const/4 v1, 0x0

    .line 708
    and-int/lit16 v0, p1, 0x1000

    if-eqz v0, :cond_9

    .line 709
    iput-byte v1, p0, Lmain/Map;->now_eV1:B

    .line 710
    iput-byte v1, p0, Lmain/Map;->now_eV2:B

    .line 712
    :cond_9
    and-int/lit16 v0, p1, 0x100

    if-eqz v0, :cond_f

    iput-byte v1, p0, Lmain/Map;->eventGoing:B

    .line 713
    :cond_f
    and-int/lit8 v0, p1, 0x10

    if-eqz v0, :cond_16

    const/4 v0, 0x1

    iput-byte v0, p0, Lmain/Map;->event_state:B

    .line 714
    :cond_16
    and-int/lit8 v0, p1, 0x1

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 715
    :cond_1e
    iget-object v0, p0, Lmain/Map;->pkey:Lmain/PointerKey;

    invoke-virtual {v0}, Lmain/PointerKey;->initPointer()V

    .line 716
    return-void
.end method

.method private oneMove(Ldm/Npc;I)V
    .registers 7
    .param p1, "npc_"    # Ldm/Npc;
    .param p2, "i"    # I

    .prologue
    const/4 v1, -0x1

    .line 2211
    iget-byte v0, p1, Ldm/Npc;->frame_c:B

    if-lez v0, :cond_2c

    .line 2212
    iget-byte v0, p0, Lmain/Map;->srcNpcNo:B

    if-ne v0, p2, :cond_14

    .line 2213
    iget-short v0, p1, Ldm/Npc;->x:S

    iget-short v1, p1, Ldm/Npc;->y:S

    iget-byte v2, p1, Ldm/Npc;->speed_x:B

    iget-byte v3, p1, Ldm/Npc;->speed_y:B

    invoke-virtual {p0, v0, v1, v2, v3}, Lmain/Map;->mapMove(IIII)V

    .line 2214
    :cond_14
    iget-short v0, p1, Ldm/Npc;->x:S

    iget-byte v1, p1, Ldm/Npc;->speed_x:B

    add-int/2addr v0, v1

    int-to-short v0, v0

    iput-short v0, p1, Ldm/Npc;->x:S

    .line 2215
    iget-short v0, p1, Ldm/Npc;->y:S

    iget-byte v1, p1, Ldm/Npc;->speed_y:B

    add-int/2addr v0, v1

    int-to-short v0, v0

    iput-short v0, p1, Ldm/Npc;->y:S

    .line 2216
    iget-byte v0, p1, Ldm/Npc;->frame_c:B

    const/4 v1, 0x1

    sub-int/2addr v0, v1

    int-to-byte v0, v0

    iput-byte v0, p1, Ldm/Npc;->frame_c:B

    .line 2221
    :cond_2b
    :goto_2b
    return-void

    .line 2217
    :cond_2c
    iget-byte v0, p1, Ldm/Npc;->frame_c:B

    if-eq v0, v1, :cond_2b

    .line 2218
    iput-byte v1, p1, Ldm/Npc;->frame_c:B

    .line 2219
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Ldm/Npc;->setActionNo(Z)V

    goto :goto_2b
.end method

.method private runAutoMoveNpc(Ldm/Npc;I)V
    .registers 10
    .param p1, "npc"    # Ldm/Npc;
    .param p2, "i"    # I

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x5

    const/4 v6, 0x3

    const/4 v5, 0x1

    const/4 v4, 0x7

    .line 3787
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-ne v0, v5, :cond_4c

    iget-byte v0, p0, Lmain/Map;->get_meet:B

    if-ne v0, p2, :cond_4c

    .line 3788
    iget-object v0, p1, Ldm/Npc;->other:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-object v1, p1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v4

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v1

    div-int/lit8 v1, v1, 0x3

    mul-int/lit8 v1, v1, 0x3

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->dir:B

    const/4 v3, 0x4

    if-ge v2, v3, :cond_42

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->dir:B

    sub-int/2addr v2, v5

    :goto_2d
    add-int/2addr v1, v2

    int-to-byte v1, v1

    aput-byte v1, v0, v4

    .line 3789
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->dir:B

    if-ne v0, v6, :cond_49

    .line 3790
    iget-object v0, p1, Ldm/Npc;->other:[B

    iget-object v1, p1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v4

    neg-int v1, v1

    int-to-byte v1, v1

    aput-byte v1, v0, v4

    .line 3797
    :cond_41
    :goto_41
    return-void

    .line 3788
    :cond_42
    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->dir:B

    const/4 v3, 0x2

    sub-int/2addr v2, v3

    goto :goto_2d

    .line 3791
    :cond_49
    iput-byte v6, p1, Ldm/Npc;->dir:B

    goto :goto_41

    .line 3793
    :cond_4c
    const/16 v0, 0xa

    invoke-direct {p0, p1, v0}, Lmain/Map;->initAuto(Ldm/Npc;I)Z

    move-result v0

    if-eqz v0, :cond_41

    .line 3794
    iget-boolean v0, p1, Ldm/Npc;->b_auto:Z

    if-eqz v0, :cond_69

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->mapMove:[B

    iget-object v1, p1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v3

    sub-int/2addr v1, v2

    mul-int/lit8 v1, v1, 0x2

    aget-byte v0, v0, v1

    invoke-direct {p0, p1, v0}, Lmain/Map;->runAutoX(Ldm/Npc;I)V

    goto :goto_41

    .line 3795
    :cond_69
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->mapMove:[B

    iget-object v1, p1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v3

    sub-int/2addr v1, v2

    mul-int/lit8 v1, v1, 0x2

    add-int/lit8 v1, v1, 0x1

    aget-byte v0, v0, v1

    invoke-direct {p0, p1, v0}, Lmain/Map;->runAutoY(Ldm/Npc;I)V

    goto :goto_41
.end method

.method private runAutoX(Ldm/Npc;I)V
    .registers 9
    .param p1, "_npc"    # Ldm/Npc;
    .param p2, "w"    # I

    .prologue
    const/16 v5, 0x14

    const/4 v4, 0x3

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 3846
    iget-byte v1, p1, Ldm/Npc;->timeMove:B

    if-nez v1, :cond_56

    .line 3847
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v1, 0x64

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    const/16 v2, 0x32

    if-ge v1, v2, :cond_31

    move v1, v4

    :goto_17
    iput-byte v1, p1, Ldm/Npc;->dir:B

    .line 3848
    iget-byte v1, p1, Ldm/Npc;->dir:B

    if-ne v1, v4, :cond_33

    iget-short v1, p1, Ldm/Npc;->x:S

    iget-object v2, p1, Ldm/Npc;->other:[B

    aget-byte v2, v2, v3

    mul-int/lit8 v2, v2, 0x14

    sub-int/2addr v1, v2

    int-to-short v0, v1

    .line 3850
    .local v0, "t":S
    :goto_27
    if-gt v0, v5, :cond_3f

    iget-byte v1, p1, Ldm/Npc;->speed:B

    div-int v1, v0, v1

    int-to-byte v1, v1

    iput-byte v1, p1, Ldm/Npc;->timeMove:B

    .line 3866
    .end local v0    # "t":S
    :cond_30
    :goto_30
    return-void

    .line 3847
    :cond_31
    const/4 v1, 0x4

    goto :goto_17

    .line 3849
    :cond_33
    iget-object v1, p1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v3

    add-int/2addr v1, p2

    mul-int/lit8 v1, v1, 0x14

    iget-short v2, p1, Ldm/Npc;->x:S

    sub-int/2addr v1, v2

    int-to-short v0, v1

    .restart local v0    # "t":S
    goto :goto_27

    .line 3851
    :cond_3f
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sub-int v1, v0, v5

    iget-byte v2, p1, Ldm/Npc;->speed:B

    div-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    iget-byte v2, p1, Ldm/Npc;->speed:B

    div-int v2, v5, v2

    add-int/2addr v1, v2

    int-to-byte v1, v1

    iput-byte v1, p1, Ldm/Npc;->timeMove:B

    goto :goto_30

    .line 3852
    .end local v0    # "t":S
    :cond_56
    iget-byte v1, p1, Ldm/Npc;->timeMove:B

    if-lez v1, :cond_30

    .line 3853
    iget-byte v1, p1, Ldm/Npc;->frame_c:B

    if-ge v1, v2, :cond_30

    .line 3854
    iget-byte v1, p1, Ldm/Npc;->dir:B

    if-ne v1, v4, :cond_81

    iget-byte v1, p1, Ldm/Npc;->speed:B

    neg-int v1, v1

    :goto_65
    invoke-direct {p0, p1, v1, v3}, Lmain/Map;->isAuto_canMove(Ldm/Npc;II)Z

    move-result v1

    if-eqz v1, :cond_87

    .line 3855
    iget-byte v1, p1, Ldm/Npc;->dir:B

    if-ne v1, v4, :cond_84

    iget-byte v1, p1, Ldm/Npc;->speed:B

    neg-int v1, v1

    :goto_72
    invoke-virtual {p1, v1, v3}, Ldm/Npc;->setSpeedXY(II)V

    .line 3856
    iget-byte v1, p1, Ldm/Npc;->timeMove:B

    sub-int/2addr v1, v2

    int-to-byte v1, v1

    iput-byte v1, p1, Ldm/Npc;->timeMove:B

    .line 3857
    iput-byte v2, p1, Ldm/Npc;->frame_c:B

    .line 3858
    invoke-virtual {p1, v2}, Ldm/Npc;->setActionNo(Z)V

    goto :goto_30

    .line 3854
    :cond_81
    iget-byte v1, p1, Ldm/Npc;->speed:B

    goto :goto_65

    .line 3855
    :cond_84
    iget-byte v1, p1, Ldm/Npc;->speed:B

    goto :goto_72

    .line 3860
    :cond_87
    const/16 v1, -0x14

    iput-byte v1, p1, Ldm/Npc;->timeMove:B

    .line 3861
    const/4 v1, -0x1

    iput-byte v1, p1, Ldm/Npc;->frame_c:B

    .line 3862
    invoke-virtual {p1, v3}, Ldm/Npc;->setActionNo(Z)V

    goto :goto_30
.end method

.method private runAutoY(Ldm/Npc;I)V
    .registers 9
    .param p1, "_npc"    # Ldm/Npc;
    .param p2, "w"    # I

    .prologue
    const/4 v5, -0x1

    const/16 v4, 0x14

    const/4 v2, 0x0

    const/4 v3, 0x1

    .line 3823
    iget-byte v1, p1, Ldm/Npc;->timeMove:B

    if-nez v1, :cond_5a

    iget-byte v1, p1, Ldm/Npc;->frame_c:B

    if-ne v1, v5, :cond_5a

    .line 3824
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v1, 0x64

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    const/16 v2, 0x32

    if-ge v1, v2, :cond_35

    move v1, v3

    :goto_1b
    iput-byte v1, p1, Ldm/Npc;->dir:B

    .line 3825
    iget-byte v1, p1, Ldm/Npc;->dir:B

    if-ne v1, v3, :cond_37

    iget-short v1, p1, Ldm/Npc;->y:S

    iget-object v2, p1, Ldm/Npc;->other:[B

    aget-byte v2, v2, v3

    mul-int/lit8 v2, v2, 0x14

    sub-int/2addr v1, v2

    int-to-short v0, v1

    .line 3827
    .local v0, "t":S
    :goto_2b
    if-gt v0, v4, :cond_43

    iget-byte v1, p1, Ldm/Npc;->speed:B

    div-int v1, v0, v1

    int-to-byte v1, v1

    iput-byte v1, p1, Ldm/Npc;->timeMove:B

    .line 3843
    .end local v0    # "t":S
    :cond_34
    :goto_34
    return-void

    .line 3824
    :cond_35
    const/4 v1, 0x2

    goto :goto_1b

    .line 3826
    :cond_37
    iget-object v1, p1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v3

    add-int/2addr v1, p2

    mul-int/lit8 v1, v1, 0x14

    iget-short v2, p1, Ldm/Npc;->y:S

    sub-int/2addr v1, v2

    int-to-short v0, v1

    .restart local v0    # "t":S
    goto :goto_2b

    .line 3828
    :cond_43
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sub-int v1, v0, v4

    iget-byte v2, p1, Ldm/Npc;->speed:B

    div-int/2addr v1, v2

    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    iget-byte v2, p1, Ldm/Npc;->speed:B

    div-int v2, v4, v2

    add-int/2addr v1, v2

    int-to-byte v1, v1

    iput-byte v1, p1, Ldm/Npc;->timeMove:B

    goto :goto_34

    .line 3829
    .end local v0    # "t":S
    :cond_5a
    iget-byte v1, p1, Ldm/Npc;->timeMove:B

    if-lez v1, :cond_34

    .line 3830
    iget-byte v1, p1, Ldm/Npc;->frame_c:B

    if-ge v1, v3, :cond_34

    .line 3831
    iget-byte v1, p1, Ldm/Npc;->dir:B

    if-ne v1, v3, :cond_85

    iget-byte v1, p1, Ldm/Npc;->speed:B

    neg-int v1, v1

    :goto_69
    invoke-direct {p0, p1, v2, v1}, Lmain/Map;->isAuto_canMove(Ldm/Npc;II)Z

    move-result v1

    if-eqz v1, :cond_8b

    .line 3832
    iget-byte v1, p1, Ldm/Npc;->dir:B

    if-ne v1, v3, :cond_88

    iget-byte v1, p1, Ldm/Npc;->speed:B

    neg-int v1, v1

    :goto_76
    invoke-virtual {p1, v2, v1}, Ldm/Npc;->setSpeedXY(II)V

    .line 3833
    iget-byte v1, p1, Ldm/Npc;->timeMove:B

    sub-int/2addr v1, v3

    int-to-byte v1, v1

    iput-byte v1, p1, Ldm/Npc;->timeMove:B

    .line 3834
    iput-byte v3, p1, Ldm/Npc;->frame_c:B

    .line 3835
    invoke-virtual {p1, v3}, Ldm/Npc;->setActionNo(Z)V

    goto :goto_34

    .line 3831
    :cond_85
    iget-byte v1, p1, Ldm/Npc;->speed:B

    goto :goto_69

    .line 3832
    :cond_88
    iget-byte v1, p1, Ldm/Npc;->speed:B

    goto :goto_76

    .line 3837
    :cond_8b
    const/16 v1, -0x14

    iput-byte v1, p1, Ldm/Npc;->timeMove:B

    .line 3838
    iput-byte v5, p1, Ldm/Npc;->frame_c:B

    .line 3839
    invoke-virtual {p1, v2}, Ldm/Npc;->setActionNo(Z)V

    goto :goto_34
.end method

.method private runBoat()V
    .registers 5

    .prologue
    const/4 v3, -0x1

    .line 4056
    iget-byte v0, p0, Lmain/Map;->boatSelect:B

    if-eq v0, v3, :cond_11

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->ix:B

    if-ne v0, v3, :cond_11

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->iy:B

    if-eq v0, v3, :cond_12

    .line 4071
    :cond_11
    :goto_11
    return-void

    .line 4057
    :cond_12
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0x9

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 4058
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v1, v0, Lmain/GameRun;->cur_a:B

    add-int/lit8 v1, v1, 0x2

    int-to-byte v1, v1

    iput-byte v1, v0, Lmain/GameRun;->cur_a:B

    iget-object v0, p0, Lmain/Map;->boatCourse:[[B

    iget-byte v2, p0, Lmain/Map;->boatSelect:B

    aget-object v0, v0, v2

    array-length v0, v0

    if-lt v1, v0, :cond_37

    .line 4059
    iput-byte v3, p0, Lmain/Map;->boatSelect:B

    .line 4060
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v1, 0x0

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 4061
    iput-byte v3, p0, Lmain/Map;->anole_type:B

    .line 4062
    invoke-virtual {p0}, Lmain/Map;->setAnole()V

    goto :goto_11

    .line 4064
    :cond_37
    iget-object v0, p0, Lmain/Map;->door:[[B

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->x:S

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v2, Ldm/Npc;->y:S

    invoke-direct {p0, v0, v1, v2}, Lmain/Map;->checkIfOther([[BII)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->checkType:B

    .line 4065
    iget-byte v0, p0, Lmain/Map;->checkType:B

    if-eq v0, v3, :cond_54

    .line 4066
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v1, 0x5

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 4067
    iget-byte v0, p0, Lmain/Map;->checkType:B

    iput-byte v0, p0, Lmain/Map;->get_meet:B

    .line 4069
    :cond_54
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v1, p0, Lmain/Map;->boatCourse:[[B

    iget-byte v2, p0, Lmain/Map;->boatSelect:B

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->cur_a:B

    aget-byte v1, v1, v2

    iget-object v2, p0, Lmain/Map;->boatCourse:[[B

    iget-byte v3, p0, Lmain/Map;->boatSelect:B

    aget-object v2, v2, v3

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->cur_a:B

    add-int/lit8 v3, v3, 0x1

    aget-byte v2, v2, v3

    invoke-virtual {v0, v1, v2}, Ldm/Npc;->setIXY(II)V

    goto :goto_11
.end method

.method private runEvent_brow(I)V
    .registers 9
    .param p1, "i"    # I

    .prologue
    const/4 v6, 0x6

    const/4 v5, 0x1

    const/4 v3, -0x1

    const/4 v4, 0x0

    .line 1278
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x2

    aget-byte v1, v1, v2

    sub-int v0, v1, v5

    .line 1279
    .local v0, "event_temp":I
    if-ne v0, v3, :cond_4d

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    sput-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    .line 1281
    :goto_18
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x4

    aget-byte v1, v1, v2

    if-nez v1, :cond_5e

    .line 1282
    sget-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v2, p0, Lmain/Map;->event:[[B

    aget-object v2, v2, p1

    iget-object v3, p0, Lmain/Map;->event_now:[S

    aget-short v3, v3, p1

    add-int/lit8 v3, v3, 0x3

    aget-byte v2, v2, v3

    iput-byte v2, v1, Ldm/Npc;->brow_type:B

    .line 1283
    sget-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    iput-byte v4, v1, Ldm/Npc;->brow_action:B

    .line 1284
    sget-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    iput-byte v4, v1, Ldm/Npc;->brow_time:B

    .line 1291
    :cond_3e
    :goto_3e
    iget-object v1, p0, Lmain/Map;->event_now:[S

    aget-short v2, v1, p1

    add-int/lit8 v2, v2, 0x5

    int-to-short v2, v2

    aput-short v2, v1, p1

    .line 1292
    const/16 v1, 0x1010

    invoke-direct {p0, v1}, Lmain/Map;->nextEvent(I)V

    .line 1293
    return-void

    .line 1280
    :cond_4d
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    invoke-direct {p0, v0}, Lmain/Map;->getNpcLayer(I)B

    move-result v2

    aget-object v1, v1, v2

    invoke-direct {p0, v0}, Lmain/Map;->getNpcId(I)B

    move-result v2

    aget-object v1, v1, v2

    sput-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    goto :goto_18

    .line 1285
    :cond_5e
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x4

    aget-byte v1, v1, v2

    if-ne v1, v5, :cond_7f

    .line 1286
    sget-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v1, v1, Ldm/Npc;->other:[B

    iget-object v2, p0, Lmain/Map;->event:[[B

    aget-object v2, v2, p1

    iget-object v3, p0, Lmain/Map;->event_now:[S

    aget-short v3, v3, p1

    add-int/lit8 v3, v3, 0x3

    aget-byte v2, v2, v3

    aput-byte v2, v1, v6

    goto :goto_3e

    .line 1287
    :cond_7f
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x4

    aget-byte v1, v1, v2

    const/4 v2, 0x2

    if-ne v1, v2, :cond_3e

    .line 1288
    sget-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    iput-byte v3, v1, Ldm/Npc;->brow_type:B

    .line 1289
    sget-object v1, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v1, v1, Ldm/Npc;->other:[B

    aput-byte v4, v1, v6

    goto :goto_3e
.end method

.method private runEvent_dialog(I)V
    .registers 11
    .param p1, "i"    # I

    .prologue
    const/4 v4, 0x2

    const/4 v3, -0x1

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 1466
    iput-byte v3, p0, Lmain/Map;->checkNpcT:B

    .line 1468
    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-nez v1, :cond_af

    .line 1469
    iput-byte v7, p0, Lmain/Map;->eventGoing:B

    .line 1470
    iget-byte v1, p0, Lmain/Map;->anole_type:B

    if-ne v1, v7, :cond_13

    invoke-virtual {p0}, Lmain/Map;->setAnole()V

    .line 1471
    :cond_13
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x2

    aget-byte v1, v1, v2

    sub-int v0, v1, v7

    .line 1472
    .local v0, "event_temp":I
    if-ne v0, v3, :cond_7c

    .line 1473
    const-string v1, "\u585e\u5176"

    iput-object v1, p0, Lmain/Map;->npcName:Ljava/lang/String;

    .line 1474
    iput-byte v8, p0, Lmain/Map;->now_eV2:B

    .line 1484
    :goto_29
    iget-object v1, p0, Lmain/Map;->npcName:Ljava/lang/String;

    invoke-virtual {p0, v1}, Lmain/Map;->initNpcFaceOne(Ljava/lang/String;)V

    .line 1486
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v1, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v2, 0x16

    invoke-virtual {v1, v2}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 1487
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    iget-object v3, p0, Lmain/Map;->event:[[B

    aget-object v3, v3, p1

    iget-object v4, p0, Lmain/Map;->event_now:[S

    aget-short v4, v4, p1

    add-int/lit8 v4, v4, 0x5

    iget-object v5, p0, Lmain/Map;->event:[[B

    aget-object v5, v5, p1

    iget-object v6, p0, Lmain/Map;->event_now:[S

    aget-short v6, v6, p1

    add-int/lit8 v6, v6, 0x4

    aget-byte v5, v5, v6

    invoke-virtual {v2, v3, v4, v5}, Ldm/Ms;->getDialogs([BII)Ljava/lang/String;

    move-result-object v2

    sget v3, Lmain/Constants_H;->WIDTH__:I

    const/16 v4, 0x14

    sub-int/2addr v3, v4

    invoke-virtual {v1, v2, v3}, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;

    move-result-object v1

    iput-object v1, p0, Lmain/Map;->dialog:[Ljava/lang/StringBuffer;

    .line 1489
    iget-boolean v1, p0, Lmain/Map;->fontSizeControl:Z

    if-nez v1, :cond_73

    .line 1490
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v1, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v2, 0x1a

    invoke-virtual {v1, v2}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 1491
    :cond_73
    iput-byte v8, p0, Lmain/Map;->dialog_no:B

    .line 1492
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v7, v1, Ldm/Npc;->state:B

    .line 1493
    iput-boolean v8, p0, Lmain/Map;->bDirTalk:Z

    .line 1499
    .end local v0    # "event_temp":I
    :cond_7b
    :goto_7b
    return-void

    .line 1476
    .restart local v0    # "event_temp":I
    :cond_7c
    invoke-direct {p0, v0}, Lmain/Map;->getNpcLayer(I)B

    move-result v1

    iput-byte v1, p0, Lmain/Map;->now_eV1:B

    .line 1477
    invoke-direct {p0, v0}, Lmain/Map;->getNpcId(I)B

    move-result v1

    iput-byte v1, p0, Lmain/Map;->now_eV2:B

    .line 1478
    iget-object v1, p0, Lmain/Map;->npcNameData:[Ljava/lang/String;

    iget-byte v2, p0, Lmain/Map;->now_eV2:B

    aget-object v1, v1, v2

    iput-object v1, p0, Lmain/Map;->npcName:Ljava/lang/String;

    .line 1479
    iget-object v1, p0, Lmain/Map;->npcName:Ljava/lang/String;

    const-string v2, "\u8def\u4eba"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9d

    const/4 v1, 0x0

    iput-object v1, p0, Lmain/Map;->npcName:Ljava/lang/String;

    .line 1480
    :cond_9d
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    iget-byte v2, p0, Lmain/Map;->now_eV1:B

    aget-object v1, v1, v2

    iget-byte v2, p0, Lmain/Map;->now_eV2:B

    aget-object v1, v1, v2

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v4

    iput-byte v1, p0, Lmain/Map;->now_eV2:B

    goto/16 :goto_29

    .line 1494
    .end local v0    # "event_temp":I
    :cond_af
    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-ne v1, v4, :cond_7b

    .line 1495
    iget-object v1, p0, Lmain/Map;->event_now:[S

    aget-short v2, v1, p1

    iget-object v3, p0, Lmain/Map;->event:[[B

    aget-object v3, v3, p1

    iget-object v4, p0, Lmain/Map;->event_now:[S

    aget-short v4, v4, p1

    add-int/lit8 v4, v4, 0x4

    aget-byte v3, v3, v4

    shl-int/lit8 v3, v3, 0x1

    add-int/lit8 v3, v3, 0x5

    add-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v1, p1

    .line 1496
    const/16 v1, 0x1111

    invoke-direct {p0, v1}, Lmain/Map;->nextEvent(I)V

    goto :goto_7b
.end method

.method private runEvent_getMon(I)V
    .registers 9
    .param p1, "i"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v5, -0x1

    .line 1260
    const/4 v0, 0x0

    iput-boolean v0, p0, Lmain/Map;->gmErr:Z

    .line 1261
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x2

    aget-byte v1, v1, v2

    iget-object v2, p0, Lmain/Map;->event:[[B

    aget-object v2, v2, p1

    iget-object v3, p0, Lmain/Map;->event_now:[S

    aget-short v3, v3, p1

    add-int/lit8 v3, v3, 0x3

    aget-byte v2, v2, v3

    .line 1262
    iget-object v3, p0, Lmain/Map;->event:[[B

    aget-object v3, v3, p1

    iget-object v4, p0, Lmain/Map;->event_now:[S

    aget-short v4, v4, p1

    add-int/lit8 v4, v4, 0x4

    aget-byte v3, v3, v4

    .line 1261
    invoke-virtual {v0, v1, v2, v3, v5}, Lmain/GameRun;->getMonster(IIII)B

    move-result v0

    if-ne v0, v5, :cond_49

    .line 1263
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v1, "\u5ba0\u7269\u7a7a\u95f4\u5df2\u6ee1\uff0c\u65e0\u6cd5\u83b7\u5f97\u65b0\u7684\u5ba0\u7269\uff0c\u8bf7\u6574\u7406\u5bc4\u5b58\u6240\u7a7a\u51fa\u4e00\u4e2a\u7a7a\u95f4\u3002"

    invoke-virtual {v0, v1, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1264
    iput-boolean v6, p0, Lmain/Map;->gmErr:Z

    .line 1265
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v1, 0x6

    iput-byte v1, v0, Lmain/GameRun;->mini_state:B

    .line 1266
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v6, v0, Lmain/GameRun;->view_state:B

    .line 1267
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->goVIEW_MONSTER()V

    .line 1272
    :goto_48
    return-void

    .line 1269
    :cond_49
    iget-object v0, p0, Lmain/Map;->event_now:[S

    aget-short v1, v0, p1

    iget-object v2, p0, Lmain/Map;->event:[[B

    aget-object v2, v2, p1

    iget-object v3, p0, Lmain/Map;->event_now:[S

    aget-short v3, v3, p1

    add-int/lit8 v3, v3, 0x1

    aget-byte v2, v2, v3

    add-int/lit8 v2, v2, 0x2

    add-int/2addr v1, v2

    int-to-short v1, v1

    aput-short v1, v0, p1

    .line 1270
    const/16 v0, 0x1110

    invoke-direct {p0, v0}, Lmain/Map;->nextEvent(I)V

    goto :goto_48
.end method

.method private runEvent_goShop(I)V
    .registers 11
    .param p1, "i"    # I

    .prologue
    const/4 v4, 0x2

    const/16 v8, 0x10

    const/4 v7, 0x4

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1324
    iget-object v2, p0, Lmain/Map;->event:[[B

    aget-object v2, v2, p1

    iget-object v3, p0, Lmain/Map;->event_now:[S

    aget-short v3, v3, p1

    add-int/lit8 v3, v3, 0x3

    aget-byte v1, v2, v3

    .line 1325
    .local v1, "event_temp":I
    if-ne v1, v7, :cond_9d

    .line 1326
    iget-byte v2, p0, Lmain/Map;->inShop:B

    if-nez v2, :cond_5c

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->state:B

    if-eq v2, v8, :cond_5c

    .line 1327
    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v8, v2, Ldm/Npc;->state:B

    .line 1328
    iput-byte v6, p0, Lmain/Map;->inShop:B

    .line 1329
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-array v3, v4, [Ljava/lang/String;

    const-string v4, "\u56de\u590d"

    aput-object v4, v3, v5

    const-string v4, "\u4e0d\u56de\u590d"

    aput-object v4, v3, v6

    invoke-virtual {v2, v3}, Lmain/GameRun;->setAction_str([Ljava/lang/String;)V

    .line 1330
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v5, v2, Lmain/GameRun;->popMenu:B

    .line 1331
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput v5, v2, Lmain/GameRun;->sell_money:I

    .line 1333
    const/4 v0, 0x0

    .line 1334
    .local v0, "d":B
    :goto_3c
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->myMon_length:B

    if-lt v0, v2, :cond_43

    .line 1366
    .end local v0    # "d":B
    :cond_42
    :goto_42
    return-void

    .line 1335
    .restart local v0    # "d":B
    :cond_43
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v3, v2, Lmain/GameRun;->sell_money:I

    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, v0

    iget-object v4, v4, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v7

    mul-int/lit8 v4, v4, 0x14

    add-int/lit8 v4, v4, 0x28

    add-int/2addr v3, v4

    iput v3, v2, Lmain/GameRun;->sell_money:I

    .line 1334
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    goto :goto_3c

    .line 1337
    .end local v0    # "d":B
    :cond_5c
    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->state:B

    if-nez v2, :cond_42

    .line 1338
    iget-byte v2, p0, Lmain/Map;->inShop:B

    if-ne v2, v6, :cond_88

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->popMenu:B

    if-nez v2, :cond_88

    .line 1339
    iput-byte v4, p0, Lmain/Map;->inShop:B

    .line 1340
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v2}, Lmain/GameRun;->checkMonster()Z

    move-result v2

    if-nez v2, :cond_42

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v3, v3, Lmain/GameRun;->sell_money:I

    invoke-virtual {v2, v3, v6}, Lmain/GameRun;->isMoney(IZ)Z

    move-result v2

    if-eqz v2, :cond_42

    .line 1341
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v2, v6}, Lmain/GameRun;->healMonster(Z)V

    goto :goto_42

    .line 1342
    :cond_88
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->say_c:B

    if-nez v2, :cond_42

    .line 1343
    iput-byte v5, p0, Lmain/Map;->inShop:B

    .line 1344
    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v3, v2, p1

    add-int/lit8 v3, v3, 0x4

    int-to-short v3, v3

    aput-short v3, v2, p1

    .line 1345
    invoke-direct {p0, v5}, Lmain/Map;->nextEvent(I)V

    goto :goto_42

    .line 1349
    :cond_9d
    const/4 v2, 0x3

    if-ge v1, v2, :cond_be

    .line 1350
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, p0, Lmain/Map;->event:[[B

    aget-object v3, v3, p1

    iget-object v4, p0, Lmain/Map;->event_now:[S

    aget-short v4, v4, p1

    add-int/lit8 v4, v4, 0x2

    aget-byte v3, v3, v4

    invoke-virtual {v2, v3, v1}, Lmain/GameRun;->goBUY_ITEM(II)V

    .line 1363
    :cond_b1
    :goto_b1
    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v3, v2, p1

    add-int/lit8 v3, v3, 0x4

    int-to-short v3, v3

    aput-short v3, v2, p1

    .line 1364
    invoke-direct {p0, v8}, Lmain/Map;->nextEvent(I)V

    goto :goto_42

    .line 1351
    :cond_be
    const/4 v2, 0x3

    if-ne v1, v2, :cond_c7

    .line 1352
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v2, v5}, Lmain/GameRun;->goVIEW_COMPUTER(I)V

    goto :goto_b1

    .line 1354
    :cond_c7
    const/4 v2, 0x5

    if-ne v1, v2, :cond_d0

    .line 1355
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v2, v5}, Lmain/GameRun;->goNidus(I)V

    goto :goto_b1

    .line 1357
    :cond_d0
    const/4 v2, 0x6

    if-ne v1, v2, :cond_dd

    .line 1358
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v7, v2, Lmain/GameRun;->view_state:B

    .line 1359
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v3, -0x1

    iput-byte v3, v2, Lmain/GameRun;->popMenu:B

    goto :goto_b1

    .line 1360
    :cond_dd
    const/4 v2, 0x7

    if-ne v1, v2, :cond_b1

    .line 1361
    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v6, v2, Lmain/GameRun;->view_state:B

    goto :goto_b1
.end method

.method private runEvent_item_add_del(I)V
    .registers 9
    .param p1, "i"    # I

    .prologue
    const/4 v6, 0x0

    const/4 v4, -0x1

    const/4 v5, 0x1

    .line 1440
    const/4 v0, 0x0

    .line 1441
    .local v0, "event_temp":I
    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-nez v1, :cond_a9

    .line 1442
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x2

    aget-byte v1, v1, v2

    iput-byte v1, p0, Lmain/Map;->now_eV1:B

    .line 1443
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x3

    aget-byte v1, v1, v2

    iput-byte v1, p0, Lmain/Map;->now_eV2:B

    .line 1444
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x3

    aget-byte v1, v1, v2

    if-ltz v1, :cond_78

    .line 1445
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, p0, Lmain/Map;->now_eV1:B

    iget-byte v3, p0, Lmain/Map;->now_eV2:B

    invoke-virtual {v1, v2, v3}, Lmain/GameRun;->addItem(II)B

    move-result v0

    .line 1454
    :goto_3c
    if-eq v0, v4, :cond_75

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    iget-byte v3, p0, Lmain/Map;->now_eV2:B

    if-ltz v3, :cond_a6

    const-string v3, "\u83b7\u5f97\uff1a"

    :goto_48
    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1455
    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v4, p0, Lmain/Map;->now_eV1:B

    invoke-virtual {v3, v4}, Lmain/GameRun;->getNameItem(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "x"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v3, p0, Lmain/Map;->now_eV2:B

    invoke-static {v3}, Ldm/Ms;->abs(I)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 1454
    invoke-virtual {v1, v2, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1456
    :cond_75
    iput-byte v5, p0, Lmain/Map;->eventGoing:B

    .line 1464
    :cond_77
    :goto_77
    return-void

    .line 1447
    :cond_78
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v2, -0x2

    iget-byte v3, p0, Lmain/Map;->now_eV1:B

    invoke-virtual {v1, v2, v3, v5}, Lmain/GameRun;->findItem(IIZ)B

    move-result v1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v2, p0, Lmain/Map;->now_eV2:B

    invoke-static {v2}, Ldm/Ms;->abs(I)I

    move-result v2

    if-lt v1, v2, :cond_9d

    .line 1448
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, p0, Lmain/Map;->now_eV1:B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v3, p0, Lmain/Map;->now_eV2:B

    invoke-static {v3}, Ldm/Ms;->abs(I)I

    move-result v3

    invoke-virtual {v1, v2, v3}, Lmain/GameRun;->deleteItems(II)V

    goto :goto_3c

    .line 1450
    :cond_9d
    const/4 v0, -0x1

    .line 1451
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v2, "\u9053\u5177\u4e0d\u8db3\uff01"

    invoke-virtual {v1, v2, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_3c

    .line 1454
    :cond_a6
    const-string v3, "\u5931\u53bb\uff1a"

    goto :goto_48

    .line 1457
    :cond_a9
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->say_c:B

    if-nez v1, :cond_77

    .line 1458
    if-ne v0, v4, :cond_b5

    invoke-direct {p0, p1, v5}, Lmain/Map;->setEventNow(IZ)V

    goto :goto_77

    .line 1460
    :cond_b5
    iget-object v1, p0, Lmain/Map;->event_now:[S

    aget-short v2, v1, p1

    add-int/lit8 v2, v2, 0x4

    int-to-short v2, v2

    aput-short v2, v1, p1

    .line 1461
    const/16 v1, 0x1110

    invoke-direct {p0, v1}, Lmain/Map;->nextEvent(I)V

    goto :goto_77
.end method

.method private runEvent_miniGame_myLevel(I)V
    .registers 11
    .param p1, "i"    # I

    .prologue
    const/4 v8, 0x1

    const/4 v3, 0x2

    const/4 v7, -0x1

    const/4 v6, 0x3

    const/4 v5, 0x0

    .line 1368
    iget-object v1, p0, Lmain/Map;->event:[[B

    aget-object v1, v1, p1

    iget-object v2, p0, Lmain/Map;->event_now:[S

    aget-short v2, v2, p1

    add-int/lit8 v2, v2, 0x2

    aget-byte v0, v1, v2

    .line 1369
    .local v0, "event_temp":I
    if-le v0, v8, :cond_22

    .line 1379
    iget-object v1, p0, Lmain/Map;->event_now:[S

    aget-short v2, v1, p1

    add-int/lit8 v2, v2, 0x3

    int-to-short v2, v2

    aput-short v2, v1, p1

    .line 1380
    const/16 v1, 0x1110

    invoke-direct {p0, v1}, Lmain/Map;->nextEvent(I)V

    .line 1438
    :cond_21
    :goto_21
    return-void

    .line 1382
    :cond_22
    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-ge v1, v3, :cond_148

    .line 1383
    if-nez v0, :cond_d6

    .line 1384
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->magic_id:B

    const/4 v2, -0x2

    if-ne v1, v2, :cond_91

    .line 1385
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->rmsOther:[B

    aget-byte v1, v1, v6

    const/4 v2, 0x5

    if-ne v1, v2, :cond_47

    .line 1386
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v2, -0x2

    iput-byte v2, v1, Lmain/GameRun;->magic_id:B

    .line 1387
    iput-byte v3, p0, Lmain/Map;->eventGoing:B

    .line 1388
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v2, "\u60a8\u5f53\u524d\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u8fbe\u5230\u4e0a\u9650\uff01"

    invoke-virtual {v1, v2, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_21

    .line 1390
    :cond_47
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v2, v8}, Lmain/GameRun;->isMyLevel(Z)B

    move-result v2

    iput v2, v1, Lmain/GameRun;->sell_money:I

    .line 1391
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v1, v1, Lmain/GameRun;->sell_money:I

    if-ne v1, v7, :cond_8e

    .line 1392
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v2, 0xa

    iput-byte v2, v1, Ldm/Npc;->state:B

    .line 1393
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x1c

    iput-byte v2, v1, Lmain/GameRun;->magic_id:B

    .line 1394
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v2, p0, Lmain/Map;->map_x:I

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v3, v3, Ldm/Npc;->x:S

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0xa

    iput v2, v1, Lmain/GameRun;->magic_x:I

    .line 1395
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v2, p0, Lmain/Map;->map_y:I

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v3, v3, Ldm/Npc;->y:S

    add-int/2addr v2, v3

    add-int/lit8 v2, v2, 0x13

    iput v2, v1, Lmain/GameRun;->magic_y:I

    .line 1396
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->magic_id:B

    div-int/lit8 v2, v2, 0x5

    invoke-virtual {v1, v2}, Lmain/GameRun;->setMagic(I)V

    .line 1397
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v1, v5}, Lmain/GameRun;->setMaxTakes(Z)V

    goto :goto_21

    .line 1399
    :cond_8e
    iput-byte v3, p0, Lmain/Map;->eventGoing:B

    goto :goto_21

    .line 1402
    :cond_91
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->magic_id:B

    if-ne v1, v7, :cond_21

    .line 1403
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v2, -0x2

    iput-byte v2, v1, Lmain/GameRun;->magic_id:B

    .line 1404
    iput-byte v3, p0, Lmain/Map;->eventGoing:B

    .line 1405
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u606d\u559c\u60a8\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u63d0\u5347\u4e3a#7"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->rmsOther:[B

    aget-byte v3, v3, v6

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#0\uff0c\u60a8\u968f\u8eab\u53ef\u643a\u5e26\u5ba0\u7269\u6570\u91cf#7\u66b4\u589e\u5230"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->max_takes:B

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#0\uff0c\u60a8\u5546\u5e97\u80fd\u5b58\u653e\u7684\u5ba0\u7269#7\u66b4\u589e\u5230"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->max_monsters:B

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_21

    .line 1407
    :cond_d6
    if-ne v0, v8, :cond_21

    .line 1408
    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-nez v1, :cond_f5

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->monInfoList:[B

    const/16 v2, 0x68

    aget-byte v1, v1, v2

    if-nez v1, :cond_f5

    .line 1409
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput v5, v1, Lmain/GameRun;->sell_money:I

    .line 1410
    iput-byte v6, p0, Lmain/Map;->eventGoing:B

    .line 1411
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v2, "\u6b64\u6b21\u60a8\u6ca1\u6709\u6355\u83b7\u5230\u5168\u65b0\u7684\u5ba0\u7269\uff0c\u6355\u83b7\u5e76\u4e0d\u662f\u552f\u4e00\u9014\u5f84\uff0c\u6709\u4e9b\u5ba0\u7269\u9700\u8981\u901a\u8fc7\u8fdb\u5316\u624d\u80fd\u83b7\u5f97\u54e6\u3002"

    invoke-virtual {v1, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_21

    .line 1412
    :cond_f5
    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-nez v1, :cond_21

    .line 1413
    iput-byte v6, p0, Lmain/Map;->eventGoing:B

    .line 1414
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->monInfoList:[B

    const/16 v3, 0x68

    aget-byte v2, v2, v3

    iput v2, v1, Lmain/GameRun;->sell_money:I

    .line 1415
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->monInfoList:[B

    const/16 v2, 0x68

    aput-byte v5, v1, v2

    .line 1416
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u6b64\u6b21\u60a8\u6355\u83b7\u4e86"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v3, v3, Lmain/GameRun;->sell_money:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\u4e2a\u65b0\u5ba0\u7269\uff0c\u8fd9\u91cc\u662f\u738b\u56fd\u8bad\u7ec3\u5e08\u673a\u6784\u5956\u52b1\u7ed9\u60a8\u7684"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v3, v3, Lmain/GameRun;->sell_money:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\u4e2a\u5fbd\u7ae0\uff0c\u5e0c\u671b\u518d\u63a5\u518d\u5389\u54e6\u3002"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1417
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v2, v1, Lmain/GameRun;->coin:I

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v3, v3, Lmain/GameRun;->sell_money:I

    add-int/2addr v2, v3

    iput v2, v1, Lmain/GameRun;->coin:I

    goto/16 :goto_21

    .line 1420
    :cond_148
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->say_c:B

    if-nez v1, :cond_21

    .line 1421
    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-ne v1, v3, :cond_1b4

    .line 1422
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->rmsOther:[B

    aget-byte v1, v1, v6

    const/4 v2, 0x5

    if-ne v1, v2, :cond_167

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v2, "\u60a8\u5f53\u524d\u7684\u8bad\u7ec3\u5e08\u7b49\u7ea7\u5df2\u8fbe\u5230\u4e0a\u9650\uff01"

    invoke-virtual {v1, v2, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1428
    :goto_162
    const/4 v1, 0x4

    iput-byte v1, p0, Lmain/Map;->eventGoing:B

    goto/16 :goto_21

    .line 1424
    :cond_167
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v2, v5}, Lmain/GameRun;->isMyLevel(Z)B

    move-result v2

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->monInfoList:[B

    const/16 v4, 0x67

    aget-byte v3, v3, v4

    sub-int/2addr v2, v3

    int-to-byte v2, v2

    iput v2, v1, Lmain/GameRun;->sell_money:I

    .line 1425
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v1, v1, Lmain/GameRun;->sell_money:I

    if-ge v1, v8, :cond_185

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput v5, v1, Lmain/GameRun;->sell_money:I

    .line 1426
    :cond_185
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u5f53\u524d\u8bad\u7ec3\u5e08\u7b49\u7ea7\u4e3a#7"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->rmsOther:[B

    aget-byte v3, v3, v6

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#0\u8ddd\u79bb\u4e0b\u6b21\u5347\u7ea7\u8fd8\u9700\u8981\u6355\u6349#7"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v3, v3, Lmain/GameRun;->sell_money:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#0\u53ea\u4e0d\u540c\u7684\u5ba0\u7269\uff0c\u52aa\u529b\u83b7\u5f97\u65b0\u5ba0\u5427\u3002"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_162

    .line 1429
    :cond_1b4
    iget-byte v1, p0, Lmain/Map;->eventGoing:B

    if-ne v1, v6, :cond_1db

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v1, v1, Lmain/GameRun;->sell_money:I

    if-lez v1, :cond_1db

    .line 1430
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u83b7\u5f97\uff1a\u5fbd\u7ae0x"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v3, v3, Lmain/GameRun;->sell_money:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v5}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1431
    const/4 v1, 0x4

    iput-byte v1, p0, Lmain/Map;->eventGoing:B

    goto/16 :goto_21

    .line 1433
    :cond_1db
    iget-object v1, p0, Lmain/Map;->event_now:[S

    aget-short v2, v1, p1

    add-int/lit8 v2, v2, 0x3

    int-to-short v2, v2

    aput-short v2, v1, p1

    .line 1434
    const/16 v1, 0x1110

    invoke-direct {p0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_21
.end method

.method private runEvent_select(I)V
    .registers 13
    .param p1, "i"    # I

    .prologue
    .line 1502
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->state:B

    const/16 v5, 0xc

    if-eq v4, v5, :cond_ad

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->state:B

    const/16 v5, 0xd

    if-eq v4, v5, :cond_ad

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->state:B

    const/16 v5, 0xe

    if-eq v4, v5, :cond_ad

    .line 1504
    iget-object v4, p0, Lmain/Map;->event:[[B

    aget-object v4, v4, p1

    iget-object v5, p0, Lmain/Map;->event_now:[S

    aget-short v5, v5, p1

    add-int/lit8 v5, v5, 0x1

    aget-byte v4, v4, v5

    iput-byte v4, p0, Lmain/Map;->sEvent_eV2:B

    .line 1505
    const/4 v4, 0x0

    iput-byte v4, p0, Lmain/Map;->sEvent_eV1:B

    .line 1506
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v5, 0x0

    iput-object v5, v4, Lmain/GameRun;->action_str:[Ljava/lang/String;

    .line 1507
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v5, p0, Lmain/Map;->sEvent_eV2:B

    new-array v5, v5, [Ljava/lang/String;

    iput-object v5, v4, Lmain/GameRun;->action_str:[Ljava/lang/String;

    .line 1508
    const/4 v3, 0x0

    .local v3, "j":B
    :goto_37
    iget-byte v4, p0, Lmain/Map;->sEvent_eV2:B

    if-lt v3, v4, :cond_58

    .line 1513
    iget-byte v4, p0, Lmain/Map;->sIfElse:B

    const/4 v5, -0x1

    if-eq v4, v5, :cond_a1

    .line 1514
    const/4 v4, 0x1

    iput-byte v4, p0, Lmain/Map;->event_state:B

    .line 1515
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v5, p0, Lmain/Map;->sIfElse:B

    iput-byte v5, v4, Lmain/GameRun;->cur_a:B

    .line 1516
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v5, 0xd

    iput-byte v5, v4, Ldm/Npc;->state:B

    .line 1517
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v5, 0x0

    iput-object v5, v4, Lmain/GameRun;->action_str:[Ljava/lang/String;

    .line 1518
    const/4 v4, -0x1

    iput-byte v4, p0, Lmain/Map;->sIfElse:B

    .line 1535
    .end local v3    # "j":B
    :cond_57
    :goto_57
    return-void

    .line 1509
    .restart local v3    # "j":B
    :cond_58
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->action_str:[Ljava/lang/String;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    iget-object v6, p0, Lmain/Map;->event:[[B

    aget-object v6, v6, p1

    .line 1510
    iget-object v7, p0, Lmain/Map;->event_now:[S

    aget-short v7, v7, p1

    add-int/lit8 v7, v7, 0x2

    iget-byte v8, p0, Lmain/Map;->sEvent_eV1:B

    add-int/2addr v7, v8

    add-int/lit8 v7, v7, 0x1

    iget-object v8, p0, Lmain/Map;->event:[[B

    aget-object v8, v8, p1

    iget-object v9, p0, Lmain/Map;->event_now:[S

    aget-short v9, v9, p1

    add-int/lit8 v9, v9, 0x2

    iget-byte v10, p0, Lmain/Map;->sEvent_eV1:B

    add-int/2addr v9, v10

    aget-byte v8, v8, v9

    .line 1509
    invoke-virtual {v5, v6, v7, v8}, Ldm/Ms;->getDialogs([BII)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v3

    .line 1511
    iget-byte v4, p0, Lmain/Map;->sEvent_eV1:B

    iget-object v5, p0, Lmain/Map;->event:[[B

    aget-object v5, v5, p1

    iget-object v6, p0, Lmain/Map;->event_now:[S

    aget-short v6, v6, p1

    add-int/lit8 v6, v6, 0x2

    iget-byte v7, p0, Lmain/Map;->sEvent_eV1:B

    add-int/2addr v6, v7

    aget-byte v5, v5, v6

    shl-int/lit8 v5, v5, 0x1

    add-int/lit8 v5, v5, 0x1

    add-int/2addr v4, v5

    int-to-byte v4, v4

    iput-byte v4, p0, Lmain/Map;->sEvent_eV1:B

    .line 1508
    add-int/lit8 v4, v3, 0x1

    int-to-byte v3, v4

    goto :goto_37

    .line 1520
    :cond_a1
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v5, 0x0

    iput-byte v5, v4, Lmain/GameRun;->cur_a:B

    .line 1521
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v5, 0xc

    iput-byte v5, v4, Ldm/Npc;->state:B

    goto :goto_57

    .line 1524
    .end local v3    # "j":B
    :cond_ad
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->state:B

    const/16 v5, 0xd

    if-ne v4, v5, :cond_105

    .line 1525
    iget-byte v4, p0, Lmain/Map;->sEvent_eV1:B

    add-int/lit8 v4, v4, 0x2

    int-to-byte v4, v4

    iput-byte v4, p0, Lmain/Map;->sEvent_eV1:B

    .line 1526
    iget-object v4, p0, Lmain/Map;->event:[[B

    aget-object v4, v4, p1

    iget-object v5, p0, Lmain/Map;->event_now:[S

    aget-short v5, v5, p1

    iget-byte v6, p0, Lmain/Map;->sEvent_eV1:B

    add-int/2addr v5, v6

    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v6, v6, Lmain/GameRun;->cur_a:B

    shl-int/lit8 v6, v6, 0x1

    add-int/2addr v5, v6

    aget-byte v0, v4, v5

    .line 1527
    .local v0, "a":B
    iget-object v4, p0, Lmain/Map;->event:[[B

    aget-object v4, v4, p1

    iget-object v5, p0, Lmain/Map;->event_now:[S

    aget-short v5, v5, p1

    iget-byte v6, p0, Lmain/Map;->sEvent_eV1:B

    add-int/2addr v5, v6

    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v6, v6, Lmain/GameRun;->cur_a:B

    shl-int/lit8 v6, v6, 0x1

    add-int/2addr v5, v6

    add-int/lit8 v5, v5, 0x1

    aget-byte v1, v4, v5

    .line 1528
    .local v1, "b":B
    and-int/lit16 v4, v0, 0xff

    shl-int/lit8 v4, v4, 0x8

    and-int/lit16 v5, v1, 0xff

    or-int/2addr v4, v5

    int-to-short v2, v4

    .line 1529
    .local v2, "d":S
    iget-object v4, p0, Lmain/Map;->event_now:[S

    aget-short v5, v4, p1

    iget-byte v6, p0, Lmain/Map;->sEvent_eV1:B

    iget-byte v7, p0, Lmain/Map;->sEvent_eV2:B

    shl-int/lit8 v7, v7, 0x1

    add-int/2addr v6, v7

    add-int/2addr v6, v2

    add-int/2addr v5, v6

    int-to-short v5, v5

    aput-short v5, v4, p1

    .line 1530
    const/16 v4, 0x11

    invoke-direct {p0, v4}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_57

    .line 1531
    .end local v0    # "a":B
    .end local v1    # "b":B
    .end local v2    # "d":S
    :cond_105
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->state:B

    const/16 v5, 0xe

    if-ne v4, v5, :cond_57

    .line 1532
    const/4 v4, 0x1

    invoke-direct {p0, p1, v4}, Lmain/Map;->setEventNow(IZ)V

    goto/16 :goto_57
.end method

.method private runEvent_srcMove(I)V
    .registers 14
    .param p1, "i"    # I

    .prologue
    .line 1295
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0xa

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 1296
    iget-object v0, p0, Lmain/Map;->event:[[B

    aget-object v0, v0, p1

    iget-object v1, p0, Lmain/Map;->event_now:[S

    aget-short v1, v1, p1

    add-int/lit8 v1, v1, 0x2

    aget-byte v0, v0, v1

    const/4 v1, 0x1

    sub-int v9, v0, v1

    .line 1297
    .local v9, "event_temp":I
    const/4 v1, 0x0

    .local v1, "x":I
    const/4 v11, 0x0

    .line 1298
    .local v11, "y":I
    const/4 v0, -0x1

    if-ne v9, v0, :cond_73

    .line 1299
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v0}, Ldm/Npc;->getIx()B

    move-result v1

    .line 1300
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v0}, Ldm/Npc;->getIy()B

    move-result v11

    .line 1301
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/Map;->srcNpcNo:B

    .line 1309
    :goto_29
    const/16 v10, 0xa

    .line 1310
    .local v10, "step":B
    iget-short v2, p0, Lmain/Map;->cols:S

    sget-byte v3, Lmain/Constants_H;->XCELLS:B

    sget-byte v4, Lmain/Constants_H;->HALF_XCELLS:B

    sget v5, Lmain/Constants_H;->WIDTH:I

    const/16 v6, 0x14

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Lmain/Map;->map_set(IIIIII)I

    move-result v0

    iget v1, p0, Lmain/Map;->map_x:I

    .end local v1    # "x":I
    sub-int v1, v0, v1

    .line 1311
    .restart local v1    # "x":I
    iget-short v4, p0, Lmain/Map;->rows:S

    sget-byte v5, Lmain/Constants_H;->YCELLS:B

    sget-byte v6, Lmain/Constants_H;->HALF_YCELLS:B

    sget v7, Lmain/Constants_H;->HEIGHT:I

    const/16 v8, 0x14

    move-object v2, p0

    move v3, v11

    invoke-direct/range {v2 .. v8}, Lmain/Map;->map_set(IIIIII)I

    move-result v0

    iget v2, p0, Lmain/Map;->map_y:I

    sub-int v11, v0, v2

    .line 1313
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v11}, Ldm/Ms;->abs(I)I

    move-result v0

    if-ge v0, v10, :cond_a8

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v0

    if-ge v0, v10, :cond_a8

    .line 1314
    iget-object v0, p0, Lmain/Map;->event_now:[S

    aget-short v1, v0, p1

    .end local v1    # "x":I
    add-int/lit8 v1, v1, 0x3

    int-to-short v1, v1

    aput-short v1, v0, p1

    .line 1315
    const/16 v0, 0x1010

    invoke-direct {p0, v0}, Lmain/Map;->nextEvent(I)V

    .line 1322
    :cond_72
    :goto_72
    return-void

    .line 1303
    .end local v10    # "step":B
    .restart local v1    # "x":I
    :cond_73
    invoke-direct {p0, v9}, Lmain/Map;->getNpcLayer(I)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->now_eV1:B

    .line 1304
    invoke-direct {p0, v9}, Lmain/Map;->getNpcId(I)B

    move-result v0

    iput-byte v0, p0, Lmain/Map;->now_eV2:B

    .line 1305
    iget-byte v0, p0, Lmain/Map;->now_eV1:B

    if-nez v0, :cond_a6

    iget-byte v0, p0, Lmain/Map;->now_eV2:B

    :goto_85
    iput-byte v0, p0, Lmain/Map;->srcNpcNo:B

    .line 1306
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    iget-byte v1, p0, Lmain/Map;->now_eV1:B

    .end local v1    # "x":I
    aget-object v0, v0, v1

    iget-byte v1, p0, Lmain/Map;->now_eV2:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x0

    aget-byte v1, v0, v1

    .line 1307
    .restart local v1    # "x":I
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    iget-byte v2, p0, Lmain/Map;->now_eV1:B

    aget-object v0, v0, v2

    iget-byte v2, p0, Lmain/Map;->now_eV2:B

    aget-object v0, v0, v2

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v2, 0x1

    aget-byte v11, v0, v2

    goto :goto_29

    .line 1305
    :cond_a6
    const/4 v0, 0x0

    goto :goto_85

    .line 1317
    .restart local v10    # "step":B
    :cond_a8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v0

    if-lt v0, v10, :cond_bf

    .line 1318
    iget v0, p0, Lmain/Map;->map_x:I

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v1}, Ldm/Ms;->abs(I)I

    move-result v2

    div-int/2addr v1, v2

    .end local v1    # "x":I
    mul-int/2addr v1, v10

    add-int/2addr v0, v1

    iput v0, p0, Lmain/Map;->map_x:I

    .line 1319
    :cond_bf
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v11}, Ldm/Ms;->abs(I)I

    move-result v0

    if-lt v0, v10, :cond_72

    .line 1320
    iget v0, p0, Lmain/Map;->map_y:I

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static {v11}, Ldm/Ms;->abs(I)I

    move-result v1

    div-int v1, v11, v1

    mul-int/2addr v1, v10

    add-int/2addr v0, v1

    iput v0, p0, Lmain/Map;->map_y:I

    goto :goto_72
.end method

.method private runMove()V
    .registers 8

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x1

    const/4 v4, -0x1

    .line 3766
    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->ix:B

    if-ne v2, v4, :cond_f

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->iy:B

    if-eq v2, v4, :cond_22

    :cond_f
    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v3, 0x0

    invoke-direct {p0, v2, v3}, Lmain/Map;->runSeek(Ldm/Npc;Z)V

    .line 3768
    :goto_15
    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-direct {p0, v2, v4}, Lmain/Map;->oneMove(Ldm/Npc;I)V

    .line 3770
    const/4 v1, 0x0

    .line 3771
    .local v1, "j":B
    :goto_1b
    const/4 v2, 0x3

    if-lt v1, v2, :cond_26

    .line 3783
    invoke-virtual {p0}, Lmain/Map;->insertNpc()V

    .line 3784
    return-void

    .line 3767
    .end local v1    # "j":B
    :cond_22
    invoke-direct {p0}, Lmain/Map;->runBoat()V

    goto :goto_15

    .line 3772
    .restart local v1    # "j":B
    :cond_26
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_27
    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    array-length v2, v2

    if-lt v0, v2, :cond_32

    .line 3771
    add-int/lit8 v2, v1, 0x2

    int-to-byte v1, v2

    goto :goto_1b

    .line 3775
    :cond_32
    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    aget-byte v2, v2, v6

    if-eq v2, v5, :cond_4f

    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    aget-byte v2, v2, v6

    const/4 v3, 0x2

    if-eq v2, v3, :cond_4f

    .line 3772
    :goto_4b
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    goto :goto_27

    .line 3777
    :cond_4f
    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    const/16 v3, 0x8

    aget-byte v2, v2, v3

    const/4 v3, 0x5

    if-lt v2, v3, :cond_71

    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    invoke-direct {p0, v2, v0}, Lmain/Map;->runAutoMoveNpc(Ldm/Npc;I)V

    .line 3780
    :cond_67
    :goto_67
    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    invoke-direct {p0, v2, v0}, Lmain/Map;->oneMove(Ldm/Npc;I)V

    goto :goto_4b

    .line 3779
    :cond_71
    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    iget-byte v2, v2, Ldm/Npc;->ix:B

    if-ne v2, v4, :cond_85

    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    iget-byte v2, v2, Ldm/Npc;->iy:B

    if-eq v2, v4, :cond_67

    :cond_85
    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v1

    aget-object v2, v2, v0

    invoke-direct {p0, v2, v5}, Lmain/Map;->runSeek(Ldm/Npc;Z)V

    goto :goto_67
.end method

.method private runNpcAniOne([Ldm/Npc;I)V
    .registers 11
    .param p1, "npc"    # [Ldm/Npc;
    .param p2, "i"    # I

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 3681
    aget-object v3, p1, p2

    iget-object v3, v3, Ldm/Npc;->other:[B

    const/4 v4, 0x3

    aget-byte v3, v3, v4

    sub-int/2addr v3, v7

    int-to-byte v2, v3

    .line 3682
    .local v2, "type":B
    aget-object v3, p1, p2

    iget-object v3, v3, Ldm/Npc;->other:[B

    const/4 v4, 0x2

    aget-byte v1, v3, v4

    .line 3683
    .local v1, "id":B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    aget-object v3, p1, p2

    iget-object v3, v3, Ldm/Npc;->other:[B

    const/4 v4, 0x7

    aget-byte v3, v3, v4

    invoke-static {v3}, Ldm/Ms;->abs(I)I

    move-result v3

    int-to-byte v0, v3

    .line 3685
    .local v0, "action_id":B
    aget-object v3, p1, p2

    iget-byte v3, v3, Ldm/Npc;->now_action:B

    sget-object v4, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v4, v4, v2

    aget-object v4, v4, v1

    invoke-virtual {v4, v0}, Ldm/Sprite;->aLength(I)I

    move-result v4

    if-lt v3, v4, :cond_38

    .line 3686
    aget-object v3, p1, p2

    iput-byte v6, v3, Ldm/Npc;->now_action:B

    .line 3687
    invoke-direct {p0, p1, p2}, Lmain/Map;->setlastA([Ldm/Npc;I)Z

    .line 3689
    :cond_38
    aget-object v3, p1, p2

    iget-byte v4, v3, Ldm/Npc;->now_time:B

    add-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    iput-byte v4, v3, Ldm/Npc;->now_time:B

    sget-object v3, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v3, v3, v2

    aget-object v3, v3, v1

    aget-object v5, p1, p2

    iget-byte v5, v5, Ldm/Npc;->now_action:B

    invoke-virtual {v3, v0, v5, v7}, Ldm/Sprite;->action(III)I

    move-result v3

    if-lt v4, v3, :cond_5e

    .line 3690
    aget-object v3, p1, p2

    iget-byte v4, v3, Ldm/Npc;->now_action:B

    add-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    iput-byte v4, v3, Ldm/Npc;->now_action:B

    .line 3691
    aget-object v3, p1, p2

    iput-byte v6, v3, Ldm/Npc;->now_time:B

    .line 3693
    :cond_5e
    return-void
.end method

.method private runSeek(Ldm/Npc;Z)V
    .registers 12
    .param p1, "npc_"    # Ldm/Npc;
    .param p2, "b_who"    # Z

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v4, -0x1

    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 3870
    iget-boolean v0, p1, Ldm/Npc;->b_check:Z

    .line 3871
    .local v0, "bb":Z
    iget-byte v3, p1, Ldm/Npc;->ix:B

    mul-int/lit8 v3, v3, 0x14

    int-to-short v1, v3

    .line 3872
    .local v1, "x_":S
    iget-byte v3, p1, Ldm/Npc;->iy:B

    mul-int/lit8 v3, v3, 0x14

    int-to-short v2, v3

    .line 3873
    .local v2, "y_":S
    iget-short v3, p1, Ldm/Npc;->x:S

    if-ne v3, v1, :cond_47

    iget-short v3, p1, Ldm/Npc;->y:S

    if-ne v3, v2, :cond_47

    .line 3874
    iget-byte v3, p1, Ldm/Npc;->frame_c:B

    if-ne v3, v4, :cond_3d

    .line 3875
    iput-byte v4, p1, Ldm/Npc;->iy:B

    iput-byte v4, p1, Ldm/Npc;->ix:B

    .line 3876
    if-eqz p2, :cond_3e

    invoke-virtual {p1}, Ldm/Npc;->setIxIy_npc()V

    .line 3878
    :goto_26
    iget-boolean v3, p1, Ldm/Npc;->bdir:Z

    if-eqz v3, :cond_3d

    .line 3879
    iget-object v3, p1, Ldm/Npc;->other:[B

    const/4 v4, 0x7

    iget-byte v5, p1, Ldm/Npc;->lastAction:B

    aput-byte v5, v3, v4

    .line 3880
    iget-byte v3, p1, Ldm/Npc;->lastAction:B

    if-gez v3, :cond_45

    move v3, v8

    :goto_36
    iput-byte v3, p1, Ldm/Npc;->dir:B

    .line 3881
    const/16 v3, 0x7f

    invoke-virtual {p1, v6, v3}, Ldm/Npc;->setLastAction(ZI)V

    .line 3901
    :cond_3d
    :goto_3d
    return-void

    .line 3877
    :cond_3e
    invoke-virtual {p0}, Lmain/Map;->getMySpeed()B

    move-result v3

    iput-byte v3, p1, Ldm/Npc;->speed:B

    goto :goto_26

    :cond_45
    move v3, v7

    .line 3880
    goto :goto_36

    .line 3884
    :cond_47
    iget-byte v3, p1, Ldm/Npc;->frame_c:B

    if-ge v3, v5, :cond_3d

    .line 3885
    if-eqz v0, :cond_86

    iget-short v3, p1, Ldm/Npc;->x:S

    if-eq v3, v1, :cond_84

    move v0, v5

    .line 3887
    :goto_52
    if-eqz v0, :cond_9e

    .line 3888
    iget-short v3, p1, Ldm/Npc;->x:S

    if-le v3, v1, :cond_5f

    iget-short v3, p1, Ldm/Npc;->x:S

    iget-byte v4, p1, Ldm/Npc;->speed:B

    sub-int/2addr v3, v4

    if-lt v3, v1, :cond_6a

    :cond_5f
    iget-short v3, p1, Ldm/Npc;->x:S

    if-ge v3, v1, :cond_8e

    iget-short v3, p1, Ldm/Npc;->x:S

    iget-byte v4, p1, Ldm/Npc;->speed:B

    add-int/2addr v3, v4

    if-le v3, v1, :cond_8e

    .line 3889
    :cond_6a
    iget-short v3, p1, Ldm/Npc;->x:S

    sub-int v3, v1, v3

    invoke-virtual {p1, v3, v6}, Ldm/Npc;->setSpeedXY(II)V

    .line 3891
    :goto_71
    iget-boolean v3, p1, Ldm/Npc;->bdir:Z

    if-nez v3, :cond_7c

    iget-short v3, p1, Ldm/Npc;->x:S

    if-le v3, v1, :cond_9c

    move v3, v7

    :goto_7a
    iput-byte v3, p1, Ldm/Npc;->dir:B

    .line 3898
    :cond_7c
    :goto_7c
    iget-byte v3, p1, Ldm/Npc;->frame_num:B

    iput-byte v3, p1, Ldm/Npc;->frame_c:B

    .line 3899
    invoke-virtual {p1, v5}, Ldm/Npc;->setActionNo(Z)V

    goto :goto_3d

    :cond_84
    move v0, v6

    .line 3885
    goto :goto_52

    .line 3886
    :cond_86
    iget-short v3, p1, Ldm/Npc;->y:S

    if-ne v3, v2, :cond_8c

    move v0, v5

    :goto_8b
    goto :goto_52

    :cond_8c
    move v0, v6

    goto :goto_8b

    .line 3890
    :cond_8e
    iget-short v3, p1, Ldm/Npc;->x:S

    if-le v3, v1, :cond_99

    iget-byte v3, p1, Ldm/Npc;->speed:B

    neg-int v3, v3

    :goto_95
    invoke-virtual {p1, v3, v6}, Ldm/Npc;->setSpeedXY(II)V

    goto :goto_71

    :cond_99
    iget-byte v3, p1, Ldm/Npc;->speed:B

    goto :goto_95

    :cond_9c
    move v3, v8

    .line 3891
    goto :goto_7a

    .line 3893
    :cond_9e
    iget-short v3, p1, Ldm/Npc;->y:S

    if-le v3, v2, :cond_a9

    iget-short v3, p1, Ldm/Npc;->y:S

    iget-byte v4, p1, Ldm/Npc;->speed:B

    sub-int/2addr v3, v4

    if-lt v3, v2, :cond_b4

    :cond_a9
    iget-short v3, p1, Ldm/Npc;->y:S

    if-ge v3, v2, :cond_c7

    iget-short v3, p1, Ldm/Npc;->y:S

    iget-byte v4, p1, Ldm/Npc;->speed:B

    add-int/2addr v3, v4

    if-le v3, v2, :cond_c7

    .line 3894
    :cond_b4
    iget-short v3, p1, Ldm/Npc;->y:S

    sub-int v3, v2, v3

    invoke-virtual {p1, v6, v3}, Ldm/Npc;->setSpeedXY(II)V

    .line 3896
    :goto_bb
    iget-boolean v3, p1, Ldm/Npc;->bdir:Z

    if-nez v3, :cond_7c

    iget-short v3, p1, Ldm/Npc;->y:S

    if-le v3, v2, :cond_d5

    move v3, v5

    :goto_c4
    iput-byte v3, p1, Ldm/Npc;->dir:B

    goto :goto_7c

    .line 3895
    :cond_c7
    iget-short v3, p1, Ldm/Npc;->y:S

    if-le v3, v2, :cond_d2

    iget-byte v3, p1, Ldm/Npc;->speed:B

    neg-int v3, v3

    :goto_ce
    invoke-virtual {p1, v6, v3}, Ldm/Npc;->setSpeedXY(II)V

    goto :goto_bb

    :cond_d2
    iget-byte v3, p1, Ldm/Npc;->speed:B

    goto :goto_ce

    .line 3896
    :cond_d5
    const/4 v3, 0x2

    goto :goto_c4
.end method

.method private setEventNow(IZ)V
    .registers 5
    .param p1, "i"    # I
    .param p2, "bb"    # Z

    .prologue
    const/4 v1, 0x0

    .line 700
    if-eqz p2, :cond_7

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 701
    :cond_7
    iput-byte v1, p0, Lmain/Map;->now_eV1:B

    .line 702
    iput-byte v1, p0, Lmain/Map;->now_eV2:B

    .line 703
    iput-byte v1, p0, Lmain/Map;->eventGoing:B

    .line 704
    iget-object v0, p0, Lmain/Map;->event_now:[S

    aput-short v1, v0, p1

    .line 705
    return-void
.end method

.method private setMapData()V
    .registers 9

    .prologue
    const/16 v6, 0x14

    const/16 v7, 0xa

    .line 415
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v0}, Ldm/Npc;->getIx()B

    move-result v1

    iget-short v2, p0, Lmain/Map;->cols:S

    sget-byte v3, Lmain/Constants_H;->XCELLS:B

    sget-byte v4, Lmain/Constants_H;->HALF_XCELLS:B

    sget v5, Lmain/Constants_H;->WIDTH:I

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Lmain/Map;->map_set(IIIIII)I

    move-result v0

    iput v0, p0, Lmain/Map;->map_x:I

    .line 416
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v0}, Ldm/Npc;->getIy()B

    move-result v1

    iget-short v2, p0, Lmain/Map;->rows:S

    sget-byte v3, Lmain/Constants_H;->YCELLS:B

    sget-byte v4, Lmain/Constants_H;->HALF_YCELLS:B

    sget v5, Lmain/Constants_H;->HEIGHT:I

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Lmain/Map;->map_set(IIIIII)I

    move-result v0

    iput v0, p0, Lmain/Map;->map_y:I

    .line 418
    sget v0, Lmain/Constants_H;->WIDTH_H:I

    sub-int/2addr v0, v7

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->mapLeft_NOmove:S

    .line 419
    iget-short v0, p0, Lmain/Map;->cols:S

    mul-int/lit8 v0, v0, 0x14

    sget v1, Lmain/Constants_H;->WIDTH_H:I

    sub-int/2addr v0, v1

    sub-int/2addr v0, v7

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->mapRight_NOmove:S

    .line 421
    sget v0, Lmain/Constants_H;->HEIGHT_H:I

    sub-int/2addr v0, v7

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->mapUp_NOmove:S

    .line 422
    iget-short v0, p0, Lmain/Map;->rows:S

    mul-int/lit8 v0, v0, 0x14

    sget v1, Lmain/Constants_H;->HEIGHT_H:I

    sub-int/2addr v0, v1

    sub-int/2addr v0, v7

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->mapDown_NOmove:S

    .line 423
    return-void
.end method

.method private setMapOffer()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 1825
    iget v0, p0, Lmain/Map;->map_y:I

    iget-short v1, p0, Lmain/Map;->rows:S

    mul-int/lit8 v1, v1, 0x14

    add-int/2addr v0, v1

    sget v1, Lmain/Constants_H;->HEIGHT:I

    if-ge v0, v1, :cond_1c

    iget-short v0, p0, Lmain/Map;->rows:S

    sget-byte v1, Lmain/Constants_H;->YCELLS:B

    if-le v0, v1, :cond_1c

    sget v0, Lmain/Constants_H;->HEIGHT:I

    iget-short v1, p0, Lmain/Map;->rows:S

    mul-int/lit8 v1, v1, 0x14

    sub-int/2addr v0, v1

    iput v0, p0, Lmain/Map;->map_y:I

    .line 1829
    :cond_1b
    :goto_1b
    return-void

    .line 1826
    :cond_1c
    iget v0, p0, Lmain/Map;->map_y:I

    if-lez v0, :cond_29

    iget-short v0, p0, Lmain/Map;->rows:S

    sget-byte v1, Lmain/Constants_H;->YCELLS:B

    if-le v0, v1, :cond_29

    iput v2, p0, Lmain/Map;->map_y:I

    goto :goto_1b

    .line 1827
    :cond_29
    iget v0, p0, Lmain/Map;->map_x:I

    if-lez v0, :cond_36

    iget-short v0, p0, Lmain/Map;->cols:S

    sget-byte v1, Lmain/Constants_H;->XCELLS:B

    if-le v0, v1, :cond_36

    iput v2, p0, Lmain/Map;->map_x:I

    goto :goto_1b

    .line 1828
    :cond_36
    iget v0, p0, Lmain/Map;->map_x:I

    iget-short v1, p0, Lmain/Map;->cols:S

    mul-int/lit8 v1, v1, 0x14

    add-int/2addr v0, v1

    sget v1, Lmain/Constants_H;->WIDTH:I

    if-ge v0, v1, :cond_1b

    iget-short v0, p0, Lmain/Map;->cols:S

    sget-byte v1, Lmain/Constants_H;->XCELLS:B

    if-le v0, v1, :cond_1b

    sget v0, Lmain/Constants_H;->WIDTH:I

    iget-short v1, p0, Lmain/Map;->cols:S

    mul-int/lit8 v1, v1, 0x14

    sub-int/2addr v0, v1

    iput v0, p0, Lmain/Map;->map_x:I

    goto :goto_1b
.end method

.method private setMoveStop_m()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 2562
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v2, v0, Ldm/Npc;->speed_x:B

    .line 2563
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v2, v0, Ldm/Npc;->speed_y:B

    .line 2564
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v1, -0x1

    iput-byte v1, v0, Ldm/Npc;->frame_c:B

    .line 2565
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v0, v2}, Ldm/Npc;->setActionNo(Z)V

    .line 2566
    return-void
.end method

.method private setSIfElse(IZZ)Z
    .registers 7
    .param p1, "_mode"    # I
    .param p2, "_bt"    # Z
    .param p3, "_bmode"    # Z

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 675
    const/4 v0, 0x2

    if-ne p1, v0, :cond_f

    if-eqz p2, :cond_d

    move v0, v2

    :goto_8
    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/Map;->sIfElse:B

    move v0, v1

    .line 678
    :goto_c
    return v0

    :cond_d
    move v0, v1

    .line 675
    goto :goto_8

    .line 676
    :cond_f
    if-eqz p3, :cond_15

    if-eqz p2, :cond_15

    move v0, v1

    goto :goto_c

    .line 677
    :cond_15
    if-nez p3, :cond_1b

    if-ne p1, v1, :cond_1b

    move v0, v1

    goto :goto_c

    :cond_1b
    move v0, v2

    .line 678
    goto :goto_c
.end method

.method private setlastA([Ldm/Npc;I)Z
    .registers 7
    .param p1, "npc"    # [Ldm/Npc;
    .param p2, "i"    # I

    .prologue
    const/16 v3, 0x7f

    .line 3695
    aget-object v0, p1, p2

    iget-byte v0, v0, Ldm/Npc;->lastAction:B

    if-eq v0, v3, :cond_19

    .line 3696
    aget-object v0, p1, p2

    iget-object v0, v0, Ldm/Npc;->other:[B

    const/4 v1, 0x7

    aget-object v2, p1, p2

    iget-byte v2, v2, Ldm/Npc;->lastAction:B

    aput-byte v2, v0, v1

    .line 3697
    aget-object v0, p1, p2

    iput-byte v3, v0, Ldm/Npc;->lastAction:B

    .line 3698
    const/4 v0, 0x1

    .line 3700
    :goto_18
    return v0

    :cond_19
    const/4 v0, 0x0

    goto :goto_18
.end method

.method private turnAround(I)V
    .registers 4
    .param p1, "dir"    # I

    .prologue
    .line 2199
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    int-to-byte v1, p1

    iput-byte v1, v0, Ldm/Npc;->dir:B

    .line 2200
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ldm/Npc;->setActionNo(Z)V

    .line 2201
    return-void
.end method


# virtual methods
.method public addAnole(I)V
    .registers 7
    .param p1, "i"    # I

    .prologue
    const/16 v4, 0x42

    const/16 v3, 0x31

    const/16 v2, 0x22

    const/16 v1, 0xd

    .line 2123
    if-eq p1, v1, :cond_15

    if-eq p1, v2, :cond_15

    if-eq p1, v3, :cond_15

    if-eq p1, v4, :cond_15

    const/16 v0, 0x52

    if-eq p1, v0, :cond_15

    .line 2135
    :goto_14
    return-void

    .line 2124
    :cond_15
    if-ne p1, v1, :cond_26

    const/4 p1, 0x0

    .line 2134
    :goto_18
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    const/4 v1, 0x2

    aget-byte v2, v0, v1

    const/4 v3, 0x1

    shl-int/2addr v3, p1

    or-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    goto :goto_14

    .line 2125
    :cond_26
    if-ne p1, v2, :cond_2a

    const/4 p1, 0x1

    goto :goto_18

    .line 2126
    :cond_2a
    if-ne p1, v3, :cond_2e

    const/4 p1, 0x2

    goto :goto_18

    .line 2127
    :cond_2e
    if-ne p1, v4, :cond_32

    const/4 p1, 0x3

    goto :goto_18

    .line 2128
    :cond_32
    const/4 p1, 0x4

    goto :goto_18
.end method

.method public bkEvent_getMon()V
    .registers 2

    .prologue
    .line 1274
    const/16 v0, -0xa

    sput v0, Lmain/GameRun;->run_state:I

    .line 1275
    return-void
.end method

.method public bkgroundToPaint([S[Ljavax/microedition/lcdui/Image;II[[SLjavax/microedition/lcdui/Graphics;IIIIZ)V
    .registers 33
    .param p1, "bkgroundData"    # [S
    .param p2, "img"    # [Ljavax/microedition/lcdui/Image;
    .param p3, "screen_x"    # I
    .param p4, "screen_y"    # I
    .param p5, "moduleData"    # [[S
    .param p6, "gtem"    # Ljavax/microedition/lcdui/Graphics;
    .param p7, "x1"    # I
    .param p8, "y1"    # I
    .param p9, "x2"    # I
    .param p10, "y2"    # I
    .param p11, "fillBlack"    # Z

    .prologue
    .line 3343
    if-nez p1, :cond_3

    .line 3391
    :cond_2
    return-void

    .line 3345
    :cond_3
    add-int/lit8 p4, p4, -0x14

    .line 3349
    if-eqz p11, :cond_30

    .line 3350
    sub-int v5, p9, p7

    sub-int v6, p10, p8

    move-object/from16 v0, p6

    move/from16 v1, p7

    move/from16 v2, p8

    move v3, v5

    move v4, v6

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 3351
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->bgColor:I

    move v5, v0

    move-object/from16 v0, p6

    move v1, v5

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 3352
    sub-int v5, p9, p7

    sub-int v6, p10, p8

    move-object/from16 v0, p6

    move/from16 v1, p7

    move/from16 v2, p8

    move v3, v5

    move v4, v6

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 3354
    :cond_30
    const/16 v18, -0x1

    .local v18, "bkdata_id":I
    const/16 v19, 0x0

    .line 3355
    .local v19, "bkdata_trans":I
    const/16 v17, 0x0

    .local v17, "bkPic_w":I
    const/16 v16, 0x0

    .line 3357
    .local v16, "bkPic_h":I
    const/16 v20, 0x0

    .local v20, "i":I
    :goto_3a
    move-object/from16 v0, p1

    array-length v0, v0

    move v5, v0

    move/from16 v0, v20

    move v1, v5

    if-ge v0, v1, :cond_2

    .line 3358
    add-int/lit8 v5, v20, 0x2

    aget-short v5, p1, v5

    if-ltz v5, :cond_b7

    .line 3359
    add-int/lit8 v5, v20, 0x2

    aget-short v5, p1, v5

    shr-int/lit8 v18, v5, 0x3

    .line 3360
    add-int/lit8 v5, v20, 0x2

    aget-short v5, p1, v5

    and-int/lit8 v19, v5, 0x3

    .line 3361
    aget-short v5, p1, v20

    mul-int/lit8 v5, v5, 0x14

    sub-int v11, v5, p3

    .line 3362
    .local v11, "realX":I
    add-int/lit8 v5, v20, 0x1

    aget-short v5, p1, v5

    mul-int/lit8 v5, v5, 0x14

    sub-int v12, v5, p4

    .line 3363
    .local v12, "realY":I
    rem-int/lit8 v5, v19, 0x2

    const/4 v6, 0x1

    if-ne v5, v6, :cond_ba

    .line 3364
    aget-object v5, p5, v18

    const/4 v6, 0x4

    aget-short v17, v5, v6

    .line 3365
    aget-object v5, p5, v18

    const/4 v6, 0x3

    aget-short v16, v5, v6

    .line 3370
    :goto_72
    add-int v5, v11, v17

    move v0, v5

    move/from16 v1, p7

    if-lt v0, v1, :cond_b7

    move v0, v11

    move/from16 v1, p9

    if-gt v0, v1, :cond_b7

    move v0, v12

    move/from16 v1, p8

    if-lt v0, v1, :cond_b7

    sub-int v5, v12, v16

    move v0, v5

    move/from16 v1, p10

    if-gt v0, v1, :cond_b7

    .line 3381
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    aget-object v6, p5, v18

    const/4 v7, 0x0

    aget-short v6, v6, v7

    aget-object v6, p2, v6

    .line 3382
    aget-object v7, p5, v18

    const/4 v8, 0x1

    aget-short v7, v7, v8

    aget-object v8, p5, v18

    const/4 v9, 0x2

    aget-short v8, v8, v9

    .line 3383
    aget-object v9, p5, v18

    const/4 v10, 0x3

    aget-short v9, v9, v10

    aget-object v10, p5, v18

    const/4 v13, 0x4

    aget-short v10, v10, v13

    .line 3386
    const/4 v13, 0x4

    or-int/lit8 v13, v13, 0x20

    add-int/lit8 v14, v20, 0x2

    aget-short v14, p1, v14

    and-int/lit8 v14, v14, 0x7

    move-object/from16 v15, p6

    .line 3381
    invoke-virtual/range {v5 .. v15}, Ldm/Ui;->drawRegion(Ljavax/microedition/lcdui/Image;IIIIIIIILjavax/microedition/lcdui/Graphics;)V

    .line 3357
    .end local v11    # "realX":I
    .end local v12    # "realY":I
    :cond_b7
    add-int/lit8 v20, v20, 0x3

    goto :goto_3a

    .line 3367
    .restart local v11    # "realX":I
    .restart local v12    # "realY":I
    :cond_ba
    aget-object v5, p5, v18

    const/4 v6, 0x3

    aget-short v17, v5, v6

    .line 3368
    aget-object v5, p5, v18

    const/4 v6, 0x4

    aget-short v16, v5, v6

    goto :goto_72
.end method

.method public declared-synchronized checkRegWhere0(I)V
    .registers 6
    .param p1, "i"    # I

    .prologue
    .line 4177
    monitor-enter p0

    const/4 v1, 0x1

    :try_start_2
    iput-boolean v1, p0, Lmain/Map;->isNeedWait:Z

    .line 4180
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-static {v1}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    const/4 v2, 0x2

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lmain/SMSSender;->go(IZ)V

    .line 4181
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-static {v1}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v1

    invoke-virtual {v1}, Lmain/SMSSender;->run()V

    .line 4182
    iget-boolean v1, p0, Lmain/Map;->isNeedWait:Z
    :try_end_1a
    .catchall {:try_start_2 .. :try_end_1a} :catchall_35

    if-eqz v1, :cond_2d

    .line 4184
    :try_start_1c
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "wait() start"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 4185
    invoke-virtual {p0}, Ljava/lang/Object;->wait()V
    :try_end_26
    .catch Ljava/lang/Exception; {:try_start_1c .. :try_end_26} :catch_2f
    .catchall {:try_start_1c .. :try_end_26} :catchall_35

    .line 4189
    :goto_26
    :try_start_26
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "wait() over"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    :try_end_2d
    .catchall {:try_start_26 .. :try_end_2d} :catchall_35

    .line 4193
    :cond_2d
    monitor-exit p0

    return-void

    .line 4186
    :catch_2f
    move-exception v1

    move-object v0, v1

    .line 4187
    .local v0, "ex":Ljava/lang/Exception;
    :try_start_31
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_34
    .catchall {:try_start_31 .. :try_end_34} :catchall_35

    goto :goto_26

    .line 4177
    .end local v0    # "ex":Ljava/lang/Exception;
    :catchall_35
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public checkSoftKey(IIII)B
    .registers 14
    .param p1, "A_X"    # I
    .param p2, "A_Y"    # I
    .param p3, "_speed_x"    # I
    .param p4, "_speed_y"    # I

    .prologue
    const/4 v8, 0x2

    const/4 v7, -0x1

    const/16 v4, 0x8

    const/4 v6, 0x7

    const/4 v5, 0x0

    .line 2243
    add-int v1, p1, p3

    if-ltz v1, :cond_1e

    add-int v1, p1, p3

    iget-short v2, p0, Lmain/Map;->cols:S

    mul-int/lit8 v2, v2, 0x14

    if-ge v1, v2, :cond_1e

    .line 2244
    add-int v1, p2, p4

    if-ltz v1, :cond_1e

    add-int v1, p2, p4

    iget-short v2, p0, Lmain/Map;->rows:S

    mul-int/lit8 v2, v2, 0x14

    if-lt v1, v2, :cond_20

    :cond_1e
    move v1, v5

    .line 2299
    :goto_1f
    return v1

    .line 2245
    :cond_20
    const/4 v0, 0x0

    .line 2246
    .local v0, "type":B
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    add-int v2, p1, p3

    add-int v3, p2, p4

    invoke-direct {p0, v1, v2, v3}, Lmain/Map;->checkIfNpc([Ldm/Npc;II)B

    move-result v0

    .line 2247
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->state:B

    if-nez v1, :cond_115

    if-eq v0, v7, :cond_115

    .line 2261
    iget-byte v1, p0, Lmain/Map;->anole_type:B

    const/4 v2, 0x1

    if-ne v1, v2, :cond_74

    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v4

    const/4 v2, 0x4

    if-ne v1, v2, :cond_74

    .line 2262
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    const/4 v2, -0x4

    aput-byte v2, v1, v4

    .line 2263
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v2, v1, v6

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    aput-byte v2, v1, v6

    .line 2264
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iput-byte v5, v1, Ldm/Npc;->now_action:B

    .line 2265
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iput-byte v5, v1, Ldm/Npc;->now_time:B

    .line 2287
    :cond_71
    :goto_71
    const/16 v1, 0x9

    goto :goto_1f

    .line 2266
    :cond_74
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v4

    const/4 v2, -0x4

    if-eq v1, v2, :cond_71

    .line 2271
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v8, v1, Ldm/Npc;->state:B

    .line 2272
    iput-byte v0, p0, Lmain/Map;->get_meet:B

    .line 2275
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v4

    if-eq v1, v8, :cond_111

    .line 2276
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v4

    const/4 v2, 0x3

    if-eq v1, v2, :cond_111

    .line 2277
    iget-object v1, p0, Lmain/Map;->npcNameData:[Ljava/lang/String;

    aget-object v1, v1, v0

    const-string v2, "\u8def\u4eba"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_111

    .line 2278
    const/4 v1, 0x1

    iput-boolean v1, p0, Lmain/Map;->bDirTalk:Z

    .line 2279
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    aget-byte v1, v1, v6

    iput-byte v1, p0, Lmain/Map;->npcDirTalk:B

    .line 2280
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    iget-byte v2, p0, Lmain/Map;->npcDirTalk:B

    invoke-static {v2}, Ldm/Ms;->abs(I)I

    move-result v2

    div-int/lit8 v2, v2, 0x3

    mul-int/lit8 v2, v2, 0x3

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->dir:B

    const/4 v4, 0x4

    if-ge v3, v4, :cond_100

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->dir:B

    const/4 v4, 0x1

    sub-int/2addr v3, v4

    :goto_dd
    add-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v1, v6

    .line 2281
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->dir:B

    const/4 v2, 0x3

    if-ne v1, v2, :cond_106

    .line 2282
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Npc;->other:[B

    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v5

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    aget-byte v2, v2, v6

    neg-int v2, v2

    int-to-byte v2, v2

    aput-byte v2, v1, v6

    goto/16 :goto_71

    .line 2280
    :cond_100
    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->dir:B

    sub-int/2addr v3, v8

    goto :goto_dd

    .line 2283
    :cond_106
    iget-object v1, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v1, v1, v5

    aget-object v1, v1, v0

    const/4 v2, 0x3

    iput-byte v2, v1, Ldm/Npc;->dir:B

    goto/16 :goto_71

    .line 2284
    :cond_111
    iput-boolean v5, p0, Lmain/Map;->bDirTalk:Z

    goto/16 :goto_71

    .line 2290
    :cond_115
    iget-object v1, p0, Lmain/Map;->item:[[B

    add-int v2, p1, p3

    add-int v3, p2, p4

    invoke-direct {p0, v1, v2, v3}, Lmain/Map;->checkIfOther([[BII)B

    move-result v0

    .line 2291
    if-eq v0, v7, :cond_138

    iget-object v1, p0, Lmain/Map;->item:[[B

    aget-object v1, v1, v0

    aget-byte v1, v1, v8

    if-eq v1, v7, :cond_138

    .line 2293
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->keyRelease()V

    .line 2294
    iput-byte v0, p0, Lmain/Map;->get_meet:B

    .line 2295
    invoke-direct {p0}, Lmain/Map;->getItem()V

    move v1, v5

    .line 2297
    goto/16 :goto_1f

    :cond_138
    move v1, v7

    .line 2299
    goto/16 :goto_1f
.end method

.method public chuansong(II)V
    .registers 5
    .param p1, "mapno"    # I
    .param p2, "door"    # I

    .prologue
    .line 626
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v1, 0x5

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 627
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/Map;->mapNotemp:B

    .line 628
    int-to-byte v0, p2

    iput-byte v0, p0, Lmain/Map;->go:B

    .line 630
    invoke-direct {p0}, Lmain/Map;->setMoveStop_m()V

    .line 631
    return-void
.end method

.method public createEvent()V
    .registers 11

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 218
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    const-string v6, "event"

    iget-byte v7, p0, Lmain/Map;->mapNo:B

    invoke-virtual {v5, v6, v7}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 219
    .local v0, "data":[B
    const/4 v3, 0x0

    .line 221
    .local v3, "start_pos":I
    array-length v5, v0

    if-ne v5, v9, :cond_15

    .line 222
    iput v8, p0, Lmain/Map;->eventCount:I

    .line 251
    :cond_14
    return-void

    .line 225
    :cond_15
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "start_pos":I
    .local v4, "start_pos":I
    aget-byte v5, v0, v3

    iput v5, p0, Lmain/Map;->eventCount:I

    .line 226
    iget-object v5, p0, Lmain/Map;->mapInfo:[S

    iget-byte v6, p0, Lmain/Map;->mapNo:B

    mul-int/lit8 v6, v6, 0x2

    aget-short v5, v5, v6

    if-ge v5, v9, :cond_70

    .line 227
    iget-object v5, p0, Lmain/Map;->event_now_list:[[S

    iget-byte v6, p0, Lmain/Map;->mapNo:B

    const/4 v7, 0x0

    aput-object v7, v5, v6

    .line 228
    iget-object v5, p0, Lmain/Map;->event_now_list:[[S

    iget-byte v6, p0, Lmain/Map;->mapNo:B

    iget v7, p0, Lmain/Map;->eventCount:I

    new-array v7, v7, [S

    aput-object v7, v5, v6

    .line 233
    :cond_36
    iget-object v5, p0, Lmain/Map;->event_now_list:[[S

    iget-byte v6, p0, Lmain/Map;->mapNo:B

    aget-object v5, v5, v6

    iput-object v5, p0, Lmain/Map;->event_now:[S

    .line 241
    iget v5, p0, Lmain/Map;->eventCount:I

    new-array v5, v5, [[B

    iput-object v5, p0, Lmain/Map;->event:[[B

    .line 242
    const/4 v2, 0x0

    .line 243
    .local v2, "length_":S
    const/4 v1, 0x0

    .local v1, "i":B
    move v3, v4

    .end local v4    # "start_pos":I
    .restart local v3    # "start_pos":I
    :goto_47
    iget v5, p0, Lmain/Map;->eventCount:I

    if-ge v1, v5, :cond_14

    .line 244
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "start_pos":I
    .restart local v4    # "start_pos":I
    aget-byte v5, v0, v3

    shl-int/lit8 v5, v5, 0x8

    add-int/lit8 v3, v4, 0x1

    .end local v4    # "start_pos":I
    .restart local v3    # "start_pos":I
    aget-byte v6, v0, v4

    and-int/lit16 v6, v6, 0xff

    or-int/2addr v5, v6

    int-to-short v2, v5

    .line 246
    iget-object v5, p0, Lmain/Map;->event:[[B

    new-array v6, v2, [B

    aput-object v6, v5, v1

    .line 247
    iget-object v5, p0, Lmain/Map;->event:[[B

    aget-object v5, v5, v1

    iget-object v6, p0, Lmain/Map;->event:[[B

    aget-object v6, v6, v1

    array-length v6, v6

    invoke-static {v0, v3, v5, v8, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 249
    add-int/2addr v3, v2

    .line 243
    add-int/lit8 v5, v1, 0x1

    int-to-byte v1, v5

    goto :goto_47

    .line 230
    .end local v1    # "i":B
    .end local v2    # "length_":S
    .end local v3    # "start_pos":I
    .restart local v4    # "start_pos":I
    :cond_70
    const/4 v1, 0x0

    .restart local v1    # "i":B
    :goto_71
    iget v5, p0, Lmain/Map;->eventCount:I

    if-ge v1, v5, :cond_36

    .line 231
    iget-byte v5, p0, Lmain/Map;->mapNo:B

    invoke-direct {p0, v5, v1}, Lmain/Map;->isMapEvent(II)Z

    move-result v5

    if-eqz v5, :cond_87

    iget-object v5, p0, Lmain/Map;->event_now_list:[[S

    iget-byte v6, p0, Lmain/Map;->mapNo:B

    aget-object v5, v5, v6

    const/16 v6, 0x5ea0

    aput-short v6, v5, v1

    .line 230
    :cond_87
    add-int/lit8 v5, v1, 0x1

    int-to-byte v1, v5

    goto :goto_71
.end method

.method createItem([B[[B)[[B
    .registers 8
    .param p1, "data"    # [B
    .param p2, "npc"    # [[B

    .prologue
    .line 367
    const/4 p2, 0x0

    check-cast p2, [[B

    .line 369
    iget-object v2, p0, Lmain/Map;->mapInfo:[S

    iget-byte v3, p0, Lmain/Map;->mapNo:B

    mul-int/lit8 v3, v3, 0x2

    aget-short v2, v2, v3

    if-lez v2, :cond_4f

    .line 370
    iget-object v2, p0, Lmain/Map;->mapTemp:[[B

    iget-byte v3, p0, Lmain/Map;->mapNo:B

    aget-object p1, v2, v3

    .line 371
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v2, Ldm/Ms;->skip2:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip2:I

    aget-byte v2, p1, v2

    new-array p2, v2, [[B

    .line 372
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_21
    array-length v2, p2

    if-lt v0, v2, :cond_25

    .line 388
    :cond_24
    return-object p2

    .line 373
    :cond_25
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v2, Ldm/Ms;->skip2:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip2:I

    aget-byte v2, p1, v2

    new-array v2, v2, [B

    aput-object v2, p2, v0

    .line 374
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_35
    aget-object v2, p2, v0

    array-length v2, v2

    if-lt v1, v2, :cond_3d

    .line 372
    add-int/lit8 v0, v0, 0x1

    goto :goto_21

    .line 375
    :cond_3d
    aget-object v2, p2, v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v3, Ldm/Ms;->skip2:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip2:I

    aget-byte v3, p1, v3

    aput-byte v3, v2, v1

    .line 374
    add-int/lit8 v1, v1, 0x1

    goto :goto_35

    .line 380
    .end local v0    # "i":I
    .end local v1    # "j":I
    :cond_4f
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    new-array p2, v2, [[B

    .line 381
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_5d
    array-length v2, p2

    if-ge v0, v2, :cond_24

    .line 382
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    new-array v2, v2, [B

    aput-object v2, p2, v0

    .line 383
    const/4 v1, 0x0

    .restart local v1    # "j":I
    :goto_70
    aget-object v2, p2, v0

    array-length v2, v2

    if-lt v1, v2, :cond_78

    .line 381
    add-int/lit8 v0, v0, 0x1

    goto :goto_5d

    .line 384
    :cond_78
    aget-object v2, p2, v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v3, Ldm/Ms;->skip:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip:I

    aget-byte v3, p1, v3

    aput-byte v3, v2, v1

    .line 383
    add-int/lit8 v1, v1, 0x1

    goto :goto_70
.end method

.method public createLayer()V
    .registers 1

    .prologue
    .line 426
    invoke-direct {p0}, Lmain/Map;->createMap()V

    .line 428
    invoke-direct {p0}, Lmain/Map;->setMapData()V

    .line 429
    return-void
.end method

.method createNpc([B[Ldm/Npc;)[Ldm/Npc;
    .registers 9
    .param p1, "data"    # [B
    .param p2, "npc"    # [Ldm/Npc;

    .prologue
    .line 343
    const/4 p2, 0x0

    check-cast p2, [Ldm/Npc;

    .line 344
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v2, Ldm/Ms;->skip:I

    add-int/lit8 v3, v2, 0x1

    sput v3, Ldm/Ms;->skip:I

    aget-byte v2, p1, v2

    new-array p2, v2, [Ldm/Npc;

    .line 346
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_11
    array-length v2, p2

    if-lt v0, v2, :cond_23

    .line 353
    iget-object v2, p0, Lmain/Map;->mapInfo:[S

    iget-byte v3, p0, Lmain/Map;->mapNo:B

    mul-int/lit8 v3, v3, 0x2

    aget-short v2, v2, v3

    if-lez v2, :cond_22

    .line 354
    const/4 v0, 0x0

    :goto_1f
    array-length v2, p2

    if-lt v0, v2, :cond_59

    .line 363
    :cond_22
    return-object p2

    .line 347
    :cond_23
    new-instance v2, Ldm/Npc;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v3, Ldm/Ms;->skip:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip:I

    aget-byte v3, p1, v3

    invoke-direct {v2, v3}, Ldm/Npc;-><init>(I)V

    aput-object v2, p2, v0

    .line 348
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_36
    aget-object v2, p2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    array-length v2, v2

    if-lt v1, v2, :cond_45

    .line 351
    aget-object v2, p2, v0

    invoke-virtual {v2}, Ldm/Npc;->setXY_npc()V

    .line 346
    add-int/lit8 v0, v0, 0x1

    goto :goto_11

    .line 349
    :cond_45
    aget-object v2, p2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v3, Ldm/Ms;->skip:I

    add-int/lit8 v4, v3, 0x1

    sput v4, Ldm/Ms;->skip:I

    aget-byte v3, p1, v3

    aput-byte v3, v2, v1

    .line 348
    add-int/lit8 v1, v1, 0x1

    goto :goto_36

    .line 355
    .end local v1    # "j":I
    :cond_59
    aget-object v2, p2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    const/16 v3, 0x9

    aget-byte v2, v2, v3

    const/4 v3, 0x1

    if-ne v2, v3, :cond_71

    .line 356
    const/4 v1, 0x0

    .restart local v1    # "j":I
    :goto_65
    aget-object v2, p2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    array-length v2, v2

    if-lt v1, v2, :cond_74

    .line 359
    aget-object v2, p2, v0

    invoke-virtual {v2}, Ldm/Npc;->setXY_npc()V

    .line 354
    .end local v1    # "j":I
    :cond_71
    add-int/lit8 v0, v0, 0x1

    goto :goto_1f

    .line 357
    .restart local v1    # "j":I
    :cond_74
    aget-object v2, p2, v0

    iget-object v2, v2, Ldm/Npc;->other:[B

    iget-object v3, p0, Lmain/Map;->mapTemp:[[B

    iget-byte v4, p0, Lmain/Map;->mapNo:B

    aget-object v3, v3, v4

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v4, Ldm/Ms;->skip2:I

    add-int/lit8 v5, v4, 0x1

    sput v5, Ldm/Ms;->skip2:I

    aget-byte v3, v3, v4

    aput-byte v3, v2, v1

    .line 356
    add-int/lit8 v1, v1, 0x1

    goto :goto_65
.end method

.method public createNpcPos([B[B)[B
    .registers 6
    .param p1, "data"    # [B
    .param p2, "npc"    # [B

    .prologue
    .line 397
    const/4 p2, 0x0

    check-cast p2, [B

    .line 398
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v1, Ldm/Ms;->skip:I

    add-int/lit8 v2, v1, 0x1

    sput v2, Ldm/Ms;->skip:I

    aget-byte v1, p1, v1

    new-array p2, v1, [B

    .line 400
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_11
    array-length v1, p2

    if-lt v0, v1, :cond_15

    .line 403
    return-object p2

    .line 401
    :cond_15
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v1, Ldm/Ms;->skip:I

    add-int/lit8 v2, v1, 0x1

    sput v2, Ldm/Ms;->skip:I

    aget-byte v1, p1, v1

    aput-byte v1, p2, v0

    .line 400
    add-int/lit8 v0, v0, 0x1

    goto :goto_11
.end method

.method public createNpcString()V
    .registers 4

    .prologue
    .line 142
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lmain/GameRun;->createData(I)[B

    move-result-object v1

    iget-byte v2, p0, Lmain/Map;->mapNo:B

    invoke-virtual {p0, v1, v2}, Lmain/Map;->initData([BI)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ldm/Ms;->loadText([B)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmain/Map;->npcNameData:[Ljava/lang/String;

    .line 143
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Lmain/GameRun;->createData(I)[B

    move-result-object v1

    iget-byte v2, p0, Lmain/Map;->mapNo:B

    invoke-virtual {p0, v1, v2}, Lmain/Map;->initData([BI)[B

    move-result-object v1

    invoke-virtual {v0, v1}, Ldm/Ms;->loadText([B)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lmain/Map;->npcStringData:[Ljava/lang/String;

    .line 144
    return-void
.end method

.method public createOther()V
    .registers 11

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v2, 0x0

    const/4 v7, 0x0

    .line 321
    move-object v0, v2

    check-cast v0, [B

    move-object v1, v0

    .line 322
    .local v1, "Datas":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v7, Ldm/Ms;->skip:I

    .line 323
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sput v7, Ldm/Ms;->skip2:I

    .line 324
    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v3, v7}, Lmain/GameRun;->createData(I)[B

    move-result-object v3

    iget-byte v4, p0, Lmain/Map;->mapNo:B

    invoke-virtual {p0, v3, v4}, Lmain/Map;->initData([BI)[B

    move-result-object v1

    .line 325
    iget-object v3, p0, Lmain/Map;->npcPos:[B

    invoke-virtual {p0, v1, v3}, Lmain/Map;->createNpcPos([B[B)[B

    move-result-object v3

    iput-object v3, p0, Lmain/Map;->npcPos:[B

    .line 326
    iget-object v3, p0, Lmain/Map;->mapInfo:[S

    iget-byte v4, p0, Lmain/Map;->mapNo:B

    mul-int/lit8 v4, v4, 0x2

    aget-short v3, v3, v4

    if-lez v3, :cond_4a

    .line 327
    iget-object v3, p0, Lmain/Map;->mapTemp:[[B

    iget-byte v4, p0, Lmain/Map;->mapNo:B

    aget-object v3, v3, v4

    if-nez v3, :cond_4a

    .line 328
    iget-object v3, p0, Lmain/Map;->mapTemp:[[B

    iget-byte v4, p0, Lmain/Map;->mapNo:B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    iget-byte v6, p0, Lmain/Map;->mapNo:B

    add-int/lit8 v6, v6, 0xe

    invoke-virtual {v5, v6, v2, v8}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v5

    aput-object v5, v3, v4

    .line 331
    :cond_4a
    iget-object v3, p0, Lmain/Map;->npc:[[Ldm/Npc;

    iget-object v4, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v4, v4, v7

    invoke-virtual {p0, v1, v4}, Lmain/Map;->createNpc([B[Ldm/Npc;)[Ldm/Npc;

    move-result-object v4

    aput-object v4, v3, v7

    .line 332
    iget-object v3, p0, Lmain/Map;->npc:[[Ldm/Npc;

    iget-object v4, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v4, v4, v8

    invoke-virtual {p0, v1, v4}, Lmain/Map;->createNpc([B[Ldm/Npc;)[Ldm/Npc;

    move-result-object v4

    aput-object v4, v3, v8

    .line 333
    iget-object v3, p0, Lmain/Map;->npc:[[Ldm/Npc;

    iget-object v4, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v4, v4, v9

    invoke-virtual {p0, v1, v4}, Lmain/Map;->createNpc([B[Ldm/Npc;)[Ldm/Npc;

    move-result-object v4

    aput-object v4, v3, v9

    .line 334
    iget-object v3, p0, Lmain/Map;->item:[[B

    invoke-virtual {p0, v1, v3}, Lmain/Map;->createItem([B[[B)[[B

    move-result-object v3

    iput-object v3, p0, Lmain/Map;->item:[[B

    .line 335
    iget-object v3, p0, Lmain/Map;->door:[[B

    invoke-virtual {p0, v1, v3}, Lmain/Map;->createItem([B[[B)[[B

    move-result-object v3

    iput-object v3, p0, Lmain/Map;->door:[[B

    .line 336
    iput-object v2, p0, Lmain/Map;->npcList:[B

    .line 337
    iget-object v3, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v3, v3, v7

    array-length v3, v3

    add-int/lit8 v3, v3, 0x1

    iget-object v4, p0, Lmain/Map;->item:[[B

    array-length v4, v4

    add-int/2addr v3, v4

    new-array v3, v3, [B

    iput-object v3, p0, Lmain/Map;->npcList:[B

    .line 338
    move-object v0, v2

    check-cast v0, [B

    move-object v1, v0

    .line 339
    invoke-virtual {p0}, Lmain/Map;->initNpcAni()V

    .line 340
    return-void
.end method

.method public doKey()V
    .registers 7

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 2157
    iget-byte v0, p0, Lmain/Map;->map_key:B

    sparse-switch v0, :sswitch_data_84

    .line 2196
    :cond_7
    :goto_7
    :sswitch_7
    return-void

    .line 2162
    :sswitch_8
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->dir:B

    iget-byte v1, p0, Lmain/Map;->map_key:B

    if-eq v0, v1, :cond_15

    iget-byte v0, p0, Lmain/Map;->map_key:B

    invoke-direct {p0, v0}, Lmain/Map;->turnAround(I)V

    .line 2163
    :cond_15
    iget-object v0, p0, Lmain/Map;->dir_select:[[B

    iget-byte v1, p0, Lmain/Map;->map_key:B

    aget-object v0, v0, v1

    aget-byte v0, v0, v4

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, v1, Ldm/Npc;->speed:B

    mul-int/2addr v0, v1

    iget-object v1, p0, Lmain/Map;->dir_select:[[B

    iget-byte v2, p0, Lmain/Map;->map_key:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v5

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->speed:B

    mul-int/2addr v1, v2

    invoke-direct {p0, v0, v1}, Lmain/Map;->canMove(II)V

    goto :goto_7

    .line 2167
    :sswitch_33
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-boolean v0, v0, Lmain/GameRun;->isTalk:Z

    if-eqz v0, :cond_7

    .line 2168
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v0, v0, Ldm/Npc;->x:S

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    iget-object v2, p0, Lmain/Map;->dir_select:[[B

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->dir:B

    aget-object v2, v2, v3

    aget-byte v2, v2, v4

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->speed:B

    mul-int/2addr v2, v3

    iget-object v3, p0, Lmain/Map;->dir_select:[[B

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->dir:B

    aget-object v3, v3, v4

    aget-byte v3, v3, v5

    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v4, v4, Ldm/Npc;->speed:B

    mul-int/2addr v3, v4

    invoke-virtual {p0, v0, v1, v2, v3}, Lmain/Map;->checkSoftKey(IIII)B

    goto :goto_7

    .line 2172
    :sswitch_63
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 2173
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    const/4 v1, 0x2

    aget-byte v0, v0, v1

    if-lez v0, :cond_7

    invoke-virtual {p0}, Lmain/Map;->initAnoleValue()Z

    goto :goto_7

    .line 2186
    :sswitch_77
    invoke-virtual {p0, v5, v4}, Lmain/Map;->goMission(IZ)V

    goto :goto_7

    .line 2190
    :sswitch_7b
    invoke-virtual {p0, v4, v4}, Lmain/Map;->goMission(IZ)V

    goto :goto_7

    .line 2193
    :sswitch_7f
    invoke-virtual {p0}, Lmain/Map;->goMiniMap()V

    goto :goto_7

    .line 2157
    nop

    :sswitch_data_84
    .sparse-switch
        -0x39 -> :sswitch_63
        -0x37 -> :sswitch_7
        -0x35 -> :sswitch_33
        -0x33 -> :sswitch_77
        -0x31 -> :sswitch_7b
        -0x30 -> :sswitch_7f
        0x1 -> :sswitch_8
        0x2 -> :sswitch_8
        0x3 -> :sswitch_8
        0x4 -> :sswitch_8
        0x5 -> :sswitch_33
    .end sparse-switch
.end method

.method public drawBlackSRC(Ljavax/microedition/lcdui/Graphics;IZ)V
    .registers 25
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;
    .param p2, "y"    # I
    .param p3, "mode"    # Z

    .prologue
    .line 1850
    sget v16, Lmain/Constants_H;->WIDTH__:I

    .local v16, "WIDTH":I
    sget v15, Lmain/Constants_H;->HEIGHT__:I

    .line 1851
    .local v15, "HEIGHT":I
    sget v5, Lmain/Constants_H;->WIDTH__:I

    div-int/lit8 v17, v5, 0x2

    .line 1852
    .local v17, "WIDTH_H":I
    const/16 v7, 0x19

    .local v7, "FONT_W":I
    const/16 v14, 0x19

    .line 1853
    .local v14, "FONT_H":I
    const v5, 0xffffff

    move-object/from16 v0, p1

    move v1, v5

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 1859
    const/16 v18, 0x0

    .local v18, "d":S
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->black_0:S

    move v5, v0

    const/4 v6, 0x5

    sub-int/2addr v5, v6

    if-lez v5, :cond_35

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->black_0:S

    move v5, v0

    const/4 v6, 0x5

    sub-int/2addr v5, v6

    :goto_27
    move v0, v5

    int-to-byte v0, v0

    move/from16 v19, v0

    .line 1862
    .local v19, "offy":S
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    if-nez v5, :cond_8e

    .line 1887
    .end local v7    # "FONT_W":I
    :cond_34
    :goto_34
    return-void

    .line 1859
    .end local v19    # "offy":S
    .restart local v7    # "FONT_W":I
    :cond_35
    const/4 v5, 0x0

    goto :goto_27

    .line 1865
    .restart local v19    # "offy":S
    :cond_37
    if-nez p3, :cond_ec

    .line 1866
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->black_0:S

    move v5, v0

    move v0, v5

    move/from16 v1, v18

    if-ne v0, v1, :cond_5e

    .line 1867
    const/4 v5, 0x0

    sub-int v6, v18, v19

    add-int/lit8 v8, v14, 0x4

    mul-int/lit8 v6, v6, 0x1d

    add-int v6, v6, p2

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->black_1:S

    move v8, v0

    shl-int/lit8 v8, v8, 0x1

    add-int/lit8 v9, v14, 0x4

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    move v3, v8

    move v4, v9

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 1868
    :cond_5e
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-object v6, v6, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    aget-object v6, v6, v18

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    sub-int v8, v18, v19

    add-int/lit8 v9, v14, 0x4

    mul-int/lit8 v8, v8, 0x1d

    add-int v8, v8, p2

    const/4 v9, 0x0

    const/4 v10, 0x0

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V

    .line 1869
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    move/from16 v3, v16

    move v4, v15

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 1864
    :goto_88
    add-int/lit8 v5, v18, 0x1

    move v0, v5

    int-to-short v0, v0

    move/from16 v18, v0

    :cond_8e
    if-eqz p3, :cond_140

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    array-length v5, v5

    move/from16 v0, v18

    move v1, v5

    if-lt v0, v1, :cond_37

    .line 1876
    :cond_9d
    :goto_9d
    if-nez p3, :cond_c5

    .line 1877
    const/4 v5, 0x0

    move-object/from16 v0, p1

    move v1, v5

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 1878
    const/4 v5, 0x0

    const/4 v6, 0x0

    const/16 v7, 0x28

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    move/from16 v3, v16

    move v4, v7

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 1879
    .end local v7    # "FONT_W":I
    const/4 v5, 0x0

    const/16 v6, 0x28

    sub-int v6, v15, v6

    const/16 v7, 0x28

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    move/from16 v3, v16

    move v4, v7

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->fillRect(IIII)V

    .line 1881
    :cond_c5
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->black_0:S

    move v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-object v6, v6, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    array-length v6, v6

    if-ne v5, v6, :cond_159

    .line 1882
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    sub-int v6, v15, v14

    const/4 v7, 0x4

    sub-int/2addr v6, v7

    const/4 v7, 0x1

    or-int/lit8 v7, v7, 0x20

    const/4 v8, 0x0

    move-object v0, v5

    move/from16 v1, v17

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/GameRun;->drawZero(IIII)V

    goto/16 :goto_34

    .line 1872
    .restart local v7    # "FONT_W":I
    :cond_ec
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-object v6, v6, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    aget-object v6, v6, v18

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ldm/Ms;->getStringWidth(Ljava/lang/String;)I

    move-result v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v8, v0

    iget-object v8, v8, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    aget-object v8, v8, v18

    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lmain/GameRun;->getSIndexW(Ljava/lang/String;)S

    move-result v6

    sub-int/2addr v5, v6

    move v0, v5

    int-to-short v0, v0

    move/from16 v20, v0

    .line 1873
    .local v20, "sw":S
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    aget-object v5, v5, v18

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    sub-int v5, v16, v20

    shr-int/lit8 v10, v5, 0x1

    add-int/lit8 v5, v14, 0x4

    mul-int/lit8 v5, v18, 0x1d

    add-int v5, v5, p2

    add-int/lit8 v11, v5, 0x6

    const/4 v12, 0x0

    const/4 v13, 0x0

    invoke-virtual/range {v8 .. v13}, Ldm/Ui;->drawStringColor(Ljava/lang/String;IIII)V

    goto/16 :goto_88

    .line 1864
    .end local v20    # "sw":S
    :cond_140
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->black_0:S

    move v5, v0

    move/from16 v0, v18

    move v1, v5

    if-gt v0, v1, :cond_9d

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    array-length v5, v5

    move/from16 v0, v18

    move v1, v5

    if-lt v0, v1, :cond_37

    goto/16 :goto_9d

    .line 1883
    .end local v7    # "FONT_W":I
    :cond_159
    if-nez p3, :cond_182

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->black_1:S

    move v5, v0

    add-int/lit8 v5, v5, 0xa

    int-to-short v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->black_1:S

    move v0, v5

    move/from16 v1, v17

    if-lt v0, v1, :cond_182

    .line 1884
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->black_1:S

    .line 1885
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->black_0:S

    move v5, v0

    add-int/lit8 v5, v5, 0x1

    int-to-short v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->black_0:S

    goto/16 :goto_34

    .line 1886
    :cond_182
    if-eqz p3, :cond_34

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    array-length v5, v5

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->black_0:S

    goto/16 :goto_34
.end method

.method drawMap(Ljavax/microedition/lcdui/Graphics;)V
    .registers 22
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 3275
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->leftCol:S

    move/from16 v18, v0

    .line 3276
    .local v18, "tempLeftCol":I
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->topRow:S

    move/from16 v19, v0

    .line 3277
    .local v19, "tempTopRow":I
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_x:I

    move v5, v0

    if-ltz v5, :cond_87

    .line 3278
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->leftCol:S

    .line 3279
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_x:I

    move v5, v0

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->map_left:I

    .line 3285
    :goto_23
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_y:I

    move v5, v0

    if-ltz v5, :cond_a2

    .line 3286
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->topRow:S

    .line 3287
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_y:I

    move v5, v0

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->map_top:I

    .line 3293
    :goto_3a
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->leftCol:S

    move v5, v0

    mul-int/lit8 v8, v5, 0x14

    .line 3294
    .local v8, "left":I
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->topRow:S

    move v5, v0

    mul-int/lit8 v9, v5, 0x14

    .line 3295
    .local v9, "top":I
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->firstDrawMap:B

    move v5, v0

    if-nez v5, :cond_be

    .line 3296
    const/4 v5, 0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->firstDrawMap:B

    .line 3297
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bottomData:[S

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->moduleData:[[S

    move-object v10, v0

    const/4 v12, 0x0

    const/4 v13, 0x0

    sget v14, Lmain/Constants_H;->OFF_WIDTH:I

    sget v15, Lmain/Constants_H;->OFF_HEIGHT:I

    const/16 v16, 0x1

    move-object/from16 v5, p0

    move-object/from16 v11, p1

    invoke-virtual/range {v5 .. v16}, Lmain/Map;->bkgroundToPaint([S[Ljavax/microedition/lcdui/Image;II[[SLjavax/microedition/lcdui/Graphics;IIIIZ)V

    .line 3320
    :cond_73
    :goto_73
    sget-object v5, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    sget-object v6, Lmain/GameRun;->scrT:Ljavax/microedition/lcdui/Image;

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_left:I

    move v7, v0

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_top:I

    move v8, v0

    .end local v8    # "left":I
    const/16 v9, 0x14

    invoke-virtual {v5, v6, v7, v8, v9}, Ljavax/microedition/lcdui/Graphics;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 3321
    .end local v9    # "top":I
    return-void

    .line 3281
    :cond_87
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_x:I

    move v5, v0

    neg-int v5, v5

    div-int/lit8 v5, v5, 0x14

    int-to-short v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->leftCol:S

    .line 3282
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_x:I

    move v5, v0

    rem-int/lit8 v5, v5, 0x14

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->map_left:I

    goto :goto_23

    .line 3289
    :cond_a2
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_y:I

    move v5, v0

    neg-int v5, v5

    div-int/lit8 v5, v5, 0x14

    int-to-short v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->topRow:S

    .line 3290
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_y:I

    move v5, v0

    rem-int/lit8 v5, v5, 0x14

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->map_top:I

    goto/16 :goto_3a

    .line 3299
    .restart local v8    # "left":I
    .restart local v9    # "top":I
    :cond_be
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->leftCol:S

    move v5, v0

    move v0, v5

    move/from16 v1, v18

    if-ne v0, v1, :cond_d2

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->topRow:S

    move v5, v0

    move v0, v5

    move/from16 v1, v19

    if-eq v0, v1, :cond_73

    .line 3300
    :cond_d2
    const/4 v5, 0x0

    const/4 v6, 0x0

    sget v7, Lmain/Constants_H;->OFF_WIDTH:I

    sget v10, Lmain/Constants_H;->OFF_HEIGHT:I

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v10

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 3303
    const/4 v11, 0x0

    const/4 v12, 0x0

    sget v13, Lmain/Constants_H;->OFF_WIDTH:I

    sget v14, Lmain/Constants_H;->OFF_HEIGHT:I

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->leftCol:S

    move v5, v0

    sub-int v5, v18, v5

    mul-int/lit8 v15, v5, 0x14

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->topRow:S

    move v5, v0

    sub-int v5, v19, v5

    mul-int/lit8 v16, v5, 0x14

    const/16 v17, 0x14

    move-object/from16 v10, p1

    invoke-virtual/range {v10 .. v17}, Ljavax/microedition/lcdui/Graphics;->copyArea(IIIIIII)V

    .line 3304
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->leftCol:S

    move v5, v0

    move v0, v5

    move/from16 v1, v18

    if-ge v0, v1, :cond_160

    .line 3305
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bottomData:[S

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->moduleData:[[S

    move-object v10, v0

    .line 3306
    const/4 v12, 0x0

    const/4 v13, 0x0

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->leftCol:S

    move v5, v0

    sub-int v5, v18, v5

    mul-int/lit8 v14, v5, 0x14

    sget v15, Lmain/Constants_H;->OFF_HEIGHT:I

    const/16 v16, 0x1

    move-object/from16 v5, p0

    move-object/from16 v11, p1

    .line 3305
    invoke-virtual/range {v5 .. v16}, Lmain/Map;->bkgroundToPaint([S[Ljavax/microedition/lcdui/Image;II[[SLjavax/microedition/lcdui/Graphics;IIIIZ)V

    .line 3311
    :cond_12f
    :goto_12f
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->topRow:S

    move v5, v0

    move v0, v5

    move/from16 v1, v19

    if-ge v0, v1, :cond_195

    .line 3312
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bottomData:[S

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->moduleData:[[S

    move-object v10, v0

    .line 3313
    const/4 v12, 0x0

    const/4 v13, 0x0

    sget v14, Lmain/Constants_H;->OFF_WIDTH:I

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->topRow:S

    move v5, v0

    sub-int v5, v19, v5

    mul-int/lit8 v15, v5, 0x14

    const/16 v16, 0x1

    move-object/from16 v5, p0

    move-object/from16 v11, p1

    .line 3312
    invoke-virtual/range {v5 .. v16}, Lmain/Map;->bkgroundToPaint([S[Ljavax/microedition/lcdui/Image;II[[SLjavax/microedition/lcdui/Graphics;IIIIZ)V

    goto/16 :goto_73

    .line 3307
    :cond_160
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->leftCol:S

    move v5, v0

    move v0, v5

    move/from16 v1, v18

    if-le v0, v1, :cond_12f

    .line 3308
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bottomData:[S

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->moduleData:[[S

    move-object v10, v0

    .line 3309
    sget v5, Lmain/Constants_H;->OFF_WIDTH:I

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->leftCol:S

    move v11, v0

    sub-int v11, v18, v11

    mul-int/lit8 v11, v11, 0x14

    add-int v12, v5, v11

    const/4 v13, 0x0

    sget v14, Lmain/Constants_H;->OFF_WIDTH:I

    sget v15, Lmain/Constants_H;->OFF_HEIGHT:I

    const/16 v16, 0x1

    move-object/from16 v5, p0

    move-object/from16 v11, p1

    .line 3308
    invoke-virtual/range {v5 .. v16}, Lmain/Map;->bkgroundToPaint([S[Ljavax/microedition/lcdui/Image;II[[SLjavax/microedition/lcdui/Graphics;IIIIZ)V

    goto :goto_12f

    .line 3314
    :cond_195
    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->topRow:S

    move v5, v0

    move v0, v5

    move/from16 v1, v19

    if-le v0, v1, :cond_73

    .line 3315
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bottomData:[S

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    move-object v7, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->moduleData:[[S

    move-object v10, v0

    .line 3316
    const/4 v12, 0x0

    sget v5, Lmain/Constants_H;->OFF_HEIGHT:I

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->topRow:S

    move v11, v0

    sub-int v11, v19, v11

    mul-int/lit8 v11, v11, 0x14

    add-int v13, v5, v11

    sget v14, Lmain/Constants_H;->OFF_WIDTH:I

    sget v15, Lmain/Constants_H;->OFF_HEIGHT:I

    const/16 v16, 0x1

    move-object/from16 v5, p0

    move-object/from16 v11, p1

    .line 3315
    invoke-virtual/range {v5 .. v16}, Lmain/Map;->bkgroundToPaint([S[Ljavax/microedition/lcdui/Image;II[[SLjavax/microedition/lcdui/Graphics;IIIIZ)V

    goto/16 :goto_73
.end method

.method public drawMyAni(Ldm/Npc;IIII)V
    .registers 15
    .param p1, "my"    # Ldm/Npc;
    .param p2, "my_id"    # I
    .param p3, "x"    # I
    .param p4, "y"    # I
    .param p5, "action_id"    # I

    .prologue
    const/4 v4, 0x4

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 3703
    int-to-byte v6, p2

    .line 3704
    .local v6, "id":B
    iget-byte v0, p1, Ldm/Npc;->now_action:B

    sget-object v1, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v1, v1, v7

    aget-object v1, v1, v6

    invoke-virtual {v1, p5}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_14

    iput-byte v8, p1, Ldm/Npc;->now_action:B

    .line 3706
    :cond_14
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    const/4 v1, 0x2

    if-eq v0, v1, :cond_28

    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-eq v0, v4, :cond_28

    .line 3713
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->imgShadow:Ljavax/microedition/lcdui/Image;

    const/16 v2, 0x21

    invoke-virtual {v0, v1, p3, p4, v2}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 3716
    :cond_28
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    sget-object v1, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v1, v1, v7

    aget-object v1, v1, v6

    sget-object v2, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v2, v2, v7

    aget-object v2, v2, v6

    iget-byte v3, p1, Ldm/Npc;->now_action:B

    invoke-virtual {v2, p5, v3, v8}, Ldm/Sprite;->action(III)I

    move-result v2

    iget-byte v3, p1, Ldm/Npc;->dir:B

    if-ne v3, v4, :cond_67

    move v5, v7

    :goto_43
    move v3, p3

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    .line 3717
    iget-byte v0, p1, Ldm/Npc;->now_time:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p1, Ldm/Npc;->now_time:B

    sget-object v1, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v1, v1, v7

    aget-object v1, v1, v6

    iget-byte v2, p1, Ldm/Npc;->now_action:B

    invoke-virtual {v1, p5, v2, v7}, Ldm/Sprite;->action(III)I

    move-result v1

    if-le v0, v1, :cond_66

    .line 3718
    iget-byte v0, p1, Ldm/Npc;->now_action:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p1, Ldm/Npc;->now_action:B

    .line 3719
    iput-byte v8, p1, Ldm/Npc;->now_time:B

    .line 3723
    :cond_66
    return-void

    :cond_67
    move v5, v8

    .line 3716
    goto :goto_43
.end method

.method public eventCheck()V
    .registers 27

    .prologue
    .line 721
    const/16 v25, 0x0

    .line 724
    .local v25, "event_temp":I
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    if-eqz v5, :cond_12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    array-length v5, v5

    if-lt v12, v5, :cond_13

    .line 1257
    :cond_12
    return-void

    .line 725
    :cond_13
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    if-eqz v5, :cond_2d

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    array-length v6, v6

    if-lt v5, v6, :cond_30

    .line 724
    :cond_2d
    :goto_2d
    add-int/lit8 v12, v12, 0x1

    goto :goto_3

    .line 727
    :cond_30
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->event_state:B

    .line 728
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    array-length v6, v6

    if-lt v5, v6, :cond_5e

    .line 730
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapInfo:[S

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->mapNo:B

    move v6, v0

    mul-int/lit8 v6, v6, 0x2

    add-int/lit8 v6, v6, 0x1

    aget-short v7, v5, v6

    const/4 v8, 0x1

    shl-int/2addr v8, v12

    or-int/2addr v7, v8

    int-to-short v7, v7

    aput-short v7, v5, v6

    goto :goto_2d

    .line 734
    :cond_5e
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    aget-byte v5, v5, v6

    packed-switch v5, :pswitch_data_14a8

    .line 1253
    :cond_71
    :goto_71
    :pswitch_71
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->event_state:B

    move v5, v0

    const/4 v6, 0x1

    if-eq v5, v6, :cond_30

    goto :goto_2d

    .line 736
    :pswitch_7a
    move-object/from16 v0, p0

    move v1, v12

    invoke-direct {v0, v1}, Lmain/Map;->runEvent_dialog(I)V

    goto :goto_71

    .line 739
    :pswitch_81
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 740
    const/4 v5, -0x1

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_144

    .line 741
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x3

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    aget-byte v7, v7, v8

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Npc;->setXY(IIII)V

    .line 742
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/4 v6, -0x1

    iput-byte v6, v5, Ldm/Npc;->frame_c:B

    .line 743
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->srcNpcNo:B

    move v5, v0

    const/4 v6, -0x1

    if-ne v5, v6, :cond_12e

    .line 744
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v6, v5, v6

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->cols:S

    move v7, v0

    sget-byte v8, Lmain/Constants_H;->XCELLS:B

    sget-byte v9, Lmain/Constants_H;->HALF_XCELLS:B

    sget v10, Lmain/Constants_H;->WIDTH:I

    const/16 v11, 0x14

    move-object/from16 v5, p0

    invoke-direct/range {v5 .. v11}, Lmain/Map;->map_set(IIIIII)I

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->map_x:I

    .line 745
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x4

    aget-byte v6, v5, v6

    move-object/from16 v0, p0

    iget-short v0, v0, Lmain/Map;->rows:S

    move v7, v0

    sget-byte v8, Lmain/Constants_H;->YCELLS:B

    sget-byte v9, Lmain/Constants_H;->HALF_YCELLS:B

    sget v10, Lmain/Constants_H;->HEIGHT:I

    const/16 v11, 0x14

    move-object/from16 v5, p0

    invoke-direct/range {v5 .. v11}, Lmain/Map;->map_set(IIIIII)I

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->map_y:I

    .line 754
    :cond_12e
    :goto_12e
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x5

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 755
    const/16 v5, 0x1010

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 748
    :cond_144
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 749
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 750
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 751
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 752
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    invoke-virtual {v5}, Ldm/Npc;->setXY_npc()V

    goto/16 :goto_12e

    .line 758
    :pswitch_1ca
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    if-nez v5, :cond_1e8

    const/4 v5, 0x1

    :goto_1df
    move-object/from16 v0, p0

    move v1, v12

    move v2, v5

    invoke-direct {v0, v1, v2}, Lmain/Map;->setEventNow(IZ)V

    goto/16 :goto_71

    :cond_1e8
    const/4 v5, 0x0

    goto :goto_1df

    .line 761
    :pswitch_1ea
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->monInfoList:[B

    const/16 v6, 0x67

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    if-lt v5, v6, :cond_228

    const/4 v5, 0x1

    move v10, v5

    .line 762
    .local v10, "bt":Z
    :goto_20b
    const/4 v7, 0x4

    const/16 v8, 0x10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v9, v5, v6

    move-object/from16 v5, p0

    move v6, v12

    invoke-direct/range {v5 .. v10}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 761
    .end local v10    # "bt":Z
    :cond_228
    const/4 v5, 0x0

    move v10, v5

    goto :goto_20b

    .line 765
    :pswitch_22b
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->initBoat(I)V

    .line 766
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 767
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 770
    :pswitch_259
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    add-int/lit8 v6, v6, 0x1

    int-to-byte v6, v6

    iput-byte v6, v5, Lmain/GameRun;->overMode:B

    .line 771
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    goto/16 :goto_71

    .line 775
    :pswitch_283
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x18

    if-eq v5, v6, :cond_299

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x19

    if-ne v5, v6, :cond_2d4

    .line 776
    :cond_299
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 777
    const/4 v5, 0x0

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    .line 778
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x18

    if-ne v5, v6, :cond_2ca

    .line 779
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const-string v6, "\u4fdd\u5b58\u8fdb\u5ea6\u5b8c\u6210"

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 780
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/GameRun;->saveGame()V

    .line 782
    :cond_2ca
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/4 v6, 0x0

    iput-byte v6, v5, Ldm/Npc;->state:B

    goto/16 :goto_71

    .line 783
    :cond_2d4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->frame_c:B

    const/4 v6, -0x1

    if-ne v5, v6, :cond_71

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x17

    if-eq v5, v6, :cond_71

    .line 784
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0x17

    iput-byte v6, v5, Ldm/Npc;->state:B

    goto/16 :goto_71

    .line 788
    :pswitch_2f4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 789
    const/4 v5, -0x1

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_362

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    sput-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    .line 791
    :goto_316
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    aget-byte v7, v7, v8

    invoke-virtual {v5, v6, v7}, Ldm/Npc;->setLastAction(ZI)V

    .line 792
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 793
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    const/4 v6, 0x0

    iput-byte v6, v5, Ldm/Npc;->now_action:B

    .line 794
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x5

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 795
    const/16 v5, 0x1000

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 790
    :cond_362
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v6

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v6

    aget-object v5, v5, v6

    sput-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    goto :goto_316

    .line 798
    :pswitch_37e
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 799
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 800
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->rmsOther:[B

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    mul-int/lit8 v6, v6, 0x2

    add-int/lit8 v6, v6, 0x4

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v7, v0

    shl-int/2addr v6, v7

    and-int/2addr v5, v6

    if-eqz v5, :cond_71

    .line 801
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 802
    const/16 v5, 0x1011

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 807
    :pswitch_3de
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 808
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 809
    invoke-static {}, Lminigame/Mg;->i()Lminigame/Mg;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v7, v0

    const/4 v8, -0x1

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v9, v0

    invoke-virtual {v5, v6, v7, v8, v9}, Lminigame/Mg;->go(Lmain/GameRun;III)V

    .line 810
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 811
    const/16 v5, 0x1011

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 815
    :pswitch_439
    move-object/from16 v0, p0

    move v1, v12

    invoke-direct {v0, v1}, Lmain/Map;->runEvent_item_add_del(I)V

    goto/16 :goto_71

    .line 818
    :pswitch_441
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->magic_id:B

    const/4 v6, -0x2

    if-ne v5, v6, :cond_4d1

    .line 819
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0xa

    iput-byte v6, v5, Ldm/Npc;->state:B

    .line 820
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    iput-byte v6, v5, Lmain/GameRun;->magic_id:B

    .line 821
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_x:I

    move v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    mul-int/lit8 v7, v7, 0x14

    add-int/2addr v6, v7

    add-int/lit8 v6, v6, 0xa

    iput v6, v5, Lmain/GameRun;->magic_x:I

    .line 822
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_y:I

    move v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    aget-byte v7, v7, v8

    mul-int/lit8 v7, v7, 0x14

    add-int/2addr v6, v7

    add-int/lit8 v6, v6, 0x14

    iput v6, v5, Lmain/GameRun;->magic_y:I

    .line 823
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    div-int/lit8 v6, v6, 0x5

    invoke-virtual {v5, v6}, Lmain/GameRun;->setMagic(I)V

    goto/16 :goto_71

    .line 824
    :cond_4d1
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->magic_id:B

    const/4 v6, -0x1

    if-ne v5, v6, :cond_71

    .line 825
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, -0x2

    iput-byte v6, v5, Lmain/GameRun;->magic_id:B

    .line 826
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x5

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 827
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 831
    :pswitch_4f9
    move-object/from16 v0, p0

    move v1, v12

    invoke-direct {v0, v1}, Lmain/Map;->runEvent_getMon(I)V

    goto/16 :goto_71

    .line 834
    :pswitch_501
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->eventGoing:B

    move v5, v0

    if-nez v5, :cond_567

    .line 835
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    invoke-virtual {v5, v6, v7}, Lmain/GameRun;->findMonsterMinLv(II)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 836
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v5, v0

    const/4 v6, -0x1

    if-eq v5, v6, :cond_55d

    .line 837
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    invoke-virtual {v5, v6}, Lmain/GameRun;->delMonster(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 838
    const/4 v5, 0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->eventGoing:B

    goto/16 :goto_71

    .line 840
    :cond_55d
    const/4 v5, 0x0

    move-object/from16 v0, p0

    move v1, v12

    move v2, v5

    invoke-direct {v0, v1, v2}, Lmain/Map;->setEventNow(IZ)V

    goto/16 :goto_71

    .line 842
    :cond_567
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->say_c:B

    if-nez v5, :cond_71

    .line 843
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v5, v0

    const/4 v6, -0x1

    if-ne v5, v6, :cond_582

    .line 844
    const/4 v5, 0x0

    move-object/from16 v0, p0

    move v1, v12

    move v2, v5

    invoke-direct {v0, v1, v2}, Lmain/Map;->setEventNow(IZ)V

    goto/16 :goto_71

    .line 846
    :cond_582
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x1

    aget-byte v7, v7, v8

    add-int/lit8 v7, v7, 0x2

    add-int/2addr v6, v7

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 847
    const/16 v5, 0x1110

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 853
    :pswitch_5ab
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 854
    const/4 v5, -0x1

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_620

    .line 855
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 856
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    packed-switch v5, :pswitch_data_1516

    .line 874
    :goto_5f7
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 875
    const/16 v5, 0x1010

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 859
    :pswitch_60d
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/4 v6, 0x0

    iput-byte v6, v5, Ldm/Npc;->state:B

    goto :goto_5f7

    .line 863
    :pswitch_616
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0xa

    iput-byte v6, v5, Ldm/Npc;->state:B

    goto :goto_5f7

    .line 867
    :cond_620
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 868
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 869
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    goto :goto_5f7

    .line 878
    :pswitch_665
    move-object/from16 v0, p0

    move v1, v12

    invoke-direct {v0, v1}, Lmain/Map;->runEvent_miniGame_myLevel(I)V

    goto/16 :goto_71

    .line 882
    :pswitch_66d
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    invoke-virtual {v5, v6}, Ldm/Sound;->setMusicId(I)V

    .line 883
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Ldm/Sound;->setMusic(Z)V

    .line 884
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 885
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 888
    :pswitch_6a4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0xa

    iput-byte v6, v5, Ldm/Npc;->state:B

    .line 889
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->sleep_count:B

    move v5, v0

    add-int/lit8 v5, v5, 0x1

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->sleep_count:B

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    if-ne v5, v6, :cond_71

    .line 890
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->sleep_count:B

    .line 891
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 892
    const/16 v5, 0x11

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 896
    :pswitch_6ea
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0xa

    iput-byte v6, v5, Ldm/Npc;->state:B

    .line 897
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->xxx:B

    .line 898
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 899
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 902
    :pswitch_720
    move-object/from16 v0, p0

    move v1, v12

    invoke-direct {v0, v1}, Lmain/Map;->runEvent_goShop(I)V

    goto/16 :goto_71

    .line 905
    :pswitch_728
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    move v1, v5

    invoke-virtual {v0, v1}, Lmain/Map;->initSrcEffect(I)Z

    move-result v5

    if-eqz v5, :cond_71

    .line 906
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 907
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 912
    :pswitch_759
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->eventGoing:B

    move v5, v0

    if-nez v5, :cond_801

    .line 913
    const/4 v5, 0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->eventGoing:B

    .line 915
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    if-nez v5, :cond_7ae

    .line 916
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bMission:[B

    move-object v5, v0

    const/16 v6, 0xe

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x2

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 917
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->bMission:[B

    move-object v5, v0

    const/16 v6, 0xe

    aget-byte v5, v5, v6

    const/4 v6, -0x1

    if-eq v5, v6, :cond_71

    .line 918
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const-string v6, "#4\u4e3b\u7ebf\u4efb\u52a1#0\u5df2\u66f4\u65b0\uff0c\u70b9\u51fb#7\u5de5\u5177\u5305\u5185\u7684\u4e3b\u7ebf\u6309\u94ae#0\u53ef\u67e5\u770b\u4efb\u52a1\u8868\u3002"

    const/4 v7, -0x1

    invoke-virtual {v5, v6, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_71

    .line 921
    :cond_7ae
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x3

    aget-byte v6, v6, v7

    const/4 v7, 0x2

    if-ne v6, v7, :cond_7ff

    const/4 v6, 0x1

    :goto_7d6
    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Lmain/Map;->setMission(IZ)V

    .line 922
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    const/4 v6, 0x2

    if-ne v5, v6, :cond_71

    .line 923
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const-string v6, "#4\u5206\u652f\u4efb\u52a1#0\u5df2\u66f4\u65b0\uff0c\u70b9\u51fb#7\u5de5\u5177\u5305\u5185\u7684\u652f\u7ebf\u6309\u94ae#0\u53ef\u67e5\u770b\u4efb\u52a1\u8868\u3002"

    const/4 v7, -0x1

    invoke-virtual {v5, v6, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_71

    .line 921
    :cond_7ff
    const/4 v6, 0x0

    goto :goto_7d6

    .line 926
    :cond_801
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->say_c:B

    if-nez v5, :cond_71

    .line 927
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 928
    const/16 v5, 0x110

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 932
    :pswitch_820
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0xa

    iput-byte v6, v5, Ldm/Npc;->state:B

    .line 933
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 934
    const/4 v5, -0x1

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_8c1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    sput-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    .line 936
    :goto_84b
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x3

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    aget-byte v7, v7, v8

    invoke-virtual {v5, v6, v7}, Ldm/Npc;->setIXY(II)V

    .line 937
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x5

    aget-byte v6, v6, v7

    iput-byte v6, v5, Ldm/Npc;->speed:B

    .line 938
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x6

    aget-byte v6, v6, v7

    if-nez v6, :cond_8de

    const/4 v6, 0x1

    :goto_8a1
    iput-boolean v6, v5, Ldm/Npc;->b_check:Z

    .line 939
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    const/4 v6, 0x0

    const/16 v7, 0x7f

    invoke-virtual {v5, v6, v7}, Ldm/Npc;->setLastAction(ZI)V

    .line 940
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x7

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 941
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 935
    :cond_8c1
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v6

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v6

    aget-object v5, v5, v6

    sput-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    goto/16 :goto_84b

    .line 938
    :cond_8de
    const/4 v6, 0x0

    goto :goto_8a1

    .line 946
    :pswitch_8e0
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0xa

    iput-byte v6, v5, Ldm/Npc;->state:B

    .line 947
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 948
    const/4 v5, -0x1

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_9aa

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    sput-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    .line 950
    :goto_90b
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x6

    aget-byte v7, v7, v8

    invoke-virtual {v5, v6, v7}, Ldm/Npc;->setLastAction(ZI)V

    .line 951
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x3

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    aget-byte v7, v7, v8

    invoke-virtual {v5, v6, v7}, Ldm/Npc;->setIXY(II)V

    .line 952
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x5

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 953
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x5

    aget-byte v5, v5, v6

    if-gez v5, :cond_97e

    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    const/4 v6, 0x4

    iput-byte v6, v5, Ldm/Npc;->dir:B

    .line 954
    :cond_97e
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x7

    aget-byte v6, v6, v7

    iput-byte v6, v5, Ldm/Npc;->speed:B

    .line 955
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x8

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 956
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 949
    :cond_9aa
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v6

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v6

    aget-object v5, v5, v6

    sput-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    goto/16 :goto_90b

    .line 959
    :pswitch_9c7
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 960
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 961
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 962
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Lmain/Map;->setRestEvent(II)V

    .line 963
    const/16 v5, 0x1010

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 966
    :pswitch_a1c
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 967
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 968
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 969
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Lmain/Map;->setOverEvent(II)V

    .line 970
    const/16 v5, 0x1010

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 974
    :pswitch_a71
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x3

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    aget-byte v7, v7, v8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v8, v0

    aget-object v8, v8, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v9, v0

    aget-short v9, v9, v12

    add-int/lit8 v9, v9, 0x5

    aget-byte v8, v8, v9

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    move v3, v7

    move v4, v8

    invoke-direct {v0, v1, v2, v3, v4}, Lmain/Map;->exitBoss(IIII)V

    .line 977
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x6

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 978
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 981
    :pswitch_ad8
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 982
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 983
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 984
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    add-int/lit8 v7, v7, 0x1

    int-to-byte v7, v7

    aput-byte v7, v5, v6

    .line 985
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 986
    const/16 v5, 0x1010

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 989
    :pswitch_b4a
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 990
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 992
    const/4 v13, 0x5

    const/16 v14, 0x1010

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x4

    aget-byte v15, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    invoke-direct {v0, v1, v2}, Lmain/Map;->isMapEvent(II)Z

    move-result v16

    move-object/from16 v11, p0

    invoke-direct/range {v11 .. v16}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 995
    :pswitch_ba6
    move-object/from16 v0, p0

    move v1, v12

    invoke-direct {v0, v1}, Lmain/Map;->runEvent_srcMove(I)V

    goto/16 :goto_71

    .line 998
    :pswitch_bae
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0xa

    iput-byte v6, v5, Ldm/Npc;->state:B

    .line 999
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    shl-int/lit8 v5, v5, 0x1

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->srcFlash_c:B

    .line 1000
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1001
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 1004
    :pswitch_be7
    move-object/from16 v0, p0

    move v1, v12

    invoke-direct {v0, v1}, Lmain/Map;->runEvent_brow(I)V

    goto/16 :goto_71

    .line 1007
    :pswitch_bef
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v5, 0x0

    sput v5, Ldm/Ms;->skip:I

    .line 1008
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    const-string v6, "data/battle/boss.d"

    const/4 v7, -0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v24

    .line 1009
    .local v24, "data":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    move-object v0, v5

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v23

    .line 1010
    .local v23, "bossStream":[[B
    const/16 v24, 0x0

    check-cast v24, [B

    .line 1011
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x1

    aget-byte v5, v5, v6

    shr-int/lit8 v25, v5, 0x1

    .line 1012
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    const/4 v5, 0x5

    move/from16 v0, v25

    move v1, v5

    filled-new-array {v0, v1}, [I

    move-result-object v5

    sget-object v7, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v7, v5}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [[B

    iput-object v5, v6, Lmain/GameRun;->enemyList:[[B

    .line 1013
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    :goto_c40
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v5, v0

    move v0, v5

    move/from16 v1, v25

    if-lt v0, v1, :cond_c90

    .line 1022
    const/16 v23, 0x0

    check-cast v23, [[B

    .line 1023
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v5

    const/4 v6, 0x6

    invoke-virtual {v5, v6}, Ldm/Sound;->setMusicId(I)V

    .line 1024
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Ldm/Sound;->setMusic(Z)V

    .line 1025
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, 0x3

    invoke-virtual {v5, v6}, Lmain/GameRun;->battleType(I)V

    .line 1026
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/GameRun;->goBattle()V

    .line 1027
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x1

    aget-byte v7, v7, v8

    add-int/lit8 v7, v7, 0x2

    add-int/2addr v6, v7

    int-to-short v6, v6

    aput-short v6, v5, v12

    goto/16 :goto_71

    .line 1014
    :cond_c90
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v7, v0

    mul-int/lit8 v7, v7, 0x2

    add-int/2addr v6, v7

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 1015
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->enemyList:[[B

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v7, v0

    aget-object v7, v23, v7

    const/4 v8, 0x0

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 1017
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->enemyList:[[B

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    const/4 v6, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v9, v0

    mul-int/lit8 v9, v9, 0x2

    add-int/2addr v8, v9

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 1018
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->enemyList:[[B

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    const/4 v6, 0x2

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v7, v0

    aget-object v7, v23, v7

    const/4 v8, 0x1

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 1019
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->enemyList:[[B

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    const/4 v6, 0x3

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v7, v0

    aget-object v7, v23, v7

    const/4 v8, 0x2

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 1020
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->enemyList:[[B

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    const/4 v6, 0x4

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v7, v0

    aget-object v7, v23, v7

    const/4 v8, 0x3

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 1013
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v5, v0

    add-int/lit8 v5, v5, 0x1

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    goto/16 :goto_c40

    .line 1030
    .end local v23    # "bossStream":[[B
    .end local v24    # "data":[B
    :pswitch_d55
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-short v14, v5, Ldm/Npc;->x:S

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-short v15, v5, Ldm/Npc;->y:S

    const/16 v16, 0x13

    const/16 v17, 0x13

    .line 1031
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    mul-int/lit8 v18, v5, 0x14

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    mul-int/lit8 v19, v5, 0x14

    .line 1032
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x4

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    sub-int/2addr v5, v6

    add-int/lit8 v5, v5, 0x1

    mul-int/lit8 v20, v5, 0x14

    .line 1033
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x5

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x3

    aget-byte v6, v6, v7

    sub-int/2addr v5, v6

    add-int/lit8 v5, v5, 0x1

    mul-int/lit8 v21, v5, 0x14

    .line 1030
    invoke-virtual/range {v13 .. v21}, Ldm/Ms;->isRect(IIIIIIII)Z

    move-result v10

    .line 1034
    .restart local v10    # "bt":Z
    const/4 v13, 0x7

    const/16 v14, 0x10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x6

    aget-byte v15, v5, v6

    move-object/from16 v11, p0

    move/from16 v16, v10

    invoke-direct/range {v11 .. v16}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 1041
    .end local v10    # "bt":Z
    :pswitch_e07
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 1042
    const/4 v5, -0x1

    move/from16 v0, v25

    move v1, v5

    if-eq v0, v1, :cond_71

    .line 1043
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 1044
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 1045
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/4 v6, 0x2

    if-ne v5, v6, :cond_e72

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->get_meet:B

    move v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    if-ne v5, v6, :cond_e72

    const/4 v5, 0x1

    move v10, v5

    .line 1046
    .restart local v10    # "bt":Z
    :goto_e54
    const/4 v13, 0x4

    const/16 v14, 0x10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v15, v5, v6

    move-object/from16 v11, p0

    move/from16 v16, v10

    invoke-direct/range {v11 .. v16}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 1045
    .end local v10    # "bt":Z
    :cond_e72
    const/4 v5, 0x0

    move v10, v5

    goto :goto_e54

    .line 1050
    :pswitch_e75
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget v5, v5, Lmain/GameRun;->money:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    mul-int/lit8 v6, v6, 0x64

    if-lt v5, v6, :cond_eb2

    const/4 v5, 0x1

    move v10, v5

    .line 1051
    .restart local v10    # "bt":Z
    :goto_e94
    const/4 v13, 0x4

    const/16 v14, 0x10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v15, v5, v6

    move-object/from16 v11, p0

    move/from16 v16, v10

    invoke-direct/range {v11 .. v16}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 1050
    .end local v10    # "bt":Z
    :cond_eb2
    const/4 v5, 0x0

    move v10, v5

    goto :goto_e94

    .line 1057
    :pswitch_eb5
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, -0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x2

    aget-byte v7, v7, v8

    const/4 v8, 0x1

    invoke-virtual {v5, v6, v7, v8}, Lmain/GameRun;->findItem(IIZ)B

    move-result v25

    .line 1058
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    if-nez v5, :cond_f0b

    if-nez v25, :cond_f08

    const/4 v5, 0x1

    move v10, v5

    .line 1060
    .restart local v10    # "bt":Z
    :goto_eea
    const/4 v13, 0x5

    const/16 v14, 0x10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x4

    aget-byte v15, v5, v6

    move-object/from16 v11, p0

    move/from16 v16, v10

    invoke-direct/range {v11 .. v16}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 1058
    .end local v10    # "bt":Z
    :cond_f08
    const/4 v5, 0x0

    move v10, v5

    goto :goto_eea

    .line 1059
    :cond_f0b
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    move/from16 v0, v25

    move v1, v5

    if-lt v0, v1, :cond_f25

    const/4 v5, 0x1

    move v10, v5

    .restart local v10    # "bt":Z
    :goto_f24
    goto :goto_eea

    .end local v10    # "bt":Z
    :cond_f25
    const/4 v5, 0x0

    move v10, v5

    goto :goto_f24

    .line 1063
    :pswitch_f28
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x2

    aget-byte v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    invoke-virtual {v5, v6, v7}, Lmain/GameRun;->findMonster(II)B

    move-result v5

    const/4 v6, -0x1

    if-eq v5, v6, :cond_f78

    const/4 v5, 0x1

    move v10, v5

    .line 1064
    .restart local v10    # "bt":Z
    :goto_f5a
    const/4 v13, 0x5

    const/16 v14, 0x10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x4

    aget-byte v15, v5, v6

    move-object/from16 v11, p0

    move/from16 v16, v10

    invoke-direct/range {v11 .. v16}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 1063
    .end local v10    # "bt":Z
    :cond_f78
    const/4 v5, 0x0

    move v10, v5

    goto :goto_f5a

    .line 1067
    :pswitch_f7b
    move-object/from16 v0, p0

    move v1, v12

    invoke-direct {v0, v1}, Lmain/Map;->runEvent_select(I)V

    goto/16 :goto_71

    .line 1070
    :pswitch_f83
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 1071
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 1072
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 1073
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/16 v6, 0x8

    aget-byte v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x3

    aget-byte v6, v6, v7

    if-ne v5, v6, :cond_ff5

    .line 1074
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1075
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 1076
    :cond_ff5
    const/4 v5, 0x0

    move-object/from16 v0, p0

    move v1, v12

    move v2, v5

    invoke-direct {v0, v1, v2}, Lmain/Map;->setEventNow(IZ)V

    goto/16 :goto_71

    .line 1079
    :pswitch_fff
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 1080
    const/4 v5, -0x1

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_1070

    .line 1081
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x7

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    invoke-static {v7}, Ldm/Ms;->abs(I)I

    move-result v7

    int-to-byte v7, v7

    aput-byte v7, v5, v6

    .line 1082
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    if-gez v5, :cond_105a

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/4 v6, 0x4

    iput-byte v6, v5, Ldm/Npc;->dir:B

    .line 1088
    :cond_105a
    :goto_105a
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1089
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 1084
    :cond_1070
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v6

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v6

    aget-object v5, v5, v6

    sput-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    .line 1085
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/4 v6, 0x7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 1086
    sget-object v5, Lmain/Map;->cur_npc:Ldm/Npc;

    sget-object v6, Lmain/Map;->npcSp:[[Ldm/Sprite;

    sget-object v7, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v7, v7, Ldm/Npc;->other:[B

    const/4 v8, 0x3

    aget-byte v7, v7, v8

    const/4 v8, 0x1

    sub-int/2addr v7, v8

    aget-object v6, v6, v7

    sget-object v7, Lmain/Map;->cur_npc:Ldm/Npc;

    iget-object v7, v7, Ldm/Npc;->other:[B

    const/4 v8, 0x2

    aget-byte v7, v7, v8

    aget-object v6, v6, v7

    invoke-virtual {v6}, Ldm/Sprite;->aLength()I

    move-result v6

    invoke-virtual {v5, v6}, Ldm/Npc;->setNpcNum(I)V

    goto :goto_105a

    .line 1092
    :pswitch_10c4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 1093
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 1094
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 1095
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/16 v6, 0x8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    aput-byte v7, v5, v6

    .line 1096
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1097
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 1100
    :pswitch_1134
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->eventGoing:B

    move v5, v0

    if-nez v5, :cond_11bb

    .line 1101
    const/4 v5, 0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->eventGoing:B

    .line 1102
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    mul-int/lit8 v25, v5, 0x64

    .line 1103
    if-gez v25, :cond_1178

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget v5, v5, Lmain/GameRun;->money:I

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static/range {v25 .. v25}, Ldm/Ms;->abs(I)I

    move-result v6

    if-ge v5, v6, :cond_1178

    .line 1104
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const-string v6, "\u91d1\u94b1\u4e0d\u8db3\uff01"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1105
    const/4 v5, 0x2

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->eventGoing:B

    .line 1107
    :cond_1178
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->eventGoing:B

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_71

    .line 1108
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget v6, v5, Lmain/GameRun;->money:I

    add-int v6, v6, v25

    iput v6, v5, Lmain/GameRun;->money:I

    .line 1109
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    new-instance v6, Ljava/lang/StringBuilder;

    if-gez v25, :cond_11b8

    const-string v7, "\u5931\u53bb\uff1a"

    :goto_1196
    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    invoke-static/range {v25 .. v25}, Ldm/Ms;->abs(I)I

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\u91d1"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_71

    :cond_11b8
    const-string v7, "\u83b7\u5f97\uff1a"

    goto :goto_1196

    .line 1111
    :cond_11bb
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->say_c:B

    if-nez v5, :cond_71

    .line 1112
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->eventGoing:B

    move v5, v0

    const/4 v6, 0x2

    if-ne v5, v6, :cond_11d6

    .line 1113
    const/4 v5, 0x1

    move-object/from16 v0, p0

    move v1, v12

    move v2, v5

    invoke-direct {v0, v1, v2}, Lmain/Map;->setEventNow(IZ)V

    goto/16 :goto_71

    .line 1115
    :cond_11d6
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1116
    const/16 v5, 0x110

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 1130
    :pswitch_11ec
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int/2addr v5, v6

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->anole_type:B

    .line 1131
    invoke-virtual/range {p0 .. p0}, Lmain/Map;->setAnole()V

    .line 1132
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1133
    const/16 v5, 0x10

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 1137
    :pswitch_121f
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    packed-switch v5, :pswitch_data_1522

    goto/16 :goto_71

    .line 1139
    :pswitch_1236
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->eventGoing:B

    move v5, v0

    if-nez v5, :cond_1278

    .line 1140
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v9, v0

    aget-object v9, v9, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v10, v0

    aget-short v10, v10, v12

    add-int/lit8 v10, v10, 0x3

    aget-byte v9, v9, v10

    invoke-virtual {v6, v7, v8, v9}, Ldm/Ms;->getDialogs([BII)Ljava/lang/String;

    move-result-object v6

    const/4 v7, -0x1

    invoke-virtual {v5, v6, v7}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1141
    const/4 v5, 0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->eventGoing:B

    goto/16 :goto_71

    .line 1142
    :cond_1278
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->say_c:B

    if-nez v5, :cond_71

    .line 1143
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    shl-int/lit8 v7, v7, 0x1

    add-int/lit8 v7, v7, 0x4

    add-int/2addr v6, v7

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1144
    const/16 v5, 0x110

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 1149
    :pswitch_12ac
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->eventGoing:B

    move v5, v0

    if-nez v5, :cond_133a

    .line 1150
    const/16 v22, 0x19

    .line 1151
    .local v22, "FONT_W":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/16 v6, 0x16

    iput-byte v6, v5, Ldm/Npc;->state:B

    .line 1152
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->black_1:S

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->black_0:S

    .line 1154
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v5, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v6, 0x16

    invoke-virtual {v5, v6}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 1155
    const/4 v5, 0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lmain/Map;->fontSizeControl:Z

    .line 1156
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x4

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v9, v0

    aget-object v9, v9, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v10, v0

    aget-short v10, v10, v12

    add-int/lit8 v10, v10, 0x3

    aget-byte v9, v9, v10

    invoke-virtual {v6, v7, v8, v9}, Ldm/Ms;->getDialogs([BII)Ljava/lang/String;

    move-result-object v6

    sget v7, Lmain/Constants_H;->WIDTH__:I

    mul-int/lit8 v8, v22, 0x2

    sub-int/2addr v7, v8

    const/4 v8, 0x3

    invoke-virtual {v5, v6, v7, v8}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 1157
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v5, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v6, 0x1a

    invoke-virtual {v5, v6}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 1158
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lmain/Map;->fontSizeControl:Z

    .line 1160
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->eventGoing:B

    goto/16 :goto_71

    .line 1161
    .end local v22    # "FONT_W":I
    :cond_133a
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->eventGoing:B

    move v5, v0

    const/4 v6, 0x3

    if-ne v5, v6, :cond_71

    .line 1162
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v7, v0

    aget-object v7, v7, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v8, v0

    aget-short v8, v8, v12

    add-int/lit8 v8, v8, 0x3

    aget-byte v7, v7, v8

    shl-int/lit8 v7, v7, 0x1

    add-int/lit8 v7, v7, 0x4

    add-int/2addr v6, v7

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1163
    const/16 v5, 0x110

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    .line 1164
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, 0x0

    iput-object v6, v5, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    .line 1165
    const/4 v5, -0x1

    move v0, v5

    move-object/from16 v1, p0

    iput-short v0, v1, Lmain/Map;->black_0:S

    goto/16 :goto_71

    .line 1177
    :pswitch_137b
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v5, v5, v6

    const/4 v6, 0x1

    sub-int v25, v5, v6

    .line 1178
    const/4 v5, -0x1

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_13d8

    .line 1179
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x3

    aget-byte v5, v5, v6

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 1180
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    iput-byte v6, v5, Ldm/Npc;->dir:B

    .line 1181
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Ldm/Npc;->setActionNo(Z)V

    .line 1190
    :cond_13c2
    :goto_13c2
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x4

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1191
    const/16 v5, 0x1010

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    goto/16 :goto_71

    .line 1183
    :cond_13d8
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcLayer(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV1:B

    .line 1184
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v5, v0

    if-nez v5, :cond_13c2

    .line 1185
    move-object/from16 v0, p0

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lmain/Map;->getNpcId(I)B

    move-result v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->now_eV2:B

    .line 1186
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v6, v0

    aget-object v6, v6, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v7, v0

    aget-short v7, v7, v12

    add-int/lit8 v7, v7, 0x3

    aget-byte v6, v6, v7

    iput-byte v6, v5, Ldm/Npc;->dir:B

    .line 1187
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV1:B

    move v6, v0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->now_eV2:B

    move v6, v0

    aget-object v5, v5, v6

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Ldm/Npc;->setActionNo(Z)V

    goto :goto_13c2

    .line 1222
    :pswitch_1438
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event:[[B

    move-object v5, v0

    aget-object v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v6, v0

    aget-short v6, v6, v12

    add-int/lit8 v6, v6, 0x2

    aget-byte v25, v5, v6

    .line 1224
    if-nez v25, :cond_1462

    .line 1225
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/GameRun;->gameCheckRegIsOK()Z

    move-result v10

    .line 1226
    .restart local v10    # "bt":Z
    const/4 v13, 0x3

    const/16 v14, 0x10

    const/4 v15, 0x2

    move-object/from16 v11, p0

    move/from16 v16, v10

    invoke-direct/range {v11 .. v16}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 1227
    .end local v10    # "bt":Z
    :cond_1462
    const/4 v5, 0x1

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_148e

    .line 1228
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/GameRun;->gameCheckRegIsOK()Z

    move-result v5

    if-nez v5, :cond_71

    .line 1229
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->event_now:[S

    move-object v5, v0

    aget-short v6, v5, v12

    add-int/lit8 v6, v6, 0x3

    int-to-short v6, v6

    aput-short v6, v5, v12

    .line 1230
    const/4 v5, 0x0

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->nextEvent(I)V

    .line 1231
    move-object/from16 v0, p0

    move v1, v12

    invoke-virtual {v0, v1}, Lmain/Map;->checkRegWhere0(I)V

    goto/16 :goto_71

    .line 1233
    :cond_148e
    const/4 v5, 0x2

    move/from16 v0, v25

    move v1, v5

    if-ne v0, v1, :cond_71

    .line 1234
    const/4 v13, 0x3

    const/16 v14, 0x10

    const/4 v15, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/GameRun;->gameCheckRegIsOK()Z

    move-result v16

    move-object/from16 v11, p0

    invoke-direct/range {v11 .. v16}, Lmain/Map;->ifEvent(IIIIZ)V

    goto/16 :goto_71

    .line 734
    :pswitch_data_14a8
    .packed-switch 0x1
        :pswitch_e07
        :pswitch_b4a
        :pswitch_e75
        :pswitch_1ea
        :pswitch_eb5
        :pswitch_d55
        :pswitch_71
        :pswitch_f28
        :pswitch_71
        :pswitch_71
        :pswitch_f83
        :pswitch_f7b
        :pswitch_759
        :pswitch_71
        :pswitch_1ca
        :pswitch_720
        :pswitch_a1c
        :pswitch_439
        :pswitch_bef
        :pswitch_71
        :pswitch_1134
        :pswitch_a71
        :pswitch_9c7
        :pswitch_22b
        :pswitch_259
        :pswitch_4f9
        :pswitch_501
        :pswitch_7a
        :pswitch_2f4
        :pswitch_820
        :pswitch_137b
        :pswitch_665
        :pswitch_11ec
        :pswitch_71
        :pswitch_5ab
        :pswitch_ad8
        :pswitch_8e0
        :pswitch_be7
        :pswitch_37e
        :pswitch_fff
        :pswitch_81
        :pswitch_3de
        :pswitch_10c4
        :pswitch_1438
        :pswitch_ba6
        :pswitch_66d
        :pswitch_6a4
        :pswitch_bae
        :pswitch_441
        :pswitch_283
        :pswitch_121f
        :pswitch_6ea
        :pswitch_728
    .end packed-switch

    .line 856
    :pswitch_data_1516
    .packed-switch 0x0
        :pswitch_60d
        :pswitch_616
        :pswitch_60d
        :pswitch_616
    .end packed-switch

    .line 1137
    :pswitch_data_1522
    .packed-switch 0x0
        :pswitch_1236
        :pswitch_12ac
        :pswitch_12ac
    .end packed-switch
.end method

.method public exitMap([[B)B
    .registers 6
    .param p1, "door"    # [[B

    .prologue
    const/4 v3, 0x3

    .line 434
    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v1, p1, v1

    aget-byte v1, v1, v3

    const/4 v2, -0x1

    if-ne v1, v2, :cond_18

    .line 435
    iget-byte v0, p0, Lmain/Map;->mapNo:B

    .line 436
    .local v0, "go":B
    iget-byte v1, p0, Lmain/Map;->lastMap:B

    iput-byte v1, p0, Lmain/Map;->mapNo:B

    .line 437
    iput-byte v0, p0, Lmain/Map;->lastMap:B

    .line 438
    iget-byte v1, p0, Lmain/Map;->get_meet:B

    iput-byte v1, p0, Lmain/Map;->lastExit:B

    .line 439
    const/4 v0, -0x1

    .line 447
    :goto_17
    return v0

    .line 441
    .end local v0    # "go":B
    :cond_18
    iget-byte v0, p0, Lmain/Map;->mapNo:B

    .line 442
    .restart local v0    # "go":B
    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v1, p1, v1

    const/4 v2, 0x4

    aget-byte v1, v1, v2

    iput-byte v1, p0, Lmain/Map;->mapNo:B

    .line 443
    iput-byte v0, p0, Lmain/Map;->lastMap:B

    .line 444
    iget-byte v1, p0, Lmain/Map;->get_meet:B

    iput-byte v1, p0, Lmain/Map;->lastExit:B

    .line 445
    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v1, p1, v1

    aget-byte v0, v1, v3

    goto :goto_17
.end method

.method public getMySpeed()B
    .registers 6

    .prologue
    const/16 v4, 0xa

    const/4 v3, 0x6

    const/4 v2, 0x5

    .line 2146
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    if-nez v0, :cond_a

    move v0, v3

    .line 2154
    :goto_9
    return v0

    .line 2147
    :cond_a
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_11

    move v0, v3

    goto :goto_9

    .line 2148
    :cond_11
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    const/4 v1, 0x2

    if-ne v0, v1, :cond_18

    move v0, v4

    goto :goto_9

    .line 2149
    :cond_18
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1f

    move v0, v2

    goto :goto_9

    .line 2153
    :cond_1f
    iget-byte v0, p0, Lmain/Map;->anole_type:B

    const/4 v1, 0x3

    if-ne v0, v1, :cond_26

    move v0, v4

    goto :goto_9

    :cond_26
    move v0, v2

    .line 2154
    goto :goto_9
.end method

.method public goMiniMap()V
    .registers 8

    .prologue
    const/4 v6, 0x0

    const/4 v5, -0x1

    .line 2809
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3}, Ldm/Ms;->keyRelease()V

    .line 2810
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    const-string v4, "data/map.d"

    invoke-virtual {v3, v4, v5}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v0

    .line 2811
    .local v0, "data":[B
    sput v6, Ldm/Ms;->skip:I

    .line 2812
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v3

    iput-object v3, p0, Lmain/Map;->mapdataArea:[[B

    .line 2813
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3, v0}, Ldm/Ms;->create2Array([B)[[B

    move-result-object v3

    iput-object v3, p0, Lmain/Map;->mapdataMap:[[B

    .line 2814
    const/4 v0, 0x0

    check-cast v0, [B

    .line 2816
    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v4, 0x11

    iput-byte v4, v3, Ldm/Npc;->state:B

    .line 2817
    iput-byte v5, p0, Lmain/Map;->showArea:B

    .line 2818
    iput-byte v5, p0, Lmain/Map;->myMiniMap:B

    .line 2819
    iput-byte v6, p0, Lmain/Map;->selectMap:B

    .line 2820
    const/4 v1, 0x0

    .line 2821
    .local v1, "i":B
    :goto_39
    iget-object v3, p0, Lmain/Map;->mapdataArea:[[B

    array-length v3, v3

    if-lt v1, v3, :cond_3f

    .line 2841
    :goto_3e
    return-void

    .line 2822
    :cond_3f
    const/4 v2, 0x0

    .local v2, "k":B
    :goto_40
    iget-object v3, p0, Lmain/Map;->mapdataArea:[[B

    aget-object v3, v3, v1

    array-length v3, v3

    if-lt v2, v3, :cond_4b

    .line 2821
    add-int/lit8 v3, v1, 0x1

    int-to-byte v1, v3

    goto :goto_39

    .line 2823
    :cond_4b
    iget-byte v3, p0, Lmain/Map;->mapNo:B

    iget-object v4, p0, Lmain/Map;->mapdataArea:[[B

    aget-object v4, v4, v1

    aget-byte v4, v4, v2

    if-ne v3, v4, :cond_78

    .line 2824
    iget-byte v3, p0, Lmain/Map;->mapNo:B

    iput-byte v3, p0, Lmain/Map;->selectMap:B

    .line 2825
    iget-object v3, p0, Lmain/Map;->mapdataMap:[[B

    iget-byte v4, p0, Lmain/Map;->selectMap:B

    aget-object v3, v3, v4

    array-length v3, v3

    if-lez v3, :cond_78

    .line 2826
    iget-byte v3, p0, Lmain/Map;->selectMap:B

    iput-byte v3, p0, Lmain/Map;->myMiniMap:B

    .line 2827
    iput-byte v1, p0, Lmain/Map;->showArea:B

    .line 2828
    iget-object v3, p0, Lmain/Map;->mapdataArea:[[B

    iget-byte v4, p0, Lmain/Map;->showArea:B

    aget-object v3, v3, v4

    aget-byte v3, v3, v6

    if-le v3, v5, :cond_76

    const/4 v3, 0x1

    :goto_73
    iput-boolean v3, p0, Lmain/Map;->miniMapMode:Z

    goto :goto_3e

    :cond_76
    move v3, v6

    goto :goto_73

    .line 2822
    :cond_78
    add-int/lit8 v3, v2, 0x1

    int-to-byte v2, v3

    goto :goto_40
.end method

.method public goMission(IZ)V
    .registers 14
    .param p1, "type"    # I
    .param p2, "b"    # Z

    .prologue
    .line 2888
    const/16 v0, 0x280

    .line 2889
    .local v0, "WIDTH":I
    iget-object v6, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v6, v6, Ldm/Npc;->state:B

    const/16 v7, 0x12

    if-eq v6, v7, :cond_11

    iget-object v6, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v6, v6, Ldm/Npc;->state:B

    if-eqz v6, :cond_11

    .line 2928
    :goto_10
    return-void

    .line 2890
    :cond_11
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    invoke-virtual {v6}, Ldm/Ms;->keyRelease()V

    .line 2891
    iput-boolean p2, p0, Lmain/Map;->bPause:Z

    .line 2892
    const/16 v6, -0xa

    sput v6, Lmain/GameRun;->run_state:I

    .line 2893
    iget-object v6, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v7, 0x12

    iput-byte v7, v6, Ldm/Npc;->state:B

    .line 2894
    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    int-to-byte v7, p1

    iput-byte v7, v6, Lmain/GameRun;->cur_a:B

    .line 2895
    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v6, v6, Lmain/GameRun;->select:[[B

    const/4 v7, 0x0

    aget-object v6, v6, v7

    const/4 v7, 0x0

    iget-object v8, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v8, v8, Lmain/GameRun;->select:[[B

    const/4 v9, 0x0

    aget-object v8, v8, v9

    const/4 v9, 0x1

    const/4 v10, 0x0

    aput-byte v10, v8, v9

    aput-byte v10, v6, v7

    .line 2896
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v6, 0x0

    sput v6, Ldm/Ms;->skip:I

    .line 2897
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "data/mission"

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ".t"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const/4 v8, -0x1

    invoke-virtual {v6, v7, v8}, Ldm/Ms;->getStream(Ljava/lang/String;I)[B

    move-result-object v1

    .line 2898
    .local v1, "data":[B
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    invoke-virtual {v6, v1}, Ldm/Ms;->createString2Array([B)[[Ljava/lang/StringBuffer;

    move-result-object v6

    iput-object v6, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    .line 2906
    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v7, 0x6

    iput-byte v7, v6, Lmain/GameRun;->line_max:B

    .line 2908
    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v7, 0x0

    iput-object v7, v6, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    .line 2910
    const/4 v6, 0x1

    if-ne p1, v6, :cond_d2

    .line 2911
    const/4 v2, 0x0

    .local v2, "i":B
    const/4 v3, 0x0

    .local v3, "j":B
    const/16 v6, 0x32

    new-array v5, v6, [B

    .line 2912
    .local v5, "tMis":[B
    :goto_7f
    iget-object v6, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    array-length v6, v6

    if-lt v2, v6, :cond_c2

    .line 2915
    const/4 v6, 0x0

    iput-object v6, p0, Lmain/Map;->mDirect:[B

    .line 2916
    new-array v6, v3, [B

    iput-object v6, p0, Lmain/Map;->mDirect:[B

    .line 2917
    const/4 v6, 0x0

    iget-object v7, p0, Lmain/Map;->mDirect:[B

    const/4 v8, 0x0

    iget-object v9, p0, Lmain/Map;->mDirect:[B

    array-length v9, v9

    invoke-static {v5, v6, v7, v8, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 2918
    iget-object v6, p0, Lmain/Map;->mDirect:[B

    array-length v6, v6

    if-lez v6, :cond_bd

    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v7, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    iget-object v8, p0, Lmain/Map;->mDirect:[B

    iget-object v9, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v9, v9, Lmain/GameRun;->select:[[B

    const/4 v10, 0x0

    aget-object v9, v9, v10

    const/4 v10, 0x0

    aget-byte v9, v9, v10

    aget-byte v8, v8, v9

    aget-object v7, v7, v8

    const/4 v8, 0x1

    aget-object v7, v7, v8

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x32

    sub-int v8, v0, v8

    const/4 v9, 0x0

    invoke-virtual {v6, v7, v8, v9}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2919
    :cond_bd
    const/4 v5, 0x0

    check-cast v5, [B

    goto/16 :goto_10

    .line 2913
    :cond_c2
    invoke-direct {p0, v2}, Lmain/Map;->isMission(I)Z

    move-result v6

    if-eqz v6, :cond_ce

    add-int/lit8 v6, v3, 0x1

    int-to-byte v4, v6

    .end local v3    # "j":B
    .local v4, "j":B
    aput-byte v2, v5, v3

    move v3, v4

    .line 2912
    .end local v4    # "j":B
    .restart local v3    # "j":B
    :cond_ce
    add-int/lit8 v6, v2, 0x1

    int-to-byte v2, v6

    goto :goto_7f

    .line 2923
    .end local v2    # "i":B
    .end local v3    # "j":B
    .end local v5    # "tMis":[B
    :cond_d2
    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v6, v6, Lmain/GameRun;->select:[[B

    const/4 v7, 0x0

    aget-object v6, v6, v7

    const/4 v7, 0x0

    iget-object v8, p0, Lmain/Map;->bMission:[B

    const/16 v9, 0xe

    aget-byte v8, v8, v9

    aput-byte v8, v6, v7

    .line 2924
    iget-object v6, p0, Lmain/Map;->bMission:[B

    const/16 v7, 0xe

    aget-byte v6, v6, v7

    iget-object v7, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v7, v7, Lmain/GameRun;->line_max:B

    if-lt v6, v7, :cond_12b

    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v6, v6, Lmain/GameRun;->select:[[B

    const/4 v7, 0x0

    aget-object v6, v6, v7

    const/4 v7, 0x1

    iget-object v8, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v8, v8, Lmain/GameRun;->select:[[B

    const/4 v9, 0x0

    aget-object v8, v8, v9

    const/4 v9, 0x0

    aget-byte v8, v8, v9

    iget-object v9, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v9, v9, Lmain/GameRun;->line_max:B

    sub-int/2addr v8, v9

    add-int/lit8 v8, v8, 0x1

    int-to-byte v8, v8

    aput-byte v8, v6, v7

    .line 2926
    :goto_10a
    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v7, p0, Lmain/Map;->sMission:[[Ljava/lang/StringBuffer;

    iget-object v8, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v8, v8, Lmain/GameRun;->select:[[B

    const/4 v9, 0x0

    aget-object v8, v8, v9

    const/4 v9, 0x0

    aget-byte v8, v8, v9

    aget-object v7, v7, v8

    const/4 v8, 0x1

    aget-object v7, v7, v8

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x32

    sub-int v8, v0, v8

    const/4 v9, 0x0

    invoke-virtual {v6, v7, v8, v9}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    goto/16 :goto_10

    .line 2925
    :cond_12b
    iget-object v6, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v6, v6, Lmain/GameRun;->select:[[B

    const/4 v7, 0x0

    aget-object v6, v6, v7

    const/4 v7, 0x1

    const/4 v8, 0x0

    aput-byte v8, v6, v7

    goto :goto_10a
.end method

.method public goNextMap()V
    .registers 9

    .prologue
    const/4 v3, 0x5

    const/4 v7, -0x2

    const/4 v6, 0x1

    const/4 v5, -0x1

    const/4 v4, 0x0

    .line 463
    invoke-virtual {p0}, Lmain/Map;->setfmap()V

    .line 464
    iput-byte v4, p0, Lmain/Map;->firstDrawMap:B

    .line 468
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Lmain/GameRun;->doPaint(I)V

    .line 469
    invoke-virtual {p0}, Lmain/Map;->saveMapBak()V

    .line 470
    iget-byte v0, p0, Lmain/Map;->lastExit:B

    .line 471
    .local v0, "exit_b":B
    iget-byte v1, p0, Lmain/Map;->go:B

    if-eq v1, v7, :cond_27

    .line 472
    iget-byte v1, p0, Lmain/Map;->mapNo:B

    iput-byte v1, p0, Lmain/Map;->lastMap:B

    .line 473
    iget-byte v1, p0, Lmain/Map;->mapNotemp:B

    iput-byte v1, p0, Lmain/Map;->mapNo:B

    .line 474
    iput-byte v4, p0, Lmain/Map;->mapNotemp:B

    .line 475
    iget-byte v1, p0, Lmain/Map;->go:B

    iput-byte v1, p0, Lmain/Map;->lastExit:B

    .line 477
    :cond_27
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v1, v3}, Lmain/GameRun;->doPaint(I)V

    .line 478
    iget-byte v1, p0, Lmain/Map;->go:B

    if-ne v1, v7, :cond_38

    .line 479
    iget-object v1, p0, Lmain/Map;->door:[[B

    invoke-virtual {p0, v1}, Lmain/Map;->exitMap([[B)B

    move-result v1

    iput-byte v1, p0, Lmain/Map;->go:B

    .line 480
    :cond_38
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v1, v4}, Lmain/GameRun;->setNull(Z)V

    .line 481
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lmain/GameRun;->doPaint(I)V

    .line 482
    invoke-virtual {p0}, Lmain/Map;->createOther()V

    .line 483
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0xa

    invoke-virtual {v1, v2}, Lmain/GameRun;->doPaint(I)V

    .line 484
    iget-byte v1, p0, Lmain/Map;->go:B

    if-ne v1, v5, :cond_54

    .line 485
    iput-byte v0, p0, Lmain/Map;->go:B

    .line 487
    :cond_54
    iget-boolean v1, p0, Lmain/Map;->bExitBoss:Z

    if-nez v1, :cond_5f

    iget-byte v1, p0, Lmain/Map;->go:B

    iget-object v2, p0, Lmain/Map;->door:[[B

    invoke-direct {p0, v1, v2}, Lmain/Map;->getInMap(B[[B)V

    .line 488
    :cond_5f
    invoke-virtual {p0}, Lmain/Map;->createEvent()V

    .line 489
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0xf

    invoke-virtual {v1, v2}, Lmain/GameRun;->doPaint(I)V

    .line 490
    invoke-virtual {p0}, Lmain/Map;->createNpcString()V

    .line 492
    invoke-virtual {p0}, Lmain/Map;->createLayer()V

    .line 494
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x14

    invoke-virtual {v1, v2}, Lmain/GameRun;->doPaint(I)V

    .line 495
    iget-boolean v1, p0, Lmain/Map;->bExitBoss:Z

    if-nez v1, :cond_111

    iget-object v1, p0, Lmain/Map;->door:[[B

    iget-byte v2, p0, Lmain/Map;->go:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v3

    if-eq v1, v6, :cond_8f

    iget-object v1, p0, Lmain/Map;->door:[[B

    iget-byte v2, p0, Lmain/Map;->go:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v3

    const/4 v2, 0x2

    if-ne v1, v2, :cond_111

    .line 496
    :cond_8f
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v2, 0x14

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->speed:B

    div-int/2addr v2, v3

    int-to-byte v2, v2

    iput-byte v2, v1, Ldm/Npc;->frame_c:B

    .line 497
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v2, p0, Lmain/Map;->dir_select:[[B

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->dir:B

    aget-object v2, v2, v3

    aget-byte v2, v2, v4

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->speed:B

    mul-int/2addr v2, v3

    int-to-byte v2, v2

    iput-byte v2, v1, Ldm/Npc;->speed_x:B

    .line 498
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-object v2, p0, Lmain/Map;->dir_select:[[B

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->dir:B

    aget-object v2, v2, v3

    aget-byte v2, v2, v6

    iget-object v3, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v3, v3, Ldm/Npc;->speed:B

    mul-int/2addr v2, v3

    int-to-byte v2, v2

    iput-byte v2, v1, Ldm/Npc;->speed_y:B

    .line 499
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v1, v6}, Ldm/Npc;->setActionNo(Z)V

    .line 501
    :goto_c8
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v4, v1, Lmain/GameRun;->b_c:B

    .line 502
    invoke-virtual {p0, v4}, Lmain/Map;->setMapMusic(Z)V

    .line 503
    iput-byte v7, p0, Lmain/Map;->go:B

    .line 504
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, p0, Lmain/Map;->mapNo:B

    invoke-virtual {v1, v2, v6}, Lmain/GameRun;->initMonPro(IZ)V

    .line 505
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x19

    iput-byte v2, v1, Lmain/GameRun;->cityName_c:B

    .line 507
    iput-byte v5, p0, Lmain/Map;->srcNpcNo:B

    .line 508
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x4

    invoke-virtual {v1, v6, v2, v3}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 510
    invoke-direct {p0}, Lmain/Map;->initCloud()V

    .line 512
    iput-boolean v4, p0, Lmain/Map;->bExitBoss:Z

    .line 514
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v2, 0x9

    iput-byte v2, v1, Ldm/Npc;->state:B

    .line 515
    iget-byte v1, p0, Lmain/Map;->boatSelect:B

    if-ne v1, v5, :cond_109

    .line 516
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v4, v1, Ldm/Npc;->state:B

    .line 517
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v1, v5, v5}, Ldm/Npc;->setIXY(II)V

    .line 518
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {p0}, Lmain/Map;->getMySpeed()B

    move-result v2

    iput-byte v2, v1, Ldm/Npc;->speed:B

    .line 525
    :cond_109
    iput-byte v5, p0, Lmain/Map;->checkNpcT:B

    .line 528
    iget-object v1, p0, Lmain/Map;->pkey:Lmain/PointerKey;

    invoke-virtual {v1}, Lmain/PointerKey;->stopMove()V

    .line 530
    return-void

    .line 500
    :cond_111
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v1, v4}, Ldm/Npc;->setActionNo(Z)V

    goto :goto_c8
.end method

.method public initAnoleValue()Z
    .registers 5

    .prologue
    const/4 v3, 0x0

    .line 2113
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v0, v0, Ldm/Npc;->x:S

    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    iget-byte v2, p0, Lmain/Map;->anole_type:B

    invoke-direct {p0, v0, v1, v2}, Lmain/Map;->isAnole(III)Z

    move-result v0

    if-eqz v0, :cond_1a

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v1, "\u4e0d\u80fd\u66f4\u6362\u5750\u9a91"

    invoke-virtual {v0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    move v0, v3

    .line 2118
    :goto_19
    return v0

    .line 2114
    :cond_1a
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0x14

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 2115
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v3, v0, Lmain/GameRun;->cur_a:B

    .line 2116
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v3, v0, Lmain/GameRun;->cur_b:B

    .line 2117
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    const-string v1, "\u4e0b\u5750\u9a91#n\u690d\u7269\u5750\u9a91#n\u91d1\u5c5e\u5750\u9a91#n\u98de\u884c\u5750\u9a91#n\u91ce\u517d\u5750\u9a91#n\u6d77\u6d0b\u5750\u9a91#n\u65e0\u6b64\u5750\u9a91"

    sget v2, Lmain/Constants_H;->WIDTH:I

    invoke-virtual {v0, v1, v2, v3}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 2118
    const/4 v0, 0x1

    goto :goto_19
.end method

.method public initBrowImage()V
    .registers 4

    .prologue
    .line 3452
    iget-object v0, p0, Lmain/Map;->brow:Ldm/Sprite;

    if-nez v0, :cond_11

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "data/face/brow"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;

    move-result-object v0

    iput-object v0, p0, Lmain/Map;->brow:Ldm/Sprite;

    .line 3453
    :cond_11
    return-void
.end method

.method public initData([BI)[B
    .registers 10
    .param p1, "tempdata"    # [B
    .param p2, "n"    # I

    .prologue
    .line 206
    const/4 v2, 0x1

    .line 207
    .local v2, "len":I
    const/4 v1, 0x0

    .local v1, "i":I
    move v3, v2

    .end local v2    # "len":I
    .local v3, "len":I
    :goto_3
    if-lt v1, p2, :cond_1d

    .line 211
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "len":I
    .restart local v2    # "len":I
    aget-byte v5, p1, v3

    and-int/lit16 v5, v5, 0xff

    shl-int/lit8 v5, v5, 0x8

    add-int/lit8 v3, v2, 0x1

    .end local v2    # "len":I
    .restart local v3    # "len":I
    aget-byte v6, p1, v2

    and-int/lit16 v6, v6, 0xff

    or-int v4, v5, v6

    .line 212
    .local v4, "temp":I
    new-array v0, v4, [B

    .line 213
    .local v0, "data":[B
    const/4 v5, 0x0

    array-length v6, v0

    invoke-static {p1, v3, v0, v5, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 214
    return-object v0

    .line 208
    .end local v0    # "data":[B
    .end local v4    # "temp":I
    :cond_1d
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "len":I
    .restart local v2    # "len":I
    aget-byte v5, p1, v3

    and-int/lit16 v5, v5, 0xff

    shl-int/lit8 v5, v5, 0x8

    add-int/lit8 v3, v2, 0x1

    .end local v2    # "len":I
    .restart local v3    # "len":I
    aget-byte v6, p1, v2

    and-int/lit16 v6, v6, 0xff

    or-int v4, v5, v6

    .line 209
    .restart local v4    # "temp":I
    add-int v2, v3, v4

    .line 207
    .end local v3    # "len":I
    .restart local v2    # "len":I
    add-int/lit8 v1, v1, 0x1

    move v3, v2

    .end local v2    # "len":I
    .restart local v3    # "len":I
    goto :goto_3
.end method

.method public initMap()V
    .registers 8

    .prologue
    const/4 v6, 0x4

    const/4 v2, 0x0

    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 284
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v6, v1, Ldm/Npc;->dir:B

    .line 285
    const/4 v1, -0x1

    iput-byte v1, p0, Lmain/Map;->srcNpcNo:B

    .line 286
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v1}, Lmain/GameRun;->loadRmsSms()V

    .line 288
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v1}, Lmain/GameRun;->loadRmsNidus()V

    .line 290
    invoke-virtual {p0, v2, v2}, Lmain/Map;->notMeet(II)V

    .line 291
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    const/16 v3, 0xd

    invoke-virtual {v2, v3, v5, v4}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ldm/Ms;->byteArrayToShortArray([B)[S

    move-result-object v1

    iput-object v1, p0, Lmain/Map;->mapInfo:[S

    .line 292
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v4, v5, v4}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v1

    iput-object v1, p0, Lmain/Map;->mapChange:[B

    .line 295
    const/4 v0, 0x0

    .local v0, "i":S
    :goto_37
    iget-object v1, p0, Lmain/Map;->mapChange:[B

    array-length v1, v1

    if-lt v0, v1, :cond_7e

    .line 301
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 302
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x21

    iput-byte v2, v1, Lmain/GameRun;->createOver:B

    .line 303
    invoke-virtual {p0}, Lmain/Map;->createOther()V

    .line 304
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x23

    iput-byte v2, v1, Lmain/GameRun;->createOver:B

    .line 305
    invoke-virtual {p0}, Lmain/Map;->createLayer()V

    .line 306
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x25

    iput-byte v2, v1, Lmain/GameRun;->createOver:B

    .line 308
    invoke-virtual {p0}, Lmain/Map;->createEvent()V

    .line 309
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x27

    iput-byte v2, v1, Lmain/GameRun;->createOver:B

    .line 310
    invoke-virtual {p0}, Lmain/Map;->createNpcString()V

    .line 311
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    const/16 v2, 0x28

    iput-byte v2, v1, Lmain/GameRun;->createOver:B

    .line 312
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v4, v5, v6}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 313
    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v2, p0, Lmain/Map;->mapNo:B

    invoke-virtual {v1, v2, v4}, Lmain/GameRun;->initMonPro(IZ)V

    .line 314
    invoke-direct {p0}, Lmain/Map;->initMissionList()V

    .line 316
    invoke-direct {p0}, Lmain/Map;->initCloud()V

    .line 318
    return-void

    .line 296
    :cond_7e
    iget-object v1, p0, Lmain/Map;->mapChange:[B

    aget-byte v1, v1, v0

    if-ne v1, v4, :cond_92

    .line 298
    iget-object v1, p0, Lmain/Map;->mapTemp:[[B

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    add-int/lit8 v3, v0, 0xe

    invoke-virtual {v2, v3, v5, v4}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v2

    aput-object v2, v1, v0

    .line 295
    :cond_92
    add-int/lit8 v1, v0, 0x1

    int-to-short v0, v1

    goto :goto_37
.end method

.method public initNpcAni()V
    .registers 14

    .prologue
    const/4 v12, 0x3

    const/4 v11, -0x1

    const/4 v10, 0x2

    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 3547
    const/4 v3, 0x0

    .line 3548
    .local v3, "k":B
    new-array v0, v12, [[B

    .line 3549
    .local v0, "em":[[B
    const/16 v5, 0x64

    new-array v5, v5, [B

    aput-object v5, v0, v9

    .line 3550
    const/4 v5, 0x5

    new-array v5, v5, [B

    aput-object v5, v0, v8

    .line 3551
    const/16 v5, 0x3c

    new-array v5, v5, [B

    aput-object v5, v0, v10

    .line 3553
    iget-object v5, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v5, v9}, Lmain/GameRun;->initNidusMap(I)V

    .line 3555
    iget-object v5, p0, Lmain/Map;->npc:[[Ldm/Npc;

    array-length v5, v5

    sub-int/2addr v5, v8

    int-to-byte v1, v5

    .local v1, "i":B
    :goto_23
    if-gt v1, v11, :cond_60

    .line 3568
    iget-object v5, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v5, v8}, Lmain/GameRun;->initNidusMap(I)V

    .line 3570
    iget-object v5, p0, Lmain/Map;->npcList:[B

    aput-byte v11, v5, v9

    .line 3571
    iget-object v5, p0, Lmain/Map;->item:[[B

    array-length v5, v5

    iget-object v6, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v6, v6, v9

    array-length v6, v6

    add-int/2addr v5, v6

    int-to-byte v1, v5

    :goto_38
    iget-object v5, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v5, v5, v9

    array-length v5, v5

    if-gt v1, v5, :cond_ac

    .line 3573
    const/16 v5, 0x64

    aget-object v6, v0, v9

    invoke-direct {p0, v5, v9, v6}, Lmain/Map;->initNpcAni_1(II[B)V

    .line 3574
    const/4 v5, 0x5

    aget-object v6, v0, v8

    invoke-direct {p0, v5, v8, v6}, Lmain/Map;->initNpcAni_1(II[B)V

    .line 3575
    const/16 v5, 0x3c

    aget-object v6, v0, v10

    invoke-direct {p0, v5, v10, v6}, Lmain/Map;->initNpcAni_1(II[B)V

    .line 3576
    const/4 v0, 0x0

    check-cast v0, [[B

    .line 3577
    iget-object v5, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v5, v5, v9

    array-length v5, v5

    sub-int/2addr v5, v8

    int-to-byte v2, v5

    .local v2, "j":B
    :goto_5d
    if-gt v2, v11, :cond_c0

    .line 3586
    return-void

    .line 3556
    .end local v2    # "j":B
    :cond_60
    iget-object v5, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v5, v5, v1

    array-length v5, v5

    sub-int/2addr v5, v8

    int-to-byte v2, v5

    .restart local v2    # "j":B
    move v4, v3

    .end local v3    # "k":B
    .local v4, "k":B
    :goto_68
    if-gt v2, v11, :cond_6f

    .line 3555
    sub-int v5, v1, v8

    int-to-byte v1, v5

    move v3, v4

    .end local v4    # "k":B
    .restart local v3    # "k":B
    goto :goto_23

    .line 3557
    .end local v3    # "k":B
    .restart local v4    # "k":B
    :cond_6f
    iget-object v5, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v5, v5, v1

    aget-object v5, v5, v2

    iget-object v5, v5, Ldm/Npc;->other:[B

    aget-byte v5, v5, v12

    sub-int/2addr v5, v8

    aget-object v5, v0, v5

    iget-object v6, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v6, v6, v1

    aget-object v6, v6, v2

    iget-object v6, v6, Ldm/Npc;->other:[B

    aget-byte v6, v6, v10

    aput-byte v8, v5, v6

    .line 3558
    if-nez v1, :cond_ed

    .line 3559
    iget-object v5, p0, Lmain/Map;->npcList:[B

    add-int/lit8 v6, v2, 0x1

    aput-byte v2, v5, v6

    .line 3561
    iget-object v5, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v5, v5, v1

    aget-object v5, v5, v2

    iget-object v5, v5, Ldm/Npc;->other:[B

    const/16 v6, 0x8

    aget-byte v5, v5, v6

    if-ne v5, v8, :cond_ed

    .line 3562
    iget-object v5, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v5, v5, Lmain/GameRun;->nidusMap:[B

    add-int/lit8 v6, v4, 0x1

    int-to-byte v3, v6

    .end local v4    # "k":B
    .restart local v3    # "k":B
    aput-byte v2, v5, v4

    .line 3556
    :goto_a7
    sub-int v5, v2, v8

    int-to-byte v2, v5

    move v4, v3

    .end local v3    # "k":B
    .restart local v4    # "k":B
    goto :goto_68

    .line 3572
    .end local v2    # "j":B
    .end local v4    # "k":B
    .restart local v3    # "k":B
    :cond_ac
    iget-object v5, p0, Lmain/Map;->npcList:[B

    const/4 v6, -0x2

    sub-int/2addr v6, v1

    iget-object v7, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v7, v7, v9

    array-length v7, v7

    add-int/2addr v6, v7

    add-int/lit8 v6, v6, 0x1

    int-to-byte v6, v6

    aput-byte v6, v5, v1

    .line 3571
    sub-int v5, v1, v8

    int-to-byte v1, v5

    goto/16 :goto_38

    .line 3584
    .restart local v2    # "j":B
    :cond_c0
    iget-object v5, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v5, v5, v9

    aget-object v5, v5, v2

    sget-object v6, Lmain/Map;->npcSp:[[Ldm/Sprite;

    iget-object v7, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v7, v7, v9

    aget-object v7, v7, v2

    iget-object v7, v7, Ldm/Npc;->other:[B

    aget-byte v7, v7, v12

    sub-int/2addr v7, v8

    aget-object v6, v6, v7

    iget-object v7, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v7, v7, v9

    aget-object v7, v7, v2

    iget-object v7, v7, Ldm/Npc;->other:[B

    aget-byte v7, v7, v10

    aget-object v6, v6, v7

    invoke-virtual {v6}, Ldm/Sprite;->aLength()I

    move-result v6

    invoke-virtual {v5, v6}, Ldm/Npc;->setNpcNum(I)V

    .line 3577
    sub-int v5, v2, v8

    int-to-byte v2, v5

    goto/16 :goto_5d

    .end local v3    # "k":B
    .restart local v4    # "k":B
    :cond_ed
    move v3, v4

    .end local v4    # "k":B
    .restart local v3    # "k":B
    goto :goto_a7
.end method

.method public initNpcAniOne(Ljava/lang/String;II)V
    .registers 9
    .param p1, "sid"    # Ljava/lang/String;
    .param p2, "id"    # I
    .param p3, "type"    # I

    .prologue
    .line 3539
    sget-object v0, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v0, v0, p3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "data/npc"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 3540
    const/4 v3, 0x2

    if-ne p3, v3, :cond_35

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v3, v4}, Lmain/GameRun;->isNpc2ImageType(I)Z

    move-result v3

    .line 3539
    :goto_2e
    invoke-virtual {v1, v2, v3}, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;

    move-result-object v1

    aput-object v1, v0, p2

    .line 3544
    return-void

    .line 3540
    :cond_35
    const/4 v3, 0x1

    goto :goto_2e
.end method

.method public initNpcFaceOne(Ljava/lang/String;)V
    .registers 6
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 3415
    if-nez p1, :cond_3

    .line 3442
    :cond_2
    :goto_2
    return-void

    .line 3417
    :cond_3
    const/4 v0, -0x1

    .line 3418
    .local v0, "id":B
    const/4 v1, 0x1

    iput-boolean v1, p0, Lmain/Map;->faceDir:Z

    .line 3419
    const-string v1, "\u585e\u5176"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_46

    .line 3420
    const/4 v0, 0x0

    .line 3421
    const/4 v1, 0x0

    iput-boolean v1, p0, Lmain/Map;->faceDir:Z

    .line 3431
    :cond_13
    :goto_13
    const/4 v1, -0x1

    if-le v0, v1, :cond_95

    .line 3432
    iget-object v1, p0, Lmain/Map;->imgFace:Ljavax/microedition/lcdui/Image;

    if-eqz v1, :cond_1e

    iget-byte v1, p0, Lmain/Map;->faceLast:B

    if-eq v1, v0, :cond_2

    .line 3433
    :cond_1e
    iget-boolean v1, p0, Lmain/Map;->faceDir:Z

    if-eqz v1, :cond_92

    const/16 v1, 0x32

    :goto_24
    int-to-short v1, v1

    iput-short v1, p0, Lmain/Map;->face_c:S

    .line 3434
    iput-byte v0, p0, Lmain/Map;->faceLast:B

    .line 3435
    const/4 v1, 0x0

    iput-object v1, p0, Lmain/Map;->imgFace:Ljavax/microedition/lcdui/Image;

    .line 3436
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "data/face/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v1

    iput-object v1, p0, Lmain/Map;->imgFace:Ljavax/microedition/lcdui/Image;

    goto :goto_2

    .line 3422
    :cond_46
    const-string v1, "\u5b89\u742a\u513f"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_56

    const-string v1, "\u84dd\u53d1\u5973\u5b69"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_58

    :cond_56
    const/4 v0, 0x1

    goto :goto_13

    .line 3423
    :cond_58
    const-string v1, "\u5e7d\u6697\u9b3c\u738b"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_62

    const/4 v0, 0x2

    goto :goto_13

    .line 3424
    :cond_62
    const-string v1, "\u6770\u5947\u6821\u957f"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6c

    const/4 v0, 0x3

    goto :goto_13

    .line 3425
    :cond_6c
    const-string v1, "\u666e\u7f57"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_7c

    const-string v1, "\u666e\u7f57\u6821\u957f"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_7e

    :cond_7c
    const/4 v0, 0x4

    goto :goto_13

    .line 3426
    :cond_7e
    const-string v1, "\u795e\u79d8\u4e1c\u65b9\u7537\u5b50"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_88

    const/4 v0, 0x5

    goto :goto_13

    .line 3427
    :cond_88
    const-string v1, "\u5357\u5bab\u4e91"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_13

    const/4 v0, 0x6

    goto :goto_13

    .line 3433
    :cond_92
    const/16 v1, -0x32

    goto :goto_24

    .line 3438
    :cond_95
    invoke-virtual {p0}, Lmain/Map;->nullNpcFace()V

    goto/16 :goto_2
.end method

.method public initSrcEffect(I)Z
    .registers 10
    .param p1, "mode"    # I

    .prologue
    const/16 v7, 0x28

    const/4 v6, 0x6

    const/4 v3, 0x5

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 3930
    sget v0, Lmain/Constants_H;->SRC_BATTLE_H__:I

    .line 3931
    .local v0, "SRC_BATTLE_H":I
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v2, 0xa

    iput-byte v2, v1, Ldm/Npc;->state:B

    .line 3932
    packed-switch p1, :pswitch_data_64

    :cond_11
    move v1, v4

    .line 3958
    :goto_12
    return v1

    .line 3936
    :pswitch_13
    iput-short v4, p0, Lmain/Map;->bSrc_c:S

    .line 3937
    if-ne p1, v5, :cond_22

    move v1, v0

    :goto_18
    int-to-short v1, v1

    iput-short v1, p0, Lmain/Map;->black_width:S

    .line 3938
    if-ne p1, v5, :cond_24

    move v1, v5

    :goto_1e
    iput-boolean v1, p0, Lmain/Map;->bSrc:Z

    move v1, v5

    .line 3939
    goto :goto_12

    :cond_22
    move v1, v4

    .line 3937
    goto :goto_18

    :cond_24
    move v1, v4

    .line 3938
    goto :goto_1e

    .line 3944
    :pswitch_26
    iput-boolean v5, p0, Lmain/Map;->bSrc:Z

    .line 3945
    iget-short v1, p0, Lmain/Map;->bSrc_c:S

    if-nez v1, :cond_3a

    .line 3946
    if-eq p1, v6, :cond_30

    if-ne p1, v3, :cond_55

    .line 3947
    :cond_30
    const/16 v1, -0x28

    iput-short v1, p0, Lmain/Map;->bSrc_c:S

    .line 3948
    if-ne p1, v3, :cond_53

    move v1, v7

    :goto_37
    int-to-short v1, v1

    iput-short v1, p0, Lmain/Map;->black_width:S

    .line 3951
    :cond_3a
    :goto_3a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-short v2, p0, Lmain/Map;->bSrc_c:S

    const/16 v3, 0xc

    invoke-virtual {v1, v2, v4, v3, v4}, Ldm/Ms;->mathSpeedN(IIIZ)S

    move-result v1

    iput-short v1, p0, Lmain/Map;->bSrc_c:S

    .line 3952
    iget-short v1, p0, Lmain/Map;->bSrc_c:S

    if-nez v1, :cond_11

    .line 3953
    if-eq p1, v6, :cond_61

    move v1, v5

    :goto_4f
    iput-boolean v1, p0, Lmain/Map;->bSrc:Z

    move v1, v5

    .line 3954
    goto :goto_12

    :cond_53
    move v1, v4

    .line 3948
    goto :goto_37

    .line 3949
    :cond_55
    const/4 v1, 0x4

    if-ne p1, v1, :cond_5f

    move v1, v0

    :goto_59
    int-to-short v1, v1

    iput-short v1, p0, Lmain/Map;->bSrc_c:S

    iput-short v1, p0, Lmain/Map;->black_width:S

    goto :goto_3a

    :cond_5f
    move v1, v7

    goto :goto_59

    :cond_61
    move v1, v4

    .line 3953
    goto :goto_4f

    .line 3932
    nop

    :pswitch_data_64
    .packed-switch 0x0
        :pswitch_13
        :pswitch_13
        :pswitch_13
        :pswitch_26
        :pswitch_26
        :pswitch_26
        :pswitch_26
    .end packed-switch
.end method

.method public initWalkIco()V
    .registers 4

    .prologue
    .line 3457
    iget-object v0, p0, Lmain/Map;->walkIco:[Ljavax/microedition/lcdui/Image;

    if-nez v0, :cond_11

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x3

    const-string v2, "data/brow/w"

    invoke-virtual {v0, v1, v2}, Ldm/Ms;->createImageArray(ILjava/lang/String;)[Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Lmain/Map;->walkIco:[Ljavax/microedition/lcdui/Image;

    .line 3458
    :cond_11
    return-void
.end method

.method public insertNpc()V
    .registers 10

    .prologue
    const/4 v8, 0x1

    .line 3726
    iget-object v5, p0, Lmain/Map;->npc:[[Ldm/Npc;

    if-nez v5, :cond_6

    .line 3746
    :cond_5
    return-void

    .line 3727
    :cond_6
    const/4 v2, 0x0

    .line 3729
    .local v2, "temp":B
    const/4 v0, 0x1

    .local v0, "i":B
    :goto_8
    iget-object v5, p0, Lmain/Map;->npcList:[B

    array-length v5, v5

    if-ge v0, v5, :cond_5

    .line 3730
    move v1, v0

    .local v1, "j":B
    :goto_e
    if-gtz v1, :cond_14

    .line 3729
    :cond_10
    add-int/lit8 v5, v0, 0x1

    int-to-byte v0, v5

    goto :goto_8

    .line 3731
    :cond_14
    invoke-direct {p0, v1}, Lmain/Map;->getNpcListY(I)S

    move-result v3

    .line 3732
    .local v3, "y0":S
    sub-int v5, v1, v8

    invoke-direct {p0, v5}, Lmain/Map;->getNpcListY(I)S

    move-result v4

    .line 3735
    .local v4, "y1":S
    if-gt v3, v4, :cond_10

    .line 3738
    if-ne v3, v4, :cond_2d

    if-ne v3, v4, :cond_41

    iget-object v5, p0, Lmain/Map;->npcList:[B

    sub-int v6, v1, v8

    aget-byte v5, v5, v6

    const/4 v6, -0x1

    if-ne v5, v6, :cond_41

    .line 3739
    :cond_2d
    iget-object v5, p0, Lmain/Map;->npcList:[B

    aget-byte v2, v5, v1

    .line 3740
    iget-object v5, p0, Lmain/Map;->npcList:[B

    iget-object v6, p0, Lmain/Map;->npcList:[B

    sub-int v7, v1, v8

    aget-byte v6, v6, v7

    aput-byte v6, v5, v1

    .line 3741
    iget-object v5, p0, Lmain/Map;->npcList:[B

    sub-int v6, v1, v8

    aput-byte v2, v5, v6

    .line 3730
    :cond_41
    sub-int v5, v1, v8

    int-to-byte v1, v5

    goto :goto_e
.end method

.method public key_map()V
    .registers 8

    .prologue
    const/4 v6, 0x7

    const/4 v5, 0x3

    const/4 v4, 0x1

    const/4 v3, -0x1

    const/4 v2, 0x0

    .line 1891
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x11

    if-ne v0, v1, :cond_11

    invoke-direct {p0}, Lmain/Map;->keyMiniMap()V

    .line 1977
    :cond_10
    :goto_10
    return-void

    .line 1892
    :cond_11
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x12

    if-ne v0, v1, :cond_1d

    invoke-direct {p0}, Lmain/Map;->keyMission()V

    goto :goto_10

    .line 1893
    :cond_1d
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0xc

    if-ne v0, v1, :cond_29

    invoke-direct {p0}, Lmain/Map;->keySelectMenu()V

    goto :goto_10

    .line 1894
    :cond_29
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x13

    if-ne v0, v1, :cond_35

    invoke-direct {p0}, Lmain/Map;->keyMySave()V

    goto :goto_10

    .line 1895
    :cond_35
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x16

    if-ne v0, v1, :cond_60

    iget-short v0, p0, Lmain/Map;->black_0:S

    if-le v0, v3, :cond_60

    iget-short v0, p0, Lmain/Map;->black_0:S

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->about_d:[Ljava/lang/StringBuffer;

    array-length v1, v1

    if-ne v0, v1, :cond_60

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Num0()Z

    move-result v0

    if-eqz v0, :cond_60

    .line 1896
    iput-byte v5, p0, Lmain/Map;->eventGoing:B

    .line 1897
    iput-short v3, p0, Lmain/Map;->black_0:S

    .line 1898
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto :goto_10

    .line 1901
    :cond_60
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x10

    if-ne v0, v1, :cond_101

    .line 1902
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-nez v0, :cond_10

    .line 1903
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_d9

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v1, v0, Lmain/GameRun;->popMenu:B

    xor-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    iput-byte v1, v0, Lmain/GameRun;->popMenu:B

    .line 1925
    :cond_85
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-ne v0, v4, :cond_186

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_186

    .line 1926
    iget-byte v0, p0, Lmain/Map;->dialog_no:B

    add-int/lit8 v0, v0, 0x2

    iget-object v1, p0, Lmain/Map;->dialog:[Ljava/lang/StringBuffer;

    array-length v1, v1

    if-lt v0, v1, :cond_178

    .line 1927
    iput-byte v3, p0, Lmain/Map;->dialog_no:B

    .line 1928
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/Map;->dialog:[Ljava/lang/StringBuffer;

    .line 1929
    iget-byte v0, p0, Lmain/Map;->eventGoing:B

    if-nez v0, :cond_173

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v2, v0, Ldm/Npc;->state:B

    .line 1932
    :goto_ab
    iget-boolean v0, p0, Lmain/Map;->bDirTalk:Z

    if-eqz v0, :cond_10

    .line 1933
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v2

    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Npc;->other:[B

    iget-byte v1, p0, Lmain/Map;->npcDirTalk:B

    aput-byte v1, v0, v6

    .line 1934
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v2

    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v6

    if-le v0, v3, :cond_d5

    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v2

    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v0, v0, v1

    iput-byte v5, v0, Ldm/Npc;->dir:B

    .line 1935
    :cond_d5
    iput-boolean v2, p0, Lmain/Map;->bDirTalk:Z

    goto/16 :goto_10

    .line 1904
    :cond_d9
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-nez v0, :cond_ed

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_85

    .line 1905
    :cond_ed
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_fb

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v4, v0, Lmain/GameRun;->popMenu:B

    .line 1906
    :cond_fb
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v2, v0, Ldm/Npc;->state:B

    goto/16 :goto_10

    .line 1909
    :cond_101
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0xa

    if-ne v0, v1, :cond_112

    .line 1910
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto/16 :goto_10

    .line 1912
    :cond_112
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x17

    if-ne v0, v1, :cond_144

    .line 1913
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_133

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0x19

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 1915
    :cond_12a
    :goto_12a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto/16 :goto_10

    .line 1914
    :cond_133
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_12a

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    const/16 v1, 0x18

    iput-byte v1, v0, Ldm/Npc;->state:B

    goto :goto_12a

    .line 1917
    :cond_144
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0xb

    if-ne v0, v1, :cond_166

    .line 1918
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_15a

    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v2, v0, Lmain/GameRun;->say_c:B

    .line 1919
    :cond_15a
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->say_c:B

    if-nez v0, :cond_10

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v2, v0, Ldm/Npc;->state:B

    goto/16 :goto_10

    .line 1921
    :cond_166
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x14

    if-ne v0, v1, :cond_85

    .line 1922
    invoke-direct {p0}, Lmain/Map;->keyAnoleSel()V

    goto/16 :goto_10

    .line 1930
    :cond_173
    const/4 v0, 0x2

    iput-byte v0, p0, Lmain/Map;->eventGoing:B

    goto/16 :goto_ab

    .line 1939
    :cond_178
    iget-byte v0, p0, Lmain/Map;->dialog_no:B

    add-int/lit8 v0, v0, 0x2

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/Map;->dialog_no:B

    .line 1940
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 1942
    :cond_186
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->frame_c:B

    if-gtz v0, :cond_10

    .line 1974
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-nez v0, :cond_10

    .line 1975
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget v0, Ldm/Ms;->key:I

    neg-int v0, v0

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/Map;->map_key:B

    .line 1976
    invoke-virtual {p0}, Lmain/Map;->doKey()V

    goto/16 :goto_10
.end method

.method public loadDate_Rms()V
    .registers 12

    .prologue
    const/4 v5, -0x1

    const/4 v3, 0x0

    const/4 v10, 0x1

    const/4 v9, 0x0

    const/4 v8, 0x2

    .line 146
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    invoke-virtual {v4, v8, v3, v10}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v1

    .line 148
    .local v1, "info":[B
    aget-byte v4, v1, v9

    if-ne v4, v5, :cond_9c

    .line 150
    const/16 v4, 0x10

    new-array v2, v4, [B

    const/16 v4, 0x3a

    aput-byte v4, v2, v9

    const/16 v4, 0x9

    aput-byte v4, v2, v10

    const/16 v4, 0x10

    aput-byte v4, v2, v8

    const/4 v4, 0x3

    aput-byte v8, v2, v4

    const/4 v4, 0x5

    aput-byte v10, v2, v4

    const/4 v4, 0x6

    aput-byte v8, v2, v4

    const/16 v4, 0xf

    aput-byte v5, v2, v4

    .line 154
    .local v2, "one":[B
    move-object v1, v2

    .line 155
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    invoke-virtual {v4, v8, v2, v8}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 156
    move-object v0, v3

    check-cast v0, [B

    move-object v2, v0

    .line 157
    const/16 v4, 0x46

    new-array v4, v4, [[S

    iput-object v4, p0, Lmain/Map;->event_now_list:[[S

    .line 158
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    const/16 v5, 0xc

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v6

    iget-object v7, p0, Lmain/Map;->event_now_list:[[S

    invoke-virtual {v6, v7}, Ldm/Ms;->getEventNowData([[S)[B

    move-result-object v6

    invoke-virtual {v4, v5, v6, v8}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 160
    .end local v2    # "one":[B
    :goto_53
    aget-byte v4, v1, v9

    iput-byte v4, p0, Lmain/Map;->mapNo:B

    .line 161
    const/4 v4, 0x5

    aget-byte v4, v1, v4

    iput-byte v4, p0, Lmain/Map;->lastMap:B

    .line 162
    const/4 v4, 0x6

    aget-byte v4, v1, v4

    iput-byte v4, p0, Lmain/Map;->lastExit:B

    .line 163
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    aget-byte v5, v1, v10

    aget-byte v6, v1, v8

    invoke-virtual {v4, v5, v6, v9, v9}, Ldm/Npc;->setXY(IIII)V

    .line 164
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    const/4 v5, 0x3

    aget-byte v5, v1, v5

    iput-byte v5, v4, Ldm/Npc;->dir:B

    .line 166
    iget-object v4, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v4, v9}, Ldm/Npc;->setActionNo(Z)V

    .line 167
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    const/4 v6, 0x7

    invoke-virtual {v5, v1, v6}, Ldm/Ms;->getInt([BI)I

    move-result v5

    iput v5, v4, Lmain/GameRun;->money:I

    .line 168
    iget-object v4, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v5

    const/16 v6, 0xb

    invoke-virtual {v5, v1, v6}, Ldm/Ms;->getInt([BI)I

    move-result v5

    iput v5, v4, Lmain/GameRun;->coin:I

    .line 169
    const/16 v4, 0xf

    aget-byte v4, v1, v4

    iput-byte v4, p0, Lmain/Map;->anole_type:B

    .line 170
    move-object v0, v3

    check-cast v0, [B

    move-object v1, v0

    .line 171
    return-void

    .line 159
    :cond_9c
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v4

    invoke-virtual {v4}, Ldm/Ms;->readEventNowData()[[S

    move-result-object v4

    iput-object v4, p0, Lmain/Map;->event_now_list:[[S

    goto :goto_53
.end method

.method public mapMove(IIII)V
    .registers 6
    .param p1, "x"    # I
    .param p2, "y"    # I
    .param p3, "xs"    # I
    .param p4, "ys"    # I

    .prologue
    .line 2203
    if-lez p3, :cond_a

    iget-short v0, p0, Lmain/Map;->mapLeft_NOmove:S

    if-lt p1, v0, :cond_a

    iget-short v0, p0, Lmain/Map;->mapRight_NOmove:S

    if-lt p1, v0, :cond_14

    .line 2204
    :cond_a
    if-gez p3, :cond_19

    iget-short v0, p0, Lmain/Map;->mapLeft_NOmove:S

    if-le p1, v0, :cond_19

    iget-short v0, p0, Lmain/Map;->mapRight_NOmove:S

    if-gt p1, v0, :cond_19

    .line 2205
    :cond_14
    iget v0, p0, Lmain/Map;->map_x:I

    sub-int/2addr v0, p3

    iput v0, p0, Lmain/Map;->map_x:I

    .line 2206
    :cond_19
    if-lez p4, :cond_23

    iget-short v0, p0, Lmain/Map;->mapUp_NOmove:S

    if-lt p2, v0, :cond_23

    iget-short v0, p0, Lmain/Map;->mapDown_NOmove:S

    if-lt p2, v0, :cond_2d

    .line 2207
    :cond_23
    if-gez p4, :cond_32

    iget-short v0, p0, Lmain/Map;->mapUp_NOmove:S

    if-le p2, v0, :cond_32

    iget-short v0, p0, Lmain/Map;->mapDown_NOmove:S

    if-gt p2, v0, :cond_32

    .line 2208
    :cond_2d
    iget v0, p0, Lmain/Map;->map_y:I

    sub-int/2addr v0, p4

    iput v0, p0, Lmain/Map;->map_y:I

    .line 2209
    :cond_32
    return-void
.end method

.method public map_saveGame()V
    .registers 6

    .prologue
    const/4 v4, 0x2

    .line 173
    const/16 v1, 0x10

    new-array v0, v1, [B

    .line 174
    .local v0, "info":[B
    const/4 v1, 0x0

    iget-byte v2, p0, Lmain/Map;->mapNo:B

    aput-byte v2, v0, v1

    .line 175
    const/4 v1, 0x5

    iget-byte v2, p0, Lmain/Map;->lastMap:B

    aput-byte v2, v0, v1

    .line 176
    const/4 v1, 0x6

    iget-byte v2, p0, Lmain/Map;->lastExit:B

    aput-byte v2, v0, v1

    .line 177
    const/4 v1, 0x1

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v2, v2, Ldm/Npc;->x:S

    div-int/lit8 v2, v2, 0x14

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 178
    iget-object v1, p0, Lmain/Map;->my:Ldm/Npc;

    iget-short v1, v1, Ldm/Npc;->y:S

    div-int/lit8 v1, v1, 0x14

    int-to-byte v1, v1

    aput-byte v1, v0, v4

    .line 179
    const/4 v1, 0x3

    iget-object v2, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v2, v2, Ldm/Npc;->dir:B

    aput-byte v2, v0, v1

    .line 181
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v2, v2, Lmain/GameRun;->money:I

    const/4 v3, 0x7

    invoke-virtual {v1, v2, v0, v3}, Ldm/Ms;->putInt(I[BI)V

    .line 182
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget v2, v2, Lmain/GameRun;->coin:I

    const/16 v3, 0xb

    invoke-virtual {v1, v2, v0, v3}, Ldm/Ms;->putInt(I[BI)V

    .line 183
    const/16 v1, 0xf

    iget-byte v2, p0, Lmain/Map;->anole_type:B

    aput-byte v2, v0, v1

    .line 185
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1, v4, v0, v4}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 186
    const/4 v0, 0x0

    check-cast v0, [B

    .line 187
    return-void
.end method

.method public notMeet(II)V
    .registers 7
    .param p1, "kind"    # I
    .param p2, "id"    # I

    .prologue
    const/16 v3, 0xf

    const/4 v0, 0x1

    const/4 v2, 0x0

    .line 112
    if-nez p1, :cond_52

    .line 113
    iput-byte v2, p0, Lmain/Map;->notMeet:B

    .line 114
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v0, 0x1e

    invoke-static {v0}, Ldm/Ms;->getRandom(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->step_MEET:S

    .line 115
    iget-short v0, p0, Lmain/Map;->step_MEET:S

    sub-int/2addr v0, v3

    iget-short v1, p0, Lmain/Map;->step_MEET:S

    sub-int/2addr v1, v3

    mul-int/2addr v0, v1

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->meet_step:S

    .line 116
    iget-short v0, p0, Lmain/Map;->meet_step:S

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v1, 0x32

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    if-gt v0, v1, :cond_3a

    .line 118
    :goto_2d
    iget-short v0, p0, Lmain/Map;->step_MEET:S

    shl-int/lit8 v0, v0, 0x2

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->step_MEET:S

    .line 119
    iput-short v2, p0, Lmain/Map;->meet_step:S

    .line 120
    const/4 v0, -0x1

    iput-byte v0, p0, Lmain/Map;->bStep:B

    .line 128
    :cond_39
    :goto_39
    return-void

    .line 117
    :cond_3a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/16 v0, 0x9

    invoke-static {v0}, Ldm/Ms;->getRandom(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x11

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v1, 0x7

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    sub-int/2addr v0, v1

    int-to-byte v0, v0

    iput-short v0, p0, Lmain/Map;->step_MEET:S

    goto :goto_2d

    .line 121
    :cond_52
    if-ne p1, v0, :cond_39

    .line 122
    iput-byte v0, p0, Lmain/Map;->notMeet:B

    .line 123
    const/16 v0, 0xe

    sub-int v0, p2, v0

    add-int/lit8 v0, v0, 0x1

    mul-int/lit16 v0, v0, 0xc8

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->step_MEET:S

    .line 124
    iget-short v0, p0, Lmain/Map;->step_MEET:S

    shl-int/lit8 v0, v0, 0x2

    int-to-short v0, v0

    iput-short v0, p0, Lmain/Map;->step_MEET:S

    .line 125
    iput-short v2, p0, Lmain/Map;->meet_step:S

    .line 126
    const/16 v0, 0x64

    iput-byte v0, p0, Lmain/Map;->bStep:B

    goto :goto_39
.end method

.method public nullNpcFace()V
    .registers 2

    .prologue
    .line 3444
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/Map;->imgFace:Ljavax/microedition/lcdui/Image;

    .line 3447
    return-void
.end method

.method public paint_map(Ljavax/microedition/lcdui/Graphics;)V
    .registers 25
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 1595
    sput-object p1, Lmain/Map;->g:Ljavax/microedition/lcdui/Graphics;

    .line 1608
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/4 v6, 0x6

    if-ne v5, v6, :cond_2b

    .line 1609
    const/16 v21, 0x280

    .local v21, "WIDTH":I
    const/16 v19, 0x168

    .line 1611
    .local v19, "HEIGHT":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->b_c:B

    const/16 v8, 0x1e

    const/16 v9, 0x26

    sub-int v9, v19, v9

    const/16 v10, 0x3c

    sub-int v10, v21, v10

    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->drawChangeMap(ZIIII)V

    .line 1818
    .end local v19    # "HEIGHT":I
    .end local v21    # "WIDTH":I
    :goto_2a
    return-void

    .line 1614
    :cond_2b
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x11

    if-ne v5, v6, :cond_3a

    .line 1615
    invoke-direct/range {p0 .. p0}, Lmain/Map;->drawMiniMap()V

    goto :goto_2a

    .line 1617
    :cond_3a
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x12

    if-ne v5, v6, :cond_49

    .line 1618
    invoke-direct/range {p0 .. p0}, Lmain/Map;->drawMission()V

    goto :goto_2a

    .line 1625
    :cond_49
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->bgColor:I

    move v6, v0

    const/4 v7, 0x0

    const/4 v8, 0x0

    sget v9, Lmain/Constants_H;->WIDTH:I

    sget v10, Lmain/Constants_H;->HEIGHT:I

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->fillRect(IIIII)V

    .line 1627
    sget-object v5, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v6, Lmain/MainCanvas;->mapxx:F

    sget v7, Lmain/MainCanvas;->mapyy:F

    invoke-virtual {v5, v6, v7}, Lmain/MainCanvas;->setScale(FF)V

    .line 1628
    sget-object v5, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v6, Lmain/MainCanvas;->mapxx:F

    iput v6, v5, Lmain/MainCanvas;->keyxx:F

    .line 1629
    sget-object v5, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v6, Lmain/MainCanvas;->mapyy:F

    iput v6, v5, Lmain/MainCanvas;->keyyy:F

    .line 1630
    invoke-direct/range {p0 .. p0}, Lmain/Map;->setMapOffer()V

    .line 1631
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->xxx:B

    move v5, v0

    if-lez v5, :cond_9c

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->xxx:B

    move v5, v0

    const/4 v6, 0x1

    sub-int/2addr v5, v6

    int-to-byte v5, v5

    move v0, v5

    move-object/from16 v1, p0

    iput-byte v0, v1, Lmain/Map;->xxx:B

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->xxx:B

    move v5, v0

    rem-int/lit8 v5, v5, 0x2

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->xxx:B

    move v6, v0

    rem-int/lit8 v6, v6, 0x2

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Ljavax/microedition/lcdui/Graphics;->translate(II)V

    .line 1634
    :cond_9c
    sget-object v5, Lmain/GameRun;->offG:Ljavax/microedition/lcdui/Graphics;

    move-object/from16 v0, p0

    move-object v1, v5

    invoke-virtual {v0, v1}, Lmain/Map;->drawMap(Ljavax/microedition/lcdui/Graphics;)V

    .line 1635
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    const/4 v6, 0x2

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    move-object v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->drawNpcAni([Ldm/Npc;)V

    .line 1647
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v5, v0

    iget-boolean v5, v5, Lmain/PointerKey;->isGo:Z

    if-eqz v5, :cond_117

    .line 1648
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->ii:I

    move v5, v0

    add-int/lit8 v6, v5, 0x1

    move v0, v6

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->ii:I

    const/4 v6, 0x2

    if-le v5, v6, :cond_e9

    .line 1650
    const/4 v5, 0x0

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->ii:I

    .line 1651
    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->i:I

    move v5, v0

    add-int/lit8 v6, v5, 0x1

    move v0, v6

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->i:I

    const/4 v6, 0x2

    if-ge v5, v6, :cond_2f1

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->i:I

    move v5, v0

    :goto_e4
    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/Map;->i:I

    .line 1657
    :cond_e9
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->walkIco:[Ljavax/microedition/lcdui/Image;

    move-object v6, v0

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->i:I

    move v7, v0

    aget-object v6, v6, v7

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v7, v0

    iget v7, v7, Lmain/PointerKey;->gox:I

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_x:I

    move v8, v0

    add-int/2addr v7, v8

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v8, v0

    iget v8, v8, Lmain/PointerKey;->goy:I

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_y:I

    move v9, v0

    add-int/2addr v8, v9

    const/4 v9, 0x3

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 1661
    :cond_117
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    const/4 v6, 0x0

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    move-object v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->drawNMAni([Ldm/Npc;)V

    .line 1662
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->frontData:[S

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    move-object v7, v0

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_x:I

    move v5, v0

    neg-int v8, v5

    move-object/from16 v0, p0

    iget v0, v0, Lmain/Map;->map_y:I

    move v5, v0

    neg-int v5, v5

    const/4 v9, 0x1

    sub-int v9, v5, v9

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->moduleData:[[S

    move-object v10, v0

    const/4 v12, 0x0

    const/4 v13, 0x0

    sget v14, Lmain/Constants_H;->WIDTH:I

    sget v15, Lmain/Constants_H;->HEIGHT:I

    const/16 v16, 0x0

    move-object/from16 v5, p0

    move-object/from16 v11, p1

    invoke-virtual/range {v5 .. v16}, Lmain/Map;->bkgroundToPaint([S[Ljavax/microedition/lcdui/Image;II[[SLjavax/microedition/lcdui/Graphics;IIIIZ)V

    .line 1663
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npc:[[Ldm/Npc;

    move-object v5, v0

    const/4 v6, 0x1

    aget-object v5, v5, v6

    move-object/from16 v0, p0

    move-object v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->drawNpcAni([Ldm/Npc;)V

    .line 1665
    invoke-direct/range {p0 .. p1}, Lmain/Map;->drawMapRect(Ljavax/microedition/lcdui/Graphics;)V

    .line 1667
    sget v5, Lmain/Constants_H;->WIDTH:I

    const/16 v6, 0x11

    sub-int/2addr v5, v6

    const/4 v6, 0x0

    const/16 v7, 0x10

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move v2, v5

    move v3, v6

    move v4, v7

    invoke-direct {v0, v1, v2, v3, v4}, Lmain/Map;->drawStep(Ljavax/microedition/lcdui/Graphics;III)V

    .line 1668
    invoke-direct/range {p0 .. p0}, Lmain/Map;->drawBrow()V

    .line 1669
    const/4 v5, 0x4

    move-object/from16 v0, p0

    move v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->drawCheck5(I)V

    .line 1671
    invoke-direct/range {p0 .. p0}, Lmain/Map;->drawCloud()V

    .line 1673
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->magic_id:B

    const/4 v6, -0x1

    if-le v5, v6, :cond_1f6

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-byte v6, v6, Lmain/GameRun;->magic_id:B

    div-int/lit8 v6, v6, 0x5

    const/4 v7, 0x5

    if-le v6, v7, :cond_2f4

    const/4 v6, 0x5

    :goto_19e
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->magic_id:B

    div-int/lit8 v7, v7, 0x5

    const/4 v8, 0x5

    if-le v7, v8, :cond_2ff

    const/4 v7, 0x5

    .line 1674
    :goto_1ab
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v8, v0

    iget-byte v8, v8, Lmain/GameRun;->magic_id:B

    div-int/lit8 v8, v8, 0x5

    const/4 v9, 0x5

    if-lt v8, v9, :cond_30a

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v8, v0

    iget-byte v8, v8, Lmain/GameRun;->magic_id:B

    const/16 v9, 0x19

    sub-int/2addr v8, v9

    :goto_1c1
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v9, v0

    iget v9, v9, Lmain/GameRun;->magic_x:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v10, v0

    iget v10, v10, Lmain/GameRun;->magic_y:I

    add-int/lit8 v10, v10, 0x10

    const/4 v11, 0x0

    .line 1673
    invoke-virtual/range {v5 .. v11}, Lmain/GameRun;->drawMagicC(IIIIII)Z

    move-result v5

    if-eqz v5, :cond_1f6

    .line 1675
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x15

    if-ne v5, v6, :cond_315

    .line 1676
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, -0x2

    iput-byte v6, v5, Lmain/GameRun;->magic_id:B

    .line 1677
    invoke-virtual/range {p0 .. p0}, Lmain/Map;->setAnole()V

    .line 1679
    :goto_1ee
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    const/4 v6, 0x0

    iput-byte v6, v5, Ldm/Npc;->state:B

    .line 1687
    :cond_1f6
    invoke-virtual/range {p1 .. p1}, Ljavax/microedition/lcdui/Graphics;->getTranslateX()I

    move-result v5

    neg-int v5, v5

    invoke-virtual/range {p1 .. p1}, Ljavax/microedition/lcdui/Graphics;->getTranslateY()I

    move-result v6

    neg-int v6, v6

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Ljavax/microedition/lcdui/Graphics;->translate(II)V

    .line 1690
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x14

    if-ne v5, v6, :cond_215

    invoke-direct/range {p0 .. p0}, Lmain/Map;->drawAnoleSel()V

    .line 1697
    :cond_215
    invoke-virtual/range {p1 .. p1}, Ljavax/microedition/lcdui/Graphics;->restCanvas()V

    .line 1704
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lmain/Map;->fontSizeControl:Z

    move v5, v0

    if-nez v5, :cond_229

    .line 1705
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v5, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v6, 0x16

    invoke-virtual {v5, v6}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 1707
    :cond_229
    const/16 v18, 0x19

    .local v18, "FONT_W":I
    const/16 v17, 0x19

    .line 1709
    .local v17, "FONT_H":I
    invoke-direct/range {p0 .. p0}, Lmain/Map;->drawSrcEffect()V

    .line 1711
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0xc

    if-ne v5, v6, :cond_270

    .line 1714
    sget v5, Lmain/Constants_H;->WIDTH__:I

    div-int/lit8 v7, v5, 0x2

    .line 1718
    .local v7, "WIDTH_H":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-object v6, v6, Lmain/GameRun;->action_str:[Ljava/lang/String;

    mul-int/lit8 v8, v18, 0x3

    sub-int/2addr v7, v8

    sget v8, Lmain/Constants_H;->HEIGHT__:I

    .end local v7    # "WIDTH_H":I
    div-int/lit8 v8, v8, 0x2

    const/16 v9, 0x64

    sub-int/2addr v8, v9

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v9, v0

    iget-object v9, v9, Lmain/GameRun;->action_str:[Ljava/lang/String;

    array-length v9, v9

    shr-int/lit8 v9, v9, 0x1

    mul-int v9, v9, v17

    add-int/2addr v8, v9

    mul-int/lit8 v9, v18, 0x6

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v12, v0

    iget-byte v12, v12, Lmain/GameRun;->cur_a:B

    invoke-virtual/range {v5 .. v12}, Lmain/GameRun;->drawSelectMenu_([Ljava/lang/Object;IIIIII)V

    .line 1722
    :cond_270
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->view_state:B

    const/4 v6, 0x4

    if-ne v5, v6, :cond_31f

    .line 1725
    sget v21, Lmain/Constants_H;->WIDTH__:I

    .restart local v21    # "WIDTH":I
    sget v19, Lmain/Constants_H;->HEIGHT__:I

    .line 1726
    .restart local v19    # "HEIGHT":I
    sget v5, Lmain/Constants_H;->WIDTH__:I

    div-int/lit8 v7, v5, 0x2

    .line 1728
    .restart local v7    # "WIDTH_H":I
    const/4 v5, 0x3

    move v0, v5

    new-array v0, v0, [B

    move-object/from16 v22, v0

    fill-array-data v22, :array_440

    .line 1737
    .local v22, "id":[B
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    mul-int/lit8 v8, v17, 0x3

    sub-int v8, v19, v8

    mul-int/lit8 v9, v17, 0x3

    move-object v0, v5

    move v1, v6

    move v2, v8

    move/from16 v3, v21

    move v4, v9

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawKuang(IIII)V

    .line 1738
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v8, v0

    iget-byte v8, v8, Lmain/GameRun;->cur_a:B

    aget-byte v8, v22, v8

    invoke-virtual {v6, v8}, Lmain/GameRun;->getNameMonsterInfo(I)Ljava/lang/String;

    move-result-object v6

    mul-int/lit8 v8, v17, 0x2

    sub-int v8, v19, v8

    const/16 v9, 0x8

    sub-int/2addr v8, v9

    const/16 v9, 0xa

    const/4 v10, 0x3

    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->showStringM_(Ljava/lang/String;IIII)V

    .line 1741
    const/16 v22, 0x0

    check-cast v22, [B

    .line 1768
    .end local v7    # "WIDTH_H":I
    .end local v19    # "HEIGHT":I
    .end local v21    # "WIDTH":I
    .end local v22    # "id":[B
    :cond_2c7
    :goto_2c7
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x14

    if-eq v5, v6, :cond_2e1

    .line 1769
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v6, v0

    iget-byte v6, v6, Ldm/Npc;->state:B

    invoke-virtual {v5, v6}, Lmain/GameRun;->drawPauseIco(I)V

    .line 1771
    :cond_2e1
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x13

    if-ne v5, v6, :cond_3b4

    .line 1772
    invoke-direct/range {p0 .. p0}, Lmain/Map;->drawMySave()V

    goto/16 :goto_2a

    .line 1651
    .end local v17    # "FONT_H":I
    .end local v18    # "FONT_W":I
    :cond_2f1
    const/4 v5, 0x0

    goto/16 :goto_e4

    .line 1673
    :cond_2f4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-byte v6, v6, Lmain/GameRun;->magic_id:B

    div-int/lit8 v6, v6, 0x5

    goto/16 :goto_19e

    :cond_2ff
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v7, v0

    iget-byte v7, v7, Lmain/GameRun;->magic_id:B

    div-int/lit8 v7, v7, 0x5

    goto/16 :goto_1ab

    .line 1674
    :cond_30a
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v8, v0

    iget-byte v8, v8, Lmain/GameRun;->magic_id:B

    rem-int/lit8 v8, v8, 0x5

    goto/16 :goto_1c1

    .line 1678
    :cond_315
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const/4 v6, -0x1

    iput-byte v6, v5, Lmain/GameRun;->magic_id:B

    goto/16 :goto_1ee

    .line 1742
    .restart local v17    # "FONT_H":I
    .restart local v18    # "FONT_W":I
    :cond_31f
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x10

    if-ne v5, v6, :cond_2c7

    .line 1745
    sget v21, Lmain/Constants_H;->WIDTH__:I

    .restart local v21    # "WIDTH":I
    sget v19, Lmain/Constants_H;->HEIGHT__:I

    .line 1746
    .restart local v19    # "HEIGHT":I
    sget v5, Lmain/Constants_H;->WIDTH__:I

    div-int/lit8 v7, v5, 0x2

    .restart local v7    # "WIDTH_H":I
    sget v5, Lmain/Constants_H;->HEIGHT__:I

    div-int/lit8 v20, v5, 0x2

    .line 1747
    .local v20, "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    mul-int/lit8 v8, v17, 0x4

    sub-int v8, v19, v8

    mul-int/lit8 v9, v17, 0x4

    move-object v0, v5

    move v1, v6

    move v2, v8

    move/from16 v3, v21

    move v4, v9

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawKuang(IIII)V

    .line 1748
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    const-string v6, "\u662f\u5426\u56de\u590d\u6240\u6709\u5ba0\u7269\uff1f"

    mul-int/lit8 v8, v17, 0x4

    sub-int v8, v19, v8

    add-int/lit8 v8, v8, 0x4

    const/16 v9, 0xa

    const/4 v10, 0x3

    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->showStringM_(Ljava/lang/String;IIII)V

    .line 1752
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v8, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v9, v5, Lmain/GameRun;->action_str:[Ljava/lang/String;

    mul-int/lit8 v5, v18, 0x2

    sub-int v10, v7, v5

    sub-int v11, v20, v17

    mul-int/lit8 v12, v18, 0x4

    const/4 v13, -0x1

    const/4 v14, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v15, v5, Lmain/GameRun;->popMenu:B

    invoke-virtual/range {v8 .. v15}, Lmain/GameRun;->drawSelectMenu_([Ljava/lang/Object;IIIIII)V

    .line 1755
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v8, "\u6240\u9700\u91d1\u989d\uff1a"

    invoke-direct {v6, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v8, v0

    iget v8, v8, Lmain/GameRun;->sell_money:I

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    mul-int/lit8 v8, v17, 0x3

    sub-int v8, v19, v8

    add-int/lit8 v8, v8, 0x4

    const/16 v9, 0xa

    const/4 v10, 0x3

    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->showStringM_(Ljava/lang/String;IIII)V

    .line 1759
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    sub-int v6, v19, v17

    add-int/lit8 v6, v6, 0xf

    const/4 v8, 0x3

    const/4 v9, 0x0

    invoke-virtual {v5, v7, v6, v8, v9}, Lmain/GameRun;->drawMoney(IIIZ)V

    goto/16 :goto_2c7

    .line 1779
    .end local v7    # "WIDTH_H":I
    .end local v19    # "HEIGHT":I
    .end local v20    # "HEIGHT_H":I
    .end local v21    # "WIDTH":I
    :cond_3b4
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->rmsOther:[B

    const/4 v6, 0x2

    aget-byte v5, v5, v6

    .line 1786
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/GameRun;->drawCityName()V

    .line 1788
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    move-object v5, v0

    iget-byte v5, v5, Ldm/Npc;->state:B

    const/16 v6, 0x17

    if-ne v5, v6, :cond_411

    .line 1789
    sget v21, Lmain/Constants_H;->WIDTH__:I

    .restart local v21    # "WIDTH":I
    sget v19, Lmain/Constants_H;->HEIGHT__:I

    .line 1790
    .restart local v19    # "HEIGHT":I
    sget v5, Lmain/Constants_H;->WIDTH__:I

    div-int/lit8 v7, v5, 0x2

    .line 1791
    .restart local v7    # "WIDTH_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    mul-int/lit8 v8, v17, 0x2

    sub-int v8, v19, v8

    mul-int/lit8 v9, v17, 0x2

    move-object v0, v5

    move v1, v6

    move v2, v8

    move/from16 v3, v21

    move v4, v9

    invoke-virtual {v0, v1, v2, v3, v4}, Ldm/Ui;->drawKuang(IIII)V

    .line 1792
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const-string v6, "\u662f\u5426\u4fdd\u5b58\u8fdb\u5ea6\uff1f"

    mul-int/lit8 v8, v17, 0x2

    sub-int v8, v19, v8

    add-int/lit8 v8, v8, 0x6

    const/16 v9, 0x11

    const/4 v10, 0x3

    const/4 v11, 0x0

    invoke-virtual/range {v5 .. v11}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 1793
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo__(ZZ)V

    .line 1794
    .end local v7    # "WIDTH_H":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v5, v0

    const/4 v6, 0x0

    iput-boolean v6, v5, Lmain/PointerKey;->isGo:Z

    .line 1796
    .end local v19    # "HEIGHT":I
    .end local v21    # "WIDTH":I
    :cond_411
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/Map;->dialog_no:B

    move v5, v0

    const/4 v6, -0x1

    if-le v5, v6, :cond_42c

    .line 1797
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->npcName:Ljava/lang/String;

    move-object v5, v0

    move-object/from16 v0, p0

    move-object v1, v5

    invoke-direct {v0, v1}, Lmain/Map;->dialog(Ljava/lang/String;)V

    .line 1798
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    move-object v5, v0

    const/4 v6, 0x0

    iput-boolean v6, v5, Lmain/PointerKey;->isGo:Z

    .line 1801
    :cond_42c
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/Map;->gr:Lmain/GameRun;

    move-object v5, v0

    invoke-virtual {v5}, Lmain/GameRun;->map_flashString()V

    .line 1817
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v5, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v6, 0x1a

    invoke-virtual {v5, v6}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    goto/16 :goto_2a

    .line 1728
    :array_440
    .array-data 1
        0x4t
        0x19t
        0x38t
    .end array-data
.end method

.method public run_map()V
    .registers 8

    .prologue
    const/4 v2, 0x6

    const/4 v6, 0x5

    const/4 v3, 0x4

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1542
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x9

    if-eq v0, v1, :cond_16

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-eq v0, v2, :cond_16

    invoke-virtual {p0}, Lmain/Map;->eventCheck()V

    .line 1546
    :cond_16
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-ne v0, v6, :cond_29

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->frame_c:B

    if-ge v0, v5, :cond_29

    .line 1547
    invoke-direct {p0}, Lmain/Map;->setMoveStop_m()V

    .line 1549
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v2, v0, Ldm/Npc;->state:B

    .line 1553
    :cond_29
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    if-ne v0, v2, :cond_37

    .line 1554
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iput-byte v5, v0, Lmain/GameRun;->createOver:B

    .line 1555
    invoke-virtual {p0}, Lmain/Map;->goNextMap()V

    .line 1584
    :goto_36
    return-void

    .line 1557
    :cond_37
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/4 v1, 0x2

    if-ne v0, v1, :cond_cf

    iget-byte v0, p0, Lmain/Map;->eventGoing:B

    if-nez v0, :cond_cf

    .line 1558
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v4

    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v3

    if-eq v0, v5, :cond_5f

    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v4

    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v3

    const/4 v1, 0x3

    if-ne v0, v1, :cond_ca

    :cond_5f
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v0, v0, v4

    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v0, v0, v1

    iget-object v0, v0, Ldm/Npc;->other:[B

    aget-byte v0, v0, v6

    if-lez v0, :cond_ca

    .line 1559
    iget-object v0, p0, Lmain/Map;->npcNameData:[Ljava/lang/String;

    iget-byte v1, p0, Lmain/Map;->get_meet:B

    aget-object v0, v0, v1

    iput-object v0, p0, Lmain/Map;->npcName:Ljava/lang/String;

    .line 1560
    iget-object v0, p0, Lmain/Map;->npcName:Ljava/lang/String;

    const-string v1, "\u8def\u4eba"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_82

    const/4 v0, 0x0

    iput-object v0, p0, Lmain/Map;->npcName:Ljava/lang/String;

    .line 1562
    :cond_82
    iget-object v0, p0, Lmain/Map;->npcName:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lmain/Map;->initNpcFaceOne(Ljava/lang/String;)V

    .line 1564
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v0, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v1, 0x16

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 1565
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->npcStringData:[Ljava/lang/String;

    iget-object v2, p0, Lmain/Map;->npc:[[Ldm/Npc;

    aget-object v2, v2, v4

    iget-byte v3, p0, Lmain/Map;->get_meet:B

    aget-object v2, v2, v3

    iget-object v2, v2, Ldm/Npc;->other:[B

    aget-byte v2, v2, v6

    sub-int/2addr v2, v5

    aget-object v1, v1, v2

    sget v2, Lmain/Constants_H;->WIDTH__:I

    const/16 v3, 0x14

    sub-int/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Ldm/Ms;->groupString(Ljava/lang/String;I)[Ljava/lang/StringBuffer;

    move-result-object v0

    iput-object v0, p0, Lmain/Map;->dialog:[Ljava/lang/StringBuffer;

    .line 1566
    iget-boolean v0, p0, Lmain/Map;->fontSizeControl:Z

    if-nez v0, :cond_bf

    .line 1567
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v0, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    const/16 v1, 0x1a

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Font;->setSize(I)V

    .line 1568
    :cond_bf
    iput-byte v4, p0, Lmain/Map;->dialog_no:B

    .line 1570
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v5, v0, Ldm/Npc;->state:B

    .line 1582
    :cond_c5
    :goto_c5
    invoke-direct {p0}, Lmain/Map;->runMove()V

    goto/16 :goto_36

    .line 1571
    :cond_ca
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v4, v0, Ldm/Npc;->state:B

    goto :goto_c5

    .line 1572
    :cond_cf
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    const/16 v1, 0x8

    if-ne v0, v1, :cond_c5

    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->frame_c:B

    const/4 v1, -0x1

    if-ne v0, v1, :cond_c5

    .line 1573
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->immueEnemy:B

    if-nez v0, :cond_10e

    .line 1574
    const-string v0, "sk"

    const-string v1, "gr.immueEnemy==0"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1575
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->battleSay:[Ljava/lang/String;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v2, 0x3

    invoke-static {v2}, Ldm/Ms;->getRandom(I)I

    move-result v2

    aget-object v1, v1, v2

    invoke-virtual {v0, v1, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 1576
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0}, Lmain/MainCanvas;->repaint()V

    .line 1577
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v0, v3}, Lmain/GameRun;->battleType(I)V

    .line 1578
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->goBattlePVC()V

    goto :goto_c5

    .line 1579
    :cond_10e
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    iput-byte v4, v0, Ldm/Npc;->state:B

    goto :goto_c5
.end method

.method public save()V
    .registers 8

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x2

    .line 189
    invoke-virtual {p0}, Lmain/Map;->map_saveGame()V

    .line 190
    invoke-virtual {p0}, Lmain/Map;->saveNpc()V

    .line 191
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_9
    iget-object v1, p0, Lmain/Map;->mapInfo:[S

    array-length v1, v1

    div-int/lit8 v1, v1, 0x2

    if-lt v0, v1, :cond_5f

    .line 197
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/16 v2, 0xd

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    iget-object v4, p0, Lmain/Map;->mapInfo:[S

    invoke-virtual {v3, v4}, Ldm/Ms;->shortArrayToByteArray([S)[B

    move-result-object v3

    invoke-virtual {v1, v2, v3, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 198
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/16 v2, 0xc

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    iget-object v4, p0, Lmain/Map;->event_now_list:[[S

    invoke-virtual {v3, v4}, Ldm/Ms;->getEventNowData([[S)[B

    move-result-object v3

    invoke-virtual {v1, v2, v3, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 199
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/Map;->mapChange:[B

    invoke-virtual {v1, v6, v2, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 200
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/4 v2, 0x7

    iget-object v3, p0, Lmain/Map;->bMission:[B

    invoke-virtual {v1, v2, v3, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 201
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/4 v2, 0x5

    iget-object v3, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->rmsSms:[B

    invoke-virtual {v1, v2, v3, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 202
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x4

    invoke-virtual {v1, v6, v2, v3}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 203
    return-void

    .line 192
    :cond_5f
    iget-object v1, p0, Lmain/Map;->mapChange:[B

    aget-byte v1, v1, v0

    if-ne v1, v6, :cond_77

    .line 193
    iget-object v1, p0, Lmain/Map;->mapChange:[B

    const/4 v2, 0x0

    aput-byte v2, v1, v0

    .line 194
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    add-int/lit8 v2, v0, 0xe

    iget-object v3, p0, Lmain/Map;->mapTemp:[[B

    aget-object v3, v3, v0

    invoke-virtual {v1, v2, v3, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 191
    :cond_77
    add-int/lit8 v0, v0, 0x1

    goto :goto_9
.end method

.method public saveMapBak()V
    .registers 5

    .prologue
    const/4 v3, 0x1

    .line 452
    invoke-virtual {p0}, Lmain/Map;->saveNpc()V

    .line 453
    iget-object v0, p0, Lmain/Map;->mapChange:[B

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    aput-byte v3, v0, v1

    .line 454
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->mapChange:[B

    const/4 v2, 0x2

    invoke-virtual {v0, v3, v1, v2}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 456
    return-void
.end method

.method public saveNpc()V
    .registers 5

    .prologue
    const/4 v3, 0x1

    .line 407
    iget-object v0, p0, Lmain/Map;->mapTemp:[[B

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    const/4 v2, 0x0

    aput-object v2, v0, v1

    .line 408
    iget-object v0, p0, Lmain/Map;->mapTemp:[[B

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    invoke-direct {p0}, Lmain/Map;->getNpcData()[B

    move-result-object v2

    aput-object v2, v0, v1

    .line 409
    iget-object v0, p0, Lmain/Map;->mapInfo:[S

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    mul-int/lit8 v1, v1, 0x2

    aput-short v3, v0, v1

    .line 410
    iget-object v0, p0, Lmain/Map;->mapChange:[B

    iget-byte v1, p0, Lmain/Map;->mapNo:B

    aput-byte v3, v0, v1

    .line 411
    return-void
.end method

.method public setAnole()V
    .registers 9

    .prologue
    const/4 v7, -0x1

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 2138
    iget-object v0, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-byte v1, p0, Lmain/Map;->anole_type:B

    const/4 v2, 0x3

    if-ne v1, v2, :cond_43

    move v1, v6

    :goto_b
    int-to-byte v1, v1

    iput-byte v1, v0, Lmain/GameRun;->immueEnemy:B

    .line 2139
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {p0}, Lmain/Map;->getMySpeed()B

    move-result v1

    iput-byte v1, v0, Ldm/Npc;->speed:B

    .line 2140
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    sget-object v1, Lmain/Map;->npcSp:[[Ldm/Sprite;

    aget-object v1, v1, v6

    aget-object v1, v1, v5

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "data/npc1/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v3, p0, Lmain/Map;->anole_type:B

    if-ne v3, v7, :cond_45

    const-string v3, "0"

    :goto_2d
    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 2141
    iget-byte v3, p0, Lmain/Map;->anole_type:B

    if-ne v3, v7, :cond_57

    move v3, v6

    .line 2140
    :goto_3a
    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->setSprite(Ldm/Sprite;Ljava/lang/String;Z)V

    .line 2142
    iget-object v0, p0, Lmain/Map;->my:Ldm/Npc;

    invoke-virtual {v0, v5}, Ldm/Npc;->setActionNo(Z)V

    .line 2143
    return-void

    :cond_43
    move v1, v5

    .line 2138
    goto :goto_b

    .line 2140
    :cond_45
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "r"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-byte v4, p0, Lmain/Map;->anole_type:B

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_2d

    :cond_57
    move v3, v5

    .line 2141
    goto :goto_3a
.end method

.method public setMapMusic(Z)V
    .registers 5
    .param p1, "bb"    # Z

    .prologue
    .line 4073
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    iget-object v1, p0, Lmain/Map;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->musicNo:[B

    iget-byte v2, p0, Lmain/Map;->mapNo:B

    aget-byte v1, v1, v2

    invoke-virtual {v0, v1}, Ldm/Sound;->setMusicId(I)V

    .line 4074
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, p1}, Ldm/Sound;->setMusic(Z)V

    .line 4075
    return-void
.end method

.method public setMission(IZ)V
    .registers 7
    .param p1, "id"    # I
    .param p2, "bb"    # Z

    .prologue
    const/4 v3, 0x1

    .line 2931
    div-int/lit8 v1, p1, 0x8

    int-to-byte v0, v1

    .line 2932
    .local v0, "type":B
    rem-int/lit8 v1, p1, 0x8

    int-to-byte p1, v1

    .line 2933
    if-eqz p2, :cond_13

    iget-object v1, p0, Lmain/Map;->bMission:[B

    aget-byte v2, v1, v0

    shl-int/2addr v3, p1

    or-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    .line 2940
    :cond_12
    :goto_12
    return-void

    .line 2935
    :cond_13
    iget-object v1, p0, Lmain/Map;->bMission:[B

    aget-byte v1, v1, v0

    shl-int v2, v3, p1

    and-int/2addr v1, v2

    if-eqz v1, :cond_12

    .line 2936
    iget-object v1, p0, Lmain/Map;->bMission:[B

    aget-byte v2, v1, v0

    shl-int/2addr v3, p1

    xor-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    .line 2937
    iget-object v1, p0, Lmain/Map;->bMission:[B

    const/16 v2, 0xf

    aget-byte v3, v1, v2

    add-int/lit8 v3, v3, 0x1

    int-to-byte v3, v3

    aput-byte v3, v1, v2

    goto :goto_12
.end method

.method public setNull()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 2614
    iget-object v0, p0, Lmain/Map;->npc:[[Ldm/Npc;

    const/4 v1, 0x0

    aput-object v2, v0, v1

    .line 2615
    iput-object v2, p0, Lmain/Map;->item:[[B

    .line 2616
    iput-object v2, p0, Lmain/Map;->door:[[B

    .line 2617
    iput-object v2, p0, Lmain/Map;->event:[[B

    .line 2618
    iput-object v2, p0, Lmain/Map;->mapImg:[Ljavax/microedition/lcdui/Image;

    .line 2619
    iput-object v2, p0, Lmain/Map;->moduleData:[[S

    .line 2629
    return-void
.end method

.method public setOverEvent(II)V
    .registers 8
    .param p1, "map"    # I
    .param p2, "id"    # I

    .prologue
    const/16 v4, 0x5ea0

    .line 694
    invoke-direct {p0, p1, p2}, Lmain/Map;->isMapEvent(II)Z

    move-result v0

    if-nez v0, :cond_16

    iget-object v0, p0, Lmain/Map;->mapInfo:[S

    mul-int/lit8 v1, p1, 0x2

    add-int/lit8 v1, v1, 0x1

    aget-short v2, v0, v1

    const/4 v3, 0x1

    shl-int/2addr v3, p2

    or-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 695
    :cond_16
    iget-byte v0, p0, Lmain/Map;->mapNo:B

    if-ne p1, v0, :cond_1f

    iget-object v0, p0, Lmain/Map;->event_now:[S

    aput-short v4, v0, p2

    .line 697
    :cond_1e
    :goto_1e
    return-void

    .line 696
    :cond_1f
    iget-object v0, p0, Lmain/Map;->event_now_list:[[S

    aget-object v0, v0, p1

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lmain/Map;->event_now_list:[[S

    aget-object v0, v0, p1

    aput-short v4, v0, p2

    goto :goto_1e
.end method

.method public declared-synchronized setRegState(Z)V
    .registers 5
    .param p1, "isSuccess"    # Z

    .prologue
    .line 4195
    monitor-enter p0

    :try_start_1
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "setRegState() notifyAll start isSuccess= "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 4196
    const/4 v0, 0x0

    iput-boolean v0, p0, Lmain/Map;->isNeedWait:Z

    .line 4197
    invoke-virtual {p0}, Ljava/lang/Object;->notifyAll()V

    .line 4199
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "setRegState() notifyAll over"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    :try_end_22
    .catchall {:try_start_1 .. :try_end_22} :catchall_24

    .line 4200
    monitor-exit p0

    return-void

    .line 4195
    :catchall_24
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setRestEvent(II)V
    .registers 8
    .param p1, "map"    # I
    .param p2, "id"    # I

    .prologue
    const/4 v4, 0x0

    .line 689
    invoke-direct {p0, p1, p2}, Lmain/Map;->isMapEvent(II)Z

    move-result v0

    if-eqz v0, :cond_15

    iget-object v0, p0, Lmain/Map;->mapInfo:[S

    mul-int/lit8 v1, p1, 0x2

    add-int/lit8 v1, v1, 0x1

    aget-short v2, v0, v1

    const/4 v3, 0x1

    shl-int/2addr v3, p2

    xor-int/2addr v2, v3

    int-to-short v2, v2

    aput-short v2, v0, v1

    .line 690
    :cond_15
    iget-byte v0, p0, Lmain/Map;->mapNo:B

    if-ne p1, v0, :cond_1e

    iget-object v0, p0, Lmain/Map;->event_now:[S

    aput-short v4, v0, p2

    .line 692
    :cond_1d
    :goto_1d
    return-void

    .line 691
    :cond_1e
    iget-object v0, p0, Lmain/Map;->event_now_list:[[S

    aget-object v0, v0, p1

    if-eqz v0, :cond_1d

    iget-object v0, p0, Lmain/Map;->event_now_list:[[S

    aget-object v0, v0, p1

    aput-short v4, v0, p2

    goto :goto_1d
.end method

.method public setTempNull()V
    .registers 2

    .prologue
    .line 107
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/Map;->mapTemp:[[B

    .line 108
    const/16 v0, 0x46

    new-array v0, v0, [[B

    iput-object v0, p0, Lmain/Map;->mapTemp:[[B

    .line 109
    return-void
.end method

.method public setfmap()V
    .registers 2

    .prologue
    .line 636
    const/4 v0, 0x0

    iput-byte v0, p0, Lmain/Map;->fmap:B

    .line 638
    return-void
.end method
