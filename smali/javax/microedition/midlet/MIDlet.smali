.class public abstract Ljavax/microedition/midlet/MIDlet;
.super Ljava/lang/Object;
.source "MIDlet.java"


# direct methods
.method protected constructor <init>()V
    .registers 1

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    return-void
.end method


# virtual methods
.method protected abstract destroyApp(Z)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/microedition/midlet/MIDletStateChangeException;
        }
    .end annotation
.end method

.method public final getAppProperty(Ljava/lang/String;)Ljava/lang/String;
    .registers 3
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-static {}, Ljavax/microedition/midlet/MIDletManager;->getInstance()Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Ljavax/microedition/midlet/MIDletManager;->getAppProperty(Ljavax/microedition/midlet/MIDlet;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final notifyDestroyed()V
    .registers 2

    .prologue
    .line 25
    invoke-static {}, Ljavax/microedition/midlet/MIDletManager;->getInstance()Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyDestroyed()V

    .line 26
    invoke-static {}, Ljavax/microedition/midlet/MIDletManager;->getInstance()Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyExit()V

    .line 27
    return-void
.end method

.method public final notifyPaused()V
    .registers 2

    .prologue
    .line 30
    invoke-static {}, Ljavax/microedition/midlet/MIDletManager;->getInstance()Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyPaused()V

    .line 31
    return-void
.end method

.method protected abstract pauseApp()V
.end method

.method public final platformRequest(Ljava/lang/String;)Z
    .registers 6
    .param p1, "URL"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/microedition/io/ConnectionNotFoundException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 39
    const-string v2, "http://"

    invoke-virtual {p1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1d

    .line 40
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 41
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 42
    .local v0, "it":Landroid/content/Intent;
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljavax/microedition/lcdui/CwaActivity;->startActivity(Landroid/content/Intent;)V

    move v2, v3

    .line 48
    :goto_1c
    return v2

    .line 44
    .end local v0    # "it":Landroid/content/Intent;
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_1d
    const-string v2, "tel:"

    invoke-virtual {p1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_39

    .line 45
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 46
    .restart local v1    # "uri":Landroid/net/Uri;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.DIAL"

    invoke-direct {v0, v2, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 47
    .restart local v0    # "it":Landroid/content/Intent;
    invoke-static {}, Ljavax/microedition/lcdui/CwaActivity;->getInstance()Ljavax/microedition/lcdui/CwaActivity;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljavax/microedition/lcdui/CwaActivity;->startActivity(Landroid/content/Intent;)V

    move v2, v3

    .line 48
    goto :goto_1c

    .line 50
    .end local v0    # "it":Landroid/content/Intent;
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_39
    new-instance v2, Ljavax/microedition/io/ConnectionNotFoundException;

    invoke-direct {v2, p1}, Ljavax/microedition/io/ConnectionNotFoundException;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public resumeRequest()V
    .registers 2

    .prologue
    .line 54
    invoke-static {}, Ljavax/microedition/midlet/MIDletManager;->getInstance()Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyResumed()V

    .line 55
    return-void
.end method

.method protected abstract startApp()V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljavax/microedition/midlet/MIDletStateChangeException;
        }
    .end annotation
.end method
