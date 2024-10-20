.class Ljavax/microedition/lcdui/CwaActivity$2;
.super Ljava/lang/Object;
.implements Landroid/content/DialogInterface$OnClickListener;
.source "CwaActivity.java"

.annotation system Ldalvik/annotation/EnclosingMethod;
  value = Ljavax/microedition/lcdui/CwaActivity;->showExitDialog()V
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 0
  name = null
.end annotation

.field final synthetic this$0:Ljavax/microedition/lcdui/CwaActivity;

.method constructor <init>(Ljavax/microedition/lcdui/CwaActivity;)V
  .registers 2
  .prologue
  .line 1
    iput-object p1, p0, Ljavax/microedition/lcdui/CwaActivity$2;->this$0:Ljavax/microedition/lcdui/CwaActivity;
  .line 247
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
  .parameter "dialog" # Landroid/content/DialogInterface;
  .parameter "which" # I
  .registers 4
  .prologue
  .line 250
    invoke-interface { p1 }, Landroid/content/DialogInterface;->dismiss()V
  .line 251
    iget-object v0, p0, Ljavax/microedition/lcdui/CwaActivity$2;->this$0:Ljavax/microedition/lcdui/CwaActivity;
    invoke-static { v0 }, Ljavax/microedition/lcdui/CwaActivity;->access$0(Ljavax/microedition/lcdui/CwaActivity;)Ljavax/microedition/midlet/MIDletManager;
    move-result-object v0
    invoke-virtual { v0 }, Ljavax/microedition/midlet/MIDletManager;->notifyResumed()V
  .line 252
    return-void
.end method
