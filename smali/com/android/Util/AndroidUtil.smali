.class public Lcom/android/Util/AndroidUtil;
.super Ljava/lang/Object;
.source "AndroidUtil.java"

.field private final static LOG:Ljava/lang/String; = "PIC_ERROR"

.field public static SCREEN_HEIGHT:I

.field public static SCREEN_WIDTH:I

.field private static aManager:Landroid/media/AudioManager;

.field public static am:Landroid/content/res/AssetManager;

.field public static cv:Landroid/os/ConditionVariable;

.method static constructor <clinit>()V
  .registers 2
  .prologue
  .line 21
    new-instance v0, Landroid/os/ConditionVariable;
    const/4 v1, 1
    invoke-direct { v0, v1 }, Landroid/os/ConditionVariable;-><init>(Z)V
    sput-object v0, Lcom/android/Util/AndroidUtil;->cv:Landroid/os/ConditionVariable;
  .line 26
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/CwaActivity;->getAssets()Landroid/content/res/AssetManager;
    move-result-object v0
    sput-object v0, Lcom/android/Util/AndroidUtil;->am:Landroid/content/res/AssetManager;
  .line 14
    return-void
.end method

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 14
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static getCurrentMusic()I
  .registers 2
  .prologue
  .line 48
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, :L1
  .line 50
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;
    move-result-object v0
    const-string v1, "audio"
    invoke-virtual { v0, v1 }, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/media/AudioManager;
    sput-object v0, Lcom/android/Util/AndroidUtil;->aManager:Landroid/media/AudioManager;
  .line 51
    sget-object v0, Lcom/android/Util/AndroidUtil;->aManager:Landroid/media/AudioManager;
    const/4 v1, 3
    invoke-virtual { v0, v1 }, Landroid/media/AudioManager;->getStreamVolume(I)I
    move-result v0
  :L0
  .line 53
    return v0
  :L1
    const/4 v0, -1
    goto :L0
.end method

.method public static getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;
  .parameter "name" # Ljava/lang/String;
  .catch Ljava/io/IOException; { :L0 .. :L4 } :L5
  .registers 6
  .prologue
  .line 28
    const/4 v1, 0
  .line 30
  .local v1, "is":Ljava/io/InputStream;
    const/16 v2, 47
  :L0
    invoke-virtual { p0, v2 }, Ljava/lang/String;->indexOf(I)I
    move-result v2
    if-nez v2, :L3
  .line 31
    sget-object v2, Lcom/android/Util/AndroidUtil;->am:Landroid/content/res/AssetManager;
    const/4 v3, 1
    invoke-virtual { p0 }, Ljava/lang/String;->length()I
    move-result v4
    invoke-virtual { p0, v3, v4 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
    move-result-object v3
    invoke-virtual { v2, v3 }, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;
    move-result-object v1
  :L1
  .line 37
    if-nez v1, :L2
  .line 38
    const-string v2, "PIC_ERROR"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-static { p0 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v4, " is not exist"
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static { v2, v3 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  :L2
  .line 44
    return-object v1
  :L3
  .line 33
    sget-object v2, Lcom/android/Util/AndroidUtil;->am:Landroid/content/res/AssetManager;
    invoke-virtual { v2, p0 }, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;
  :L4
    move-result-object v1
    goto :L1
  :L5
  .line 40
    move-exception v2
    move-object v0, v2
  .line 41
  .local v0, "e":Ljava/io/IOException;
    const-string v2, "PIC_ERROR"
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-static { p0 }, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-direct { v3, v4 }, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    const-string v4, " is not exist"
    invoke-virtual { v3, v4 }, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual { v3 }, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static { v2, v3 }, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I
  .line 42
    invoke-virtual { v0 }, Ljava/io/IOException;->printStackTrace()V
    goto :L2
.end method

.method public static setMusic(I)V
  .parameter "volume" # I
  .registers 4
  .prologue
  .line 58
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;
    move-result-object v0
    if-eqz v0, :L0
  .line 59
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getContextInstance()Landroid/content/Context;
    move-result-object v0
    const-string v1, "audio"
    invoke-virtual { v0, v1 }, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/media/AudioManager;
    sput-object v0, Lcom/android/Util/AndroidUtil;->aManager:Landroid/media/AudioManager;
  .line 60
    sget-object v0, Lcom/android/Util/AndroidUtil;->aManager:Landroid/media/AudioManager;
    const/4 v1, 3
    const/16 v2, 16
    invoke-virtual { v0, v1, p0, v2 }, Landroid/media/AudioManager;->setStreamVolume(III)V
  :L0
  .line 62
    return-void
.end method
