.class Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;
.super Ljava/lang/Object;
.source "TitleSpinner.java"

# interfaces
.implements Landroid/widget/ListAdapter;
.implements Landroid/widget/SpinnerAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uc/paymentsdk/commons/ui/TitleSpinner;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DropDownAdapter"
.end annotation


# instance fields
.field private mAdapter:Landroid/widget/SpinnerAdapter;

.field private mListAdapter:Landroid/widget/ListAdapter;


# direct methods
.method public constructor <init>(Landroid/widget/SpinnerAdapter;)V
    .registers 3
    .param p1, "paramSpinnerAdapter"    # Landroid/widget/SpinnerAdapter;

    .prologue
    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    iput-object p1, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    .line 100
    instance-of v0, p1, Landroid/widget/SpinnerAdapter;

    if-eqz v0, :cond_d

    .line 101
    check-cast p1, Landroid/widget/ListAdapter;

    .end local p1    # "paramSpinnerAdapter":Landroid/widget/SpinnerAdapter;
    iput-object p1, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mListAdapter:Landroid/widget/ListAdapter;

    .line 102
    :cond_d
    return-void
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .registers 3

    .prologue
    .line 157
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mListAdapter:Landroid/widget/ListAdapter;

    .line 158
    .local v0, "localListAdapter":Landroid/widget/ListAdapter;
    if-eqz v0, :cond_9

    .line 159
    invoke-interface {v0}, Landroid/widget/ListAdapter;->areAllItemsEnabled()Z

    move-result v1

    .line 160
    :goto_8
    return v1

    :cond_9
    const/4 v1, 0x1

    goto :goto_8
.end method

.method public getCount()I
    .registers 2

    .prologue
    .line 107
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return v0

    :cond_6
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v0}, Landroid/widget/SpinnerAdapter;->getCount()I

    move-result v0

    goto :goto_5
.end method

.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 5
    .param p1, "paramInt"    # I
    .param p2, "paramView"    # Landroid/view/View;
    .param p3, "paramViewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return-object v0

    :cond_6
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v0, p1, p2, p3}, Landroid/widget/SpinnerAdapter;->getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_5
.end method

.method public getItem(I)Ljava/lang/Object;
    .registers 3
    .param p1, "paramInt"    # I

    .prologue
    .line 113
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return-object v0

    :cond_6
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v0, p1}, Landroid/widget/SpinnerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_5
.end method

.method public getItemId(I)J
    .registers 4
    .param p1, "paramInt"    # I

    .prologue
    .line 119
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-nez v0, :cond_7

    const-wide/16 v0, -0x1

    :goto_6
    return-wide v0

    :cond_7
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v0, p1}, Landroid/widget/SpinnerAdapter;->getItemId(I)J

    move-result-wide v0

    goto :goto_6
.end method

.method public getItemViewType(I)I
    .registers 3
    .param p1, "paramInt"    # I

    .prologue
    .line 175
    const/4 v0, 0x0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 5
    .param p1, "paramInt"    # I
    .param p2, "paramView"    # Landroid/view/View;
    .param p3, "paramViewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 125
    invoke-virtual {p0, p1, p2, p3}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getViewTypeCount()I
    .registers 2

    .prologue
    .line 181
    const/4 v0, 0x1

    return v0
.end method

.method public hasStableIds()Z
    .registers 2

    .prologue
    .line 137
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-eqz v0, :cond_e

    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v0}, Landroid/widget/SpinnerAdapter;->hasStableIds()Z

    move-result v0

    if-eqz v0, :cond_e

    const/4 v0, 0x1

    :goto_d
    return v0

    :cond_e
    const/4 v0, 0x0

    goto :goto_d
.end method

.method public isEmpty()Z
    .registers 2

    .prologue
    .line 187
    invoke-virtual {p0}, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->getCount()I

    move-result v0

    if-nez v0, :cond_8

    const/4 v0, 0x1

    :goto_7
    return v0

    :cond_8
    const/4 v0, 0x0

    goto :goto_7
.end method

.method public isEnabled(I)Z
    .registers 4
    .param p1, "paramInt"    # I

    .prologue
    .line 166
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mListAdapter:Landroid/widget/ListAdapter;

    .line 167
    .local v0, "localListAdapter":Landroid/widget/ListAdapter;
    if-eqz v0, :cond_9

    .line 168
    invoke-interface {v0, p1}, Landroid/widget/ListAdapter;->isEnabled(I)Z

    move-result v1

    .line 169
    :goto_8
    return v1

    :cond_9
    const/4 v1, 0x1

    goto :goto_8
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .registers 3
    .param p1, "paramDataSetObserver"    # Landroid/database/DataSetObserver;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-eqz v0, :cond_9

    .line 144
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v0, p1}, Landroid/widget/SpinnerAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 145
    :cond_9
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .registers 3
    .param p1, "paramDataSetObserver"    # Landroid/database/DataSetObserver;

    .prologue
    .line 150
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    if-eqz v0, :cond_9

    .line 151
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;

    invoke-interface {v0, p1}, Landroid/widget/SpinnerAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 152
    :cond_9
    return-void
.end method
