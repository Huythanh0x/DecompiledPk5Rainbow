package com.uc.paymentsdk.network.chain.SyncPayChannelHandler$1;
import java.lang.Runnable;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;
import java.lang.Object;
import java.lang.Integer;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler$1$1;
import android.os.Handler;
import java.lang.InterruptedException;

class SyncPayChannelHandler$1 implements Runnable	// class@0000ab from classes.dex
{
    final SyncPayChannelHandler this$0;

    void SyncPayChannelHandler$1(SyncPayChannelHandler p0){
       this.this$0 = p0;
       super();
    }
    static SyncPayChannelHandler access$0(SyncPayChannelHandler$1 p0){
       return p0.this$0;
    }
    public void run(){
       Integer integer = SyncPayChannelHandler.access$0(this.this$0);
       try{
          _monitor_enter(integer);
          SyncPayChannelHandler.access$0(this.this$0).wait();
       }catch(java.lang.InterruptedException e2){
          InterruptedException localInterruptedException = e2;
          localInterruptedException.printStackTrace();
       }
       _monitor_exit(integer);
       this.this$0.mHandler.post(new SyncPayChannelHandler$1$1(this));
       return;
    }
}
