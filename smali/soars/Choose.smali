.class public Lsoars/Choose;
.super Landroid/app/Activity;
.source "Choose.java"

.field private btn:Landroid/widget/Button;

.field private btn2:Landroid/widget/Button;

.method public constructor <init>()V
  .registers 2
  .prologue
    const/4 v0, 0
  .line 14
    invoke-direct { p0 }, Landroid/app/Activity;-><init>()V
  .line 15
    iput-object v0, p0, Lsoars/Choose;->btn:Landroid/widget/Button;
  .line 16
    iput-object v0, p0, Lsoars/Choose;->btn2:Landroid/widget/Button;
  .line 14
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
  .parameter "savedInstanceState" # Landroid/os/Bundle;
  .registers 4
  .prologue
  .line 33
    invoke-super { p0, p1 }, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V
  .line 36
    const/high16 v0, 32515
    invoke-virtual { p0, v0 }, Lsoars/Choose;->setContentView(I)V
  .line 38
    const/high16 v0, 32518
    invoke-virtual { p0, v0 }, Lsoars/Choose;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/Button;
    iput-object v0, p0, Lsoars/Choose;->btn:Landroid/widget/Button;
  .line 39
    const v0, 2131099649
    invoke-virtual { p0, v0 }, Lsoars/Choose;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/Button;
    iput-object v0, p0, Lsoars/Choose;->btn2:Landroid/widget/Button;
  .line 41
    iget-object v0, p0, Lsoars/Choose;->btn:Landroid/widget/Button;
    new-instance v1, Lsoars/Choose$1;
    invoke-direct { v1, p0 }, Lsoars/Choose$1;-><init>(Lsoars/Choose;)V
    invoke-virtual { v0, v1 }, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
  .line 54
    iget-object v0, p0, Lsoars/Choose;->btn2:Landroid/widget/Button;
    new-instance v1, Lsoars/Choose$2;
    invoke-direct { v1, p0 }, Lsoars/Choose$2;-><init>(Lsoars/Choose;)V
    invoke-virtual { v0, v1 }, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
  .line 63
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
  .parameter "keyCode" # I
  .parameter "event" # Landroid/view/KeyEvent;
  .registers 5
  .prologue
  .line 19
    packed-switch p1, :L2
  .line 26
    invoke-super { p0, p1, p2 }, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z
    move-result v0
  :L0
    return v0
  :L1
  .line 21
    sget-object v0, Lcom/PetKing5_480x800/PetKing5;->gr:Lmain/GameRun;
    sget-object v1, Lcom/PetKing5_480x800/PetKing5;->gr:Lmain/GameRun;
    invoke-static { v1 }, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;
    sget-byte v1, Lmain/SMSSender;->smsType:B
    invoke-virtual { v0, v1 }, Lmain/GameRun;->falselly(I)V
  .line 22
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;
    const-string v1, "\u6211\u7684"
    invoke-virtual { v0, v1 }, Ljava/io/PrintStream;->println(Ljava/lang/String;)V
  .line 23
    invoke-virtual { p0 }, Lsoars/Choose;->getParent()Landroid/app/Activity;
    move-result-object v0
    invoke-virtual { p0, v0 }, Lsoars/Choose;->finishFromChild(Landroid/app/Activity;)V
  .line 24
    const/4 v0, 1
    goto :L0
  .line 19
  :L2
  .packed-switch 4
    :L1
  .end packed-switch
.end method
