package com.uc.paymentsdk.network.chain;

class SyncChargeChannelHandler$1 implements Runnable {
   final SyncChargeChannelHandler this$0;

   SyncChargeChannelHandler$1(SyncChargeChannelHandler var1) {
      super();
      this.this$0 = var1;
   }

   // $FF: synthetic method
   static SyncChargeChannelHandler access$0(SyncChargeChannelHandler$1 var0) {
      return var0.this$0;
   }

   public void run() {
      Integer var1 = SyncChargeChannelHandler.access$0(this.this$0);
      synchronized(var1){}

      label205: {
         Throwable var10000;
         boolean var10001;
         label200: {
            label206: {
               InterruptedException var2;
               try {
                  try {
                     SyncChargeChannelHandler.access$0(this.this$0).wait();
                     break label206;
                  } catch (InterruptedException var26) {
                     var2 = var26;
                  }
               } catch (Throwable var27) {
                  var10000 = var27;
                  var10001 = false;
                  break label200;
               }

               try {
                  var2.printStackTrace();
               } catch (Throwable var25) {
                  var10000 = var25;
                  var10001 = false;
                  break label200;
               }
            }

            label191:
            try {
               break label205;
            } catch (Throwable var24) {
               var10000 = var24;
               var10001 = false;
               break label191;
            }
         }

         while(true) {
            Throwable var28 = var10000;

            try {
               throw var28;
            } catch (Throwable var23) {
               var10000 = var23;
               var10001 = false;
               continue;
            }
         }
      }

      this.this$0.mHandler.post(new SyncChargeChannelHandler$1$1(this));
   }
}
