.class public final Lmain/MainCanvas;
.super Lcom/nokia/mid/ui/FullCanvas;
.source "MainCanvas.java"

# interfaces
.implements Ljava/lang/Runnable;


# static fields
.field private static dg:Lcom/nokia/mid/ui/DirectGraphics;

.field private static g:Ljavax/microedition/lcdui/Graphics;

.field public static mainxx:F

.field public static mainyy:F

.field public static mapxx:F

.field public static mapyy:F


# instance fields
.field battle_c:B

.field bblack:Z

.field public createStop:Z

.field dialog:[Ljava/lang/StringBuffer;

.field error:I

.field errorString:Ljava/lang/String;

.field private fisrt_paint:B

.field private flashSP:Ldm/Sprite;

.field game:Lmain/XConnection;

.field public game_state:I

.field gr:Lmain/GameRun;

.field private haveSoundBeforeHideNotify:Z

.field private help_state:B

.field iii:B

.field imageData:[I

.field image_logo:Ljavax/microedition/lcdui/Image;

.field image_logo_word:Ljavax/microedition/lcdui/Image;

.field load_c:I

.field logo_c:I

.field loop_s:I

.field private ma:B

.field public menu_state:I

.field private mt:B

.field pkey:Lmain/PointerKey;

.field public prevGameState:I

.field public prevMenuState:I

.field public prevRunState:I

.field quitGame:Z

.field public sender:Lmain/SMSSender;

.field private smsIsSetRun_state:Z

.field starttime:J

.field strTemp:Ljava/lang/String;

.field temp_gamestate:I

.field temp_loop:I

.field public temp_state:I

.field timetaken:J


# direct methods
.method public constructor <init>(Lmain/XConnection;)V
    .locals 4
    .param p1, "game"    # Lmain/XConnection;

    .prologue
    const-wide/16 v2, 0x0

    const/4 v1, 0x0

    .line 82
    invoke-direct {p0}, Lcom/nokia/mid/ui/FullCanvas;-><init>()V

    .line 59
    const-string v0, ""

    iput-object v0, p0, Lmain/MainCanvas;->errorString:Ljava/lang/String;

    .line 68
    iput-boolean v1, p0, Lmain/MainCanvas;->quitGame:Z

    .line 73
    iput v1, p0, Lmain/MainCanvas;->logo_c:I

    .line 74
    iput v1, p0, Lmain/MainCanvas;->temp_loop:I

    .line 161
    iput-wide v2, p0, Lmain/MainCanvas;->starttime:J

    .line 162
    iput-wide v2, p0, Lmain/MainCanvas;->timetaken:J

    .line 324
    const/16 v0, 0x9

    iput-byte v0, p0, Lmain/MainCanvas;->battle_c:B

    .line 325
    const-string v0, ""

    iput-object v0, p0, Lmain/MainCanvas;->strTemp:Ljava/lang/String;

    .line 326
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/MainCanvas;->imageData:[I

    .line 327
    iput-boolean v1, p0, Lmain/MainCanvas;->bblack:Z

    .line 629
    iput v1, p0, Lmain/MainCanvas;->temp_state:I

    .line 630
    iput v1, p0, Lmain/MainCanvas;->temp_gamestate:I

    .line 638
    iput-boolean v1, p0, Lmain/MainCanvas;->haveSoundBeforeHideNotify:Z

    .line 700
    iput-boolean v1, p0, Lmain/MainCanvas;->smsIsSetRun_state:Z

    .line 1054
    const/4 v0, -0x1

    iput v0, p0, Lmain/MainCanvas;->load_c:I

    .line 85
    iput-object p1, p0, Lmain/MainCanvas;->game:Lmain/XConnection;

    .line 86
    new-instance v0, Lmain/GameRun;

    invoke-direct {v0, p0}, Lmain/GameRun;-><init>(Lmain/MainCanvas;)V

    iput-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    .line 88
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-static {v0}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v0

    iput-object v0, p0, Lmain/MainCanvas;->sender:Lmain/SMSSender;

    .line 94
    new-instance v0, Lmain/PointerKey;

    invoke-direct {v0, p0}, Lmain/PointerKey;-><init>(Lmain/MainCanvas;)V

    iput-object v0, p0, Lmain/MainCanvas;->pkey:Lmain/PointerKey;

    .line 95
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, p0, Lmain/MainCanvas;->pkey:Lmain/PointerKey;

    iput-object v1, v0, Lmain/Map;->pkey:Lmain/PointerKey;

    .line 96
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v1, p0, Lmain/MainCanvas;->pkey:Lmain/PointerKey;

    iput-object v1, v0, Lmain/GameRun;->pkey:Lmain/PointerKey;

    .line 98
    iget-object v0, p0, Lmain/MainCanvas;->sender:Lmain/SMSSender;

    iget-object v1, p0, Lmain/MainCanvas;->pkey:Lmain/PointerKey;

    iput-object v1, v0, Lmain/SMSSender;->pkey:Lmain/PointerKey;

    .line 102
    sget v0, Lmain/Constants_H;->WIDTH__:I

    int-to-float v0, v0

    const/high16 v1, 0x44200000    # 640.0f

    div-float/2addr v0, v1

    sput v0, Lmain/MainCanvas;->mainxx:F

    sget v0, Lmain/Constants_H;->WIDTH__:I

    int-to-float v0, v0

    sget v1, Lmain/Constants_H;->WIDTH:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    sput v0, Lmain/MainCanvas;->mapxx:F

    .line 103
    sget v0, Lmain/Constants_H;->HEIGHT__:I

    int-to-float v0, v0

    const/high16 v1, 0x43b40000    # 360.0f

    div-float/2addr v0, v1

    sput v0, Lmain/MainCanvas;->mainyy:F

    sget v0, Lmain/Constants_H;->HEIGHT__:I

    int-to-float v0, v0

    sget v1, Lmain/Constants_H;->HEIGHT:I

    int-to-float v1, v1

    div-float/2addr v0, v1

    sput v0, Lmain/MainCanvas;->mapyy:F

    .line 104
    return-void
.end method

.method private final game_init()V
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->initOffG()V

    .line 150
    return-void
.end method

.method private goQuit()V
    .locals 1

    .prologue
    .line 1018
    const/16 v0, 0x65

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 1019
    return-void
.end method

.method private final keyProcess()V
    .locals 7

    .prologue
    const/4 v3, 0x3

    const/4 v2, 0x0

    const/4 v1, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 788
    iput v3, p0, Lmain/MainCanvas;->error:I

    .line 789
    iget v0, p0, Lmain/MainCanvas;->game_state:I

    sparse-switch v0, :sswitch_data_0

    .line 1006
    :cond_0
    :goto_0
    return-void

    .line 791
    :sswitch_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Num0()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 796
    :cond_1
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "\u6309\u952e\u5904\u7406\u8fd9\u91cc\u6267\u884c\u5417"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 797
    invoke-virtual {p0}, Lmain/MainCanvas;->doShowNotify()V

    .line 799
    :cond_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto :goto_0

    .line 803
    :sswitch_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1()Z

    move-result v0

    if-nez v0, :cond_3

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 804
    :cond_3
    iput v5, p0, Lmain/MainCanvas;->logo_c:I

    .line 805
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_S1()Z

    move-result v1

    invoke-virtual {v0, v1}, Ldm/Sound;->setSoundON(Z)V

    .line 806
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    invoke-virtual {v1}, Ldm/Ms;->key_S1()Z

    move-result v1

    if-eqz v1, :cond_5

    const/16 v1, 0x1e

    :goto_1
    invoke-virtual {v0, v1}, Ldm/Sound;->setVolume(I)V

    .line 807
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 808
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->goMAIN_MENU()V

    .line 810
    :cond_4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto :goto_0

    :cond_5
    move v1, v5

    .line 806
    goto :goto_1

    .line 814
    :sswitch_2
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->key_gameRun()V

    goto :goto_0

    .line 817
    :sswitch_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 818
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 819
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->goMAIN_MENU()V

    goto/16 :goto_0

    .line 830
    :sswitch_4
    iput-boolean v6, p0, Lmain/MainCanvas;->quitGame:Z

    .line 833
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto/16 :goto_0

    .line 836
    :sswitch_5
    iget v0, p0, Lmain/MainCanvas;->menu_state:I

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    goto/16 :goto_0

    .line 852
    :pswitch_1
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 854
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Num0()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 855
    iput-byte v5, p0, Lmain/MainCanvas;->ma:B

    iput-byte v5, p0, Lmain/MainCanvas;->mt:B

    iput v6, p0, Lmain/MainCanvas;->load_c:I

    .line 863
    :cond_6
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 865
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->selectx:B

    packed-switch v0, :pswitch_data_1

    goto/16 :goto_0

    .line 888
    :pswitch_2
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0, v1}, Lmain/GameRun;->skyCheckRegFull(I)V

    goto/16 :goto_0

    .line 839
    :pswitch_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1_Num5()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 840
    invoke-direct {p0}, Lmain/MainCanvas;->newGame()V

    .line 849
    :cond_7
    :goto_2
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto/16 :goto_0

    .line 845
    :cond_8
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 846
    iput v5, p0, Lmain/MainCanvas;->menu_state:I

    .line 847
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-object v2, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    goto :goto_2

    .line 856
    :cond_9
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-nez v0, :cond_6

    goto/16 :goto_0

    .line 874
    :pswitch_4
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0, v6}, Lmain/GameRun;->skyCheckRegFull(I)V

    goto/16 :goto_0

    .line 896
    :pswitch_5
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, v5}, Ldm/Sound;->keyVolume(I)V

    .line 897
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, v6}, Ldm/Sound;->setMusicForMenu(Z)V

    goto/16 :goto_0

    .line 901
    :pswitch_6
    invoke-virtual {p0, v5}, Lmain/MainCanvas;->goHELP_dialog(I)V

    goto/16 :goto_0

    .line 906
    :pswitch_7
    const-string v0, "soars"

    const-string v1, "ABOUT_BUTTON"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 908
    invoke-virtual {p0}, Lmain/MainCanvas;->goABOUT()V

    goto/16 :goto_0

    .line 911
    :pswitch_8
    const-string v0, "soars"

    const-string v1, "EXIT_BUTTON"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 918
    iput-boolean v6, p0, Lmain/MainCanvas;->quitGame:Z

    .line 919
    iget-object v0, p0, Lmain/MainCanvas;->game:Lmain/XConnection;

    invoke-virtual {v0, v6}, Lmain/XConnection;->destroyApp(Z)V

    goto/16 :goto_0

    .line 926
    :cond_a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 927
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->selectx:B

    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->rmsOther:[B

    aget-byte v3, v3, v5

    const/4 v4, -0x1

    if-ne v3, v4, :cond_b

    move v3, v6

    :goto_3
    iget-object v4, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->action_str:[Ljava/lang/String;

    array-length v4, v4

    sub-int/2addr v4, v6

    invoke-virtual {v1, v2, v3, v4}, Ldm/Ms;->select(III)B

    move-result v1

    iput-byte v1, v0, Lmain/GameRun;->selectx:B

    goto/16 :goto_0

    :cond_b
    move v3, v5

    goto :goto_3

    .line 946
    :pswitch_9
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_e

    .line 947
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-object v2, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    .line 948
    iget-byte v0, p0, Lmain/MainCanvas;->help_state:B

    if-ne v0, v6, :cond_d

    .line 949
    const/16 v0, 0x1e

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 950
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0, v5}, Lmain/GameRun;->doPaint(I)V

    .line 951
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0, v1}, Lmain/GameRun;->goYouPAUSE(I)V

    .line 952
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-byte v6, v0, Lmain/GameRun;->selectx:B

    .line 953
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-byte v1, v0, Lmain/GameRun;->selecty:B

    .line 954
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v1, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->selectx:B

    invoke-virtual {v0, v1}, Lmain/GameRun;->setPauseS(I)V

    .line 961
    :cond_c
    :goto_4
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto/16 :goto_0

    .line 956
    :cond_d
    invoke-virtual {p0}, Lmain/MainCanvas;->goMain_menu()V

    .line 957
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->select:[[B

    aget-object v0, v0, v5

    aput-byte v3, v0, v5

    goto :goto_4

    .line 959
    :cond_e
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-nez v0, :cond_f

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 960
    :cond_f
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->help_page:B

    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->page_max:B

    sub-int/2addr v3, v6

    invoke-virtual {v1, v2, v5, v3}, Ldm/Ms;->select(III)B

    move-result v1

    iput-byte v1, v0, Lmain/GameRun;->help_page:B

    goto :goto_4

    .line 964
    :pswitch_a
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 965
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 966
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-object v2, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    .line 967
    const-string v0, "soars"

    const-string v1, "gr.about_a dfd"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 968
    invoke-virtual {p0}, Lmain/MainCanvas;->goMain_menu()V

    .line 972
    :cond_10
    :goto_5
    const-string v0, "soars"

    const-string v1, "s.i().key_Up_Down()||Ms.i().key"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 973
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    goto/16 :goto_0

    .line 969
    :cond_11
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-nez v0, :cond_12

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left_Right()Z

    move-result v0

    if-eqz v0, :cond_10

    .line 970
    :cond_12
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v1

    iget-object v2, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->help_page:B

    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->page_max:B

    sub-int/2addr v3, v6

    invoke-virtual {v1, v2, v5, v3}, Ldm/Ms;->select(III)B

    move-result v1

    iput-byte v1, v0, Lmain/GameRun;->help_page:B

    goto :goto_5

    .line 789
    :sswitch_data_0
    .sparse-switch
        0xa -> :sswitch_1
        0xb -> :sswitch_3
        0x1e -> :sswitch_2
        0x28 -> :sswitch_5
        0x62 -> :sswitch_0
        0x65 -> :sswitch_4
    .end sparse-switch

    .line 836
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_9
        :pswitch_a
    .end packed-switch

    .line 865
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_2
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method private newGame()V
    .locals 6

    .prologue
    const/4 v5, 0x5

    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 1205
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->data_init()V

    .line 1207
    const-string v0, "test"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "new game "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    invoke-virtual {v2, v3, v4, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1208
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0, v3, v4, v5}, Ldm/Ms;->rmsOptions(I[BI)[B

    move-result-object v0

    if-nez v0, :cond_0

    .line 1210
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    iput-byte v3, v0, Lmain/Map;->firstDrawMap:B

    .line 1211
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v3, v4, v1}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 1212
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->initRmsOther()V

    .line 1213
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/16 v1, 0xa

    iget-object v2, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->rmsOther:[B

    const/4 v3, 0x2

    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 1214
    invoke-virtual {p0}, Lmain/MainCanvas;->goGameLoading()V

    .line 1215
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lmain/Map;->initSrcEffect(I)Z

    .line 1220
    :goto_0
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-object v4, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    .line 1221
    return-void

    .line 1218
    :cond_0
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    const-string v1, "\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3\uff01"

    invoke-virtual {v0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method private setMenuFrame_C()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 275
    iget-byte v0, p0, Lmain/MainCanvas;->mt:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/MainCanvas;->mt:B

    iget-object v1, p0, Lmain/MainCanvas;->flashSP:Ldm/Sprite;

    iget v2, p0, Lmain/MainCanvas;->load_c:I

    iget-byte v3, p0, Lmain/MainCanvas;->ma:B

    invoke-virtual {v1, v2, v3, v5}, Ldm/Sprite;->action(III)I

    move-result v1

    if-le v0, v1, :cond_0

    .line 276
    iput-byte v4, p0, Lmain/MainCanvas;->mt:B

    .line 277
    iget-byte v0, p0, Lmain/MainCanvas;->ma:B

    add-int/lit8 v0, v0, 0x1

    int-to-byte v0, v0

    iput-byte v0, p0, Lmain/MainCanvas;->ma:B

    iget-object v1, p0, Lmain/MainCanvas;->flashSP:Ldm/Sprite;

    iget v2, p0, Lmain/MainCanvas;->load_c:I

    invoke-virtual {v1, v2}, Ldm/Sprite;->aLength(I)I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 278
    iput-byte v4, p0, Lmain/MainCanvas;->ma:B

    .line 279
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-nez v0, :cond_0

    iput v5, p0, Lmain/MainCanvas;->load_c:I

    .line 282
    :cond_0
    return-void
.end method


# virtual methods
.method public checkHaveSoundBeforeHideNotify()Z
    .locals 3

    .prologue
    .line 640
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "checkHaveSoundBeforeHideNotify haveSoundBeforeHideNotify= "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v2, p0, Lmain/MainCanvas;->haveSoundBeforeHideNotify:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 641
    iget-boolean v0, p0, Lmain/MainCanvas;->haveSoundBeforeHideNotify:Z

    return v0
.end method

.method public checkSmsRun_stateIsTrue()Z
    .locals 3

    .prologue
    .line 708
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "checkSmsRun_stateIsTrue smsIsSetRun_state= "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-boolean v2, p0, Lmain/MainCanvas;->smsIsSetRun_state:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 709
    iget-boolean v0, p0, Lmain/MainCanvas;->smsIsSetRun_state:Z

    return v0
.end method

.method createFlashImage()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 269
    iget-object v0, p0, Lmain/MainCanvas;->flashSP:Ldm/Sprite;

    if-nez v0, :cond_0

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "data/fm"

    invoke-virtual {v0, v1, v2}, Ldm/Ms;->createSprite(Ljava/lang/String;Z)Ldm/Sprite;

    move-result-object v0

    iput-object v0, p0, Lmain/MainCanvas;->flashSP:Ldm/Sprite;

    .line 270
    :cond_0
    iput-byte v2, p0, Lmain/MainCanvas;->mt:B

    iput-byte v2, p0, Lmain/MainCanvas;->ma:B

    .line 271
    iput v2, p0, Lmain/MainCanvas;->load_c:I

    .line 273
    return-void
.end method

.method public doShowNotify()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 713
    iget v0, p0, Lmain/MainCanvas;->temp_gamestate:I

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 715
    invoke-virtual {p0}, Lmain/MainCanvas;->checkSmsRun_stateIsTrue()Z

    move-result v0

    if-nez v0, :cond_2

    .line 716
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "\u5728\u8fd9\uff1f"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 717
    iget v0, p0, Lmain/MainCanvas;->temp_state:I

    sput v0, Lmain/GameRun;->run_state:I

    .line 727
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lmain/MainCanvas;->checkHaveSoundBeforeHideNotify()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 728
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, v2}, Ldm/Sound;->setMusic(Z)V

    .line 729
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, v2}, Ldm/Sound;->setSoundON(Z)V

    .line 730
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Sound;->soundPlay()V

    .line 731
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Sound;->soundStart()V

    .line 734
    :cond_1
    return-void

    .line 719
    :cond_2
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 720
    sget v0, Lmain/GameRun;->run_state:I

    const/16 v1, 0x62

    if-ne v0, v1, :cond_0

    .line 721
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "\u5728\u8fd9\uff1f\uff1f"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 722
    iget v0, p0, Lmain/MainCanvas;->temp_state:I

    sput v0, Lmain/GameRun;->run_state:I

    goto :goto_0
.end method

.method public drawRectBG()V
    .locals 12

    .prologue
    const/4 v11, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x4

    const/4 v2, 0x0

    const/16 v4, 0xa

    .line 1037
    const/16 v8, 0x280

    .local v8, "WIDTH":I
    const/16 v7, 0x168

    .line 1038
    .local v7, "HEIGHT":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ui;->fillRectB()V

    .line 1039
    new-array v1, v5, [I

    const/4 v0, 0x1

    aput v4, v1, v0

    const/16 v0, 0x14

    aput v0, v1, v6

    aput v4, v1, v11

    .line 1040
    .local v1, "vertexX":[I
    new-array v3, v5, [I

    aput v4, v3, v2

    aput v4, v3, v6

    const/16 v0, 0x14

    aput v0, v3, v11

    .line 1042
    .local v3, "vertexY":[I
    const/4 v10, 0x0

    .local v10, "j":B
    :goto_0
    div-int/lit8 v0, v7, 0x14

    add-int/lit8 v0, v0, 0x1

    if-lt v10, v0, :cond_0

    .line 1049
    const/4 v1, 0x0

    check-cast v1, [I

    .line 1050
    const/4 v3, 0x0

    check-cast v3, [I

    .line 1051
    return-void

    .line 1043
    :cond_0
    const/4 v9, 0x0

    .local v9, "i":B
    :goto_1
    div-int/lit8 v0, v8, 0x14

    add-int/lit8 v0, v0, 0x1

    if-lt v9, v0, :cond_1

    .line 1042
    add-int/lit8 v0, v10, 0x1

    int-to-byte v10, v0

    goto :goto_0

    .line 1044
    :cond_1
    sget-object v0, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    mul-int/lit8 v4, v9, 0x14

    mul-int/lit8 v6, v10, 0x14

    invoke-virtual {v0, v4, v6}, Ljavax/microedition/lcdui/Graphics;->translate(II)V

    .line 1045
    sget-object v0, Lmain/MainCanvas;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    const v6, -0xb03801

    move v4, v2

    invoke-virtual/range {v0 .. v6}, Lcom/nokia/mid/ui/DirectGraphics;->fillPolygon([II[IIII)V

    .line 1046
    sget-object v0, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    mul-int/lit8 v4, v9, -0x14

    mul-int/lit8 v6, v10, -0x14

    invoke-virtual {v0, v4, v6}, Ljavax/microedition/lcdui/Graphics;->translate(II)V

    .line 1043
    add-int/lit8 v0, v9, 0x1

    int-to-byte v9, v0

    goto :goto_1
.end method

.method public final game_start()V
    .locals 1

    .prologue
    .line 153
    new-instance v0, Ljava/lang/Thread;

    invoke-direct {v0, p0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 154
    return-void
.end method

.method public final game_stop()V
    .locals 4

    .prologue
    .line 158
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 159
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Sound;->soundStop()V

    .line 160
    return-void
.end method

.method goABOUT()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 1166
    const-string v0, "soars"

    const-string v1, "goAbout"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1167
    const/16 v0, 0x28

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 1168
    const/4 v0, 0x5

    iput v0, p0, Lmain/MainCanvas;->menu_state:I

    .line 1169
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-byte v4, v0, Lmain/GameRun;->help_page:B

    .line 1170
    iput v4, p0, Lmain/MainCanvas;->logo_c:I

    .line 1171
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    const/16 v1, 0xb

    iput-byte v1, v0, Lmain/GameRun;->line_max:B

    .line 1172
    iput-byte v4, p0, Lmain/MainCanvas;->help_state:B

    .line 1174
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    .line 1175
    const-string v1, "\u5ba0\u7269\u738b\u56fd5-\u5f69\u8679#n\u5f00\u53d1\u5546\uff1a\u534e\u5a31\u65e0\u7ebf#n\u5ba2\u670d\u7535\u8bdd\uff1a#n010-88901665#n\u5ba2\u670dEmail:#ngeekan@imy.cn"

    .line 1188
    sget v2, Lmain/Constants_H;->WIDTH:I

    const/16 v3, 0x32

    sub-int/2addr v2, v3

    .line 1174
    invoke-virtual {v0, v1, v2, v4}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 1192
    return-void
.end method

.method public goGameLoading()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1223
    const-string v0, "loading"

    const-string v1, "\u6e38\u620f\u72b6\u6001\uff1aGAME_LOADING"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1224
    const/16 v0, 0x14

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 1225
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-byte v2, v0, Lmain/GameRun;->time_count:B

    .line 1226
    const/4 v0, 0x0

    iput-object v0, p0, Lmain/MainCanvas;->flashSP:Ldm/Sprite;

    .line 1228
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0}, Lmain/Map;->loadDate_Rms()V

    .line 1231
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->loadRmsOther()V

    .line 1232
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v1, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->map:Lmain/Map;

    iget-byte v1, v1, Lmain/Map;->anole_type:B

    iput-byte v1, v0, Lmain/Map;->anole_temp:B

    .line 1234
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    const/4 v1, 0x5

    invoke-static {v1}, Ldm/Ms;->getRandom(I)I

    move-result v1

    int-to-byte v1, v1

    iput-byte v1, v0, Lmain/Map;->anole_type:B

    .line 1238
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    invoke-virtual {v0}, Lmain/Map;->setAnole()V

    .line 1239
    invoke-virtual {p0}, Lmain/MainCanvas;->paint()V

    .line 1240
    new-instance v0, Lmain/CreateThread;

    iget-object v1, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-direct {v0, v1, v2}, Lmain/CreateThread;-><init>(Lmain/GameRun;I)V

    .line 1241
    return-void
.end method

.method goHELP_dialog(I)V
    .locals 5
    .param p1, "mode"    # I

    .prologue
    const/4 v4, 0x0

    .line 1141
    const/16 v0, 0x28

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 1142
    const/4 v0, 0x4

    iput v0, p0, Lmain/MainCanvas;->menu_state:I

    .line 1143
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-byte v4, v0, Lmain/GameRun;->help_page:B

    .line 1144
    iput v4, p0, Lmain/MainCanvas;->logo_c:I

    .line 1145
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/MainCanvas;->help_state:B

    .line 1151
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    const/16 v1, 0xb

    iput-byte v1, v0, Lmain/GameRun;->line_max:B

    .line 1154
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    const-string v1, "\u6e38\u620f\u5e2e\u52a9#n\u73a9\u5bb6\u626e\u6f14\u4e00\u540d\u5ba0\u7269\u8bad\u7ec3\u5e08\uff0c\u4e3a\u4e86\u89e3\u51b3\u56fd\u5bb6\u7684\u5371\u673a\u800c\u8e0f\u4e0a\u4e86\u5192\u9669\u4e4b\u65c5\u3002#n\u64cd\u4f5c\u63d0\u793a#n\u70b9\u51fb\u4e3b\u7ebf\u4efb\u52a1\u56fe\u6807\uff1a\u4e3b\u7ebf\u4efb\u52a1#n\u70b9\u51fb\u652f\u7ebf\u4efb\u52a1\u56fe\u6807\uff1a\u652f\u7ebf\u4efb\u52a1#n\u70b9\u51fb\u5730\u56fe\u56fe\u6807\uff1a\u6e38\u620f\u5730\u56fe#n\u70b9\u51fb\u5c4f\u5e55\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8#n\u672c\u7248\u672c\u53ea\u652f\u6301\u6a2a\u5c4f\u6e38\u620f"

    .line 1163
    sget v2, Lmain/Constants_H;->WIDTH:I

    const/16 v3, 0x32

    sub-int/2addr v2, v3

    .line 1154
    invoke-virtual {v0, v1, v2, v4}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 1164
    return-void
.end method

.method goMain_menu()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 314
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    const/4 v1, 0x7

    invoke-virtual {v0, v1}, Ldm/Sound;->setMusicId(I)V

    .line 315
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, v2}, Ldm/Sound;->setMusic(Z)V

    .line 316
    const/16 v0, 0x28

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 317
    iput v2, p0, Lmain/MainCanvas;->menu_state:I

    .line 318
    iput-byte v2, p0, Lmain/MainCanvas;->fisrt_paint:B

    .line 319
    return-void
.end method

.method public hideNotify()V
    .locals 0

    .prologue
    .line 635
    invoke-virtual {p0}, Lmain/MainCanvas;->hideNotifyMy()V

    .line 636
    return-void
.end method

.method public hideNotifyMy()V
    .locals 4

    .prologue
    const/16 v3, 0x62

    .line 645
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "hideNotifyMy() run_state= "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v2, Lmain/GameRun;->run_state:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " game_state= "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lmain/MainCanvas;->game_state:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 649
    const/4 v0, 0x0

    sput-boolean v0, Ldm/Ms;->keyRepeat:Z

    .line 651
    iget v0, p0, Lmain/MainCanvas;->game_state:I

    if-eq v0, v3, :cond_2

    sget v0, Lmain/GameRun;->run_state:I

    if-eq v0, v3, :cond_2

    .line 652
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Sound;->getHaveSoundPlayState()Z

    move-result v0

    iput-boolean v0, p0, Lmain/MainCanvas;->haveSoundBeforeHideNotify:Z

    .line 653
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Sound;->soundStop()V

    .line 658
    iget v0, p0, Lmain/MainCanvas;->game_state:I

    if-eq v0, v3, :cond_0

    .line 659
    iget v0, p0, Lmain/MainCanvas;->game_state:I

    iput v0, p0, Lmain/MainCanvas;->temp_gamestate:I

    .line 662
    :cond_0
    sget v0, Lmain/GameRun;->run_state:I

    if-eq v0, v3, :cond_1

    .line 663
    sget v0, Lmain/GameRun;->run_state:I

    iput v0, p0, Lmain/MainCanvas;->temp_state:I

    .line 666
    :cond_1
    sput v3, Lmain/GameRun;->run_state:I

    .line 668
    iput v3, p0, Lmain/MainCanvas;->game_state:I

    .line 672
    :cond_2
    return-void
.end method

.method public initGraphics(Ljavax/microedition/lcdui/Graphics;)V
    .locals 2
    .param p1, "_g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 331
    sput-object p1, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    .line 332
    invoke-static {p1}, Lcom/nokia/mid/ui/DirectUtils;->getDirectGraphics(Ljavax/microedition/lcdui/Graphics;)Lcom/nokia/mid/ui/DirectGraphics;

    move-result-object v0

    sput-object v0, Lmain/MainCanvas;->dg:Lcom/nokia/mid/ui/DirectGraphics;

    .line 333
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    sget-object v1, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, v1}, Lmain/GameRun;->initGraphics(Ljavax/microedition/lcdui/Graphics;)V

    .line 334
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    sget-object v1, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, v1}, Ldm/Ui;->initGraphics(Ljavax/microedition/lcdui/Graphics;)V

    .line 335
    return-void
.end method

.method protected final keyPressed(I)V
    .locals 2
    .param p1, "key"    # I

    .prologue
    .line 772
    sget-boolean v0, Lmain/SMSSender;->isWorking:Z

    if-eqz v0, :cond_0

    .line 773
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 782
    :goto_0
    return-void

    .line 780
    :cond_0
    const/4 v0, 0x1

    sput-boolean v0, Ldm/Ms;->keyRepeat:Z

    .line 781
    sput p1, Ldm/Ms;->key:I

    goto :goto_0
.end method

.method protected final keyReleased(I)V
    .locals 1
    .param p1, "key"    # I

    .prologue
    .line 784
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 785
    return-void
.end method

.method public paint()V
    .locals 0

    .prologue
    .line 321
    invoke-virtual {p0}, Lmain/MainCanvas;->repaint()V

    .line 322
    invoke-virtual {p0}, Lmain/MainCanvas;->serviceRepaints()V

    .line 323
    return-void
.end method

.method protected paint(Ljavax/microedition/lcdui/Graphics;)V
    .locals 26
    .param p1, "g"    # Ljavax/microedition/lcdui/Graphics;

    .prologue
    .line 340
    move-object/from16 v0, p0

    iget v0, v0, Lmain/MainCanvas;->game_state:I

    move v5, v0

    if-eqz v5, :cond_0

    .line 341
    sget v5, Lmain/MainCanvas;->mainxx:F

    sget v6, Lmain/MainCanvas;->mainyy:F

    move-object/from16 v0, p0

    move v1, v5

    move v2, v6

    invoke-virtual {v0, v1, v2}, Lmain/MainCanvas;->setScale(FF)V

    .line 342
    :cond_0
    sget v5, Lmain/MainCanvas;->mainxx:F

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/MainCanvas;->keyxx:F

    .line 343
    sget v5, Lmain/MainCanvas;->mainyy:F

    move v0, v5

    move-object/from16 v1, p0

    iput v0, v1, Lmain/MainCanvas;->keyyy:F

    .line 344
    const/16 v9, 0x280

    .local v9, "WIDTH":I
    const/16 v25, 0x168

    .line 345
    .local v25, "HEIGHT":I
    const/16 v12, 0x140

    .local v12, "WIDTH_H":I
    const/16 v17, 0xb4

    .line 348
    .local v17, "HEIGHT_H":I
    invoke-virtual/range {p0 .. p1}, Lmain/MainCanvas;->initGraphics(Ljavax/microedition/lcdui/Graphics;)V

    .line 349
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-object v5, Ldm/Ms;->font:Ljavax/microedition/lcdui/Font;

    move-object/from16 v0, p1

    move-object v1, v5

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/Graphics;->setFont(Ljavax/microedition/lcdui/Font;)V

    .line 350
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    move v3, v9

    move/from16 v4, v25

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 363
    move-object/from16 v0, p0

    iget v0, v0, Lmain/MainCanvas;->game_state:I

    move v5, v0

    sparse-switch v5, :sswitch_data_0

    .line 626
    .end local v9    # "WIDTH":I
    .end local v17    # "HEIGHT_H":I
    :goto_0
    :sswitch_0
    return-void

    .line 365
    .restart local v9    # "WIDTH":I
    .restart local v17    # "HEIGHT_H":I
    :sswitch_1
    invoke-virtual/range {p0 .. p0}, Lmain/MainCanvas;->drawRectBG()V

    .line 366
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, -0x5

    const/16 v7, 0x4b

    sub-int v7, v25, v7

    add-int/lit8 v8, v9, 0xa

    const/16 v9, 0x4b

    const/4 v10, 0x3

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK1(IIIII)V

    .line 367
    .end local v9    # "WIDTH":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    const-string v6, "\u6e38\u620f\u6682\u505c\uff0c\u70b9\u51fb\u5c4f\u5e55\u8fd4\u56de\u3002"

    const/16 v7, 0x32

    sub-int v7, v25, v7

    const/4 v8, 0x2

    sub-int v8, v7, v8

    const/16 v9, 0x9

    const/4 v10, 0x3

    move v7, v12

    invoke-virtual/range {v5 .. v10}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    goto :goto_0

    .line 371
    .restart local v9    # "WIDTH":I
    :sswitch_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object v0, v5

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Lmain/GameRun;->paint_gameRun(Ljavax/microedition/lcdui/Graphics;)V

    goto :goto_0

    .line 389
    :sswitch_3
    invoke-virtual/range {p0 .. p0}, Lmain/MainCanvas;->paintMobileLogo()V

    goto :goto_0

    .line 393
    :sswitch_4
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    move/from16 v10, v25

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->fillRect(IIIII)V

    .line 394
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    const-string v11, "\u662f\u5426\u6253\u5f00\u97f3\u4e50?"

    const/16 v5, 0x19

    sub-int v13, v17, v5

    const/4 v5, 0x1

    or-int/lit8 v14, v5, 0x10

    const/4 v15, 0x0

    const/16 v16, 0x0

    invoke-virtual/range {v10 .. v16}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 395
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    const-string v11, "\uff08\u5173\u95ed\u58f0\u97f3\u6e38\u620f\u66f4\u6d41\u7545\uff09"

    const/4 v5, 0x1

    or-int/lit8 v14, v5, 0x10

    const/4 v15, 0x5

    const/16 v16, 0x0

    move/from16 v13, v17

    invoke-virtual/range {v10 .. v16}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 400
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v13

    const-string v14, "\u662f"

    const/4 v15, 0x4

    const/4 v5, 0x4

    or-int/lit8 v17, v5, 0x20

    const/16 v18, 0x0

    const/16 v19, 0x0

    move/from16 v16, v25

    invoke-virtual/range {v13 .. v19}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 401
    .end local v17    # "HEIGHT_H":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v13

    const-string v14, "\u5426"

    const/4 v5, 0x4

    sub-int v15, v9, v5

    const/16 v5, 0x8

    or-int/lit8 v17, v5, 0x20

    const/16 v18, 0x0

    const/16 v19, 0x0

    move/from16 v16, v25

    invoke-virtual/range {v13 .. v19}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto/16 :goto_0

    .line 406
    .restart local v17    # "HEIGHT_H":I
    :sswitch_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v13, v0

    const/4 v14, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v15, v5, Lmain/GameRun;->time_count:B

    const/16 v16, 0x1e

    const/16 v5, 0x26

    sub-int v17, v25, v5

    const/16 v5, 0x3c

    sub-int v18, v9, v5

    invoke-virtual/range {v13 .. v18}, Lmain/GameRun;->drawChangeMap(ZIIII)V

    goto/16 :goto_0

    .line 424
    :sswitch_6
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->image_logo:Ljavax/microedition/lcdui/Image;

    move-object v6, v0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    goto/16 :goto_0

    .line 427
    :sswitch_7
    move-object/from16 v0, p0

    iget v0, v0, Lmain/MainCanvas;->menu_state:I

    move v5, v0

    packed-switch v5, :pswitch_data_0

    :pswitch_0
    goto/16 :goto_0

    .line 451
    :pswitch_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    move/from16 v10, v25

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->fillRect(IIIII)V

    .line 453
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->flashSP:Ldm/Sprite;

    move-object v14, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->flashSP:Ldm/Sprite;

    move-object v5, v0

    move-object/from16 v0, p0

    iget v0, v0, Lmain/MainCanvas;->load_c:I

    move v6, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/MainCanvas;->ma:B

    move v7, v0

    const/4 v8, 0x0

    invoke-virtual {v5, v6, v7, v8}, Ldm/Sprite;->action(III)I

    move-result v15

    const/16 v18, 0x0

    move/from16 v16, v12

    invoke-virtual/range {v13 .. v18}, Ldm/Ui;->drawFrameOne(Ldm/Sprite;IIII)V

    .line 454
    invoke-direct/range {p0 .. p0}, Lmain/MainCanvas;->setMenuFrame_C()V

    .line 455
    move-object/from16 v0, p0

    iget v0, v0, Lmain/MainCanvas;->load_c:I

    move v5, v0

    const/4 v6, 0x1

    if-ne v5, v6, :cond_2

    .line 460
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, p1

    move v1, v5

    move v2, v6

    move v3, v9

    move/from16 v4, v25

    invoke-virtual {v0, v1, v2, v3, v4}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 464
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v18

    const/16 v5, 0x7d

    sub-int v5, v12, v5

    const/4 v6, 0x5

    sub-int v19, v5, v6

    const/16 v5, 0x19

    sub-int v5, v25, v5

    const/4 v6, 0x6

    sub-int v20, v5, v6

    const/16 v21, 0x104

    const/16 v22, 0x1f

    const/16 v23, 0x0

    invoke-virtual/range {v18 .. v23}, Ldm/Ui;->drawK0(IIIII)V

    .line 465
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-byte v5, v5, Lmain/GameRun;->selectx:B

    const/4 v6, 0x2

    if-ne v5, v6, :cond_1

    .line 468
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    add-int/lit8 v6, v12, 0x6

    add-int/lit8 v6, v6, 0x46

    const/16 v7, 0x13

    sub-int v7, v25, v7

    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v8

    invoke-virtual {v8}, Ldm/Sound;->getVolume()B

    move-result v8

    const/4 v9, 0x1

    invoke-virtual {v5, v6, v7, v8, v9}, Ldm/Ui;->drawVolume(IIIZ)V

    .line 469
    .end local v9    # "WIDTH":I
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v5, v5, Lmain/GameRun;->action_str:[Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v6, v0

    iget-byte v6, v6, Lmain/GameRun;->selectx:B

    aget-object v11, v5, v6

    add-int/lit8 v13, v25, 0x6

    const/4 v5, 0x1

    or-int/lit8 v14, v5, 0x20

    const/4 v15, 0x3

    const/16 v16, 0x1

    invoke-virtual/range {v10 .. v16}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 470
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v11

    const/16 v5, 0xd

    sub-int v13, v25, v5

    const/16 v14, 0x7d

    const/4 v15, 0x1

    const/16 v16, 0x1

    invoke-virtual/range {v11 .. v16}, Ldm/Ui;->drawTriangle1(IIIZZ)V

    .line 497
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    goto/16 :goto_0

    .line 501
    .restart local v9    # "WIDTH":I
    :cond_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    const-string v11, "\u70b9\u51fb\u5c4f\u5e55\u8df3\u8fc7"

    const/4 v5, 0x1

    or-int/lit8 v14, v5, 0x20

    const/4 v15, 0x1

    const/16 v16, 0x2

    move/from16 v13, v25

    invoke-virtual/range {v10 .. v16}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    goto/16 :goto_0

    .line 505
    :pswitch_2
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    const/16 v7, 0x57

    sub-int v7, v25, v7

    const/16 v8, 0x3a

    invoke-virtual {v5, v6, v7, v9, v8}, Ldm/Ui;->drawKuang(IIII)V

    .line 506
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v10, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    iget-object v11, v5, Lmain/GameRun;->gogoString:Ljava/lang/String;

    const/16 v5, 0x57

    sub-int v5, v25, v5

    add-int/lit8 v13, v5, 0x2

    const/16 v14, 0xa

    const/4 v15, 0x3

    invoke-virtual/range {v10 .. v15}, Lmain/GameRun;->showStringM(Ljava/lang/String;IIII)V

    .line 507
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x1

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    goto/16 :goto_0

    .line 510
    :pswitch_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v11, 0x2

    move/from16 v10, v25

    invoke-virtual/range {v6 .. v11}, Ldm/Ui;->drawK0(IIIII)V

    .line 519
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object v0, v5

    iget-object v0, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object v0, v5

    iget-byte v0, v0, Lmain/GameRun;->line_max:B

    move/from16 v21, v0

    const/16 v23, 0xa

    const/4 v5, 0x1

    or-int/lit8 v24, v5, 0x10

    move-object/from16 v19, p1

    move/from16 v22, v12

    invoke-virtual/range {v18 .. v24}, Lmain/GameRun;->drawHelpStr(Ljavax/microedition/lcdui/Graphics;[Ljava/lang/StringBuffer;IIII)V

    .line 520
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    goto/16 :goto_0

    .line 523
    :pswitch_4
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v6

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v11, 0x2

    move/from16 v10, v25

    invoke-virtual/range {v6 .. v11}, Ldm/Ui;->drawK0(IIIII)V

    .line 532
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    const-string v6, "\u5ba0\u7269\u738b\u56fd5-\u5f69\u8679#n\u5f00\u53d1\u5546\uff1a#n\u534e\u5a31\u65e0\u7ebf#n\u5ba2\u670d\u7535\u8bdd\uff1a#n010-88901665#n\u5ba2\u670dEmail:#ngeekan@imy.cn"

    .line 539
    const/16 v7, 0x32

    sub-int v7, v9, v7

    const/4 v8, 0x0

    .line 532
    invoke-virtual {v5, v6, v7, v8}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 540
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object v0, v5

    iget-object v0, v0, Lmain/GameRun;->about_a:[Ljava/lang/StringBuffer;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    move-object v5, v0

    move-object v0, v5

    iget-byte v0, v0, Lmain/GameRun;->line_max:B

    move/from16 v21, v0

    const/16 v23, 0xa

    const/4 v5, 0x1

    or-int/lit8 v24, v5, 0x10

    move-object/from16 v19, p1

    move/from16 v22, v12

    invoke-virtual/range {v18 .. v24}, Lmain/GameRun;->drawHelpStr(Ljavax/microedition/lcdui/Graphics;[Ljava/lang/StringBuffer;IIII)V

    .line 541
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v6, 0x0

    const/4 v7, 0x1

    invoke-virtual {v5, v6, v7}, Ldm/Ui;->drawYesNo(ZZ)V

    goto/16 :goto_0

    .line 363
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_3
        0xa -> :sswitch_4
        0xb -> :sswitch_6
        0x14 -> :sswitch_5
        0x1e -> :sswitch_2
        0x28 -> :sswitch_7
        0x3c -> :sswitch_0
        0x62 -> :sswitch_1
        0x65 -> :sswitch_0
    .end sparse-switch

    .line 427
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method protected paintMobileLogo()V
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/16 v9, 0x25

    const/16 v3, 0x13

    const/4 v8, 0x1

    const/4 v2, 0x0

    .line 1061
    sget v4, Lmain/Constants_H;->WIDTH__:I

    .local v4, "WIDTH":I
    sget v5, Lmain/Constants_H;->HEIGHT__:I

    .line 1062
    .local v5, "HEIGHT":I
    sget v0, Lmain/Constants_H;->WIDTH__:I

    div-int/lit8 v7, v0, 0x2

    .local v7, "WIDTH_H":I
    sget v0, Lmain/Constants_H;->HEIGHT__:I

    div-int/lit8 v6, v0, 0x2

    .line 1063
    .local v6, "HEIGHT_H":I
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-gez v0, :cond_0

    .line 1065
    iput v2, p0, Lmain/MainCanvas;->load_c:I

    .line 1135
    :goto_0
    return-void

    .line 1091
    :cond_0
    sget-object v0, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, v2, v2, v4, v5}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 1092
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-ltz v0, :cond_3

    iget v0, p0, Lmain/MainCanvas;->load_c:I

    const/16 v1, 0x12

    if-ge v0, v1, :cond_3

    .line 1094
    sget-object v0, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, v2, v2, v4, v5}, Ljavax/microedition/lcdui/Graphics;->setClip(IIII)V

    .line 1095
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    const v1, 0xffffff

    move v3, v2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 1100
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-nez v0, :cond_1

    .line 1101
    sget-object v0, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    sput-object v0, Lmain/GameRun;->g:Ljavax/microedition/lcdui/Graphics;

    .line 1102
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "qq/qqlogo"

    invoke-virtual {v0, v1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Lmain/MainCanvas;->image_logo:Ljavax/microedition/lcdui/Image;

    .line 1105
    :cond_1
    sget-object v0, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    iget-object v1, p0, Lmain/MainCanvas;->image_logo:Ljavax/microedition/lcdui/Image;

    or-int/lit8 v2, v8, 0x2

    invoke-virtual {v0, v1, v7, v6, v2}, Ljavax/microedition/lcdui/Graphics;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    .line 1133
    :cond_2
    :goto_1
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lmain/MainCanvas;->load_c:I

    goto :goto_0

    .line 1107
    :cond_3
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-lt v0, v3, :cond_5

    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-ge v0, v9, :cond_5

    .line 1109
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-ne v0, v3, :cond_4

    .line 1110
    iput-object v10, p0, Lmain/MainCanvas;->image_logo:Ljavax/microedition/lcdui/Image;

    .line 1111
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const-string v1, "cwa"

    invoke-virtual {v0, v1}, Ldm/Ms;->createImage(Ljava/lang/String;)Ljavax/microedition/lcdui/Image;

    move-result-object v0

    iput-object v0, p0, Lmain/MainCanvas;->image_logo:Ljavax/microedition/lcdui/Image;

    .line 1113
    :cond_4
    sget-object v0, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    invoke-virtual {v0, v2}, Ljavax/microedition/lcdui/Graphics;->setColor(I)V

    .line 1114
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v0

    move v1, v2

    move v3, v2

    invoke-virtual/range {v0 .. v5}, Ldm/Ui;->fillRect(IIIII)V

    .line 1115
    sget-object v0, Lmain/MainCanvas;->g:Ljavax/microedition/lcdui/Graphics;

    iget-object v1, p0, Lmain/MainCanvas;->image_logo:Ljavax/microedition/lcdui/Image;

    or-int/lit8 v2, v8, 0x2

    invoke-virtual {v0, v1, v7, v6, v2}, Ljavax/microedition/lcdui/Graphics;->drawImage(Ljavax/microedition/lcdui/Image;III)V

    goto :goto_1

    .line 1116
    :cond_5
    iget v0, p0, Lmain/MainCanvas;->load_c:I

    if-le v0, v9, :cond_2

    .line 1127
    iput-object v10, p0, Lmain/MainCanvas;->image_logo:Ljavax/microedition/lcdui/Image;

    .line 1128
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iput-byte v2, v0, Lmain/GameRun;->popMenu:B

    .line 1129
    const/16 v0, 0xa

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 1130
    const-string v0, "\u662f\u5426\u6253\u5f00\u97f3\u4e50?"

    iput-object v0, p0, Lmain/MainCanvas;->strTemp:Ljava/lang/String;

    .line 1131
    invoke-direct {p0}, Lmain/MainCanvas;->game_init()V

    goto :goto_1
.end method

.method public pointerPressed(II)V
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 747
    sget-boolean v0, Lmain/SMSSender;->isWorking:Z

    if-eqz v0, :cond_0

    .line 751
    :goto_0
    return-void

    .line 750
    :cond_0
    iget-object v0, p0, Lmain/MainCanvas;->pkey:Lmain/PointerKey;

    invoke-virtual {v0, p1, p2}, Lmain/PointerKey;->process(II)V

    goto :goto_0
.end method

.method public pointerReleased(II)V
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 753
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 754
    return-void
.end method

.method public run()V
    .locals 9

    .prologue
    const/4 v8, -0x1

    const/16 v7, 0x3c

    .line 165
    :goto_0
    :try_start_0
    iget-boolean v3, p0, Lmain/MainCanvas;->quitGame:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    if-eqz v3, :cond_0

    .line 262
    :goto_1
    iget-object v3, p0, Lmain/MainCanvas;->game:Lmain/XConnection;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lmain/XConnection;->destroyApp(Z)V

    .line 264
    return-void

    .line 167
    :cond_0
    :try_start_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iput-wide v3, p0, Lmain/MainCanvas;->starttime:J

    .line 170
    sget-boolean v3, Lmain/SMSSender;->isWorking:Z

    if-nez v3, :cond_4

    .line 175
    sget-object v3, Lcom/android/Util/AndroidUtil;->cv:Landroid/os/ConditionVariable;

    invoke-virtual {v3}, Landroid/os/ConditionVariable;->block()V

    .line 181
    sget-object v3, Lcom/android/Util/AndroidUtil;->cv:Landroid/os/ConditionVariable;

    invoke-virtual {v3}, Landroid/os/ConditionVariable;->close()V

    .line 184
    iget v3, p0, Lmain/MainCanvas;->game_state:I

    const/16 v4, 0x62

    if-eq v3, v4, :cond_1

    .line 185
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v3

    invoke-virtual {v3}, Ldm/Sound;->soundPlay()V

    .line 187
    :cond_1
    iget v3, p0, Lmain/MainCanvas;->game_state:I

    sparse-switch v3, :sswitch_data_0

    .line 218
    :cond_2
    :goto_2
    :sswitch_0
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    sget-boolean v3, Ldm/Ms;->keyRepeat:Z

    if-eqz v3, :cond_3

    invoke-direct {p0}, Lmain/MainCanvas;->keyProcess()V

    .line 219
    :cond_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3}, Ldm/Ms;->runDelay()V

    .line 220
    invoke-virtual {p0}, Lmain/MainCanvas;->paint()V

    .line 237
    :cond_4
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iget-wide v5, p0, Lmain/MainCanvas;->starttime:J

    sub-long/2addr v3, v5

    iput-wide v3, p0, Lmain/MainCanvas;->timetaken:J

    .line 238
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3}, Ldm/Ms;->getSleep()I

    move-result v3

    if-lez v3, :cond_9

    .line 239
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3}, Ldm/Ms;->getSleep()I

    move-result v3

    int-to-long v3, v3

    invoke-static {v3, v4}, Ljava/lang/Thread;->sleep(J)V

    .line 240
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Ldm/Ms;->sleep(I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 250
    :catch_0
    move-exception v3

    move-object v0, v3

    .line 258
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 259
    :cond_5
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    invoke-virtual {v3}, Ldm/Ms;->key_Num0()Z

    move-result v3

    if-eqz v3, :cond_5

    goto :goto_1

    .line 189
    .end local v0    # "ex":Ljava/lang/Exception;
    :sswitch_1
    :try_start_2
    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v3}, Lmain/GameRun;->run_gameRun()V

    .line 191
    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v3}, Lmain/GameRun;->runPauseIco()Z

    move-result v3

    if-nez v3, :cond_6

    iget-object v3, p0, Lmain/MainCanvas;->pkey:Lmain/PointerKey;

    invoke-virtual {v3}, Lmain/PointerKey;->runMove()V

    goto :goto_2

    .line 192
    :cond_6
    iget-object v3, p0, Lmain/MainCanvas;->pkey:Lmain/PointerKey;

    const/4 v4, 0x0

    iput-boolean v4, v3, Lmain/PointerKey;->isGo:Z

    goto :goto_2

    .line 196
    :sswitch_2
    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->createOver:B

    if-ne v3, v8, :cond_8

    .line 197
    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    const/16 v4, 0x3c

    iput-byte v4, v3, Lmain/GameRun;->time_count:B

    .line 198
    invoke-virtual {p0}, Lmain/MainCanvas;->paint()V

    .line 200
    :cond_7
    :goto_3
    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->threadType:B

    if-nez v3, :cond_2

    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->createOver:B

    if-ne v3, v8, :cond_2

    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->time_count:B

    if-ne v3, v7, :cond_2

    .line 201
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x4

    invoke-virtual {v3, v4, v5, v6}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 202
    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v3}, Lmain/GameRun;->start()V

    goto/16 :goto_2

    .line 199
    :cond_8
    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->time_count:B

    if-ge v3, v7, :cond_7

    iget-object v3, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-byte v4, v3, Lmain/GameRun;->time_count:B

    add-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    iput-byte v4, v3, Lmain/GameRun;->time_count:B

    goto :goto_3

    .line 243
    :cond_9
    const-wide/16 v3, 0x3c

    iget-wide v5, p0, Lmain/MainCanvas;->timetaken:J

    sub-long v1, v3, v5

    .line 244
    .local v1, "useTime":J
    const-wide/16 v3, 0xa

    cmp-long v3, v1, v3

    if-gez v3, :cond_a

    .line 245
    const-wide/16 v1, 0xa

    .line 247
    :cond_a
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 187
    :sswitch_data_0
    .sparse-switch
        0x14 -> :sswitch_2
        0x1e -> :sswitch_1
        0x28 -> :sswitch_0
    .end sparse-switch
.end method

.method public setSmsIsSetRun_state(Z)V
    .locals 3
    .param p1, "state"    # Z

    .prologue
    .line 703
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "setSmsIsSetRun_state state= "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 704
    iput-boolean p1, p0, Lmain/MainCanvas;->smsIsSetRun_state:Z

    .line 705
    return-void
.end method

.method public showNotify()V
    .locals 0

    .prologue
    .line 675
    invoke-virtual {p0}, Lmain/MainCanvas;->showNotifyMy()V

    .line 676
    return-void
.end method

.method public showNotifyMy()V
    .locals 4

    .prologue
    const/16 v3, 0x62

    .line 679
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "showNotifyMy() run_state= "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget v2, Lmain/GameRun;->run_state:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " game_state= "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lmain/MainCanvas;->game_state:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 680
    iget v0, p0, Lmain/MainCanvas;->game_state:I

    if-ne v0, v3, :cond_1

    .line 681
    sget v0, Lmain/GameRun;->run_state:I

    const/16 v1, -0x14

    if-eq v0, v1, :cond_0

    sget v0, Lmain/GameRun;->run_state:I

    const/16 v1, -0x15

    if-eq v0, v1, :cond_0

    .line 682
    const/16 v0, 0x1e

    iput v0, p0, Lmain/MainCanvas;->game_state:I

    .line 683
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "\u5728\u8fd9?"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 685
    :cond_0
    invoke-virtual {p0}, Lmain/MainCanvas;->repaint()V

    .line 686
    sput v3, Lmain/GameRun;->run_state:I

    iput v3, p0, Lmain/MainCanvas;->game_state:I

    .line 687
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "\u8fd8\u662f\u5728\u8fd9?"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 688
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Sound;->soundStop()V

    .line 698
    :goto_0
    return-void

    .line 691
    :cond_1
    const/4 v0, 0x0

    iput-byte v0, p0, Lmain/MainCanvas;->fisrt_paint:B

    .line 692
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "\u4e0d\u4f1a\u5728\u8fd9\u5427\uff1f"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public skyContinueGame()V
    .locals 2

    .prologue
    .line 1384
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->data_init()V

    .line 1387
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 1388
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    const/4 v1, 0x0

    iput-byte v1, v0, Lmain/Map;->firstDrawMap:B

    .line 1389
    invoke-virtual {p0}, Lmain/MainCanvas;->goGameLoading()V

    .line 1391
    iget-object v0, p0, Lmain/MainCanvas;->pkey:Lmain/PointerKey;

    invoke-virtual {v0}, Lmain/PointerKey;->stopMove()V

    .line 1392
    return-void
.end method

.method public skyNewGame()V
    .locals 2

    .prologue
    .line 1371
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsOther:[B

    const/4 v1, 0x0

    aget-byte v0, v0, v1

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 1372
    invoke-direct {p0}, Lmain/MainCanvas;->newGame()V

    .line 1380
    :goto_0
    return-void

    .line 1377
    :cond_0
    const/4 v0, 0x2

    iput v0, p0, Lmain/MainCanvas;->menu_state:I

    .line 1378
    iget-object v0, p0, Lmain/MainCanvas;->gr:Lmain/GameRun;

    const-string v1, "\u8fd9\u5c06\u6e05\u9664\u60a8\u4e4b\u524d\u7684\u6240\u6709\u8bb0\u5f55\uff0c\u662f\u5426\u7ee7\u7eed\uff1f"

    iput-object v1, v0, Lmain/GameRun;->gogoString:Ljava/lang/String;

    goto :goto_0
.end method
