package com.uc.paymentsdk.network.chain.SyncSmsInfoHandler$1$1;
import java.lang.Runnable;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler$1;
import java.lang.Object;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;

class SyncSmsInfoHandler$1$1 implements Runnable	// class@0000ad from classes.dex
{
    final SyncSmsInfoHandler$1 this$1;

    void SyncSmsInfoHandler$1$1(SyncSmsInfoHandler$1 p0){
       this.this$1 = p0;
       super();
    }
    public void run(){
       SyncSmsInfoHandler$1.access$0(this.this$1).handleRequest();
    }
}
