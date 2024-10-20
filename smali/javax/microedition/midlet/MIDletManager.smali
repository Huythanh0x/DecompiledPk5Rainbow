.class public Ljavax/microedition/midlet/MIDletManager;
.super Ljava/lang/Object;
.source "MIDletManager.java"

.field private static jam:Ljavax/microedition/midlet/MIDletManager;

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

.method private constructor <init>()V
  .registers 3
  .prologue
    const/4 v1, 1
  .line 28
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 16
    iput-boolean v1, p0, Ljavax/microedition/midlet/MIDletManager;->autoLaunch:Z
  .line 17
    const/4 v0, 0
    iput-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z
  .line 18
    iput-boolean v1, p0, Ljavax/microedition/midlet/MIDletManager;->destroyed:Z
  .line 29
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct { v0 }, Ljava/util/LinkedHashMap;-><init>()V
    iput-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->midlets:Ljava/util/Map;
  .line 30
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct { v0 }, Ljava/util/LinkedHashMap;-><init>()V
    iput-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->jad:Ljava/util/Map;
  .line 31
    return-void
.end method

.method public final static getInstance()Ljavax/microedition/midlet/MIDletManager;
  .registers 1
  .prologue
  .line 38
    sget-object v0, Ljavax/microedition/midlet/MIDletManager;->jam:Ljavax/microedition/midlet/MIDletManager;
    if-nez v0, :L0
  .line 39
    new-instance v0, Ljavax/microedition/midlet/MIDletManager;
    invoke-direct { v0 }, Ljavax/microedition/midlet/MIDletManager;-><init>()V
    sput-object v0, Ljavax/microedition/midlet/MIDletManager;->jam:Ljavax/microedition/midlet/MIDletManager;
  :L0
  .line 41
    sget-object v0, Ljavax/microedition/midlet/MIDletManager;->jam:Ljavax/microedition/midlet/MIDletManager;
    return-object v0
.end method

.method public final getAppProperty(Ljavax/microedition/midlet/MIDlet;Ljava/lang/String;)Ljava/lang/String;
  .parameter "midlet" # Ljavax/microedition/midlet/MIDlet;
  .parameter "key" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 131
    iget-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->jad:Ljava/util/Map;
    invoke-interface { v0, p2 }, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object p0
  .end local p0
    check-cast p0, Ljava/lang/String;
    return-object p0
.end method

.method public getCurrenMIDlet()Ljavax/microedition/midlet/MIDlet;
  .registers 2
  .prologue
  .line 182
    iget-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;
    return-object v0
.end method

.method public isAutoLaunch()Z
  .registers 2
  .prologue
  .line 56
    iget-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->autoLaunch:Z
    return v0
.end method

.method public final notifyDestroyed()V
  .catch Ljavax/microedition/midlet/MIDletStateChangeException; { :L0 .. :L1 } :L2
  .registers 4
  .prologue
    const/4 v2, 1
  .line 138
    iget-object v1, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;
    if-eqz v1, :L1
    iget-boolean v1, p0, Ljavax/microedition/midlet/MIDletManager;->destroyed:Z
    if-nez v1, :L1
  .line 139
    iput-boolean v2, p0, Ljavax/microedition/midlet/MIDletManager;->destroyed:Z
  :L0
  .line 141
    iget-object v1, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;
    const/4 v2, 1
    invoke-virtual { v1, v2 }, Ljavax/microedition/midlet/MIDlet;->destroyApp(Z)V
  :L1
  .line 146
    iget-object v1, p0, Ljavax/microedition/midlet/MIDletManager;->jad:Ljava/util/Map;
    invoke-interface { v1 }, Ljava/util/Map;->clear()V
  .line 147
    iget-object v1, p0, Ljavax/microedition/midlet/MIDletManager;->midlets:Ljava/util/Map;
    invoke-interface { v1 }, Ljava/util/Map;->clear()V
  .line 148
    return-void
  :L2
  .line 142
    move-exception v1
    move-object v0, v1
  .line 143
  .local v0, "e":Ljavax/microedition/midlet/MIDletStateChangeException;
    invoke-virtual { v0 }, Ljavax/microedition/midlet/MIDletStateChangeException;->printStackTrace()V
    goto :L1
.end method

.method public final notifyExit()V
  .registers 2
  .prologue
  .line 154
    invoke-static { }, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;
    move-result-object v0
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/CwaActivity;->finish()V
  .line 155
    return-void
.end method

.method public final notifyPaused()V
  .registers 2
  .prologue
  .line 161
    iget-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;
    if-eqz v0, :L0
    iget-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z
    if-nez v0, :L0
  .line 162
    const/4 v0, 1
    iput-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z
  .line 163
    invoke-static { }, Ljavax/microedition/lcdui/Display;->getCanvas()Ljavax/microedition/lcdui/Canvas;
    move-result-object v0
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/Canvas;->hideNotify()V
  :L0
  .line 165
    return-void
.end method

.method public final notifyResumed()V
  .registers 2
  .prologue
  .line 171
    iget-object v0, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;
    if-eqz v0, :L0
    iget-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z
    if-eqz v0, :L0
  .line 172
    const/4 v0, 0
    iput-boolean v0, p0, Ljavax/microedition/midlet/MIDletManager;->paused:Z
  .line 173
    invoke-static { }, Ljavax/microedition/lcdui/Display;->getCanvas()Ljavax/microedition/lcdui/Canvas;
    move-result-object v0
    invoke-virtual { v0 }, Ljavax/microedition/lcdui/Canvas;->showNotify()V
  :L0
  .line 175
    return-void
.end method

.method public setAutoLaunch(Z)V
  .parameter "autoLaunch" # Z
  .registers 2
  .prologue
  .line 48
    iput-boolean p1, p0, Ljavax/microedition/midlet/MIDletManager;->autoLaunch:Z
  .line 49
    return-void
.end method

.method public setMIDlet(Ljavax/microedition/midlet/MIDlet;)V
  .parameter "midlet" # Ljavax/microedition/midlet/MIDlet;
  .registers 2
  .prologue
  .line 186
    iput-object p1, p0, Ljavax/microedition/midlet/MIDletManager;->currentMidlet:Ljavax/microedition/midlet/MIDlet;
  .line 187
    return-void
.end method
