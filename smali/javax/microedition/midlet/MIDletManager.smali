.class public Ljavax/microedition/midlet/MIDletManager;
.super Ljava/lang/Object;
.source "MIDletManager.java"


# static fields
.field private static jam:Ljavax/microedition/midlet/MIDletManager;


# instance fields
.field private autoLaunch:Z

.field private currentMidlet:Ljavax/microedition/midlet/MIDlet;

.field private destroyed:Z

.field private jad:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private midlets:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private paused:Z


# direct methods
.method private constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean v1, p0, Ljavax/microedition/midlet/MIDletManager;->autoLaunch:Z

    .line 17
    const/4 v0, 0x0

    iput-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z

    .line 18
    iput-boolean v1, p0, Ljavax/microedition/midlet/MIDletManager;->destroyed:Z

    .line 29
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->midlets:Ljava/util/Map;

    .line 30
    new-instance v0, Ljava/util/LinkedHashMap;

    invoke-direct {v0}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->jad:Ljava/util/Map;

    .line 31
    return-void
.end method

.method public static final getInstance()Ljavax/microedition/midlet/MIDletManager;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Ljavax/microedition/midlet/MIDletManager;->jam:Ljavax/microedition/midlet/MIDletManager;

    if-nez v0, :cond_0

    .line 39
    new-instance v0, Ljavax/microedition/midlet/MIDletManager;

    invoke-direct {v0}, Ljavax/microedition/midlet/MIDletManager;-><init>()V

    sput-object v0, Ljavax/microedition/midlet/MIDletManager;->jam:Ljavax/microedition/midlet/MIDletManager;

    .line 41
    :cond_0
    sget-object v0, Ljavax/microedition/midlet/MIDletManager;->jam:Ljavax/microedition/midlet/MIDletManager;

    return-object v0
.end method


# virtual methods
.method public final getAppProperty(Ljavax/microedition/midlet/MIDlet;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "midlet"    # Ljavax/microedition/midlet/MIDlet;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 131
    iget-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->jad:Ljava/util/Map;

    invoke-interface {v0, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p0

    .end local p0    # "this":Ljavax/microedition/midlet/MIDletManager;
    check-cast p0, Ljava/lang/String;

    return-object p0
.end method

.method public getCurrenMIDlet()Ljavax/microedition/midlet/MIDlet;
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;

    return-object v0
.end method

.method public isAutoLaunch()Z
    .locals 1

    .prologue
    .line 56
    iget-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->autoLaunch:Z

    return v0
.end method

.method public final notifyDestroyed()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 138
    iget-object v1, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Ljavax/microedition/midlet/MIDletManager;->destroyed:Z

    if-nez v1, :cond_0

    .line 139
    iput-boolean v2, p0, Ljavax/microedition/midlet/MIDletManager;->destroyed:Z

    .line 141
    :try_start_0
    iget-object v1, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Ljavax/microedition/midlet/MIDlet;->destroyApp(Z)V
    :try_end_0
    .catch Ljavax/microedition/midlet/MIDletStateChangeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 146
    :cond_0
    :goto_0
    iget-object v1, p0, Ljavax/microedition/midlet/MIDletManager;->jad:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    .line 147
    iget-object v1, p0, Ljavax/microedition/midlet/MIDletManager;->midlets:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    .line 148
    return-void

    .line 142
    :catch_0
    move-exception v1

    move-object v0, v1

    .line 143
    .local v0, "e":Ljavax/microedition/midlet/MIDletStateChangeException;
    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletStateChangeException;->printStackTrace()V

    goto :goto_0
.end method

.method public final notifyExit()V
    .locals 1

    .prologue
    .line 154
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/lcdui/CwaActivity;->finish()V

    .line 155
    return-void
.end method

.method public final notifyPaused()V
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z

    if-nez v0, :cond_0

    .line 162
    const/4 v0, 0x1

    iput-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z

    .line 163
    invoke-static {}, Ljavax/microedition/lcdui/Display;->getCanvas()Ljavax/microedition/lcdui/Canvas;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Canvas;->hideNotify()V

    .line 165
    :cond_0
    return-void
.end method

.method public final notifyResumed()V
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z

    if-eqz v0, :cond_0

    .line 172
    const/4 v0, 0x0

    iput-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z

    .line 173
    invoke-static {}, Ljavax/microedition/lcdui/Display;->getCanvas()Ljavax/microedition/lcdui/Canvas;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/lcdui/Canvas;->showNotify()V

    .line 175
    :cond_0
    return-void
.end method

.method public setAutoLaunch(Z)V
    .locals 0
    .param p1, "autoLaunch"    # Z

    .prologue
    .line 48
    iput-boolean p1, p0, Ljavax/microedition/midlet/MIDletManager;->autoLaunch:Z

    .line 49
    return-void
.end method

.method public setMIDlet(Ljavax/microedition/midlet/MIDlet;)V
    .locals 0
    .param p1, "midlet"    # Ljavax/microedition/midlet/MIDlet;

    .prologue
    .line 186
    iput-object p1, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;

    .line 187
    return-void
.end method
