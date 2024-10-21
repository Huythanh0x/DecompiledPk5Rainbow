package com.uc.paymentsdk.network.chain.SyncChargeChannelHandler$1;
import java.lang.Runnable;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;
import java.lang.Object;
import java.lang.Integer;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler$1$1;
import android.os.Handler;
import java.lang.InterruptedException;

class SyncChargeChannelHandler$1 implements Runnable	// class@0000a8 from classes.dex
{
    final SyncChargeChannelHandler this$0;

    void SyncChargeChannelHandler$1(SyncChargeChannelHandler p0){
       this.this$0 = p0;
       super();
    }
    static SyncChargeChannelHandler access$0(SyncChargeChannelHandler$1 p0){
       return p0.this$0;
    }
    public void run(){
       Integer integer = SyncChargeChannelHandler.access$0(this.this$0);
       try{
          _monitor_enter(integer);
          SyncChargeChannelHandler.access$0(this.this$0).wait();
       }catch(java.lang.InterruptedException e2){
          InterruptedException localInterruptedException = e2;
          localInterruptedException.printStackTrace();
       }
       _monitor_exit(integer);
       this.this$0.mHandler.post(new SyncChargeChannelHandler$1$1(this));
       return;
    }
}
