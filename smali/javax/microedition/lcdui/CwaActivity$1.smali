.class Ljavax/microedition/lcdui/CwaActivity$1;
.super Ljava/lang/Object;
.source "CwaActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljavax/microedition/lcdui/CwaActivity;->showExitDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ljavax/microedition/lcdui/CwaActivity;


# direct methods
.method constructor <init>(Ljavax/microedition/lcdui/CwaActivity;)V
    .registers 2

    .prologue
    .line 1
    iput-object p1, p0, Ljavax/microedition/lcdui/CwaActivity$1;->this$0:Ljavax/microedition/lcdui/CwaActivity;

    .line 239
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .registers 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 242
    const/4 v0, -0x1

    if-ne p2, v0, :cond_15

    .line 243
    iget-object v0, p0, Ljavax/microedition/lcdui/CwaActivity$1;->this$0:Ljavax/microedition/lcdui/CwaActivity;

    invoke-static {v0}, Ljavax/microedition/lcdui/CwaActivity;->access$0(Ljavax/microedition/lcdui/CwaActivity;)Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyDestroyed()V

    .line 244
    iget-object v0, p0, Ljavax/microedition/lcdui/CwaActivity$1;->this$0:Ljavax/microedition/lcdui/CwaActivity;

    invoke-static {v0}, Ljavax/microedition/lcdui/CwaActivity;->access$0(Ljavax/microedition/lcdui/CwaActivity;)Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyExit()V

    .line 246
    :cond_15
    return-void
.end method
