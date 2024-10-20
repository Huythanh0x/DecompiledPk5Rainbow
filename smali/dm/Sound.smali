.class public final Ldm/Sound;
.super Ljava/lang/Object;
.source "Sound.java"

.field private static soundListener:Ldm/Sound;

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

.method public constructor <init>()V
  .registers 3
  .prologue
    const/4 v1, 0
    const/4 v0, -1
  .line 24
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 14
    iput-boolean v1, p0, Ldm/Sound;->sound_play:Z
  .line 15
    iput-boolean v1, p0, Ldm/Sound;->sound_on:Z
  .line 18
    iput-byte v0, p0, Ldm/Sound;->musicId:B
  .line 19
    iput-byte v0, p0, Ldm/Sound;->musicId_temp:B
  .line 21
    const/16 v0, 30
    iput-byte v0, p0, Ldm/Sound;->volume:B
  .line 23
    const/16 v0, 10
    new-array v0, v0, [B
    fill-array-data v0, :L0
    iput-object v0, p0, Ldm/Sound;->loop:[B
  .line 24
    sput-object p0, Ldm/Sound;->soundListener:Ldm/Sound;
    return-void
  .line 23
  :L0
  .array-data 1
    -1t
    -1t
    -1t
    -1t
    -1t
    -1t
    -1t
    -1t
    -1t
    -1t
  .end array-data
.end method

.method private createMusic(II)Ljavax/microedition/media/Player;
  .parameter "id" # I
  .parameter "flag" # I
  .catch Ljava/lang/Exception; { :L0 .. :L2 } :L3
  .registers 7
  .prologue
  .line 67
    const/4 v2, 2
    new-array v1, v2, [Ljava/lang/String;
    const/4 v2, 0
    const-string v3, "audio/midi"
    aput-object v3, v1, v2
    const/4 v2, 1
    const-string v3, "audio/x-wav"
    aput-object v3, v1, v2
  .line 69
  .local v1, "tt_str":[Ljava/lang/String;
    if-ltz p2, :L2
  :L0
  .line 70
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    if-eqz v2, :L1
  .line 71
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v2 }, Ljavax/microedition/media/Player;->close()V
  :L1
  .line 72
    const/4 v2, 0
    iput-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
  .line 78
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "/music/"
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v2, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ".mid"
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    aget-object v3, v1, p2
    invoke-static { v2, v3 }, Ljavax/microedition/media/Manager;->createPlayer(Ljava/lang/String;Ljava/lang/String;)Ljavax/microedition/media/Player;
    move-result-object v2
    iput-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
  .line 80
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v2 }, Ljavax/microedition/media/Player;->prefetch()V
  .line 81
    const/4 v2, 0
    iput-object v2, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;
  .line 82
    iget-byte v2, p0, Ldm/Sound;->volume:B
    invoke-direct { p0, v2 }, Ldm/Sound;->createVolume(I)V
  :L2
  .line 90
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    return-object v2
  :L3
  .line 87
    move-exception v2
    move-object v0, v2
  .line 88
  .local v0, "e":Ljava/lang/Exception;
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L2
.end method

.method private createMusicForMenu(II)Ljavax/microedition/media/Player;
  .parameter "id" # I
  .parameter "flag" # I
  .catch Ljava/lang/Exception; { :L0 .. :L2 } :L3
  .registers 7
  .prologue
  .line 40
    const/4 v2, 2
    new-array v1, v2, [Ljava/lang/String;
    const/4 v2, 0
    const-string v3, "audio/midi"
    aput-object v3, v1, v2
    const/4 v2, 1
    const-string v3, "audio/x-wav"
    aput-object v3, v1, v2
  .line 42
  .local v1, "tt_str":[Ljava/lang/String;
    if-ltz p2, :L2
  :L0
  .line 43
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    if-eqz v2, :L1
  .line 44
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v2 }, Ljavax/microedition/media/Player;->close()V
  :L1
  .line 45
    const/4 v2, 0
    iput-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
  .line 51
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "/music/"
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v2, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ".mid"
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    aget-object v3, v1, p2
    invoke-static { v2, v3 }, Ljavax/microedition/media/Manager;->createPlayer(Ljava/lang/String;Ljava/lang/String;)Ljavax/microedition/media/Player;
    move-result-object v2
    iput-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
  .line 53
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v2 }, Ljavax/microedition/media/Player;->prefetch()V
  .line 54
    const/4 v2, 0
    iput-object v2, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;
  .line 55
    iget-byte v2, p0, Ldm/Sound;->volume:B
    invoke-direct { p0, v2 }, Ldm/Sound;->createVolumeForMenu(I)V
  :L2
  .line 63
    iget-object v2, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    return-object v2
  :L3
  .line 60
    move-exception v2
    move-object v0, v2
  .line 61
  .local v0, "e":Ljava/lang/Exception;
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L2
.end method

.method private createVolume(I)V
  .parameter "volume" # I
  .registers 5
  .prologue
  .line 182
    iget-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;
    if-nez v0, :L0
  .line 183
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    const-string v1, "VolumeControl"
    invoke-virtual { v0, v1 }, Ljavax/microedition/media/Player;->getControl(Ljava/lang/String;)Ljavax/microedition/media/Control;
    move-result-object v0
    check-cast v0, Ljavax/microedition/media/control/VolumeControl;
    iput-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;
  :L0
  .line 186
    const-string v0, ""
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f"
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v1, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 187
    iget-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;
    invoke-virtual { v0, p1 }, Ljavax/microedition/media/control/VolumeControl;->setLevel(I)I
  .line 195
    return-void
.end method

.method private createVolumeForMenu(I)V
  .parameter "volume" # I
  .registers 5
  .prologue
  .line 164
    iget-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;
    if-nez v0, :L0
  .line 165
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    const-string v1, "VolumeControl"
    invoke-virtual { v0, v1 }, Ljavax/microedition/media/Player;->getControl(Ljava/lang/String;)Ljavax/microedition/media/Control;
    move-result-object v0
    check-cast v0, Ljavax/microedition/media/control/VolumeControl;
    iput-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;
  :L0
  .line 168
    const-string v0, ""
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "\u8fd9\u4e2a\u6e38\u620f\u7684\u97f3\u4e50\u662f"
    invoke-direct { v1, v2 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v1, p1 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual { v1 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 169
    iget-object v0, p0, Ldm/Sound;->vc_snd:Ljavax/microedition/media/control/VolumeControl;
    invoke-virtual { v0, p1 }, Ljavax/microedition/media/control/VolumeControl;->setLevelForMenu(I)I
  .line 177
    return-void
.end method

.method public static i()Ldm/Sound;
  .registers 1
  .prologue
  .line 26
    sget-object v0, Ldm/Sound;->soundListener:Ldm/Sound;
    if-nez v0, :L0
    new-instance v0, Ldm/Sound;
    invoke-direct { v0 }, Ldm/Sound;-><init>()V
    sput-object v0, Ldm/Sound;->soundListener:Ldm/Sound;
  :L0
  .line 27
    sget-object v0, Ldm/Sound;->soundListener:Ldm/Sound;
    return-object v0
.end method

.method public getHaveSoundPlayState()Z
  .catch Ljava/lang/Exception; { :L0 .. :L3 } :L4
  .registers 5
  .prologue
    const/4 v3, 0
  :L0
  .line 214
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    if-eqz v1, :L2
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v1 }, Ljavax/microedition/media/Player;->getState()I
    move-result v1
    const/16 v2, 400
    if-ne v1, v2, :L2
  .line 215
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;
    const-string v2, "getHaveSoundPlayState() true"
    invoke-virtual { v1, v2 }, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
  .line 216
    const/4 v1, 1
  :L1
  .line 224
    return v1
  :L2
  .line 218
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;
    const-string v2, "getHaveSoundPlayState() false"
    invoke-virtual { v1, v2 }, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
  :L3
    move v1, v3
  .line 219
    goto :L1
  :L4
  .line 221
    move-exception v1
    move-object v0, v1
  .line 222
  .local v0, "e":Ljava/lang/Exception;
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
  .line 223
    sget-object v1, Ljava/lang/System;->out:Ljava/io/PrintStream;
    const-string v2, "getHaveSoundPlayState() false"
    invoke-virtual { v1, v2 }, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
    move v1, v3
  .line 224
    goto :L1
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
  .parameter "mode" # I
  .registers 7
  .prologue
    const/4 v4, 1
    const/16 v3, 90
    const/4 v2, 0
  .line 198
    if-nez p1, :L2
  .line 199
    iget-byte v0, p0, Ldm/Sound;->volume:B
    add-int/lit8 v0, v0, 30
    int-to-byte v0, v0
    iput-byte v0, p0, Ldm/Sound;->volume:B
    if-le v0, v3, :L0
    iput-byte v2, p0, Ldm/Sound;->volume:B
  :L0
  .line 206
    iget-byte v0, p0, Ldm/Sound;->volume:B
    if-nez v0, :L4
  .line 207
    iput-boolean v2, p0, Ldm/Sound;->sound_on:Z
  .line 208
    invoke-virtual { p0 }, Ldm/Sound;->soundStop()V
  :L1
  .line 210
    return-void
  :L2
  .line 200
    if-ne p1, v4, :L0
  .line 201
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Right()Z
    move-result v0
    if-eqz v0, :L0
  .line 202
    iget-byte v0, p0, Ldm/Sound;->volume:B
    add-int/lit8 v0, v0, 30
    int-to-byte v0, v0
    iput-byte v0, p0, Ldm/Sound;->volume:B
    if-le v0, v3, :L3
    iput-byte v2, p0, Ldm/Sound;->volume:B
    goto :L0
  :L3
  .line 203
    invoke-static { }, Ldm/Ms;->i()Ldm/Ms;
    move-result-object v0
    invoke-virtual { v0 }, Ldm/Ms;->key_Left()Z
    move-result v0
    if-eqz v0, :L0
  .line 204
    iget-byte v0, p0, Ldm/Sound;->volume:B
    const/16 v1, 30
    sub-int/2addr v0, v1
    int-to-byte v0, v0
    iput-byte v0, p0, Ldm/Sound;->volume:B
    if-gez v0, :L0
    iput-byte v3, p0, Ldm/Sound;->volume:B
    goto :L0
  :L4
  .line 209
    iput-boolean v4, p0, Ldm/Sound;->sound_on:Z
    goto :L1
.end method

.method playTone()V
  .registers 1
  .prologue
  .line 150
    return-void
.end method

.method public setMusic(Z)V
  .parameter "b" # Z
  .catch Ljava/lang/Exception; { :L1 .. :L5 } :L6
  .registers 6
  .prologue
    const/4 v3, 0
  .line 94
    iget-boolean v1, p0, Ldm/Sound;->sound_on:Z
    if-eqz v1, :L0
    iget-byte v1, p0, Ldm/Sound;->musicId:B
    if-gez v1, :L1
  :L0
  .line 107
    return-void
  :L1
  .line 96
    iget-byte v1, p0, Ldm/Sound;->musicId_temp:B
    iget-byte v2, p0, Ldm/Sound;->musicId:B
    if-ne v1, v2, :L2
    if-eqz p1, :L4
  :L2
  .line 97
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
    if-eqz v1, :L3
  .line 101
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v1 }, Ljavax/microedition/media/Player;->close()V
  :L3
  .line 102
    const/4 v1, 0
    iput-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
  .line 103
    iget-byte v1, p0, Ldm/Sound;->play_music:B
    const/4 v2, 0
    invoke-direct { p0, v1, v2 }, Ldm/Sound;->createMusic(II)Ljavax/microedition/media/Player;
  :L4
  .line 105
    const/4 v1, 1
    iput-boolean v1, p0, Ldm/Sound;->sound_play:Z
  :L5
    goto :L0
  :L6
  .line 106
    move-exception v1
    move-object v0, v1
  .local v0, "ex":Ljava/lang/Exception;
    iput-boolean v3, p0, Ldm/Sound;->sound_play:Z
    goto :L0
.end method

.method public setMusicForMenu(Z)V
  .parameter "b" # Z
  .catch Ljava/lang/Exception; { :L1 .. :L5 } :L6
  .registers 6
  .prologue
    const/4 v3, 0
  .line 111
    iget-boolean v1, p0, Ldm/Sound;->sound_on:Z
    if-eqz v1, :L0
    iget-byte v1, p0, Ldm/Sound;->musicId:B
    if-gez v1, :L1
  :L0
  .line 124
    return-void
  :L1
  .line 113
    iget-byte v1, p0, Ldm/Sound;->musicId_temp:B
    iget-byte v2, p0, Ldm/Sound;->musicId:B
    if-ne v1, v2, :L2
    if-eqz p1, :L4
  :L2
  .line 114
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
    if-eqz v1, :L3
  .line 118
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v1 }, Ljavax/microedition/media/Player;->close()V
  :L3
  .line 119
    const/4 v1, 0
    iput-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
  .line 120
    iget-byte v1, p0, Ldm/Sound;->play_music:B
    const/4 v2, 0
    invoke-direct { p0, v1, v2 }, Ldm/Sound;->createMusicForMenu(II)Ljavax/microedition/media/Player;
  :L4
  .line 122
    const/4 v1, 1
    iput-boolean v1, p0, Ldm/Sound;->sound_play:Z
  :L5
    goto :L0
  :L6
  .line 123
    move-exception v1
    move-object v0, v1
  .local v0, "ex":Ljava/lang/Exception;
    iput-boolean v3, p0, Ldm/Sound;->sound_play:Z
    goto :L0
.end method

.method public setMusicId(I)V
  .parameter "musicId_" # I
  .registers 3
  .prologue
  .line 32
    int-to-byte v0, p1
    iput-byte v0, p0, Ldm/Sound;->musicId:B
    return-void
.end method

.method public setSoundON(Z)V
  .parameter "sound_on_" # Z
  .registers 2
  .prologue
  .line 30
    iput-boolean p1, p0, Ldm/Sound;->sound_on:Z
    return-void
.end method

.method public setVolume(I)V
  .parameter "volume_" # I
  .registers 3
  .prologue
  .line 34
    int-to-byte v0, p1
    iput-byte v0, p0, Ldm/Sound;->volume:B
    return-void
.end method

.method public soundPlay()V
  .registers 5
  .prologue
    const/4 v3, 1
    const/4 v2, -1
  .line 136
    iget-boolean v0, p0, Ldm/Sound;->sound_on:Z
    if-eqz v0, :L0
    iget-byte v0, p0, Ldm/Sound;->play_music:B
    if-gez v0, :L1
  :L0
  .line 148
    return-void
  :L1
  .line 137
    iget-boolean v0, p0, Ldm/Sound;->sound_play:Z
    if-eqz v0, :L0
  .line 138
    iget-byte v0, p0, Ldm/Sound;->loop_s:B
    if-ne v0, v2, :L2
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    if-eqz v0, :L2
  .line 139
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v0, v2 }, Ljavax/microedition/media/Player;->setLoopCount(I)V
  .line 140
    invoke-virtual { p0 }, Ldm/Sound;->soundStart()V
  .line 141
    iput-byte v2, p0, Ldm/Sound;->play_music:B
    goto :L0
  :L2
  .line 142
    iget-byte v0, p0, Ldm/Sound;->loop_s:B
    if-lez v0, :L3
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    if-eqz v0, :L3
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v0 }, Ljavax/microedition/media/Player;->getState()I
    move-result v0
    const/16 v1, 400
    if-eq v0, v1, :L3
  .line 143
    iget-object v0, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v0, v3 }, Ljavax/microedition/media/Player;->setLoopCount(I)V
  .line 144
    invoke-virtual { p0 }, Ldm/Sound;->soundStart()V
  .line 145
    iget-byte v0, p0, Ldm/Sound;->loop_s:B
    sub-int/2addr v0, v3
    int-to-byte v0, v0
    iput-byte v0, p0, Ldm/Sound;->loop_s:B
    goto :L0
  :L3
  .line 146
    iget-byte v0, p0, Ldm/Sound;->loop_s:B
    if-nez v0, :L0
    iput-byte v2, p0, Ldm/Sound;->play_music:B
    goto :L0
.end method

.method public soundStart()V
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L2
  .registers 3
  :L0
  .prologue
  .line 128
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v1 }, Ljavax/microedition/media/Player;->start()V
  :L1
  .line 132
    return-void
  :L2
  .line 129
    move-exception v1
    move-object v0, v1
  .line 130
  .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
    goto :L1
.end method

.method public soundStop()V
  .catch Ljava/lang/Exception; { :L0 .. :L1 } :L3
  .catchall { :L0 .. :L1 } :L6
  .catchall { :L4 .. :L5 } :L6
  .registers 4
  .prologue
    const/4 v2, 0
  :L0
  .line 154
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    if-eqz v1, :L1
    iget-object v1, p0, Ldm/Sound;->snd_music:Ljavax/microedition/media/Player;
    invoke-virtual { v1 }, Ljavax/microedition/media/Player;->close()V
  :L1
  .line 157
    iput-boolean v2, p0, Ldm/Sound;->sound_play:Z
  :L2
  .line 158
    return-void
  :L3
  .line 155
    move-exception v1
    move-object v0, v1
  :L4
  .line 156
  .local v0, "e":Ljava/lang/Exception;
    invoke-virtual { v0 }, Ljava/lang/Exception;->printStackTrace()V
  :L5
  .line 157
    iput-boolean v2, p0, Ldm/Sound;->sound_play:Z
    goto :L2
  :L6
  .end local v0
    move-exception v1
    iput-boolean v2, p0, Ldm/Sound;->sound_play:Z
    throw v1
.end method
