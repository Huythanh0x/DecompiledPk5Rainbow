.class public Ljavax/microedition/media/Manager;
.super Ljava/lang/Object;
.source "Manager.java"

.field private static islocator:Z

.field private final static supportedContentTypes:[Ljava/lang/String;

.field private final static supportedProtocols:[Ljava/lang/String;

.method static constructor <clinit>()V
  .registers 6
  .prologue
    const/4 v5, 2
    const/4 v4, 1
    const/4 v3, 0
  .line 9
    sput-boolean v3, Ljavax/microedition/media/Manager;->islocator:Z
  .line 70
    const/4 v0, 6
    new-array v0, v0, [Ljava/lang/String;
  .line 71
    const-string v1, "audio/x-wav"
    aput-object v1, v0, v3
    const-string v1, "audio/basic"
    aput-object v1, v0, v4
    const-string v1, "audio/mpeg"
    aput-object v1, v0, v5
    const/4 v1, 3
    const-string v2, "audio/midi"
    aput-object v2, v0, v1
    const/4 v1, 4
    const-string v2, "audio/x-tone-seq"
    aput-object v2, v0, v1
    const/4 v1, 5
    const-string v2, "audio/amr"
    aput-object v2, v0, v1
  .line 70
    sput-object v0, Ljavax/microedition/media/Manager;->supportedContentTypes:[Ljava/lang/String;
  .line 75
    new-array v0, v5, [Ljava/lang/String;
  .line 76
    const-string v1, "http://"
    aput-object v1, v0, v3
    const-string v1, "rtsp://"
    aput-object v1, v0, v4
  .line 75
    sput-object v0, Ljavax/microedition/media/Manager;->supportedProtocols:[Ljava/lang/String;
  .line 8
    return-void
.end method

.method public constructor <init>()V
  .registers 1
  .prologue
  .line 8
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public static createPlayer(Ljava/lang/String;)Ljavax/microedition/media/Player;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/io/IOException;,
      Ljavax/microedition/media/MediaException;
    }
  .end annotation
  .parameter "locator" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 42
    const/4 v2, 1
    sput-boolean v2, Ljavax/microedition/media/Manager;->islocator:Z
  .line 43
    const-string v1, ""
  .line 44
  .local v1, "typeName":Ljava/lang/String;
    const-string v2, ".mid"
    invoke-virtual { p0, v2 }, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    move-result v2
    if-nez v2, :L0
    const-string v2, ".midi"
    invoke-virtual { p0, v2 }, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, :L2
  :L0
  .line 45
    const-string v1, "audio/midi"
  :L1
  .line 54
    new-instance v0, Ljavax/microedition/media/Player;
    invoke-direct { v0 }, Ljavax/microedition/media/Player;-><init>()V
  .line 55
  .local v0, "player":Ljavax/microedition/media/Player;
    invoke-virtual { v0, p0 }, Ljavax/microedition/media/Player;->setDatasource(Ljava/lang/String;)V
  .line 56
    invoke-virtual { v0, v1 }, Ljavax/microedition/media/Player;->setType(Ljava/lang/String;)V
  .line 58
    return-object v0
  :L2
  .line 46
  .end local v0
    const-string v2, ".wav"
    invoke-virtual { p0, v2 }, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, :L3
  .line 47
    const-string v1, "audio/x-wav"
    goto :L1
  :L3
  .line 48
    const-string v2, ".mpeg"
    invoke-virtual { p0, v2 }, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    move-result v2
    if-nez v2, :L4
    const-string v2, ".mp3"
    invoke-virtual { p0, v2 }, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, :L5
  :L4
  .line 49
    const-string v1, "audio/mpeg"
    goto :L1
  :L5
  .line 50
    const-string v2, ".amr"
    invoke-virtual { p0, v2 }, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, :L1
  .line 51
    const-string v1, "audio/amr"
    goto :L1
.end method

.method public static createPlayer(Ljava/lang/String;Ljava/lang/String;)Ljavax/microedition/media/Player;
  .annotation system Ldalvik/annotation/Throws;
    value = {
      Ljava/io/IOException;,
      Ljavax/microedition/media/MediaException;
    }
  .end annotation
  .parameter "sound" # Ljava/lang/String;
  .parameter "type" # Ljava/lang/String;
  .registers 6
  .prologue
    const/4 v3, -1
  .line 14
    const/4 v2, 0
    sput-boolean v2, Ljavax/microedition/media/Manager;->islocator:Z
  .line 15
    const-string v1, ""
  .line 16
  .local v1, "typeName":Ljava/lang/String;
    const-string v2, "mid"
    invoke-virtual { p1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v2
    if-eq v2, v3, :L2
  .line 17
    const-string v1, ".mid"
  :L0
  .line 26
    new-instance v0, Ljavax/microedition/media/Player;
    invoke-direct { v0 }, Ljavax/microedition/media/Player;-><init>()V
  .line 27
  .local v0, "player":Ljavax/microedition/media/Player;
    const/16 v2, 47
    invoke-virtual { p0, v2 }, Ljava/lang/String;->indexOf(I)I
    move-result v2
    if-nez v2, :L5
  .line 28
    const/4 v2, 1
    invoke-virtual { p0 }, Ljava/lang/String;->length()I
    move-result v3
    invoke-virtual { p0, v2, v3 }, Ljava/lang/String;->substring(II)Ljava/lang/String;
    move-result-object v2
    invoke-virtual { v0, v2 }, Ljavax/microedition/media/Player;->setDatasource(Ljava/lang/String;)V
  :L1
  .line 32
    invoke-virtual { v0, v1 }, Ljavax/microedition/media/Player;->setType(Ljava/lang/String;)V
  .line 34
    return-object v0
  :L2
  .line 18
  .end local v0
    const-string v2, "midi"
    invoke-virtual { p1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v2
    if-eq v2, v3, :L3
  .line 19
    const-string v1, ".midi"
    goto :L0
  :L3
  .line 20
    const-string v2, "mpeg"
    invoke-virtual { p1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v2
    if-eq v2, v3, :L4
  .line 21
    const-string v1, ".mp3"
    goto :L0
  :L4
  .line 22
    const-string v2, "amr"
    invoke-virtual { p1, v2 }, Ljava/lang/String;->indexOf(Ljava/lang/String;)I
    move-result v2
    if-eq v2, v3, :L0
  .line 23
    const-string v1, ".amr"
    goto :L0
  :L5
  .line 30
  .restart local v0
    invoke-virtual { v0, p0 }, Ljavax/microedition/media/Player;->setDatasource(Ljava/lang/String;)V
    goto :L1
.end method

.method public static getIsLocator()Z
  .registers 1
  .prologue
  .line 81
    sget-boolean v0, Ljavax/microedition/media/Manager;->islocator:Z
    return v0
.end method

.method public static getSupportedContentTypes(Ljava/lang/String;)[Ljava/lang/String;
  .parameter "protocol" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 62
    sget-object v0, Ljavax/microedition/media/Manager;->supportedContentTypes:[Ljava/lang/String;
    return-object v0
.end method

.method public static getSupportedProtocols(Ljava/lang/String;)[Ljava/lang/String;
  .parameter "content_type" # Ljava/lang/String;
  .registers 2
  .prologue
  .line 66
    sget-object v0, Ljavax/microedition/media/Manager;->supportedProtocols:[Ljava/lang/String;
    return-object v0
.end method
