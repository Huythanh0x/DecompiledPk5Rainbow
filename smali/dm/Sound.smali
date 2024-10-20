.class public final Ldm/Sound;
.super Ljava/lang/Object;
.source "Sound.java"


# static fields
.field private static soundListener:Ldm/Sound;


# instance fields
.field public loop:[B

.field private loop_s:B

.field private musicId:B

.field private musicId_temp:B

.field private play_music:B

.field private snd_music:Ljavax/microedition/media/Player;

.field private sound_on:Z

.field private sound_play:Z

.field private vc_snd:Ljavax/microedition/media/control/VolumeControl;

.field private volume:B


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v1, 0x0

    const/4 v0, -0x1

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-boolean v1, p0, Ldm/Sound;->sound_play:Z

    .line 15
    iput-boolean v1, p0, Ldm/Sound;->sound_on:Z

    .line 18
    iput-byte v0, p0, Ldm/Sound;->musicId:B

    .line 19
    iput-byte v0, p0, Ldm/Sound;->musicId_temp:B

    .line 21
    const/16 v0, 0x1e

    iput-byte v0, p0, Ldm/Sound;->volume:B

    .line 23
    const/16 v0, 0xa

    new-array v0, v0, [B

    fill-array-data v0, :array_1e

    iput-object v0, p0, Ldm/Sound;->loop:[B

    .line 24
    sput-object p0, Ldm/Sound;->soundListener:Ldm/Sound;

    return-void

    .line 23
    nop

    :array_1e
    .array-data 1
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
        -0x1t
    .end array-data
.end method

.method private createMusic(II)Ljavax/microedition/media/Player;
    .registers 7
    .param p1, "id"    # I
    .param p2, "flag"    # I

    .prologue
    .line 67
    const/4 v2, 0x2

    new-array v1, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "audio/midi"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "audio/x-wav"

    aput-object v3, v1, v2

    .line 69
    .local v1, "tt_str":[Ljava/lang/String;
    if-ltz p2, :cond_45

    .line 70
    :try_start_f
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    if-eqz v2, :cond_18

    .line 71
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v2}, Ljavax/microedition/media/Player;->close()V

    .line 72
    :cond_18
    const/4 v2, 0x0

    iput-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    .line 78
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "/music/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".mid"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    aget-object v3, v1, p2

    invoke-static {v2, v3}, Ljavax/microedition/media/Manager;->createPlayer(Ljava/lang/String;Ljava/lang/String;)Ljavax/microedition/media/Player;

    move-result-object v2

    iput-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    .line 80
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v2}, Ljavax/microedition/media/Player;->prefetch()V

    .line 81
    const/4 v2, 0x0

    iput-object v2, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;

    .line 82
    iget-byte v2, p0, Ldm/Sound;->volume:B

    invoke-direct {p0, v2}, Ldm/Sound;->createVolume(I)V
    :try_end_45
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_45} :catch_48

    .line 90
    :cond_45
    :goto_45
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    return-object v2

    .line 87
    :catch_48
    move-exception v2

    move-object v0, v2

    .line 88
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_45
.end method

.method private createMusicForMenu(II)Ljavax/microedition/media/Player;
    .registers 7
    .param p1, "id"    # I
    .param p2, "flag"    # I

    .prologue
    .line 40
    const/4 v2, 0x2

    new-array v1, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "audio/midi"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "audio/x-wav"

    aput-object v3, v1, v2

    .line 42
    .local v1, "tt_str":[Ljava/lang/String;
    if-ltz p2, :cond_45

    .line 43
    :try_start_f
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    if-eqz v2, :cond_18

    .line 44
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v2}, Ljavax/microedition/media/Player;->close()V

    .line 45
    :cond_18
    const/4 v2, 0x0

    iput-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    .line 51
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "/music/"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ".mid"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    aget-object v3, v1, p2

    invoke-static {v2, v3}, Ljavax/microedition/media/Manager;->createPlayer(Ljava/lang/String;Ljava/lang/String;)Ljavax/microedition/media/Player;

    move-result-object v2

    iput-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    .line 53
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v2}, Ljavax/microedition/media/Player;->prefetch()V

    .line 54
    const/4 v2, 0x0

    iput-object v2, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;

    .line 55
    iget-byte v2, p0, Ldm/Sound;->volume:B

    invoke-direct {p0, v2}, Ldm/Sound;->createVolumeForMenu(I)V
    :try_end_45
    .catch Ljava/lang/Exception; {:try_start_f .. :try_end_45} :catch_48

    .line 63
    :cond_45
    :goto_45
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    return-object v2

    .line 60
    :catch_48
    move-exception v2

    move-object v0, v2

    .line 61
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_45
.end method

.method private createVolume(I)V
    .registers 5
    .param p1, "volume"    # I

    .prologue
    .line 182
    iget-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;

    if-nez v0, :cond_10

    .line 183
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    const-string v1, "VolumeControl"

    invoke-virtual {v0, v1}, Ljavax/microedition/media/Player;->getControl(Ljava/lang/String;)Ljavax/microedition/media/Control;

    move-result-object v0

    check-cast v0, Ljavax/microedition/media/control/VolumeControl;

    iput-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;

    .line 186
    :cond_10
    const-string v0, ""

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 187
    iget-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;

    invoke-virtual {v0, p1}, Ljavax/microedition/media/control/VolumeControl;->setLevel(I)I

    .line 195
    return-void
.end method

.method private createVolumeForMenu(I)V
    .registers 5
    .param p1, "volume"    # I

    .prologue
    .line 164
    iget-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;

    if-nez v0, :cond_10

    .line 165
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    const-string v1, "VolumeControl"

    invoke-virtual {v0, v1}, Ljavax/microedition/media/Player;->getControl(Ljava/lang/String;)Ljavax/microedition/media/Control;

    move-result-object v0

    check-cast v0, Ljavax/microedition/media/control/VolumeControl;

    iput-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;

    .line 168
    :cond_10
    const-string v0, ""

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 169
    iget-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;

    invoke-virtual {v0, p1}, Ljavax/microedition/media/control/VolumeControl;->setLevelForMenu(I)I

    .line 177
    return-void
.end method

.method public static i()Ldm/Sound;
    .registers 1

    .prologue
    .line 26
    sget-object v0, Ldm/Sound;->soundListener:Ldm/Sound;

    if-nez v0, :cond_b

    new-instance v0, Ldm/Sound;

    invoke-direct {v0}, Ldm/Sound;-><init>()V

    sput-object v0, Ldm/Sound;->soundListener:Ldm/Sound;

    .line 27
    :cond_b
    sget-object v0, Ldm/Sound;->soundListener:Ldm/Sound;

    return-object v0
.end method


# virtual methods
.method public getHaveSoundPlayState()Z
    .registers 5

    .prologue
    const/4 v3, 0x0

    .line 214
    :try_start_1
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    if-eqz v1, :cond_18

    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v1}, Ljavax/microedition/media/Player;->getState()I

    move-result v1

    const/16 v2, 0x190

    if-ne v1, v2, :cond_18

    .line 215
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "getHaveSoundPlayState() true"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 216
    const/4 v1, 0x1

    .line 224
    :goto_17
    return v1

    .line 218
    :cond_18
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "getHaveSoundPlayState() false"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    :try_end_1f
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1f} :catch_21

    move v1, v3

    .line 219
    goto :goto_17

    .line 221
    :catch_21
    move-exception v1

    move-object v0, v1

    .line 222
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 223
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v2, "getHaveSoundPlayState() false"

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    move v1, v3

    .line 224
    goto :goto_17
.end method

.method public getMusicId()B
    .registers 2

    .prologue
    .line 33
    iget-byte v0, p0, Ldm/Sound;->musicId:B

    return v0
.end method

.method public getSoundON()Z
    .registers 2

    .prologue
    .line 31
    iget-boolean v0, p0, Ldm/Sound;->sound_on:Z

    return v0
.end method

.method public getVolume()B
    .registers 2

    .prologue
    .line 35
    iget-byte v0, p0, Ldm/Sound;->volume:B

    return v0
.end method

.method public keyVolume(I)V
    .registers 7
    .param p1, "mode"    # I

    .prologue
    const/4 v4, 0x1

    const/16 v3, 0x5a

    const/4 v2, 0x0

    .line 198
    if-nez p1, :cond_1b

    .line 199
    iget-byte v0, p0, Ldm/Sound;->volume:B

    add-int/lit8 v0, v0, 0x1e

    int-to-byte v0, v0

    iput-byte v0, p0, Ldm/Sound;->volume:B

    if-le v0, v3, :cond_11

    iput-byte v2, p0, Ldm/Sound;->volume:B

    .line 206
    :cond_11
    :goto_11
    iget-byte v0, p0, Ldm/Sound;->volume:B

    if-nez v0, :cond_4a

    .line 207
    iput-boolean v2, p0, Ldm/Sound;->sound_on:Z

    .line 208
    invoke-virtual {p0}, Ldm/Sound;->soundStop()V

    .line 210
    :goto_1a
    return-void

    .line 200
    :cond_1b
    if-ne p1, v4, :cond_11

    .line 201
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Right()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 202
    iget-byte v0, p0, Ldm/Sound;->volume:B

    add-int/lit8 v0, v0, 0x1e

    int-to-byte v0, v0

    iput-byte v0, p0, Ldm/Sound;->volume:B

    if-le v0, v3, :cond_33

    iput-byte v2, p0, Ldm/Sound;->volume:B

    goto :goto_11

    .line 203
    :cond_33
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Left()Z

    move-result v0

    if-eqz v0, :cond_11

    .line 204
    iget-byte v0, p0, Ldm/Sound;->volume:B

    const/16 v1, 0x1e

    sub-int/2addr v0, v1

    int-to-byte v0, v0

    iput-byte v0, p0, Ldm/Sound;->volume:B

    if-gez v0, :cond_11

    iput-byte v3, p0, Ldm/Sound;->volume:B

    goto :goto_11

    .line 209
    :cond_4a
    iput-boolean v4, p0, Ldm/Sound;->sound_on:Z

    goto :goto_1a
.end method

.method playTone()V
    .registers 1

    .prologue
    .line 150
    return-void
.end method

.method public setMusic(Z)V
    .registers 6
    .param p1, "b"    # Z

    .prologue
    const/4 v3, 0x0

    .line 94
    iget-boolean v1, p0, Ldm/Sound;->sound_on:Z

    if-eqz v1, :cond_9

    iget-byte v1, p0, Ldm/Sound;->musicId:B

    if-gez v1, :cond_a

    .line 107
    :cond_9
    :goto_9
    return-void

    .line 96
    :cond_a
    :try_start_a
    iget-byte v1, p0, Ldm/Sound;->musicId_temp:B

    iget-byte v2, p0, Ldm/Sound;->musicId:B

    if-ne v1, v2, :cond_12

    if-eqz p1, :cond_34

    .line 97
    :cond_12
    iget-object v1, p0, Ldm/Sound;->loop:[B

    iget-byte v2, p0, Ldm/Sound;->musicId:B

    aget-byte v1, v1, v2

    iput-byte v1, p0, Ldm/Sound;->loop_s:B

    .line 98
    iget-byte v1, p0, Ldm/Sound;->musicId:B

    iput-byte v1, p0, Ldm/Sound;->play_music:B

    .line 99
    iget-byte v1, p0, Ldm/Sound;->play_music:B

    iput-byte v1, p0, Ldm/Sound;->musicId_temp:B

    .line 100
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    if-eqz v1, :cond_2b

    .line 101
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v1}, Ljavax/microedition/media/Player;->close()V

    .line 102
    :cond_2b
    const/4 v1, 0x0

    iput-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    .line 103
    iget-byte v1, p0, Ldm/Sound;->play_music:B

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Ldm/Sound;->createMusic(II)Ljavax/microedition/media/Player;

    .line 105
    :cond_34
    const/4 v1, 0x1

    iput-boolean v1, p0, Ldm/Sound;->sound_play:Z
    :try_end_37
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_37} :catch_38

    goto :goto_9

    .line 106
    :catch_38
    move-exception v1

    move-object v0, v1

    .local v0, "ex":Ljava/lang/Exception;
    iput-boolean v3, p0, Ldm/Sound;->sound_play:Z

    goto :goto_9
.end method

.method public setMusicForMenu(Z)V
    .registers 6
    .param p1, "b"    # Z

    .prologue
    const/4 v3, 0x0

    .line 111
    iget-boolean v1, p0, Ldm/Sound;->sound_on:Z

    if-eqz v1, :cond_9

    iget-byte v1, p0, Ldm/Sound;->musicId:B

    if-gez v1, :cond_a

    .line 124
    :cond_9
    :goto_9
    return-void

    .line 113
    :cond_a
    :try_start_a
    iget-byte v1, p0, Ldm/Sound;->musicId_temp:B

    iget-byte v2, p0, Ldm/Sound;->musicId:B

    if-ne v1, v2, :cond_12

    if-eqz p1, :cond_34

    .line 114
    :cond_12
    iget-object v1, p0, Ldm/Sound;->loop:[B

    iget-byte v2, p0, Ldm/Sound;->musicId:B

    aget-byte v1, v1, v2

    iput-byte v1, p0, Ldm/Sound;->loop_s:B

    .line 115
    iget-byte v1, p0, Ldm/Sound;->musicId:B

    iput-byte v1, p0, Ldm/Sound;->play_music:B

    .line 116
    iget-byte v1, p0, Ldm/Sound;->play_music:B

    iput-byte v1, p0, Ldm/Sound;->musicId_temp:B

    .line 117
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    if-eqz v1, :cond_2b

    .line 118
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v1}, Ljavax/microedition/media/Player;->close()V

    .line 119
    :cond_2b
    const/4 v1, 0x0

    iput-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    .line 120
    iget-byte v1, p0, Ldm/Sound;->play_music:B

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Ldm/Sound;->createMusicForMenu(II)Ljavax/microedition/media/Player;

    .line 122
    :cond_34
    const/4 v1, 0x1

    iput-boolean v1, p0, Ldm/Sound;->sound_play:Z
    :try_end_37
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_37} :catch_38

    goto :goto_9

    .line 123
    :catch_38
    move-exception v1

    move-object v0, v1

    .local v0, "ex":Ljava/lang/Exception;
    iput-boolean v3, p0, Ldm/Sound;->sound_play:Z

    goto :goto_9
.end method

.method public setMusicId(I)V
    .registers 3
    .param p1, "musicId_"    # I

    .prologue
    .line 32
    int-to-byte v0, p1

    iput-byte v0, p0, Ldm/Sound;->musicId:B

    return-void
.end method

.method public setSoundON(Z)V
    .registers 2
    .param p1, "sound_on_"    # Z

    .prologue
    .line 30
    iput-boolean p1, p0, Ldm/Sound;->sound_on:Z

    return-void
.end method

.method public setVolume(I)V
    .registers 3
    .param p1, "volume_"    # I

    .prologue
    .line 34
    int-to-byte v0, p1

    iput-byte v0, p0, Ldm/Sound;->volume:B

    return-void
.end method

.method public soundPlay()V
    .registers 5

    .prologue
    const/4 v3, 0x1

    const/4 v2, -0x1

    .line 136
    iget-boolean v0, p0, Ldm/Sound;->sound_on:Z

    if-eqz v0, :cond_a

    iget-byte v0, p0, Ldm/Sound;->play_music:B

    if-gez v0, :cond_b

    .line 148
    :cond_a
    :goto_a
    return-void

    .line 137
    :cond_b
    iget-boolean v0, p0, Ldm/Sound;->sound_play:Z

    if-eqz v0, :cond_a

    .line 138
    iget-byte v0, p0, Ldm/Sound;->loop_s:B

    if-ne v0, v2, :cond_22

    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    if-eqz v0, :cond_22

    .line 139
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v0, v2}, Ljavax/microedition/media/Player;->setLoopCount(I)V

    .line 140
    invoke-virtual {p0}, Ldm/Sound;->soundStart()V

    .line 141
    iput-byte v2, p0, Ldm/Sound;->play_music:B

    goto :goto_a

    .line 142
    :cond_22
    iget-byte v0, p0, Ldm/Sound;->loop_s:B

    if-lez v0, :cond_43

    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    if-eqz v0, :cond_43

    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v0}, Ljavax/microedition/media/Player;->getState()I

    move-result v0

    const/16 v1, 0x190

    if-eq v0, v1, :cond_43

    .line 143
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v0, v3}, Ljavax/microedition/media/Player;->setLoopCount(I)V

    .line 144
    invoke-virtual {p0}, Ldm/Sound;->soundStart()V

    .line 145
    iget-byte v0, p0, Ldm/Sound;->loop_s:B

    sub-int/2addr v0, v3

    int-to-byte v0, v0

    iput-byte v0, p0, Ldm/Sound;->loop_s:B

    goto :goto_a

    .line 146
    :cond_43
    iget-byte v0, p0, Ldm/Sound;->loop_s:B

    if-nez v0, :cond_a

    iput-byte v2, p0, Ldm/Sound;->play_music:B

    goto :goto_a
.end method

.method public soundStart()V
    .registers 3

    .prologue
    .line 128
    :try_start_0
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v1}, Ljavax/microedition/media/Player;->start()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_5} :catch_6

    .line 132
    :goto_5
    return-void

    .line 129
    :catch_6
    move-exception v1

    move-object v0, v1

    .line 130
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_5
.end method

.method public soundStop()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 154
    :try_start_1
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    if-eqz v1, :cond_a

    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;

    invoke-virtual {v1}, Ljavax/microedition/media/Player;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_a} :catch_d
    .catchall {:try_start_1 .. :try_end_a} :catchall_15

    .line 157
    :cond_a
    iput-boolean v2, p0, Ldm/Sound;->sound_play:Z

    .line 158
    :goto_c
    return-void

    .line 155
    :catch_d
    move-exception v1

    move-object v0, v1

    .line 156
    .local v0, "e":Ljava/lang/Exception;
    :try_start_f
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_12
    .catchall {:try_start_f .. :try_end_12} :catchall_15

    .line 157
    iput-boolean v2, p0, Ldm/Sound;->sound_play:Z

    goto :goto_c

    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_15
    move-exception v1

    iput-boolean v2, p0, Ldm/Sound;->sound_play:Z

    throw v1
.end method
