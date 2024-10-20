package com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;
import com.uc.paymentsdk.network.ApiTask$TaskHandler;
import com.uc.paymentsdk.network.chain.Handler;
import android.content.Context;
import java.lang.Integer;
import com.uc.paymentsdk.network.chain.Handler$OnFinishListener;
import java.lang.Thread;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler$1;
import java.lang.Runnable;
import com.uc.paymentsdk.payment.PaymentInfo;
import com.uc.paymentsdk.util.Utils;
import java.lang.String;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.payment.sms.SmsInfos;
import com.uc.paymentsdk.util.PrefUtil;
import java.lang.Object;
import com.uc.paymentsdk.network.XMLParser;
import java.io.IOException;
import java.util.ArrayList;
import com.uc.paymentsdk.payment.sms.SmsInfo;
import java.lang.Exception;
import org.apache.http.HttpResponse;
import java.lang.CharSequence;
import android.text.TextUtils;

public class SyncSmsInfoHandler extends Handler implements ApiTask$TaskHandler	// class@0000af from classes.dex
{
    private final Integer LOCK;
    private Handler$OnFinishListener mOnFinishListener;
    private static int sStatus;

    public void SyncSmsInfoHandler(Context paramContext){
       super(paramContext);
       this.LOCK = Integer.valueOf(0);
    }
    public void SyncSmsInfoHandler(Context paramContext,Handler$OnFinishListener paramOnFinishListener){
       super(paramContext);
       this.LOCK = Integer.valueOf(0);
       this.mOnFinishListener = paramOnFinishListener;
    }
    static Integer access$0(SyncSmsInfoHandler p0){
       return p0.LOCK;
    }
    public static void init(){
       SyncSmsInfoHandler.sStatus = 0;
    }
    public void handleRequest(){
       switch (SyncSmsInfoHandler.sStatus){
           case 0:
             SyncSmsInfoHandler.sStatus = 1;
             Api.syncSmsInfo(this.mContext, this, Utils.getPaymentInfo().getCpID(), Utils.getPaymentInfo().getmGameID());
             break;
           case 1:
             new Thread(new SyncSmsInfoHandler$1(this)).start();
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
       String str;
       SmsInfos localSmsInfos;
       try{
          SyncSmsInfoHandler.sStatus = 2;
          if (Utils.getSmsInfos() == null) {
             if ((str = PrefUtil.getSmsInfo(this.mContext)) == null) {
                Utils.setSmsInfo(null);
             }else if((localSmsInfos = XMLParser.parseSmsInfo(str)) == null){
                Utils.setSmsInfo(null);
             }else if(Utils.dateDiffByDay(localSmsInfos.smsInfos.get(0).getSmsendtime(), Utils.getCurrentTime(true), "yyyy-MM-dd") >= 0){
                Utils.setSmsInfo(null);
             }else {
                try{
                   Utils.setSmsInfo(localSmsInfos);
                }catch( e0){
                }
             }
          }
       }catch(java.io.IOException e4){
          IOException localIOException = e4;
          SyncSmsInfoHandler.sStatus = 0;
          localIOException.printStackTrace();
       }catch(java.lang.Exception e4){
          Exception localException = e4;
          SyncSmsInfoHandler.sStatus = 0;
          localException.printStackTrace();
       }
       SyncSmsInfoHandler tLOCK = this.LOCK;
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
       SmsInfos smsInfos;
       String str = Utils.getBodyString(paramInt, paramHttpResponse);
       if (TextUtils.isEmpty(str)) {
          smsInfos = null;
       }else {
          try{
             SmsInfos localSmsInfos = XMLParser.parseSmsInfo(str);
             PrefUtil.setSmsInfo(this.mContext, str);
             smsInfos = localSmsInfos;
          }catch(java.lang.Exception e0){
             e0.printStackTrace();
             smsInfos = null;
          }
       }
       return smsInfos;
    }
    public void onSuccess(int paramInt,Object paramObject){
       SyncSmsInfoHandler.sStatus = 2;
       Utils.setSmsInfo(paramObject);
       SyncSmsInfoHandler tLOCK = this.LOCK;
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
