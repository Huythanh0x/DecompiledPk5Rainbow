package com.uc.paymentsdk.network.chain;

import android.content.Context;
import android.text.TextUtils;
import com.uc.paymentsdk.network.Api;
import com.uc.paymentsdk.network.ApiTask;
import com.uc.paymentsdk.network.XMLParser;
import com.uc.paymentsdk.util.PrefUtil;
import com.uc.paymentsdk.util.Utils;
import org.apache.http.HttpResponse;

public class SyncPayChannelHandler extends Handler implements ApiTask.TaskHandler {
  private static int sStatus;
  
  private final Integer LOCK = Integer.valueOf(0);
  
  private Handler.OnFinishListener mOnFinishListener;
  
  public SyncPayChannelHandler(Context paramContext) {
    super(paramContext);
  }
  
  public SyncPayChannelHandler(Context paramContext, Handler.OnFinishListener paramOnFinishListener) {
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
      case 2:
        if (getSuccessor() == null)
          if (this.mOnFinishListener != null)
            this.mOnFinishListener.onFinish();  
        getSuccessor().handleRequest();
      case 1:
        (new Thread(new Runnable() {
              final SyncPayChannelHandler this$0;
              
              public void run() {
                synchronized (SyncPayChannelHandler.this.LOCK) {
                  SyncPayChannelHandler.this.LOCK.wait();
                  SyncPayChannelHandler.this.mHandler.post(new Runnable() {
                        final SyncPayChannelHandler.null this$1;
                        
                        public void run() {
                          SyncPayChannelHandler.null.access$0(SyncPayChannelHandler.null.this).handleRequest();
                        }
                      });
                  return;
                } 
              }
            })).start();
      case 0:
        break;
    } 
    sStatus = 1;
    Api.syncPayChannel(this.mContext, this);
  }
  
  public void onError(int paramInt1, int paramInt2) {
    sStatus = 0;
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
  
  public Object onPreHandle(int paramInt, HttpResponse paramHttpResponse) {
    String str = Utils.getBodyString(paramInt, paramHttpResponse);
    if (TextUtils.isEmpty(str))
      return null; 
    try {
      str = XMLParser.parsePayChannel(str);
    } catch (Exception exception) {
      exception = null;
    } 
    return exception;
  }
  
  public void onSuccess(int paramInt, Object paramObject) {
    PrefUtil.syncPayChannels(this.mContext, (String)paramObject);
    sStatus = 2;
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


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/chain/SyncPayChannelHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */