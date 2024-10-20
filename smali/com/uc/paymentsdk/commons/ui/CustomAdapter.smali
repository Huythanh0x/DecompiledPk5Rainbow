.class public Lcom/uc/paymentsdk/commons/ui/CustomAdapter;
.super Landroid/widget/BaseAdapter;
.source "CustomAdapter.java"


# static fields
.field private static sIcon:Landroid/graphics/drawable/Drawable;


# instance fields
.field private mContext:Landroid/content/Context;

.field private mItems:[Lcom/uc/paymentsdk/model/IType;


# direct methods
.method public constructor <init>(Landroid/content/Context;[Lcom/uc/paymentsdk/model/IType;)V
    .registers 4
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paramArrayOfIType"    # [Lcom/uc/paymentsdk/model/IType;

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mContext:Landroid/content/Context;

    .line 21
    iput-object p2, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mItems:[Lcom/uc/paymentsdk/model/IType;

    .line 22
    sget-object v0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->sIcon:Landroid/graphics/drawable/Drawable;

    if-nez v0, :cond_13

    .line 23
    const-string v0, "more.png"

    invoke-static {v0}, Lcom/uc/paymentsdk/util/Utils;->getDrawableFromFile(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    sput-object v0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->sIcon:Landroid/graphics/drawable/Drawable;

    .line 24
    :cond_13
    return-void
.end method


# virtual methods
.method public getCount()I
    .registers 2

    .prologue
    .line 41
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mItems:[Lcom/uc/paymentsdk/model/IType;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return v0

    :cond_6
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mItems:[Lcom/uc/paymentsdk/model/IType;

    array-length v0, v0

    goto :goto_5
.end method

.method public getItem(I)Lcom/uc/paymentsdk/model/IType;
    .registers 3
    .param p1, "paramInt"    # I

    .prologue
    .line 46
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mItems:[Lcom/uc/paymentsdk/model/IType;

    if-nez v0, :cond_6

    const/4 v0, 0x0

    :goto_5
    return-object v0

    :cond_6
    iget-object v0, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mItems:[Lcom/uc/paymentsdk/model/IType;

    aget-object v0, v0, p1

    goto :goto_5
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .registers 3

    .prologue
    .line 1
    invoke-virtual {p0, p1}, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->getItem(I)Lcom/uc/paymentsdk/model/IType;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .registers 4
    .param p1, "paramInt"    # I

    .prologue
    .line 51
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .registers 8
    .param p1, "paramInt"    # I
    .param p2, "paramView"    # Landroid/view/View;
    .param p3, "paramViewGroup"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v3, 0x0

    .line 28
    new-instance v0, Lcom/uc/paymentsdk/commons/ui/CustomTextView;

    iget-object v1, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, Lcom/uc/paymentsdk/commons/ui/CustomTextView;-><init>(Landroid/content/Context;I)V

    .line 30
    .local v0, "localCustomTextView":Lcom/uc/paymentsdk/commons/ui/CustomTextView;
    const v1, -0xbbbbbc

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/commons/ui/CustomTextView;->setTextColor(I)V

    .line 31
    iget-object v1, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mItems:[Lcom/uc/paymentsdk/model/IType;

    aget-object v1, v1, p1

    .line 32
    invoke-interface {v1}, Lcom/uc/paymentsdk/model/IType;->getDesc()Ljava/lang/String;

    move-result-object v1

    .line 31
    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/commons/ui/CustomTextView;->setText(Ljava/lang/CharSequence;)V

    .line 33
    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/commons/ui/CustomTextView;->setCompoundDrawablePadding(I)V

    .line 35
    iget-object v1, p0, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->mItems:[Lcom/uc/paymentsdk/model/IType;

    aget-object v1, v1, p1

    invoke-interface {v1}, Lcom/uc/paymentsdk/model/IType;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    sget-object v2, Lcom/uc/paymentsdk/commons/ui/CustomAdapter;->sIcon:Landroid/graphics/drawable/Drawable;

    .line 34
    invoke-virtual {v0, v1, v3, v2, v3}, Lcom/uc/paymentsdk/commons/ui/CustomTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 36
    return-object v0
.end method
