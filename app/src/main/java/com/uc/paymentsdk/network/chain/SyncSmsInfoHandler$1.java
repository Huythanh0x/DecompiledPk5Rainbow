package com.uc.paymentsdk.network.chain.SyncSmsInfoHandler$1;
import java.lang.Runnable;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler;
import java.lang.Object;
import java.lang.Integer;
import com.uc.paymentsdk.network.chain.SyncSmsInfoHandler$1$1;
import android.os.Handler;
import java.lang.InterruptedException;

class SyncSmsInfoHandler$1 implements Runnable	// class@0000ae from classes.dex
{
    final SyncSmsInfoHandler this$0;

    void SyncSmsInfoHandler$1(SyncSmsInfoHandler p0){
       this.this$0 = p0;
       super();
    }
    static SyncSmsInfoHandler access$0(SyncSmsInfoHandler$1 p0){
       return p0.this$0;
    }
    public void run(){
       Integer integer = SyncSmsInfoHandler.access$0(this.this$0);
       try{
          _monitor_enter(integer);
          SyncSmsInfoHandler.access$0(this.this$0).wait();
       }catch(java.lang.InterruptedException e2){
          InterruptedException localInterruptedException = e2;
          localInterruptedException.printStackTrace();
       }
       _monitor_exit(integer);
       this.this$0.mHandler.post(new SyncSmsInfoHandler$1$1(this));
       return;
    }
}
