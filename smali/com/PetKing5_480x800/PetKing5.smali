.class public Lcom/PetKing5_480x800/PetKing5;
.super Ljavax/microedition/lcdui/CwaActivity;
.source "PetKing5.java"


# static fields
.field public static gr:Lmain/GameRun;

.field public static intent:Landroid/content/Intent;


# instance fields
.field ad:Landroid/app/AlertDialog;

.field instance:Lmain/XConnection;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .prologue
    const/4 v0, 0x0

    .line 36
    sput-object v0, Lcom/PetKing5_480x800/PetKing5;->intent:Landroid/content/Intent;

    .line 44
    sput-object v0, Lcom/PetKing5_480x800/PetKing5;->gr:Lmain/GameRun;

    .line 32
    return-void
.end method

.method public constructor <init>()V
    .registers 1

    .prologue
    .line 37
    invoke-direct {p0}, Ljavax/microedition/lcdui/CwaActivity;-><init>()V

    .line 39
    sput-object p0, Lmain/SMSSender;->pk:Lcom/PetKing5_480x800/PetKing5;

    .line 40
    invoke-static {p0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->init(Landroid/content/Context;)V

    .line 42
    return-void
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .registers 12
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v7, 0x6

    const/4 v6, 0x0

    const/4 v4, -0x1

    const/4 v5, 0x1

    .line 169
    invoke-super {p0, p1, p2, p3}, Ljavax/microedition/lcdui/CwaActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 171
    if-nez p1, :cond_69

    .line 172
    if-ne v4, p2, :cond_81

    .line 173
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "================resultCode"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 174
    const-string v3, "\u6210\u529f"

    const-string v4, "\u6210\u529f"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 175
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v3

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Lmain/SMSSender;->setSendSms(I)V

    .line 178
    :try_start_2e
    sget-byte v3, Lmain/SMSSender;->smsType:B

    if-ne v3, v7, :cond_71

    .line 179
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v3

    invoke-virtual {v3}, Lmain/SMSSender;->sendSuccess()V

    .line 180
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v3

    const/4 v4, -0x1

    invoke-virtual {v3, v4}, Lmain/SMSSender;->setSendSms(I)V

    .line 181
    const/16 v3, -0xa

    sput v3, Lmain/GameRun;->run_state:I

    .line 182
    sget-object v3, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v4, Lmain/GameRun;->run_state:I

    iput v4, v3, Lmain/MainCanvas;->temp_state:I

    .line 183
    sget-object v3, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 184
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->map:Lmain/Map;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lmain/Map;->setRegState(Z)V
    :try_end_5d
    .catch Ljava/lang/Exception; {:try_start_2e .. :try_end_5d} :catch_7b

    .line 196
    :goto_5d
    const-string v3, "number"

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 199
    .local v1, "number":Ljava/lang/String;
    const-string v3, "orderId"

    invoke-virtual {p3, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 243
    .end local v1    # "number":Ljava/lang/String;
    :cond_69
    :goto_69
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    sput-boolean v6, Lmain/SMSSender;->isWorking:Z

    .line 244
    return-void

    .line 187
    :cond_71
    :try_start_71
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v3

    invoke-virtual {v3}, Lmain/SMSSender;->sendSuccess()V
    :try_end_7a
    .catch Ljava/lang/Exception; {:try_start_71 .. :try_end_7a} :catch_7b

    goto :goto_5d

    .line 189
    :catch_7b
    move-exception v3

    move-object v0, v3

    .line 191
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_5d

    .line 202
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_81
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v3

    invoke-virtual {v3, v4}, Lmain/SMSSender;->setSendSms(I)V

    .line 208
    :try_start_8a
    sget-byte v3, Lmain/SMSSender;->smsType:B

    const/4 v4, 0x7

    if-ne v3, v4, :cond_b1

    .line 209
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v3

    const/4 v4, 0x1

    iput-boolean v4, v3, Lmain/SMSSender;->sms_a:Z

    .line 210
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-virtual {v3}, Lmain/GameRun;->goGameOver()V

    .line 211
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v4, "ccccccccc"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 213
    sget-object v3, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V
    :try_end_aa
    .catch Ljava/lang/Exception; {:try_start_8a .. :try_end_aa} :catch_ab

    goto :goto_69

    .line 236
    :catch_ab
    move-exception v3

    move-object v0, v3

    .line 238
    .restart local v0    # "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_69

    .line 215
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_b1
    :try_start_b1
    sget-byte v3, Lmain/SMSSender;->smsType:B

    const/4 v4, 0x5

    if-ne v3, v4, :cond_cf

    .line 216
    const/16 v3, -0xa

    sput v3, Lmain/GameRun;->run_state:I

    .line 217
    sget-object v3, Lmain/GameRun;->mc:Lmain/MainCanvas;

    sget v4, Lmain/GameRun;->run_state:I

    iput v4, v3, Lmain/MainCanvas;->temp_state:I

    .line 218
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->map:Lmain/Map;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lmain/Map;->setRegState(Z)V

    .line 221
    sget-object v3, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    goto :goto_69

    .line 222
    :cond_cf
    sget-byte v3, Lmain/SMSSender;->smsType:B

    if-ne v3, v7, :cond_e6

    .line 223
    const/16 v3, -0xa

    sput v3, Lmain/GameRun;->run_state:I

    .line 225
    sget-object v3, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 226
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    iget-object v3, v3, Lmain/GameRun;->map:Lmain/Map;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lmain/Map;->setRegState(Z)V

    goto :goto_69

    .line 227
    :cond_e6
    sget-byte v3, Lmain/SMSSender;->smsType:B

    if-ne v3, v5, :cond_69

    .line 229
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v3

    invoke-virtual {v3}, Lmain/SMSSender;->getSmsSenderMenuState()B

    move-result v3

    if-eqz v3, :cond_69

    .line 230
    sget-object v3, Lmain/GameRun;->mc:Lmain/MainCanvas;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lmain/MainCanvas;->setSmsIsSetRun_state(Z)V

    .line 231
    sget-object v3, Lmain/SMSSender;->gr:Lmain/GameRun;

    invoke-static {v3}, Lmain/SMSSender;->i(Lmain/GameRun;)Lmain/SMSSender;

    move-result-object v3

    invoke-virtual {v3}, Lmain/SMSSender;->getTstate()I

    move-result v3

    sput v3, Lmain/GameRun;->run_state:I
    :try_end_108
    .catch Ljava/lang/Exception; {:try_start_b1 .. :try_end_108} :catch_ab

    goto/16 :goto_69
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .registers 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 54
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/PetKing5_480x800/PetKing5;->setFullWindow(Z)V

    .line 55
    invoke-super {p0, p1}, Ljavax/microedition/lcdui/CwaActivity;->onCreate(Landroid/os/Bundle;)V

    .line 56
    new-instance v0, Lmain/XConnection;

    invoke-direct {v0}, Lmain/XConnection;-><init>()V

    iput-object v0, p0, Lcom/PetKing5_480x800/PetKing5;->instance:Lmain/XConnection;

    .line 57
    iget-object v0, p0, Lcom/PetKing5_480x800/PetKing5;->instance:Lmain/XConnection;

    invoke-virtual {p0, v0}, Lcom/PetKing5_480x800/PetKing5;->setMIDlet(Ljavax/microedition/midlet/MIDlet;)V

    .line 58
    invoke-virtual {p0}, Lcom/PetKing5_480x800/PetKing5;->setContentView()V

    .line 62
    invoke-virtual {p0}, Lcom/PetKing5_480x800/PetKing5;->getIntent()Landroid/content/Intent;

    move-result-object v0

    sput-object v0, Lcom/PetKing5_480x800/PetKing5;->intent:Landroid/content/Intent;

    .line 63
    return-void
.end method

.method protected onDestroy()V
    .registers 1

    .prologue
    .line 48
    invoke-super {p0}, Ljavax/microedition/lcdui/CwaActivity;->onDestroy()V

    .line 50
    return-void
.end method

.method public setSmshah()V
    .registers 22

    .prologue
    .line 67
    const-string v14, "10086"

    .line 68
    .local v14, "DebugAdress":Ljava/lang/String;
    sget-byte v9, Lmain/SMSSender;->smsType:B

    packed-switch v9, :pswitch_data_12a

    .line 167
    :goto_7
    :pswitch_7
    return-void

    .line 77
    :pswitch_8
    new-instance v15, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/PetKing5_480x800/PetKing5;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 78
    const-class v10, Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 77
    invoke-direct {v15, v9, v10}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 79
    .local v15, "intent":Landroid/content/Intent;
    new-instance v3, Lcom/uc/paymentsdk/payment/PaymentInfo;

    const-string v4, "\u8d2d\u4e705000\u91d1"

    const-string v5, "22"

    const-string v6, "01"

    const-string v7, "\u8eab\u4e3a\u56db\u5927\u5bb6\u65cf\u4e4b\u9996\u7684\u8d35\u516c\u5b50\uff0c\u6ca1\u94b1\u53ef\u4e0d\u884c\uff01\u7acb\u523b\u62e5\u67095000\u91d1\u3002"

    const/16 v8, 0x14

    invoke-direct/range {v3 .. v8}, Lcom/uc/paymentsdk/payment/PaymentInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 80
    .local v3, "info":Lcom/uc/paymentsdk/payment/PaymentInfo;
    const-string v9, "com.mappn.sdk.paymentinfo"

    invoke-virtual {v15, v9, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 81
    const/4 v9, 0x0

    move-object/from16 v0, p0

    move-object v1, v15

    move v2, v9

    invoke-virtual {v0, v1, v2}, Lcom/PetKing5_480x800/PetKing5;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_7

    .line 100
    .end local v3    # "info":Lcom/uc/paymentsdk/payment/PaymentInfo;
    .end local v15    # "intent":Landroid/content/Intent;
    :pswitch_30
    new-instance v16, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/PetKing5_480x800/PetKing5;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 101
    const-class v10, Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 100
    move-object/from16 v0, v16

    move-object v1, v9

    move-object v2, v10

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 102
    .local v16, "intent1":Landroid/content/Intent;
    new-instance v4, Lcom/uc/paymentsdk/payment/PaymentInfo;

    const-string v5, "\u8d2d\u4e7010\u5fbd\u7ae0"

    const-string v6, "22"

    const-string v7, "02"

    const-string v8, "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u7acb\u523b\u62e5\u670910\u5fbd\u7ae0\uff0c\u80fd\u8d2d\u4e70\u53cc\u500d\u7ecf\u9a8c\uff0c\u5ba0\u7269\u6280\u80fd\uff0c\u5f3a\u5927\u7684\u5ba0\u7269\u6355\u83b7\u7403\u7b49\u5404\u79cd\u795e\u5947\u7684\u9053\u5177\u3002"

    const/16 v9, 0x14

    invoke-direct/range {v4 .. v9}, Lcom/uc/paymentsdk/payment/PaymentInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 103
    .local v4, "info1":Lcom/uc/paymentsdk/payment/PaymentInfo;
    const-string v9, "com.mappn.sdk.paymentinfo"

    move-object/from16 v0, v16

    move-object v1, v9

    move-object v2, v4

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 104
    const/4 v9, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v16

    move v2, v9

    invoke-virtual {v0, v1, v2}, Lcom/PetKing5_480x800/PetKing5;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_7

    .line 111
    .end local v4    # "info1":Lcom/uc/paymentsdk/payment/PaymentInfo;
    .end local v16    # "intent1":Landroid/content/Intent;
    :pswitch_61
    new-instance v17, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/PetKing5_480x800/PetKing5;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 112
    const-class v10, Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 111
    move-object/from16 v0, v17

    move-object v1, v9

    move-object v2, v10

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 113
    .local v17, "intent2":Landroid/content/Intent;
    new-instance v5, Lcom/uc/paymentsdk/payment/PaymentInfo;

    const-string v6, "\u5ba0\u7269\u53475\u7ea7"

    const-string v7, "22"

    const-string v8, "03"

    const-string v9, "\u8ba9\u60a8\u968f\u8eab\u643a\u5e26\u7684\u5168\u90e8\u5ba0\u7269\u7acb\u523b\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09"

    const/16 v10, 0x14

    invoke-direct/range {v5 .. v10}, Lcom/uc/paymentsdk/payment/PaymentInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 114
    .local v5, "info2":Lcom/uc/paymentsdk/payment/PaymentInfo;
    const-string v9, "com.mappn.sdk.paymentinfo"

    move-object/from16 v0, v17

    move-object v1, v9

    move-object v2, v5

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 115
    const/4 v9, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move v2, v9

    invoke-virtual {v0, v1, v2}, Lcom/PetKing5_480x800/PetKing5;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_7

    .line 125
    .end local v5    # "info2":Lcom/uc/paymentsdk/payment/PaymentInfo;
    .end local v17    # "intent2":Landroid/content/Intent;
    :pswitch_93
    new-instance v18, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/PetKing5_480x800/PetKing5;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 126
    const-class v10, Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 125
    move-object/from16 v0, v18

    move-object v1, v9

    move-object v2, v10

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 127
    .local v18, "intent3":Landroid/content/Intent;
    new-instance v6, Lcom/uc/paymentsdk/payment/PaymentInfo;

    const-string v7, "\u8d2d\u4e70\u5947\u5f02\u517d"

    const-string v8, "22"

    const-string v9, "04"

    const-string v10, "\u8d2d\u4e70\u8be5\u7279\u6b8a\u9053\u5177\uff0c\u83b7\u5f97\u53ef\u7231\u7684\u5947\u5f02\u517d\uff0c\u79fb\u52a8\u901f\u5ea6\u53ef\u4ee5\u63d0\u9ad8\u4e00\u500d\uff0c\u4e14\u4e0d\u4f1a\u9047\u5230\u4efb\u4f55\u654c\u4eba\uff01\u65e0\u9650\u4f7f\u7528\uff0c\u5fc3\u52a8\u4e0d\u5982\u884c\u52a8\uff0c\u5feb\u8d2d\u4e70\u5427\uff01"

    const/16 v11, 0x14

    invoke-direct/range {v6 .. v11}, Lcom/uc/paymentsdk/payment/PaymentInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 128
    .local v6, "info3":Lcom/uc/paymentsdk/payment/PaymentInfo;
    const-string v9, "com.mappn.sdk.paymentinfo"

    move-object/from16 v0, v18

    move-object v1, v9

    move-object v2, v6

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 129
    const/4 v9, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move v2, v9

    invoke-virtual {v0, v1, v2}, Lcom/PetKing5_480x800/PetKing5;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_7

    .line 139
    .end local v6    # "info3":Lcom/uc/paymentsdk/payment/PaymentInfo;
    .end local v18    # "intent3":Landroid/content/Intent;
    :pswitch_c5
    new-instance v19, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/PetKing5_480x800/PetKing5;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 140
    const-class v10, Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 139
    move-object/from16 v0, v19

    move-object v1, v9

    move-object v2, v10

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 141
    .local v19, "intent4":Landroid/content/Intent;
    new-instance v7, Lcom/uc/paymentsdk/payment/PaymentInfo;

    const-string v8, "\u6b63\u7248\u9a8c\u8bc1"

    const-string v9, "22"

    const-string v10, "05"

    const-string v11, "\u6e38\u620f\u8bd5\u73a9\u7ed3\u675f\uff0c\u8d2d\u4e70\u6b64\u9879\u5c06\u5f00\u542f\u540e\u7eed\u6240\u6709\u6e38\u620f\u5185\u5bb9\u3001\u5730\u56fe\u3002\u540c\u65f6\u5c06\u514d\u8d39\u8d60\u9001\u60a85\u679a\u5fbd\u7ae0\uff08\u53ef\u8d2d\u4e70\u5f3a\u529b\u9053\u5177\uff09"

    const/16 v12, 0x28

    invoke-direct/range {v7 .. v12}, Lcom/uc/paymentsdk/payment/PaymentInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 142
    .local v7, "info4":Lcom/uc/paymentsdk/payment/PaymentInfo;
    const-string v9, "com.mappn.sdk.paymentinfo"

    move-object/from16 v0, v19

    move-object v1, v9

    move-object v2, v7

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 143
    const/4 v9, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move v2, v9

    invoke-virtual {v0, v1, v2}, Lcom/PetKing5_480x800/PetKing5;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_7

    .line 153
    .end local v7    # "info4":Lcom/uc/paymentsdk/payment/PaymentInfo;
    .end local v19    # "intent4":Landroid/content/Intent;
    :pswitch_f7
    new-instance v20, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/PetKing5_480x800/PetKing5;->getApplicationContext()Landroid/content/Context;

    move-result-object v9

    .line 154
    const-class v10, Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 153
    move-object/from16 v0, v20

    move-object v1, v9

    move-object v2, v10

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 155
    .local v20, "intent5":Landroid/content/Intent;
    new-instance v8, Lcom/uc/paymentsdk/payment/PaymentInfo;

    const-string v9, "\u5347\u7ea7\u590d\u6d3b"

    const-string v10, "22"

    const-string v11, "06"

    const-string v12, "\u8ba9\u60a8\u643a\u5e26\u7684\u6240\u6709\u5ba0\u7269\u5168\u6062\u590d\uff0c\u540c\u65f6\u7acb\u523b\u8ba9\u60a8\u643a\u5e26\u7684\u5ba0\u7269\u63d0\u53475\u7ea7\uff08\u8d85\u8fc770\u7ea7\u5ba0\u7269\u4e0d\u80fd\u518d\u5347\u7ea7\uff09\uff0c\u8ba9\u63a5\u4e0b\u6765\u7684\u6218\u6597\u53d8\u7684\u66f4\u8f7b\u677e\u3002"

    const/16 v13, 0x14

    invoke-direct/range {v8 .. v13}, Lcom/uc/paymentsdk/payment/PaymentInfo;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 156
    .local v8, "info5":Lcom/uc/paymentsdk/payment/PaymentInfo;
    const-string v9, "com.mappn.sdk.paymentinfo"

    move-object/from16 v0, v20

    move-object v1, v9

    move-object v2, v8

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 157
    const/4 v9, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move v2, v9

    invoke-virtual {v0, v1, v2}, Lcom/PetKing5_480x800/PetKing5;->startActivityForResult(Landroid/content/Intent;I)V

    goto/16 :goto_7

    .line 68
    nop

    :pswitch_data_12a
    .packed-switch 0x1
        :pswitch_8
        :pswitch_7
        :pswitch_30
        :pswitch_61
        :pswitch_93
        :pswitch_c5
        :pswitch_f7
    .end packed-switch
.end method
