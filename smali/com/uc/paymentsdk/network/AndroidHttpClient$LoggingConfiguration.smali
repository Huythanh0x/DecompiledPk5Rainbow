.class Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;
.super Ljava/lang/Object;
.source "AndroidHttpClient.java"

.annotation system Ldalvik/annotation/EnclosingClass;
  value = Lcom/uc/paymentsdk/network/AndroidHttpClient;
.end annotation
.annotation system Ldalvik/annotation/InnerClass;
  accessFlags = 10
  name = "LoggingConfiguration"
.end annotation

.field private final level:I

.field private final tag:Ljava/lang/String;

.method private constructor <init>(Ljava/lang/String;I)V
  .parameter "paramString" # Ljava/lang/String;
  .parameter "paramInt" # I
  .registers 3
  .prologue
  .line 405
    invoke-direct { p0 }, Ljava/lang/Object;-><init>()V
  .line 407
    iput-object p1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->tag:Ljava/lang/String;
  .line 408
    iput p2, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->level:I
  .line 409
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;)V
  .registers 4
  .prologue
  .line 405
    invoke-direct { p0, p1, p2 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;-><init>(Ljava/lang/String;I)V
    return-void
.end method

.method static synthetic access$0(Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;)Z
  .registers 2
  .prologue
  .line 411
    invoke-direct { p0 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->isLoggable()Z
    move-result v0
    return v0
.end method

.method static synthetic access$1(Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;Ljava/lang/String;)V
  .registers 2
  .prologue
  .line 416
    invoke-direct { p0, p1 }, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->println(Ljava/lang/String;)V
    return-void
.end method

.method private isLoggable()Z
  .registers 3
  .prologue
  .line 413
    iget-object v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->tag:Ljava/lang/String;
    iget v1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->level:I
    invoke-static { v0, v1 }, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z
    move-result v0
    return v0
.end method

.method private println(Ljava/lang/String;)V
  .parameter "paramString" # Ljava/lang/String;
  .registers 4
  .prologue
  .line 418
    iget v0, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->level:I
    iget-object v1, p0, Lcom/uc/paymentsdk/network/AndroidHttpClient$LoggingConfiguration;->tag:Ljava/lang/String;
    invoke-static { v0, v1, p1 }, Landroid/util/Log;->println(ILjava/lang/String;Ljava/lang/String;)I
  .line 419
    return-void
.end method
