.class public Ljavax/microedition/media/Player;
.super Ljava/lang/Object;
.source "Player.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;


# static fields
.field public static final CLOSED:I = 0x0

.field public static final PREFETCHED:I = 0x12c

.field public static final REALIZED:I = 0xc8

.field public static final STARTED:I = 0x190

.field public static final TIME_UNKNOWN:J = -0x1L

.field public static final UNREALIZED:I = 0x64


# instance fields
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


# direct methods
.method public constructor <init>()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    const/16 v0, 0x64

    iput v0, p0, Ljavax/microedition/media/Player;->state:I

    .line 35
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    iput-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    .line 36
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;

    .line 37
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v0, p0}, Landroid/media/MediaPlayer;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    .line 38
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setLooping(Z)V

    .line 39
    iput-object v2, p0, Ljavax/microedition/media/Player;->dateSource:Ljava/lang/String;

    .line 40
    iput-object v2, p0, Ljavax/microedition/media/Player;->type:Ljava/lang/String;

    .line 41
    return-void
.end method

.method private final onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .registers 6
    .param p1, "event"    # Ljava/lang/String;
    .param p2, "eventData"    # Ljava/lang/Object;

    .prologue
    .line 267
    iget-object v1, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;

    invoke-virtual {v1}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_6
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_d

    .line 270
    return-void

    .line 267
    :cond_d
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljavax/microedition/media/PlayerListener;

    .line 268
    .local v0, "playerListener":Ljavax/microedition/media/PlayerListener;
    invoke-interface {v0, p0, p1, p2}, Ljavax/microedition/media/PlayerListener;->playerUpdate(Ljavax/microedition/media/Player;Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_6
.end method


# virtual methods
.method public addPlayerListener(Ljavax/microedition/media/PlayerListener;)V
    .registers 3
    .param p1, "playerListener"    # Ljavax/microedition/media/PlayerListener;

    .prologue
    .line 242
    iget-object v0, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_d

    .line 243
    iget-object v0, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 245
    :cond_d
    return-void
.end method

.method public close()V
    .registers 4

    .prologue
    const/4 v2, 0x0

    .line 163
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_22

    .line 164
    iget v0, p0, Ljavax/microedition/media/Player;->state:I

    const/16 v1, 0x190

    if-ne v0, v1, :cond_15

    .line 165
    const-string v0, "stopped"

    invoke-direct {p0, v0, v2}, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 166
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->stop()V

    .line 168
    :cond_15
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 169
    const-string v0, "closed"

    invoke-direct {p0, v0, v2}, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 170
    const/4 v0, 0x0

    iput v0, p0, Ljavax/microedition/media/Player;->state:I

    .line 172
    :cond_22
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
    .registers 6
    .param p1, "controlType"    # Ljava/lang/String;

    .prologue
    const/4 v3, -0x1

    .line 55
    const-string v2, "VolumeControl"

    invoke-virtual {p1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-eq v2, v3, :cond_10

    .line 56
    new-instance v1, Ljavax/microedition/media/control/VolumeControl;

    invoke-direct {v1}, Ljavax/microedition/media/control/VolumeControl;-><init>()V

    .local v1, "vc":Ljavax/microedition/media/control/VolumeControl;
    move-object v2, v1

    .line 63
    .end local v1    # "vc":Ljavax/microedition/media/control/VolumeControl;
    :goto_f
    return-object v2

    .line 58
    :cond_10
    const-string v2, "ToneControl"

    invoke-virtual {p1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-eq v2, v3, :cond_1f

    .line 59
    new-instance v0, Ljavax/microedition/media/control/ToneControl;

    invoke-direct {v0}, Ljavax/microedition/media/control/ToneControl;-><init>()V

    .local v0, "tc":Ljavax/microedition/media/control/ToneControl;
    move-object v2, v0

    .line 60
    goto :goto_f

    .line 62
    .end local v0    # "tc":Ljavax/microedition/media/control/ToneControl;
    :cond_1f
    const-string v2, "ERROR"

    const-string v3, "PLAYER IS ERROR"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 63
    const/4 v2, 0x0

    goto :goto_f
.end method

.method public getDuration()J
    .registers 5

    .prologue
    .line 209
    iget-object v2, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v2

    mul-int/lit16 v2, v2, 0x3e8

    int-to-long v0, v2

    .line 210
    .local v0, "duration":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-gtz v2, :cond_12

    .line 211
    const-wide/16 v2, -0x1

    .line 213
    :goto_11
    return-wide v2

    :cond_12
    move-wide v2, v0

    goto :goto_11
.end method

.method public getMediaTime()J
    .registers 5

    .prologue
    .line 194
    iget-object v2, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->getCurrentPosition()I

    move-result v2

    mul-int/lit16 v2, v2, 0x3e8

    int-to-long v0, v2

    .line 195
    .local v0, "mediaTime":J
    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-gtz v2, :cond_12

    .line 196
    const-wide/16 v2, -0x1

    .line 198
    :goto_11
    return-wide v2

    :cond_12
    move-wide v2, v0

    goto :goto_11
.end method

.method public getState()I
    .registers 2

    .prologue
    .line 203
    iget v0, p0, Ljavax/microedition/media/Player;->state:I

    return v0
.end method

.method public onCompletion(Landroid/media/MediaPlayer;)V
    .registers 4
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 256
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    if-ne p1, v0, :cond_1f

    .line 257
    iget v0, p0, Ljavax/microedition/media/Player;->playedCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Ljavax/microedition/media/Player;->playedCount:I

    .line 258
    iget v0, p0, Ljavax/microedition/media/Player;->playedCount:I

    iget v1, p0, Ljavax/microedition/media/Player;->loopCount:I

    if-lt v0, v1, :cond_1f

    iget v0, p0, Ljavax/microedition/media/Player;->loopCount:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_1f

    .line 259
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/media/MediaPlayer;->setLooping(Z)V

    .line 260
    const-string v0, "endOfMedia"

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 263
    :cond_1f
    return-void
.end method

.method public prefetch()V
    .registers 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/microedition/media/MediaException;
        }
    .end annotation

    .prologue
    const/16 v3, 0x12c

    .line 93
    iget v1, p0, Ljavax/microedition/media/Player;->state:I

    if-lt v1, v3, :cond_7

    .line 106
    :goto_6
    return-void

    .line 95
    :cond_7
    iget v1, p0, Ljavax/microedition/media/Player;->state:I

    const/16 v2, 0xc8

    if-ge v1, v2, :cond_10

    .line 96
    invoke-virtual {p0}, Ljavax/microedition/media/Player;->realize()V

    .line 99
    :cond_10
    :try_start_10
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->prepare()V
    :try_end_15
    .catch Ljava/lang/IllegalStateException; {:try_start_10 .. :try_end_15} :catch_18
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_15} :catch_1e

    .line 105
    :goto_15
    iput v3, p0, Ljavax/microedition/media/Player;->state:I

    goto :goto_6

    .line 100
    :catch_18
    move-exception v1

    move-object v0, v1

    .line 101
    .local v0, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v0}, Ljava/lang/IllegalStateException;->printStackTrace()V

    goto :goto_15

    .line 102
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    :catch_1e
    move-exception v1

    move-object v0, v1

    .line 103
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_15
.end method

.method public realize()V
    .registers 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/microedition/media/MediaException;
        }
    .end annotation

    .prologue
    const/16 v8, 0xc8

    .line 72
    iget v0, p0, Ljavax/microedition/media/Player;->state:I

    if-lt v0, v8, :cond_7

    .line 87
    :goto_6
    return-void

    .line 76
    :cond_7
    :try_start_7
    invoke-static {}, Ljavax/microedition/media/Manager;->getIsLocator()Z

    move-result v0

    if-eqz v0, :cond_17

    .line 77
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    iget-object v1, p0, Ljavax/microedition/media/Player;->dateSource:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V
    :try_end_14
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_14} :catch_31

    .line 85
    :goto_14
    iput v8, p0, Ljavax/microedition/media/Player;->state:I

    goto :goto_6

    .line 79
    :cond_17
    :try_start_17
    sget-object v0, Lcom/android/Util/AndroidUtil;->am:Landroid/content/res/AssetManager;

    iget-object v1, p0, Ljavax/microedition/media/Player;->dateSource:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/content/res/AssetManager;->openFd(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;

    move-result-object v6

    .line 80
    .local v6, "afd":Landroid/content/res/AssetFileDescriptor;
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getFileDescriptor()Ljava/io/FileDescriptor;

    move-result-object v1

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getStartOffset()J

    move-result-wide v2

    invoke-virtual {v6}, Landroid/content/res/AssetFileDescriptor;->getLength()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Landroid/media/MediaPlayer;->setDataSource(Ljava/io/FileDescriptor;JJ)V
    :try_end_30
    .catch Ljava/io/IOException; {:try_start_17 .. :try_end_30} :catch_31

    goto :goto_14

    .line 82
    .end local v6    # "afd":Landroid/content/res/AssetFileDescriptor;
    :catch_31
    move-exception v0

    move-object v7, v0

    .line 83
    .local v7, "e":Ljava/io/IOException;
    new-instance v0, Ljavax/microedition/media/MediaException;

    invoke-direct {v0}, Ljavax/microedition/media/MediaException;-><init>()V

    throw v0
.end method

.method public removePlayerListener(Ljavax/microedition/media/PlayerListener;)V
    .registers 3
    .param p1, "playerListener"    # Ljavax/microedition/media/PlayerListener;

    .prologue
    .line 249
    iget-object v0, p0, Ljavax/microedition/media/Player;->playerListeners:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->remove(Ljava/lang/Object;)Z

    .line 250
    return-void
.end method

.method public setDatasource(Ljava/lang/String;)V
    .registers 2
    .param p1, "dataSource"    # Ljava/lang/String;

    .prologue
    .line 45
    iput-object p1, p0, Ljavax/microedition/media/Player;->dateSource:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public setLoopCount(I)V
    .registers 5
    .param p1, "count"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    .line 226
    iget v0, p0, Ljavax/microedition/media/Player;->state:I

    const/16 v1, 0x190

    if-ne v0, v1, :cond_f

    .line 227
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "player is close"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 228
    :cond_f
    if-nez p1, :cond_19

    .line 229
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "loopcount is 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 231
    :cond_19
    const/4 v0, -0x1

    if-eq p1, v0, :cond_1e

    if-le p1, v2, :cond_26

    .line 232
    :cond_1e
    iget-object v0, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v0, v2}, Landroid/media/MediaPlayer;->setLooping(Z)V

    .line 233
    iput p1, p0, Ljavax/microedition/media/Player;->loopCount:I

    .line 238
    :goto_25
    return-void

    .line 235
    :cond_26
    const-string v0, "Player"

    const-string v1, "Loop count < -1"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_25
.end method

.method public setMediaTime(J)J
    .registers 5
    .param p1, "now"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/microedition/media/MediaException;
        }
    .end annotation

    .prologue
    .line 178
    long-to-int v1, p1

    div-int/lit16 v0, v1, 0x3e8

    .line 179
    .local v0, "mill_now":I
    if-gez v0, :cond_e

    .line 180
    const/4 v0, 0x0

    .line 181
    const-wide/16 p1, 0x0

    .line 186
    :cond_8
    :goto_8
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v1, v0}, Landroid/media/MediaPlayer;->seekTo(I)V

    .line 187
    return-wide p1

    .line 182
    :cond_e
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v1

    if-le v0, v1, :cond_8

    .line 183
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v0

    .line 184
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->getDuration()I

    move-result v1

    mul-int/lit16 v1, v1, 0x3e8

    int-to-long p1, v1

    goto :goto_8
.end method

.method public setType(Ljava/lang/String;)V
    .registers 2
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Ljavax/microedition/media/Player;->type:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public start()V
    .registers 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/microedition/media/MediaException;
        }
    .end annotation

    .prologue
    const/16 v4, 0x190

    const/16 v3, 0x12c

    const/16 v2, 0xc8

    .line 111
    iget v1, p0, Ljavax/microedition/media/Player;->state:I

    if-lt v1, v4, :cond_b

    .line 128
    :cond_a
    :goto_a
    return-void

    .line 113
    :cond_b
    iget v1, p0, Ljavax/microedition/media/Player;->state:I

    if-ge v1, v2, :cond_12

    .line 114
    invoke-virtual {p0}, Ljavax/microedition/media/Player;->realize()V

    .line 115
    :cond_12
    iget v1, p0, Ljavax/microedition/media/Player;->state:I

    if-ge v1, v3, :cond_19

    .line 116
    invoke-virtual {p0}, Ljavax/microedition/media/Player;->prefetch()V

    .line 117
    :cond_19
    iget v1, p0, Ljavax/microedition/media/Player;->state:I

    if-eq v1, v2, :cond_21

    iget v1, p0, Ljavax/microedition/media/Player;->state:I

    if-ne v1, v3, :cond_a

    .line 118
    :cond_21
    const/4 v1, 0x0

    iput v1, p0, Ljavax/microedition/media/Player;->playedCount:I

    .line 120
    :try_start_24
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->start()V
    :try_end_29
    .catch Ljava/lang/IllegalStateException; {:try_start_24 .. :try_end_29} :catch_32

    .line 125
    const-string v1, "started"

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 126
    iput v4, p0, Ljavax/microedition/media/Player;->state:I

    goto :goto_a

    .line 121
    :catch_32
    move-exception v1

    move-object v0, v1

    .line 122
    .local v0, "e":Ljava/lang/IllegalStateException;
    const-string v1, "error"

    invoke-virtual {v0}, Ljava/lang/IllegalStateException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 123
    new-instance v1, Ljavax/microedition/media/MediaException;

    invoke-direct {v1}, Ljavax/microedition/media/MediaException;-><init>()V

    throw v1
.end method

.method public stop()V
    .registers 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/microedition/media/MediaException;
        }
    .end annotation

    .prologue
    .line 133
    iget v1, p0, Ljavax/microedition/media/Player;->state:I

    const/16 v2, 0x190

    if-ge v1, v2, :cond_7

    .line 145
    :goto_6
    return-void

    .line 137
    :cond_7
    :try_start_7
    iget-object v1, p0, Ljavax/microedition/media/Player;->mp:Landroid/media/MediaPlayer;

    invoke-virtual {v1}, Landroid/media/MediaPlayer;->pause()V
    :try_end_c
    .catch Ljava/lang/IllegalStateException; {:try_start_7 .. :try_end_c} :catch_17

    .line 142
    const-string v1, "stopped"

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 143
    const/16 v1, 0x12c

    iput v1, p0, Ljavax/microedition/media/Player;->state:I

    goto :goto_6

    .line 138
    :catch_17
    move-exception v1

    move-object v0, v1

    .line 139
    .local v0, "e":Ljava/lang/IllegalStateException;
    const-string v1, "error"

    invoke-virtual {v0}, Ljava/lang/IllegalStateException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Ljavax/microedition/media/Player;->onEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 140
    new-instance v1, Ljavax/microedition/media/MediaException;

    invoke-direct {v1}, Ljavax/microedition/media/MediaException;-><init>()V

    throw v1
.end method
