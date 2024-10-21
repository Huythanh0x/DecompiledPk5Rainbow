package com.uc.paymentsdk.network.chain.SyncPayChannelHandler;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import com.uc.paymentsdk.network.chain.Handler;
import android.content.Context;
import java.lang.Integer;
import com.uc.paymentsdk.network.chain.Handler$OnFinishListener;
import java.lang.Thread;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler$1;
import java.lang.Runnable;
import com.uc.paymentsdk.network.Api;
import java.lang.Object;
import org.apache.http.HttpResponse;
import java.lang.String;
import com.uc.paymentsdk.util.Utils;
import java.lang.CharSequence;
import android.text.TextUtils;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.util.PrefUtil;

public class SyncPayChannelHandler extends Handler implements ApiTask$TaskHandler	// class@0000ac from classes.dex
{
    private final Integer LOCK;
    private Handler$OnFinishListener mOnFinishListener;
    private static int sStatus;

    public void SyncPayChannelHandler(Context paramContext){
       super(paramContext);
       this.LOCK = Integer.valueOf(0);
    }
    public void SyncPayChannelHandler(Context paramContext,Handler$OnFinishListener paramOnFinishListener){
       super(paramContext);
       this.LOCK = Integer.valueOf(0);
       this.mOnFinishListener = paramOnFinishListener;
    }
    static Integer access$0(SyncPayChannelHandler p0){
       return p0.LOCK;
    }
    public static void init(){
       SyncPayChannelHandler.sStatus = 0;
    }
    public void handleRequest(){
       switch (SyncPayChannelHandler.sStatus){
           case 0:
             SyncPayChannelHandler.sStatus = 1;
             Api.syncPayChannel(this.mContext, this);
             break;
           case 1:
             new Thread(new SyncPayChannelHandler$1(this)).start();
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
       SyncPayChannelHandler.sStatus = 0;
       SyncPayChannelHandler tLOCK = this.LOCK;
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
       String strx;
       String str = Utils.getBodyString(paramInt, paramHttpResponse);
       if (TextUtils.isEmpty(str)) {
          strx = null;
       }else {
          try{
             strx = XMLParser.parsePayChannel(str);
          }catch(java.lang.Exception e1){
             strx = null;
          }
       }
       return strx;
    }
    public void onSuccess(int paramInt,Object paramObject){
       PrefUtil.syncPayChannels(this.mContext, paramObject);
       SyncPayChannelHandler.sStatus = 2;
       SyncPayChannelHandler tLOCK = this.LOCK;
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
