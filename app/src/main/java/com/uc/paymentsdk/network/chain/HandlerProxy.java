package com.uc.paymentsdk.network.chain;

import android.content.Context;

public class HandlerProxy extends Handler {
  private Handler handler;
  
  public HandlerProxy(Context paramContext) {
    super(paramContext);
    this.handler = new SyncSmsInfoHandler(paramContext);
  }
  
  public HandlerProxy(Context paramContext, Handler.OnFinishListener paramOnFinishListener) {
    super(paramContext);
    this.handler = new SyncSmsInfoHandler(paramContext, paramOnFinishListener);
  }
  
  public void handleRequest() {
    this.handler.handleRequest();
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/chain/HandlerProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */