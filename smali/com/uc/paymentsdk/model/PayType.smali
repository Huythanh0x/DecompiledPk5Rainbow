.class public Lcom/uc/paymentsdk/model/PayType;
.super Lcom/uc/paymentsdk/model/AbstractType;
.source "PayType.java"


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .registers 5
    .param p1, "paramString1"    # Ljava/lang/String;
    .param p2, "paramString2"    # Ljava/lang/String;
    .param p3, "paramString3"    # Ljava/lang/String;
    .param p4, "paramString4"    # Ljava/lang/String;

    .prologue
    .line 7
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/uc/paymentsdk/model/AbstractType;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 8
    return-void
.end method
