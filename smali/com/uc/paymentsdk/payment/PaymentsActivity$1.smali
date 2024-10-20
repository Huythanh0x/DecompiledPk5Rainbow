.class Lcom/uc/paymentsdk/payment/PaymentsActivity$1;
.super Landroid/content/BroadcastReceiver;
.source "PaymentsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uc/paymentsdk/payment/PaymentsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;


# direct methods
.method constructor <init>(Lcom/uc/paymentsdk/payment/PaymentsActivity;)V
    .registers 2

    .prologue
    .line 1
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 154
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .registers 17
    .param p1, "paramContext"    # Landroid/content/Context;
    .param p2, "paramIntent"    # Landroid/content/Intent;

    .prologue
    .line 157
    invoke-virtual {p0}, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->getResultCode()I

    move-result v0

    sparse-switch v0, :sswitch_data_23e

    .line 270
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 271
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const-string v1, "\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25"

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V

    .line 272
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const/16 v1, 0x15

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    .line 273
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$3(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_2e

    const/4 v0, 0x5

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$0(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v1

    if-ne v0, v1, :cond_36

    .line 274
    :cond_2e
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$10(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;

    move-result-object v0

    if-nez v0, :cond_227

    .line 280
    :cond_36
    :goto_36
    :sswitch_36
    return-void

    .line 160
    :sswitch_37
    const/4 v0, 0x4

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$0(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v1

    if-ne v0, v1, :cond_12f

    .line 161
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->isNeedconfirm()Z

    move-result v0

    if-eqz v0, :cond_77

    .line 163
    const-wide/16 v0, 0x1388

    :try_start_4e
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_51
    .catch Ljava/lang/InterruptedException; {:try_start_4e .. :try_end_51} :catch_72

    .line 167
    :goto_51
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 168
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 169
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v0

    .line 170
    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsConfirmContent()Ljava/lang/String;

    move-result-object v12

    .line 171
    .local v12, "smsConfirmText":Ljava/lang/String;
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v0

    .line 172
    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsConfirmNumber()Ljava/lang/String;

    move-result-object v13

    .line 173
    .local v13, "smsaddress":Ljava/lang/String;
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0, v13, v12}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$2(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_36

    .line 164
    .end local v12    # "smsConfirmText":Ljava/lang/String;
    .end local v13    # "smsaddress":Ljava/lang/String;
    :catch_72
    move-exception v11

    .line 165
    .local v11, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v11}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_51

    .line 176
    .end local v11    # "e":Ljava/lang/InterruptedException;
    :cond_77
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$3(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v1

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$4(Lcom/uc/paymentsdk/payment/PaymentsActivity;I)V

    .line 177
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 178
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 180
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 181
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$5(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v1

    .line 179
    invoke-static {v0, v1}, Lcom/uc/paymentsdk/util/PrefUtil;->setPayedAmount(Landroid/content/Context;I)V

    .line 182
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$3(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v0

    const/4 v1, 0x1

    if-lt v0, v1, :cond_114

    .line 183
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$6(Lcom/uc/paymentsdk/payment/PaymentsActivity;)V

    .line 195
    :goto_a6
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmstype()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_36

    .line 197
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 198
    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 199
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 200
    iget-object v2, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v2}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v2

    .line 201
    invoke-virtual {v2}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getCpID()Ljava/lang/String;

    move-result-object v2

    .line 202
    iget-object v3, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v3}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v3

    .line 203
    invoke-virtual {v3}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmGameID()Ljava/lang/String;

    move-result-object v3

    .line 204
    iget-object v4, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v4}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v4

    .line 205
    invoke-virtual {v4}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v4

    .line 206
    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getSmsPayment()I

    move-result v5

    .line 207
    iget-object v6, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v6

    .line 208
    invoke-virtual {v6}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v6

    .line 209
    iget-object v7, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v7}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v7

    .line 210
    invoke-virtual {v7}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmschannelid()Ljava/lang/String;

    move-result-object v7

    .line 211
    iget-object v8, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v8}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v8

    .line 212
    invoke-virtual {v8}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsnumber()Ljava/lang/String;

    move-result-object v8

    .line 213
    iget-object v9, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v9}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v9

    invoke-virtual {v9}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getContent()Ljava/lang/String;

    move-result-object v9

    .line 214
    iget-object v10, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v10}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmstype()I

    move-result v10

    .line 196
    invoke-static/range {v0 .. v10}, Lcom/uc/paymentsdk/network/Api;->postSmsPayment(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto/16 :goto_36

    .line 186
    :cond_114
    :try_start_114
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 187
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$7(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/content/BroadcastReceiver;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_11f
    .catch Ljava/lang/IllegalArgumentException; {:try_start_114 .. :try_end_11f} :catch_23a

    .line 190
    :goto_11f
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const-string v1, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002"

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V

    .line 191
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 192
    const/16 v1, 0x14

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    goto/16 :goto_a6

    .line 219
    :cond_12f
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 220
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$3(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v1

    const/4 v2, 0x1

    sub-int/2addr v1, v2

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$4(Lcom/uc/paymentsdk/payment/PaymentsActivity;I)V

    .line 222
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 223
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$5(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v1

    .line 221
    invoke-static {v0, v1}, Lcom/uc/paymentsdk/util/PrefUtil;->setPayedAmount(Landroid/content/Context;I)V

    .line 224
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$3(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v0

    const/4 v1, 0x1

    if-lt v0, v1, :cond_1cc

    .line 225
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$6(Lcom/uc/paymentsdk/payment/PaymentsActivity;)V

    .line 237
    :goto_15e
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmstype()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_36

    .line 239
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 240
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 241
    iget-object v2, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v2}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getCpID()Ljava/lang/String;

    move-result-object v2

    .line 242
    iget-object v3, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v3}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmGameID()Ljava/lang/String;

    move-result-object v3

    .line 243
    iget-object v4, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v4}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v4

    .line 244
    invoke-virtual {v4}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getSmsPayment()I

    move-result v5

    .line 245
    iget-object v6, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v6

    .line 246
    invoke-virtual {v6}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v6

    .line 247
    iget-object v7, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v7}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v7

    .line 248
    invoke-virtual {v7}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmschannelid()Ljava/lang/String;

    move-result-object v7

    .line 249
    iget-object v8, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v8}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v8

    invoke-virtual {v8}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsnumber()Ljava/lang/String;

    move-result-object v8

    .line 250
    iget-object v9, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v9}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v9

    invoke-virtual {v9}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getContent()Ljava/lang/String;

    move-result-object v9

    .line 251
    iget-object v10, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v10}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmstype()I

    move-result v10

    .line 238
    invoke-static/range {v0 .. v10}, Lcom/uc/paymentsdk/network/Api;->postSmsPayment(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto/16 :goto_36

    .line 228
    :cond_1cc
    :try_start_1cc
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 229
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$7(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/content/BroadcastReceiver;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_1d7
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1cc .. :try_end_1d7} :catch_238

    .line 232
    :goto_1d7
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const-string v1, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002"

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V

    .line 233
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 234
    const/16 v1, 0x14

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    goto/16 :goto_15e

    .line 256
    :sswitch_1e7
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 257
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const-string v1, "\u5f53\u524d\u624b\u673a\u8bbe\u7f6e\u4e3a\u98de\u884c\u6a21\u5f0f\uff0c\u4e0d\u80fd\u53d1\u9001\u77ed\u4fe1\u3002"

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V

    .line 258
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    const/16 v1, 0x15

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    .line 259
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$3(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_20e

    const/4 v0, 0x5

    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$0(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v1

    if-ne v0, v1, :cond_36

    .line 260
    :cond_20e
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$10(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;

    move-result-object v0

    if-eqz v0, :cond_36

    .line 262
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 264
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$10(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;

    move-result-object v1

    .line 263
    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    goto/16 :goto_36

    .line 276
    :cond_227
    iget-object v0, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-virtual {v0}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 278
    iget-object v1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$1;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    invoke-static {v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$10(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;

    move-result-object v1

    .line 277
    invoke-virtual {v0, v1}, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    goto/16 :goto_36

    .line 230
    :catch_238
    move-exception v0

    goto :goto_1d7

    .line 188
    :catch_23a
    move-exception v0

    goto/16 :goto_11f

    .line 157
    nop

    :sswitch_data_23e
    .sparse-switch
        -0x1 -> :sswitch_37
        0x1 -> :sswitch_36
        0x2 -> :sswitch_1e7
        0x2091c -> :sswitch_36
    .end sparse-switch
.end method
