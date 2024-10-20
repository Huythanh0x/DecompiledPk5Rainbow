.class public Lcom/uc/paymentsdk/model/PayType;
.super Lcom/uc/paymentsdk/model/AbstractType;
.source "PayType.java"

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  .parameter "paramString1" # Ljava/lang/String;
  .parameter "paramString2" # Ljava/lang/String;
  .parameter "paramString3" # Ljava/lang/String;
  .parameter "paramString4" # Ljava/lang/String;
  .registers 5
  .prologue
  .line 7
    invoke-direct { p0, p1, p2, p3, p4 }, Lcom/uc/paymentsdk/model/AbstractType;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
  .line 8
    return-void
.end method
