.class public Ljavax/microedition/media/control/VolumeControl;
.super Ljava/lang/Object;
.implements Ljavax/microedition/media/Control;
.source "VolumeControl.java"

.field private audioManager:Landroid/media/AudioManager;

.field private currentVolume:I

.field private maxVolume:I

.field private mute:Z

.field private percent:F

.method public constructor <init>()V
  .registers 3
  .prologue
    const/4 v0, 0
  .line 24
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 19
    iput-boolean v0, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z
  .line 20
    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I
  .line 25
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;
    move-result-object v0
    const-string v1, "audio"
    invoke-virtual { v0, v1 }, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/media/AudioManager;
    iput-object v0, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;
  .line 26
    iget-object v0, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;
    const/4 v1, 3
    invoke-virtual { v0, v1 }, Landroid/media/AudioManager;->getStreamMaxVolume(I)I
    move-result v0
    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->maxVolume:I
  .line 27
    const/16 v0, 100
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
    const/4 v0, 1
    iput-boolean v0, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z
  .line 100
    iget-object v0, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;
    const/4 v1, 3
    const/4 v2, 0
    const/16 v3, 16
    invoke-virtual { v0, v1, v2, v3 }, Landroid/media/AudioManager;->setStreamVolume(III)V
  .line 101
    return-void
.end method

.method private unmute()V
  .registers 5
  .prologue
  .line 106
    const/4 v0, 0
    iput-boolean v0, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z
  .line 107
    iget-object v0, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;
    const/4 v1, 3
    iget v2, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I
    const/16 v3, 16
    invoke-virtual { v0, v1, v2, v3 }, Landroid/media/AudioManager;->setStreamVolume(III)V
  .line 108
    return-void
.end method

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
    invoke-virtual { p0 }, Ljavax/microedition/media/control/VolumeControl;->getLevel()I
    move-result v0
    if-nez v0, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public setLevel(I)I
  .parameter "level" # I
  .registers 6
  .prologue
  .line 43
    if-gez p1, :L2
  .line 44
    const/4 p1, 0
  :L0
  .line 49
    int-to-float v1, p1
    iget v2, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F
    div-float/2addr v1, v2
    float-to-int v0, v1
  .line 50
  .local v0, "androidLevel":I
    iget-boolean v1, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z
    if-nez v1, :L1
  .line 53
    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I
  .line 55
    const-string v1, ""
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f"
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v3, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static { v1, v2 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 56
    const-string v1, ""
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f"
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v2, v0 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static { v1, v2 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  :L1
  .line 61
    return p1
  :L2
  .line 45
  .end local v0
    const/16 v1, 100
    if-le p1, v1, :L0
  .line 46
    const/16 p1, 100
    goto :L0
.end method

.method public setLevelForMenu(I)I
  .parameter "level" # I
  .registers 6
  .prologue
  .line 65
    if-gez p1, :L2
  .line 66
    const/4 p1, 0
  :L0
  .line 71
    int-to-float v1, p1
    iget v2, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F
    div-float/2addr v1, v2
    float-to-int v0, v1
  .line 72
  .local v0, "androidLevel":I
    iget-boolean v1, p0, Ljavax/microedition/media/control/VolumeControl;->mute:Z
    if-nez v1, :L1
  .line 75
    iput v0, p0, Ljavax/microedition/media/control/VolumeControl;->currentVolume:I
  .line 77
    const-string v1, ""
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u7684\u6bd4\u4f8b\u503c\u662f"
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v3, p0, Ljavax/microedition/media/control/VolumeControl;->percent:F
    invoke-virtual { v2, v3 }, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static { v1, v2 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 78
    const-string v1, ""
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "\u8fd9\u4e2a\u6e38\u620f\u7684\u7ba1\u7406\u5668\u58f0\u97f3\u662f"
    invoke-direct { v2, v3 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual { v2, v0 }, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual { v2 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static { v1, v2 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 79
    const-string v1, ""
    const-string v2, "dddddddddddddddddddddd"
    invoke-static { v1, v2 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 81
    iget-object v1, p0, Ljavax/microedition/media/control/VolumeControl;->audioManager:Landroid/media/AudioManager;
    const/4 v2, 3
    const/16 v3, 16
    invoke-virtual { v1, v2, v0, v3 }, Landroid/media/AudioManager;->setStreamVolume(III)V
  :L1
  .line 84
    return p1
  :L2
  .line 67
  .end local v0
    const/16 v1, 100
    if-le p1, v1, :L0
  .line 68
    const/16 p1, 100
    goto :L0
.end method

.method public setMute(Z)V
  .parameter "mute" # Z
  .registers 2
  .prologue
  .line 89
    if-eqz p1, :L1
  .line 90
    invoke-direct { p0 }, Ljavax/microedition/media/control/VolumeControl;->mute()V
  :L0
  .line 94
    return-void
  :L1
  .line 92
    invoke-direct { p0 }, Ljavax/microedition/media/control/VolumeControl;->unmute()V
    goto :L0
.end method
