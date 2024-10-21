package com.uc.paymentsdk.network.chain.SyncPayChannelHandler$1$1;
import java.lang.Runnable;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler$1;
import java.lang.Object;
import com.uc.paymentsdk.network.chain.SyncPayChannelHandler;

class SyncPayChannelHandler$1$1 implements Runnable	// class@0000aa from classes.dex
{
    final SyncPayChannelHandler$1 this$1;

    void SyncPayChannelHandler$1$1(SyncPayChannelHandler$1 p0){
       this.this$1 = p0;
       super();
    }
    public void run(){
       SyncPayChannelHandler$1.access$0(this.this$1).handleRequest();
    }
}
