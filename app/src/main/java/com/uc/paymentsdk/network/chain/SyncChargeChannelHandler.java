package com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import com.uc.paymentsdk.network.chain.Handler;
import android.content.Context;
import java.lang.Integer;
import com.uc.paymentsdk.network.chain.Handler$OnFinishListener;
import java.lang.Thread;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler$1;
import java.lang.Runnable;
import com.uc.paymentsdk.network.Api;
import java.lang.Object;
import org.apache.http.HttpResponse;
import java.lang.String;
import com.uc.paymentsdk.util.Utils;
import java.lang.CharSequence;
import android.text.TextUtils;
import com.uc.paymentsdk.network.JSONParser;
import com.uc.paymentsdk.util.PrefUtil;

public class SyncChargeChannelHandler extends Handler implements ApiTask$TaskHandler	// class@0000a9 from classes.dex
{
    private final Integer LOCK;
    private Handler$OnFinishListener mOnFinishListener;
    private static int sStatus;

    public void SyncChargeChannelHandler(Context paramContext){
       super(paramContext);
       this.LOCK = Integer.valueOf(0);
    }
    public void SyncChargeChannelHandler(Context paramContext,Handler$OnFinishListener paramOnFinishListener){
       super(paramContext);
       this.LOCK = Integer.valueOf(0);
       this.mOnFinishListener = paramOnFinishListener;
    }
    static Integer access$0(SyncChargeChannelHandler p0){
       return p0.LOCK;
    }
    public static void init(){
       SyncChargeChannelHandler.sStatus = 0;
    }
    public void handleRequest(){
       switch (SyncChargeChannelHandler.sStatus){
           case 0:
             SyncChargeChannelHandler.sStatus = 1;
             Api.syncChargeChannel(this.mContext, this);
             break;
           case 1:
             new Thread(new SyncChargeChannelHandler$1(this)).start();
             break;
           case 2:
             if (this.getSuccessor() == null) {
                if (this.mOnFinishListener != null) {
                   this.mOnFinishListener.onFinish();
                }
             }else {
                this.getSuccessor().handleRequest();
             }
             break;
       }
       return;
    }
    public void onError(int paramInt1,int paramInt2){
       SyncChargeChannelHandler.sStatus = 0;
       SyncChargeChannelHandler tLOCK = this.LOCK;
       _monitor_enter(tLOCK);
       this.LOCK.notifyAll();
       _monitor_exit(tLOCK);
       if (this.getSuccessor() == null) {
          if (this.mOnFinishListener != null) {
             this.mOnFinishListener.onFinish();
          }
       }else {
          this.getSuccessor().handleRequest();
       }
       return;
    }
    public Object onPreHandle(int paramInt,HttpResponse paramHttpResponse){
       String[] stringArray;
       String str = Utils.getBodyString(paramInt, paramHttpResponse);
       if (TextUtils.isEmpty(str)) {
          stringArray = null;
       }else {
          try{
             stringArray = JSONParser.parseChargeChannel(str);
          }catch(org.json.JSONException e1){
             stringArray = null;
          }
       }
       return stringArray;
    }
    public void onSuccess(int paramInt,Object paramObject){
       PrefUtil.syncChargeChannels(this.mContext, paramObject);
       SyncChargeChannelHandler.sStatus = 2;
       SyncChargeChannelHandler tLOCK = this.LOCK;
       _monitor_enter(tLOCK);
       this.LOCK.notifyAll();
       _monitor_exit(tLOCK);
       if (this.getSuccessor() == null) {
          if (this.mOnFinishListener != null) {
             this.mOnFinishListener.onFinish();
          }
       }else {
          this.getSuccessor().handleRequest();
       }
       return;
    }
}
