.class Lsoars/Choose$1;
.super Ljava/lang/Object;
.implements Landroid/view/View$OnClickListener;
.source "Choose.java"

.annotation system Ldalvik/annotation/EnclosingMethod;
  value = Lsoars/Choose;->onCreate(Landroid/os/Bundle;)V
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 0
  name = null
.end annotation

.field final synthetic this$0:Lsoars/Choose;

.method constructor <init>(Lsoars/Choose;)V
  .registers 2
  .prologue
  .line 1
    iput-object p1, p0, Lsoars/Choose$1;->this$0:Lsoars/Choose;
  .line 41
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
    return-void
.end method

.method public onClick(Landroid/view/View;)V
  .parameter "v" # Landroid/view/View;
  .registers 4
  .prologue
  .line 49
    sget-object v0, Lmain/SMSSender;->smsSender:Lmain/SMSSender;
    const/4 v1, 0
    invoke-virtual { v0, v1 }, Lmain/SMSSender;->setSmsValue(I)V
  .line 50
    iget-object v0, p0, Lsoars/Choose$1;->this$0:Lsoars/Choose;
    iget-object v1, p0, Lsoars/Choose$1;->this$0:Lsoars/Choose;
    invoke-virtual { v1 }, Lsoars/Choose;->getParent()Landroid/app/Activity;
    move-result-object v1
    invoke-virtual { v0, v1 }, Lsoars/Choose;->finishFromChild(Landroid/app/Activity;)V
  .line 52
    return-void
.end method
