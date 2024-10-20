.class Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;
.super Ljava/lang/Object;
.implements Landroid/widget/ListAdapter;
.implements Landroid/widget/SpinnerAdapter;
.source "TitleSpinner.java"

.annotation system Ldalvik/annotation/EnclosingClass;
  value = Lcom/uc/paymentsdk/commons/ui/TitleSpinner;
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 10
  name = "DropDownAdapter"
.end annotation

.field private mAdapter:Landroid/widget/SpinnerAdapter;

.field private mListAdapter:Landroid/widget/ListAdapter;

.method public constructor <init>(Landroid/widget/SpinnerAdapter;)V
  .parameter "paramSpinnerAdapter" # Landroid/widget/SpinnerAdapter;
  .registers 3
  .prologue
  .line 97
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 99
    iput-object p1, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
  .line 100
    instance-of v0, p1, Landroid/widget/SpinnerAdapter;
    if-eqz v0, :L0
  .line 101
    check-cast p1, Landroid/widget/ListAdapter;
  .end local p1
    iput-object p1, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mListAdapter:Landroid/widget/ListAdapter;
  :L0
  .line 102
    return-void
.end method

.method public areAllItemsEnabled()Z
  .registers 3
  .prologue
  .line 157
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mListAdapter:Landroid/widget/ListAdapter;
  .line 158
  .local v0, "localListAdapter":Landroid/widget/ListAdapter;
    if-eqz v0, :L1
  .line 159
    invoke-interface { v0 }, Landroid/widget/ListAdapter;->areAllItemsEnabled()Z
    move-result v1
  :L0
  .line 160
    return v1
  :L1
    const/4 v1, 1
    goto :L0
.end method

.method public getCount()I
  .registers 2
  .prologue
  .line 107
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    if-nez v0, :L1
    const/4 v0, 0
  :L0
    return v0
  :L1
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    invoke-interface { v0 }, Landroid/widget/SpinnerAdapter;->getCount()I
    move-result v0
    goto :L0
.end method

.method public getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
  .parameter "paramInt" # I
  .parameter "paramView" # Landroid/view/View;
  .parameter "paramViewGroup" # Landroid/view/ViewGroup;
  .registers 5
  .prologue
  .line 131
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    if-nez v0, :L1
    const/4 v0, 0
  :L0
    return-object v0
  :L1
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    invoke-interface { v0, p1, p2, p3 }, Landroid/widget/SpinnerAdapter;->getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v0
    goto :L0
.end method

.method public getItem(I)Ljava/lang/Object;
  .parameter "paramInt" # I
  .registers 3
  .prologue
  .line 113
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    if-nez v0, :L1
    const/4 v0, 0
  :L0
    return-object v0
  :L1
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    invoke-interface { v0, p1 }, Landroid/widget/SpinnerAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v0
    goto :L0
.end method

.method public getItemId(I)J
  .parameter "paramInt" # I
  .registers 4
  .prologue
  .line 119
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    if-nez v0, :L1
    const-wide/16 v0, -1
  :L0
    return-wide v0
  :L1
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    invoke-interface { v0, p1 }, Landroid/widget/SpinnerAdapter;->getItemId(I)J
    move-result-wide v0
    goto :L0
.end method

.method public getItemViewType(I)I
  .parameter "paramInt" # I
  .registers 3
  .prologue
  .line 175
    const/4 v0, 0
    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
  .parameter "paramInt" # I
  .parameter "paramView" # Landroid/view/View;
  .parameter "paramViewGroup" # Landroid/view/ViewGroup;
  .registers 5
  .prologue
  .line 125
    invoke-virtual { p0, p1, p2, p3 }, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->getDropDownView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method public getViewTypeCount()I
  .registers 2
  .prologue
  .line 181
    const/4 v0, 1
    return v0
.end method

.method public hasStableIds()Z
  .registers 2
  .prologue
  .line 137
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    if-eqz v0, :L1
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    invoke-interface { v0 }, Landroid/widget/SpinnerAdapter;->hasStableIds()Z
    move-result v0
    if-eqz v0, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public isEmpty()Z
  .registers 2
  .prologue
  .line 187
    invoke-virtual { p0 }, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->getCount()I
    move-result v0
    if-nez v0, :L1
    const/4 v0, 1
  :L0
    return v0
  :L1
    const/4 v0, 0
    goto :L0
.end method

.method public isEnabled(I)Z
  .parameter "paramInt" # I
  .registers 4
  .prologue
  .line 166
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mListAdapter:Landroid/widget/ListAdapter;
  .line 167
  .local v0, "localListAdapter":Landroid/widget/ListAdapter;
    if-eqz v0, :L1
  .line 168
    invoke-interface { v0, p1 }, Landroid/widget/ListAdapter;->isEnabled(I)Z
    move-result v1
  :L0
  .line 169
    return v1
  :L1
    const/4 v1, 1
    goto :L0
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
  .parameter "paramDataSetObserver" # Landroid/database/DataSetObserver;
  .registers 3
  .prologue
  .line 143
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    if-eqz v0, :L0
  .line 144
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    invoke-interface { v0, p1 }, Landroid/widget/SpinnerAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V
  :L0
  .line 145
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
  .parameter "paramDataSetObserver" # Landroid/database/DataSetObserver;
  .registers 3
  .prologue
  .line 150
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    if-eqz v0, :L0
  .line 151
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/TitleSpinner$DropDownAdapter;->mAdapter:Landroid/widget/SpinnerAdapter;
    invoke-interface { v0, p1 }, Landroid/widget/SpinnerAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
  :L0
  .line 152
    return-void
.end method
