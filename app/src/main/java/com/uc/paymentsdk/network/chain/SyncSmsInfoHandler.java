package com.uc.paymentsdk.network.chain;

import android.content.Context;
import android.text.TextUtils;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;

public class SyncSmsInfoHandler extends Handler implements ApiTask.TaskHandler {
  private static int sStatus;
  
  private final Integer LOCK = Integer.valueOf(0);
  
  private Handler.OnFinishListener mOnFinishListener;
  
  public SyncSmsInfoHandler(Context paramContext) {
    super(paramContext);
  }
  
  public SyncSmsInfoHandler(Context paramContext, Handler.OnFinishListener paramOnFinishListener) {
    super(paramContext);
    this.mOnFinishListener = paramOnFinishListener;
  }
  
  public static void init() {
    sStatus = 0;
  }
  
  public void handleRequest() {
    switch (sStatus) {
      default:
        return;
      case 1:
        (new Thread(new Runnable() {
              final SyncSmsInfoHandler this$0;
              
              public void run() {
                synchronized (SyncSmsInfoHandler.this.LOCK) {
                  SyncSmsInfoHandler.this.LOCK.wait();
                  SyncSmsInfoHandler.this.mHandler.post(new Runnable() {
                        final SyncSmsInfoHandler.null this$1;
                        
                        public void run() {
                          SyncSmsInfoHandler.null.access$0(SyncSmsInfoHandler.null.this).handleRequest();
                        }
                      });
                  return;
                } 
              }
            })).start();
      case 2:
        if (getSuccessor() == null)
          if (this.mOnFinishListener != null)
            this.mOnFinishListener.onFinish();  
        getSuccessor().handleRequest();
      case 0:
        break;
    } 
    sStatus = 1;
    Api.syncSmsInfo(this.mContext, this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID());
  }
  
  public void onError(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: iconst_2
    //   1: putstatic com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.sStatus : I
    //   4: invokestatic getSmsInfos : ()Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    //   7: ifnonnull -> 26
    //   10: aload_0
    //   11: getfield mContext : Landroid/content/Context;
    //   14: invokestatic getSmsInfo : (Landroid/content/Context;)Ljava/lang/String;
    //   17: astore_3
    //   18: aload_3
    //   19: ifnonnull -> 69
    //   22: aconst_null
    //   23: invokestatic setSmsInfo : (Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
    //   26: aload_0
    //   27: getfield LOCK : Ljava/lang/Integer;
    //   30: astore #4
    //   32: aload #4
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield LOCK : Ljava/lang/Integer;
    //   39: invokevirtual notifyAll : ()V
    //   42: aload #4
    //   44: monitorexit
    //   45: aload_0
    //   46: invokevirtual getSuccessor : ()Lcom/uc/paymentsdk/network/chain/Handler;
    //   49: ifnonnull -> 155
    //   52: aload_0
    //   53: getfield mOnFinishListener : Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    //   56: ifnull -> 68
    //   59: aload_0
    //   60: getfield mOnFinishListener : Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
    //   63: invokeinterface onFinish : ()V
    //   68: return
    //   69: aload_3
    //   70: invokestatic parseSmsInfo : (Ljava/lang/String;)Lcom/uc/paymentsdk/payment/sms/SmsInfos;
    //   73: astore_3
    //   74: aload_3
    //   75: ifnonnull -> 97
    //   78: aconst_null
    //   79: invokestatic setSmsInfo : (Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
    //   82: goto -> 26
    //   85: astore_3
    //   86: iconst_0
    //   87: putstatic com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.sStatus : I
    //   90: aload_3
    //   91: invokevirtual printStackTrace : ()V
    //   94: goto -> 26
    //   97: aload_3
    //   98: getfield smsInfos : Ljava/util/ArrayList;
    //   101: iconst_0
    //   102: invokevirtual get : (I)Ljava/lang/Object;
    //   105: checkcast com/uc/paymentsdk/payment/sms/SmsInfo
    //   108: invokevirtual getSmsendtime : ()Ljava/lang/String;
    //   111: iconst_1
    //   112: invokestatic getCurrentTime : (Z)Ljava/lang/String;
    //   115: ldc 'yyyy-MM-dd'
    //   117: invokestatic dateDiffByDay : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   120: iflt -> 142
    //   123: aconst_null
    //   124: invokestatic setSmsInfo : (Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
    //   127: goto -> 26
    //   130: astore_3
    //   131: iconst_0
    //   132: putstatic com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.sStatus : I
    //   135: aload_3
    //   136: invokevirtual printStackTrace : ()V
    //   139: goto -> 26
    //   142: aload_3
    //   143: invokestatic setSmsInfo : (Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
    //   146: goto -> 26
    //   149: astore_3
    //   150: aload #4
    //   152: monitorexit
    //   153: aload_3
    //   154: athrow
    //   155: aload_0
    //   156: invokevirtual getSuccessor : ()Lcom/uc/paymentsdk/network/chain/Handler;
    //   159: invokevirtual handleRequest : ()V
    //   162: goto -> 68
    // Exception table:
    //   from	to	target	type
    //   10	18	85	java/io/IOException
    //   10	18	130	java/lang/Exception
    //   22	26	85	java/io/IOException
    //   22	26	130	java/lang/Exception
    //   35	45	149	finally
    //   69	74	85	java/io/IOException
    //   69	74	130	java/lang/Exception
    //   78	82	85	java/io/IOException
    //   78	82	130	java/lang/Exception
    //   97	127	85	java/io/IOException
    //   97	127	130	java/lang/Exception
    //   142	146	85	java/io/IOException
    //   142	146	130	java/lang/Exception
    //   150	153	149	finally
  }
  
  public Object onPreHandle(int paramInt, HttpResponse paramHttpResponse) {
    String str = Utils.getBodyString(paramInt, paramHttpResponse);
    if (TextUtils.isEmpty(str))
      return null; 
    try {
      SmsInfos smsInfos = XMLParser.parseSmsInfo(str);
      PrefUtil.setSmsInfo(this.mContext, str);
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return exception;
  }
  
  public void onSuccess(int paramInt, Object paramObject) {
    sStatus = 2;
    Utils.setSmsInfo((SmsInfos)paramObject);
    synchronized (this.LOCK) {
      this.LOCK.notifyAll();
      if (getSuccessor() == null) {
        if (this.mOnFinishListener != null)
          this.mOnFinishListener.onFinish(); 
        return;
      } 
    } 
    getSuccessor().handleRequest();
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */