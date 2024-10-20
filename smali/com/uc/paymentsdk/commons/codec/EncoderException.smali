.class public Lcom/uc/paymentsdk/commons/codec/EncoderException;
.super Ljava/lang/Exception;
.source "EncoderException.java"


# static fields
.field private static final serialVersionUID:J = 0x5d4c3a1c6a4ffb14L


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
