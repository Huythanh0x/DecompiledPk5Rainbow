.class public abstract Lcom/uc/paymentsdk/model/AbstractType;
.super Ljava/lang/Object;
.source "AbstractType.java"

# interfaces
.implements Lcom/uc/paymentsdk/model/IType;


# instance fields
.field private mDesc:Ljava/lang/String;

.field private mIcon:Ljava/lang/ref/SoftReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/SoftReference",
            "<",
            "Landroid/graphics/drawable/Drawable;",
            ">;"
        }
    .end annotation
.end field

.field private mIconFileName:Ljava/lang/String;

.field private mId:Ljava/lang/String;

.field private mName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 7
    .param p1, "typeId"    # Ljava/lang/String;
    .param p2, "typeName"    # Ljava/lang/String;
    .param p3, "typeDesc"    # Ljava/lang/String;
    .param p4, "typeIconFileName"    # Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/uc/paymentsdk/model/AbstractType;->mId:Ljava/lang/String;

    .line 21
    iput-object p2, p0, Lcom/uc/paymentsdk/model/AbstractType;->mName:Ljava/lang/String;

    .line 22
    iput-object p3, p0, Lcom/uc/paymentsdk/model/AbstractType;->mDesc:Ljava/lang/String;

    .line 23
    iput-object p4, p0, Lcom/uc/paymentsdk/model/AbstractType;->mIconFileName:Ljava/lang/String;

    .line 24
    new-instance v0, Ljava/lang/ref/SoftReference;

    invoke-static {p4}, Lcom/uc/paymentsdk/util/Utils;->getDrawableFromFile(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/uc/paymentsdk/model/AbstractType;->mIcon:Ljava/lang/ref/SoftReference;

    .line 25
    return-void
.end method


# virtual methods
.method public getDesc()Ljava/lang/String;
    .registers 2

    .prologue
    .line 36
    iget-object v0, p0, Lcom/uc/paymentsdk/model/AbstractType;->mDesc:Ljava/lang/String;

    return-object v0
.end method

.method public getIcon()Landroid/graphics/drawable/Drawable;
    .registers 3

    .prologue
    .line 42
    iget-object v1, p0, Lcom/uc/paymentsdk/model/AbstractType;->mIcon:Ljava/lang/ref/SoftReference;

    invoke-virtual {v1}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/Drawable;

    .line 43
    .local v0, "localDrawable":Landroid/graphics/drawable/Drawable;
    if-nez v0, :cond_17

    .line 45
    iget-object v1, p0, Lcom/uc/paymentsdk/model/AbstractType;->mIconFileName:Ljava/lang/String;

    invoke-static {v1}, Lcom/uc/paymentsdk/util/Utils;->getDrawableFromFile(Ljava/lang/String;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 46
    new-instance v1, Ljava/lang/ref/SoftReference;

    invoke-direct {v1, v0}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lcom/uc/paymentsdk/model/AbstractType;->mIcon:Ljava/lang/ref/SoftReference;

    .line 48
    :cond_17
    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .registers 2

    .prologue
    .line 30
    iget-object v0, p0, Lcom/uc/paymentsdk/model/AbstractType;->mId:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .registers 2

    .prologue
    .line 54
    iget-object v0, p0, Lcom/uc/paymentsdk/model/AbstractType;->mName:Ljava/lang/String;

    return-object v0
.end method
