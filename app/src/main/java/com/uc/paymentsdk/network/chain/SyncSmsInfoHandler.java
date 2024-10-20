package com.uc.paymentsdk.network.chain;

import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.network.XMLParser;
import android.text.TextUtils;
import org.apache.http.HttpResponse;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.util.Utils;
import android.content.Context;
import com.uc.paymentsdk.network.ApiTask;

public class SyncSmsInfoHandler extends Handler implements TaskHandler
{
    private static int sStatus;
    private final Integer LOCK;
    private OnFinishListener mOnFinishListener;
    
    public SyncSmsInfoHandler(final Context context) {
        super(context);
        this.LOCK = Integer.valueOf(0);
    }
    
    public SyncSmsInfoHandler(final Context context, final OnFinishListener mOnFinishListener) {
        super(context);
        this.LOCK = Integer.valueOf(0);
        this.mOnFinishListener = mOnFinishListener;
    }
    
    static /* synthetic */ Integer access$0(final SyncSmsInfoHandler syncSmsInfoHandler) {
        return syncSmsInfoHandler.LOCK;
    }
    
    public static void init() {
        SyncSmsInfoHandler.sStatus = 0;
    }
    
    @Override
    public void handleRequest() {
        switch (SyncSmsInfoHandler.sStatus) {
            case 1: {
                new Thread(new Runnable(this) {
                    final SyncSmsInfoHandler this$0;
                    
                    SyncSmsInfoHandler$1(final SyncSmsInfoHandler this$0) {
                        this.this$0 = this$0;
                        super();
                    }
                    
                    static /* synthetic */ SyncSmsInfoHandler access$0(final SyncSmsInfoHandler$1 runnable) {
                        return runnable.this$0;
                    }
                    
                    @Override
                    public void run() {
                        synchronized (LOCK) {
                            while (true) {
                                try {
                                    LOCK.wait();
                                    monitorexit(LOCK);
                                    this.this$0.mHandler.post((Runnable)new Runnable(this) {
                                        final SyncSmsInfoHandler$1 this$1;
                                        
                                        SyncSmsInfoHandler$1$1(final SyncSmsInfoHandler$1 this$1) {
                                            this.this$1 = this$1;
                                            super();
                                        }
                                        
                                        @Override
                                        public void run() {
                                            this$0.handleRequest();
                                        }
                                    });
                                }
                                catch (final InterruptedException ex) {
                                    ex.printStackTrace();
                                    continue;
                                }
                                break;
                            }
                        }
                    }
                }).start();
                break;
            }
            case 2: {
                if (this.getSuccessor() != null) {
                    this.getSuccessor().handleRequest();
                    break;
                }
                if (this.mOnFinishListener != null) {
                    this.mOnFinishListener.onFinish();
                    break;
                }
                break;
            }
            case 0: {
                SyncSmsInfoHandler.sStatus = 1;
                Api.syncSmsInfo(this.mContext, this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID());
                break;
            }
        }
    }
    
    @Override
    public void onError(final int p0, final int p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: putstatic       com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.sStatus:I
        //     4: invokestatic    com/uc/paymentsdk/util/Utils.getSmsInfos:()Lcom/uc/paymentsdk/payment/sms/SmsInfos;
        //     7: ifnonnull       26
        //    10: aload_0        
        //    11: getfield        com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.mContext:Landroid/content/Context;
        //    14: invokestatic    com/uc/paymentsdk/util/PrefUtil.getSmsInfo:(Landroid/content/Context;)Ljava/lang/String;
        //    17: astore_3       
        //    18: aload_3        
        //    19: ifnonnull       69
        //    22: aconst_null    
        //    23: invokestatic    com/uc/paymentsdk/util/Utils.setSmsInfo:(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
        //    26: aload_0        
        //    27: getfield        com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.LOCK:Ljava/lang/Integer;
        //    30: astore          4
        //    32: aload           4
        //    34: monitorenter   
        //    35: aload_0        
        //    36: getfield        com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.LOCK:Ljava/lang/Integer;
        //    39: invokevirtual   java/lang/Object.notifyAll:()V
        //    42: aload           4
        //    44: monitorexit    
        //    45: aload_0        
        //    46: invokevirtual   com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.getSuccessor:()Lcom/uc/paymentsdk/network/chain/Handler;
        //    49: ifnonnull       155
        //    52: aload_0        
        //    53: getfield        com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
        //    56: ifnull          68
        //    59: aload_0        
        //    60: getfield        com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.mOnFinishListener:Lcom/uc/paymentsdk/network/chain/Handler$OnFinishListener;
        //    63: invokeinterface com/uc/paymentsdk/network/chain/Handler$OnFinishListener.onFinish:()V
        //    68: return         
        //    69: aload_3        
        //    70: invokestatic    com/uc/paymentsdk/network/XMLParser.parseSmsInfo:(Ljava/lang/String;)Lcom/uc/paymentsdk/payment/sms/SmsInfos;
        //    73: astore_3       
        //    74: aload_3        
        //    75: ifnonnull       97
        //    78: aconst_null    
        //    79: invokestatic    com/uc/paymentsdk/util/Utils.setSmsInfo:(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
        //    82: goto            26
        //    85: astore_3       
        //    86: iconst_0       
        //    87: putstatic       com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.sStatus:I
        //    90: aload_3        
        //    91: invokevirtual   java/io/IOException.printStackTrace:()V
        //    94: goto            26
        //    97: aload_3        
        //    98: getfield        com/uc/paymentsdk/payment/sms/SmsInfos.smsInfos:Ljava/util/ArrayList;
        //   101: iconst_0       
        //   102: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   105: checkcast       Lcom/uc/paymentsdk/payment/sms/SmsInfo;
        //   108: invokevirtual   com/uc/paymentsdk/payment/sms/SmsInfo.getSmsendtime:()Ljava/lang/String;
        //   111: iconst_1       
        //   112: invokestatic    com/uc/paymentsdk/util/Utils.getCurrentTime:(Z)Ljava/lang/String;
        //   115: ldc             "yyyy-MM-dd"
        //   117: invokestatic    com/uc/paymentsdk/util/Utils.dateDiffByDay:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
        //   120: iflt            142
        //   123: aconst_null    
        //   124: invokestatic    com/uc/paymentsdk/util/Utils.setSmsInfo:(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
        //   127: goto            26
        //   130: astore_3       
        //   131: iconst_0       
        //   132: putstatic       com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.sStatus:I
        //   135: aload_3        
        //   136: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   139: goto            26
        //   142: aload_3        
        //   143: invokestatic    com/uc/paymentsdk/util/Utils.setSmsInfo:(Lcom/uc/paymentsdk/payment/sms/SmsInfos;)V
        //   146: goto            26
        //   149: astore_3       
        //   150: aload           4
        //   152: monitorexit    
        //   153: aload_3        
        //   154: athrow         
        //   155: aload_0        
        //   156: invokevirtual   com/uc/paymentsdk/network/chain/SyncSmsInfoHandler.getSuccessor:()Lcom/uc/paymentsdk/network/chain/Handler;
        //   159: invokevirtual   com/uc/paymentsdk/network/chain/Handler.handleRequest:()V
        //   162: goto            68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  10     18     85     97     Ljava/io/IOException;
        //  10     18     130    142    Ljava/lang/Exception;
        //  22     26     85     97     Ljava/io/IOException;
        //  22     26     130    142    Ljava/lang/Exception;
        //  35     45     149    155    Any
        //  69     74     85     97     Ljava/io/IOException;
        //  69     74     130    142    Ljava/lang/Exception;
        //  78     82     85     97     Ljava/io/IOException;
        //  78     82     130    142    Ljava/lang/Exception;
        //  97     127    85     97     Ljava/io/IOException;
        //  97     127    130    142    Ljava/lang/Exception;
        //  142    146    85     97     Ljava/io/IOException;
        //  142    146    130    142    Ljava/lang/Exception;
        //  150    153    149    155    Any
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    public Object onPreHandle(final int n, final HttpResponse httpResponse) {
        final String bodyString = Utils.getBodyString(n, httpResponse);
        Object smsInfo;
        if (TextUtils.isEmpty((CharSequence)bodyString)) {
            smsInfo = null;
        }
        else {
            try {
                smsInfo = XMLParser.parseSmsInfo(bodyString);
                PrefUtil.setSmsInfo(this.mContext, bodyString);
            }
            catch (final Exception ex) {
                ex.printStackTrace();
                smsInfo = null;
            }
        }
        return smsInfo;
    }
    
    @Override
    public void onSuccess(final int n, final Object o) {
        while (true) {
            SyncSmsInfoHandler.sStatus = 2;
            Utils.setSmsInfo((SmsInfos)o);
            synchronized (this.LOCK) {
                this.LOCK.notifyAll();
                monitorexit(this.LOCK);
                if (this.getSuccessor() == null) {
                    if (this.mOnFinishListener != null) {
                        this.mOnFinishListener.onFinish();
                    }
                    return;
                }
            }
            this.getSuccessor().handleRequest();
        }
    }
}
