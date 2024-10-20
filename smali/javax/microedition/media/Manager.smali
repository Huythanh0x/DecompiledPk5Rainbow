.class public Ljavax/microedition/media/Manager;
.super Ljava/lang/Object;
.source "Manager.java"


# static fields
.field private static islocator:Z

.field private static final supportedContentTypes:[Ljava/lang/String;

.field private static final supportedProtocols:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .registers 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 9
    sput-boolean v3, Ljavax/microedition/media/Manager;->islocator:Z

    .line 70
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/String;

    .line 71
    const-string v1, "audio/x-wav"

    aput-object v1, v0, v3

    const-string v1, "audio/basic"

    aput-object v1, v0, v4

    const-string v1, "audio/mpeg"

    aput-object v1, v0, v5

    const/4 v1, 0x3

    const-string v2, "audio/midi"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "audio/x-tone-seq"

    aput-object v2, v0, v1

    const/4 v1, 0x5

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
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static createPlayer(Ljava/lang/String;)Ljavax/microedition/media/Player;
    .registers 4
    .param p0, "locator"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljavax/microedition/media/MediaException;
        }
    .end annotation

    .prologue
    .line 42
    const/4 v2, 0x1

    sput-boolean v2, Ljavax/microedition/media/Manager;->islocator:Z

    .line 43
    const-string v1, ""

    .line 44
    .local v1, "typeName":Ljava/lang/String;
    const-string v2, ".mid"

    invoke-virtual {p0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_15

    const-string v2, ".midi"

    invoke-virtual {p0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_23

    .line 45
    :cond_15
    const-string v1, "audio/midi"

    .line 54
    :cond_17
    :goto_17
    new-instance v0, Ljavax/microedition/media/Player;

    invoke-direct {v0}, Ljavax/microedition/media/Player;-><init>()V

    .line 55
    .local v0, "player":Ljavax/microedition/media/Player;
    invoke-virtual {v0, p0}, Ljavax/microedition/media/Player;->setDatasource(Ljava/lang/String;)V

    .line 56
    invoke-virtual {v0, v1}, Ljavax/microedition/media/Player;->setType(Ljava/lang/String;)V

    .line 58
    return-object v0

    .line 46
    .end local v0    # "player":Ljavax/microedition/media/Player;
    :cond_23
    const-string v2, ".wav"

    invoke-virtual {p0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2e

    .line 47
    const-string v1, "audio/x-wav"

    goto :goto_17

    .line 48
    :cond_2e
    const-string v2, ".mpeg"

    invoke-virtual {p0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_3e

    const-string v2, ".mp3"

    invoke-virtual {p0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_41

    .line 49
    :cond_3e
    const-string v1, "audio/mpeg"

    goto :goto_17

    .line 50
    :cond_41
    const-string v2, ".amr"

    invoke-virtual {p0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_17

    .line 51
    const-string v1, "audio/amr"

    goto :goto_17
.end method

.method public static createPlayer(Ljava/lang/String;Ljava/lang/String;)Ljavax/microedition/media/Player;
    .registers 6
    .param p0, "sound"    # Ljava/lang/String;
    .param p1, "type"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljavax/microedition/media/MediaException;
        }
    .end annotation

    .prologue
    const/4 v3, -0x1

    .line 14
    const/4 v2, 0x0

    sput-boolean v2, Ljavax/microedition/media/Manager;->islocator:Z

    .line 15
    const-string v1, ""

    .line 16
    .local v1, "typeName":Ljava/lang/String;
    const-string v2, "mid"

    invoke-virtual {p1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-eq v2, v3, :cond_2d

    .line 17
    const-string v1, ".mid"

    .line 26
    :cond_10
    :goto_10
    new-instance v0, Ljavax/microedition/media/Player;

    invoke-direct {v0}, Ljavax/microedition/media/Player;-><init>()V

    .line 27
    .local v0, "player":Ljavax/microedition/media/Player;
    const/16 v2, 0x2f

    invoke-virtual {p0, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    if-nez v2, :cond_4e

    .line 28
    const/4 v2, 0x1

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {p0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljavax/microedition/media/Player;->setDatasource(Ljava/lang/String;)V

    .line 32
    :goto_29
    invoke-virtual {v0, v1}, Ljavax/microedition/media/Player;->setType(Ljava/lang/String;)V

    .line 34
    return-object v0

    .line 18
    .end local v0    # "player":Ljavax/microedition/media/Player;
    :cond_2d
    const-string v2, "midi"

    invoke-virtual {p1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-eq v2, v3, :cond_38

    .line 19
    const-string v1, ".midi"

    goto :goto_10

    .line 20
    :cond_38
    const-string v2, "mpeg"

    invoke-virtual {p1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-eq v2, v3, :cond_43

    .line 21
    const-string v1, ".mp3"

    goto :goto_10

    .line 22
    :cond_43
    const-string v2, "amr"

    invoke-virtual {p1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-eq v2, v3, :cond_10

    .line 23
    const-string v1, ".amr"

    goto :goto_10

    .line 30
    .restart local v0    # "player":Ljavax/microedition/media/Player;
    :cond_4e
    invoke-virtual {v0, p0}, Ljavax/microedition/media/Player;->setDatasource(Ljava/lang/String;)V

    goto :goto_29
.end method

.method public static getIsLocator()Z
    .registers 1

    .prologue
    .line 81
    sget-boolean v0, Ljavax/microedition/media/Manager;->islocator:Z

    return v0
.end method

.method public static getSupportedContentTypes(Ljava/lang/String;)[Ljava/lang/String;
    .registers 2
    .param p0, "protocol"    # Ljava/lang/String;

    .prologue
    .line 62
    sget-object v0, Ljavax/microedition/media/Manager;->supportedContentTypes:[Ljava/lang/String;

    return-object v0
.end method

.method public static getSupportedProtocols(Ljava/lang/String;)[Ljava/lang/String;
    .registers 2
    .param p0, "content_type"    # Ljava/lang/String;

    .prologue
    .line 66
    sget-object v0, Ljavax/microedition/media/Manager;->supportedProtocols:[Ljava/lang/String;

    return-object v0
.end method
