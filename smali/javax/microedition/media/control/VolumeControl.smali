.class public Ljavax/microedition/media/control/VolumeControl;
.super Ljava/lang/Object;
.source "VolumeControl.java"

# interfaces
.implements Ljavax/microedition/media/Control;


# instance fields
.field private audioManager:Landroid/media/AudioManager;

.field private currentVolume:I

.field private maxVolume:I

.field private mute:Z

.field private percent:F


# direct methods
.method public constructor <init>()V
    .registers 3

    .prologue
    const/4 v0, 0x0

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-boolean v0, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z

    .line 20
    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I

    .line 25
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;

    move-result-object v0

    const-string v1, "audio"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;

    .line 26
    iget-object v0, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result v0

    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->maxVolume:I

    .line 27
    const/16 v0, 0x64

    iget v1, p0, Ljavax/microedition/media/control/VolumeControl;->maxVolume:I

    div-int/2addr v0, v1

    int-to-float v0, v0

    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F

    .line 28
    return-void
.end method

.method private mute()V
    .registers 5

    .prologue
    .line 99
    const/4 v0, 0x1

    iput-boolean v0, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z

    .line 100
    iget-object v0, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x3

    const/4 v2, 0x0

    const/16 v3, 0x10

    invoke-virtual {v0, v1, v2, v3}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 101
    return-void
.end method

.method private unmute()V
    .registers 5

    .prologue
    .line 106
    const/4 v0, 0x0

    iput-boolean v0, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z

    .line 107
    iget-object v0, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;

    const/4 v1, 0x3

    iget v2, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I

    const/16 v3, 0x10

    invoke-virtual {v0, v1, v2, v3}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 108
    return-void
.end method


# virtual methods
.method public getLevel()I
    .registers 3

    .prologue
    .line 32
    iget v0, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I

    int-to-float v0, v0

    iget v1, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F

    mul-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method public isMuted()Z
    .registers 2

    .prologue
    .line 37
    invoke-virtual {p0}, Ljavax/microedition/media/control/VolumeControl;->getLevel()I

    move-result v0

    if-nez v0, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public setLevel(I)I
    .registers 6
    .param p1, "level"    # I

    .prologue
    .line 43
    if-gez p1, :cond_39

    .line 44
    const/4 p1, 0x0

    .line 49
    :cond_3
    :goto_3
    int-to-float v1, p1

    iget v2, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F

    div-float/2addr v1, v2

    float-to-int v0, v1

    .line 50
    .local v0, "androidLevel":I
    iget-boolean v1, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z

    if-nez v1, :cond_38

    .line 53
    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I

    .line 55
    const-string v1, ""

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 56
    const-string v1, ""

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 61
    :cond_38
    return p1

    .line 45
    .end local v0    # "androidLevel":I
    :cond_39
    const/16 v1, 0x64

    if-le p1, v1, :cond_3

    .line 46
    const/16 p1, 0x64

    goto :goto_3
.end method

.method public setLevelForMenu(I)I
    .registers 6
    .param p1, "level"    # I

    .prologue
    .line 65
    if-gez p1, :cond_48

    .line 66
    const/4 p1, 0x0

    .line 71
    :cond_3
    :goto_3
    int-to-float v1, p1

    iget v2, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F

    div-float/2addr v1, v2

    float-to-int v0, v1

    .line 72
    .local v0, "androidLevel":I
    iget-boolean v1, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z

    if-nez v1, :cond_47

    .line 75
    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I

    .line 77
    const-string v1, ""

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v3, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 78
    const-string v1, ""

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    const-string v1, ""

    const-string v2, "dddddddddddddddddddddd"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 81
    iget-object v1, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;

    const/4 v2, 0x3

    const/16 v3, 0x10

    invoke-virtual {v1, v2, v0, v3}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 84
    :cond_47
    return p1

    .line 67
    .end local v0    # "androidLevel":I
    :cond_48
    const/16 v1, 0x64

    if-le p1, v1, :cond_3

    .line 68
    const/16 p1, 0x64

    goto :goto_3
.end method

.method public setMute(Z)V
    .registers 2
    .param p1, "mute"    # Z

    .prologue
    .line 89
    if-eqz p1, :cond_6

    .line 90
    invoke-direct {p0}, Ljavax/microedition/media/control/VolumeControl;->mute()V

    .line 94
    :goto_5
    return-void

    .line 92
    :cond_6
    invoke-direct {p0}, Ljavax/microedition/media/control/VolumeControl;->unmute()V

    goto :goto_5
.end method
