package com.uc.paymentsdk.network.chain.SyncChargeChannelHandler$1$1;
import java.lang.Runnable;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler$1;
import java.lang.Object;
import com.uc.paymentsdk.network.chain.SyncChargeChannelHandler;

class SyncChargeChannelHandler$1$1 implements Runnable	// class@0000a7 from classes.dex
{
    final SyncChargeChannelHandler$1 this$1;

    void SyncChargeChannelHandler$1$1(SyncChargeChannelHandler$1 p0){
       this.this$1 = p0;
       super();
    }
    public void run(){
       SyncChargeChannelHandler$1.access$0(this.this$1).handleRequest();
    }
}
