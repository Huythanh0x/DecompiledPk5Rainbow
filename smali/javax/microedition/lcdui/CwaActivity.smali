.class public Ljavax/microedition/lcdui/CwaActivity;
.super Landroid/app/Activity;
.source "CwaActivity.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "CwaActivity"

.field private static final MIN_HEAP_SIZE:I = 0xc00000

.field private static final TARGET_HEAP_UTILIZATION:F = 0.75f

.field private static context:Landroid/content/Context;

.field private static curCanvas:Ljavax/microedition/lcdui/Canvas;

.field private static cwaActivity:Ljavax/microedition/lcdui/CwaActivity;


# instance fields
.field public audioManager:Landroid/media/AudioManager;

.field private isFullWindow:Z

.field private jam:Ljavax/microedition/midlet/MIDletManager;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 37
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 23
    invoke-static {}, Ljavax/microedition/midlet/MIDletManager;->getInstance()Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    iput-object v0, p0, Ljavax/microedition/lcdui/CwaActivity;->jam:Ljavax/microedition/midlet/MIDletManager;

    .line 32
    const/4 v0, 0x0

    iput-boolean v0, p0, Ljavax/microedition/lcdui/CwaActivity;->isFullWindow:Z

    .line 38
    sget-object v0, Ljavax/microedition/lcdui/CwaActivity;->cwaActivity:Ljavax/microedition/lcdui/CwaActivity;

    if-nez v0, :cond_0

    .line 39
    sput-object p0, Ljavax/microedition/lcdui/CwaActivity;->cwaActivity:Ljavax/microedition/lcdui/CwaActivity;

    .line 41
    :cond_0
    return-void
.end method

.method static synthetic access$0(Ljavax/microedition/lcdui/CwaActivity;)Ljavax/microedition/midlet/MIDletManager;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Ljavax/microedition/lcdui/CwaActivity;->jam:Ljavax/microedition/midlet/MIDletManager;

    return-object v0
.end method

.method public static getContextInstance()Landroid/content/Context;
    .locals 1

    .prologue
    .line 70
    sget-object v0, Ljavax/microedition/lcdui/CwaActivity;->context:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 71
    sget-object v0, Ljavax/microedition/lcdui/CwaActivity;->cwaActivity:Ljavax/microedition/lcdui/CwaActivity;

    invoke-virtual {v0}, Ljavax/microedition/lcdui/CwaActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    sput-object v0, Ljavax/microedition/lcdui/CwaActivity;->context:Landroid/content/Context;

    .line 72
    :cond_0
    sget-object v0, Ljavax/microedition/lcdui/CwaActivity;->context:Landroid/content/Context;

    return-object v0
.end method

.method public static getInstance()Ljavax/microedition/lcdui/CwaActivity;
    .locals 1

    .prologue
    .line 62
    sget-object v0, Ljavax/microedition/lcdui/CwaActivity;->cwaActivity:Ljavax/microedition/lcdui/CwaActivity;

    return-object v0
.end method

.method private initActivity()V
    .locals 4

    .prologue
    const/16 v3, 0x80

    .line 106
    invoke-static {}, Ldalvik/system/VMRuntime;->getRuntime()Ldalvik/system/VMRuntime;

    move-result-object v0

    const-wide/32 v1, 0xc00000

    invoke-virtual {v0, v1, v2}, Ldalvik/system/VMRuntime;->setMinimumHeapSize(J)J

    .line 107
    invoke-static {}, Ldalvik/system/VMRuntime;->getRuntime()Ldalvik/system/VMRuntime;

    move-result-object v0

    const/high16 v1, 0x3f400000    # 0.75f

    invoke-virtual {v0, v1}, Ldalvik/system/VMRuntime;->setTargetHeapUtilization(F)F

    .line 110
    invoke-virtual {p0}, Ljavax/microedition/lcdui/CwaActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v3, v3}, Landroid/view/Window;->setFlags(II)V

    .line 111
    return-void
.end method

.method private killBackgroundProcess()V
    .locals 7

    .prologue
    .line 47
    const-string v4, "activity"

    invoke-virtual {p0, v4}, Ljavax/microedition/lcdui/CwaActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 48
    .local v0, "activityManager":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v1

    .line 49
    .local v1, "apps":Ljava/util/List;, "Ljava/util/List<Landroid/app/ActivityManager$RunningAppProcessInfo;>;"
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v2

    .line 50
    .local v2, "mypid":I
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_1

    .line 55
    return-void

    .line 50
    :cond_1
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/ActivityManager$RunningAppProcessInfo;

    .line 51
    .local v3, "runningAppProcessInfo":Landroid/app/ActivityManager$RunningAppProcessInfo;
    iget v5, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    if-eq v5, v2, :cond_0

    iget v5, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->importance:I

    const/16 v6, 0x12c

    if-le v5, v6, :cond_0

    .line 52
    iget v5, v3, Landroid/app/ActivityManager$RunningAppProcessInfo;->pid:I

    invoke-static {v5}, Landroid/os/Process;->killProcess(I)V

    goto :goto_0
.end method

.method private setFullScreen()V
    .locals 2

    .prologue
    const/16 v1, 0x400

    .line 96
    invoke-virtual {p0}, Ljavax/microedition/lcdui/CwaActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    .line 98
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/CwaActivity;->requestWindowFeature(I)Z

    .line 99
    return-void
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 209
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 218
    invoke-super {p0, p1}, Landroid/app/Activity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    :goto_0
    return v0

    .line 214
    :sswitch_0
    const/4 v0, 0x1

    goto :goto_0

    .line 209
    :sswitch_data_0
    .sparse-switch
        0x1b -> :sswitch_0
        0x50 -> :sswitch_0
    .end sparse-switch
.end method

.method public getCanvas()Ljavax/microedition/lcdui/Canvas;
    .locals 1

    .prologue
    .line 88
    sget-object v0, Ljavax/microedition/lcdui/CwaActivity;->curCanvas:Ljavax/microedition/lcdui/Canvas;

    return-object v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 133
    invoke-super {p0, p1}, Landroid/app/Activity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 134
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 139
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 140
    invoke-direct {p0}, Ljavax/microedition/lcdui/CwaActivity;->killBackgroundProcess()V

    .line 141
    invoke-direct {p0}, Ljavax/microedition/lcdui/CwaActivity;->initActivity()V

    .line 142
    const-string v0, "audio"

    invoke-virtual {p0, v0}, Ljavax/microedition/lcdui/CwaActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Ljavax/microedition/lcdui/CwaActivity;->audioManager:Landroid/media/AudioManager;

    .line 143
    iget-boolean v0, p0, Ljavax/microedition/lcdui/CwaActivity;->isFullWindow:Z

    if-eqz v0, :cond_0

    .line 144
    invoke-direct {p0}, Ljavax/microedition/lcdui/CwaActivity;->setFullScreen()V

    .line 151
    :cond_0
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 199
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 200
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 201
    invoke-static {}, Landroid/os/Process;->myPid()I

    move-result v0

    invoke-static {v0}, Landroid/os/Process;->killProcess(I)V

    .line 202
    return-void
.end method

.method public onLowMemory()V
    .locals 0

    .prologue
    .line 115
    invoke-direct {p0}, Ljavax/microedition/lcdui/CwaActivity;->killBackgroundProcess()V

    .line 116
    invoke-super {p0}, Landroid/app/Activity;->onLowMemory()V

    .line 117
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 180
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 181
    iget-object v0, p0, Ljavax/microedition/lcdui/CwaActivity;->jam:Ljavax/microedition/midlet/MIDletManager;

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyPaused()V

    .line 182
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 189
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 190
    iget-object v0, p0, Ljavax/microedition/lcdui/CwaActivity;->jam:Ljavax/microedition/midlet/MIDletManager;

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyResumed()V

    .line 191
    return-void
.end method

.method public setCanvas(Ljavax/microedition/lcdui/Canvas;)V
    .locals 0
    .param p1, "canvas"    # Ljavax/microedition/lcdui/Canvas;

    .prologue
    .line 80
    sput-object p1, Ljavax/microedition/lcdui/CwaActivity;->curCanvas:Ljavax/microedition/lcdui/Canvas;

    .line 81
    return-void
.end method

.method public setContentView()V
    .locals 2

    .prologue
    .line 166
    sget-object v0, Ljavax/microedition/lcdui/CwaActivity;->curCanvas:Ljavax/microedition/lcdui/Canvas;

    if-eqz v0, :cond_0

    .line 167
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v0

    sget-object v1, Ljavax/microedition/lcdui/CwaActivity;->curCanvas:Ljavax/microedition/lcdui/Canvas;

    invoke-virtual {v0, v1}, Ljavax/microedition/lcdui/CwaActivity;->setContentView(Landroid/view/View;)V

    .line 171
    :goto_0
    return-void

    .line 169
    :cond_0
    const-string v0, "CwaActivity"

    const-string v1, "current canvas is null"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public setFullWindow(Z)V
    .locals 0
    .param p1, "mode"    # Z

    .prologue
    .line 124
    iput-boolean p1, p0, Ljavax/microedition/lcdui/CwaActivity;->isFullWindow:Z

    .line 125
    return-void
.end method

.method protected setMIDlet(Ljavax/microedition/midlet/MIDlet;)V
    .locals 1
    .param p1, "midlet"    # Ljavax/microedition/midlet/MIDlet;

    .prologue
    .line 158
    iget-object v0, p0, Ljavax/microedition/lcdui/CwaActivity;->jam:Ljavax/microedition/midlet/MIDletManager;

    invoke-virtual {v0, p1}, Ljavax/microedition/midlet/MIDletManager;->setMIDlet(Ljavax/microedition/midlet/MIDlet;)V

    .line 159
    return-void
.end method

.method public showExitDialog()V
    .locals 3

    .prologue
    .line 238
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const-string v1, "\u786e\u8ba4\u9000\u51fa\uff1f"

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 239
    const-string v1, "\u662f"

    new-instance v2, Ljavax/microedition/lcdui/CwaActivity$1;

    invoke-direct {v2, p0}, Ljavax/microedition/lcdui/CwaActivity$1;-><init>(Ljavax/microedition/lcdui/CwaActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 247
    const-string v1, "\u5426"

    new-instance v2, Ljavax/microedition/lcdui/CwaActivity$2;

    invoke-direct {v2, p0}, Ljavax/microedition/lcdui/CwaActivity$2;-><init>(Ljavax/microedition/lcdui/CwaActivity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 253
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 254
    return-void
.end method
