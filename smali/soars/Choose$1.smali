.class Lsoars/Choose$1;
.super Ljava/lang/Object;
.source "Choose.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsoars/Choose;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lsoars/Choose;


# direct methods
.method constructor <init>(Lsoars/Choose;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lsoars/Choose$1;->this$0:Lsoars/Choose;

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 49
    sget-object v0, Lmain/SMSSender;->smsSender:Lmain/SMSSender;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lmain/SMSSender;->setSmsValue(I)V

    .line 50
    iget-object v0, p0, Lsoars/Choose$1;->this$0:Lsoars/Choose;

    iget-object v1, p0, Lsoars/Choose$1;->this$0:Lsoars/Choose;

    invoke-virtual {v1}, Lsoars/Choose;->getParent()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v0, v1}, Lsoars/Choose;->finishFromChild(Landroid/app/Activity;)V

    .line 52
    return-void
.end method
