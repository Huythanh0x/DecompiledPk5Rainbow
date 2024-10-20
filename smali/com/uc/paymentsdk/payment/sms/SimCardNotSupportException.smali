.class public Lcom/uc/paymentsdk/payment/sms/SimCardNotSupportException;
.super Ljava/lang/Exception;
.source "SimCardNotSupportException.java"


# static fields
.field private static final serialVersionUID:J = 0x1ed81e04bccb132L


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .registers 2
    .param p1, "paramString"    # Ljava/lang/String;

    .prologue
    .line 9
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 10
    return-void
.end method
