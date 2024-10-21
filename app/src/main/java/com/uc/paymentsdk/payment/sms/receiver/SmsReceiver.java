package com.uc.paymentsdk.payment.sms.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
  public void onReceive(Context paramContext, Intent paramIntent) {
    Bundle bundle = paramIntent.getExtras();
    if (bundle != null) {
      Object[] arrayOfObject = (Object[])bundle.get("pdus");
      byte b = 0;
      while (true) {
        if (b < arrayOfObject.length) {
          String str = SmsMessage.createFromPdu((byte[])arrayOfObject[b]).getOriginatingAddress();
          Log.i("pay", "receiver number:" + str);
          abortBroadcast();
          b++;
          continue;
        } 
        return;
      } 
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/com/uc/paymentsdk/payment/sms/receiver/SmsReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */