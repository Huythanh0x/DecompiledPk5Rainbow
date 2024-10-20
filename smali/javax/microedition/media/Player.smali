.class public Ljavax/microedition/media/Player;
.super Ljava/lang/Object;
.implements Landroid/media/MediaPlayer$OnCompletionListener;
.source "Player.java"

.field public final static CLOSED:I = 0

.field public final static PREFETCHED:I = 300

.field public final static REALIZED:I = 200

.field public final static STARTED:I = 400

.field public final static TIME_UNKNOWN:J = -1L

.field public final static UNREALIZED:I = 100

.field private dateSource:Ljava/lang/String;

.field private loopCount:I

.field private mp:Landroid/media/MediaPlayer;

.field private playedCount:I

.field private playerListeners:Ljava/util/Vector;
  .annotation system Ldalvik/annotation/Signature;
    value = {
      "Ljava/util/Vector",
      "<",
      "Ljavax/microedition/media/PlayerListener;",
      ">;"
    }
  .end annotation
.end field

.field private state:I

.field private type:Ljava/lang/String;

.method public constructor <init>()V
  .registers 4
  .prologue
    const/4 v2, 0
  .line 34
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 26
    const/16 v0, 100
    iput v0, p0, Ljavax/microedition/media/Player;->state:I
  .line 35
    new-instance v0, Landroid/media/MediaPlayer;
    invoke-direct { v0 }, Landroid/media/MediaPlayer;-><init>()V
    iput-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
  .line 36
    new-instance v0, Ljava/util/Vector;
    invoke-direct { v0 }, Ljava/util/Vector;-><init>()V
    iput-object v0, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;
  .line 37
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v0, p0 }, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V
  .line 38
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    const/4 v1, 0
    invoke-virtual { v0, v1 }, Landroid/media/MediaPlayer;->setLooping(Z)V
  .line 39
    iput-object v2, p0, Ljavax/microedition/media/Player;->dateSource:Ljava/lang/String;
  .line 40
    iput-object v2, p0, Ljavax/microedition/media/Player;->type:Ljava/lang/String;
  .line 41
    return-void
.end method

.method private final onEvent(Ljava/lang/String;Ljava/lang/Object;)V
  .parameter "event" # Ljava/lang/String;
  .parameter "eventData" # Ljava/lang/Object;
  .registers 6
  .prologue
  .line 267
    iget-object v1, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;
    invoke-virtual { v1 }, Ljava/util/Vector;->iterator()Ljava/util/Iterator;
    move-result-object v1
  :L0
    invoke-interface { v1 }, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-nez v2, :L1
  .line 270
    return-void
  :L1
  .line 267
    invoke-interface { v1 }, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljavax/microedition/media/PlayerListener;
  .line 268
  .local v0, "playerListener":Ljavax/microedition/media/PlayerListener;
    invoke-interface { v0, p0, p1, p2 }, Ljavax/microedition/media/PlayerListener;->playerUpdate(Ljavax/microedition/media/Player;Ljava/lang/String;Ljava/lang/Object;)V
    goto :L0
.end method

.method public addPlayerListener(Ljavax/microedition/media/PlayerListener;)V
  .parameter "playerListener" # Ljavax/microedition/media/PlayerListener;
  .registers 3
  .prologue
  .line 242
    iget-object v0, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;
    invoke-virtual { v0, p1 }, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, :L0
  .line 243
    iget-object v0, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;
    invoke-virtual { v0, p1 }, Ljava/util/Vector;->add(Ljava/lang/Object;)Z
  :L0
  .line 245
    return-void
.end method

.method public close()V
  .registers 4
  .prologue
    const/4 v2, 0
  .line 163
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    if-eqz v0, :L1
  .line 164
    iget v0, p0, Ljavax/microedition/media/Player;->state:I
    const/16 v1, 400
    if-ne v0, v1, :L0
  .line 165
    const-string v0, "stopped"
    invoke-direct { p0, v0, v2 }, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V
  .line 166
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v0 }, Landroid/media/MediaPlayer;->stop()V
  :L0
  .line 168
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v0 }, Landroid/media/MediaPlayer;->release()V
  .line 169
    const-string v0, "closed"
    invoke-direct { p0, v0, v2 }, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V
  .line 170
    const/4 v0, 0
    iput v0, p0, Ljavax/microedition/media/Player;->state:I
  :L1
  .line 172
    return-void
.end method

.method public deallocate()V
  .registers 1
  .prologue
  .line 159
    return-void
.end method

.method public getContentType()Ljava/lang/String;
  .registers 2
  .prologue
  .line 219
    iget-object v0, p0, Ljavax/microedition/media/Player;->type:Ljava/lang/String;
    return-object v0
.end method

.method public getControl(Ljava/lang/String;)Ljavax/microedition/media/Control;
  .parameter "controlType" # Ljava/lang/String;
  .registers 6
  .prologue
    const/4 v3, -1
  .line 55
    const-string v2, "VolumeControl"
    invoke-virtual { p1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v2
    if-eq v2, v3, :L1
  .line 56
    new-instance v1, Ljavax/microedition/media/control/VolumeControl;
    invoke-direct { v1 }, Ljavax/microedition/media/control/VolumeControl;-><init>()V
  .local v1, "vc":Ljavax/microedition/media/control/VolumeControl;
    move-object v2, v1
  :L0
  .line 63
  .end local v1
    return-object v2
  :L1
  .line 58
    const-string v2, "ToneControl"
    invoke-virtual { p1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v2
    if-eq v2, v3, :L2
  .line 59
    new-instance v0, Ljavax/microedition/media/control/ToneControl;
    invoke-direct { v0 }, Ljavax/microedition/media/control/ToneControl;-><init>()V
  .local v0, "tc":Ljavax/microedition/media/control/ToneControl;
    move-object v2, v0
  .line 60
    goto :L0
  :L2
  .line 62
  .end local v0
    const-string v2, "ERROR"
    const-string v3, "PLAYER IS ERROR"
    invoke-static { v2, v3 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 63
    const/4 v2, 0
    goto :L0
.end method

.method public getDuration()J
  .registers 5
  .prologue
  .line 209
    iget-object v2, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v2 }, Landroid/media/MediaPlayer;->getDuration()I
    move-result v2
    mul-int/lit16 v2, v2, 1000
    int-to-long v0, v2
  .line 210
  .local v0, "duration":J
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-gtz v2, :L1
  .line 211
    const-wide/16 v2, -1
  :L0
  .line 213
    return-wide v2
  :L1
    move-wide v2, v0
    goto :L0
.end method

.method public getMediaTime()J
  .registers 5
  .prologue
  .line 194
    iget-object v2, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v2 }, Landroid/media/MediaPlayer;->getCurrentPosition()I
    move-result v2
    mul-int/lit16 v2, v2, 1000
    int-to-long v0, v2
  .line 195
  .local v0, "mediaTime":J
    const-wide/16 v2, 0
    cmp-long v2, v0, v2
    if-gtz v2, :L1
  .line 196
    const-wide/16 v2, -1
  :L0
  .line 198
    return-wide v2
  :L1
    move-wide v2, v0
    goto :L0
.end method

.method public getState()I
  .registers 2
  .prologue
  .line 203
    iget v0, p0, Ljavax/microedition/media/Player;->state:I
    return v0
.end method

.method public onCompletion(Landroid/media/MediaPlayer;)V
  .parameter "mp" # Landroid/media/MediaPlayer;
  .registers 4
  .prologue
  .line 256
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    if-ne p1, v0, :L0
  .line 257
    iget v0, p0, Ljavax/microedition/media/Player;->playedCount:I
    add-int/lit8 v0, v0, 1
    iput v0, p0, Ljavax/microedition/media/Player;->playedCount:I
  .line 258
    iget v0, p0, Ljavax/microedition/media/Player;->playedCount:I
    iget v1, p0, Ljavax/microedition/media/Player;->loopCount:I
    if-lt v0, v1, :L0
    iget v0, p0, Ljavax/microedition/media/Player;->loopCount:I
    const/4 v1, -1
    if-eq v0, v1, :L0
  .line 259
    const/4 v0, 0
    invoke-virtual { p1, v0 }, Landroid/media/MediaPlayer;->setLooping(Z)V
  .line 260
    const-string v0, "endOfMedia"
    const/4 v1, 0
    invoke-direct { p0, v0, v1 }, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V
  :L0
  .line 263
    return-void
.end method

.method public prefetch()V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/media/MediaException;
    }
  .end annotation
  .catch Ljava/lang/IllegalStateException; { :L2 .. :L3 } :L4
  .catch Ljava/io/IOException; { :L2 .. :L3 } :L5
  .registers 5
  .prologue
    const/16 v3, 300
  .line 93
    iget v1, p0, Ljavax/microedition/media/Player;->state:I
    if-lt v1, v3, :L1
  :L0
  .line 106
    return-void
  :L1
  .line 95
    iget v1, p0, Ljavax/microedition/media/Player;->state:I
    const/16 v2, 200
    if-ge v1, v2, :L2
  .line 96
    invoke-virtual { p0 }, Ljavax/microedition/media/Player;->realize()V
  :L2
  .line 99
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v1 }, Landroid/media/MediaPlayer;->prepare()V
  :L3
  .line 105
    iput v3, p0, Ljavax/microedition/media/Player;->state:I
    goto :L0
  :L4
  .line 100
    move-exception v1
    move-object v0, v1
  .line 101
  .local v0, "e":Ljava/lang/IllegalStateException;
    invoke-virtual { v0 }, Ljava/lang/IllegalStateException;->printStackTrace()V
    goto :L3
  :L5
  .line 102
  .end local v0
    move-exception v1
    move-object v0, v1
  .line 103
  .local v0, "e":Ljava/io/IOException;
    invoke-virtual { v0 }, Ljava/io/IOException;->printStackTrace()V
    goto :L3
.end method

.method public realize()V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/media/MediaException;
    }
  .end annotation
  .catch Ljava/io/IOException; { :L1 .. :L2 } :L5
  .catch Ljava/io/IOException; { :L3 .. :L4 } :L5
  .registers 10
  .prologue
    const/16 v8, 200
  .line 72
    iget v0, p0, Ljavax/microedition/media/Player;->state:I
    if-lt v0, v8, :L1
  :L0
  .line 87
    return-void
  :L1
  .line 76
    invoke-static { }, Ljavax/microedition/media/Manager;->getIsLocator()Z
    move-result v0
    if-eqz v0, :L3
  .line 77
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    iget-object v1, p0, Ljavax/microedition/media/Player;->dateSource:Ljava/lang/String;
    invoke-virtual { v0, v1 }, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V
  :L2
  .line 85
    iput v8, p0, Ljavax/microedition/media/Player;->state:I
    goto :L0
  :L3
  .line 79
    sget-object v0, Lcom/android/Util/AndroidUtil;->am:Landroid/content/res/AssetManager;
    iget-object v1, p0, Ljavax/microedition/media/Player;->dateSource:Ljava/lang/String;
    invoke-virtual { v0, v1 }, Landroid/content/res/AssetManager;->openFd(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    move-result-object v6
  .line 80
  .local v6, "afd":Landroid/content/res/AssetFileDescriptor;
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v6 }, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;
    move-result-object v1
    invoke-virtual { v6 }, Landroid/content/res/AssetFileDescriptor;->getStartOffset()J
    move-result-wide v2
    invoke-virtual { v6 }, Landroid/content/res/AssetFileDescriptor;->getLength()J
    move-result-wide v4
    invoke-virtual/range { v0 .. v5 }, Landroid/media/MediaPlayer;->setDataSource(Ljava/io/FileDescriptor;JJ)V
  :L4
    goto :L2
  :L5
  .line 82
  .end local v6
    move-exception v0
    move-object v7, v0
  .line 83
  .local v7, "e":Ljava/io/IOException;
    new-instance v0, Ljavax/microedition/media/MediaException;
    invoke-direct { v0 }, Ljavax/microedition/media/MediaException;-><init>()V
    throw v0
.end method

.method public removePlayerListener(Ljavax/microedition/media/PlayerListener;)V
  .parameter "playerListener" # Ljavax/microedition/media/PlayerListener;
  .registers 3
  .prologue
  .line 249
    iget-object v0, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;
    invoke-virtual { v0, p1 }, Ljava/util/Vector;->remove(Ljava/lang/Object;)Z
  .line 250
    return-void
.end method

.method public setDatasource(Ljava/lang/String;)V
  .parameter "dataSource" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 45
    iput-object p1, p0, Ljavax/microedition/media/Player;->dateSource:Ljava/lang/String;
  .line 46
    return-void
.end method

.method public setLoopCount(I)V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/lang/IllegalArgumentException;,
      Ljava/lang/IllegalStateException;
    }
  .end annotation
  .parameter "count" # I
  .registers 5
  .prologue
    const/4 v2, 1
  .line 226
    iget v0, p0, Ljavax/microedition/media/Player;->state:I
    const/16 v1, 400
    if-ne v0, v1, :L0
  .line 227
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "player is close"
    invoke-direct { v0, v1 }, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
  :L0
  .line 228
    if-nez p1, :L1
  .line 229
    new-instance v0, Ljava/lang/IllegalArgumentException;
    const-string v1, "loopcount is 0"
    invoke-direct { v0, v1 }, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v0
  :L1
  .line 231
    const/4 v0, -1
    if-eq p1, v0, :L2
    if-le p1, v2, :L4
  :L2
  .line 232
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v0, v2 }, Landroid/media/MediaPlayer;->setLooping(Z)V
  .line 233
    iput p1, p0, Ljavax/microedition/media/Player;->loopCount:I
  :L3
  .line 238
    return-void
  :L4
  .line 235
    const-string v0, "Player"
    const-string v1, "Loop count < -1"
    invoke-static { v0, v1 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
    goto :L3
.end method

.method public setMediaTime(J)J
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/media/MediaException;
    }
  .end annotation
  .parameter "now" # J
  .registers 5
  .prologue
  .line 178
    long-to-int v1, p1
    div-int/lit16 v0, v1, 1000
  .line 179
  .local v0, "mill_now":I
    if-gez v0, :L1
  .line 180
    const/4 v0, 0
  .line 181
    const-wide/16 p1, 0
  :L0
  .line 186
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v1, v0 }, Landroid/media/MediaPlayer;->seekTo(I)V
  .line 187
    return-wide p1
  :L1
  .line 182
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v1 }, Landroid/media/MediaPlayer;->getDuration()I
    move-result v1
    if-le v0, v1, :L0
  .line 183
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v1 }, Landroid/media/MediaPlayer;->getDuration()I
    move-result v0
  .line 184
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v1 }, Landroid/media/MediaPlayer;->getDuration()I
    move-result v1
    mul-int/lit16 v1, v1, 1000
    int-to-long p1, v1
    goto :L0
.end method

.method public setType(Ljava/lang/String;)V
  .parameter "type" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 50
    iput-object p1, p0, Ljavax/microedition/media/Player;->type:Ljava/lang/String;
  .line 51
    return-void
.end method

.method public start()V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/media/MediaException;
    }
  .end annotation
  .catch Ljava/lang/IllegalStateException; { :L5 .. :L6 } :L7
  .registers 6
  .prologue
    const/16 v4, 400
    const/16 v3, 300
    const/16 v2, 200
  .line 111
    iget v1, p0, Ljavax/microedition/media/Player;->state:I
    if-lt v1, v4, :L1
  :L0
  .line 128
    return-void
  :L1
  .line 113
    iget v1, p0, Ljavax/microedition/media/Player;->state:I
    if-ge v1, v2, :L2
  .line 114
    invoke-virtual { p0 }, Ljavax/microedition/media/Player;->realize()V
  :L2
  .line 115
    iget v1, p0, Ljavax/microedition/media/Player;->state:I
    if-ge v1, v3, :L3
  .line 116
    invoke-virtual { p0 }, Ljavax/microedition/media/Player;->prefetch()V
  :L3
  .line 117
    iget v1, p0, Ljavax/microedition/media/Player;->state:I
    if-eq v1, v2, :L4
    iget v1, p0, Ljavax/microedition/media/Player;->state:I
    if-ne v1, v3, :L0
  :L4
  .line 118
    const/4 v1, 0
    iput v1, p0, Ljavax/microedition/media/Player;->playedCount:I
  :L5
  .line 120
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v1 }, Landroid/media/MediaPlayer;->start()V
  :L6
  .line 125
    const-string v1, "started"
    const/4 v2, 0
    invoke-direct { p0, v1, v2 }, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V
  .line 126
    iput v4, p0, Ljavax/microedition/media/Player;->state:I
    goto :L0
  :L7
  .line 121
    move-exception v1
    move-object v0, v1
  .line 122
  .local v0, "e":Ljava/lang/IllegalStateException;
    const-string v1, "error"
    invoke-virtual { v0 }, Ljava/lang/IllegalStateException;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-direct { p0, v1, v2 }, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V
  .line 123
    new-instance v1, Ljavax/microedition/media/MediaException;
    invoke-direct { v1 }, Ljavax/microedition/media/MediaException;-><init>()V
    throw v1
.end method

.method public stop()V
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljavax/microedition/media/MediaException;
    }
  .end annotation
  .catch Ljava/lang/IllegalStateException; { :L1 .. :L2 } :L3
  .registers 4
  .prologue
  .line 133
    iget v1, p0, Ljavax/microedition/media/Player;->state:I
    const/16 v2, 400
    if-ge v1, v2, :L1
  :L0
  .line 145
    return-void
  :L1
  .line 137
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;
    invoke-virtual { v1 }, Landroid/media/MediaPlayer;->pause()V
  :L2
  .line 142
    const-string v1, "stopped"
    const/4 v2, 0
    invoke-direct { p0, v1, v2 }, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V
  .line 143
    const/16 v1, 300
    iput v1, p0, Ljavax/microedition/media/Player;->state:I
    goto :L0
  :L3
  .line 138
    move-exception v1
    move-object v0, v1
  .line 139
  .local v0, "e":Ljava/lang/IllegalStateException;
    const-string v1, "error"
    invoke-virtual { v0 }, Ljava/lang/IllegalStateException;->getMessage()Ljava/lang/String;
    move-result-object v2
    invoke-direct { p0, v1, v2 }, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V
  .line 140
    new-instance v1, Ljavax/microedition/media/MediaException;
    invoke-direct { v1 }, Ljavax/microedition/media/MediaException;-><init>()V
    throw v1
.end method
