.class public Lmain/SMSSender;
.super Ljava/lang/Object;
.source "SMSSender.java"

# interfaces
.implements Lmain/Key_H;


# static fields
.field public static gr:Lmain/GameRun;

.field public static isWorking:Z

.field public static pk:Lcom/PetKing5_480x800/PetKing5;

.field public static smsSender:Lmain/SMSSender;

.field public static smsType:B


# instance fields
.field private about:[Ljava/lang/StringBuffer;

.field private currentPage:B

.field public idSmsLevel:B

.field public menu:[[B

.field private menuTxt:[[Ljava/lang/String;

.field public menu_state:B

.field public pkey:Lmain/PointerKey;

.field public sel:[B

.field public sendSms:B

.field public showLine:B

.field public smsCount:[[B

.field public sms_a:Z

.field public sms_b:Z

.field public tMyState:B

.field private tState:I

.field private totalPage:B


# direct methods
.method public constructor <init>(Lmain/GameRun;)V
    .locals 9
    .param p1, "gr_"    # Lmain/GameRun;

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x2

    const/4 v6, 0x0

    const/4 v5, 0x3

    const/4 v4, 0x1

    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 99
    iput-boolean v4, p0, Lmain/SMSSender;->sms_a:Z

    iput-boolean v6, p0, Lmain/SMSSender;->sms_b:Z

    .line 103
    const/4 v1, 0x5

    new-array v1, v1, [[B

    .line 113
    new-array v2, v8, [B

    aput-byte v7, v2, v4

    aput-byte v8, v2, v7

    const/4 v3, 0x5

    aput-byte v3, v2, v5

    aput-object v2, v1, v6

    .line 114
    new-array v2, v4, [B

    const/4 v3, 0x6

    aput-byte v3, v2, v6

    aput-object v2, v1, v4

    .line 115
    new-array v2, v4, [B

    const/4 v3, 0x7

    aput-byte v3, v2, v6

    aput-object v2, v1, v7

    .line 116
    new-array v2, v4, [B

    const/16 v3, 0x8

    aput-byte v3, v2, v6

    aput-object v2, v1, v5

    .line 118
    new-array v2, v4, [B

    aput-byte v7, v2, v6

    aput-object v2, v1, v8

    iput-object v1, p0, Lmain/SMSSender;->menu:[[B

    .line 119
    new-array v1, v7, [B

    iput-object v1, p0, Lmain/SMSSender;->sel:[B

    .line 125
    const/16 v1, 0x8

    new-array v1, v1, [[B

    .line 126
    new-array v2, v5, [B

    fill-array-data v2, :array_0

    aput-object v2, v1, v6

    .line 127
    new-array v2, v5, [B

    fill-array-data v2, :array_1

    aput-object v2, v1, v4

    .line 128
    new-array v2, v5, [B

    fill-array-data v2, :array_2

    aput-object v2, v1, v7

    .line 129
    new-array v2, v5, [B

    fill-array-data v2, :array_3

    aput-object v2, v1, v5

    .line 130
    new-array v2, v5, [B

    fill-array-data v2, :array_4

    aput-object v2, v1, v8

    const/4 v2, 0x5

    .line 131
    new-array v3, v5, [B

    aput-byte v4, v3, v6

    aput-byte v4, v3, v4

    aput-object v3, v1, v2

    const/4 v2, 0x6

    .line 132
    new-array v3, v5, [B

    fill-array-data v3, :array_5

    aput-object v3, v1, v2

    const/4 v2, 0x7

    .line 133
    new-array v3, v5, [B

    fill-array-data v3, :array_6

    aput-object v3, v1, v2

    iput-object v1, p0, Lmain/SMSSender;->smsCount:[[B

    .line 135
    const/4 v1, -0x1

    iput-byte v1, p0, Lmain/SMSSender;->sendSms:B

    .line 45
    sput-object p1, Lmain/SMSSender;->gr:Lmain/GameRun;

    .line 46
    sput-object p0, Lmain/SMSSender;->smsSender:Lmain/SMSSender;

    .line 48
    :try_start_0
    invoke-direct {p0}, Lmain/SMSSender;->createSMS()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 53
    :goto_0
    return-void

    .line 50
    :catch_0
    move-exception v0

    .line 51
    .local v0, "ex":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 126
    :array_0
    .array-data 1
        0x4t
        0x1t
        0x1t
    .end array-data

    .line 127
    :array_1
    .array-data 1
        0x2t
        0x1t
        0x2t
    .end array-data

    .line 128
    :array_2
    .array-data 1
        0x4t
        0x1t
        0x3t
    .end array-data

    .line 129
    :array_3
    .array-data 1
        0x1t
        0x1t
        0x4t
    .end array-data

    .line 130
    :array_4
    .array-data 1
        0x2t
        0x1t
        0x5t
    .end array-data

    .line 132
    :array_5
    .array-data 1
        0x2t
        0x1t
        0x6t
    .end array-data

    .line 133
    :array_6
    .array-data 1
        0x2t
        0x1t
        0x5t
    .end array-data
.end method

.method private createSMS()V
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 85
    const/16 v0, 0x9

    new-array v0, v0, [[Ljava/lang/String;

    .line 86
    new-array v1, v5, [Ljava/lang/String;

    const-string v2, "\u5546\u57ce"

    aput-object v2, v1, v4

    aput-object v1, v0, v4

    .line 87
    new-array v1, v6, [Ljava/lang/String;

    const-string v2, "\u8d2d\u4e7030000\u91d1"

    aput-object v2, v1, v4

    const-string v2, ""

    aput-object v2, v1, v5

    aput-object v1, v0, v5

    .line 88
    new-array v1, v6, [Ljava/lang/String;

    const-string v2, "\u8d2d\u4e705000\u91d1"

    aput-object v2, v1, v4

    const-string v2, "\u8eab\u4e3a\u56db\u5927\u5bb6\u65cf\u4e4b\u9996\u7684\u8d35\u516c\u5b50\uff0c\u6ca1\u94b1\u53ef\u4e0d\u884c\uff01\u7acb\u523b\u62e5\u67095000\u91d1\u3002"

    aput-object v2, v1, v5

    aput-object v1, v0, v6

    const/4 v1, 0x3

    .line 89
    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "\u8d2d\u4e7050\u5fbd\u7ae0"

    aput-object v3, v2, v4

    const-string v3, ""

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/4 v1, 0x4

    .line 90
    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "\u8d2d\u4e7010\u5fbd\u7ae0"

    aput-object v3, v2, v4

    const-string v3, "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u7acb\u523b\u62e5\u670910\u5fbd\u7ae0\uff0c\u80fd\u8d2d\u4e70\u53cc\u500d\u7ecf\u9a8c\uff0c\u5ba0\u7269\u6280\u80fd\uff0c\u5f3a\u5927\u7684\u5ba0\u7269\u6355\u83b7\u7403\u7b49\u5404\u79cd\u795e\u5947\u7684\u9053\u5177\u3002"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/4 v1, 0x5

    .line 91
    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "\u5ba0\u7269\u53475\u7ea7"

    aput-object v3, v2, v4

    const-string v3, "\u8ba9\u60a8\u968f\u8eab\u643a\u5e26\u7684\u5168\u90e8\u5ba0\u7269\u7acb\u523b\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/4 v1, 0x6

    .line 92
    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "\u8d2d\u4e70\u5947\u5f02\u517d"

    aput-object v3, v2, v4

    const-string v3, "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u83b7\u5f97\u53ef\u7231\u7684\u5947\u5f02\u517d\uff0c\u79fb\u52a8\u901f\u5ea6\u53ef\u4ee5\u63d0\u9ad8\u4e00\u500d\uff0c\u4e14\u4e0d\u4f1a\u9047\u5230\u4efb\u4f55\u654c\u4eba\uff01\u65e0\u9650\u4f7f\u7528\uff0c\u5fc3\u52a8\u4e0d\u5982\u884c\u52a8\uff0c\u5feb\u8d2d\u4e70\u5427\uff01"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/4 v1, 0x7

    .line 93
    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "\u6b63\u7248\u9a8c\u8bc1"

    aput-object v3, v2, v4

    const-string v3, "\u6e38\u620f\u8bd5\u73a9\u7ed3\u675f\uff0c\u8d2d\u4e70\u6b64\u9879\u5c06\u5f00\u542f\u540e\u7eed\u6240\u6709\u6e38\u620f\u5185\u5bb9\u3001\u5730\u56fe\u3002\u540c\u65f6\u5c06\u514d\u8d39\u8d60\u9001\u60a85\u679a\u5fbd\u7ae0\uff08\u53ef\u8d2d\u4e70\u5f3a\u529b\u9053\u5177\uff09"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    const/16 v1, 0x8

    .line 94
    new-array v2, v6, [Ljava/lang/String;

    const-string v3, "\u5347\u7ea7\u590d\u6d3b"

    aput-object v3, v2, v4

    const-string v3, "\u8ba9\u60a8\u643a\u5e26\u7684\u6240\u6709\u5ba0\u7269\u5168\u6062\u590d\uff0c\u540c\u65f6\u7acb\u523b\u8ba9\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u63d0\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09\uff0c\u8ba9\u63a5\u4e0b\u6765\u7684\u6218\u6597\u53d8\u7684\u66f4\u8f7b\u677e\u3002"

    aput-object v3, v2, v5

    aput-object v2, v0, v1

    .line 85
    iput-object v0, p0, Lmain/SMSSender;->menuTxt:[[Ljava/lang/String;

    .line 96
    return-void
.end method

.method private draw0()V
    .locals 11

    .prologue
    const/4 v10, -0x1

    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/16 v6, 0x17

    .line 417
    const/4 v0, 0x1

    .local v0, "bLeft":Z
    const/4 v1, 0x1

    .line 418
    .local v1, "bRight":Z
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-le v4, v10, :cond_1

    .line 419
    const-string v3, ""

    .line 420
    .local v3, "smsTip":Ljava/lang/String;
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-nez v4, :cond_3

    .line 421
    iget-object v4, p0, Lmain/SMSSender;->smsCount:[[B

    sget-byte v5, Lmain/SMSSender;->smsType:B

    aget-object v4, v4, v5

    aget-byte v2, v4, v8

    .line 422
    .local v2, "i":I
    if-gez v2, :cond_2

    const/4 v2, 0x0

    .line 424
    :goto_0
    iget-object v4, p0, Lmain/SMSSender;->smsCount:[[B

    sget-byte v5, Lmain/SMSSender;->smsType:B

    aget-object v4, v4, v5

    aget-byte v4, v4, v7

    sub-int/2addr v4, v2

    invoke-direct {p0, v2, v4}, Lmain/SMSSender;->getSmsTip(II)Ljava/lang/String;

    move-result-object v3

    .line 451
    .end local v2    # "i":I
    :cond_0
    :goto_1
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-eq v4, v9, :cond_1

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-eq v4, v7, :cond_1

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-eq v4, v8, :cond_1

    .line 452
    sget-object v4, Lmain/SMSSender;->gr:Lmain/GameRun;

    sget v5, Lmain/Constants_H;->HEIGHT_H:I

    const/16 v6, 0x32

    sub-int/2addr v5, v6

    const/4 v6, 0x0

    invoke-virtual {v4, v3, v5, v6}, Lmain/GameRun;->showString(Ljava/lang/String;II)V

    .line 457
    .end local v3    # "smsTip":Ljava/lang/String;
    :cond_1
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v4

    invoke-virtual {v4, v0, v1}, Ldm/Ui;->drawYesNo(ZZ)V

    .line 458
    return-void

    .line 423
    .restart local v2    # "i":I
    .restart local v3    # "smsTip":Ljava/lang/String;
    :cond_2
    sget-object v4, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->rmsSms:[B

    aget-byte v2, v4, v2

    goto :goto_0

    .line 425
    .end local v2    # "i":I
    :cond_3
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-eq v4, v7, :cond_0

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-eq v4, v8, :cond_0

    .line 429
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-eq v4, v9, :cond_0

    .line 432
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-le v4, v9, :cond_4

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    const/16 v5, 0xf

    if-lt v4, v5, :cond_5

    :cond_4
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-le v4, v6, :cond_6

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    const/16 v5, 0x22

    if-ge v4, v5, :cond_6

    .line 433
    :cond_5
    const-string v3, "\u8d2d\u4e70\u5df2\u6210\u529f\uff01"

    .line 436
    const/4 v1, 0x0

    move v0, v1

    .line 437
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-le v4, v6, :cond_0

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    const/16 v5, 0x22

    if-ge v4, v5, :cond_0

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    add-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    iput-byte v4, p0, Lmain/SMSSender;->sendSms:B

    goto :goto_1

    .line 438
    :cond_6
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    const/16 v5, 0xf

    if-ne v4, v5, :cond_7

    .line 439
    const-string v3, "\u81ea\u52a8\u4fdd\u5b58\u6e38\u620f\u3002"

    .line 440
    const/4 v1, 0x0

    move v0, v1

    goto :goto_1

    .line 441
    :cond_7
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-ge v4, v6, :cond_0

    .line 442
    const-string v3, "\u4fdd\u5b58\u6e38\u620f\u6210\u529f\u3002"

    .line 443
    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    add-int/lit8 v4, v4, 0x1

    int-to-byte v4, v4

    iput-byte v4, p0, Lmain/SMSSender;->sendSms:B

    .line 445
    const/4 v1, 0x0

    move v0, v1

    .line 446
    sget-byte v4, Lmain/SMSSender;->smsType:B

    const/4 v5, 0x5

    if-ne v4, v5, :cond_8

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-ne v4, v6, :cond_8

    .line 447
    sget-object v4, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v5, "\u8d2d\u4e70\u5df2\u6210\u529f\uff01\u6e38\u620f\u5df2\u4fdd\u5b58\u3002#n\u65b0\u6e38\u620f\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39\u3002"

    invoke-virtual {v4, v5, v10}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_1

    .line 448
    :cond_8
    sget-byte v4, Lmain/SMSSender;->smsType:B

    const/4 v5, 0x6

    if-ne v4, v5, :cond_0

    iget-byte v4, p0, Lmain/SMSSender;->sendSms:B

    if-ne v4, v6, :cond_0

    .line 449
    sget-object v4, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v5, "\u8d2d\u4e70\u5df2\u6210\u529f\uff01\u83b7\u5f975\u679a\u5fbd\u7ae0(\u80cc\u5305\u7684\u5377\u8f74\u754c\u9762\u53ef\u67e5\u770b\uff09\u3002\u6e38\u620f\u5df2\u4fdd\u5b58\u3002#n\u65b0\u6e38\u620f\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39\u3002"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto/16 :goto_1
.end method

.method private getSmsTip(II)Ljava/lang/String;
    .locals 3
    .param p1, "i0"    # I
    .param p2, "i1"    # I

    .prologue
    .line 460
    const-string v0, ""

    .line 461
    .local v0, "tip":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "\u60a8\u5df2\u53d1\u9001"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\u6761\u77ed\u4fe1\u3002"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 462
    const-string v2, "\u8d2d\u4e70\u6b64\u9879\uff0c\u8fd8\u9700\u53d1\u9001"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\u6761\u77ed\u4fe1\u3002"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 463
    const-string v2, "\u786e\u8ba4\u53d1\u9001\u77ed\u4fe1\u5417\uff1f"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 461
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 464
    return-object v0
.end method

.method private goWord()V
    .locals 1

    .prologue
    .line 218
    const/4 v0, 0x3

    iput-byte v0, p0, Lmain/SMSSender;->showLine:B

    .line 225
    return-void
.end method

.method public static i(Lmain/GameRun;)Lmain/SMSSender;
    .locals 1
    .param p0, "gr_"    # Lmain/GameRun;

    .prologue
    .line 55
    sget-object v0, Lmain/SMSSender;->smsSender:Lmain/SMSSender;

    if-nez v0, :cond_0

    .line 56
    new-instance v0, Lmain/SMSSender;

    invoke-direct {v0, p0}, Lmain/SMSSender;-><init>(Lmain/GameRun;)V

    sput-object v0, Lmain/SMSSender;->smsSender:Lmain/SMSSender;

    .line 58
    :cond_0
    sget-object v0, Lmain/SMSSender;->smsSender:Lmain/SMSSender;

    return-object v0
.end method

.method private outState()V
    .locals 2

    .prologue
    .line 471
    iget v0, p0, Lmain/SMSSender;->tState:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 472
    iget v0, p0, Lmain/SMSSender;->tState:I

    sput v0, Lmain/GameRun;->run_state:I

    .line 473
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v1, p0, Lmain/SMSSender;->tMyState:B

    iput-byte v1, v0, Ldm/Npc;->state:B

    .line 480
    :goto_0
    return-void

    .line 477
    :cond_0
    const/16 v0, -0xa

    sput v0, Lmain/GameRun;->run_state:I

    goto :goto_0
.end method


# virtual methods
.method public draw()V
    .locals 26

    .prologue
    .line 371
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->menu_state:B

    move v5, v0

    if-nez v5, :cond_2

    .line 372
    const/16 v22, 0x280

    .local v22, "WIDTH":I
    const/16 v21, 0x168

    .line 373
    .local v21, "HEIGHT":I
    const/16 v23, 0x140

    .line 374
    .local v23, "WIDTH_H":I
    const/4 v6, 0x1

    .local v6, "x":I
    const/4 v7, 0x1

    .local v7, "y":I
    const/4 v5, 0x2

    sub-int v8, v22, v5

    .local v8, "w":I
    const/4 v5, 0x1

    sub-int v9, v21, v5

    .line 375
    .local v9, "h":I
    const/16 v24, 0x1c

    .line 379
    .local v24, "fh":I
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    invoke-virtual {v5}, Ldm/Ui;->fillRectB()V

    .line 380
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v10, 0x0

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK2(IIIII)V

    .line 381
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    const/16 v5, 0x4b

    sub-int v11, v23, v5

    add-int/lit8 v12, v7, 0x3

    const/16 v13, 0x96

    const/4 v5, 0x4

    sub-int v14, v24, v5

    const/4 v15, 0x4

    invoke-virtual/range {v10 .. v15}, Ldm/Ui;->drawK1(IIIII)V

    .line 382
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->menuTxt:[[Ljava/lang/String;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->menu:[[B

    move-object v11, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->menu_state:B

    move v12, v0

    aget-object v11, v11, v12

    const/4 v12, 0x0

    aget-byte v11, v11, v12

    aget-object v5, v5, v11

    const/4 v11, 0x0

    aget-object v11, v5, v11

    add-int/lit8 v13, v7, 0x1

    const/16 v14, 0x11

    const/4 v15, 0x0

    const/16 v16, 0x1

    move/from16 v12, v23

    invoke-virtual/range {v10 .. v16}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 383
    const-string v5, "sk"

    const-string v10, "draw"

    invoke-static {v5, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 386
    add-int/lit8 v6, v6, 0x5

    add-int/lit8 v5, v24, 0x1

    add-int/lit8 v7, v7, 0x1d

    add-int/lit8 v8, v8, -0xa

    .line 387
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->menu:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->menu_state:B

    move v10, v0

    aget-object v5, v5, v10

    array-length v5, v5

    const/4 v10, 0x1

    if-le v5, v10, :cond_1

    .line 388
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    const/16 v5, 0xf

    sub-int v13, v8, v5

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->showLine:B

    move v5, v0

    mul-int v14, v24, v5

    const/4 v15, 0x1

    move v11, v6

    move v12, v7

    invoke-virtual/range {v10 .. v15}, Ldm/Ui;->drawK1(IIIII)V

    .line 389
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    add-int/lit16 v5, v6, 0x274

    const/16 v11, 0xd

    sub-int v11, v5, v11

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->showLine:B

    move v5, v0

    mul-int v13, v24, v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v5, v0

    const/4 v12, 0x0

    aget-byte v5, v5, v12

    const/4 v12, 0x1

    sub-int v14, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->menu:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->menu_state:B

    move v12, v0

    aget-object v5, v5, v12

    array-length v5, v5

    const/4 v12, 0x1

    sub-int v15, v5, v12

    const/16 v16, 0x1

    move v12, v7

    invoke-virtual/range {v10 .. v16}, Ldm/Ui;->sliding(IIIIIZ)V

    .line 390
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->showLine:B

    move v11, v0

    add-int/lit8 v13, v7, 0x2

    const/16 v5, 0xf

    sub-int v14, v8, v5

    const/4 v15, 0x2

    const/16 v17, -0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v5, v0

    const/4 v12, 0x0

    aget-byte v5, v5, v12

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v12, v0

    const/16 v16, 0x1

    aget-byte v12, v12, v16

    sub-int v18, v5, v12

    const/16 v19, 0x4

    const/16 v20, 0x2

    move v12, v6

    move/from16 v16, v24

    invoke-virtual/range {v10 .. v20}, Ldm/Ui;->drawListKY(IIIIIIIIII)V

    .line 391
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v5, v0

    const/4 v10, 0x1

    aget-byte v25, v5, v10

    .line 392
    .local v25, "i":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v5, v0

    const/4 v10, 0x1

    aget-byte v5, v5, v10

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->showLine:B

    move v10, v0

    add-int/2addr v5, v10

    move/from16 v0, v25

    move v1, v5

    if-ge v0, v1, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->menu:[[B

    move-object v5, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->menu_state:B

    move v10, v0

    aget-object v5, v5, v10

    array-length v5, v5

    move/from16 v0, v25

    move v1, v5

    if-lt v0, v1, :cond_3

    .line 401
    :cond_0
    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->showLine:B

    move v5, v0

    mul-int v5, v5, v24

    add-int/lit8 v5, v5, 0x5

    add-int/lit8 v7, v5, 0x1e

    .line 403
    .end local v25    # "i":I
    :cond_1
    add-int/lit8 v5, v7, 0xa

    sub-int/2addr v9, v5

    .line 404
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v5

    const/4 v10, 0x2

    invoke-virtual/range {v5 .. v10}, Ldm/Ui;->drawK1(IIIII)V

    .line 405
    const/16 v25, 0x0

    .line 412
    .restart local v25    # "i":I
    invoke-direct/range {p0 .. p0}, Lmain/SMSSender;->draw0()V

    .line 414
    .end local v6    # "x":I
    .end local v7    # "y":I
    .end local v8    # "w":I
    .end local v9    # "h":I
    .end local v21    # "HEIGHT":I
    .end local v22    # "WIDTH":I
    .end local v23    # "WIDTH_H":I
    .end local v24    # "fh":I
    .end local v25    # "i":I
    :cond_2
    return-void

    .line 393
    .restart local v6    # "x":I
    .restart local v7    # "y":I
    .restart local v8    # "w":I
    .restart local v9    # "h":I
    .restart local v21    # "HEIGHT":I
    .restart local v22    # "WIDTH":I
    .restart local v23    # "WIDTH_H":I
    .restart local v24    # "fh":I
    .restart local v25    # "i":I
    :cond_3
    invoke-static {}, Ldm/Ui;->i()Ldm/Ui;

    move-result-object v10

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->menuTxt:[[Ljava/lang/String;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->menu:[[B

    move-object v11, v0

    move-object/from16 v0, p0

    iget-byte v0, v0, Lmain/SMSSender;->menu_state:B

    move v12, v0

    aget-object v11, v11, v12

    aget-byte v11, v11, v25

    aget-object v5, v5, v11

    const/4 v11, 0x0

    aget-object v11, v5, v11

    shr-int/lit8 v5, v8, 0x1

    add-int/lit16 v12, v6, 0x13a

    .line 394
    add-int/lit8 v5, v7, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v5, v0

    const/4 v13, 0x1

    aget-byte v5, v5, v13

    sub-int v5, v25, v5

    mul-int v5, v5, v24

    add-int/lit8 v13, v5, 0x20

    const/16 v14, 0x11

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v5, v0

    const/4 v15, 0x0

    aget-byte v5, v5, v15

    move v0, v5

    move/from16 v1, v25

    if-ne v0, v1, :cond_5

    const/4 v5, 0x0

    move v15, v5

    :goto_1
    const/16 v16, 0x0

    .line 393
    invoke-virtual/range {v10 .. v16}, Ldm/Ui;->drawString(Ljava/lang/String;IIIII)V

    .line 395
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->pkey:Lmain/PointerKey;

    move-object v5, v0

    add-int/lit8 v10, v7, 0x2

    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v10, v0

    const/4 v11, 0x1

    aget-byte v10, v10, v11

    sub-int v10, v25, v10

    mul-int v10, v10, v24

    add-int/lit8 v10, v10, 0x20

    move-object v0, v5

    move v1, v6

    move v2, v10

    move/from16 v3, v22

    move/from16 v4, v24

    invoke-virtual {v0, v1, v2, v3, v4}, Lmain/PointerKey;->isSelect(IIII)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 396
    move-object/from16 v0, p0

    iget-object v0, v0, Lmain/SMSSender;->sel:[B

    move-object v5, v0

    const/4 v10, 0x0

    move/from16 v0, v25

    int-to-byte v0, v0

    move v11, v0

    aput-byte v11, v5, v10

    .line 397
    invoke-virtual/range {p0 .. p0}, Lmain/SMSSender;->setSmsType()V

    .line 399
    :cond_4
    add-int/lit8 v25, v25, 0x1

    goto/16 :goto_0

    .line 394
    :cond_5
    const/4 v5, 0x3

    move v15, v5

    goto :goto_1
.end method

.method public getSendSms()B
    .locals 1

    .prologue
    .line 784
    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    return v0
.end method

.method public getSmsSenderMenuState()B
    .locals 1

    .prologue
    .line 791
    iget-byte v0, p0, Lmain/SMSSender;->menu_state:B

    return v0
.end method

.method public getTstate()I
    .locals 1

    .prologue
    .line 794
    iget v0, p0, Lmain/SMSSender;->tState:I

    return v0
.end method

.method public go(IZ)V
    .locals 7
    .param p1, "menu_state_"    # I
    .param p2, "bb"    # Z

    .prologue
    const/4 v6, -0x1

    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 179
    if-eqz p2, :cond_1

    .line 180
    sget v0, Lmain/GameRun;->run_state:I

    iput v0, p0, Lmain/SMSSender;->tState:I

    .line 181
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->map:Lmain/Map;

    iget-object v0, v0, Lmain/Map;->my:Ldm/Npc;

    iget-byte v0, v0, Ldm/Npc;->state:B

    iput-byte v0, p0, Lmain/SMSSender;->tMyState:B

    .line 185
    :goto_0
    iput-boolean v4, p0, Lmain/SMSSender;->sms_a:Z

    .line 186
    iput-boolean v5, p0, Lmain/SMSSender;->sms_b:Z

    .line 187
    const/16 v0, -0x14

    sput v0, Lmain/GameRun;->run_state:I

    .line 188
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/SMSSender;->menu_state:B

    .line 191
    iget-object v0, p0, Lmain/SMSSender;->sel:[B

    iget-object v1, p0, Lmain/SMSSender;->sel:[B

    iget-object v2, p0, Lmain/SMSSender;->menu:[[B

    iget-byte v3, p0, Lmain/SMSSender;->menu_state:B

    aget-object v2, v2, v3

    array-length v2, v2

    if-le v2, v4, :cond_2

    move v2, v4

    :goto_1
    int-to-byte v2, v2

    aput-byte v2, v1, v4

    aput-byte v2, v0, v5

    .line 193
    iget-object v0, p0, Lmain/SMSSender;->menu:[[B

    iget-byte v1, p0, Lmain/SMSSender;->menu_state:B

    aget-object v0, v0, v1

    iget-object v1, p0, Lmain/SMSSender;->sel:[B

    aget-byte v1, v1, v5

    aget-byte v0, v0, v1

    sub-int/2addr v0, v4

    int-to-byte v0, v0

    sput-byte v0, Lmain/SMSSender;->smsType:B

    .line 198
    invoke-direct {p0}, Lmain/SMSSender;->goWord()V

    .line 200
    sget-byte v0, Lmain/SMSSender;->smsType:B

    const/4 v1, 0x5

    if-eq v0, v1, :cond_0

    sget-byte v0, Lmain/SMSSender;->smsType:B

    const/4 v1, 0x6

    if-eq v0, v1, :cond_0

    sget-byte v0, Lmain/SMSSender;->smsType:B

    const/4 v1, 0x7

    if-eq v0, v1, :cond_0

    iget-byte v0, p0, Lmain/SMSSender;->menu_state:B

    const/4 v1, 0x4

    if-ne v0, v1, :cond_3

    sget-byte v0, Lmain/SMSSender;->smsType:B

    if-ne v0, v4, :cond_3

    .line 201
    :cond_0
    iput-byte v4, p0, Lmain/SMSSender;->sendSms:B

    .line 209
    :goto_2
    return-void

    .line 183
    :cond_1
    iput v6, p0, Lmain/SMSSender;->tState:I

    goto :goto_0

    :cond_2
    move v2, v5

    .line 191
    goto :goto_1

    .line 205
    :cond_3
    iput-byte v6, p0, Lmain/SMSSender;->sendSms:B

    .line 207
    sput-boolean v5, Lmain/SMSSender;->isWorking:Z

    goto :goto_2
.end method

.method public goLevel()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v8, -0x1

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 536
    const/16 v2, -0x15

    sput v2, Lmain/GameRun;->run_state:I

    .line 537
    iput-byte v5, p0, Lmain/SMSSender;->idSmsLevel:B

    .line 538
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iput-byte v5, v2, Lmain/GameRun;->b_c:B

    .line 540
    iget v2, p0, Lmain/SMSSender;->tState:I

    const/16 v3, -0x1f

    if-eq v2, v3, :cond_0

    .line 542
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iput-object v9, v2, Lmain/GameRun;->levelUp_in_battle:[[B

    .line 543
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->max_takes:B

    filled-new-array {v3, v7}, [I

    move-result-object v3

    sget-object v4, Ljava/lang/Byte;->TYPE:Ljava/lang/Class;

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object p0

    .end local p0    # "this":Lmain/SMSSender;
    check-cast p0, [[B

    iput-object p0, v2, Lmain/GameRun;->levelUp_in_battle:[[B

    .line 544
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iput-object v9, v2, Lmain/GameRun;->proReplace:[[S

    .line 545
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    array-length v3, v3

    const/4 v4, 0x7

    filled-new-array {v3, v4}, [I

    move-result-object v3

    sget-object v4, Ljava/lang/Short;->TYPE:Ljava/lang/Class;

    invoke-static {v4, v3}, Ljava/lang/reflect/Array;->newInstance(Ljava/lang/Class;[I)Ljava/lang/Object;

    move-result-object p0

    check-cast p0, [[S

    iput-object p0, v2, Lmain/GameRun;->proReplace:[[S

    .line 548
    :cond_0
    const/4 v0, 0x0

    .line 549
    .local v0, "i":B
    :goto_0
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->myMon_length:B

    if-lt v0, v2, :cond_1

    .line 563
    return-void

    .line 550
    :cond_1
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v7

    const/16 v3, 0x46

    if-lt v2, v3, :cond_3

    .line 551
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v0

    invoke-virtual {v2, v3}, Lmain/GameRun;->healMonster(Ldm/Monster;)V

    .line 549
    :cond_2
    add-int/lit8 v2, v0, 0x1

    int-to-byte v0, v2

    goto :goto_0

    .line 554
    :cond_3
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->proReplace:[[S

    aget-object v2, v2, v0

    const/4 v3, 0x6

    sget-object v4, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v4, v4, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v4, v4, v0

    iget-object v4, v4, Ldm/Monster;->monster:[B

    aget-byte v4, v4, v7

    aput-short v4, v2, v3

    .line 555
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->levelUp_in_battle:[[B

    aget-object v2, v2, v0

    aput-byte v6, v2, v5

    .line 556
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->levelUp_in_battle:[[B

    aget-object v2, v2, v0

    aput-byte v8, v2, v6

    .line 557
    const/4 v1, 0x0

    .local v1, "j":B
    :goto_1
    const/4 v2, 0x5

    if-ge v1, v2, :cond_2

    .line 558
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-virtual {v2, v0, v5}, Lmain/GameRun;->levelPro(IZ)V

    .line 559
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v0

    invoke-virtual {v2, v3}, Lmain/GameRun;->getMagic(Ldm/Monster;)V

    .line 560
    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->getSkill:B

    if-eq v2, v8, :cond_4

    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->levelUp_in_battle:[[B

    aget-object v2, v2, v0

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v3, v3, Lmain/GameRun;->getSkill:B

    aput-byte v3, v2, v6

    .line 557
    :cond_4
    add-int/lit8 v2, v1, 0x1

    int-to-byte v1, v2

    goto :goto_1
.end method

.method public isMyMonLevel()Z
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 567
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->myMon_length:B

    sub-int/2addr v1, v3

    int-to-byte v0, v1

    .local v0, "i":B
    :goto_0
    const/4 v1, -0x1

    if-gt v0, v1, :cond_0

    .line 570
    const/4 v1, 0x0

    :goto_1
    return v1

    .line 568
    :cond_0
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v1, v1, v0

    iget-object v1, v1, Ldm/Monster;->monster:[B

    const/4 v2, 0x2

    aget-byte v1, v1, v2

    const/16 v2, 0x46

    if-ge v1, v2, :cond_1

    move v1, v3

    goto :goto_1

    .line 567
    :cond_1
    sub-int v1, v0, v3

    int-to-byte v0, v1

    goto :goto_0
.end method

.method public key()V
    .locals 5

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v2, -0x1

    .line 324
    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    if-ne v0, v2, :cond_2

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_Up_Down()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 325
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 366
    :cond_0
    :goto_0
    return-void

    .line 329
    :cond_1
    iget-object v0, p0, Lmain/SMSSender;->menu:[[B

    iget-byte v1, p0, Lmain/SMSSender;->menu_state:B

    aget-object v0, v0, v1

    array-length v0, v0

    if-le v0, v4, :cond_0

    .line 330
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    iget-object v1, p0, Lmain/SMSSender;->sel:[B

    iget-object v2, p0, Lmain/SMSSender;->menu:[[B

    iget-byte v3, p0, Lmain/SMSSender;->menu_state:B

    aget-object v2, v2, v3

    array-length v2, v2

    iget-byte v3, p0, Lmain/SMSSender;->showLine:B

    invoke-virtual {v0, v1, v4, v2, v3}, Ldm/Ms;->selectS([BIII)V

    .line 331
    invoke-virtual {p0}, Lmain/SMSSender;->setSmsType()V

    goto :goto_0

    .line 333
    :cond_2
    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    if-eq v0, v2, :cond_3

    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    if-nez v0, :cond_6

    :cond_3
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S1()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 334
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 335
    sget-byte v0, Lmain/SMSSender;->smsType:B

    const/4 v1, 0x4

    if-ne v0, v1, :cond_5

    iget-object v0, p0, Lmain/SMSSender;->sel:[B

    aget-byte v0, v0, v3

    const/4 v1, 0x7

    if-eq v0, v1, :cond_5

    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->myMon_length:B

    if-lt v0, v4, :cond_4

    invoke-virtual {p0}, Lmain/SMSSender;->isMyMonLevel()Z

    move-result v0

    if-nez v0, :cond_5

    .line 336
    :cond_4
    iput-byte v2, p0, Lmain/SMSSender;->sendSms:B

    .line 337
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v1, "\u76ee\u524d\u6ca1\u6709\u53ef\u4ee5\u5347\u7ea7\u7684\u5ba0\u7269\uff01"

    invoke-virtual {v0, v1, v3}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    goto :goto_0

    .line 342
    :cond_5
    iput-byte v4, p0, Lmain/SMSSender;->sendSms:B

    goto :goto_0

    .line 348
    :cond_6
    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    if-eq v0, v2, :cond_7

    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    if-eqz v0, :cond_7

    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    const/4 v1, 0x3

    if-eq v0, v1, :cond_7

    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    const/16 v1, 0x18

    if-ne v0, v1, :cond_0

    :cond_7
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_S2()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 350
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->keyRelease()V

    .line 353
    invoke-direct {p0}, Lmain/SMSSender;->outState()V

    .line 354
    sget-byte v0, Lmain/SMSSender;->smsType:B

    const/4 v1, 0x6

    if-ne v0, v1, :cond_8

    .line 355
    const/16 v0, -0xa

    sput v0, Lmain/GameRun;->run_state:I

    .line 357
    sput-boolean v4, Lmain/SMSSender;->isWorking:Z

    .line 362
    :cond_8
    iput-byte v2, p0, Lmain/SMSSender;->sendSms:B

    goto/16 :goto_0
.end method

.method public keyLevel()V
    .locals 2

    .prologue
    .line 531
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    invoke-virtual {v0}, Ldm/Ms;->key_delay()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 533
    :cond_0
    :goto_0
    return-void

    .line 532
    :cond_1
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget v0, v0, Lmain/GameRun;->say_s:I

    if-nez v0, :cond_0

    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const/4 v1, 0x0

    iput-byte v1, v0, Lmain/GameRun;->b_c:B

    goto :goto_0
.end method

.method public paint()V
    .locals 0

    .prologue
    .line 228
    invoke-virtual {p0}, Lmain/SMSSender;->draw()V

    .line 229
    return-void
.end method

.method public paintLevel()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 485
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->b_c:B

    if-eq v0, v3, :cond_0

    .line 487
    :goto_0
    return-void

    .line 486
    :cond_0
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const/4 v1, 0x0

    iget-byte v2, p0, Lmain/SMSSender;->idSmsLevel:B

    invoke-virtual {v0, v1, v2, v3}, Lmain/GameRun;->drawEvolveUI(IIZ)V

    goto :goto_0
.end method

.method public run()V
    .locals 2

    .prologue
    .line 234
    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 238
    const/4 v0, 0x2

    iput-byte v0, p0, Lmain/SMSSender;->sendSms:B

    .line 252
    sget-object v0, Lmain/SMSSender;->pk:Lcom/PetKing5_480x800/PetKing5;

    invoke-virtual {v0}, Lcom/PetKing5_480x800/PetKing5;->setSmshah()V

    .line 315
    :cond_0
    return-void
.end method

.method public runLevel()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x4

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 490
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->b_c:B

    if-nez v1, :cond_3

    .line 491
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->levelUp_in_battle:[[B

    iget-byte v2, p0, Lmain/SMSSender;->idSmsLevel:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v5

    if-ne v1, v6, :cond_1

    .line 492
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->levelUp_in_battle:[[B

    iget-byte v2, p0, Lmain/SMSSender;->idSmsLevel:B

    aget-object v1, v1, v2

    aput-byte v5, v1, v5

    .line 493
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iput-byte v6, v1, Lmain/GameRun;->b_c:B

    .line 494
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    const/16 v2, 0x34

    iput v2, v1, Lmain/GameRun;->say_s:I

    .line 495
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v2, p0, Lmain/SMSSender;->idSmsLevel:B

    invoke-virtual {v1, v2, v6}, Lmain/GameRun;->levelPro(IZ)V

    .line 497
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u751f\u547d;+"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->proReplace:[[S

    iget-byte v4, p0, Lmain/SMSSender;->idSmsLevel:B

    aget-object v3, v3, v4

    aget-short v3, v3, v5

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 498
    const-string v3, "\u80fd\u91cf"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";+"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->proReplace:[[S

    iget-byte v4, p0, Lmain/SMSSender;->idSmsLevel:B

    aget-object v3, v3, v4

    aget-short v3, v3, v6

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget v3, Lmain/Constants_H;->WIDTH:I

    .line 497
    invoke-virtual {v1, v2, v3, v5}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 499
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\u529b\u91cf;+"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->proReplace:[[S

    iget-byte v4, p0, Lmain/SMSSender;->idSmsLevel:B

    aget-object v3, v3, v4

    const/4 v4, 0x3

    aget-short v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 500
    const-string v3, "\u9632\u5fa1"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";+"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->proReplace:[[S

    iget-byte v4, p0, Lmain/SMSSender;->idSmsLevel:B

    aget-object v3, v3, v4

    aget-short v3, v3, v8

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 501
    const-string v3, "\u654f\u6377"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";+"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->proReplace:[[S

    iget-byte v4, p0, Lmain/SMSSender;->idSmsLevel:B

    aget-object v3, v3, v4

    const/4 v4, 0x5

    aget-short v3, v3, v4

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget v3, Lmain/Constants_H;->WIDTH:I

    .line 499
    invoke-virtual {v1, v2, v3, v6}, Lmain/GameRun;->setStringB(Ljava/lang/String;II)V

    .line 502
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->mList_id:[[B

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    iget-byte v4, p0, Lmain/SMSSender;->idSmsLevel:B

    aget-object v3, v3, v4

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    aget-byte v2, v2, v5

    invoke-virtual {v1, v7, v2, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 504
    :goto_0
    iget-byte v1, p0, Lmain/SMSSender;->idSmsLevel:B

    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v2, v2, Lmain/GameRun;->myMon_length:B

    if-lt v1, v2, :cond_0

    .line 505
    iget v1, p0, Lmain/SMSSender;->tState:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_2

    .line 506
    const/16 v1, -0x14

    sput v1, Lmain/GameRun;->run_state:I

    .line 507
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iput-object v9, v1, Lmain/GameRun;->levelUp_in_battle:[[B

    .line 508
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iput-object v9, v1, Lmain/GameRun;->proReplace:[[S

    .line 528
    :cond_0
    :goto_1
    return-void

    .line 503
    :cond_1
    iget-byte v1, p0, Lmain/SMSSender;->idSmsLevel:B

    add-int/lit8 v1, v1, 0x1

    int-to-byte v1, v1

    iput-byte v1, p0, Lmain/SMSSender;->idSmsLevel:B

    goto :goto_0

    .line 510
    :cond_2
    iget v1, p0, Lmain/SMSSender;->tState:I

    sput v1, Lmain/GameRun;->run_state:I

    .line 511
    iget v1, p0, Lmain/SMSSender;->tState:I

    const/16 v2, -0x1f

    if-ne v1, v2, :cond_0

    .line 512
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->mList_id:[[B

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v3}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v3

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v5

    aget-object v2, v2, v3

    aget-byte v2, v2, v5

    invoke-virtual {v1, v7, v2, v6}, Lmain/GameRun;->initMonStream(III)V

    .line 513
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->myB:Ldm/Battle;

    iput-byte v5, v1, Ldm/Battle;->act_num:B

    .line 514
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->myB:Ldm/Battle;

    invoke-virtual {v2}, Ldm/Battle;->getMon()Ldm/Monster;

    move-result-object v2

    invoke-virtual {v1, v2}, Lmain/GameRun;->initSkillList(Ldm/Monster;)V

    .line 518
    const/4 v0, 0x0

    .local v0, "i":B
    :goto_2
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->myMon_length:B

    if-ge v0, v1, :cond_0

    .line 519
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v1, v1, Lmain/GameRun;->proReplace:[[S

    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v2, v2, v0

    iget-object v2, v2, Ldm/Monster;->monster:[B

    aget-byte v2, v2, v6

    aget-object v1, v1, v2

    const/4 v2, 0x6

    .line 520
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->myMonsters:[Ldm/Monster;

    aget-object v3, v3, v0

    iget-object v3, v3, Ldm/Monster;->monster:[B

    aget-byte v3, v3, v7

    .line 519
    aput-short v3, v1, v2

    .line 518
    add-int/lit8 v1, v0, 0x1

    int-to-byte v0, v1

    goto :goto_2

    .line 525
    .end local v0    # "i":B
    :cond_3
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v1, v1, Lmain/GameRun;->b_c:B

    if-ne v1, v6, :cond_0

    .line 526
    sget-object v1, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v2

    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget v3, v3, Lmain/GameRun;->say_s:I

    invoke-virtual {v2, v3, v8, v6}, Ldm/Ms;->mathSpeedDown(IIZ)S

    move-result v2

    int-to-byte v2, v2

    iput v2, v1, Lmain/GameRun;->say_s:I

    goto :goto_1
.end method

.method public sendSuccess()V
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    const/16 v5, -0xa

    const/4 v4, -0x1

    .line 689
    iget-byte v0, p0, Lmain/SMSSender;->sendSms:B

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lmain/SMSSender;->smsCount:[[B

    sget-byte v1, Lmain/SMSSender;->smsType:B

    aget-object v0, v0, v1

    aget-byte v0, v0, v7

    if-le v0, v7, :cond_0

    .line 690
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsSms:[B

    iget-object v1, p0, Lmain/SMSSender;->smsCount:[[B

    sget-byte v2, Lmain/SMSSender;->smsType:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v8

    aget-byte v2, v0, v1

    add-int/lit8 v2, v2, 0x1

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    iget-object v0, p0, Lmain/SMSSender;->smsCount:[[B

    sget-byte v1, Lmain/SMSSender;->smsType:B

    aget-object v0, v0, v1

    aget-byte v0, v0, v7

    if-eq v2, v0, :cond_2

    .line 691
    iput-byte v6, p0, Lmain/SMSSender;->sendSms:B

    .line 693
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x5

    sget-object v2, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v2, v2, Lmain/GameRun;->rmsSms:[B

    invoke-virtual {v0, v1, v2, v8}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 694
    invoke-static {}, Ldm/Ms;->i()Ldm/Ms;

    move-result-object v0

    const/4 v1, 0x5

    const/4 v2, 0x0

    const/4 v3, 0x4

    invoke-virtual {v0, v1, v2, v3}, Ldm/Ms;->rmsOptions(I[BI)[B

    .line 699
    :cond_0
    :goto_0
    sget-byte v0, Lmain/SMSSender;->smsType:B

    packed-switch v0, :pswitch_data_0

    .line 759
    :goto_1
    :pswitch_0
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-virtual {v0}, Lmain/GameRun;->saveGame()V

    .line 760
    iget-byte v0, p0, Lmain/SMSSender;->menu_state:B

    if-eqz v0, :cond_3

    .line 761
    iput-byte v4, p0, Lmain/SMSSender;->sendSms:B

    .line 762
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-byte v0, v0, Lmain/GameRun;->say_c:B

    if-nez v0, :cond_1

    .line 763
    invoke-direct {p0}, Lmain/SMSSender;->outState()V

    .line 766
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0, v7}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 768
    sput v5, Lmain/GameRun;->run_state:I

    .line 769
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    .line 779
    :cond_1
    :goto_2
    iput-byte v4, p0, Lmain/SMSSender;->sendSms:B

    .line 780
    sput v5, Lmain/GameRun;->run_state:I

    .line 781
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    .line 782
    return-void

    .line 696
    :cond_2
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsSms:[B

    iget-object v1, p0, Lmain/SMSSender;->smsCount:[[B

    sget-byte v2, Lmain/SMSSender;->smsType:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v8

    aput-byte v6, v0, v1

    goto :goto_0

    .line 707
    :pswitch_1
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget v1, v0, Lmain/GameRun;->money:I

    add-int/lit16 v1, v1, 0x1388

    iput v1, v0, Lmain/GameRun;->money:I

    .line 709
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v1, "\u8d2d\u4e705000\u91d1\u5e01"

    invoke-virtual {v0, v1, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 710
    sput v5, Lmain/GameRun;->run_state:I

    .line 711
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    goto :goto_1

    .line 714
    :pswitch_2
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget v1, v0, Lmain/GameRun;->coin:I

    add-int/lit8 v1, v1, 0x32

    iput v1, v0, Lmain/GameRun;->coin:I

    .line 715
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v1, "\u5728\u5377\u8f74\u5546\u5e97\u4e2d\u624d\u80fd\u770b\u5230\u5fbd\u7ae0\u6570\u91cf"

    invoke-virtual {v0, v1, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 716
    sput v5, Lmain/GameRun;->run_state:I

    .line 717
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    goto :goto_1

    .line 720
    :pswitch_3
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget v1, v0, Lmain/GameRun;->coin:I

    add-int/lit8 v1, v1, 0xa

    iput v1, v0, Lmain/GameRun;->coin:I

    .line 721
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v1, "\u5728\u5377\u8f74\u5546\u5e97\u4e2d\u624d\u80fd\u770b\u5230\u5fbd\u7ae0\u6570\u91cf"

    invoke-virtual {v0, v1, v4}, Lmain/GameRun;->say(Ljava/lang/String;I)V

    .line 722
    sput v5, Lmain/GameRun;->run_state:I

    .line 723
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    goto/16 :goto_1

    .line 726
    :pswitch_4
    iput v4, p0, Lmain/SMSSender;->tState:I

    .line 728
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v1, "\u643a\u5e26\u7684\u5ba0\u7269\u5168\u90e8\u53475\u7ea7,\u5ba0\u7269\u9875\u9762\u67e5\u770b\u65b0\u5c5e\u6027"

    invoke-virtual {v0, v1, v6, v4}, Lmain/GameRun;->say(Ljava/lang/String;II)V

    .line 729
    sput v5, Lmain/GameRun;->run_state:I

    .line 730
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    .line 733
    :pswitch_5
    invoke-virtual {p0}, Lmain/SMSSender;->goLevel()V

    .line 736
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    invoke-virtual {v0, v7}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 738
    sput v5, Lmain/GameRun;->run_state:I

    .line 739
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    goto/16 :goto_1

    .line 742
    :pswitch_6
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsSms:[B

    const/16 v1, 0xa

    aput-byte v1, v0, v6

    .line 743
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v1, "\u8d2d\u4e70\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39"

    invoke-virtual {v0, v1, v6, v4}, Lmain/GameRun;->say(Ljava/lang/String;II)V

    .line 744
    sput v5, Lmain/GameRun;->run_state:I

    .line 745
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    goto/16 :goto_1

    .line 750
    :pswitch_7
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v0, v0, Lmain/GameRun;->rmsSms:[B

    iget-object v1, p0, Lmain/SMSSender;->smsCount:[[B

    sget-byte v2, Lmain/SMSSender;->smsType:B

    aget-object v1, v1, v2

    aget-byte v1, v1, v8

    const/16 v2, 0xa

    aput-byte v2, v0, v1

    .line 751
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget v1, v0, Lmain/GameRun;->coin:I

    add-int/lit8 v1, v1, 0x5

    iput v1, v0, Lmain/GameRun;->coin:I

    .line 752
    iput-boolean v7, p0, Lmain/SMSSender;->sms_b:Z

    .line 753
    sget-object v0, Lmain/SMSSender;->gr:Lmain/GameRun;

    const-string v1, "\u8d2d\u4e70\u540e\u6b64\u529f\u80fd\u4e0d\u518d\u8981\u6c42\u4ed8\u8d39"

    invoke-virtual {v0, v1, v6, v4}, Lmain/GameRun;->say(Ljava/lang/String;II)V

    .line 754
    sput v5, Lmain/GameRun;->run_state:I

    .line 755
    sget-object v0, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v1, Lmain/GameRun;->run_state:I

    iput v1, v0, Lmain/MainCanvas;->temp_state:I

    goto/16 :goto_1

    .line 772
    :cond_3
    iput-byte v4, p0, Lmain/SMSSender;->sendSms:B

    .line 776
    invoke-static {}, Ldm/Sound;->i()Ldm/Sound;

    move-result-object v0

    invoke-virtual {v0, v6}, Ldm/Sound;->setMusic(Z)V

    goto/16 :goto_2

    .line 699
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_6
        :pswitch_7
        :pswitch_5
    .end packed-switch
.end method

.method public setSendSms(I)V
    .locals 1
    .param p1, "value"    # I

    .prologue
    .line 788
    int-to-byte v0, p1

    iput-byte v0, p0, Lmain/SMSSender;->sendSms:B

    .line 789
    return-void
.end method

.method public setSmsType()V
    .locals 4

    .prologue
    .line 317
    const/16 v0, 0x280

    .line 318
    .local v0, "WIDTH":I
    iget-object v1, p0, Lmain/SMSSender;->menu:[[B

    iget-byte v2, p0, Lmain/SMSSender;->menu_state:B

    aget-object v1, v1, v2

    iget-object v2, p0, Lmain/SMSSender;->sel:[B

    const/4 v3, 0x0

    aget-byte v2, v2, v3

    aget-byte v1, v1, v2

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    int-to-byte v1, v1

    sput-byte v1, Lmain/SMSSender;->smsType:B

    .line 322
    return-void
.end method

.method public setSmsValue(I)V
    .locals 1
    .param p1, "type"    # I

    .prologue
    .line 801
    sget-byte v0, Lmain/SMSSender;->smsType:B

    packed-switch v0, :pswitch_data_0

    .line 823
    :pswitch_0
    return-void

    .line 801
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
