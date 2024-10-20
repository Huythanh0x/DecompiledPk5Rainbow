.class public Lsoars/Choose;
.super Landroid/app/Activity;
.source "Choose.java"


# instance fields
.field private btn:Landroid/widget/Button;

.field private btn2:Landroid/widget/Button;


# direct methods
.method public constructor <init>()V
    .registers 2

    .prologue
    const/4 v0, 0x0

    .line 14
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 15
    iput-object v0, p0, Lsoars/Choose;->btn:Landroid/widget/Button;

    .line 16
    iput-object v0, p0, Lsoars/Choose;->btn2:Landroid/widget/Button;

    .line 14
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .registers 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 36
    const/high16 v0, 0x7f030000

    invoke-virtual {p0, v0}, Lsoars/Choose;->setContentView(I)V

    .line 38
    const/high16 v0, 0x7f060000

    invoke-virtual {p0, v0}, Lsoars/Choose;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lsoars/Choose;->btn:Landroid/widget/Button;

    .line 39
    const v0, 0x7f060001

    invoke-virtual {p0, v0}, Lsoars/Choose;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lsoars/Choose;->btn2:Landroid/widget/Button;

    .line 41
    iget-object v0, p0, Lsoars/Choose;->btn:Landroid/widget/Button;

    new-instance v1, Lsoars/Choose$1;

    invoke-direct {v1, p0}, Lsoars/Choose$1;-><init>(Lsoars/Choose;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 54
    iget-object v0, p0, Lsoars/Choose;->btn2:Landroid/widget/Button;

    new-instance v1, Lsoars/Choose$2;

    invoke-direct {v1, p0}, Lsoars/Choose$2;-><init>(Lsoars/Choose;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .registers 5
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 19
    packed-switch p1, :pswitch_data_24

    .line 26
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    :goto_7
    return v0

    .line 21
    :pswitch_8
    sget-object v0, Lcom/PetKing5_480x800/PetKing5;->gr:Lmain/GameRun;

    sget-object v1, Lcom/PetKing5_480x800/PetKing5;->gr:Lmain/GameRun;

    invoke-static {v1}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    sget-byte v1, Lmain/SMSSender;->smsType:B

    invoke-virtual {v0, v1}, Lmain/GameRun;->falselly(I)V

    .line 22
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v1, "\u6211\u7684"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 23
    invoke-virtual {p0}, Lsoars/Choose;->getParent()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {p0, v0}, Lsoars/Choose;->finishFromChild(Landroid/app/Activity;)V

    .line 24
    const/4 v0, 0x1

    goto :goto_7

    .line 19
    :pswitch_data_24
    .packed-switch 0x4
        :pswitch_8
    .end packed-switch
.end method
