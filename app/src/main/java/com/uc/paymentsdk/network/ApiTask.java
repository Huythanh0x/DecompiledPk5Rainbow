package com.uc.paymentsdk.network;

import org.apache.http.HttpResponse;
import android.app.Activity;
import java.util.HashMap;
import android.content.Context;
import android.os.AsyncTask;

public class ApiTask extends AsyncTask<Void, Void, Object>
{
    private static final String TAG = "pay";
    private String httpmethod;
    private AndroidHttpClient mClient;
    private Context mContext;
    private TaskHandler mHandler;
    private HashMap<String, Object> mParameter;
    private int mReuqestAction;
    
    ApiTask(final Context mContext, final int mReuqestAction, final TaskHandler mHandler, final HashMap<String, Object> mParameter, final String httpmethod) {
        super();
        this.mContext = mContext;
        this.mReuqestAction = mReuqestAction;
        this.mHandler = mHandler;
        this.mParameter = mParameter;
        this.mClient = HttpClientFactory.get().getSDKHttpClient(null);
        this.httpmethod = httpmethod;
    }
    
    protected /* bridge */ Object doInBackground(final Object[] array) {
        return this.doInBackground((Void[])array);
    }
    
    protected Object doInBackground(final Void[] p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0        
        //     4: getfield        com/uc/paymentsdk/network/ApiTask.mReuqestAction:I
        //     7: aaload         
        //     8: astore_1       
        //     9: aconst_null    
        //    10: astore          5
        //    12: aconst_null    
        //    13: astore          4
        //    15: aload_0        
        //    16: getfield        com/uc/paymentsdk/network/ApiTask.httpmethod:Ljava/lang/String;
        //    19: ldc             "post"
        //    21: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    24: ifeq            95
        //    27: new             Lorg/apache/http/client/methods/HttpPost;
        //    30: astore          5
        //    32: aload           5
        //    34: aload_1        
        //    35: invokespecial   org/apache/http/client/methods/HttpPost.<init>:(Ljava/lang/String;)V
        //    38: aload_0        
        //    39: getfield        com/uc/paymentsdk/network/ApiTask.mParameter:Ljava/util/HashMap;
        //    42: invokestatic    com/uc/paymentsdk/util/Utils.getQueryString:(Ljava/util/HashMap;)Ljava/lang/String;
        //    45: astore          6
        //    47: new             Lorg/apache/http/entity/ByteArrayEntity;
        //    50: astore_1       
        //    51: aload_1        
        //    52: aload           6
        //    54: ldc             "UTF-8"
        //    56: invokevirtual   java/lang/String.getBytes:(Ljava/lang/String;)[B
        //    59: invokespecial   org/apache/http/entity/ByteArrayEntity.<init>:([B)V
        //    62: aload           5
        //    64: aload_1        
        //    65: invokevirtual   org/apache/http/client/methods/HttpPost.setEntity:(Lorg/apache/http/HttpEntity;)V
        //    68: aload           5
        //    70: ldc             "Content-Type"
        //    72: ldc             "application/x-www-form-urlencoded"
        //    74: invokevirtual   org/apache/http/client/methods/HttpPost.addHeader:(Ljava/lang/String;Ljava/lang/String;)V
        //    77: aload_0        
        //    78: getfield        com/uc/paymentsdk/network/ApiTask.mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;
        //    81: aload           5
        //    83: invokevirtual   com/uc/paymentsdk/network/AndroidHttpClient.execute:(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //    86: astore_1       
        //    87: aload_1        
        //    88: ifnonnull       200
        //    91: aconst_null    
        //    92: astore_1       
        //    93: aload_1        
        //    94: areturn        
        //    95: aload_0        
        //    96: getfield        com/uc/paymentsdk/network/ApiTask.mParameter:Ljava/util/HashMap;
        //    99: invokestatic    com/uc/paymentsdk/util/Utils.getQueryString:(Ljava/util/HashMap;)Ljava/lang/String;
        //   102: astore          6
        //   104: new             Lorg/apache/http/client/methods/HttpGet;
        //   107: astore          4
        //   109: aload_1        
        //   110: ldc             "?"
        //   112: invokevirtual   java/lang/String.indexOf:(Ljava/lang/String;)I
        //   115: ifle            167
        //   118: new             Ljava/lang/StringBuilder;
        //   121: astore          7
        //   123: aload           7
        //   125: aload_1        
        //   126: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   129: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   132: aload           7
        //   134: ldc             "&"
        //   136: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: aload           6
        //   141: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   144: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   147: astore_1       
        //   148: aload           4
        //   150: aload_1        
        //   151: invokespecial   org/apache/http/client/methods/HttpGet.<init>:(Ljava/lang/String;)V
        //   154: aload_0        
        //   155: getfield        com/uc/paymentsdk/network/ApiTask.mClient:Lcom/uc/paymentsdk/network/AndroidHttpClient;
        //   158: aload           4
        //   160: invokevirtual   com/uc/paymentsdk/network/AndroidHttpClient.execute:(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
        //   163: astore_1       
        //   164: goto            87
        //   167: new             Ljava/lang/StringBuilder;
        //   170: astore          7
        //   172: aload           7
        //   174: aload_1        
        //   175: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   178: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   181: aload           7
        //   183: ldc             "?"
        //   185: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: aload           6
        //   190: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   193: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   196: astore_1       
        //   197: goto            148
        //   200: aload_1        
        //   201: invokeinterface org/apache/http/HttpResponse.getStatusLine:()Lorg/apache/http/StatusLine;
        //   206: invokeinterface org/apache/http/StatusLine.getStatusCode:()I
        //   211: istore_2       
        //   212: sipush          200
        //   215: iload_2        
        //   216: if_icmpeq       227
        //   219: iload_2        
        //   220: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   223: astore_1       
        //   224: goto            93
        //   227: aload_0        
        //   228: getfield        com/uc/paymentsdk/network/ApiTask.mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
        //   231: ifnull          378
        //   234: aload_0        
        //   235: getfield        com/uc/paymentsdk/network/ApiTask.mContext:Landroid/content/Context;
        //   238: instanceof      Landroid/app/Activity;
        //   241: ifeq            309
        //   244: aload_0        
        //   245: getfield        com/uc/paymentsdk/network/ApiTask.mContext:Landroid/content/Context;
        //   248: checkcast       Landroid/app/Activity;
        //   251: invokevirtual   android/app/Activity.isFinishing:()Z
        //   254: istore_3       
        //   255: iload_3        
        //   256: ifeq            309
        //   259: aload           5
        //   261: ifnull          287
        //   264: aload           5
        //   266: invokevirtual   org/apache/http/client/methods/HttpPost.abort:()V
        //   269: aload_1        
        //   270: ifnull          284
        //   273: aload_1        
        //   274: invokeinterface org/apache/http/HttpResponse.getEntity:()Lorg/apache/http/HttpEntity;
        //   279: invokeinterface org/apache/http/HttpEntity.consumeContent:()V
        //   284: goto            93
        //   287: aload           4
        //   289: ifnull          269
        //   292: aload           4
        //   294: invokevirtual   org/apache/http/client/methods/HttpGet.abort:()V
        //   297: goto            269
        //   300: astore_1       
        //   301: iconst_m1      
        //   302: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   305: astore_1       
        //   306: goto            93
        //   309: aload_0        
        //   310: getfield        com/uc/paymentsdk/network/ApiTask.mHandler:Lcom/uc/paymentsdk/network/ApiTask$TaskHandler;
        //   313: aload_0        
        //   314: getfield        com/uc/paymentsdk/network/ApiTask.mReuqestAction:I
        //   317: aload_1        
        //   318: invokeinterface com/uc/paymentsdk/network/ApiTask$TaskHandler.onPreHandle:(ILorg/apache/http/HttpResponse;)Ljava/lang/Object;
        //   323: astore          6
        //   325: aload           5
        //   327: ifnull          356
        //   330: aload           5
        //   332: invokevirtual   org/apache/http/client/methods/HttpPost.abort:()V
        //   335: aload_1        
        //   336: ifnull          350
        //   339: aload_1        
        //   340: invokeinterface org/apache/http/HttpResponse.getEntity:()Lorg/apache/http/HttpEntity;
        //   345: invokeinterface org/apache/http/HttpEntity.consumeContent:()V
        //   350: aload           6
        //   352: astore_1       
        //   353: goto            93
        //   356: aload           4
        //   358: ifnull          335
        //   361: aload           4
        //   363: invokevirtual   org/apache/http/client/methods/HttpGet.abort:()V
        //   366: goto            335
        //   369: astore_1       
        //   370: iconst_m1      
        //   371: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   374: astore_1       
        //   375: goto            93
        //   378: aload           5
        //   380: ifnull          406
        //   383: aload           5
        //   385: invokevirtual   org/apache/http/client/methods/HttpPost.abort:()V
        //   388: aload_1        
        //   389: ifnull          403
        //   392: aload_1        
        //   393: invokeinterface org/apache/http/HttpResponse.getEntity:()Lorg/apache/http/HttpEntity;
        //   398: invokeinterface org/apache/http/HttpEntity.consumeContent:()V
        //   403: goto            93
        //   406: aload           4
        //   408: ifnull          388
        //   411: aload           4
        //   413: invokevirtual   org/apache/http/client/methods/HttpGet.abort:()V
        //   416: goto            388
        //   419: astore_1       
        //   420: iconst_m1      
        //   421: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   424: astore_1       
        //   425: goto            93
        //   428: astore          6
        //   430: aload           5
        //   432: ifnull          472
        //   435: aload           5
        //   437: invokevirtual   org/apache/http/client/methods/HttpPost.abort:()V
        //   440: aload_1        
        //   441: ifnull          455
        //   444: aload_1        
        //   445: invokeinterface org/apache/http/HttpResponse.getEntity:()Lorg/apache/http/HttpEntity;
        //   450: invokeinterface org/apache/http/HttpEntity.consumeContent:()V
        //   455: aload           6
        //   457: athrow         
        //   458: astore_1       
        //   459: aload_1        
        //   460: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   463: bipush          -3
        //   465: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   468: astore_1       
        //   469: goto            93
        //   472: aload           4
        //   474: ifnull          440
        //   477: aload           4
        //   479: invokevirtual   org/apache/http/client/methods/HttpGet.abort:()V
        //   482: goto            440
        //   485: astore_1       
        //   486: goto            68
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                      
        //  -----  -----  -----  -----  ------------------------------------------
        //  0      9      300    309    Ljava/net/ConnectException;
        //  0      9      369    378    Ljava/net/SocketTimeoutException;
        //  0      9      419    428    Ljava/net/SocketException;
        //  0      9      458    472    Ljava/lang/Exception;
        //  15     47     300    309    Ljava/net/ConnectException;
        //  15     47     369    378    Ljava/net/SocketTimeoutException;
        //  15     47     419    428    Ljava/net/SocketException;
        //  15     47     458    472    Ljava/lang/Exception;
        //  47     68     485    489    Ljava/lang/ArrayIndexOutOfBoundsException;
        //  47     68     300    309    Ljava/net/ConnectException;
        //  47     68     369    378    Ljava/net/SocketTimeoutException;
        //  47     68     419    428    Ljava/net/SocketException;
        //  47     68     458    472    Ljava/lang/Exception;
        //  68     87     300    309    Ljava/net/ConnectException;
        //  68     87     369    378    Ljava/net/SocketTimeoutException;
        //  68     87     419    428    Ljava/net/SocketException;
        //  68     87     458    472    Ljava/lang/Exception;
        //  95     148    300    309    Ljava/net/ConnectException;
        //  95     148    369    378    Ljava/net/SocketTimeoutException;
        //  95     148    419    428    Ljava/net/SocketException;
        //  95     148    458    472    Ljava/lang/Exception;
        //  148    164    300    309    Ljava/net/ConnectException;
        //  148    164    369    378    Ljava/net/SocketTimeoutException;
        //  148    164    419    428    Ljava/net/SocketException;
        //  148    164    458    472    Ljava/lang/Exception;
        //  167    197    300    309    Ljava/net/ConnectException;
        //  167    197    369    378    Ljava/net/SocketTimeoutException;
        //  167    197    419    428    Ljava/net/SocketException;
        //  167    197    458    472    Ljava/lang/Exception;
        //  200    212    300    309    Ljava/net/ConnectException;
        //  200    212    369    378    Ljava/net/SocketTimeoutException;
        //  200    212    419    428    Ljava/net/SocketException;
        //  200    212    458    472    Ljava/lang/Exception;
        //  227    255    428    485    Any
        //  264    269    300    309    Ljava/net/ConnectException;
        //  264    269    369    378    Ljava/net/SocketTimeoutException;
        //  264    269    419    428    Ljava/net/SocketException;
        //  264    269    458    472    Ljava/lang/Exception;
        //  273    284    300    309    Ljava/net/ConnectException;
        //  273    284    369    378    Ljava/net/SocketTimeoutException;
        //  273    284    419    428    Ljava/net/SocketException;
        //  273    284    458    472    Ljava/lang/Exception;
        //  292    297    300    309    Ljava/net/ConnectException;
        //  292    297    369    378    Ljava/net/SocketTimeoutException;
        //  292    297    419    428    Ljava/net/SocketException;
        //  292    297    458    472    Ljava/lang/Exception;
        //  309    325    428    485    Any
        //  330    335    300    309    Ljava/net/ConnectException;
        //  330    335    369    378    Ljava/net/SocketTimeoutException;
        //  330    335    419    428    Ljava/net/SocketException;
        //  330    335    458    472    Ljava/lang/Exception;
        //  339    350    300    309    Ljava/net/ConnectException;
        //  339    350    369    378    Ljava/net/SocketTimeoutException;
        //  339    350    419    428    Ljava/net/SocketException;
        //  339    350    458    472    Ljava/lang/Exception;
        //  361    366    300    309    Ljava/net/ConnectException;
        //  361    366    369    378    Ljava/net/SocketTimeoutException;
        //  361    366    419    428    Ljava/net/SocketException;
        //  361    366    458    472    Ljava/lang/Exception;
        //  383    388    300    309    Ljava/net/ConnectException;
        //  383    388    369    378    Ljava/net/SocketTimeoutException;
        //  383    388    419    428    Ljava/net/SocketException;
        //  383    388    458    472    Ljava/lang/Exception;
        //  392    403    300    309    Ljava/net/ConnectException;
        //  392    403    369    378    Ljava/net/SocketTimeoutException;
        //  392    403    419    428    Ljava/net/SocketException;
        //  392    403    458    472    Ljava/lang/Exception;
        //  411    416    300    309    Ljava/net/ConnectException;
        //  411    416    369    378    Ljava/net/SocketTimeoutException;
        //  411    416    419    428    Ljava/net/SocketException;
        //  411    416    458    472    Ljava/lang/Exception;
        //  435    440    300    309    Ljava/net/ConnectException;
        //  435    440    369    378    Ljava/net/SocketTimeoutException;
        //  435    440    419    428    Ljava/net/SocketException;
        //  435    440    458    472    Ljava/lang/Exception;
        //  444    455    300    309    Ljava/net/ConnectException;
        //  444    455    369    378    Ljava/net/SocketTimeoutException;
        //  444    455    419    428    Ljava/net/SocketException;
        //  444    455    458    472    Ljava/lang/Exception;
        //  455    458    300    309    Ljava/net/ConnectException;
        //  455    458    369    378    Ljava/net/SocketTimeoutException;
        //  455    458    419    428    Ljava/net/SocketException;
        //  455    458    458    472    Ljava/lang/Exception;
        //  477    482    300    309    Ljava/net/ConnectException;
        //  477    482    369    378    Ljava/net/SocketTimeoutException;
        //  477    482    419    428    Ljava/net/SocketException;
        //  477    482    458    472    Ljava/lang/Exception;
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    protected void onPostExecute(final Object o) {
        if (this.mHandler != null && (!(this.mContext instanceof Activity) || !((Activity)this.mContext).isFinishing())) {
            if (o == null) {
                this.mHandler.onError(this.mReuqestAction, 500);
            }
            else if (o instanceof Integer) {
                this.mHandler.onError(this.mReuqestAction, (int)o);
            }
            else {
                this.mHandler.onSuccess(this.mReuqestAction, o);
            }
        }
    }
    
    public interface TaskHandler
    {
        void onError(final int p0, final int p1);
        
        Object onPreHandle(final int p0, final HttpResponse p1);
        
        void onSuccess(final int p0, final Object p1);
    }
}
