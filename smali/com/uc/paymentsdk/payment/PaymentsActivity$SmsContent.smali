.class Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;
.super Landroid/database/ContentObserver;
.source "PaymentsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uc/paymentsdk/payment/PaymentsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SmsContent"
.end annotation


# static fields
.field private static final BODY:Ljava/lang/String; = "body"

.field private static final NUMBER:Ljava/lang/String; = "address"


# instance fields
.field private mCursor:Landroid/database/Cursor;

.field final synthetic this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;


# direct methods
.method public constructor <init>(Lcom/uc/paymentsdk/payment/PaymentsActivity;Landroid/os/Handler;)V
    .locals 0
    .param p2, "arg2"    # Landroid/os/Handler;

    .prologue
    .line 1752
    iput-object p1, p0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    .line 1753
    invoke-direct {p0, p2}, Landroid/database/ContentObserver;-><init>(Landroid/os/Handler;)V

    .line 1754
    return-void
.end method


# virtual methods
.method public onChange(Z)V
    .locals 24
    .param p1, "paramBoolean"    # Z

    .prologue
    .line 1757
    invoke-super/range {p0 .. p1}, Landroid/database/ContentObserver;->onChange(Z)V

    .line 1758
    const-string v5, "content://sms/inbox"

    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 1759
    .local v6, "localUri":Landroid/net/Uri;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1761
    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    const-string v9, "_id"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-string v9, "address"

    aput-object v9, v7, v8

    const/4 v8, 0x2

    const-string v9, "body"

    aput-object v9, v7, v8

    .line 1762
    const-string v8, " address like ? or address like ? and read=?"

    .line 1763
    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    .line 1764
    new-instance v11, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v12, v0

    invoke-static {v12}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v12

    invoke-virtual {v12}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsnumber()Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 1765
    const-string v12, "%%"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 1764
    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    .line 1766
    new-instance v11, Ljava/lang/StringBuilder;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v12, v0

    invoke-static {v12}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v12

    .line 1767
    invoke-virtual {v12}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsConfirmNumber()Ljava/lang/String;

    move-result-object v12

    invoke-static {v12}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v12, "%%"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    .line 1766
    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x2

    .line 1767
    const-string v11, "0"

    aput-object v11, v9, v10

    .line 1768
    const-string v10, "date desc"

    .line 1759
    invoke-virtual/range {v5 .. v10}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->managedQuery(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v5

    move-object v0, v5

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    .line 1769
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v5, v0

    if-nez v5, :cond_0

    .line 1913
    .end local v6    # "localUri":Landroid/net/Uri;
    :goto_0
    return-void

    .line 1771
    .restart local v6    # "localUri":Landroid/net/Uri;
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v5, v0

    invoke-interface {v5}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 1772
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$11(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v5

    if-lez v5, :cond_1

    .line 1773
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$11(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v5

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v7, v0

    .line 1774
    const/4 v8, 0x0

    invoke-interface {v7, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    if-le v5, v7, :cond_1

    .line 1775
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v5, v0

    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 1778
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$12(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v5

    const/4 v7, 0x1

    if-gt v5, v7, :cond_2

    .line 1779
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$13(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/os/Handler;

    move-result-object v5

    .line 1780
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v7, v0

    invoke-static {v7}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$14(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Ljava/lang/Runnable;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1781
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    .line 1783
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v7, v0

    invoke-static {v7}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$10(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/database/ContentObserver;

    move-result-object v7

    .line 1782
    invoke-virtual {v5, v7}, Landroid/content/ContentResolver;->unregisterContentObserver(Landroid/database/ContentObserver;)V

    .line 1785
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1786
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v7, v0

    invoke-static {v7}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$7(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/content/BroadcastReceiver;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_1

    .line 1790
    :cond_2
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v7, v0

    const/4 v8, 0x0

    invoke-interface {v7, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v7

    invoke-static {v5, v7}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$15(Lcom/uc/paymentsdk/payment/PaymentsActivity;I)V

    .line 1791
    new-instance v19, Landroid/content/ContentValues;

    invoke-direct/range {v19 .. v19}, Landroid/content/ContentValues;-><init>()V

    .line 1792
    .local v19, "localContentValues":Landroid/content/ContentValues;
    const-string v5, "read"

    const-string v7, "1"

    move-object/from16 v0, v19

    move-object v1, v5

    move-object v2, v7

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1794
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    .line 1795
    const-string v7, " _id=?"

    .line 1796
    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/String;

    const/4 v9, 0x0

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v11, v0

    invoke-static {v11}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$11(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    .line 1794
    move-object v0, v5

    move-object v1, v6

    move-object/from16 v2, v19

    move-object v3, v7

    move-object v4, v8

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Landroid/database/sqlite/SQLiteAbortException; {:try_start_1 .. :try_end_1} :catch_0

    .line 1800
    :goto_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v6, v0

    .line 1801
    .end local v6    # "localUri":Landroid/net/Uri;
    const-string v7, "body"

    invoke-interface {v6, v7}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 1800
    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v23

    .line 1802
    .local v23, "smscontent":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v5, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v6, v0

    .line 1803
    const-string v7, "address"

    invoke-interface {v6, v7}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 1802
    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v21

    .line 1804
    .local v21, "smsaddress":Ljava/lang/String;
    const/4 v5, 0x4

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v6, v0

    invoke-static {v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$0(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v6

    if-ne v5, v6, :cond_8

    .line 1805
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->isNeedconfirm()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 1806
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1807
    const/16 v6, 0x11

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 1808
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    .line 1809
    move-object v0, v5

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->parseConfirmSmsConfirmNumber(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 1810
    .local v22, "smsconfirmnumber":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    .line 1811
    move-object v0, v5

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->isSuccess(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 1812
    if-eqz v22, :cond_4

    .line 1813
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$13(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/os/Handler;

    move-result-object v5

    .line 1814
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v6, v0

    invoke-static {v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$14(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Ljava/lang/Runnable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1815
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    move-object v0, v5

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    invoke-static {v0, v1, v2}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$2(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;Ljava/lang/String;)V

    .line 1912
    .end local v19    # "localContentValues":Landroid/content/ContentValues;
    .end local v21    # "smsaddress":Ljava/lang/String;
    .end local v22    # "smsconfirmnumber":Ljava/lang/String;
    .end local v23    # "smscontent":Ljava/lang/String;
    :cond_3
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->mCursor:Landroid/database/Cursor;

    move-object v5, v0

    invoke-interface {v5}, Landroid/database/Cursor;->close()V

    goto/16 :goto_0

    .line 1797
    .restart local v6    # "localUri":Landroid/net/Uri;
    .restart local v19    # "localContentValues":Landroid/content/ContentValues;
    :catch_0
    move-exception v5

    move-object/from16 v20, v5

    .line 1798
    .local v20, "localSQLiteAbortException":Landroid/database/sqlite/SQLiteAbortException;
    invoke-virtual/range {v20 .. v20}, Landroid/database/sqlite/SQLiteAbortException;->printStackTrace()V

    goto/16 :goto_2

    .line 1818
    .end local v6    # "localUri":Landroid/net/Uri;
    .end local v20    # "localSQLiteAbortException":Landroid/database/sqlite/SQLiteAbortException;
    .restart local v21    # "smsaddress":Ljava/lang/String;
    .restart local v22    # "smsconfirmnumber":Ljava/lang/String;
    .restart local v23    # "smscontent":Ljava/lang/String;
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1819
    const/16 v6, 0x11

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 1820
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    const-string v6, "\u4f59\u989d\u4e0d\u8db3\uff0c\u652f\u4ed8\u5931\u8d25"

    invoke-static {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V

    .line 1821
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1822
    const/16 v6, 0x15

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    goto :goto_3

    .line 1826
    .end local v22    # "smsconfirmnumber":Ljava/lang/String;
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 1827
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v6, v0

    invoke-static {v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$5(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v6

    .line 1825
    invoke-static {v5, v6}, Lcom/uc/paymentsdk/util/PrefUtil;->setPayedAmount(Landroid/content/Context;I)V

    .line 1828
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$12(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v5

    const/4 v6, 0x1

    if-le v5, v6, :cond_6

    .line 1829
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$12(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v6

    const/4 v7, 0x1

    sub-int/2addr v6, v7

    invoke-static {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$16(Lcom/uc/paymentsdk/payment/PaymentsActivity;I)V

    .line 1839
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmstype()I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_3

    .line 1841
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1842
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    .line 1843
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v8, v0

    .line 1844
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v5

    .line 1845
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getCpID()Ljava/lang/String;

    move-result-object v9

    .line 1846
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v5

    .line 1847
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmGameID()Ljava/lang/String;

    move-result-object v10

    .line 1848
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v5

    .line 1849
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v11

    .line 1850
    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getSmsPayment()I

    move-result v12

    .line 1851
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v5

    .line 1852
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v13

    .line 1853
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    .line 1854
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmschannelid()Ljava/lang/String;

    move-result-object v14

    .line 1855
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    .line 1856
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsnumber()Ljava/lang/String;

    move-result-object v15

    .line 1857
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getContent()Ljava/lang/String;

    move-result-object v16

    .line 1858
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmstype()I

    move-result v17

    .line 1840
    invoke-static/range {v7 .. v17}, Lcom/uc/paymentsdk/network/Api;->postSmsPayment(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto/16 :goto_3

    .line 1831
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$12(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v5

    const/4 v6, 0x1

    if-gt v5, v6, :cond_7

    .line 1832
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1833
    const/16 v6, 0x11

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 1834
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    const-string v6, "\u652f\u4ed8\u5df2\u5b8c\u6210\uff0c\u795d\u60a8\u73a9\u5f97\u5f00\u5fc3\u3002"

    invoke-static {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V

    .line 1835
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1836
    const/16 v6, 0x14

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    goto/16 :goto_4

    .line 1863
    :cond_8
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    const/16 v6, 0x11

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 1864
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    .line 1865
    move-object v0, v5

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->parseConfirmResultSms(Ljava/lang/String;)Z

    move-result v18

    .line 1866
    .local v18, "bool":Z
    if-eqz v18, :cond_a

    .line 1868
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 1869
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v6, v0

    invoke-static {v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$5(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v6

    .line 1867
    invoke-static {v5, v6}, Lcom/uc/paymentsdk/util/PrefUtil;->setPayedAmount(Landroid/content/Context;I)V

    .line 1870
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$12(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v5

    const/4 v6, 0x1

    if-le v5, v6, :cond_9

    .line 1871
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$12(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v6

    const/4 v7, 0x1

    sub-int/2addr v6, v7

    invoke-static {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$16(Lcom/uc/paymentsdk/payment/PaymentsActivity;I)V

    .line 1872
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$3(Lcom/uc/paymentsdk/payment/PaymentsActivity;)I

    move-result v6

    const/4 v7, 0x1

    sub-int/2addr v6, v7

    invoke-static {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$4(Lcom/uc/paymentsdk/payment/PaymentsActivity;I)V

    .line 1873
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$13(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Landroid/os/Handler;

    move-result-object v5

    .line 1874
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v6, v0

    invoke-static {v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$14(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Ljava/lang/Runnable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1875
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1876
    const/16 v6, 0x11

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->removeDialog(I)V

    .line 1877
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$6(Lcom/uc/paymentsdk/payment/PaymentsActivity;)V

    .line 1885
    :goto_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmstype()I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_3

    .line 1887
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1888
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    .line 1889
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v8, v0

    .line 1890
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v5

    .line 1891
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getCpID()Ljava/lang/String;

    move-result-object v9

    .line 1892
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v5

    .line 1893
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmGameID()Ljava/lang/String;

    move-result-object v10

    .line 1894
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v5

    .line 1895
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v11

    .line 1896
    invoke-static {}, Lcom/uc/paymentsdk/util/Utils;->getSmsPayment()I

    move-result v12

    .line 1897
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$9(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/PaymentInfo;

    move-result-object v5

    .line 1898
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/PaymentInfo;->getmActionID()Ljava/lang/String;

    move-result-object v13

    .line 1899
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    .line 1900
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmschannelid()Ljava/lang/String;

    move-result-object v14

    .line 1901
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    .line 1902
    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmsnumber()Ljava/lang/String;

    move-result-object v15

    .line 1903
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getContent()Ljava/lang/String;

    move-result-object v16

    .line 1904
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    invoke-static {v5}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$1(Lcom/uc/paymentsdk/payment/PaymentsActivity;)Lcom/uc/paymentsdk/payment/sms/SmsInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/uc/paymentsdk/payment/sms/SmsInfo;->getSmstype()I

    move-result v17

    .line 1886
    invoke-static/range {v7 .. v17}, Lcom/uc/paymentsdk/network/Api;->postSmsPayment(Landroid/content/Context;Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    goto/16 :goto_3

    .line 1879
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1880
    const-string v6, "success"

    const-string v7, "\u8d2d\u4e70\u6210\u529f"

    move-object/from16 v0, v23

    move-object v1, v6

    move-object v2, v7

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v6

    .line 1879
    invoke-static {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V

    .line 1881
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    .line 1882
    const/16 v6, 0x14

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    goto/16 :goto_5

    .line 1907
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    move-object v0, v5

    move-object/from16 v1, v23

    invoke-static {v0, v1}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->access$8(Lcom/uc/paymentsdk/payment/PaymentsActivity;Ljava/lang/String;)V

    .line 1908
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/uc/paymentsdk/payment/PaymentsActivity$SmsContent;->this$0:Lcom/uc/paymentsdk/payment/PaymentsActivity;

    move-object v5, v0

    const/16 v6, 0x15

    invoke-virtual {v5, v6}, Lcom/uc/paymentsdk/payment/PaymentsActivity;->showDialog(I)V

    goto/16 :goto_3

    .line 1787
    .end local v18    # "bool":Z
    .end local v19    # "localContentValues":Landroid/content/ContentValues;
    .end local v21    # "smsaddress":Ljava/lang/String;
    .end local v23    # "smscontent":Ljava/lang/String;
    .restart local v6    # "localUri":Landroid/net/Uri;
    :catch_1
    move-exception v5

    goto/16 :goto_1
.end method
