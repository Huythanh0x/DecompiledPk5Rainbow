package com.uc.paymentsdk.network.chain;

import android.content.Context;

public abstract class Handler {
  protected static final int STATUS_SYNCED = 2;
  
  protected static final int STATUS_SYNCING = 1;
  
  protected static final int STATUS_UNSYNC = 0;
  
  protected Context mContext;
  
  protected android.os.Handler mHandler;
  
  private Handler mSuccessor;
  
  public Handler(Context paramContext) {
    this.mContext = paramContext;
    this.mHandler = new android.os.Handler();
  }
  
  public Handler getSuccessor() {
    return this.mSuccessor;
  }
  
  public abstract void handleRequest();
  
  public Handler setSuccessor(Handler paramHandler) {
    this.mSuccessor = paramHandler;
    return this;
  }
  
  public static interface OnFinishListener {
    void onFinish();
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/network/chain/Handler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */