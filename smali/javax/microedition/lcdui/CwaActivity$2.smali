.class Ljavax/microedition/lcdui/CwaActivity$2;
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
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Ljavax/microedition/lcdui/CwaActivity$2;->this$0:Ljavax/microedition/lcdui/CwaActivity;

    .line 247
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 250
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 251
    iget-object v0, p0, Ljavax/microedition/lcdui/CwaActivity$2;->this$0:Ljavax/microedition/lcdui/CwaActivity;

    invoke-static {v0}, Ljavax/microedition/lcdui/CwaActivity;->access$0(Ljavax/microedition/lcdui/CwaActivity;)Ljavax/microedition/midlet/MIDletManager;

    move-result-object v0

    invoke-virtual {v0}, Ljavax/microedition/midlet/MIDletManager;->notifyResumed()V

    .line 252
    return-void
.end method
